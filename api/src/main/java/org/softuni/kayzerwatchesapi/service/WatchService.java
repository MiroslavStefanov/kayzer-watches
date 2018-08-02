package org.softuni.kayzerwatchesapi.service;

import org.softuni.kayzerwatchesapi.domain.enitity.Watch;
import org.softuni.kayzerwatchesapi.domain.model.binding.WatchBindingModel;
import org.softuni.kayzerwatchesapi.domain.model.view.WatchAllViewModel;
import org.softuni.kayzerwatchesapi.domain.model.view.WatchTopViewModel;

import java.util.List;

public interface WatchService {
    List<WatchTopViewModel> getTop4Watches();

    List<WatchAllViewModel> getAllWatches();

    Watch getById(String id);

    void save(WatchBindingModel watchBindingModel);
}
