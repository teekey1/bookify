package com.codecool.bookify.Service;

import com.codecool.bookify.Exceptions.NotFoundException;
import com.codecool.bookify.Model.UserRate;
import com.codecool.bookify.Repository.UserRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRateService implements HelperService<UserRate> {

    protected UserRateRepository userRateRepository;

    @Autowired
    public UserRateService(UserRateRepository userRateRepository) {
        this.userRateRepository = userRateRepository;
    }

    @Override
    public List<UserRate> getAll() {
        return userRateRepository.findAll();
    }

    @Override
    public UserRate getById(Long id) {
        Optional<UserRate> userRate = userRateRepository.findById(id);
        if (userRate.isPresent()) return userRate.get();
        throw new NotFoundException();
    }

    @Override
    public void update(UserRate userRate, Long id) {
    }

    @Override
    public void insert(UserRate userRate) {
        userRateRepository.save(userRate);
    }

    @Override
    public void delete(Long id) {
        userRateRepository.deleteById(id);
    }
}
