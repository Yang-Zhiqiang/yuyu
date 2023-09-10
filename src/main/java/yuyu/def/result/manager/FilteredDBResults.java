package yuyu.def.result.manager;

import java.util.Iterator;

import jp.co.slcs.swak.core.exception.ExNullArgumentException;
import jp.co.slcs.swak.core.lang.Closeable;
import jp.co.slcs.swak.db.ExDBResults;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * 大量データフィルタリング取得クラスです。<br />
 * <ul>
 *   <li>大量データ取得しながら、フィルタリングした結果を返却します。
 * <ul>
 */
public class FilteredDBResults<T> implements Iterable<T>, Closeable {

    private ExDBResults<T> result = null;
    private Iterator<T> iterator = null;

    public FilteredDBResults(ExDBResults<T> pResult, Predicate<T> pFilter) {

        if (pResult == null || pFilter == null) {

            throw new ExNullArgumentException("pResult or pFilter is null.");
        }

        result = pResult;
        iterator = Iterables.filter(pResult, pFilter).iterator();
    }

    @Override
    public void close() {

        result.close();
    }

    @Override
    public Iterator<T> iterator() {

        return iterator;
    }
}
