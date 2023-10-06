package yuyu.batch.biz.bzkaikei.bzsikinidoulistskshijynbrnyk;

import java.util.Comparator;

import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 経理・会計 資金移動リスト作成(平準払入金用)ソートクラス
 */
public class BzSikinIdouListSksHijynbrNykComparator implements Comparator<SikinIdouListSksHijynbrNykDataBean>{

    @Override
    public int compare(SikinIdouListSksHijynbrNykDataBean pTarget1, SikinIdouListSksHijynbrNykDataBean pTarget2) {


        C_SikinidougroupKbn sikinidougroupKbn1 = pTarget1.getSikinidougroupkbn() == null ? C_SikinidougroupKbn.BLNK
            : pTarget1.getSikinidougroupkbn();
        C_SikinidougroupKbn sikinidougroupKbn2 = pTarget2.getSikinidougroupkbn() == null ? C_SikinidougroupKbn.BLNK
            : pTarget2.getSikinidougroupkbn();

        C_Tuukasyu tuukasyu1 = pTarget1.getSiteituuka() == null ? C_Tuukasyu.BLNK : pTarget1.getSiteituuka();
        C_Tuukasyu tuukasyu2 = pTarget2.getSiteituuka() == null ? C_Tuukasyu.BLNK : pTarget2.getSiteituuka();

        String sikinidoukbnnm1 = pTarget1.getSikinidoukbnnm() == null ? "" : pTarget1.getSikinidoukbnnm();
        String sikinidoukbnnm2 = pTarget2.getSikinidoukbnnm() == null ? "" : pTarget2.getSikinidoukbnnm();

        C_Segcd segcd1 = pTarget1.getSeg1cd() == null ? C_Segcd.BLNK : pTarget1.getSeg1cd();
        C_Segcd segcd2 = pTarget2.getSeg1cd() == null ? C_Segcd.BLNK : pTarget2.getSeg1cd();

        C_SikinidoumeisaiKbn sikinidoumeisaiKbn1 = pTarget1.getSikinidoumeisaikbn() == null ? C_SikinidoumeisaiKbn.BLNK
            : pTarget1.getSikinidoumeisaikbn();
        C_SikinidoumeisaiKbn sikinidoumeisaiKbn2 = pTarget2.getSikinidoumeisaikbn() == null ? C_SikinidoumeisaiKbn.BLNK
            : pTarget2.getSikinidoumeisaikbn();

        int cmpret = 0;

        if(!sikinidougroupKbn1.equals(sikinidougroupKbn2)) {

            if(C_SikinidougroupKbn.BLNK.eq(sikinidougroupKbn1)) {
                return -1;
            }
            if(C_SikinidougroupKbn.BLNK.eq(sikinidougroupKbn2)) {
                return 1;
            }

            cmpret = sikinidougroupKbn1.compareTo(sikinidougroupKbn2);

        }
        else {
            if(!tuukasyu1.equals(tuukasyu2)) {

                if(C_Tuukasyu.BLNK.eq(tuukasyu1)) {
                    return -1;
                }
                if(C_Tuukasyu.BLNK.eq(tuukasyu2)) {
                    return 1;
                }

                cmpret = tuukasyu1.compareTo(tuukasyu2);

            }
            else {
                if(!sikinidoukbnnm1.equals(sikinidoukbnnm2)) {

                    if("".equals(sikinidoukbnnm1)) {
                        return -1;
                    }
                    if("".equals(sikinidoukbnnm2)) {
                        return 1;
                    }

                    cmpret = sikinidoukbnnm1.compareTo(sikinidoukbnnm2);

                }
                else {
                    if(!segcd1.equals(segcd2)) {

                        if(C_Segcd.BLNK.eq(segcd1)) {
                            return -1;
                        }
                        if(C_Segcd.BLNK.eq(segcd2)) {
                            return 1;
                        }

                        cmpret = segcd1.compareTo(segcd2);

                    }
                    else {
                        if(!sikinidoumeisaiKbn1.equals(sikinidoumeisaiKbn2)) {

                            if(C_SikinidoumeisaiKbn.BLNK.eq(sikinidoumeisaiKbn1)) {
                                return -1;
                            }
                            if(C_SikinidoumeisaiKbn.BLNK.eq(sikinidoumeisaiKbn2)) {
                                return 1;
                            }

                            cmpret = sikinidoumeisaiKbn1.compareTo(sikinidoumeisaiKbn2);

                        }
                    }
                }
            }
        }

        return cmpret;

    }
}
