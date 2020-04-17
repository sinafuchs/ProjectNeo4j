package ch.sixgroup.demo.neo4JProjekt.domainModels.apprentice;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.NoSuchElementException;

public class ApprenticeServiceImpl  implements ApprenticeService {

    private ApprenticeRepository apprenticeRepository;

    @Autowired
    public ApprenticeServiceImpl(ApprenticeRepository apprenticeRepository) {
        this.apprenticeRepository = apprenticeRepository;
    }

    @Override
    public Apprentice create(Apprentice apprentice) {
        return apprenticeRepository.save(apprentice);
    }

    @Override
    public List<Apprentice> findAll() {
        return (List<Apprentice>) apprenticeRepository.findAll();
    }

    @Override
    public Apprentice findById(int id) {
        return apprenticeRepository.findById(id).get();
    }

    @Override
    public Apprentice updateById(int id, Apprentice apprentice) {
        if(apprenticeRepository.existsById(id)) {
            apprentice.setId((long) id);
            apprenticeRepository.save(apprentice);

            return apprentice;
        } else {
            throw new NoSuchElementException("No value");
        }
    }

    @Override
    public void deleteById(int id) {
        apprenticeRepository.deleteById(id);
    }
}


