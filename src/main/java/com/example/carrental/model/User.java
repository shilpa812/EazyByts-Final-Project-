package com.example.carrental.model;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
@Id
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private boolean enabled;
}
