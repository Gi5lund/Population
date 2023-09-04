package dat3.poblacion2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "town")

public class Town
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name = "city_name",length = 100,nullable = true)
		private String name;
		@Column(name = "city_zip",nullable = true)
		private String zipCode;
		@Column(name = "current_mayor",length = 121,nullable = true)
		private String mayor;
		@Column(name = "schools")
		private String schools;
	}
