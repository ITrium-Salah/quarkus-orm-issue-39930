package fr.itriumconseil;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

@jakarta.persistence.Entity
public class Entity extends PanacheEntity {
    public String column1;
    public String column2;
    public String column3;
}
