package com.slr3073;

import com.slr3073.coachs.Coach;
import com.slr3073.coachs.CoachPiscine;
import com.slr3073.fortunes.Fortune;
import com.slr3073.fortunes.SadFortune;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.slr3073")
public class SLRConfig {
    @Bean
    public Fortune sadFortune(){
        return new SadFortune();
    }

    @Bean
    public Coach coachPiscine(){
        return new CoachPiscine(sadFortune());
    }
}
