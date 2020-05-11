package ro.fasttrack.homework22;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vacations")
public class VacationController {
    private final VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping
    public List<Vacation> getAllVacations(){
        return vacationService.getAllVacation();
    }

    @GetMapping("{id}")
    public Vacation getVacationById(@PathVariable int id){
        return vacationService.getVacationById(id);
    }

    @GetMapping(value = "/{location}")
    public List<Vacation> getVacationFrom(@PathVariable String location){
        return vacationService.getVacationsFrom(location);
    }

    @GetMapping(params = "{maxPrice}")
    public List<Vacation> getVacationLowerThan(@RequestParam int maxPrice){
        return vacationService.getVacationsWithPriceLowerThan(maxPrice);
    }

    @PostMapping()
    public void addVacation(@RequestBody Vacation vacation){
         vacationService.addVacation(vacation);
    }

    @PutMapping("{id}")
    public Vacation replaceVacation(@PathVariable int id, @RequestBody Vacation vacation){
        return vacationService.replaceVacation(id, vacation);
    }

    @DeleteMapping("{id}")
    public Vacation deleteVacation(@PathVariable int id){
        return vacationService.deleteVacation(id);
    }

}
