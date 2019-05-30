package com.xzh.springjooq;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.jooq.RecordValueReader;
import org.n3r.idworker.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJooqExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJooqExampleApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setSourceNameTokenizer(NameTokenizers.UNDERSCORE).addValueReader(new RecordValueReader());
        return modelMapper;
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1L);
    }

}
