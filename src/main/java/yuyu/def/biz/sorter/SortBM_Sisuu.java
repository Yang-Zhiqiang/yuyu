package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Sisuu;
import yuyu.def.db.entity.BM_Sisuu;
import yuyu.def.db.meta.QBM_Sisuu;

public class SortBM_Sisuu {

    public List<BM_Sisuu> OrderBM_SisuuByPkAsc(List<BM_Sisuu> pEntity) {
        List<SortCondition<BM_Sisuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Sisuu()).sisuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_Sisuu()).sisuukouhyouymd, SortOrder.ASC));
        List<BM_Sisuu> copyList = new ArrayList<BM_Sisuu>(pEntity);
        Collections.sort(copyList, new OrderBM_Sisuu(orders));
        return copyList;
    }

    public List<BM_Sisuu> OrderBM_SisuuByPkDesc(List<BM_Sisuu> pEntity) {
        List<SortCondition<BM_Sisuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Sisuu()).sisuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_Sisuu()).sisuukouhyouymd, SortOrder.DESC));
        List<BM_Sisuu> copyList = new ArrayList<BM_Sisuu>(pEntity);
        Collections.sort(copyList, new OrderBM_Sisuu(orders));
        return copyList;
    }
}
