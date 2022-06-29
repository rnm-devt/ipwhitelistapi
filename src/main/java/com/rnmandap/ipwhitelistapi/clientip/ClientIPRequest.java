package com.rnmandap.ipwhitelistapi.clientip;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ClientIPRequest {
    @NotBlank(message = "ipv4 is mandatory")
    @Pattern(
            message = "ipv4 is invalid",
            regexp = "^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)(\\.(?!$)|$)){4}$"
    )
    private String ipv4;
    @NotBlank(message = "client is mandatory")
    private String client;
    @NotBlank(message = "app is mandatory")
    private String app;
    @NotBlank(message = "env is mandatory")
    private String env;

    public ClientIPRequest(String ipv4, String client, String app, String env) {
        this.ipv4 = ipv4;
        this.client = client;
        this.app = app;
        this.env = env;
    }

    public String getIpv4() {
        return ipv4;
    }

    public String getClient() {
        return client;
    }

    public String getApp() {
        return app;
    }

    public String getEnv() {
        return env;
    }

    @Override
    public String toString() {
        return "ClientIPRequest{" +
                "ipv4='" + ipv4 + '\'' +
                ", client='" + client + '\'' +
                ", app='" + app + '\'' +
                ", env='" + env + '\'' +
                '}';
    }
}
