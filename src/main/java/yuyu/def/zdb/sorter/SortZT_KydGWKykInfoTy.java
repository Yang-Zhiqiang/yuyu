package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KydGWKykInfoTy;
import yuyu.def.db.meta.QZT_KydGWKykInfoTy;
import yuyu.def.zdb.comparator.OrderZT_KydGWKykInfoTy;

public class SortZT_KydGWKykInfoTy {

    
    public List<ZT_KydGWKykInfoTy> OrderZT_KydGWKykInfoTyByPkAsc(List<ZT_KydGWKykInfoTy> pEntity) {
        List<SortCondition<ZT_KydGWKykInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KydGWKykInfoTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KydGWKykInfoTy()).ztysyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KydGWKykInfoTy()).ztykykmfksnctrlkh, SortOrder.ASC));
        List<ZT_KydGWKykInfoTy> copyList = new ArrayList<ZT_KydGWKykInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KydGWKykInfoTy(orders));
        return copyList;
    }

    
    public List<ZT_KydGWKykInfoTy> OrderZT_KydGWKykInfoTyByPkDesc(List<ZT_KydGWKykInfoTy> pEntity) {
        List<SortCondition<ZT_KydGWKykInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KydGWKykInfoTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KydGWKykInfoTy()).ztysyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KydGWKykInfoTy()).ztykykmfksnctrlkh, SortOrder.DESC));
        List<ZT_KydGWKykInfoTy> copyList = new ArrayList<ZT_KydGWKykInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KydGWKykInfoTy(orders));
        return copyList;
    }
}
