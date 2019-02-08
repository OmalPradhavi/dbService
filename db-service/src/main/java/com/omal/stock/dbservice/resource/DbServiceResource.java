package com.omal.stock.dbservice.resource;

import com.omal.stock.dbservice.model.Quote;
import com.omal.stock.dbservice.model.Quotes;
import com.omal.stock.dbservice.repository.QuotesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    private QuotesRepository quotesRepository;

    public DbServiceResource(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username){


        return quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());

    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes){

        return null;
    }


}
