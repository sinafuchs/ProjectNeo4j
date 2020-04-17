package ch.sixgroup.demo.neo4JProjekt.domainModels.apprentice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/apprentices")
public class ApprenticeController {

    private ApprenticeService apprenticeService;

    @Autowired
    public ApprenticeController(ApprenticeService apprenticeService) {
        this.apprenticeService = apprenticeService;
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Apprentice> create(@RequestBody Apprentice apprentice) {
        return new ResponseEntity<>(apprenticeService.create(apprentice), HttpStatus.CREATED);
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<Apprentice>> getAll() {
        return new ResponseEntity<>(apprenticeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apprentice> getById(@PathVariable int id) {
        return new ResponseEntity<>(apprenticeService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apprentice> updateById(@PathVariable int id, @RequestBody Apprentice apprentice) {
        return new ResponseEntity<>(apprenticeService.updateById(id, apprentice), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        apprenticeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
