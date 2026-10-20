package br.com.evertonhulek.projectvehicle.vehicle;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import br.com.evertonhulek.projectvehicle.rentVehicle.RentalStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data 
@Entity( name ="vehicles")
public class VehicleModel {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String plate;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;

    private String photos;
    
    @CreationTimestamp 
    @Column( nullable = false,  updatable=false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private LocalDateTime created_at;

     @Enumerated( EnumType.STRING)
    private  RentalStatus rentalStatus = RentalStatus.AVAILABLE ; // rented  | available
}
