package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import static yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai.SkMosSyoukaiConstants.*;

import java.util.Comparator;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_GaitouKbn;
import yuyu.def.classification.C_KeihiKbn;
import yuyu.def.classification.C_SysCdKbn;

/**
 * 被保険者索引情報ソートクラス
 */
public class HhknSakuinInfoSortComparator implements Comparator<HhknSakuinInfoDataSourceBean> {

    @Override
    public int compare(HhknSakuinInfoDataSourceBean obj1, HhknSakuinInfoDataSourceBean obj2) {

        C_KeihiKbn taisyousya1 = obj1.getDisphhknsakuintaisyou();
        C_KeihiKbn taisyousya2 = obj2.getDisphhknsakuintaisyou();
        BizDate syoumetuYmd1 = obj1.getDisphhknsakuinsyoumetuymd();
        BizDate syoumetuYmd2 = obj2.getDisphhknsakuinsyoumetuymd();
        String seirituJyoukyo1 = obj1.getSeirituJyoukyo();
        String seirituJyoukyo2 = obj2.getSeirituJyoukyo();
        C_GaitouKbn gaitouKbn1 = obj1.getDisphhknsakuinhuseiritu();
        C_GaitouKbn gaitouKbn2 = obj2.getDisphhknsakuinhuseiritu();
        C_SysCdKbn systemKbn1 = obj1.getDisphhknsakuin();
        C_SysCdKbn systemKbn2 = obj2.getDisphhknsakuin();
        String taisyousyaSortNo1 = "0";
        String taisyousyaSortNo2 = "0";
        String gaitouKbnSortNo1 = "0";
        String gaitouKbnSortNo2 = "0";

        taisyousyaSortNo1 = String.valueOf(getSortNoForTaisyousya(taisyousya1));
        taisyousyaSortNo2 = String.valueOf(getSortNoForTaisyousya(taisyousya2));

        if (syoumetuYmd1 == null) {
            syoumetuYmd1 = HIDUKEINIT;
        }

        if (syoumetuYmd2 == null) {
            syoumetuYmd2 = HIDUKEINIT;
        }

        if (gaitouKbn1 != null) {
            gaitouKbnSortNo1 = gaitouKbn1.getValue();
        }

        if (gaitouKbn2 != null) {
            gaitouKbnSortNo2 = gaitouKbn2.getValue();
        }

        if (!taisyousya1.eq(taisyousya2)) {
            return taisyousyaSortNo1.compareTo(taisyousyaSortNo2);
        }
        else if (!syoumetuYmd1.equals(syoumetuYmd2)) {

            if (syoumetuYmd1.compareTo(HIDUKEINIT) == 0) {
                return SEISUUFUSUUONE;
            }
            else if (syoumetuYmd2.compareTo(HIDUKEINIT) == 0) {
                return SEISUUONE;
            }
            else {
                return syoumetuYmd2.compareTo(syoumetuYmd1);
            }
        }
        else if (seirituJyoukyo1.equals(SRTUSMKEYAKU)) {
            return SEISUUFUSUUONE;
        }
        else if (seirituJyoukyo2.equals(SRTUSMKEYAKU)) {
            return SEISUUONE;
        }
        else if (!gaitouKbn1.eq(gaitouKbn2)) {

            return gaitouKbnSortNo1.compareTo(gaitouKbnSortNo2);
        }
        else {
            return systemKbn2.compareTo(systemKbn1);
        }
    }

    private int getSortNoForTaisyousya(C_KeihiKbn pTaisyousya) {

        int sortNo = 0;

        switch (pTaisyousya.getValue()) {

            case "1" :
                sortNo = 3;
                break;
            case "2" :
                sortNo = 1;
                break;
            case "3" :
                sortNo = 2;
                break;
            default:
                break;
        }
        return sortNo;
    }
}
