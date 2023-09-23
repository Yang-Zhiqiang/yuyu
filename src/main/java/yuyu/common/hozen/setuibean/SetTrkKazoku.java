package yuyu.common.hozen.setuibean;

import java.util.List;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_TrkKzk;

/**
 * 契約保全 UiBean設定 登録家族情報設定
 */
public class SetTrkKazoku {

    private static final String BLANK = "";

    public static boolean exec(KhozenCommonParam pKhCParm, SetTrkKazokuExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();
        List<IT_TrkKzk> trkKzkList = pKhCParm.getTrkKzk(syoNo);

        init(pUiBean);

        if (trkKzkList != null) {

            for (int idx = 0; idx < trkKzkList.size(); idx++) {

                if (C_TrkKzkKbn.TRKKZK1.eq(trkKzkList.get(idx).getTrkkzkkbn())) {

                    pUiBean.setVtrkkzktrkkzknmkn1(trkKzkList.get(idx).getTrkkzknmkn());
                    pUiBean.setVtrkkzktrkkzknmkj1(trkKzkList.get(idx).getTrkkzknmkj());
                    pUiBean.setVtrkkzktrkkzknmkjkhukakbn1(trkKzkList.get(idx).getTrkkzknmkjkhukakbn());
                    pUiBean.setVtrkkzktrkkzkseiymd1(trkKzkList.get(idx).getTrkkzkseiymd());
                    pUiBean.setVtrkkzktrkkzksei1(trkKzkList.get(idx).getTrkkzksei());
                    pUiBean.setVtrkkzktrkkzktdk1(trkKzkList.get(idx).getTrkkzktdk());
                    pUiBean.setVtrkkzktrkkzkyno1(trkKzkList.get(idx).getTrkkzkyno());
                    pUiBean.setVtrkkzktrkkzkadr1kj1(trkKzkList.get(idx).getTrkkzkadr1kj());
                    pUiBean.setVtrkkzktrkkzkadr2kj1(trkKzkList.get(idx).getTrkkzkadr2kj());
                    pUiBean.setVtrkkzktrkkzkadr3kj1(trkKzkList.get(idx).getTrkkzkadr3kj());
                    pUiBean.setVtrkkzktrkkzktelno1(trkKzkList.get(idx).getTrkkzktelno());
                    pUiBean.setVtrkkzktrkkzkumukbn1(C_UmuKbn.ARI);
                }
                else if (C_TrkKzkKbn.TRKKZK2.eq(trkKzkList.get(idx).getTrkkzkkbn())) {

                    pUiBean.setVtrkkzktrkkzknmkn2(trkKzkList.get(idx).getTrkkzknmkn());
                    pUiBean.setVtrkkzktrkkzknmkj2(trkKzkList.get(idx).getTrkkzknmkj());
                    pUiBean.setVtrkkzktrkkzknmkjkhukakbn2(trkKzkList.get(idx).getTrkkzknmkjkhukakbn());
                    pUiBean.setVtrkkzktrkkzkseiymd2(trkKzkList.get(idx).getTrkkzkseiymd());
                    pUiBean.setVtrkkzktrkkzksei2(trkKzkList.get(idx).getTrkkzksei());
                    pUiBean.setVtrkkzktrkkzktdk2(trkKzkList.get(idx).getTrkkzktdk());
                    pUiBean.setVtrkkzktrkkzkyno2(trkKzkList.get(idx).getTrkkzkyno());
                    pUiBean.setVtrkkzktrkkzkadr1kj2(trkKzkList.get(idx).getTrkkzkadr1kj());
                    pUiBean.setVtrkkzktrkkzkadr2kj2(trkKzkList.get(idx).getTrkkzkadr2kj());
                    pUiBean.setVtrkkzktrkkzkadr3kj2(trkKzkList.get(idx).getTrkkzkadr3kj());
                    pUiBean.setVtrkkzktrkkzktelno2(trkKzkList.get(idx).getTrkkzktelno());
                    pUiBean.setVtrkkzktrkkzkumukbn2(C_UmuKbn.ARI);
                }
            }
        }

        return true;
    }

    public static void init(SetTrkKazokuExecUiBeanParam pUiBean) {
        pUiBean.setVtrkkzktrkkzknmkn1(BLANK);
        pUiBean.setVtrkkzktrkkzknmkj1(BLANK);
        pUiBean.setVtrkkzktrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        pUiBean.setVtrkkzktrkkzkseiymd1(null);
        pUiBean.setVtrkkzktrkkzksei1(C_Seibetu.BLNK);
        pUiBean.setVtrkkzktrkkzktdk1(C_Tdk.BLNK);
        pUiBean.setVtrkkzktrkkzkyno1(BLANK);
        pUiBean.setVtrkkzktrkkzkadr1kj1(BLANK);
        pUiBean.setVtrkkzktrkkzkadr2kj1(BLANK);
        pUiBean.setVtrkkzktrkkzkadr3kj1(BLANK);
        pUiBean.setVtrkkzktrkkzktelno1(BLANK);
        pUiBean.setVtrkkzktrkkzkumukbn1(C_UmuKbn.NONE);

        pUiBean.setVtrkkzktrkkzknmkn2(BLANK);
        pUiBean.setVtrkkzktrkkzknmkj2(BLANK);
        pUiBean.setVtrkkzktrkkzknmkjkhukakbn2(C_KjkhukaKbn.BLNK);
        pUiBean.setVtrkkzktrkkzkseiymd2(null);
        pUiBean.setVtrkkzktrkkzksei2(C_Seibetu.BLNK);
        pUiBean.setVtrkkzktrkkzktdk2(C_Tdk.BLNK);
        pUiBean.setVtrkkzktrkkzkyno2(BLANK);
        pUiBean.setVtrkkzktrkkzkadr1kj2(BLANK);
        pUiBean.setVtrkkzktrkkzkadr2kj2(BLANK);
        pUiBean.setVtrkkzktrkkzkadr3kj2(BLANK);
        pUiBean.setVtrkkzktrkkzktelno2(BLANK);
        pUiBean.setVtrkkzktrkkzkumukbn2(C_UmuKbn.NONE);
    }
}
