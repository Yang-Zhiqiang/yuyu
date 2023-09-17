package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_RateW;
import yuyu.def.db.entity.BM_RateW;
import yuyu.def.db.meta.QBM_RateW;

public class SortBM_RateW {

    public List<BM_RateW> OrderBM_RateWByPkAsc(List<BM_RateW> pEntity) {
        List<SortCondition<BM_RateW>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateW()).palhokensyuruikigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateW()).palhokensyuruikigousdicode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateW()).palyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateW()).palpmencode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateW()).palharaikomikaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateW()).palhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateW()).palkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateW()).palsaimankihyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateW()).palhokenkikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateW()).palpharaikomikikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateW()).palannaihuyouriyuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateW()).ratetuukasyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateW()).ratedai1hknkkn, SortOrder.ASC));
        List<BM_RateW> copyList = new ArrayList<BM_RateW>(pEntity);
        Collections.sort(copyList, new OrderBM_RateW(orders));
        return copyList;
    }

    public List<BM_RateW> OrderBM_RateWByPkDesc(List<BM_RateW> pEntity) {
        List<SortCondition<BM_RateW>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateW()).palhokensyuruikigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateW()).palhokensyuruikigousdicode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateW()).palyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateW()).palpmencode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateW()).palharaikomikaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateW()).palhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateW()).palkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateW()).palsaimankihyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateW()).palhokenkikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateW()).palpharaikomikikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateW()).palannaihuyouriyuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateW()).ratetuukasyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateW()).ratedai1hknkkn, SortOrder.DESC));
        List<BM_RateW> copyList = new ArrayList<BM_RateW>(pEntity);
        Collections.sort(copyList, new OrderBM_RateW(orders));
        return copyList;
    }
}
