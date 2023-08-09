package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr6Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr6Ty;
import yuyu.def.zdb.comparator.OrderZT_Skeiksnbsgetujisr6Ty;

public class SortZT_Skeiksnbsgetujisr6Ty {

    
    public List<ZT_Skeiksnbsgetujisr6Ty> OrderZT_Skeiksnbsgetujisr6TyByPkAsc(List<ZT_Skeiksnbsgetujisr6Ty> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr6Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr6Ty()).ztyktgysyono, SortOrder.ASC));
        List<ZT_Skeiksnbsgetujisr6Ty> copyList = new ArrayList<ZT_Skeiksnbsgetujisr6Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr6Ty(orders));
        return copyList;
    }

    
    public List<ZT_Skeiksnbsgetujisr6Ty> OrderZT_Skeiksnbsgetujisr6TyByPkDesc(List<ZT_Skeiksnbsgetujisr6Ty> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr6Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr6Ty()).ztyktgysyono, SortOrder.DESC));
        List<ZT_Skeiksnbsgetujisr6Ty> copyList = new ArrayList<ZT_Skeiksnbsgetujisr6Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr6Ty(orders));
        return copyList;
    }
}
