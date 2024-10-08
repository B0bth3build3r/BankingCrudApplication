package com.example.CRUDApplication.repo;



import com.example.CRUDApplication.model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}