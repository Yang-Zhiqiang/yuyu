package yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SetErrMessageInfoBean;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfoBean;
import yuyu.common.suuri.srcommon.SrSuuriGouseiRateKeisan;
import yuyu.common.suuri.srcommon.SrSuuriGouseiRateKeisanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriAnnaiFuyouRiyuuKbn;
import yuyu.def.classification.C_SuuriRyourituKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_GkknHnkuSyrSynypTukiTy;
import yuyu.def.suuri.configuration.YuyuSuuriConfig;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 数理 数理統計 月間変更処理収入Ｐ統計情報作成の項目編集クラス
 */
public class SrGkknHnkuSyrSyunyupTukiItemEditor {

    private static final String RENDOUKBN_RYOKINHOZEN = "1";

    private static final String JYUTOUKAISU_ITIJIBARAI = "0000";

    private static final String SYUNOUKBN_ITIJIBARAI = "001";

    private static final String SINNYUKINKBN_IPPAN = "10";

    private static final String TENKANMINAOSIKBN_SONOTA = "0";

    private static final String TOKUJYOUKBN_SAKUGENIGAI = "0";

    private static final String DAINITOKUJYOUKBN_SAKUGENIGAI = "0";

    private static final String SYORICD = "RGIX";

    private static final String KYKJIYOTEIRIRITU = "契約時予定利率";

    private static final String SYUNOUKBN_INIT = "000";

    private boolean errorFlag;

    private C_Hrkkeiro hrkkeiro;

    private C_Hrkkaisuu hrkkaisuu;

    @Inject
    private BatchLogger batchLogger;

    public SrGkknHnkuSyrSyunyupTukiItemEditor() {
        super();
        errorFlag = false;
    }

    public boolean editKoumokuItijibr(SrGkknHnkuSyrSyunyupTukiBatchParam pSrGkknHnkuSyrSyunyupTukiBatchParam,
        BT_DenpyoData pDenpyoData, IT_KhShrRireki pKhShrRireki, IT_KhTtdkRireki pKhTtdkRireki,
        IT_NyknJissekiRireki pNyknJissekiRireki, IT_KykDairiten pKykDairiten, IT_KykSonotaTkyk pKykSonotaTkyk,
        IT_KykSya pKykSya, IT_KykKihon pKykKihon, TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_GkknHnkuSyrSynypTukiTy pGkknHnkuSyrSynypTukiTy, int pSyouhin,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn) {

        SrGkknHnkuSyrSyunyupTukiDbaStatement srGkknHnkuSyrSyunyupTukiDbaStatement =
            SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDbaStatement.class);

        BM_SyouhnZokusei syouhnZokusei = srGkknHnkuSyrSyunyupTukiDbaStatement.getSyouhnZokusei(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());


        editToukeiDataItijibr(
            pSrGkknHnkuSyrSyunyupTukiBatchParam,
            pDenpyoData,
            pKhShrRireki,
            pKhTtdkRireki,
            pKykDairiten,
            pKykSya,
            pKykKihon,
            pTkJitenKeiyakuSyouhinKijyunBean,
            syouhnZokusei,
            pGkknHnkuSyrSynypTukiTy,
            pSyouhin
            );

        editRayDataItijibr(
            pSrGkknHnkuSyrSyunyupTukiBatchParam,
            pNyknJissekiRireki,
            pKykSonotaTkyk,
            pKykKihon,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pGkknHnkuSyrSynypTukiTy,
            pSyouhin,
            pKhSisuurendoTmttkn
            );

        editHeaderData(
            pSrGkknHnkuSyrSyunyupTukiBatchParam,
            pGkknHnkuSyrSynypTukiTy
            );

