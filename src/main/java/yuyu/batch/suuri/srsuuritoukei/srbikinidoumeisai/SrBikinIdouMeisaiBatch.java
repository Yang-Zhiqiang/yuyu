package yuyu.batch.suuri.srsuuritoukei.srbikinidoumeisai;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.KhSisuurendoTmttknBean;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenSisuurendoTmttknInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTmttknInfoBean;
import yuyu.common.suuri.srcommon.SrTyukeiyouItzHznSakujyo;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_IdouRecordKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_BikinIdouMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_BikinIdouMeisaiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 備金異動明細情報作成
 */
public class SrBikinIdouMeisaiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrBikinIdouMeisaiBatchParam srBikinIdouMeisaiBatchParam;

    private int tableTourokuCount;

    private int itjTableTourokuCount;

    @Override
    public BatchParam getParam() {
        return srBikinIdouMeisaiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        tableTourokuCount = 0;

        itjTableTourokuCount = 0;

        SrBikinIdouMeisaiBatchDbAccess srBikinIdouMeisaiBatchDbAccess =
            SWAKInjector.getInstance(SrBikinIdouMeisaiBatchDbAccess.class);

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(srBikinIdouMeisaiBatchParam);

        try (EntityInserter<ZT_BikinIdouMeisaiTy> ztBikinIdouMeisaiTyList = new EntityInserter<>();
            EntityInserter<ST_IdouMeisaiTyukeiyouItzHzn> idouMeisaiTyukeiyouItzHznList = new EntityInserter<>()) {

            List<SV_BikinIdouMeisai> bikinIdouMeisaiLst =
                srBikinIdouMeisaiBatchDbAccess.getBikinIdouMeisais(C_BknJkuKbn.SINBI,
                    C_BknrigiKbn.DEL, srBikinIdouMeisaiBatchParam.getKijyunymd());

            String syonoBefore = "";

            for (SV_BikinIdouMeisai bikinIdouMeisai : bikinIdouMeisaiLst) {

                if (C_BkncdKbn.YENDTHNKHR.eq(bikinIdouMeisai.getBkncdkbn())) {

                    continue;
                }

                if(C_BkncdKbn.SIBOUUKETUKE.eq(bikinIdouMeisai.getBkncdkbn()) ||
                    C_BkncdKbn.SIBOUKARIUKETUKE.eq(bikinIdouMeisai.getBkncdkbn())) {

                    List<JT_SiBikinkanri> bikinIdouMeisaiLstb = srBikinIdouMeisaiBatchDbAccess.getSiBikinkanri(
                        bikinIdouMeisai.getSyono(), bikinIdouMeisai.getKessankijyunymd());

                    if (bikinIdouMeisaiLstb != null && bikinIdouMeisaiLstb.size() != 0) {

                        continue;
                    }
                }

                if (bikinIdouMeisai.getSyono().equals(syonoBefore)) {

                    srBikinIdouMeisaiBatchParam.setKeiyakuMFkoushinCTRrenban(
                        srBikinIdouMeisaiBatchParam.getKeiyakuMFkoushinCTRrenban() + 1);
                }
                else {

                    srBikinIdouMeisaiBatchParam.setKeiyakuMFkoushinCTRrenban(1);
                }

                syonoBefore = bikinIdouMeisai.getSyono();

                insertData(bikinIdouMeisai, ztBikinIdouMeisaiTyList, idouMeisaiTyukeiyouItzHznList);
            }
        }

        if (srBikinIdouMeisaiBatchParam.getErrorCount() != 0 &&
            srBikinIdouMeisaiBatchParam.getIbKakutyoujobcd().equals(SrBikinIdouMeisaiBatchParam.RGHCM004)) {

            throw new BizAppException(MessageId.ISA1001, "数理用エラー情報テーブル",
                String.valueOf(srBikinIdouMeisaiBatchParam.getErrorCount()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "備金異動明細Fテーブル（中）",
            String.valueOf(tableTourokuCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "異動明細中継用一時保存テーブル",
            String.valueOf(itjTableTourokuCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
            String.valueOf(srBikinIdouMeisaiBatchParam.getErrorCount())));
    }

    private void insertData(SV_BikinIdouMeisai bikinIdouMeisai,
        EntityInserter<ZT_BikinIdouMeisaiTy> pZtBikinIdouMeisaiTyList,
        EntityInserter<ST_IdouMeisaiTyukeiyouItzHzn> pIdouMeisaiTyukeiyouItzHznList) {

        BizDate kouryokuhasseiymd = null;

        SrBikinIdouMeisaiBatchDbAccess srBikinIdouMeisaiBatchDbAccess = SWAKInjector
            .getInstance(SrBikinIdouMeisaiBatchDbAccess.class);

        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanAto = SWAKInjector
            .getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanMae = SWAKInjector
            .getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo = SWAKInjector
            .getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        List<SV_KiykSyuhnData> svKiykSyuhnDataList = srBikinIdouMeisaiBatchDbAccess.getKiykSyuhnDatas(
            bikinIdouMeisai.getSyono(), C_SyutkKbn.SYU);

        if ( C_BkncdKbn.GENGK.eq(bikinIdouMeisai.getBkncdkbn())) {

            TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                bikinIdouMeisai.getSyono(),
                null,
                bikinIdouMeisai.getHenkousikibetukey(),
                svKiykSyuhnDataList);

            tkJitenKeiyakuSyouhinKijyunBeanAto = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

            tkJitenKeiyakuSyouhinKijyunBeanMae = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanMae();

            kouryokuhasseiymd = tkJitenKeiyakuSyouhinKijyunBeanAto.getKouryokuhasseiymd();

        }
        else {

            tkJitenKeiyakuSyouhinKijyunBeanAto = srGetTokutejitenSyohnInfo.exec(
                C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                bikinIdouMeisai.getSyono(),
                srBikinIdouMeisaiBatchParam.getKijyunymd(),
                "",
                svKiykSyuhnDataList)
                .getTkJitenKeiyakuSyouhinKijyunBeanAto();
        }

        int syouhnUtilKekka = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBeanAto.getSyouhncd());

        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = new IT_KhSisuurendoTmttkn();
        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = new IT_KhSisuurendoTmttkn();
        BizDate tmttknInfoKijyunYmd = null;

        if (syouhnUtilKekka == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syouhnUtilKekka == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList = new ArrayList<IT_KhSisuurendoTmttkn>();

            List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanList = new ArrayList<SrGetTokutejitenTmttknInfoBean>();

            KhSisuurendoTmttknBean khSisuurendoTmttknBean = new KhSisuurendoTmttknBean();

            tmttknInfoKijyunYmd = bikinIdouMeisai.getCalckijyunymd();

            if (tkJitenKeiyakuSyouhinKijyunBeanAto.getYendthnkymd() == null) {

                if (BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd(),
                    tmttknInfoKijyunYmd) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd(),
                        tmttknInfoKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

                    if (C_BkncdKbn.GENGK.eq(bikinIdouMeisai.getBkncdkbn())) {

                        srGetTokutejitenTmttknInfoBeanList = srGetTokutejitenSisuurendoTmttknInfo.exec(
                            bikinIdouMeisai.getSyono(), null, bikinIdouMeisai.getHenkousikibetukey(),
                            svKiykSyuhnDataList);

                        khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(null,
                            bikinIdouMeisai.getHenkousikibetukey(), srGetTokutejitenTmttknInfoBeanList);

                        khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

                        khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();
                    }
                    else{
                        srGetTokutejitenTmttknInfoBeanList = srGetTokutejitenSisuurendoTmttknInfo.exec(
                            bikinIdouMeisai.getSyono(), tmttknInfoKijyunYmd, null, svKiykSyuhnDataList);

                        khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                            tmttknInfoKijyunYmd, null, srGetTokutejitenTmttknInfoBeanList);

                        khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();
                    }
                }
                else {

                    khSisuurendoTmttknList =
                        srBikinIdouMeisaiBatchDbAccess.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(
                            bikinIdouMeisai.getSyono(), tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd());

                    khSisuurendoTmttknAto = khSisuurendoTmttknList.get(0);
                }
            }
        }
        else if (syouhnUtilKekka == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            tkJitenKeiyakuSyouhinKijyunBeanAto.getYendthnkymd() != null) {

            tmttknInfoKijyunYmd = bikinIdouMeisai.getCalckijyunymd();
        }

        List<IT_KykSyouhnHnkmae> KykSyouhnHnkmaeList = new ArrayList<IT_KykSyouhnHnkmae>();

        KykSyouhnHnkmaeList =
            srBikinIdouMeisaiBatchDbAccess.getKykSyouhnHnkmaeBySyonoHenkousikibetukeyDesc(bikinIdouMeisai.getSyono());

        List<IT_HokenryouTmttkn> hokenryouTmttknList = new ArrayList<>();
        if (syouhnUtilKekka == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN &&
            !C_BkncdKbn.GENGK.eq(bikinIdouMeisai.getBkncdkbn())) {
            hokenryouTmttknList = srBikinIdouMeisaiBatchDbAccess.getHokenryouTmttknsBySyonoTmttkntaisyouymDesc(
                bikinIdouMeisai.getSyono(),
                BizDateYM.valueOf(SrCommonConstants.YM_ALL9));
        }

        SrBikinIdouMeisaiBatchEdit srBikinIdouMeisaiBatchEdit = SWAKInjector.getInstance(
            SrBikinIdouMeisaiBatchEdit.class);

        boolean errorFlag = false;

        ZT_BikinIdouMeisaiTy ztBikinIdouMeisaiTyGensyou = new ZT_BikinIdouMeisaiTy();
        ZT_BikinIdouMeisaiTy ztBikinIdouMeisaiTyZouka = new ZT_BikinIdouMeisaiTy();
        ZT_BikinIdouMeisaiTy ztBikinIdouMeisaiTyTan = new ZT_BikinIdouMeisaiTy();

        ST_IdouMeisaiTyukeiyouItzHzn idouMeisaiTyukeiyouItzHznGensyou = new ST_IdouMeisaiTyukeiyouItzHzn();
        ST_IdouMeisaiTyukeiyouItzHzn idouMeisaiTyukeiyouItzHznZouka = new ST_IdouMeisaiTyukeiyouItzHzn();
        ST_IdouMeisaiTyukeiyouItzHzn idouMeisaiTyukeiyouItzHznTan = new ST_IdouMeisaiTyukeiyouItzHzn();

        if (C_BkncdKbn.GENGK.eq(bikinIdouMeisai.getBkncdkbn())) {

            errorFlag = srBikinIdouMeisaiBatchEdit.editKoumoku(srBikinIdouMeisaiBatchParam,
                bikinIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanMae,
                ztBikinIdouMeisaiTyGensyou,
                C_IdouRecordKbn.MINUSRECORD,
                kouryokuhasseiymd,
                idouMeisaiTyukeiyouItzHznGensyou,
                syouhnUtilKekka,
                khSisuurendoTmttknMae,
                tmttknInfoKijyunYmd,
                svKiykSyuhnDataList,
                KykSyouhnHnkmaeList,
                hokenryouTmttknList);

            errorFlag = srBikinIdouMeisaiBatchEdit.editKoumoku(srBikinIdouMeisaiBatchParam,
                bikinIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanAto,
                ztBikinIdouMeisaiTyZouka,
                C_IdouRecordKbn.PLUSRECORD,
                kouryokuhasseiymd,
                idouMeisaiTyukeiyouItzHznZouka,
                syouhnUtilKekka,
                khSisuurendoTmttknAto,
                tmttknInfoKijyunYmd,
                svKiykSyuhnDataList,
                KykSyouhnHnkmaeList,
                hokenryouTmttknList);

            if (errorFlag == true) {

                return;
            }
        }
        else {

            errorFlag = srBikinIdouMeisaiBatchEdit.editKoumoku(srBikinIdouMeisaiBatchParam,
                bikinIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanAto,
                ztBikinIdouMeisaiTyTan,
                C_IdouRecordKbn.SINGLERECORD,
                kouryokuhasseiymd,
                idouMeisaiTyukeiyouItzHznTan,
                syouhnUtilKekka,
                khSisuurendoTmttknAto,
                tmttknInfoKijyunYmd,
                svKiykSyuhnDataList,
                KykSyouhnHnkmaeList,
                hokenryouTmttknList);

            if (errorFlag == true) {

                return;
            }
        }

        if (C_BkncdKbn.GENGK.eq(bikinIdouMeisai.getBkncdkbn())) {

            BizPropertyInitializer.initialize(ztBikinIdouMeisaiTyGensyou);

            SrBikinIdouMeisaiConverter.convertPadding(ztBikinIdouMeisaiTyGensyou);

            pZtBikinIdouMeisaiTyList.add(ztBikinIdouMeisaiTyGensyou);

            tableTourokuCount++;

            BizPropertyInitializer.initialize(ztBikinIdouMeisaiTyZouka);

            SrBikinIdouMeisaiConverter.convertPadding(ztBikinIdouMeisaiTyZouka);

            pZtBikinIdouMeisaiTyList.add(ztBikinIdouMeisaiTyZouka);

            tableTourokuCount++;

            if (syouhnUtilKekka == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                syouhnUtilKekka == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
                (syouhnUtilKekka == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                tkJitenKeiyakuSyouhinKijyunBeanMae.getYendthnkymd() != null &&
                tkJitenKeiyakuSyouhinKijyunBeanAto.getYendthnkymd() != null)) {

                BizPropertyInitializer.initialize(idouMeisaiTyukeiyouItzHznGensyou);

                SrBikinIdouMeisaiConverter.convertPadding(idouMeisaiTyukeiyouItzHznGensyou);

                pIdouMeisaiTyukeiyouItzHznList.add(idouMeisaiTyukeiyouItzHznGensyou);

                itjTableTourokuCount++;

                BizPropertyInitializer.initialize(idouMeisaiTyukeiyouItzHznZouka);

                SrBikinIdouMeisaiConverter.convertPadding(idouMeisaiTyukeiyouItzHznZouka);

                pIdouMeisaiTyukeiyouItzHznList.add(idouMeisaiTyukeiyouItzHznZouka);

                itjTableTourokuCount++;
            }
        }
        else {

            BizPropertyInitializer.initialize(ztBikinIdouMeisaiTyTan);

            SrBikinIdouMeisaiConverter.convertPadding(ztBikinIdouMeisaiTyTan);

            pZtBikinIdouMeisaiTyList.add(ztBikinIdouMeisaiTyTan);

            tableTourokuCount++;

            if (syouhnUtilKekka == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                syouhnUtilKekka == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
                (syouhnUtilKekka == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                tkJitenKeiyakuSyouhinKijyunBeanAto.getYendthnkymd() != null)) {

                BizPropertyInitializer.initialize(idouMeisaiTyukeiyouItzHznTan);

                SrBikinIdouMeisaiConverter.convertPadding(idouMeisaiTyukeiyouItzHznTan);

                pIdouMeisaiTyukeiyouItzHznList.add(idouMeisaiTyukeiyouItzHznTan);

                itjTableTourokuCount++;
            }
        }
    }
}