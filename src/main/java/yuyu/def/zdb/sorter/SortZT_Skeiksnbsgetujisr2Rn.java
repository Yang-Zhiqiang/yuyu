package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr2Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr2Rn;
import yuyu.def.zdb.comparator.OrderZT_Skeiksnbsgetujisr2Rn;

public class SortZT_Skeiksnbsgetujisr2Rn {

    
    public List<ZT_Skeiksnbsgetujisr2Rn> OrderZT_Skeiksnbsgetujisr2RnByPkAsc(List<ZT_Skeiksnbsgetujisr2Rn> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr2Rn()).zrnktgysyono, SortOrder.ASC));
        List<ZT_Skeiksnbsgetujisr2Rn> copyList = new ArrayList<ZT_Skeiksnbsgetujisr2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr2Rn(orders));
        return copyList;
    }

    
    public List<ZT_Skeiksnbsgetujisr2Rn> OrderZT_Skeiksnbsgetujisr2RnByPkDesc(List<ZT_Skeiksnbsgetujisr2Rn> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr2Rn()).zrnktgysyono, SortOrder.DESC));
        List<ZT_Skeiksnbsgetujisr2Rn> copyList = new ArrayList<ZT_Skeiksnbsgetujisr2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr2Rn(orders));
        return copyList;
    }
}
