package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenIpToukeiTy;
import yuyu.def.db.meta.QZT_DrtenIpToukeiTy;
import yuyu.def.zdb.comparator.OrderZT_DrtenIpToukeiTy;

public class SortZT_DrtenIpToukeiTy {

    
    public List<ZT_DrtenIpToukeiTy> OrderZT_DrtenIpToukeiTyByPkAsc(List<ZT_DrtenIpToukeiTy> pEntity) {
        List<SortCondition<ZT_DrtenIpToukeiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiTy()).ztyeigyouhonbusisyacd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiTy()).ztysosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiTy()).ztyatukaikojincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiTy()).ztymosym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiTy()).ztymosno, SortOrder.ASC));
        List<ZT_DrtenIpToukeiTy> copyList = new ArrayList<ZT_DrtenIpToukeiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenIpToukeiTy(orders));
        return copyList;
    }

    
    public List<ZT_DrtenIpToukeiTy> OrderZT_DrtenIpToukeiTyByPkDesc(List<ZT_DrtenIpToukeiTy> pEntity) {
        List<SortCondition<ZT_DrtenIpToukeiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiTy()).ztyeigyouhonbusisyacd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiTy()).ztysosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiTy()).ztyatukaikojincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiTy()).ztymosym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiTy()).ztymosno, SortOrder.DESC));
        List<ZT_DrtenIpToukeiTy> copyList = new ArrayList<ZT_DrtenIpToukeiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenIpToukeiTy(orders));
        return copyList;
    }
}
