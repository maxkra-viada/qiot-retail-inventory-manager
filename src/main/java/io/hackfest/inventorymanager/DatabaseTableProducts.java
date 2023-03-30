package io.hackfest.inventorymanager;

import io.hackfest.inventorymanager.models.ProductEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DatabaseTableProducts implements PanacheRepositoryBase<ProductEntity, String> {
    public ProductEntity findByTitle(String title){
        return find("title", title).singleResult();
    }
}
