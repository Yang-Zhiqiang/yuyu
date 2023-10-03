package yuyu.batch.suuri.srsuuritoukei.srrisanomituujyouhaitousyoyougaku;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.HtkinSikinIdouDataBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.haitou.KeisanD;
import yuyu.common.hozen.haitou.KeisanDBean;
import yuyu.common.hozen.haitou.KeisanDGanrikin;
import yuyu.common.hozen.haitou.KeisanDInfoBean;
import yuyu.common.hozen.haitou.SetDNnd;
import yuyu.common.hozen.haitou.SetDNnd.DRateBean;
import yuyu.common.hozen.khcommon.KeisanGaikaP;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.RisanomiTjHitsyyugkParam;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrDRateSyutokuInfoBeanForDSyoyou;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfoBean;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTokuyakuInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTokuyakuInfoBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.srcommon.SrSuuriKeisanVHeijyun;
import yuyu.common.suuri.srcommon.SrTmttknBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GetTaisyouSonotaTokuyakuKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SonotaTkTokuteiJitenKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriHaraikataKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_RisanomiTuujyuHitusyyugk;
import yuyu.def.suuri.configuration.YuyuSuuriConfig;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 利差のみ通常配当所要額情報項目編集
 */
public class SrRisanomiTuujyouHaitousyoyougakuItemEditor {

    private static final String KEIYAKUOUBIKBNMAE = "2";

    private static final String KEIYAKUOUBIKBNGO = "1";

    private static final String KEIYAKUOUBIKBNNENDOKSN = "0";

    private static final String NENMEOUTOUBIKBN = "1";

    private static final BizCurrency ZERO = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private static final String TMTTKN_SIBOUS = "積立金計算：死亡Ｓ";

    private static final String SIBOUS = "死亡Ｓ";

    private static final String NKSJITIRTTUMITATEKIN = "年金開始時定率部分積立金";

    private static final String SJKKKTUSIRRT = "市場価格調整用利率";

    private static final String KYKJIYOTEIRIRITU = "契約時予定利率";

    private static final String SUURIHIJYNPTUMITATEKIN = "数理平準払用保険料積立金";

    private static final String TANGETUGKNYKNKGKKSN_RIRONBASE = "単月外貨入金額計算（理論ベース）";

    private static final String HATOUSYOYOUGK = "配当所要額";

    @Inject
    private BatchLogger batchLogger;

    private boolean errorFlag;

    private BizNumber kykjiYoteiRiritu;

    private BizCurrency ptmttkngkNkgns;

    private BizCurrency ptmttkngkRrnBase;

    private BizCurrency kiharaikomiPRrnBase;

    private BizCurrency pRrnBase;

    private BizNumber yoteiRirituRrnBase;

    private C_Hrkkeiro hrkkeiro;

    private C_Hrkkaisuu hrkkaisuu;

    private C_Segcd segCd1;

    public SrRisanomiTuujyouHaitousyoyougakuItemEditor() {

        errorFlag = false;
        kykjiYoteiRiritu = null;
        ptmttkngkNkgns = null;
        ptmttkngkRrnBase = null;
        kiharaikomiPRrnBase = null;
        pRrnBase = null;
        yoteiRirituRrnBase = null;
        hrkkeiro = null;
        hrkkaisuu = null;
        segCd1 = null;
    }

    public boolean editKoumoku(
        SrRisanomiTuujyouHaitousyoyougakuBatchParam pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
        SV_RisanomiTuujyuHitusyyugk pSvRisanomiTuujyuHitusyyugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        RisanomiTjHitsyyugkParam pRisanomiTjHitsyyugkParam,
        int pSyohinHanteiKbn,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn,
        List<SV_KiykSyuhnData> pKiykSyuhnDataList,
        List<IT_HokenryouTmttkn> pHokenryouTmttknList,
        IT_KhHaitouKanri pZenKhHaitouKanri,
        IT_KhHaitouKanri pTouKhHaitouKanri,
        HtkinSikinIdouDataBean pHtkinSikinIdouDataBean) {

        BizDate haitoushrKijyunYmd = null;
        BizDate zennendoutoubi = null;
        BizDate tounendoutoubi = null;
        BizDate keisanDnendoZennendoutoubi = null;
        BizDate keisanDnendoutoubi = null;
        BizDate keisanDnendYokunendoutoubi = null;
        String keiyakuoutoubiKbn = "";
        BizDateY haitoushrKijyunYmdJigyou = null;
        String gonenmeoutoubikbn = "";

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            haitoushrKijyunYmd = pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd();
        }
        else {

            haitoushrKijyunYmd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
        }

        if (haitoushrKijyunYmd.getMonth() >= SrCommonConstants.MONTH_APRIL) {

            zennendoutoubi = BizDate.valueOf(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getTounendo().addYears(-1),
                haitoushrKijyunYmd.getBizDateMD()).getRekijyou();
            tounendoutoubi = BizDate.valueOf(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getTounendo(),
                haitoushrKijyunYmd.getBizDateMD()).getRekijyou();
            keisanDnendoZennendoutoubi = BizDate.valueOf(
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendo().addYears(-1),
                haitoushrKijyunYmd.getBizDateMD()).getRekijyou();
            keisanDnendoutoubi = BizDate.valueOf(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendo(),
                haitoushrKijyunYmd.getBizDateMD()).getRekijyou();
            keisanDnendYokunendoutoubi = BizDate.valueOf(
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendo().addYears(1),
                haitoushrKijyunYmd.getBizDateMD()).getRekijyou();
        }
        else {

            zennendoutoubi = BizDate.valueOf(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getTounendo(),
                haitoushrKijyunYmd.getBizDateMD()).getRekijyou();
            tounendoutoubi = BizDate.valueOf(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getTounendo().addYears(1),
                haitoushrKijyunYmd.getBizDateMD()).getRekijyou();
            keisanDnendoZennendoutoubi = BizDate.valueOf(
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendo(), haitoushrKijyunYmd.getBizDateMD())
                .getRekijyou();
            keisanDnendoutoubi = BizDate.valueOf(
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendo().addYears(1),
                haitoushrKijyunYmd.getBizDateMD()).getRekijyou();
            keisanDnendYokunendoutoubi = BizDate.valueOf(
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendo().addYears(2),
                haitoushrKijyunYmd.getBizDateMD()).getRekijyou();
        }

