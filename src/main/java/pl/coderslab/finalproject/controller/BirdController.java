package pl.coderslab.finalproject.controller;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.entity.Bird;
import pl.coderslab.finalproject.repository.BirdRepository;
import pl.coderslab.finalproject.repository.CityRepository;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/birds")
@RequiredArgsConstructor
public class BirdController {

    private final BirdRepository birdRepository;
    private final CityRepository cityRepository;

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Bird> birds = birdRepository.findAll();
        model.addAttribute("birds", birds);
        return "birds/all";
    }

    @GetMapping("/add")
    public String createBirdsForm(Model model) {
        model.addAttribute("bird", new Bird());
        model.addAttribute("cities", cityRepository.findAll());
        return "birds/form";
    }

    @PostMapping("/add")
    public String createBirds(Bird bird, Model model) {
        try {
            birdRepository.save(bird);
            return "redirect:/birds/all";
        } catch (ConstraintViolationException e) {
            model.addAttribute("bird", bird);
            model.addAttribute("cities", cityRepository.findAll());
            model.addAttribute("error", e);
            return "birds/form";
        }
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable long id, Model model) {
        Optional<Bird> bird = birdRepository.findById(id);
        Preconditions.checkState(bird.isPresent(), "Bird id: %s not found", id);
        model.addAttribute("birds", bird.get());
        return "birds/details";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Optional<Bird> bird = birdRepository.findById(id);
        Preconditions.checkState(bird.isPresent(), "Bird id: %s not found", id);
        model.addAttribute("bird", bird.get());
        model.addAttribute("cities", cityRepository.findAll());
        return "birds/form";
    }

    @PostMapping("/{id}/edit")
    public String edit(Bird bird, Model model) {
        try {
            birdRepository.save(bird);
            return "redirect:/birds/all";
        } catch (ConstraintViolationException e) {
            model.addAttribute("bird", bird);
            model.addAttribute("cities", cityRepository.findAll());
            model.addAttribute("error", e);
            return "birds/form";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteForm(@PathVariable long id, Model model) {
        Optional<Bird> bird = birdRepository.findById(id);
        Preconditions.checkState(bird.isPresent(), "Bird id: %s not found", id);
        model.addAttribute("bird", bird.get());
        return "birds/delete";
    }

    @GetMapping("/{id}/delete/confirm")
    public String delete(@PathVariable long id) {
        birdRepository.deleteById(id);
        return "redirect:/birds/all";
    }

    @GetMapping("/{id}/delete/cancel")
    public String deleteCancel(@PathVariable long id) {
        return "redirect:/birds/all";
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable long id, Model model) {
        Optional<Bird> bird = birdRepository.findById(id);
        Preconditions.checkState(bird.isPresent(), "Bird id: %s not found", id);
        model.addAttribute("bird", bird.get());
        return "birds/details";
    }
}



