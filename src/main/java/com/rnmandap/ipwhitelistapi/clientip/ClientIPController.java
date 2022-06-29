package com.rnmandap.ipwhitelistapi.clientip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ClientIPController {

    private ClientIPService service;

    @Autowired
    public ClientIPController(ClientIPService service) {
        this.service = service;
    }

    @PostMapping("/client-ip")
    public ClientIP addClientIP(@Valid @RequestBody ClientIPRequest clientIPRequest){
        return service.addClientIP(clientIPRequest);
    }

    @GetMapping("/client-ip/ipv4")
    public List<String> getIPv4List(
            @RequestParam(required = false) String env,
            @RequestParam(required = false) String app,
            @RequestParam(required = false) String client) {
        return service.getIPv4List(env, app, client);
    }

    @DeleteMapping("/client-ip")
    public String removeClientIP(@Valid @RequestBody ClientIPRequest clientIPRequest) {
        int deleted = service.removeClientIP(clientIPRequest);
        if (deleted == 0){
            return "nothing deleted...";
        }
        return "deletion success...";
    }


}
