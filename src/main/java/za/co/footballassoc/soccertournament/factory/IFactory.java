package za.co.footballassoc.soccertournament.factory;

public interface IFactory <T, ID>{
    T create (T t);
}
