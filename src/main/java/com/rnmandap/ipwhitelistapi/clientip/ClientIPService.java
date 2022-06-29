package com.rnmandap.ipwhitelistapi.clientip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientIPService implements ClientIPDAO {

    private ClientIPRepository repo;

    @Autowired
    public ClientIPService(ClientIPRepository repo) {
        this.repo = repo;
    }

    @Override
    public ClientIP addClientIP(ClientIPRequest clientIPRequest) {
        return repo.save(new ClientIP(
                clientIPRequest.getIpv4(),
                clientIPRequest.getClient(),
                clientIPRequest.getApp(),
                clientIPRequest.getEnv()
        ));
    }

    @Override
    public List<String> getIPv4List(String env, String app, String client) {
        return repo.getIPv4List(env, app, client);
    }

    @Transactional
    @Override
    public int removeClientIP(ClientIPRequest clientIPRequest) {
        return repo.removeClientIP(
                clientIPRequest.getIpv4(),
                clientIPRequest.getClient(),
                clientIPRequest.getApp(),
                clientIPRequest.getEnv()
        );
    }
}
