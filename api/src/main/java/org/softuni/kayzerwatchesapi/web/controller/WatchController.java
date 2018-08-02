package org.softuni.kayzerwatchesapi.web.controller;

import org.softuni.kayzerwatchesapi.domain.enitity.Watch;
import org.softuni.kayzerwatchesapi.domain.model.binding.WatchBindingModel;
import org.softuni.kayzerwatchesapi.domain.model.view.WatchAllViewModel;
import org.softuni.kayzerwatchesapi.domain.model.view.WatchTopViewModel;
import org.softuni.kayzerwatchesapi.service.WatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WatchController {
    private final WatchService watchService;

    public WatchController(WatchService watchService) {
        this.watchService = watchService;
    }

    @GetMapping(value = "/watches/top")
    public List<WatchTopViewModel> top(){
        return this.watchService.getTop4Watches();
    }

    @GetMapping(value = "/watches/all")
    public List<WatchAllViewModel> all(){
        return this.watchService.getAllWatches();
    }

    @GetMapping(value = "/watches/details")
    public Watch details(@RequestParam(name = "id") String id) {
        return this.watchService.getById(id);
    }

    @PostMapping(value = "/watches/add")
    public void add(@ModelAttribute WatchBindingModel watchBindingModel) {
        this.watchService.save(watchBindingModel);
    }
}
