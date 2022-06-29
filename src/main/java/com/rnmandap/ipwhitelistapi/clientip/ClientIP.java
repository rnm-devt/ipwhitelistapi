package com.rnmandap.ipwhitelistapi.clientip;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="client_ip")
public class ClientIP {
    @Id
    @GeneratedValue(generator = "seq_client_ip")
    @SequenceGenerator(
            name = "seq_client_ip",
            sequenceName = "client_ip_seq",
            allocationSize = 1
    )
    private Integer id;
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

    public ClientIP() {}

    public ClientIP(String ipv4, String client, String app, String env) {
        this.ipv4 = ipv4;
        this.client = client;
        this.app = app;
        this.env = env;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    @Override
    public String toString() {
        return "ClientIP{" +
                "id=" + id +
                ", ipv4='" + ipv4 + '\'' +
                ", client='" + client + '\'' +
                ", app='" + app + '\'' +
                ", env='" + env + '\'' +
                '}';
    }
}
