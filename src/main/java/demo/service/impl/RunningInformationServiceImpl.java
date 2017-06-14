package demo.service.impl;


import demo.domain.RunningInformation;

import demo.domain.RunningInfortmaionRep;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunningInformationServiceImpl implements RunningInformationService{
    @Autowired
    private RunningInfortmaionRep runningInfortmaionRep;

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformationList){
        return this.runningInfortmaionRep.save(runningInformationList);
    }

    @Override
    public void deleteAll(){
        this.runningInfortmaionRep.deleteAll();
    }

    @Override
    public Page<RunningInformation> findAll(Pageable pageable){
        return this.runningInfortmaionRep.findAll(pageable);
    }

    @Override
    public void deleteByRunningId(String runningId){
        this.runningInfortmaionRep.delete(runningId);
    }

    @Override
    public Page<RunningInformation> findAllByRunningId(String runningId, Pageable pageable){
        return this.runningInfortmaionRep.findAllByRunningId(runningId, pageable);
    }
}
