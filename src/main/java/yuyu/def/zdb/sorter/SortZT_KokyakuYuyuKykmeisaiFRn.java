package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.db.meta.QZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.zdb.comparator.OrderZT_KokyakuYuyuKykmeisaiFRn;

public class SortZT_KokyakuYuyuKykmeisaiFRn {

    
    public List<ZT_KokyakuYuyuKykmeisaiFRn> OrderZT_KokyakuYuyuKykmeisaiFRnByPkAsc(List<ZT_KokyakuYuyuKykmeisaiFRn> pEntity) {
        List<SortCondition<ZT_KokyakuYuyuKykmeisaiFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KokyakuYuyuKykmeisaiFRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_KokyakuYuyuKykmeisaiFRn> copyList = new ArrayList<ZT_KokyakuYuyuKykmeisaiFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KokyakuYuyuKykmeisaiFRn(orders));
        return copyList;
    }

    
    public List<ZT_KokyakuYuyuKykmeisaiFRn> OrderZT_KokyakuYuyuKykmeisaiFRnByPkDesc(List<ZT_KokyakuYuyuKykmeisaiFRn> pEntity) {
        List<SortCondition<ZT_KokyakuYuyuKykmeisaiFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KokyakuYuyuKykmeisaiFRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_KokyakuYuyuKykmeisaiFRn> copyList = new ArrayList<ZT_KokyakuYuyuKykmeisaiFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KokyakuYuyuKykmeisaiFRn(orders));
        return copyList;
    }
}
