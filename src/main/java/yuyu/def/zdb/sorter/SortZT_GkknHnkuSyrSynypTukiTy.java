package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_GkknHnkuSyrSynypTukiTy;
import yuyu.def.db.meta.QZT_GkknHnkuSyrSynypTukiTy;
import yuyu.def.zdb.comparator.OrderZT_GkknHnkuSyrSynypTukiTy;

public class SortZT_GkknHnkuSyrSynypTukiTy {

    
    public List<ZT_GkknHnkuSyrSynypTukiTy> OrderZT_GkknHnkuSyrSynypTukiTyByPkAsc(List<ZT_GkknHnkuSyrSynypTukiTy> pEntity) {
        List<SortCondition<ZT_GkknHnkuSyrSynypTukiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GkknHnkuSyrSynypTukiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_GkknHnkuSyrSynypTukiTy> copyList = new ArrayList<ZT_GkknHnkuSyrSynypTukiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_GkknHnkuSyrSynypTukiTy(orders));
        return copyList;
    }

    
    public List<ZT_GkknHnkuSyrSynypTukiTy> OrderZT_GkknHnkuSyrSynypTukiTyByPkDesc(List<ZT_GkknHnkuSyrSynypTukiTy> pEntity) {
        List<SortCondition<ZT_GkknHnkuSyrSynypTukiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GkknHnkuSyrSynypTukiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_GkknHnkuSyrSynypTukiTy> copyList = new ArrayList<ZT_GkknHnkuSyrSynypTukiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_GkknHnkuSyrSynypTukiTy(orders));
        return copyList;
    }
}
