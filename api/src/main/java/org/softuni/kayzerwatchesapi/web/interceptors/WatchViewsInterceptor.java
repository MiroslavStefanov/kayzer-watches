package org.softuni.kayzerwatchesapi.web.interceptors;

import org.softuni.kayzerwatchesapi.repository.WatchRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class WatchViewsInterceptor implements HandlerInterceptor {
    private final WatchRepository watchRepository;

    public WatchViewsInterceptor(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        if(url.contains("/watches/details")) {
            String id = request.getParameter("id");
            this.watchRepository.findById(id).ifPresent(watch -> {
                watch.setViews(watch.getViews() + 1);
                this.watchRepository.save(watch);
            });
        }
        return true;
    }
}
