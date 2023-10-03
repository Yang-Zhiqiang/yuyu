package yuyu.batch.suuri.srsuuritoukei.srdshrtoukei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.haitou.GetDRiritu;
import yuyu.common.hozen.haitou.KeisanDCommon;
import yuyu.common.hozen.haitou.KeisanDGanrikin;
import yuyu.common.hozen.haitou.SetDNnd;
import yuyu.common.hozen.haitou.SetDNnd.DRateBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrTyukeiyouItzHznSakujyo;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.entity.ST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_DshrToukeiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 Ｄ支払統計情報作成
 */
public class SrDshrToukeiBatch implements Batch {

    private BizCurrency haitouganRikin;

    private BizCurrency modosiKingk;

    private BizDateYM dshrYm;

    private String shrriyuuKbn;

    private String dUketoriHouhouKbn;

    private String bikinHyj;

    private BizCurrency toujigyouNendoD;

    private BizCurrency toujigyouNendohasseiDRsk;

    private BizCurrency zenjigyouNendomatuDZndk;

    private BizCurrency yokujigyouNendoD;

    private BizCurrency hushrToujigyouNendoD;

    private Boolean dKrKoumokuAll0Flg;

    private Boolean mainErrorFlg;

    private int tableCount;

    private int itTableCount;

    @Inject
    private SrDshrToukeiBatchParam srDshrToukeiBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public BatchParam getParam() {
        return srDshrToukeiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        srDshrToukeiBatchParam.setParam();

        tableCount = 0;
        itTableCount = 0;

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(srDshrToukeiBatchParam);

        List<DshrTukiInfoBean> dshrTukiInfoBeanLst = getDshrTukiTbl(
            srDshrToukeiBatchParam.getZenkaiDensimeYmd().addBusinessDays(1),
            srDshrToukeiBatchParam.getKonkaiDensimeYmd().addBusinessDays(1));

        SrDshrToukeiBatchDbAccess srDshrToukeiBatchDbAccess = SWAKInjector.getInstance(SrDshrToukeiBatchDbAccess.class);

        try (
            EntityInserter<ZT_DshrToukeiTy> zT_DshrToukeiTyTyLst = new EntityInserter<>();
            EntityInserter<ST_DshrTukiTyukeiyouItzHzn> sT_DshrTukiTyukeiyouItzHznLst = new EntityInserter<>(); ){

            String dShrtoukeioutKbn = "";
            Boolean tumiDRecord = false;
            Boolean kariDRecord = false;

            for (DshrTukiInfoBean dshrTukiInfoBean : dshrTukiInfoBeanLst) {

                if (dshrTukiInfoBean.getHaitounendo2() == null) {
                    continue;
                }
                if (IKhozenCommonConstants.KINOUID_DHANEI.equals(dshrTukiInfoBean.getGyoumuKousinKinou())) {

                    if (dshrTukiInfoBean.getRenno() == 1) {
                        dShrtoukeioutKbn = SrCommonConstants.DSHRTOUKEIOUTKBN_DHANEISEISANDHANEI;
                    }
                    else {
                        continue;
                    }
                }
                else {
                    dShrtoukeioutKbn = SrCommonConstants.DSHRTOUKEIOUTKBN_DSHRSYORI;

                    if (dshrTukiInfoBean.getSiharaid().compareTo(BizCurrency.valueOf(SrCommonConstants.
                        DEFAULT_INT_ZERO)) <= SrCommonConstants.DEFAULT_INT_ZERO) {
                        continue;
                    }
                    tumiDRecord = false;
                    kariDRecord = false;

                    if (dshrTukiInfoBean.getHaitouganrikincalctumi() != null &&
                        dshrTukiInfoBean.getHaitouganrikincalctumi().compareTo(BizCurrency.valueOf(SrCommonConstants.
                            DEFAULT_INT_ZERO)) > SrCommonConstants.DEFAULT_INT_ZERO) {
                        tumiDRecord = true;
                    }

                    if (dshrTukiInfoBean.getHaitouganrikincalckari() != null &&
                        dshrTukiInfoBean.getHaitouganrikincalckari().compareTo(BizCurrency.valueOf(SrCommonConstants.
                            DEFAULT_INT_ZERO)) > SrCommonConstants.DEFAULT_INT_ZERO) {
                        kariDRecord = true;
                    }
                }

                int syouhinUtilResult = SyouhinUtil.hantei(dshrTukiInfoBean.getSyouhncd());

                BizCurrency toujigyouNendoDTumi = BizCurrency.valueOf(0);
                BizCurrency toujigyouNendohasseiDRskTumi = BizCurrency.valueOf(0);
                BizCurrency zenjigyouNendomatuDZndkTumi = BizCurrency.valueOf(0);
                BizCurrency yokujigyouNendoDTumi = BizCurrency.valueOf(0);
                BizCurrency hushrToujigyouNendoDTumi = BizCurrency.valueOf(0);
                BizCurrency toujigyouNendoDKari = BizCurrency.valueOf(0);
                BizCurrency toujigyouNendohasseiDRskKari = BizCurrency.valueOf(0);
                BizCurrency zenjigyouNendomatuDZndkKari = BizCurrency.valueOf(0);
                BizCurrency yokujigyouNendoDKari = BizCurrency.valueOf(0);
                BizCurrency hushrToujigyouNendoDKari = BizCurrency.valueOf(0);

                if (SrCommonConstants.DSHRTOUKEIOUTKBN_DSHRSYORI.equals(dShrtoukeioutKbn)) {

                    if (tumiDRecord) {
                        setDkrKoumoku(dShrtoukeioutKbn, SrCommonConstants.TUMIDKARIDKBN_TUMIDRECORD,
                            dshrTukiInfoBean, srDshrToukeiBatchParam);

                        toujigyouNendoDTumi = toujigyouNendoD;
                        toujigyouNendohasseiDRskTumi = toujigyouNendohasseiDRsk;
                        zenjigyouNendomatuDZndkTumi = zenjigyouNendomatuDZndk;
                        yokujigyouNendoDTumi = yokujigyouNendoD;
                        hushrToujigyouNendoDTumi = hushrToujigyouNendoD;

                        if (dKrKoumokuAll0Flg || mainErrorFlg) {
                            tumiDRecord = false;
                        }
                    }
                    if (kariDRecord) {
                        setDkrKoumoku(dShrtoukeioutKbn, SrCommonConstants.TUMIDKARIDKBN_KARIDRECORD,
                            dshrTukiInfoBean, srDshrToukeiBatchParam);

                        toujigyouNendoDKari = toujigyouNendoD;
                        toujigyouNendohasseiDRskKari = toujigyouNendohasseiDRsk;
                        zenjigyouNendomatuDZndkKari = zenjigyouNendomatuDZndk;
                        yokujigyouNendoDKari = yokujigyouNendoD;
                        hushrToujigyouNendoDKari = hushrToujigyouNendoD;

                        if (dKrKoumokuAll0Flg || mainErrorFlg) {
                            kariDRecord = false;
                        }
                    }

                    if (!tumiDRecord && !kariDRecord) {
                        continue;
                    }
                }
                else if (SrCommonConstants.DSHRTOUKEIOUTKBN_DHANEISEISANDHANEI.equals(dShrtoukeioutKbn)) {

                    if (syouhinUtilResult == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN
                        || syouhinUtilResult == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                        IT_AnsyuKihon ansyuKihon = srDshrToukeiBatchDbAccess.
                            getAnsyuKihon(dshrTukiInfoBean.getSyono());

                        BizDateYM jkipJytYm = ansyuKihon.getJkipjytym();

                        if (BizDateUtil.compareYm(jkipJytYm, dshrTukiInfoBean.getDenymd().getBizDateYM()) < 0) {
                            continue;
                        }
                    }

                    setDkrKoumoku(dShrtoukeioutKbn, null,
                        dshrTukiInfoBean, srDshrToukeiBatchParam);

                    toujigyouNendoDKari = toujigyouNendoD;
                    toujigyouNendohasseiDRskKari = toujigyouNendohasseiDRsk;
                    zenjigyouNendomatuDZndkKari = zenjigyouNendomatuDZndk;
                    yokujigyouNendoDKari = yokujigyouNendoD;
                    hushrToujigyouNendoDKari = hushrToujigyouNendoD;

                    if (dKrKoumokuAll0Flg) {
                        continue;
                    }
                }

                BizDateYM dshrYmTumi = null;
                String shrriyuukbnTumi = "";
                String dUketoriHouhouKbnTumi = "" ;
                String bikinhyjTumi = "";
                BizDateYM dshrYmKari = null;
                String shrriyuukbnKari = "";
                String dUketoriHouhouKbnKari = "" ;
                String bikinhyjKari = "";
                if (SrCommonConstants.DSHRTOUKEIOUTKBN_DSHRSYORI.equals(dShrtoukeioutKbn)) {
                    if (tumiDRecord) {
                        setOutPatternBetuKoumoku(dShrtoukeioutKbn, SrCommonConstants.TUMIDKARIDKBN_TUMIDRECORD,
                            dshrTukiInfoBean);

                        dshrYmTumi = dshrYm;
                        shrriyuukbnTumi = shrriyuuKbn;
                        dUketoriHouhouKbnTumi = dUketoriHouhouKbn;
                        bikinhyjTumi = bikinHyj;
                    }

                    if (kariDRecord) {
                        setOutPatternBetuKoumoku(dShrtoukeioutKbn, SrCommonConstants.TUMIDKARIDKBN_KARIDRECORD,
                            dshrTukiInfoBean);
                        dshrYmKari = dshrYm;
                        shrriyuukbnKari = shrriyuuKbn;
                        dUketoriHouhouKbnKari = dUketoriHouhouKbn;
                        bikinhyjKari = bikinHyj;
                    }
                }
                else if (SrCommonConstants.DSHRTOUKEIOUTKBN_DHANEISEISANDHANEI.equals(dShrtoukeioutKbn)) {

                    setOutPatternBetuKoumoku(dShrtoukeioutKbn, null, dshrTukiInfoBean);
                    dshrYmKari = dshrYm;
                    shrriyuukbnKari = shrriyuuKbn;
                    dUketoriHouhouKbnKari = dUketoriHouhouKbn;
                    bikinhyjKari = bikinHyj;
                }

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = SWAKInjector
                    .getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanKykYmdJiten = SWAKInjector
                    .getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);

                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                    SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

                List<SV_KiykSyuhnData> kiykSyuhnDataList = srDshrToukeiBatchDbAccess.getKiykSyuhnDatas(dshrTukiInfoBean.getSyono(), C_SyutkKbn.SYU);

                if (syouhinUtilResult == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                    TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean =
                        srGetTokutejitenSyohnInfo.exec(C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                            dshrTukiInfoBean.getSyono(),
                            dshrTukiInfoBean.getKykymd(),
                            "",
                            kiykSyuhnDataList);

                    tkJitenKeiyakuSyouhinKijyunBeanKykYmdJiten =
                        tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();
                }

                BizDate kijyunYmd;
                if (SrCommonConstants.DSHRTOUKEIOUTKBN_DHANEISEISANDHANEI.equals(dShrtoukeioutKbn)) {

                    kijyunYmd = dshrTukiInfoBean.getSyoriYmd();
                }
                else {

                    if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(dshrTukiInfoBean.getGyoumuKousinKinou())) {

                        kijyunYmd = dshrTukiInfoBean.getKinoubetukijyunymd();
                    }
                    else {

                        kijyunYmd = dshrTukiInfoBean.getCalckijyunymd();
                    }
                }

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean =
                    srGetTokutejitenSyohnInfo.exec(C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                        dshrTukiInfoBean.getSyono(),
                        kijyunYmd,
                        "",
                        kiykSyuhnDataList);

                tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

                SrDshrToukeiBatchEdit srDshrToukeiBatchEdit = SWAKInjector.getInstance(SrDshrToukeiBatchEdit.class);

                ZT_DshrToukeiTy zT_DshrToukeiTyTumi = new ZT_DshrToukeiTy();
                ST_DshrTukiTyukeiyouItzHzn sT_DshrTukiTyukeiyouItzHznTumi = new ST_DshrTukiTyukeiyouItzHzn();
                ZT_DshrToukeiTy zT_DshrToukeiTyKari = new ZT_DshrToukeiTy();
                ST_DshrTukiTyukeiyouItzHzn sT_DshrTukiTyukeiyouItzHznKari = new ST_DshrTukiTyukeiyouItzHzn();

                boolean editKoumokuErrorFlag = false;

                if (SrCommonConstants.DSHRTOUKEIOUTKBN_DSHRSYORI.equals(dShrtoukeioutKbn)) {
                    if (tumiDRecord) {
                        editKoumokuErrorFlag = srDshrToukeiBatchEdit.editKoumoku(
                            srDshrToukeiBatchParam,
                            dshrTukiInfoBean,
                            dshrYmTumi,
                            shrriyuukbnTumi,
                            dUketoriHouhouKbnTumi,
                            bikinhyjTumi,
                            toujigyouNendoDTumi,
                            toujigyouNendohasseiDRskTumi,
                            zenjigyouNendomatuDZndkTumi,
                            yokujigyouNendoDTumi,
                            hushrToujigyouNendoDTumi,
                            syouhinUtilResult,
                            tkJitenKeiyakuSyouhinKijyunBean,
                            tkJitenKeiyakuSyouhinKijyunBeanKykYmdJiten,
                            zT_DshrToukeiTyTumi,
                            sT_DshrTukiTyukeiyouItzHznTumi);
                    }

                    if (kariDRecord) {
                        editKoumokuErrorFlag = srDshrToukeiBatchEdit.editKoumoku(
                            srDshrToukeiBatchParam,
                            dshrTukiInfoBean,
                            dshrYmKari,
                            shrriyuukbnKari,
                            dUketoriHouhouKbnKari,
                            bikinhyjKari,
                            toujigyouNendoDKari,
                            toujigyouNendohasseiDRskKari,
                            zenjigyouNendomatuDZndkKari,
                            yokujigyouNendoDKari,
                            hushrToujigyouNendoDKari,
                            syouhinUtilResult,
                            tkJitenKeiyakuSyouhinKijyunBean,
                            tkJitenKeiyakuSyouhinKijyunBeanKykYmdJiten,
                            zT_DshrToukeiTyKari,
                            sT_DshrTukiTyukeiyouItzHznKari);
                    }
                }
                else if (SrCommonConstants.DSHRTOUKEIOUTKBN_DHANEISEISANDHANEI.equals(dShrtoukeioutKbn)) {

                    editKoumokuErrorFlag = srDshrToukeiBatchEdit.editKoumoku(
                        srDshrToukeiBatchParam,
                        dshrTukiInfoBean,
                        dshrYmKari,
                        shrriyuukbnKari,
                        dUketoriHouhouKbnKari,
                        bikinhyjKari,
                        toujigyouNendoDKari,
                        toujigyouNendohasseiDRskKari,
                        zenjigyouNendomatuDZndkKari,
                        yokujigyouNendoDKari,
                        hushrToujigyouNendoDKari,
                        syouhinUtilResult,
                        tkJitenKeiyakuSyouhinKijyunBean,
                        tkJitenKeiyakuSyouhinKijyunBeanKykYmdJiten,
                        zT_DshrToukeiTyKari,
                        sT_DshrTukiTyukeiyouItzHznKari);

                }

                if (editKoumokuErrorFlag) {
                    continue;
                }

                if (SrCommonConstants.DSHRTOUKEIOUTKBN_DSHRSYORI.equals(dShrtoukeioutKbn)) {
                    if (tumiDRecord) {
                        BizPropertyInitializer.initialize(zT_DshrToukeiTyTumi);
                        zT_DshrToukeiTyTyLst.add(zT_DshrToukeiTyTumi);
                        tableCount++;
                        BizPropertyInitializer.initialize(sT_DshrTukiTyukeiyouItzHznTumi);
                        sT_DshrTukiTyukeiyouItzHznLst.add(sT_DshrTukiTyukeiyouItzHznTumi);
                        itTableCount++;
                    }

                    if (kariDRecord) {
                        BizPropertyInitializer.initialize(zT_DshrToukeiTyKari);
                        zT_DshrToukeiTyTyLst.add(zT_DshrToukeiTyKari);
                        tableCount++;
                        BizPropertyInitializer.initialize(sT_DshrTukiTyukeiyouItzHznKari);
                        sT_DshrTukiTyukeiyouItzHznLst.add(sT_DshrTukiTyukeiyouItzHznKari);
                        itTableCount++;
                    }
                }
                else if (SrCommonConstants.DSHRTOUKEIOUTKBN_DHANEISEISANDHANEI.equals(dShrtoukeioutKbn)) {
                    BizPropertyInitializer.initialize(zT_DshrToukeiTyKari);
                    zT_DshrToukeiTyTyLst.add(zT_DshrToukeiTyKari);
                    tableCount++;
                    BizPropertyInitializer.initialize(sT_DshrTukiTyukeiyouItzHznKari);
                    sT_DshrTukiTyukeiyouItzHznLst.add(sT_DshrTukiTyukeiyouItzHznKari);
                    itTableCount++;
                }
            }
        }

        if (srDshrToukeiBatchParam.getErrorCount() != 0 &&
            (SrDshrToukeiBatchParam.RGLBM000.equals(srDshrToukeiBatchParam.getIbKakutyoujobcd()) ||
                SrDshrToukeiBatchParam.RGLBM004.equals(srDshrToukeiBatchParam.getIbKakutyoujobcd()))) {

            throw new BizAppException(MessageId.ISA1001, "数理用エラー情報テーブル",
                String.valueOf(srDshrToukeiBatchParam.getErrorCount()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "Ｄ支払統計Ｆテーブル（中）",
            String.valueOf(tableCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "Ｄ支払統計中継用一時保存テーブル",
            String.valueOf(itTableCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
            String.valueOf(srDshrToukeiBatchParam.getErrorCount())));
    }

    private List<DshrTukiInfoBean> getDshrTukiTbl(BizDate pZenkaidensimeYmd, BizDate pKonkaidensimeYmd) {

        List<DshrTukiInfoBean> dshrTukiInfoBeanLst = new ArrayList<>();

        SrDshrToukeiBatchDbAccess srDshrToukeiBatchDbAccess = SWAKInjector.getInstance(SrDshrToukeiBatchDbAccess.class);

        try (ExDBResults<IT_KhDshrTuki> khDshrTukiLst =
            srDshrToukeiBatchDbAccess.getItKhDshrTuki(pZenkaidensimeYmd, pKonkaidensimeYmd);){

            for (IT_KhDshrTuki khDshrTuki : khDshrTukiLst) {
                DshrTukiInfoBean dshrTukiInfoBean = SWAKInjector.getInstance(DshrTukiInfoBean.class);

                BeanUtil.copyProperties(dshrTukiInfoBean, khDshrTuki);

                dshrTukiInfoBeanLst.add(dshrTukiInfoBean);
            }
        }

        try (ExDBResults<JT_SiDshrTuki>  siDshrTukiLst =
            srDshrToukeiBatchDbAccess.getJtSiDshrTuki(pZenkaidensimeYmd, pKonkaidensimeYmd);) {

            for (JT_SiDshrTuki siDshrTuki : siDshrTukiLst) {
                DshrTukiInfoBean dshrTukiInfoBean = SWAKInjector.getInstance(DshrTukiInfoBean.class);

                BeanUtil.copyProperties(dshrTukiInfoBean, siDshrTuki);

                dshrTukiInfoBeanLst.add(dshrTukiInfoBean);
            }
        }

        return dshrTukiInfoBeanLst;
    }

    private void setDkrKoumoku(String pDshrtoukeioutKbn, String pTumidkaridKbn,
        DshrTukiInfoBean pDshrTukiInfoBean, SrDshrToukeiBatchParam pBatchParam) {

        toujigyouNendoD = BizCurrency.valueOf(0);
        toujigyouNendohasseiDRsk = BizCurrency.valueOf(0);
        zenjigyouNendomatuDZndk = BizCurrency.valueOf(0);
        yokujigyouNendoD = BizCurrency.valueOf(0);
        hushrToujigyouNendoD = BizCurrency.valueOf(0);
        dKrKoumokuAll0Flg = false;
        mainErrorFlg = false;

        BizDate kijyunYmd;
        BizDateY  kijyunNendo;
        if (pDshrTukiInfoBean.getYendthnkymd() != null) {
            kijyunYmd = pDshrTukiInfoBean.getYendthnkymd();
        }
        else {
            kijyunYmd = pDshrTukiInfoBean.getKykymd();
        }

        if (kijyunYmd.getMonth() <= SrCommonConstants.MONTH_MARCH) {
            kijyunNendo = kijyunYmd.getBizDateY().addYears( - SrCommonConstants.YEAR_1Y) ;
        }
        else {
            kijyunNendo = kijyunYmd.getBizDateY();
        }

        BizDateY haitouNendo = pDshrTukiInfoBean.getHaitounendo2();

        Boolean seisikiwariateNendoFlg = false;
        if (BizDateUtil.calcDifferenceMonths(BizDateYM.valueOf(haitouNendo, 1),
            BizDateYM.valueOf(kijyunNendo, 1)) % 5 == 0) {
            seisikiwariateNendoFlg = true;
        }

        BizDate denYmd;
        if (pDshrTukiInfoBean.getDenymd() == null) {
            denYmd = pDshrTukiInfoBean.getSyoriYmd();
        }
        else {
            denYmd = pDshrTukiInfoBean.getDenymd();
        }

        BizDate zenJigyouNendomatuBi;
        if (denYmd.getMonth() >= SrCommonConstants.MONTH_APRIL) {
            zenJigyouNendomatuBi = BizDate.valueOf(denYmd.getBizDateY(),
                BizDateMD.valueOf(SrCommonConstants.FIXEDDAY_NENDOKSNBI));
        }
        else {
            zenJigyouNendomatuBi = BizDate.valueOf(denYmd.getBizDateY().addYears(-SrCommonConstants.YEAR_1Y),
                BizDateMD.valueOf(SrCommonConstants.FIXEDDAY_NENDOKSNBI));
        }

        BizDateMD outouYmdMd;
        BizDateY haitouNen;
        BizDate tykzendhaneiymd;

        if (pDshrTukiInfoBean.getYendthnkymd() != null) {
            outouYmdMd = pDshrTukiInfoBean.getYendthnkymd().getBizDateMD();
        }
        else {
            outouYmdMd = pDshrTukiInfoBean.getKykymd().getBizDateMD();
        }

        if (outouYmdMd.getMonth() <= SrCommonConstants.MONTH_MARCH) {
            haitouNen = pDshrTukiInfoBean.getHaitounendo2().addYears(SrCommonConstants.YEAR_1Y);
        }
        else {
            haitouNen = pDshrTukiInfoBean.getHaitounendo2();
        }

        tykzendhaneiymd = BizDate.valueOf(haitouNen, outouYmdMd).getRekijyou();

        Boolean douituNendoDHaneiKbn = false;
        if (BizDateUtil.compareYmd(zenJigyouNendomatuBi, tykzendhaneiymd)
            == BizDateUtil.COMPARE_LESSER) {
            douituNendoDHaneiKbn = true;
        }

        BizCurrency modosimaeKgk = BizCurrency.valueOf(0);
        BizCurrency gengakuKariwariatedruigk = BizCurrency.valueOf(0);
        BizCurrency riatedruigk = BizCurrency.valueOf(0);

        if (SrCommonConstants.DSHRTOUKEIOUTKBN_DSHRSYORI.equals(pDshrtoukeioutKbn) &&
            SrCommonConstants.TUMIDKARIDKBN_KARIDRECORD.equals(pTumidkaridKbn)) {
            if (douituNendoDHaneiKbn) {
                if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
                    toujigyouNendoD = BizCurrency.valueOf(0);
                }
                else {
                    toujigyouNendoD = pDshrTukiInfoBean.getTounendod();
                }

                BizDate kijyunToYmd;
                if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
                    modosimaeKgk = pDshrTukiInfoBean.getKariwariatedruigk();
                    kijyunToYmd = tykzendhaneiymd;
                }
                else {
                    modosimaeKgk = pDshrTukiInfoBean.getKariwariatedruigk2().subtract(pDshrTukiInfoBean.getTounendod());
                    kijyunToYmd = tykzendhaneiymd;
                }

                setModosiKingk(zenJigyouNendomatuBi, kijyunToYmd, modosimaeKgk, pDshrTukiInfoBean.getSyono(),
                    pBatchParam);
                zenjigyouNendomatuDZndk = modosiKingk;

                if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
                    setHaitouganrikin(pDshrTukiInfoBean.getKariwariatedruigk(), tykzendhaneiymd,
                        pDshrTukiInfoBean.getSyoriYmd(), pDshrTukiInfoBean.getSyono(), pBatchParam);
                    gengakuKariwariatedruigk = haitouganRikin;

                    toujigyouNendohasseiDRsk = gengakuKariwariatedruigk.subtract(zenjigyouNendomatuDZndk);
                }
                else {
                    toujigyouNendohasseiDRsk = pDshrTukiInfoBean.getHaitouganrikincalckari()
                        .subtract(toujigyouNendoD).subtract(zenjigyouNendomatuDZndk);
                }
            }
            else {
                toujigyouNendoD = BizCurrency.valueOf(0);

                if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
                    riatedruigk = pDshrTukiInfoBean.getKariwariatedruigk();
                }
                else {
                    riatedruigk = pDshrTukiInfoBean.getKariwariatedruigk2();
                }

                setHaitouganrikin(riatedruigk, tykzendhaneiymd,
                    zenJigyouNendomatuBi, pDshrTukiInfoBean.getSyono(), pBatchParam);
                zenjigyouNendomatuDZndk = haitouganRikin;

                if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
                    if (pDshrTukiInfoBean.getSyoriYmd().addYears(-1).getRekijyou().compareTo(tykzendhaneiymd) <= 0) {
                        setHaitouganrikin(pDshrTukiInfoBean.getKariwariatedruigk(), tykzendhaneiymd,
                            pDshrTukiInfoBean.getSyoriYmd(), pDshrTukiInfoBean.getSyono(), pBatchParam);
                    }
                    else {
                        setHaitouganrikinOverYear(pDshrTukiInfoBean.getKariwariatedruigk(),
                            pDshrTukiInfoBean.getSyoriYmd(),
                            pDshrTukiInfoBean.getCalckijyunymd(),
                            pDshrTukiInfoBean.getSyono(), pBatchParam, pDshrTukiInfoBean.getKykymd());
                    }

                    gengakuKariwariatedruigk = haitouganRikin;
                    toujigyouNendohasseiDRsk = gengakuKariwariatedruigk.subtract(zenjigyouNendomatuDZndk);
                }
                else {
                    toujigyouNendohasseiDRsk = pDshrTukiInfoBean.getHaitouganrikincalckari()
                        .subtract(toujigyouNendoD).subtract(zenjigyouNendomatuDZndk);
                }
            }
        }

        else if (SrCommonConstants.DSHRTOUKEIOUTKBN_DSHRSYORI.equals(pDshrtoukeioutKbn) &&
            SrCommonConstants.TUMIDKARIDKBN_TUMIDRECORD.equals(pTumidkaridKbn)) {

            if (douituNendoDHaneiKbn && seisikiwariateNendoFlg) {
                toujigyouNendoD = pDshrTukiInfoBean.getTounendod();

                modosimaeKgk = pDshrTukiInfoBean.getTumitated2().subtract(pDshrTukiInfoBean.getTounendod());

                setModosiKingk(zenJigyouNendomatuBi, tykzendhaneiymd, modosimaeKgk, pDshrTukiInfoBean.getSyono(),
                    pBatchParam);
                zenjigyouNendomatuDZndk = modosiKingk;

                toujigyouNendohasseiDRsk = pDshrTukiInfoBean.getHaitouganrikincalctumi()
                    .subtract(toujigyouNendoD).subtract(zenjigyouNendomatuDZndk);
            }
            else  if (douituNendoDHaneiKbn && !seisikiwariateNendoFlg) {
                toujigyouNendoD = BizCurrency.valueOf(0);

                modosimaeKgk = pDshrTukiInfoBean.getTumitated2();

                setModosiKingk(zenJigyouNendomatuBi, tykzendhaneiymd, modosimaeKgk, pDshrTukiInfoBean.getSyono(),
                    pBatchParam);
                zenjigyouNendomatuDZndk = modosiKingk;

                toujigyouNendohasseiDRsk = pDshrTukiInfoBean.getHaitouganrikincalctumi()
                    .subtract(toujigyouNendoD).subtract(zenjigyouNendomatuDZndk);
            }
            else if (!douituNendoDHaneiKbn){
                toujigyouNendoD = BizCurrency.valueOf(0);

                setHaitouganrikin(pDshrTukiInfoBean.getTumitated2(), tykzendhaneiymd,
                    zenJigyouNendomatuBi, pDshrTukiInfoBean.getSyono(), pBatchParam);
                zenjigyouNendomatuDZndk = haitouganRikin;

                toujigyouNendohasseiDRsk = pDshrTukiInfoBean.getHaitouganrikincalctumi()
                    .subtract(toujigyouNendoD).subtract(zenjigyouNendomatuDZndk);
            }
        }
        else if (SrCommonConstants.DSHRTOUKEIOUTKBN_DHANEISEISANDHANEI.equals(pDshrtoukeioutKbn)) {
            toujigyouNendoD = pDshrTukiInfoBean.getKariwariatedruigk2()
                .subtract(pDshrTukiInfoBean.getTounendod()).multiply(-1) ;

            modosimaeKgk = pDshrTukiInfoBean.getKariwariatedruigk2().subtract(pDshrTukiInfoBean.getTounendod());

            setModosiKingk(zenJigyouNendomatuBi, pDshrTukiInfoBean.getKariwariatedshrymd(), modosimaeKgk,
                pDshrTukiInfoBean.getSyono(), pBatchParam);
            zenjigyouNendomatuDZndk = modosiKingk;

            toujigyouNendohasseiDRsk = pDshrTukiInfoBean.getKariwariatedruigk2().subtract(pDshrTukiInfoBean.getTounendod()).subtract(zenjigyouNendomatuDZndk);
        }

        if (BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO).compareTo(toujigyouNendoD) == 0  &&
            BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO).compareTo(toujigyouNendohasseiDRsk) == 0 &&
            BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO).compareTo(zenjigyouNendomatuDZndk) == 0&&
            BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO).compareTo(yokujigyouNendoD) == 0 &&
            BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO).compareTo(hushrToujigyouNendoD) == 0) {
            dKrKoumokuAll0Flg = true;
        }
    }

    private void setOutPatternBetuKoumoku(String pDshrtoukeioutKbn, String pTumidkaridKbn,
        DshrTukiInfoBean pDshrTukiInfoBean) {

        dshrYm = null;
        shrriyuuKbn = "";
        dUketoriHouhouKbn = "";
        bikinHyj = "";

        if (SrCommonConstants.DSHRTOUKEIOUTKBN_DSHRSYORI.equals(pDshrtoukeioutKbn)) {
            if (pDshrTukiInfoBean.getDenymd() == null) {
                dshrYm = pDshrTukiInfoBean.getSyoriYmd().getBizDateYM();
            }
            else {
                dshrYm = pDshrTukiInfoBean.getDenymd().getBizDateYM();
            }
        }
        else if (SrCommonConstants.DSHRTOUKEIOUTKBN_DHANEISEISANDHANEI.equals(pDshrtoukeioutKbn)) {
            dshrYm = pDshrTukiInfoBean.getKariwariatedshrymd().getBizDateYM();
        }

        if (SrCommonConstants.DSHRTOUKEIOUTKBN_DSHRSYORI.equals(pDshrtoukeioutKbn)) {
            if (IKhozenCommonConstants.KINOUID_DSHR.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
                shrriyuuKbn = SrCommonConstants.SHRRIYUUKBN_TUMITATEDHIKIDASI;
            }
            else if (IKhozenCommonConstants.KINOUID_DSEISAN.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
                shrriyuuKbn = SrCommonConstants.SHRRIYUUKBN_DSEISAN;
            }
            else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pDshrTukiInfoBean.getGyoumuKousinKinou())) {
                shrriyuuKbn = SrCommonConstants.SHRRIYUUKBN_SONOTASHR;
            }
            else {
                shrriyuuKbn = SrCommonConstants.SHRRIYUUKBN_SYOUMETU;
            }
        }
        else if (SrCommonConstants.DSHRTOUKEIOUTKBN_DHANEISEISANDHANEI.equals(pDshrtoukeioutKbn)) {
            shrriyuuKbn = SrCommonConstants.SHRRIYUUKBN_KARITOTUMI;
        }

        if (SrCommonConstants.DSHRTOUKEIOUTKBN_DSHRSYORI.equals(pDshrtoukeioutKbn) &&
            SrCommonConstants.TUMIDKARIDKBN_TUMIDRECORD.equals(pTumidkaridKbn)) {
            dUketoriHouhouKbn = SrCommonConstants.DUKETORIHOUKBN_TUMITATED;
        }
        else {
            dUketoriHouhouKbn = SrCommonConstants.DUKETORIHOUKBN_KARIWARIATED;
        }

        BizDate denymd = null;
        if (pDshrTukiInfoBean.getDenymd() == null) {
            denymd = pDshrTukiInfoBean.getSyoriYmd();
        }
        else {
            denymd = pDshrTukiInfoBean.getDenymd();
        }

        BizDate zenJigyouNendomatuBi = null;
        if (denymd.getMonth() >= SrCommonConstants.MONTH_APRIL) {
            zenJigyouNendomatuBi = BizDate.valueOf(denymd.getBizDateY(),
                BizDateMD.valueOf(SrCommonConstants.FIXEDDAY_NENDOKSNBI));
        }
        else {
            zenJigyouNendomatuBi = BizDate.valueOf(denymd.getBizDateY().addYears(-SrCommonConstants.YEAR_1Y),
                BizDateMD.valueOf(SrCommonConstants.FIXEDDAY_NENDOKSNBI));
        }

        SrDshrToukeiBatchDbAccess srDshrToukeiBatchDbAccess = SWAKInjector.getInstance(SrDshrToukeiBatchDbAccess.class);

        long  bikinKykHaitouMeisaiCount = srDshrToukeiBatchDbAccess.getBikinKykHaitouMeisaiCount(
            pDshrTukiInfoBean.getSyono(),
            zenJigyouNendomatuBi);

        if (bikinKykHaitouMeisaiCount > 0) {
            bikinHyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            bikinHyj = SrCommonConstants.HYOUJI_NASI;
        }
    }

    private void setModosiKingk(BizDate pCalcKijyunFromYmd, BizDate pCalckijyunToYmd, BizCurrency pModosimaeKingk,
        String pSyono, SrDshrToukeiBatchParam pBatchParam) {

        modosiKingk = BizCurrency.valueOf(0);

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(pCalcKijyunFromYmd, pCalckijyunToYmd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            String msg =
                MessageUtil.getMessage(MessageId.ESA1001, "割戻し金額計算", pSyono);

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSyono);
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pBatchParam.setErrorCount(pBatchParam.getErrorCount() + 1);
            mainErrorFlg = true;

            return;
        }

        BizNumber haitouriritu = getDRiritu.getDRiritu();

        List<BizNumber> haitouRirituLst = new ArrayList<>();

        haitouRirituLst.add(haitouriritu);

        KeisanDCommon keisanDCommon = SWAKInjector.getInstance(KeisanDCommon.class);
        modosiKingk = keisanDCommon.calcWrmdsKngk(pModosimaeKingk, haitouRirituLst);

    }

    private void setHaitouganrikin(BizCurrency pRuigk, BizDate pCalcKijyunFromYmd, BizDate pCalckijyunToYmd,
        String pSyono, SrDshrToukeiBatchParam pBatchParam) {

        haitouganRikin = BizCurrency.valueOf(0);

        KeisanDGanrikin keisanDGanrikin = SWAKInjector.getInstance(KeisanDGanrikin.class);
        C_ErrorKbn errorKbn = keisanDGanrikin.exec(
            pRuigk,
            pCalcKijyunFromYmd,
            pCalckijyunToYmd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            String msg =
                MessageUtil.getMessage(MessageId.ESA1001, "配当元利金計算", pSyono);

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSyono);
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pBatchParam.setErrorCount(pBatchParam.getErrorCount() + 1);
            mainErrorFlg = true;
        }
        else {
            haitouganRikin = keisanDGanrikin.getDGanrikin();
        }
    }

    private void setHaitouganrikinOverYear(BizCurrency pRuigk, BizDate pCalcKijyunYmd, BizDate pCalckijyunYmdTyouseiz,
        String pSyono, SrDshrToukeiBatchParam pBatchParam, BizDate pKykYmd) {

        haitouganRikin = BizCurrency.valueOf(0);

        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);
        List<DRateBean> drateBeanLst = setDNnd.execCorrespoindingOverAYear(
            pKykYmd,
            pSyono,
            pCalcKijyunYmd,
            pCalckijyunYmdTyouseiz);

        if (drateBeanLst == null) {

            String msg = MessageUtil.getMessage(MessageId.ESA1001, "Ｄレート年度回数設定", pSyono);

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSyono);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pBatchParam.setErrorCount(pBatchParam.getErrorCount() + 1);
            mainErrorFlg = true;
        }

        KeisanDGanrikin keisanDGanrikin = SWAKInjector.getInstance(KeisanDGanrikin.class);
        C_ErrorKbn errorKbn = keisanDGanrikin.execAllowOverAYear(
            pRuigk,
            drateBeanLst);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            String msg =
                MessageUtil.getMessage(MessageId.ESA1001, "配当元利金計算（１年超）", pSyono);

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSyono);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pBatchParam.setErrorCount(pBatchParam.getErrorCount() + 1);
            mainErrorFlg = true;
        }
        else{
            haitouganRikin = keisanDGanrikin.getDGanrikin();
        }
    }
}