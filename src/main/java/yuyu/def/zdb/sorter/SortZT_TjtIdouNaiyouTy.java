package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouTy;
import yuyu.def.db.meta.QZT_TjtIdouNaiyouTy;
import yuyu.def.zdb.comparator.OrderZT_TjtIdouNaiyouTy;

public class SortZT_TjtIdouNaiyouTy {

    
    public List<ZT_TjtIdouNaiyouTy> OrderZT_TjtIdouNaiyouTyByPkAsc(List<ZT_TjtIdouNaiyouTy> pEntity) {
        List<SortCondition<ZT_TjtIdouNaiyouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjtIdouNaiyouTy()).ztyhuho2kyknokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TjtIdouNaiyouTy()).ztyhuho2kykno, SortOrder.ASC));
        List<ZT_TjtIdouNaiyouTy> copyList = new ArrayList<ZT_TjtIdouNaiyouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TjtIdouNaiyouTy(orders));
        return copyList;
    }

    
    public List<ZT_TjtIdouNaiyouTy> OrderZT_TjtIdouNaiyouTyByPkDesc(List<ZT_TjtIdouNaiyouTy> pEntity) {
        List<SortCondition<ZT_TjtIdouNaiyouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjtIdouNaiyouTy()).ztyhuho2kyknokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TjtIdouNaiyouTy()).ztyhuho2kykno, SortOrder.DESC));
        List<ZT_TjtIdouNaiyouTy> copyList = new ArrayList<ZT_TjtIdouNaiyouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TjtIdouNaiyouTy(orders));
        return copyList;
    }
}
