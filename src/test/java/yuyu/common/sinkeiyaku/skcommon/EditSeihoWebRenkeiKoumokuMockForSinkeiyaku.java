package yuyu.common.sinkeiyaku.skcommon;

import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_PWaribikitekiyouKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link EditSeihoWebRenkeiKoumoku}のモッククラスです。<br />
 */
public class EditSeihoWebRenkeiKoumokuMockForSinkeiyaku extends EditSeihoWebRenkeiKoumoku {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static final String TESTPATTERN13 = "13";

    public static final String TESTPATTERN14 = "14";

    public static final String TESTPATTERN15 = "15";

    public static final String TESTPATTERN16 = "16";

    public static final String TESTPATTERN17 = "17";

    public static final String TESTPATTERN18 = "18";

    public static final String TESTPATTERN19 = "19";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_UmuKbn kjmeigihkhunouumukbnSyutoku(String pTksykmcd1, String pTksykmcd2, String pTksykmcd3,
        String pTksykmcd4, String pTksykmcd5) {

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                super.kjmeigihkhunouumukbnSyutoku(pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);

                return C_UmuKbn.ARI;
            }
        }

        return super.kjmeigihkhunouumukbnSyutoku(pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
    }

    @Override
    public C_UmuKbn tsryhshrkykumukbnSyutoku(String pTksykmcd1, String pTksykmcd2, String pTksykmcd3,
        String pTksykmcd4, String pTksykmcd5) {

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                super.tsryhshrkykumukbnSyutoku(pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);

                return C_UmuKbn.ARI;
            }
        }

        return super.tsryhshrkykumukbnSyutoku(pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
    }

    @Override
    public C_UmuKbn syosisyatodokeumukbnSyutoku(String pTksykmcd1, String pTksykmcd2, String pTksykmcd3,
        String pTksykmcd4, String pTksykmcd5) {

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                super.syosisyatodokeumukbnSyutoku(pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);

                return C_UmuKbn.ARI;
            }
        }

        return super.syosisyatodokeumukbnSyutoku(pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
    }

    @Override
    public C_UmuKbn kakukisyouryakukbumukbnSyutoku(String pTksykmcd1, String pTksykmcd2, String pTksykmcd3,
        String pTksykmcd4, String pTksykmcd5) {

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                super.kakukisyouryakukbumukbnSyutoku(pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);

                return C_UmuKbn.ARI;
            }
        }

        return super.kakukisyouryakukbumukbnSyutoku(pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
    }

    @Override
    public C_UmuKbn seiymdmosseitouumukbnSyutoku(String pTksykmcd1, String pTksykmcd2, String pTksykmcd3,
        String pTksykmcd4, String pTksykmcd5) {

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                super.seiymdmosseitouumukbnSyutoku(pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);

                return C_UmuKbn.ARI;
            }
        }

        return super.seiymdmosseitouumukbnSyutoku(pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
    }

    @Override
    public C_Sknenkinsyu sknenkinsyuHenkan(String pNksyukbn) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN5.equals(SYORIPTN)) {

                return C_Sknenkinsyu.KKTI5;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                return C_Sknenkinsyu.KKTI5;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {

                return C_Sknenkinsyu.KKTI15;
            }
            else if (TESTPATTERN17.equals(SYORIPTN)) {

                return C_Sknenkinsyu.SGKHSYSYSN;
            }
            else if (TESTPATTERN18.equals(SYORIPTN)) {

                return C_Sknenkinsyu.SGKHSYSYSN;
            }

            return C_Sknenkinsyu.KKTI10;
        }

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_Sknenkinsyu.KKTI5;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_Sknenkinsyu.KKTI15;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_Sknenkinsyu.SGKHSYSYSN;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return C_Sknenkinsyu.BLNK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                return C_Sknenkinsyu.KKTI10;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                return C_Sknenkinsyu.BLNK;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                return C_Sknenkinsyu.KKTI5;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                return C_Sknenkinsyu.KKTI5DAI1BAIGAKU;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {

                return C_Sknenkinsyu.KKTI10;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                return C_Sknenkinsyu.KKTI5;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {

                return C_Sknenkinsyu.KKTI15;
            }
            else if (TESTPATTERN13.equals(SYORIPTN)) {

                return C_Sknenkinsyu.SGKHSYSYSN;
            }
            else if (TESTPATTERN15.equals(SYORIPTN)) {

                return C_Sknenkinsyu.KKTI5DAI1BAIGAKU;
            }
            else if (TESTPATTERN16.equals(SYORIPTN)) {

                return C_Sknenkinsyu.SGKHSYSYSN;
            }

        }

        return super.sknenkinsyuHenkan(pNksyukbn);
    }

    @Override
    public BizDate mosymdHensyuu(BizDate pKijyunymd, String pHaraikomikaisukbn, String pHknsyuruino) {
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf("20180101");
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf("20180117");
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizDate.valueOf("20180116");
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizDate.valueOf("20180117");
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizDate.valueOf("20180117");
            }else if (TESTPATTERN7.equals(SYORIPTN)) {
                return BizDate.valueOf("20180117");
            }else if (TESTPATTERN9.equals(SYORIPTN)) {
                return BizDate.valueOf("20180117");
            }else if (TESTPATTERN17.equals(SYORIPTN)) {
                return BizDate.valueOf("20180117");
            }else if (TESTPATTERN18.equals(SYORIPTN)) {
                return BizDate.valueOf("20180117");
            }
        }

        if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf("20171119");
            }
        }
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf("20180427");
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf("20180427");
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizDate.valueOf("20180427");
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizDate.valueOf("20180427");
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizDate.valueOf("20180427");
            }else if (TESTPATTERN7.equals(SYORIPTN)) {
                return BizDate.valueOf("20180427");
            }else if (TESTPATTERN16.equals(SYORIPTN)) {
                return BizDate.valueOf("20180427");
            }
        }

        return super.mosymdHensyuu(pKijyunymd, pHaraikomikaisukbn, pHknsyuruino);
    }

    @Override
    public C_Tkhukaumu syksbYensitiHsyuTkhkKbn(String pYensitihsyutkykarihyj, C_HknsyuruiNo pHknsyuruino) {
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            return C_Tkhukaumu.HUKA;
        }
        return super.syksbYensitiHsyuTkhkKbn(pYensitihsyutkykarihyj, pHknsyuruino);
    }

    @Override
    public C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbnHenkan(Integer pHaibunwariai, C_UmuKbn pTmttknhaibunwarisiteiumu) {
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            return C_TumitatekinHaibunWariKbn.WARIAI010;
        }
        return super.tumitatekinHaibunWariKbnHenkan(pHaibunwariai, pTmttknhaibunwarisiteiumu);
    }

    @Override
    public Integer hknkknSyutoku(Integer pHknkkn, Integer pSueokikkn, C_HknsyuruiNo pHknsyuruino) {
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            return 10;
        }
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 10;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return 10;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                return 10;
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                return 10;
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                return 10;
            }else if (TESTPATTERN7.equals(SYORIPTN)) {
                return 10;
            }else if (TESTPATTERN8.equals(SYORIPTN)) {
                return 10;
            }else if (TESTPATTERN9.equals(SYORIPTN)) {
                return 10;
            }else if (TESTPATTERN11.equals(SYORIPTN)) {
                return 10;
            }else if (TESTPATTERN12.equals(SYORIPTN)) {
                return 10;
            }else if (TESTPATTERN13.equals(SYORIPTN)) {
                return 10;
            }else if (TESTPATTERN16.equals(SYORIPTN)) {
                return 5;
            }
        }
        return super.hknkknSyutoku(pHknkkn, pSueokikkn, pHknsyuruino);
    }

    @Override
    public C_Tdk zrnUktTdkKbn(String pZrnukttdkkbn) {
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_Tdk.BLNK;
            }
        }
        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_Tdk.BLNK;
            }
        }
        return super.zrnUktTdkKbn(pZrnukttdkkbn);
    }

    @Override
    public C_Tuukasyu tuukasyuHenkan(String pTuukakbn) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class ) {

            if (TESTPATTERN5.equals(SYORIPTN)) {

                return C_Tuukasyu.JPY;
            }
            else if(TESTPATTERN6.equals(SYORIPTN)){

                return C_Tuukasyu.JPY;
            }
            else if(TESTPATTERN7.equals(SYORIPTN)){

                return C_Tuukasyu.JPY;
            }
            else if(TESTPATTERN8.equals(SYORIPTN)){

                return C_Tuukasyu.USD;
            }
            else if(TESTPATTERN18.equals(SYORIPTN)){

                return C_Tuukasyu.JPY;
            }
            else if(TESTPATTERN19.equals(SYORIPTN)){

                return C_Tuukasyu.EUR;
            }
        }


        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_Tuukasyu.USD;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_Tuukasyu.JPY;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_Tuukasyu.JPY;
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_Tuukasyu.JPY;
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_Tuukasyu.JPY;
            }else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_Tuukasyu.JPY;
            }else if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_Tuukasyu.JPY;
            }else if (TESTPATTERN8.equals(SYORIPTN)) {
                return C_Tuukasyu.JPY;
            }else if (TESTPATTERN9.equals(SYORIPTN)) {
                return C_Tuukasyu.USD;
            }else if (TESTPATTERN11.equals(SYORIPTN)) {
                return C_Tuukasyu.USD;
            }else if (TESTPATTERN12.equals(SYORIPTN)) {
                return C_Tuukasyu.JPY;
            }else if (TESTPATTERN13.equals(SYORIPTN)) {
                return C_Tuukasyu.JPY;
            }else if (TESTPATTERN16.equals(SYORIPTN)) {
                return C_Tuukasyu.JPY;
            }
        }
        return super.tuukasyuHenkan(pTuukakbn);

    }

    @Override
    public C_Hrkkaisuu hrkkaisuuHenkan(String pHaraikomikaisukbn) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN5.equals(SYORIPTN)) {

                return C_Hrkkaisuu.TUKI;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                return C_Hrkkaisuu.HALFY;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                return C_Hrkkaisuu.TUKI;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                return C_Hrkkaisuu.HALFY;
            }
            else if (TESTPATTERN18.equals(SYORIPTN)) {

                return C_Hrkkaisuu.TUKI;
            }
        }

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_Hrkkaisuu.TUKI;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_Hrkkaisuu.TUKI;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_Hrkkaisuu.TUKI;
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_Hrkkaisuu.TUKI;
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_Hrkkaisuu.TUKI;
            }else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_Hrkkaisuu.TUKI;
            }else if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_Hrkkaisuu.TUKI;
            }else if (TESTPATTERN16.equals(SYORIPTN)) {
                return C_Hrkkaisuu.TUKI;
            }
        }

        return super.hrkkaisuuHenkan(pHaraikomikaisukbn);

    }

    @Override
    public C_Hhknsei hhknseiHenkan(String pHhknsei) {

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_Hhknsei.MALE;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_Hhknsei.MALE;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_Hhknsei.MALE;
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_Hhknsei.MALE;
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_Hhknsei.MALE;
            }else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_Hhknsei.MALE;
            }else if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_Hhknsei.MALE;
            }else if (TESTPATTERN16.equals(SYORIPTN)) {
                return C_Hhknsei.MALE;
            }
        }

        return super.hhknseiHenkan(pHhknsei);
    }

    @Override
    public BizCurrency huho2GetMosheijyunp(String pHaraikomikaisukbn, String pNyuukintuukakbn,
        Long pNykntuukanykngk, Long pGnykntuknykngk) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            return BizCurrency.valueOf(new BigDecimal("7894561230"));
        }

        return super.huho2GetMosheijyunp(pHaraikomikaisukbn, pNyuukintuukakbn, pNykntuukanykngk, pGnykntuknykngk);
    }

    @Override
    public C_IkkatubaraiKbn huho2GetIkkatubaraikbn(String pIkkatubaraiKbn) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN7.equals(SYORIPTN)) {

                return C_IkkatubaraiKbn.BLNK;
            }
            if (TESTPATTERN17.equals(SYORIPTN)) {

                return C_IkkatubaraiKbn.TEIKIIKKATU;
            }
            if (TESTPATTERN18.equals(SYORIPTN)) {

                return C_IkkatubaraiKbn.TEIKIIKKATU;
            }

            return C_IkkatubaraiKbn.IKKATU;
        }
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_IkkatubaraiKbn.IKKATU;
            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_IkkatubaraiKbn.IKKATU;
            }

            else if (TESTPATTERN5.equals(SYORIPTN)) {

                return C_IkkatubaraiKbn.IKKATU;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                return C_IkkatubaraiKbn.IKKATU;
            }

            else if (TESTPATTERN9.equals(SYORIPTN)) {

                return C_IkkatubaraiKbn.IKKATU;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                return C_IkkatubaraiKbn.IKKATU;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {

                return C_IkkatubaraiKbn.IKKATU;
            }

            return C_IkkatubaraiKbn.BLNK;
        }


        return super.huho2GetIkkatubaraikbn(pIkkatubaraiKbn);
    }

    @Override
    public C_IkkatubaraiKaisuuKbn huho2GetIkkatubaraikaisuu(String pIkkatubaraikaisuu) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            return C_IkkatubaraiKaisuuKbn.BLNK;
        }

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_IkkatubaraiKaisuuKbn.IKKATU11;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_IkkatubaraiKaisuuKbn.IKKATU8;
            }

            else if (TESTPATTERN9.equals(SYORIPTN)) {
                return C_IkkatubaraiKaisuuKbn.IKKATU7;
            }

            return C_IkkatubaraiKaisuuKbn.IKKATU6;
        }


        return super.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
    }

    @Override
    public C_UmuKbn huho2GetZennoumousideumu(String pZennouhyouji) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN5.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }
            else if (TESTPATTERN17.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }
            else if (TESTPATTERN19.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }

            return C_UmuKbn.NONE;
        }

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }

            else if (TESTPATTERN5.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                return C_UmuKbn.ARI;
            }

            return C_UmuKbn.NONE;
        }

        return super.huho2GetZennoumousideumu(pZennouhyouji);
    }

    @Override
    public C_BlnktkumuKbn huho2GetZenkizennouumu(C_UmuKbn pZenkizennoutekiumu, String pZennouhyouji) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            return C_BlnktkumuKbn.BLNK;
        }

        return super.huho2GetZenkizennouumu(pZenkizennoutekiumu, pZennouhyouji);
    }

    @Override
    public Integer huho2GetZnnkai(Integer pZennoukikan) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            return 12;
        }

        return super.huho2GetZnnkai(pZennoukikan);
    }

    @Override
    public C_Tkhukaumu huho2GetKjnnkpzeitekitkhukakbn(C_UmuKbn pZeiseitekikakuumu,
        String pTksykmcd1, String pTksykmcd2, String pTksykmcd3, String pTksykmcd4, String pTksykmcd5) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            return C_Tkhukaumu.BLNK;
        }

        return super.huho2GetKjnnkpzeitekitkhukakbn(pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4,
            pTksykmcd5);
    }

    @Override
    public C_HrkkknsmnKbn hrkkknsmnkbnSyutoku(C_HknsyuruiNo pHknsyuruino, Integer pPhrkkikn) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            return C_HrkkknsmnKbn.BLNK;
        }

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_HrkkknsmnKbn.BLNK;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                return C_HrkkknsmnKbn.NENMANKI;
            }
            return C_HrkkknsmnKbn.BLNK;
        }

        return super.hrkkknsmnkbnSyutoku(pHknsyuruino, pPhrkkikn);
    }

    @Override
    public String seihoWebGetPwaribikirankkbn(C_PWaribikitekiyouKbn pPwaribikitekiyoukbn) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            return "1";
        }

        return super.seihoWebGetPwaribikirankkbn(pPwaribikitekiyoukbn);
    }

    @Override
    public C_TargetTkMokuhyoutiKbn targettkmkhtkbnSyutoku(Integer pTargettkmokuhyouti) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN8.equals(SYORIPTN)) {

                return C_TargetTkMokuhyoutiKbn.TARGET105;
            }
        }

        return super.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
    }

    @Override
    public C_HknsyuruiNo huho2EditHknsyuruino(String pHknsyuruino) {

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU;
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT;
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU;
            }else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU;
            }else if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU;
            }else if (TESTPATTERN8.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKARIRITUHENDOUNK;
            }else if (TESTPATTERN9.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND;
            }else if (TESTPATTERN11.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU;
            }else if (TESTPATTERN12.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI;
            }else if (TESTPATTERN13.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAINDEXNK;
            }else if (TESTPATTERN14.equals(SYORIPTN)) {
                return C_HknsyuruiNo.BLNK;
            }else if (TESTPATTERN15.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU;
            }else if (TESTPATTERN16.equals(SYORIPTN)) {
                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU;
            }

        }

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI;
            }
        }

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN2.equals(SYORIPTN) ||
                TESTPATTERN5.equals(SYORIPTN) || TESTPATTERN6.equals(SYORIPTN) ||
                TESTPATTERN7.equals(SYORIPTN) || TESTPATTERN8.equals(SYORIPTN) ) {

                if ("444".equals(pHknsyuruino)) {

                    return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI;
                }
            }
            else if (TESTPATTERN16.equals(SYORIPTN)) {

                return C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI;
            }
        }

        return super.huho2EditHknsyuruino(pHknsyuruino);
    }

    @Override
    public C_Tdk hhkdrtdkkbnHenkan(String pTdkkbn) {
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_Tdk.BLNK;
            }
        }
        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_Tdk.BLNK;
            }
        }
        return super.hhkdrtdkkbnHenkan(pTdkkbn);
    }

    @Override
    public C_FstphrkkeiroKbn fstphrkkeiroHenkan(String pHaraikomikaisukbn, String pHrkkeirokbn, String pTkiyougyoutaikbn) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_FstphrkkeiroKbn.CREDIT;
            }
        }

        return super.fstphrkkeiroHenkan(pHaraikomikaisukbn, pHrkkeirokbn, pTkiyougyoutaikbn);
    }

    @Override
    public C_Tkhukaumu teikisiharaitkykhkkbnSyutoku(String pTeikisiharaiarihyj, C_HknsyuruiNo pHknsyuruino) {
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_Tkhukaumu.HUKA;
            }
        }

        return super.teikisiharaitkykhkkbnSyutoku(pTeikisiharaiarihyj, pHknsyuruino);
    }

    @Override
    public String syouhnhantei(C_HknsyuruiNo pHknsyuruiNo) {
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN2.equals(SYORIPTN) ||
                TESTPATTERN5.equals(SYORIPTN) || TESTPATTERN6.equals(SYORIPTN) ||
                TESTPATTERN7.equals(SYORIPTN) || TESTPATTERN8.equals(SYORIPTN) ) {

                if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(pHknsyuruiNo)) {

                    return "1";
                }
            }
            else if (TESTPATTERN16.equals(SYORIPTN)) {

                return "1";
            }
            else if (TESTPATTERN17.equals(SYORIPTN)) {

                return "2";
            }
            else if (TESTPATTERN18.equals(SYORIPTN)) {

                return "2";
            }
        }

        return super.syouhnhantei(pHknsyuruiNo);
    }
}