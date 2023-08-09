package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr5Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr5Ty;
import yuyu.def.zdb.comparator.OrderZT_Skeiksnbsgetujisr5Ty;

public class SortZT_Skeiksnbsgetujisr5Ty {

    
    public List<ZT_Skeiksnbsgetujisr5Ty> OrderZT_Skeiksnbsgetujisr5TyByPkAsc(List<ZT_Skeiksnbsgetujisr5Ty> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr5Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr5Ty()).ztyktgysyono, SortOrder.ASC));
        List<ZT_Skeiksnbsgetujisr5Ty> copyList = new ArrayList<ZT_Skeiksnbsgetujisr5Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr5Ty(orders));
        return copyList;
    }

    
    public List<ZT_Skeiksnbsgetujisr5Ty> OrderZT_Skeiksnbsgetujisr5TyByPkDesc(List<ZT_Skeiksnbsgetujisr5Ty> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr5Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr5Ty()).ztyktgysyono, SortOrder.DESC));
        List<ZT_Skeiksnbsgetujisr5Ty> copyList = new ArrayList<ZT_Skeiksnbsgetujisr5Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr5Ty(orders));
        return copyList;
    }
}
