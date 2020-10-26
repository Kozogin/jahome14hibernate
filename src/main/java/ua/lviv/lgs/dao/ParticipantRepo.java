package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Level;
import ua.lviv.lgs.domain.Participant;

@Repository
public class ParticipantRepo {
	
	private List<Participant> participants = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		
		Participant participant1 = new Participant();
		participant1.setId(1);
		participant1.setName("Ivan");
		participant1.setEmail("ivan@mail.com");
		participant1.setLevel(Level.L3);
		participant1.setPrimarySkill("blacksmith");		
			participants.add(participant1);
			
		Participant participant2 = new Participant();
		participant2.setId(2);
		participant2.setName("Peter");
		participant2.setEmail("petian@mail.com");
		participant2.setLevel(Level.L1);
		participant2.setPrimarySkill("photographer");		
			participants.add(participant2);
			
		Participant participant3 = new Participant();
		participant3.setId(3);
		participant3.setName("Ostap");
		participant3.setEmail("osta@mail.com");
		participant3.setLevel(Level.L5);
		participant3.setPrimarySkill("teacher");		
			participants.add(participant3);		
		
	}
	
	public List<Participant> findAllParticipants() {
		return participants;
	}

	public Participant findOne(int id) {
		return participants.stream().filter(participant -> participant.getId() == id).findFirst().orElse(null);
	}

	public void save(Participant participant) {

		if (participant.getId() != null) {

			participants = participants.stream().peek(s -> {
				if (s.getId() == participant.getId()) {
					s.setParticipant(participant);
				}

			}).collect(Collectors.toList());
		} else {
			participant.setId(participants.get(participants.size() - 1).getId() + 1);
			participants.add(participant);
		}
	}

	public void delete(int id) {
		participants = participants.stream().filter(s -> s.getId() != id)
				.collect(Collectors.toList());		
	}
	

}
