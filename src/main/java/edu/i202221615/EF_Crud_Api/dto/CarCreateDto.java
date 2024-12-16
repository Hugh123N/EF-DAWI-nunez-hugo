package edu.i202221615.EF_Crud_Api.dto;

import java.util.Date;

public record CarCreateDto(
         String make,
         String model,
         int year,
         String vin,
         String licensePlate,
         String ownerName,
         String ownerContact,
         int mileage,
         String engineType,
         String color,
         String insuranceCompany
) {
}
