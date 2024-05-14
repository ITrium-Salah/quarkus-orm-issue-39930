package fr.itriumconseil;

import io.quarkus.hibernate.orm.runtime.dev.HibernateOrmDevController;
import io.quarkus.hibernate.orm.runtime.dev.HibernateOrmDevInfo;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;

@Path("/test")
public class Resource {

    @GET
    public String update()
    {
        for (HibernateOrmDevInfo.PersistenceUnit persistenceUnit : HibernateOrmDevController.get().getInfo().getPersistenceUnits()) {
            String createDDL = persistenceUnit.getUpdateDDL();
            return createDDL;
        }
        return "";
    }


    @GET
    @Path("transaction")
    @WithTransaction
    public Uni<String> updateTransaction()
    {
        for (HibernateOrmDevInfo.PersistenceUnit persistenceUnit : HibernateOrmDevController.get().getInfo().getPersistenceUnits()) {
            String createDDL = persistenceUnit.getUpdateDDL();
            return Uni.createFrom().item(createDDL);
        }
        return Uni.createFrom().failure(new NotFoundException());
    }


}
