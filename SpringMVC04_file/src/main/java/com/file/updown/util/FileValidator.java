package com.file.updown.util;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {		// validator가 검증할 수 있는 타입인지 확인 (파일 유무 확인)
		// validator 사용 가능 여부 확인
		return false;		
	}

	@Override
	public void validate(Object target, Errors errors) {	// target을 검증한 후, 에러값이 있으면 errors에 담는다.
		UploadFile file = (UploadFile) target;
		
		if (file.getMpfile().getSize() == 0) {
			// field에 대한 errorCode를 리턴 / errorCode 없으면 default message 전달
			errors.rejectValue("mpfile", "fileNPE", "please select a file");  // 에러에 대한 메세지 전달
		}
	}

}
