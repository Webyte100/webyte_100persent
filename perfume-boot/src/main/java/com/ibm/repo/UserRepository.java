package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.entity.User;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
	User findUserByEmailAndPasswd(String email, String passwd);

    User findUserByPhoneNumber(long phoneNo);
}