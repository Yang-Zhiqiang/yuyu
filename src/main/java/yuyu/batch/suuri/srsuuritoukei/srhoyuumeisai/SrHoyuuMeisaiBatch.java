package yuyu.batch.suuri.srsuuritoukei.srhoyuumeisai;

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
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenSisuurendoTmttknInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTmttknInfoBean;
import yuyu.common.suuri.srcommon.SrHoyuuKeiyakuCheck;
import yuyu.common.suuri.srcommon.SrTyukeiyouItzHznSakujyo;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HoyuuCheckKekkaKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_HoyuuMeisaiTy;
import yuyu.def.hozen.result.bean.HoyuKykSyouhnsBySyonoSyutkkbnBean;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 保有明細情報作成
 */
public class SrHoyuuMeisaiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrHoyuuMeisaiBatchParam srHoyuuMeisaiBatchParam;

    @Inject
    private AS_Kinou kinou;

    private int tableCount;

    private int tempTableCount;

    @Override
    public BatchParam getParam() {
        return srHoyuuMeisaiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        tableCount = 0;

        tempTableCount = 0;

        String kbnkey = srHoyuuMeisaiBatchParam.getHeisoukbn();
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, kbnkey));

        SrHoyuuMeisaiBatchDbAccess srHoyuuMeisaiBatchDbAccess =
            SWAKInjector.getInstance(SrHoyuuMeisaiBatchDbAccess.class);
        SrHoyuuKeiyakuCheck srHoyuuKeiyakuCheck = SWAKInjector.getInstance(SrHoyuuKeiyakuCheck.class);

        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

        if (!BizUtil.isBlank(kbnkey) && SrCommonConstants.DEFAULT_STRING_ZERO_2.equals(kbnkey)){
            SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
            srTyukeiyouItzHznSakujyo.deleteItzHznTable(srHoyuuMeisaiBatchParam);
        }

        try (EntityInserter<ZT_HoyuuMeisaiTy> ztHoyuuMeisaiTyList = new EntityInserter<>();
            EntityInserter<ST_HoyuuMeisaiTyukeiyouItzHzn> stHoyuuMeisaiItzHznList = new EntityInserter<>();
            ExDBResults<SV_HoyuuMeisai> svHoyuuMeisaiList = srHoyuuMeisaiBatchDbAccess.getHoyuuMeisais(kbnkey)) {

            for (SV_HoyuuMeisai svHoyuuMeisai : svHoyuuMeisaiList) {

                List<HoyuKykSyouhnsBySyonoSyutkkbnBean> hoyuKykSyouhnsBySyonoSyutkkbnBeanList =
                    srHoyuuMeisaiBatchDbAccess.getKiykSyuhnDatas(svHoyuuMeisai.getSyono(), C_SyutkKbn.SYU);

                for (HoyuKykSyouhnsBySyonoSyutkkbnBean hoyuKykSyouhnsBySyonoSyutkkbnBean :
                    hoyuKykSyouhnsBySyonoSyutkkbnBeanList) {

                    ZT_HoyuuMeisaiTy ztHoyuuMeisaiTy = new ZT_HoyuuMeisaiTy();
                    ST_HoyuuMeisaiTyukeiyouItzHzn stHoyuuMeisaiTyukeiyouItzHzn = new ST_HoyuuMeisaiTyukeiyouItzHzn();

                    List<IT_KhBikinkanri> itKhBikinkanriList = srHoyuuMeisaiBatchDbAccess.
                        getKhBikinkanris(svHoyuuMeisai.getSyono());

                    List<JT_SiBikinkanri> jtSiBikinkanriList = srHoyuuMeisaiBatchDbAccess.
                        getSiBikinkanris(svHoyuuMeisai.getSyono());

                    List<SV_KiykSyuhnData> svKiykSyuhnDataList = new ArrayList<SV_KiykSyuhnData>();

                    HoyuuKhTtdkRirekiByPkBean hoyuuKhTtdkRirekiByPkBean = new HoyuuKhTtdkRirekiByPkBean(null);

                    if (C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(hoyuKykSyouhnsBySyonoSyutkkbnBean.
                        getSyoumetujiyuu())){
                        svKiykSyuhnDataList = srHoyuuMeisaiBatchDbAccess.
                            getKiykSyuhnList(svHoyuuMeisai.getSyono(), C_SyutkKbn.SYU);

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
                        hoyuuKhTtdkRirekiByPkBean = srHoyuuMeisaiBatchDbAccess.
                            getKhTtdkRireki(hoyuKykSyouhnsBySyonoSyutkkbnBean.getSyono(),
                                hoyuKykSyouhnsBySyonoSyutkkbnBean.getHenkousikibetukey());
                    }

                    C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(
                        srHoyuuMeisaiBatchParam.getKijyunymd(),
                        svHoyuuMeisai.getSyono(),
                        svHoyuuMeisai.getSkeikeijyouym(),
                        hoyuKykSyouhnsBySyonoSyutkkbnBean,
                        hoyuuKhTtdkRirekiByPkBean,
                        itKhBikinkanriList,
                        jtSiBikinkanriList);

                    if (!C_HoyuuCheckKekkaKbn.HOYUUTAISYOU.eq(hoyuuCheckKekkaKbn)) {

                        continue;
                    }

                    if (!C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(hoyuKykSyouhnsBySyonoSyutkkbnBean.
                        getSyoumetujiyuu())){
                        svKiykSyuhnDataList = srHoyuuMeisaiBatchDbAccess.
                            getKiykSyuhnList(svHoyuuMeisai.getSyono(), C_SyutkKbn.SYU);
                    }

                    TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                        C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO, svHoyuuMeisai.getSyono(),
                        srHoyuuMeisaiBatchParam.getKijyunymd(), "", svKiykSyuhnDataList);

                    TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
                        tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

                    int syohinHanteiKbn = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

                    IT_KhSisuurendoTmttkn itKhSisuurendoTmttkn = new IT_KhSisuurendoTmttkn();

                    List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanList =
                        new ArrayList<SrGetTokutejitenTmttknInfoBean>();

                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                        if (BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            srHoyuuMeisaiBatchParam.getKijyunymd()) <= BizDateUtil.COMPARE_EQUAL) {

                            SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
                                SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                            srGetTokutejitenTmttknInfoBeanList =
                                srGetTokutejitenSisuurendoTmttknInfo.exec(svHoyuuMeisai.getSyono(),
                                    srHoyuuMeisaiBatchParam.getKijyunymd(), null, svKiykSyuhnDataList);

                            itKhSisuurendoTmttkn = srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                                srHoyuuMeisaiBatchParam.getKijyunymd(),
                                null, srGetTokutejitenTmttknInfoBeanList).getKhSisuurendoTmttknAto();
                        }
                        else {

                            List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLstAsc = srHoyuuMeisaiBatchDbAccess
                                .getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(svHoyuuMeisai.getSyono(),
                                    tkJitenKeiyakuSyouhinKijyunBean.getKykymd());

                            itKhSisuurendoTmttkn = khSisuurendoTmttknLstAsc.get(0);
                        }
                    }

                    List<IT_HokenryouTmttkn> hokenryouTmttknLst = new ArrayList<>();
                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        if (BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            srHoyuuMeisaiBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_EQUAL ||
                            BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                                srHoyuuMeisaiBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER) {

                            hokenryouTmttknLst = srHoyuuMeisaiBatchDbAccess
                                .getHokenryouTmttknsBySyonoTmttknkouryokukaisiymdDesc(svHoyuuMeisai.getSyono(),
                                    BizDateYM.valueOf(SrCommonConstants.YM_ALL9));

                        }
                    }

                    List<IT_KykSyouhnHnkmae> khKykSyouhnHnkmaeLstDesc = srHoyuuMeisaiBatchDbAccess
                        .getKykSyouhnHnkmaes(svHoyuuMeisai.getSyono());

                    srHoyuuMeisaiBatchParam.setHeisoukbn(svHoyuuMeisai.getKbnkey());

                    SrHoyuuMeisaiBatchEdit srHoyuuMeisaiBatchEdit =
                        SWAKInjector.getInstance(SrHoyuuMeisaiBatchEdit.class);

                    Boolean errorFlag = srHoyuuMeisaiBatchEdit.editKoumoku(srHoyuuMeisaiBatchParam, svHoyuuMeisai,
                        tkJitenKeiyakuSyouhinKijyunBean, kinou.getSyoricd(), ztHoyuuMeisaiTy, stHoyuuMeisaiTyukeiyouItzHzn,
                        syohinHanteiKbn, itKhSisuurendoTmttkn, hokenryouTmttknLst, svKiykSyuhnDataList, khKykSyouhnHnkmaeLstDesc,
                        srGetTokutejitenTmttknInfoBeanList, tableCount);

                    if (errorFlag) {

                        continue;
                    }

                    BizPropertyInitializer.initialize(ztHoyuuMeisaiTy);

                    SrHoyuuMeisaiConverter.convertPadding(ztHoyuuMeisaiTy);

                    ztHoyuuMeisaiTyList.add(ztHoyuuMeisaiTy);

                    tableCount++;

                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
                        syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
                        (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                        tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {
                        BizPropertyInitializer.initialize(stHoyuuMeisaiTyukeiyouItzHzn);

                        SrHoyuuMeisaiConverter.convertPadding(stHoyuuMeisaiTyukeiyouItzHzn);

                        stHoyuuMeisaiItzHznList.add(stHoyuuMeisaiTyukeiyouItzHzn);

                        tempTableCount++;
                    }
                }
            }
        }

        if (srHoyuuMeisaiBatchParam.getErrorsyorikensuu() != 0 &&
            (srHoyuuMeisaiBatchParam.getIbKakutyoujobcd().equals(SrHoyuuMeisaiBatchParam.RGHAM000) ||
                srHoyuuMeisaiBatchParam.getIbKakutyoujobcd().equals(SrHoyuuMeisaiBatchParam.RGHAM004))) {

            throw new BizAppException(MessageId.IBC1027, "数理用エラー情報テーブル", kbnkey,
                String.valueOf(srHoyuuMeisaiBatchParam.getErrorsyorikensuu()));

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027,
            "保有明細Fテーブル（中）", kbnkey, String.valueOf(tableCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027,
            "保有明細中継用一時保存テーブル", kbnkey, String.valueOf(tempTableCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027,
            "数理用エラー情報テーブル", kbnkey, String.valueOf(srHoyuuMeisaiBatchParam.getErrorsyorikensuu())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, kbnkey));
    }
}