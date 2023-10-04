package yuyu.batch.siharai.sihubi.simakehubitourokulist;

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
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.file.csv.SiMktKnrRendouLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.result.bean.HubiTourokuInfosByHasinymdBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 保険金給付金支払 不備 不備登録リスト作成
 */
public class SiMakeHubiTourokuListBatch implements Batch {
    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        try (ExDBResults<HubiTourokuInfosByHasinymdBean> exDbResults = siharaiDomManager
            .getHubiTourokuInfosByHasinymd(syoriYmd)) {
            long totalCnt = 0;
            List<SiMktKnrRendouLayoutFile> hubiTourokuInfosByHasinymdBeanList = Lists.newArrayList();
            Iterator<HubiTourokuInfosByHasinymdBean> hubiTourokuInfosByHasinymdBean = exDbResults.iterator();
            if (hubiTourokuInfosByHasinymdBean.hasNext()) {
                while (hubiTourokuInfosByHasinymdBean.hasNext()) {
                    HubiTourokuInfosByHasinymdBean hubiTourokuInfosByHasinymdBeanLoop = hubiTourokuInfosByHasinymdBean
                        .next();

                    BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager
                        .getGyoumuKouteiInfo(hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi().getHubisikibetukey());

                    KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
                    KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
                    keiyakuPrm.setSyono(hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi().getSyono());
                    keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);
                    keiyakuInfoSyutoku.getInfos(keiyakuPrm);
                    JT_SiKykKihon siKykKihon = keiyakuInfoSyutoku.getKykKihons().get(0);

                    JT_SkKihon skKihon = siharaiDomManager.getSkKihon(gyoumuKouteiInfo.getSkno(),
                        gyoumuKouteiInfo.getSyono());

                    Integer maxSeikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(
                        skKihon.getSkno(), skKihon.getSyono());

                    JT_Sk sk = skKihon.getSkBySeikyuurirekino(maxSeikyuurirekino);

                    SiMktKnrRendouLayoutFile siMktKnrRendouLayoutFile = SWAKInjector
                        .getInstance(SiMktKnrRendouLayoutFile.class);

                    String kakuninsakiKbn = "";

                    String ssyiriskiSsycd = "";
                    if (C_HassinsakiKbn.KOK.eq(hubiTourokuInfosByHasinymdBeanLoop.getHassinsakikbn())) {
                        kakuninsakiKbn = TeisuuSiharai.KAKSAKIKBNMKTKNR_SEIKYUUSYA;
                    }
                    else if (C_HassinsakiKbn.SISYA.eq(hubiTourokuInfosByHasinymdBeanLoop.getHassinsakikbn())) {
                        kakuninsakiKbn = TeisuuSiharai.KAKSAKIKBNMKTKNR_SISYA;

                    }
                    else if (C_HassinsakiKbn.SYA.eq(hubiTourokuInfosByHasinymdBeanLoop.getHassinsakikbn())) {
                        kakuninsakiKbn = TeisuuSiharai.KAKSAKIKBNMKTKNR_SISYA;

                    }
                    if (C_HassinsakiKbn.KOK.eq(hubiTourokuInfosByHasinymdBeanLoop.getHassinsakikbn())) {
                        ssyiriskiSsycd = "";
                    }
                    else if (C_HassinsakiKbn.SISYA.eq(hubiTourokuInfosByHasinymdBeanLoop.getHassinsakikbn())) {
                        ssyiriskiSsycd = hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi().getSisyacd();

                    }
                    else if (C_HassinsakiKbn.SYA.eq(hubiTourokuInfosByHasinymdBeanLoop.getHassinsakikbn())
                        && !BizUtil.isBlank(hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi().getSisyacd())) {
                        ssyiriskiSsycd = hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi().getSisyacd();

                    }
                    else if (C_HassinsakiKbn.SYA.eq(hubiTourokuInfosByHasinymdBeanLoop.getHassinsakikbn())
                        && BizUtil.isBlank(hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi().getSisyacd())) {
                        ssyiriskiSsycd = C_Tantositucd.SIHARAIGYOUMU.getValue();

                    }
                    siMktKnrRendouLayoutFile.setIfcAnkenkanrino("");
                    siMktKnrRendouLayoutFile.setIfcSyono(siKykKihon.getSyono());
                    siMktKnrRendouLayoutFile.setIfcIraiymd(hubiTourokuInfosByHasinymdBeanLoop.getHasinymd());
                    siMktKnrRendouLayoutFile.setIfcIraimotokbn(TeisuuSiharai.IRAIMOTOKBNMKTKNR_YUYU);
                    siMktKnrRendouLayoutFile.setIfcHubisyubetu(TeisuuSiharai.HBSYBTMKTKNR_BUNSYOHUI);
                    siMktKnrRendouLayoutFile.setIfcKakuninsakikbn(kakuninsakiKbn);
                    siMktKnrRendouLayoutFile.setIfcKakuninkbn("");
                    siMktKnrRendouLayoutFile.setIfcKyuuhukbn(TeisuuSiharai.KYUUHUKBNMKTKNR_SB);
                    siMktKnrRendouLayoutFile.setIfcHonninsaisikbn("");
                    siMktKnrRendouLayoutFile.setIfcTaisyousyakbn(TeisuuSiharai.TAISYOUKBNMKTKNR_HONNIN);
                    siMktKnrRendouLayoutFile.setIfcSeikyuukbn(TeisuuSiharai.SEIKYUUKBNMKTKNR_SB);
                    siMktKnrRendouLayoutFile.setIfcSyoubyousyakn("");
                    siMktKnrRendouLayoutFile.setIfcSyoubyousyakj("");
                    siMktKnrRendouLayoutFile.setIfcSyoubyousyaseiymd(null);
                    siMktKnrRendouLayoutFile.setIfcHhknkbn(TeisuuSiharai.HHKNKBNMKTKNR_1HI);
                    siMktKnrRendouLayoutFile.setIfcHhknmeikn(ConvertUtil.toHanAll(siKykKihon.getHhknnmkn(), 0, 0));
                    siMktKnrRendouLayoutFile.setIfcHhknmeikj(siKykKihon.getHhknnmkj());
                    siMktKnrRendouLayoutFile.setIfcHihokensyaseiymd(siKykKihon.getHhknseiymd());
                    siMktKnrRendouLayoutFile.setIfcDai2hhknmeikn("");
                    siMktKnrRendouLayoutFile.setIfcDai2hhknmeikj("");
                    siMktKnrRendouLayoutFile.setIfcDai2hhknseiymd(null);
                    siMktKnrRendouLayoutFile.setIfcKijyunymd(sk.getSyoruiukeymd());
                    siMktKnrRendouLayoutFile.setIfcSyoruiukeymd(sk.getSyoruiukeymd());
                    siMktKnrRendouLayoutFile.setIfcIraimotocomment("");
                    siMktKnrRendouLayoutFile.setIfcHubidojikakuninumu("");
                    siMktKnrRendouLayoutFile.setIfcKyksyameikn(ConvertUtil.toHanAll(siKykKihon.getKyknmkn(), 0, 0));
                    siMktKnrRendouLayoutFile.setIfcKyksyameikj(siKykKihon.getKyknmkj());
                    siMktKnrRendouLayoutFile.setIfcKeiyakuseiymd(siKykKihon.getKykseiymd());
                    siMktKnrRendouLayoutFile.setIfcKykadr(siKykKihon.getTsinadr1kj() + siKykKihon.getTsinadr2kj()
                        + siKykKihon.getTsinadr3kj());
                    siMktKnrRendouLayoutFile.setIfcSiteidairimeikn(ConvertUtil.toHanAll(siKykKihon.getSiteidruktnmkn(), 0, 0));
                    siMktKnrRendouLayoutFile.setIfcSiteidairimeikj(siKykKihon.getSiteidruktnmkj());
                    siMktKnrRendouLayoutFile.setIfcShadr(hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi()
                        .getRenrakusakiadr1kj()
                        + hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi().getRenrakusakiadr2kj()
                        + hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi().getRenrakusakiadr3kj());
                    siMktKnrRendouLayoutFile.setIfcYno(hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi()
                        .getRenrakuyno());
                    siMktKnrRendouLayoutFile.setIfcKihontikucd("");
                    siMktKnrRendouLayoutFile.setIfcJyouiadr("");
                    siMktKnrRendouLayoutFile.setIfcKaiadr(hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi()
                        .getRenrakusakiadr1kj()
                        + hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi().getRenrakusakiadr2kj()
                        + hubiTourokuInfosByHasinymdBeanLoop.getJT_SiHubi().getRenrakusakiadr3kj());
                    siMktKnrRendouLayoutFile.setIfcSsyiriskissycd(ssyiriskiSsycd);
                    siMktKnrRendouLayoutFile.setIfcMdhansybetukbn("");
                    siMktKnrRendouLayoutFile.setIfcHjntkskhyj("");
                    siMktKnrRendouLayoutFile.setIfcKykhknhyj("");

                    hubiTourokuInfosByHasinymdBeanList.add(siMktKnrRendouLayoutFile);
                    totalCnt++;

                }
            }

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_HUBILIST,
                hubiTourokuInfosByHasinymdBeanList, true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(totalCnt), kinou.getKinouNm()));
        }
    }
}
