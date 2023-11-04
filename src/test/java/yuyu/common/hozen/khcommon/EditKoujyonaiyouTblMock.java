package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 控除証明内容TBL編集のモッククラスです。<br />
 */
public class EditKoujyonaiyouTblMock extends EditKoujyonaiyouTbl {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private String kinouId = "";
    private String userId  = "";
    private String sysTime = "";
    private C_KoujyosymnaiyourecKbn koujyoSymNaiyouRecKbn = C_KoujyosymnaiyourecKbn.BLNK;
    private C_UmuKbn pmnjTkHnkUmu  = C_UmuKbn.NONE;
    private BizDate calcKjnYmd = null;
    private BizDateYM henmaeJkipJytYm = null;
    private String henmaeHenkousikibetukey = "";
    private C_Hrkkaisuu henmaeHrkKaisuu = C_Hrkkaisuu.BLNK;
    private C_UmuKbn ikkatuNyknUmu = C_UmuKbn.NONE;
    private BizDateYM nyknJskStartYm = null;
    private BizDateYM nyknJskEndYm = null;
    private int nyknJskRenno = 0;
    private BizDate nyknJskRyosyuYmd = null;
    private int nyknJskJytKaisuuY = 0;
    private int nyknJskJytKaisuuM = 0;
    private int kihrkpSeisanRenno = 0;
    private BizDateYM kihrkpSeisanJytYm = null;
    private int kihrkpSeisanJytKaisuuY = 0;
    private int kihrkpSeisanJytKaisuuM = 0;
    private int koujyoSymNaiyouRenNo = 0;

    @Override
    public void setCalcKjnYmd(BizDate pCalcKjnYmd) {
        super.setCalcKjnYmd(pCalcKjnYmd);
    }

    @Override
    public void setHenmaeJkipJytYm(BizDateYM pHenmaeJkipJytYm) {
        super.setHenmaeJkipJytYm(pHenmaeJkipJytYm);
    }

    @Override
    public void setHenmaeHenkousikibetukey(String pHenmaeHenkousikibetukey) {
        super.setHenmaeHenkousikibetukey(pHenmaeHenkousikibetukey);
    }

    @Override
    public void setHenmaeHrkKaisuu(C_Hrkkaisuu pHenmaeHrkKaisuu) {
        super.setHenmaeHrkKaisuu(pHenmaeHrkKaisuu);
    }

    @Override
    public void setIkkatuNyknUmu(C_UmuKbn pIkkatuNyknUmu) {
        super.setIkkatuNyknUmu(pIkkatuNyknUmu);
    }

    @Override
    public void setNyknJskStartYm(BizDateYM pNyknJskStartYm) {
        super.setNyknJskStartYm(pNyknJskStartYm);
    }

    @Override
    public void setNyknJskEndYm(BizDateYM pNyknJskEndYm) {
        super.setNyknJskEndYm(pNyknJskEndYm);
    }

    @Override
    public void setNyknJskRenno(int pNyknJskRenno) {
        super.setNyknJskRenno(pNyknJskRenno);
    }

    @Override
    public void setNyknJskRyosyuYmd(BizDate pNyknJskRyosyuYmd) {
        super.setNyknJskRyosyuYmd(pNyknJskRyosyuYmd);
    }

    @Override
    public void setNyknJskJytKaisuuY(int pNyknJskJytKaisuuY) {
        super.setNyknJskJytKaisuuY(pNyknJskJytKaisuuY);
    }

    @Override
    public void setNyknJskJytKaisuuM(int pNyknJskJytKaisuuM) {
        super.setNyknJskJytKaisuuM(pNyknJskJytKaisuuM);
    }

    @Override
    public void setKihrkpSeisanRenno(int pKihrkpSeisanRenno) {
        super.setKihrkpSeisanRenno(pKihrkpSeisanRenno);
    }

    @Override
    public void setKihrkpSeisanJytYm(BizDateYM pKihrkpSeisanJytYm) {
        super.setKihrkpSeisanJytYm(pKihrkpSeisanJytYm);
    }

    @Override
    public void setKihrkpSeisanJytKaisuuY(int pKihrkpSeisanJytKaisuuY) {
        super.setKihrkpSeisanJytKaisuuY(pKihrkpSeisanJytKaisuuY);
    }

    @Override
    public void setKihrkpSeisanJytKaisuuM(int pKihrkpSeisanJytKaisuuM) {
        super.setKihrkpSeisanJytKaisuuM(pKihrkpSeisanJytKaisuuM);
    }

    @Override
    public C_ErrorKbn exec(KhozenCommonParam pKCParam,
        String pSyono, C_KjsymnytblhensyuusyoriKbn pSyoriKbn, BizDate pSyoriYmd) {

        if ((caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == EditKaiyakuTblUpdateTest_exec.class ||
            caller == KykHenkoujiZnnJytTrksKsnTest_exec.class) &&
            TESTPATTERN1.equals(SYORIPTN) ||
            TESTPATTERN4.equals(SYORIPTN) ||
            TESTPATTERN2.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }

        return super.exec(pKCParam, pSyono, pSyoriKbn, pSyoriYmd);
    }

    @Override
    public void setZennouKoujyogakuKeisanParam(ZennouKoujyogakuKeisanParam pZennouKoujyogakuKeisanParam) {

        if (caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec7.class) {
            pZennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf("20181224"));
            pZennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("30");
            pZennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(123456789));
            pZennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(122345789));
            pZennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            pZennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf("20181212"));
            pZennouKoujyogakuKeisanParam.setZennourenno(2);
        }
        else {
            super.setZennouKoujyogakuKeisanParam(pZennouKoujyogakuKeisanParam);
        }
    }

}