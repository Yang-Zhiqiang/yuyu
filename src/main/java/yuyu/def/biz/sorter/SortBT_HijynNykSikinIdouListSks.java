package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_HijynNykSikinIdouListSks;
import yuyu.def.db.entity.BT_HijynNykSikinIdouListSks;
import yuyu.def.db.meta.QBT_HijynNykSikinIdouListSks;

public class SortBT_HijynNykSikinIdouListSks {

    public List<BT_HijynNykSikinIdouListSks> OrderBT_HijynNykSikinIdouListSksByPkAsc(List<BT_HijynNykSikinIdouListSks> pEntity) {
        List<SortCondition<BT_HijynNykSikinIdouListSks>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HijynNykSikinIdouListSks()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HijynNykSikinIdouListSks()).sikinidoupjytym, SortOrder.ASC));
        List<BT_HijynNykSikinIdouListSks> copyList = new ArrayList<BT_HijynNykSikinIdouListSks>(pEntity);
        Collections.sort(copyList, new OrderBT_HijynNykSikinIdouListSks(orders));
        return copyList;
    }

    public List<BT_HijynNykSikinIdouListSks> OrderBT_HijynNykSikinIdouListSksByPkDesc(List<BT_HijynNykSikinIdouListSks> pEntity) {
        List<SortCondition<BT_HijynNykSikinIdouListSks>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HijynNykSikinIdouListSks()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HijynNykSikinIdouListSks()).sikinidoupjytym, SortOrder.DESC));
        List<BT_HijynNykSikinIdouListSks> copyList = new ArrayList<BT_HijynNykSikinIdouListSks>(pEntity);
        Collections.sort(copyList, new OrderBT_HijynNykSikinIdouListSks(orders));
        return copyList;
    }
}
