package org.softuni.kayzerwatchesapi.service;

import org.modelmapper.ModelMapper;
import org.softuni.kayzerwatchesapi.domain.enitity.Watch;
import org.softuni.kayzerwatchesapi.domain.model.binding.WatchBindingModel;
import org.softuni.kayzerwatchesapi.domain.model.view.WatchAllViewModel;
import org.softuni.kayzerwatchesapi.domain.model.view.WatchTopViewModel;
import org.softuni.kayzerwatchesapi.repository.WatchRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WatchServiceImpl implements WatchService{
    private final WatchRepository watchRepository;
    private final ModelMapper modelMapper;

    public WatchServiceImpl(WatchRepository watchRepository, ModelMapper modelMapper) {
        this.watchRepository = watchRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<WatchTopViewModel> getTop4Watches() {
        return this.watchRepository.findAllByOrderByViewsDesc()
                .stream()
                .limit(4)
                .map(w -> this.modelMapper.map(w, WatchTopViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<WatchAllViewModel> getAllWatches() {
        return this.watchRepository.findAll()
                .stream()
                .map(w -> this.modelMapper.map(w, WatchAllViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Watch getById(String id) {
        return this.watchRepository.findById(id).orElse(null);
    }

    @Override
    public void save(WatchBindingModel watchBindingModel) {
        Watch watch = this.modelMapper.map(watchBindingModel, Watch.class);
        this.watchRepository.save(watch);
    }
}
