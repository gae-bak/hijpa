package com.example.hijpa.jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "Orders")
public class Order {

	@Id @GeneratedValue
	private Long id;
	private int orderAmount;

	@Embedded
	private Address address;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
