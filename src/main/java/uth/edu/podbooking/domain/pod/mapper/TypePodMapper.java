package uth.edu.podbooking.domain.pod.mapper;

import org.mapstruct.Mapper;
import uth.edu.podbooking.domain.pod.dto.response.TypePodResponse;
import uth.edu.podbooking.domain.pod.entity.TypePod;


@Mapper(componentModel = "spring")
public interface TypePodMapper {
    TypePodResponse toTypePodResponse(TypePod typePod);
}
