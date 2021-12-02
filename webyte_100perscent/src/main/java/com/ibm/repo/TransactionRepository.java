/**
* This class describes the repository of Transaction.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.model.entities.TransactionModel;

public interface TransactionRepository extends JpaRepository<TransactionModel, Integer>{

}
