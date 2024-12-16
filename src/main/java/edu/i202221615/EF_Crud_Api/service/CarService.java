package edu.i202221615.EF_Crud_Api.service;

import edu.i202221615.EF_Crud_Api.dto.CarCreateDto;
import edu.i202221615.EF_Crud_Api.dto.CarDetailDto;
import edu.i202221615.EF_Crud_Api.dto.CarDto;
import edu.i202221615.EF_Crud_Api.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarDto> findAllCar() throws Exception;

    Optional<CarDetailDto> findDetailCar(Integer id) throws Exception;

    boolean updateCar(Car car) throws Exception;

    boolean createCar(CarCreateDto car) throws Exception;

    boolean deleteCar(Integer id) throws Exception;

}
