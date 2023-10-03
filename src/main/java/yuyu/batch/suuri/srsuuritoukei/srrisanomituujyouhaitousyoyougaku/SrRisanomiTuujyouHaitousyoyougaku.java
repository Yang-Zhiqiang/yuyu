package yuyu.batch.suuri.srsuuritoukei.srrisanomituujyouhaitousyoyougaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.kaikei.BzKrHtkinSikinIdouDataSks;
import yuyu.common.biz.kaikei.HtkinSikinIdouDataBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.RisanomiTjHitsyyugkParam;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKhHaitouKanri;
import yuyu.common.suuri.srcommon.SrGetTokutejitenSisuurendoTmttknInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTmttknInfoBean;
import yuyu.common.suuri.srcommon.SrHoyuuKeiyakuCheck;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HoyuuCheckKekkaKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.BW_HtkinSikinIdouWk;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_RisanomiTuujyuHitusyyugk;
import yuyu.def.db.entity.ZT_RisaTjHitNminusZeroTy;
import yuyu.def.db.entity.ZT_RisaTjHitNplusQuartTy;
import yuyu.def.db.entity.ZT_RisaTjHitNplusZeroTy;
import yuyu.def.hozen.result.bean.HoyuKykSyouhnsBySyonoSyutkkbnBean;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 利差のみ通常配当所要額情報クラス
 */
