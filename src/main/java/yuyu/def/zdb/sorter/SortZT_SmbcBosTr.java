package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SmbcBosTr;
import yuyu.def.db.meta.QZT_SmbcBosTr;
import yuyu.def.zdb.comparator.OrderZT_SmbcBosTr;

public class SortZT_SmbcBosTr {

    
    public List<ZT_SmbcBosTr> OrderZT_SmbcBosTrByPkAsc(List<ZT_SmbcBosTr> pEntity) {
        List<SortCondition<ZT_SmbcBosTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcBosTr()).ztrseihowebidkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcBosTr()).ztrseihowebkojincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcBosTr()).ztrseihowebitijihozonhyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcBosTr()).ztrseihowebsekno, SortOrder.ASC));
        List<ZT_SmbcBosTr> copyList = new ArrayList<ZT_SmbcBosTr>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcBosTr(orders));
        return copyList;
    }

    
    public List<ZT_SmbcBosTr> OrderZT_SmbcBosTrByPkDesc(List<ZT_SmbcBosTr> pEntity) {
        List<SortCondition<ZT_SmbcBosTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcBosTr()).ztrseihowebidkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcBosTr()).ztrseihowebkojincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcBosTr()).ztrseihowebitijihozonhyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcBosTr()).ztrseihowebsekno, SortOrder.DESC));
        List<ZT_SmbcBosTr> copyList = new ArrayList<ZT_SmbcBosTr>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcBosTr(orders));
        return copyList;
    }
}
