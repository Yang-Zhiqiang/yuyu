package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoTy;
import yuyu.def.db.meta.QZT_JinsokuShrTtdkInfoTy;
import yuyu.def.zdb.comparator.OrderZT_JinsokuShrTtdkInfoTy;

public class SortZT_JinsokuShrTtdkInfoTy {

    
    public List<ZT_JinsokuShrTtdkInfoTy> OrderZT_JinsokuShrTtdkInfoTyByPkAsc(List<ZT_JinsokuShrTtdkInfoTy> pEntity) {
        List<SortCondition<ZT_JinsokuShrTtdkInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztysyorisosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztysyoricd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztyhknknshrsntkno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztysyoruiukeymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztysyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztydenymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztysyono, SortOrder.ASC));
        List<ZT_JinsokuShrTtdkInfoTy> copyList = new ArrayList<ZT_JinsokuShrTtdkInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_JinsokuShrTtdkInfoTy(orders));
        return copyList;
    }

    
    public List<ZT_JinsokuShrTtdkInfoTy> OrderZT_JinsokuShrTtdkInfoTyByPkDesc(List<ZT_JinsokuShrTtdkInfoTy> pEntity) {
        List<SortCondition<ZT_JinsokuShrTtdkInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztysyorisosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztysyoricd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztyhknknshrsntkno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztysyoruiukeymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztysyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztydenymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoTy()).ztysyono, SortOrder.DESC));
        List<ZT_JinsokuShrTtdkInfoTy> copyList = new ArrayList<ZT_JinsokuShrTtdkInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_JinsokuShrTtdkInfoTy(orders));
        return copyList;
    }
}
