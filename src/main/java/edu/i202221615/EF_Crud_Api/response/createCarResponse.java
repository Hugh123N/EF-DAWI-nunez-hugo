package edu.i202221615.EF_Crud_Api.response;

import edu.i202221615.EF_Crud_Api.dto.CarCreateDto;
import edu.i202221615.EF_Crud_Api.dto.CarDto;

import java.util.List;

public record createCarResponse(
        String code,
        String error
) {
}
