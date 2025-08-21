package com.lol.itens_favoritos_api.repository;

import com.lol.itens_favoritos_api.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}