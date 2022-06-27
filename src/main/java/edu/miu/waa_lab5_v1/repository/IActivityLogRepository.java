package edu.miu.waa_lab5_v1.repository;

import edu.miu.waa_lab5_v1.model.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActivityLogRepository extends CrudRepository<ActivityLog, Integer> {
}
