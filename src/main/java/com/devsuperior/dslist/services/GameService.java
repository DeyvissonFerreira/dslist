package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		return gameRepository.findAll().stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		return new GameDTO(gameRepository.findById(id).get());
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByListId(Long listId) {
		return gameRepository.searchByList(listId).stream().map(x -> new GameMinDTO(x)).toList();
	}

}
