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

import br.com.compasso.cooperativismo.controller.dto.SessaoDTO;
import br.com.compasso.cooperativismo.model.Sessao;
import br.com.compasso.cooperativismo.service.impl.SessaoService;

@RestController
@RequestMapping("/sessao")
public class SessaoController {
	
	@Autowired
	private SessaoService sessaoService;
	
	@PostMapping
	public ResponseEntity<Sessao> saveSessao(@RequestBody @Valid SessaoDTO sessaoDTO) throws Exception{
		return new ResponseEntity<>(sessaoService.saveSessao(new ModelMapper().map(sessaoDTO, Sessao.class)),HttpStatus.CREATED);
	}

}
