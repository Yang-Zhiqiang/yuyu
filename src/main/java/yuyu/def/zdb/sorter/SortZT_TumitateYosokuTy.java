package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TumitateYosokuTy;
import yuyu.def.db.meta.QZT_TumitateYosokuTy;
import yuyu.def.zdb.comparator.OrderZT_TumitateYosokuTy;

public class SortZT_TumitateYosokuTy {

    
    public List<ZT_TumitateYosokuTy> OrderZT_TumitateYosokuTyByPkAsc(List<ZT_TumitateYosokuTy> pEntity) {
        List<SortCondition<ZT_TumitateYosokuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztyhknsyukigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztykeiyakuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztytysytymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztykyktuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztyhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztytmttknsyuruikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztysisuukbn, SortOrder.ASC));
        List<ZT_TumitateYosokuTy> copyList = new ArrayList<ZT_TumitateYosokuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TumitateYosokuTy(orders));
        return copyList;
    }

    
    public List<ZT_TumitateYosokuTy> OrderZT_TumitateYosokuTyByPkDesc(List<ZT_TumitateYosokuTy> pEntity) {
        List<SortCondition<ZT_TumitateYosokuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztyhknsyukigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztykeiyakuymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztytysytymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztykyktuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztyhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztytmttknsyuruikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuTy()).ztysisuukbn, SortOrder.DESC));
        List<ZT_TumitateYosokuTy> copyList = new ArrayList<ZT_TumitateYosokuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TumitateYosokuTy(orders));
        return copyList;
    }
}
