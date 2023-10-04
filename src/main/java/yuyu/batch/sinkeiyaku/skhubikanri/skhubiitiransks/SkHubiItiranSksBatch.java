package yuyu.batch.sinkeiyaku.skhubikanri.skhubiitiransks;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.skhubikanri.skhubiitiransks.dba.SkHubiInfoBean;
import yuyu.batch.sinkeiyaku.skhubikanri.skhubiitiransks.dba.SkHubiItiranSksDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_LastSyoriymdKanriKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_LastSyoriYMDKanri;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.file.csv.SkTougetuHassinHubiLayoutFile;
import yuyu.def.sinkeiyaku.file.excel.SkShopTeikyouHubiLayoutFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 新契約 不備管理 新契約不備一覧作成
 */
public class SkHubiItiranSksBatch implements Batch {

    private static final String START_HUGOU = "◆";

    private static final String KAIGYOUCD  = "\r\n";

    private static final int BNWARI_KETASUU = 450;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private SkHubiItiranSksDao skHubiItiranSksDao;

    @Inject
    private BizDomManager bizDomManager;

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

        BizDate lastSyoriYMD = null;

        BT_LastSyoriYMDKanri lastSyoriYMDKanri = bizDomManager.getLastSyoriYMDKanri(C_LastSyoriymdKanriKbn.SKHUBIITIRANSKS);
        if (lastSyoriYMDKanri != null) {
            lastSyoriYMD = lastSyoriYMDKanri.getLastsyoriymd();
        }

        BizDate syoriFirstDay = syoriYmd.getBizDateYM().getFirstDay();

        List<SkTougetuHassinHubiLayoutFile> skTougetuhassinhubiLst = Lists.newArrayList();
        List<SkShopTeikyouHubiLayoutFile> skShopteikyouhubiLst = Lists.newArrayList();
        long syoriCntTougetuhassin = 0;
        long syoriCntShopteikyou = 0;

        try(ExDBResults<SkHubiInfoBean> hubiInfoBeanLst =
            skHubiItiranSksDao.getSkHubiInfo(syoriFirstDay, syoriYmd)) {

            int renban = 1;
            String mosnoMei = "";
            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
            String skRenrakujikouDecode = null;

            for (SkHubiInfoBean hasinsumihubiInfoBean : hubiInfoBeanLst) {

                HT_MosDairiten htMosDairiten = hasinsumihubiInfoBean.getMosDairiten();
                HT_SkHubiDetail htSkHubiDetail = hasinsumihubiInfoBean.getSkHubiDetail();
                HT_SyoriCTL htSyoriCTL = hasinsumihubiInfoBean.getSyoriCTL();
                HT_SkHubi htSkHubi = hasinsumihubiInfoBean.getSkHubi();
                HM_SkHubiKoumoku hmSkHubiKoumoku = hasinsumihubiInfoBean.getSkHubiKoumoku();
                HM_SkHubiNaiyou hmSkHubiNaiyou = hasinsumihubiInfoBean.getSkHubiNaiyou();
                HM_SkSeibiSijiNaiyou hmSkSeibiSijiNaiyou = hasinsumihubiInfoBean.getSkSeibiSijiNaiyou();
                HT_MosKihon htMosKihon = hasinsumihubiInfoBean.getMosKihon();
                BM_SyouhnZokusei syouhnZokusei = hasinsumihubiInfoBean.getSyouhnZokusei();
                Boolean hubiNaiyouMsgBnwarFlag = false;

                String dairitenNm = "";
                String jimusyoCd = "";
                String drtenTrkNo = "";

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst= bzGetAgInfo.exec(htMosDairiten.getTratkiagcd());

                for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {

                    if (C_DiritenjyouhouKbn.SHITEIKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                        jimusyoCd = bzGetAgInfoBean.getDrtenJimCd();
                    }

                    else if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                        dairitenNm = bzGetAgInfoBean.getKanjiDairitenNm();
                        drtenTrkNo = bzGetAgInfoBean.getDrtentrkno();
                    }
                }

                skRenrakujikouDecode = EditSecurityKm.getDecodeData(
                    htSyoriCTL.getMosno(), htSkHubiDetail.getSkrenrakujikou());

                SkTougetuHassinHubiLayoutFile skTougetuHassinHubiLayoutFile = new SkTougetuHassinHubiLayoutFile();
                EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);

