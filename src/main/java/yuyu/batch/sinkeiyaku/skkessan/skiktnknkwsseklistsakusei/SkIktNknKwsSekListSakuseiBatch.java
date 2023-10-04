package yuyu.batch.sinkeiyaku.skkessan.skiktnknkwsseklistsakusei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.skkessan.skiktnknkwsseklistsakusei.dba.SkIktNknKwsSekListSakuseiDao;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_GrossNykn;
import yuyu.def.db.entity.HT_GrossNyknMeisai;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.file.csv.SkIktNknKwsSekLayoutFile;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 決算 一括入金為替差益リスト作成
 */
public class SkIktNknKwsSekListSakuseiBatch implements Batch {

    private BizCurrency goukeiSaekiGk;

    private C_Tuukasyu goukeiRyousyuuTuukasyu;

    private List<SkIktNknKwsSekLayoutFile> skIktNknKwsSekLayoutFileLst;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SkIktNknKwsSekListSakuseiBatchParam skIktNknKwsSekListSakuseiBatchParam;

    @Inject
    private SkIktNknKwsSekListSakuseiDao skIktNknKwsSekListSakuseiDao;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Override
    public BatchParam getParam() {
        return skIktNknKwsSekListSakuseiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = skIktNknKwsSekListSakuseiBatchParam.getSyoriYmd();
        String kessanFlg = skIktNknKwsSekListSakuseiBatchParam.getKessanFlg();

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage("決算フラグ"), kessanFlg));

        goukeiSaekiGk = BizCurrency.valueOf(0);
        goukeiRyousyuuTuukasyu = C_Tuukasyu.BLNK;
        skIktNknKwsSekLayoutFileLst = new ArrayList<>();

        BizDate ryosyuFromYmd = null;
        BizDate ryosyuToYmd = null;
        long count = 0;
        int renno = 0;

        if ("1".equals(kessanFlg)) {

            BizDateY syoriY = syoriYmd.getBizDateY();

            if (syoriYmd.getMonth() == 7) {

                ryosyuFromYmd = BizDate.valueOf(syoriY, 4, 1);
                ryosyuToYmd = BizDate.valueOf(syoriY, 6, 30);
            }
            else if (syoriYmd.getMonth() == 10) {

                ryosyuFromYmd = BizDate.valueOf(syoriY, 7, 1);
                ryosyuToYmd = BizDate.valueOf(syoriY, 9, 30);
            }
            else if (syoriYmd.getMonth() == 1) {

                ryosyuFromYmd = BizDate.valueOf(syoriY.addYears(-1), 10, 1);
                ryosyuToYmd = BizDate.valueOf(syoriY.addYears(-1), 12, 31);
            }
            else if (syoriYmd.getMonth() == 4) {

                ryosyuFromYmd = BizDate.valueOf(syoriY, 1, 1);
                ryosyuToYmd = BizDate.valueOf(syoriY, 3, 31);
            }

            try (ExDBResults<HT_GrossNykn> grossNyknLst =
                skIktNknKwsSekListSakuseiDao.getGrossNyukinInfoByRyosyuYmd(ryosyuFromYmd, ryosyuToYmd);) {

                for (HT_GrossNykn grossNykn : grossNyknLst) {

                    setSkIktNknKwsSekLayOutFileLst(grossNykn, renno);

                    renno = renno + 1;

                    count = count + 1;
                }

            }
        }
        else {

            try (ExDBResults<HT_GrossNykn> grossNyknLst = skIktNknKwsSekListSakuseiDao.getGrossNyukinInfoBySyoriYmd(syoriYmd);) {

                for (HT_GrossNykn grossNykn : grossNyknLst) {

                    setSkIktNknKwsSekLayOutFileLst(grossNykn, renno);

                    renno = renno + 1;

                    count = count + 1;
                }

            }
        }

        if (count > 0) {

            SkIktNknKwsSekLayoutFile skIktNknKwsSekLayoutFile = SWAKInjector.getInstance(SkIktNknKwsSekLayoutFile.class);
            skIktNknKwsSekLayoutFile.setIfcRstuukasyu(goukeiRyousyuuTuukasyu.getValue());
            skIktNknKwsSekLayoutFile.setIfcMeisaikbn("3");
            skIktNknKwsSekLayoutFile.setIfcTotalkawasesaeki(String.valueOf(goukeiSaekiGk));

            skIktNknKwsSekLayoutFileLst.add(skIktNknKwsSekLayoutFile);
        }

        C_FileSyuruiCdKbn outFileSyuruiCdKbn;

        if ("1".equals(kessanFlg)) {

            outFileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_IKTNYUUKINKAWASESAEKISIHANKI;
        }
        else {

            outFileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_IKTNYUUKINKAWASESAEKI;
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        bzFileUploadUtil.exec(outFileSyuruiCdKbn, skIktNknKwsSekLayoutFileLst, true);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(count), "対象グロス入金TBL件数"));

    }

    private void setSkIktNknKwsSekLayOutFileLst(HT_GrossNykn pGrossNykn, Integer pRenno) {

        HT_SyoriCTL syoriCtl = null;

        HT_MosKihon mosKihon = null;

        if (pRenno != 0 && !C_Tuukasyu.BLNK.eq(goukeiRyousyuuTuukasyu) &&
            !goukeiRyousyuuTuukasyu.eq(pGrossNykn.getHrktuukasyu())) {

            SkIktNknKwsSekLayoutFile skIktNknKwsSeklayoutfile = SWAKInjector.getInstance(SkIktNknKwsSekLayoutFile.class);

            skIktNknKwsSeklayoutfile.setIfcRstuukasyu(goukeiRyousyuuTuukasyu.getValue());
            skIktNknKwsSeklayoutfile.setIfcMeisaikbn("3");
            skIktNknKwsSeklayoutfile.setIfcTotalkawasesaeki(String.valueOf(goukeiSaekiGk));

            skIktNknKwsSekLayoutFileLst.add(skIktNknKwsSeklayoutfile);

            goukeiSaekiGk = BizCurrency.valueOf(0);
        }

        SkIktNknKwsSekLayoutFile skIktNknKwsseklayoutfile = SWAKInjector.getInstance(SkIktNknKwsSekLayoutFile.class);

        skIktNknKwsseklayoutfile.setIfcRstuukasyu(pGrossNykn.getHrktuukasyu().getValue());
        skIktNknKwsseklayoutfile.setIfcRennoStr(String.valueOf(pRenno + 1));
        skIktNknKwsseklayoutfile.setIfcMeisaikbn("1");
        skIktNknKwsseklayoutfile.setIfcKyktuukasyu(pGrossNykn.getKyktuukasyu().getValue());
        skIktNknKwsseklayoutfile.setIfcRyosyuymd(String.valueOf(pGrossNykn.getRyosyuymd()));
        skIktNknKwsseklayoutfile.setIfcOyadrtennm(pGrossNykn.getNyuukinoyadrtennm());
        skIktNknKwsseklayoutfile.setIfcKouzano(pGrossNykn.getKouzano());
        skIktNknKwsseklayoutfile.setIfcKawaserate(String.valueOf(pGrossNykn.getKawaserate()));
        skIktNknKwsseklayoutfile.setIfcGrossnykngk(String.valueOf(pGrossNykn.getGrossnykngk()));
        skIktNknKwsseklayoutfile.setIfcGrossdengk(String.valueOf(pGrossNykn.getGrossdengk()));
        skIktNknKwsseklayoutfile.setIfcMeisaigoukeidengk(String.valueOf(pGrossNykn.getMeisaigoukeidengk()));
        skIktNknKwsseklayoutfile.setIfcKawasesaeki(String.valueOf(pGrossNykn.getKawasesasonekikngk()));

        skIktNknKwsSekLayoutFileLst.add(skIktNknKwsseklayoutfile);

        goukeiSaekiGk = goukeiSaekiGk.add(pGrossNykn.getKawasesasonekikngk());
        goukeiRyousyuuTuukasyu = pGrossNykn.getHrktuukasyu();

        List<HT_GrossNyknMeisai> grossNyknMeisaiLst = pGrossNykn.getGrossNyknMeisais();

        for (HT_GrossNyknMeisai grossNyknMeisai : grossNyknMeisaiLst) {

            syoriCtl = sinkeiyakuDomManager.getSyoriCTL(grossNyknMeisai.getNykmosno());

            if (syoriCtl != null) {

                mosKihon = syoriCtl.getMosKihon();
            }

            String mosStatus = "";

            if (syoriCtl == null || C_UmuKbn.NONE.eq(syoriCtl.getMosnrkumu()) || mosKihon == null) {

                mosStatus = "未到着";
            }
            else {

                if (C_UmuKbn.NONE.eq(syoriCtl.getNyknnrkumu())) {

                    mosStatus = "未入金";
                }
                else {

                    mosStatus = "入金済";
                }
            }

            SkIktNknKwsSekLayoutFile skIktNknKwsSekLayoutfile = SWAKInjector.getInstance(SkIktNknKwsSekLayoutFile.class);

            skIktNknKwsSekLayoutfile.setIfcRstuukasyu(pGrossNykn.getHrktuukasyu().getValue());
            skIktNknKwsSekLayoutfile.setIfcRennoStr(String.valueOf(pRenno + 1));
            skIktNknKwsSekLayoutfile.setIfcMeisaikbn("2");
            skIktNknKwsSekLayoutfile.setIfcKyktuukasyu(pGrossNykn.getKyktuukasyu().getValue());
            skIktNknKwsSekLayoutfile.setIfcRyosyuymd(String.valueOf(pGrossNykn.getRyosyuymd()));
            skIktNknKwsSekLayoutfile.setIfcOyadrtennm(pGrossNykn.getNyuukinoyadrtennm());
            skIktNknKwsSekLayoutfile.setIfcKouzano(pGrossNykn.getKouzano());
            skIktNknKwsSekLayoutfile.setIfcKawaserate(String.valueOf(pGrossNykn.getKawaserate()));
            skIktNknKwsSekLayoutfile.setIfcMosno(grossNyknMeisai.getNykmosno());
            skIktNknKwsSekLayoutfile.setIfcRsgaku(String.valueOf(grossNyknMeisai.getRsgaku()));
            skIktNknKwsSekLayoutfile.setIfcDengk(String.valueOf(grossNyknMeisai.getDengk()));
            skIktNknKwsSekLayoutfile.setIfcMosstatus(mosStatus);

            skIktNknKwsSekLayoutFileLst.add(skIktNknKwsSekLayoutfile);
        }
    }
}
