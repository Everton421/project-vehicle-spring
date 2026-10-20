package br.com.evertonhulek.projectvehicle.vehicle;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping("/vehicles")
public class VehicleController {
    public List<VehicleModel> vehicles = new ArrayList<VehicleModel>();

     @GetMapping("/")
     public ResponseEntity<List<VehicleModel>> getVeicles(){
        return  ResponseEntity.ok(this.vehicles);
    }
    
    @PostMapping("/")
     public VehicleModel createVehicle(@RequestBody VehicleModel vehicle) {
            vehicles.add(vehicle);
          return vehicle;
    }
    


}
