package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SmbcPaperlessMos2Tr;
import yuyu.def.db.meta.QZT_SmbcPaperlessMos2Tr;
import yuyu.def.zdb.comparator.OrderZT_SmbcPaperlessMos2Tr;

public class SortZT_SmbcPaperlessMos2Tr {

    
    public List<ZT_SmbcPaperlessMos2Tr> OrderZT_SmbcPaperlessMos2TrByPkAsc(List<ZT_SmbcPaperlessMos2Tr> pEntity) {
        List<SortCondition<ZT_SmbcPaperlessMos2Tr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos2Tr()).ztrseihowebidkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos2Tr()).ztrseihowebkojincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos2Tr()).ztrseihowebitijihozonhyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos2Tr()).ztrseihowebseknoc, SortOrder.ASC));
        List<ZT_SmbcPaperlessMos2Tr> copyList = new ArrayList<ZT_SmbcPaperlessMos2Tr>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcPaperlessMos2Tr(orders));
        return copyList;
    }

    
    public List<ZT_SmbcPaperlessMos2Tr> OrderZT_SmbcPaperlessMos2TrByPkDesc(List<ZT_SmbcPaperlessMos2Tr> pEntity) {
        List<SortCondition<ZT_SmbcPaperlessMos2Tr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos2Tr()).ztrseihowebidkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos2Tr()).ztrseihowebkojincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos2Tr()).ztrseihowebitijihozonhyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos2Tr()).ztrseihowebseknoc, SortOrder.DESC));
        List<ZT_SmbcPaperlessMos2Tr> copyList = new ArrayList<ZT_SmbcPaperlessMos2Tr>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcPaperlessMos2Tr(orders));
        return copyList;
    }
}