        return errorFlag;

    }

    public boolean editKoumokuHeijyun(SrGkknHnkuSyrSyunyupTukiBatchParam pSrGkknHnkuSyrSyunyupTukiBatchParam,
        BT_DenpyoData pDenpyoData, IT_NyknJissekiRireki pNyknJissekiRirekiznnjyuutou,
        IT_NyknJissekiRireki pNyknJissekiRireki, IT_KykDairiten pKykDairiten,
        IT_KykSonotaTkyk pKykSonotaTkyk, IT_KykSya pKykSya, IT_KykKihon pKykKihon,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_GkknHnkuSyrSynypTukiTy pGkknHnkuSyrSynypTukiTy, ST_SynypTukiTugtTykiyuHozon pSynypTukiTugtTykiyuHozon,
        int pSyouhin, BizCurrency pSyonendosyokaip, BizCurrency pSyonendo2kaimeikoup, BizCurrency pJinendoikoup,
        BizDateYM pJyutouym, String pJyuutoukaisuu,String pBusitucd,String pSyoricd,int pSynypinfo,
        int pToukipzennoupRecordkbn,List<SV_KiykSyuhnData> pSvkiykSyuhnDataList,BizCurrency pZennoujiHrkp,
        BizNumber pNyknjikwsRate,BizDate pNyknjikwsRateTkyymd,Boolean pNyknjikwsRateHtnFlg) {

        SrGkknHnkuSyrSyunyupTukiDbaStatement srGkknHnkuSyrSyunyupTukiDbaStatement =
            SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDbaStatement.class);

        BM_SyouhnZokusei syouhnZokusei = srGkknHnkuSyrSyunyupTukiDbaStatement.getSyouhnZokusei(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());

        BizDate keiyakuKihonjymd = null;
        hrkkeiro = C_Hrkkeiro.BLNK;
        hrkkaisuu = C_Hrkkaisuu.BLNK;

        keiyakuKihonjymd = BizDate.valueOf(pJyutouym, pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();

        SrGetTokutejitenKykKihonInfo srGetTokutejitenSyohnInfo = SWAKInjector.getInstance(SrGetTokutejitenKykKihonInfo.class);

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenSyohnInfo.exec(
            C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN,
            pKykKihon.getSyono(), keiyakuKihonjymd, null, pSvkiykSyuhnDataList, null,
            pKykKihon.getHrkkeiro(),pKykKihon.getHrkkaisuu());

        hrkkeiro = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
        hrkkaisuu = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();


        editToukeiDataHeijyun(
            pSrGkknHnkuSyrSyunyupTukiBatchParam,
            pDenpyoData,
            pNyknJissekiRirekiznnjyuutou,
            pKykDairiten,
            pKykSya,
            pKykKihon,
            pTkJitenKeiyakuSyouhinKijyunBean,
            syouhnZokusei,
            pGkknHnkuSyrSynypTukiTy,
            pSynypTukiTugtTykiyuHozon,
            pSyouhin,
            pSyonendosyokaip,
            pSyonendo2kaimeikoup,
            pJinendoikoup,
            pJyutouym,
            pJyuutoukaisuu,
            pBusitucd,
            pSynypinfo,
            pToukipzennoupRecordkbn
            );

        editRayDataHeijyun(
            pSrGkknHnkuSyrSyunyupTukiBatchParam,
            pNyknJissekiRireki,
            pKykSonotaTkyk,
            pKykKihon,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pGkknHnkuSyrSynypTukiTy,
            pSynypTukiTugtTykiyuHozon,
            pSyouhin,
            pSynypinfo,
            pToukipzennoupRecordkbn,
            pZennoujiHrkp,
            pNyknjikwsRate,
            pNyknjikwsRateTkyymd,
            pNyknjikwsRateHtnFlg
            );

        editHeaderData(
            pSrGkknHnkuSyrSyunyupTukiBatchParam,
            pGkknHnkuSyrSynypTukiTy
            );

        if (pSyouhin == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyouhin == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU ||
                (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU &&
                pToukipzennoupRecordkbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP)) {

                editSynypTukiTugtTykiyuHozonData(pSrGkknHnkuSyrSyunyupTukiBatchParam, pDenpyoData,
                    pNyknJissekiRirekiznnjyuutou, pSynypTukiTugtTykiyuHozon, pSyoricd, pSynypinfo);
            }
        }

        return errorFlag;

    }

    private void editToukeiDataItijibr(SrGkknHnkuSyrSyunyupTukiBatchParam pSrGkknHnkuSyrSyunyupTukiBatchParam,
        BT_DenpyoData pDenpyoData, IT_KhShrRireki pKhShrRireki, IT_KhTtdkRireki pKhTtdkRireki,
        IT_KykDairiten pKykDairiten, IT_KykSya pKykSya, IT_KykKihon pKykKihon,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,BM_SyouhnZokusei pSyouhnZokusei,
        ZT_GkknHnkuSyrSynypTukiTy pGkknHnkuSyrSynypTukiTy, int pSyouhin) {

        BizCurrency syoNendoSyokaiP = BizCurrency.valueOf(0);
        String haitouKbn = "";
        String hhknsyNenreiTys = "";
        String kyksyaNenreiTys = "";
        String sykykSyrCode = "";
        String bosyuKeitaiKbn = "";
        BizCurrency kihons = BizCurrency.valueOf(0);
        String saimnkkykhyj = "";


        if (pDenpyoData.getTaisyakukbn().eq(C_TaisyakuKbn.KARIKATA)) {
            BizCurrency denyenkagk = pDenpyoData.getDenyenkagk();
            syoNendoSyokaiP = denyenkagk.multiply(-1);
        }
        else {
            syoNendoSyokaiP = pDenpyoData.getDenyenkagk();
        }


        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_HAITOU,
            pSyouhnZokusei.getHaitoukbn().getValue()
            );

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_HAITOU.getContent(),
                pKykKihon.getSyono(),
                pSyouhnZokusei.getHaitoukbn().getValue()
                );

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            haitouKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);
        int hhknsyHokenNenrei = setHokenNenrei.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHhknseiymd());

        if (pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().intValue() != hhknsyHokenNenrei) {
            hhknsyNenreiTys = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            hhknsyNenreiTys = SrCommonConstants.HYOUJI_NASI;
        }


        int kyksyaHokenNenrei = setHokenNenrei.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pKykSya.getKykseiymd());

        SetNenrei SetNenrei = SWAKInjector.getInstance(SetNenrei.class);
        int kyknen = SetNenrei.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pKykSya.getKykseiymd());

        if (kyksyaHokenNenrei != kyknen) {
            kyksyaNenreiTys = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            kyksyaNenreiTys = SrCommonConstants.HYOUJI_NASI;
        }

        int kykSynTyouseigo;
        if (kyknen > 99) {
            kykSynTyouseigo = 0;
        }
        else {
            kykSynTyouseigo = kyknen;
        }



        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(
            C_SrKbnHenkanKbn.SYOKEIYAKU,
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
            );

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage =MessageUtil.getMessage(MessageId.ESA1006,
                C_SrKbnHenkanKbn.SYOKEIYAKU.getContent(),
                pKykKihon.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
                );

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            sykykSyrCode = Strings.padStart(srSuuriKbnHenkanBean.getHenkanAtoKbn(), 3, '0');
        }


        String atsksySskCode = pKykDairiten.getDrtenkanrisosikicd();
        String atsksyKjnCode = pKykDairiten.getDaibosyuucd();

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.BOSYU_KEITAI,
            pKykDairiten.getDrtencd()
            );

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage =MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                pKykKihon.getSyono(),
                pKykDairiten.getDrtencd()
                );

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            bosyuKeitaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == pSyouhin ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == pSyouhin) {
            kihons = BizCurrency.valueOf(0);
        }
        else {
            kihons = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
        }


        if (C_HknkknsmnKbn.SAIMANKI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn())) {
            saimnkkykhyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            saimnkkykhyj = SrCommonConstants.HYOUJI_NASI;
        }

        C_Segcd segcd = C_Segcd.BLNK;
        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu()
            );

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1007,
                SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD,
                pTkJitenKeiyakuSyouhinKijyunBean.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
                );

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pTkJitenKeiyakuSyouhinKijyunBean.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            segcd = syouhinbetuSegmentBean.getSegcd1();
        }



        pGkknHnkuSyrSynypTukiTy.setZtydatakanrino(pKykKihon.getSyono());
        pGkknHnkuSyrSynypTukiTy.setZtysyoricd(SYORICD);
        pGkknHnkuSyrSynypTukiTy.setZtyrendoukbn(RENDOUKBN_RYOKINHOZEN);
        pGkknHnkuSyrSynypTukiTy.setZtysyuunoukeirokbn(SrCommonConstants.SYUUNOUKEIROKBN_SONOTA);
        String syoriSosikicd =  pKhTtdkRireki.getSyorisosikicd();
        if ((syoriSosikicd != null) && (syoriSosikicd.length() > 2)) {
            syoriSosikicd = syoriSosikicd.substring(0, 3);
        }
        pGkknHnkuSyrSynypTukiTy.setZtysuitousisya(syoriSosikicd);
        BizDate shrYmd = pKhShrRireki.getShrymd();
        if (shrYmd != null) {
            pGkknHnkuSyrSynypTukiTy.setZtysyuukinym(shrYmd.getBizDateYM().toString());
        }
        BizDate kykymd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
        if (kykymd != null) {
            pGkknHnkuSyrSynypTukiTy.setZtyjyuutouym(kykymd.getBizDateYM().toString());
        }
        pGkknHnkuSyrSynypTukiTy.setZtyjyuutoukaisuu(JYUTOUKAISU_ITIJIBARAI);
        pGkknHnkuSyrSynypTukiTy.setZtyzennoukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pGkknHnkuSyrSynypTukiTy.setZtyrecordkbn(pDenpyoData.getTaisyakukbn().getValue());
        pGkknHnkuSyrSynypTukiTy.setZtyhaitoukbn(haitouKbn);
        if (shrYmd != null) {
            pGkknHnkuSyrSynypTukiTy.setZtydenymd(shrYmd.toString());
        }
        pGkknHnkuSyrSynypTukiTy.setZtysyonendosyokaip(new BigDecimal(syoNendoSyokaiP.toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        pGkknHnkuSyrSynypTukiTy.setZtysaimnkkykhyj(saimnkkykhyj);
        pGkknHnkuSyrSynypTukiTy.setZtyhknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().toString());
        pGkknHnkuSyrSynypTukiTy.setZtyphrkkikn(SrCommonConstants.PHARAIKOMIKIKAN_ITIJIBARAI);
        pGkknHnkuSyrSynypTukiTy.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pGkknHnkuSyrSynypTukiTy.setZtykyksyanen(Integer.toString(kykSynTyouseigo));
        if (kykymd!=null)  {
            pGkknHnkuSyrSynypTukiTy.setZtykykymd(kykymd.toString());
        }
        pGkknHnkuSyrSynypTukiTy.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());
        pGkknHnkuSyrSynypTukiTy.setZtyannaifuyouriyuukbn(SrCommonConstants.ANNAIFUYOURIYUUKBN_ITIJIBARAI);
        pGkknHnkuSyrSynypTukiTy.setZtyhrkkaisuukbn(SrCommonConstants.HRKKAISUUKBN_ITIJIBARAI);
        pGkknHnkuSyrSynypTukiTy.setZtysdpdkbn(pKykKihon.getSdpdkbn().getValue());
        pGkknHnkuSyrSynypTukiTy.setZtyryouritukbn(SrCommonConstants.RYOURITUKBN_HUTUUITIJIBARAI);
        pGkknHnkuSyrSynypTukiTy.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
        pGkknHnkuSyrSynypTukiTy.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
        pGkknHnkuSyrSynypTukiTy.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
        pGkknHnkuSyrSynypTukiTy.setZtykihons(new BigDecimal(kihons.toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtyaatukaisosikicd(atsksySskCode);
        pGkknHnkuSyrSynypTukiTy.setZtyaatukaikojincd(atsksyKjnCode);
        pGkknHnkuSyrSynypTukiTy.setZtybsyym(pKykKihon.getBosyuuym().toString());
        pGkknHnkuSyrSynypTukiTy.setZtyharaikomip(new BigDecimal(pKykKihon.getHrkp().toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtysyukeiyakup(new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtysyuunoukbn(SYUNOUKBN_ITIJIBARAI);
        pGkknHnkuSyrSynypTukiTy.setZtytkykkumkhnsyukosuu(SrCommonConstants.DEFAULT_INT_ZERO);
        pGkknHnkuSyrSynypTukiTy.setZtysinnyuukinkbn(SINNYUKINKBN_IPPAN);
        pGkknHnkuSyrSynypTukiTy.setZtykbnkeiriyousegmentcd(segcd.getValue());
        pGkknHnkuSyrSynypTukiTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pGkknHnkuSyrSynypTukiTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
        pGkknHnkuSyrSynypTukiTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
        pGkknHnkuSyrSynypTukiTy.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
        pGkknHnkuSyrSynypTukiTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pGkknHnkuSyrSynypTukiTy.setZtytokubetuhosyoukikan(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pGkknHnkuSyrSynypTukiTy.setZtytenkanminaosikbn(TENKANMINAOSIKBN_SONOTA);
        pGkknHnkuSyrSynypTukiTy.setZtyhhknnentysihyj(hhknsyNenreiTys);
        pGkknHnkuSyrSynypTukiTy.setZtykyksyaagetyouseihyj(kyksyaNenreiTys);
        pGkknHnkuSyrSynypTukiTy.setZtysykykhokenhoutekiyouhyj(SrCommonConstants.HYOUJI_ARI);
        pGkknHnkuSyrSynypTukiTy.setZtytkjykbn(TOKUJYOUKBN_SAKUGENIGAI);
        pGkknHnkuSyrSynypTukiTy.setZtydai2tokujyoukbn(DAINITOKUJYOUKBN_SAKUGENIGAI);
        pGkknHnkuSyrSynypTukiTy.setZtybosyuukeitaikbn(bosyuKeitaiKbn);
        pGkknHnkuSyrSynypTukiTy.setZtysyukeiyakusyuruicdv3(sykykSyrCode);

        pGkknHnkuSyrSynypTukiTy.setZtysetrenseimrtikatakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pGkknHnkuSyrSynypTukiTy.setZtysetkaigomaruteikatakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
    }

    private void editRayDataItijibr(SrGkknHnkuSyrSyunyupTukiBatchParam pSrGkknHnkuSyrSyunyupTukiBatchParam,
        IT_NyknJissekiRireki pNyknJissekiRireki,IT_KykSonotaTkyk pKykSonotaTkyk,
        IT_KykKihon pKykKihon, TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_GkknHnkuSyrSynypTukiTy pGkknHnkuSyrSynypTukiTy,int pSyouhin,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn) {


        String gaikaKbn = "";

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
            );

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pKykKihon.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
                );

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            gaikaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        BizNumber kykjiKawaserate = BizNumber.ZERO;

        BizDate kykjiKawaserateYmd = null;

        BizNumber crossRate = BizNumber.ZERO;

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.BLNK;

        C_KawasetsryKbn kawasetsrykbn = C_KawasetsryKbn.BLNK;


        if (C_Tuukasyu.JPY.eq(pNyknJissekiRireki.getRstuukasyu())) {

            kawaserateSyuruiKbn =  C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
            kawasetsrykbn = C_KawasetsryKbn.NYUKINRATE;
        }
        else {

            kawaserateSyuruiKbn =  C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
            kawasetsrykbn = C_KawasetsryKbn.JISSEIRATE;
        }

        C_ErrorKbn errorKbn = getKawaseRate.exec(
            pNyknJissekiRireki.getRyosyuymd(),
            kawaserateSyuruiKbn,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            kawasetsrykbn,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            String errMessage = MessageUtil.getMessage(
                MessageId.ESA1004,
                pNyknJissekiRireki.getRyosyuymd().toString(),
                kawaserateSyuruiKbn.getValue(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                C_Tuukasyu.JPY.getValue(),
                C_KawasetekiyoKbn.TTM.getValue(),
                kawasetsrykbn.getValue(),
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                C_YouhiKbn.HUYOU.getValue());

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            kykjiKawaserate = getKawaseRate.getKawaserate();
            kykjiKawaserateYmd = getKawaseRate.getKwsrateKjYmd();
        }


        if (!pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().eq(pNyknJissekiRireki.getRstuukasyu())
            &&
            (C_Tuukasyu.AUD.eq(pNyknJissekiRireki.getRstuukasyu()) || C_Tuukasyu.USD.eq(pNyknJissekiRireki
                .getRstuukasyu()))) {


            errorKbn = getKawaseRate.exec(
                pNyknJissekiRireki.getRyosyuymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                pNyknJissekiRireki.getRstuukasyu(),
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.NYUKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String errMessage = MessageUtil.getMessage(
                    MessageId.ESA1004,
                    pNyknJissekiRireki.getRyosyuymd().toString(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE.getValue(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                    pNyknJissekiRireki.getRstuukasyu().getValue(),
                    C_KawasetekiyoKbn.TTM.getValue(),
                    C_KawasetsryKbn.NYUKINRATE.getValue(),
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                    C_YouhiKbn.HUYOU.getValue());

                batchLogger.warn(errMessage);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                    pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

                errorFlag = true;
            }
            else {
                crossRate = getKawaseRate.getKawaserate();
            }


            SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);

            SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean = srSuuriGouseiRateKeisan.exec(
                pNyknJissekiRireki.getRyosyuymd(),
                pNyknJissekiRireki.getRstuukasyu(),
                crossRate
                );
            SetErrMessageInfoBean errMessageInfoBean = srSuuriGouseiRateKeisanBean.getErrMessageInfoBean();

            if (C_ErrorKbn.ERROR.eq(srSuuriGouseiRateKeisanBean.getErrorKbn())) {

                String errMessage = MessageUtil.getMessage(
                    MessageId.ESA1004,
                    errMessageInfoBean == null ? "" : errMessageInfoBean.getKwsrateKjYmd().toString(),
                        errMessageInfoBean == null ? "" : errMessageInfoBean.getKawaserateSyuruiKbn().getValue(),
                            errMessageInfoBean == null ? "" : errMessageInfoBean.getMotoTuukasyu().getValue(),
                                errMessageInfoBean == null ? "" : errMessageInfoBean.getKansanTuukasyu().getValue(),
                                    errMessageInfoBean == null ? "" : errMessageInfoBean.getKawasetekiyoKbn().getValue(),
                                        errMessageInfoBean == null ? "" : errMessageInfoBean.getKawasetsryKbn().getValue(),
                                            errMessageInfoBean == null ? "" : errMessageInfoBean.getEigyoubiHoseiKbn().getValue(),
                                                errMessageInfoBean == null ? "" : errMessageInfoBean.getYouhiKbn().getValue()
                                                    + "：合成レート"
                    );

                batchLogger.warn(errMessage);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                    pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

                errorFlag = true;
            }
            else {
                kykjiKawaserate = srSuuriGouseiRateKeisanBean.getSuuriGouseiRate();
            }

        }


        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        BizCurrency yenkasbjiSaiteiHsygk = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));

        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

            yenkasbjiSaiteiHsygk = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        }


        String nyknTskkbn = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA,
            pNyknJissekiRireki.getRstuukasyu().getValue()
            );

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA.getContent(),
                pKykKihon.getSyono(),
                pNyknJissekiRireki.getRstuukasyu().getValue()
                );

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            nyknTskkbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        BizNumber sisuurendouRate = BizNumber.valueOf(0);

        if (pSyouhin == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhin == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (C_TmttknhaibunjyoutaiKbn.BLNK.eq(pTkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())
                || C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {

                sisuurendouRate = BizNumber.valueOf(0);
            }
            else {

                sisuurendouRate = pTkJitenKeiyakuSyouhinKijyunBean.getKykjisisuurendourate();
            }
        }
        else {
            sisuurendouRate = BizNumber.valueOf(0);
        }

        String sisuukbn = "";
        if (pSyouhin == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhin == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {

                sisuukbn = C_Sisuukbn.BLNK.getValue();
            }
            else {
                sisuukbn = pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn().getValue();

            }

            srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
                C_SrKbnHenkanKbn.SUURI_SISUU,
                sisuukbn
                );

            if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                String errMessage = MessageUtil.getMessage(MessageId.ESA1002,
                    C_SrKbnHenkanKbn.SUURI_SISUU.getContent(),
                    pKykKihon.getSyono(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn().getValue()
                    );

                batchLogger.warn(errMessage);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                    pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

                errorFlag = true;
            }
            else {
                sisuukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
            }
        }
        else {

            sisuukbn = "";
        }


        String tuukasyukbn = "";
        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.TUUKA_SYU,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
            );

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA.getContent(),
                pKykKihon.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
                );

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            tuukasyukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        BizCurrency nkGns = BizCurrency.valueOf(0);

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == pSyouhin ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == pSyouhin) {

            KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd = SWAKInjector
                .getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

            errorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                pKykSonotaTkyk.getTeikishrtkykhukaumu(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getBizDateYM(),
                pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String errMessage = MessageUtil.getMessage(
                    MessageId.ESA1001,
                    "年金原資",
                    pKykKihon.getSyono());

                batchLogger.warn(errMessage);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                    pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

                errorFlag = true;
            }
            else {

                nkGns = keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei();
            }
        }
        else {
            nkGns = BizCurrency.valueOf(0);
        }


        BizCurrency sisuuBbnTounyuuGk = BizCurrency.valueOf(0);

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == pSyouhin ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == pSyouhin) {

            sisuuBbnTounyuuGk = pKhSisuurendoTmttkn.getSisuurendoutmttkngk();
        }
        else {

            sisuuBbnTounyuuGk = BizCurrency.valueOf(0);
        }



        pGkknHnkuSyrSynypTukiTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pGkknHnkuSyrSynypTukiTy.setZtygaikakbn(gaikaKbn);
        pGkknHnkuSyrSynypTukiTy.setZtykykjikawaserate(kykjiKawaserate);
        if (kykjiKawaserateYmd != null) {
            pGkknHnkuSyrSynypTukiTy.setZtykykjikawaseratetkyuymd(kykjiKawaserateYmd.toString());
        }
        pGkknHnkuSyrSynypTukiTy.setZtykeiyakujiyoteiriritu(
            pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());
        pGkknHnkuSyrSynypTukiTy.setZtyenkdtsbujsitihsyukngk(new BigDecimal(yenkasbjiSaiteiHsygk.toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtynyuukintuukakbn(nyknTskkbn);
        pGkknHnkuSyrSynypTukiTy.setZtysisuurendourate(sisuurendouRate.toString());
        pGkknHnkuSyrSynypTukiTy.setZtysisuukbn(sisuukbn);
        pGkknHnkuSyrSynypTukiTy.setZtysrdai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn().toString());
        pGkknHnkuSyrSynypTukiTy.setZtytuukasyukbn(tuukasyukbn);
        pGkknHnkuSyrSynypTukiTy.setZtynkgns(new BigDecimal(nkGns.toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtysisuubbntounyuugk(
            new BigDecimal(sisuuBbnTounyuuGk.toAdsoluteString()).longValue());
    }

    private void editToukeiDataHeijyun(SrGkknHnkuSyrSyunyupTukiBatchParam pSrGkknHnkuSyrSyunyupTukiBatchParam,
        BT_DenpyoData pDenpyoData, IT_NyknJissekiRireki pNyknJissekiRireki, IT_KykDairiten pKykDairiten,
        IT_KykSya pKykSya, IT_KykKihon pKykKihon,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean, BM_SyouhnZokusei pSyouhnZokusei,
        ZT_GkknHnkuSyrSynypTukiTy pGkknHnkuSyrSynypTukiTy,
        ST_SynypTukiTugtTykiyuHozon pSynypTukiTugtTykiyuHozon, int pSyouhin,
        BizCurrency pSyonendosyokaip, BizCurrency pSyonendo2kaimeikoup, BizCurrency pJinendoikoup,
        BizDateYM pJyutouym, String pJyuutoukaisuu, String pBusitucd,int pSynypinfo, int pToukipzennoupRecordkbn) {

        String syuunoukeirokbn = "";
        String zennoukbn = "";
        String haitouKbn = "";
        String hhknsyNenreiTys = "";
        String kyksyaNenreiTys = "";
        String sykykSyrCode = "";
        String bosyuKeitaiKbn = "";
        String haraikomikaisukbn = "";
        String ryouritukbn = "";
        String saimnkkykhyj = "";
        String sinnyuukinkbn = "";
        String syuukinym = "";
        String recordkbn = "";
        String denymd = "";

        if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU) {

            BizDate denYmd = pDenpyoData.getDenymd();

            if (denYmd != null) {
                syuukinym = denYmd.getBizDateYM().toString();
                denymd = denYmd.toString();
            }

            recordkbn = pDenpyoData.getTaisyakukbn().getValue();
        }
        else if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU) {

            BizDate ryosyuYmd = pNyknJissekiRireki.getRyosyuymd();

            if (ryosyuYmd != null) {
                syuukinym = ryosyuYmd.getBizDateYM().toString();
                denymd = ryosyuYmd.toString();
            }

            recordkbn = C_TaisyakuKbn.KASIKATA.getValue();
        }


        if (C_Hrkkeiro.HURIKAE.eq(hrkkeiro)) {

            syuunoukeirokbn = SrCommonConstants.SYUUNOUKEIROKBN_HURIKAERYOURITU;
        }
        else if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {

            syuunoukeirokbn = SrCommonConstants.SYUUNOUKEIROKBN_KZHURIKAERYOURITU;
        }
        else if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {

            syuunoukeirokbn = SrCommonConstants.SYUUNOUKEIROKBN_CREDITRYOURITU;
        }
        else {

            syuunoukeirokbn = SrCommonConstants.SYUUNOUKEIROKBN_SONOTA;
        }


        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_HAITOU,
            pSyouhnZokusei.getHaitoukbn().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_HAITOU.getContent(),
                pKykKihon.getSyono(),
                pSyouhnZokusei.getHaitoukbn().getValue());

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            haitouKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);
        int hhknsyHokenNenrei = setHokenNenrei.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHhknseiymd());

        if (pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().intValue() != hhknsyHokenNenrei) {
            hhknsyNenreiTys = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            hhknsyNenreiTys = SrCommonConstants.HYOUJI_NASI;
        }


        int kyksyaHokenNenrei = setHokenNenrei.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pKykSya.getKykseiymd());

        SetNenrei SetNenrei = SWAKInjector.getInstance(SetNenrei.class);
        int kyknen = SetNenrei.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pKykSya.getKykseiymd());

        if (kyksyaHokenNenrei != kyknen) {
            kyksyaNenreiTys = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            kyksyaNenreiTys = SrCommonConstants.HYOUJI_NASI;
        }

        int kykSynTyouseigo;
        if (kyknen > 99) {
            kykSynTyouseigo = 0;
        }
        else {
            kykSynTyouseigo = kyknen;
        }


        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(
            C_SrKbnHenkanKbn.SYOKEIYAKU,
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1006,
                C_SrKbnHenkanKbn.SYOKEIYAKU.getContent(),
                pKykKihon.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());
            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            sykykSyrCode = Strings.padStart(srSuuriKbnHenkanBean.getHenkanAtoKbn(), 3, '0');
        }


        String atsksySskCode = pKykDairiten.getDrtenkanrisosikicd();
        String atsksyKjnCode = pKykDairiten.getDaibosyuucd();

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.BOSYU_KEITAI,
            pKykDairiten.getDrtencd());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                pKykKihon.getSyono(),
                pKykDairiten.getDrtencd());

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            bosyuKeitaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.HRK_KAISUU,
            hrkkaisuu.getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.HRK_KAISUU.getContent(),
                pKykKihon.getSyono(),
                hrkkaisuu.getValue());

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            haraikomikaisukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            ryouritukbn = C_SuuriRyourituKbn.OTHER.getValue();

        }
        else {
            if (C_Hrkkaisuu.NEN.eq(hrkkaisuu) || C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {
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
        }

        BizCurrency kihons = BizCurrency.valueOf(0);
        if(pSyouhin == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN){
            kihons = BizCurrency.valueOf(0);
        }
        else{
            kihons = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
        }


        if (C_HknkknsmnKbn.SAIMANKI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn())) {
            saimnkkykhyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            saimnkkykhyj = SrCommonConstants.HYOUJI_NASI;
        }

        if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU) {

            if (pToukipzennoupRecordkbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP) {

                sinnyuukinkbn = SrCommonConstants.SINNYUUKINKBN_IPPAN;

                zennoukbn = SrCommonConstants.ZENNOUKBN_IPPAN;
            }
            else {

                sinnyuukinkbn = SrCommonConstants.SINNYUUKINKBN_ZENNOU;

                zennoukbn = SrCommonConstants.ZENNOUKBN_ZENNOU;
            }
        }
        else if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU) {

            sinnyuukinkbn = SrCommonConstants.SINNYUUKINKBN_IPPAN;

            zennoukbn = SrCommonConstants.ZENNOUKBN_ZENNOU;
        }

        C_Segcd segcd = C_Segcd.BLNK;
        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu()
            );

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1007,
                SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD,
                pTkJitenKeiyakuSyouhinKijyunBean.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
                );

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pTkJitenKeiyakuSyouhinKijyunBean.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            segcd = syouhinbetuSegmentBean.getSegcd1();
        }



        pGkknHnkuSyrSynypTukiTy.setZtydatakanrino(pKykKihon.getSyono());
        pGkknHnkuSyrSynypTukiTy.setZtysyoricd(SYORICD);
        pGkknHnkuSyrSynypTukiTy.setZtyrendoukbn(RENDOUKBN_RYOKINHOZEN);
        pGkknHnkuSyrSynypTukiTy.setZtysyuunoukeirokbn(syuunoukeirokbn);
        pGkknHnkuSyrSynypTukiTy.setZtysuitousisya(pBusitucd);
        pGkknHnkuSyrSynypTukiTy.setZtysyuukinym(syuukinym);
        if (pJyutouym != null) {
            pGkknHnkuSyrSynypTukiTy.setZtyjyuutouym(pJyutouym.toString());
        }
        pGkknHnkuSyrSynypTukiTy.setZtyjyuutoukaisuu(pJyuutoukaisuu);
        pGkknHnkuSyrSynypTukiTy.setZtyzennoukbn(zennoukbn);
        pGkknHnkuSyrSynypTukiTy.setZtyrecordkbn(recordkbn);
        pGkknHnkuSyrSynypTukiTy.setZtyhaitoukbn(haitouKbn);
        pGkknHnkuSyrSynypTukiTy.setZtydenymd(denymd);
        pGkknHnkuSyrSynypTukiTy.setZtysyonendosyokaip(new BigDecimal(pSyonendosyokaip.toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtysyonendo2kaimeikoup(
            new BigDecimal(pSyonendo2kaimeikoup.toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtyjinendoikoup(new BigDecimal(pJinendoikoup.toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        pGkknHnkuSyrSynypTukiTy.setZtysaimnkkykhyj(saimnkkykhyj);
        pGkknHnkuSyrSynypTukiTy.setZtyhknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().toString());
        pGkknHnkuSyrSynypTukiTy.setZtyphrkkikn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn().toString());
        pGkknHnkuSyrSynypTukiTy.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pGkknHnkuSyrSynypTukiTy.setZtykyksyanen(Integer.toString(kykSynTyouseigo));
        if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd() != null) {
            pGkknHnkuSyrSynypTukiTy.setZtykykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        }
        pGkknHnkuSyrSynypTukiTy.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());
        pGkknHnkuSyrSynypTukiTy.setZtyannaifuyouriyuukbn(C_SuuriAnnaiFuyouRiyuuKbn.ANNAITYUU.getValue());
        pGkknHnkuSyrSynypTukiTy.setZtyhrkkaisuukbn(haraikomikaisukbn);
        pGkknHnkuSyrSynypTukiTy.setZtysdpdkbn(pKykKihon.getSdpdkbn().getValue());
        pGkknHnkuSyrSynypTukiTy.setZtyryouritukbn(ryouritukbn);
        pGkknHnkuSyrSynypTukiTy.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
        pGkknHnkuSyrSynypTukiTy.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
        pGkknHnkuSyrSynypTukiTy.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
        pGkknHnkuSyrSynypTukiTy.setZtykihons(new BigDecimal(kihons.toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtyaatukaisosikicd(atsksySskCode);
        pGkknHnkuSyrSynypTukiTy.setZtyaatukaikojincd(atsksyKjnCode);
        pGkknHnkuSyrSynypTukiTy.setZtybsyym(pKykKihon.getBosyuuym().toString());
        pGkknHnkuSyrSynypTukiTy.setZtyharaikomip(
            new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtysyukeiyakup(
            new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtysyuunoukbn(SYUNOUKBN_INIT);
        pGkknHnkuSyrSynypTukiTy.setZtytkykkumkhnsyukosuu(SrCommonConstants.DEFAULT_INT_ZERO);
        pGkknHnkuSyrSynypTukiTy.setZtysinnyuukinkbn(sinnyuukinkbn);
        pGkknHnkuSyrSynypTukiTy.setZtykbnkeiriyousegmentcd(segcd.getValue());
        pGkknHnkuSyrSynypTukiTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pGkknHnkuSyrSynypTukiTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
        pGkknHnkuSyrSynypTukiTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
        pGkknHnkuSyrSynypTukiTy.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
        pGkknHnkuSyrSynypTukiTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pGkknHnkuSyrSynypTukiTy.setZtytokubetuhosyoukikan(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pGkknHnkuSyrSynypTukiTy.setZtytenkanminaosikbn(TENKANMINAOSIKBN_SONOTA);
        pGkknHnkuSyrSynypTukiTy.setZtyhhknnentysihyj(hhknsyNenreiTys);
        pGkknHnkuSyrSynypTukiTy.setZtykyksyaagetyouseihyj(kyksyaNenreiTys);
        pGkknHnkuSyrSynypTukiTy.setZtysykykhokenhoutekiyouhyj(SrCommonConstants.HYOUJI_ARI);
        pGkknHnkuSyrSynypTukiTy.setZtytkjykbn(TOKUJYOUKBN_SAKUGENIGAI);
        pGkknHnkuSyrSynypTukiTy.setZtydai2tokujyoukbn(DAINITOKUJYOUKBN_SAKUGENIGAI);
        pGkknHnkuSyrSynypTukiTy.setZtybosyuukeitaikbn(bosyuKeitaiKbn);
        pGkknHnkuSyrSynypTukiTy.setZtysyukeiyakusyuruicdv3(sykykSyrCode);

        pGkknHnkuSyrSynypTukiTy.setZtysetrenseimrtikatakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pGkknHnkuSyrSynypTukiTy.setZtysetkaigomaruteikatakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);

        if (pSyouhin == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU ||
                (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU &&
                pToukipzennoupRecordkbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP)) {

                pSynypTukiTugtTykiyuHozon.setZtydatakanrino(pKykKihon.getSyono());
                if (pJyutouym != null) {
                    pSynypTukiTugtTykiyuHozon.setZtyjyuutouym(pJyutouym.toString());
                }
                pSynypTukiTugtTykiyuHozon.setZtyjyuutoukaisuu(pJyuutoukaisuu);
                pSynypTukiTugtTykiyuHozon.setZtyrecordkbn(recordkbn);
                if (denymd != null) {
                    pSynypTukiTugtTykiyuHozon.setZtydenymd(denymd.toString());
                }
                pSynypTukiTugtTykiyuHozon.setZtykbnkeiriyousegmentcd(segcd.getValue());
            }
        }
    }

    private void editRayDataHeijyun(SrGkknHnkuSyrSyunyupTukiBatchParam pSrGkknHnkuSyrSyunyupTukiBatchParam,
        IT_NyknJissekiRireki pNyknJissekiRireki, IT_KykSonotaTkyk pKykSonotaTkyk,
        IT_KykKihon pKykKihon, TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_GkknHnkuSyrSynypTukiTy pGkknHnkuSyrSynypTukiTy, ST_SynypTukiTugtTykiyuHozon pSynypTukiTugtTykiyuHozon,
        int pSyouhin, int pSynypinfo, int pToukipzennoupRecordkbn,BizCurrency pZennoujiHrkp,
        BizNumber pNyknjikwsRate,BizDate pNyknjikwsRateTkyymd,Boolean pNyknjikwsRateHtnFlg) {


        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        String gaikaKbn = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pKykKihon.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            gaikaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        BizNumber kykjiKawaserate = BizNumber.ZERO;

        BizDate kykjiKawaserateYmd = null;

        BizNumber crossRate = BizNumber.ZERO;

        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.BLNK;

        C_KawasetsryKbn kawasetsrykbn = C_KawasetsryKbn.BLNK;

        C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;
        if(C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())){
            kykjiKawaserate = BizNumber.ZERO;
            kykjiKawaserateYmd = null;
        }
        else{
            if (C_Tuukasyu.JPY.eq(pNyknJissekiRireki.getRstuukasyu())) {

                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
                kawasetsrykbn = C_KawasetsryKbn.NYUKINRATE;
            }
            else {

                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
                kawasetsrykbn = C_KawasetsryKbn.JISSEIRATE;
            }

            BizDate kwsrateKjYmd = null;
            if (pSyouhin == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
                (pSyouhin == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN  &&
                !C_Kykjyoutai.ZENNOU.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai()))) {

                kwsrateKjYmd = pNyknJissekiRireki.getRyosyuymd().addBusinessDays(-1);
            }
            else {
                kwsrateKjYmd = pNyknJissekiRireki.getRyosyuymd();
            }

            errorKbn = getKawaseRate.exec(
                kwsrateKjYmd,
                kawaserateSyuruiKbn,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                kawasetsrykbn,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String errMessage = MessageUtil.getMessage(
                    MessageId.ESA1004,
                    pNyknJissekiRireki.getRyosyuymd().toString(),
                    kawaserateSyuruiKbn.getValue(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                    C_Tuukasyu.JPY.getValue(),
                    C_KawasetekiyoKbn.TTM.getValue(),
                    kawasetsrykbn.getValue(),
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                    C_YouhiKbn.HUYOU.getValue());

                batchLogger.warn(errMessage);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                    pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

                errorFlag = true;
            }
            else {

                kykjiKawaserate = getKawaseRate.getKawaserate();

                kykjiKawaserateYmd = getKawaseRate.getKwsrateKjYmd();
            }


            if (!pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().eq(pNyknJissekiRireki.getRstuukasyu())
                &&
                (C_Tuukasyu.AUD.eq(pNyknJissekiRireki.getRstuukasyu()) || C_Tuukasyu.USD.eq(pNyknJissekiRireki
                    .getRstuukasyu()))) {


                errorKbn = getKawaseRate.exec(
                    pNyknJissekiRireki.getRyosyuymd(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                    pNyknJissekiRireki.getRstuukasyu(),
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String errMessage = MessageUtil.getMessage(
                        MessageId.ESA1004,
                        pNyknJissekiRireki.getRyosyuymd().toString(),
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE.getValue(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                        pNyknJissekiRireki.getRstuukasyu().getValue(),
                        C_KawasetekiyoKbn.TTM.getValue(),
                        C_KawasetsryKbn.NYUKINRATE.getValue(),
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                        C_YouhiKbn.HUYOU.getValue());

                    batchLogger.warn(errMessage);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                        pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

                    errorFlag = true;
                }
                else {
                    crossRate = getKawaseRate.getKawaserate();
                }


                SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);

                SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean = srSuuriGouseiRateKeisan.exec(
                    pNyknJissekiRireki.getRyosyuymd(),
                    pNyknJissekiRireki.getRstuukasyu(),
                    crossRate);

                SetErrMessageInfoBean errMessageInfoBean = srSuuriGouseiRateKeisanBean.getErrMessageInfoBean();

                if (C_ErrorKbn.ERROR.eq(srSuuriGouseiRateKeisanBean.getErrorKbn())) {

                    String errMessage = MessageUtil.getMessage(
                        MessageId.ESA1004,
                        errMessageInfoBean == null ? "" : errMessageInfoBean.getKwsrateKjYmd().toString(),
                            errMessageInfoBean == null ? "" : errMessageInfoBean.getKawaserateSyuruiKbn().getValue(),
                                errMessageInfoBean == null ? "" : errMessageInfoBean.getMotoTuukasyu().getValue(),
                                    errMessageInfoBean == null ? "" : errMessageInfoBean.getKansanTuukasyu().getValue(),
                                        errMessageInfoBean == null ? "" : errMessageInfoBean.getKawasetekiyoKbn().getValue(),
                                            errMessageInfoBean == null ? "" : errMessageInfoBean.getKawasetsryKbn().getValue(),
                                                errMessageInfoBean == null ? "" : errMessageInfoBean.getEigyoubiHoseiKbn().getValue(),
                                                    errMessageInfoBean == null ? "" : errMessageInfoBean.getYouhiKbn().getValue()
                                                        + "：合成レート"
                        );

                    batchLogger.warn(errMessage);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                        pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

                    errorFlag = true;
                }
                else {
                    kykjiKawaserate = srSuuriGouseiRateKeisanBean.getSuuriGouseiRate();
                }
            }
        }

        BizNumber kykjiyoteiriritu = BizNumber.valueOf(0);

        if (pSyouhin == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);

            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

            getYoteirirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

            getYoteirirituBean.setKijyunymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            getYoteirirituBean.setSknnkaisiymd(pTkJitenKeiyakuSyouhinKijyunBean.getSknnkaisiymd());

            getYoteirirituBean.setKykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            getYoteirirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());

            getYoteirirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());

            getYoteirirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

            getYoteirirituBean.setSitihsyuriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt());

            getYoteirirituBean.setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            errorKbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String errMessage = MessageUtil.getMessage(MessageId.ESA1001,
                    KYKJIYOTEIRIRITU,
                    pKykKihon.getSyono());

                batchLogger.warn(errMessage);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                    pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

                errorFlag = true;
            }
            else {
                kykjiyoteiriritu = getYoteiriritu.getYoteiriritu();
            }
        }
        else{
            kykjiyoteiriritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu();
        }


        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        BizCurrency yenkasbjiSaiteiHsygk = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));

        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

            yenkasbjiSaiteiHsygk = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        }


        String nyknTskkbn = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA,
            pNyknJissekiRireki.getRstuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA.getContent(),
                pKykKihon.getSyono(),
                pNyknJissekiRireki.getRstuukasyu().getValue());

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            nyknTskkbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizNumber nyknjikwsRate = BizNumber.ZERO;

        BizDate nyknjikwsRateTkyymd = null;
        if(pSyouhin == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN){
            if(C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())){
                nyknjikwsRate = BizNumber.ZERO;
                nyknjikwsRateTkyymd = null;
            }
            else{
                if(pNyknjikwsRateHtnFlg){
                    nyknjikwsRate = kykjiKawaserate;
                    nyknjikwsRateTkyymd = kykjiKawaserateYmd;
                }
                else{
                    nyknjikwsRate = pNyknjikwsRate;
                    nyknjikwsRateTkyymd = pNyknjikwsRateTkyymd;
                }
            }
        }

        String tuukasyukbn = "";
        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.TUUKA_SYU,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
            );

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errMessage = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA.getContent(),
                pKykKihon.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
                );

            batchLogger.warn(errMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrGkknHnkuSyrSyunyupTukiBatchParam.setErrorSyoriKensuu(
                pSrGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            tuukasyukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizCurrency zennoujiIkktbrijyututksuk = BizCurrency.valueOf(0);

        if (C_Kykjyoutai.ZENNOU.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai()) &&
            ((pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU &&
            pToukipzennoupRecordkbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP) ||
            pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU)) {

            zennoujiIkktbrijyututksuk = pZennoujiHrkp;
        }
        else {

            zennoujiIkktbrijyututksuk = BizCurrency.valueOf(0);

        }

        BizCurrency gaikadatesyukeiyakup = BizCurrency.valueOf(0);

        if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == pSyouhin &&
            !C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())){

            gaikadatesyukeiyakup = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
        }



        pGkknHnkuSyrSynypTukiTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pGkknHnkuSyrSynypTukiTy.setZtygaikakbn(gaikaKbn);
        pGkknHnkuSyrSynypTukiTy.setZtykykjikawaserate(kykjiKawaserate);
        if (kykjiKawaserateYmd != null) {
            pGkknHnkuSyrSynypTukiTy.setZtykykjikawaseratetkyuymd(kykjiKawaserateYmd.toString());
        }
        pGkknHnkuSyrSynypTukiTy.setZtykeiyakujiyoteiriritu(
            kykjiyoteiriritu);
        pGkknHnkuSyrSynypTukiTy.setZtyenkdtsbujsitihsyukngk(new BigDecimal(yenkasbjiSaiteiHsygk.toAdsoluteString())
        .longValue());
        pGkknHnkuSyrSynypTukiTy.setZtynyuukintuukakbn(nyknTskkbn);
        pGkknHnkuSyrSynypTukiTy.setZtynyknjikawaserate(nyknjikwsRate);
        if (nyknjikwsRateTkyymd != null) {
            pGkknHnkuSyrSynypTukiTy.setZtynyknjikawaseratetkyuymd(nyknjikwsRateTkyymd.toString());
        }
        pGkknHnkuSyrSynypTukiTy.setZtysrdai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn().toString());
        pGkknHnkuSyrSynypTukiTy.setZtytuukasyukbn(tuukasyukbn);
        pGkknHnkuSyrSynypTukiTy.setZtyzennoujiikkatubaraijytgk(
            new BigDecimal(zennoujiIkktbrijyututksuk.toAdsoluteString()).longValue());
        pGkknHnkuSyrSynypTukiTy.setZtygaikadatesyukeiyakup(
            new BigDecimal(gaikadatesyukeiyakup.toAdsoluteString()).longValue());

        if (pSyouhin == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU ||
                (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU &&
                pToukipzennoupRecordkbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP)) {
                pSynypTukiTugtTykiyuHozon.setZtyzennoujiikkatubaraijytgk(
                    new BigDecimal(zennoujiIkktbrijyututksuk.toAdsoluteString()).longValue());
            }
        }
    }

    private void editHeaderData(SrGkknHnkuSyrSyunyupTukiBatchParam pSrGkknHnkuSyrSyunyupTukiBatchParam,
        ZT_GkknHnkuSyrSynypTukiTy pGkknHnkuSyrSynypTukiTy) {


        int sequenceNo = pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriKensuu();
        int yuukouRecordLength = 0;

        int palpxre550length = YuyuSuuriConfig.getInstance().getPalpxre550length();
        int palpxre551length = YuyuSuuriConfig.getInstance().getPalpxre551length();
        int palprre853length = YuyuSuuriConfig.getInstance().getPalprre853length();
        int palrdwarealength = YuyuSuuriConfig.getInstance().getPalrdwarealength();

        String ztyrdwarea = "";

        yuukouRecordLength = palrdwarealength + palpxre550length + palprre853length +
            (palpxre551length * pGkknHnkuSyrSynypTukiTy.getZtytkykkumkhnsyukosuu());

        pSrGkknHnkuSyrSyunyupTukiBatchParam.setSyoriKensuu(pSrGkknHnkuSyrSyunyupTukiBatchParam.getSyoriKensuu() + 1);



        pGkknHnkuSyrSynypTukiTy.setZtysequenceno(sequenceNo);
        pGkknHnkuSyrSynypTukiTy.setZtyyuukourecordlength(yuukouRecordLength);
        pGkknHnkuSyrSynypTukiTy.setZtyrdwarea(ztyrdwarea);

    }

    private void editSynypTukiTugtTykiyuHozonData(SrGkknHnkuSyrSyunyupTukiBatchParam pSrGkknHnkuSyrSyunyupTukiBatchParam,
        BT_DenpyoData pDenpyoData, IT_NyknJissekiRireki pNyknJissekiRireki,
        ST_SynypTukiTugtTykiyuHozon pSynypTukiTugtTykiyuHozon,
        String pSyoricd, int pSynypinfo) {


        String henkousyoriymd = "";

        String denrenno = "";

        if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU) {

            henkousyoriymd = pDenpyoData.getSyoriYmd().toString();

            denrenno = pDenpyoData.getDenrenno();
        }

        else if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU) {

            henkousyoriymd = pNyknJissekiRireki.getNyksyoriymd().toString();

            denrenno = "";
        }

        pSynypTukiTugtTykiyuHozon.setZtysrkijyunym(
            pSrGkknHnkuSyrSyunyupTukiBatchParam.getZenkaiDenSimeYmd().getBizDateYM().toString());
        pSynypTukiTugtTykiyuHozon.setZtysrkakutyoujobcd(pSrGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd());
        pSynypTukiTugtTykiyuHozon.setZtysequenceno(pSrGkknHnkuSyrSyunyupTukiBatchParam.getItSyoriKensuu());
        pSynypTukiTugtTykiyuHozon.setZtysyoricd(pSyoricd);
        pSynypTukiTugtTykiyuHozon.setZtyhenkousyoriymd(henkousyoriymd);
        pSynypTukiTugtTykiyuHozon.setZtysrdenrenno(denrenno);

        pSrGkknHnkuSyrSyunyupTukiBatchParam.setItSyoriKensuu(pSrGkknHnkuSyrSyunyupTukiBatchParam.getItSyoriKensuu() + 1);

    }
}