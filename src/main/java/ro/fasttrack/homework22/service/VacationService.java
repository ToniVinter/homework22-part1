package ro.fasttrack.homework22.service;

import org.springframework.stereotype.Service;
import ro.fasttrack.homework22.VacationNoutFound;
import ro.fasttrack.homework22.model.Vacation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class VacationService {
    private final List<Vacation> vacations;

    public VacationService(List<Vacation> vacations) {
        this.vacations = new ArrayList<>(vacations);
    }

    public Vacation getVacationById(int id){
        return vacations.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElseThrow(() -> new VacationNoutFound("Could not found vacation"));
    }

    public List<Vacation> getAllVacation(){
        return Collections.unmodifiableList(vacations);
    }

    public List<Vacation> getVacationsFrom(String location){
        return vacations.stream()
                    .filter(v -> v.getLocation().equals(location))
                    .collect(Collectors.toList());
    }

    public List<Vacation> getVacationsWithPriceLowerThan(int price){
        return vacations.stream()
                .filter(v -> v.getPrice() < price)
                .collect(Collectors.toList());
    }

    public void addVacation(Vacation vacation){
        Vacation newVacation = new Vacation(vacations.size() + 1,vacation.getLocation(),vacation.getPrice(),vacation.getDuration());
        vacations.add(newVacation);
    }

    public Vacation deleteVacation(int id){
        Vacation vacationToDel = vacations.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElseThrow(()-> new VacationNoutFound("Vacation not found to delete"));

        vacations.remove(vacationToDel);
        return vacationToDel;

    }

    public Vacation replaceVacation(int id, Vacation vacation){
        Vacation replaceVacation = vacations.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElseThrow(()-> new VacationNoutFound("Vacation not found"));
        vacations.remove(replaceVacation);
        Vacation newVacation = new Vacation(replaceVacation.getId(), vacation.getLocation(), vacation.getPrice(), vacation.getDuration());
        vacations.add(id-1,newVacation);
        return newVacation;
    }
}
