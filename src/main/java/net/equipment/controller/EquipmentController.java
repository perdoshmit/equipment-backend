//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.equipment.controller;

import java.util.List;
import net.equipment.dto.AddEquipmentRequest;
import net.equipment.models.Equipment;
import net.equipment.models.User;
import net.equipment.services.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/equipment"})
public class EquipmentController {
    private final EquipmentService equipmentService;

    @PostMapping
    public ResponseEntity<Equipment> createEquipment(@RequestBody AddEquipmentRequest equipment) {
        System.out.println("CONTROLLER" + String.valueOf(equipment));
        Equipment newEquipment = this.equipmentService.addEquipment(equipment);
        return new ResponseEntity(newEquipment, HttpStatus.CREATED);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable("id") Long equipmentId) {
        Equipment equipment = this.equipmentService.getEquipmentById(equipmentId);
        return ResponseEntity.ok(equipment);
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        List<Equipment> companies = this.equipmentService.getAllEquipment();
        return ResponseEntity.ok(companies);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteEquipment(@PathVariable("id") Long equipmentId) {
        this.equipmentService.deleteEquipment(equipmentId);
        return ResponseEntity.ok("equipment deleted successfully");
    }

    @PostMapping({"{equipmentId}/{userId}"})
    public ResponseEntity<Equipment> addUserToEquipment(@PathVariable("equipmentId") Long equipmentId, @PathVariable("userId") Long userId) {
        Equipment equipment = this.equipmentService.addUserToEquipment(equipmentId, userId);
        return ResponseEntity.ok(equipment);
    }

    @DeleteMapping({"remove/{equipmentId}"})
    public ResponseEntity<String> removeUserFromEquipment(@PathVariable("equipmentId") Long equipmentId) {
        this.equipmentService.removeUserFromEquipment(equipmentId);
        return ResponseEntity.ok("User removed From Equipment successfully");
    }

    @GetMapping({"user/{userId}"})
    public ResponseEntity<User> getUserAssignedToEquipment(@PathVariable("userId") Long userId) {
        User assignedUser = this.equipmentService.getUserAssignedToEquipment(userId);
        return ResponseEntity.ok(assignedUser);
    }

    public EquipmentController(final EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }
}
