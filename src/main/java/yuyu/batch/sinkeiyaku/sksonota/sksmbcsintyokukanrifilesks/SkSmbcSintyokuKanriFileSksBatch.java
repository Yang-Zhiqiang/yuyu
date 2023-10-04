package yuyu.batch.sinkeiyaku.sksonota.sksmbcsintyokukanrifilesks;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Rendouflg;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouTy;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 その他 ＳＭＢＣ進捗管理送信ファイル作成
 */
public class SkSmbcSintyokuKanriFileSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String tableId = "HT_SmbcStyKanri";
        String recoveryFilterId = "Bz001";
        int insKensuu = 0;
        int updKensuu = 0;
        String systemTime = BizDate.getSysDateTimeMilli();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            bzBatchParam.getIbKakutyoujobcd()));

        try (
            ExDBResults<HT_SmbcStyKanri> smbcStyKanrilLst =
            sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno(
                bzBatchParam.getIbKakutyoujobcd());
            EntityInserter<ZT_SmbcSkMeisaiRendouTy> smbcSkMeisaiRendouTyLst = new EntityInserter<>()) {

            for (HT_SmbcStyKanri smbcStyKanri : smbcStyKanrilLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(tableId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryFilterId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(smbcStyKanri.getSyono());

                ZT_SmbcSkMeisaiRendouTy smbcSkMeisaiRendouTy = new ZT_SmbcSkMeisaiRendouTy();
                smbcSkMeisaiRendouTy.setZtysmbcdatakbn(smbcStyKanri.getSmbcdatakbn());
                smbcSkMeisaiRendouTy.setZtysmbcdatasakuseiymd(smbcStyKanri.getSmbcdatasakuseiymd());
                smbcSkMeisaiRendouTy.setZtysmbchknkaisyacd(smbcStyKanri.getSmbchknkaisyacd());
                smbcSkMeisaiRendouTy.setZtysmbcuktkkanriid(smbcStyKanri.getSmbcuktkkanriid());
                smbcSkMeisaiRendouTy.setZtysmbcseihouktkzmymd(smbcStyKanri.getSmbcseihouktkzmymd());
                smbcSkMeisaiRendouTy.setZtysmbcseihohbymd(smbcStyKanri.getSmbcseihohbymd());
                smbcSkMeisaiRendouTy.setZtysmbcbankhnkykflg(smbcStyKanri.getSmbcbankhnkykflg());
                smbcSkMeisaiRendouTy.setZtysmbcseihohbksyymd(smbcStyKanri.getSmbcseihohbksyymd());
                smbcSkMeisaiRendouTy.setZtysmbcseihohjyttykymd(smbcStyKanri.getSmbcseihohjyttykymd());
                smbcSkMeisaiRendouTy.setZtysmbcseihonyknzmymd(smbcStyKanri.getSmbcseihonyknzmymd());
                smbcSkMeisaiRendouTy.setZtysmbcseihosnszmymd(smbcStyKanri.getSmbcseihosnszmymd());
                smbcSkMeisaiRendouTy.setZtysmbcseihosyknhkkzmymd(smbcStyKanri.getSmbcseihosyknhkkzmymd());
                smbcSkMeisaiRendouTy.setZtysmbcseihosyumoku(smbcStyKanri.getSmbcseihosyumoku());
                smbcSkMeisaiRendouTy.setZtysmbcseihosyurui(smbcStyKanri.getSmbcseihosyurui());
                smbcSkMeisaiRendouTy.setZtysmbcsyono(smbcStyKanri.getSmbcsyono());
                smbcSkMeisaiRendouTy.setZtysmbcsyonoedaban(smbcStyKanri.getSmbcsyonoedaban());
                smbcSkMeisaiRendouTy.setZtysmbcjktkflg(smbcStyKanri.getSmbcjktkflg());
                smbcSkMeisaiRendouTy.setZtysmbcseihotrksymd(smbcStyKanri.getSmbcseihotrksymd());
                smbcSkMeisaiRendouTy.setZtysmbcseihohktymd(smbcStyKanri.getSmbcseihohktymd());
                smbcSkMeisaiRendouTy.setZtysmbckykseiymd(smbcStyKanri.getSmbckykseiymd());
                smbcSkMeisaiRendouTy.setZtysmbckyknmkn(smbcStyKanri.getSmbckyknmkn());
                smbcSkMeisaiRendouTy.setZtysmbcmosuktymd(smbcStyKanri.getSmbcmosuktymd());
                smbcSkMeisaiRendouTy.setZtysmbcmossyoriflg(smbcStyKanri.getSmbcmossyoriflg());
                smbcSkMeisaiRendouTy.setZtysmbckosyaareastyknr(smbcStyKanri.getSmbckosyaareastyknr());
                BizPropertyInitializer.initialize(smbcSkMeisaiRendouTy);

                smbcSkMeisaiRendouTyLst.add(smbcSkMeisaiRendouTy);
                insKensuu++;

                List<HT_SmbcStyKanri> smbcStyKanriUpdlLst =
                    sinkeiyakuDomManager.getSmbcStyKanrisBySyonoRendouflg(smbcStyKanri.getSyono());

                for (HT_SmbcStyKanri smbcStyKanriUpd : smbcStyKanriUpdlLst) {
                    smbcStyKanriUpd.setRendouflg(C_Rendouflg.RENDOUZUMI);
                    smbcStyKanriUpd.setGyoumuKousinKinou(kinou.getKinouId());
                    smbcStyKanriUpd.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    smbcStyKanriUpd.setGyoumuKousinTime(systemTime);
                }
                sinkeiyakuDomManager.update(smbcStyKanriUpdlLst);
                sinkeiyakuDomManager.flush();

                updKensuu = updKensuu + smbcStyKanriUpdlLst.size();

            }
            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002,
                String.valueOf(insKensuu),
                "ＳＭＢＣ扱新契約明細連動テーブル（中）"));

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002,
                String.valueOf(updKensuu),
                "ＳＭＢＣ進捗管理テーブル"));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}