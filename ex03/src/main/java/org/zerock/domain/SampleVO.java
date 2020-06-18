package org.zerock.domain;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class SampleVO {
		private Integer mno; 
		private String firstName; 
		private String lastName;
		
		
		
}
