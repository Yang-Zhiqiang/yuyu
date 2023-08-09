package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_GkknHnkuSyrSynypTukiRn;
import yuyu.def.db.meta.QZT_GkknHnkuSyrSynypTukiRn;
import yuyu.def.zdb.comparator.OrderZT_GkknHnkuSyrSynypTukiRn;

public class SortZT_GkknHnkuSyrSynypTukiRn {

    
    public List<ZT_GkknHnkuSyrSynypTukiRn> OrderZT_GkknHnkuSyrSynypTukiRnByPkAsc(List<ZT_GkknHnkuSyrSynypTukiRn> pEntity) {
        List<SortCondition<ZT_GkknHnkuSyrSynypTukiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GkknHnkuSyrSynypTukiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_GkknHnkuSyrSynypTukiRn> copyList = new ArrayList<ZT_GkknHnkuSyrSynypTukiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_GkknHnkuSyrSynypTukiRn(orders));
        return copyList;
    }

    
    public List<ZT_GkknHnkuSyrSynypTukiRn> OrderZT_GkknHnkuSyrSynypTukiRnByPkDesc(List<ZT_GkknHnkuSyrSynypTukiRn> pEntity) {
        List<SortCondition<ZT_GkknHnkuSyrSynypTukiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GkknHnkuSyrSynypTukiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_GkknHnkuSyrSynypTukiRn> copyList = new ArrayList<ZT_GkknHnkuSyrSynypTukiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_GkknHnkuSyrSynypTukiRn(orders));
        return copyList;
    }
}
