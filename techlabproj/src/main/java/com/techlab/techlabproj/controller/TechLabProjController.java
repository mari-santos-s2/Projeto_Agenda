package com.techlab.techlabproj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techlab.techlabproj.model.Cadastro;
import com.techlab.techlabproj.service.TechLabProjService;

@RestController
@RequestMapping ("/api")
public class TechLabProjController {

	TechLabProjService techLabProjService;
	
	@PostMapping("/cadastrar")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public String cadastrar(@RequestBody Cadastro novoCadastro) {
		
		
		if(cadastroEhValido(novoCadastro)) {
			var cadastroCriado =  techLabProjService.cadastrarUsuario(novoCadastro);
			if (cadastroCriado.getSerialversionuid()> 0) {
				return String.format("Usuario cadastrado com sucesso", HttpStatus.CREATED.toString());
				
			}
		}
		
		return null;
	}
	@GetMapping ("/buscar")
	public String buscar(@RequestBody String nome) {
		return  nome;
	}
	
	
	
	
	
	private boolean cadastroEhValido (Cadastro cadastro) {
		
		if(cadastro == null) {
			return false;
		}
		
		if(cadastro.getNome().length() <=0) {
			return false;
		}
		
		if(cadastro.getEmail().length() <=0) {
			return false;
		}
		
		if(cadastro.getMatricula().length() <=0) {
			return false;
		}
		
		if(cadastro.getSenha().length() <=0) {
			return false;
		}
		
		return true;
	}
	
	
	
	
}
