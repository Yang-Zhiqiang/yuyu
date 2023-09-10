package yuyu.def.result.manager;

import java.util.Iterator;

import jp.co.slcs.swak.db.ExDBResults;

/**
 * データ集合クラス（大量 UNION）<br />
 */
public abstract class UnionManager<I, R> extends UnionAllManager<I, R> {

    @SafeVarargs
    public UnionManager(ExDBResults<I>... pRsts) {

        super(pRsts);
    }

    protected abstract String getUnionKey(R pItem);

    @Override
    protected R loadNext(int pRstIndex) {

        Iterator<I> iter = lstIter.get(pRstIndex);
        if (iter.hasNext()) {

            I iItem = iter.next();
            if (iItem != null) {

                R rItem = copy(iItem, pRstIndex);
                String strDistincKey = getUnionKey(rItem);
                if (!mapUnionKey.containsKey(strDistincKey)) {

                    mapUnionKey.put(strDistincKey, strDistincKey);

                    return rItem;
                }
            }
        } else {

            return null;
        }

        return loadNext(pRstIndex);
    }

    protected String concat(String... pVals) {

        StringBuffer sbKey = new StringBuffer();
        for (String val : pVals) {

            sbKey.append(String.valueOf(val));
            sbKey.append(UNION_KEY_CONCAT);
        }

        return sbKey.toString();
    }
}