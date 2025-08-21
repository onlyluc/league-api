package com.lol.itens_favoritos_api.controller;

import com.lol.itens_favoritos_api.model.Item;
import com.lol.itens_favoritos_api.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public ResponseEntity<List<Item>> listarTodos() {
        List<Item> itens = itemRepository.findAll();
        return new ResponseEntity<>(itens, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Item> criarItem(@Valid @RequestBody Item item) {
        Item novoItem = itemRepository.save(item);
        return new ResponseEntity<>(novoItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizarItem(@PathVariable Long id, @Valid @RequestBody Item itemAtualizado) {
        if (itemRepository.existsById(id)) {
            itemAtualizado.setId(id);
            Item salvo = itemRepository.save(itemAtualizado);
            return new ResponseEntity<>(salvo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItem(@PathVariable Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}