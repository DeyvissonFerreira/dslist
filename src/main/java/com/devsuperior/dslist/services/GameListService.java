package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	public List<GameListDTO> findAll(){
		return gameListRepository.findAll().stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameListDTO findById(Long id) {
		return new GameListDTO(gameListRepository.findById(id).get());
	}


}
