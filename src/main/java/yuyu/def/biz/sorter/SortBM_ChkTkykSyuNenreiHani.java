package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkTkykSyuNenreiHani;
import yuyu.def.db.entity.BM_ChkTkykSyuNenreiHani;
import yuyu.def.db.meta.QBM_ChkTkykSyuNenreiHani;

public class SortBM_ChkTkykSyuNenreiHani {

    public List<BM_ChkTkykSyuNenreiHani> OrderBM_ChkTkykSyuNenreiHaniByPkAsc(List<BM_ChkTkykSyuNenreiHani> pEntity) {
        List<SortCondition<BM_ChkTkykSyuNenreiHani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkTkykSyuNenreiHani()).pmnjtkkbn, SortOrder.ASC));
        List<BM_ChkTkykSyuNenreiHani> copyList = new ArrayList<BM_ChkTkykSyuNenreiHani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkTkykSyuNenreiHani(orders));
        return copyList;
    }

    public List<BM_ChkTkykSyuNenreiHani> OrderBM_ChkTkykSyuNenreiHaniByPkDesc(List<BM_ChkTkykSyuNenreiHani> pEntity) {
        List<SortCondition<BM_ChkTkykSyuNenreiHani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkTkykSyuNenreiHani()).pmnjtkkbn, SortOrder.DESC));
        List<BM_ChkTkykSyuNenreiHani> copyList = new ArrayList<BM_ChkTkykSyuNenreiHani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkTkykSyuNenreiHani(orders));
        return copyList;
    }

}

