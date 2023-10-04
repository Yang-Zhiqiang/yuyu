package yuyu.batch.sinkeiyaku.sksonota.skteiseikeiyakulistsakusei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.sinkeiyaku.file.csv.SkTskmlistLayoutFile;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 新契約 その他 訂正契約関連リスト作成処理
 */
public class SkTeiseiKeiyakuListSakuseiBatch implements Batch {

    private static final String LOG_TSKMLIST = "訂正項目リスト";
    private static final String MAX_SYORIYMD = "999999999";
    private static final String MIN_SYORIYMD = "000000000";

    private String syoriYmd = null;

    private int syoriKensuu = 0;

    @Inject
    private BatchParam batchParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = batchParam.getSyoriYmd().toString();

        List<SkTskmlistLayoutFile> skTskmlistLayoutFileLst = Lists.newArrayList();

        try (ExDBResults<HT_KmTsRireki> kmTsRirekiResults = sinkeiyakuDomManager.
            getKmtsrirekisBySyoriTime(syoriYmd + MIN_SYORIYMD, syoriYmd + MAX_SYORIYMD)) {

            for (HT_KmTsRireki kmTsRireki : kmTsRirekiResults) {

                SkTskmlistLayoutFile exSkTskmlistLayoutFile = new SkTskmlistLayoutFile();

                exSkTskmlistLayoutFile.setIfcSyoritime(kmTsRireki.getSyoriTime());
                exSkTskmlistLayoutFile.setIfcMosno(kmTsRireki.getMosno());

                if (!BizUtil.isBlank(kmTsRireki.getKinouId())) {

                    if (!BizUtil.isBlank(kmTsRireki.getKinouModeId())) {

                        if(C_SkkinouModeIdKbn.DEFAULT.getValue().equals(kmTsRireki.getKinouModeId())) {
                            exSkTskmlistLayoutFile.setIfcSyorinm(baseDomManager.getKinou(kmTsRireki.getKinouId()).getKinouNm());
                        }
                        else {
                            exSkTskmlistLayoutFile.setIfcSyorinm(baseDomManager.getKinou(kmTsRireki.getKinouId()).
                                getKinouMode(kmTsRireki.getKinouModeId()).getKinouModeNm());
                        }

                    } else {

                        exSkTskmlistLayoutFile.setIfcSyorinm("");
                    }

                } else {

                    exSkTskmlistLayoutFile.setIfcSyorinm("");
                }

                exSkTskmlistLayoutFile.setIfcTskmnm(kmTsRireki.getTskmnm());

                exSkTskmlistLayoutFile.setIfcTsmaenaiyou(kmTsRireki.getTsmaenaiyou());

                exSkTskmlistLayoutFile.setIfcTsgonaiyou(kmTsRireki.getTsgonaiyou());

                exSkTskmlistLayoutFile.setIfcTntnm(baseDomManager.getUser(kmTsRireki.getTantid()).getUserNm());

                skTskmlistLayoutFileLst.add(exSkTskmlistLayoutFile);

                syoriKensuu++;

            }
        }
        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST, skTskmlistLayoutFileLst, true);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            AS_FileSyurui fileSyurui = baseDomManager.getFileSyurui(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST);

            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0163, fileSyurui.getDownloadFileNm()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu),
            LOG_TSKMLIST));

    }

}
