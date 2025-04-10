package br.com.fiap.controletrafego.service;

import java.util.List;

import br.com.fiap.controletrafego.dtos.CameraDTO;

public interface CameraService {
	
	List<CameraDTO> getCameras(Long idSemafaro);
	
	CameraDTO save(Long idSemafaro, CameraDTO cameraDTO);
	
	CameraDTO update(Long idSemafaro, Long idCamera, CameraDTO cameraDTO);
	
	void delete(Long idSemafaro, Long idCamera);
	
	CameraDTO getById(Long idSemafaro, Long idCamera);

}
