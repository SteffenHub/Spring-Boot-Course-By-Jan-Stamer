package com.freddys_bbq_frontend_intern;


import com.freddys_bbq_frontend_intern.model.Delivery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Controller
@RequestMapping("/intern/delivery")
public class DeliveryControllerFrontend {

    @Value("${DELIVERY_BACKEND_URL:http://localhost:8081}")
    private String deliveryBackendUrl;

    private final RestTemplate restTemplate;

    public DeliveryControllerFrontend(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/get")
    public ResponseEntity<Delivery[]> getDeliveries() {
        return restTemplate.getForEntity(deliveryBackendUrl + "/api/delivery/delivery", Delivery[].class);
    }

    @GetMapping
    public String getDeliverySite() {
        return "delivery";
    }

    @PostMapping("/start")
    public ResponseEntity<String> startDelivery(@RequestBody UUID id) {
        //UUID uuid = UUID.fromString(id);
        ResponseEntity<String> response = restTemplate.postForEntity(deliveryBackendUrl + "/api/delivery/delivery/start", id, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Lieferung gestartet");
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
