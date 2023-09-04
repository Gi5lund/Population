package dat3.poblacion2.service;

import dat3.poblacion2.entity.Address;
import dat3.poblacion2.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // gør serviceklasse transactional
public class AddressService {
	@Autowired
	AddressRepository addressRepository;

@Transactional
	public void printFullAddressInfo(int id, boolean includeCitizens) {
		Address address_1 = addressRepository.findById(id).get();
		System.out.println(address_1.getStreet());
		if (includeCitizens) {
			System.out.println("Citizens: " + address_1.getCitizens().size());
		}
	}
}


