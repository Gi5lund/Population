package dat3.poblacion2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="address")
public class Address
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name = "street",nullable = false,length = 100)
		private String street;
		@Column(name = "city",nullable = false,length = 100)
		private String city;
		@Column(name = "address_zip")
		private String zip;

		@OneToMany(mappedBy = "address", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
//	@OneToMany
	//@JoinColumn(name = "address_id") //hm skal den med
	private List<Citizen> citizens = new ArrayList();




		public Address(String street, String city, String zip)
			{
				this.street = street;
				this.city = city;
				this.zip = zip;
			}

		public void addCitizen(Citizen c){
			c.setAddress(this);
			citizens.add(c);
		}


	}
