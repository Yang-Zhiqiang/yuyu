package yuyu.batch.siharai.sikessan.simakebikinmisyupkeijyou;

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
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.file.csv.SiBikinMisyupKeijyouListLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 保険金給付金支払 決算 備金未収Ｐ計上ファイル作成
 */
public class SiMakeBikinMisyupKeijyouBatch implements Batch {

    private static final String LISTNM = "備金未収Ｐ計上ファイル";

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

        List<SiBikinMisyupKeijyouListLayoutFile> siBikinMisyupKeijyouListLayoutFileLst =
            new ArrayList<SiBikinMisyupKeijyouListLayoutFile>();

        long outKensuu = 0;

        try (ExDBResults<JT_SiBikinkanri> siBikinkanriExDBResults = siharaiDomManager.getSiBikinkanrisByMisyup(kessankijyunymd,
            C_UmuKbn.ARI, C_ShrKekkaKbn.HSHR, C_BknrigiKbn.DEL)) {

            for (JT_SiBikinkanri siBikinkanri : siBikinkanriExDBResults) {

                BizCurrency misyuup = BizCurrency.valueOf(0);
                BizDate knsnkijyunymd;
                String kawaseRate;
                String kyktuukamisyuup;
                BizCurrency syonendojikaiikoup = BizCurrency.valueOf(0);
                BizCurrency jinendoikoup = BizCurrency.valueOf(0);

                if (C_Tuukasyu.JPY.eq(siBikinkanri.getKyktuukasyu())) {
                    misyuup = siBikinkanri.getMisyuup();
                    knsnkijyunymd = null;
                    kawaseRate = "";
                    kyktuukamisyuup = "";
                    syonendojikaiikoup = siBikinkanri.getSyonendojikaiikoup();
                    jinendoikoup = siBikinkanri.getJinendoikoup();
                }
                else {
                    misyuup = siBikinkanri.getYenkamisyuup();
                    knsnkijyunymd = siBikinkanri.getShrkwsratekjnymd();
                    kawaseRate = siBikinkanri.getShrkwsrate().toString();
                    kyktuukamisyuup = siBikinkanri.getMisyuup().toString();
                    syonendojikaiikoup = siBikinkanri.getYenkasyonendojikaiikoup();
                    jinendoikoup = siBikinkanri.getYenkajinendoikoup();
                }

                BizDate syoruiukeymd = siBikinkanri.getSyoruiukeymd();

                if (siBikinkanri.getHubikanryouymd() != null) {
                    syoruiukeymd = siBikinkanri.getHubikanryouymd();
                }

                String gaikaukthyoji;

                if (C_Tuukasyu.JPY.eq(siBikinkanri.getShrtuukasyu()) ||
                    C_Tuukasyu.BLNK.eq(siBikinkanri.getShrtuukasyu()) ) {
                    gaikaukthyoji = "";
                }
                else {
                    gaikaukthyoji = "*";
                }

                outKensuu = outKensuu + 1;

                YuyuSiharaiConfig yuyuSiharaiConfig =  YuyuSiharaiConfig.getInstance();
                String tantousitu = yuyuSiharaiConfig.getTantousitu();

                SiBikinMisyupKeijyouListLayoutFile siBikinMisyupKeijyouListLayoutFile =
                    SWAKInjector.getInstance(SiBikinMisyupKeijyouListLayoutFile.class);

                siBikinMisyupKeijyouListLayoutFile.setIfcListnm(LISTNM);
                siBikinMisyupKeijyouListLayoutFile.setIfcAtesaki(tantousitu);
                siBikinMisyupKeijyouListLayoutFile.setIfcSakuseiymdseireki(
                    FixedDateFormatter.formatYMDSeirekiSlashZeroFill(syoriYmd));
                siBikinMisyupKeijyouListLayoutFile.setIfcPageno("");
                siBikinMisyupKeijyouListLayoutFile.setIfcKbnkeirisegcd(siBikinkanri.getKbnkeirisegcd().getValue());
                siBikinMisyupKeijyouListLayoutFile.setIfcHknsyruilevelcd(siBikinkanri.getKbnkeirisegcd().getContent());
                siBikinMisyupKeijyouListLayoutFile.setIfcBknkktinnd(siBikinkanri.getBknkktinnd());
                siBikinMisyupKeijyouListLayoutFile.setIfcBknkktiym(siBikinkanri.getBknkktiym().toString());
                siBikinMisyupKeijyouListLayoutFile.setIfcKessannnd(csvKessannnd);
                siBikinMisyupKeijyouListLayoutFile.setIfcBkncd(siBikinkanri.getBkncdkbn().getValue());
                siBikinMisyupKeijyouListLayoutFile.setIfcBknkktiymdseireki(
                    FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getBknkktymd()));
                siBikinMisyupKeijyouListLayoutFile.setIfcCalckijyunymdseireki(
                    FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getCalckijyunymd()));
                siBikinMisyupKeijyouListLayoutFile.setIfcSyono(siBikinkanri.getSyono());
                siBikinMisyupKeijyouListLayoutFile.setIfcKeiyakuymd(
                    FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getKykymd()));
                siBikinMisyupKeijyouListLayoutFile.setIfcMisyuupjyuutouym(siBikinkanri.getMisyuupjyuutouym().toString());
                siBikinMisyupKeijyouListLayoutFile.setIfcHrkp(siBikinkanri.getHrkp().toString());
                siBikinMisyupKeijyouListLayoutFile.setIfcMisyuup(misyuup.toString());

                if (syoruiukeymd == null) {
                    siBikinMisyupKeijyouListLayoutFile.setIfcSyoruiukeymdseireki("");
                }
                else {
                    siBikinMisyupKeijyouListLayoutFile.setIfcSyoruiukeymdseireki(
                        FixedDateFormatter.formatYMDSeirekiSlashZeroFill(syoruiukeymd));
                }

                siBikinMisyupKeijyouListLayoutFile.setIfcGaikaukthyoji(gaikaukthyoji);

                if (knsnkijyunymd == null) {
                    siBikinMisyupKeijyouListLayoutFile.setIfcKnsnkijyunymd("");
                }
                else {
                    siBikinMisyupKeijyouListLayoutFile.setIfcKnsnkijyunymd(
                        FixedDateFormatter.formatYMDSeirekiSlashZeroFill(knsnkijyunymd));
                }

                siBikinMisyupKeijyouListLayoutFile.setIfcKawaserate(kawaseRate);
                siBikinMisyupKeijyouListLayoutFile.setIfcKyktuukamisyuup(kyktuukamisyuup);
                siBikinMisyupKeijyouListLayoutFile.setIfcKyktuuka(siBikinkanri.getKyktuukasyu().getValue());
                siBikinMisyupKeijyouListLayoutFile.setIfcHrkkaisuunaiyou(siBikinkanri.getHrkkaisuu().getContent());
                siBikinMisyupKeijyouListLayoutFile.setIfcSyonendojikaiikoup(syonendojikaiikoup.toString());
                siBikinMisyupKeijyouListLayoutFile.setIfcJinendoikoup(jinendoikoup.toString());

                siBikinMisyupKeijyouListLayoutFileLst.add(siBikinMisyupKeijyouListLayoutFile);
            }
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn result = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_BIKINMISYUPKEIJYOUFILE,
            siBikinMisyupKeijyouListLayoutFileLst, true);

        if (C_ErrorKbn.ERROR.eq(result)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(outKensuu), kinou.getKinouNm()));
    }
}
