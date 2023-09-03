package dat3.poblacion2.config;

import dat3.poblacion2.entity.Address;
import dat3.poblacion2.entity.Citizen;
import dat3.poblacion2.repository.AddressRepository;
import dat3.poblacion2.repository.CitizenRepository;
import dat3.poblacion2.repository.TownRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DeveloperData implements ApplicationRunner
	{
		AddressRepository addressRepository;
		CitizenRepository citizenRepository;
		TownRepository townRepository;
		public DeveloperData(AddressRepository addressRepository,CitizenRepository citizenRepository, TownRepository townRepository){
			this.addressRepository=addressRepository;
			this.citizenRepository=citizenRepository;
			this.townRepository=townRepository;
		}
		@Override
		public void run(ApplicationArguments args) throws Exception
			{
				Address a1 = new Address("Lyngbyvej 1", "Lyngby", 2800);
				Citizen citizen1 = new Citizen("Kurt", "Wonnegut", "a@b.dk","123");
				Citizen citizen2 = new Citizen("Hanne", "Wonnegut", "h@b.dk", "234");
				//citizenRepository.save(citizen1);
				//citizenRepository.save(citizen2);
				a1.addCitizen(citizen1);
				a1.addCitizen(citizen2);

				addressRepository.save(a1);//Save the address


			}
	}
