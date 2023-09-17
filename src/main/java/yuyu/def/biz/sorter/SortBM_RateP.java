package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_RateP;
import yuyu.def.db.entity.BM_RateP;
import yuyu.def.db.meta.QBM_RateP;

public class SortBM_RateP {

    public List<BM_RateP> OrderBM_RatePByPkAsc(List<BM_RateP> pEntity) {
        List<SortCondition<BM_RateP>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateP()).palhokensyuruikigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP()).palhokensyuruikigousdicode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP()).palyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP()).palpmencode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP()).palharaikomikaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP()).palhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP()).palkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP()).palsaimankihyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP()).palhokenkikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateP()).palpharaikomikikan, SortOrder.ASC));
        List<BM_RateP> copyList = new ArrayList<BM_RateP>(pEntity);
        Collections.sort(copyList, new OrderBM_RateP(orders));
        return copyList;
    }

    public List<BM_RateP> OrderBM_RatePByPkDesc(List<BM_RateP> pEntity) {
        List<SortCondition<BM_RateP>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateP()).palhokensyuruikigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP()).palhokensyuruikigousdicode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP()).palyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP()).palpmencode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP()).palharaikomikaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP()).palhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP()).palkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP()).palsaimankihyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP()).palhokenkikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateP()).palpharaikomikikan, SortOrder.DESC));
        List<BM_RateP> copyList = new ArrayList<BM_RateP>(pEntity);
        Collections.sort(copyList, new OrderBM_RateP(orders));
        return copyList;
    }

}

