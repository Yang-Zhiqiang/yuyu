package yuyu.def.result.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.core.exception.ExNullArgumentException;
import jp.co.slcs.swak.core.lang.Closeable;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * データ集合クラス（大量 UNION ALL）<br />
 */
public abstract class UnionAllManager<I, R> implements Iterable<R>, Closeable {

    protected static final boolean GROUP_DEFAULT = true;
    protected static final int COMPARE_DEFAULT = -99;
    protected static final String UNION_KEY_CONCAT = ";";
    protected static final String GROUP_KEY_CONCAT = ";";
    protected static final Long GROUP_COUNT_DEFAULT = Long.valueOf(1);
    protected List<ExDBResults<I>> lstRst = new ArrayList<ExDBResults<I>>();
    protected List<Iterator<I>> lstIter = new ArrayList<Iterator<I>>();
    protected List<R> lstItem = new ArrayList<R>();
    protected List<R> lstItemNext = new ArrayList<R>();
    protected Map<String, String> mapUnionKey = new HashMap<String, String>();

    @SafeVarargs
    protected UnionAllManager(ExDBResults<I>... pRsts) {

        if (pRsts == null || pRsts.length < 1) {

            throw new ExNullArgumentException("ExDBResults<R>... pRsts");
        }

        Iterator<I> iter = null;
        int iCount = -1;
        for (ExDBResults<I> rst : pRsts) {

            iCount++;
            lstRst.add(rst);
            lstIter.add(null);
            lstItem.add(null);
            lstItemNext.add(null);
            if (rst != null) {

                iter = rst.iterator();
                lstIter.set(iCount, iter);
                setNext(iCount);
            }
        }
    }

    protected abstract R copy(I pItem, int pRstIndex);

    protected int compare(R pItem1, R pItem2) {

        return COMPARE_DEFAULT;
    }

    @Override
    public Iterator<R> iterator() {

        return new TIterator();
    }

    @Override
    public void close() {

        if (lstRst != null) {

            for (ExDBResults<I> rst : lstRst) {

                if (rst != null) {

                    rst.close();
                }
            }
        }
    }

    protected R getNext(int pRstIndex) {

        R item = lstItem.get(pRstIndex);

        lstItem.set(pRstIndex, null);

        setNext(pRstIndex);

        return item;
    }

    protected void setNext(int pRstIndex) {

        R item = loadNext(pRstIndex);
        if (item == null) {

            return;
        }

        lstItem.set(pRstIndex, item);
    }

    protected R loadNext(int pRstIndex) {

        Iterator<I> iter = lstIter.get(pRstIndex);
        if (iter.hasNext()) {

            I item = iter.next();
            if (item != null) {

                return copy(item, pRstIndex);
            }
        }

        return null;
    }

    protected int isAscDesc(boolean pOrderFlg) {

        return pOrderFlg ? 1 : -1;
    }

    protected int getRstIndex() {

        int iRstIndex = -1;
        int iCount = lstItem.size();
        R item = null;
        R itemTemp = null;
        for (int i = 0; i < iCount; i++) {

            item = lstItem.get(i);
            if (item == null) {

                continue;
            }

            if (itemTemp == null) {

                itemTemp = item;
                iRstIndex = i;

                continue;
            }

            int compare = compare(itemTemp, item);
            if (compare == COMPARE_DEFAULT) {

                if (iRstIndex == -1) {

                    return i;
                }
            }

            if (compare > 0) {

                itemTemp = item;
                iRstIndex = i;
            }
        }

        return iRstIndex;
    }

    private class TIterator implements Iterator<R> {

        public TIterator() {
            super();
        }

        @Override
        public boolean hasNext() {

            if (lstItem != null) {

                for (R item : lstItem) {

                    if (item != null) {

                        return true;
                    }
                }
            }

            return false;
        }

        @Override
        public R next() {

            if (!hasNext()) {

                return null;
            }

            int iRstIndex = getRstIndex();
            if (iRstIndex < 0) {

                return null;
            }

            return getNext(iRstIndex);
        }

        @Override
        @Deprecated
        public void remove() {
            // TODO 利用しなくて実装不要
        }
    }
}