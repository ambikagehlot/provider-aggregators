package com.ipa.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ipa.demo.entity.ProviderAggregator;
import com.ipa.demo.exceptions.RestException;
import com.ipa.demo.service.ProviderAggregatorService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProviderAggregatorController {
	
	@Autowired
	ProviderAggregatorService providerAggregatorService;
	
	@GetMapping("/providers")
	public List<ProviderAggregator> getProviders() throws RestException{
		return providerAggregatorService.getProviders();
	}
	
	@PostMapping("/providerAggregator/addProvider")
	public ProviderAggregator addProvider(@RequestBody ProviderAggregator newProvider) throws RestException
	{
		return providerAggregatorService.addProvider(newProvider);
	}
	
	@GetMapping("/providerHealthPlans/{providerName}")
	public ResponseEntity<String> getProviderPlansByName(@PathVariable("providerName") String providerName) throws RestException{
		
		
		ProviderAggregator providerAggregatorObj = providerAggregatorService.getProviderByName(providerName);
		if(providerAggregatorObj!=null)
		{
			final String url = providerAggregatorObj.getProviderUrl();
			RestTemplate restTemplate = new RestTemplate();
		    HttpHeaders headers = new HttpHeaders();
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		    ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		    return result;
		}
		else
		{
			throw new RestException("Could not find provider with name - "+providerName);
		}
	}
	
}
