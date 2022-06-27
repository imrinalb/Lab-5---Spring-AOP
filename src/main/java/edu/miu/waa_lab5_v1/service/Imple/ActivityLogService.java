package edu.miu.waa_lab5_v1.service.Imple;

import edu.miu.waa_lab5_v1.model.ActivityLog;
import edu.miu.waa_lab5_v1.repository.IActivityLogRepository;
import edu.miu.waa_lab5_v1.service.IActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityLogService implements IActivityLogService {

    @Autowired
    IActivityLogRepository activityLogRepository;

    @Override
    public List<ActivityLog> getAllActivityLog() {
        return (List<ActivityLog>) activityLogRepository.findAll();
    }

    @Override
    public ActivityLog createActivityLog(ActivityLog activityLog) {
        activityLog.setDate(new Date());
        return activityLogRepository.save(activityLog);
    }

    @Override
    public ActivityLog updateActivityLog(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }

    @Override
    public Optional<ActivityLog> getById(int id) {
        return activityLogRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        activityLogRepository.deleteById(id);
    }
}
