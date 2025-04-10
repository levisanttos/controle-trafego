package br.com.fiap.controletrafego.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.controletrafego.model.Camera;

public interface CameraRepository extends JpaRepository<Camera, Long> {

}
