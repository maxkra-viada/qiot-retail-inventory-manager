package io.hackfest.inventorymanager;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import io.hackfest.inventorymanager.dbmodel.DbProduct;

@ApplicationScoped
public class DatabaseTableProducts implements PanacheRepositoryBase<DbProduct, UUID> {

}
