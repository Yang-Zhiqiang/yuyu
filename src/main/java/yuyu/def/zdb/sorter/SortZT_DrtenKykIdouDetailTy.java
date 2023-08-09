package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenKykIdouDetailTy;
import yuyu.def.db.meta.QZT_DrtenKykIdouDetailTy;
import yuyu.def.zdb.comparator.OrderZT_DrtenKykIdouDetailTy;

public class SortZT_DrtenKykIdouDetailTy {

    
    public List<ZT_DrtenKykIdouDetailTy> OrderZT_DrtenKykIdouDetailTyByPkAsc(List<ZT_DrtenKykIdouDetailTy> pEntity) {
        List<SortCondition<ZT_DrtenKykIdouDetailTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailTy()).ztybsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailTy()).ztybosyuunincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailTy()).ztyidouhasseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailTy()).ztyidoukbn, SortOrder.ASC));
        List<ZT_DrtenKykIdouDetailTy> copyList = new ArrayList<ZT_DrtenKykIdouDetailTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenKykIdouDetailTy(orders));
        return copyList;
    }

    
    public List<ZT_DrtenKykIdouDetailTy> OrderZT_DrtenKykIdouDetailTyByPkDesc(List<ZT_DrtenKykIdouDetailTy> pEntity) {
        List<SortCondition<ZT_DrtenKykIdouDetailTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailTy()).ztybsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailTy()).ztybosyuunincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailTy()).ztyidouhasseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailTy()).ztyidoukbn, SortOrder.DESC));
        List<ZT_DrtenKykIdouDetailTy> copyList = new ArrayList<ZT_DrtenKykIdouDetailTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenKykIdouDetailTy(orders));
        return copyList;
    }
}
