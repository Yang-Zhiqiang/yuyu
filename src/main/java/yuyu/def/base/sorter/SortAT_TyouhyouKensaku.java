package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_TyouhyouKensaku;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.meta.QAT_TyouhyouKensaku;

public class SortAT_TyouhyouKensaku {

    public List<AT_TyouhyouKensaku> OrderAT_TyouhyouKensakuByPkAsc(List<AT_TyouhyouKensaku> pEntity) {
        List<SortCondition<AT_TyouhyouKensaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_TyouhyouKensaku()).uniqueId, SortOrder.ASC));
        List<AT_TyouhyouKensaku> copyList = new ArrayList<AT_TyouhyouKensaku>(pEntity);
        Collections.sort(copyList, new OrderAT_TyouhyouKensaku(orders));
        return copyList;
    }

    public List<AT_TyouhyouKensaku> OrderAT_TyouhyouKensakuByPkDesc(List<AT_TyouhyouKensaku> pEntity) {
        List<SortCondition<AT_TyouhyouKensaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_TyouhyouKensaku()).uniqueId, SortOrder.DESC));
        List<AT_TyouhyouKensaku> copyList = new ArrayList<AT_TyouhyouKensaku>(pEntity);
        Collections.sort(copyList, new OrderAT_TyouhyouKensaku(orders));
        return copyList;
    }

    public List<AT_TyouhyouKensaku> OrderAT_TyouhyouKensakuBySyoriYmdDescKensakuKeyAsc(List<AT_TyouhyouKensaku> pEntity) {
        List<SortCondition<AT_TyouhyouKensaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_TyouhyouKensaku()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_TyouhyouKensaku()).kensakuKey1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_TyouhyouKensaku()).kensakuKey2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_TyouhyouKensaku()).kensakuKey3, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_TyouhyouKensaku()).kensakuKey4, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_TyouhyouKensaku()).kensakuKey5, SortOrder.ASC));
        List<AT_TyouhyouKensaku> copyList = new ArrayList<AT_TyouhyouKensaku>(pEntity);
        Collections.sort(copyList, new OrderAT_TyouhyouKensaku(orders));
        return copyList;
    }
}
