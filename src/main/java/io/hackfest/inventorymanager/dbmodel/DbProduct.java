package io.hackfest.inventorymanager.dbmodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class DbProduct {
	@Id
	public String uuid;

	@Column
	public String title;

	@Column
	public float cost;
}
