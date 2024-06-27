package code.pragra.learning.spring_api_jugraj.Service;
import code.pragra.learning.spring_api_jugraj.Entities.Hospital;
import code.pragra.learning.spring_api_jugraj.Repository.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    HospitalRepo hospitalRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Hospital> getHospitalRecord()
    {
        return hospitalRepo.findAll();

    }


    public void addNurseData(Hospital hospital)
    {
            String encodedPassword = bCryptPasswordEncoder.encode(hospital.getNursePassword());
            hospital.setNursePassword(encodedPassword);
            hospitalRepo.save(hospital);
    }

    public void addMultipleNursesData(List<Hospital> hospital)
    {
        hospitalRepo.saveAll(hospital);
    }

     public Optional<Hospital> getNurseRecordById(Integer nurseId) {
         return hospitalRepo.findById(nurseId);

     }

     public String updateHospitalRecord(Hospital hospital)
     {
        if(hospitalRepo.existsById(hospital.getNurseId()))
        {
            hospitalRepo.save(hospital);
            return "record saved successfully";
        }
        else
            return "No record found";
     }

     public boolean updateNurseName(Integer nurseId, String nurseFirstName)
     {
         if(hospitalRepo.existsById(nurseId))
         {
             Optional<Hospital> nurseRecord = hospitalRepo.findById(nurseId);
             nurseRecord.get().setNurseFirstName(nurseFirstName);
             hospitalRepo.save(nurseRecord.get());
             return true;
         }
         else
            return false;

     }

     public String deleteRecordById(Integer nurseId)
     {
         if(hospitalRepo.existsById(nurseId)){
             hospitalRepo.deleteById(nurseId);
             return "Nurse record with id " + nurseId + " is deleted";
         }
         else
            return "Nurse Record not found";
     }



}
