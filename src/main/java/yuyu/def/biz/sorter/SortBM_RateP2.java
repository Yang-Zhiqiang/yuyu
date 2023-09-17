package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_RateP2;
import yuyu.def.db.entity.BM_RateP2;
import yuyu.def.db.meta.QBM_RateP2;

public class SortBM_RateP2 {

    public List<BM_RateP2> OrderBM_RateP2ByPkAsc(List<BM_RateP2> pEntity) {
        List<SortCondition<BM_RateP2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateP2()).palhokensyuruikigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palhokensyuruikigousdicode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palpmencode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palharaikomikaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palsaimankihyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palhokenkikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palpharaikomikikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palannaihuyouriyuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).ratetuukasyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).ratedai1hknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palryouritukbn, SortOrder.ASC));
        List<BM_RateP2> copyList = new ArrayList<BM_RateP2>(pEntity);
        Collections.sort(copyList, new OrderBM_RateP2(orders));
        return copyList;
    }

    public List<BM_RateP2> OrderBM_RateP2ByPkDesc(List<BM_RateP2> pEntity) {
        List<SortCondition<BM_RateP2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateP2()).palhokensyuruikigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palhokensyuruikigousdicode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palpmencode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palharaikomikaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palsaimankihyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palhokenkikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palpharaikomikikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palannaihuyouriyuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).ratetuukasyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).ratedai1hknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP2()).palryouritukbn, SortOrder.DESC));
        List<BM_RateP2> copyList = new ArrayList<BM_RateP2>(pEntity);
        Collections.sort(copyList, new OrderBM_RateP2(orders));
        return copyList;
    }
}
