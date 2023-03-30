package io.hackfest.inventorymanager.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity(name="Product")
@Table(name="products")
public class ProductEntity {
	public static final String NQ_FIND_BY_TITLE_QUERY = "SELECT p from Product p WHERE p.title = :title";


	@Id
	public String uuid;

	@Column
	public String title;

	@Column
	public int priceInCents;

	@Column
	public int quantity;
}
