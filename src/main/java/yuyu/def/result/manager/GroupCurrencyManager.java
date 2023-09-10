package yuyu.def.result.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

/**
 * データ集合クラス（大量 グループ金額合計）<br />
 * 重複キーを指定すれば（UNION）、指定してなければ（UNION All）<br />
 */
public abstract class GroupCurrencyManager<I, R> extends UnionManager<I, R> {

    @SafeVarargs
    public GroupCurrencyManager(ExDBResults<I>... pRsts) {

        super(pRsts);
    }

    @Override
    protected String getUnionKey(R pItem) {

        mapUnionKey.clear();

        return UNION_KEY_CONCAT;
    }

    protected abstract boolean isGroup(R pItem1, R pItem2);

    protected abstract void grouping(R pItem1, R pItem2);

    @Override
    protected void setNext(int pRstIndex) {

        R item = lstItemNext.get(pRstIndex);
        if (item == null) {

            item = loadNext(pRstIndex);
        } else {

            lstItemNext.set(pRstIndex, null);
        }

        if (item == null) {

            return;
        }

        int iCount = lstItem.size();
        R otherItem = null;
        for (int i = 0; i < iCount; i++) {

            if (i == pRstIndex) {

                continue;
            }

            otherItem = lstItem.get(i);
            if (otherItem == null) {

                continue;
            }

            if (!isGroup(otherItem, item)) {

                continue;
            }

            grouping(otherItem, item);
            setNext(pRstIndex);

            return;
        }

        lstItem.set(pRstIndex, item);
        setItemNext(pRstIndex);
    }

    private void setItemNext(int pRstIndex) {

        R itemNext = loadNext(pRstIndex);
        if (itemNext == null) {

            return;
        }

        R item = lstItem.get(pRstIndex);
        if (item == null) {

            return;
        }

        if (!isGroup(item, itemNext)) {

            lstItemNext.set(pRstIndex, itemNext);

            return;
        }

        grouping(item, itemNext);
        setItemNext(pRstIndex);
    }

    protected Map<CurrencyType, BizCurrency> initMapBizCurrency(BizCurrency pBizCurrency) {

        Map<CurrencyType, BizCurrency> mapBizCurrency = new HashMap<CurrencyType, BizCurrency>();
        if (pBizCurrency != null) {

            mapBizCurrency.put(pBizCurrency.getType(), pBizCurrency);
        }

        return mapBizCurrency;
    }

    protected void computeMapBizCurrency(Map<CurrencyType, BizCurrency> pMapBizCurrency1, Map<CurrencyType, BizCurrency> pMapBizCurrency2) {

        Iterator<CurrencyType> iter = pMapBizCurrency2.keySet().iterator();
        CurrencyType type = null;
        while (iter.hasNext()) {

            type = iter.next();
            if (pMapBizCurrency1.containsKey(type)) {

                pMapBizCurrency1.put(type, pMapBizCurrency1.get(type).add(pMapBizCurrency2.get(type)));
            } else {

                pMapBizCurrency1.put(type, pMapBizCurrency2.get(type));
            }
        }
    }
}