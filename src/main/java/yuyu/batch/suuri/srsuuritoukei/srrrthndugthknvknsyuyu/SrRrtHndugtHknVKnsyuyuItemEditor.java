package yuyu.batch.suuri.srsuuritoukei.srrrthndugthknvknsyuyu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanGaikaP;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrSuuriKeisanVHeijyun;
import yuyu.common.suuri.srcommon.SrTmttknBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 利率変動型保険Ｖ検証用情報作成の項目編集クラス
 */
public class SrRrtHndugtHknVKnsyuyuItemEditor {

    @Inject
    private BatchLogger batchLogger;

    private Boolean result;

    public SrRrtHndugtHknVKnsyuyuItemEditor() {

        result = false;
    }

    public Boolean editKoumoku(SrRrtHndugtHknVKnsyuyuBatchParam pSrRrtHndugtHknVKnsyuyuParam,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean, List<SV_KiykSyuhnData> pKiykSyuhnDataLst,
        IT_KykKihon pKykKihon, List<IT_HokenryouTmttkn> pHokenryouTmttknLst,
        ZT_RrtHndugtHknVKnsyuyuTy pRrtHndugtHknVKnsyuyuTy) {

        editHeaderData(pSrRrtHndugtHknVKnsyuyuParam, pRrtHndugtHknVKnsyuyuTy);

        editHyumeisaiData(pHoyuuMeisaiTyukeiyouItzHzn, pRrtHndugtHknVKnsyuyuTy);

        editRrtHndugtHknVKnsyuyuTyData(pSrRrtHndugtHknVKnsyuyuParam, pHoyuuMeisaiTyukeiyouItzHzn,
            pTkJitenKeiyakuSyouhinKijyunBean, pKiykSyuhnDataLst, pKykKihon, pHokenryouTmttknLst,
            pRrtHndugtHknVKnsyuyuTy);

        return result;
    }

    private void editHeaderData(SrRrtHndugtHknVKnsyuyuBatchParam pSrRrtHndugtHknVKnsyuyuParam,
        ZT_RrtHndugtHknVKnsyuyuTy pRrtHndugtHknVKnsyuyuTy) {

        Integer key = pSrRrtHndugtHknVKnsyuyuParam.getSyoriKns();
        pSrRrtHndugtHknVKnsyuyuParam.setSyoriKns(pSrRrtHndugtHknVKnsyuyuParam.getSyoriKns() + 1);

        pRrtHndugtHknVKnsyuyuTy.setZtysequenceno(key);
    }

