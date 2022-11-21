// If it is "/" : Path Variable
// If it is "?" : Request Parameter

//<-------------------------------------------------- Jackson ----------------------------------------------------------->
// RequestBody ---> Converts Raw Data (JSON Format / XML File) from Client Side(Postman) to String Data in Server Side to be stored in Database
// ResponseBody ---> Converts String Data from Server Side to JSON Format / XML File in Client Side(Postman)
package com.app.WebApp.Controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.WebApp.Interface.AlienRepo;
import com.app.WebApp.Java.Alien;

//@RestController
@Controller
public class AlienController {
	 
	@Autowired
	AlienRepo crud;
	
	// Request Mapping --> For Path
	@RequestMapping("/")// RequestMapping("/...")  --> Client sends Request to Server for path "/",Server responds by taking it to "home.jsp"
	public String show() {
		return "home.jsp"; // Shows Webpage for Particular Path
	}

	
	// As we are now in "home.jsp" and when we input our values and click on submit and it changespath to "/addAlien?...." with some params
	@RequestMapping("/addAlien") // Should be same as Form Actionn Ex: http://localhost:9045/addAlien?aid=101&aname=Yash
	public String getAlien(Alien obj) { // Data coming from Client in WebApp will be assigned to Object as Params
		crud.save(obj); // Datas will be saved to Database
		System.out.println("Object of Alien : "+obj); //Ex : Alien [aid=101,aname=Biswa] ,We get it as String from Alien Class...so,Alien is "Entity" and aid,aname is Fields as "Id" with respective values stored in Database
		return "home.jsp";
	}
	
	
	@RequestMapping("/getAlien") // Should be same as Form Action
	public ModelAndView showAlien1(@RequestParam int aid) { // Data coming from Client in WebApp will be assigned to Object
//		
		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		
		Alien obj = crud.findById(aid).orElse(new Alien());
		System.out.println("Object of Alien : "+obj); 
		System.out.println("From Client : ID -> " + obj.getAid() + " Name -> " + obj.getAname());
		mv.addObject("Object",obj);
//		
//		System.out.println(crud.findByAname("Yash"));
//  	System.out.println(crud.findByAnameSorted("Yash"));
//		System.out.println(crud.findByAid(101));
//		System.out.println(crud.findByAidGreaterThan(102));
//		System.out.println(crud.findByAidLessThan(104));
//		
		return mv;
	}
	
	
	@RequestMapping("/viewAliens")
	@ResponseBody
	public String showsAliens() {
		return crud.findAll().toString(); // In String Format

	}
	
	@RequestMapping("/viewAliens/{x}")
	@ResponseBody
	public String showsAlien(@PathVariable("x")int y) {
		return crud.findByAid(y).toString(); // In String Format

	}
	
	// <-------------------------------------------- POST ----------------------------------------------------->
	// In Postman : Client sends Data to Server through '/AlienPost'
	@PostMapping("/AlienPOST") // PostMapping("/....")--> Client Sends POST Request to Server
	@ResponseBody
//	@RequestMapping(path="/Alien",consumes= {"application/xml"}) // Consumes means We will only be accepting Data from Client in XML Format
	public Alien post(@RequestBody Alien alien) { // Data coming from Client in WebApp will be assigned to Object //RequestBody ---> Converts Raw Data (JSON Format) from Postman to String Data then Stored in Database  
		
		Alien obj1 = crud.save(alien); // Datas will be saved to Database
		System.out.println("Alien : "+alien);
		System.out.println("Object : "+obj1);
		System.out.println("From Client : ID -> " + alien.getAid() + " Name -> " + alien.getAname());
		
		return alien;
	}
	
	
//	@RequestMapping("/getAlien") // Should be same as Form Action
//	public ModelAndView showAlien(@RequestParam int aid) { // Data coming from Client in WebApp will be assigned to Object
//		
//		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		
//		Alien obj = crud.findById(aid).orElse(new Alien());
//		System.out.println("From Client : ID -> " + obj.getAid() + " Name -> " + obj.getAname());
//		mv.addObject("Object",obj);
//		
//		System.out.println(crud.findByAname("Yash"));
//	//	System.out.println(crud.findByAnameSorted("Yash"));
//
//		System.out.println(crud.findByAid(101));
//		System.out.println(crud.findByAidGreaterThan(102));
//		System.out.println(crud.findByAidLessThan(104));
//
//		System.out.println("Hello World");
//		
//		return mv;
//	}
	
	//<----------------------------------------------- PUT ---------------------------------------------------------------->
	@PutMapping("/AlienPUT")
	@ResponseBody
	public Alien getUpdate(@RequestBody Alien alien) { 
		
		Alien obj2 = crud.save(alien); 
		System.out.println(alien);
	    System.out.println("From Client : ID -> " + obj2.getAid() + " Name -> " + obj2.getAname());

		return alien;
	}
	
	//<------------------------------------------------ DELETE ------------------------------------------------------------->
	@DeleteMapping("/AlienDEL/{aid}")
	public String del(@PathVariable("aid") int aid) {
		
		crud.deleteById(aid);
		return "Deleted";
		
	}
	
	// <----------------------------------------------- GET ALL ------------------------------------------------------------>
//	@RequestMapping("/Aliens")
//	@RequestMapping(path="/Aliens",produces= {"application/xml"}) // Produces : We will only be producing Data in XML Format on Client Side
	
	@GetMapping("/Aliens") // GetMapping("/....")--> Client Sends GET Request to Server
	@ResponseBody
//	public Iterable<Alien> showAliens() { // Return Type will be in JSON Format due to Jackson
	
		public String showAliens() {

		System.out.println("Without Conversion to String Type : " + crud.findAll());
		System.out.println("After Conversion to String Type :  " + crud.findAll().toString());
		
		return crud.findAll().toString(); // Ex : [Alien [aid=101, aname=Biswa], Alien [aid=102, aname=Yash], Alien [aid=103, aname=Tushar]

//		return crud.findAll(); // Ex : [Alien [aid=101, aname=Biswa], Alien [aid=102, aname=Yash], Alien [aid=103, aname=Tushar],Converted to JSON due to Jackson
	}
	
	//<------------------------------------------------- GET ID ----------------------------------------------------------->
	
	@RequestMapping("/Aliens/{ash}")
	@ResponseBody
	public Optional<Alien> showAlien(@PathVariable("ash") int aid) {
//		public String showAlien(@PathVariable("aid") int aid) {

//		return crud.findById(aid).toString();
	    
		return crud.findById(aid); // In JSON Format
	}	
	
}


