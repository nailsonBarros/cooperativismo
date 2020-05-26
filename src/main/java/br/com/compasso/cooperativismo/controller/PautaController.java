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

import br.com.compasso.cooperativismo.controller.dto.PautaDTO;
import br.com.compasso.cooperativismo.model.Pauta;
import br.com.compasso.cooperativismo.service.impl.PautaService;

@RestController
@RequestMapping("/pauta")
public class PautaController {
	
	@Autowired
	private PautaService pautaService;
	
	@PostMapping
	public ResponseEntity<Pauta> savePauta(@RequestBody @Valid PautaDTO pautaDTO){
		return new ResponseEntity<>(pautaService.savePauta(new ModelMapper().map(pautaDTO, Pauta.class)),HttpStatus.CREATED);
	}

}
