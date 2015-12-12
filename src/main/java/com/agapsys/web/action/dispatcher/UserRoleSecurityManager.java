/*
 * Copyright 2015 Agapsys Tecnologia Ltda-ME.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.agapsys.web.action.dispatcher;

import java.util.Set;

/**
 * Security manger responsible by checking if a user is allowed to process an action
 * @author Leandro Oliveira (leandro@agapsys.com)
 */
public class UserRoleSecurityManager implements SecurityManager {
	private final Set<String> requiredRoles;
	private final UserManager userManager;
	
	/**
	 * Constructor.
	 * Creates a security manger with given required roles
	 * @param userManager user manager which will be used by this instance whiling getting the user from a session.
	 * @param requiredRoles required roles. Passing null or an empty set implies in no security
	 */
	public UserRoleSecurityManager(UserManager userManager, Set<String> requiredRoles) {
		this.requiredRoles = requiredRoles;
		this.userManager = userManager;
	}
	
	/**
	 * Returns the user manager passed in constructor.
	 * @return the user manager passed in constructor.
	 */
	public final UserManager getUserManager() {
		return userManager;
	}
		
	@Override
	public boolean isAllowed(HttpExchange exchange) {
		if (requiredRoles == null || requiredRoles.isEmpty()) {
			return true;
		} else {
			ApplicationUser sessionUser = userManager != null ? userManager.getUser(exchange) : null;
			return sessionUser != null && (sessionUser.isAdmin() || (sessionUser.getRoles() != null && sessionUser.getRoles().containsAll(requiredRoles)));
		}
	}
}
