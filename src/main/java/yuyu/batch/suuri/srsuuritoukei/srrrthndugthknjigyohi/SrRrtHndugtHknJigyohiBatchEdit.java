package yuyu.batch.suuri.srsuuritoukei.srrrthndugthknjigyohi;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.hozen.khcommon.KeisanGaikaP;
import yuyu.common.hozen.khcommon.KeisanIkkatuPGk;
import yuyu.common.hozen.khcommon.KeisanIkkatuPGkBean;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfoBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.srcommon.SrSuuriKeisanVHeijyun;
import yuyu.common.suuri.srcommon.SrTmttknBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ALMSoftKbn;
import yuyu.def.classification.C_DaiKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HosyouKinouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SkeiSoftKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriAnnaiFuyouRiyuuKbn;
import yuyu.def.classification.C_SuuriHaraikataKbn;
import yuyu.def.classification.C_SuuriPWaribikitekiyouKbn;
import yuyu.def.classification.C_SuuriRyourituKbn;
import yuyu.def.classification.C_SyouKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyuuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_RrtHndugtHknJigyohiTy;
import yuyu.def.db.entity.ZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 利率変動型保険事業費情報作成の項目編集クラス
 */
public class SrRrtHndugtHknJigyohiBatchEdit {

    private Boolean errorFlag;

    private C_Hrkkeiro hrkkeiro;

    @Inject
    private BatchLogger batchLogger;

    public SrRrtHndugtHknJigyohiBatchEdit() {

        errorFlag = false;
    }

    public Boolean editKoumoku(SrRrtHndugtHknJigyohiBatchParam pSrRrtHndugtHknJigyohiBatchParam,
        C_KessanKbn pOuttisyKbn, BizDateYM pPjytoym, C_TaisyakuKbn pTaisyakuKbn, BizDate pDenymd,
        String pSyoricd, BizDate pSyoriYmd, C_Segcd pSeg1cd, Long pZennoujiikkatubaraijytgk,
        String pDenrenno, String pSyoumetuHyouji, TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        List<SV_KiykSyuhnData> pKiykSyuhnDataLst, SV_HoyuuMeisai pHoyuuMeisai,
        List<IT_HokenryouTmttkn> pHokenryouTmttknLst, ZT_RrtHndugtHknJigyohiTy pRrtHndugtHknJigyohiTy,
        ZT_RrtHndugtHknKsnJigyohiTy pRrtHndugtHknKsnJigyohiTy) {

        BizDate keiyakuKihonjymd = null;
        hrkkeiro = C_Hrkkeiro.BLNK;

        keiyakuKihonjymd = BizDate.valueOf(pPjytoym, pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());

        SrGetTokutejitenKykKihonInfo srGetTokutejitenSyohnInfo =
            SWAKInjector.getInstance(SrGetTokutejitenKykKihonInfo.class);

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenSyohnInfo.exec(
            C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN,
            pHoyuuMeisai.getSyono(), keiyakuKihonjymd, null, pKiykSyuhnDataLst, null,
            pHoyuuMeisai.getHrkkeiro(),pHoyuuMeisai.getHrkkaisuu());

        hrkkeiro = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();

        editHeddaKoumoku(
            pSrRrtHndugtHknJigyohiBatchParam,
            pOuttisyKbn,
            pRrtHndugtHknJigyohiTy,
            pRrtHndugtHknKsnJigyohiTy);

        editKeijyouctrlKoumoku(
            pSrRrtHndugtHknJigyohiBatchParam,
            pOuttisyKbn,
            pPjytoym,
            pTaisyakuKbn,
            pDenymd,
            pSyoricd,
            pSyoriYmd,
            pDenrenno,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pKiykSyuhnDataLst,
            pHoyuuMeisai,
            pRrtHndugtHknJigyohiTy,
            pRrtHndugtHknKsnJigyohiTy);

        editKykInfoKoumoku(
            pSrRrtHndugtHknJigyohiBatchParam,
            pOuttisyKbn,
            pSeg1cd,
            pSyoumetuHyouji,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pHoyuuMeisai,
            pRrtHndugtHknJigyohiTy,
            pRrtHndugtHknKsnJigyohiTy);

        editJigyouhiksnKoumoku(
            pSrRrtHndugtHknJigyohiBatchParam,
            pOuttisyKbn,
            pPjytoym,
            pZennoujiikkatubaraijytgk,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pKiykSyuhnDataLst,
            pHoyuuMeisai,
            pHokenryouTmttknLst,
            pRrtHndugtHknJigyohiTy,
            pRrtHndugtHknKsnJigyohiTy);

        return errorFlag;
    }

    private void editHeddaKoumoku(SrRrtHndugtHknJigyohiBatchParam pSrRrtHndugtHknJigyohiBatchParam, C_KessanKbn pOuttisyKbn,
        ZT_RrtHndugtHknJigyohiTy pRrtHndugtHknJigyohiTy, ZT_RrtHndugtHknKsnJigyohiTy pRrtHndugtHknKsnJigyohiTy) {

        if (C_KessanKbn.TUUJYOU.eq(pOuttisyKbn)) {
            int keyKoumoku = pSrRrtHndugtHknJigyohiBatchParam.getReigetuKensuu();
            pSrRrtHndugtHknJigyohiBatchParam.setReigetuKensuu(pSrRrtHndugtHknJigyohiBatchParam.getReigetuKensuu() + 1);
            pRrtHndugtHknJigyohiTy.setZtysequenceno(keyKoumoku);
        }
        else {
            int keyKoumoku = pSrRrtHndugtHknJigyohiBatchParam.getKessanKensuu();
            pSrRrtHndugtHknJigyohiBatchParam.setKessanKensuu(pSrRrtHndugtHknJigyohiBatchParam.getKessanKensuu() + 1);
            pRrtHndugtHknKsnJigyohiTy.setZtysequenceno(keyKoumoku);
        }
    }

