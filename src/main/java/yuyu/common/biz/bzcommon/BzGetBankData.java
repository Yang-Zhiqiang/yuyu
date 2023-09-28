package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;

import org.slf4j.Logger;

import yuyu.def.biz.detacher.BM_GinkouDetacher;
import yuyu.def.biz.detacher.BM_KinyuuKikanHuhoyofuriInfoDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BankYuuksHantKbn;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_EnkashrKahiKbn;
import yuyu.def.classification.C_GaikashrKahiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kokunaikwskameihyj;
import yuyu.def.classification.C_KyouteiSyouinKbn;
import yuyu.def.classification.C_TrhkginkousitenKbn;
import yuyu.def.db.entity.BM_Ginkou;
import yuyu.def.db.entity.BM_KinyuuKikanHuhoyofuriInfo;

/**
 * 業務共通 共通 銀行情報取得
 */
public class BzGetBankData {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public BzGetBankData() {
        super();
    }

    @SuppressWarnings("null")
    public BzGetBankDataBean exec(String pBankCd, String pSitenCd, BizDate pKijyunYmd) {

        logger.debug("▽ 銀行情報取得 開始");

        BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);

        if (BizUtil.isBlank(pBankCd)) {

            bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
            bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.HANTEIHUKA);

            logger.debug("△ 銀行情報取得 終了");

