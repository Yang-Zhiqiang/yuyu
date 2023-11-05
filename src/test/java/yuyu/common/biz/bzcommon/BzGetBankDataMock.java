package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.app.dsweb.dwdsinfo.dwgetsoukinyoukouzainfo.DwGetSoukinyouKouzaInfoTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenhokenryohurikaekouzainfo.DwGetHozenHokenryoHurikaeKouzaInfoTest_execPostForm;
import yuyu.common.biz.kaikei.BzFbSoukinFileSksTest_creadFBsoukinfwairu;
import yuyu.common.direct.dscommon.CheckKaiyakuUketukeTest_kaiyakusyokaiChk;
import yuyu.common.hozen.khcommon.CheckKzhuriKouzaTest_execA1;
import yuyu.common.hozen.khcommon.CheckKzhuriKouzaTest_execA2;
import yuyu.common.hozen.khcommon.EditHrhnKanryoTuutiTest_editTBL;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdateTest_exec;
import yuyu.common.hozen.khcommon.EditMinyuuTuutiTest_editTBL;
import yuyu.common.hozen.khcommon.EditSeikyuusyoTblTest_editBean;
import yuyu.common.hozen.khcommon.EditTtdkKanryouTblTest_editTBL;
import yuyu.common.hozen.khcommon.EditTtdkKanryouTblTest_editTBL1;
import yuyu.common.hozen.khcommon.EditTtdkKanryouTblTest_editTBL2;
import yuyu.common.hozen.khcommon.KhCheckBankMasterTest_checkBankMaster;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoTest_exec;
import yuyu.common.siharai.chksk.ChkSubSksInfoTest_exec;
import yuyu.common.siharai.sicommon.SiEditFbTest_exec;
import yuyu.common.siharai.sicommon.SiSetUiBeanTest_setSk;
import yuyu.common.sinkeiyaku.moschk.CheckTblKouzaJyouhouTest_exec;
import yuyu.common.sinkeiyaku.skcommon.HenkinTest_exec;
import yuyu.def.classification.C_BankYuuksHantKbn;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_EnkashrKahiKbn;
import yuyu.def.classification.C_GaikashrKahiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kokunaikwskameihyj;

/**
 * {@link BzGetBankData}のモッククラスです。<br />
 */
