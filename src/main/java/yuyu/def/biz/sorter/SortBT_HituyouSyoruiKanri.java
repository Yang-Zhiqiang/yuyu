package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_HituyouSyoruiKanri;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.db.meta.QBT_HituyouSyoruiKanri;

public class SortBT_HituyouSyoruiKanri {

    public List<BT_HituyouSyoruiKanri> OrderBT_HituyouSyoruiKanriByPkAsc(List<BT_HituyouSyoruiKanri> pEntity) {
        List<SortCondition<BT_HituyouSyoruiKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HituyouSyoruiKanri()).kouteikanriid, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HituyouSyoruiKanri()).syoruiCd, SortOrder.ASC));
        List<BT_HituyouSyoruiKanri> copyList = new ArrayList<BT_HituyouSyoruiKanri>(pEntity);
        Collections.sort(copyList, new OrderBT_HituyouSyoruiKanri(orders));
        return copyList;
    }

    public List<BT_HituyouSyoruiKanri> OrderBT_HituyouSyoruiKanriByPkDesc(List<BT_HituyouSyoruiKanri> pEntity) {
        List<SortCondition<BT_HituyouSyoruiKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HituyouSyoruiKanri()).kouteikanriid, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HituyouSyoruiKanri()).syoruiCd, SortOrder.DESC));
        List<BT_HituyouSyoruiKanri> copyList = new ArrayList<BT_HituyouSyoruiKanri>(pEntity);
        Collections.sort(copyList, new OrderBT_HituyouSyoruiKanri(orders));
        return copyList;
    }

}

