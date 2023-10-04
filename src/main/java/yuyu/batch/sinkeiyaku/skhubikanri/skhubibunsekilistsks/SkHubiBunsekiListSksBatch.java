package yuyu.batch.sinkeiyaku.skhubikanri.skhubibunsekilistsks;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.file.csv.SkHubibunsekiLayoutFile;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.result.bean.SkhubibunsekiInfosBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 新契約 不備管理 新契約不備分析リスト作成処理
 */
public class SkHubiBunsekiListSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BatchParam batchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriPreMonYmd = batchParam.getSyoriYmd().getPreviousMonth();

        BizDateYM cyuusyutsuYm = syoriPreMonYmd.getBizDateYM();

        long syoriCount = 0;

        List<SkHubibunsekiLayoutFile> skHubibunsekiLayoutFileLst = Lists.newArrayList();

        try (ExDBResults<SkhubibunsekiInfosBean> skhubibunsekiInfosBeanLst = sinkeiyakuDomManager
            .getSkhubibunsekiInfos(cyuusyutsuYm.getFirstDay(), cyuusyutsuYm.getLastDay())) {

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

            EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
            String skRenrakujikouDecode = null;

            EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);

            for (SkhubibunsekiInfosBean skhubibunsekiInfosBean : skhubibunsekiInfosBeanLst) {

                SkHubibunsekiLayoutFile skHubibunsekiLayoutFile = new SkHubibunsekiLayoutFile();
                HT_MosDairiten htMosDairiten = skhubibunsekiInfosBean.getMosDairiten();
                HT_SkHubiDetail htSkHubiDetail = skhubibunsekiInfosBean.getSkHubiDetail();
                HT_SyoriCTL htSyoriCTL = skhubibunsekiInfosBean.getSyoriCTL();
                HT_SkHubi htSkHubi = skhubibunsekiInfosBean.getSkHubi();
                HM_SkHubiKoumoku hmSkHubiKoumoku = skhubibunsekiInfosBean.getSkHubiKoumoku();
                HM_SkHubiNaiyou hmSkHubiNaiyou = skhubibunsekiInfosBean.getSkHubiNaiyou();
                HM_SkSeibiSijiNaiyou hmSkSeibiSijiNaiyou = skhubibunsekiInfosBean.getSkSeibiSijiNaiyou();
                HT_MosKihon htMosKihon = skhubibunsekiInfosBean.getMosKihon();
                BM_SyouhnZokusei syouhnZokusei = skhubibunsekiInfosBean.getSyouhnZokusei();
                String dairitenNm = "";
                String jimusyoCd = "";

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst= bzGetAgInfo.exec(htMosDairiten.getTratkiagcd());

                for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {

                    if (C_DiritenjyouhouKbn.SHITEIKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                        jimusyoCd = bzGetAgInfoBean.getDrtenJimCd();
                    }
                    else if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                        dairitenNm = bzGetAgInfoBean.getKanjiDairitenNm();
                    }
                }

                skHubibunsekiLayoutFile.setIfcHasinymd(String.valueOf(htSkHubiDetail.getHasinymd()));

                skHubibunsekiLayoutFile.setIfcMosno(htSyoriCTL.getMosno());

                skHubibunsekiLayoutFile.setIfcDrtencd(htMosDairiten.getSyoriCTL().
                    getMosDairitens().get(0).getTratkiagcd());

                skHubibunsekiLayoutFile.setIfcDrtennmkj(dairitenNm);

                skHubibunsekiLayoutFile.setIfcJimusyocd(jimusyoCd);

                skHubibunsekiLayoutFile.setIfcUtidasikikannm1(htSkHubi.getUtdskknnm1kj());

                skHubibunsekiLayoutFile.setIfcUtidasikikannm2(htSkHubi.getUtdskknnm2kj());

                skHubibunsekiLayoutFile.setIfcSkhubikoumokucd(htSkHubiDetail.getSkhubikoumokucd());

                skHubibunsekiLayoutFile.setIfcSkhubikoumoku(hmSkHubiKoumoku.getSkhubikoumoku());

                skHubibunsekiLayoutFile.setIfcSkhubinaiyoucd(htSkHubiDetail.getSkhubinaiyoucd());

                skHubibunsekiLayoutFile.setIfcSkhubinaiyou(hmSkHubiNaiyou.getSkhubinaiyou());

                skHubibunsekiLayoutFile.setIfcSkseibisijinaiyoucd(htSkHubiDetail.getSkseibisijinaiyoucd());

                skHubibunsekiLayoutFile.setIfcSkseibisijinaiyou(hmSkSeibiSijiNaiyou.getSkseibisijinaiyou());

                editSecurityKm.init(htSyoriCTL.getMosno());
                skRenrakujikouDecode = editSecurityKm.decode(htSkHubiDetail.getSkrenrakujikou());
                skHubibunsekiLayoutFile.setIfcSonotarenrakujikou(skRenrakujikouDecode);

                skHubibunsekiLayoutFile.setIfcMosymd(String.valueOf(htMosKihon.getMosymd()));

                skHubibunsekiLayoutFile.setIfcMosnyuuryokuymd(String.valueOf(htSyoriCTL.getMosnrkymd()));

                skHubibunsekiLayoutFile.setIfcToukeiyouhokensyuruikbn(
                    editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(syouhnZokusei, htMosKihon));

                skHubibunsekiLayoutFileLst.add(skHubibunsekiLayoutFile);

                syoriCount = syoriCount + 1;
            }
        }
        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_HUBIBUNSEKILST, skHubibunsekiLayoutFileLst, true);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));
    }

}
