package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ScrollController {

	static Score score = new Score(30, 20, 10);
	
	@PutMapping("/score")
	public Score replaceScore(@RequestBody Score newScore) {
		score = newScore;
		return score;
	}
	
	
	@DeleteMapping("/score")
	public void deleteScore() {
		score =null;
	}
	
	@PatchMapping("score/wins")
	public Score updateWins(@RequestParam(name="new-value")int newValue) {
		score.wins = newValue;
		return score;
	}

	@GetMapping("/health-check")
	public String getHealthCheck() {
		return "Situation normal all fired up";
	}
	
	@PostMapping("/score/wins")
	public Score increaseWins() {
		score.wins++;
		return score;
	}
	
	@PostMapping("/score/losses")
	public Score increaseLosses() {
		score.losses++;
		return score;
	}
	
	@PostMapping("/score/ties")
	public Score increaseTies() {
		score.ties++;
		return score;
	}

	@GetMapping("/score")
	public Score getScore() {
		return score;
	}

	@GetMapping("/score/{winslossesorties}")
	public int getWinsLossesorTies(@PathVariable String winslossesorties) {
		if (winslossesorties.equalsIgnoreCase("wins")) {
			return score.wins;
		}
		if (winslossesorties.equalsIgnoreCase("ties")) {

			return score.ties;
		}
		return score.losses;
	}
}
//if we dont want to use different methods for each variables likr getWins, getLosses then you can use @PathVariables

/*
 * @GetMapping("/score/wins") public int getWins() { return score.wins; }
 * 
 * @GetMapping("/score/losses") public int getLosses() { return score.losses; }
 * 
 * @GetMapping("/score/ties") public int getTies() { return score.ties; }
 * 
 */
