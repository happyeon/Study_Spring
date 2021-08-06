package com.test02;

import java.util.Locale;

/*
 * <메세지 국제화>
 * MessageSourceAware는 번들이 지정된 properties 파일을 setMessageSource로 전달
 * 
 * ResourceBundleMessageSource의 setBaseName()을 통해 전달된 파일을 setMessageSource로 자동 매핑
 * ResourceBundleMessageSource와 MessageSourceAware는 쌍으로 사용
 */

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class MemberInfo implements MessageSourceAware {
	
	private MessageSource message;

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("컨테이너가 메세지 설정을 수행 중...");
		this.message = messageSource;
	}
	
	public void display(Locale locale) {
		String name = message.getMessage("member.name", null, locale);
		String birthplace = message.getMessage("member.birthplace", null, locale);
		String hobby = message.getMessage("member.hobby", null, locale);
		String age = message.getMessage("member.age", new Object[] {"13"}, locale);
		
		System.out.println(locale);
		System.out.println(name);
		System.out.println(birthplace);
		System.out.println(hobby);
		System.out.println(age);
	}

}
