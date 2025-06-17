package za.co.footballassoc.soccertournament.repository;

@Deprecated
public interface IRepository <T, ID>{
    T create(T entity);
    T read(ID id);
    T update(T entity);
    void delete(ID id);
}
