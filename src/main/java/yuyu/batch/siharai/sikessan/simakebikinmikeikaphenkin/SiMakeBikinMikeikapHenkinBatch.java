package yuyu.batch.siharai.sikessan.simakebikinmikeikaphenkin;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Bknkessankbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.file.csv.SiBikinMikeikapHenkinListLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 保険金給付金支払 決算 備金未経過Ｐ返金ファイル作成
 */
public class SiMakeBikinMikeikapHenkinBatch implements Batch {

    private static final String LISTNM = "備金未経過Ｐ返金ファイル";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SiharaiDomManager siharaiDomManager;

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

        BizDate kessankijyunymd = null;

        if (syoriYmd.getDay() <= 15) {
            kessankijyunymd = syoriYmd.getPreviousMonth().getBizDateYM().getLastDay();
        }
        else {
            kessankijyunymd = syoriYmd.getBizDateYM().getLastDay();
        }

        String kessannnd = DateFormatUtil.dateYKANJISeirekiNendo(kessankijyunymd);

        C_Bknkessankbn bknkessanKbn = C_Bknkessankbn.BLNK;

        if (kessankijyunymd.getMonth() == 3) {
            bknkessanKbn = C_Bknkessankbn.KESSAN;
        }
        else if (kessankijyunymd.getMonth() == 6) {
            bknkessanKbn = C_Bknkessankbn.SHNK;
        }
        else if (kessankijyunymd.getMonth() == 9) {
            bknkessanKbn = C_Bknkessankbn.HNK;
        }
        else if (kessankijyunymd.getMonth() == 12) {
            bknkessanKbn = C_Bknkessankbn.SHNK;
        }

        String csvKessannnd = kessannnd + bknkessanKbn.getContent();

        List<SiBikinMikeikapHenkinListLayoutFile> siBikinMikeikapHenkinListLayoutFileLst =
            new ArrayList<SiBikinMikeikapHenkinListLayoutFile>();

        long outKensuu = 0;

        try (ExDBResults<JT_SiBikinkanri> siBikinkanriExDBResults = siharaiDomManager.getSiBikinkanrisByMikeikap(kessankijyunymd,
            C_UmuKbn.ARI, C_ShrKekkaKbn.HSHR, C_BknrigiKbn.DEL)) {

            for (JT_SiBikinkanri siBikinkanri : siBikinkanriExDBResults) {

                BizCurrency mikeikap = BizCurrency.valueOf(0);

                if (C_Tuukasyu.JPY.eq(siBikinkanri.getKyktuukasyu())) {
                    mikeikap =  siBikinkanri.getMikeikap();
                }
                else {
                    mikeikap =  siBikinkanri.getYenkamikeikap();
                }

                BizDate syoruiukeymd = siBikinkanri.getSyoruiukeymd();

                if (siBikinkanri.getHubikanryouymd() != null) {
                    syoruiukeymd = siBikinkanri.getHubikanryouymd();
                }

                String gaikaukthyoji;
                String gkdtmikeikap;
                String kawaseRate;

                if (C_Tuukasyu.JPY.eq(siBikinkanri.getShrtuukasyu()) ||
                    C_Tuukasyu.BLNK.eq(siBikinkanri.getShrtuukasyu()) ) {
                    gaikaukthyoji = "";
                }
                else {
                    gaikaukthyoji = "*";
                }

                if (C_Tuukasyu.JPY.eq(siBikinkanri.getKyktuukasyu())) {

                    gkdtmikeikap = "";
                    kawaseRate = "";
                }
                else {

                    if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siBikinkanri.getMikeikapknrtuukakbn())) {

                        gkdtmikeikap = siBikinkanri.getMikeikap().toString();
                        kawaseRate = siBikinkanri.getShrkwsrate().toString();
                    }
                    else {

                        if (C_Tuukasyu.JPY.eq(siBikinkanri.getShrtuukasyu()) ||
                            C_Tuukasyu.BLNK.eq(siBikinkanri.getShrtuukasyu())) {

                            gkdtmikeikap = "";
                            kawaseRate = "";
                        }
                        else {

                            gkdtmikeikap = siBikinkanri.getMikeikap().toString();
                            kawaseRate = siBikinkanri.getShrkwsrate().toString();
                        }
                    }
                }

                outKensuu = outKensuu  + 1;

                YuyuSiharaiConfig yuyuSiharaiConfig =  YuyuSiharaiConfig.getInstance();
                String tantousitu = yuyuSiharaiConfig.getTantousitu();

                SiBikinMikeikapHenkinListLayoutFile siBikinMikeikapHenkinListLayoutFile =
                    SWAKInjector.getInstance(SiBikinMikeikapHenkinListLayoutFile.class);

                siBikinMikeikapHenkinListLayoutFile.setIfcListnm(LISTNM);
                siBikinMikeikapHenkinListLayoutFile.setIfcAtesaki(tantousitu);
                siBikinMikeikapHenkinListLayoutFile.setIfcSakuseiymdseireki(
                    FixedDateFormatter.formatYMDSeirekiSlashZeroFill(syoriYmd));
                siBikinMikeikapHenkinListLayoutFile.setIfcPageno("");
                siBikinMikeikapHenkinListLayoutFile.setIfcKessannnd(csvKessannnd);
                siBikinMikeikapHenkinListLayoutFile.setIfcSyoricd(siBikinkanri.getBkncdkbn().getValue());
                siBikinMikeikapHenkinListLayoutFile.setIfcKbnkeirisegcd(siBikinkanri.getKbnkeirisegcd().getValue());
                siBikinMikeikapHenkinListLayoutFile.setIfcHknsyruilevelcd(siBikinkanri.getKbnkeirisegcd().getContent());
                siBikinMikeikapHenkinListLayoutFile.setIfcMikeikapkktiymd(
                    FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getBknkktymd()));
                siBikinMikeikapHenkinListLayoutFile.setIfcMikeikapkktinnd(siBikinkanri.getBknkktinnd());
                siBikinMikeikapHenkinListLayoutFile.setIfcMikeikapkktiym(siBikinkanri.getBknkktiym().toString());
                siBikinMikeikapHenkinListLayoutFile.setIfcSyono(siBikinkanri.getSyono());
                siBikinMikeikapHenkinListLayoutFile.setIfcMikeikap(mikeikap.toString());

                if (syoruiukeymd == null) {
                    siBikinMikeikapHenkinListLayoutFile.setIfcSyoruiukeymdseireki("");
                }
                else {
                    siBikinMikeikapHenkinListLayoutFile.setIfcSyoruiukeymdseireki(
                        FixedDateFormatter.formatYMDSeirekiSlashZeroFill(syoruiukeymd));
                }

                siBikinMikeikapHenkinListLayoutFile.setIfcGaikaukthyoji(gaikaukthyoji);
                siBikinMikeikapHenkinListLayoutFile.setIfcGkdtmikeikap(gkdtmikeikap);
                siBikinMikeikapHenkinListLayoutFile.setIfcKawaserate(kawaseRate);
                siBikinMikeikapHenkinListLayoutFile.setIfcMissuhyj("");

                siBikinMikeikapHenkinListLayoutFileLst.add(siBikinMikeikapHenkinListLayoutFile);
            }
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn result = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_BIKINMIKEIKAPHENKINFILE,
            siBikinMikeikapHenkinListLayoutFileLst, true);

        if (C_ErrorKbn.ERROR.eq(result)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(outKensuu), kinou.getKinouNm()));
    }
}
