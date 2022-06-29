package com.rnmandap.ipwhitelistapi.clientip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientIPRepository extends JpaRepository<ClientIP, Integer> {

    @Query(
            "SELECT DISTINCT (ci.ipv4) " +
                    "FROM ClientIP ci " +
                    "WHERE (?1 IS NULL OR ci.env = ?1) " +
                    "AND (?2 IS NULL OR ci.app = ?2) " +
                    "AND (?3 IS NULL OR ci.client = ?3)"
    )
    public List<String> getIPv4List(String env, String app, String client);

    @Modifying
    @Query("DELETE FROM ClientIP ci WHERE ci.ipv4 = ?1 AND ci.client = ?2 AND ci.app = ?3 AND ci.env = ?4")
    public int removeClientIP(String ipv4, String client, String app, String env);

}
