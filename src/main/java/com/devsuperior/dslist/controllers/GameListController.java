package com.devsuperior.dslist.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		return gameListService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public GameListDTO findById(@PathVariable Long id){
		return gameListService.findById(id);
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByListId(@PathVariable Long listId){
		return gameService.findByListId(listId);
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public ResponseEntity<Map<String, String>> move(@PathVariable Long listId, @Valid @RequestBody ReplacementDTO body){
		gameListService.move(listId, body.getSourceIndex(), body.getTargetIndex());
		Map<String, String> success = new HashMap<>();
		success.put("sucess", "position updated.");
		return ResponseEntity.ok(success);
	}

}
