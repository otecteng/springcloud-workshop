package com.example.workshopproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired ProductRepository productRepository;
    Random r = new Random(2000);
    @GetMapping
    public List<Product> list(){
        try {
            int t = r.nextInt(2000);
            System.out.println("------- sleep " + t);
            Thread.sleep(t);

        }catch (Exception ex){
            ;
        }
        return productRepository.findAll();
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "nihao mama";
    }

    @PostMapping
    public Product create(@RequestBody Product request){
        return productRepository.save(request);
    }

    @GetMapping(value = "{id}")
    public Product get(@PathVariable String id){
        return productRepository.findOne(id);
    }

    @PutMapping
    public Product update(){
        return new Product();
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable String id){
        productRepository.delete(id);
    }

    static Vector v = new Vector();
    static int memSize = 1048576*8;
    @GetMapping(value = "/allocate")
    public String allocate(){
        v.add(new byte[memSize]);
        return calMem();
    }

    @GetMapping(value = "/deallocate")
    public String deallocate() {
        v.clear();
        return calMem();
    }

    byte b[];
    @GetMapping(value = "/newHeap")
    public String newHeap(){
        b = new byte[memSize];
        return calMem();
    }

    @GetMapping(value = "/gc")
    public String gc() {
        Runtime rt = Runtime.getRuntime();
        rt.gc();
        return calMem();
    }
    private String calMem(){
        Runtime rt = Runtime.getRuntime();
        long heapSize = rt.totalMemory()/1024/1024;
        long heapMaxSize = rt.maxMemory()/1024/1024;
        long heapFreeSize = rt.freeMemory()/1024/1024;
        return "heapSize = " + heapSize + ";heapMaxSize = " + heapMaxSize + ";heapFreeSize = " + heapFreeSize;
    }
}
