package com.miramontes.myneighbors.config;

import com.miramontes.myneighbors.model.House;
import com.miramontes.myneighbors.model.Owner;
import com.miramontes.myneighbors.repositories.HouseRepository;
import com.miramontes.myneighbors.repositories.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SeedDatabase implements CommandLineRunner {

    private final HouseRepository houseRepository;
    private final OwnerRepository ownerRepository;

    public SeedDatabase(HouseRepository houseRepository, OwnerRepository ownerRepository) {
        this.houseRepository = houseRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        printToLog("Starting", "run");
        seedOwners(10);
        seedHouses(10);
        printToLog("Finished", "run");
    }

    private void seedHouses(int count) {
        printToLog("Starting", "houses");
        for (int i = 1; i <= count; i++) {
            Owner owner = ownerRepository.findById(i).get();
            houseRepository.save(House.builder().address("Address " + i).owner(owner).build());
        }
        log.info("Houses count: " + houseRepository.count());
        printToLog("Finished", "houses");
    }

    private void seedOwners(int count) {
        printToLog("Starting", "owners");
        for (int i = 1; i <= count; i++) {
            ownerRepository.save(
                    Owner.builder()
                            .name("Owner " + i)
                            .email("owner_email_" + i + "@domain.com")
                            .phone("" + i + i + i + i)
                            .build());
        }
        log.info("Owners count: " + ownerRepository.count());
        printToLog("Finished", "owners");
    }

    private void printToLog(String prefix, String name) {
        String dashes = "----------";
        log.info(dashes + " " + prefix + " seeding " + name + dashes);
    }
}
