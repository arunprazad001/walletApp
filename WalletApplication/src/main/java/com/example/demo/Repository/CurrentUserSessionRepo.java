package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CurrentUserSession;

@Repository
public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession,Integer> {
     
	 @Query("SELECT c FROM CurrentUserSession c WHERE c.uuid = :uuid")
	public  CurrentUserSession findByUuid(@Param("uuid") String uuid);
	
}
