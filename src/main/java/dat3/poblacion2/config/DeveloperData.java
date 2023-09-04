package dat3.poblacion2.config;

import dat3.poblacion2.entity.Address;
import dat3.poblacion2.entity.Citizen;
import dat3.poblacion2.entity.Town;
import dat3.poblacion2.repository.AddressRepository;
import dat3.poblacion2.repository.CitizenRepository;
import dat3.poblacion2.repository.TownRepository;
import dat3.poblacion2.service.AddressService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DeveloperData implements ApplicationRunner
	{
		private final AddressRepository addressRepository;
	private final CitizenRepository citizenRepository;
		private final TownRepository townRepository;
		private AddressService addressService;

		public DeveloperData(AddressRepository addressRepository, CitizenRepository citizenRepository, TownRepository townRepository, AddressService addressService)
			{
				this.addressRepository = addressRepository;
				this.citizenRepository = citizenRepository;
				this.townRepository = townRepository;
				this.addressService = addressService;
			}

		@Override
		public void run(ApplicationArguments args) throws Exception
			{
				Town town=new Town();
				townRepository.save(town);
				Address a1 = new Address("Lyngbyvej 1", "Lyngby", "2800");
				Citizen citizen1 = new Citizen("Kurt", "Wonnegut", "a@b.dk","123");
				Citizen citizen2 = new Citizen("Hanne", "Wonnegut", "h@b.dk", "234");
				//citizenRepository.save(citizen1); er nødvendigt ved unidirectional onetomany .
				//citizenRepository.save(citizen2);
				a1.addCitizen(citizen1);
				a1.addCitizen(citizen2);
				citizen2.setTown(town);
				citizen1.setTown(town);
				addressRepository.save(a1);//Save the address



				System.out.println("------- Select statements starts here ------------");
//				Address address_1 = addressRepository.findById(a1.getId()).get();
//				System.out.println(address_1.getStreet());
//				System.out.println("Press Enter to continue");
//				System.in.read();  //This will block so you have time to read the DEBUG statements
//				System.out.println("Citizens: "+address_1.getCitizens().size());
				addressService.printFullAddressInfo(1,false);




			}
	}
