package edu.i202221615.EF_Crud_Api.dto;

public record CarDto(
        Integer carId,
        String make,
        String licensePlate,
        String ownerName,
        String color
) {
}
