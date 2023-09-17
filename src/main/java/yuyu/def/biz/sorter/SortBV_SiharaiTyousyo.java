package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBV_SiharaiTyousyo;
import yuyu.def.db.entity.BV_SiharaiTyousyo;
import yuyu.def.db.meta.QBV_SiharaiTyousyo;

public class SortBV_SiharaiTyousyo {

    public List<BV_SiharaiTyousyo> OrderBV_SiharaiTyousyoByPkAsc(List<BV_SiharaiTyousyo> pEntity) {
        List<SortCondition<BV_SiharaiTyousyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBV_SiharaiTyousyo()).subSystemId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBV_SiharaiTyousyo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBV_SiharaiTyousyo()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBV_SiharaiTyousyo()).shrtysyrenno, SortOrder.ASC));
        List<BV_SiharaiTyousyo> copyList = new ArrayList<BV_SiharaiTyousyo>(pEntity);
        Collections.sort(copyList, new OrderBV_SiharaiTyousyo(orders));
        return copyList;
    }

    public List<BV_SiharaiTyousyo> OrderBV_SiharaiTyousyoByPkDesc(List<BV_SiharaiTyousyo> pEntity) {
        List<SortCondition<BV_SiharaiTyousyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBV_SiharaiTyousyo()).subSystemId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBV_SiharaiTyousyo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBV_SiharaiTyousyo()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBV_SiharaiTyousyo()).shrtysyrenno, SortOrder.DESC));
        List<BV_SiharaiTyousyo> copyList = new ArrayList<BV_SiharaiTyousyo>(pEntity);
        Collections.sort(copyList, new OrderBV_SiharaiTyousyo(orders));
        return copyList;
    }
}