                skTougetuHassinHubiLayoutFile.setIfcHasinymd(String.valueOf(htSkHubiDetail.getHasinymd()));
                skTougetuHassinHubiLayoutFile.setIfcMosno(htSyoriCTL.getMosno());
                skTougetuHassinHubiLayoutFile.setIfcDrtencd(htMosDairiten.getTratkiagcd());
                skTougetuHassinHubiLayoutFile.setIfcJimusyocd(jimusyoCd);
                skTougetuHassinHubiLayoutFile.setIfcDrtennmkj(dairitenNm);
                skTougetuHassinHubiLayoutFile.setIfcUtidasikikannm1(htSkHubi.getUtdskknnm1kj());
                skTougetuHassinHubiLayoutFile.setIfcUtidasikikannm2(htSkHubi.getUtdskknnm2kj());
                skTougetuHassinHubiLayoutFile.setIfcSkhubikoumokucd(htSkHubiDetail.getSkhubikoumokucd());
                skTougetuHassinHubiLayoutFile.setIfcSkhubikoumoku(hmSkHubiKoumoku.getSkhubikoumoku());
                skTougetuHassinHubiLayoutFile.setIfcSkhubinaiyoucd(htSkHubiDetail.getSkhubinaiyoucd());
                skTougetuHassinHubiLayoutFile.setIfcSkhubinaiyou(hmSkHubiNaiyou.getSkhubinaiyou());
                skTougetuHassinHubiLayoutFile.setIfcSkseibisijinaiyoucd(htSkHubiDetail.getSkseibisijinaiyoucd());
                skTougetuHassinHubiLayoutFile.setIfcSkseibisijinaiyou(hmSkSeibiSijiNaiyou.getSkseibisijinaiyou());
                skTougetuHassinHubiLayoutFile.setIfcSonotarenrakujikou(skRenrakujikouDecode);
                skTougetuHassinHubiLayoutFile.setIfcMosymd(String.valueOf(htMosKihon.getMosymd()));
                skTougetuHassinHubiLayoutFile.setIfcMosnyuuryokuymd(String.valueOf(htSyoriCTL.getMosnrkymd()));
                skTougetuHassinHubiLayoutFile.setIfcToukeiyouhokensyuruikbn(
                    editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(syouhnZokusei, htMosKihon));
                skTougetuHassinHubiLayoutFile.setIfcSkeijimukbn(htSyoriCTL.getSkeijimukbn().getContent());
                skTougetuHassinHubiLayoutFile.setIfcSeiritukbn(htSyoriCTL.getSeiritukbn().getContent());
                skTougetuHassinHubiLayoutFile.setIfcKaisyouymd(htSkHubiDetail.getKaisyouymd());

                skTougetuhassinhubiLst.add(skTougetuHassinHubiLayoutFile);

                syoriCntTougetuhassin = syoriCntTougetuhassin + 1;

