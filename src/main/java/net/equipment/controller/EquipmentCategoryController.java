//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.equipment.controller;

import java.util.List;
import net.equipment.dto.AddEquipmentCategoryRequest;
import net.equipment.models.EquipmentCategory;
import net.equipment.services.EquipmentCategoryService;
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
@RequestMapping({"/api/EquipmentCategory"})
public class EquipmentCategoryController {
    private final EquipmentCategoryService equipmentCategoryService;

    @PostMapping
    public ResponseEntity<EquipmentCategory> createEquipmentCategory(@RequestBody AddEquipmentCategoryRequest equipmentCategory) {
        EquipmentCategory newEquipmentCategory = this.equipmentCategoryService.addEquipmentCategory(equipmentCategory);
        return new ResponseEntity(newEquipmentCategory, HttpStatus.CREATED);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<EquipmentCategory> getEquipmentCategoryById(@PathVariable("id") Long equipmentCategoryId) {
        EquipmentCategory equipment = this.equipmentCategoryService.getEquipmentCategoryById(equipmentCategoryId);
        return ResponseEntity.ok(equipment);
    }

    @GetMapping
    public ResponseEntity<List<EquipmentCategory>> getAllEquipmentCategory() {
        List<EquipmentCategory> companies = this.equipmentCategoryService.getAllEquipmentCategory();
        return ResponseEntity.ok(companies);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteEquipmentCategory(@PathVariable("id") Long equipmentCategoryId) {
        this.equipmentCategoryService.deleteEquipment(equipmentCategoryId);
        return ResponseEntity.ok("equipment deleted successfully");
    }

    public EquipmentCategoryController(final EquipmentCategoryService equipmentCategoryService) {
        this.equipmentCategoryService = equipmentCategoryService;
    }
}
