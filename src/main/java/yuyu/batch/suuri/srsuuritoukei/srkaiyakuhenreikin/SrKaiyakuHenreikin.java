package yuyu.batch.suuri.srsuuritoukei.srkaiyakuhenreikin;

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
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenSisuurendoTmttknInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTmttknInfoBean;
import yuyu.common.suuri.srcommon.SrHoyuuKeiyakuCheck;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HoyuuCheckKekkaKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.SV_KiykHnriknSutugk;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_KaiykHrSoutougakuTy;
import yuyu.def.hozen.result.bean.HoyuKykSyouhnsBySyonoSyutkkbnBean;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 解約返戻金相当額Fテーブル（中）作成クラス
 */
public class SrKaiyakuHenreikin implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrKaiyakuHenreikinParam batchParam;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        SrKaiyakuHenreikinDbaStatement srKaiyakuHenreikinDbaStatement = SWAKInjector
            .getInstance(SrKaiyakuHenreikinDbaStatement.class);

        String kbnkey = batchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, kbnkey));

        try (ExDBResults<SV_KiykHnriknSutugk> kiykHnriknSutugkResults = srKaiyakuHenreikinDbaStatement
            .getKiykHnriknSutugks(kbnkey);
            EntityInserter<ZT_KaiykHrSoutougakuTy> kaiykHrSoutougakuTyList = new EntityInserter<>()) {
            for (SV_KiykHnriknSutugk svKiykHnriknSutugk : kiykHnriknSutugkResults) {

                ZT_KaiykHrSoutougakuTy kaiykHrSoutougakuTy = new ZT_KaiykHrSoutougakuTy();

                List<IT_KykSyouhn> kykSyouhnList = srKaiyakuHenreikinDbaStatement.getKykSyouhnsBySyonoSyutkkbn(
                    svKiykHnriknSutugk.getSyono(), C_SyutkKbn.SYU);

                for (IT_KykSyouhn kykSyouhn : kykSyouhnList) {

                    List<IT_KhBikinkanri> khBikinkanriList = srKaiyakuHenreikinDbaStatement
                        .getKhBikinkanrisBySyono(svKiykHnriknSutugk.getSyono());

                    List<JT_SiBikinkanri> siBikinkanriList = srKaiyakuHenreikinDbaStatement
                        .getSiBikinkanrisBySyono(svKiykHnriknSutugk.getSyono());

                    List<SV_KiykSyuhnData> svKiykSyuhnDataList = new ArrayList<SV_KiykSyuhnData>();

                    HoyuKykSyouhnsBySyonoSyutkkbnBean hoyuKykSyouhnsBySyonoSyutkkbnBean =
                        new HoyuKykSyouhnsBySyonoSyutkkbnBean(null,null,null,null, null, null);
                    HoyuuKhTtdkRirekiByPkBean hoyuuKhTtdkRirekiByPkBean =
                        new HoyuuKhTtdkRirekiByPkBean(null);

                    if (C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(kykSyouhn.getSyoumetujiyuu())){
                        svKiykSyuhnDataList = srKaiyakuHenreikinDbaStatement.
                            getKiykSyuhnDatasBySyonoSyutkkbn(svKiykHnriknSutugk.getSyono(), C_SyutkKbn.SYU);

                        for (SV_KiykSyuhnData kiykSyuhnData : svKiykSyuhnDataList) {

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

                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyono(kykSyouhn.getSyono());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setHenkousikibetukey(kykSyouhn.
                            getHenkousikibetukey());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyutkkbn(kykSyouhn.getSyutkkbn());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setYuukousyoumetukbn(kykSyouhn.
                            getYuukousyoumetukbn());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyoumetuymd(kykSyouhn.getSyoumetuymd());
                        hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyoumetujiyuu(kykSyouhn.getSyoumetujiyuu());

                        hoyuuKhTtdkRirekiByPkBean = srKaiyakuHenreikinDbaStatement.
                            getKhTtdkRireki(kykSyouhn.getSyono(), kykSyouhn.getHenkousikibetukey());
                    }

                    SrHoyuuKeiyakuCheck srHoyuuKeiyakuCheck = SWAKInjector.getInstance(SrHoyuuKeiyakuCheck.class);

                    C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(
                        batchParam.getKijyunymd(),
                        svKiykHnriknSutugk.getSyono(),
                        svKiykHnriknSutugk.getSkeikeijyouym(),
                        hoyuKykSyouhnsBySyonoSyutkkbnBean,
                        hoyuuKhTtdkRirekiByPkBean,
                        khBikinkanriList,
                        siBikinkanriList);

                    if (!C_HoyuuCheckKekkaKbn.HOYUUTAISYOU.eq(hoyuuCheckKekkaKbn)) {

                        continue;
                    }

                    if (!C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(hoyuKykSyouhnsBySyonoSyutkkbnBean.
                        getSyoumetujiyuu())){
                        svKiykSyuhnDataList = srKaiyakuHenreikinDbaStatement
                            .getKiykSyuhnDatasBySyonoSyutkkbn(svKiykHnriknSutugk.getSyono(), C_SyutkKbn.SYU);
                    }

                    SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector
                        .getInstance(SrGetTokutejitenSyohnInfo.class);

                    TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                        C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                        svKiykHnriknSutugk.getSyono(),
                        batchParam.getKijyunymd(),
                        "",
                        svKiykSyuhnDataList);

                    TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean
                        .getTkJitenKeiyakuSyouhinKijyunBeanAto();

                    int syohinHanteiKbn = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

                    IT_KhSisuurendoTmttkn khSisuurendoTmttkn = new IT_KhSisuurendoTmttkn();

                    List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanList =
                        new ArrayList<SrGetTokutejitenTmttknInfoBean>();

                    if ((syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR
                        || syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20)
                        && (BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            batchParam.getKijyunymd()) == BizDateUtil.COMPARE_EQUAL
                            || BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                                batchParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER)) {
                        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
                            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                        srGetTokutejitenTmttknInfoBeanList =
                            srGetTokutejitenSisuurendoTmttknInfo.exec(svKiykHnriknSutugk.getSyono(),
                                batchParam.getKijyunymd(), null, svKiykSyuhnDataList);

                        khSisuurendoTmttkn = srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                            batchParam.getKijyunymd(),
                            null, srGetTokutejitenTmttknInfoBeanList).getKhSisuurendoTmttknAto();
                    }

                    List<IT_HokenryouTmttkn> hokenryouTmttknLst = Lists.newArrayList();

                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  &&
                        (BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            batchParam.getKijyunymd()) == BizDateUtil.COMPARE_EQUAL
                            || BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                                batchParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER)) {
                        hokenryouTmttknLst = srKaiyakuHenreikinDbaStatement.getHokenryouTmttkns(
                            svKiykHnriknSutugk.getSyono(),
                            BizDateYM.valueOf(SrCommonConstants.YM_ALL9));
                    }

                    SrKaiyakuHenreikinItemEditor srKaiyakuHenreikinItemEditor = SWAKInjector
                        .getInstance(SrKaiyakuHenreikinItemEditor.class);

                    boolean editKoumokuErrorFlg = srKaiyakuHenreikinItemEditor.editKoumoku(
                        batchParam,
                        svKiykHnriknSutugk,
                        tkJitenKeiyakuSyouhinKijyunBean,
                        kaiykHrSoutougakuTy,
                        syohinHanteiKbn,
                        khSisuurendoTmttkn,
                        hokenryouTmttknLst,
                        svKiykSyuhnDataList);

                    if (!editKoumokuErrorFlg) {

                        BizPropertyInitializer.initialize(kaiykHrSoutougakuTy);

                        SrKaiyakuHenreikinConverter.convertPadding(kaiykHrSoutougakuTy);

                        kaiykHrSoutougakuTyList.add(kaiykHrSoutougakuTy);

                        batchParam.setSyorikensuu(batchParam.getSyorikensuu() + 1);

                    }
                    else {

                        continue;
                    }
                }
            }
        }

        if (SrKaiyakuHenreikinParam.RGHDM001.equals(batchParam.getIbKakutyoujobcd()) &&
            batchParam.getErrorSyoriKensuu() != 0) {

            throw new BizAppException(MessageId.IBC1027, "数理用エラー情報テーブル", kbnkey,
                String.valueOf(batchParam.getErrorSyoriKensuu()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, "解約返戻金相当額Fテーブル（中）", kbnkey,
            String.valueOf(batchParam.getSyorikensuu())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, "数理用エラー情報テーブル", kbnkey,
            String.valueOf(batchParam.getErrorSyoriKensuu())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, kbnkey));

    }
}
