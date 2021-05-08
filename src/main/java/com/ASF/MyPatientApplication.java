package com.ASF;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ASF.Dao.IPatientDao;
import com.ASF.entities.Patient;

@SpringBootApplication
public class MyPatientApplication implements CommandLineRunner{
	@Autowired
		 IPatientDao patientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MyPatientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	patientRepository.save(new Patient(null,"hossam",new Date(),true));
	patientRepository.save(new Patient(null,"imane",new Date(),false));
	patientRepository.save(new Patient(null,"yassin",new Date(),false));
	patientRepository.save(new Patient(null,"amalon",new Date(),false));
	
	patientRepository.findAll()
	.forEach(patient->System.out.println(patient.toString()));
		
	}

}
