package ru.pokazaneva.MyFirstAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class Controllers {

    private ArrayList<String> arrayList;
    private HashMap<Integer, String> hashMap;
    private int counter = 0;

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "value") String value) {
        if (arrayList == null){
            arrayList = new ArrayList<>();
            return "ArrayList created!";
        }
        arrayList.add(value);
        return String.format("Add string: %s!", value);
    }

    @GetMapping("/show-array")
    public ArrayList<String> showArrayList(){
        return arrayList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "value") String value) {
        if (hashMap == null){
            hashMap = new HashMap<>();
            return "HashMap created!";
        }
        hashMap.put(counter++, value);
        return String.format("Add string: %s!", value);
    }

    @GetMapping("/show-map")
    public HashMap<Integer, String> showHashMap(){
        return hashMap;
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        int arrayLenght = (arrayList == null) ? 0 : arrayList.size();
        int hashMapLenght = (hashMap == null) ? 0 : hashMap.size();
        return String.format("ArrayList: %s; HashMap: %s", arrayLenght, hashMapLenght);
    }
}