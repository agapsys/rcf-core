/*
 * Copyright 2016 Agapsys Tecnologia Ltda-ME.
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
package com.agapsys.rcf.integration.controllers;

import com.agapsys.rcf.Controller;
import com.agapsys.rcf.ActionRequest;
import com.agapsys.rcf.WebAction;

public class Controller1 extends Controller {

	@WebAction
	public static void sGet() {  // <-- static method action
		System.out.println("Called!");
	}

    @WebAction
    public void get() {}

    @WebAction(mapping = "/*")
    public String rootWilcardGet(ActionRequest req) {
        return req.getPathInfo();
    }

    @WebAction(mapping = "/wildcard/*")
    public String wildCargGet(ActionRequest req) {
        return req.getPathInfo();
    }

}
