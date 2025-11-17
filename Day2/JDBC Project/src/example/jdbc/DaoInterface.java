package example.jdbc;

import java.util.Collection;

public interface DaoInterface<T,ID> {
	Collection<T> getAll();
	T getOne(ID id);
	void create(T t); //T is type of Student so that when we add create () method go to StudentDao class and make changes
    void update(T t);
    void deleteOne(ID id);
}
