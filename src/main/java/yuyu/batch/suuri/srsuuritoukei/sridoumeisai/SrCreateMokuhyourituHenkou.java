package yuyu.batch.suuri.srsuuritoukei.sridoumeisai;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.KhSisuurendoTmttknBean;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenSisuurendoTmttknInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTmttknInfoBean;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.classification.C_IdouRecordKbn;
import yuyu.def.classification.C_SuuriIdoKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_IdouMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_IdouMeisaiTy;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;

/**
 * 数理統計 数理統計 異動明細情報作成 目標率変更内部生成処理
 */
public class SrCreateMokuhyourituHenkou {

    private static final String ITKHSISUURENDOTMTTKN = "IT_KhSisuurendoTmttkn";

    private static final String SISUURENDOUTMTTKNGN = "sisuurendoutmttkngk";

    private static final String TEIRITUTMTTKNGN = "teiritutmttkngk";

    private int tableCount;

    private int itTableCount;

    public int getTableCount() {
        return tableCount;
    }

    public int getItTableCount() {
        return itTableCount;
    }

    public void execute(SrIdouMeisaiBatchParam pSrIdouMeisaiBatchParam, String pNaibuRcdKbn,
        SV_IdouMeisai pIdouMeisai, BizDate pTargetTkykkykhenkoYmd, String pHenkSkbtkey, BizDate pSyoriYmd,
        BizDate pSyoruiukeYmd) {

        try (
            EntityInserter<ZT_IdouMeisaiTy> idouMeisaiTyLst = new EntityInserter<>();
            EntityInserter<ST_IdouMeisaiTyukeiyouItzHzn> idouMeisaiTyukeiyouItzHznLst = new EntityInserter<>();) {

            TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
                SWAKInjector.getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);

            SrIdouMeisaiBatchDbAccess srIdouMeisaiBatchDbAccess = SWAKInjector.
                getInstance(SrIdouMeisaiBatchDbAccess.class);

            List<SV_KiykSyuhnData>  kiykSyuhnDataLst = srIdouMeisaiBatchDbAccess.getKiykSyuhnData(
                pIdouMeisai.getSyono(),
                C_SyutkKbn.SYU);

            SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

            TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                pIdouMeisai.getSyono(),
                null,
                pHenkSkbtkey,
                kiykSyuhnDataLst);

