package br.com.evertonhulek.projectvehicle.rentVehicle;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
 

@Data()
@Entity(name = "rentVehicle")
public class RentVehicleModel {

    /**
     * ID
     * usuário (id do usuario )
     * veiculo alugado
     * Data de Início
     * Data de Término
     * tipo de locação 
     * 
     */

    @Id 
    @GeneratedValue ( strategy =  GenerationType.IDENTITY)
    private int id;
    
    private int userId;
    private int vehicleId;

    @CreationTimestamp 
    private LocalDateTime startAt;

    @CreationTimestamp 
    private LocalDateTime endAt;
    
    @Column ( length = 50)
    private String rentalType;

    @Enumerated( EnumType.STRING)
    private  RentalStatus rentalStatus; // rented  | available

    @CreationTimestamp 
    @Column ( nullable = false, updatable = false, columnDefinition = " TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;
    
}
