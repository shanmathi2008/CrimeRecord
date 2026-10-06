package com.CrimeRecord.CrimeRecord;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CrimeController {

    private final CrimeRepository crimeRepository;

    public CrimeController(CrimeRepository crimeRepository) {
        this.crimeRepository = crimeRepository;
    }

    @PostMapping("/save-crime")
    public String saveCrime(@ModelAttribute Crime crime) {
        crimeRepository.save(crime);
        return "redirect:/dashboard";
    }
}