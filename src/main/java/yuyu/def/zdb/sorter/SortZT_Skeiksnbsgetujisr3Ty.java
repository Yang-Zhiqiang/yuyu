package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr3Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr3Ty;
import yuyu.def.zdb.comparator.OrderZT_Skeiksnbsgetujisr3Ty;

public class SortZT_Skeiksnbsgetujisr3Ty {

    
    public List<ZT_Skeiksnbsgetujisr3Ty> OrderZT_Skeiksnbsgetujisr3TyByPkAsc(List<ZT_Skeiksnbsgetujisr3Ty> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr3Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr3Ty()).ztyktgysyono, SortOrder.ASC));
        List<ZT_Skeiksnbsgetujisr3Ty> copyList = new ArrayList<ZT_Skeiksnbsgetujisr3Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr3Ty(orders));
        return copyList;
    }

    
    public List<ZT_Skeiksnbsgetujisr3Ty> OrderZT_Skeiksnbsgetujisr3TyByPkDesc(List<ZT_Skeiksnbsgetujisr3Ty> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr3Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr3Ty()).ztyktgysyono, SortOrder.DESC));
        List<ZT_Skeiksnbsgetujisr3Ty> copyList = new ArrayList<ZT_Skeiksnbsgetujisr3Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr3Ty(orders));
        return copyList;
    }
}
