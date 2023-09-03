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
@Table(name = "citizen")

public class Citizen
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name = "first_name",length = 120,nullable = false)
		private String firstName;
		@Column(name = "last_name",length = 120,nullable = false)
		private String lastName;
		@Column(name = "email",unique = true)
		private String email;
		@Column(name = "phone_No.")
		private String  phone;
		@ManyToOne
		Address address;

		public Citizen(String firstName, String lastName, String email, String phone)
			{
				this.firstName = firstName;
				this.lastName = lastName;
				this.email = email;
				this.phone = phone;
			}
	}
