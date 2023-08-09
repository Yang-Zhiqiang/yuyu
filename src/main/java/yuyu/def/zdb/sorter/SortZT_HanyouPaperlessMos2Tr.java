package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HanyouPaperlessMos2Tr;
import yuyu.def.db.meta.QZT_HanyouPaperlessMos2Tr;
import yuyu.def.zdb.comparator.OrderZT_HanyouPaperlessMos2Tr;

public class SortZT_HanyouPaperlessMos2Tr {

    
    public List<ZT_HanyouPaperlessMos2Tr> OrderZT_HanyouPaperlessMos2TrByPkAsc(List<ZT_HanyouPaperlessMos2Tr> pEntity) {
        List<SortCondition<ZT_HanyouPaperlessMos2Tr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos2Tr()).ztrseihowebidkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos2Tr()).ztrseihowebkojincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos2Tr()).ztrseihowebitijihozonhyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos2Tr()).ztrseihowebseknoc, SortOrder.ASC));
        List<ZT_HanyouPaperlessMos2Tr> copyList = new ArrayList<ZT_HanyouPaperlessMos2Tr>(pEntity);
        Collections.sort(copyList, new OrderZT_HanyouPaperlessMos2Tr(orders));
        return copyList;
    }

    
    public List<ZT_HanyouPaperlessMos2Tr> OrderZT_HanyouPaperlessMos2TrByPkDesc(List<ZT_HanyouPaperlessMos2Tr> pEntity) {
        List<SortCondition<ZT_HanyouPaperlessMos2Tr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos2Tr()).ztrseihowebidkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos2Tr()).ztrseihowebkojincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos2Tr()).ztrseihowebitijihozonhyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HanyouPaperlessMos2Tr()).ztrseihowebseknoc, SortOrder.DESC));
        List<ZT_HanyouPaperlessMos2Tr> copyList = new ArrayList<ZT_HanyouPaperlessMos2Tr>(pEntity);
        Collections.sort(copyList, new OrderZT_HanyouPaperlessMos2Tr(orders));
        return copyList;
    }
}
