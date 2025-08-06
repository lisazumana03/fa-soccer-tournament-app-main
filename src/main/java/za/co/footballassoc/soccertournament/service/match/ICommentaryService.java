package za.co.footballassoc.soccertournament.service.match;

import za.co.footballassoc.soccertournament.domain.match.Commentary;
import za.co.footballassoc.soccertournament.service.IService;

public interface ICommentaryService extends IService<Commentary, String> {
    void delete(String commentatorId);
}
