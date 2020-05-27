package br.com.compasso.cooperativismo.sessao;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.time.LocalDateTime;

import org.junit.Assert;
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

import com.google.gson.Gson;

import br.com.compasso.cooperativismo.controller.dto.PautaIdDTO;
import br.com.compasso.cooperativismo.controller.dto.SessaoDTO;
import br.com.compasso.cooperativismo.model.Sessao;
import br.com.compasso.cooperativismo.service.impl.SessaoService;
import br.com.compasso.cooperativismo.util.Constants;
import br.com.compasso.cooperativismo.util.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SessaoControllerTest {

	private static final String URL_JSON_SESSAO = "/json/sessao/InsertSessaoValida.json";
	private static final String URL_JSON_PAUTA = "/json/sessao/InsertSessaoPautaValida.json";
	private static final String URL_JSON_PAUTA_DATA_FIM = "/json/sessao/InsertSessaoPautaValidaDataFim.json";
	private static final String URL_SESSAO = "/sessao";
	private static final String URL_PAUTA = "/pauta";
	private static final String URL_JSON_PAUTA_DATA_INICIO = "/json/sessao/InsertSessaoPautaValidaDataInicio.json";
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private SessaoService sessaoService;
	
	@Test
	public void testPostSaveSessaoInsertRecordAsJson() throws Exception {
		
		String jsonFilePauta = TestUtil.readJsonFile(URL_JSON_PAUTA);
		
		RequestBuilder requestBuilderPauta = MockMvcRequestBuilders.post(URL_PAUTA)
															  .accept(APPLICATION_JSON)
															  .content(jsonFilePauta)
															  .contentType(APPLICATION_JSON);
		
		MvcResult resultPauta = mockMvc.perform(requestBuilderPauta).andReturn();
			
		Gson gson = new Gson();
		PautaIdDTO pautaId = gson.fromJson(resultPauta.getResponse().getContentAsString(), PautaIdDTO.class);
		
		SessaoDTO sessao = new SessaoDTO();

		sessao.setPauta(pautaId);
		
		String jsonSessao = gson.toJson(sessao);
		
		RequestBuilder requestBuilderSessao = MockMvcRequestBuilders.post(URL_SESSAO)
				  .accept(APPLICATION_JSON)
				  .content(jsonSessao)
				  .contentType(APPLICATION_JSON);

		MvcResult resultSessao = mockMvc.perform(requestBuilderSessao).andReturn();
		MockHttpServletResponse response = resultSessao.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
	
	@Test
	public void testPostSaveSessaoInsertDataFimRecordAsJson() throws Exception {
		
		String jsonFilePauta = TestUtil.readJsonFile(URL_JSON_PAUTA_DATA_FIM);
		
		RequestBuilder requestBuilderPauta = MockMvcRequestBuilders.post(URL_PAUTA)
															  .accept(APPLICATION_JSON)
															  .content(jsonFilePauta)
															  .contentType(APPLICATION_JSON);
		
		MvcResult resultPauta = mockMvc.perform(requestBuilderPauta).andReturn();
			
		Gson gson = new Gson();
		PautaIdDTO pautaId = gson.fromJson(resultPauta.getResponse().getContentAsString(), PautaIdDTO.class);
		
		TestSessaoDTO sessao = new TestSessaoDTO();

		sessao.setPauta(pautaId);
		sessao.setDataInicio(LocalDateTime.now().toString());
		
		String jsonSessao = gson.toJson(sessao);
		
		RequestBuilder requestBuilderSessao = MockMvcRequestBuilders.post(URL_SESSAO)
				  .accept(APPLICATION_JSON)
				  .content(jsonSessao)
				  .contentType(APPLICATION_JSON);

		MvcResult resultSessao = mockMvc.perform(requestBuilderSessao).andReturn();
		MockHttpServletResponse response = resultSessao.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
	
	@Test
	public void testPostSaveSessaoInsertDataInicioRecordAsJson() throws Exception {
		
		String jsonFilePauta = TestUtil.readJsonFile(URL_JSON_PAUTA_DATA_INICIO);
		
		RequestBuilder requestBuilderPauta = MockMvcRequestBuilders.post(URL_PAUTA)
															  .accept(APPLICATION_JSON)
															  .content(jsonFilePauta)
															  .contentType(APPLICATION_JSON);
		
		MvcResult resultPauta = mockMvc.perform(requestBuilderPauta).andReturn();
			
		Gson gson = new Gson();
		PautaIdDTO pautaId = gson.fromJson(resultPauta.getResponse().getContentAsString(), PautaIdDTO.class);
		
		TestSessaoDTO sessao = new TestSessaoDTO();
		
		LocalDateTime dataAtual = LocalDateTime.now();

		sessao.setPauta(pautaId);
		sessao.setDataInicio(dataAtual.plusMinutes(1L).toString());
		sessao.setDataFim(dataAtual.toString());
		
		String jsonSessao = gson.toJson(sessao);
		
		RequestBuilder requestBuilderSessao = MockMvcRequestBuilders.post(URL_SESSAO)
				  .accept(APPLICATION_JSON)
				  .content(jsonSessao)
				  .contentType(APPLICATION_JSON);

		MvcResult resultSessao = mockMvc.perform(requestBuilderSessao).andReturn();
		MockHttpServletResponse response = resultSessao.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}
	
	@Test
	public void testPostSaveSessaoInsertPautaRecordAsJson() throws Exception {
			
		Gson gson = new Gson();
		
		PautaIdDTO pautaId = new PautaIdDTO();
		pautaId.setId(0L);
		
		TestSessaoDTO sessao = new TestSessaoDTO();

		sessao.setPauta(pautaId);
		
		String jsonSessao = gson.toJson(sessao);
		
		RequestBuilder requestBuilderSessao = MockMvcRequestBuilders.post(URL_SESSAO)
				  .accept(APPLICATION_JSON)
				  .content(jsonSessao)
				  .contentType(APPLICATION_JSON);

		MvcResult resultSessao = mockMvc.perform(requestBuilderSessao).andReturn();
		MockHttpServletResponse response = resultSessao.getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
	}
	
	@Test
	public void testePostSaveSessaoInsertPautaIsEmpty() {
		try {
			sessaoService.saveSessao(new Sessao());
			Assert.fail("Deveria ter lançando uma exceção");
		} catch (Exception e) {
			assertEquals(null, e.getMessage());
		}
	}
}
