package com.montanabrews.specifications.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.montanabrews.entities.Beer;
import com.montanabrews.entities.Brewery;
import com.montanabrews.util.SearchCriteria;

public class BeerSpecification implements Specification<Beer> {

	private SearchCriteria searchCriteria;

	public BeerSpecification(SearchCriteria searchCriteria) {
		super();
		this.searchCriteria = searchCriteria;
	}

	@Override
	public Predicate toPredicate(Root<Beer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (searchCriteria.getOperation().equalsIgnoreCase("<")) {
			return criteriaBuilder.greaterThan(root.<String>get(searchCriteria.getKey()), searchCriteria.getValue());
		} else if (searchCriteria.getOperation().equalsIgnoreCase(">")) {
			return criteriaBuilder.lessThan(root.<String>get(searchCriteria.getKey()), searchCriteria.getValue());
		} else if (searchCriteria.getOperation().equalsIgnoreCase(":")) {
			if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
				return criteriaBuilder.like(root.<String>get(searchCriteria.getKey()),
						"%" + searchCriteria.getValue() + "%");
			} else {
				return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
			}
		} else if (searchCriteria.getOperation().equalsIgnoreCase("^")) {
			if (root.get(searchCriteria.getKey()).getJavaType() == Brewery.class) {
				if (searchCriteria.getSearchCriteria().getOperation().equalsIgnoreCase(":")) {
					return criteriaBuilder.like(
							root.get(searchCriteria.getKey()).<String>get(searchCriteria.getSearchCriteria().getKey()),
							"%" + searchCriteria.getSearchCriteria().getValue() + "%");
				}
			}
		}
		return null;
	}

}
