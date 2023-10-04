package yuyu.batch.sinkeiyaku.skhubikanri.skhubiitiransksnit;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.skhubikanri.skhubiitiransksnit.dba.SkHubiItiranSksNitDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.sinkeiyaku.skcommon.EditSkHubiItiranNit;
import yuyu.common.sinkeiyaku.skcommon.GetSkChannelInfo;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_DrtenRnrkhouKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_SeihokisyacdKbn;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.file.csv.SkNitPplessHubiCsvFile;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkHubiDetail;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 新契約 不備管理 新契約不備一覧作成（ＮＩＴ）
 *
 */
public class SkHubiItiranSksNitBatch implements Batch {
    private static final String SAKUJYO_FLG = "0";

    private static final String HKNKAISYA_BUSYO = "契約審査部　代理店契約室";

    private static final String EX_FILE_NM = "_____";

    private static final String TYSYTID = "HT_SyoriCTL";

    public static final String RECOVERYFILTERID = "Sk001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkHubiItiranSksNitDao skHubiItiranSksNitDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    int syoriCount = 0;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), ibKakutyoujobcd));

        List<HM_SkDairitenKobetuJyouhou> skDairitenKobetuJyouhouLst = sinkeiyakuDomManager
            .getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn(C_DrtenRnrkhouKbn.NIT);

