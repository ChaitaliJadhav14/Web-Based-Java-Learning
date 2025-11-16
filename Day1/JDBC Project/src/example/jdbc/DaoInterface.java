package example.jdbc;

import java.util.Collection;

public interface DaoInterface<T,ID> {
	Collection<T> getAll();

}
