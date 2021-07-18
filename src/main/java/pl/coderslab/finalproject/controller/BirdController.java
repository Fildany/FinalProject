package pl.coderslab.finalproject.controller;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.entity.Bird;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.repository.BirdRepository;
import pl.coderslab.finalproject.repository.CityRepository;
import pl.coderslab.finalproject.repository.UserRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/birds")
@RequiredArgsConstructor
public class BirdController {

    private final BirdRepository birdRepository;
    private final CityRepository cityRepository;
    private final UserRepository userRepository;

    @GetMapping("/all")
    public String showPosts(Model model, Principal principal) {
        List<Bird> birds = birdRepository.findAllByUserEmail(principal.getName());
        model.addAttribute("birds", birds);
        return "birds/all";
    }

    @GetMapping("/add")
    public String createBirdsForm(Model model) {
        model.addAttribute("bird", new Bird());
        model.addAttribute("cities", cityRepository.findAllByOrderByName());
        return "birds/form";
    }

    @PostMapping("/add")
    public String createBirds(@Valid Bird bird, BindingResult bindingResult, Model model, Principal principal) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cities", cityRepository.findAllByOrderByName());
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "birds/form";
        }
        Optional<User> user = userRepository.findByEmail(principal.getName());
        Preconditions.checkState(user.isPresent(),"user not found");
        bird.setUser(user.get());
        birdRepository.save(bird);
        return "redirect:/birds/all";
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
        model.addAttribute("cities", cityRepository.findAllByOrderByName());
        return "birds/form";
    }

    @PostMapping("/{id}/edit")
    public String edit(@Valid Bird bird, BindingResult bindingResult, Model model, Principal principal) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cities", cityRepository.findAllByOrderByName());
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "birds/form";
        }
        Optional<User> user = userRepository.findByEmail(principal.getName());
        Preconditions.checkState(user.isPresent(),"user not found");
        bird.setUser(user.get());
        birdRepository.save(bird);
        return "redirect:/birds/all";
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



