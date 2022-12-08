### SpringBoot Workspace


<---------------------------------- RESPONSE CONTROLLER ---------------------------------------------------->
package com.optum.basics.administrationutility.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object object) {
		ResponseMessageWrapper response = new ResponseMessageWrapper(object, message, status);
		return new ResponseEntity<Object>(response, status);
	}

}

Link : https://medium.com/codestorm/custom-json-response-with-responseentity-in-spring-boot-b09e87ab1f0a

<---------------------------------- API CONTROLLER ---------------------------------------------------->
@GetMapping("/Groups")
public ResponseEntity<Object> getGroups() {
		List<Group> groups = this.groupService.getGroups();
		if (groups.size() > 0) {
			return ResponseHandler.generateResponse("Found User Groups", HttpStatus.OK, groups);
		} else {
			return ResponseHandler.generateResponse("No User Groups found", HttpStatus.NOT_FOUND, null);
		}
	}
