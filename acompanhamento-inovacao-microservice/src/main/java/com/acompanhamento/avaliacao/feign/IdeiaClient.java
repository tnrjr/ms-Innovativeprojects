package com.acompanhamento.avaliacao.feign;

import com.acompanhamento.avaliacao.dtos.IdeiaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ideias", url = "http://localhost:8082")
public interface IdeiaClient {

    @GetMapping("/ideias/{id}")
    IdeiaDTO buscarIdeia(@PathVariable("id") Long id);
}
