package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenTsryInfoTy;
import yuyu.def.db.meta.QZT_DrtenTsryInfoTy;
import yuyu.def.zdb.comparator.OrderZT_DrtenTsryInfoTy;

public class SortZT_DrtenTsryInfoTy {

    
    public List<ZT_DrtenTsryInfoTy> OrderZT_DrtenTsryInfoTyByPkAsc(List<ZT_DrtenTsryInfoTy> pEntity) {
        List<SortCondition<ZT_DrtenTsryInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoTy()).ztydairitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoTy()).ztybosyuunincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoTy()).ztykikaisyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoTy()).ztykykmfksnctrlkh, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoTy()).ztysikibetujyunjyo, SortOrder.ASC));
        List<ZT_DrtenTsryInfoTy> copyList = new ArrayList<ZT_DrtenTsryInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenTsryInfoTy(orders));
        return copyList;
    }

    
    public List<ZT_DrtenTsryInfoTy> OrderZT_DrtenTsryInfoTyByPkDesc(List<ZT_DrtenTsryInfoTy> pEntity) {
        List<SortCondition<ZT_DrtenTsryInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoTy()).ztydairitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoTy()).ztybosyuunincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoTy()).ztykikaisyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoTy()).ztykykmfksnctrlkh, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoTy()).ztysikibetujyunjyo, SortOrder.DESC));
        List<ZT_DrtenTsryInfoTy> copyList = new ArrayList<ZT_DrtenTsryInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenTsryInfoTy(orders));
        return copyList;
    }
}
