package br.com.evertonhulek.projectvehicle.rentVehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping("/rentals")
public class RentVehicleController {
    
   
   @Autowired 
   private IRentVehicleRepository rentVehicleRepository;   
   
   @GetMapping("/vehicle/:id")
    public ResponseEntity getRentByVehicleId(@RequestParam int id ) {
         var dataRent = this.rentVehicleRepository.findByVehicleId(id);
         return ResponseEntity.status(200).body(dataRent);
    }

    @PostMapping("/rent")
    public ResponseEntity rentVehicle(@RequestBody RentVehicleModel rent) {

         System.out.println("Chegou no controller");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new Error ("Veículo: "+ rent.getVehicleId()+" já esta alugado"));


    }
    
    

}
