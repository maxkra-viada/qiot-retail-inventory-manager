package io.hackfest.inventorymanager;

import io.hackfest.inventorymanager.models.ProductEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DatabaseTableProducts implements PanacheRepositoryBase<ProductEntity, UUID> {

}
