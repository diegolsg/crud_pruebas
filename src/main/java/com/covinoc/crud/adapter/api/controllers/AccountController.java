package com.covinoc.crud.adapter.api.controllers;

import com.covinoc.crud.domain.ports.service.AccountService;
import com.covinoc.crud.adapter.api.dtos.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("public/all")
    public ResponseEntity<List<AccountDto>> getAll(){
        List<AccountDto> accountDtoList = new ArrayList<>();
        accountService.getAll().forEach(account -> accountDtoList.add(AccountDto.of(account)));
        return new ResponseEntity<>(accountDtoList,HttpStatus.OK);
    }

    @GetMapping("public/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable("id") int accountId){
        return new ResponseEntity<>(AccountDto.of(accountService.getAccount(accountId)),HttpStatus.OK);
    }
    @PostMapping("/save")
    public AccountDto save(@RequestBody AccountDto accountDto){
        return AccountDto.of(accountService.save(accountDto.getAccountDto()));
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int accountId){
        return accountService.delete(accountId);
    }
}
