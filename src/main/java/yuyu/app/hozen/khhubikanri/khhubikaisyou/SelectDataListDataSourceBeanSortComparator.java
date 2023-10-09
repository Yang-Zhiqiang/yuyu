package yuyu.app.hozen.khhubikanri.khhubikaisyou;

import java.util.Comparator;

import jp.co.slcs.swak.date.BizDate;

/**
 * SelectDataListDataSourceBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛事務開始日の昇順｝です。
 */
public class SelectDataListDataSourceBeanSortComparator implements Comparator<SelectDataListDataSourceBean> {

    @Override
    public int compare(SelectDataListDataSourceBean o1, SelectDataListDataSourceBean o2) {

        BizDate day1 = o1.getDispjimustartymd() == null ? BizDate.MIN_VALUE : o1.getDispjimustartymd();
        BizDate day2 = o2.getDispjimustartymd() == null ? BizDate.MIN_VALUE : o2.getDispjimustartymd();

        if (BizDate.MIN_VALUE.equals(day1)) {
            return -1;
        }
        if (BizDate.MIN_VALUE.equals(day2)) {
            return 1;
        }

        return day1.compareTo(day2);
    }
}
