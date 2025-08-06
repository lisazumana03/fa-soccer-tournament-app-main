package za.co.footballassoc.soccertournament.service.match.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.match.Commentary;
import za.co.footballassoc.soccertournament.repository.match.CommentaryRepository;
import za.co.footballassoc.soccertournament.service.match.ICommentaryService;

import java.util.List;

@Service
public class CommentaryService implements ICommentaryService {

    @Autowired
    private CommentaryRepository cRepository;

    @Override
    public void delete(String commentatorId) {
        cRepository.deleteById(commentatorId);
    }

    @Override
    public Commentary create(Commentary commentary) {
        return cRepository.save(commentary);
    }

    @Override
    public Commentary read(String s) {
        return null;
    }

    @Override
    public List<Commentary> getAll() {
        return cRepository.findAll();
    }

    @Override
    public Commentary update(String s, Commentary commentary) {
        return null;
    }
}
