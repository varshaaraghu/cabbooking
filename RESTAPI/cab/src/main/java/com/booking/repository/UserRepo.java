package com.booking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	
	
	@Query("select userid from User u where u.mobile = :mobile")
	public int findByMobile(@Param("mobile") String mobile);
	
}