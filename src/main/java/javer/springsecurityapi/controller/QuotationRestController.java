package javer.springsecurityapi.controller;

import javer.springsecurityapi.model.Quotation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuotationRestController {

    private final List<Quotation> quotations;

    public QuotationRestController() {
        this.quotations = new ArrayList<>();
        quotations.add(new Quotation("Forgive your enemies, but never forget their names.", "Unknown"));
        quotations.add(new Quotation("All you need is love.", "Unknown"));
    }

    @GetMapping("/api")
    public List<Quotation> getQuotation() {
        return quotations;
    }

    @PostMapping("/api")
    public boolean addQuotation(@RequestBody Quotation quotation) {
        return quotations.add(quotation);
    }

    @DeleteMapping("/api")
    public void deleteQuotation(@RequestParam int index) {
        quotations.remove(index);
    }
}
