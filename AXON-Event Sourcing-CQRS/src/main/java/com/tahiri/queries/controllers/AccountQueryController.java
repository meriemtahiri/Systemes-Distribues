package com.tahiri.queries.controllers;

import com.tahiri.commonapi.queries.GetAccountById;
import com.tahiri.commonapi.queries.GetAllAccountQuery;
import com.tahiri.queries.entities.Account;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/account")
@AllArgsConstructor
@Slf4j
public class AccountQueryController {

    QueryGateway queryGateway;

    @GetMapping(path = "/allAccounts")
    public List<Account> getAllAccounts() {
        return queryGateway.query(new GetAllAccountQuery(), ResponseTypes.multipleInstancesOf(Account.class)).join();
    }

    @GetMapping(path = "/byId/{id}")
    public Account getAccountById(@PathVariable String id) {
        return queryGateway.query(new GetAccountById(id), ResponseTypes.instanceOf(Account.class)).join();
    }


}
