package yuyu.batch.suuri.srsuuritoukei.srdshrtoukei;

import java.math.BigDecimal;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriHaraikataKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.ST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.ZT_DshrToukeiTy;

/**
 * Ｄ支払統計情報作成項目編集クラス
 */
public class SrDshrToukeiBatchEdit {

    private boolean errorFlg;

    private static final int KOTEIKAWASERATE1DEUR  = 100;

    public SrDshrToukeiBatchEdit() {

        errorFlg = false;
    }

    public boolean editKoumoku(SrDshrToukeiBatchParam pBatchParam,
        DshrTukiInfoBean pDshrTukiInfoBean,
        BizDateYM  pDshrym,
        String pShrRiyuuKbn,
        String pDUketoriHouhouKbn,
        String pBikinhyj,
        BizCurrency pToujigyouNendoD,
        BizCurrency pToujigyouNendoHasseiDRsk,
        BizCurrency pZenjigyouNendoMatuDZndk,
        BizCurrency pYokujigyouNendoD,
        BizCurrency pHushrToujigyouNendoD,
        int pSyohnZokusei,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenSyouhinInfo,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenSyouhinInfoKykymdJiten,
        ZT_DshrToukeiTy pZT_DshrToukeiTy,
        ST_DshrTukiTyukeiyouItzHzn pST_DshrTukiTyukeiyouItzHzn) {

        editHeaderData(pBatchParam, pZT_DshrToukeiTy, pST_DshrTukiTyukeiyouItzHzn);

        editDshrTukiyouFKoumoku(pBatchParam,
            pDshrTukiInfoBean,
            pDshrym,
            pShrRiyuuKbn,
            pDUketoriHouhouKbn,
            pBikinhyj,
            pToujigyouNendoD,
            pToujigyouNendoHasseiDRsk,
            pZenjigyouNendoMatuDZndk,
            pYokujigyouNendoD,
            pHushrToujigyouNendoD,
            pSyohnZokusei,
            pTkJitenSyouhinInfo,
            pTkJitenSyouhinInfoKykymdJiten,
            pZT_DshrToukeiTy,
            pST_DshrTukiTyukeiyouItzHzn);

        editDshrTukiTyukeiyouItzHznKoumoku(pDshrTukiInfoBean, pSyohnZokusei, pTkJitenSyouhinInfo,
            pST_DshrTukiTyukeiyouItzHzn);

        return errorFlg;
    }

    private void editHeaderData(SrDshrToukeiBatchParam pBatchParam,
        ZT_DshrToukeiTy pZT_DshrToukeiTy,
        ST_DshrTukiTyukeiyouItzHzn pST_DshrTukiTyukeiyouItzHzn) {

        Integer keyKoumoku = pBatchParam.getShiKensu();
        pBatchParam.setShiKensu(pBatchParam.getShiKensu() + 1);

        pZT_DshrToukeiTy.setZtysequenceno(keyKoumoku);

        pST_DshrTukiTyukeiyouItzHzn.setZtysequenceno(pZT_DshrToukeiTy.getZtysequenceno());
    }

