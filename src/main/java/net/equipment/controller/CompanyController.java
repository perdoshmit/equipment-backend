//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.equipment.controller;

import java.util.List;
import net.equipment.dto.CompanyDto;
import net.equipment.dto.CreateCompanyRequest;
import net.equipment.models.Company;
import net.equipment.models.User;
import net.equipment.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/companies"})
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody CreateCompanyRequest company) {
        Company newcompany = this.companyService.createCompany(company);
        return new ResponseEntity(newcompany, HttpStatus.CREATED);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<Company> getUserById(@PathVariable("id") Long companyId) {
        Company company = this.companyService.getCompanyById(companyId);
        return ResponseEntity.ok(company);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = this.companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @PutMapping({"{id}"})
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable("id") Long companyId, @RequestBody CompanyDto updatedCompany) {
        CompanyDto companyDto = this.companyService.updateCompany(companyId, updatedCompany);
        return ResponseEntity.ok(companyDto);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteCompany(@PathVariable("id") Long companyId) {
        this.companyService.deleteCompany(companyId);
        return ResponseEntity.ok("Company deleted successfully");
    }

    @GetMapping({"byAdmin/{id}"})
    public ResponseEntity<List<Company>> getCompanyByAdminId(@PathVariable("id") Long adminId) throws Exception {
        List<Company> companies = this.companyService.getCompanyByAdminId(adminId);
        return ResponseEntity.ok(companies);
    }

    @GetMapping({"employees/{id}"})
    public ResponseEntity<List<User>> getEmployees(@PathVariable("id") Long companyId) throws Exception {
        List<User> employees = this.companyService.getEmployees(companyId);
        return ResponseEntity.ok(employees);
    }

    @PostMapping({"employees/{companyId}/{userId}"})
    public ResponseEntity<List<User>> addEmployee(@PathVariable("companyId") Long companyId, @PathVariable("userId") Long userId) throws Exception {
        List<User> employees = this.companyService.addEmployee(companyId, userId);
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping({"employees/{companyId}/{userId}"})
    public ResponseEntity<List<User>> removeEmployee(@PathVariable("companyId") Long companyId, @PathVariable("userId") Long userId) throws Exception {
        List<User> employees = this.companyService.removeEmployee(companyId, userId);
        return ResponseEntity.ok(employees);
    }

    public CompanyController(final CompanyService companyService) {
        this.companyService = companyService;
    }
}
