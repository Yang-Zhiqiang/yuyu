package yuyu.app.hozen.khhubikanri.khhubitouroku;

import java.util.Comparator;

import jp.co.slcs.swak.date.BizDate;

/**
 * 選択データリストソート処理用クラス
 */
public class SelectDataListComparator implements Comparator<SelectDataListDataSourceBean> {

    public static final BizDate DATE_INIT  = BizDate.valueOf("00000000");

    @Override
    public int compare(SelectDataListDataSourceBean pDataSourceBeanLst1, SelectDataListDataSourceBean pDataSourceBeanLst2) {

        String jimuttzkCd1 = pDataSourceBeanLst1.getJimuttzkCd();
        String jimuttzkCd2 = pDataSourceBeanLst2.getJimuttzkCd();

        BizDate jimustartymd1 = pDataSourceBeanLst1.getDispjimustartymd();
        BizDate jimustartymd2 = pDataSourceBeanLst2.getDispjimustartymd();

        if (jimuttzkCd1 == null) {
            jimuttzkCd1 = "";
        }

        if (jimuttzkCd2 == null) {
            jimuttzkCd2 = "";
        }

        if (jimustartymd1 == null) {
            jimustartymd1 = DATE_INIT;
        }

        if (jimustartymd2 == null) {
            jimustartymd2 = DATE_INIT;
        }

        if (!jimuttzkCd1.equals(jimuttzkCd2)) {
            return jimuttzkCd1.compareTo(jimuttzkCd2);
        }

        return jimustartymd1.compareTo(jimustartymd2);
    }
}
