package com.telagene;

import org.springframework.data.repository.CrudRepository;
import com.telagene.Analyse;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AnalyseRepository extends CrudRepository<Analyse, Integer> {

}
