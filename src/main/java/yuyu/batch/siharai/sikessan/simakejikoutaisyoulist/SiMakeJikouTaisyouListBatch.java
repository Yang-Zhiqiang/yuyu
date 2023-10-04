package yuyu.batch.siharai.sikessan.simakejikoutaisyoulist;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.collect.Lists;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.siharai.file.csv.SiJikouTaisyouListLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 保険金給付金支払 決算 時効対象リスト作成
 */
public class SiMakeJikouTaisyouListBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        BizDate syoriYmd = batchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        BizDate kessanKijyunYmd = null;

        if (syoriYmd.getDay() <= 15) {

            kessanKijyunYmd = syoriYmd.getPreviousMonth().getBizDateYM().getLastDay();
        }

        else {

            kessanKijyunYmd = syoriYmd.getBizDateYM().getLastDay();
        }

        long syuturyokuKensuu = 0;
        List<SiJikouTaisyouListLayoutFile> siJikouTaisyouListLayoutFileList = Lists.newArrayList();

        try (ExDBResults<JT_SiBikinkanri> siBikinkanriLst =
            siharaiDomManager.getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(kessanKijyunYmd, C_BknJkuKbn.SAISAISAIBI,
                C_BknrigiKbn.DEL)) {

            for (JT_SiBikinkanri siBikinkanri : siBikinkanriLst) {
                String hokenSyorui = C_Segcd.valueOf(siBikinkanri.getKbnkeirisegcd().getValue()).getContent();
                String kyhsyurui = siBikinkanri.getHokenkinsyuruikbn().getContent(
                    C_HokenkinsyuruiKbn.PATTERN_KYHSYURUI);

                String bikinkbn = siBikinkanri.getHokenkinsyuruikbn().getContent(
                    C_HokenkinsyuruiKbn.PATTERN_REPORT);

                KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

                KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

                keiyakuPrm.setSyono(siBikinkanri.getSyono());

                keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

                keiyakuInfoSyutoku.getInfos(keiyakuPrm);

                JT_SiKykKihon siKykKihon = keiyakuInfoSyutoku.getKykKihons().get(0);
                SiJikouTaisyouListLayoutFile siJikouTaisyouListLayoutFile = SWAKInjector
                    .getInstance(SiJikouTaisyouListLayoutFile.class);

                siJikouTaisyouListLayoutFile.setIfcSyono(siBikinkanri.getSyono());
                siJikouTaisyouListLayoutFile.setIfcBknkktiymdseireki(
                    FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getBknkktymd()));
                siJikouTaisyouListLayoutFile.setIfcHknsyurui(hokenSyorui);
                siJikouTaisyouListLayoutFile.setIfcBkncd(siBikinkanri.getBkncdkbn().getValue());
                siJikouTaisyouListLayoutFile.setIfcKyhsyurui(kyhsyurui);
                siJikouTaisyouListLayoutFile.setIfcHknknsyruiname(bikinkbn);
                siJikouTaisyouListLayoutFile.setIfcHhknsyanmkn(siKykKihon.getHhknnmkn());
                siJikouTaisyouListLayoutFile.setIfcHhknnmkj(siKykKihon.getHhknnmkj());
                siJikouTaisyouListLayoutFile.setIfcKyknmkn(siKykKihon.getKyknmkn());
                siJikouTaisyouListLayoutFile.setIfcKyknmkj(siKykKihon.getKyknmkj());

                siJikouTaisyouListLayoutFileList.add(siJikouTaisyouListLayoutFile);

                syuturyokuKensuu = syuturyokuKensuu + 1;

            }

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.SI_JIKOUTAISYOULIST,
                siJikouTaisyouListLayoutFileList,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syuturyokuKensuu),
            kinou.getKinouNm()));
    }

}
