package yuyu.batch.siharai.sikessan.simakezeimuhenrei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.siharai.file.csv.SiMkZeiHenMeisaiLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 保険金給付金支払 決算 税務及び返戻金備金明細表作成
 */
public class SiMakeZeimuHenreiBatch implements Batch {

    private BizDate kessanKijyunYmd;

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(batchParam.getSyoriYmd())));

        long count = 0;

        List<SiMkZeiHenMeisaiLayoutFile> siMakeZeimuHenreiLst = new ArrayList<>();

        if (batchParam.getSyoriYmd().getDay() <= 15) {

            kessanKijyunYmd = batchParam.getSyoriYmd().getPreviousMonth().getBizDateYM().getLastDay();
        }

        else {

            kessanKijyunYmd = batchParam.getSyoriYmd().getBizDateYM().getLastDay();
        }

        try (ExDBResults<JT_SiBikinkanri> siBikinkanrisLst = siharaiDomManager
            .getSiBikinkanrisByKessankijyunymdBknrigikbnEx(kessanKijyunYmd, C_BknrigiKbn.BLNK)) {
            Iterator<JT_SiBikinkanri> siBikinkanri = siBikinkanrisLst.iterator() ;
            while (siBikinkanri.hasNext()) {

                JT_SiBikinkanri siBikinkanriloop = siBikinkanri.next();

                SiMkZeiHenMeisaiLayoutFile siMkZeiHenMeisaiLayoutFile = SWAKInjector
                    .getInstance(SiMkZeiHenMeisaiLayoutFile.class);

                if (C_BkncdKbn.SIBOUUKETUKE.eq(siBikinkanriloop.getBkncdkbn())) {

                    if (C_ShrKekkaKbn.HSHR.eq(siBikinkanriloop.getShrkekkakbn())) {
                        siMkZeiHenMeisaiLayoutFile.setIfcSyono(siBikinkanriloop.getSyono());
                        siMkZeiHenMeisaiLayoutFile.setIfcSeglevelkbn(siBikinkanriloop.getKbnkeirisegcd().getValue()
                            .substring(0, 2));
                        siMkZeiHenMeisaiLayoutFile.setIfcHknsyruilevelkbn(siBikinkanriloop.getKbnkeirisegcd().getValue()
                            .substring(2, 4));
                        siMkZeiHenMeisaiLayoutFile.setIfcBknkktiymd(siBikinkanriloop.getBknkktymd());
                        siMkZeiHenMeisaiLayoutFile.setIfcBkncd(siBikinkanriloop.getBkncdkbn().getValue());
                        siMkZeiHenMeisaiLayoutFile.setIfcBikinkeigaku(siBikinkanriloop.getBkngk().toString());
                        siMkZeiHenMeisaiLayoutFile.setIfcKaimasis("0");
                        siMkZeiHenMeisaiLayoutFile.setIfcNkbikinhyj("");
                        siMkZeiHenMeisaiLayoutFile.setIfcZeimuhininkakyouhyj("");
                        siMkZeiHenMeisaiLayoutFile.setIfcYobisiharai("");
                        siMkZeiHenMeisaiLayoutFile.setIfcKyktuukasyu(siBikinkanriloop.getKyktuukasyu().getValue());
                        siMakeZeimuHenreiLst.add(siMkZeiHenMeisaiLayoutFile);
                    }
                    else if (C_ShrKekkaKbn.BLNK.eq(siBikinkanriloop.getShrkekkakbn())) {

                        if (C_UmuKbn.ARI.eq(siBikinkanriloop.getJisatumensekiumukbn())) {
                            siMkZeiHenMeisaiLayoutFile.setIfcSyono(siBikinkanriloop.getSyono());
                            siMkZeiHenMeisaiLayoutFile.setIfcSeglevelkbn(siBikinkanriloop.getKbnkeirisegcd().getValue()
                                .substring(0, 2));
                            siMkZeiHenMeisaiLayoutFile.setIfcHknsyruilevelkbn(siBikinkanriloop.getKbnkeirisegcd()
                                .getValue().substring(2, 4));
                            siMkZeiHenMeisaiLayoutFile.setIfcBknkktiymd(siBikinkanriloop.getBknkktymd());
                            siMkZeiHenMeisaiLayoutFile.setIfcBkncd(siBikinkanriloop.getBkncdkbn().getValue());
                            siMkZeiHenMeisaiLayoutFile.setIfcBikinkeigaku(siBikinkanriloop.getBkngk().toString());
                            siMkZeiHenMeisaiLayoutFile.setIfcKaimasis("0");
                            siMkZeiHenMeisaiLayoutFile.setIfcNkbikinhyj("");
                            siMkZeiHenMeisaiLayoutFile.setIfcZeimuhininkakyouhyj("");
                            siMkZeiHenMeisaiLayoutFile.setIfcYobisiharai("");
                            siMkZeiHenMeisaiLayoutFile.setIfcKyktuukasyu(siBikinkanriloop.getKyktuukasyu().getValue());
                            siMakeZeimuHenreiLst.add(siMkZeiHenMeisaiLayoutFile);
                        }
                    }
                }
                else if (C_BkncdKbn.SIBOUKARIUKETUKE.eq(siBikinkanriloop.getBkncdkbn())) {

                    if (C_UmuKbn.ARI.eq(siBikinkanriloop.getJisatumensekiumukbn())) {
                        siMkZeiHenMeisaiLayoutFile.setIfcSyono(siBikinkanriloop.getSyono());
                        siMkZeiHenMeisaiLayoutFile.setIfcSeglevelkbn(siBikinkanriloop.getKbnkeirisegcd().getValue()
                            .substring(0, 2));
                        siMkZeiHenMeisaiLayoutFile.setIfcHknsyruilevelkbn(siBikinkanriloop.getKbnkeirisegcd().getValue()
                            .substring(2, 4));
                        siMkZeiHenMeisaiLayoutFile.setIfcBknkktiymd(siBikinkanriloop.getBknkktymd());
                        siMkZeiHenMeisaiLayoutFile.setIfcBkncd(siBikinkanriloop.getBkncdkbn().getValue());
                        siMkZeiHenMeisaiLayoutFile.setIfcBikinkeigaku(siBikinkanriloop.getBkngk().toString());
                        siMkZeiHenMeisaiLayoutFile.setIfcKaimasis("0");
                        siMkZeiHenMeisaiLayoutFile.setIfcNkbikinhyj("");
                        siMkZeiHenMeisaiLayoutFile.setIfcZeimuhininkakyouhyj("");
                        siMkZeiHenMeisaiLayoutFile.setIfcYobisiharai("");
                        siMkZeiHenMeisaiLayoutFile.setIfcKyktuukasyu(siBikinkanriloop.getKyktuukasyu().getValue());
                        siMakeZeimuHenreiLst.add(siMkZeiHenMeisaiLayoutFile);
                    }
                }
            }
            count = siMakeZeimuHenreiLst.size();

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_ZEIMUHENREIMEISAI, siMakeZeimuHenreiLst,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(count), kinou.getKinouNm()));
        }
    }
}
