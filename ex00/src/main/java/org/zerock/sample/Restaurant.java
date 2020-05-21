package org.zerock.sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	
	
	//@Setter(onMethod_=@Autowired)
	@Setter(onMethod_=@Autowired)
	private Chef  chef; 
	// 지연  : 레스토랑이 동작할 때 세프가 필요. 레스토랑이 셰프에게 의존함. 
	// 지연 : autowired를 하면, 해당 세프 객체를 자동으로 주입한다.
	// 지연 : @data어노테이션이 붙어있기에 chef변수 하나만 선언했던것이
	
	
}
