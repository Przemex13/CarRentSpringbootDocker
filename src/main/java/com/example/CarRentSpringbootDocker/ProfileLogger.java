package com.example.CarRentSpringbootDocker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ProfileLogger implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(ProfileLogger.class);
    private final Environment environment;


    public ProfileLogger(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String[]  activeProfile = environment.getActiveProfiles();



        if (activeProfile.length == 0){
            logger.info("Profil się wczytał. Coś poszło nie tak");
        }else{
            for (String profile : activeProfile){
                logger.info("Zaczytano konfigurację : {}", profile);

            }
            if(Arrays.stream(activeProfile)
            .anyMatch(str -> str.equals("h2"))){
                logger.info("Zaczytano parametry testowe!");
            }
            if(Arrays.stream(activeProfile)
                    .anyMatch(str -> str.equals("mysql"))){
                logger.info("Zaczytano parametry produkcyjne!");
            }


        }
    }
}
