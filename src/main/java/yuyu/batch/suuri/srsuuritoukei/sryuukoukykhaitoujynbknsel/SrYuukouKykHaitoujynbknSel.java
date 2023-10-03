package yuyu.batch.suuri.srsuuritoukei.sryuukoukykhaitoujynbknsel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.haitou.CheckDJyoutai;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrHoyuuKeiyakuCheck;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HoyuuCheckKekkaKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknKarid;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.result.bean.HoyuKykSyouhnsBySyonoSyutkkbnBean;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 有効契約配当準備金データ抽出
 */
public class SrYuukouKykHaitoujynbknSel implements Batch {

    @Inject
    private SrYuukouKykHaitoujynbknSelBatchParam batchParam;

    @Inject
    private BatchLogger batchLogger;

    private static final String TABLETMTTD = "有効契約配当準備金（積立Ｄ）テーブル";

    private static final String TABLEKARID = "有効契約配当準備金（仮割当Ｄ）テーブル";

    private static final String SUURIYOUERRJYOUHOUTABLE = "数理用エラー情報テーブル";

    private int tmttdTblCount;

    private int karidTblCount;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        tmttdTblCount = 0;
        karidTblCount = 0;

        String kbnkey = batchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, kbnkey));

        SrYuukouKykHaitoujynbknSelDbaStatement dbaStatement = SWAKInjector
            .getInstance(SrYuukouKykHaitoujynbknSelDbaStatement.class);

        try (ExDBResults<SV_HoyuuMeisai> hoyuuMeisaiLst = dbaStatement.getHoyuuMeisais(kbnkey);
            EntityInserter<ST_YuukoukykHtjynbknTmttd> yuukoukykHtjynbknTmttdLst = new EntityInserter<>();
            EntityInserter<ST_YuukoukykHtjynbknKarid> yuukoukykHtjynbknKaridLst = new EntityInserter<>();) {

            for (SV_HoyuuMeisai hoyuuMeisai : hoyuuMeisaiLst) {

                List<HoyuKykSyouhnsBySyonoSyutkkbnBean> hoyuKykSyouhnsBySyonoSyutkkbnBeanLst = dbaStatement
                    .getHoyuKykSyouhnsBySyonoSyutkkbn(hoyuuMeisai.getSyono(), C_SyutkKbn.SYU);

                for (HoyuKykSyouhnsBySyonoSyutkkbnBean hoyuKykSyouhnsBySyonoSyutkkbnBean : hoyuKykSyouhnsBySyonoSyutkkbnBeanLst) {

                    List<IT_KhBikinkanri> khBikinkanriLst = dbaStatement
                        .getKhBikinkanrisBySyono(hoyuuMeisai.getSyono());
                    List<JT_SiBikinkanri> siBikinkanriLst = dbaStatement
                        .getSiBikinkanrisBySyono(hoyuuMeisai.getSyono());

                    HoyuuKhTtdkRirekiByPkBean hoyuuKhTtdkRirekiByPkBean = new HoyuuKhTtdkRirekiByPkBean(null);

                    List<SV_KiykSyuhnData> kiykSyuhnDataLst = new ArrayList<SV_KiykSyuhnData>();

                    if (C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(hoyuKykSyouhnsBySyonoSyutkkbnBean
                        .getSyoumetujiyuu())) {

                        kiykSyuhnDataLst = dbaStatement.getKiykSyuhnDatasBySyonoSyutkkbn(hoyuuMeisai.getSyono(),
                            C_SyutkKbn.SYU);

                        for (SV_KiykSyuhnData kiykSyuhnData : kiykSyuhnDataLst) {

                            if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(kiykSyuhnData
                                .getGyoumuKousinKinou())) {

                                hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyono(kiykSyuhnData.getSyono());
                                hoyuKykSyouhnsBySyonoSyutkkbnBean.setHenkousikibetukey(kiykSyuhnData
                                    .getHenkousikibetukey());
                                hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyutkkbn(kiykSyuhnData.getSyutkkbn());
                                hoyuKykSyouhnsBySyonoSyutkkbnBean.setYuukousyoumetukbn(kiykSyuhnData
                                    .getYuukousyoumetukbn());
                                hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyoumetuymd(kiykSyuhnData.getSyoumetuymd());
                                hoyuKykSyouhnsBySyonoSyutkkbnBean.setSyoumetujiyuu(kiykSyuhnData.getSyoumetujiyuu());
                                hoyuuKhTtdkRirekiByPkBean.setSyoriymd(kiykSyuhnData.getSyoriYmd());

                                break;
                            }
                        }
                    }
                    else {

                        hoyuuKhTtdkRirekiByPkBean = dbaStatement.getHoyuuKhTtdkRirekiByPk(
                            hoyuKykSyouhnsBySyonoSyutkkbnBean.getSyono(),
                            hoyuKykSyouhnsBySyonoSyutkkbnBean.getHenkousikibetukey());
                    }

                    SrHoyuuKeiyakuCheck srHoyuuKeiyakuCheck = SWAKInjector.getInstance(SrHoyuuKeiyakuCheck.class);

                    C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(
                        batchParam.getKijyunymd(),
                        hoyuuMeisai.getSyono(),
                        hoyuuMeisai.getSkeikeijyouym(),
                        hoyuKykSyouhnsBySyonoSyutkkbnBean,
                        hoyuuKhTtdkRirekiByPkBean,
                        khBikinkanriLst,
                        siBikinkanriLst);

                    if (!C_HoyuuCheckKekkaKbn.HOYUUTAISYOU.eq(hoyuuCheckKekkaKbn)) {

                        continue;
                    }

                    if (!C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(hoyuKykSyouhnsBySyonoSyutkkbnBean
                        .getSyoumetujiyuu())) {

                        kiykSyuhnDataLst = dbaStatement.getKiykSyuhnDatasBySyonoSyutkkbn(hoyuuMeisai.getSyono(),
                            C_SyutkKbn.SYU);
                    }

                    SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector
                        .getInstance(SrGetTokutejitenSyohnInfo.class);
                    TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = srGetTokutejitenSyohnInfo.exec(
                        C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                        hoyuuMeisai.getSyono(),
                        batchParam.getKijyunymd(),
                        "",
                        kiykSyuhnDataLst).getTkJitenKeiyakuSyouhinKijyunBeanAto();

                    int syohinHanteiKbn = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

                    boolean tmttdFlg = false;
                    boolean karidFlg = false;

                    List<IT_KhTumitateDKanri> khTumitateDKanriLst = dbaStatement.getTumitateDKanris(
                        hoyuuMeisai.getSyono(), batchParam.getKijyunymd());
                    if (khTumitateDKanriLst.size() != 0) {

                        tmttdFlg = true;
                    }

                    List<IT_KhHaitouKanri> khHaitouKanriLst = dbaStatement.getHaitouKanris(
                        hoyuuMeisai.getSyono(), batchParam.getKijyunymd());

                    BizDateY wkHaitounendo = null;

                    if (khHaitouKanriLst.size() != 0) {

                        karidFlg = true;
                        wkHaitounendo = khHaitouKanriLst.get(0).getHaitounendo();
                    }

                    CheckDJyoutai checkDJyoutai = SWAKInjector.getInstance(CheckDJyoutai.class);
                    C_UmuKbn haitoukinMihaneiJyoutai = checkDJyoutai.execForMibaraiHaitouHantei(
                        batchParam.getKijyunymd(),
                        tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                        wkHaitounendo);

                    if (C_UmuKbn.ARI.eq(haitoukinMihaneiJyoutai)) {

                        String msg = MessageUtil.getMessage(MessageId.ESA1005, hoyuuMeisai.getSyono());

                        batchLogger.warn(msg);

                        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                        suuriyouErrJyouhou.setSyoriYmd(batchParam.getSyoriYmd());
                        suuriyouErrJyouhou.setKakutyoujobcd(batchParam.getIbKakutyoujobcd());
                        suuriyouErrJyouhou.setSyono(hoyuuMeisai.getSyono());
                        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                        batchParam.setErrorSyoriKensuu(batchParam.getErrorSyoriKensuu() + 1);

                        continue;
                    }

                    if (!karidFlg){
                        continue;
                    }

                    SrYuukouKykHaitoujynbknSelItemEditor itemEditor = SWAKInjector
                        .getInstance(SrYuukouKykHaitoujynbknSelItemEditor.class);
                    boolean errorFlag = false;
                    ST_YuukoukykHtjynbknTmttd yuukoukykHtjynbknTmttd = new ST_YuukoukykHtjynbknTmttd();
                    ST_YuukoukykHtjynbknKarid yuukoukykHtjynbknKarid = new ST_YuukoukykHtjynbknKarid();

                    if (tmttdFlg || karidFlg) {

                        itemEditor.editKoumoku(
                            batchParam,
                            hoyuuMeisai,
                            tkJitenKeiyakuSyouhinKijyunBean,
                            syohinHanteiKbn,
                            kiykSyuhnDataLst);
                    }

                    if (tmttdFlg) {

                        errorFlag = itemEditor.editKoumokuTmttd(
                            batchParam,
                            hoyuuMeisai,
                            tkJitenKeiyakuSyouhinKijyunBean,
                            syohinHanteiKbn,
                            kiykSyuhnDataLst,
                            khTumitateDKanriLst,
                            khHaitouKanriLst,
                            yuukoukykHtjynbknTmttd);
                    }

                    if (karidFlg) {

                        errorFlag = itemEditor.editKoumokuKarid(
                            batchParam,
                            hoyuuMeisai,
                            tkJitenKeiyakuSyouhinKijyunBean,
                            syohinHanteiKbn,
                            kiykSyuhnDataLst,
                            khHaitouKanriLst,
                            yuukoukykHtjynbknKarid);
                    }

                    if (!errorFlag) {

                        if (tmttdFlg) {

                            BizPropertyInitializer.initialize(yuukoukykHtjynbknTmttd);

                            yuukoukykHtjynbknTmttdLst.add(yuukoukykHtjynbknTmttd);

                            tmttdTblCount = tmttdTblCount + 1;
                        }

                        if (karidFlg) {

                            BizPropertyInitializer.initialize(yuukoukykHtjynbknKarid);

                            yuukoukykHtjynbknKaridLst.add(yuukoukykHtjynbknKarid);

                            karidTblCount = karidTblCount + 1;
                        }
                    }
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, TABLETMTTD, kbnkey, String.valueOf(tmttdTblCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, TABLEKARID, kbnkey, String.valueOf(karidTblCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, SUURIYOUERRJYOUHOUTABLE, kbnkey,
            String.valueOf(batchParam.getErrorSyoriKensuu())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, kbnkey));
    }
}
