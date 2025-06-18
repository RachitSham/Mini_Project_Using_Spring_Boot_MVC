package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service("actService")
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IActorRepository actorRepository;

	// getting All Actor
	@Override
	public Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	// Add the Actor
	@Override
	public String registerActor(Actor act) {
		return "Actor is Saved With Id Value: " + actorRepository.save(act).getAid();
	}

	// get the Actor by id
	@Override
	public Actor getActorByid(Integer id) {
		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Actor by this id is not found !!!"));
		return actor;

	}

	// update the actor by id
	@Override
	public String updateActor(Actor act) {
		act = actorRepository.save(act);

		return "Actor/Actoress " + act.getAname().toUpperCase()+act.getCategory() + " is edited whose ID number is " + act.getAid();

	}

	// delete the Actor by id
	@Override
	public String delectActor(Integer id) {
		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Actor not Found By this Id"));

		actorRepository.deleteById(id);
		return "Actor/Actoress " + actor.getAname().toUpperCase() + " is deleted whose ID number was " + actor.getAid();
	}

	
}
