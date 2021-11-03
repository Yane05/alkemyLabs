package com.alkemy.challengeAlternativo.icons.repository.specifications;

import com.alkemy.challengeAlternativo.icons.dto.PaisFiltersDTO;
import com.alkemy.challengeAlternativo.icons.entity.ContinenteEntity;
import com.alkemy.challengeAlternativo.icons.entity.PaisEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class PaisSpecification {
    public Specification<PaisEntity> getByFilters(PaisFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denominacion")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"
                        )
                );
            }
            if (!CollectionUtils.isEmpty(filtersDTO.getIdContinente())) {
                Join<ContinenteEntity, PaisEntity> join = root.join("continentes", JoinType.INNER);
                Expression<String> continenteId = join.get("id");
                predicates.add(continenteId.in(filtersDTO.getIdContinente()));
            }
            /*if (NumberUtils.parseNumber(filtersDTO.getIdContinente()), Long){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(filtersDTO.getDate(), formatter);

                predicates.add(
                        criteriaBuilder.equal(root.<LocalDate>get("fechaCreacion"),date)
                );
            }
            if (!CollectionUtils.isEmpty(filtersDTO.getCities())){
                Join<PaisEntity, IconEntity> join = root.join("paises", JoinType.INNER);
                Expression<String> citiesId = join.get("id");
                predicates.add(citiesId.in(filtersDTO.getCities()));
            }*/

            //Remove duplicates
            query.distinct(true);

            //orden
            String orderByField = "denominacion";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
