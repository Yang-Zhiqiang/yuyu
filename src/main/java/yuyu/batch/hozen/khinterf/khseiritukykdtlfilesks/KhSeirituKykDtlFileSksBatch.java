package yuyu.batch.hozen.khinterf.khseiritukykdtlfilesks;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khseiritukykdtlfilesks.dba.KhSeirituKykDtlFileSksDao;
import yuyu.batch.hozen.khinterf.khseiritukykdtlfilesks.dba.SeirituKykDtlBean;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.hozen.file.excel.KhSeirituKykDtlFileLayoutFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 契約保全 インターフェイス 成立契約明細ファイル作成
 */
public class KhSeirituKykDtlFileSksBatch implements Batch {

    private final int FILE_SAVE_MAX_LIST_COUNT = 10000;

    private final String KYKYMD_FROM = "契約日（自）";

    private final String KYKYMD_TO = "契約日（至）";

    private final String SYOUHINBUNRUIKBN_ITIJIBRSYSN = "1";

    private final String SYOUHINBUNRUIKBN_HEIJYUNBRSYSN = "2";

    private final String SYOUHINBUNRUIKBN_KOJINNENKIN = "6";

    private final int HKNKKN_SYSN = 99;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhSeirituKykDtlFileSksBatchParam batchParam;

    @Inject
    private KhSeirituKykDtlFileSksDao khSeirituKykDtlFileSksDao;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = batchParam.getSyoriYmd();
        BizDate kykYmdFrom = batchParam.getKykYmdFrom();
        BizDate kykYmdTo = batchParam.getKykYmdTo();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, KYKYMD_FROM, String.valueOf(kykYmdFrom)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, KYKYMD_TO, String.valueOf(kykYmdTo)));

        BizDate taisyoStartYmd = kykYmdFrom;
        BizDate taisyoEndYmd = kykYmdTo;

        List<KhSeirituKykDtlFileLayoutFile> khSeirituKykDtlFileLst = Lists.newArrayList();
        long syoriKensuu = 0;

        try(ExDBResults<SeirituKykDtlBean> seirituKykDtlLst =
            khSeirituKykDtlFileSksDao.getSeirituKykDtl(taisyoStartYmd, taisyoEndYmd)) {

            String syonoZenkai = "";
            KhSeirituKykDtlFileLayoutFile khSeirituKykDtlFileLayoutFile = null;

            for (SeirituKykDtlBean seirituKykDtlBean : seirituKykDtlLst) {

                if (BizUtil.isBlank(syonoZenkai)) {

                    syonoZenkai = seirituKykDtlBean.getSyono();

                    khSeirituKykDtlFileLayoutFile = new KhSeirituKykDtlFileLayoutFile();

                    khSeirituKykDtlFileLayoutFile.setIfeSyono(seirituKykDtlBean.getSyono());
                    khSeirituKykDtlFileLayoutFile.setIfeKykymd(seirituKykDtlBean.getKykymd().toString());
                    khSeirituKykDtlFileLayoutFile.setIfeAatkisyaBosyuuDrtencd(seirituKykDtlBean.getDrtencd());

                    if(HKNKKN_SYSN == seirituKykDtlBean.getHknkkn()){
                        if(C_Kykjyoutai.ITIJIBARAI.eq(seirituKykDtlBean.getKykjyoutai())){
                            khSeirituKykDtlFileLayoutFile.setIfeSyouhinbunruikbn(SYOUHINBUNRUIKBN_ITIJIBRSYSN);
                        }
                        else{
                            khSeirituKykDtlFileLayoutFile.setIfeSyouhinbunruikbn(SYOUHINBUNRUIKBN_HEIJYUNBRSYSN);
                        }
                    }
                    else{
                        khSeirituKykDtlFileLayoutFile.setIfeSyouhinbunruikbn(SYOUHINBUNRUIKBN_KOJINNENKIN);
                    }

                    continue;
                }

                if (!syonoZenkai.equals(seirituKykDtlBean.getSyono())) {

                    khSeirituKykDtlFileLst.add(khSeirituKykDtlFileLayoutFile);

                    syoriKensuu = syoriKensuu + 1;
                    syonoZenkai = seirituKykDtlBean.getSyono();

                    khSeirituKykDtlFileLayoutFile = new KhSeirituKykDtlFileLayoutFile();

                    khSeirituKykDtlFileLayoutFile.setIfeSyono(seirituKykDtlBean.getSyono());
                    khSeirituKykDtlFileLayoutFile.setIfeKykymd(seirituKykDtlBean.getKykymd().toString());
                    khSeirituKykDtlFileLayoutFile.setIfeAatkisyaBosyuuDrtencd(seirituKykDtlBean.getDrtencd());

                    if(HKNKKN_SYSN == seirituKykDtlBean.getHknkkn()){
                        if(C_Kykjyoutai.ITIJIBARAI.eq(seirituKykDtlBean.getKykjyoutai())){
                            khSeirituKykDtlFileLayoutFile.setIfeSyouhinbunruikbn(SYOUHINBUNRUIKBN_ITIJIBRSYSN);
                        }
                        else{
                            khSeirituKykDtlFileLayoutFile.setIfeSyouhinbunruikbn(SYOUHINBUNRUIKBN_HEIJYUNBRSYSN);
                        }
                    }
                    else{
                        khSeirituKykDtlFileLayoutFile.setIfeSyouhinbunruikbn(SYOUHINBUNRUIKBN_KOJINNENKIN);
                    }

                }
                else {
                    if (khSeirituKykDtlFileLayoutFile != null) {

                        khSeirituKykDtlFileLayoutFile.setIfeBatkisyaBosyuuDrtencd(seirituKykDtlBean.getDrtencd());
                    }
                }
            }

            if (khSeirituKykDtlFileLayoutFile != null) {

                khSeirituKykDtlFileLst.add(khSeirituKykDtlFileLayoutFile);

                syoriKensuu = syoriKensuu + 1;
            }
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        int renNo = 1;

        if (!khSeirituKykDtlFileLst.isEmpty()) {
            List<List<KhSeirituKykDtlFileLayoutFile>> bunkatuList =  Lists.partition(khSeirituKykDtlFileLst, FILE_SAVE_MAX_LIST_COUNT);

            for(List<KhSeirituKykDtlFileLayoutFile> list:bunkatuList) {
                bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_SEIRITUKYKDTLFILE, list, true, "_" + renNo);
                renNo = renNo + 1;

            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }
}
