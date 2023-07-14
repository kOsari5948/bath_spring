package com.manbath.bath.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manbath.bath.entitiy.History;
import com.manbath.bath.repository.HistoryRepository;
import com.manbath.bath.vo.HistroyVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class HistroyService {
	@Autowired
	private HistoryRepository historyRepository;
	

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
	EntityManager em = emf.createEntityManager();
	
	@Transactional(readOnly = true)
	public List<History> findByUserid(String id,HistroyVO vo){
		
		String jpql = "SELECT h FROM history h where userid = '"+ id +"' ";
		
		if (vo.getDay() != 0) {
			jpql += "and DAY(start_time) = "+vo.getDay()+" ";
		}
		if (vo.getYear() != 0) {
			jpql += "and YEAR(start_time) = "+vo.getYear()+" ";
		}
		if (vo.getMonth() != 0) {
			jpql += "and MONTH(start_time) = "+vo.getMonth()+" ";
		}

		System.out.println("쿼리문 실행: " + jpql);
		//return historyRepository.findAll();
		
		TypedQuery<History> query;
		
		if(vo.getNumber()!= 0 ) {
			query = em.createQuery(jpql,History.class)
					.setFirstResult(vo.getStart())
					.setMaxResults(vo.getNumber());
		}else {
			query = em.createQuery(jpql,History.class)
					.setFirstResult(vo.getStart());
		}
		
		return query.getResultList();
		
	}
	
}
