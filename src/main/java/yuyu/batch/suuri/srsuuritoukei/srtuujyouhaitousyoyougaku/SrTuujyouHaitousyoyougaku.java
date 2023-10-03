package yuyu.batch.suuri.srsuuritoukei.srtuujyouhaitousyoyougaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrHoyuuKeiyakuCheck;
import yuyu.common.suuri.srcommon.TuujyuHitusyyugkParam;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HoyuuCheckKekkaKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_TuujyuHitusyyugk;
import yuyu.def.db.entity.ZT_TjHitsyyugkNminusZeroTy;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusOneTy;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusQuartTy;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusTwoTy;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusZeroTy;
import yuyu.def.hozen.result.bean.HoyuKykSyouhnsBySyonoSyutkkbnBean;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 通常配当所要額情報作成クラス
 */
public class SrTuujyouHaitousyoyougaku implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrTuujyouHaitousyoyougakuBatchParam batchParam;

    private static final String TBLNMZEROPLUS = "通常配当所要額Ｆ（Ｎ＋０）テーブル（中）";

    private static final String TBLNMONE = "通常配当所要額Ｆ（Ｎ＋１）テーブル（中）";

    private static final String TBLNMTWO = "通常配当所要額Ｆ（Ｎ＋２）テーブル（中）";

    private static final String TBLNMZERMINUS = "通常配当所要額Ｆ（Ｎ－０）テーブル（中）";

    private static final String TBLNMQUARTER = "通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（中）";

    private static final String BLANK = "";

    private static final String TBLSUURIYOUERRJYOUHOU = "数理用エラー情報テーブル";

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchParam.setParam();

        String heisoukbn = batchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, heisoukbn));

        SrTuujyouHaitousyoyougakuDbaStatement srTuujyouHaitousyoyougakuDbaStatement = SWAKInjector
            .getInstance(SrTuujyouHaitousyoyougakuDbaStatement.class);

        try (ExDBResults<SV_TuujyuHitusyyugk> svTuujyuHitusyyugkList = srTuujyouHaitousyoyougakuDbaStatement
            .getTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn.SYU, C_HaitouKbn.RISAHAI, heisoukbn);
            EntityInserter<ZT_TjHitsyyugkNplusZeroTy> ztTjHitsyyugkNplusZeroTyList = new EntityInserter<>();
            EntityInserter<ZT_TjHitsyyugkNplusOneTy> ztTjHitsyyugkNplusOneTyList = new EntityInserter<>();
            EntityInserter<ZT_TjHitsyyugkNplusTwoTy> ztTjHitsyyugkNplusTwoTyList = new EntityInserter<>();
            EntityInserter<ZT_TjHitsyyugkNminusZeroTy> ztTjHitsyyugkNminusZeroTyList = new EntityInserter<>();
            EntityInserter<ZT_TjHitsyyugkNplusQuartTy> ztTjHitsyyugkNplusQuartTyList = new EntityInserter<>()) {

            for (SV_TuujyuHitusyyugk svTuujyuHitusyyugk : svTuujyuHitusyyugkList) {

                TuujyuHitusyyugkParam tuujyuHitusyyugkParam = null;

                if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(batchParam
                    .getHaitousyoyougakukeisancd())) {

                    tuujyuHitusyyugkParam = new ZT_TjHitsyyugkNplusZeroTy();
                }
                else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ONE.equals(batchParam
                    .getHaitousyoyougakukeisancd())) {

                    tuujyuHitusyyugkParam = new ZT_TjHitsyyugkNplusOneTy();
                }
                else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_TWO.equals(batchParam
                    .getHaitousyoyougakukeisancd())) {

                    tuujyuHitusyyugkParam = new ZT_TjHitsyyugkNplusTwoTy();
                }
                else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO.equals(batchParam
                    .getHaitousyoyougakukeisancd())) {

                    tuujyuHitusyyugkParam = new ZT_TjHitsyyugkNminusZeroTy();
                }
                else {

                    tuujyuHitusyyugkParam = new ZT_TjHitsyyugkNplusQuartTy();
                }

                List<IT_KykSyouhn> kykSyouhnList = srTuujyouHaitousyoyougakuDbaStatement
                    .getKykSyouhnsBySyonoSyutkkbn(svTuujyuHitusyyugk.getSyono(), C_SyutkKbn.SYU);

                for (int n = 0; n < kykSyouhnList.size(); n++) {

                    List<IT_KhBikinkanri> khBikinkanriList = srTuujyouHaitousyoyougakuDbaStatement
                        .getKhBikinkanrisBySyono(svTuujyuHitusyyugk.getSyono());

                    List<JT_SiBikinkanri> siBikinkanriList = srTuujyouHaitousyoyougakuDbaStatement
                        .getSiBikinkanrisBySyono(svTuujyuHitusyyugk.getSyono());

                    List<SV_KiykSyuhnData> kiykSyuhnDataList = new ArrayList<SV_KiykSyuhnData>();

                    HoyuKykSyouhnsBySyonoSyutkkbnBean hoyuKykSyouhnsBySyonoSyutkkbnBean =
                        new HoyuKykSyouhnsBySyonoSyutkkbnBean(null,null,null,null, null, null);
                    HoyuuKhTtdkRirekiByPkBean hoyuuKhTtdkRirekiByPkBean =
                        new HoyuuKhTtdkRirekiByPkBean(null);

                    if (C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(kykSyouhnList.get(n).getSyoumetujiyuu())){
                        kiykSyuhnDataList = srTuujyouHaitousyoyougakuDbaStatement.
                            getKiykSyuhnDatasBySyonoSyutkkbn(svTuujyuHitusyyugk.getSyono(), C_SyutkKbn.SYU);

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

                        IT_KhTtdkRireki khTtdkRireki = srTuujyouHaitousyoyougakuDbaStatement.
                            getKhTtdkRirekiByHenkousikibetukey(kykSyouhnList.get(n).getSyono(),
                                kykSyouhnList.get(n).getHenkousikibetukey());

                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyono(kykSyouhnList.get(n).getSyono());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setHenkousikibetukey(kykSyouhnList.get(n).
                            getHenkousikibetukey());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyutkkbn(kykSyouhnList.get(n).getSyutkkbn());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setYuukousyoumetukbn(kykSyouhnList.get(n).
                            getYuukousyoumetukbn());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyoumetuymd(kykSyouhnList.get(n).getSyoumetuymd());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyoumetujiyuu(kykSyouhnList.get(n).getSyoumetujiyuu());

                        hoyuuKhTtdkRirekiByPkBean.setSyoriymd(khTtdkRireki.getSyoriYmd());
                    }

                    SrHoyuuKeiyakuCheck srHoyuuKeiyakuCheck = SWAKInjector.getInstance(SrHoyuuKeiyakuCheck.class);

                    C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(
                        batchParam.getKijyunymd(),
                        svTuujyuHitusyyugk.getSyono(),
                        svTuujyuHitusyyugk.getSkeikeijyouym(),
                        hoyuKykSyouhnsBySyonoSyutkkbnBean,
                        hoyuuKhTtdkRirekiByPkBean,
                        khBikinkanriList,
                        siBikinkanriList);

                    if (!C_HoyuuCheckKekkaKbn.HOYUUTAISYOU.eq(hoyuuCheckKekkaKbn)) {

                        continue;
                    }

                    if (!C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(hoyuKykSyouhnsBySyonoSyutkkbnBean.
                        getSyoumetujiyuu())){

                        kiykSyuhnDataList = srTuujyouHaitousyoyougakuDbaStatement
                            .getKiykSyuhnDatasBySyonoSyutkkbn(svTuujyuHitusyyugk.getSyono(), C_SyutkKbn.SYU);
                    }

                    SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector
                        .getInstance(SrGetTokutejitenSyohnInfo.class);

                    TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                        C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                        svTuujyuHitusyyugk.getSyono(),
                        batchParam.getKijyunymd(),
                        BLANK,
                        kiykSyuhnDataList);

                    TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanAto = tkJitenKeiyakuSyouhinBean
                        .getTkJitenKeiyakuSyouhinKijyunBeanAto();

                    int syohinHanteiKbn=SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBeanAto.getSyouhncd());

                    batchParam.setHeisoukbn(svTuujyuHitusyyugk.getKbnkey());

                    SrTuujyouHaitousyoyougakuItemEditor srTuujyouHaitousyoyougakuItemEditor = SWAKInjector
                        .getInstance(SrTuujyouHaitousyoyougakuItemEditor.class);

                    boolean editKoumokuErrorFlg = srTuujyouHaitousyoyougakuItemEditor.editKoumoku(
                        batchParam,
                        svTuujyuHitusyyugk,
                        tkJitenKeiyakuSyouhinKijyunBeanAto,
                        tuujyuHitusyyugkParam,
                        syohinHanteiKbn,
                        kiykSyuhnDataList);

                    if (!editKoumokuErrorFlg) {

                        if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(batchParam
                            .getHaitousyoyougakukeisancd())) {

                            BizPropertyInitializer.initialize((ZT_TjHitsyyugkNplusZeroTy) tuujyuHitusyyugkParam);

                            SrTuujyouHaitousyoyougakuConverter.convertPadding(tuujyuHitusyyugkParam);

                            ztTjHitsyyugkNplusZeroTyList.add((ZT_TjHitsyyugkNplusZeroTy) tuujyuHitusyyugkParam);

                            batchParam.setSyorikensuuNplusZero(batchParam.getSyorikensuuNplusZero() + 1);

                        }
                        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ONE.equals(batchParam
                            .getHaitousyoyougakukeisancd())) {

                            BizPropertyInitializer.initialize((ZT_TjHitsyyugkNplusOneTy) tuujyuHitusyyugkParam);

                            SrTuujyouHaitousyoyougakuConverter.convertPadding(tuujyuHitusyyugkParam);

                            ztTjHitsyyugkNplusOneTyList.add((ZT_TjHitsyyugkNplusOneTy) tuujyuHitusyyugkParam);

                            batchParam.setSyorikensuuNplusOne(batchParam.getSyorikensuuNplusOne() + 1);

                        }
                        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_TWO.equals(batchParam
                            .getHaitousyoyougakukeisancd())) {

                            BizPropertyInitializer.initialize((ZT_TjHitsyyugkNplusTwoTy) tuujyuHitusyyugkParam);

                            SrTuujyouHaitousyoyougakuConverter.convertPadding(tuujyuHitusyyugkParam);

                            ztTjHitsyyugkNplusTwoTyList.add((ZT_TjHitsyyugkNplusTwoTy) tuujyuHitusyyugkParam);

                            batchParam.setSyorikensuuNplusTwo(batchParam.getSyorikensuuNplusTwo() + 1);

                        }
                        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO.equals(batchParam
                            .getHaitousyoyougakukeisancd())) {

                            BizPropertyInitializer.initialize((ZT_TjHitsyyugkNminusZeroTy) tuujyuHitusyyugkParam);

                            SrTuujyouHaitousyoyougakuConverter.convertPadding(tuujyuHitusyyugkParam);

                            ztTjHitsyyugkNminusZeroTyList.add((ZT_TjHitsyyugkNminusZeroTy) tuujyuHitusyyugkParam);

                            batchParam.setSyorikensuuNminusZero(batchParam.getSyorikensuuNminusZero() + 1);

                        }
                        else {

                            BizPropertyInitializer.initialize((ZT_TjHitsyyugkNplusQuartTy) tuujyuHitusyyugkParam);

                            SrTuujyouHaitousyoyougakuConverter.convertPadding(tuujyuHitusyyugkParam);

                            ztTjHitsyyugkNplusQuartTyList.add((ZT_TjHitsyyugkNplusQuartTy) tuujyuHitusyyugkParam);

                            batchParam.setSyorikensuuNplusQuart(batchParam.getSyorikensuuNplusQuart() + 1);
                        }
                    }
                    else {
                        continue;
                    }
                }
            }
        }

        if ((SrTuujyouHaitousyoyougakuBatchParam.RGHIM000.equals(batchParam.getIbKakutyoujobcd())
            || SrTuujyouHaitousyoyougakuBatchParam.RGHIM001.equals(batchParam.getIbKakutyoujobcd())
            || SrTuujyouHaitousyoyougakuBatchParam.RGHIM002.equals(batchParam.getIbKakutyoujobcd())
            || SrTuujyouHaitousyoyougakuBatchParam.RGHIM008.equals(batchParam.getIbKakutyoujobcd())
            || SrTuujyouHaitousyoyougakuBatchParam.RGHIM009.equals(batchParam.getIbKakutyoujobcd())
            || SrTuujyouHaitousyoyougakuBatchParam.RGHIM010.equals(batchParam.getIbKakutyoujobcd())
            || SrTuujyouHaitousyoyougakuBatchParam.RGHIM011.equals(batchParam.getIbKakutyoujobcd())
            || SrTuujyouHaitousyoyougakuBatchParam.RGHIM012.equals(batchParam.getIbKakutyoujobcd()))
            && batchParam.getErrorSyorikensuu() != 0) {

            throw new BizAppException(MessageId.IBC1027, TBLSUURIYOUERRJYOUHOU, heisoukbn,
                String.valueOf(batchParam.getErrorSyorikensuu()));
        }

        if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(batchParam
            .getHaitousyoyougakukeisancd())) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, TBLNMZEROPLUS, heisoukbn,
                String.valueOf(batchParam.getSyorikensuuNplusZero())));

        }
        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ONE.equals(batchParam
            .getHaitousyoyougakukeisancd())) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, TBLNMONE, heisoukbn,
                String.valueOf(batchParam.getSyorikensuuNplusOne())));

        }
        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_TWO.equals(batchParam
            .getHaitousyoyougakukeisancd())) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, TBLNMTWO, heisoukbn,
                String.valueOf(batchParam.getSyorikensuuNplusTwo())));

        }
        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO.equals(batchParam
            .getHaitousyoyougakukeisancd())) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, TBLNMZERMINUS, heisoukbn,
                String.valueOf(batchParam.getSyorikensuuNminusZero())));

        }
        else {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, TBLNMQUARTER, heisoukbn,
                String.valueOf(batchParam.getSyorikensuuNplusQuart())));

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, TBLSUURIYOUERRJYOUHOU, heisoukbn,
            String.valueOf(batchParam.getErrorSyorikensuu())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, heisoukbn));

    }
}
