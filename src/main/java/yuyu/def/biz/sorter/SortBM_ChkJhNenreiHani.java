package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkJhNenreiHani;
import yuyu.def.db.entity.BM_ChkJhNenreiHani;
import yuyu.def.db.meta.QBM_ChkJhNenreiHani;

public class SortBM_ChkJhNenreiHani {

    public List<BM_ChkJhNenreiHani> OrderBM_ChkJhNenreiHaniByPkAsc(List<BM_ChkJhNenreiHani> pEntity) {
        List<SortCondition<BM_ChkJhNenreiHani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).channelcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syusyouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syukatakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuhknkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuhknkknsmnkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuhrkkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuhrkkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuhrkkknsmnkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syufromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syutonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuyoteiriritufrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuyoteirirituto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tokusyuchkno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tksyouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkhknkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkhknkknsmnkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkhrkkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkhrkkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkhrkkknsmnkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tktonen, SortOrder.ASC));
        List<BM_ChkJhNenreiHani> copyList = new ArrayList<BM_ChkJhNenreiHani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhNenreiHani(orders));
        return copyList;
    }

    public List<BM_ChkJhNenreiHani> OrderBM_ChkJhNenreiHaniByPkDesc(List<BM_ChkJhNenreiHani> pEntity) {
        List<SortCondition<BM_ChkJhNenreiHani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).channelcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syusyouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syukatakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuhknkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuhknkknsmnkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuhrkkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuhrkkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuhrkkknsmnkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syufromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syutonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuyoteiriritufrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).syuyoteirirituto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tokusyuchkno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tksyouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkhknkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkhknkknsmnkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkhrkkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkhrkkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkhrkkknsmnkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tkfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiHani()).tktonen, SortOrder.DESC));
        List<BM_ChkJhNenreiHani> copyList = new ArrayList<BM_ChkJhNenreiHani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhNenreiHani(orders));
        return copyList;
    }
}
