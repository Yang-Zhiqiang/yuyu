package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_KijituTouraiHonbanKensyou;
import yuyu.def.db.entity.BT_KijituTouraiHonbanKensyou;
import yuyu.def.db.meta.QBT_KijituTouraiHonbanKensyou;

public class SortBT_KijituTouraiHonbanKensyou {

    public List<BT_KijituTouraiHonbanKensyou> OrderBT_KijituTouraiHonbanKensyouByPkAsc(List<BT_KijituTouraiHonbanKensyou> pEntity) {
        List<SortCondition<BT_KijituTouraiHonbanKensyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_KijituTouraiHonbanKensyou()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_KijituTouraiHonbanKensyou()).subSystemId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_KijituTouraiHonbanKensyou()).tysytno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_KijituTouraiHonbanKensyou()).datakanrino, SortOrder.ASC));
        List<BT_KijituTouraiHonbanKensyou> copyList = new ArrayList<BT_KijituTouraiHonbanKensyou>(pEntity);
        Collections.sort(copyList, new OrderBT_KijituTouraiHonbanKensyou(orders));
        return copyList;
    }

    public List<BT_KijituTouraiHonbanKensyou> OrderBT_KijituTouraiHonbanKensyouByPkDesc(List<BT_KijituTouraiHonbanKensyou> pEntity) {
        List<SortCondition<BT_KijituTouraiHonbanKensyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_KijituTouraiHonbanKensyou()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_KijituTouraiHonbanKensyou()).subSystemId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_KijituTouraiHonbanKensyou()).tysytno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_KijituTouraiHonbanKensyou()).datakanrino, SortOrder.DESC));
        List<BT_KijituTouraiHonbanKensyou> copyList = new ArrayList<BT_KijituTouraiHonbanKensyou>(pEntity);
        Collections.sort(copyList, new OrderBT_KijituTouraiHonbanKensyou(orders));
        return copyList;
    }
}
