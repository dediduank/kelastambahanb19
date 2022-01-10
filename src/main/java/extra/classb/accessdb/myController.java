/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extra.classb.accessdb;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dedi Wardani
 */
@CrossOrigin
@RestController
public class myController {

    MahasiswaJpaController mhs = new MahasiswaJpaController();
    
    @RequestMapping("/showdata")
    @ResponseBody
    public List<Mahasiswa> getData(){
        
         List<Mahasiswa> mhsb = new ArrayList<>();    
        try {
            
            mhsb = mhs.findMahasiswaEntities();
            
        } catch (Exception e) {
        }
        
        return mhsb;
        
    }
}
