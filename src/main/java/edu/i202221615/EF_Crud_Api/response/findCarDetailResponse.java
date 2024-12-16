package edu.i202221615.EF_Crud_Api.response;

import edu.i202221615.EF_Crud_Api.dto.CarDetailDto;
import edu.i202221615.EF_Crud_Api.dto.CarDto;

import java.util.List;

public record findCarDetailResponse(
        String code,
        String error,
        CarDetailDto car
) {
}