    private void editDshrTukiyouFKoumoku(SrDshrToukeiBatchParam pBatchParam,
        DshrTukiInfoBean pDshrTukiInfoBean,
        BizDateYM  pDshrym,
        String pShrRiyuuKbn,
        String pDUketoriHouhouKbn,
        String pBikinhyj,
        BizCurrency pToujigyouNendoD,
        BizCurrency pToujigyouNendoHasseiDRsk,
        BizCurrency pZenjigyouNendoMatuDZndk,
        BizCurrency pYokujigyouNendoD,
        BizCurrency pHushrToujigyouNendoD,
        int pSyohnZokusei,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenSyouhinInfo,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenSyouhinInfoKykymdJiten,
        ZT_DshrToukeiTy pZT_DshrToukeiTy,
        ST_DshrTukiTyukeiyouItzHzn pST_DshrTukiTyukeiyouItzHzn) {

        String srSyoumetuCd = "0000";

        if (SrCommonConstants.SHRRIYUUKBN_SYOUMETU.equals(pShrRiyuuKbn) ||
            SrCommonConstants.SHRRIYUUKBN_DSEISAN.equals(pShrRiyuuKbn)) {
            if (SrCommonConstants.HKNKNKINOUID_SATEI_SIBOU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
                srSyoumetuCd = SrCommonConstants.SRSYMTCD_SIBOU_KOUDOSG;
            }
            else if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou()) ||
                IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
                srSyoumetuCd = SrCommonConstants.SRSYMTCD_KAIYAKU;
            }
            else if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
                srSyoumetuCd = SrCommonConstants.SRSYMTCD_PMINYUUSYOUMETU;
            }
        }

        SrDshrToukeiBatchDbAccess srDshrToukeiBatchDbAccess = SWAKInjector.getInstance(SrDshrToukeiBatchDbAccess.class);

        AS_Kinou kinou = srDshrToukeiBatchDbAccess.getKinou(pDshrTukiInfoBean.getGyoumuKousinKinou());

        String syoricd = kinou.getSyoricd();

        int kyknendo = 0;

        if (pDshrTukiInfoBean.getKykymd().getMonth() >= SrCommonConstants.MONTH_APRIL) {
            kyknendo = pDshrTukiInfoBean.getKykymd().getYear();
        }
        else {
            kyknendo = pDshrTukiInfoBean.getKykymd().getYear() - SrCommonConstants.YEAR_1Y;
        }

        int annaikigetu = 0;
        if (pDshrTukiInfoBean.getYendthnkymd() != null) {
            annaikigetu = pDshrTukiInfoBean.getYendthnkymd().getMonth();
        }
        else {
            annaikigetu = pDshrTukiInfoBean.getKykymd().getMonth();
        }

        String annaiKbn = "";
        if (C_Kykjyoutai.ITIJIBARAI.eq(pDshrTukiInfoBean.getKykjyoutai())) {
            annaiKbn = SrCommonConstants.ANNAIKBN_ITIJIBARAI;
        }
        else {
            if (C_Hrkkeiro.HURIKAE.eq(pDshrTukiInfoBean.getHrkkeiro())) {
                annaiKbn = SrCommonConstants.ANNAIKBN_TIZUKI;
            }
            else if (C_Hrkkeiro.KOUHURI.eq(pDshrTukiInfoBean.getHrkkeiro())){
                annaiKbn = SrCommonConstants.ANNAIKBN_BANKTUKIBARAI;
            }
            else if (C_Hrkkeiro.CREDIT.eq(pDshrTukiInfoBean.getHrkkeiro())) {
                annaiKbn = SrCommonConstants.ANNAIKBN_CREDITTUKIBARAI;
            }
        }

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            pDshrTukiInfoBean.getSyouhncd(), pTkJitenSyouhinInfo.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1007, SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD,
                pDshrTukiInfoBean.getSyono(), pDshrTukiInfoBean.getSyouhncd(),
                pTkJitenSyouhinInfo.getKyktuukasyu().getValue());

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pDshrTukiInfoBean.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pBatchParam.setErrorCount(pBatchParam.getErrorCount() + 1);

            errorFlg = true;
        }

        C_Segcd seg1cd = syouhinbetuSegmentBean.getSegcd1();

        BizCurrency srhsys = BizCurrency.valueOf(0);
        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            srhsys = BizCurrency.valueOf(0);
        }
        else {
            if (pDshrTukiInfoBean.getYendthnkymd() != null
                || C_Tuukasyu.JPY.eq(pTkJitenSyouhinInfo.getKyktuukasyu())) {
                srhsys = pDshrTukiInfoBean.getKihons();
            }
            else {
                srhsys = pDshrTukiInfoBean.getKihons().convCurrencyType(BizCurrencyTypes.YEN,
                    BizNumber.valueOf(SrCommonConstants.INT_VALUE_100));
            }
        }

        String syukeiyakusyuruicd = "";
        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(C_SrKbnHenkanKbn.SYOKEIYAKU,
            pDshrTukiInfoBean.getSyouhncd(), pTkJitenSyouhinInfo.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1006, C_SrKbnHenkanKbn.SYOKEIYAKU.getContent(),
                pDshrTukiInfoBean.getSyono(), pDshrTukiInfoBean.getSyouhncd(),
                pTkJitenSyouhinInfo.getKyktuukasyu().getValue());

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pDshrTukiInfoBean.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pBatchParam.setErrorCount(
                pBatchParam.getErrorCount() + 1);

            errorFlg = true;
        }
        else {
            syukeiyakusyuruicd = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizNumber daihyouYoteiRiritu = null;

        if (pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);

            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

            getYoteirirituBean.setSyouhncd(pDshrTukiInfoBean.getSyouhncd());
            getYoteirirituBean.setKijyunymd(pDshrTukiInfoBean.getKykymd());
            getYoteirirituBean.setSknnkaisiymd(pDshrTukiInfoBean.getKykymd());
            getYoteirirituBean.setKykymd(pDshrTukiInfoBean.getKykymd());
            getYoteirirituBean.setHknkkn(pTkJitenSyouhinInfoKykymdJiten.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(pTkJitenSyouhinInfoKykymdJiten.getHknkknsmnKbn());
            getYoteirirituBean.setHhknnen(pTkJitenSyouhinInfoKykymdJiten.getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(pTkJitenSyouhinInfoKykymdJiten.getYoteirrthendohosyurrt());
            getYoteirirituBean.setTuukasyu(pTkJitenSyouhinInfoKykymdJiten.getKyktuukasyu());

            C_ErrorKbn kekkakbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.ERROR.eq(kekkakbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001, "代表予定利率", pDshrTukiInfoBean.getSyono());

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pDshrTukiInfoBean.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pBatchParam.setErrorCount(
                    pBatchParam.getErrorCount() + 1);

                errorFlg = true;
            }
            else {

                daihyouYoteiRiritu =  getYoteiriritu.getYoteiriritu().multiply(SrCommonConstants.INT_VALUE_100);
            }
        }
        else if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pDshrTukiInfoBean.getYendthnkymd() != null) {

            daihyouYoteiRiritu = BizNumber.ZERO;
        }
        else {

            daihyouYoteiRiritu =  pDshrTukiInfoBean.getYoteiriritu().multiply(SrCommonConstants.INT_VALUE_100);
        }


        String haraikataKbn = "";
        if (C_Kykjyoutai.ITIJIBARAI.eq(pDshrTukiInfoBean.getKykjyoutai())) {
            haraikataKbn = C_SuuriHaraikataKbn.ITIJI.getValue();
        }
        else {
            if (C_Hrkkeiro.HURIKAE.eq(pDshrTukiInfoBean.getHrkkeiro())) {
                haraikataKbn = C_SuuriHaraikataKbn.TIZUKI.getValue();
            }
            else if (C_Hrkkeiro.KOUHURI.eq(pDshrTukiInfoBean.getHrkkeiro())) {
                haraikataKbn = C_SuuriHaraikataKbn.BANKZUKI.getValue();
            }
            else if (C_Hrkkeiro.CREDIT.eq(pDshrTukiInfoBean.getHrkkeiro())) {
                haraikataKbn = C_SuuriHaraikataKbn.CREDIT.getValue();
            }
        }

        pZT_DshrToukeiTy.setZtysyono(pDshrTukiInfoBean.getSyono());
        pZT_DshrToukeiTy.setZtydshrym(String.valueOf(pDshrym));
        pZT_DshrToukeiTy.setZtyhknsyukigou(pDshrTukiInfoBean.getSyouhncd());
        pZT_DshrToukeiTy.setZtysrsyoumetucd(srSyoumetuCd);
        pZT_DshrToukeiTy.setZtysyoricd(syoricd);
        pZT_DshrToukeiTy.setZtykeiyakunendo(String.valueOf(kyknendo));
        pZT_DshrToukeiTy.setZtyannaikigetu(String.valueOf(annaikigetu));
        pZT_DshrToukeiTy.setZtyshrriyuukbn(pShrRiyuuKbn);
        pZT_DshrToukeiTy.setZtyannaikbn(annaiKbn);
        pZT_DshrToukeiTy.setZtyduketorihouhoukbn(pDUketoriHouhouKbn);
        pZT_DshrToukeiTy.setZtybikinhyj(pBikinhyj);
        pZT_DshrToukeiTy.setZtyskskbn(SrCommonConstants.DATASAKUSEIKBN_KIKAISYORI);
        if (seg1cd == null) {
            pZT_DshrToukeiTy.setZtysegcd("");
        } else {
            pZT_DshrToukeiTy.setZtysegcd(seg1cd.getValue());
        }
        pZT_DshrToukeiTy.setZtysrkensuu(SrCommonConstants.INT_VALUE_1);
        pZT_DshrToukeiTy.setZtysrhsys(new BigDecimal((srhsys.toAdsoluteString())).longValue());
        pZT_DshrToukeiTy.setZtytoujigyounendod(new BigDecimal((pToujigyouNendoD.toAdsoluteString())).longValue());
        pZT_DshrToukeiTy.setZtytoujigyounendohasseidrsk(new BigDecimal((pToujigyouNendoHasseiDRsk.toAdsoluteString())).longValue());
        pZT_DshrToukeiTy.setZtyzenjigyounendomatudzndk(new BigDecimal((pZenjigyouNendoMatuDZndk.toAdsoluteString())).longValue());
        pZT_DshrToukeiTy.setZtyyokujigyounendod(new BigDecimal((pYokujigyouNendoD.toAdsoluteString())).longValue());
        pZT_DshrToukeiTy.setZtyhushrtoujigyounendod(new BigDecimal((pHushrToujigyouNendoD.toAdsoluteString())).longValue());
        pZT_DshrToukeiTy.setZtysyukeiyakusyuruicdv2(syukeiyakusyuruicd);
        pZT_DshrToukeiTy.setZtydaihyouyoteiriritu(daihyouYoteiRiritu);
        pZT_DshrToukeiTy.setZtyharaikatakbn(haraikataKbn);

        pST_DshrTukiTyukeiyouItzHzn.setZtysyono(pZT_DshrToukeiTy.getZtysyono());
        pST_DshrTukiTyukeiyouItzHzn.setZtydshrym(pZT_DshrToukeiTy.getZtydshrym());
        pST_DshrTukiTyukeiyouItzHzn.setZtyhknsyukigou(pZT_DshrToukeiTy.getZtyhknsyukigou());
        pST_DshrTukiTyukeiyouItzHzn.setZtysrsyoumetucd(pZT_DshrToukeiTy.getZtysrsyoumetucd());
        pST_DshrTukiTyukeiyouItzHzn.setZtysyoricd(pZT_DshrToukeiTy.getZtysyoricd());
        pST_DshrTukiTyukeiyouItzHzn.setZtykeiyakunendo(pZT_DshrToukeiTy.getZtykeiyakunendo());
        pST_DshrTukiTyukeiyouItzHzn.setZtyannaikigetu(pZT_DshrToukeiTy.getZtyannaikigetu());
        pST_DshrTukiTyukeiyouItzHzn.setZtyshrriyuukbn(pZT_DshrToukeiTy.getZtyshrriyuukbn());
        pST_DshrTukiTyukeiyouItzHzn.setZtyannaikbn(pZT_DshrToukeiTy.getZtyannaikbn());
        pST_DshrTukiTyukeiyouItzHzn.setZtyduketorihouhoukbn(pZT_DshrToukeiTy.getZtyduketorihouhoukbn());
        pST_DshrTukiTyukeiyouItzHzn.setZtybikinhyj(pZT_DshrToukeiTy.getZtybikinhyj());
        pST_DshrTukiTyukeiyouItzHzn.setZtyskskbn(pZT_DshrToukeiTy.getZtyskskbn());
        pST_DshrTukiTyukeiyouItzHzn.setZtysegcd(pZT_DshrToukeiTy.getZtysegcd());
        pST_DshrTukiTyukeiyouItzHzn.setZtysrkensuu(pZT_DshrToukeiTy.getZtysrkensuu());
        pST_DshrTukiTyukeiyouItzHzn.setZtysrhsys(pZT_DshrToukeiTy.getZtysrhsys());
        pST_DshrTukiTyukeiyouItzHzn.setZtytoujigyounendod(pZT_DshrToukeiTy.getZtytoujigyounendod());
        pST_DshrTukiTyukeiyouItzHzn.setZtytoujigyounendohasseidrsk(pZT_DshrToukeiTy.getZtytoujigyounendohasseidrsk());
        pST_DshrTukiTyukeiyouItzHzn.setZtyzenjigyounendomatudzndk(pZT_DshrToukeiTy.getZtyzenjigyounendomatudzndk());
        pST_DshrTukiTyukeiyouItzHzn.setZtyyokujigyounendod(pZT_DshrToukeiTy.getZtyyokujigyounendod());
        pST_DshrTukiTyukeiyouItzHzn.setZtyhushrtoujigyounendod(pZT_DshrToukeiTy.getZtyhushrtoujigyounendod());
        pST_DshrTukiTyukeiyouItzHzn.setZtysyukeiyakusyuruicdv2(pZT_DshrToukeiTy.getZtysyukeiyakusyuruicdv2());
        pST_DshrTukiTyukeiyouItzHzn.setZtydaihyouyoteiriritu(pZT_DshrToukeiTy.getZtydaihyouyoteiriritu());
        pST_DshrTukiTyukeiyouItzHzn.setZtyharaikatakbn(pZT_DshrToukeiTy.getZtyharaikatakbn());

    }

    private void editDshrTukiTyukeiyouItzHznKoumoku(DshrTukiInfoBean pDshrTukiInfoBean,
        int pSyohnZokusei,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenSyouhinInfo,
        ST_DshrTukiTyukeiyouItzHzn pST_DshrTukiTyukeiyouItzHzn) {

        String hknsyruiKbn = "";

        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
            hknsyruiKbn = SrCommonConstants.DSHRTOUKEIHKNSYURUIKBN_GKDTKOJINHKN;
        }
        else if(pSyohnZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            if (C_Tuukasyu.JPY.eq(pTkJitenSyouhinInfo.getKyktuukasyu())) {

                hknsyruiKbn = SrCommonConstants.DSHRTOUKEIHKNSYURUIKBN_KOUJINSIBOUHKN;
            }
            else {

                hknsyruiKbn = SrCommonConstants.DSHRTOUKEIHKNSYURUIKBN_GKDTKOJINHKN;
            }

        }
        else {

            hknsyruiKbn = SrCommonConstants.DSHRTOUKEIHKNSYURUIKBN_GKDTKOJINNENKIN;
        }
        String syoumetuKbn = "";
        if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou()) ||
            IKhozenCommonConstants.KINOUID_DHANEI.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
            syoumetuKbn = SrCommonConstants.DSHRTOUKEISYOUMETUKBN_NOTSYOUMETU;
        }
        else if (SrCommonConstants.HKNKNKINOUID_SATEI_SIBOU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
            syoumetuKbn = SrCommonConstants.DSHRTOUKEISYOUMETUKBN_SIBOU_KOUDOSG;
        }
        else if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou()) ||
            IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
            syoumetuKbn = SrCommonConstants.DSHRTOUKEISYOUMETUKBN_KAIYAKU;
        }
        else if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
            syoumetuKbn = SrCommonConstants.DSHRTOUKEISYOUMETUKBN_PMINYUUSYOUMETU;
        }
        else {
            syoumetuKbn = SrCommonConstants.DSHRTOUKEISYOUMETUKBN_SONOTASYOUMETU;
        }

        pST_DshrTukiTyukeiyouItzHzn.setZtyhknsyruikbn(hknsyruiKbn);
        pST_DshrTukiTyukeiyouItzHzn.setZtysyoumetukbn(syoumetuKbn);
    }
}
