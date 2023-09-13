package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsNeugokiHanteiKekka;
import yuyu.def.db.meta.QMT_DsNeugokiHanteiKekka;
import yuyu.def.direct.comparator.OrderMT_DsNeugokiHanteiKekka;

public class SortMT_DsNeugokiHanteiKekka {

    public List<MT_DsNeugokiHanteiKekka> OrderMT_DsNeugokiHanteiKekkaByPkAsc(List<MT_DsNeugokiHanteiKekka> pEntity) {
        List<SortCondition<MT_DsNeugokiHanteiKekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsNeugokiHanteiKekka()).dsdatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsNeugokiHanteiKekka()).syono, SortOrder.ASC));
        List<MT_DsNeugokiHanteiKekka> copyList = new ArrayList<MT_DsNeugokiHanteiKekka>(pEntity);
        Collections.sort(copyList, new OrderMT_DsNeugokiHanteiKekka(orders));
        return copyList;
    }

    public List<MT_DsNeugokiHanteiKekka> OrderMT_DsNeugokiHanteiKekkaByPkDesc(List<MT_DsNeugokiHanteiKekka> pEntity) {
        List<SortCondition<MT_DsNeugokiHanteiKekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsNeugokiHanteiKekka()).dsdatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsNeugokiHanteiKekka()).syono, SortOrder.DESC));
        List<MT_DsNeugokiHanteiKekka> copyList = new ArrayList<MT_DsNeugokiHanteiKekka>(pEntity);
        Collections.sort(copyList, new OrderMT_DsNeugokiHanteiKekka(orders));
        return copyList;
    }
}
