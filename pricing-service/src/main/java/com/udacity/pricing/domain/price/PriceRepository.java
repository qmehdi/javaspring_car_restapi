package com.udacity.pricing.domain.price;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

    /** This allows us to call this method via POST as follows
        http://localhost:8082/prices/search/retrieveByVehicleId?vehicleId=100
            But first, POST a price as follows:
                http://localhost:8082/prices
                 {
                     "currency": "USD",
                     "price": 22122.99,
                     "vehicleId": 100
                 }
     */
    @RestResource(path = "retrieveByVehicleId", rel = "customFindMethod")
    List<Price> findByVehicleId(@Param("vehicleId") Long vehicleId);
}
