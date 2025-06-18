package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Actor;
import com.nt.service.IActorMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ActorOperationController {

	@Autowired
	private IActorMgmtService actorService;

	// main page
	@GetMapping("/")
	public String showHome() {
		System.out.println("ActorOperationController.showHome()");
		// return LVN
		return "welcome";
	}

	// getting all Actors
	@GetMapping("/report")
	public String showActorData(Map<String, Object> map) {
		// use service
		Iterable<Actor> itActors = actorService.getAllActors();
		// put result in model attribute
		map.put("actorList", itActors);
		// return LVN
		return "show_actor_report";
	}

	// show the form page of Add Employee Operation
	@GetMapping("/actor_add")
	public String showFormForSaveActor(@ModelAttribute("act") Actor act) {
		return "register_actor";

	}

	// to perform add operation task releated form submission operation
	@PostMapping("/actor_add")
	public String saveActor(@ModelAttribute("act") Actor act, Map<String, Object> map) {
		// use service
		String msg = actorService.registerActor(act);
		Iterable<Actor> itActors = actorService.getAllActors();
		// keep the result int model Attribute
		map.put("resultMsg", msg);
		map.put("actorList", itActors);

		// return LVN
		return "show_actor_report";
	}

	/*Example-2 Best - [Using Flash Attribute of Redirect Attrribute Object]
		[special shared memory which hold the attributes only during 	coarse of Redirection. Once the redirection is over 
		Attributes in the special shared Memory will be vanished..so these attributes are called flash attributes]	
	*/
	@PostMapping("/act_add")
	public String saveActorToRedirect(@ModelAttribute("act") Actor act, RedirectAttributes attrs) {

		System.out.println("ActorOperationController.saveActor()");

		// use service
		String msg = actorService.registerActor(act);
		// keep the result in the flask attribute
		attrs.addFlashAttribute("resultMsg", msg);
		// return LVN
		return "redirect:actor_report";

	}

	@GetMapping("/actor_report")
	public String showActorReport(Map<String, Object> map) {
		System.out.println("ActorOperationController.showActorReport()");

		// use service
		Iterable<Actor> itActors = actorService.getAllActors();

		// put the result in the model attribute
		map.put("actorList", itActors);
		// return LVN
		return "show_actor_report";

	}

	// ====================================================
	// edit the Actor Form page
	@GetMapping("/act_edit")
	public String showEditActorFormPage(@RequestParam("id") Integer id, @ModelAttribute("act") Actor act) {
		// use Service
		Actor act1 = actorService.getActorByid(id);
		// copy data
		BeanUtils.copyProperties(act1, act);
		// return LVN
		return "actor_edit_form";
	}
	
	// edit Actor form page submission related request
	@PostMapping("/act_edit")
	public String editActor(RedirectAttributes attrs, @ModelAttribute("act") Actor act) {
	
		// 1. Fetch the existing actor from DB
		Actor existingActor = actorService.getActorByid(act.getAid());
	
		// 2. Copy updated values from form to the existing entity
		BeanUtils.copyProperties(act, existingActor, "id", "createdDate", "createdBy", "updateCount");
	
		// 3. Save the updated entity
		String msg = actorService.updateActor(existingActor);
	
		// Reuse save method
		attrs.addFlashAttribute("resultMsg", msg);
		// redirect
		return "redirect:actor_report";
	}

	@GetMapping("/act_delete")
	public String delectActor(RedirectAttributes attrs, @RequestParam("id") Integer id) {
		String msg = actorService.delectActor(id);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:actor_report";
	}

}
