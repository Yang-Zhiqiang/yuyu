package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr4Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr4Ty;
import yuyu.def.zdb.comparator.OrderZT_Skeiksnbsgetujisr4Ty;

public class SortZT_Skeiksnbsgetujisr4Ty {

    
    public List<ZT_Skeiksnbsgetujisr4Ty> OrderZT_Skeiksnbsgetujisr4TyByPkAsc(List<ZT_Skeiksnbsgetujisr4Ty> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr4Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr4Ty()).ztyktgysyono, SortOrder.ASC));
        List<ZT_Skeiksnbsgetujisr4Ty> copyList = new ArrayList<ZT_Skeiksnbsgetujisr4Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr4Ty(orders));
        return copyList;
    }

    
    public List<ZT_Skeiksnbsgetujisr4Ty> OrderZT_Skeiksnbsgetujisr4TyByPkDesc(List<ZT_Skeiksnbsgetujisr4Ty> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr4Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr4Ty()).ztyktgysyono, SortOrder.DESC));
        List<ZT_Skeiksnbsgetujisr4Ty> copyList = new ArrayList<ZT_Skeiksnbsgetujisr4Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr4Ty(orders));
        return copyList;
    }
}