    private void editHyumeisaiData(ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        ZT_RrtHndugtHknVKnsyuyuTy pRrtHndugtHknVKnsyuyuTy) {

        pRrtHndugtHknVKnsyuyuTy.setZtykeijyouym(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouym());
        pRrtHndugtHknVKnsyuyuTy.setZtyraysystemhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyraysystemhyj());
        pRrtHndugtHknVKnsyuyuTy.setZtydatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
        pRrtHndugtHknVKnsyuyuTy.setZtyhknsyukigou(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknsyukigou());
        pRrtHndugtHknVKnsyuyuTy
        .setZtyhknsyuruikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknsyuruikigousedaikbn());
        pRrtHndugtHknVKnsyuyuTy.setZtysotodasipmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasipmenkbn());
        pRrtHndugtHknVKnsyuyuTy.setZtysotodasimanagehyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasimanagehyouji());
        pRrtHndugtHknVKnsyuyuTy.setZtysrdai1hknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrdai1hknkkn());
        pRrtHndugtHknVKnsyuyuTy.setZtytuukasyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytuukasyukbn());
        pRrtHndugtHknVKnsyuyuTy.setZtykbnkeiriyousegmentkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykbnkeiriyousegmentkbn());
        pRrtHndugtHknVKnsyuyuTy.setZtykbnkeiriyourgnbnskkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykbnkeiriyourgnbnskkbn());
        pRrtHndugtHknVKnsyuyuTy.setZtysuurisyuruicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuurisyuruicd());
        pRrtHndugtHknVKnsyuyuTy.setZtykykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd());
        pRrtHndugtHknVKnsyuyuTy.setZtyhknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknkkn());
        pRrtHndugtHknVKnsyuyuTy.setZtyphrkkikn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyphrkkikn());
        pRrtHndugtHknVKnsyuyuTy.setZtysaimnkkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaimnkkykhyj());
        pRrtHndugtHknVKnsyuyuTy.setZtyannaifuyouriyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyannaifuyouriyuukbn());
        pRrtHndugtHknVKnsyuyuTy.setZtyhhknseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknseikbn());
        pRrtHndugtHknVKnsyuyuTy.setZtyhihokensyaagev2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhihokensyaagev2());
        pRrtHndugtHknVKnsyuyuTy.setZtykuriagekurisagekbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykuriagekurisagekbn());
        pRrtHndugtHknVKnsyuyuTy
        .setZtysyukeiyakupwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyukeiyakupwaribikikbn());
        pRrtHndugtHknVKnsyuyuTy.setZtyjikaipjyuutouym2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyjikaipjyuutouym2());
        pRrtHndugtHknVKnsyuyuTy.setZtysyokainyknjikawasekjnymd(pHoyuuMeisaiTyukeiyouItzHzn
            .getZtykykjikawaseratetkyuymd());
        pRrtHndugtHknVKnsyuyuTy.setZtygaikakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikakbn());
        pRrtHndugtHknVKnsyuyuTy.setZtykimatukawaserate(BizNumber.valueOf(pHoyuuMeisaiTyukeiyouItzHzn
            .getZtykawaserate1()));
    }

    private void editRrtHndugtHknVKnsyuyuTyData(SrRrtHndugtHknVKnsyuyuBatchParam pSrRrtHndugtHknVKnsyuyuParam,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean, List<SV_KiykSyuhnData> pKiykSyuhnDataLst,
        IT_KykKihon pKykKihon, List<IT_HokenryouTmttkn> pHokenryouTmttknLst,
        ZT_RrtHndugtHknVKnsyuyuTy pRrtHndugtHknVKnsyuyuTy) {

        BizDateYM kijyunymFrom = null;
        BizDateYM kijyunymTo = null;

        if (BizDateUtil.compareYmd(pSrRrtHndugtHknVKnsyuyuParam.getKijyunymd(),
            BizDate.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd())) == BizDateUtil.COMPARE_LESSER) {

            kijyunymFrom = BizDate.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd()).getBizDateYM();
            kijyunymTo = BizDate.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd()).getBizDateYM();
        }
        else {
            if (pSrRrtHndugtHknVKnsyuyuParam.getKijyunymd().getBizDateYM().subtractMonths(BizDate.valueOf(
                pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd()).getBizDateYM()) <= SrCommonConstants.KIKAN_15M) {

                kijyunymFrom = BizDate.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd()).getBizDateYM();
            }
            else {

                kijyunymFrom = pSrRrtHndugtHknVKnsyuyuParam.getKijyunymd().getBizDateYM()
                    .addMonths(-SrCommonConstants.KIKAN_15M);
            }

            if (BizDateUtil.compareYm(pSrRrtHndugtHknVKnsyuyuParam.getKijyunymd().getBizDateYM(),
                BizDateYM.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtyjikaipjyuutouym())) == BizDateUtil.COMPARE_LESSER) {

                kijyunymTo = pSrRrtHndugtHknVKnsyuyuParam.getKijyunymd().getBizDateYM();
            }
            else {

                kijyunymTo = BizDateYM.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtyjikaipjyuutouym()).addMonths(
                    -SrCommonConstants.KIKAN_1M);
            }
        }

        List<BizNumber> yoteirirituLst = new ArrayList<>();
        List<BizCurrency> ptumitatekinLst = new ArrayList<>();
        List<BizCurrency> gaikadatejyuutoupLst = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            yoteirirituLst.add(BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO));
            ptumitatekinLst.add(BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO));
            gaikadatejyuutoupLst.add(BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO));
        }

        SrSuuriKeisanVHeijyun srSuuriKeisanVHeijyun = SWAKInjector.getInstance(SrSuuriKeisanVHeijyun.class);

        C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(
            pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
            pTkJitenKeiyakuSyouhinKijyunBean,
            pKiykSyuhnDataLst,
            pHokenryouTmttknLst,
            kijyunymFrom,
            kijyunymTo,
            pKykKihon.getHrkkaisuu(),
            pKykKihon.getFstpnyknymd(),
            false,
            null,
            null,
            false);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1001, "保険料積立金",
                pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRrtHndugtHknVKnsyuyuParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRrtHndugtHknVKnsyuyuParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRrtHndugtHknVKnsyuyuParam
            .setZokkouErrorSyoriKns(pSrRrtHndugtHknVKnsyuyuParam.getZokkouErrorSyoriKns() + 1);

            result = true;
        }
        else {

            List<SrTmttknBean> srTmttknBeanLst = srSuuriKeisanVHeijyun.getSrTmttknBeanList();

            for (int n = 0; n < srTmttknBeanLst.size(); n++) {

                if (n > 15) {
                    break;
                }

                yoteirirituLst.set(n, srTmttknBeanLst.get(n).getYoteiriritu());
                ptumitatekinLst.set(n, srTmttknBeanLst.get(n).getTmttKngk());

                KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);
                errorKbn = keisanGaikaP.execKawaseSitei(
                    srTmttknBeanLst.get(n).getHokenryou(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                    srTmttknBeanLst.get(n).getKawaserate());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String msg = MessageUtil.getMessage(MessageId.ESA1001, "単月外貨入金額計算",
                        pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrRrtHndugtHknVKnsyuyuParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrRrtHndugtHknVKnsyuyuParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrRrtHndugtHknVKnsyuyuParam.setZokkouErrorSyoriKns(pSrRrtHndugtHknVKnsyuyuParam
                        .getZokkouErrorSyoriKns() + 1);

                    result = true;
                }
                else {

                    gaikadatejyuutoupLst.set(n, keisanGaikaP.getP());
                }
            }
        }

        List<BizDateYM> sykykkitmttvkeisanymLst = new ArrayList<>();
        List<BizCurrency> sykykkitmttvLst = new ArrayList<>();
        int index = 0;
        int tmttkngenkensuu = 0;
        int kyksyuhngenkensuu = 0;

        for (int j = 0; j < 2; j++) {
            sykykkitmttvkeisanymLst.add(null);
            sykykkitmttvLst.add(BizCurrency.valueOf(0));
        }

        for (int m = 0; m < pHokenryouTmttknLst.size(); m++) {

            if (index > 1) {
                break;
            }

            if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pHokenryouTmttknLst.get(m).getGyoumuKousinKinou())) {

                tmttkngenkensuu++;

                if (BizDateUtil.compareYm(pSrRrtHndugtHknVKnsyuyuParam.getKijyunymd().getBizDateYM().
                    addMonths(SrCommonConstants.KIKAN_1M), pHokenryouTmttknLst.get(m).getTmttkntaisyouym()
                    ) == BizDateUtil.COMPARE_LESSER) {
                    continue;
                }

                kyksyuhngenkensuu = SrCommonConstants.DEFAULT_INT_ZERO;

                for (int k = 0; k < pKiykSyuhnDataLst.size(); k++) {

                    if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pKiykSyuhnDataLst.get(k).getGyoumuKousinKinou())) {

                        kyksyuhngenkensuu++;

                        if (tmttkngenkensuu == kyksyuhngenkensuu){

                            if (BizDateUtil.compareYmd(pKiykSyuhnDataLst.get(k).getKouryokuhasseiymd(),
                                pSrRrtHndugtHknVKnsyuyuParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER
                                || BizDateUtil.compareYmd(pKiykSyuhnDataLst.get(k).getKouryokuhasseiymd(),
                                    pSrRrtHndugtHknVKnsyuyuParam.getKijyunymd()) == BizDateUtil.COMPARE_EQUAL) {

                                sykykkitmttvkeisanymLst.set(index, pHokenryouTmttknLst.get(m).getTmttkntaisyouym());
                                sykykkitmttvLst.set(index, pHokenryouTmttknLst.get(m).getPtmttkngk());
                                index++;
                            }
                            break;
                        }
                    }
                }
            }
        }

        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5(yoteirirituLst.get(0));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x2(yoteirirituLst.get(1));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x3(yoteirirituLst.get(2));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x4(yoteirirituLst.get(3));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x5(yoteirirituLst.get(4));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x6(yoteirirituLst.get(5));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x7(yoteirirituLst.get(6));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x8(yoteirirituLst.get(7));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x9(yoteirirituLst.get(8));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x10(yoteirirituLst.get(9));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x11(yoteirirituLst.get(10));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x12(yoteirirituLst.get(11));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x13(yoteirirituLst.get(12));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x14(yoteirirituLst.get(13));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x15(yoteirirituLst.get(14));
        pRrtHndugtHknVKnsyuyuTy.setZtyyoteiriritun5x16(yoteirirituLst.get(15));
        pRrtHndugtHknVKnsyuyuTy.setZtysyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyukeiyakup());
        pRrtHndugtHknVKnsyuyuTy.setZtysyuptumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyuptumitatekin());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekin(new BigDecimal(ptumitatekinLst.get(0).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx2(new BigDecimal(ptumitatekinLst.get(1).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx3(new BigDecimal(ptumitatekinLst.get(2).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx4(new BigDecimal(ptumitatekinLst.get(3).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx5(new BigDecimal(ptumitatekinLst.get(4).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx6(new BigDecimal(ptumitatekinLst.get(5).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx7(new BigDecimal(ptumitatekinLst.get(6).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx8(new BigDecimal(ptumitatekinLst.get(7).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx9(new BigDecimal(ptumitatekinLst.get(8).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx10(new BigDecimal(ptumitatekinLst.get(9).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx11(new BigDecimal(ptumitatekinLst.get(10).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx12(new BigDecimal(ptumitatekinLst.get(11).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx13(new BigDecimal(ptumitatekinLst.get(12).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx14(new BigDecimal(ptumitatekinLst.get(13).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx15(new BigDecimal(ptumitatekinLst.get(14).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyptumitatekinx16(new BigDecimal(ptumitatekinLst.get(15).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtygaikadatejyuutoup(new BigDecimal(gaikadatejyuutoupLst.get(0).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy
        .setZtygaikadatejyuutoupx2(new BigDecimal(gaikadatejyuutoupLst.get(1).toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy
        .setZtygaikadatejyuutoupx3(new BigDecimal(gaikadatejyuutoupLst.get(2).toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy
        .setZtygaikadatejyuutoupx4(new BigDecimal(gaikadatejyuutoupLst.get(3).toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy
        .setZtygaikadatejyuutoupx5(new BigDecimal(gaikadatejyuutoupLst.get(4).toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy
        .setZtygaikadatejyuutoupx6(new BigDecimal(gaikadatejyuutoupLst.get(5).toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy
        .setZtygaikadatejyuutoupx7(new BigDecimal(gaikadatejyuutoupLst.get(6).toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy
        .setZtygaikadatejyuutoupx8(new BigDecimal(gaikadatejyuutoupLst.get(7).toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy
        .setZtygaikadatejyuutoupx9(new BigDecimal(gaikadatejyuutoupLst.get(8).toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtygaikadatejyuutoupx10(new BigDecimal(gaikadatejyuutoupLst.get(9)
            .toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtygaikadatejyuutoupx11(new BigDecimal(gaikadatejyuutoupLst.get(10)
            .toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtygaikadatejyuutoupx12(new BigDecimal(gaikadatejyuutoupLst.get(11)
            .toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtygaikadatejyuutoupx13(new BigDecimal(gaikadatejyuutoupLst.get(12)
            .toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtygaikadatejyuutoupx14(new BigDecimal(gaikadatejyuutoupLst.get(13)
            .toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtygaikadatejyuutoupx15(new BigDecimal(gaikadatejyuutoupLst.get(14)
            .toAdsoluteString()).longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtygaikadatejyuutoupx16(new BigDecimal(gaikadatejyuutoupLst.get(15)
            .toAdsoluteString()).longValue());
        if (sykykkitmttvkeisanymLst.get(0) == null) {
            pRrtHndugtHknVKnsyuyuTy.setZtysykykkitmttvkeisanym1("");
        } else {
            pRrtHndugtHknVKnsyuyuTy.setZtysykykkitmttvkeisanym1(String.valueOf(sykykkitmttvkeisanymLst.get(0)));
        }
        pRrtHndugtHknVKnsyuyuTy.setZtysykykkitmttv1(new BigDecimal(sykykkitmttvLst.get(0).toAdsoluteString())
        .longValue());
        if (sykykkitmttvkeisanymLst.get(1) == null) {
            pRrtHndugtHknVKnsyuyuTy.setZtysykykkitmttvkeisanym2("");
        } else {
            pRrtHndugtHknVKnsyuyuTy.setZtysykykkitmttvkeisanym2(String.valueOf(sykykkitmttvkeisanymLst.get(1)));
        }
        pRrtHndugtHknVKnsyuyuTy.setZtysykykkitmttv2(new BigDecimal(sykykkitmttvLst.get(1).toAdsoluteString())
        .longValue());
        pRrtHndugtHknVKnsyuyuTy.setZtyrrthnduhknvkisovkisnyu1(pHoyuuMeisaiTyukeiyouItzHzn
            .getZtyrrthnduhknvkisovkisnyu1());
        pRrtHndugtHknVKnsyuyuTy.setZtyrrthnduhknvkisovkisnyu2(pHoyuuMeisaiTyukeiyouItzHzn
            .getZtyrrthnduhknvkisovkisnyu2());
        pRrtHndugtHknVKnsyuyuTy.setZtyrrthnduhknvkisovkisnyu3(pHoyuuMeisaiTyukeiyouItzHzn
            .getZtyrrthnduhknvkisovkisnyu3());
        pRrtHndugtHknVKnsyuyuTy.setZtyrrthnduhknvkisovkisnyu4(pHoyuuMeisaiTyukeiyouItzHzn
            .getZtyrrthnduhknvkisovkisnyu4());
        pRrtHndugtHknVKnsyuyuTy.setZtyrrthnduhknvkiso(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrrthnduhknvkiso());
    }
}
