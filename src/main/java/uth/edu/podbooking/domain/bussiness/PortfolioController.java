package uth.edu.podbooking.domain.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PortfolioController {
    @Autowired
    private PortfolioRepository portfolioRepository;

    @GetMapping("/api/portfolios")
    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }
}
