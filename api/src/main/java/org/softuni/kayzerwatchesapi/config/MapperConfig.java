package org.softuni.kayzerwatchesapi.config;

import org.modelmapper.ModelMapper;
import org.softuni.kayzerwatchesapi.domain.enitity.Watch;
import org.softuni.kayzerwatchesapi.domain.model.binding.WatchBindingModel;
import org.softuni.kayzerwatchesapi.domain.model.view.WatchAllViewModel;
import org.softuni.kayzerwatchesapi.domain.model.view.WatchTopViewModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    private final ModelMapper mapper;

    public MapperConfig() {
        this.mapper = new ModelMapper();
        this.configure();
    }

    private void configure() {
        this.topWatchesViewMapping();
        this.allWatchesViewMapping();
        this.watchBindingMapping();
    }

    private void topWatchesViewMapping() {
        this.mapper.createTypeMap(Watch.class, WatchTopViewModel.class);
    }

    private void allWatchesViewMapping() {
        this.mapper.createTypeMap(Watch.class, WatchAllViewModel.class);
    }

    private void watchBindingMapping() {
        this.mapper.createTypeMap(WatchBindingModel.class, Watch.class);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return this.mapper;
    }
}
