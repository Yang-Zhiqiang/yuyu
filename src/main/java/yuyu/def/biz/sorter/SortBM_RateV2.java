package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_RateV2;
import yuyu.def.db.entity.BM_RateV2;
import yuyu.def.db.meta.QBM_RateV2;

public class SortBM_RateV2 {

    public List<BM_RateV2> OrderBM_RateV2ByPkAsc(List<BM_RateV2> pEntity) {
        List<SortCondition<BM_RateV2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateV2()).palhokensyuruikigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palhokensyuruikigousdicode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palpmencode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palharaikomikaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palsaimankihyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palhokenkikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palpharaikomikikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palannaihuyouriyuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV2()).ratetuukasyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV2()).ratedai1hknkkn, SortOrder.ASC));
        List<BM_RateV2> copyList = new ArrayList<BM_RateV2>(pEntity);
        Collections.sort(copyList, new OrderBM_RateV2(orders));
        return copyList;
    }

    public List<BM_RateV2> OrderBM_RateV2ByPkDesc(List<BM_RateV2> pEntity) {
        List<SortCondition<BM_RateV2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateV2()).palhokensyuruikigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palhokensyuruikigousdicode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palpmencode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palharaikomikaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palsaimankihyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palhokenkikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palpharaikomikikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV2()).palannaihuyouriyuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV2()).ratetuukasyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV2()).ratedai1hknkkn, SortOrder.DESC));
        List<BM_RateV2> copyList = new ArrayList<BM_RateV2>(pEntity);
        Collections.sort(copyList, new OrderBM_RateV2(orders));
        return copyList;
    }
}