    public void editKeijyouctrlKoumoku(SrRrtHndugtHknJigyohiBatchParam pSrRrtHndugtHknJigyohiBatchParam,
        C_KessanKbn pOuttisyKbn, BizDateYM pPjytoym, C_TaisyakuKbn pTaisyakuKbn, BizDate pDenymd,
        String pSyoricd, BizDate pSyoriYmd, String pDenrenno, TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        List<SV_KiykSyuhnData> pKiykSyuhnDataLst, SV_HoyuuMeisai pHoyuuMeisai, ZT_RrtHndugtHknJigyohiTy pRrtHndugtHknJigyohiTy,
        ZT_RrtHndugtHknKsnJigyohiTy pRrtHndugtHknKsnJigyohiTy) {

        BizDate denymd = pDenymd;
        boolean denymdSaisetteiFlg = false;
        IT_NyknJissekiRireki nyknJissekiRireki = null;

        if (C_TaisyakuKbn.KARIKATA.eq(pTaisyakuKbn)) {

            SrRrtHndugtHknJigyohiBatchDbAccess srRrtHndugtHknJigyohiBatchDbAccess = SWAKInjector
                .getInstance(SrRrtHndugtHknJigyohiBatchDbAccess.class);

            if (SrCommonConstants.SYORICD_NYUUKINTORIKESI.equals(pSyoricd)) {
                nyknJissekiRireki =
                    srRrtHndugtHknJigyohiBatchDbAccess.getNyknJissekiRireki2(pHoyuuMeisai.getSyono(), pPjytoym,  pDenrenno);

                if (nyknJissekiRireki != null) {
                    denymd = nyknJissekiRireki.getNykdenymd();
                    denymdSaisetteiFlg = true;
                }
            }
            else {
                nyknJissekiRireki =
                    srRrtHndugtHknJigyohiBatchDbAccess.getNyknJissekiRireki1(pHoyuuMeisai.getSyono(), pPjytoym);

                if (nyknJissekiRireki != null) {
                    denymd = nyknJissekiRireki.getNykdenymd();
                    denymdSaisetteiFlg = true;
                }
            }
        }

        if (denymdSaisetteiFlg) {

            int kykymdMonth = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getMonth();
            BizDateYM kykymdYmZengetu = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM()
                .addMonths(-SrCommonConstants.KIKAN_1M);

            if ((kykymdMonth == SrCommonConstants.MONTH_JANUARY || kykymdMonth == SrCommonConstants.MONTH_APRIL
                || kykymdMonth == SrCommonConstants.MONTH_JULY || kykymdMonth == SrCommonConstants.MONTH_OCTOBER)
                && BizDateUtil.compareYm(pHoyuuMeisai.getSkeikeijyouym(), denymd.getBizDateYM()) == BizDateUtil.COMPARE_LESSER
                && BizDateUtil.compareYm(pHoyuuMeisai.getSkeikeijyouym(), kykymdYmZengetu) == BizDateUtil.COMPARE_EQUAL
                && BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(),
                    nyknJissekiRireki.getJyutoustartym()) == BizDateUtil.COMPARE_EQUAL) {

                denymd = pHoyuuMeisai.getSkeikeijyouym().getLastDay();
            }
        }

        String kykymdmaekykhyj = "";
        if (C_KessanKbn.TUUJYOU.eq(pOuttisyKbn)) {
            kykymdmaekykhyj = SrCommonConstants.HYOUJI_NASI;
        }
        else {
            kykymdmaekykhyj = SrCommonConstants.HYOUJI_ARI;
        }

