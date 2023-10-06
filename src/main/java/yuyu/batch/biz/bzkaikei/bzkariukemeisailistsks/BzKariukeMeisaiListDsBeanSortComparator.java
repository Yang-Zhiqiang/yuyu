package yuyu.batch.biz.bzkaikei.bzkariukemeisailistsks;

import java.util.Comparator;

import yuyu.def.biz.bean.report.BzKariukeMeisaiListDataSourceBean;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_Tantositucd;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * 【仮受計上明細リスト作成】BzKariukeMeisaiListDataSourceBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛担当室コードの昇順、勘定科目コードの昇順、処理コードの昇順、証券番号の昇順、伝票データ連番の昇順、枝番号の昇順｝です。
 */
public class BzKariukeMeisaiListDsBeanSortComparator implements Comparator<IReportDataSouceBean> {

    @Override
    public int compare(IReportDataSouceBean o1, IReportDataSouceBean o2) {

        BzKariukeMeisaiListDataSourceBean impl1 = (BzKariukeMeisaiListDataSourceBean)o1;
        BzKariukeMeisaiListDataSourceBean impl2 = (BzKariukeMeisaiListDataSourceBean)o2;

        C_Tantositucd tantosituCd1 = impl1.getIrTantousitucd() == null ? C_Tantositucd.BLNK0 : impl1.getIrTantousitucd();
        C_Tantositucd tantosituCd2 = impl2.getIrTantousitucd() == null ? C_Tantositucd.BLNK0 : impl2.getIrTantousitucd();

        String kanjyoukmkCd1 =impl1.getIrKanjyoukmkcd() == null ? C_Kanjyoukmkcd.BLNK.toString() : impl1.getIrKanjyoukmkcd();
        String kanjyoukmkCd2 =impl2.getIrKanjyoukmkcd() == null ? C_Kanjyoukmkcd.BLNK.toString() : impl2.getIrKanjyoukmkcd();

        String syoriCd1 = impl1.getIrSyoricd() == null ? "" : impl1.getIrSyoricd();
        String syoriCd2 = impl2.getIrSyoricd() == null ? "" : impl2.getIrSyoricd();

        String syoNo1 =impl1.getIrSyono() == null ? "" : impl1.getIrSyono();
        String syoNo2 =impl2.getIrSyono() == null ? "" : impl2.getIrSyono();

        String denRenno1 = impl1.getIrDenrenno() == null ? "": impl1.getIrDenrenno();
        String denRenno2 = impl2.getIrDenrenno() == null ? "": impl2.getIrDenrenno();

        Integer edaNo1 = impl1.getIrEdano() == null ? 0 : impl1.getIrEdano();
        Integer edaNo2 = impl2.getIrEdano() == null ? 0 : impl2.getIrEdano();

        int cmpret = 0;

        if (!tantosituCd1.equals(tantosituCd2)) {

            if (C_Tantositucd.BLNK0.eq(tantosituCd1)) {
                return -1;
            }

            if (C_Tantositucd.BLNK0.eq(tantosituCd2)) {
                return 1;
            }

            cmpret = tantosituCd1.compareTo(tantosituCd2);

        }
        else {

            if (!kanjyoukmkCd1.equals(kanjyoukmkCd2)) {

                if (C_Kanjyoukmkcd.BLNK.toString().equals(kanjyoukmkCd1)) {
                    return -1;
                }

                if (C_Kanjyoukmkcd.BLNK.toString().equals(kanjyoukmkCd2)) {
                    return 1;
                }

                cmpret =  kanjyoukmkCd1.compareTo(kanjyoukmkCd2);

            }
            else {

                if (!syoriCd1.equals(syoriCd2)) {

                    if ("".equals(syoriCd1)) {
                        return -1;
                    }

                    if ("".equals(syoriCd2)) {
                        return 1;
                    }

                    cmpret =  syoriCd1.compareTo(syoriCd2);
                }
                else {

                    if (!syoNo1.equals(syoNo2)) {

                        if ("".equals(syoNo1)) {
                            return -1;
                        }

                        if ("".equals(syoNo2)) {
                            return 1;
                        }

                        cmpret =  syoNo1.compareTo(syoNo2);
                    }
                    else {

                        if (!denRenno1.equals(denRenno2)) {

                            if("".equals(denRenno1)) {
                                return -1;
                            }

                            if("".equals(denRenno2)) {
                                return 1;
                            }

                            cmpret =  denRenno1.compareTo(denRenno2);
                        }
                        else {

                            if(edaNo1 != edaNo2) {

                                if(edaNo1 == 0) {
                                    return -1;
                                }

                                if(edaNo2 == 0) {
                                    return 1;
                                }

                                cmpret =  edaNo1.compareTo(edaNo2);
                            }
                        }
                    }
                }
            }
        }

        return cmpret;
    }
}
