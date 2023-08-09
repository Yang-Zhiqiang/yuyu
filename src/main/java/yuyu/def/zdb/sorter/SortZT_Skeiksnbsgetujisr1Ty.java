package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr1Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr1Ty;
import yuyu.def.zdb.comparator.OrderZT_Skeiksnbsgetujisr1Ty;

public class SortZT_Skeiksnbsgetujisr1Ty {

    
    public List<ZT_Skeiksnbsgetujisr1Ty> OrderZT_Skeiksnbsgetujisr1TyByPkAsc(List<ZT_Skeiksnbsgetujisr1Ty> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr1Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr1Ty()).ztyktgysyono, SortOrder.ASC));
        List<ZT_Skeiksnbsgetujisr1Ty> copyList = new ArrayList<ZT_Skeiksnbsgetujisr1Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr1Ty(orders));
        return copyList;
    }

    
    public List<ZT_Skeiksnbsgetujisr1Ty> OrderZT_Skeiksnbsgetujisr1TyByPkDesc(List<ZT_Skeiksnbsgetujisr1Ty> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr1Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr1Ty()).ztyktgysyono, SortOrder.DESC));
        List<ZT_Skeiksnbsgetujisr1Ty> copyList = new ArrayList<ZT_Skeiksnbsgetujisr1Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr1Ty(orders));
        return copyList;
    }
}
