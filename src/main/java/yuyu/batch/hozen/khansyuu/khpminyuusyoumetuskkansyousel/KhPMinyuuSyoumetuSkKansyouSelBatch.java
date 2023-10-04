package yuyu.batch.hozen.khansyuu.khpminyuusyoumetuskkansyousel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khpminyuusyoumetuskkansyousel.dba.KhPMinyuuSyoumetuSkKansyouSelDao;
import yuyu.batch.hozen.khansyuu.khpminyuusyoumetuskkansyousel.dba.PMinyuuSyoumetuSkKansyouInfosBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_PMinyuuSyoumetuInfo;
import yuyu.def.hozen.file.csv.KhPminyuusyoumetuskcsvsakuseiLayoutFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 Ｐ未入消滅請求勧奨抽出
 */
public class KhPMinyuuSyoumetuSkKansyouSelBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERYFILTERKBNID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KhPMinyuuSyoumetuSkKansyouSelDao khPMinyuuSyoumetuSkKansyouSelDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {


        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));


        long syutokuCnt = 0;

        List<KhPminyuusyoumetuskcsvsakuseiLayoutFile> khPminyuusyoumetuskcsvsakuseiLayoutFileLst = new ArrayList<>();

        BizDateYM pminyuuSyoumetuSyoriYm = syoriYmd.getBizDateYM().getPreviousMonth();

        try (ExDBResults<PMinyuuSyoumetuSkKansyouInfosBean> pMinyuuSyoumetuSkKansyouInfosLst =
            khPMinyuuSyoumetuSkKansyouSelDao.getPMinyuuSyoumetuSkKansyouInfos(kakutyouJobCd, pminyuuSyoumetuSyoriYm)) {

            String syoumetujiSitiken = "";

            String siteiTuukasyu = "";

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            for (PMinyuuSyoumetuSkKansyouInfosBean pMinyuuSyoumetuSkKansyouInfosBean : pMinyuuSyoumetuSkKansyouInfosLst) {

                String syoNo = pMinyuuSyoumetuSkKansyouInfosBean.getIT_KykKihon().getSyono();

                IT_PMinyuuSyoumetuInfo pMinyuuSyoumetuInfo = pMinyuuSyoumetuSkKansyouInfosBean.getIT_PMinyuuSyoumetuInfo();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERKBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(
                    pMinyuuSyoumetuSkKansyouInfosBean.getIT_KykKihon().getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syoNo);

                if (C_StknsetKbn.ARI.eq(pMinyuuSyoumetuInfo.getStknsetkbn())) {
                    syoumetujiSitiken = "設定あり";
                }
                else {
                    syoumetujiSitiken = "";
                }
                siteiTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(
                    pMinyuuSyoumetuInfo.getKaiyakuhrkngkkeisiteituuka().getType()).getContent();


                KhPminyuusyoumetuskcsvsakuseiLayoutFile khPminyuusyoumetuskcsvsakuseiLayoutFile =
                    SWAKInjector.getInstance(KhPminyuusyoumetuskcsvsakuseiLayoutFile.class);

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcSyono(syoNo);

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcSyouhnnm102keta(
                    pMinyuuSyoumetuSkKansyouInfosBean.getBM_SyouhnZokusei().getSyouhnnm() + "「" +
                        pMinyuuSyoumetuSkKansyouInfosBean.getIT_KykKihon().getAisyoumeikbn().getContent() + "」");

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcKykymd(
                    pMinyuuSyoumetuSkKansyouInfosBean.getIT_KykSyouhn().getKykymd());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcKnjkyksyamei(
                    pMinyuuSyoumetuSkKansyouInfosBean.getIT_KykSya().getKyknmkj());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcKyknmkn(
                    pMinyuuSyoumetuSkKansyouInfosBean.getIT_KykSya().getKyknmkn());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcKnjhknmei(
                    pMinyuuSyoumetuSkKansyouInfosBean.getIT_HhknSya().getHhknnmkj());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcHhknsyanmkn(
                    pMinyuuSyoumetuSkKansyouInfosBean.getIT_HhknSya().getHhknnmkn());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcTsinyno(
                    pMinyuuSyoumetuSkKansyouInfosBean.getIT_KykSya().getTsinyno());

                String tsinadr = pMinyuuSyoumetuSkKansyouInfosBean.getIT_KykSya().getTsinadr1kj() +
                    pMinyuuSyoumetuSkKansyouInfosBean.getIT_KykSya().getTsinadr2kj() +
                    pMinyuuSyoumetuSkKansyouInfosBean.getIT_KykSya().getTsinadr3kj();

                if (tsinadr.length() > 62) {

                    tsinadr = tsinadr.substring(0, 62);
                }

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcTsinkaiadr(tsinadr);

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcTsintelno(
                    pMinyuuSyoumetuSkKansyouInfosBean.getIT_KykSya().getTsintelno());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcSyoumetuymd(
                    pMinyuuSyoumetuInfo.getSyoumetuymd().toString());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcJidousoukinhukariyuu(
                    pMinyuuSyoumetuInfo.getJidousoukinhukariyuu().getContent());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcTtdktyuuihanteikekka(
                    pMinyuuSyoumetuInfo.getTtdktyuuihanteikekka().
                    getContent(C_SyorikahiKbn.PATTERN_DISPANSYUU));

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcSitiken(syoumetujiSitiken);

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcKaiyakuhrknyen(
                    pMinyuuSyoumetuInfo.getShrtuukakaiyakuhrkngkkei().toString());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcSonotaseisankin(
                    pMinyuuSyoumetuInfo.getSonotaseisan().toString());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcYenkahaitoukinbizc(
                    pMinyuuSyoumetuInfo.getYenkansanhaitoukin());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcYenkasonotahaitoukinbizc(
                    pMinyuuSyoumetuInfo.getYensonotahaitoukin());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcShrkwsrate(
                    pMinyuuSyoumetuInfo.getShrkwsrate());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcSiteituuka(siteiTuukasyu);

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcKaiyakuhrkngkkeigaika(
                    pMinyuuSyoumetuInfo.getKaiyakuhrkngkkeisiteituuka().toString());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcKaiyakuhrkngaika(
                    pMinyuuSyoumetuInfo.getKaiyakuhrknsiteituuka().toString());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcZitkazkrknsiteituukabizc(
                    pMinyuuSyoumetuInfo.getZitkazukarikingksiteituuka());

                khPminyuusyoumetuskcsvsakuseiLayoutFile.setIfcSakuseiymd(syoriYmd);

                khPminyuusyoumetuskcsvsakuseiLayoutFileLst.add(khPminyuusyoumetuskcsvsakuseiLayoutFile);

                syutokuCnt = syutokuCnt + 1;
            }

            if (syutokuCnt == 0) {

                KhPminyuusyoumetuskcsvsakuseiLayoutFile khPminyuusyoumetuskcsvsakuseiLayoutFile =
                    SWAKInjector.getInstance(KhPminyuusyoumetuskcsvsakuseiLayoutFile.class);

                khPminyuusyoumetuskcsvsakuseiLayoutFileLst.add(khPminyuusyoumetuskcsvsakuseiLayoutFile);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();


            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.AS_PMINYUUSYOUMETUSK,
                khPminyuusyoumetuskcsvsakuseiLayoutFileLst,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }
        }

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(syutokuCnt), "Ｐ未入消滅請求勧奨用ＣＳＶファイル"));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
