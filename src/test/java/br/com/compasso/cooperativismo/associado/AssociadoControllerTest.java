package br.com.compasso.cooperativismo.associado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.compasso.cooperativismo.util.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AssociadoControllerTest {
	
	private static final String URL_JSON_ASSOCIADO = "/json/associado/InsertAssociadoCpfValido.json";
	private static final String URL_ASSOCIADO = "/associado";
	private static final String URL_JSON_ASSOCIADO_INVALIDO = "/json/associado/InsertAssociadoCpfInvalido.json";
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testPostSaveAssociadoRecordAsJson() throws Exception {
		
		String jsonFile = TestUtil.readJsonFile(URL_JSON_ASSOCIADO);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL_ASSOCIADO).accept(APPLICATION_JSON).content(jsonFile).contentType(APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
	
	@Test
	public void testPostSaveAssociadoInvalidoRecordAsJson() throws Exception {
		
		String jsonFile = TestUtil.readJsonFile(URL_JSON_ASSOCIADO_INVALIDO);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL_ASSOCIADO).accept(APPLICATION_JSON).content(jsonFile).contentType(APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}

}
