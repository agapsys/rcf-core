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

/**
 * Represents a security handler.
 * A security handler is an object responsible to allow or reject request according to its internal logic.
 * @author Leandro Oliveira (leandro@agapsys.com)
 */
public interface SecurityHandler {
	/**
	 * Returns a boolean indicating if given request is allowed to be processed.
	 * @param exchange HTTP exchange
	 * @return a boolean indicating if given request is allowed to be processed.
	 */
	public boolean isAllowed(HttpExchange exchange);
}
