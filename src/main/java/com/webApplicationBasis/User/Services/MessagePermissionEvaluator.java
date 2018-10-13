package com.webApplicationBasis.User.Services;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.webApplicationBasis.User.Model.Message;
import com.webApplicationBasis.User.Model.User;


@Component
public class MessagePermissionEvaluator implements PermissionEvaluator{

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		if(authentication == null) {
			return false;
		}
		Message message = (Message) targetDomainObject;
		if(message == null) {
			return true;
		}
		User currentUser = (User) authentication.getPrincipal();
		System.out.println(currentUser.getId());
		return currentUser.getId().equals(message.getOwner().getId());
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		throw new UnsupportedOperationException();
	}

}
