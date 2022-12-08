### SpringBoot Workspace



### Response Controller
     public class ResponseHandler {
	 public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object object) {
		ResponseMessageWrapper response = new ResponseMessageWrapper(object, message, status);
		return new ResponseEntity<Object>(response, status);
	 }
     }
     return ResponseHandler.generateResponse("No User Groups found", HttpStatus.NOT_FOUND, object);

### Link : https://medium.com/codestorm/custom-json-response-with-responseentity-in-spring-boot-b09e87ab1f0a
