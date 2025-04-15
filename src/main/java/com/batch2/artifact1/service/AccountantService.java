package com.batch2.artifact1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch2.artifact1.domain.Accountant;
import com.batch2.artifact1.repository.AccountantRepo;

@Service
public class AccountantService {
    @Autowired
    private AccountantRepo rep;

    public List<Accountant> listAll() {
        return rep.findAll();
    }

    public void save(Accountant account) {
        rep.save(account);
    }

    public Accountant get(long no) {
        return rep.findById(no).orElseThrow(() -> new RuntimeException("Account not found with No: " + no));
    }

    public void delete(long no) {
        if (!rep.existsById(no)) {
            throw new RuntimeException("Cannot delete, account not found with No: " + no);
        }
        rep.deleteById(no);
    }
}
