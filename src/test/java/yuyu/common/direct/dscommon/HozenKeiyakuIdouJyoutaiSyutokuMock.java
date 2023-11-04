package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.app.dsweb.dwdsinfo.dwgetdskanyuukeiyakuitiran.DwGetDsKanyuuKeiyakuItiranTest_execPostForm;
import yuyu.app.dsweb.dwninsyou.dwlogin.DwLoginTest_execPostForm;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_YuukshantkekKbn;

/**
 * {@link HozenKeiyakuIdouJyoutaiSyutoku}のモッククラスです。<br />
 */
public class HozenKeiyakuIdouJyoutaiSyutokuMock extends HozenKeiyakuIdouJyoutaiSyutoku {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";


    @Override
    public HozenKeiyakuIdouJyoutaiSyutokuBean hozenKeiyakuIdouJyoutaiSyutoku(String pSyoNo) {

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = SWAKInjector
            .getInstance(HozenKeiyakuIdouJyoutaiSyutokuBean.class);

        if (caller == DwLoginTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {

            idouJyoutaiSyutokuBean.setYuukouKbn(C_YuukshantkekKbn.OK);
            idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUTYUU);
        }
        else if (caller == DwLoginTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {

            idouJyoutaiSyutokuBean.setYuukouKbn(C_YuukshantkekKbn.NG);
            idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUNASHI);
        }
        else if (caller == DwLoginTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)) {

            super.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);
            idouJyoutaiSyutokuBean.setYuukouKbn(C_YuukshantkekKbn.OK);
            idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUNASHI);
        }
        else if (caller == DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {

            idouJyoutaiSyutokuBean.setYuukouKbn(C_YuukshantkekKbn.OK);
            idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUNASHI);
        }
        else if (caller == DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {

            if ("17806000024".equals(pSyoNo)) {
                idouJyoutaiSyutokuBean.setYuukouKbn(C_YuukshantkekKbn.NG);
                idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUNASHI);
            }
            else if ("17806000035".equals(pSyoNo)) {
                idouJyoutaiSyutokuBean.setYuukouKbn(C_YuukshantkekKbn.OK);
                idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUTYUU);
            }
            else if ("17806000046".equals(pSyoNo) || "17806000068".equals(pSyoNo)) {
                idouJyoutaiSyutokuBean.setYuukouKbn(C_YuukshantkekKbn.OK);
                idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUNASHI);
            }
            else if ("17806000057".equals(pSyoNo)) {
                idouJyoutaiSyutokuBean.setYuukouKbn(C_YuukshantkekKbn.ERROR);
                idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.ERROR);
            }

        }
        else if (caller == GenkyouTuutiKariPasswordHakkouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.ERROR);
        }
        else if (caller == GenkyouTuutiKariPasswordHakkouTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUTYUU);
        }
        else if (caller == GenkyouTuutiKariPasswordHakkouTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUNASHI);
        }

        else if (caller == CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUTYUU);

            } else if (TESTPATTERN2.equals(SYORIPTN)) {

                idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.ERROR);

            } else {
                idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUNASHI);
            }
        }
        else {
            idouJyoutaiSyutokuBean = super.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);
        }

        return idouJyoutaiSyutokuBean;
    }

    @Override
    public C_YuukshantkekKbn keiyakuJyoutaiYuukouseiHantei(String pSyoNo) {

        C_YuukshantkekKbn yuukouKbn = null;

        if (caller == HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutoku.class && TESTPATTERN1.equals(SYORIPTN)) {

            yuukouKbn = C_YuukshantkekKbn.NG;

        }
        else if (caller == HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutoku.class && TESTPATTERN2.equals(SYORIPTN)) {

            yuukouKbn = C_YuukshantkekKbn.ERROR;

        }
        else if (caller == HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutoku.class && TESTPATTERN3.equals(SYORIPTN)) {

            yuukouKbn = C_YuukshantkekKbn.OK;

        }

        else if (caller == HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu.class && TESTPATTERN1.equals(SYORIPTN)) {

            yuukouKbn = C_YuukshantkekKbn.NG;

        }
        else if (caller == HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu.class && TESTPATTERN2.equals(SYORIPTN)) {

            yuukouKbn = C_YuukshantkekKbn.ERROR;

        }
        else if (caller == HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu.class && TESTPATTERN3.equals(SYORIPTN)) {

            yuukouKbn = C_YuukshantkekKbn.OK;

        }


        else {
            yuukouKbn = super.keiyakuJyoutaiYuukouseiHantei(pSyoNo);
        }

        return yuukouKbn;
    }
}
