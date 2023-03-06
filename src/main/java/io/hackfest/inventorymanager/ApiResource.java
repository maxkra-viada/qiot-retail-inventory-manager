package io.hackfest.inventorymanager;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import javax.inject.Inject;

import java.util.List;
import java.util.Vector;

import io.hackfest.inventorymanager.dbmodel.DbProduct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api")
public class ApiResource {
	public ApiResource() {}

	private Logger LOGGER = LoggerFactory.getLogger(ApiResource.class);

	@GET
	@Path("/all")
	public List<DbProduct> all() {
		var ret = new Vector();

		return ret;
	}

	class CreateProductRequest {
		 String name;
		 float price;
	}

	class CreateProductResponse {
		boolean success;
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CreateProductResponse createProduct(CreateProductRequest req) {
		LOGGER.info("product: " + req.name);

		var ret = new CreateProductResponse();
		ret.success = false;
		return ret;
	}
}
