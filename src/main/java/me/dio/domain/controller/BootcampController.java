package me.dio.domain.controller;

import me.dio.domain.model.Bootcamp;
import me.dio.domain.service.BootcampService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/bootcamps")
public class BootcampController {
    private final BootcampService bootcampService;

    public BootcampController(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bootcamp> findbyId(@PathVariable Long id){
        var bootcamp = bootcampService.findbyId(id);
        return ResponseEntity.ok(bootcamp);
    }

    @PostMapping("")
    public ResponseEntity<Bootcamp> create(@RequestBody Bootcamp bootcamptoCreate){
        var bootcamp = bootcampService.create(bootcamptoCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bootcamp.getId())
                .toUri();
        return ResponseEntity.created(location).body(bootcamp);
    }
}
