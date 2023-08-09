package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SmbcPaperlessMos1Tr;
import yuyu.def.db.meta.QZT_SmbcPaperlessMos1Tr;
import yuyu.def.zdb.comparator.OrderZT_SmbcPaperlessMos1Tr;

public class SortZT_SmbcPaperlessMos1Tr {

    
    public List<ZT_SmbcPaperlessMos1Tr> OrderZT_SmbcPaperlessMos1TrByPkAsc(List<ZT_SmbcPaperlessMos1Tr> pEntity) {
        List<SortCondition<ZT_SmbcPaperlessMos1Tr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos1Tr()).ztrseihowebidkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos1Tr()).ztrseihowebkojincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos1Tr()).ztrseihowebitijihozonhyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos1Tr()).ztrseihowebseknoc, SortOrder.ASC));
        List<ZT_SmbcPaperlessMos1Tr> copyList = new ArrayList<ZT_SmbcPaperlessMos1Tr>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcPaperlessMos1Tr(orders));
        return copyList;
    }

    
    public List<ZT_SmbcPaperlessMos1Tr> OrderZT_SmbcPaperlessMos1TrByPkDesc(List<ZT_SmbcPaperlessMos1Tr> pEntity) {
        List<SortCondition<ZT_SmbcPaperlessMos1Tr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos1Tr()).ztrseihowebidkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos1Tr()).ztrseihowebkojincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos1Tr()).ztrseihowebitijihozonhyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcPaperlessMos1Tr()).ztrseihowebseknoc, SortOrder.DESC));
        List<ZT_SmbcPaperlessMos1Tr> copyList = new ArrayList<ZT_SmbcPaperlessMos1Tr>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcPaperlessMos1Tr(orders));
        return copyList;
    }
}
