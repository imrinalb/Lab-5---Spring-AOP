package edu.miu.waa_lab5_v1.controller;

import edu.miu.waa_lab5_v1.aspect.annotation.ExecutionTime;
import edu.miu.waa_lab5_v1.dto.ActivityLogDto;
import edu.miu.waa_lab5_v1.model.ActivityLog;
import edu.miu.waa_lab5_v1.service.IActivityLogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/activelog")
public class ActivityLogController {

    @Autowired
    private ModelMapper mp;

    IActivityLogService activityLogService;

    public ActivityLogController(IActivityLogService activityLogService) {
        super();
        this.activityLogService = activityLogService;
    }

    @ExecutionTime
    @GetMapping
    public List<ActivityLogDto> getAll() {
        return activityLogService.getAllActivityLog().stream().map(a -> mp.map(a, ActivityLogDto.class))
                .collect(Collectors.toList());
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public ResponseEntity<ActivityLogDto> getById(@PathVariable int id) {
        Optional<ActivityLog> activityLog = activityLogService.getById(id);
        ActivityLogDto activityLogDto = mp.map(activityLog, ActivityLogDto.class);
        return ResponseEntity.ok().body(activityLogDto);
    }

    @ExecutionTime
    @PostMapping
    public ResponseEntity<ActivityLogDto> createActivityLog(@RequestBody ActivityLogDto activityLogDto)  {
        // convert DTO to entity
        ActivityLog logRequest = mp.map(activityLogDto, ActivityLog.class);
        ActivityLog log = activityLogService.createActivityLog(logRequest);
        // convert entity to DTO
        ActivityLogDto logResponse = mp.map(log, ActivityLogDto.class);
        return new ResponseEntity<ActivityLogDto>(logResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ActivityLogDto> updateActivityLog(@RequestBody ActivityLogDto activityLogDto)  {
        // convert DTO to entity
        ActivityLog logRequest = mp.map(activityLogDto, ActivityLog.class);
        ActivityLog log = activityLogService.createActivityLog(logRequest);
        // convert entity to DTO
        ActivityLogDto logResponse = mp.map(log, ActivityLogDto.class);
        return new ResponseEntity<ActivityLogDto>(logResponse, HttpStatus.CREATED);
    }

    @ExecutionTime
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable(name = "id") int id) {
        activityLogService.deleteById(id);
        return "Delete success!!!";
    }
}
