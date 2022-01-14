package org.springframework.samples.petclinic.recoveryroom;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
	@Autowired
	private RecoveryRoomService recoveryRoomService;

	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
		this.recoveryRoomService = recoveryRoomService;
	}

	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(Map<String, Object> model) {

		RecoveryRoom recoveryRoom = new RecoveryRoom();
		model.put("recoveryRoom", recoveryRoom);
		model.put("recoveryRoom", recoveryRoomService.getAllRecoveryRoomTypes());
		return "recoveryroom/reateOrUpdateRecoveryRoomForm";

	}
	
	@PostMapping(value="/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, Map<String, Object> model) {
		
		if(result.hasErrors()) {
			model.put("product", recoveryRoom);
			model.put("productType", recoveryRoomService.getAllRecoveryRoomTypes());
			return "recoveryroom/reateOrUpdateRecoveryRoomForm";
		}else {
			this.recoveryRoomService.save(recoveryRoom);
			return "welcome";
		}
	}
}