            return bzGetBankDataBean;
        }
        if (BizUtil.isBlank(pSitenCd)) {

            bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
            bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.HANTEIHUKA);

            logger.debug("△ 銀行情報取得 終了");

            return bzGetBankDataBean;
        }
        String hrkmSitencd = "";
        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankCd)) {

            ConvertYuutyoSitencd convertYuutyoSitencd = SWAKInjector.getInstance(ConvertYuutyoSitencd.class);

            hrkmSitencd = convertYuutyoSitencd.exec(pSitenCd);
        }
        else {
            hrkmSitencd = pSitenCd;
        }
        BM_Ginkou ginkou = bizDomManager.getGinkou(pBankCd, hrkmSitencd);

        ginkou = BM_GinkouDetacher.detachGinkoutouched(ginkou);

        if (ginkou == null) {

            bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);
            bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.HANTEIHUKA);

            logger.debug("△ 銀行情報取得 終了");

            return bzGetBankDataBean;

        }

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankCd)) {

            String zenSitenCd = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, pSitenCd);

            bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
            bzGetBankDataBean.setBankCd(ginkou.getBankcd());
            bzGetBankDataBean.setSitenCd(ginkou.getSitencd());
            bzGetBankDataBean.setKousinYmd(ginkou.getKousinymd());
            bzGetBankDataBean.setSinsetuYmd(ginkou.getSinsetuymd());
            bzGetBankDataBean.setHaisiYmd(ginkou.getHaisiymd());
            bzGetBankDataBean.setBankNmKn(ginkou.getBanknmkn());
            bzGetBankDataBean.setSitenNmKn(ginkou.getSitennmkn());
            bzGetBankDataBean.setBankNmKj(ginkou.getBanknmkj());
            bzGetBankDataBean.setSitenNmKj("１".concat(zenSitenCd).concat("０"));
            bzGetBankDataBean.setBankNmEj(ginkou.getBanknmej());
            bzGetBankDataBean.setSitenNmEj(ginkou.getSitennmej());
            bzGetBankDataBean.setKokunaikwskameihyj(ginkou.getKokunaikwskameihyj());
            bzGetBankDataBean.setHrkmKanouihyj(ginkou.getHrkmKanouihyj());
        }


        BM_KinyuuKikanHuhoyofuriInfo kinyuuKikanHuhoyofuriInfo = null;

        if (!IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankCd)) {
            kinyuuKikanHuhoyofuriInfo = BM_KinyuuKikanHuhoyofuriInfoDetacher.
                    detachKinyuuKikanHuhoyofuriInfotouched(bizDomManager.getKinyuuKikanHuhoyofuriInfo(pBankCd));

            if (kinyuuKikanHuhoyofuriInfo == null) {

                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankCd(ginkou.getBankcd());
                bzGetBankDataBean.setSitenCd(ginkou.getSitencd());
                bzGetBankDataBean.setKousinYmd(ginkou.getKousinymd());
                bzGetBankDataBean.setSinsetuYmd(ginkou.getSinsetuymd());
                bzGetBankDataBean.setHaisiYmd(ginkou.getHaisiymd());
                bzGetBankDataBean.setBankNmKn(ginkou.getBanknmkn());
                bzGetBankDataBean.setSitenNmKn(ginkou.getSitennmkn());
                bzGetBankDataBean.setBankNmKj(ginkou.getBanknmkj());
                bzGetBankDataBean.setSitenNmKj(ginkou.getSitennmkj());
                bzGetBankDataBean.setBankNmEj(ginkou.getBanknmej());
                bzGetBankDataBean.setSitenNmEj(ginkou.getSitennmej());
                bzGetBankDataBean.setKokunaikwskameihyj(ginkou.getKokunaikwskameihyj());
                bzGetBankDataBean.setHrkmKanouihyj(ginkou.getHrkmKanouihyj());
            }
            else {
                bzGetBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
                bzGetBankDataBean.setBankCd(ginkou.getBankcd());
                bzGetBankDataBean.setSitenCd(ginkou.getSitencd());
                bzGetBankDataBean.setKousinYmd(ginkou.getKousinymd());
                bzGetBankDataBean.setSinsetuYmd(ginkou.getSinsetuymd());
                bzGetBankDataBean.setHaisiYmd(ginkou.getHaisiymd());
                bzGetBankDataBean.setBankNmKn(ginkou.getBanknmkn());
                bzGetBankDataBean.setSitenNmKn(ginkou.getSitennmkn());
                bzGetBankDataBean.setBankNmKj(ginkou.getBanknmkj());
                bzGetBankDataBean.setSitenNmKj(ginkou.getSitennmkj());
                bzGetBankDataBean.setBankNmEj(ginkou.getBanknmej());
                bzGetBankDataBean.setSitenNmEj(ginkou.getSitennmej());
                bzGetBankDataBean.setCssKyouteiKaisiYmd(kinyuuKikanHuhoyofuriInfo.getCsskyouteikaisiymd());
                bzGetBankDataBean.setCssKyouteiKaijyoYmd(kinyuuKikanHuhoyofuriInfo.getCsskyouteikaijyoymd());
                bzGetBankDataBean.setKokunaikwskameihyj(ginkou.getKokunaikwskameihyj());
                bzGetBankDataBean.setHrkmKanouihyj(ginkou.getHrkmKanouihyj());
                bzGetBankDataBean.setYofurikyouteikaisiYmd(kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaisiymd());
                bzGetBankDataBean.setYofurikyouteikaijyoYmd(kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaijyoymd());
                bzGetBankDataBean.setItakusyakinyuuCd(kinyuuKikanHuhoyofuriInfo.getItakusyakinyuucd());
                bzGetBankDataBean.setItakusyasitenCd(kinyuuKikanHuhoyofuriInfo.getItakusyasitencd());
                bzGetBankDataBean.setItakusyayokinKbn(kinyuuKikanHuhoyofuriInfo.getItakusyayokinkbn());
                bzGetBankDataBean.setItakusyakouzano(kinyuuKikanHuhoyofuriInfo.getItakusyakouzano());
                bzGetBankDataBean.setTsrkeisanhouKbn(kinyuuKikanHuhoyofuriInfo.getTsrkeisanhoukbn());
                bzGetBankDataBean.setKinyuutesuuryou(kinyuuKikanHuhoyofuriInfo.getKinyuutesuuryou());
                bzGetBankDataBean.setItakusyacd(kinyuuKikanHuhoyofuriInfo.getItakusyacd());
                bzGetBankDataBean.setTapekoukanKbn1(kinyuuKikanHuhoyofuriInfo.getTapekoukankbn1());
                bzGetBankDataBean.setMdsisyaCd(kinyuuKikanHuhoyofuriInfo.getMdsisyacd().substring(0, 3));
                bzGetBankDataBean.setZzkkyouteikaisiYmd(kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaisiymd());
                bzGetBankDataBean.setZzkkyouteikaijyoYmd(kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaijyoymd());
                bzGetBankDataBean.setHuhoyofuriinfokousinYmd(kinyuuKikanHuhoyofuriInfo.getHuhoyofuriinfokousinymd());
            }
        }

        String zenSitencd = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, pSitenCd);

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankCd)) {
            bzGetBankDataBean.setReportSitenNm("通帳記号　１".concat(zenSitencd).concat("０"));
        }
        else {
            bzGetBankDataBean.setReportSitenNm(ginkou.getSitennmkj());
        }
        BizDate kijyunYmd = pKijyunYmd;

        if (kijyunYmd == null) {
            bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.HANTEIHUKA);
        }
        else {
            BizDate sinsetuymd = ginkou.getSinsetuymd();

            BizDate haisiymd = ginkou.getHaisiymd();

            if (sinsetuymd == null) {
                bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.NG);

            }
            else {
                if (haisiymd == null) {
                    haisiymd = BizDate.MAX_VALID_DATE;
                }

                if (sinsetuymd.compareTo(kijyunYmd) <= 0 && haisiymd.compareTo(kijyunYmd) > 0) {
                    bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.OK);
                }
                else {
                    bzGetBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.NG);
                }

            }
        }

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankCd)) {
            if (C_Kokunaikwskameihyj.KAMEI.eq(ginkou.getKokunaikwskameihyj())) {
                bzGetBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.KA);
            }
            else {
                bzGetBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.HUKA);
            }
        }
        else {
            bzGetBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.KA);
        }


        if (!BizUtil.isBlank(ginkou.getBanknmej())
                && !BizUtil.isBlank(ginkou.getSitennmej())) {

            bzGetBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.KA);
        }
        else {
            bzGetBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.HUKA);
        }

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankCd)) {
            if (BizDateUtil.compareYmd(kijyunYmd, BizDate.valueOf("19891004")) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYmd(kijyunYmd, BizDate.valueOf("19891004")) == BizDateUtil.COMPARE_EQUAL) {

                bzGetBankDataBean.setYohuriKahiKbn(C_KahiKbn.KA);
            }
            else {
                bzGetBankDataBean.setYohuriKahiKbn(C_KahiKbn.HUKA);
            }
            bzGetBankDataBean.setYohuriKyouteiSyouinKbn(C_KyouteiSyouinKbn.KYOUTEI);
            bzGetBankDataBean.setYohuriKyouteiKouryokuhasseiYmd(BizDate.valueOf("19891004"));
            bzGetBankDataBean.setTrhkGinkousitenKbn(C_TrhkginkousitenKbn.SITEN);
            bzGetBankDataBean.setCssKahiKbn(C_KahiKbn.HUKA);
            bzGetBankDataBean.setCssKyouteiSyouinKbn(C_KyouteiSyouinKbn.MIKYOUTEI);
            bzGetBankDataBean.setZzkKahiKbn(C_KahiKbn.HUKA);
            bzGetBankDataBean.setZzkKyouteiSyouinKbn(C_KyouteiSyouinKbn.MIKYOUTEI);
        }
        else if (kinyuuKikanHuhoyofuriInfo != null) {
            BizDate yofurikyouteikaisiymd = null;
            BizDate yofurikyouteikaijyoymd = null;
            BizDate csskyouteikaisiymd = null;
            BizDate csskyouteikaijyoymd = null;
            BizDate zzkkyouteikaisiymd = null;
            BizDate zzkkyouteikaijyoymd = null;

            if (kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaisiymd() == null) {
                yofurikyouteikaisiymd = null;
                yofurikyouteikaijyoymd = null;
            }
            else if (ginkou.getHaisiymd() != null && kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaijyoymd() != null) {

                if (BizDateUtil.compareYmd(ginkou.getSinsetuymd(), kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaisiymd())
                        == BizDateUtil.COMPARE_GREATER) {
                    yofurikyouteikaisiymd = ginkou.getSinsetuymd();
                }
                else {
                    yofurikyouteikaisiymd = kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaisiymd();
                }

                if (BizDateUtil.compareYmd(ginkou.getHaisiymd(), kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaijyoymd())
                        == BizDateUtil.COMPARE_GREATER) {
                    yofurikyouteikaijyoymd = kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaijyoymd();
                }
                else {
                    yofurikyouteikaijyoymd = ginkou.getHaisiymd();
                }
            }
            else if (ginkou.getHaisiymd() == null) {

                if (BizDateUtil.compareYmd(ginkou.getSinsetuymd(), kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaisiymd())
                        == BizDateUtil.COMPARE_GREATER) {
                    yofurikyouteikaisiymd = ginkou.getSinsetuymd();
                }
                else {
                    yofurikyouteikaisiymd = kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaisiymd();
                }
                yofurikyouteikaijyoymd = kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaijyoymd();
            }
            else if (kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaijyoymd() == null) {
                if (BizDateUtil.compareYmd(ginkou.getSinsetuymd(), kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaisiymd())
                        == BizDateUtil.COMPARE_GREATER) {
                    yofurikyouteikaisiymd = ginkou.getSinsetuymd();
                }
                else {
                    yofurikyouteikaisiymd = kinyuuKikanHuhoyofuriInfo.getYofurikyouteikaisiymd();
                }
                yofurikyouteikaijyoymd = ginkou.getHaisiymd();
            }

            if (yofurikyouteikaisiymd == null) {

                bzGetBankDataBean.setYohuriKyouteiSyouinKbn(C_KyouteiSyouinKbn.MIKYOUTEI);
                bzGetBankDataBean.setYohuriKyouteiKouryokuhasseiYmd(null);
            }
            else if (yofurikyouteikaijyoymd == null) {

                bzGetBankDataBean.setYohuriKyouteiSyouinKbn(C_KyouteiSyouinKbn.KYOUTEI);
                bzGetBankDataBean.setYohuriKyouteiKouryokuhasseiYmd(yofurikyouteikaisiymd);
            }
            else {
                bzGetBankDataBean.setYohuriKyouteiSyouinKbn(C_KyouteiSyouinKbn.KAIJYO);
                bzGetBankDataBean.setYohuriKyouteiKouryokuhasseiYmd(yofurikyouteikaijyoymd);
            }

            if (C_KyouteiSyouinKbn.KYOUTEI.eq(bzGetBankDataBean.getYohuriKyouteiSyouinKbn()) &&
                    (BizDateUtil.compareYmd(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),
                            kijyunYmd) == BizDateUtil.COMPARE_LESSER ||
                            BizDateUtil.compareYmd(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),
                                    kijyunYmd) == BizDateUtil.COMPARE_EQUAL)) {

                bzGetBankDataBean.setYohuriKahiKbn(C_KahiKbn.KA);
            }
            else if (C_KyouteiSyouinKbn.KAIJYO.eq(bzGetBankDataBean.getYohuriKyouteiSyouinKbn()) &&
                    (BizDateUtil.compareYmd(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),
                            kijyunYmd) == BizDateUtil.COMPARE_GREATER)) {

                bzGetBankDataBean.setYohuriKahiKbn(C_KahiKbn.KA);
            }
            else {

                bzGetBankDataBean.setYohuriKahiKbn(C_KahiKbn.HUKA);
            }

            if (kinyuuKikanHuhoyofuriInfo.getCsskyouteikaisiymd() == null) {
                csskyouteikaisiymd = null;
                csskyouteikaijyoymd = null;
            }
            else if (ginkou.getHaisiymd() != null && kinyuuKikanHuhoyofuriInfo.getCsskyouteikaijyoymd() != null) {

                if (BizDateUtil.compareYmd(ginkou.getSinsetuymd(), kinyuuKikanHuhoyofuriInfo.getCsskyouteikaisiymd())
                        == BizDateUtil.COMPARE_GREATER) {

                    csskyouteikaisiymd = ginkou.getSinsetuymd();
                }
                else {
                    csskyouteikaisiymd = kinyuuKikanHuhoyofuriInfo.getCsskyouteikaisiymd();
                }

                if (BizDateUtil.compareYmd(ginkou.getHaisiymd(), kinyuuKikanHuhoyofuriInfo.getCsskyouteikaijyoymd())
                        == BizDateUtil.COMPARE_GREATER) {

                    csskyouteikaijyoymd = kinyuuKikanHuhoyofuriInfo.getCsskyouteikaijyoymd();
                }
                else {
                    csskyouteikaijyoymd = ginkou.getHaisiymd();
                }
            }
            else if (ginkou.getHaisiymd() == null) {
                if (BizDateUtil.compareYmd(ginkou.getSinsetuymd(), kinyuuKikanHuhoyofuriInfo.getCsskyouteikaisiymd())
                        == BizDateUtil.COMPARE_GREATER) {

                    csskyouteikaisiymd = ginkou.getSinsetuymd();
                }
                else {
                    csskyouteikaisiymd = kinyuuKikanHuhoyofuriInfo.getCsskyouteikaisiymd();
                }

                csskyouteikaijyoymd = kinyuuKikanHuhoyofuriInfo.getCsskyouteikaijyoymd();
            }
            else if (kinyuuKikanHuhoyofuriInfo.getCsskyouteikaijyoymd() == null) {
                if (BizDateUtil.compareYmd(ginkou.getSinsetuymd(), kinyuuKikanHuhoyofuriInfo.getCsskyouteikaisiymd())
                        == BizDateUtil.COMPARE_GREATER) {

                    csskyouteikaisiymd = ginkou.getSinsetuymd();
                }
                else {
                    csskyouteikaisiymd = kinyuuKikanHuhoyofuriInfo.getCsskyouteikaisiymd();
                }

                csskyouteikaijyoymd = ginkou.getHaisiymd();
            }

            if (csskyouteikaisiymd == null) {
                bzGetBankDataBean.setCssKyouteiSyouinKbn(C_KyouteiSyouinKbn.MIKYOUTEI);
                bzGetBankDataBean.setCssKyouteiKouryokuhasseiYmd(null);
            }
            else if (csskyouteikaijyoymd == null) {
                bzGetBankDataBean.setCssKyouteiSyouinKbn(C_KyouteiSyouinKbn.KYOUTEI);
                bzGetBankDataBean.setCssKyouteiKouryokuhasseiYmd(csskyouteikaisiymd);
            }
            else {
                bzGetBankDataBean.setCssKyouteiSyouinKbn(C_KyouteiSyouinKbn.KAIJYO);
                bzGetBankDataBean.setCssKyouteiKouryokuhasseiYmd(csskyouteikaijyoymd);
            }

            if (C_KyouteiSyouinKbn.KYOUTEI.eq(bzGetBankDataBean.getCssKyouteiSyouinKbn()) &&
                    (BizDateUtil.compareYmd(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(),
                            kijyunYmd) == BizDateUtil.COMPARE_LESSER ||
                            BizDateUtil.compareYmd(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(),
                                    kijyunYmd) == BizDateUtil.COMPARE_EQUAL)) {

                bzGetBankDataBean.setCssKahiKbn(C_KahiKbn.KA);
            }
            else if (C_KyouteiSyouinKbn.KAIJYO.eq(bzGetBankDataBean.getCssKyouteiSyouinKbn()) &&
                    (BizDateUtil.compareYmd(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(),
                            kijyunYmd) == BizDateUtil.COMPARE_GREATER)) {

                bzGetBankDataBean.setCssKahiKbn(C_KahiKbn.KA);
            }
            else {
                bzGetBankDataBean.setCssKahiKbn(C_KahiKbn.HUKA);
            }

            if (kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaisiymd() == null) {
                zzkkyouteikaisiymd = null;
                zzkkyouteikaijyoymd = null;
            }
            else if (ginkou.getHaisiymd() != null && kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaijyoymd() != null) {
                if (BizDateUtil.compareYmd(ginkou.getSinsetuymd(), kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaisiymd())
                        == BizDateUtil.COMPARE_GREATER) {
                    zzkkyouteikaisiymd = ginkou.getSinsetuymd();
                }
                else {
                    zzkkyouteikaisiymd = kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaisiymd();
                }

                if (BizDateUtil.compareYmd(ginkou.getHaisiymd(), kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaijyoymd())
                        == BizDateUtil.COMPARE_GREATER) {

                    zzkkyouteikaijyoymd = kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaijyoymd();
                }
                else {
                    zzkkyouteikaijyoymd = ginkou.getHaisiymd();
                }
            }
            else if (ginkou.getHaisiymd() == null) {
                if (BizDateUtil.compareYmd(ginkou.getSinsetuymd(), kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaisiymd())
                        == BizDateUtil.COMPARE_GREATER) {
                    zzkkyouteikaisiymd = ginkou.getSinsetuymd();
                }
                else {
                    zzkkyouteikaisiymd = kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaisiymd();
                }

                zzkkyouteikaijyoymd = kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaijyoymd();

            }
            else if (kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaijyoymd() == null) {

                if (BizDateUtil.compareYmd(ginkou.getSinsetuymd(), kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaisiymd())
                        == BizDateUtil.COMPARE_GREATER) {
                    zzkkyouteikaisiymd = ginkou.getSinsetuymd();
                }
                else {
                    zzkkyouteikaisiymd = kinyuuKikanHuhoyofuriInfo.getZzkkyouteikaisiymd();
                }

                zzkkyouteikaijyoymd = ginkou.getHaisiymd();
            }

            if (zzkkyouteikaisiymd == null) {

                bzGetBankDataBean.setZzkKyouteiSyouinKbn(C_KyouteiSyouinKbn.MIKYOUTEI);
                bzGetBankDataBean.setZzkKyouteiKouryokuhasseiYmd(null);

            }
            else if (zzkkyouteikaijyoymd == null) {

                bzGetBankDataBean.setZzkKyouteiSyouinKbn(C_KyouteiSyouinKbn.KYOUTEI);
                bzGetBankDataBean.setZzkKyouteiKouryokuhasseiYmd(zzkkyouteikaisiymd);
            }
            else {
                bzGetBankDataBean.setZzkKyouteiSyouinKbn(C_KyouteiSyouinKbn.KAIJYO);
                bzGetBankDataBean.setZzkKyouteiKouryokuhasseiYmd(zzkkyouteikaijyoymd);
            }
            if (C_KyouteiSyouinKbn.KYOUTEI.eq(bzGetBankDataBean.getZzkKyouteiSyouinKbn()) &&
                    (BizDateUtil.compareYmd(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(),
                            kijyunYmd) == BizDateUtil.COMPARE_LESSER ||
                            BizDateUtil.compareYmd(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(),
                                    kijyunYmd) == BizDateUtil.COMPARE_EQUAL)) {

                bzGetBankDataBean.setZzkKahiKbn(C_KahiKbn.KA);
            }
            else if (C_KyouteiSyouinKbn.KAIJYO.eq(bzGetBankDataBean.getZzkKyouteiSyouinKbn()) &&
                    (BizDateUtil.compareYmd(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(),
                            kijyunYmd) == BizDateUtil.COMPARE_GREATER)) {

                bzGetBankDataBean.setZzkKahiKbn(C_KahiKbn.KA);
            }
            else {
                bzGetBankDataBean.setZzkKahiKbn(C_KahiKbn.HUKA);
            }

            if (BizUtil.isBlank(kinyuuKikanHuhoyofuriInfo.getItakusyasitencd())) {

                bzGetBankDataBean.setTrhkGinkousitenKbn(C_TrhkginkousitenKbn.GINKOU);
            }
            else {
                bzGetBankDataBean.setTrhkGinkousitenKbn(C_TrhkginkousitenKbn.SITEN);
            }
        }
        logger.debug("△ 銀行情報取得 終了");

        return bzGetBankDataBean;
    }

    public BzGetBankDataBean exec(String pBankCd, String pSitenCd) {

        BizDate pKijyunYmd = null;

        BzGetBankDataBean bzGetBankDataBean = exec(pBankCd, pSitenCd, pKijyunYmd);

        return bzGetBankDataBean;

    }

}
