package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.tools.CountWords;
import service.tools.WriteFileFromXML;

/**
 * Created by azburatura on 8/10/2016.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private CountWords countWords;

    @Autowired
    private WriteFileFromXML writeFileFromXML;

    @RequestMapping(method = RequestMethod.GET)
    public String showHome(){

        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addArticle(@RequestParam("title") String title){

        writeFileFromXML.writeFileFromXML(title);
        countWords.countWords();

        return "home";
    }

}
