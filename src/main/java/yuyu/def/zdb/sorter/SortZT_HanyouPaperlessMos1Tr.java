package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.meta.QZT_HanyouPaperlessMos1Tr;
import yuyu.def.zdb.comparator.OrderZT_HanyouPaperlessMos1Tr;

public class SortZT_HanyouPaperlessMos1Tr {

    
    public List<ZT_HanyouPaperlessMos1Tr> OrderZT_HanyouPaperlessMos1TrByPkAsc(List<ZT_HanyouPaperlessMos1Tr> pEntity) {
        List<SortCondition<ZT_HanyouPaperlessMos1Tr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos1Tr()).ztrseihowebidkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos1Tr()).ztrseihowebkojincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos1Tr()).ztrseihowebitijihozonhyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos1Tr()).ztrseihowebseknoc, SortOrder.ASC));
        List<ZT_HanyouPaperlessMos1Tr> copyList = new ArrayList<ZT_HanyouPaperlessMos1Tr>(pEntity);
        Collections.sort(copyList, new OrderZT_HanyouPaperlessMos1Tr(orders));
        return copyList;
    }

    
    public List<ZT_HanyouPaperlessMos1Tr> OrderZT_HanyouPaperlessMos1TrByPkDesc(List<ZT_HanyouPaperlessMos1Tr> pEntity) {
        List<SortCondition<ZT_HanyouPaperlessMos1Tr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos1Tr()).ztrseihowebidkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos1Tr()).ztrseihowebkojincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos1Tr()).ztrseihowebitijihozonhyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos1Tr()).ztrseihowebseknoc, SortOrder.DESC));
        List<ZT_HanyouPaperlessMos1Tr> copyList = new ArrayList<ZT_HanyouPaperlessMos1Tr>(pEntity);
        Collections.sort(copyList, new OrderZT_HanyouPaperlessMos1Tr(orders));
        return copyList;
    }
}
