package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_TuukabetuKyuusibi;
import yuyu.def.db.entity.BM_TuukabetuKyuusibi;
import yuyu.def.db.meta.QBM_TuukabetuKyuusibi;

public class SortBM_TuukabetuKyuusibi {

    public List<BM_TuukabetuKyuusibi> OrderBM_TuukabetuKyuusibiByPkAsc(List<BM_TuukabetuKyuusibi> pEntity) {
        List<SortCondition<BM_TuukabetuKyuusibi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TuukabetuKyuusibi()).tuukatoriatukaiymd, SortOrder.ASC));
        List<BM_TuukabetuKyuusibi> copyList = new ArrayList<BM_TuukabetuKyuusibi>(pEntity);
        Collections.sort(copyList, new OrderBM_TuukabetuKyuusibi(orders));
        return copyList;
    }

    public List<BM_TuukabetuKyuusibi> OrderBM_TuukabetuKyuusibiByPkDesc(List<BM_TuukabetuKyuusibi> pEntity) {
        List<SortCondition<BM_TuukabetuKyuusibi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TuukabetuKyuusibi()).tuukatoriatukaiymd, SortOrder.DESC));
        List<BM_TuukabetuKyuusibi> copyList = new ArrayList<BM_TuukabetuKyuusibi>(pEntity);
        Collections.sort(copyList, new OrderBM_TuukabetuKyuusibi(orders));
        return copyList;
    }

}

