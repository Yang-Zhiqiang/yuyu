package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkNenreiHani;
import yuyu.def.db.entity.BM_ChkNenreiHani;
import yuyu.def.db.meta.QBM_ChkNenreiHani;

public class SortBM_ChkNenreiHani {

    public List<BM_ChkNenreiHani> OrderBM_ChkNenreiHaniByPkAsc(List<BM_ChkNenreiHani> pEntity) {
        List<SortCondition<BM_ChkNenreiHani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).channelcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syusyouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syukatakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuhknkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuhknkknsmnkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuhrkkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuhrkkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuhrkkknsmnkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syufromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syutonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuyoteiriritufrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuyoteirirituto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tokusyuchkno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tksyouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkhknkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkhknkknsmnkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkhrkkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkhrkkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkhrkkknsmnkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tktonen, SortOrder.ASC));
        List<BM_ChkNenreiHani> copyList = new ArrayList<BM_ChkNenreiHani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNenreiHani(orders));
        return copyList;
    }

    public List<BM_ChkNenreiHani> OrderBM_ChkNenreiHaniByPkDesc(List<BM_ChkNenreiHani> pEntity) {
        List<SortCondition<BM_ChkNenreiHani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).channelcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syusyouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syukatakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuhknkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuhknkknsmnkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuhrkkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuhrkkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuhrkkknsmnkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syufromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syutonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuyoteiriritufrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).syuyoteirirituto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tokusyuchkno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tksyouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkhknkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkhknkknsmnkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkhrkkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkhrkkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkhrkkknsmnkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tkfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani()).tktonen, SortOrder.DESC));
        List<BM_ChkNenreiHani> copyList = new ArrayList<BM_ChkNenreiHani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNenreiHani(orders));
        return copyList;
    }
}
