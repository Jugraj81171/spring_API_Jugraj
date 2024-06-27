package code.pragra.learning.spring_api_jugraj.Controller;

import code.pragra.learning.spring_api_jugraj.Entities.Hospital;
import code.pragra.learning.spring_api_jugraj.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class HospitalController
{

    @Autowired
    HospitalService hospitalService;

    @GetMapping("/getNursesData")
    public List<Hospital> getHospitalRecord()
    {
        return hospitalService.getHospitalRecord();

    }

    @PostMapping("/addNurseData")
    public ResponseEntity<String> addNurseData(@RequestBody Hospital hospital)
    {

       hospitalService.addNurseData(hospital);
       return new ResponseEntity<>("Hospital record is saved successfully", HttpStatus.OK);

    }
    @PostMapping("/addMultipleNursesData")
    public ResponseEntity<String> addMultipleNursesData(@RequestBody List<Hospital> hospital)
    {
       hospitalService.addMultipleNursesData(hospital);

       return new ResponseEntity<>("Hospital record is saved successfully", HttpStatus.OK);
    }

    @GetMapping("/getNurseRecordById")
    public Optional<Hospital> getNurseRecordById(@RequestParam Integer nurseId)
    {
        return hospitalService.getNurseRecordById(nurseId);

    }

    @PutMapping("/updateHospitalRecord")
    public String updateHospitalRecord(@RequestBody Hospital hospital)
    {
        return hospitalService.updateHospitalRecord(hospital);
    }
    @PatchMapping("/updateNurseName")
    public String updateNurseName(@RequestParam Integer nurseId, String nurseFirstName)
    {
       if(hospitalService.updateNurseName(nurseId, nurseFirstName))
       {
           return "Hospital record is saved successfully";
       }
       else
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital record not found");

    }
    @DeleteMapping("/deleteRecordById")
    public String deleteRecordById(@RequestParam Integer nurseId)
    {
        return hospitalService.deleteRecordById(nurseId);

    }


}
