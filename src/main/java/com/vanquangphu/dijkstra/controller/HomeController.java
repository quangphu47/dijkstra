package com.vanquangphu.dijkstra.controller;


import com.vanquangphu.dijkstra.model.EdgeForm;
import com.vanquangphu.dijkstra.service.DijkstraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
    @Autowired
    private DijkstraService dijkstraService;
    @GetMapping(value = {"/home", "/"})
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("edgeForm", new EdgeForm());
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView submissionResult(@ModelAttribute("edgeForm")EdgeForm edgeForm) {
        System.out.println(edgeForm);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("result", dijkstraService.run(edgeForm));
        return modelAndView;
    }
}
