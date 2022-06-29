package com.rnmandap.ipwhitelistapi.clientip;

import java.util.List;

public interface ClientIPDAO {

    public ClientIP addClientIP(ClientIPRequest clientIPRequest);

    public List<String> getIPv4List(String env, String app, String client);

    public int removeClientIP(ClientIPRequest clientIPRequest);

}
