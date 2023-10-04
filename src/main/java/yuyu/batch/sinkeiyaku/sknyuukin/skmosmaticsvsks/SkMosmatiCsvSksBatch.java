package yuyu.batch.sinkeiyaku.sknyuukin.skmosmaticsvsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skmosmaticsvsks.dba.SkMosmatiListCsvSakuseiDao;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.sinkeiyaku.skcommon.SetNyknRnrkhyouYmd;
import yuyu.def.MessageId;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.entity.HV_MosSyoruiMitoutyakuList;
import yuyu.def.sinkeiyaku.file.csv.SkMosmatilistcsvsakuseiLayoutFile;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 申込書類未到着ＣＳＶ作成のバッチクラスです。
 */
public class SkMosmatiCsvSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SkMosmatiListCsvSakuseiDao skMosmatiListCsvSakuseiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        long syutokuCnt = 0;
        List<SkMosmatilistcsvsakuseiLayoutFile> skMosmatilistcsvsakuseiLayoutFileLst = new ArrayList<>();
        C_NyktyhyoutKbn[] nyktyhyoutList = new C_NyktyhyoutKbn[] {C_NyktyhyoutKbn.NONE, C_NyktyhyoutKbn.GAIKADATE};

        syutokuCnt = createSkMosmatilistcsvsakuseiLayoutFileLst(skMosmatilistcsvsakuseiLayoutFileLst, syoriYmd,
            nyktyhyoutList);

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_MOSMATICSV, skMosmatilistcsvsakuseiLayoutFileLst, true);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(syutokuCnt), "申込書類未到着ＣＳＶ作成"));

        syutokuCnt = 0;
        skMosmatilistcsvsakuseiLayoutFileLst = new ArrayList<>();
        nyktyhyoutList = new C_NyktyhyoutKbn[] {C_NyktyhyoutKbn.YENDATE};

        syutokuCnt = createSkMosmatilistcsvsakuseiLayoutFileLst(skMosmatilistcsvsakuseiLayoutFileLst, syoriYmd,
            nyktyhyoutList);

        bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_MOSMATICSV_YENDT, skMosmatilistcsvsakuseiLayoutFileLst, true);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(syutokuCnt), "申込書類未到着ＣＳＶ（円建）"));
    }

    private String dateDOTSeirekiNoEx(BizDate pSource){

        try {
            String retStr = new BizDateFormat("yyyyMMdd",FillStyle.Zero).format(pSource);

            return retStr;
        }
        catch(Exception exp) {
            if (pSource == null) {
                return null;
            }

            return pSource.toString();
        }
    }

    private long createSkMosmatilistcsvsakuseiLayoutFileLst (
        List<SkMosmatilistcsvsakuseiLayoutFile> pSkMosmatilistcsvsakuseiLayoutFileLst, BizDate pKnjyymd,
        C_NyktyhyoutKbn[] pNyktyhyoutList) {
        long syutokuCnt = 0;
        SetNyknRnrkhyouYmd setNyknRnrkhyouYmd = SWAKInjector.getInstance(SetNyknRnrkhyouYmd.class);
        String syorizumiOyadrtencd = "";
        HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou = null;
        String utdskknnm1kj = "";
        String utdskknnm2kj = "";


        try (ExDBResults<HV_MosSyoruiMitoutyakuList> mosSyoruiMitoutyakuLists =
            skMosmatiListCsvSakuseiDao.getMosSyoruiMitoutyakuListsBySyoriYmdNyktyhyoutlst(pKnjyymd, pNyktyhyoutList)) {

            for (HV_MosSyoruiMitoutyakuList mosSyoruiMitoutyakuList : mosSyoruiMitoutyakuLists) {

                String oyadrtenNm = mosSyoruiMitoutyakuList.getNyuukinoyadrtennm();

                if (!syorizumiOyadrtencd.equals(mosSyoruiMitoutyakuList.getOyadrtencd())) {
                    skDairitenKobetuJyouhou = sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(
                        mosSyoruiMitoutyakuList.getOyadrtencd());

                    if (skDairitenKobetuJyouhou != null) {
                        utdskknnm1kj = skDairitenKobetuJyouhou.getUtdskknnm1kj();
                        utdskknnm2kj = skDairitenKobetuJyouhou.getUtdskknnm2kj();
                    }
                    else {
                        utdskknnm1kj = "";
                        utdskknnm2kj = "";
                    }

                    syorizumiOyadrtencd = mosSyoruiMitoutyakuList.getOyadrtencd();
                }

                SkMosmatilistcsvsakuseiLayoutFile skMosmatilistcsvsakuseiLayoutFile =
                    SWAKInjector.getInstance(SkMosmatilistcsvsakuseiLayoutFile.class);

                skMosmatilistcsvsakuseiLayoutFile.setIfcDrtennmkj(oyadrtenNm);
                skMosmatilistcsvsakuseiLayoutFile.setIfcOyadrtencd(mosSyoruiMitoutyakuList.getOyadrtencd());
                skMosmatilistcsvsakuseiLayoutFile.setIfcUtidasikikannm1(utdskknnm1kj);
                skMosmatilistcsvsakuseiLayoutFile.setIfcUtidasikikannm2(utdskknnm2kj);
                skMosmatilistcsvsakuseiLayoutFile.setIfcNyknymd(
                    dateDOTSeirekiNoEx(mosSyoruiMitoutyakuList.getKnjyymd()));
                skMosmatilistcsvsakuseiLayoutFile.setIfcSyouhnno(mosSyoruiMitoutyakuList.getSyouhnno());
                skMosmatilistcsvsakuseiLayoutFile.setIfcMosno(mosSyoruiMitoutyakuList.getNykmosno());
                skMosmatilistcsvsakuseiLayoutFile.setIfcHrkmirninnm(mosSyoruiMitoutyakuList.getHrkmirninnm());
                skMosmatilistcsvsakuseiLayoutFile.setIfcTuukasyu(mosSyoruiMitoutyakuList.getTuukasyu().getContent());
                skMosmatilistcsvsakuseiLayoutFile.setIfcTrhkkgk(mosSyoruiMitoutyakuList.getTrhkkgk().toString());
                skMosmatilistcsvsakuseiLayoutFile.setIfcDengk(mosSyoruiMitoutyakuList.getDengk().toString());


                if (!C_Tuukasyu.JPY.eq(mosSyoruiMitoutyakuList.getTuukasyu())) {
                    skMosmatilistcsvsakuseiLayoutFile.setIfcSimukebanknm(ConvertUtil.toZenAll(
                        mosSyoruiMitoutyakuList.getSimukebanknmeiji(), 0, 1));
                    skMosmatilistcsvsakuseiLayoutFile.setIfcSimuketennm(ConvertUtil.toZenAll(
                        mosSyoruiMitoutyakuList.getSimuketennmeiji(), 0, 1));
                }
                else {
                    skMosmatilistcsvsakuseiLayoutFile.setIfcSimukebanknm(mosSyoruiMitoutyakuList.getSimukebanknmkn());
                    skMosmatilistcsvsakuseiLayoutFile.setIfcSimuketennm(mosSyoruiMitoutyakuList.getSimuketennmkn());
                }

                BizDate nyknRnrkhyouYmd = setNyknRnrkhyouYmd.exec(
                    mosSyoruiMitoutyakuList.getHrkmnykndatarenmotoKbn(), mosSyoruiMitoutyakuList.getSyoriYmd());
                skMosmatilistcsvsakuseiLayoutFile.setIfcNyknrnrkhyouymd(dateDOTSeirekiNoEx(nyknRnrkhyouYmd));

                skMosmatilistcsvsakuseiLayoutFile.setIfcBankcd(mosSyoruiMitoutyakuList.getBankcd());
                skMosmatilistcsvsakuseiLayoutFile.setIfcSitencd(mosSyoruiMitoutyakuList.getSitencd());

                if (mosSyoruiMitoutyakuList.getSiteituuka() == null) {
                    skMosmatilistcsvsakuseiLayoutFile.setIfcSiteituuka("");
                }
                else {
                    skMosmatilistcsvsakuseiLayoutFile.setIfcSiteituuka(mosSyoruiMitoutyakuList.getSiteituuka()
                        .getContent());
                }

                if (mosSyoruiMitoutyakuList.getHrkmnykndatarenmotoKbn() == null) {
                    skMosmatilistcsvsakuseiLayoutFile.setIfcHrkmnykndatarenmotoKbn("");
                }
                else {
                    skMosmatilistcsvsakuseiLayoutFile.setIfcHrkmnykndatarenmotoKbn(
                        mosSyoruiMitoutyakuList.getHrkmnykndatarenmotoKbn().getContent(C_HrkmnykndatarenmotoKbn.PATTERN_DISP));
                }

                if (C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI.eq(mosSyoruiMitoutyakuList.getHrkmnykndatarenmotoKbn())) {
                    skMosmatilistcsvsakuseiLayoutFile.setIfcMeisaitrkmymd(
                        dateDOTSeirekiNoEx(mosSyoruiMitoutyakuList.getSyoriYmd()));
                }
                else {
                    skMosmatilistcsvsakuseiLayoutFile.setIfcMeisaitrkmymd("");
                }

                pSkMosmatilistcsvsakuseiLayoutFileLst.add(skMosmatilistcsvsakuseiLayoutFile);

                syutokuCnt ++;
            }
        }

        return syutokuCnt;
    }
}
