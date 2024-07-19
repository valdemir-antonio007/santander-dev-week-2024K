package me.dio.domain.service;

import me.dio.domain.model.Bootcamp;

public interface BootcampService {
    Bootcamp findbyId(Long id);

    Bootcamp create(Bootcamp bootcamp);
}
