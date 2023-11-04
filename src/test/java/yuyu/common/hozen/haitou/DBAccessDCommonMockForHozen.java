package yuyu.common.hozen.haitou;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;

/**
 * {@link DBAccessDCommon}のモッククラスです。<br />
 */
public class DBAccessDCommonMockForHozen extends DBAccessDCommon {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn getSaisinHaitouKanriSyu(String pSyono) {

        if (caller == CheckDSeigouTest_checkHaitoukanriTBL.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == CheckDSeigouTest_exec.class || caller == CheckDSeigouTest_init.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.getSaisinHaitouKanriSyu(pSyono);
    }

    @Override
    public IT_KhHaitouKanri getKhHaitouKanri() {

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();
        if (caller == CheckDSeigouTest_checkHaitoukanriTBL.class ) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                khHaitouKanri.setKbnkey("01");
                khHaitouKanri.setSyono("60806000011");
                khHaitouKanri.setHaitounendo(BizDateY.valueOf(2018));
                khHaitouKanri.setRenno(1);
                khHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIDSIHARAI);
                khHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);

                return khHaitouKanri;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return null;
            }
        }
        if (caller == CheckDSeigouTest_exec.class || caller == CheckDSeigouTest_init.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                khHaitouKanri.setKbnkey("01");
                khHaitouKanri.setSyono("60806000011");
                khHaitouKanri.setHaitounendo(BizDateY.valueOf(2018));
                khHaitouKanri.setRenno(1);
                khHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIDSIHARAI);
                khHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);

                return khHaitouKanri;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                khHaitouKanri.setKbnkey("01");
                khHaitouKanri.setSyono("60806000011");
                khHaitouKanri.setHaitounendo(BizDateY.valueOf(2018));
                khHaitouKanri.setRenno(1);
                khHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIDSIHARAI);
                khHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);

                return khHaitouKanri;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return null;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                khHaitouKanri.setKbnkey("01");
                khHaitouKanri.setSyono("60806000011");
                khHaitouKanri.setHaitounendo(BizDateY.valueOf(2018));
                khHaitouKanri.setRenno(1);
                khHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIDSIHARAI);
                khHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);

                return khHaitouKanri;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                khHaitouKanri.setKbnkey("01");
                khHaitouKanri.setSyono("60806000011");
                khHaitouKanri.setHaitounendo(BizDateY.valueOf(2018));
                khHaitouKanri.setRenno(1);
                khHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIDSIHARAI);
                khHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);

                return khHaitouKanri;
            }
        }
        if(KeisanDCommonTest_calcKariwariateDGanrikin.class == caller){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                khHaitouKanri.setKariwariatedruigk(BizCurrency.valueOf(123));
                khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khHaitouKanri;
            }
        }

        if(KeisanDCommonTest_calcTumitateDGanrikin.class == caller){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                khHaitouKanri.setKariwariatedruigk(BizCurrency.valueOf(123));
                khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khHaitouKanri;
            }
        }

        if(KeisanDCommonGengakuTest_calcDShrgk.class == caller){

            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khHaitouKanri;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
                return khHaitouKanri;
            }
        }

        if(KeisanDCommonKaiyakuTest_calcDShrgk.class == caller){

            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khHaitouKanri;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
                return khHaitouKanri;
            }
        }

        if(KeisanDCommonSibouTest_calcDShrgk.class == caller){

            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khHaitouKanri;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
                return khHaitouKanri;
            }
        }

        if(KeisanDCommonYendtHnk_calcDkngk.class == caller){

            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khHaitouKanri;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
                return khHaitouKanri;
            }
        }

        return super.getKhHaitouKanri();
    }

    @Override
    public C_ErrorKbn getSaisinTumitateDKanri(String pSyono) {
        if (caller == CheckDSeigouTest_checkTumitateDkanriTBL.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == CheckDSeigouTest_exec.class || caller == CheckDSeigouTest_init.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.getSaisinTumitateDKanri(pSyono);
    }

    @Override
    public IT_KhTumitateDKanri getKhTumitateDKanri() {

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();

        if (caller == CheckDSeigouTest_checkTumitateDkanriTBL.class ) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                khTumitateDKanri.setKbnkey("02");
                khTumitateDKanri.setSyono("60806000022");
                khTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20180609));
                khTumitateDKanri.setRenno(1);

                return khTumitateDKanri;
            }
            else  if (TESTPATTERN3.equals(SYORIPTN)){
                return null;
            }
        }

        if (caller == CheckDSeigouTest_exec.class || caller == CheckDSeigouTest_init.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                khTumitateDKanri.setKbnkey("02");
                khTumitateDKanri.setSyono("60806000022");
                khTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20180609));
                khTumitateDKanri.setRenno(1);

                return khTumitateDKanri;
            }
            else  if (TESTPATTERN3.equals(SYORIPTN)){

                khTumitateDKanri.setKbnkey("02");
                khTumitateDKanri.setSyono("60806000022");
                khTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20180609));
                khTumitateDKanri.setRenno(1);

                return khTumitateDKanri;

            }
            else  if (TESTPATTERN4.equals(SYORIPTN)){

                khTumitateDKanri.setKbnkey("02");
                khTumitateDKanri.setSyono("60806000022");
                khTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20180609));
                khTumitateDKanri.setRenno(1);

                return khTumitateDKanri;

            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                khTumitateDKanri.setKbnkey("02");
                khTumitateDKanri.setSyono("60806000022");
                khTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20180609));
                khTumitateDKanri.setRenno(1);

                return khTumitateDKanri;
            }
        }

        if(KeisanDCommonTest_calcKariwariateDGanrikin.class == caller){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                khTumitateDKanri.setTumitated(BizCurrency.valueOf(456));
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khTumitateDKanri;
            }
        }

        if(KeisanDCommonTest_calcTumitateDGanrikin.class == caller){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                khTumitateDKanri.setTumitated(BizCurrency.valueOf(456));
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khTumitateDKanri;
            }
        }

        if(KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khTumitateDKanri;
            }
            if (TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
                return khTumitateDKanri;
            }
        }

        if(KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khTumitateDKanri;
            }
            if (TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
                return khTumitateDKanri;
            }
        }

        if(KeisanDCommonGengakuTest_calcDShrgk.class == caller){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khTumitateDKanri;
            }
            if (TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
                return khTumitateDKanri;
            }
        }

        if(KeisanDCommonKaiyakuTest_calcDShrgk.class == caller){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khTumitateDKanri;
            }
            if (TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
                return khTumitateDKanri;
            }
        }

        if(KeisanDCommonSibouTest_calcDShrgk.class == caller){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khTumitateDKanri;
            }
            if (TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
                return khTumitateDKanri;
            }
        }

        if(KeisanDCommonYendtHnk_calcDkngk.class == caller){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return khTumitateDKanri;
            }
            if (TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
                return khTumitateDKanri;
            }
        }

        return super.getKhTumitateDKanri();
    }

    @Override
    public C_ErrorKbn getKijyunymdTykzenHaitouKanriSyu(String pSyono, BizDate pKijyunymd) {

        if(KeisanDCommonTest_calcKariwariateDGanrikin.class == caller){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if(KeisanDCommonTest_calcTumitateDGanrikin.class == caller){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if(KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller){

            return C_ErrorKbn.OK;
        }

        if(KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller){

            return C_ErrorKbn.OK;
        }

        if(KeisanDCommonGengakuTest_calcDShrgk.class == caller){

            return C_ErrorKbn.OK;
        }

        if(KeisanDCommonKaiyakuTest_calcDShrgk.class == caller){

            return C_ErrorKbn.OK;
        }

        if(KeisanDCommonSibouTest_calcDShrgk.class == caller){

            return C_ErrorKbn.OK;
        }

        if(KeisanDCommonYendtHnk_calcDkngk.class == caller){

            return C_ErrorKbn.OK;
        }

        return super.getKijyunymdTykzenHaitouKanriSyu(pSyono, pKijyunymd);
    }

    @Override
    public C_ErrorKbn getKijyunymdTykzenTumitateDKanri(String pSyono, BizDate pKijyunymd) {

        if(KeisanDCommonTest_calcKariwariateDGanrikin.class == caller){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if(KeisanDCommonTest_calcTumitateDGanrikin.class == caller){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if(KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller){

            return C_ErrorKbn.OK;
        }

        if(KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller){

            return C_ErrorKbn.OK;
        }

        if(KeisanDCommonGengakuTest_calcDShrgk.class == caller){

            return C_ErrorKbn.OK;
        }

        if(KeisanDCommonKaiyakuTest_calcDShrgk.class == caller){

            return C_ErrorKbn.OK;
        }

        if(KeisanDCommonSibouTest_calcDShrgk.class == caller){

            return C_ErrorKbn.OK;
        }

        if(KeisanDCommonYendtHnk_calcDkngk.class == caller){

            return C_ErrorKbn.OK;
        }

        return super.getKijyunymdTykzenTumitateDKanri(pSyono, pKijyunymd);
    }
}
