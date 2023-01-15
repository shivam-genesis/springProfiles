package com.profiles.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	@Column(name = "id")
	private Integer userId;

	@Column(name = "name")
	private String userName;

	@Column(name = "city")
	private String userCity;

	@Column(name = "status")
	private String userStatus;
}
