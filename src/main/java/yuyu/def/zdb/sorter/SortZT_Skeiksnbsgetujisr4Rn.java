package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr4Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr4Rn;
import yuyu.def.zdb.comparator.OrderZT_Skeiksnbsgetujisr4Rn;

public class SortZT_Skeiksnbsgetujisr4Rn {

    
    public List<ZT_Skeiksnbsgetujisr4Rn> OrderZT_Skeiksnbsgetujisr4RnByPkAsc(List<ZT_Skeiksnbsgetujisr4Rn> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr4Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr4Rn()).zrnktgysyono, SortOrder.ASC));
        List<ZT_Skeiksnbsgetujisr4Rn> copyList = new ArrayList<ZT_Skeiksnbsgetujisr4Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr4Rn(orders));
        return copyList;
    }

    
    public List<ZT_Skeiksnbsgetujisr4Rn> OrderZT_Skeiksnbsgetujisr4RnByPkDesc(List<ZT_Skeiksnbsgetujisr4Rn> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr4Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr4Rn()).zrnktgysyono, SortOrder.DESC));
        List<ZT_Skeiksnbsgetujisr4Rn> copyList = new ArrayList<ZT_Skeiksnbsgetujisr4Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr4Rn(orders));
        return copyList;
    }
}
