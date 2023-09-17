package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkSaikouSSTani;
import yuyu.def.db.entity.BM_ChkSaikouSSTani;
import yuyu.def.db.meta.QBM_ChkSaikouSSTani;

public class SortBM_ChkSaikouSSTani {

    public List<BM_ChkSaikouSSTani> OrderBM_ChkSaikouSSTaniByPkAsc(List<BM_ChkSaikouSSTani> pEntity) {
        List<SortCondition<BM_ChkSaikouSSTani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).hhkntonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).moskbnfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).moskbnto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).tuukasyu, SortOrder.ASC));
        List<BM_ChkSaikouSSTani> copyList = new ArrayList<BM_ChkSaikouSSTani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSaikouSSTani(orders));
        return copyList;
    }

    public List<BM_ChkSaikouSSTani> OrderBM_ChkSaikouSSTaniByPkDesc(List<BM_ChkSaikouSSTani> pEntity) {
        List<SortCondition<BM_ChkSaikouSSTani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).hhkntonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).moskbnfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).moskbnto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaikouSSTani()).tuukasyu, SortOrder.DESC));
        List<BM_ChkSaikouSSTani> copyList = new ArrayList<BM_ChkSaikouSSTani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSaikouSSTani(orders));
        return copyList;
    }

}

