package kz.sdu.finalproject.user.mapper;

import kz.sdu.finalproject.user.dto.UserCreateRequest;
import kz.sdu.finalproject.user.entity.UserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(UserCreateRequest request);

}
