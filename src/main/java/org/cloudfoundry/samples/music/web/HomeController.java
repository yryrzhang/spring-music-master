package org.cloudfoundry.samples.music.web;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/home")
public class HomeController {
	@Value("${services.test-service-key5.username}")
	private String migrationVal;

	@Value("${services.test-service-key5.password}")
	private String migrationPassword;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String home() {
		return "Welcome to Hello World! Value is [" + migrationVal + "] Password is ["+migrationPassword+"]";
	}

	@RequestMapping(value = "/env", method = RequestMethod.GET)
	@ResponseBody
	public String env() {
		String retVal = "";
		for (Map.Entry<String, String> env: System.getenv().entrySet()) {
			retVal += env.getKey() + ": " + env.getValue() + ",";
		}
		return retVal;
	}


}
