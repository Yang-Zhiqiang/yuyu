package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_RateD;
import yuyu.def.db.entity.BM_RateD;
import yuyu.def.db.meta.QBM_RateD;

public class SortBM_RateD {

    public List<BM_RateD> OrderBM_RateDByPkAsc(List<BM_RateD> pEntity) {
        List<SortCondition<BM_RateD>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateD()).palhokensyuruikigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateD()).palhokensyuruikigousdicode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateD()).palyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateD()).palpmencode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateD()).palharaikomikaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateD()).palhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateD()).palkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateD()).palsaimankihyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateD()).palhokenkikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateD()).palpharaikomikikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateD()).paldnendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateD()).paldratenaikakucode, SortOrder.ASC));
        List<BM_RateD> copyList = new ArrayList<BM_RateD>(pEntity);
        Collections.sort(copyList, new OrderBM_RateD(orders));
        return copyList;
    }

    public List<BM_RateD> OrderBM_RateDByPkDesc(List<BM_RateD> pEntity) {
        List<SortCondition<BM_RateD>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateD()).palhokensyuruikigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateD()).palhokensyuruikigousdicode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateD()).palyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateD()).palpmencode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateD()).palharaikomikaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateD()).palhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateD()).palkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateD()).palsaimankihyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateD()).palhokenkikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateD()).palpharaikomikikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateD()).paldnendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateD()).paldratenaikakucode, SortOrder.DESC));
        List<BM_RateD> copyList = new ArrayList<BM_RateD>(pEntity);
        Collections.sort(copyList, new OrderBM_RateD(orders));
        return copyList;
    }

}

