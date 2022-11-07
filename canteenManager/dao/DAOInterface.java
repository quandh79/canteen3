package canteenManager.dao;

import java.util.ArrayList;

public interface DAOInterface<S> {
    ArrayList<S> all();
    boolean creat(S s);
    boolean delete(S s);
    S findOne(Integer id);


}
