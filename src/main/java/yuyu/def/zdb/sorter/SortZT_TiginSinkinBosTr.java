package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TiginSinkinBosTr;
import yuyu.def.db.meta.QZT_TiginSinkinBosTr;
import yuyu.def.zdb.comparator.OrderZT_TiginSinkinBosTr;

public class SortZT_TiginSinkinBosTr {

    
    public List<ZT_TiginSinkinBosTr> OrderZT_TiginSinkinBosTrByPkAsc(List<ZT_TiginSinkinBosTr> pEntity) {
        List<SortCondition<ZT_TiginSinkinBosTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosTr()).ztrseihowebidkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosTr()).ztrseihowebkojincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosTr()).ztrseihowebitijihozonhyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosTr()).ztrseihowebsekno, SortOrder.ASC));
        List<ZT_TiginSinkinBosTr> copyList = new ArrayList<ZT_TiginSinkinBosTr>(pEntity);
        Collections.sort(copyList, new OrderZT_TiginSinkinBosTr(orders));
        return copyList;
    }

    
    public List<ZT_TiginSinkinBosTr> OrderZT_TiginSinkinBosTrByPkDesc(List<ZT_TiginSinkinBosTr> pEntity) {
        List<SortCondition<ZT_TiginSinkinBosTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosTr()).ztrseihowebidkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosTr()).ztrseihowebkojincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosTr()).ztrseihowebitijihozonhyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosTr()).ztrseihowebsekno, SortOrder.DESC));
        List<ZT_TiginSinkinBosTr> copyList = new ArrayList<ZT_TiginSinkinBosTr>(pEntity);
        Collections.sort(copyList, new OrderZT_TiginSinkinBosTr(orders));
        return copyList;
    }
}
