package io.hackfest.inventorymanager.models;

public record ProductRequest (
    String title,
    int priceInCents,
    int quantity
){};
