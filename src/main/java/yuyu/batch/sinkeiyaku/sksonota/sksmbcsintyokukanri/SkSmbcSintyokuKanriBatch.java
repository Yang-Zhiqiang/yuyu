package yuyu.batch.sinkeiyaku.sksonota.sksmbcsintyokukanri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.hozen.khcommon.SetSyokenhakkouymd;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SmbcEditSintyokuData;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Kanryouflg;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_MobilebosyuuKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_Rendouflg;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkMisslistBean;
import yuyu.def.sinkeiyaku.bean.report.SkMisslistDetailBean;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.jasperreport.JasperReportServicesBean;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * 新契約 その他 SMBC進捗管理データ作成
 */
public class SkSmbcSintyokuKanriBatch implements Batch {

    private static final String BLANK = "";
    private static final String SEIREKIUP2 = "20";

    private String userID;
    private String kinouID;
    private String sysTime;
    private BizDate sysDate;
    private long syoriKensuu;
    private BizNumber maxNo;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean recoveryDataSikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        HashMap<String, Object> smbcStyKanriMap = null;
        userID = bzBatchParam.getUserId();
        kinouID = kinou.getKinouId();
        sysTime = BizDate.getSysDateTimeMilli();
        sysDate = bzBatchParam.getSyoriYmd();
        syoriKensuu = 0;
        maxNo = BizNumber.valueOf(0);
        String tableId = "HT_SyoriCTL";
        String recoveryFilterId = "Sk001";
        SkMisslistBean skMislistBean = new SkMisslistBean();
        ArrayList<IReportDataSouceBean> skMisslistDetailBeanLst = new ArrayList<>();

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(sysDate)));

        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018), kakutyoujobCd));

        BizNumber maxDataNo = sinkeiyakuDomManager.getSmbcStyKanriMaxDatasakuseirennoByDatarenymd(sysDate);

        if (maxDataNo != null) {
            maxNo = maxDataNo;
        }
        SmbcEditSintyokuData smbcEditSintyokuData = SWAKInjector.getInstance(SmbcEditSintyokuData.class);

        try (EntityInserter<HT_SmbcStyKanri> smbcStyKanriInsert = new EntityInserter<>()) {

            try (EntityInserter<HT_SmbcStyKanriSsRireki> smbcStyKanriSsRirekiInsert = new EntityInserter<>()) {

                try (ExDBResults<HT_SyoriCTL> syoriCTLExDBResults =
                    sinkeiyakuDomManager.getSmbcSnkSntKnrTsDatasByKakutyoujobcd(kakutyoujobCd)) {

                    for (HT_SyoriCTL syoriCTL : syoriCTLExDBResults) {

                        smbcStyKanriMap = new HashMap<>();
                        HT_SmbcStyKanri smbcStyKanri = new HT_SmbcStyKanri();
                        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki = new HT_SmbcStyKanriSsRireki();

                        recoveryDataSikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                        recoveryDataSikibetuBean.setIbTableid(tableId);
                        recoveryDataSikibetuBean.setIbRecoveryfilterid(recoveryFilterId);
                        recoveryDataSikibetuBean.setIbRecoveryfilterkey1(syoriCTL.getMosno());

                        if (!checkKikan(syoriCTL.getSeiritukbn(), syoriCTL.getSrsyoriymd())) {
                            continue;
                        }

                        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(1);
                        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                        if (!checkUketukekanriId(mosKihon.getMosno(), mosKihon.getUktkid(), skMisslistDetailBeanLst)) {
                            continue;
                        }

                        initSmbcSntInsMap(syoriCTL, mosKihon, mosDairiten, smbcStyKanriMap);

                        smbcEditSintyokuData.setFstrndumuflg(C_UmuKbn.ARI);
                        smbcEditSintyokuData.exec(syoriCTL, sysDate, smbcStyKanriMap);

                        editSmbcSntInsUpdateSet(smbcStyKanriMap, smbcStyKanri);
                        BizPropertyInitializer.initialize(smbcStyKanri);
                        smbcStyKanriInsert.add(smbcStyKanri);

                        editRrKTblInsUpdateSet(syoriCTL, smbcStyKanriMap, smbcStyKanriSsRireki);
                        BizPropertyInitializer.initialize(smbcStyKanriSsRireki);
                        smbcStyKanriSsRirekiInsert.add(smbcStyKanriSsRireki);

                        syoriKensuu++;
                    }

                    recoveryDataSikibetuBean.initializeBlank();
                }
            }

            smbcEditSintyokuData = SWAKInjector.getInstance(SmbcEditSintyokuData.class);

            try (EntityUpdater<HT_SmbcStyKanriSsRireki> smbcStyKanriSsRirekiUpdater = new EntityUpdater<>()) {

                try (ExDBResults<HT_SyoriCTL> syoriCTLExDBResults =
                    sinkeiyakuDomManager.getSmbcHnkSntKnrTsDatasByKakutyoujobcd(kakutyoujobCd)) {

                    for (HT_SyoriCTL syoriCTL: syoriCTLExDBResults) {

                        smbcStyKanriMap = new HashMap<>();
                        HT_SmbcStyKanri smbcStyKanri = new HT_SmbcStyKanri();

                        recoveryDataSikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                        recoveryDataSikibetuBean.setIbTableid(tableId);
                        recoveryDataSikibetuBean.setIbRecoveryfilterid(recoveryFilterId);
                        recoveryDataSikibetuBean.setIbRecoveryfilterkey1(syoriCTL.getMosno());

                        if (!checkKikan(syoriCTL.getSeiritukbn(), syoriCTL.getSrsyoriymd())) {
                            continue;
                        }

                        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(1);
                        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                        if (!checkUketukekanriId(mosKihon.getMosno(), mosKihon.getUktkid(), skMisslistDetailBeanLst)) {
                            continue;
                        }

                        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki =
                            sinkeiyakuDomManager.getSmbcStyKanriSsRireki(syoriCTL.getSyono());

                        initSmbcSntInsMap(syoriCTL, mosKihon, mosDairiten, smbcStyKanriMap);

                        editSmbcSntInsMap(smbcStyKanriSsRireki, smbcStyKanriMap);

                        smbcEditSintyokuData.setFstrndumuflg(C_UmuKbn.NONE);
                        smbcEditSintyokuData.exec(syoriCTL, sysDate, smbcStyKanriMap);

                        editSmbcSntInsUpdateSet(smbcStyKanriMap, smbcStyKanri);

                        if (checkSMBCSousinTaisyou(syoriCTL, sysDate, smbcStyKanri, smbcStyKanriSsRireki) == -1) {

                            continue;
                        }

                        BizPropertyInitializer.initialize(smbcStyKanri);
                        smbcStyKanriInsert.add(smbcStyKanri);

                        editRrKTblInsUpdateSet(syoriCTL, smbcStyKanriMap, smbcStyKanriSsRireki);
                        BizPropertyInitializer.initialize(smbcStyKanriSsRireki);
                        smbcStyKanriSsRirekiUpdater.add(smbcStyKanriSsRireki);

                        syoriKensuu++;
                    }

                    recoveryDataSikibetuBean.initializeBlank();
                }
            }
        }

        if (skMisslistDetailBeanLst.size() != 0) {

            outputSkMisslist(skMislistBean, skMisslistDetailBeanLst);

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0018, String.valueOf(syoriKensuu)));
        }
        else {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0019, String.valueOf(syoriKensuu)));
        }
    }

    private void initSmbcSntInsMap(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, HT_MosDairiten pMosDairiten,
        Map<String, Object> pSmbcStyKanriMap) {

        String syoNo = "";
        if (C_SeirituKbn.SEIRITU.eq(pSyoriCTL.getSeiritukbn())) {

            syoNo = pSyoriCTL.getSyono();
        }
        else {
            syoNo = "";
        }

        pSmbcStyKanriMap.put(HT_SmbcStyKanri.DATARENYMD, sysDate);
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.SYONO, pSyoriCTL.getSyono());
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.MOSNO, pSyoriCTL.getMosno());
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.RENDOUFLG, C_Rendouflg.MIRENDOU);
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCDATAKBN, "0");
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCDATASAKUSEIYMD, sysDate.toString());
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCHKNKAISYACD, "DT");
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCUKTKKANRIID, pMosKihon.getUktkid());
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCBANKHNKYKFLG, BLANK);
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCSEIHOSYUMOKU, "AA");
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCSYONO, syoNo);
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCSYONOEDABAN, BLANK);
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCKOSYAAREASTYKNR, BLANK);
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.GYOUMUKOUSINKINOU, kinouID);
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.GYOUMUKOUSINSYAID, userID);
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.GYOUMUKOUSINTIME, sysTime);
        maxNo = maxNo.add(BizNumber.valueOf(1));
        pSmbcStyKanriMap.put(HT_SmbcStyKanri.DATASAKUSEIRENNO, maxNo);

        if (C_KykKbn.KEIHI_DOUITU.eq(pMosKihon.getKykkbn())) {

            pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCKYKSEIYMD, pMosKihon.getHhknseiymd().toString());

            pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCKYKNMKN, pMosKihon.getHhknnmkn());
        }
        else {

            pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCKYKSEIYMD, pMosKihon.getKykseiymd().toString());

            pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCKYKNMKN, pMosKihon.getKyknmkn());
        }

        if (C_MosUketukeKbn.PAPERLESS.eq(pSyoriCTL.getMosuketukekbn())) {

            if (C_MobilebosyuuKbn.MOBILEBOSYUU.eq(pMosKihon.getMobilebosyuukbn())) {
                pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCMOSSYORIFLG, "2");
            }
            else {
                pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCMOSSYORIFLG, "1");
            }
            if (pMosKihon.getPplessmosukeymd() != null) {
                pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCMOSUKTYMD, pMosKihon.getPplessmosukeymd().toString());
            }
            else {
                pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCMOSUKTYMD, "");
            }
        }
        else {
            pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCMOSSYORIFLG, "0");
            pSmbcStyKanriMap.put(HT_SmbcStyKanri.SMBCMOSUKTYMD, "");
        }
    }

    private void editSmbcSntInsMap(HT_SmbcStyKanriSsRireki pSmbcStyKanriSsRireki,
        HashMap<String, Object> pSintyokuKanriMap) {

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki = pSmbcStyKanriSsRireki;

        pSintyokuKanriMap.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD,
            smbcStyKanriSsRireki.getSmbcseihouktkzmymd());
        pSintyokuKanriMap.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD,
            smbcStyKanriSsRireki.getSmbcseihohbymd());
        pSintyokuKanriMap.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD,
            smbcStyKanriSsRireki.getSmbcseihohbksyymd());
        pSintyokuKanriMap.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD + "RRK",
            smbcStyKanriSsRireki.getSmbcseihohbksyymd());
        pSintyokuKanriMap.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD,
            smbcStyKanriSsRireki.getSmbcseihohjyttykymd());
        pSintyokuKanriMap.put(HT_SmbcStyKanri.SMBCSEIHONYKNZMYMD,
            smbcStyKanriSsRireki.getSmbcseihonyknzmymd());
        pSintyokuKanriMap.put(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD,
            smbcStyKanriSsRireki.getSmbcseihosnszmymd());
        pSintyokuKanriMap.put(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD,
            smbcStyKanriSsRireki.getSmbcseihosyknhkkzmymd());
        pSintyokuKanriMap.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD,
            smbcStyKanriSsRireki.getSmbcseihotrksymd());
        pSintyokuKanriMap.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD,
            smbcStyKanriSsRireki.getSmbcseihohktymd());
        pSintyokuKanriMap.put(HT_SmbcStyKanri.SMBCSEIHOSYURUI,
            smbcStyKanriSsRireki.getSmbcseihosyurui());
        pSintyokuKanriMap.put(HT_SmbcStyKanri.SMBCJKTKFLG,
            smbcStyKanriSsRireki.getSmbcjktkflg());
    }

    private void editSmbcSntInsUpdateSet(HashMap<String, Object> pSmbcStyKanriMap, HT_SmbcStyKanri pSmbcStyKanri) {

        pSmbcStyKanri.setDatarenymd((BizDate)pSmbcStyKanriMap.get(HT_SmbcStyKanri.DATARENYMD));
        pSmbcStyKanri.setDatasakuseirenno((BizNumber)pSmbcStyKanriMap.get(HT_SmbcStyKanri.DATASAKUSEIRENNO));
        pSmbcStyKanri.setSyono((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SYONO));
        pSmbcStyKanri.setMosno((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.MOSNO));
        pSmbcStyKanri.setRendouflg((C_Rendouflg)pSmbcStyKanriMap.get(HT_SmbcStyKanri.RENDOUFLG));
        pSmbcStyKanri.setSmbcdatakbn((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCDATAKBN));
        pSmbcStyKanri.setSmbcdatasakuseiymd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCDATASAKUSEIYMD));
        pSmbcStyKanri.setSmbchknkaisyacd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCHKNKAISYACD));
        pSmbcStyKanri.setSmbcuktkkanriid((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCUKTKKANRIID));
        pSmbcStyKanri.setSmbcseihouktkzmymd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD));
        pSmbcStyKanri.setSmbcseihohbymd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD));
        pSmbcStyKanri.setSmbcbankhnkykflg((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCBANKHNKYKFLG));
        pSmbcStyKanri.setSmbcseihohbksyymd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD));
        pSmbcStyKanri.setSmbcseihohjyttykymd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD));
        pSmbcStyKanri.setSmbcseihonyknzmymd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSEIHONYKNZMYMD));
        pSmbcStyKanri.setSmbcseihosnszmymd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD));
        pSmbcStyKanri.setSmbcseihosyknhkkzmymd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD));
        pSmbcStyKanri.setSmbcseihosyumoku((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOSYUMOKU));
        pSmbcStyKanri.setSmbcseihosyurui((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOSYURUI));
        pSmbcStyKanri.setSmbcsyono((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSYONO));
        pSmbcStyKanri.setSmbcsyonoedaban((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSYONOEDABAN));
        pSmbcStyKanri.setSmbcjktkflg((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCJKTKFLG));
        pSmbcStyKanri.setSmbcseihotrksymd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD));
        pSmbcStyKanri.setSmbcseihohktymd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOHKTYMD));
        pSmbcStyKanri.setSmbckykseiymd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCKYKSEIYMD));
        pSmbcStyKanri.setSmbckyknmkn((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCKYKNMKN));
        pSmbcStyKanri.setSmbcmosuktymd((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCMOSUKTYMD));
        pSmbcStyKanri.setSmbcmossyoriflg((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCMOSSYORIFLG));
        pSmbcStyKanri.setSmbckosyaareastyknr((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.SMBCKOSYAAREASTYKNR));
        pSmbcStyKanri.setGyoumuKousinKinou((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.GYOUMUKOUSINKINOU));
        pSmbcStyKanri.setGyoumuKousinsyaId((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.GYOUMUKOUSINSYAID));
        pSmbcStyKanri.setGyoumuKousinTime((String)pSmbcStyKanriMap.get(HT_SmbcStyKanri.GYOUMUKOUSINTIME));
    }

    private void editRrKTblInsUpdateSet(HT_SyoriCTL pSyoriCTL,
        HashMap<String, Object> pSintyokuKanriMap,
        HT_SmbcStyKanriSsRireki pSmbcStyKanriSsRireki) {

        C_Kanryouflg renKanryoFlg = C_Kanryouflg.MIKANRYOU;

        if (C_SeirituKbn.SEIRITU.eq(pSyoriCTL.getSeiritukbn())
            || C_SeirituKbn.HUSEIRITU.eq(pSyoriCTL.getSeiritukbn())) {
            renKanryoFlg = C_Kanryouflg.KANRYOU;
        }
        else {
            renKanryoFlg = C_Kanryouflg.MIKANRYOU;
        }

        pSmbcStyKanriSsRireki.setSyono((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SYONO));
        pSmbcStyKanriSsRireki.setMosno((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.MOSNO));
        pSmbcStyKanriSsRireki.setSyrctrltblkostime(pSyoriCTL.getGyoumuKousinTime());
        pSmbcStyKanriSsRireki.setRenkanryoflg(Integer.valueOf(renKanryoFlg.getValue()));
        pSmbcStyKanriSsRireki.setSmbcdatakbn((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCDATAKBN));
        pSmbcStyKanriSsRireki.setSmbcdatasakuseiymd((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCDATASAKUSEIYMD));
        pSmbcStyKanriSsRireki.setSmbchknkaisyacd((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCHKNKAISYACD));
        pSmbcStyKanriSsRireki.setSmbcuktkkanriid((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCUKTKKANRIID));
        pSmbcStyKanriSsRireki.setSmbcseihouktkzmymd((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD));
        pSmbcStyKanriSsRireki.setSmbcseihohbymd((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD));
        pSmbcStyKanriSsRireki.setSmbcbankhnkykflg((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCBANKHNKYKFLG));
        pSmbcStyKanriSsRireki.setSmbcseihohbksyymd((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD));
        pSmbcStyKanriSsRireki.setSmbcseihohjyttykymd((String)pSintyokuKanriMap.
            get(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD));
        pSmbcStyKanriSsRireki.setSmbcseihonyknzmymd((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCSEIHONYKNZMYMD));
        pSmbcStyKanriSsRireki.setSmbcseihosnszmymd((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD));
        pSmbcStyKanriSsRireki.setSmbcseihosyknhkkzmymd((String)pSintyokuKanriMap.
            get(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD));
        pSmbcStyKanriSsRireki.setSmbcseihosyumoku((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOSYUMOKU));
        pSmbcStyKanriSsRireki.setSmbcseihosyurui((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOSYURUI));
        pSmbcStyKanriSsRireki.setSmbcsyono((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCSYONO));
        pSmbcStyKanriSsRireki.setSmbcsyonoedaban((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCSYONOEDABAN));
        pSmbcStyKanriSsRireki.setSmbcjktkflg((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCJKTKFLG));
        pSmbcStyKanriSsRireki.setSmbcseihotrksymd((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD));
        pSmbcStyKanriSsRireki.setSmbcseihohktymd((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCSEIHOHKTYMD));
        pSmbcStyKanriSsRireki.setSmbckykseiymd((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCKYKSEIYMD));
        pSmbcStyKanriSsRireki.setSmbckyknmkn((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCKYKNMKN));
        pSmbcStyKanriSsRireki.setSmbcmosuktymd((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCMOSUKTYMD));
        pSmbcStyKanriSsRireki.setSmbcmossyoriflg((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.SMBCMOSSYORIFLG));
        pSmbcStyKanriSsRireki.setSmbckosyaareastyknr((String)pSintyokuKanriMap.
            get(HT_SmbcStyKanri.SMBCKOSYAAREASTYKNR));
        pSmbcStyKanriSsRireki.setGyoumuKousinKinou((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.GYOUMUKOUSINKINOU));
        pSmbcStyKanriSsRireki.setGyoumuKousinsyaId((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.GYOUMUKOUSINSYAID));
        pSmbcStyKanriSsRireki.setGyoumuKousinTime((String)pSintyokuKanriMap.get(HT_SmbcStyKanri.GYOUMUKOUSINTIME));
    }

    private boolean checkUketukekanriId(String pMosNo, String pUktkId, ArrayList<IReportDataSouceBean> pBeanList) {

        boolean isErr = false;
        SkMisslistDetailBean skMissLstBean;

        if (pUktkId.length() < 7) {
            isErr = true;
        }
        else {
            String uktkKanriId6keta = pUktkId.substring(0, 6);
            String taikeiChkStr = SEIREKIUP2 + uktkKanriId6keta;
            if (!BizDate.valueOf(taikeiChkStr).isRekijyou()) {
                isErr = true;
            }
        }
        if (isErr) {
            skMissLstBean = new SkMisslistDetailBean();
            skMissLstBean.setIrMosno(pMosNo);
            skMissLstBean.setIrMisslistmsg(MessageUtil.getMessage(MessageId.EHA1049, pUktkId));
            pBeanList.add(skMissLstBean);

            return false;
        }

        List<HT_MosKihon> mosKihons_dup = sinkeiyakuDomManager.getMosKihonsByUktkidMosnoNe(pUktkId, pMosNo);
        if (mosKihons_dup != null && mosKihons_dup.size() > 0) {
            String mosno_dup = mosKihons_dup.get(0).getMosno();
            int count = mosKihons_dup.size() - 1;

            skMissLstBean = new SkMisslistDetailBean();
            skMissLstBean.setIrMosno(pMosNo);
            if (count == 0) {
                skMissLstBean.setIrMisslistmsg(MessageUtil.getMessage(MessageId.EHA1066, pUktkId, mosno_dup));
            } else {
                skMissLstBean.setIrMisslistmsg(
                    MessageUtil.getMessage(MessageId.EHA1067, pUktkId, mosno_dup, String.valueOf(count)));
            }
            pBeanList.add(skMissLstBean);

            return false;
        }

        return true;
    }

    private boolean checkKikan(C_SeirituKbn pSeirituKbn, BizDate pSrsyoriymd) {
        BizDate kjnTo = null;

        if (C_SeirituKbn.HUSEIRITU.eq(pSeirituKbn)) {
            kjnTo = pSrsyoriymd.addBusinessDays(5);
        }
        else if (C_SeirituKbn.SEIRITU.eq(pSeirituKbn)) {
            SetSyokenhakkouymd setSyokenhakkouymd = SWAKInjector.getInstance(SetSyokenhakkouymd.class);
            BizDate syoHakkouYmd = setSyokenhakkouymd.exec(pSrsyoriymd);
            kjnTo = syoHakkouYmd.addBusinessDays(5);
        }
        else {
            return true;
        }

        if (kjnTo != null && BizDateUtil.compareYmd(kjnTo, sysDate) == BizDateUtil.COMPARE_LESSER) {
            return false;
        }

        return true;
    }

    private int checkSMBCSousinTaisyou(HT_SyoriCTL pSyoriCTL,
        BizDate pSyoriYmd,
        HT_SmbcStyKanri pSmbcStyKanri,
        HT_SmbcStyKanriSsRireki pSmbcStyKanriSsRireki) {

        if (!pSmbcStyKanri.getSyono().equals(pSmbcStyKanriSsRireki.getSyono())) {
            return 0;
        }
        if (!pSmbcStyKanri.getMosno().equals(pSmbcStyKanriSsRireki.getMosno())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcdatakbn().equals(pSmbcStyKanriSsRireki.getSmbcdatakbn())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcdatasakuseiymd().equals(pSmbcStyKanriSsRireki.getSmbcdatasakuseiymd())) {
            return 0;
        }
        if (!pSmbcStyKanri.getSmbchknkaisyacd().equals(pSmbcStyKanriSsRireki.getSmbchknkaisyacd())) {
            return 0;
        }
        if (!pSmbcStyKanri.getSmbcuktkkanriid().equals(pSmbcStyKanriSsRireki.getSmbcuktkkanriid())) {
            return 0;
        }
        if (!pSmbcStyKanri.getSmbcseihouktkzmymd().equals(pSmbcStyKanriSsRireki.getSmbcseihouktkzmymd())) {
            return 0;
        }
        if (!pSmbcStyKanri.getSmbcseihohbymd().equals(pSmbcStyKanriSsRireki.getSmbcseihohbymd())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcbankhnkykflg().equals(pSmbcStyKanriSsRireki.getSmbcbankhnkykflg())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcseihohbksyymd().equals(pSmbcStyKanriSsRireki.getSmbcseihohbksyymd())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcseihohjyttykymd().equals(pSmbcStyKanriSsRireki.getSmbcseihohjyttykymd())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcseihonyknzmymd().equals(pSmbcStyKanriSsRireki.getSmbcseihonyknzmymd())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcseihosnszmymd().equals(pSmbcStyKanriSsRireki.getSmbcseihosnszmymd())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcseihosyknhkkzmymd().equals(pSmbcStyKanriSsRireki.getSmbcseihosyknhkkzmymd())) {
            return 0;
        }
        if (!pSmbcStyKanri.getSmbcseihosyumoku().equals(pSmbcStyKanriSsRireki.getSmbcseihosyumoku())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcseihosyurui().equals(pSmbcStyKanriSsRireki.getSmbcseihosyurui())) {
            return 0;
        }
        if (!pSmbcStyKanri.getSmbcsyono().equals(pSmbcStyKanriSsRireki.getSmbcsyono())) {
            return 0;
        }
        if (!pSmbcStyKanri.getSmbcsyonoedaban().equals(pSmbcStyKanriSsRireki.getSmbcsyonoedaban())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcjktkflg().equals(pSmbcStyKanriSsRireki.getSmbcjktkflg())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcseihotrksymd().equals(pSmbcStyKanriSsRireki.getSmbcseihotrksymd())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcseihohktymd().equals(pSmbcStyKanriSsRireki.getSmbcseihohktymd())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbckykseiymd().equals(pSmbcStyKanriSsRireki.getSmbckykseiymd())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbckyknmkn().equals(pSmbcStyKanriSsRireki.getSmbckyknmkn())) {
            return 0;
        }

        if (!pSmbcStyKanri.getSmbcmosuktymd().equals(pSmbcStyKanriSsRireki.getSmbcmosuktymd())) {
            return 0;
        }
        if (!pSmbcStyKanri.getSmbcmossyoriflg().equals(pSmbcStyKanriSsRireki.getSmbcmossyoriflg())) {
            return 0;
        }

        return -1;
    }

    private void outputSkMisslist(SkMisslistBean pSkMisslistBean,
        ArrayList<IReportDataSouceBean> pSkMislistDetailBeanLst){

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
        JasperReportServicesBean jasperReportServicesBean = new JasperReportServicesBean(
            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
            kinou.getCategoryId(),
            kinou.getKinouId(),
            C_SyoruiCdKbn.SK_SMBCSINTYOKUMISSLIST);

        pSkMisslistBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJINoEx(sysDate));
        pSkMisslistBean.setIrKensuu(pSkMislistDetailBeanLst.size());
        pSkMisslistBean.setIrKinounm("SMBC進捗管理データ作成");

        jasperReportServicesBean.setSyoriYmd(sysDate);
        jasperReportServicesBean.addParamObjects(C_SyoruiCdKbn.SK_SMBCSINTYOKUMISSLIST,
            pSkMislistDetailBeanLst,
            pSkMisslistBean);

        createReport.execNoCommit(jasperReportServicesBean);
    }

    @AppBatchExceptionTerminate
    private void abendexec() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
