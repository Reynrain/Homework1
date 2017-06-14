package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInformationController {
    @Autowired
    private RunningInformationService runningInformationService;

    @RequestMapping(value = "running_information", method = RequestMethod.GET)
    public Page<RunningInformation> findAllDescByHealthWarningLevel(@RequestParam("page") int page,
                                                                    @RequestParam(value = "size", required = false) Integer size){
        PageRequest request = new PageRequest(page, size == null ? 2 : size, Sort.Direction.DESC, "healthWarningLevel" );
        return runningInformationService.findAll(request);
    }

    @RequestMapping(value = "running_information/{running_id}", method = RequestMethod.GET)
    public  Page<RunningInformation> findAllByRunningId(@RequestParam("page") int page,
                                                        @RequestParam(value = "size", required = false) Integer size,
                                                        @PathVariable(name = "running_id") String running_id){
        PageRequest request = new PageRequest(page, size == null ? 2 : size, Sort.Direction.DESC, "healthWarningLevel");
        return runningInformationService.findAllByRunningId(running_id, request);
    }

    @RequestMapping(value = "running_information", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformationList){
        runningInformationService.saveRunningInformation(runningInformationList);
    }

    @RequestMapping(value = "running_information/{running_id}", method = RequestMethod.DELETE)
    public void  deleteByRunningId(@PathVariable(name = "running_id") String running_id) {
        runningInformationService.deleteByRunningId(running_id);
    }
}
