package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkNenreiHani2;
import yuyu.def.db.entity.BM_ChkNenreiHani2;
import yuyu.def.db.meta.QBM_ChkNenreiHani2;

public class SortBM_ChkNenreiHani2 {

    public List<BM_ChkNenreiHani2> OrderBM_ChkNenreiHani2ByPkAsc(List<BM_ChkNenreiHani2> pEntity) {
        List<SortCondition<BM_ChkNenreiHani2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).channelcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syusyouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).hhknseifrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).hhknseito, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syukatakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuhknkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuhknkknsmnkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuhrkkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuhrkkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuhrkkknsmnkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syufromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syutonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuyoteiriritufrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuyoteirirituto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syudai1hknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tokusyuchkno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tksyouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkhknkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkhknkknsmnkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkhrkkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkhrkkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkhrkkknsmnkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tktonen, SortOrder.ASC));
        List<BM_ChkNenreiHani2> copyList = new ArrayList<BM_ChkNenreiHani2>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNenreiHani2(orders));
        return copyList;
    }

    public List<BM_ChkNenreiHani2> OrderBM_ChkNenreiHani2ByPkDesc(List<BM_ChkNenreiHani2> pEntity) {
        List<SortCondition<BM_ChkNenreiHani2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).channelcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syusyouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).hhknseifrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).hhknseito, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syukatakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuhknkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuhknkknsmnkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuhrkkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuhrkkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuhrkkknsmnkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syufromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syutonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuyoteiriritufrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syuyoteirirituto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).syudai1hknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tokusyuchkno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tksyouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkhknkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkhknkknsmnkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkhrkkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkhrkkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkhrkkknsmnkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tkfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiHani2()).tktonen, SortOrder.DESC));
        List<BM_ChkNenreiHani2> copyList = new ArrayList<BM_ChkNenreiHani2>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNenreiHani2(orders));
        return copyList;
    }
}
