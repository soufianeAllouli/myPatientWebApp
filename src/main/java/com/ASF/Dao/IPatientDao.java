package com.ASF.Dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ASF.entities.Patient;

public interface IPatientDao extends JpaRepository<Patient, Long>{
		
	public Page<Patient> findByNameContains(String mc,Pageable pageable);

}