public class SrRisanomiTuujyouHaitousyoyougaku implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrRisanomiTuujyouHaitousyoyougakuBatchParam batchParam;

    private static final String TBLNMZEROPLUS = "利差のみ通常配当所要額Ｆ（Ｎ＋０）テーブル（中）";

    private static final String TBLNMZERMINUS = "利差のみ通常配当所要額Ｆ（Ｎ－０）テーブル（中）";

    private static final String TBLNMQUARTER = "利差のみ通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（中）";

    private static final String SUURIYOUERRJYOUHOUTABLE = "数理用エラー情報テーブル";

    private static final String HTKINSIKINIDOUWKTABLE = "配当金資金移動ワークテーブル";

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchParam.setParam();

        String kbnkey = batchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, kbnkey));

        SrRisanomiTuujyouHaitousyoyougakuDbaStatement srRisanomiTuujyouHaitousyoyougakuDbaStatement = SWAKInjector
            .getInstance(SrRisanomiTuujyouHaitousyoyougakuDbaStatement.class);

        int editKoumokuErrorCouont = 0;

        try (ExDBResults<SV_RisanomiTuujyuHitusyyugk> riSanomiTuujyuHitusyyugkList = srRisanomiTuujyouHaitousyoyougakuDbaStatement
            .getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn.SYU, C_HaitouKbn.RISAHAI, kbnkey);
            EntityInserter<ZT_RisaTjHitNplusZeroTy> ztRisaTjHitNplusZeroTyList = new EntityInserter<>();
            EntityInserter<ZT_RisaTjHitNminusZeroTy> ztRisaTjHitNminusZeroTyList = new EntityInserter<>();
            EntityInserter<ZT_RisaTjHitNplusQuartTy> ztRisaTjHitNplusQuartTyList = new EntityInserter<>();
            EntityInserter<BW_HtkinSikinIdouWk> bwHtkinSikinIdouWk = new EntityInserter<>()) {



            for (SV_RisanomiTuujyuHitusyyugk svRisanomiTuujyuHitusyyugk : riSanomiTuujyuHitusyyugkList) {

                RisanomiTjHitsyyugkParam risanomiTjHitsyyugkParam = null;

                if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(batchParam
                    .getHaitousyoyougakukeisancd())) {

                    risanomiTjHitsyyugkParam = new ZT_RisaTjHitNplusZeroTy();
                }
                else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(batchParam
                    .getHaitousyoyougakukeisancd())) {

                    risanomiTjHitsyyugkParam = new ZT_RisaTjHitNplusQuartTy();
                }
                else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO.equals(batchParam
                    .getHaitousyoyougakukeisancd())) {

                    risanomiTjHitsyyugkParam = new ZT_RisaTjHitNminusZeroTy();
                }

                HtkinSikinIdouDataBean htkinSikinIdouDataBean = SWAKInjector.getInstance(HtkinSikinIdouDataBean.class);

                List<IT_KykSyouhn> kykSyouhnList = srRisanomiTuujyouHaitousyoyougakuDbaStatement
                    .getKykSyouhnsBySyonoSyutkkbn(svRisanomiTuujyuHitusyyugk.getSyono(), C_SyutkKbn.SYU);

                for (int n = 0; n < kykSyouhnList.size(); n++) {

                    IT_KykSyouhn kykSyouhn = kykSyouhnList.get(n);

                    List<IT_KhBikinkanri> khBikinkanriList = srRisanomiTuujyouHaitousyoyougakuDbaStatement
                        .getKhBikinkanrisBySyono(svRisanomiTuujyuHitusyyugk.getSyono());

                    List<JT_SiBikinkanri> siBikinkanriList = srRisanomiTuujyouHaitousyoyougakuDbaStatement
                        .getSiBikinkanrisBySyono(svRisanomiTuujyuHitusyyugk.getSyono());

                    List<SV_KiykSyuhnData> kiykSyuhnDataList = new ArrayList<SV_KiykSyuhnData>();

                    HoyuKykSyouhnsBySyonoSyutkkbnBean hoyuKykSyouhnsBySyonoSyutkkbnBean =
                        new HoyuKykSyouhnsBySyonoSyutkkbnBean(null,null,null,null, null, null);
                    HoyuuKhTtdkRirekiByPkBean hoyuuKhTtdkRirekiByPkBean =
                        new HoyuuKhTtdkRirekiByPkBean(null);

                    if (C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(kykSyouhnList.get(n).getSyoumetujiyuu())){
                        kiykSyuhnDataList = srRisanomiTuujyouHaitousyoyougakuDbaStatement.
                            getKiykSyuhnDatasBySyonoSyutkkbn(svRisanomiTuujyuHitusyyugk.getSyono(), C_SyutkKbn.SYU);

                        for (SV_KiykSyuhnData kiykSyuhnData : kiykSyuhnDataList) {

                            if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(kiykSyuhnData.
                                getGyoumuKousinKinou())) {

                                hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyono(kiykSyuhnData.getSyono());
                                hoyuKykSyouhnsBySyonoSyutkkbnBean.setHenkousikibetukey(kiykSyuhnData.
                                    getHenkousikibetukey());
                                hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyutkkbn(kiykSyuhnData.getSyutkkbn());
                                hoyuKykSyouhnsBySyonoSyutkkbnBean.setYuukousyoumetukbn(kiykSyuhnData.
                                    getYuukousyoumetukbn());
                                hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyoumetuymd(kiykSyuhnData.getSyoumetuymd());
                                hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyoumetujiyuu(kiykSyuhnData.getSyoumetujiyuu());

                                hoyuuKhTtdkRirekiByPkBean.setSyoriymd(kiykSyuhnData.getSyoriYmd());

                                break;
                            }
                        }
                    }
                    else {

                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyono(kykSyouhnList.get(n).getSyono());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setHenkousikibetukey(kykSyouhnList.get(n).
                            getHenkousikibetukey());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyutkkbn(kykSyouhnList.get(n).getSyutkkbn());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setYuukousyoumetukbn(kykSyouhnList.get(n).
                            getYuukousyoumetukbn());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyoumetuymd(kykSyouhnList.get(n).getSyoumetuymd());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyoumetujiyuu(kykSyouhnList.get(n).getSyoumetujiyuu());

                        hoyuuKhTtdkRirekiByPkBean = srRisanomiTuujyouHaitousyoyougakuDbaStatement.
                            getKhTtdkRireki(kykSyouhn.getSyono(), kykSyouhn.getHenkousikibetukey());
                    }

                    SrHoyuuKeiyakuCheck srHoyuuKeiyakuCheck = SWAKInjector.getInstance(SrHoyuuKeiyakuCheck.class);

                    C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(
                        batchParam.getKijyunymd(),
                        svRisanomiTuujyuHitusyyugk.getSyono(),
                        svRisanomiTuujyuHitusyyugk.getSkeikeijyouym(),
                        hoyuKykSyouhnsBySyonoSyutkkbnBean,
                        hoyuuKhTtdkRirekiByPkBean,
                        khBikinkanriList,
                        siBikinkanriList);

                    if (!C_HoyuuCheckKekkaKbn.HOYUUTAISYOU.eq(hoyuuCheckKekkaKbn)) {

                        continue;
                    }

                    if (!C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(hoyuKykSyouhnsBySyonoSyutkkbnBean.
                        getSyoumetujiyuu())){

                        kiykSyuhnDataList = srRisanomiTuujyouHaitousyoyougakuDbaStatement
                            .getKiykSyuhnDatasBySyonoSyutkkbn(svRisanomiTuujyuHitusyyugk.getSyono(), C_SyutkKbn.SYU);
                    }

                    SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector
                        .getInstance(SrGetTokutejitenSyohnInfo.class);

                    TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                        C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                        svRisanomiTuujyuHitusyyugk.getSyono(),
                        batchParam.getKijyunymd(),
                        "",
                        kiykSyuhnDataList);

                    TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanAto = tkJitenKeiyakuSyouhinBean
                        .getTkJitenKeiyakuSyouhinKijyunBeanAto();

                    int syohinHanteiKbn=SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBeanAto.getSyouhncd());

                    IT_KhSisuurendoTmttkn khSisuurendoTmttkn = new IT_KhSisuurendoTmttkn();

                    List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanList =
                        new ArrayList<SrGetTokutejitenTmttknInfoBean>();

                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                        if (BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd(),
                            batchParam.getKijyunymd()) != BizDateUtil.COMPARE_GREATER) {

                            SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
                                SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                            srGetTokutejitenTmttknInfoBeanList =
                                srGetTokutejitenSisuurendoTmttknInfo.exec(svRisanomiTuujyuHitusyyugk.getSyono(),
                                    batchParam.getKijyunymd(), null, kiykSyuhnDataList);

                            khSisuurendoTmttkn = srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                                batchParam.getKijyunymd(),
                                null, srGetTokutejitenTmttknInfoBeanList).getKhSisuurendoTmttknAto();

                        }
                        else {
                            List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList =
                                srRisanomiTuujyouHaitousyoyougakuDbaStatement.getKhSisuurendoTmttknListAsc(
                                    svRisanomiTuujyuHitusyyugk.getSyono(),
                                    tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd());

                            if (khSisuurendoTmttknList.size() > 0) {
                                khSisuurendoTmttkn = khSisuurendoTmttknList.get(0);
                            }

                        }
                    }

                    List<IT_HokenryouTmttkn> hokenryouTmttknLst = new ArrayList<>();

                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  &&
                        BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd(),
                            batchParam.getKijyunymd()) != BizDateUtil.COMPARE_GREATER) {

                        hokenryouTmttknLst = srRisanomiTuujyouHaitousyoyougakuDbaStatement.getHokenryouTmttkns(
                            svRisanomiTuujyuHitusyyugk.getSyono(), BizDateYM.valueOf(SrCommonConstants.YM_ALL9));
                    }

                    batchParam.setHeisoukbn(svRisanomiTuujyuHitusyyugk.getKbnkey());

                    List<IT_KhHaitouKanri> zenKhHaitouKanriLst = srRisanomiTuujyouHaitousyoyougakuDbaStatement
                        .getKhHaitouKanriKakutei(svRisanomiTuujyuHitusyyugk.getSyono(), batchParam.getTounendo()
                            .addYears(-1));
                    List<IT_KhHaitouKanri> touKhHaitouKanriLst = srRisanomiTuujyouHaitousyoyougakuDbaStatement
                        .getKhHaitouKanriKakutei(svRisanomiTuujyuHitusyyugk.getSyono(), batchParam.getTounendo());

                    SrGetTokutejitenKhHaitouKanri srGetTokutejitenKhHaitouKanri = SWAKInjector
                        .getInstance(SrGetTokutejitenKhHaitouKanri.class);
                    IT_KhHaitouKanri zenKhHaitouKanri = srGetTokutejitenKhHaitouKanri.exec(zenKhHaitouKanriLst,
                        batchParam.getKijyunymd());
                    IT_KhHaitouKanri touKhHaitouKanri = srGetTokutejitenKhHaitouKanri.exec(touKhHaitouKanriLst,
                        batchParam.getKijyunymd());

                    SrRisanomiTuujyouHaitousyoyougakuItemEditor srRisanomiTuujyouHaitousyoyougakuItemEditor =
                        SWAKInjector.getInstance(SrRisanomiTuujyouHaitousyoyougakuItemEditor.class);

                    boolean editKoumokuErrorFlg = srRisanomiTuujyouHaitousyoyougakuItemEditor.editKoumoku(
                        batchParam,
                        svRisanomiTuujyuHitusyyugk,
                        tkJitenKeiyakuSyouhinKijyunBeanAto,
                        risanomiTjHitsyyugkParam,
                        syohinHanteiKbn,
                        khSisuurendoTmttkn,
                        kiykSyuhnDataList,
                        hokenryouTmttknLst,
                        zenKhHaitouKanri,
                        touKhHaitouKanri,
                        htkinSikinIdouDataBean);

                    if (!editKoumokuErrorFlg) {

                        if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(batchParam
                            .getHaitousyoyougakukeisancd())) {

                            BizPropertyInitializer.initialize((ZT_RisaTjHitNplusZeroTy) risanomiTjHitsyyugkParam);

                            SrRisanomiTuujyouHaitousyoyougakuConverter
                            .convertPadding(risanomiTjHitsyyugkParam);

                            ztRisaTjHitNplusZeroTyList.add((ZT_RisaTjHitNplusZeroTy) risanomiTjHitsyyugkParam);

                            batchParam.setSyorikensuuNplusZero(batchParam.getSyorikensuuNplusZero() + 1);
                        }
                        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(batchParam
                            .getHaitousyoyougakukeisancd())) {

                            BizPropertyInitializer.initialize((ZT_RisaTjHitNplusQuartTy) risanomiTjHitsyyugkParam);

                            SrRisanomiTuujyouHaitousyoyougakuConverter
                            .convertPadding(risanomiTjHitsyyugkParam);

                            ztRisaTjHitNplusQuartTyList.add((ZT_RisaTjHitNplusQuartTy) risanomiTjHitsyyugkParam);

                            batchParam.setSyorikensuuNplusQuart(batchParam.getSyorikensuuNplusQuart() + 1);

                        }
                        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO.equals(batchParam
                            .getHaitousyoyougakukeisancd())) {

                            BizPropertyInitializer.initialize((ZT_RisaTjHitNminusZeroTy) risanomiTjHitsyyugkParam);

                            SrRisanomiTuujyouHaitousyoyougakuConverter
                            .convertPadding(risanomiTjHitsyyugkParam);

                            ztRisaTjHitNminusZeroTyList.add((ZT_RisaTjHitNminusZeroTy) risanomiTjHitsyyugkParam);

                            batchParam.setSyorikensuuNminusZero(batchParam.getSyorikensuuNminusZero() + 1);
                        }
                    }
                    else {

                        editKoumokuErrorCouont++;

                        continue;
                    }

                    BzKrHtkinSikinIdouDataSks bzKrHtkinSikinIdouDataSks = SWAKInjector.getInstance(BzKrHtkinSikinIdouDataSks.class);
                    BW_HtkinSikinIdouWk htkinSikinIdouWk = bzKrHtkinSikinIdouDataSks.exec(htkinSikinIdouDataBean);
                    if (htkinSikinIdouWk != null) {

                        bwHtkinSikinIdouWk.add(htkinSikinIdouWk);
                        batchParam.setSyorikensuuHtkinSikinIdouWk(batchParam.getSyorikensuuHtkinSikinIdouWk() + 1);
                    }
                }
            }
        }

        if ((SrRisanomiTuujyouHaitousyoyougakuBatchParam.RGHJM000.equals(batchParam.getIbKakutyoujobcd()) ||
            SrRisanomiTuujyouHaitousyoyougakuBatchParam.RGHJM004.equals(batchParam.getIbKakutyoujobcd()) ||
            SrRisanomiTuujyouHaitousyoyougakuBatchParam.RGHJM005.equals(batchParam.getIbKakutyoujobcd()) ||
            SrRisanomiTuujyouHaitousyoyougakuBatchParam.RGHJM006.equals(batchParam.getIbKakutyoujobcd())) &&
            editKoumokuErrorCouont != 0) {

            throw new BizAppException(MessageId.IBC1027, SUURIYOUERRJYOUHOUTABLE, kbnkey,
                String.valueOf(batchParam.getZokkouerrsyorikensuu()));
        }

        if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(batchParam
            .getHaitousyoyougakukeisancd())) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, TBLNMZEROPLUS, kbnkey,
                String.valueOf(batchParam.getSyorikensuuNplusZero())));
        }
        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(batchParam
            .getHaitousyoyougakukeisancd())) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, TBLNMQUARTER, kbnkey,
                String.valueOf(batchParam.getSyorikensuuNplusQuart())));
        }
        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO.equals(batchParam
            .getHaitousyoyougakukeisancd())) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, TBLNMZERMINUS, kbnkey,
                String.valueOf(batchParam.getSyorikensuuNminusZero())));
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, HTKINSIKINIDOUWKTABLE, kbnkey,
            String.valueOf(batchParam.getSyorikensuuHtkinSikinIdouWk())));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, SUURIYOUERRJYOUHOUTABLE, kbnkey,
            String.valueOf(batchParam.getZokkouerrsyorikensuu())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, kbnkey));

    }
}
