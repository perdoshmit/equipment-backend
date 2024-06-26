//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.equipment.controller;

import net.equipment.dto.JwtAuthenticationResponse;
import net.equipment.dto.SignInRequest;
import net.equipment.dto.SignUpRequest;
import net.equipment.services.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1"})
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping({"/signup"})
    public JwtAuthenticationResponse signup(@RequestBody SignUpRequest request) {
        return this.authenticationService.signup(request);
    }

    @PostMapping({"/signin"})
    public JwtAuthenticationResponse signin(@RequestBody SignInRequest request) {
        return this.authenticationService.signin(request);
    }

    public AuthenticationController(final AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}
