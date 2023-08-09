package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SntkInfoTourokuTy;
import yuyu.def.db.meta.QZT_SntkInfoTourokuTy;
import yuyu.def.zdb.comparator.OrderZT_SntkInfoTourokuTy;

public class SortZT_SntkInfoTourokuTy {

    
    public List<ZT_SntkInfoTourokuTy> OrderZT_SntkInfoTourokuTyByPkAsc(List<ZT_SntkInfoTourokuTy> pEntity) {
        List<SortCondition<ZT_SntkInfoTourokuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SntkInfoTourokuTy()).ztysntkinfono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SntkInfoTourokuTy()).ztyrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SntkInfoTourokuTy()).ztysntkinfotourokusyskbn, SortOrder.ASC));
        List<ZT_SntkInfoTourokuTy> copyList = new ArrayList<ZT_SntkInfoTourokuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SntkInfoTourokuTy(orders));
        return copyList;
    }

    
    public List<ZT_SntkInfoTourokuTy> OrderZT_SntkInfoTourokuTyByPkDesc(List<ZT_SntkInfoTourokuTy> pEntity) {
        List<SortCondition<ZT_SntkInfoTourokuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SntkInfoTourokuTy()).ztysntkinfono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SntkInfoTourokuTy()).ztyrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SntkInfoTourokuTy()).ztysntkinfotourokusyskbn, SortOrder.DESC));
        List<ZT_SntkInfoTourokuTy> copyList = new ArrayList<ZT_SntkInfoTourokuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SntkInfoTourokuTy(orders));
        return copyList;
    }
}
