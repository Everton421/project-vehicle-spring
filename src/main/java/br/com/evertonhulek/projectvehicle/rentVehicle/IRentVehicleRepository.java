package br.com.evertonhulek.projectvehicle.rentVehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentVehicleRepository  extends JpaRepository<RentVehicleModel, Integer> {
    RentVehicleModel findByVehicleId(int id);
    

}
