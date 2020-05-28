package br.com.compasso.cooperativismo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.compasso.cooperativismo.controller.dto.ValidaCpfDTO;

@FeignClient(value = "validaCpf", url = "https://user-info.herokuapp.com/")
public interface ValidaCpfFeignClient {
	
	@GetMapping("users/{cpf}")
	ValidaCpfDTO validaCpfDTO(@PathVariable String cpf);

}
