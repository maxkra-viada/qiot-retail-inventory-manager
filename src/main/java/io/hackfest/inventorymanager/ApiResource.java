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
import javax.persistence.EntityManager;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.hackfest.inventorymanager.models.ProductEntity;

@Path("/api")
public class ApiResource {
	public ApiResource() {}

	private Logger LOGGER = LoggerFactory.getLogger(ApiResource.class);

	@Inject
	private EntityManager em;

	@GET
	@Path("/product/all")
	public List<ProductEntity> all() {
		return em.createNamedQuery(ProductEntity.NQ_FIND_ALL, ProductEntity.class)
				.getResultList();
	}

	class CreateProductRequest {
		String title;
		float priceInCents;
	}

	@POST
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductEntity createProduct(CreateProductRequest req) {
		LOGGER.info("creating product: " + req.title);

		ProductEntity product = new ProductEntity();
		product.title = req.title;
		product.priceInCents = req.priceInCents;
		product.uuid = UUID.randomUUID().toString();

		em.persist(product);

		return product;
	}

	@GET
	@Path("/product")
	@QueryParam("title")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductEntity getProductByTitle(String title) {
		LOGGER.info("fetching product: " + title);

		return em.createNamedQuery(ProductEntity.NQ_FIND_BY_TITLE, ProductEntity.class)
				.setParameter("title", title)
				.getSingleResult();
	}

	@DELETE
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductEntity deleteProductByTitle(String uuid) {
		ProductEntity product = em.find(ProductEntity.class, uuid);

		LOGGER.info("deleting product: " + product.title);

		em.remove(product);

		return product;
	}
}
