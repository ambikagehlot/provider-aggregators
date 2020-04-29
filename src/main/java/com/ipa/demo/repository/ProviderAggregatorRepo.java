package com.ipa.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipa.demo.entity.ProviderAggregator;

@Repository
public interface ProviderAggregatorRepo extends JpaRepository<ProviderAggregator, Integer>{
	Optional<ProviderAggregator> findByProviderName(String providerName);
	//Optional<Provider> findByProviderName(String providerName);
}