                if (C_SkeijimuKbn.SHOP.eq(htSyoriCTL.getSkeijimukbn()) &&
                    BizDateUtil.compareYmd(lastSyoriYMD, htSkHubiDetail.getHasinymd()) == BizDateUtil.COMPARE_LESSER &&
                    (BizDateUtil.compareYmd(htSkHubiDetail.getHasinymd(), syoriYmd) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(htSkHubiDetail.getHasinymd(), syoriYmd) == BizDateUtil.COMPARE_EQUAL)) {

                    StringBuffer hubiNaiyouMsg = new StringBuffer();
                    StringBuffer hubiNaiyouMsg2 = new StringBuffer();

                    if (skRenrakujikouDecode.length() > BNWARI_KETASUU) {
                        hubiNaiyouMsgBnwarFlag = true;

                        hubiNaiyouMsg.append(START_HUGOU);
                        hubiNaiyouMsg.append(hmSkHubiKoumoku.getSkhubikoumoku());
                        hubiNaiyouMsg.append(KAIGYOUCD);
                        hubiNaiyouMsg.append(KAIGYOUCD);
                        hubiNaiyouMsg.append(skRenrakujikouDecode.substring(0, BNWARI_KETASUU));

                        hubiNaiyouMsg2.append(START_HUGOU);
                        hubiNaiyouMsg2.append(hmSkHubiKoumoku.getSkhubikoumoku());
                        hubiNaiyouMsg2.append(KAIGYOUCD);
                        hubiNaiyouMsg2.append(KAIGYOUCD);
                        hubiNaiyouMsg2.append(skRenrakujikouDecode.substring(BNWARI_KETASUU));
                    }
                    else {
                        hubiNaiyouMsg.append(START_HUGOU);
                        hubiNaiyouMsg.append(hmSkHubiKoumoku.getSkhubikoumoku());
                        hubiNaiyouMsg.append(KAIGYOUCD);
                        hubiNaiyouMsg.append(KAIGYOUCD);
                        hubiNaiyouMsg.append(skRenrakujikouDecode);
                    }

                    if (BizUtil.isBlank(mosnoMei)) {
                        mosnoMei = htSyoriCTL.getMosno();
                    }
                    else if (!mosnoMei.equals(htSyoriCTL.getMosno())) {
                        renban = 1;
                        mosnoMei = htSyoriCTL.getMosno();
                    }
                    else {
                        renban = renban + 1;
                    }

                    SkShopTeikyouHubiLayoutFile skShopTeikyouHubiLayoutFile = new SkShopTeikyouHubiLayoutFile();

                    skShopTeikyouHubiLayoutFile.setIfeMosno(htSyoriCTL.getMosno());
                    skShopTeikyouHubiLayoutFile.setIfeDrtentrkno(drtenTrkNo);
                    skShopTeikyouHubiLayoutFile.setIfeJimusyocd(jimusyoCd);
                    skShopTeikyouHubiLayoutFile.setIfeHubinaiyoumsg(hubiNaiyouMsg.toString());
                    skShopTeikyouHubiLayoutFile.setIfeHubihanmeiymd(String.valueOf(htSkHubiDetail.getHasinymd()));
                    skShopTeikyouHubiLayoutFile.setIfeRenno(renban);
                    skShopTeikyouHubiLayoutFile.setIfeDrtencd(htMosDairiten.getOyadrtencd());

                    skShopteikyouhubiLst.add(skShopTeikyouHubiLayoutFile);

                    if (hubiNaiyouMsgBnwarFlag) {

                        renban = renban + 1;

                        SkShopTeikyouHubiLayoutFile skShopTeikyouHubiLayoutFile2 = new SkShopTeikyouHubiLayoutFile();

                        BeanUtil.copyProperties(skShopTeikyouHubiLayoutFile2, skShopTeikyouHubiLayoutFile);

                        skShopTeikyouHubiLayoutFile2.setIfeHubinaiyoumsg(hubiNaiyouMsg2.toString());
                        skShopTeikyouHubiLayoutFile2.setIfeRenno(renban);

                        skShopteikyouhubiLst.add(skShopTeikyouHubiLayoutFile2);
                    }

                    syoriCntShopteikyou = syoriCntShopteikyou + 1;
                }
            }
        }

        if (lastSyoriYMDKanri == null) {
            lastSyoriYMDKanri = new BT_LastSyoriYMDKanri();

            lastSyoriYMDKanri.setLastsyoriymdkanrikbn(C_LastSyoriymdKanriKbn.SKHUBIITIRANSKS);
            lastSyoriYMDKanri.setLastsyoriymd(syoriYmd);

            BizPropertyInitializer.initialize(lastSyoriYMDKanri);
            bizDomManager.insert(lastSyoriYMDKanri);

        }
        else {
            lastSyoriYMDKanri.setLastsyoriymd(syoriYmd);
            bizDomManager.update(lastSyoriYMDKanri);
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_TOUGETUHASINHUBIITIRAN, skTougetuhassinhubiLst, true);
        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_SHOPTEIKYOUHUBIITIRAN, skShopteikyouhubiLst, true);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(syoriCntTougetuhassin), C_FileSyuruiCdKbn.SK_TOUGETUHASINHUBIITIRAN.getContent()));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(syoriCntShopteikyou), C_FileSyuruiCdKbn.SK_SHOPTEIKYOUHUBIITIRAN.getContent()));
    }
}
