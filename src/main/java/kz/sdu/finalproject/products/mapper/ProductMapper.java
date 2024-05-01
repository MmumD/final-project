package kz.sdu.finalproject.products.mapper;

import kz.sdu.finalproject.products.dto.ProductCreateRequest;
import kz.sdu.finalproject.products.dto.ProductUpdateRequest;
import kz.sdu.finalproject.products.entity.ProductEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true), nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductEntity toEntity(ProductCreateRequest request);

    ProductEntity toEntity(@MappingTarget ProductEntity entity, ProductUpdateRequest request);


}
