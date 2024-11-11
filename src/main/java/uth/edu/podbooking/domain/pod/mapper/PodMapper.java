package uth.edu.podbooking.domain.pod.mapper;


import org.mapstruct.Mapper;
import uth.edu.podbooking.domain.pod.dto.response.PodRespone;
import uth.edu.podbooking.domain.pod.entity.Pod;

@Mapper(componentModel = "spring")
public interface PodMapper {
    PodRespone toPodRespone(Pod pod);
}
