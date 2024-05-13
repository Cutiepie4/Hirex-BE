package com.ptit.Hirex.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ptit.Hirex.entity.SaveWork;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.entity.Work;

@Repository
public interface SaveWorkRepository extends JpaRepository<SaveWork, Long>{
	SaveWork findByUserAndWork(User user, Work work);

	List<SaveWork> findByUser(User user);
	
	@Query("SELECT sw.work.id " + 
			"FROM SaveWork sw " +
	        "GROUP BY sw.work.id " +
			"ORDER BY COUNT(sw.work.id) DESC " + 
	        "LIMIT 3") 
	List<Integer> findTop3MostFrequentWorkIds();
}
