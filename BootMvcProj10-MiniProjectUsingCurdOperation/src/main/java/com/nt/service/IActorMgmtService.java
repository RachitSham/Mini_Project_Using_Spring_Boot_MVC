package com.nt.service;

import com.nt.entity.Actor;

public interface IActorMgmtService {

	public Iterable<Actor> getAllActors();

	public String registerActor(Actor act);

	public Actor getActorByid(Integer id);

	public String updateActor(Actor act);

	public String delectActor(Integer id);

}
