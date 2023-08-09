package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr2Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr2Ty;
import yuyu.def.zdb.comparator.OrderZT_Skeiksnbsgetujisr2Ty;

public class SortZT_Skeiksnbsgetujisr2Ty {

    
    public List<ZT_Skeiksnbsgetujisr2Ty> OrderZT_Skeiksnbsgetujisr2TyByPkAsc(List<ZT_Skeiksnbsgetujisr2Ty> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr2Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr2Ty()).ztyktgysyono, SortOrder.ASC));
        List<ZT_Skeiksnbsgetujisr2Ty> copyList = new ArrayList<ZT_Skeiksnbsgetujisr2Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr2Ty(orders));
        return copyList;
    }

    
    public List<ZT_Skeiksnbsgetujisr2Ty> OrderZT_Skeiksnbsgetujisr2TyByPkDesc(List<ZT_Skeiksnbsgetujisr2Ty> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr2Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr2Ty()).ztyktgysyono, SortOrder.DESC));
        List<ZT_Skeiksnbsgetujisr2Ty> copyList = new ArrayList<ZT_Skeiksnbsgetujisr2Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr2Ty(orders));
        return copyList;
    }
}