        if (pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getMonth() == SrCommonConstants.MONTH_MARCH) {

            keiyakuoutoubiKbn = KEIYAKUOUBIKBNNENDOKSN;
        }
        else {

            if (BizDateUtil.compareYmd(tounendoutoubi, pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER
                || BizDateUtil.compareYmd(tounendoutoubi, pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_EQUAL) {

                keiyakuoutoubiKbn = KEIYAKUOUBIKBNGO;
            }
            else {
                keiyakuoutoubiKbn = KEIYAKUOUBIKBNMAE;
            }
        }

        if (haitoushrKijyunYmd.getMonth() >= SrCommonConstants.MONTH_APRIL) {

            haitoushrKijyunYmdJigyou = haitoushrKijyunYmd.getBizDateY();
        }
        else {

            haitoushrKijyunYmdJigyou = haitoushrKijyunYmd.getBizDateY().addYears(-1);
        }

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null
            || pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendo().compareTo(haitoushrKijyunYmdJigyou) > 0) {

            if ((pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendo().getYear() - haitoushrKijyunYmdJigyou.getYear()) % 5 == 0) {

                gonenmeoutoubikbn = NENMEOUTOUBIKBN;
            }
        }

        kykjiYoteiRiritu = BizNumber.ZERO;
        ptmttkngkNkgns = BizCurrency.valueOf(0);
        ptmttkngkRrnBase = BizCurrency.valueOf(0);
        kiharaikomiPRrnBase = BizCurrency.valueOf(0);
        pRrnBase = BizCurrency.valueOf(0);
        yoteiRirituRrnBase = BizNumber.ZERO;
        hrkkeiro = C_Hrkkeiro.BLNK;
        hrkkaisuu = C_Hrkkaisuu.BLNK;

        if (!C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            getHijynKyoutuuInfo(pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
                pSvRisanomiTuujyuHitusyyugk,
                pTkJitenKeiyakuSyouhinKijyunBean,
                pKiykSyuhnDataList,
                pHokenryouTmttknList,
                pSyohinHanteiKbn);
        }

        SrRisanomiTuujyouHaitousyoyougakuBean srRisanomiTuujyouHaitousyoyougakuBean = calcSrRisanomiHaitouSyoyouGaku(
            pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
            pSvRisanomiTuujyuHitusyyugk,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pZenKhHaitouKanri,
            pTouKhHaitouKanri,
            keiyakuoutoubiKbn,
            gonenmeoutoubikbn,
            zennendoutoubi,
            tounendoutoubi,
            keisanDnendoZennendoutoubi,
            keisanDnendoutoubi,
            keisanDnendYokunendoutoubi,
            haitoushrKijyunYmdJigyou);

        if (srRisanomiTuujyouHaitousyoyougakuBean.isResultFlg() ==  SrCommonConstants.HAITOUSSYERRORKBN_HAITOUMIHANEIERROR) {

            String msg = MessageUtil.getMessage(
                MessageId.ESA1005,
                pSvRisanomiTuujyuHitusyyugk.getSyono());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);
        }
        else if (srRisanomiTuujyouHaitousyoyougakuBean.isResultFlg() ==  SrCommonConstants.HAITOUSSYERRORKBN_KYTKINOUERROR) {

            String msg = MessageUtil.getMessage(
                MessageId.ESA1001,
                HATOUSYOYOUGK,
                pSvRisanomiTuujyuHitusyyugk.getSyono());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);
        }

        editSrRisanomiTuujyouDKihonkoumoku(
            pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
            pSvRisanomiTuujyuHitusyyugk,
            pTkJitenKeiyakuSyouhinKijyunBean,
            keiyakuoutoubiKbn,
            gonenmeoutoubikbn,
            srRisanomiTuujyouHaitousyoyougakuBean,
            pRisanomiTjHitsyyugkParam,
            pSyohinHanteiKbn,
            pKhSisuurendoTmttkn);

        editSrRisanomiTuujyouDRAYkoumoku(
            pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
            pSvRisanomiTuujyuHitusyyugk,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pRisanomiTjHitsyyugkParam,
            srRisanomiTuujyouHaitousyoyougakuBean,
            pSyohinHanteiKbn,
            pKhSisuurendoTmttkn,
            pKiykSyuhnDataList);

        setHeadKoumoku(
            pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
            pRisanomiTjHitsyyugkParam);

        editHtkinSikinIdouData(
            pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
            pSvRisanomiTuujyuHitusyyugk,
            pTkJitenKeiyakuSyouhinKijyunBean,
            srRisanomiTuujyouHaitousyoyougakuBean,
            gonenmeoutoubikbn,
            pHtkinSikinIdouDataBean);

        return errorFlag;

    }

    public SrRisanomiTuujyouHaitousyoyougakuBean calcSrRisanomiHaitouSyoyouGaku(
        SrRisanomiTuujyouHaitousyoyougakuBatchParam pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
        SV_RisanomiTuujyuHitusyyugk pSvRisanomiTuujyuHitusyyugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        IT_KhHaitouKanri pZenKhHaitouKanri,
        IT_KhHaitouKanri pTouKhHaitouKanri,
        String pKeiyakuoutoubikbn,
        String pGonenmeoutoubikbn,
        BizDate pZennendoutoubi,
        BizDate pTounendoutoubi,
        BizDate pKeisanDnendoZennendoutoubi,
        BizDate pKeisanDnendoutoubi,
        BizDate pKeisanDnendYokunendoutoubi,
        BizDateY pHaitoushrKijyunYmdJigyou) {

        SrRisanomiTuujyouHaitousyoyougakuBean srRisanomiTuujyouHaitousyoyougakuBean = SWAKInjector
            .getInstance(SrRisanomiTuujyouHaitousyoyougakuBean.class);

        BizDate ninenmeKeiyakuoutoubi = BizDate.valueOf(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateY().addYears(1),
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()).getRekijyou();

        boolean haitouMihaneierror = false;

        if (BizDateUtil.compareYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd(),
            ninenmeKeiyakuoutoubi) == BizDateUtil.COMPARE_LESSER) {

            haitouMihaneierror = false;
        }
        else if (KEIYAKUOUBIKBNMAE.equals(pKeiyakuoutoubikbn)) {

            if (pZenKhHaitouKanri == null) {

                haitouMihaneierror = true;
            }
        }
        else {

            if (pTouKhHaitouKanri == null) {

                haitouMihaneierror = true;
            }
        }

        if (haitouMihaneierror) {

            initSrRisanomiTuujyouHaitousyoyougakuBeanError(
                srRisanomiTuujyouHaitousyoyougakuBean,
                SrCommonConstants.HAITOUSSYERRORKBN_HAITOUMIHANEIERROR,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            return srRisanomiTuujyouHaitousyoyougakuBean;
        }

        C_Hrkkaisuu wkHrkkaisuu = C_Hrkkaisuu.BLNK;

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            wkHrkkaisuu = pSvRisanomiTuujyuHitusyyugk.getHrkkaisuu();
        }
        else {

            wkHrkkaisuu = hrkkaisuu;
        }

        BizCurrency haitousyoyouCalcstartgk = ZERO;
        BizCurrency zennendoutoubiKariwariatedruigk = ZERO;
        BizCurrency tounendoutoubiHaitougkTounendodKasanzen = ZERO;
        BizCurrency tounendod = ZERO;
        C_Kykjyoutai kykjyoutaiHenkan = C_Kykjyoutai.BLNK;

        if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam
            .getHaitousyoyougakukeisancd())) {

            if (KEIYAKUOUBIKBNGO.equals(pKeiyakuoutoubikbn)) {

                if (BizDateUtil.compareYmd(pTounendoutoubi,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) != BizDateUtil.COMPARE_EQUAL) {

                    haitousyoyouCalcstartgk = pTouKhHaitouKanri.getKariwariatedruigk();
                }
            }
            else if (KEIYAKUOUBIKBNMAE.equals(pKeiyakuoutoubikbn)) {

                if (BizDateUtil.compareYmd(pZennendoutoubi,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_GREATER) {

                    haitousyoyouCalcstartgk = pZenKhHaitouKanri.getKariwariatedruigk();
                }
            }
        }
        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO
            .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())
            || SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO
            .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())) {

            if (KEIYAKUOUBIKBNGO.equals(pKeiyakuoutoubikbn) || KEIYAKUOUBIKBNNENDOKSN.equals(pKeiyakuoutoubikbn)) {

                if (BizDateUtil.compareYmd(pTounendoutoubi,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_GREATER) {

                    haitousyoyouCalcstartgk = pTouKhHaitouKanri.getKariwariatedruigk();
                }
            }
            else if (KEIYAKUOUBIKBNMAE.equals(pKeiyakuoutoubikbn)) {

                if ((pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getTounendo()
                    .getYear() - pHaitoushrKijyunYmdJigyou.getYear()) % 5 != 0) {

                    if (BizDateUtil.compareYmd(pZennendoutoubi,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) != BizDateUtil.COMPARE_EQUAL) {

                        zennendoutoubiKariwariatedruigk = pZenKhHaitouKanri.getKariwariatedruigk();
                    }

                    KeisanDGanrikin keisanDGanrikin = SWAKInjector.getInstance(KeisanDGanrikin.class);
                    C_ErrorKbn errorKbn = keisanDGanrikin.exec(zennendoutoubiKariwariatedruigk, pZennendoutoubi,
                        pTounendoutoubi);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        initSrRisanomiTuujyouHaitousyoyougakuBeanError(
                            srRisanomiTuujyouHaitousyoyougakuBean,
                            SrCommonConstants.HAITOUSSYERRORKBN_KYTKINOUERROR,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

                        return srRisanomiTuujyouHaitousyoyougakuBean;
                    }

                    tounendoutoubiHaitougkTounendodKasanzen = keisanDGanrikin.getDGanrikin();

                    SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);
                    KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);

                    DRateBean dRateBean = setDNnd.exec(
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                        pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getTounendo().addYears(-1),
                        pTounendoutoubi);

                    if (dRateBean == null) {

                        initSrRisanomiTuujyouHaitousyoyougakuBeanError(
                            srRisanomiTuujyouHaitousyoyougakuBean,
                            SrCommonConstants.HAITOUSSYERRORKBN_KYTKINOUERROR,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

                        return srRisanomiTuujyouHaitousyoyougakuBean;
                    }

                    kykjyoutaiHenkan= setDNnd.henkanKykjyoutai(
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                        pTounendoutoubi,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHrkkknsmnKbn());

                    KeisanDBean keisanDBean = SWAKInjector.getInstance(KeisanDBean.class);
                    SrDRateSyutokuInfoBeanForDSyoyou srDRateSyutokuInfoBeanForDSyoyou = new SrDRateSyutokuInfoBeanForDSyoyou(
                        setDNnd);

                    srDRateSyutokuInfoBeanForDSyoyou.setKoumoku(pTkJitenKeiyakuSyouhinKijyunBean,
                        wkHrkkaisuu, pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getTounendo(), kykjyoutaiHenkan);

                    keisanDBean.setDRateSyutokuInfoBean(srDRateSyutokuInfoBeanForDSyoyou);
                    keisanDBean.setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());
                    keisanDBean.setKihonS(pTkJitenKeiyakuSyouhinKijyunBean.getKihons());
                    keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);
                    keisanDBean.setHaitouKaisuuBeanList(dRateBean.getHaitouKaisuuBeanLst());

                    errorKbn = keisanD.exec(keisanDBean);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        initSrRisanomiTuujyouHaitousyoyougakuBeanError(
                            srRisanomiTuujyouHaitousyoyougakuBean,
                            SrCommonConstants.HAITOUSSYERRORKBN_KYTKINOUERROR,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

                        return srRisanomiTuujyouHaitousyoyougakuBean;
                    }

                    tounendod = keisanD.getD();

                    haitousyoyouCalcstartgk = tounendoutoubiHaitougkTounendodKasanzen.add(tounendod);
                }
            }
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

        BizDate calckijyunfromymd = null;
        BizDate calckijyuntoymd = null;
        BizCurrency tounendmtwrhrgkruikeigk = ZERO;
        BizCurrency warihurigakurisoku1 = ZERO;
        BizCurrency warihurigakurisoku2 = ZERO;
        BizDate kwsrateKjYmd = null;
        BizNumber dkeisankawaserate = BizNumber.valueOf(0);
        BizDate dkeisankawaseratetekiyouymd = BizDate.valueOf(00000000);
        BizCurrency yokunendosyoyougakuyou = ZERO;
        BizCurrency gaikayokunendosyoyougakuyou = BizCurrency.valueOf(0, currencyType);
        BizCurrency dtaisyouv = BizCurrency.valueOf(0, currencyType);
        BizCurrency haitoukin = ZERO;
        List<KeisanDInfoBean> keisanDInfoBeanList = new ArrayList<>();
        BizCurrency haitoukinDyouVrate = ZERO;
        List<KeisanDInfoBean> keisanDInfoBeanDyouVrateList = new ArrayList<>();
        BizCurrency hoseiBeforYuukoutyuusyoyougaku = ZERO;
        BizCurrency yuukoutyuusyoyougaku = ZERO;
        BizCurrency syoumetuyousyoyougaku1 = ZERO;
        BizCurrency syoumetuyousyoyougaku2 = ZERO;
        BizCurrency yokuyokunendosyoyougkyou = ZERO;
        BizCurrency gaikayokuyokunendosyoyougkyou = BizCurrency.valueOf(0, currencyType);
        BizCurrency tnknyutuujyoudsyoyougk1 = ZERO;
        BizCurrency tnknyutuujyoudsyoyougk2 = ZERO;
        int tnknyutuujyoudsyoyougk1SansyutudayNum = 0;
        int tnknyutuujyoudsyoyougk2SansyutudayNum = 0;
        BizCurrency anbunatoYokunendosyoyougakuyou = ZERO;
        BizCurrency anbunatoYokuyokunendosyoyougkyou1 = ZERO;
        BizCurrency anbunatoYokuyokunendosyoyougkyou2 = ZERO;
        BizCurrency tenkanyousyoyougaku1 = ZERO;
        BizCurrency tenkanyousyoyougaku2 = ZERO;

        if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO
            .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())
            || SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO
            .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())) {

            calckijyunfromymd = pTounendoutoubi;
            calckijyuntoymd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendoZenjiJigyouLastDay();
        }
        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam
            .getHaitousyoyougakukeisancd()) && KEIYAKUOUBIKBNGO.equals(pKeiyakuoutoubikbn)) {

            calckijyunfromymd = pTounendoutoubi;
            calckijyuntoymd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd();
        }
        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam
            .getHaitousyoyougakukeisancd()) && KEIYAKUOUBIKBNMAE.equals(pKeiyakuoutoubikbn)) {

            calckijyunfromymd = pZennendoutoubi;
            calckijyuntoymd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd();
        }

        KeisanDGanrikin keisanDGanrikin = SWAKInjector.getInstance(KeisanDGanrikin.class);
        C_ErrorKbn errorKbn = keisanDGanrikin.exec(haitousyoyouCalcstartgk, calckijyunfromymd, calckijyuntoymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            initSrRisanomiTuujyouHaitousyoyougakuBeanError(
                srRisanomiTuujyouHaitousyoyougakuBean,
                SrCommonConstants.HAITOUSSYERRORKBN_KYTKINOUERROR,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            return srRisanomiTuujyouHaitousyoyougakuBean;
        }

        tounendmtwrhrgkruikeigk = keisanDGanrikin.getDGanrikin();

        if (!SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART
            .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())
            || !KEIYAKUOUBIKBNGO.equals(pKeiyakuoutoubikbn)) {

            errorKbn = keisanDGanrikin.exec(haitousyoyouCalcstartgk, pKeisanDnendoZennendoutoubi, pKeisanDnendoutoubi);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                initSrRisanomiTuujyouHaitousyoyougakuBeanError(
                    srRisanomiTuujyouHaitousyoyougakuBean,
                    SrCommonConstants.HAITOUSSYERRORKBN_KYTKINOUERROR,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

                return srRisanomiTuujyouHaitousyoyougakuBean;
            }

            warihurigakurisoku1 = keisanDGanrikin.getDGanrikin().subtract(tounendmtwrhrgkruikeigk);
        }

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null &&
            !C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {

            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO
                .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())
                || SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO
                .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())) {

                kwsrateKjYmd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd();
            }
            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART
                .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())) {

                kwsrateKjYmd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendoZenjiJigyouLastDay();
            }

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            errorKbn = getKawaseRate.exec(
                kwsrateKjYmd,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                initSrRisanomiTuujyouHaitousyoyougakuBeanError(
                    srRisanomiTuujyouHaitousyoyougakuBean,
                    SrCommonConstants.HAITOUSSYERRORKBN_KYTKINOUERROR,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

                return srRisanomiTuujyouHaitousyoyougakuBean;
            }

            dkeisankawaserate = getKawaseRate.getKawaserate();
            dkeisankawaseratetekiyouymd = getKawaseRate.getKwsrateKjYmd();
        }

        if ((!SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART
            .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())
            || !KEIYAKUOUBIKBNGO.equals(pKeiyakuoutoubikbn)) && BizDateUtil.compareYmd(pKeisanDnendoutoubi,
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) != BizDateUtil.COMPARE_EQUAL) {

            SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);
            KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);

            DRateBean dRateBean = setDNnd.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendo().addYears(-1),
                pKeisanDnendoutoubi);

            if (dRateBean == null) {

                initSrRisanomiTuujyouHaitousyoyougakuBeanError(
                    srRisanomiTuujyouHaitousyoyougakuBean,
                    SrCommonConstants.HAITOUSSYERRORKBN_KYTKINOUERROR,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

                return srRisanomiTuujyouHaitousyoyougakuBean;
            }

            kykjyoutaiHenkan = setDNnd.henkanKykjyoutai(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                pKeisanDnendoutoubi,
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHrkkknsmnKbn());

            KeisanDBean keisanDBean = SWAKInjector.getInstance(KeisanDBean.class);
            SrDRateSyutokuInfoBeanForDSyoyou srDRateSyutokuInfoBeanForDSyoyou = new SrDRateSyutokuInfoBeanForDSyoyou(
                setDNnd);

            srDRateSyutokuInfoBeanForDSyoyou.setKoumoku(pTkJitenKeiyakuSyouhinKijyunBean,
                wkHrkkaisuu, pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getDratenendo(), kykjyoutaiHenkan);

            keisanDBean.setDRateSyutokuInfoBean(srDRateSyutokuInfoBeanForDSyoyou);
            keisanDBean.setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());
            keisanDBean.setKihonS(pTkJitenKeiyakuSyouhinKijyunBean.getKihons());
            keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);
            keisanDBean.setHaitouKaisuuBeanList(dRateBean.getHaitouKaisuuBeanLst());

            errorKbn = keisanD.exec(keisanDBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                initSrRisanomiTuujyouHaitousyoyougakuBeanError(
                    srRisanomiTuujyouHaitousyoyougakuBean,
                    SrCommonConstants.HAITOUSSYERRORKBN_KYTKINOUERROR,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

                return srRisanomiTuujyouHaitousyoyougakuBean;
            }

            haitoukin = keisanD.getD();
            keisanDInfoBeanList = keisanD.getKeisanDInfoBeanList();
            haitoukinDyouVrate = keisanD.getDDyouVrate();
            keisanDInfoBeanDyouVrateList = keisanD.getKeisanDInfoBeanDyouVrateList();

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null ||
                C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {

                yokunendosyoyougakuyou = haitoukin;
                gaikayokunendosyoyougakuyou = ZERO;
                dtaisyouv = haitoukinDyouVrate;
            }
            else {
                if(keisanDInfoBeanList.get(0).getHaitoukinYenKansanMae() != null){
                    gaikayokunendosyoyougakuyou = keisanDInfoBeanList.get(0).getHaitoukinYenKansanMae();

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    yokunendosyoyougakuyou = keisanGaikakanzan.exec(C_Tuukasyu.JPY, gaikayokunendosyoyougakuyou,
                        dkeisankawaserate, C_HasuusyoriKbn.AGE);

                }
                else{

                    gaikayokunendosyoyougakuyou = BizCurrency.valueOf(0, currencyType);

                    yokunendosyoyougakuyou = haitoukin;

                }
                if(keisanDInfoBeanDyouVrateList.size() > 0){
                    dtaisyouv = keisanDInfoBeanDyouVrateList.get(0).getHaitoukinYenKansanMae();

                }else{
                    dtaisyouv = haitoukinDyouVrate;
                }
            }
        }

        hoseiBeforYuukoutyuusyoyougaku = tounendmtwrhrgkruikeigk.add(warihurigakurisoku1).add(yokunendosyoyougakuyou);
        if (hoseiBeforYuukoutyuusyoyougaku.compareTo(BizCurrency.valueOf(0, hoseiBeforYuukoutyuusyoyougaku.getType())) >= 0) {

            yuukoutyuusyoyougaku = hoseiBeforYuukoutyuusyoyougaku;
        }

        if (!NENMEOUTOUBIKBN.equals(pGonenmeoutoubikbn)) {

            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART
                .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd()) && KEIYAKUOUBIKBNGO
                .equals(pKeiyakuoutoubikbn)) {

                calckijyunfromymd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd();
            }
            else {

                calckijyunfromymd = pKeisanDnendoutoubi;
            }

            errorKbn = keisanDGanrikin.exec(hoseiBeforYuukoutyuusyoyougaku, calckijyunfromymd,
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendoJigyouLastDay());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                initSrRisanomiTuujyouHaitousyoyougakuBeanError(
                    srRisanomiTuujyouHaitousyoyougakuBean,
                    SrCommonConstants.HAITOUSSYERRORKBN_KYTKINOUERROR,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

                return srRisanomiTuujyouHaitousyoyougakuBean;
            }

            warihurigakurisoku2 = keisanDGanrikin.getDGanrikin().subtract(hoseiBeforYuukoutyuusyoyougaku);
        }

        if (!SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART
            .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd()) || !KEIYAKUOUBIKBNGO
            .equals(pKeiyakuoutoubikbn)) {

            syoumetuyousyoyougaku1 = tounendmtwrhrgkruikeigk.add(warihurigakurisoku1.divide(2, 0, RoundingMode.HALF_UP));

            if (syoumetuyousyoyougaku1.compareTo(BizCurrency.valueOf(0, syoumetuyousyoyougaku1.getType())) < 0) {

                syoumetuyousyoyougaku1 = ZERO;
            }
        }

        if (!NENMEOUTOUBIKBN.equals(pGonenmeoutoubikbn)) {

            syoumetuyousyoyougaku2 = hoseiBeforYuukoutyuusyoyougaku.add(warihurigakurisoku2.divide(2, 0,
                RoundingMode.HALF_UP));

            if (syoumetuyousyoyougaku2.compareTo(BizCurrency.valueOf(0, syoumetuyousyoyougaku2.getType())) < 0) {

                syoumetuyousyoyougaku2 = ZERO;
            }
        }

        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);
        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);

        DRateBean dRateBean = setDNnd.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
            pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendo(),
            pKeisanDnendYokunendoutoubi);

        if (dRateBean == null) {

            initSrRisanomiTuujyouHaitousyoyougakuBeanError(
                srRisanomiTuujyouHaitousyoyougakuBean,
                SrCommonConstants.HAITOUSSYERRORKBN_KYTKINOUERROR,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            return srRisanomiTuujyouHaitousyoyougakuBean;
        }

        kykjyoutaiHenkan = setDNnd.henkanKykjyoutai(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
            pKeisanDnendYokunendoutoubi,
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHrkkknsmnKbn());

        KeisanDBean keisanDBean = SWAKInjector.getInstance(KeisanDBean.class);
        SrDRateSyutokuInfoBeanForDSyoyou srDRateSyutokuInfoBeanForDSyoyou = new SrDRateSyutokuInfoBeanForDSyoyou(
            setDNnd);

        srDRateSyutokuInfoBeanForDSyoyou.setKoumoku(pTkJitenKeiyakuSyouhinKijyunBean,
            wkHrkkaisuu, pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getDratenendo(), kykjyoutaiHenkan);

        keisanDBean.setDRateSyutokuInfoBean(srDRateSyutokuInfoBeanForDSyoyou);
        keisanDBean.setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());
        keisanDBean.setKihonS(pTkJitenKeiyakuSyouhinKijyunBean.getKihons());
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);
        keisanDBean.setHaitouKaisuuBeanList(dRateBean.getHaitouKaisuuBeanLst());

        errorKbn = keisanD.exec(keisanDBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            initSrRisanomiTuujyouHaitousyoyougakuBeanError(
                srRisanomiTuujyouHaitousyoyougakuBean,
                SrCommonConstants.HAITOUSSYERRORKBN_KYTKINOUERROR,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            return srRisanomiTuujyouHaitousyoyougakuBean;
        }

        haitoukin = keisanD.getD();
        keisanDInfoBeanList = keisanD.getKeisanDInfoBeanList();

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null ||
            C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {

            gaikayokuyokunendosyoyougkyou = ZERO;

            yokuyokunendosyoyougkyou = haitoukin;
        }
        else {
            if(keisanDInfoBeanList.get(0).getHaitoukinYenKansanMae() != null){
                gaikayokuyokunendosyoyougkyou = keisanDInfoBeanList.get(0).getHaitoukinYenKansanMae();

                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                yokuyokunendosyoyougkyou = keisanGaikakanzan.exec(C_Tuukasyu.JPY, gaikayokuyokunendosyoyougkyou,
                    dkeisankawaserate, C_HasuusyoriKbn.AGE);
            }else{
                gaikayokuyokunendosyoyougkyou = ZERO;

                yokuyokunendosyoyougkyou = haitoukin;
            }
        }

        if ((!SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART
            .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd()) || !KEIYAKUOUBIKBNGO
            .equals(pKeiyakuoutoubikbn))) {

            tnknyutuujyoudsyoyougk1SansyutudayNum = pSrRisanomiTuujyouHaitousyoyougakuBatchParam
                .getKeisanDnendoZenjiJigyouLastDay().subtractDays(pKeisanDnendoZennendoutoubi);

            tnknyutuujyoudsyoyougk1SansyutudayNum = tnknyutuujyoudsyoyougk1SansyutudayNum + 1;

            if (tnknyutuujyoudsyoyougk1SansyutudayNum > 365) {

                tnknyutuujyoudsyoyougk1SansyutudayNum = 365;
            }

            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO
                .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())
                || SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO
                .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())) {

                anbunatoYokunendosyoyougakuyou = yokunendosyoyougakuyou.multiply(tnknyutuujyoudsyoyougk1SansyutudayNum)
                    .divide(365, 0, RoundingMode.DOWN);
            }
            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART
                .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())) {

                if (pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getMonth() == SrCommonConstants.MONTH_JUNE) {

                    anbunatoYokunendosyoyougakuyou = yokunendosyoyougakuyou.multiply(
                        tnknyutuujyoudsyoyougk1SansyutudayNum + 91)
                        .divide(365, 0, RoundingMode.DOWN);
                }
                else if (pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getMonth() == SrCommonConstants.MONTH_SEPTEMBER) {

                    anbunatoYokunendosyoyougakuyou = yokunendosyoyougakuyou.multiply(
                        tnknyutuujyoudsyoyougk1SansyutudayNum + 183)
                        .divide(365, 0, RoundingMode.DOWN);
                }
                else if (pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getMonth() == SrCommonConstants.MONTH_DECEMBER) {

                    anbunatoYokunendosyoyougakuyou = yokunendosyoyougakuyou.multiply(
                        tnknyutuujyoudsyoyougk1SansyutudayNum + 275)
                        .divide(365, 0, RoundingMode.DOWN);
                }
            }

            tnknyutuujyoudsyoyougk1 = tounendmtwrhrgkruikeigk.add(anbunatoYokunendosyoyougakuyou)
                .add(hoseiBeforYuukoutyuusyoyougaku).divide(2, 0, RoundingMode.HALF_UP);
        }

        tnknyutuujyoudsyoyougk2SansyutudayNum = pSrRisanomiTuujyouHaitousyoyougakuBatchParam
            .getKeisanDnendoJigyouLastDay().subtractDays(pKeisanDnendoutoubi);

        tnknyutuujyoudsyoyougk2SansyutudayNum = tnknyutuujyoudsyoyougk2SansyutudayNum + 1;

        if (tnknyutuujyoudsyoyougk2SansyutudayNum > 365) {

            tnknyutuujyoudsyoyougk2SansyutudayNum = 365;
        }

        anbunatoYokuyokunendosyoyougkyou1 = yokuyokunendosyoyougkyou.multiply(tnknyutuujyoudsyoyougk2SansyutudayNum)
            .divide(365, 0, RoundingMode.DOWN);

        if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam
            .getHaitousyoyougakukeisancd()) && KEIYAKUOUBIKBNGO.equals(pKeiyakuoutoubikbn)) {

            if (pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getMonth() == SrCommonConstants.MONTH_JUNE) {

                anbunatoYokuyokunendosyoyougkyou2 = yokuyokunendosyoyougkyou.multiply(
                    tnknyutuujyoudsyoyougk2SansyutudayNum - 274)
                    .divide(365, 0, RoundingMode.DOWN);
            }
            else if (pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getMonth() == SrCommonConstants.MONTH_SEPTEMBER) {

                anbunatoYokuyokunendosyoyougkyou2 = yokuyokunendosyoyougkyou.multiply(
                    tnknyutuujyoudsyoyougk2SansyutudayNum - 182)
                    .divide(365, 0, RoundingMode.DOWN);
            }
            else if (pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getMonth() == SrCommonConstants.MONTH_DECEMBER) {

                anbunatoYokuyokunendosyoyougkyou2 = yokuyokunendosyoyougkyou.multiply(
                    tnknyutuujyoudsyoyougk2SansyutudayNum - 90)
                    .divide(365, 0, RoundingMode.DOWN);
            }
        }

        if (NENMEOUTOUBIKBN.equals(pGonenmeoutoubikbn)) {

            tnknyutuujyoudsyoyougk2 = ((ZERO.add(anbunatoYokuyokunendosyoyougkyou2)).add(ZERO.add(warihurigakurisoku2)
                .add(anbunatoYokuyokunendosyoyougkyou1))).divide(2, 0, RoundingMode.HALF_UP);
        }
        else {

            tnknyutuujyoudsyoyougk2 = ((hoseiBeforYuukoutyuusyoyougaku.add(anbunatoYokuyokunendosyoyougkyou2))
                .add(hoseiBeforYuukoutyuusyoyougaku.add(warihurigakurisoku2).add(anbunatoYokuyokunendosyoyougkyou1)))
                .divide(2, 0, RoundingMode.HALF_UP);
        }

        tenkanyousyoyougaku1 = tnknyutuujyoudsyoyougk1;
        if (tenkanyousyoyougaku1.compareTo(BizCurrency.valueOf(0, tenkanyousyoyougaku1.getType())) < 0) {

            tenkanyousyoyougaku1 = ZERO;
        }

        tenkanyousyoyougaku2 = tnknyutuujyoudsyoyougk2;
        if (tenkanyousyoyougaku2.compareTo(BizCurrency.valueOf(0, tenkanyousyoyougaku2.getType())) < 0) {

            tenkanyousyoyougaku2 = ZERO;
        }

        srRisanomiTuujyouHaitousyoyougakuBean.setResultFlg(SrCommonConstants.HAITOUSSYERRORKBN_ERRORNASI);
        srRisanomiTuujyouHaitousyoyougakuBean.setErrorKbn(C_ErrorKbn.OK);
        srRisanomiTuujyouHaitousyoyougakuBean.setTounendmtwrhrgkruikeigk(tounendmtwrhrgkruikeigk);
        srRisanomiTuujyouHaitousyoyougakuBean.setWarihurigakurisoku1(warihurigakurisoku1);
        srRisanomiTuujyouHaitousyoyougakuBean.setWarihurigakurisoku2(warihurigakurisoku2);
        srRisanomiTuujyouHaitousyoyougakuBean.setYokunendosyoyougakuyou(yokunendosyoyougakuyou);
        srRisanomiTuujyouHaitousyoyougakuBean.setYokuyokunendosyoyougkyou(yokuyokunendosyoyougkyou);
        srRisanomiTuujyouHaitousyoyougakuBean.setYuukoutyuusyoyougaku(yuukoutyuusyoyougaku);
        srRisanomiTuujyouHaitousyoyougakuBean.setSyoumetuyousyoyougaku1(syoumetuyousyoyougaku1);
        srRisanomiTuujyouHaitousyoyougakuBean.setSyoumetuyousyoyougaku2(syoumetuyousyoyougaku2);
        srRisanomiTuujyouHaitousyoyougakuBean.setDtaisyouv(dtaisyouv);
        srRisanomiTuujyouHaitousyoyougakuBean.setTnknyutuujyoudsyoyougk1(tnknyutuujyoudsyoyougk1);
        srRisanomiTuujyouHaitousyoyougakuBean.setTnknyutuujyoudsyoyougk2(tnknyutuujyoudsyoyougk2);
        srRisanomiTuujyouHaitousyoyougakuBean.setTenkanyousyoyougaku1(tenkanyousyoyougaku1);
        srRisanomiTuujyouHaitousyoyougakuBean.setTenkanyousyoyougaku2(tenkanyousyoyougaku2);
        srRisanomiTuujyouHaitousyoyougakuBean.setGaikayokunendosyoyougakuyou(gaikayokunendosyoyougakuyou);
        srRisanomiTuujyouHaitousyoyougakuBean.setGaikayokuyokunendosyoyougkyou(gaikayokuyokunendosyoyougkyou);
        srRisanomiTuujyouHaitousyoyougakuBean.setDkeisankawaserate(dkeisankawaserate);
        srRisanomiTuujyouHaitousyoyougakuBean.setDkeisankawaseratetekiyouymd(dkeisankawaseratetekiyouymd);

        return srRisanomiTuujyouHaitousyoyougakuBean;
    }

    public void editSrRisanomiTuujyouDKihonkoumoku(
        SrRisanomiTuujyouHaitousyoyougakuBatchParam pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
        SV_RisanomiTuujyuHitusyyugk pSvRisanomiTuujyuHitusyyugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        String pKeiyakuoutoubikbn,
        String pGonenmeoutoubikbn,
        SrRisanomiTuujyouHaitousyoyougakuBean pSrRisanomiTuujyouHaitousyoyougakuBean,
        RisanomiTjHitsyyugkParam pRisanomiTjHitsyyugkParam,
        int pSyohinHanteiKbn,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn) {

        String datakanrino = pSvRisanomiTuujyuHitusyyugk.getSyono();

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        String suurisyuruicode = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(
            C_SrKbnHenkanKbn.SUURISYURUI,
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(
                MessageId.ESA1006,
                C_SrKbnHenkanKbn.SUURISYURUI.getContent(),
                pSvRisanomiTuujyuHitusyyugk.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);

            errorFlag = true;
        }

        else {

            suurisyuruicode = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String kbnkeiriyousegmentkbn = "";
        String kbnkeiriyourgnbnskkbn = "";
        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1007,
                SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD,
                pSvRisanomiTuujyuHitusyyugk.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);
            errorFlag = true;
        }
        else {

            kbnkeiriyousegmentkbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(0, 2);
            kbnkeiriyourgnbnskkbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(2, 4);
            segCd1 = syouhinbetuSegmentBean.getSegcd1();
        }

        String haraikataKbn ="";

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            haraikataKbn = C_SuuriHaraikataKbn.ITIJI.getValue();
        }
        else {

            if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {

                if (C_Hrkkeiro.HURIKAE.eq(hrkkeiro)) {

                    haraikataKbn = C_SuuriHaraikataKbn.TIZUKI.getValue();
                }
                else if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {

                    haraikataKbn = C_SuuriHaraikataKbn.BANKZUKI.getValue();
                }
                else if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {

                    haraikataKbn = C_SuuriHaraikataKbn.CREDIT.getValue();
                }
            }
            else if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {

                haraikataKbn = C_SuuriHaraikataKbn.HALFY.getValue();
            }
            else if (C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {

                haraikataKbn = C_SuuriHaraikataKbn.NEN.getValue();
            }
        }

        Long sibous = 0L;

        if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            sibous = new BigDecimal(ptmttkngkNkgns.toAdsoluteString()).longValue();
        }
        else {
            BizDate sibousCalckijyunYmd = null;

            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART
                .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd())) {
                if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_GREATER) {
                    sibousCalckijyunYmd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
                }
                else {
                    sibousCalckijyunYmd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd();
                }
            }
            else {
                sibousCalckijyunYmd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeisanDnendoZenjiJigyouLastDay();
            }

            CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

            BizDate paramKijyunYmd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd();
            String paramHaitousyoyougakukeisancd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam
                .getHaitousyoyougakukeisancd();
            BizDate beanKykYmd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
            BizDate paramSyoriYmd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd();

            BizDate sijyouKakakuTyouseiyouRirituKijyunYmd;
            GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector
                .getInstance(GetSjkkktyouseiyouriritu.class);
            GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector
                .getInstance(GetSjkkktyouseiyourirituBean.class);
            BizNumber kaiyakusjkkktyouseiriritu = BizNumber.valueOf(0);

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null &&
                pSyohinHanteiKbn != SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                if (BizDateUtil.compareYmd(sibousCalckijyunYmd, paramKijyunYmd) == BizDateUtil.COMPARE_GREATER ||
                    (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(paramHaitousyoyougakukeisancd) &&
                        BizDateUtil.compareYmd(beanKykYmd, paramKijyunYmd) == BizDateUtil.COMPARE_GREATER) ||
                        BizDateUtil.compareYmd(paramSyoriYmd, paramKijyunYmd) == BizDateUtil.COMPARE_LESSER) {

                    if (BizDateUtil.compareYmd(paramSyoriYmd, paramKijyunYmd) == BizDateUtil.COMPARE_LESSER) {
                        sijyouKakakuTyouseiyouRirituKijyunYmd = paramSyoriYmd;
                    } else {
                        sijyouKakakuTyouseiyouRirituKijyunYmd = paramKijyunYmd;
                    }
                }
                else {
                    sijyouKakakuTyouseiyouRirituKijyunYmd = sibousCalckijyunYmd;
                }

                getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                getSjkkktyouseiyourirituBean.setKijyunymd(sijyouKakakuTyouseiyouRirituKijyunYmd);
                getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

                C_ErrorKbn sjkkkTsyRirituKekkaKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                if (C_ErrorKbn.ERROR.eq(sjkkkTsyRirituKekkaKbn)) {

                    String msg = MessageUtil
                        .getMessage(MessageId.ESA1001, SJKKKTUSIRRT, pSvRisanomiTuujyuHitusyyugk.getSyono());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                    suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam
                        .getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                        pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);

                    errorFlag = true;
                }
                else {
                    kaiyakusjkkktyouseiriritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                }
            }

            if (!errorFlag) {

                BizDateYM tmttkntaisyouYm = null;
                BizCurrency teiritutmttKngk = BizCurrency.valueOf(0);
                BizCurrency sisuurendoutmttKngk = BizCurrency.valueOf(0);
                BizNumber tumitateRiritu = BizNumber.valueOf(0);
                C_Hrkkaisuu wkHrkkaisuu = C_Hrkkaisuu.BLNK;
                C_Hrkkeiro wkHrkkeiro = C_Hrkkeiro.BLNK;
                C_Kykjyoutai kykjyoutaiHenkan = C_Kykjyoutai.BLNK;
                SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);
                BizDateYM jkipjytYm = null;

                if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                    tmttkntaisyouYm = pKhSisuurendoTmttkn.getTmttkntaisyouym();
                    teiritutmttKngk = pKhSisuurendoTmttkn.getTeiritutmttkngk();
                    sisuurendoutmttKngk = pKhSisuurendoTmttkn.getSisuurendoutmttkngk();
                    tumitateRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();

                    KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                    BizDateYM kijunNengetu = null;

                    if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

                        kijunNengetu = keisanWKijunYM.exec(
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            sibousCalckijyunYmd,
                            null,
                            null,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                    }

                    if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                        sibousCalckijyunYmd = pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd();

                    }
                    else if((BizDateUtil.calcDifferenceMonths(kijunNengetu, pKhSisuurendoTmttkn.getTmttkntaisyouym()) >
                    SrCommonConstants.KIKAN_12M)){

                        int keikamon = BizDateUtil.calcDifferenceMonths(
                            sibousCalckijyunYmd.getBizDateYM(),
                            pKhSisuurendoTmttkn.getTmttkntaisyouym());

                        int keikanensuu = keikamon / SrCommonConstants.KIKAN_12M;

                        tmttkntaisyouYm = pKhSisuurendoTmttkn.getTmttkntaisyouym().addYears(keikanensuu);

                        KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
                            SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);
                        C_ErrorKbn errorKbn2 = keisanSisuuRendouNkTmttknOverNnd.exec(
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                            pSvRisanomiTuujyuHitusyyugk.getTeikishrtkykhukaumu(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            BizDate.valueOf(tmttkntaisyouYm, pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou(),
                            tmttkntaisyouYm,
                            pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                            pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                            pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

                        if (C_ErrorKbn.ERROR.eq(errorKbn2)) {

                            String msg = MessageUtil.getMessage(MessageId.ESA1001, TMTTKN_SIBOUS,
                                pSvRisanomiTuujyuHitusyyugk.getSyono());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                            suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam
                                .getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);

                            errorFlag = true;
                        }
                        else {

                            teiritutmttKngk = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
                            sisuurendoutmttKngk = keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk();
                        }
                    }
                }
                else if(pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19  &&
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null){

                    tumitateRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                }

                if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

                    wkHrkkeiro = pSvRisanomiTuujyuHitusyyugk.getHrkkeiro();
                    wkHrkkaisuu = pSvRisanomiTuujyuHitusyyugk.getHrkkaisuu();
                }
                else {

                    wkHrkkeiro = hrkkeiro;
                    wkHrkkaisuu = hrkkaisuu;

                    if (pSyohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                        jkipjytYm = keisanWKijunYM.exec(
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            sibousCalckijyunYmd,
                            sibousCalckijyunYmd.getBizDateYM(),
                            null,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());
                    }
                }

                kykjyoutaiHenkan = setDNnd.henkanKykjyoutai(
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    sibousCalckijyunYmd,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHrkkknsmnKbn());

                C_ErrorKbn cerorKbn = calcHkShrKngk.exec(
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu(),
                    wkHrkkaisuu,
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    sibousCalckijyunYmd,
                    null,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn(),
                    C_SiinKbn.SP,
                    C_HokenkinsyuruiKbn.SBHOKENKIN,
                    pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou(),
                    kaiyakusjkkktyouseiriritu,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu(),
                    tmttkntaisyouYm,
                    teiritutmttKngk,
                    sisuurendoutmttKngk,
                    tumitateRiritu,
                    pTkJitenKeiyakuSyouhinKijyunBean.getHrkkknsmnKbn(),
                    jkipjytYm,
                    null,
                    null,
                    null,
                    null,
                    kykjyoutaiHenkan,
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                    pSvRisanomiTuujyuHitusyyugk.getSdpdkbn(),
                    wkHrkkeiro);

                if (C_ErrorKbn.ERROR.eq(cerorKbn)) {

                    String msg = MessageUtil.getMessage(MessageId.ESA1001, SIBOUS,
                        pSvRisanomiTuujyuHitusyyugk.getSyono());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                    suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam
                        .getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                        pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);

                    errorFlag = true;
                }
                else {

                    sibous = new BigDecimal(calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk().toAdsoluteString())
                    .longValue();
                }
            }
        }

        int kykymdNendo = 0;

        if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getMonth() >= SrCommonConstants.MONTH_APRIL) {

            kykymdNendo = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getYear();
        }
        else {

            kykymdNendo = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getYear() - 1;
        }

        BigDecimal daihyouyoteiriritu = new BigDecimal(0);

        if (!C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            daihyouyoteiriritu = new BigDecimal(kykjiYoteiRiritu.multiply(SrCommonConstants.INT_VALUE_100).toString());
        }
        else if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            daihyouyoteiriritu = new BigDecimal(0);
        }
        else {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu() != null) {
                daihyouyoteiriritu = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()
                    .multiply(SrCommonConstants.INT_VALUE_100).toString());
            }
        }

        Long kihons = 0L;
        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            kihons = new Long(SrCommonConstants.DEFAULT_INT_ZERO);
        }
        else {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getKihons() != null) {
                kihons = new Long(
                    new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getKihons().toAdsoluteString()).longValue());
            }
        }

        pRisanomiTjHitsyyugkParam.setZtydatakanrino(datakanrino);

        pRisanomiTjHitsyyugkParam.setZtyerrkbnv1(pSrRisanomiTuujyouHaitousyoyougakuBean.getErrorKbn().getValue());

        pRisanomiTjHitsyyugkParam.setZtyratekbn(pSrRisanomiTuujyouHaitousyoyougakuBatchParam
            .getHaitousyoyougakukeisancd());

        pRisanomiTjHitsyyugkParam.setZtysuurisyuruicd(suurisyuruicode);

        pRisanomiTjHitsyyugkParam.setZtykbnkeiriyousegmentkbn(kbnkeiriyousegmentkbn);

        pRisanomiTjHitsyyugkParam.setZtykbnkeiriyourgnbnskkbn(kbnkeiriyourgnbnskkbn);

        pRisanomiTjHitsyyugkParam.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

        pRisanomiTjHitsyyugkParam.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x1(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);

        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x2(SrCommonConstants.HKNSYKGUYBI1X2_MANNENREIHOUSIKI);

        pRisanomiTjHitsyyugkParam
        .setZtyhokensyuruikigouyobi1x3(SrCommonConstants.HKNSYKGUYBI1X3_SINHOKENHOUTEKIYOU);

        pRisanomiTjHitsyyugkParam
        .setZtyhokensyuruikigouyobi1x4(SrCommonConstants.HKNSYKGUYBI1X4_SINTOKUJYOUTEKIYOU);

        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi3x1(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);

        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi3x2(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);

        pRisanomiTjHitsyyugkParam.setZtyharaikatakbn(haraikataKbn);

        if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd() != null) {
            pRisanomiTjHitsyyugkParam.setZtykeiyakunendo(String.valueOf(kykymdNendo));

            pRisanomiTjHitsyyugkParam.setZtykeiyakum(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()
                .getMonth()));
        }

        pRisanomiTjHitsyyugkParam.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());

        if (pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen() != null) {
            pRisanomiTjHitsyyugkParam.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen()
                .toString());
        }

        pRisanomiTjHitsyyugkParam.setZty5nenmeoutoubikbn(pGonenmeoutoubikbn);

        if (pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeijyouym() != null) {
            pRisanomiTjHitsyyugkParam.setZtykeijyouym(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKeijyouym()
                .toString());
        }

        pRisanomiTjHitsyyugkParam.setZtykeiyakuoutoubikbn(pKeiyakuoutoubikbn);

        pRisanomiTjHitsyyugkParam.setZtysaisitutokuyakuhukasuu(SrCommonConstants.DEFAULT_INT_ZERO);

        pRisanomiTjHitsyyugkParam.setZtykihons(kihons);

        pRisanomiTjHitsyyugkParam.setZtysibous(sibous);

        pRisanomiTjHitsyyugkParam.setZtytounendmtwrhrgkruikeigk(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getTounendmtwrhrgkruikeigk().toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtywarihurigakurisoku1(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getWarihurigakurisoku1().toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtywarihurigakurisoku2(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getWarihurigakurisoku2().toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtyyokunendosyoyougakuyou(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getYokunendosyoyougakuyou().toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtyyokuyokunendosyoyougkyou(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getYokuyokunendosyoyougkyou().toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtyyuukoutyuusyoyougaku(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getYuukoutyuusyoyougaku().toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtysyoumetuyousyoyougaku1(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getSyoumetuyousyoyougaku1().toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtysyoumetuyousyoyougaku2(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getSyoumetuyousyoyougaku2().toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtytenkanyousyoyougaku1(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getTenkanyousyoyougaku1().toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtytenkanyousyoyougaku2(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getTenkanyousyoyougaku2().toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtytnknyutuujyoudsyoyougk1(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getTnknyutuujyoudsyoyougk1().toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtytnknyutuujyoudsyoyougk2(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getTnknyutuujyoudsyoyougk2().toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtydtaisyouv(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean.getDtaisyouv()
            .toAdsoluteString()).longValue());

        pRisanomiTjHitsyyugkParam.setZtydaihyouyoteiriritu(BizNumber.valueOf(daihyouyoteiriritu));
    }

    public void editSrRisanomiTuujyouDRAYkoumoku(
        SrRisanomiTuujyouHaitousyoyougakuBatchParam pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
        SV_RisanomiTuujyuHitusyyugk pSvRisanomiTuujyuHitusyyugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        RisanomiTjHitsyyugkParam pRisanomiTjHitsyyugkParam,
        SrRisanomiTuujyouHaitousyoyougakuBean pSrRisanomiTuujyouHaitousyoyougakuBean,
        int pSyohinHanteiKbn,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn,
        List<SV_KiykSyuhnData> pKiykSyuhnDataList) {

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
        SrRisanomiTuujyouHaitousyoyougakuDbaStatement srRisanomiTuujyouHaitousyoyougakuDbaStatement =
            SWAKInjector.getInstance(SrRisanomiTuujyouHaitousyoyougakuDbaStatement.class);

        String gaikakubun = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pSvRisanomiTuujyuHitusyyugk.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);

            errorFlag = true;
        }

        else {

            gaikakubun = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizNumber kawasereto = BizNumber.valueOf(0);

        BizDate kawaseretotekiyounengappi = null;

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null ||
            C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {
        }
        else {
            BizDate paramSyoriYmd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd();
            BizDate paramKijyunYmd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd();
            BizDate kawaserateKijyunYmd;
            if (BizDateUtil.compareYmd(paramSyoriYmd, paramKijyunYmd) == BizDateUtil.COMPARE_LESSER) {
                kawaserateKijyunYmd = paramSyoriYmd;
            } else {
                kawaserateKijyunYmd = paramKijyunYmd;
            }

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

            C_ErrorKbn cerrorKbn = getKawaseRate.exec(
                kawaserateKijyunYmd,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(cerrorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1004,
                    String.valueOf(kawaserateKijyunYmd),
                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                    C_Tuukasyu.JPY.getValue(),
                    C_KawasetekiyoKbn.TTM.getValue(),
                    C_KawasetsryKbn.JISSEIRATE.getValue(),
                    C_EigyoubiHoseiKbn.ZENEIGYOUBI.getValue(),
                    C_YouhiKbn.HUYOU.getValue());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                    pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);

                errorFlag = true;
            }

            else {

                kawasereto = getKawaseRate.getKawaserate();
                kawaseretotekiyounengappi = getKawaseRate.getKwsrateKjYmd();
            }

        }

        BizNumber kykjYtRiritu = BizNumber.valueOf(0);

        if (!C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            kykjYtRiritu = kykjiYoteiRiritu;
        }
        else if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            kykjYtRiritu = BizNumber.valueOf(0);
        }
        else {
            kykjYtRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu();
        }

        BizCurrency endatesaiteihosyousibous = BizCurrency.valueOf(0);

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            endatesaiteihosyousibous = BizCurrency.valueOf(0);
        }
        else {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                endatesaiteihosyousibous = BizCurrency.valueOf(0);
            }
            else {
                List<IT_KykSyouhnHnkmae> kykSyouhnHnkmaesList = srRisanomiTuujyouHaitousyoyougakuDbaStatement
                    .getKykSyouhnHnkmaesList(pSvRisanomiTuujyuHitusyyugk.getSyono());

                SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo = SWAKInjector
                    .getInstance(SrGetTokutejitenTokuyakuInfo.class);
                SrGetTokutejitenTokuyakuInfoBean srGetTokutejitenTokuyakuInfoBean = srGetTokutejitenTokuyakuInfo.exec(
                    C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK,
                    C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET,
                    pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd(),
                    pSvRisanomiTuujyuHitusyyugk.getSyono(),
                    null,
                    null,
                    null,
                    pKiykSyuhnDataList,
                    pSvRisanomiTuujyuHitusyyugk.getYendthnkymd(),
                    kykSyouhnHnkmaesList,
                    pSvRisanomiTuujyuHitusyyugk.getInitsbjiyensitihsytkhukaumu(),
                    pSvRisanomiTuujyuHitusyyugk.getInitsbjiyenkasaiteihsygk(),
                    null,
                    null,
                    null,
                    null);

                endatesaiteihosyousibous = srGetTokutejitenTokuyakuInfoBean.getInitsbjiyenkasaiteihsygkMae();

            }
        }

        BizCurrency tumitatekin = ptmttkngkRrnBase;
        BizCurrency kiharaikomiP = kiharaikomiPRrnBase;
        BizCurrency gaikadatesyukeiyakup = pRrnBase;

        String tuukasyuKbn = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.TUUKA_SYU, pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.TUUKA_SYU.getContent(),
                pSvRisanomiTuujyuHitusyyugk.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);
            errorFlag = true;
        }
        else {

            tuukasyuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        Long nksjitirttumitatekin = new Long(SrCommonConstants.DEFAULT_INT_ZERO);
        Long sisuurentumitatekin = new Long(SrCommonConstants.DEFAULT_INT_ZERO);

        if ((pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20)&&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

            KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd = SWAKInjector
                .getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

            C_ErrorKbn kekkaKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                pSvRisanomiTuujyuHitusyyugk.getTeikishrtkykhukaumu(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getBizDateYM(),
                pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                String msg = MessageUtil.getMessage(
                    MessageId.ESA1001,
                    NKSJITIRTTUMITATEKIN,
                    pSvRisanomiTuujyuHitusyyugk.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                    pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);

                errorFlag = true;
            }

            else {

                if (keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk() != null) {
                    nksjitirttumitatekin = new Long(
                        new BigDecimal(keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk().toAdsoluteString()).longValue());
                }
            }

            if (pKhSisuurendoTmttkn.getSisuurendoutmttkngk() != null) {
                sisuurentumitatekin = new Long(
                    new BigDecimal(pKhSisuurendoTmttkn.getSisuurendoutmttkngk().toAdsoluteString()).longValue());
            }
        }

        BizCurrency syukeiyakuP = BizCurrency.valueOf(0);
        Integer hknKkn = 0;
        Integer pHrkKkn = 0;
        String saimnkkykhyj = "";

        if (!C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            syukeiyakuP = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
            hknKkn = pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn();
            pHrkKkn = pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn();
            saimnkkykhyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            saimnkkykhyj = SrCommonConstants.HYOUJI_NASI;
        }

        BizNumber yoteiRirituRironbase = yoteiRirituRrnBase;

        pRisanomiTjHitsyyugkParam.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pRisanomiTjHitsyyugkParam.setZtygaikakbn(gaikakubun);
        if (kawasereto != null) {
            pRisanomiTjHitsyyugkParam.setZtykawaserate(kawasereto);
        }
        if (kawaseretotekiyounengappi != null) {
            pRisanomiTjHitsyyugkParam.setZtykawaseratetekiyouymd(kawaseretotekiyounengappi.toString());
        }
        pRisanomiTjHitsyyugkParam.setZtykeiyakujiyoteiriritu(kykjYtRiritu);
        pRisanomiTjHitsyyugkParam.setZtyenkdtsbujsitihsyukngk(new BigDecimal(
            endatesaiteihosyousibous.toAdsoluteString()).longValue());
        pRisanomiTjHitsyyugkParam.setZtytumitatekin(new BigDecimal(tumitatekin.toAdsoluteString()).longValue());
        pRisanomiTjHitsyyugkParam.setZtykiharaikomip(new BigDecimal(kiharaikomiP.toAdsoluteString()).longValue());
        pRisanomiTjHitsyyugkParam.setZtygaikadatesyukeiyakup(new BigDecimal(gaikadatesyukeiyakup.toAdsoluteString())
        .longValue());
        pRisanomiTjHitsyyugkParam.setZtytuukasyukbn(tuukasyuKbn);
        pRisanomiTjHitsyyugkParam.setZtynksjitirttumitatekin(nksjitirttumitatekin);
        pRisanomiTjHitsyyugkParam.setZtysisuurentumitatekin(sisuurentumitatekin);
        pRisanomiTjHitsyyugkParam.setZtysyukeiyakup(new BigDecimal(syukeiyakuP.toAdsoluteString()).longValue());
        pRisanomiTjHitsyyugkParam.setZtyhknkkn(hknKkn.toString());
        pRisanomiTjHitsyyugkParam.setZtyphrkkikn(pHrkKkn.toString());
        pRisanomiTjHitsyyugkParam.setZtysaimnkkykhyj(saimnkkykhyj);
        pRisanomiTjHitsyyugkParam.setZtyyoteiririturironbase(yoteiRirituRironbase);
        pRisanomiTjHitsyyugkParam.setZtygkdtyknndsyoyougakuyou(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getGaikayokunendosyoyougakuyou().toAdsoluteString()).longValue());
        pRisanomiTjHitsyyugkParam.setZtygkdtykyknndsyoyougakuyou(new BigDecimal(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getGaikayokuyokunendosyoyougkyou().toAdsoluteString()).longValue());
        pRisanomiTjHitsyyugkParam.setZtydkeisanjikwsrate(pSrRisanomiTuujyouHaitousyoyougakuBean.getDkeisankawaserate());
        pRisanomiTjHitsyyugkParam.setZtydkeisanjikwsratetkyymd(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getDkeisankawaseratetekiyouymd().toString());
        pRisanomiTjHitsyyugkParam.setZtysrdai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn().toString());
    }

    public void setHeadKoumoku(
        SrRisanomiTuujyouHaitousyoyougakuBatchParam pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
        RisanomiTjHitsyyugkParam pRisanomiTjHitsyyugkParam) {

        Integer sikensubangou = null;

        Integer laoutPrul014 = null;

        Integer laoutPrul057 = null;

        Integer laoutPrre857 = null;

        Integer laoutRdw = null;

        Integer laoutLength = null;

        String rdw = "";

        String kbnkey = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getHeisoukbn();

        if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam
            .getHaitousyoyougakukeisancd())) {

            sikensubangou = Integer.valueOf(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyorikensuuNplusZero() +
                kbnkey.substring(kbnkey.length() - 1));

            laoutPrul014 = YuyuSuuriConfig.getInstance().getPalprul014length();

            laoutPrul057 = YuyuSuuriConfig.getInstance().getPalprul057length();

            laoutPrre857 = YuyuSuuriConfig.getInstance().getPalprre857length();

            laoutRdw = YuyuSuuriConfig.getInstance().getPalrdwarealength();

            laoutLength = laoutRdw + laoutPrul014 + laoutPrre857
                + (laoutPrul057 * pRisanomiTjHitsyyugkParam.getZtysaisitutokuyakuhukasuu());

            rdw = "";

            pRisanomiTjHitsyyugkParam.setZtysequenceno(sikensubangou);

            pRisanomiTjHitsyyugkParam.setZtyyuukourecordlength(laoutLength);

            pRisanomiTjHitsyyugkParam.setZtyrdwarea(rdw);
        }
        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART
            .equals(pSrRisanomiTuujyouHaitousyoyougakuBatchParam
                .getHaitousyoyougakukeisancd())) {

            sikensubangou = Integer.valueOf(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyorikensuuNplusQuart() +
                kbnkey.substring(kbnkey.length() - 1));

            laoutPrul014 = YuyuSuuriConfig.getInstance().getPalprul014length();

            laoutPrul057 = YuyuSuuriConfig.getInstance().getPalprul057length();

            laoutPrre857 = YuyuSuuriConfig.getInstance().getPalprre857length();

            laoutRdw = YuyuSuuriConfig.getInstance().getPalrdwarealength();

            laoutLength = laoutRdw + laoutPrul014 + laoutPrre857
                + (laoutPrul057 * pRisanomiTjHitsyyugkParam.getZtysaisitutokuyakuhukasuu());

            rdw = "";

            pRisanomiTjHitsyyugkParam.setZtysequenceno(sikensubangou);

            pRisanomiTjHitsyyugkParam.setZtyyuukourecordlength(laoutLength);

            pRisanomiTjHitsyyugkParam.setZtyrdwarea(rdw);
        }

        else {

            sikensubangou = Integer.valueOf(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyorikensuuNminusZero() +
                kbnkey.substring(kbnkey.length() - 1));

            laoutPrul014 = YuyuSuuriConfig.getInstance().getPalprul014length();

            laoutPrul057 = YuyuSuuriConfig.getInstance().getPalprul057length();

            laoutPrre857 = YuyuSuuriConfig.getInstance().getPalprre857length();

            laoutRdw = YuyuSuuriConfig.getInstance().getPalrdwarealength();

            laoutLength = laoutRdw + laoutPrul014 + laoutPrre857
                + (laoutPrul057 * pRisanomiTjHitsyyugkParam.getZtysaisitutokuyakuhukasuu());

            rdw = "";

            pRisanomiTjHitsyyugkParam.setZtysequenceno(sikensubangou);

            pRisanomiTjHitsyyugkParam.setZtyyuukourecordlength(laoutLength);

            pRisanomiTjHitsyyugkParam.setZtyrdwarea(rdw);
        }
    }

    public void getHijynKyoutuuInfo(
        SrRisanomiTuujyouHaitousyoyougakuBatchParam pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
        SV_RisanomiTuujyuHitusyyugk pSvRisanomiTuujyuHitusyyugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        List<SV_KiykSyuhnData> pKiykSyuhnDataLst,
        List<IT_HokenryouTmttkn> pHokenryouTmttknLst,
        int pSyohinHanteiKbn) {

        BizDateYM calckijyunYmRrnBase = null;
        BizDate kwsratekjYmd = null;
        Boolean nkgnsZenKeisanFlg = false;

        GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);
        getYoteirirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        getYoteirirituBean.setKijyunymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
        getYoteirirituBean.setSknnkaisiymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
        getYoteirirituBean.setKykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
        getYoteirirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
        getYoteirirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
        getYoteirirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
        getYoteirirituBean.setSitihsyuriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt());
        getYoteirirituBean.setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn kekkaKbn = getYoteiriritu.exec(getYoteirirituBean);

        if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

            String msg = MessageUtil.getMessage(
                MessageId.ESA1001,
                KYKJIYOTEIRIRITU,
                pSvRisanomiTuujyuHitusyyugk.getSyono());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);

            errorFlag = true;
        }
        else {

            kykjiYoteiRiritu = getYoteiriritu.getYoteiriritu();
        }

        if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            if (BizDateUtil.compareYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

                calckijyunYmRrnBase = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                nkgnsZenKeisanFlg = true;
            }
            else {

                calckijyunYmRrnBase = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getBizDateYM();
            }

            if (BizDateUtil.compareYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd(),
                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER) {

                kwsratekjYmd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd();
            }
            else {

                kwsratekjYmd = pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd();
            }

            SrSuuriKeisanVHeijyun srSuuriKeisanVHeijyun = SWAKInjector.getInstance(SrSuuriKeisanVHeijyun.class);

            kekkaKbn = srSuuriKeisanVHeijyun.exec(pSvRisanomiTuujyuHitusyyugk.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean, pKiykSyuhnDataLst, pHokenryouTmttknLst, calckijyunYmRrnBase,
                calckijyunYmRrnBase, pSvRisanomiTuujyuHitusyyugk.getHrkkaisuu(),
                pSvRisanomiTuujyuHitusyyugk.getFstpnyknymd(), true, kwsratekjYmd, nkgnsZenKeisanFlg, false);

            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                String msg = MessageUtil.getMessage(
                    MessageId.ESA1001,
                    SUURIHIJYNPTUMITATEKIN,
                    pSvRisanomiTuujyuHitusyyugk.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                    pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);

                errorFlag = true;
            }

            else {

                List<SrTmttknBean> srTmttknBeanLst = srSuuriKeisanVHeijyun.getSrTmttknBeanList();

                if (BizDateUtil.compareYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

                    ptmttkngkRrnBase = BizCurrency.valueOf(0);
                    kiharaikomiPRrnBase = BizCurrency.valueOf(0);
                }
                else {

                    ptmttkngkRrnBase = srTmttknBeanLst.get(0).getTmttKngk();
                    kiharaikomiPRrnBase = srTmttknBeanLst.get(0).getKiharaikomiP();
                }

                yoteiRirituRrnBase = srTmttknBeanLst.get(0).getYoteiriritu();

                KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);

                kekkaKbn = keisanGaikaP.execKawaseSitei(srTmttknBeanLst.get(0).getHokenryou(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                    srTmttknBeanLst.get(srTmttknBeanLst.size() - 1).getKawaserate());

                if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                    String msg = MessageUtil.getMessage(
                        MessageId.ESA1001,
                        TANGETUGKNYKNKGKKSN_RIRONBASE,
                        pSvRisanomiTuujyuHitusyyugk.getSyono());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                    suuriyouErrJyouhou.setSyoriYmd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrRisanomiTuujyouHaitousyoyougakuBatchParam.setZokkouerrsyorikensuu(
                        pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getZokkouerrsyorikensuu() + 1);

                    errorFlag = true;
                }

                else {

                    pRrnBase = keisanGaikaP.getP();
                }

                ptmttkngkNkgns = srTmttknBeanLst.get(srTmttknBeanLst.size() - 1).getTmttKngk();
            }
        }

        SrGetTokutejitenKykKihonInfo srGetTokutejitenKykKihonInfo = SWAKInjector
            .getInstance(SrGetTokutejitenKykKihonInfo.class);
        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN,
            pSvRisanomiTuujyuHitusyyugk.getSyono(),
            pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd(),
            null,
            pKiykSyuhnDataLst,
            null,
            pSvRisanomiTuujyuHitusyyugk.getHrkkeiro(),
            pSvRisanomiTuujyuHitusyyugk.getHrkkaisuu());
        hrkkeiro = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
        hrkkaisuu= srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
    }

    public void initSrRisanomiTuujyouHaitousyoyougakuBeanError(
        SrRisanomiTuujyouHaitousyoyougakuBean pSrRisanomiTuujyouHaitousyoyougakuBean,
        int pHaitoussyErrorkbn,
        C_Tuukasyu pTuukasyu) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);

        pSrRisanomiTuujyouHaitousyoyougakuBean.setResultFlg(pHaitoussyErrorkbn);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setErrorKbn(C_ErrorKbn.ERROR);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setTounendmtwrhrgkruikeigk(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setWarihurigakurisoku1(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setWarihurigakurisoku2(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setYokunendosyoyougakuyou(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setYokuyokunendosyoyougkyou(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setYuukoutyuusyoyougaku(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setSyoumetuyousyoyougaku1(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setSyoumetuyousyoyougaku2(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setDtaisyouv(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setTenkanyousyoyougaku1(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setTenkanyousyoyougaku2(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setTnknyutuujyoudsyoyougk1(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setTnknyutuujyoudsyoyougk2(ZERO);
        pSrRisanomiTuujyouHaitousyoyougakuBean.setGaikayokunendosyoyougakuyou(BizCurrency.valueOf(0, currencyType));
        pSrRisanomiTuujyouHaitousyoyougakuBean.setGaikayokuyokunendosyoyougkyou(BizCurrency.valueOf(0, currencyType));
        pSrRisanomiTuujyouHaitousyoyougakuBean.setDkeisankawaserate(BizNumber.valueOf(0));
        pSrRisanomiTuujyouHaitousyoyougakuBean.setDkeisankawaseratetekiyouymd(BizDate.valueOf(000000));
    }

    public void editHtkinSikinIdouData(
        SrRisanomiTuujyouHaitousyoyougakuBatchParam pSrRisanomiTuujyouHaitousyoyougakuBatchParam,
        SV_RisanomiTuujyuHitusyyugk pSvRisanomiTuujyuHitusyyugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SrRisanomiTuujyouHaitousyoyougakuBean pSrRisanomiTuujyouHaitousyoyougakuBean,
        String pGonenmeoutoubikbn,
        HtkinSikinIdouDataBean pHtkinSikinIdouDataBean) {

        pHtkinSikinIdouDataBean.setSyono(pSvRisanomiTuujyuHitusyyugk.getSyono());
        pHtkinSikinIdouDataBean.setKijyunymd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getKijyunymd());
        pHtkinSikinIdouDataBean.setKakutyoujobcd(pSrRisanomiTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());
        pHtkinSikinIdouDataBean.setKyktuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());
        pHtkinSikinIdouDataBean.setGonenmeoutoubikbn(pGonenmeoutoubikbn);
        pHtkinSikinIdouDataBean.setYuukoutyuusyoyougaku(pSrRisanomiTuujyouHaitousyoyougakuBean
            .getYuukoutyuusyoyougaku());
        pHtkinSikinIdouDataBean.setSeg1cd(segCd1);
        pHtkinSikinIdouDataBean.setKawaserate(pSrRisanomiTuujyouHaitousyoyougakuBean.getDkeisankawaserate());
    }
}