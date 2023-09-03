package dat3.poblacion2.repository;

import dat3.poblacion2.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen,Integer>
	{
	}
