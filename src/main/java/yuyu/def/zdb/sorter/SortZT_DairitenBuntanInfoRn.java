package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DairitenBuntanInfoRn;
import yuyu.def.db.meta.QZT_DairitenBuntanInfoRn;
import yuyu.def.zdb.comparator.OrderZT_DairitenBuntanInfoRn;

public class SortZT_DairitenBuntanInfoRn {

    
    public List<ZT_DairitenBuntanInfoRn> OrderZT_DairitenBuntanInfoRnByPkAsc(List<ZT_DairitenBuntanInfoRn> pEntity) {
        List<SortCondition<ZT_DairitenBuntanInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DairitenBuntanInfoRn()).zrndairitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DairitenBuntanInfoRn()).zrndairitensyouhincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DairitenBuntanInfoRn()).zrntesuuryoubuntandrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DairitenBuntanInfoRn()).zrntesuuryoubuntanstartym, SortOrder.ASC));
        List<ZT_DairitenBuntanInfoRn> copyList = new ArrayList<ZT_DairitenBuntanInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DairitenBuntanInfoRn(orders));
        return copyList;
    }

    
    public List<ZT_DairitenBuntanInfoRn> OrderZT_DairitenBuntanInfoRnByPkDesc(List<ZT_DairitenBuntanInfoRn> pEntity) {
        List<SortCondition<ZT_DairitenBuntanInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DairitenBuntanInfoRn()).zrndairitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DairitenBuntanInfoRn()).zrndairitensyouhincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DairitenBuntanInfoRn()).zrntesuuryoubuntandrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DairitenBuntanInfoRn()).zrntesuuryoubuntanstartym, SortOrder.DESC));
        List<ZT_DairitenBuntanInfoRn> copyList = new ArrayList<ZT_DairitenBuntanInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DairitenBuntanInfoRn(orders));
        return copyList;
    }
}
