package za.co.footballassoc.soccertournament.service;

public interface IService <T, ID> {
    T create (T t);
    T read (ID id);
    T update (ID id, T t);
}
