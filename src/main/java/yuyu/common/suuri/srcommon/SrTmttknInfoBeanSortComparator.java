package yuyu.common.suuri.srcommon;

import java.util.Comparator;

import yuyu.common.suuri.srcommon.SrGetTokutejitenTmttknInfoBean;

/**
 * 数理 数理共通 指数連動積増型年金積立金テーブル情報Beanリストソートクラス
 */
public class SrTmttknInfoBeanSortComparator implements Comparator<SrGetTokutejitenTmttknInfoBean> {

    @Override
    public int compare(SrGetTokutejitenTmttknInfoBean o1, SrGetTokutejitenTmttknInfoBean o2) {

        return o2.getTmttknkouryokukaisiymdForComp().compareTo(o1.getTmttknkouryokukaisiymdForComp());

    }

}
