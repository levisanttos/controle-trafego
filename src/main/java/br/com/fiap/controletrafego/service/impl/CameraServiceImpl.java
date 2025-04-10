package br.com.fiap.controletrafego.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.fiap.controletrafego.dtos.CameraDTO;
import br.com.fiap.controletrafego.model.Camera;
import br.com.fiap.controletrafego.model.Semafaro;
import br.com.fiap.controletrafego.repository.CameraRepository;
import br.com.fiap.controletrafego.repository.SemafaroRepository;
import br.com.fiap.controletrafego.service.CameraService;
import br.com.fiap.controletrafego.service.SemafaroService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CameraServiceImpl implements CameraService {

	private final CameraRepository cameraRepository;
	
	private final SemafaroRepository semafaroRepository;
	
	private final ModelMapper modelMapper;
	
	@Override
	public List<CameraDTO> getCameras(Long idSemafaro) {
		return null;
	}

	@Override
	public CameraDTO save(Long idSemafaro, CameraDTO cameraDTO) {
		Semafaro semafaro = this.semafaroRepository.findById(idSemafaro).get();
		Camera camera = this.modelMapper.map(cameraDTO, Camera.class);
		camera.setSemafaro(semafaro);
		camera.setDataInstalacao(LocalDate.now());
		camera = this.cameraRepository.save(camera);
		cameraDTO.setId(camera.getId());
		
		return cameraDTO;
	}

	@Override
	public CameraDTO update(Long idSemafaro, Long idCamera, CameraDTO cameraDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long idSemafaro, Long idCamera) {
		// TODO Auto-generated method stub

	}

	@Override
	public CameraDTO getById(Long idSemafaro, Long idCamera) {
		// TODO Auto-generated method stub
		return null;
	}

}
