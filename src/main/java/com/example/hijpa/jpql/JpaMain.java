package com.example.hijpa.jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			Member member = new Member();
			member.setAge(10);
			member.setUsername("박웅서");
			em.persist(member);

/*			//반환 타입이 명확할때
			TypedQuery<Member> query1 = em.createQuery("select m from Member m where m.age < 10", Member.class);
			List<Member> resultList = query1.getResultList();
			TypedQuery<String> query2 = em.createQuery("select m.username from Member m ", String.class);
			//반환 타입이 명확하지 않을때
			Query query3 = em.createQuery("select m.age from Member m");*/

			em.flush();
			em.clear();

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
