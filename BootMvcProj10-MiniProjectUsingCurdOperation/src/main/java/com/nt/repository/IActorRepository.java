package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Actor;

@Repository
public interface IActorRepository extends JpaRepository <Actor, Integer> {

}
