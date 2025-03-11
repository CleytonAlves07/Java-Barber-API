package com.dio.barbershopapi.mapper;

import com.dio.barbershopapi.controller.request.SaveClientRequest;
import com.dio.barbershopapi.controller.request.UpdateClientRequest;
import com.dio.barbershopapi.controller.response.ClientDetailResponse;
import com.dio.barbershopapi.controller.response.ListClientResponse;
import com.dio.barbershopapi.controller.response.SaveClientResponse;
import com.dio.barbershopapi.controller.response.UpdateClientResponse;
import com.dio.barbershopapi.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);

}
