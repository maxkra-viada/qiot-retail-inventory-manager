package io.hackfest.inventorymanager;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.hackfest.inventorymanager.models.ProductEntity;
import io.hackfest.inventorymanager.models.ProductRequest;

@Path("/api")
public class ApiResource {
	public ApiResource() {}

	private Logger LOGGER = LoggerFactory.getLogger(ApiResource.class);

	@Inject
	private DatabaseTableProducts productTable;

	@GET
	@Path("/product/all")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public List<ProductEntity> all() {
		return productTable.listAll();
	}

	@POST
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public ProductEntity createProduct(ProductRequest req) {
		LOGGER.info("creating product: " + req.title());

		ProductEntity product = new ProductEntity();
		product.title = req.title();
		product.priceInCents = req.priceInCents();
		product.quantity = req.quantity();
		product.uuid = UUID.randomUUID().toString();

		productTable.persist(product);

		return product;
	}

	@GET
	@Path("/product")
	@QueryParam("title")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductEntity getProductByTitle(String title) {
		LOGGER.info("fetching product: " + title);

		return productTable.findByTitle(title);
	}

	@DELETE
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public ProductEntity deleteProductByTitle(String uuid) {
		ProductEntity product = productTable.findById(uuid);

		LOGGER.info("deleting product: " + product.title);

		productTable.delete(product);

		return product;
	}
}