        if (C_KessanKbn.TUUJYOU.eq(pOuttisyKbn)) {
            pRrtHndugtHknJigyohiTy.setZtykeijyouym(String.valueOf(pSrRrtHndugtHknJigyohiBatchParam.getKijyunymd()
                .getBizDateYM()));
            pRrtHndugtHknJigyohiTy.setZtysuuriyoupjytouym(String.valueOf(pPjytoym));
            pRrtHndugtHknJigyohiTy.setZtyhenkousyoriymd(String.valueOf(pSyoriYmd));
            pRrtHndugtHknJigyohiTy.setZtydenymd(String.valueOf(denymd));
            pRrtHndugtHknJigyohiTy.setZtysyoricd(pSyoricd);
            pRrtHndugtHknJigyohiTy.setZtykykymdmaekykhyj(kykymdmaekykhyj);
            pRrtHndugtHknJigyohiTy.setZtykarikasikbn(pTaisyakuKbn.getValue());
        }
        else {
            pRrtHndugtHknKsnJigyohiTy.setZtykeijyouym(String.valueOf(pSrRrtHndugtHknJigyohiBatchParam.getKijyunymd()
                .getBizDateYM()));
            pRrtHndugtHknKsnJigyohiTy.setZtysuuriyoupjytouym(String.valueOf(pPjytoym));
            pRrtHndugtHknKsnJigyohiTy.setZtyhenkousyoriymd(String.valueOf(pSyoriYmd));
            pRrtHndugtHknKsnJigyohiTy.setZtydenymd(String.valueOf(denymd));
            pRrtHndugtHknKsnJigyohiTy.setZtysyoricd(pSyoricd);
            pRrtHndugtHknKsnJigyohiTy.setZtykykymdmaekykhyj(kykymdmaekykhyj);
            pRrtHndugtHknKsnJigyohiTy.setZtykarikasikbn(pTaisyakuKbn.getValue());
        }
    }

    private void editKykInfoKoumoku(SrRrtHndugtHknJigyohiBatchParam pSrRrtHndugtHknJigyohiBatchParam,
        C_KessanKbn pOuttisyKbn, C_Segcd pSeg1cd, String pSyoumetuHyouji, TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SV_HoyuuMeisai pHoyuuMeisai, ZT_RrtHndugtHknJigyohiTy pRrtHndugtHknJigyohiTy,
        ZT_RrtHndugtHknKsnJigyohiTy pRrtHndugtHknKsnJigyohiTy) {

        String suuriSyuruiCd = "";
        String sedaiKbn = "";
        String haraikatakbn = "";
        String saimankikykhyouji = "";
        String suuriAnnaiFuyouRiyuuKbn = "";
        String hrkkaisuukbn = "";
        String hrkkeirokbn = "";
        String ryouritukbn = "";
        String hhknnentysihyj = "";
        String syukeiyakuPWaribikiKbn = "";
        String nenkinKaisiNendo = "";
        String nenkingataKbn = "";
        String bosyuKeitaiKbn = "";
        String gaikaKbn = "";
        String tuukasyukbn = "";

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.TUUKA_SYU,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.TUUKA_SYU.getContent(),
                pHoyuuMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrRrtHndugtHknJigyohiBatchParam, pHoyuuMeisai, msg);
        }

        else {
            tuukasyukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(C_SrKbnHenkanKbn.SUURISYURUI,
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(
                MessageId.ESA1006,
                C_SrKbnHenkanKbn.SUURISYURUI.getContent(),
                pHoyuuMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
                );

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrRrtHndugtHknJigyohiBatchParam, pHoyuuMeisai, msg);
        }
        else {
            suuriSyuruiCd = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SEDAI,
            pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SEDAI.getContent(),
                pHoyuuMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrRrtHndugtHknJigyohiBatchParam, pHoyuuMeisai, msg);
        }
        else {
            sedaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (C_Hrkkaisuu.ITIJI.eq(pHoyuuMeisai.getHrkkaisuu())) {
            haraikatakbn = C_SuuriHaraikataKbn.ITIJI.getValue();
        }
        else {
            if (C_Hrkkeiro.HURIKAE.eq(hrkkeiro)) {
                haraikatakbn = C_SuuriHaraikataKbn.TIZUKI.getValue();
            }
            else if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {
                haraikatakbn = C_SuuriHaraikataKbn.BANKZUKI.getValue();
            }
            else if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
                haraikatakbn = C_SuuriHaraikataKbn.CREDIT.getValue();
            }
        }

        if (C_HknkknsmnKbn.SAIMANKI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn())) {
            saimankikykhyouji = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            saimankikykhyouji = SrCommonConstants.HYOUJI_NASI;
        }

        if (C_Hrkkaisuu.ITIJI.eq(pHoyuuMeisai.getHrkkaisuu())) {
            suuriAnnaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ITIJI.getValue();
        }
        else {
            suuriAnnaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ANNAITYUU.getValue();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.HRK_KAISUU,
            pHoyuuMeisai.getHrkkaisuu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KAISUU.getContent(),
                pHoyuuMeisai.getSyono(), pHoyuuMeisai.getHrkkaisuu().getValue());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrRrtHndugtHknJigyohiBatchParam, pHoyuuMeisai, msg);
        }
        else {
            hrkkaisuukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.HRK_KEIRO,
            hrkkeiro.getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KEIRO.getContent(),
                pHoyuuMeisai.getSyono(), hrkkeiro.getValue());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrRrtHndugtHknJigyohiBatchParam, pHoyuuMeisai, msg);
        }
        else {
            hrkkeirokbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (C_Hrkkaisuu.ITIJI.eq(pHoyuuMeisai.getHrkkaisuu())) {
            ryouritukbn = C_SuuriRyourituKbn.OTHER.getValue();
        }
        else {
            if (C_Hrkkeiro.HURIKAE.eq(hrkkeiro)) {
                ryouritukbn = C_SuuriRyourituKbn.OTHER.getValue();
            }
            else if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {
                ryouritukbn = C_SuuriRyourituKbn.KOUHURI.getValue();
            }
            else if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
                ryouritukbn = C_SuuriRyourituKbn.CREDIT.getValue();
            }
        }

        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);

        int hhknHkNenrei = setHokenNenrei.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHhknseiymd());

        if (pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().intValue() != hhknHkNenrei) {
            hhknnentysihyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            hhknnentysihyj = SrCommonConstants.HYOUJI_NASI;
        }

        if (pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().compareTo(
            BizCurrency.valueOf(SrCommonConstants.YEN_15000,
                pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().getType())) < 0) {
            syukeiyakuPWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_NONE.getValue();
        }
        else if (pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().compareTo(
            BizCurrency.valueOf(SrCommonConstants.YEN_30000,
                pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().getType())) < 0) {
            syukeiyakuPWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_RANK01.getValue();
        }
        else {
            syukeiyakuPWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_RANK02.getValue();
        }

        if (pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getMonth() >= SrCommonConstants.MONTH_APRIL) {
            nenkinKaisiNendo = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getYear());
        }
        else {
            nenkinKaisiNendo = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getYear()
                - SrCommonConstants.YEAR_1Y);
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.NENKINGATA,
            pTkJitenKeiyakuSyouhinKijyunBean.getNksyukbn().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.NENKINGATA.getContent(),
                pHoyuuMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getNksyukbn().getValue());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrRrtHndugtHknJigyohiBatchParam, pHoyuuMeisai, msg);
        }
        else {
            nenkingataKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.BOSYU_KEITAI,
            pHoyuuMeisai.getDrtencd());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                pHoyuuMeisai.getSyono(),
                pHoyuuMeisai.getDrtencd());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrRrtHndugtHknJigyohiBatchParam, pHoyuuMeisai, msg);
        }
        else {
            bosyuKeitaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pHoyuuMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrRrtHndugtHknJigyohiBatchParam, pHoyuuMeisai, msg);
        }
        else {
            gaikaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (C_KessanKbn.TUUJYOU.eq(pOuttisyKbn)) {

            pRrtHndugtHknJigyohiTy.setZtydatakanrino(pHoyuuMeisai.getSyono());
            pRrtHndugtHknJigyohiTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
            pRrtHndugtHknJigyohiTy.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            pRrtHndugtHknJigyohiTy.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
            pRrtHndugtHknJigyohiTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
            pRrtHndugtHknJigyohiTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
            pRrtHndugtHknJigyohiTy.setZtystdssnskbn(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
            pRrtHndugtHknJigyohiTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
            pRrtHndugtHknJigyohiTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
            pRrtHndugtHknJigyohiTy.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
            pRrtHndugtHknJigyohiTy.setZtykyksyoumetuzumihyouji(pSyoumetuHyouji);
            pRrtHndugtHknJigyohiTy.setZtytuukasyukbn(tuukasyukbn);
            pRrtHndugtHknJigyohiTy.setZtykbnkeiriyousegmentkbn(pSeg1cd.getValue().substring(0, 2));
            pRrtHndugtHknJigyohiTy.setZtykbnkeiriyourgnbnskkbn(pSeg1cd.getValue().substring(2));
            pRrtHndugtHknJigyohiTy.setZtysuurisyuruicd(suuriSyuruiCd);
            pRrtHndugtHknJigyohiTy.setZtyhosyoukinoukbn(C_HosyouKinouKbn.BLNK.getValue());
            pRrtHndugtHknJigyohiTy.setZtydaikbn(C_DaiKbn.KOJINNENKIN_SISUU.getValue());
            pRrtHndugtHknJigyohiTy.setZtytyuukbn(C_TyuuKbn.YOTEIRRT_SITEITUKANNKN.getValue());
            pRrtHndugtHknJigyohiTy.setZtysyoukbn(C_SyouKbn.YOTEIRRT_SITEITUKANNKN.getValue());
            pRrtHndugtHknJigyohiTy.setZtysedaikbn(sedaiKbn);
            pRrtHndugtHknJigyohiTy.setZtyharaikatakbn(haraikatakbn);
            pRrtHndugtHknJigyohiTy.setZtykykymd(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()));
            pRrtHndugtHknJigyohiTy.setZtyhknkkn(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn()));
            pRrtHndugtHknJigyohiTy.setZtyphrkkikn(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn()));
            pRrtHndugtHknJigyohiTy.setZtysaimnkkykhyj(saimankikykhyouji);
            pRrtHndugtHknJigyohiTy.setZtyannaifuyouriyuukbn(suuriAnnaiFuyouRiyuuKbn);
            pRrtHndugtHknJigyohiTy.setZtyhrkkaisuukbn(hrkkaisuukbn);
            pRrtHndugtHknJigyohiTy.setZtyhrkkeirokbn(hrkkeirokbn);
            pRrtHndugtHknJigyohiTy.setZtysdpdkbn(pHoyuuMeisai.getSdpdkbn().getValue());
            pRrtHndugtHknJigyohiTy.setZtyryouritukbn(ryouritukbn);
            pRrtHndugtHknJigyohiTy.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());
            pRrtHndugtHknJigyohiTy.setZtyhihokensyaagev2(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen()));
            pRrtHndugtHknJigyohiTy.setZtyhhknnentysihyj(hhknnentysihyj);
            pRrtHndugtHknJigyohiTy.setZtysyukeiyakupwaribikikbn(syukeiyakuPWaribikiKbn);
            pRrtHndugtHknJigyohiTy.setZtyalmyousohutomeisyoukbn(C_ALMSoftKbn.BLNK.getValue());
            pRrtHndugtHknJigyohiTy.setZtysnkyksoftmeisyoukbn(C_SkeiSoftKbn.TANTAI.getValue());
            pRrtHndugtHknJigyohiTy.setZtynenkinkaisinendo(nenkinKaisiNendo);
            pRrtHndugtHknJigyohiTy.setZtynenkingatakbn(nenkingataKbn);
            pRrtHndugtHknJigyohiTy.setZtynknshry(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getNenkinkkn()));
            pRrtHndugtHknJigyohiTy.setZtybosyuukeitaikbn(bosyuKeitaiKbn);
            pRrtHndugtHknJigyohiTy.setZtygaikakbn(gaikaKbn);
        }
        else {

            pRrtHndugtHknKsnJigyohiTy.setZtydatakanrino(pHoyuuMeisai.getSyono());
            pRrtHndugtHknKsnJigyohiTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
            pRrtHndugtHknKsnJigyohiTy.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            pRrtHndugtHknKsnJigyohiTy.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
            pRrtHndugtHknKsnJigyohiTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
            pRrtHndugtHknKsnJigyohiTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
            pRrtHndugtHknKsnJigyohiTy.setZtystdssnskbn(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
            pRrtHndugtHknKsnJigyohiTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
            pRrtHndugtHknKsnJigyohiTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
            pRrtHndugtHknKsnJigyohiTy.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
            pRrtHndugtHknKsnJigyohiTy.setZtykyksyoumetuzumihyouji(pSyoumetuHyouji);
            pRrtHndugtHknKsnJigyohiTy.setZtytuukasyukbn(tuukasyukbn);
            pRrtHndugtHknKsnJigyohiTy.setZtykbnkeiriyousegmentkbn(pSeg1cd.getValue().substring(0, 2));
            pRrtHndugtHknKsnJigyohiTy.setZtykbnkeiriyourgnbnskkbn(pSeg1cd.getValue().substring(2));
            pRrtHndugtHknKsnJigyohiTy.setZtysuurisyuruicd(suuriSyuruiCd);
            pRrtHndugtHknKsnJigyohiTy.setZtyhosyoukinoukbn(C_HosyouKinouKbn.BLNK.getValue());
            pRrtHndugtHknKsnJigyohiTy.setZtydaikbn(C_DaiKbn.KOJINNENKIN_SISUU.getValue());
            pRrtHndugtHknKsnJigyohiTy.setZtytyuukbn(C_TyuuKbn.YOTEIRRT_SITEITUKANNKN.getValue());
            pRrtHndugtHknKsnJigyohiTy.setZtysyoukbn(C_SyouKbn.YOTEIRRT_SITEITUKANNKN.getValue());
            pRrtHndugtHknKsnJigyohiTy.setZtysedaikbn(sedaiKbn);
            pRrtHndugtHknKsnJigyohiTy.setZtyharaikatakbn(haraikatakbn);
            pRrtHndugtHknKsnJigyohiTy.setZtykykymd(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()));
            pRrtHndugtHknKsnJigyohiTy.setZtyhknkkn(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn()));
            pRrtHndugtHknKsnJigyohiTy.setZtyphrkkikn(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn()));
            pRrtHndugtHknKsnJigyohiTy.setZtysaimnkkykhyj(saimankikykhyouji);
            pRrtHndugtHknKsnJigyohiTy.setZtyannaifuyouriyuukbn(suuriAnnaiFuyouRiyuuKbn);
            pRrtHndugtHknKsnJigyohiTy.setZtyhrkkaisuukbn(hrkkaisuukbn);
            pRrtHndugtHknKsnJigyohiTy.setZtyhrkkeirokbn(hrkkeirokbn);
            pRrtHndugtHknKsnJigyohiTy.setZtysdpdkbn(pHoyuuMeisai.getSdpdkbn().getValue());
            pRrtHndugtHknKsnJigyohiTy.setZtyryouritukbn(ryouritukbn);
            pRrtHndugtHknKsnJigyohiTy.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());
            pRrtHndugtHknKsnJigyohiTy.setZtyhihokensyaagev2(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen()));
            pRrtHndugtHknKsnJigyohiTy.setZtyhhknnentysihyj(hhknnentysihyj);
            pRrtHndugtHknKsnJigyohiTy.setZtysyukeiyakupwaribikikbn(syukeiyakuPWaribikiKbn);
            pRrtHndugtHknKsnJigyohiTy.setZtyalmyousohutomeisyoukbn(C_ALMSoftKbn.BLNK.getValue());
            pRrtHndugtHknKsnJigyohiTy.setZtysnkyksoftmeisyoukbn(C_SkeiSoftKbn.TANTAI.getValue());
            pRrtHndugtHknKsnJigyohiTy.setZtynenkinkaisinendo(nenkinKaisiNendo);
            pRrtHndugtHknKsnJigyohiTy.setZtynenkingatakbn(nenkingataKbn);
            pRrtHndugtHknKsnJigyohiTy.setZtynknshry(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getNenkinkkn()));
            pRrtHndugtHknKsnJigyohiTy.setZtybosyuukeitaikbn(bosyuKeitaiKbn);
            pRrtHndugtHknKsnJigyohiTy.setZtygaikakbn(gaikaKbn);
        }
    }

    public void editJigyouhiksnKoumoku(SrRrtHndugtHknJigyohiBatchParam pSrRrtHndugtHknJigyohiBatchParam,
        C_KessanKbn pOuttisyKbn, BizDateYM pPjytoym, Long pZennoujiikkatubaraijytgk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        List<SV_KiykSyuhnData> pKiykSyuhnDataLst, SV_HoyuuMeisai pHoyuuMeisai,
        List<IT_HokenryouTmttkn> pHokenryouTmttknLst, ZT_RrtHndugtHknJigyohiTy pRrtHndugtHknJigyohiTy,
        ZT_RrtHndugtHknKsnJigyohiTy pRrtHndugtHknKsnJigyohiTy) {

        BizDateYM keisanKijyunymfrom = null;
        BizDateYM keisanKijyunymdto = null;
        BizDate sisanKwsratekjymd = null;
        boolean nkgnsZenKeisanFlg = false;

        if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(),
            pPjytoym) == BizDateUtil.COMPARE_LESSER) {

            keisanKijyunymfrom = pPjytoym.addMonths(-SrCommonConstants.KIKAN_1M);
            keisanKijyunymdto = pPjytoym;
        }
        else {
            keisanKijyunymfrom = pPjytoym;
            keisanKijyunymdto = pPjytoym;
        }

        if (C_KessanKbn.TUUJYOU.eq(pOuttisyKbn)) {
            sisanKwsratekjymd = pPjytoym.getLastDay();
        }
        else {
            sisanKwsratekjymd = pPjytoym.getPreviousMonth().getLastDay();
            nkgnsZenKeisanFlg = true;
        }

        if (BizDateUtil.compareYmd(pSrRrtHndugtHknJigyohiBatchParam.getSyoriYmd(), sisanKwsratekjymd)
            == BizDateUtil.COMPARE_LESSER) {

            sisanKwsratekjymd = pSrRrtHndugtHknJigyohiBatchParam.getSyoriYmd();
        }

        SrTmttknBean srTmttknBeanJyuutouym = SWAKInjector.getInstance(SrTmttknBean.class);
        srTmttknBeanJyuutouym.setYoteiriritu(BizNumber.ZERO);
        srTmttknBeanJyuutouym.setYoteiIjihirituVhirei(BizNumber.ZERO);
        srTmttknBeanJyuutouym.setKiharaikomiP(BizCurrency.valueOf(0));
        srTmttknBeanJyuutouym.setvTyouseimae(BizCurrency.valueOf(0));
        srTmttknBeanJyuutouym.setZettaiSibouritu(BizNumber.ZERO);
        srTmttknBeanJyuutouym.setSoutaiSibouritu(BizNumber.ZERO);
        srTmttknBeanJyuutouym.setSoutaiKaiyakuritu(BizNumber.ZERO);
        srTmttknBeanJyuutouym.setKogakuWaribikiritu(BizNumber.ZERO);
        srTmttknBeanJyuutouym.setTmttKngk(BizCurrency.valueOf(0));
        srTmttknBeanJyuutouym.setYoteiSinkeiyakuhiritu(BizNumber.ZERO);
        srTmttknBeanJyuutouym.setYoteiIjihirituPhirei(BizNumber.ZERO);
        srTmttknBeanJyuutouym.setYoteiSyuukinhiritu(BizNumber.ZERO);

        SrTmttknBean srTmttknBeanJyuutouymzngt = SWAKInjector.getInstance(SrTmttknBean.class);
        srTmttknBeanJyuutouymzngt.setTmttKngk(BizCurrency.valueOf(0));

        SrTmttknBean srTmttknBeanNkgns = SWAKInjector.getInstance(SrTmttknBean.class);
        srTmttknBeanNkgns.setTmttKngk(BizCurrency.valueOf(0));

        SrSuuriKeisanVHeijyun srSuuriKeisanVHeijyun = SWAKInjector.getInstance(SrSuuriKeisanVHeijyun.class);

        C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(pHoyuuMeisai.getSyono() ,
            pTkJitenKeiyakuSyouhinKijyunBean, pKiykSyuhnDataLst, pHokenryouTmttknLst,
            keisanKijyunymfrom, keisanKijyunymdto, pHoyuuMeisai.getHrkkaisuu(),
            pHoyuuMeisai.getFstpnyknymd(), true, sisanKwsratekjymd, nkgnsZenKeisanFlg, false);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            String msg = MessageUtil.getMessage(MessageId.ESA1001,
                "平準払用保険料積立金",
                pHoyuuMeisai.getSyono());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrRrtHndugtHknJigyohiBatchParam, pHoyuuMeisai, msg);
        }
        else {

            List<SrTmttknBean> srTmttknBeanLst = srSuuriKeisanVHeijyun.getSrTmttknBeanList();

            for (SrTmttknBean srTmttknBean :srTmttknBeanLst) {

                if (BizDateUtil.compareYm(keisanKijyunymfrom, srTmttknBean.getTumitateYM()) == BizDateUtil.COMPARE_EQUAL) {
                    srTmttknBeanJyuutouymzngt = srTmttknBean;
                }

                if (BizDateUtil.compareYm(keisanKijyunymdto, srTmttknBean.getTumitateYM()) == BizDateUtil.COMPARE_EQUAL) {
                    srTmttknBeanJyuutouym = srTmttknBean;
                }
            }
            srTmttknBeanNkgns = srTmttknBeanLst.get(srTmttknBeanLst.size() - 1);
        }

        BizNumber pjuutoujikawaserate = srTmttknBeanJyuutouym.getKawaserate();

        BizDate pjuutoujikawasekijyunymd = null;

        if (BizDateUtil.compareYm(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), pPjytoym) == BizDateUtil.COMPARE_EQUAL) {

            pjuutoujikawasekijyunymd = pHoyuuMeisai.getFstpnyknymd().addBusinessDays(-1);
        }
        else {
            pjuutoujikawasekijyunymd =
                pPjytoym.getPreviousMonth().getLastDay().getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        }

        BizCurrency gessitumitatekin = BizCurrency.valueOf(0);

        if (BizDateUtil.compareYm(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), pPjytoym) != BizDateUtil.COMPARE_EQUAL) {

            gessitumitatekin = srTmttknBeanJyuutouymzngt.getTmttKngk();
        }

        BizNumber yoteiriritun5 = srTmttknBeanJyuutouym.getYoteiriritu();

        BizNumber tumitateriritu = srTmttknBeanJyuutouym.getYoteiriritu().subtract(srTmttknBeanJyuutouym.getYoteiIjihirituVhirei());

        KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);

        BizCurrency gaikadatetougetujuutoup = BizCurrency.valueOf(0);

        C_ErrorKbn errorKubun = keisanGaikaP.execKawaseSitei(
            pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
            srTmttknBeanJyuutouym.getKawaserate());

        if (C_ErrorKbn.ERROR.eq(errorKubun)) {
            String msg = MessageUtil.getMessage(MessageId.ESA1001,
                "外貨建当月充当Ｐ",
                pHoyuuMeisai.getSyono());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrRrtHndugtHknJigyohiBatchParam, pHoyuuMeisai, msg);
        }
        else {
            gaikadatetougetujuutoup = keisanGaikaP.getP();
        }

        BizCurrency kiharaikomip = srTmttknBeanJyuutouym.getKiharaikomiP();
        BizCurrency keisanhanteiyoutmttkn = srTmttknBeanJyuutouym.getvTyouseimae();
        BizNumber zettaisibouritu = srTmttknBeanJyuutouym.getZettaiSibouritu();
        BizNumber soutaisibouritu = srTmttknBeanJyuutouym.getSoutaiSibouritu();
        BizNumber soutaikaiyakuritu = srTmttknBeanJyuutouym.getSoutaiKaiyakuritu();
        BizNumber vhireilritu = srTmttknBeanJyuutouym.getYoteiIjihirituVhirei();
        BizNumber phireilwrbkritu = srTmttknBeanJyuutouym.getKogakuWaribikiritu();
        BizCurrency getumatutumitatekin = srTmttknBeanJyuutouym.getTmttKngk();
        BizCurrency gaikadatenkgns = srTmttknBeanNkgns.getTmttKngk();
        BizNumber phireialpha = srTmttknBeanJyuutouym.getYoteiSinkeiyakuhiritu();
        BizNumber phireibeta = srTmttknBeanJyuutouym.getYoteiIjihirituPhirei();
        BizNumber phireiganma = srTmttknBeanJyuutouym.getYoteiSyuukinhiritu();

        BizCurrency zennoujiIkktbrijyututksuk = BizCurrency.valueOf(0);

        if (pZennoujiikkatubaraijytgk != SrCommonConstants.DEFAULT_INT_ZERO){
            KeisanIkkatuPGk keisanIkkatuPGk = SWAKInjector.getInstance(KeisanIkkatuPGk.class);

            KeisanIkkatuPGkBean keisanIkkatuPGkBean = SWAKInjector.getInstance(KeisanIkkatuPGkBean.class);

            keisanIkkatuPGkBean.setSyouhnCd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

            keisanIkkatuPGkBean.setSyouhnsdNo(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());

            keisanIkkatuPGkBean.setRyouritusdNo(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

            keisanIkkatuPGkBean.setYoteiRiritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());

            keisanIkkatuPGkBean.setHokenryou(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou());

            keisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);

            keisanIkkatuPGkBean.setKeikamon(SrCommonConstants.KIKAN_12M);

            keisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

            keisanIkkatuPGkBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

            keisanIkkatuPGkBean.setHhknsei(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei());

            keisanIkkatuPGkBean.setHknkknsmnKbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());

            keisanIkkatuPGkBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());

            keisanIkkatuPGkBean.setHrkkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn());

            keisanIkkatuPGkBean.setHokenkngk(pTkJitenKeiyakuSyouhinKijyunBean.getKihons());

            keisanIkkatuPGkBean.setKykTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            keisanIkkatuPGkBean.setKykjyoutai(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai());

            keisanIkkatuPGkBean.setDai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn());

            keisanIkkatuPGkBean.setHrkkeiro(hrkkeiro);

            errorKbn = keisanIkkatuPGk.exec(keisanIkkatuPGkBean, false);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "前納時一括払充当額",
                    pHoyuuMeisai.getSyono());

                batchLogger.warn(msg);

                createSuuriyouErrJyouhou(pSrRrtHndugtHknJigyohiBatchParam, pHoyuuMeisai, msg);
            }
            else {
                zennoujiIkktbrijyututksuk = keisanIkkatuPGk.getIkkatuP();
            }
        }
        else {

            zennoujiIkktbrijyututksuk = BizCurrency.valueOf(pZennoujiikkatubaraijytgk);

        }

        BizDate kykJikawaseratetkyuYmd = null;
        BizNumber kykjikwsrate = BizNumber.valueOf(0);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.BLNK;
        C_KawasetsryKbn cawasetsryKbn = C_KawasetsryKbn.BLNK;

        SrRrtHndugtHknJigyohiBatchDbAccess srRrtHndugtHknJigyohiBatchDbAccess = SWAKInjector
            .getInstance(SrRrtHndugtHknJigyohiBatchDbAccess.class);
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        IT_NyknJissekiRireki nyknJissekiRireki = srRrtHndugtHknJigyohiBatchDbAccess.getNyknJissekiRireki3(
            pHoyuuMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), 1);

        if (C_Tuukasyu.JPY.eq(nyknJissekiRireki.getRstuukasyu())) {

            kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;

            cawasetsryKbn = C_KawasetsryKbn.NYUKINRATE;
        }

        BizDate kwsratekjymd = nyknJissekiRireki.getRyosyuymd().addBusinessDays(-1);

        errorKbn = getKawaseRate.exec(kwsratekjymd, kawaserateSyuruiKbn,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, cawasetsryKbn,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1004,
                String.valueOf(kwsratekjymd), kawaserateSyuruiKbn.getValue(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(), C_Tuukasyu.JPY.getValue(),
                C_KawasetekiyoKbn.TTM.getValue(), cawasetsryKbn.getValue(), C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                C_YouhiKbn.HUYOU.getValue());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrRrtHndugtHknJigyohiBatchParam, pHoyuuMeisai, msg);
        }
        else {

            kykJikawaseratetkyuYmd = getKawaseRate.getKwsrateKjYmd();

            kykjikwsrate = getKawaseRate.getKawaserate();
        }

        if (C_KessanKbn.TUUJYOU.eq(pOuttisyKbn)) {

            pRrtHndugtHknJigyohiTy.setZtysyukeiyakup(new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou()
                .toAdsoluteString()).longValue());
            pRrtHndugtHknJigyohiTy.setZtypjuutoujikawaserate(pjuutoujikawaserate);
            pRrtHndugtHknJigyohiTy.setZtypjuutoujikawasekijyunymd(String.valueOf(pjuutoujikawasekijyunymd));
            pRrtHndugtHknJigyohiTy.setZtygessitumitatekin(new BigDecimal(gessitumitatekin.toAdsoluteString())
            .longValue());
            pRrtHndugtHknJigyohiTy.setZtyyoteiriritun5(yoteiriritun5);
            pRrtHndugtHknJigyohiTy.setZtytumitateriritu(tumitateriritu);
            pRrtHndugtHknJigyohiTy.setZtygaikadatetougetujuutoup(new BigDecimal(gaikadatetougetujuutoup
                .toAdsoluteString()).longValue());
            pRrtHndugtHknJigyohiTy.setZtykiharaikomip(new BigDecimal(kiharaikomip.toAdsoluteString()).longValue());
            pRrtHndugtHknJigyohiTy.setZtykeisanhanteiyoutmttkn(new BigDecimal(keisanhanteiyoutmttkn.toAdsoluteString())
            .longValue());
            pRrtHndugtHknJigyohiTy.setZtyzettaisibouritu(zettaisibouritu);
            pRrtHndugtHknJigyohiTy.setZtysoutaisibouritu(soutaisibouritu);
            pRrtHndugtHknJigyohiTy.setZtysoutaikaiyakuritu(soutaikaiyakuritu);
            pRrtHndugtHknJigyohiTy.setZtyvhireilritu(vhireilritu);
            pRrtHndugtHknJigyohiTy.setZtyphireilwrbkritu(phireilwrbkritu);
            pRrtHndugtHknJigyohiTy.setZtygetumatutumitatekin(new BigDecimal(getumatutumitatekin.toAdsoluteString())
            .longValue());
            pRrtHndugtHknJigyohiTy.setZtyzennoujiikkatubaraijytgk(new BigDecimal(zennoujiIkktbrijyututksuk.
                toAdsoluteString()).longValue());
            pRrtHndugtHknJigyohiTy.setZtygaikadatenkgns(new BigDecimal(gaikadatenkgns.toAdsoluteString()).longValue());
            pRrtHndugtHknJigyohiTy.setZtyphireialpha(phireialpha);
            pRrtHndugtHknJigyohiTy.setZtyphireibeta(phireibeta);
            pRrtHndugtHknJigyohiTy.setZtyphireiganma(phireiganma);
            pRrtHndugtHknJigyohiTy.setZtykykjikawaserate(kykjikwsrate);
            pRrtHndugtHknJigyohiTy.setZtykykjikawaseratetkyuymd(String.valueOf(kykJikawaseratetkyuYmd));
        }
        else {
            pRrtHndugtHknKsnJigyohiTy.setZtysyukeiyakup(new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou()
                .toAdsoluteString()).longValue());
            pRrtHndugtHknKsnJigyohiTy.setZtypjuutoujikawaserate(pjuutoujikawaserate);
            pRrtHndugtHknKsnJigyohiTy.setZtypjuutoujikawasekijyunymd(String.valueOf(pjuutoujikawasekijyunymd));
            pRrtHndugtHknKsnJigyohiTy.setZtygessitumitatekin(new BigDecimal(gessitumitatekin.toAdsoluteString())
            .longValue());
            pRrtHndugtHknKsnJigyohiTy.setZtyyoteiriritun5(yoteiriritun5);
            pRrtHndugtHknKsnJigyohiTy.setZtytumitateriritu(tumitateriritu);
            pRrtHndugtHknKsnJigyohiTy.setZtygaikadatetougetujuutoup(new BigDecimal(gaikadatetougetujuutoup
                .toAdsoluteString()).longValue());
            pRrtHndugtHknKsnJigyohiTy.setZtykiharaikomip(new BigDecimal(kiharaikomip.toAdsoluteString()).longValue());
            pRrtHndugtHknKsnJigyohiTy.setZtykeisanhanteiyoutmttkn(new BigDecimal(keisanhanteiyoutmttkn
                .toAdsoluteString()).longValue());
            pRrtHndugtHknKsnJigyohiTy.setZtyzettaisibouritu(zettaisibouritu);
            pRrtHndugtHknKsnJigyohiTy.setZtysoutaisibouritu(soutaisibouritu);
            pRrtHndugtHknKsnJigyohiTy.setZtysoutaikaiyakuritu(soutaikaiyakuritu);
            pRrtHndugtHknKsnJigyohiTy.setZtyvhireilritu(vhireilritu);
            pRrtHndugtHknKsnJigyohiTy.setZtyphireilwrbkritu(phireilwrbkritu);
            pRrtHndugtHknKsnJigyohiTy.setZtygetumatutumitatekin(new BigDecimal(getumatutumitatekin.toAdsoluteString())
            .longValue());
            pRrtHndugtHknKsnJigyohiTy.setZtyzennoujiikkatubaraijytgk(new BigDecimal(zennoujiIkktbrijyututksuk.
                toAdsoluteString()).longValue());
            pRrtHndugtHknKsnJigyohiTy.setZtygaikadatenkgns(new BigDecimal(gaikadatenkgns.toAdsoluteString())
            .longValue());
            pRrtHndugtHknKsnJigyohiTy.setZtyphireialpha(phireialpha);
            pRrtHndugtHknKsnJigyohiTy.setZtyphireibeta(phireibeta);
            pRrtHndugtHknKsnJigyohiTy.setZtyphireiganma(phireiganma);
            pRrtHndugtHknKsnJigyohiTy.setZtykykjikawaserate(kykjikwsrate);
            pRrtHndugtHknKsnJigyohiTy.setZtykykjikawaseratetkyuymd(String.valueOf(kykJikawaseratetkyuYmd));
        }
    }

    private void createSuuriyouErrJyouhou(SrRrtHndugtHknJigyohiBatchParam pSrRrtHndugtHknJigyohiBatchParam,
        SV_HoyuuMeisai pSvHoyuuMeisai, String msg) {

        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

        suuriyouErrJyouhou.setSyoriYmd(pSrRrtHndugtHknJigyohiBatchParam.getSyoriYmd());
        suuriyouErrJyouhou.setKakutyoujobcd(pSrRrtHndugtHknJigyohiBatchParam.getIbKakutyoujobcd());
        suuriyouErrJyouhou.setSyono(pSvHoyuuMeisai.getSyono());
        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

        pSrRrtHndugtHknJigyohiBatchParam.setZokkouerrsyoriKensuu(pSrRrtHndugtHknJigyohiBatchParam
            .getZokkouerrsyoriKensuu() + 1);
        errorFlag = true;
    }
}
