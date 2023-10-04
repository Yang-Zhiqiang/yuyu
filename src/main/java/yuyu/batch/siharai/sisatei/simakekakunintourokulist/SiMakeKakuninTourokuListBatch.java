package yuyu.batch.siharai.sisatei.simakekakunintourokulist;

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
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.file.csv.SiMktKnrRendouLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SkJiyuu;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 保険金給付金支払 査定／支払 確認登録リスト出力
 */
public class SiMakeKakuninTourokuListBatch implements Batch {
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
        try (ExDBResults<JT_TtdkRireki> exDbResults = siharaiDomManager
            .getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey
            (syoriYmd, C_SikinouModeIdKbn.SATEI2.getValue())) {
            long totalCnt = 0;
            List<SiMktKnrRendouLayoutFile> ttdkRirekiList = Lists.newArrayList();
            Iterator<JT_TtdkRireki> ttdkRireki = exDbResults.iterator();

            while (ttdkRireki.hasNext()) {

                JT_TtdkRireki ttdkRirekiLoop = ttdkRireki.next();
                KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
                KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
                keiyakuPrm.setSyono(ttdkRirekiLoop.getSyono());
                keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);
                keiyakuInfoSyutoku.getInfos(keiyakuPrm);

                List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();
                JT_SiKykKihon siKykKihon = siKykKihonLst.get(0);
                Integer MaxSeikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(
                    ttdkRirekiLoop.getSkno(), ttdkRirekiLoop.getSyono());

                JT_SkKihon skKihon = siharaiDomManager.getSkKihon(ttdkRirekiLoop.getSkno(), ttdkRirekiLoop.getSyono());

                JT_Sk sk = skKihon.getSkBySeikyuurirekino(MaxSeikyuurirekino);

                List<JT_SkJiyuu> skJiyuuList = sk.getSkJiyuus();

                SortJT_SkJiyuu sortSkJiyuu = SWAKInjector.getInstance(SortJT_SkJiyuu.class);

                JT_SkJiyuu skJiyuu = sortSkJiyuu.OrderJT_SkJiyuuByPkDesc(skJiyuuList).get(0);

                C_UmuKbn umuKbn = C_UmuKbn.NONE;

                List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoList = bizDomManager.getGyoumuKouteiInfosBySyonoSkno
                    (ttdkRirekiLoop.getSyono(), ttdkRirekiLoop.getSkno());

                String hubiSikibetuKey = gyoumuKouteiInfoList.get(0).getSyukouteikanriid();

                JT_SiHubi siHubi = siharaiDomManager.getSiHubiByHubisikibetukeyHasinymd(hubiSikibetuKey, syoriYmd);
                if (siHubi != null) {
                    umuKbn = C_UmuKbn.ARI;
                }
                SiMktKnrRendouLayoutFile siMktKnrRendouLayoutFile = SWAKInjector
                    .getInstance(SiMktKnrRendouLayoutFile.class);
                siMktKnrRendouLayoutFile.setIfcAnkenkanrino("");
                siMktKnrRendouLayoutFile.setIfcSyono(siKykKihon.getSyono());
                siMktKnrRendouLayoutFile.setIfcIraiymd(syoriYmd);
                siMktKnrRendouLayoutFile.setIfcIraimotokbn(TeisuuSiharai.IRAIMOTOKBNMKTKNR_YUYU);
                siMktKnrRendouLayoutFile.setIfcHubisyubetu(TeisuuSiharai.HBSYBTMKTKNR_KAKUNIN);
                if (C_SinsaGendoKknKbn.D180.eq(sk.getSinsagendokknkbn())) {
                    siMktKnrRendouLayoutFile.setIfcKakuninsakikbn(TeisuuSiharai.KAKSAKIKBNMKTKNR_BENGOSITOU);
                    siMktKnrRendouLayoutFile.setIfcKakuninkbn(TeisuuSiharai.KAKKBNMKTKNR_TOKUBETUKAKUNIN);
                }
                else {
                    siMktKnrRendouLayoutFile.setIfcKakuninsakikbn(TeisuuSiharai.KAKSAKIKBNMKTKNR_SIS);
                    siMktKnrRendouLayoutFile.setIfcKakuninkbn(TeisuuSiharai.KAKKBNMKTKNR_TUUJYOUKAKUNIN);
                }
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
                siMktKnrRendouLayoutFile.setIfcKijyunymd(skJiyuu.getSibouymd());
                siMktKnrRendouLayoutFile.setIfcSyoruiukeymd(sk.getSyoruiukeymd());
                siMktKnrRendouLayoutFile.setIfcIraimotocomment("");
                if (C_UmuKbn.ARI.eq(umuKbn)) {
                    siMktKnrRendouLayoutFile.setIfcHubidojikakuninumu(TeisuuSiharai.HBDZKKNNUMMKTKNR_ARI);
                }
                else {
                    siMktKnrRendouLayoutFile.setIfcHubidojikakuninumu("");
                }
                siMktKnrRendouLayoutFile.setIfcKyksyameikn(ConvertUtil.toHanAll(siKykKihon.getKyknmkn(), 0, 0));
                siMktKnrRendouLayoutFile.setIfcKyksyameikj(siKykKihon.getKyknmkj());
                siMktKnrRendouLayoutFile.setIfcKeiyakuseiymd(siKykKihon.getKykseiymd());
                siMktKnrRendouLayoutFile.setIfcKykadr(siKykKihon.getTsinadr1kj() + siKykKihon.getTsinadr2kj()
                    + siKykKihon.getTsinadr3kj());
                siMktKnrRendouLayoutFile.setIfcSiteidairimeikn(ConvertUtil.toHanAll(siKykKihon.getSiteidruktnmkn(), 0, 0));
                siMktKnrRendouLayoutFile.setIfcSiteidairimeikj(siKykKihon.getSiteidruktnmkj());
                siMktKnrRendouLayoutFile.setIfcShadr(sk.getTsinadr1kj() + sk.getTsinadr2kj() + sk.getTsinadr3kj());
                siMktKnrRendouLayoutFile.setIfcYno(sk.getTsinyno());
                siMktKnrRendouLayoutFile.setIfcKihontikucd("");
                siMktKnrRendouLayoutFile.setIfcJyouiadr("");
                siMktKnrRendouLayoutFile.setIfcKaiadr(sk.getTsinadr1kj() + sk.getTsinadr2kj() + sk.getTsinadr3kj());
                siMktKnrRendouLayoutFile.setIfcSsyiriskissycd("");
                siMktKnrRendouLayoutFile.setIfcMdhansybetukbn("");
                siMktKnrRendouLayoutFile.setIfcHjntkskhyj("");
                siMktKnrRendouLayoutFile.setIfcKykhknhyj("");
                ttdkRirekiList.add(siMktKnrRendouLayoutFile);
                totalCnt++;

            }

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_KAKUNINLIST, ttdkRirekiList, true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(totalCnt), kinou.getKinouNm()));
        }
    }
}
