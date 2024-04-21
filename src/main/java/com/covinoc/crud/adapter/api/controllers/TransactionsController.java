package com.covinoc.crud.adapter.api.controllers;

import com.covinoc.crud.adapter.api.dtos.TransactionsDto;
import com.covinoc.crud.domain.ports.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
    @Autowired
    private TransactionsService transactionsservice;

    @GetMapping("/all")
    public ResponseEntity<List<TransactionsDto>> getAll(){
        List<TransactionsDto> transactionsResponseDtos = new ArrayList<>();
        transactionsservice.getAll().forEach(transactions -> transactionsResponseDtos.add(TransactionsDto.of(transactions)));
        return new ResponseEntity<>(transactionsResponseDtos, HttpStatus.OK);
    }
}
