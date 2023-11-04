package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 控除証明内容TBL編集{@link EditKoujyonaiyouTbl}のモッククラスです。<br />
 */
public class EditKoujyonaiyouTblMockForHozen extends EditKoujyonaiyouTbl {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

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

        if (caller == EditKaiyakuTblUpdateTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN) ||
                TESTPATTERN4.equals(SYORIPTN) ||
                TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pKCParam, pSyono, pSyoriKbn, pSyoriYmd);
    }

    @Override
    public void setZennouKoujyogakuKeisanParam(ZennouKoujyogakuKeisanParam pZennouKoujyogakuKeisanParam) {

        super.setZennouKoujyogakuKeisanParam(pZennouKoujyogakuKeisanParam);

    }

}