package io.hackfest.inventorymanager.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity(name="Product")
@Table(name="products")
@NamedQuery(name = ProductEntity.NQ_FIND_BY_TITLE, query = "SELECT p from Product p WHERE p.title = :title")
public class ProductEntity {
	public static final String NQ_FIND_BY_TITLE = "ProductEntity.NQ_FIND_BY_TITLE";


	@Id
	public String uuid;

	@Column
	public String title;

	@Column
	public int priceInCents;

	@Column
	public int quantity;
}
