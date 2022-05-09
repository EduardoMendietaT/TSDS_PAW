package com.pruebaauth.security.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LoginRequest {
    
    @NotBlank
	private String username;

	@NotBlank
	private String password;

}
