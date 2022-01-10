/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extra.classb.accessdb;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dedi Wardani
 */
@CrossOrigin
@RestController
@RequestMapping("/mahasiswa")
public class myController {

    @Autowired
    private RepoMahasiswa myrepo;

    @GetMapping()
    @ResponseBody
    public List<Mahasiswa> getData() {

        List<Mahasiswa> mhsb = new ArrayList<>();
        try {
            mhsb = myrepo.findAll();

        } catch (Exception e) {
        }

        return mhsb;
    }

    @DeleteMapping("/del/{nim}")
    @ResponseBody
    public String deleteItem(@PathVariable String nim) {
        String respon = "";
        try {
            myrepo.deleteById(nim);
            respon = HttpStatus.OK.toString();
        } catch (ExceptionInInitializerError e) {
            respon = HttpStatus.INTERNAL_SERVER_ERROR.toString();
        }
        return respon;

    }
}
