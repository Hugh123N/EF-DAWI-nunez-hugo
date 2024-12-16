package edu.i202221615.EF_Crud_Api.controller;

import edu.i202221615.EF_Crud_Api.dto.CarCreateDto;
import edu.i202221615.EF_Crud_Api.dto.CarDetailDto;
import edu.i202221615.EF_Crud_Api.dto.CarDto;
import edu.i202221615.EF_Crud_Api.response.createCarResponse;
import edu.i202221615.EF_Crud_Api.response.deleteCarResponse;
import edu.i202221615.EF_Crud_Api.response.findAllCarResponse;
import edu.i202221615.EF_Crud_Api.response.findCarDetailResponse;
import edu.i202221615.EF_Crud_Api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/all")
    public findAllCarResponse findAllCar(){
        try {
            List<CarDto> list=carService.findAllCar();
            if(!list.isEmpty()){
                return new findAllCarResponse("01",null,list);
            }else
                return new findAllCarResponse("02","Cars not fount",null);
        }catch(Exception e){
            e.printStackTrace();
            return new findAllCarResponse("99","An error ocurred, please tray again.",null);
        }
    }

    @GetMapping("/detail")
    public findCarDetailResponse findCarDetail(@RequestParam(value = "id", defaultValue = "0") String id){
        try {
            Optional<CarDetailDto> optional = carService.findDetailCar(Integer.parseInt(id));
            return optional.map(car->
                    new findCarDetailResponse("01",null,car)
                    ).orElse(
                    new findCarDetailResponse("02","car not found",null)
            );
        }catch (Exception e){
            e.printStackTrace();
            return new findCarDetailResponse("99","An error ocurred, please try again.",null);
        }
    }

    @PostMapping("/create")
    public createCarResponse createCar(@RequestBody CarCreateDto car){
        try {
            if(carService.createCar(car))
                 return   new createCarResponse("01",null);
            else
                return    new createCarResponse("02","create failed");
        }catch (Exception e){
            e.printStackTrace();
            return new createCarResponse("99","An error ocurred, please try again.");
        }
    }

    @PutMapping("/update")
    public createCarResponse updateCar(@RequestBody CarCreateDto car){
        try{
            if(carService.updateCar(car))
                return new createCarResponse("01",null);
            else
                return new createCarResponse("02","update failed.");
        }catch (Exception e){
            e.getStackTrace();
            return new createCarResponse("99","An error ocurred, please try again.");
        }
    }

    @DeleteMapping("delete/{id}")
    public deleteCarResponse deleteCar(@PathVariable Integer id){
        try {
            if(carService.deleteCar(id))
                return new deleteCarResponse("01",null);
            else
                return new deleteCarResponse("02","failed delete");
        }catch (Exception e){
            e.getStackTrace();
            return new deleteCarResponse("99","An error ocurred, please try again.");
        }
    }

}