        for (HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou : skDairitenKobetuJyouhouLst) {
            skHubIitiranSksNit(skDairitenKobetuJyouhou.getOyadrtencd());
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriCount)));
    }

    private void skHubIitiranSksNit(String pOyadrtencd) {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        List<SkNitPplessHubiCsvFile> skNitPplessHubiCsvFileLst = Lists.newArrayList();
        String knyuucd = "";
        String sapodetelno = "";

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(pOyadrtencd);

        for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
            if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean
                .getDiritenJyouhouKbn())) {
                knyuucd = bzGetAgInfoBean.getKinyuuCd();
                break;
            }
        }

        if (BizUtil.isBlank(knyuucd)) {
            batchLogger.warn(MessageUtil.getMessage(MessageId.EHC0010, pOyadrtencd));

            return;
        }

        GetSkChannelInfo getSkChannelInfo = SWAKInjector
            .getInstance(GetSkChannelInfo.class);
        getSkChannelInfo.exec(null, pOyadrtencd);
        sapodetelno = getSkChannelInfo.getSapodetelno();

        String[] renrakusakitelnos = new String[3];

        if (!BizUtil.isBlank(sapodetelno)) {
            renrakusakitelnos = sapodetelno.split("-");

        }else{
            renrakusakitelnos[0]="";
            renrakusakitelnos[1]="";
            renrakusakitelnos[2]="";
        }

        try (ExDBUpdatableResults<HT_SyoriCTL> syoriCTLLst =
            skHubiItiranSksNitDao.getNITPplessHubiKeiyaku(pOyadrtencd, ibKakutyoujobcd);){

            for(HT_SyoriCTL syoriCTL : syoriCTLLst){
                String mosNo = syoriCTL.getMosno();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(mosNo);

                List<HT_SkHubi> skHubiLst = syoriCTL.getSkHubis();

                if(skHubiLst.isEmpty()){
                    continue;
                }

                String[] hubijyoukyous = new String[5];
                String tntnm = "";
                int idx = 0;

                EditSkHubiItiranNit editSkHubiItiranNit = SWAKInjector.getInstance(EditSkHubiItiranNit.class);

                for(HT_SkHubi skHubi : skHubiLst){
                    tntnm = skHubi.getTuutikyokasyanmkj();

                    List<HT_SkHubiDetail> skHubiDetailLst = skHubi.getSkHubiDetails();

                    SortHT_SkHubiDetail sortHT_SkHubiDetail = SWAKInjector.getInstance(SortHT_SkHubiDetail.class);

                    skHubiDetailLst = sortHT_SkHubiDetail.OrderHT_SkHubiDetailByHasinymdRenno3ketaAsc(skHubiDetailLst);

                    for(int i = 0;i<skHubiDetailLst.size();i++){

                        if (skHubiDetailLst.get(i).getKaisyouymd() != null ||
                            skHubiDetailLst.get(i).getHasinymd() == null) {
                            continue;
                        }

                        String skhubikoumoku = "";
                        if (skHubiDetailLst.get(i).getSkHubiKoumoku() != null) {
                            skhubikoumoku = skHubiDetailLst.get(i).getSkHubiKoumoku().getSkhubikoumoku();
                        }

                        String skhubinaiyou = "";
                        if (skHubiDetailLst.get(i).getSkHubiNaiyou() != null) {
                            skhubinaiyou = skHubiDetailLst.get(i).getSkHubiNaiyou().getSkhubinaiyou();
                        }
                        String skseibisijinaiyou = "";
                        if (skHubiDetailLst.get(i).getSkSeibiSijiNaiyou() != null) {
                            skseibisijinaiyou = skHubiDetailLst.get(i).getSkSeibiSijiNaiyou().getSkseibisijinaiyou();
                        }

                        String skrenrakujikou = EditSecurityKm.getDecodeData(mosNo, skHubiDetailLst.get(i).getSkrenrakujikou());

                        boolean keizkhnsyukahi = editSkHubiItiranNit.editSkHubiItiran(idx,
                            skhubikoumoku,
                            skhubinaiyou,
                            skseibisijinaiyou,
                            skrenrakujikou);

                        hubijyoukyous = editSkHubiItiranNit.getHubijks();
                        idx++;

                        if(!keizkhnsyukahi){
                            batchLogger.info(MessageUtil.getMessage(MessageId.EHA1102,knyuucd,mosNo));
                            break;
                        }

                        if(skHubiDetailLst.get(i).getHubiitiransksymd() == null){

                            skHubiDetailLst.get(i).setHubiitiransksymd(syoriYmd);
                            skHubiDetailLst.get(i).setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            skHubiDetailLst.get(i).setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        }
                    }
                }

                SkNitPplessHubiCsvFile skNitPplessHubiCsvFile = new SkNitPplessHubiCsvFile();
                skNitPplessHubiCsvFile.setIfcAnkenid("");
                skNitPplessHubiCsvFile.setIfcAnkenedano("");
                skNitPplessHubiCsvFile.setIfcMosno(mosNo);
                skNitPplessHubiCsvFile.setIfcKinyuucd(knyuucd);
                skNitPplessHubiCsvFile.setIfcHknkaisyacd(String.valueOf(C_SeihokisyacdKbn.SUMITOMO));
                skNitPplessHubiCsvFile.setIfcSyouhncd("");
                skNitPplessHubiCsvFile.setIfcSitencd("");
                skNitPplessHubiCsvFile.setIfcCifcd("");
                skNitPplessHubiCsvFile.setIfcTratkisyacd("");
                skNitPplessHubiCsvFile.setIfcYobi1sinkeiyaku("");
                skNitPplessHubiCsvFile.setIfcYobi2sinkeiyaku("");
                skNitPplessHubiCsvFile.setIfcLayoutkaiteino("");
                skNitPplessHubiCsvFile.setIfcSakujyoflg(SAKUJYO_FLG);
                skNitPplessHubiCsvFile.setIfcHknkaisyabusyo(HKNKAISYA_BUSYO);
                skNitPplessHubiCsvFile.setIfcHknkaisyatelno1(renrakusakitelnos[0]);
                skNitPplessHubiCsvFile.setIfcHknkaisyatelno2(renrakusakitelnos[1]);
                skNitPplessHubiCsvFile.setIfcHknkaisyatelno3(renrakusakitelnos[2]);
                skNitPplessHubiCsvFile.setIfcTntnm(tntnm);
                skNitPplessHubiCsvFile.setIfcHubijyoukyou1(hubijyoukyous[0]);
                skNitPplessHubiCsvFile.setIfcHubijyoukyou2(hubijyoukyous[1]);
                skNitPplessHubiCsvFile.setIfcHubijyoukyou3(hubijyoukyous[2]);
                skNitPplessHubiCsvFile.setIfcHubijyoukyou4(hubijyoukyous[3]);
                skNitPplessHubiCsvFile.setIfcHubijyoukyou5(hubijyoukyous[4]);
                skNitPplessHubiCsvFile.setIfcHubikaitou1("");
                skNitPplessHubiCsvFile.setIfcHubikaitou2("");
                skNitPplessHubiCsvFile.setIfcHubikaitou3("");
                skNitPplessHubiCsvFile.setIfcHubikaitou4("");
                skNitPplessHubiCsvFile.setIfcHubikaitou5("");
                skNitPplessHubiCsvFile.setIfcTpsyoruitshsk("");
                skNitPplessHubiCsvFile.setIfcTpsyoruizougenkak("");
                skNitPplessHubiCsvFile.setIfcTpsyoruitkbtjkn("");
                skNitPplessHubiCsvFile.setIfcTpsyoruietc("");
                skNitPplessHubiCsvFile.setIfcTpsyoruisyousai("");
                skNitPplessHubiCsvFile.setIfcHubikaitouymd("");
                skNitPplessHubiCsvFile.setIfcTratkisyanm("");

                skNitPplessHubiCsvFileLst.add(skNitPplessHubiCsvFile);

                syoriCount++;
            }
        }
        bzRecoveryDatasikibetuBean.initializeBlank();

        sinkeiyakuDomManager.flush();

        if(skNitPplessHubiCsvFileLst.size() > 0){
            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
            bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_NITPPLESSHUBICSV,
                skNitPplessHubiCsvFileLst, false,knyuucd + EX_FILE_NM + syoriYmd);
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
