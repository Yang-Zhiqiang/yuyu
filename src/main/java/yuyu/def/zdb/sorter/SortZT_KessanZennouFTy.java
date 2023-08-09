package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KessanZennouFTy;
import yuyu.def.db.meta.QZT_KessanZennouFTy;
import yuyu.def.zdb.comparator.OrderZT_KessanZennouFTy;

public class SortZT_KessanZennouFTy {

    
    public List<ZT_KessanZennouFTy> OrderZT_KessanZennouFTyByPkAsc(List<ZT_KessanZennouFTy> pEntity) {
        List<SortCondition<ZT_KessanZennouFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KessanZennouFTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KessanZennouFTy()).ztykbnkeiriyousegmentcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KessanZennouFTy()).ztyzennoutoukeilistkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KessanZennouFTy()).ztyzennoukbn, SortOrder.ASC));
        List<ZT_KessanZennouFTy> copyList = new ArrayList<ZT_KessanZennouFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KessanZennouFTy(orders));
        return copyList;
    }

    
    public List<ZT_KessanZennouFTy> OrderZT_KessanZennouFTyByPkDesc(List<ZT_KessanZennouFTy> pEntity) {
        List<SortCondition<ZT_KessanZennouFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KessanZennouFTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KessanZennouFTy()).ztykbnkeiriyousegmentcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KessanZennouFTy()).ztyzennoutoukeilistkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KessanZennouFTy()).ztyzennoukbn, SortOrder.DESC));
        List<ZT_KessanZennouFTy> copyList = new ArrayList<ZT_KessanZennouFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KessanZennouFTy(orders));
        return copyList;
    }
}
