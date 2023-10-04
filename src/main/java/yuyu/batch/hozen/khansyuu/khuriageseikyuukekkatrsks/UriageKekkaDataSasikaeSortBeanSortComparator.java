package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks;

import java.util.Comparator;

/**
 * 【売上結果データ差替ソート項目用Bean】UriageKekkaDataSasikaeSortBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛クレジットカード売上請求ＮＧ事由の昇順｝です
 */
public class UriageKekkaDataSasikaeSortBeanSortComparator implements Comparator<UriageKekkaDataSasikaeSortBean> {

    @Override
    public int compare(UriageKekkaDataSasikaeSortBean o1, UriageKekkaDataSasikaeSortBean o2) {
        Integer creditUriageNgJiyuu1 = o1.getCreditUriageNgjiyuu() == null ? 0 : o1.getCreditUriageNgjiyuu();
        Integer creditUriageNgJiyuu2 = o2.getCreditUriageNgjiyuu() == null ? 0 : o2.getCreditUriageNgjiyuu();
        int cmpret = 0;

        if (!creditUriageNgJiyuu1.equals(creditUriageNgJiyuu2)) {
            if (0 == creditUriageNgJiyuu1) {
                return -1;
            }
            if (0 == creditUriageNgJiyuu2) {
                return 1;
            }

            cmpret = creditUriageNgJiyuu1.compareTo(creditUriageNgJiyuu2);
        }
        return cmpret;
    }

}
