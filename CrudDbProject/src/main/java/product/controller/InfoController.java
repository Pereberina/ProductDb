package product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import product.entity.Info;
import product.service.DbService;

/**
 * Created by Stasia on 07.12.16.
 */
@Controller("InfoController")
public class InfoController {
    private static Logger LOGGER = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    DbService dbService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity findAllInfo() {
        LOGGER.info("InfoController REQUEST findAll");

        Iterable<Info> infoList = dbService.findAllInfo();
        ResponseEntity responseEntity = new ResponseEntity<>(infoList, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/info/{id}", method = RequestMethod.PATCH)
    public ResponseEntity updateInfo(@PathVariable("id") Integer id, @RequestBody Info info) {
        LOGGER.info("InfoController REQUEST update");

        Info updateInfo = dbService.findOneInfo(id);

        if (info.getCores() != null) {
            updateInfo.setCores(info.getCores());
        }

        if(info.getLine() != null) {
            updateInfo.setLine(info.getLine());
        }

        if(info.getQuantity() != null) {
            updateInfo.setQuantity(info.getQuantity());
        }

        dbService.saveInfo(updateInfo);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteInfo(@PathVariable("id") Integer id) {
        LOGGER.info("InfoController REQUEST delete");
        dbService.deleteInfo(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
