package kz.sdu.finalproject.cards.mapper;

import kz.sdu.finalproject.cards.dto.CardCreateRequest;
import kz.sdu.finalproject.cards.dto.CardView;
import kz.sdu.finalproject.cards.entity.CardEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true), nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    CardEntity toEntity(CardCreateRequest request);

    CardView toView(CardEntity entity);

}
