package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameListDTO> findAll(){
		return gameListRepository.findAll().stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameListDTO findById(Long id) {
		return new GameListDTO(gameListRepository.findById(id).get());
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int targetIndex) {
		List<GameMinProjection> list =  gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(targetIndex, obj);
		
		int min = sourceIndex < targetIndex ? sourceIndex : targetIndex;
		int max = sourceIndex < targetIndex ? targetIndex : sourceIndex;
		
		for(int i = min; i <=max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
