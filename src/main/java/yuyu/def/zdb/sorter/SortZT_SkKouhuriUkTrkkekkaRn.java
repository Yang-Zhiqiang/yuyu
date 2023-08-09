package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.db.meta.QZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.zdb.comparator.OrderZT_SkKouhuriUkTrkkekkaRn;

public class SortZT_SkKouhuriUkTrkkekkaRn {

    
    public List<ZT_SkKouhuriUkTrkkekkaRn> OrderZT_SkKouhuriUkTrkkekkaRnByPkAsc(List<ZT_SkKouhuriUkTrkkekkaRn> pEntity) {
        List<SortCondition<ZT_SkKouhuriUkTrkkekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaRn()).zrnsyukkncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaRn()).zrnkinyuukikancd8keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaRn()).zrnkinyuukkntratkiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaRn()).zrnkinyuukkntratkitime, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaRn()).zrnkouhuriokyakusamano, SortOrder.ASC));
        List<ZT_SkKouhuriUkTrkkekkaRn> copyList = new ArrayList<ZT_SkKouhuriUkTrkkekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKouhuriUkTrkkekkaRn(orders));
        return copyList;
    }

    
    public List<ZT_SkKouhuriUkTrkkekkaRn> OrderZT_SkKouhuriUkTrkkekkaRnByPkDesc(List<ZT_SkKouhuriUkTrkkekkaRn> pEntity) {
        List<SortCondition<ZT_SkKouhuriUkTrkkekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaRn()).zrnsyukkncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaRn()).zrnkinyuukikancd8keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaRn()).zrnkinyuukkntratkiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaRn()).zrnkinyuukkntratkitime, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaRn()).zrnkouhuriokyakusamano, SortOrder.DESC));
        List<ZT_SkKouhuriUkTrkkekkaRn> copyList = new ArrayList<ZT_SkKouhuriUkTrkkekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKouhuriUkTrkkekkaRn(orders));
        return copyList;
    }
}
