package com.midsem_PCSMA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
@Autowired FifaUpdateRepository mongofifa;
@Autowired CricUpdateRepository mongocric;
	
	
	@RequestMapping(value = "/fifaShowDetails", method = RequestMethod.GET)
	public @ResponseBody List<FifaUpdate> getAllUser(
			) {
		
		return mongofifa.findAll();
		
	}
	@RequestMapping(value = "/cricShowDetails", method = RequestMethod.GET)
	public @ResponseBody List<CricUpdate> getCricUser(
			) {
		
		return mongocric.findAll();
		
	}
	
	@RequestMapping(value = "/fifaDetails", method = RequestMethod.GET)
	public String getAllUser(
		@RequestParam("club")String club,
		@RequestParam("team1")String team1,
		@RequestParam("team1Goals")int team1Goals,
		@RequestParam("team2")String team2,
		@RequestParam("team2Goals")int team2Goals,
		@RequestParam("winner")String winner,
		@RequestParam("date")String date,
		@RequestParam("playerOfMatch")String playerOfMatch,
		Model model
		
			) {
				
		FifaUpdate fifa = new FifaUpdate();
		
		fifa.setClub(club);
		fifa.setTeam1(team1);
		fifa.setTeam1Goals(team1Goals);
		fifa.setTeam2(team2);
		fifa.setTeam2Goals(team2Goals);
		fifa.setWinner(winner);
		fifa.setDate(date);
		fifa.setPlayerOfMatch(playerOfMatch);
		
		mongofifa.save(fifa);
		
		//return mongo.findAll();
		return "redirect:/index";
		
	}
	
	/*@RequestMapping(value = "/addDetails", method = RequestMethod.GET)
	public List<FifaUpdate) getAllUser(
		@RequestParam("club")String club,
		@RequestParam("team1")String team1,
		@RequestParam("team1Goals")int team1Goals,
		@RequestParam("team2")String team2,
		@RequestParam("team2Goals")int team2Goals,
		@RequestParam("winner")String winner,
		@RequestParam("date")String date,
		@RequestParam("playerOfMatch")String playerOfMatch
		
		
			) {
				
		FifaUpdate fifa = new FifaUpdate();
		
		fifa.setClub(club);
		fifa.setTeam1(team1);
		fifa.setTeam1Goals(team1Goals);
		fifa.setTeam2(team2);
		fifa.setTeam2Goals(team2Goals);
		fifa.setWinner(winner);
		fifa.setDate(date);
		fifa.setPlayerOfMatch(playerOfMatch);
		
		mongo.save(fifa);
		
		return mongo.findAll();
		
		
	}*/
	
	@RequestMapping(value = "/cricDetails", method = RequestMethod.GET)
	public List<CricUpdate> getCricUser(
		@RequestParam("team1")String team1,
		@RequestParam("scores1")int scores1,
		@RequestParam("team2")String team2,
		@RequestParam("scores2")int scores2,
		@RequestParam("winner")String winner,
		@RequestParam("date")String date,
		@RequestParam("playerOfMatch")String playerOfMatch,
		Model model
		
			) {
				
		CricUpdate cric = new CricUpdate();
		
		
		cric.setTeam1(team1);
		cric.setScores1(scores1);
		cric.setTeam2(team2);
		cric.setScores2(scores2);
		cric.setWinner(winner);
		cric.setDate(date);
		cric.setPlayerOfMatch(playerOfMatch);
		
		mongocric.save(cric);
		
		return mongocric.findAll();
		//return "redirect:/index";
		
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(
		Model model,Pageable pageable
			) {
		
		
		model.addAttribute("fifaUpdate",mongofifa.limit10());
		
		return "index";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String Insert(
		Model model
			) {
		
		
		
		//model.addAttribute("students",mongo.findAll());
		return "Insert";
	}
}
