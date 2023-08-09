package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr6Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr6Rn;
import yuyu.def.zdb.comparator.OrderZT_Skeiksnbsgetujisr6Rn;

public class SortZT_Skeiksnbsgetujisr6Rn {

    
    public List<ZT_Skeiksnbsgetujisr6Rn> OrderZT_Skeiksnbsgetujisr6RnByPkAsc(List<ZT_Skeiksnbsgetujisr6Rn> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr6Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr6Rn()).zrnktgysyono, SortOrder.ASC));
        List<ZT_Skeiksnbsgetujisr6Rn> copyList = new ArrayList<ZT_Skeiksnbsgetujisr6Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr6Rn(orders));
        return copyList;
    }

    
    public List<ZT_Skeiksnbsgetujisr6Rn> OrderZT_Skeiksnbsgetujisr6RnByPkDesc(List<ZT_Skeiksnbsgetujisr6Rn> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr6Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr6Rn()).zrnktgysyono, SortOrder.DESC));
        List<ZT_Skeiksnbsgetujisr6Rn> copyList = new ArrayList<ZT_Skeiksnbsgetujisr6Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr6Rn(orders));
        return copyList;
    }
}