public class BzGetBankDataMock extends BzGetBankData {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    @Override
    public BzGetBankDataBean exec(String pBankCd, String pSitenCd, BizDate pKijyunYmd) {

        if (caller == EditSeikyuusyoTblTest_editBean.class && TESTPATTERN1.equals(SYORIPTN)) {

            BzGetBankDataBean getBankDataBean = new BzGetBankDataBean();

            getBankDataBean.setBankNmKj("銀行名テスト");

            getBankDataBean.setSitenNmKj("支店名テスト");

            return getBankDataBean;
        }

        else if (caller == SetHaraikomiInfoTest_exec.class) {

            if (caller == SetHaraikomiInfoTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
                BzGetBankDataBean getBankDataBean = new BzGetBankDataBean();

                getBankDataBean.setBankNmKj("");
                getBankDataBean.setSitenNmKj("");

                return getBankDataBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetBankDataBean getBankDataBean = new BzGetBankDataBean();

                getBankDataBean.setBankNmKj("ゆうちょ銀行");
                getBankDataBean.setSitenNmKj("東京支店");

                return getBankDataBean;
            }
        }

        else if (caller == SiEditFbTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            super.exec(pBankCd, pSitenCd, pKijyunYmd);
            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
            bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
            return bzGetBankDataBean;
        }
        else if (caller == SiEditFbTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            super.exec(pBankCd, pSitenCd, pKijyunYmd);
            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
            bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
            bzGetBankDataBean.setBankNmEj("BBS");
            bzGetBankDataBean.setSitenNmEj("BBQ");
            return bzGetBankDataBean;
        }
        else if (caller == ChkSubSksInfoTest_exec.class) {
            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.NG);
                bzGetBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.HUKA);
                bzGetBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.HUKA);
                return bzGetBankDataBean;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.OK);
                bzGetBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.KA);
                bzGetBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.HUKA);
                return bzGetBankDataBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.OK);
                bzGetBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.HUKA);
                bzGetBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.KA);
                return bzGetBankDataBean;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.OK);
                bzGetBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.HUKA);
                bzGetBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.HUKA);
                return bzGetBankDataBean;
            }
        }
        else if (caller == SiSetUiBeanTest_setSk.class) {
            super.exec(pBankCd, pSitenCd, pKijyunYmd);
            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankNmKj("EEE");
                bzGetBankDataBean.setSitenNmKj("FFF");
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
                bzGetBankDataBean.setBankNmKj("EEE");
                bzGetBankDataBean.setSitenNmKj("FFF");
            }
            return bzGetBankDataBean;
        }
        if (caller == HenkinTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
            bzGetBankDataBean.setBankNmEj("bank");
            bzGetBankDataBean.setSitenNmEj("siten");
            bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
            return bzGetBankDataBean;
        }
        if (caller == HenkinTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
            bzGetBankDataBean.setBankNmEj("bank");
            bzGetBankDataBean.setSitenNmEj("siten");
            bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
            return bzGetBankDataBean;
        }
        else if (caller == BzFbSoukinFileSksTest_creadFBsoukinfwairu.class) {

            BzGetBankDataBean getBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
            getBankDataBean.setBankCd(pBankCd);
            getBankDataBean.setSitenCd(pSitenCd);
            getBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.HANTEIHUKA);
            getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
            getBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.KA);
            getBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.HUKA);

            if ("1002".equals(pBankCd)) {
                getBankDataBean.setBankNmKn("ギンコウメイギンコウメイ１");

                getBankDataBean.setSitenNmKn("シテンメイシテンメイシテンメ１");

                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);

                getBankDataBean.setKokunaikwskameihyj(C_Kokunaikwskameihyj.KAMEI);
            }
            else if ("1003".equals(pBankCd)) {
                getBankDataBean.setBankNmKn("ギンコウメイギンコウメイ２");

                getBankDataBean.setSitenNmKn("シテンメイシテンメイシテンメ２");

                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);

                getBankDataBean.setKokunaikwskameihyj(C_Kokunaikwskameihyj.MIKAMEI);
            }
            else if ("1004".equals(pBankCd)) {
                getBankDataBean.setBankNmKn("ギンコウメイギンコウメイ３");

                getBankDataBean.setSitenNmKn("シテンメイシテンメイシテンメ３");

                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);

                getBankDataBean.setKokunaikwskameihyj(C_Kokunaikwskameihyj.KAMEI);
            }
            else if ("1005".equals(pBankCd)) {
                getBankDataBean.setBankNmKn("ギンコウメイギンコウメイ４");

                getBankDataBean.setSitenNmKn("シテンメイシテンメイシテンメ４");

                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);

                getBankDataBean.setKokunaikwskameihyj(C_Kokunaikwskameihyj.KAMEI);
            }
            if (TESTPATTERN1.equals(SYORIPTN)) {
                getBankDataBean.setBankNmKn("ギンコウメイギンコウメイ１");

                getBankDataBean.setSitenNmKn("シテンメイシテンメイシテンメ１");

                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);

                getBankDataBean.setKokunaikwskameihyj(C_Kokunaikwskameihyj.KAMEI);
            }
            return getBankDataBean;
        }
        else if (caller == CheckTblKouzaJyouhouTest_exec.class) {

            BzGetBankDataBean getBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
            if (TESTPATTERN1.equals(SYORIPTN)) {
                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
                getBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.HANTEIHUKA);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                getBankDataBean.setBankCd("0001");
                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                getBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.HANTEIHUKA);
                getBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.KA);
                getBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.HUKA);
                getBankDataBean.setSitenCd("001");
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                getBankDataBean.setBankCd("9900");
                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                getBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.HANTEIHUKA);
                getBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.HUKA);
                getBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.HUKA);
                getBankDataBean.setReportSitenNm("通帳記号　１０１２０");
                getBankDataBean.setSitenCd("018");
            }
        }
        else if (caller == EditTtdkKanryouTblTest_editTBL.class || caller == EditTtdkKanryouTblTest_editTBL1.class ||
            caller == EditTtdkKanryouTblTest_editTBL2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetBankDataBean getBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);

                return getBankDataBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetBankDataBean getBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                getBankDataBean.setBankNmKj("銀漢０１");
                getBankDataBean.setReportSitenNm("支漢０１");

                return getBankDataBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BzGetBankDataBean getBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                getBankDataBean.setBankNmKj("銀漢０１");
                getBankDataBean.setSitenNmKj("支漢０１");

                return getBankDataBean;
            }
            else {
                return super.exec(pBankCd, pSitenCd, pKijyunYmd);
            }
        }
        else if (caller == KhCheckBankMasterTest_checkBankMaster.class) {

            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);

            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
                return bzGetBankDataBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.NG);
                return bzGetBankDataBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.OK);
                bzGetBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.HUKA);
                return bzGetBankDataBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.OK);
                bzGetBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.KA);
                bzGetBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.HUKA);
                return bzGetBankDataBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.OK);
                bzGetBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.HUKA);
                bzGetBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.KA);
                bzGetBankDataBean.setBankNmKj("銀行名テスト");
                bzGetBankDataBean.setSitenNmKj("支店名テスト");
                return bzGetBankDataBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.OK);
                bzGetBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.KA);
                bzGetBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.HUKA);
                bzGetBankDataBean.setBankNmKj("銀行名テスト1");
                bzGetBankDataBean.setSitenNmKj("支店名テスト1");
                return bzGetBankDataBean;
            }
        }
        else if (caller == EditKaiyakuTblUpdateTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
                bzGetBankDataBean.setBankNmEj("BANKA");
                bzGetBankDataBean.setSitenNmEj("BANKB");
                return bzGetBankDataBean;
            }
        }
        else if (caller == DwGetSoukinyouKouzaInfoTest_execPostForm.class) {
            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
                return bzGetBankDataBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankNmKj("みずほ銀行");
                bzGetBankDataBean.setSitenNmKj("東京支店");
                return bzGetBankDataBean;
            }
        }
        else if (caller == CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class) {
            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class) ;

            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
                return bzGetBankDataBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                return bzGetBankDataBean;
            }
        }

        else if (caller == DwGetHozenHokenryoHurikaeKouzaInfoTest_execPostForm.class) {
            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class) ;
            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
                return bzGetBankDataBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankNmKj("三井住友銀行");
                bzGetBankDataBean.setSitenNmKj("東京中央支店");
                return bzGetBankDataBean;
            }
        }
        else if (CheckKzhuriKouzaTest_execA1.class == caller && SYORIPTN.equals(TESTPATTERN1)) {

            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);

            bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
            bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.NG);
            bzGetBankDataBean.setBankNmKj("みずほ銀行");
            bzGetBankDataBean.setSitenNmKj("東京支店");
            bzGetBankDataBean.setYohuriKahiKbn(C_KahiKbn.HUKA);

            return bzGetBankDataBean;
        }
        else if (CheckKzhuriKouzaTest_execA1.class == caller && SYORIPTN.equals(TESTPATTERN2)) {

            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);

            bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
            bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.OK);
            bzGetBankDataBean.setBankNmKj("みずほ銀行");
            bzGetBankDataBean.setSitenNmKj("東京支店");
            bzGetBankDataBean.setYohuriKahiKbn(C_KahiKbn.KA);

            return bzGetBankDataBean;
        } else if (CheckKzhuriKouzaTest_execA2.class == caller) {

            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);

            if (SYORIPTN.equals(TESTPATTERN1)) {

                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.NG);
                bzGetBankDataBean.setBankNmKj("みずほ銀行");
                bzGetBankDataBean.setSitenNmKj("東京支店");
                bzGetBankDataBean.setYohuriKahiKbn(C_KahiKbn.HUKA);

                return bzGetBankDataBean;
            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {

                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.NG);
                bzGetBankDataBean.setBankNmKj("みずほ銀行");
                bzGetBankDataBean.setSitenNmKj("東京支店");
                bzGetBankDataBean.setYohuriKahiKbn(C_KahiKbn.HUKA);

                return bzGetBankDataBean;
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {

                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.OK);
                bzGetBankDataBean.setBankNmKj("みずほ銀行");
                bzGetBankDataBean.setSitenNmKj("東京支店");
                bzGetBankDataBean.setYohuriKahiKbn(C_KahiKbn.HUKA);

                return bzGetBankDataBean;
            }
            else if (SYORIPTN.equals(TESTPATTERN4)) {

                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.OK);
                bzGetBankDataBean.setBankNmKj("みずほ銀行");
                bzGetBankDataBean.setSitenNmKj("東京支店");
                bzGetBankDataBean.setYohuriKahiKbn(C_KahiKbn.KA);

                return bzGetBankDataBean;
            }
        }
        else if (EditHrhnKanryoTuutiTest_editTBL.class == caller) {

            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);

            if ("1001".equals(pBankCd)) {

                bzGetBankDataBean.setBankNmKj("みずほ銀行");
                bzGetBankDataBean.setReportSitenNm("東京支店");

                return bzGetBankDataBean;
            }
        }
        else if (EditMinyuuTuutiTest_editTBL.class == caller) {

            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);

            bzGetBankDataBean.setBankNmKj("みずほ銀行");
            bzGetBankDataBean.setReportSitenNm("東京支店");

            return bzGetBankDataBean;
        }

        return super.exec(pBankCd, pSitenCd, pKijyunYmd);
    }
}
