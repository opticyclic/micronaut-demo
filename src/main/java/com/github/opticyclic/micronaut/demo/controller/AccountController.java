package com.github.opticyclic.micronaut.demo.controller;

import com.github.opticyclic.micronaut.demo.model.Account;
import com.github.opticyclic.micronaut.demo.repository.AccountRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import javax.validation.Valid;

@Validated
@Controller("/accounts")
public class AccountController {

    @Inject
    private AccountRepository accountRepository;

    @Get
    public HttpResponse<?> getAccounts() {
        return HttpResponse.status(HttpStatus.OK).body(this.accountRepository.findAll());
    }

    @Post
    public HttpResponse<?> addAccount(@Body @Valid Account account) {
        Account savedAccount = accountRepository.save(account);
        return HttpResponse.status(HttpStatus.CREATED).body("Created account id: " + savedAccount.getId());
    }
}
