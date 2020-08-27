package com.employe.employe.controller;

import java.util.List;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employe.employe.DAO.EmployeRepository;
import com.employe.employe.entity.EmployeEntity;



@RestController
@CrossOrigin(origins="http://localhost:4200") 
@RequestMapping(value="/employe/api")
public class EmployeController {
	@Autowired
	EmployeRepository employeRepository;
	//consulter liste employé
	 @GetMapping(value="/allEmplyee")
	    public List<EmployeEntity> allEmploye(){
	        return employeRepository.findAll();
	    }
	//ajouter employé
	 @PostMapping(value="/addEmployee")
	   public EmployeEntity addEmploye(@Valid @RequestBody EmployeEntity e){
	        return employeRepository.save(e);
	    }
	 //supprimer employé
	 @DeleteMapping(value="/employeeDelete/{id}")
	    public Map<String,Boolean> deleteCategorie(@PathVariable Long id) throws Exception {
	        EmployeEntity emp = employeRepository.findById(id).orElseThrow(()->new Exception("La catégorie n'existe pas"));
	        employeRepository.delete(emp);
	        Map<String,Boolean> response = new HashMap<>();
	        response.put("Employe est supprimé!",Boolean.TRUE);
	        return response;
	    }
	 //modifier employé
	 @PutMapping(value="/employeeUpdate/{id}")
	    public ResponseEntity<EmployeEntity> updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeEntity employeeDetails) throws Exception{
		 EmployeEntity e = employeRepository.findById(id).orElseThrow(()->new Exception("n'existe pas"));
	        e.setNom(employeeDetails.getNom());
	        EmployeEntity updateEmployee = employeRepository.save(e);
	        return ResponseEntity.ok(updateEmployee);
	    }
	 //Afficher les détails d'un employé
	 @GetMapping(value="/employee/{id}")
	    public ResponseEntity<EmployeEntity> getEmployee(@PathVariable Long id) throws Exception{
	        EmployeEntity e = employeRepository.findById(id).orElseThrow(()->new Exception("n'existe pas"));
	        return ResponseEntity.ok().body(e);
	    }


}
