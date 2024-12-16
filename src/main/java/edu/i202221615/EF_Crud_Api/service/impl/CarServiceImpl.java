package edu.i202221615.EF_Crud_Api.service.impl;

import edu.i202221615.EF_Crud_Api.dto.CarCreateDto;
import edu.i202221615.EF_Crud_Api.dto.CarDetailDto;
import edu.i202221615.EF_Crud_Api.dto.CarDto;
import edu.i202221615.EF_Crud_Api.model.Car;
import edu.i202221615.EF_Crud_Api.repository.CarRepository;
import edu.i202221615.EF_Crud_Api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> findAllCar() throws Exception {
        List<CarDto> lista = new ArrayList<>();
            Iterable<Car> iterable=carRepository.findAll();
            iterable.forEach(car ->{
                lista.add(new CarDto(
                        car.getCarId(),
                        car.getMake(),
                        car.getLicensePlate(),
                        car.getOwnerName(),
                        car.getColor()
                ));
            });
            return lista;
    }

    @Override
    public Optional<CarDetailDto> findDetailCar(Integer id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car->new CarDetailDto(
                car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getPurchaseDate(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getServiceDueDate()
                ));
    }

    @Override
    public boolean updateCar(Car car) throws Exception {
        return false;
    }

    @Override
    public boolean createCar(CarCreateDto carDto) throws Exception {
        Car car = new Car();
        car.setMake(carDto.make());
        car.setModel(carDto.model());
        car.setYear(carDto.year());
        car.setVin(carDto.vin());
        car.setLicensePlate(carDto.licensePlate());
        car.setOwnerContact(carDto.ownerContact());
        car.setMileage(carDto.mileage());
        car.setEngineType(carDto.engineType());
        car.setColor(carDto.color());
        car.setInsuranceCompany(carDto.insuranceCompany());
        return true;
    }

    @Override
    public boolean deleteCar(Integer id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car ->{
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }
}
