package com.ipa.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipa.demo.entity.ProviderAggregator;
import com.ipa.demo.exceptions.BusinessException;
import com.ipa.demo.repository.ProviderAggregatorRepo;

@Service
public class ProviderAggregatorService {
	
	@Autowired
	ProviderAggregatorRepo providerAggregatorRepo;
	
	public ProviderAggregator getProviderPlanById(int providerId) 
	{
		return providerAggregatorRepo.findById(providerId).get();
	}
	
	public ProviderAggregator getProviderByName(String providerName)
	{
		Optional<ProviderAggregator> providerAggregatorObj = providerAggregatorRepo.findByProviderName(providerName);
		if(providerAggregatorObj.isPresent())
			return providerAggregatorObj.get();
		else
			return null;
	}
	
	public ProviderAggregator addProvider(ProviderAggregator newProvider) throws BusinessException
	{
		if(providerAggregatorRepo.findById(newProvider.getProviderId()).isPresent())
		{
			throw new BusinessException("Provider already found with Id - "+newProvider.getProviderName());
		}
		else
		{
			return providerAggregatorRepo.save(newProvider);
		}
	}
	
	public List<ProviderAggregator> getProviders() throws BusinessException{
		if(providerAggregatorRepo.count() == 0)
		{
			throw new BusinessException("Plans not found");
		}
		else
		{
			return providerAggregatorRepo.findAll();
		}
	}

}
