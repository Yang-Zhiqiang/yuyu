package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_HijynNykSiknIdouLstSksGk;
import yuyu.def.db.entity.BT_HijynNykSiknIdouLstSksGk;
import yuyu.def.db.meta.QBT_HijynNykSiknIdouLstSksGk;

public class SortBT_HijynNykSiknIdouLstSksGk {

    public List<BT_HijynNykSiknIdouLstSksGk> OrderBT_HijynNykSiknIdouLstSksGkByPkAsc(List<BT_HijynNykSiknIdouLstSksGk> pEntity) {
        List<SortCondition<BT_HijynNykSiknIdouLstSksGk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HijynNykSiknIdouLstSksGk()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HijynNykSiknIdouLstSksGk()).sikinidoupkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HijynNykSiknIdouLstSksGk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HijynNykSiknIdouLstSksGk()).renno, SortOrder.ASC));
        List<BT_HijynNykSiknIdouLstSksGk> copyList = new ArrayList<BT_HijynNykSiknIdouLstSksGk>(pEntity);
        Collections.sort(copyList, new OrderBT_HijynNykSiknIdouLstSksGk(orders));
        return copyList;
    }

    public List<BT_HijynNykSiknIdouLstSksGk> OrderBT_HijynNykSiknIdouLstSksGkByPkDesc(List<BT_HijynNykSiknIdouLstSksGk> pEntity) {
        List<SortCondition<BT_HijynNykSiknIdouLstSksGk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HijynNykSiknIdouLstSksGk()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HijynNykSiknIdouLstSksGk()).sikinidoupkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HijynNykSiknIdouLstSksGk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HijynNykSiknIdouLstSksGk()).renno, SortOrder.DESC));
        List<BT_HijynNykSiknIdouLstSksGk> copyList = new ArrayList<BT_HijynNykSiknIdouLstSksGk>(pEntity);
        Collections.sort(copyList, new OrderBT_HijynNykSiknIdouLstSksGk(orders));
        return copyList;
    }
}
