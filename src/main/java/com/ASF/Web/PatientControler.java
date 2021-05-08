package com.ASF.Web;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ASF.Dao.IPatientDao;
import com.ASF.entities.Patient;

@Controller
public class PatientControler {
	@Autowired
	IPatientDao patientRepository;
	
	@GetMapping("")
	public String index() {
		return "index";
	}
	
	@GetMapping("/patients")
	public String listPatient(Model model,@RequestParam(name = "page" ,defaultValue = "0")int page,
			@RequestParam(name="size",defaultValue = "5")int size,
			@RequestParam(name="keyword",defaultValue = "")String mc) {
		
		Page<Patient> patients=patientRepository.findByNameContains(mc,PageRequest.of(page, size));
		model.addAttribute("patients", patients);
		model.addAttribute("pages", new int[patients.getTotalPages()] );
		model.addAttribute("currentPage",page);
		model.addAttribute("keyword",mc);
		model.addAttribute("size",size);


		

		return "patients";
	}
	
	@GetMapping("/deletePatient")
	public String remove(@RequestParam(name="id")long id,@RequestParam(name="keyword")String mc,
			@RequestParam(name = "page" ,defaultValue = "0")int page,
			@RequestParam(name = "size" ,defaultValue = "5")int size) {
		patientRepository.deleteById(id);
		return "redirect:/patients?keyword="+mc+"&page="+page+"&size="+size;
	}
	
	@GetMapping(path = "/formPatient")
	public String formPatient(Model model) {
		model.addAttribute("patient", new Patient());
		return "formPatient";
		
	}
	@PostMapping(path = "/savePatient")
	public String savePatient(@Valid Patient patient,Model model,BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "formPatient";
		patientRepository.save(patient);
		model.addAttribute("patient", patient);
		return "confirmePatient";
		
	}

	@GetMapping("/editPatient")
	public String editPatient(@RequestParam Long id,Model model) {
		Patient patient=patientRepository.findById(id).get();
		model.addAttribute("patient", patient);
		return "formPatient";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
