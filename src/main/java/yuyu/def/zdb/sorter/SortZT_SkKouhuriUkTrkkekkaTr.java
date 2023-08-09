package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.db.meta.QZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.zdb.comparator.OrderZT_SkKouhuriUkTrkkekkaTr;

public class SortZT_SkKouhuriUkTrkkekkaTr {

    
    public List<ZT_SkKouhuriUkTrkkekkaTr> OrderZT_SkKouhuriUkTrkkekkaTrByPkAsc(List<ZT_SkKouhuriUkTrkkekkaTr> pEntity) {
        List<SortCondition<ZT_SkKouhuriUkTrkkekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaTr()).ztrsyukkncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaTr()).ztrkinyuukikancd8keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaTr()).ztrkinyuukkntratkiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaTr()).ztrkinyuukkntratkitime, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaTr()).ztrkouhuriokyakusamano, SortOrder.ASC));
        List<ZT_SkKouhuriUkTrkkekkaTr> copyList = new ArrayList<ZT_SkKouhuriUkTrkkekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKouhuriUkTrkkekkaTr(orders));
        return copyList;
    }

    
    public List<ZT_SkKouhuriUkTrkkekkaTr> OrderZT_SkKouhuriUkTrkkekkaTrByPkDesc(List<ZT_SkKouhuriUkTrkkekkaTr> pEntity) {
        List<SortCondition<ZT_SkKouhuriUkTrkkekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaTr()).ztrsyukkncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaTr()).ztrkinyuukikancd8keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaTr()).ztrkinyuukkntratkiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaTr()).ztrkinyuukkntratkitime, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKouhuriUkTrkkekkaTr()).ztrkouhuriokyakusamano, SortOrder.DESC));
        List<ZT_SkKouhuriUkTrkkekkaTr> copyList = new ArrayList<ZT_SkKouhuriUkTrkkekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKouhuriUkTrkkekkaTr(orders));
        return copyList;
    }
}
