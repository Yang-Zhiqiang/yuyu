package yuyu.batch.siharai.simouside.simakesiboukariuketuke;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SiMakeSbKariUktkKidouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.file.csv.SiMktKnrRendouLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.result.bean.SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;


/**
 * 保険金給付金支払 申出 死亡仮受付情報作成
 */
public class SiMakeSibouKariUketukeBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

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
        BizDate taisyoukknFrom = null;
        BizDate taisyoukknTo = null;
        BizDate saisyuEigyouYmd = bzBatchParam.getSyoriYmd().getBizDateYM().getLastDay().
            getBusinessDay(CHolidayAdjustingMode.NEXT_IN_THIS_MONTH);
        C_SiMakeSbKariUktkKidouKbn siMakeSbKariUktkKidouKbn = C_SiMakeSbKariUktkKidouKbn.BLNK;

        if(syoriYmd.equals(saisyuEigyouYmd)){
            siMakeSbKariUktkKidouKbn = C_SiMakeSbKariUktkKidouKbn.GETUMATU;
        }else{
            siMakeSbKariUktkKidouKbn = C_SiMakeSbKariUktkKidouKbn.GETTYUU;
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));


        if (C_SiMakeSbKariUktkKidouKbn.GETTYUU.eq(siMakeSbKariUktkKidouKbn)) {
            taisyoukknFrom = syoriYmd.addMonths(-2).getBizDateYM().getFirstDay();
            taisyoukknTo = BizDate.valueOf(syoriYmd.addMonths(-2).getBizDateYM(), 15);
        }

        if (C_SiMakeSbKariUktkKidouKbn.GETUMATU.eq(siMakeSbKariUktkKidouKbn)) {
            taisyoukknFrom = BizDate.valueOf(syoriYmd.addMonths(-2).getBizDateYM(), 16);
            taisyoukknTo = syoriYmd.addMonths(-2).getBizDateYM().getLastDay();
        }

        try (ExDBResults<SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean>
        sibouKariuketsukeInfosBeanLst = siharaiDomManager.
        getSibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflg(taisyoukknFrom, taisyoukknTo)) {

            long syoriKensuu = 0;
            List<SiMktKnrRendouLayoutFile> siMktKnrRendouLayoutFilelst = Lists.newArrayList();
            Iterator<SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean> iterator =
                sibouKariuketsukeInfosBeanLst.iterator();

            while (iterator.hasNext()) {
                SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean siboukariuketsukeInfosBean =
                    iterator.next();
                boolean syoriTarget = false;
                List<JT_SkKihon> skKihonLst = siharaiDomManager.
                    getSkKihonsBySyonoSeikyuusyubetu(siboukariuketsukeInfosBean.getJT_SkKihon().getSyono(),
                        C_SeikyuuSyubetu.SB);

                if (skKihonLst.size() == 0) {
                    syoriTarget = true;
                }
                else {
                    List<JT_Sk> sklst = skKihonLst.get(0).getSks();

                    if (sklst.size() == 0) {
                        syoriTarget = true;
                    }
                }

                if (syoriTarget == true) {
                    KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
                    KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
                    keiyakuPrm.setSyono(siboukariuketsukeInfosBean.getJT_SkKihon().getSyono());
                    keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);
                    keiyakuInfoSyutoku.getInfos(keiyakuPrm);
                    List<JT_SiKykKihon> kykKihonLst = keiyakuInfoSyutoku.getKykKihons();
                    JT_SiKykKihon siKykKihon = kykKihonLst.get(0);

                    if (siKykKihon == null) {
                        throw new BizAppException(MessageId.EBS0004, JT_SiKykKihon.TABLE_NAME, JT_SkKihon.SYONO,
                            siboukariuketsukeInfosBean.getJT_SkKihon().getSyono());
                    }

                    SiMktKnrRendouLayoutFile siMktKnrRendouLayoutFile =
                        SWAKInjector.getInstance(SiMktKnrRendouLayoutFile.class);
                    siMktKnrRendouLayoutFile.setIfcAnkenkanrino("");
                    siMktKnrRendouLayoutFile.setIfcSyono(siKykKihon.getSyono());
                    siMktKnrRendouLayoutFile.setIfcIraiymd(syoriYmd);
                    siMktKnrRendouLayoutFile.setIfcIraimotokbn(TeisuuSiharai.IRAIMOTOKBNMKTKNR_YUYU);
                    siMktKnrRendouLayoutFile.setIfcHubisyubetu(TeisuuSiharai.HBSYBTMKTKNR_SIBOUKARIUKETUKE);
                    siMktKnrRendouLayoutFile.setIfcKakuninsakikbn(TeisuuSiharai.KAKSAKIKBNMKTKNR_SEIKYUUSYA);
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
                    siMktKnrRendouLayoutFile.setIfcKijyunymd(siboukariuketsukeInfosBean.getJT_SibouKariuketsuke().
                        getSibouymd());
                    siMktKnrRendouLayoutFile.setIfcSyoruiukeymd(siboukariuketsukeInfosBean.getJT_SkKihon().
                        getSiboukaritrkymd());
                    siMktKnrRendouLayoutFile.setIfcIraimotocomment("");
                    siMktKnrRendouLayoutFile.setIfcHubidojikakuninumu("");
                    siMktKnrRendouLayoutFile.setIfcKyksyameikn(ConvertUtil.toHanAll(siKykKihon.getKyknmkn(), 0, 0));
                    siMktKnrRendouLayoutFile.setIfcKyksyameikj(siKykKihon.getKyknmkj());
                    siMktKnrRendouLayoutFile.setIfcKeiyakuseiymd(siKykKihon.getKykseiymd());
                    siMktKnrRendouLayoutFile.setIfcKykadr(siKykKihon.getTsinadr1kj() + siKykKihon.getTsinadr2kj() +
                        siKykKihon.getTsinadr3kj());
                    siMktKnrRendouLayoutFile.setIfcSiteidairimeikn(ConvertUtil.toHanAll(siKykKihon.getSiteidruktnmkn(), 0, 0));
                    siMktKnrRendouLayoutFile.setIfcSiteidairimeikj(siKykKihon.getSiteidruktnmkj());
                    siMktKnrRendouLayoutFile.setIfcShadr("");
                    siMktKnrRendouLayoutFile.setIfcYno("");
                    siMktKnrRendouLayoutFile.setIfcKihontikucd("");
                    siMktKnrRendouLayoutFile.setIfcJyouiadr("");
                    siMktKnrRendouLayoutFile.setIfcKaiadr("");
                    siMktKnrRendouLayoutFile.setIfcSsyiriskissycd("");
                    siMktKnrRendouLayoutFile.setIfcMdhansybetukbn("");
                    siMktKnrRendouLayoutFile.setIfcHjntkskhyj("");
                    siMktKnrRendouLayoutFile.setIfcKykhknhyj("");

                    siMktKnrRendouLayoutFilelst.add(siMktKnrRendouLayoutFile);

                    syoriKensuu++;
                }
            }

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_SBKARIUKEINFO,
                siMktKnrRendouLayoutFilelst, true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu),
                kinou.getKinouNm()));
        }
    }
}
