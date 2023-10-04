package yuyu.batch.siharai.sikessan.simakebikintyousa;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.detacher.JT_SkKihonDetacher;
import yuyu.def.siharai.file.csv.SiBikinTyousaLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SkKihon;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 保険金給付金支払 決算 支払保険金備金調査F作成
 */
public class SiMakeBikinTyousaBatch implements Batch {

    private final Integer UKETUKENO = 1;

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

        long syoriKensuu = 0;

        List<SiBikinTyousaLayoutFile> sibikinTyousaLayoutFileLst = Lists.newArrayList();

        int syoriM = syoriYmd.getMonth();

        BizDate kessanKijyunYmd = null;

        BizDate kijyunYmd = null;

        if (syoriM == 4 || syoriM == 5 || syoriM == 6) {

            kessanKijyunYmd = BizDate.valueOf(syoriYmd.getBizDateY(), 3, 31);

            if (syoriM == 6) {

                kijyunYmd = BizDate.valueOf(syoriYmd.getBizDateY(), 4, 20);

                if (kijyunYmd.isHoliday()) {

                    kijyunYmd = kijyunYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
                }
            }
            else {
                kijyunYmd = kessanKijyunYmd;
            }
        }
        else {
            kessanKijyunYmd = syoriYmd.getPreviousMonth().getBizDateYM().getLastDay();

            kijyunYmd = kessanKijyunYmd;
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        try (ExDBResults<JT_SiBikinkanri> siBikinkanriExDBResults = siharaiDomManager.
            getSiBikinkanrisByKessankijyunymdBknrigikbnOrderByBkntyousafsyorikbnSyono(kessanKijyunYmd,
                C_BknrigiKbn.BLNK)) {

            for (JT_SiBikinkanri siBikinkanri : siBikinkanriExDBResults) {

                List<JT_SiRireki> siRirekiLst = new ArrayList<>();

                if (C_BkncdKbn.SIBOUKARIUKETUKE.eq(siBikinkanri.getBkncdkbn())) {
                    List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuSaisateikbn(
                        siBikinkanri.getSyono(), C_SeikyuuSyubetu.SB, C_SaisateiKbn.BLNK);

                    if (skKihonLst.size() > 0) {

                        SortJT_SkKihon sortJt_SiKihon = SWAKInjector.getInstance(SortJT_SkKihon.class);
                        JT_SkKihon skKihon = sortJt_SiKihon.OrderJT_SkKihonByPkDesc(skKihonLst).get(0);

                        JT_SkKihon skKihonDetach = JT_SkKihonDetacher.detachSiRirekitouched(skKihon);

                        siRirekiLst = skKihonDetach.getSiRirekisByShrsyoriymd(kijyunYmd);
                    }
                }
                else {
                    JT_SkKihon skKihon = siharaiDomManager.getSkKihon(siBikinkanri.getSkno(), siBikinkanri.getSyono());

                    JT_SkKihon skKihonDetach = JT_SkKihonDetacher.detachSiRirekitouched(skKihon);

                    siRirekiLst = skKihonDetach.getSiRirekisByShrsyoriymd(kijyunYmd);
                }

                if (siRirekiLst.size() > 0) {

                    JT_SkKihon skKihon1 = siharaiDomManager.getSkKihon(siRirekiLst.get(0).getSkno(), siRirekiLst.get(0).getSyono());

                    JT_SkKihon skKihonDetach1 = JT_SkKihonDetacher.detachSiDetailtouched(skKihon1);

                    JT_Sk sk = skKihonDetach1.getSkBySeikyuurirekino(siRirekiLst.get(0).getSeikyuurirekino());

                    JT_SkJiyuu skJiyuu = sk.getSkJiyuuByUketukeno(UKETUKENO);

                    List<JT_SiDetail> siDetailLst = skJiyuu.getSiDetails();

                    if (siDetailLst.size() > 0) {

                        for (JT_SiDetail siDetail : siDetailLst) {

                            if (BizUtil.isZero(siDetail.getKyhkg())) {

                                continue;
                            }

                            BizCurrency irHkgk = BizCurrency.valueOf(0);

                            C_BlnktkumuKbn blnktkumuKbn = C_BlnktkumuKbn.BLNK;

                            if (C_ShrKekkaKbn.HSHR.eq(siRirekiLst.get(0).getShrkekkakbn())) {

                                irHkgk = BizCurrency.valueOf(0);
                            }
                            else {
                                if (C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {

                                    irHkgk = siDetail.getKyhkg();
                                }
                                else {

                                    irHkgk = siDetail.getYenkyhgk();
                                }
                            }

                            if (C_ShrKekkaKbn.SHR.eq(siRirekiLst.get(0).getShrkekkakbn())) {

                                if (siBikinkanri.getShrgk().compareTo(siDetail.getKyhkg()) == 0) {

                                    if (!C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {

                                        if (siBikinkanri.getBkngk().compareTo(siDetail.getYenkyhgk()) != 0) {

                                            blnktkumuKbn = C_BlnktkumuKbn.ARI;
                                        }
                                    }

                                }
                            }

                            SiBikinTyousaLayoutFile sibikinTyousaLayoutFile = SWAKInjector.getInstance(SiBikinTyousaLayoutFile.class);

                            sibikinTyousaLayoutFile.setIfcSyorikbn(siBikinkanri.getBkntyousafsyorikbn().getValue());

                            sibikinTyousaLayoutFile.setIfcSyono(siBikinkanri.getSyono());

                            sibikinTyousaLayoutFile.setIfcSishrymd(siRirekiLst.get(0).getTyakkinymd());

                            sibikinTyousaLayoutFile.setIfcJikohasseiymd(skJiyuu.getSibouymd());

                            sibikinTyousaLayoutFile.setIfcKaisyaryoutiymd(skKihonDetach1.getSiboukaritrkymd());

                            sibikinTyousaLayoutFile.setIfcHkgk(irHkgk.toString());

                            sibikinTyousaLayoutFile.setIfcBikinkeigaku(siBikinkanri.getBkngk().toString());

                            sibikinTyousaLayoutFile.setIfcHkgkbkngk(irHkgk.subtract(siBikinkanri.getBkngk()).toString());

                            sibikinTyousaLayoutFile.setIfcNkseikyuukbn("");

                            sibikinTyousaLayoutFile.setIfcYobisiharai("");

                            sibikinTyousaLayoutFile.setIfcKyktuukasyu(siBikinkanri.getKyktuukasyu().getValue());

                            sibikinTyousaLayoutFile.setIfcKawaseratesouikbn(blnktkumuKbn.getValue());

                            sibikinTyousaLayoutFileLst.add(sibikinTyousaLayoutFile);

                            syoriKensuu++;
                        }
                    }
                }
            }

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn result =
                bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_BIKINTYOUSA, sibikinTyousaLayoutFileLst, true);

            if (C_ErrorKbn.ERROR.eq(result)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), kinou.getKinouNm()));
    }
}
