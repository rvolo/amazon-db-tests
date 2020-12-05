package com.rvolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@SpringBootApplication
public class Main implements CommandLineRunner {
    private final TestRepository testRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    public Main(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping
    public List<TestEntity> getTestEntities() {
        return testRepository.findAll();
    }

    @GetMapping("/{id}")
    public TestEntity getTestEntity(@PathVariable long id) {
        return testRepository.getOne(id);
    }

    @PostMapping
    public TestEntity addTestEntity(TestEntity testEntity) {
        return testRepository.save(testEntity);
    }

    @PutMapping
    public TestEntity updateTestEntity(TestEntity testEntity) {
        return testRepository.save(testEntity);
    }

    @DeleteMapping
    public void deleteTestEntity(TestEntity testEntity){
        testRepository.delete(testEntity);
    }

    @Override
    public void run(String... args) throws Exception {
        long count = testRepository.count();
        for (int i = (int) count; i < count; i++){
            testRepository.save(new TestEntity().setTestField1(Instant.now().toString()));
        }
    }
}
