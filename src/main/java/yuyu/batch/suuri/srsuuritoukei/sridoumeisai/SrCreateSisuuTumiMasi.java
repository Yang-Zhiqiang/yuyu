package yuyu.batch.suuri.srsuuritoukei.sridoumeisai;

import java.math.BigDecimal;
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
 * 数理統計 数理統計 異動明細情報作成 指数積増内部生成処理
 */
public class SrCreateSisuuTumiMasi {

    private int tableCount;

    private int itTableCount;

    private static final String ITKHSISUURENDOTMTTKN = "IT_KhSisuurendoTmttkn";

    private static final String SISUURENDOUTMTTKNGN = "sisuurendoutmttkngk";

    public int getTableCount() {
        return tableCount;
    }

    public int getItTableCount() {
        return itTableCount;
    }

    public void execute(SrIdouMeisaiBatchParam pSrIdouMeisaiBatchParam, String pNaibuRcdKbn,
        SV_IdouMeisai pIdouMeisai, BizDate pSisuuTumimasiKrkYmd, String pHenkSkbtkey, BizDate pSyoriYmd) {

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

            if (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(pNaibuRcdKbn)) {
                tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanMae();
            }

            else if (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD.equals(pNaibuRcdKbn)) {
                tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();
            }

            if(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {

                return;
            }

            int  hanteiKekka = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

            IT_KhSisuurendoTmttkn wkKhSisuurendoTmttknMae = new IT_KhSisuurendoTmttkn();
            IT_KhSisuurendoTmttkn wkKhSisuurendoTmttknAto = new IT_KhSisuurendoTmttkn();

            if (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(pNaibuRcdKbn)) {

                SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo = SWAKInjector
                    .getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst = srGetTokutejitenSisuurendoTmttknInfo
                    .exec(pIdouMeisai.getSyono(), null, pIdouMeisai.getHenkousikibetukey(), kiykSyuhnDataLst);

                KhSisuurendoTmttknBean khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                    .getSisuurendoTmttknInfo(null, pIdouMeisai.getHenkousikibetukey(), srGetTokutejitenTmttknInfoBeanLst);

                wkKhSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

                List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean>
                kykHkHkRrkLst = srIdouMeisaiBatchDbAccess.getKhHenkouRirekis(
                    pIdouMeisai.getSyono(),
                    pHenkSkbtkey,
                    ITKHSISUURENDOTMTTKN,
                    SISUURENDOUTMTTKNGN);

                if (kykHkHkRrkLst.size() > 0) {

                    wkKhSisuurendoTmttknMae.setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(kykHkHkRrkLst.get(0).getBfrnaiyouoriginal()) ,
                        wkKhSisuurendoTmttknMae.getSisuurendoutmttkngk().getType()));
                }

                srGetTokutejitenTmttknInfoBeanLst = srGetTokutejitenSisuurendoTmttknInfo
                    .exec(pIdouMeisai.getSyono(), null, pHenkSkbtkey, kiykSyuhnDataLst);

                khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                    .getSisuurendoTmttknInfo(null, pHenkSkbtkey, srGetTokutejitenTmttknInfoBeanLst);
                wkKhSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();
            }

            else if (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD.equals(pNaibuRcdKbn)) {

                SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo = SWAKInjector
                    .getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst = srGetTokutejitenSisuurendoTmttknInfo
                    .exec(pIdouMeisai.getSyono(), null, pHenkSkbtkey, kiykSyuhnDataLst);

                KhSisuurendoTmttknBean khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                    .getSisuurendoTmttknInfo(null, pHenkSkbtkey, srGetTokutejitenTmttknInfoBeanLst);

                wkKhSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

                srGetTokutejitenTmttknInfoBeanLst = srGetTokutejitenSisuurendoTmttknInfo
                    .exec(pIdouMeisai.getSyono(), null, pIdouMeisai.getHenkousikibetukey(), kiykSyuhnDataLst);

                khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                    .getSisuurendoTmttknInfo(null, pIdouMeisai.getHenkousikibetukey(), srGetTokutejitenTmttknInfoBeanLst);
                wkKhSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

                List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean>
                kykHkHkRrkLst = srIdouMeisaiBatchDbAccess.getKhHenkouRirekis(
                    pIdouMeisai.getSyono(),
                    pHenkSkbtkey,
                    ITKHSISUURENDOTMTTKN,
                    SISUURENDOUTMTTKNGN);

                if (kykHkHkRrkLst.size() > 0) {

                    wkKhSisuurendoTmttknAto.setSisuurendoutmttkngk(BizCurrency.valueOf(
                        new BigDecimal(kykHkHkRrkLst.get(0).getNewnaiyouoriginal()), wkKhSisuurendoTmttknAto.getSisuurendoutmttkngk().getType()));
                }
            }

            SrIdouMeisaiBatchEdit srIdouMeisaiBatchEdit = SWAKInjector.getInstance(SrIdouMeisaiBatchEdit.class);
            ZT_IdouMeisaiTy idouMeisaiTyMinus = new ZT_IdouMeisaiTy();
            ST_IdouMeisaiTyukeiyouItzHzn idouMeisaiTyukeiyouItzHznMinus = new ST_IdouMeisaiTyukeiyouItzHzn();
            boolean errorFlag = false;

            C_SuuriIdoKbn suuriIdoKbn = C_SuuriIdoKbn.BLNK;

            if (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(pNaibuRcdKbn)) {
                suuriIdoKbn = C_SuuriIdoKbn.SISUUTUMIMASITRKS;
            }
            else if (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD.equals(pNaibuRcdKbn)) {
                suuriIdoKbn = C_SuuriIdoKbn.SISUUTUMIMASI;
            }

            errorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                pSrIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBean,
                idouMeisaiTyMinus,
                suuriIdoKbn,
                C_IdouRecordKbn.MINUSRECORD,
                pSisuuTumimasiKrkYmd,
                idouMeisaiTyukeiyouItzHznMinus,
                hanteiKekka,
                wkKhSisuurendoTmttknMae,
                pSisuuTumimasiKrkYmd,
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
                suuriIdoKbn,
                C_IdouRecordKbn.PLUSRECORD,
                pSisuuTumimasiKrkYmd,
                idouMeisaiTyukeiyouItzHznPlus,
                hanteiKekka,
                wkKhSisuurendoTmttknAto,
                pSisuuTumimasiKrkYmd,
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