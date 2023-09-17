package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkJhSaikouSSTani;
import yuyu.def.db.entity.BM_ChkJhSaikouSSTani;
import yuyu.def.db.meta.QBM_ChkJhSaikouSSTani;

public class SortBM_ChkJhSaikouSSTani {

    public List<BM_ChkJhSaikouSSTani> OrderBM_ChkJhSaikouSSTaniByPkAsc(List<BM_ChkJhSaikouSSTani> pEntity) {
        List<SortCondition<BM_ChkJhSaikouSSTani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).hhkntonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).moskbnfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).moskbnto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).tuukasyu, SortOrder.ASC));
        List<BM_ChkJhSaikouSSTani> copyList = new ArrayList<BM_ChkJhSaikouSSTani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhSaikouSSTani(orders));
        return copyList;
    }

    public List<BM_ChkJhSaikouSSTani> OrderBM_ChkJhSaikouSSTaniByPkDesc(List<BM_ChkJhSaikouSSTani> pEntity) {
        List<SortCondition<BM_ChkJhSaikouSSTani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).hhkntonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).moskbnfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).moskbnto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaikouSSTani()).tuukasyu, SortOrder.DESC));
        List<BM_ChkJhSaikouSSTani> copyList = new ArrayList<BM_ChkJhSaikouSSTani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhSaikouSSTani(orders));
        return copyList;
    }

}

