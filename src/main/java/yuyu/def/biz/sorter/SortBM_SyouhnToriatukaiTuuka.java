package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SyouhnToriatukaiTuuka;
import yuyu.def.db.entity.BM_SyouhnToriatukaiTuuka;
import yuyu.def.db.meta.QBM_SyouhnToriatukaiTuuka;

public class SortBM_SyouhnToriatukaiTuuka {

    public List<BM_SyouhnToriatukaiTuuka> OrderBM_SyouhnToriatukaiTuukaByPkAsc(List<BM_SyouhnToriatukaiTuuka> pEntity) {
        List<SortCondition<BM_SyouhnToriatukaiTuuka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SyouhnToriatukaiTuuka()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SyouhnToriatukaiTuuka()).tkyfromymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SyouhnToriatukaiTuuka()).tkytoymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SyouhnToriatukaiTuuka()).zenkizennouumu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SyouhnToriatukaiTuuka()).kyktuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SyouhnToriatukaiTuuka()).hrktuukasyu, SortOrder.ASC));
        List<BM_SyouhnToriatukaiTuuka> copyList = new ArrayList<BM_SyouhnToriatukaiTuuka>(pEntity);
        Collections.sort(copyList, new OrderBM_SyouhnToriatukaiTuuka(orders));
        return copyList;
    }

    public List<BM_SyouhnToriatukaiTuuka> OrderBM_SyouhnToriatukaiTuukaByPkDesc(List<BM_SyouhnToriatukaiTuuka> pEntity) {
        List<SortCondition<BM_SyouhnToriatukaiTuuka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SyouhnToriatukaiTuuka()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SyouhnToriatukaiTuuka()).tkyfromymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SyouhnToriatukaiTuuka()).tkytoymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SyouhnToriatukaiTuuka()).zenkizennouumu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SyouhnToriatukaiTuuka()).kyktuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SyouhnToriatukaiTuuka()).hrktuukasyu, SortOrder.DESC));
        List<BM_SyouhnToriatukaiTuuka> copyList = new ArrayList<BM_SyouhnToriatukaiTuuka>(pEntity);
        Collections.sort(copyList, new OrderBM_SyouhnToriatukaiTuuka(orders));
        return copyList;
    }
}
