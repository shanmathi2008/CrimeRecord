package com.CrimeRecord.CrimeRecord;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CrimeRepository crimeRepository;
    private final SuspectRepository suspectRepository;
    private final InvestigationRepository investigationRepository;
    private final VictimWitnessRepository victimWitnessRepository;

    public HomeController(
            CrimeRepository crimeRepository,
            SuspectRepository suspectRepository,
            InvestigationRepository investigationRepository,
            VictimWitnessRepository victimWitnessRepository) {

        this.crimeRepository = crimeRepository;
        this.suspectRepository = suspectRepository;
        this.investigationRepository = investigationRepository;
        this.victimWitnessRepository = victimWitnessRepository;
    }


    // ================= DASHBOARD =================

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<Crime> crimes = crimeRepository.findAll();

        long totalCrimes = crimes.size();

        long activeCases = crimes.stream()
                .filter(crime ->
                        "Active".equalsIgnoreCase(
                                crime.getCaseStatus()))
                .count();

        long solvedCases = crimes.stream()
                .filter(crime ->
                        "Solved".equalsIgnoreCase(
                                crime.getCaseStatus()))
                .count();

        long underInvestigation = crimes.stream()
                .filter(crime ->
                        "Investigation".equalsIgnoreCase(
                                crime.getCaseStatus()))
                .count();

        model.addAttribute("crimes", crimes);
        model.addAttribute("totalCrimes", totalCrimes);
        model.addAttribute("activeCases", activeCases);
        model.addAttribute("solvedCases", solvedCases);
        model.addAttribute(
                "underInvestigation",
                underInvestigation);

        return "dashboard";
    }


    // ================= ADD CRIME =================

    @GetMapping("/add-crime")
    public String addCrime() {

        return "add-crime";
    }


    // ================= CRIME RECORDS =================

    @GetMapping("/crime-records")
    public String crimeRecords(Model model) {

        model.addAttribute(
                "crimes",
                crimeRepository.findAll());

        return "crime-records";
    }


    // ================= CASE DETAILS =================

    @GetMapping("/case-details/{caseId}")
    public String caseDetails(
            @PathVariable String caseId,
            Model model) {

        Crime crime =
                crimeRepository
                        .findById(caseId)
                        .orElse(null);

        if (crime == null) {

            return "redirect:/crime-records";
        }

        model.addAttribute("crime", crime);

        return "case-details";
    }


    // ================= SUSPECTS =================

    @GetMapping("/suspects")
    public String suspects(Model model) {

        model.addAttribute(
                "suspects",
                suspectRepository.findAll());

        return "suspects";
    }


    // ================= ADD SUSPECT =================

    @GetMapping("/add-suspect")
    public String addSuspect() {

        return "add-suspect";
    }


    // ================= SAVE SUSPECT =================

    @PostMapping("/save-suspect")
    public String saveSuspect(Suspect suspect) {

        suspectRepository.save(suspect);

        return "redirect:/suspects";
    }


    // ================= INVESTIGATION =================

    @GetMapping("/investigation")
    public String investigation(Model model) {

        List<Investigation> investigations =
                investigationRepository.findAll();

        model.addAttribute(
                "investigations",
                investigations);

        return "investigation";
    }


    // ================= ADD INVESTIGATION =================

    @GetMapping("/add-investigation")
    public String addInvestigation() {

        return "add-investigation";
    }


    // ================= SAVE INVESTIGATION =================

    @PostMapping("/save-investigation")
    public String saveInvestigation(
            Investigation investigation) {

        investigationRepository.save(investigation);

        return "redirect:/investigation";
    }


    // ================= VICTIM / WITNESS =================

    @GetMapping("/victim-witness")
    public String victimWitness(Model model) {

        List<VictimWitness> people =
                victimWitnessRepository.findAll();

        model.addAttribute(
                "people",
                people);

        return "victim-witness";
    }


    // ================= ADD VICTIM / WITNESS =================

    @GetMapping("/add-victim-witness")
    public String addVictimWitness() {

        return "add-victim-witness";
    }


    // ================= SAVE VICTIM / WITNESS =================

    @PostMapping("/save-victim-witness")
    public String saveVictimWitness(
            VictimWitness victimWitness) {

        victimWitnessRepository.save(victimWitness);

        return "redirect:/victim-witness";
    }


    // ================= REPORTS =================

    @GetMapping("/reports")
    public String reports(Model model) {

        List<Crime> crimes =
                crimeRepository.findAll();


        // TOTAL CRIMES

        long totalCrimes =
                crimes.size();


        // SOLVED CASES

        long solvedCases =
                crimes.stream()
                        .filter(crime ->
                                "Solved".equalsIgnoreCase(
                                        crime.getCaseStatus()))
                        .count();


        // ACTIVE CASES

        long activeCases =
                crimes.stream()
                        .filter(crime ->
                                "Active".equalsIgnoreCase(
                                        crime.getCaseStatus()))
                        .count();


        // UNDER INVESTIGATION

        long investigationCases =
                crimes.stream()
                        .filter(crime ->
                                "Investigation".equalsIgnoreCase(
                                        crime.getCaseStatus()))
                        .count();


        // SEND DATA TO REPORTS PAGE

        model.addAttribute(
                "totalCrimes",
                totalCrimes);

        model.addAttribute(
                "solvedCases",
                solvedCases);

        model.addAttribute(
                "activeCases",
                activeCases);

        model.addAttribute(
                "investigationCases",
                investigationCases);


        return "reports";
    }

}