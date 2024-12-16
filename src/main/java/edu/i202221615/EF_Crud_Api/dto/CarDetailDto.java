package edu.i202221615.EF_Crud_Api.dto;

import java.util.Date;

public record CarDetailDto(
        Integer carId,
        String make,
        String model,
        int year,
        String licensePlate,
        String ownerName,
        Date purchaseDate,
        String engineType,
        String color,
        String insuranceCompany,
        String insurancePolicyNumber,
        Date serviceDueDate
) {
}
