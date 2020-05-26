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

import br.com.compasso.cooperativismo.controller.dto.VotoDTO;
import br.com.compasso.cooperativismo.model.Voto;
import br.com.compasso.cooperativismo.service.impl.VotoService;

@RestController
@RequestMapping("/voto")
public class VotoController {
	
	@Autowired
	private VotoService votoService;
	
	
	@PostMapping
	public ResponseEntity<Voto> saveVoto(@RequestBody @Valid VotoDTO votoDTO) throws Exception{
		return new ResponseEntity<>(votoService.saveVoto(new ModelMapper().map(votoDTO, Voto.class)),HttpStatus.CREATED);
	}

}
