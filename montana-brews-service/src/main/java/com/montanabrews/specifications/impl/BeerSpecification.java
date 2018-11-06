package com.montanabrews.specifications.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import com.montanabrews.entities.Beer;
import com.montanabrews.util.SearchCriteria;

public class BeerSpecification implements Specification<Beer> {
	
	private static final Logger LOG = LoggerFactory.getLogger(BeerSpecification.class);

	private SearchCriteria searchCriteria;

	public BeerSpecification(SearchCriteria searchCriteria) {
		super();
		this.searchCriteria = searchCriteria;
	}

	@Override
	public Predicate toPredicate(Root<Beer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		return buildCriteria(root, searchCriteria, criteriaBuilder);
	}
	
	public Predicate buildCriteria(Path<?> path, SearchCriteria searchCriteria, CriteriaBuilder criteriaBuilder) {		
		if (searchCriteria.getOperation().equalsIgnoreCase("^")) {
			LOG.info("recursive function hit, reaching further");
			return buildCriteria(path.get(searchCriteria.getKey()), searchCriteria.getSearchCriteria(), criteriaBuilder);
		} switch(searchCriteria.getOperation().trim()) {
			case "<":
				LOG.info("Filtering by <");
				return criteriaBuilder.greaterThan(path.<String>get(searchCriteria.getKey()), searchCriteria.getValue());
			case ">":
				LOG.info("Filtering by >");
				return criteriaBuilder.lessThan(path.<String>get(searchCriteria.getKey()), searchCriteria.getValue());
			case ":":
				LOG.info("Filtering by LIKE");
				return criteriaBuilder.like(path.<String>get(searchCriteria.getKey()),
						"%" + searchCriteria.getValue() + "%");
			default:
				LOG.error("Invalid filter operation given to filter Beer results with ('{}')", searchCriteria.getOperation());
		}
		return null;
	}

}
