package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinkimatuHoyuuFRn;
import yuyu.def.db.meta.QZT_SinkimatuHoyuuFRn;
import yuyu.def.zdb.comparator.OrderZT_SinkimatuHoyuuFRn;

public class SortZT_SinkimatuHoyuuFRn {

    
    public List<ZT_SinkimatuHoyuuFRn> OrderZT_SinkimatuHoyuuFRnByPkAsc(List<ZT_SinkimatuHoyuuFRn> pEntity) {
        List<SortCondition<ZT_SinkimatuHoyuuFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkimatuHoyuuFRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_SinkimatuHoyuuFRn> copyList = new ArrayList<ZT_SinkimatuHoyuuFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkimatuHoyuuFRn(orders));
        return copyList;
    }

    
    public List<ZT_SinkimatuHoyuuFRn> OrderZT_SinkimatuHoyuuFRnByPkDesc(List<ZT_SinkimatuHoyuuFRn> pEntity) {
        List<SortCondition<ZT_SinkimatuHoyuuFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkimatuHoyuuFRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_SinkimatuHoyuuFRn> copyList = new ArrayList<ZT_SinkimatuHoyuuFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkimatuHoyuuFRn(orders));
        return copyList;
    }
}
