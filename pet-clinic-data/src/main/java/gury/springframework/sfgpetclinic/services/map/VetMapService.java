package gury.springframework.sfgpetclinic.services.map;

import gury.springframework.sfgpetclinic.model.Speciality;
import gury.springframework.sfgpetclinic.model.Vet;
import gury.springframework.sfgpetclinic.services.SpecialityService;
import gury.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().size()>0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId()==null){
                    Speciality savedSpecality=specialityService.save(speciality);
                    speciality.setId(savedSpecality.getId());
                }
            });
        }


        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }

}
