package com.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select count(u) from User u where u.email = :email and u.mobile = :mobile")
	public int findByEmailAndMobile(@Param("email") String email,@Param("mobile") String mobile);
	
	@Query("select count(u) from User u where u.mobile = :mobile")
	public int findByMobile(@Param("mobile") String mobile);
	
	@Query("select count(u) from User u where u.email = :email")
	public int findByEmail(@Param("email") String email);
	
	@Query("select password from User u where u.mobile = :mobile")
	public String fetchByMobile(@Param("mobile") String mobile);
	
}