            if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pNaibuRcdKbn) ||
                SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pNaibuRcdKbn)) {
                tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanMae();
            }

            else if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pNaibuRcdKbn) ||
                SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(pNaibuRcdKbn)) {
                tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();
            }

            int  hanteiKekka = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

            IT_KhSisuurendoTmttkn wkKhSisuurendoTmttkn = new IT_KhSisuurendoTmttkn();

            if (hanteiKekka == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                hanteiKekka == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo = SWAKInjector
                    .getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst = new ArrayList<SrGetTokutejitenTmttknInfoBean>();

                KhSisuurendoTmttknBean khSisuurendoTmttknBean = new KhSisuurendoTmttknBean();

                if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pNaibuRcdKbn) ||
                    SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pNaibuRcdKbn)) {

                    srGetTokutejitenTmttknInfoBeanLst = srGetTokutejitenSisuurendoTmttknInfo
                        .exec(pIdouMeisai.getSyono(), null, pHenkSkbtkey, kiykSyuhnDataLst);

                    khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                        .getSisuurendoTmttknInfo(null, pHenkSkbtkey, srGetTokutejitenTmttknInfoBeanLst);

                    if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pNaibuRcdKbn)) {
                        wkKhSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();
                    }
                    else if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pNaibuRcdKbn)) {

                        wkKhSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();
                    }
                }
                else if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
                    SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(pNaibuRcdKbn)) {

                    srGetTokutejitenTmttknInfoBeanLst = srGetTokutejitenSisuurendoTmttknInfo
                        .exec(pIdouMeisai.getSyono(), null, pIdouMeisai.getHenkousikibetukey(), kiykSyuhnDataLst);

                    khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                        .getSisuurendoTmttknInfo(pIdouMeisai.getSyoriYmd(), pIdouMeisai.getHenkousikibetukey(), srGetTokutejitenTmttknInfoBeanLst);

                    wkKhSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

                    if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pNaibuRcdKbn)) {

                        String tmttknkoumokuid = null;
                        
                        if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {

                            tmttknkoumokuid = TEIRITUTMTTKNGN;
                        }
                        else {

                            tmttknkoumokuid = SISUURENDOUTMTTKNGN;
                        }
                        
                        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiLst =
                            srIdouMeisaiBatchDbAccess.getKhHenkouRirekis(pIdouMeisai.getSyono(),
                                pHenkSkbtkey,
                                ITKHSISUURENDOTMTTKN,
                                tmttknkoumokuid);

                        if (khHenkouRirekiLst.size() > 0) {
                            if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {

                                wkKhSisuurendoTmttkn.setTeiritutmttkngk(BizCurrency.valueOf(new BigDecimal(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal()) ,
                                    wkKhSisuurendoTmttkn.getTeiritutmttkngk().getType()));
                            }
                            else {

                                wkKhSisuurendoTmttkn.setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal()) ,
                                    wkKhSisuurendoTmttkn.getSisuurendoutmttkngk().getType()));
                            }
                        }
                    }
                }
            }
            SrIdouMeisaiBatchEdit srIdouMeisaiBatchEdit = SWAKInjector.getInstance(SrIdouMeisaiBatchEdit.class);
            ZT_IdouMeisaiTy idouMeisaiTyMinus = new ZT_IdouMeisaiTy();
            ST_IdouMeisaiTyukeiyouItzHzn idouMeisaiTyukeiyouItzHznMinus = new ST_IdouMeisaiTyukeiyouItzHzn();
            boolean errorFlag = false;

            errorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                pSrIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBean,
                idouMeisaiTyMinus,
                C_SuuriIdoKbn.MOKUHYOURITUHENKOU,
                C_IdouRecordKbn.MINUSRECORD,
                pTargetTkykkykhenkoYmd,
                idouMeisaiTyukeiyouItzHznMinus,
                hanteiKekka,
                wkKhSisuurendoTmttkn,
                pTargetTkykkykhenkoYmd,
                null,
                null,
                null,
                pNaibuRcdKbn,
                pSyoriYmd,
                pHenkSkbtkey);

            ZT_IdouMeisaiTy idouMeisaiTyPlus = new ZT_IdouMeisaiTy();
            ST_IdouMeisaiTyukeiyouItzHzn idouMeisaiTyukeiyouItzHznPlus = new ST_IdouMeisaiTyukeiyouItzHzn();

            errorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                pSrIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBean,
                idouMeisaiTyPlus,
                C_SuuriIdoKbn.MOKUHYOURITUHENKOU,
                C_IdouRecordKbn.PLUSRECORD,
                pTargetTkykkykhenkoYmd,
                idouMeisaiTyukeiyouItzHznPlus,
                hanteiKekka,
                wkKhSisuurendoTmttkn,
                pTargetTkykkykhenkoYmd,
                null,
                null,
                null,
                pNaibuRcdKbn,
                pSyoriYmd,
                pHenkSkbtkey);

            if (errorFlag) {
                return;
            }

            BizPropertyInitializer.initialize(idouMeisaiTyMinus);
            SrIdouMeisaiConverter.convertPadding(idouMeisaiTyMinus);
            idouMeisaiTyLst.add(idouMeisaiTyMinus);
            tableCount++;
            BizPropertyInitializer.initialize(idouMeisaiTyPlus);
            SrIdouMeisaiConverter.convertPadding(idouMeisaiTyPlus);
            idouMeisaiTyLst.add(idouMeisaiTyPlus);
            tableCount++;

            if (hanteiKekka == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                hanteiKekka == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                BizPropertyInitializer.initialize(idouMeisaiTyukeiyouItzHznMinus);
                SrIdouMeisaiConverter.convertPadding(idouMeisaiTyukeiyouItzHznMinus);
                idouMeisaiTyukeiyouItzHznLst.add(idouMeisaiTyukeiyouItzHznMinus);
                itTableCount++;
                BizPropertyInitializer.initialize(idouMeisaiTyukeiyouItzHznPlus);
                SrIdouMeisaiConverter.convertPadding(idouMeisaiTyukeiyouItzHznPlus);
                idouMeisaiTyukeiyouItzHznLst.add(idouMeisaiTyukeiyouItzHznPlus);
                itTableCount++;
            }
        }
    }
}