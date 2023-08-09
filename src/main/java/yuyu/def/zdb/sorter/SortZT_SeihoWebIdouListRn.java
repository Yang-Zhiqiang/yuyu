package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SeihoWebIdouListRn;
import yuyu.def.db.meta.QZT_SeihoWebIdouListRn;
import yuyu.def.zdb.comparator.OrderZT_SeihoWebIdouListRn;

public class SortZT_SeihoWebIdouListRn {

    
    public List<ZT_SeihoWebIdouListRn> OrderZT_SeihoWebIdouListRnByPkAsc(List<ZT_SeihoWebIdouListRn> pEntity) {
        List<SortCondition<ZT_SeihoWebIdouListRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnsakuseiymd7keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnbsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrntntusycd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnhasseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnidoukbn1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnkydatkikbnkj, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnkykyymm, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrncifcd, SortOrder.ASC));
        List<ZT_SeihoWebIdouListRn> copyList = new ArrayList<ZT_SeihoWebIdouListRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SeihoWebIdouListRn(orders));
        return copyList;
    }

    
    public List<ZT_SeihoWebIdouListRn> OrderZT_SeihoWebIdouListRnByPkDesc(List<ZT_SeihoWebIdouListRn> pEntity) {
        List<SortCondition<ZT_SeihoWebIdouListRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnsakuseiymd7keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnbsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrntntusycd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnhasseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnidoukbn1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnkydatkikbnkj, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrnkykyymm, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListRn()).zrncifcd, SortOrder.DESC));
        List<ZT_SeihoWebIdouListRn> copyList = new ArrayList<ZT_SeihoWebIdouListRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SeihoWebIdouListRn(orders));
        return copyList;
    }
}
