package edu.i202221615.EF_Crud_Api.controller;

import edu.i202221615.EF_Crud_Api.dto.CarDetailDto;
import edu.i202221615.EF_Crud_Api.dto.CarDto;
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

    @GetMapping("")
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
    public findCarDetailResponse createCar(){

    }

}
