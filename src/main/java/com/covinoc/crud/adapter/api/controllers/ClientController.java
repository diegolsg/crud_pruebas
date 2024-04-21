package com.covinoc.crud.adapter.api.controllers;


import com.covinoc.crud.adapter.api.dtos.AccountDto;
import com.covinoc.crud.domain.ports.service.ClientService;
import com.covinoc.crud.adapter.api.dtos.ClientDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
   public ResponseEntity<List<ClientDto>> getAll() {
        List<ClientDto> clientDtoList = new ArrayList<>();
        clientService.getAll().forEach(client -> clientDtoList.add(ClientDto.of(client)));
        return new ResponseEntity<>(clientDtoList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<ClientDto> getClient(@PathVariable("id") int idClient){
        return new ResponseEntity<>(ClientDto.of(clientService.getClient(idClient)),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto clientDto){
        return new ResponseEntity<>(ClientDto.of(clientService.update(clientDto.getClientDto())),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int idClient){
        return clientService.delete(idClient);
    }
    @PostMapping("/save")
    public ClientDto save(@Valid @RequestBody ClientDto clientDto){
        return ClientDto.of(clientService.save(clientDto.getClientDto()));
    }


}







