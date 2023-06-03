package com.techlab.techlabproj.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlab.techlabproj.model.Cadastro;
import com.techlab.techlabproj.repository.TechLabProjRepository;

@Service
public class TechLabProjService {

	@Autowired
	TechLabProjRepository techLabProjRepository;
	
		public Cadastro cadastrarUsuario(Cadastro novoCadastro) {
			return techLabProjRepository.save(novoCadastro);
		}
	
		public Cadastro alterarUsuario(UUID id, Cadastro cadastro) {
			var cadastroAtual = techLabProjRepository.findById(id);
			if(!cadastroAtual.isEmpty()) {
			cadastro.setId(id);
			return techLabProjRepository.save(cadastro);
			}
			return null;
			
		}
		
		public List<Cadastro>buscarTodosCadastros(){
			return techLabProjRepository.findAll();
		}
		
		
		public Cadastro buscaCadastroPorId(UUID id) {
			var cadastro = techLabProjRepository.findById(id);
			if(!cadastro.isEmpty()) {
				return cadastro.get();
			} 
			return null;
		}
		
		public void excluirCadastroPorId(UUID id) {
			var cadastro = techLabProjRepository.findById(id);
			if(!cadastro.isEmpty()) {
				techLabProjRepository.deleteById(id);
			} 
			
		}
		
	
	
}
