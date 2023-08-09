package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkeisynyptoukeiksnTy;
import yuyu.def.db.meta.QZT_SkeisynyptoukeiksnTy;
import yuyu.def.zdb.comparator.OrderZT_SkeisynyptoukeiksnTy;

public class SortZT_SkeisynyptoukeiksnTy {

    
    public List<ZT_SkeisynyptoukeiksnTy> OrderZT_SkeisynyptoukeiksnTyByPkAsc(List<ZT_SkeisynyptoukeiksnTy> pEntity) {
        List<SortCondition<ZT_SkeisynyptoukeiksnTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkeisynyptoukeiksnTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_SkeisynyptoukeiksnTy> copyList = new ArrayList<ZT_SkeisynyptoukeiksnTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkeisynyptoukeiksnTy(orders));
        return copyList;
    }

    
    public List<ZT_SkeisynyptoukeiksnTy> OrderZT_SkeisynyptoukeiksnTyByPkDesc(List<ZT_SkeisynyptoukeiksnTy> pEntity) {
        List<SortCondition<ZT_SkeisynyptoukeiksnTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkeisynyptoukeiksnTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_SkeisynyptoukeiksnTy> copyList = new ArrayList<ZT_SkeisynyptoukeiksnTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkeisynyptoukeiksnTy(orders));
        return copyList;
    }
}
