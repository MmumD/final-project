package kz.sdu.finalproject.user.mapper;

import kz.sdu.finalproject.user.dto.UserCreateRequest;
import kz.sdu.finalproject.user.dto.UserUpdateRequest;
import kz.sdu.finalproject.user.dto.UserView;
import kz.sdu.finalproject.user.entity.UserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true), nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(UserCreateRequest request);

    UserEntity toUpdateEntity(@MappingTarget UserEntity entity, UserUpdateRequest request);

    UserView toView(UserEntity entity);

}
