package yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku;

import java.util.Comparator;

import yuyu.def.classification.C_Tuukasyu;

/**
 * GkkwssekInfoDataSourceBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛（外貨為替差益情報）口座番号、（外貨為替差益情報）払込通貨種類、（外貨為替差益情報）指定通貨種類｝です。
 */
public class GkkwssekInfoDataSourceBeanSortComparator  implements Comparator<GkkwssekInfoDataSourceBean> {

    @Override
    public int compare(GkkwssekInfoDataSourceBean o1, GkkwssekInfoDataSourceBean o2) {

        String gkkwssekinfokouzano1 = o1.getGkkwssekinfokouzano();
        String gkkwssekinfokouzano2 = o2.getGkkwssekinfokouzano();

        C_Tuukasyu gkkwssekinfohrktuukasyu1 = o1.getGkkwssekinfohrktuukasyu();
        C_Tuukasyu gkkwssekinfohrktuukasyu2 = o2.getGkkwssekinfohrktuukasyu();

        C_Tuukasyu gkkwssekinfositeituukasyu1 = o1.getGkkwssekinfositeituukasyu();
        C_Tuukasyu gkkwssekinfositeituukasyu2 = o2.getGkkwssekinfositeituukasyu();

        if (!gkkwssekinfokouzano1.equals(gkkwssekinfokouzano2)) {
            return gkkwssekinfokouzano1.compareTo(gkkwssekinfokouzano2);
        }
        else if (!gkkwssekinfohrktuukasyu1.eq(gkkwssekinfohrktuukasyu2)) {
            if (C_Tuukasyu.USD.eq(gkkwssekinfohrktuukasyu1)) {
                return -1;
            }

            return 1 ;
        }
        else if (!gkkwssekinfositeituukasyu1.eq(gkkwssekinfositeituukasyu2)) {
            if (C_Tuukasyu.USD.eq(gkkwssekinfositeituukasyu1)) {
                return -1;
            }

            return 1 ;
        }
        return 0;
    }
}
