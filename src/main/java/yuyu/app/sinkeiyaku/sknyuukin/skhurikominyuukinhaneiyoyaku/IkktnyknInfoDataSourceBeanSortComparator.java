package yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku;

import java.util.Comparator;

import yuyu.def.classification.C_Tuukasyu;

/**
 * IkktnyknInfoDataSourceBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛（一括入金額情報）口座番号、（一括入金額情報）払込通貨種類、（一括入金額情報）指定通貨種類｝です。
 */
public class IkktnyknInfoDataSourceBeanSortComparator  implements Comparator<IkktnyknInfoDataSourceBean> {

    @Override
    public int compare(IkktnyknInfoDataSourceBean o1, IkktnyknInfoDataSourceBean o2) {

        String ikktnykninfokouzano1 = o1.getIkktnykninfokouzano();
        String ikktnykninfokouzano2 = o2.getIkktnykninfokouzano();

        C_Tuukasyu ikktnykninfohrktuukasyu1 = o1.getIkktnykninfohrktuukasyu();
        C_Tuukasyu ikktnykninfohrktuukasyu2 = o2.getIkktnykninfohrktuukasyu();

        C_Tuukasyu ikktnykninfositeituukasyu1 = o1.getIkktnykninfositeituukasyu();
        C_Tuukasyu ikktnykninfositeituukasyu2 = o2.getIkktnykninfositeituukasyu();

        if (!ikktnykninfokouzano1.equals(ikktnykninfokouzano2)) {
            return ikktnykninfokouzano1.compareTo(ikktnykninfokouzano2);
        }
        else if (!ikktnykninfohrktuukasyu1.eq(ikktnykninfohrktuukasyu2)) {
            if (C_Tuukasyu.USD.eq(ikktnykninfohrktuukasyu1)) {
                return -1;
            }

            return 1 ;
        }
        else if (!ikktnykninfositeituukasyu1.eq(ikktnykninfositeituukasyu2)) {
            if (C_Tuukasyu.USD.eq(ikktnykninfositeituukasyu1)) {
                return -1;
            }

            return 1 ;
        }
        return 0;
    }
}
