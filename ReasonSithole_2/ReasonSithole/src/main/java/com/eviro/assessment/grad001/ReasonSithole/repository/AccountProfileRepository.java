package com.eviro.assessment.grad001.ReasonSithole.repository;

import com.eviro.assessment.grad001.ReasonSithole.model.AccountProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//this helps to store the data in the database
@Repository
public interface AccountProfileRepository extends JpaRepository<AccountProfile, Long> {
    //using this function to search on the database
    AccountProfile findBynameAndSurname(String name, String surname);

}