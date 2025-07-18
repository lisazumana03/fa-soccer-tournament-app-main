package za.co.footballassoc.soccertournament.service.official.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.repository.official.VARRepository;

@Service
public class VARService {
    @Autowired
    private VARRepository varRepository;
}
