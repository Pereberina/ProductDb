package product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import product.entity.Product;
import product.repo.InfoRepository;

import product.entity.Info;

import java.util.List;

/**
 * Created by Stasia on 30.11.16.
 */
@Service("infoService")
public class InfoService {
    private static Logger LOGGER = LoggerFactory.getLogger(InfoService.class);

    @Autowired
    private InfoRepository infoRepo;


    public Iterable<Info> findAll() {
        LOGGER.info("InfoEntity findAll request");

        return infoRepo.findAll();
    }

    public Info findById(int id) {
        LOGGER.info("InfoEntity findById request: " + id);

        return infoRepo.findOne(id);
    }

    public List<Info> findByLine(String line) {
        LOGGER.info("InfoEntity findByLine request: " + line);

        return infoRepo.findByLine(line);
    }

    public List<Info> findByProduct(Product product) {
        LOGGER.info("InfoEntity findByProduct request: " + product.toString());

        return infoRepo.findByProduct(product);
    }

    public void save(Info info) {
        LOGGER.info("InfoEntity save request: " + info.toString());
        infoRepo.save(info);
    }

    public void delete(Integer id) {
        LOGGER.info("InfoEntity delete request: " + id);
        infoRepo.delete(id);
    }
}
