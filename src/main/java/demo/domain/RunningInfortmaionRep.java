package demo.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RunningInfortmaionRep extends JpaRepository<RunningInformation, String>{
    Page<RunningInformation> findAllByRunningId(String runningId, Pageable pageable);
}
