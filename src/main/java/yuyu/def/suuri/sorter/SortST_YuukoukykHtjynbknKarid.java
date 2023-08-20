package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknKarid;
import yuyu.def.db.meta.QST_YuukoukykHtjynbknKarid;
import yuyu.def.suuri.comparator.OrderST_YuukoukykHtjynbknKarid;

public class SortST_YuukoukykHtjynbknKarid {

    
    public List<ST_YuukoukykHtjynbknKarid> OrderST_YuukoukykHtjynbknKaridByPkAsc(List<ST_YuukoukykHtjynbknKarid> pEntity) {
        List<SortCondition<ST_YuukoukykHtjynbknKarid>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknKarid()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknKarid()).kakutyoujobcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknKarid()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknKarid()).srkijyunym, SortOrder.ASC));
        List<ST_YuukoukykHtjynbknKarid> copyList = new ArrayList<ST_YuukoukykHtjynbknKarid>(pEntity);
        Collections.sort(copyList, new OrderST_YuukoukykHtjynbknKarid(orders));
        return copyList;
    }

    
    public List<ST_YuukoukykHtjynbknKarid> OrderST_YuukoukykHtjynbknKaridByPkDesc(List<ST_YuukoukykHtjynbknKarid> pEntity) {
        List<SortCondition<ST_YuukoukykHtjynbknKarid>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknKarid()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknKarid()).kakutyoujobcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknKarid()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknKarid()).srkijyunym, SortOrder.DESC));
        List<ST_YuukoukykHtjynbknKarid> copyList = new ArrayList<ST_YuukoukykHtjynbknKarid>(pEntity);
        Collections.sort(copyList, new OrderST_YuukoukykHtjynbknKarid(orders));
        return copyList;
    }
}
