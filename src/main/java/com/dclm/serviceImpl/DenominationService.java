package com.dclm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dclm.model.Denomination;
import com.dclm.repository.DenominationRepository;
import com.dclm.service.IDenominationService;

@Service
public class DenominationService implements IDenominationService {
	
	@Autowired
	DenominationRepository denominationRepository;

	@Override
	public Denomination getDenomination(Integer id) {
		// TODO Auto-generated method stub
		return denominationRepository.findById(id).get();
	}

}
