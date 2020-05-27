package br.com.compasso.cooperativismo.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.cooperativismo.controller.dto.AssociadoDTO;
import br.com.compasso.cooperativismo.model.Associado;
import br.com.compasso.cooperativismo.service.impl.AssociadoService;

@RestController
@RequestMapping("/associado")
public class AssociadoController {
	
	@Autowired
	private AssociadoService associadoService;
	
	@PostMapping
	public ResponseEntity<Associado> saveAssociado(@RequestBody @Valid AssociadoDTO associadoDTO){
		return new ResponseEntity<>(associadoService.saveAssociado(new ModelMapper().map(associadoDTO, Associado.class)),HttpStatus.CREATED);
	}

}
