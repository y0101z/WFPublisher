package com.wf.publisher.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	private String zipCode;
}
