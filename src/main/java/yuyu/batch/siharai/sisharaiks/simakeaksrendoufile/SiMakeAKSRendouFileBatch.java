package yuyu.batch.siharai.sisharaiks.simakeaksrendoufile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetImage;
import yuyu.common.biz.bzcommon.BzGetImageOutputBean;
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsOutBean;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.ZtrhyousiInfoBySyoruiCdBean;
import yuyu.def.biz.sorter.SortBT_GyoumuKouteiInfo;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.JT_AksrendouzumiSkKykInfo;
import yuyu.def.db.entity.JT_AksrendouzumiSyoruiImg;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.file.fixedlength.SiSkKykInfoHeaderLayoutFile;
import yuyu.def.siharai.file.fixedlength.SiSkKykInfoMeisaiLayoutFile;
import yuyu.def.siharai.file.fixedlength.SiSkKykInfoTrailerLayoutFile;
import yuyu.def.siharai.file.fixedlength.SiSyrImageInfoHeaderLayoutFile;
import yuyu.def.siharai.file.fixedlength.SiSyrImageInfoMeisaiLayoutFile;
import yuyu.def.siharai.file.fixedlength.SiSyrImageInfoTrailerLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 保険金給付金支払 支払後検証 AKS連動ファイル作成
 */
public class SiMakeAKSRendouFileBatch implements Batch {

    private final String KENSUUSYORUI_PDF = ".pdf";

    private final String FILEEXT_TIF = ".tif";

    private final int OUTCOUNT = 9999;

    private final int OUTCOUNT_PAGE = 99;

    private final String AKS_HOKENKINSYURUIKBN = "01";

    private final String HYOURI = "0";

    private final String HYOUSIKBN_BLNK = " ";

    private final String HYOUSIKBN_HYOUSI = "1";

    private final String SAISATEIKBN_SAISATEIIGAI = "1";

    private final String SAISATEIKBN_SAISATEI = "2";

    private final String SAIGAIHOSYOUARIHYJ_NONE = "0";

    private final String SAIGAIHOSYOUARIHYJ = "1";

    private final String SIINSYURUIKBN_BSSS = "01";

    private final String SIINSYURUIKBN_KTJK = "02";

    private final String SIINSYURUIKBN_TENTOU = "03";

    private final String SIINSYURUIKBN_DKS = "04";

    private final String SIINSYURUIKBN_KKOKS = "05";

    private final String SIINSYURUIKBN_TSK = "06";

    private final String SIINSYURUIKBN_TDK = "07";

    private final String SIINSYURUIKBN_SONOTAFR = "08";

    private final String SIINSYURUIKBN_JS = "09";

    private final String SIINSYURUIKBN_TST = "10";

    private final String SIINSYURUIKBN_SONOTAFS = "11";

    private final String SIINSYURUIKBN_FSS = "12";

    private final String HHKNHONNINSAISIKBN = "0";

    private final String SHRHUSHRKBN = "1";

    private final String SHRHUSHRKBN_NONE = "2";

    private final String SHRKEKKAKBN = "1";

    private final String SHRKEKKAKBN_SIBOUS_NONE = "3";

    private final String SHRKEKKAKBN_NONE = "6";

    private final String BYOUMEI_CD = "    ";

    private final String LASTRECSIKIBETUSI = "LAST";

    private final String ANKENIMGJYGNTYOUKAHYJ_NONE = "0";

    private final String ANKENIMGJYGNTYOUKAHYJ = "1";

    private final String TIFFHENKANKEKKAKBN = "0";

    private final String TIFFHENKANKEKKAKBN_PDF = "1";

    private final String TIFFHENKAN_JOBCD = "RCB1D000";

    private static final String MAX_NENREI = "99";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SiMakeAKSRendouFileBatchParam siMakeAKSRendouFileBatchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private SortBT_GyoumuKouteiInfo sortBT_GyoumuKouteiInfo;

    @Override
    public BatchParam getParam() {
        return siMakeAKSRendouFileBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = siMakeAKSRendouFileBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));


        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);

        bzGetProcessSummaryInBean.setKouteEndYmdFrom(syoriYmd);

        bzGetProcessSummaryInBean.setKouteEndYmdTo(syoriYmd);

        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.KANRYOU);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        long outkensuuSyorui = 0;

        long allOutkensuuSyorui = 1;

        long outkensuuSeikyuu = 0;

        long allOutkensuuSeikyuu = 1;

        long outkensuuPdf = 0;

        List<SiSyrImageInfoHeaderLayoutFile> siSyrImageInfoHeaderLayoutFileLst = Lists.newArrayList();

        List<SiSyrImageInfoMeisaiLayoutFile> siSyrImageInfoMeisaiLayoutFileLst = Lists.newArrayList();

        List<SiSyrImageInfoTrailerLayoutFile> siSyrImageInfoTrailerLayoutFileLst = Lists.newArrayList();

        List<SiSkKykInfoHeaderLayoutFile> siSkKykInfoHeaderLayoutFileLst = Lists.newArrayList();

        List<SiSkKykInfoMeisaiLayoutFile> siSkKykInfoMeisaiLayoutFileLst = Lists.newArrayList();

        List<SiSkKykInfoTrailerLayoutFile> siSkKykInfoTrailerLayoutFileLst = Lists.newArrayList();

        SiSyrImageInfoHeaderLayoutFile siSyrImageInfoHeaderLayoutFile = SWAKInjector.getInstance
            (SiSyrImageInfoHeaderLayoutFile.class);

        SiSyrImageInfoTrailerLayoutFile siSyrImageInfoTrailerLayoutFile = SWAKInjector.getInstance
            (SiSyrImageInfoTrailerLayoutFile.class);

        SiSkKykInfoHeaderLayoutFile siSkKykInfoHeaderLayoutFile = SWAKInjector.getInstance
            (SiSkKykInfoHeaderLayoutFile.class);

        SiSkKykInfoTrailerLayoutFile siSkKykInfoTrailerLayoutFile = SWAKInjector.getInstance
            (SiSkKykInfoTrailerLayoutFile.class);

        String sysDate = BizDate.getSysDateTimeMilli();

        String space = setSpace(8);

        siSyrImageInfoHeaderLayoutFile.setIffSyoriymd(String.valueOf(syoriYmd));

        siSyrImageInfoHeaderLayoutFile.setIffYobiimginfoheader01(setSpace(492));

        siSkKykInfoHeaderLayoutFile.setIffFilesakuseiymd(String.valueOf(syoriYmd));

        siSkKykInfoHeaderLayoutFile.setIffYobiskkykinfoheader01(setSpace(1292));

        siSyrImageInfoHeaderLayoutFileLst.add(siSyrImageInfoHeaderLayoutFile);

        siSkKykInfoHeaderLayoutFileLst.add(siSkKykInfoHeaderLayoutFile);

        if (bzGetProcessSummaryOutBeanLst.size() != 0) {

            for (BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean : bzGetProcessSummaryOutBeanLst) {

                List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriid
                    (bzGetProcessSummaryOutBean.getKouteiKanriId());

                gyoumuKouteiInfoLst = sortBT_GyoumuKouteiInfo.OrderBT_GyoumuKouteiInfoBySknoAsc(gyoumuKouteiInfoLst);

                List<BzGetImagePropsBean> bzGetImagePropsBeanLst = Lists.newArrayList();

                BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);

                for (BT_GyoumuKouteiInfo gyoumuKouteiInfo : gyoumuKouteiInfoLst) {

                    BzGetImagePropsInBean bzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);

                    bzGetImagePropsInBean.setKouteiKanriId(gyoumuKouteiInfo.getKouteikanriid());

                    BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(bzGetImagePropsInBean);

                    bzGetImagePropsBeanLst.addAll(bzGetImagePropsOutBean.getBzGetImagePropsBeanLst());
                }

                int syoruiimagerendousuu = 0;

                String tiffhenkankekkakbn = TIFFHENKANKEKKAKBN;

                String ankenimgjygntyoukahyj = ANKENIMGJYGNTYOUKAHYJ_NONE;

                String hokenkinsyuruikbn = "";

                JT_SkKihon skKihon = siharaiDomManager.getSkKihon(bzGetProcessSummaryOutBean.getSkNo()
                    , bzGetProcessSummaryOutBean.getSyoNo());

                if (skKihon != null && C_SeikyuuSyubetu.SB.eq(skKihon.getSeikyuusyubetu())) {
                    hokenkinsyuruikbn = AKS_HOKENKINSYURUIKBN;
                }

                for (BzGetImagePropsBean bzGetImagePropsBean : bzGetImagePropsBeanLst) {

                    if (YuyuBizConfig.getInstance().getMyNumberSyoruiCdList().contains(bzGetImagePropsBean.getSyoruiCd().getValue())) {
                        continue;
                    }

                    outkensuuPdf = outkensuuPdf + 1;

                    String pdfFileName = SaibanBiz.getAksRendouImageNo(String.valueOf(syoriYmd));

                    String syoruiNm = bzGetImagePropsBean.getSyoruiCd().getContent();

                    syoruiNm = Strings.padEnd(syoruiNm, 30, '　');

                    BzGetImage bzGetImage = SWAKInjector.getInstance(BzGetImage.class);

                    BzGetImageOutputBean bzGetImageOutputBean = bzGetImage.exec
                        (new String[] { bzGetImagePropsBean.getImageId() }, baseUserInfo.getUser().getUserId());

                    String pdfImageInfoPath = YuyuBizConfig.getInstance().getBatchFileIn() + "/" + TIFFHENKAN_JOBCD
                        + "/" + pdfFileName + KENSUUSYORUI_PDF;

                    try (OutputStream pdfOutputStream = new FileOutputStream(pdfImageInfoPath)) {
                        pdfOutputStream.write(bzGetImageOutputBean.getBzImageInfoBeanList().get(0).getPdfImage());
                    } catch (IOException e) {
                        throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0008, MessageUtil.
                            getMessage(MessageId.IJW1062), pdfImageInfoPath));
                    }

                    int outPage = 0;

                    for (int i = 0; i < Integer.parseInt(bzGetImagePropsBean.getPageCount()); i++) {
                        if (outkensuuSyorui < OUTCOUNT) {

                            if (outPage < OUTCOUNT_PAGE) {

                                outkensuuSyorui = outkensuuSyorui + 1;

                                allOutkensuuSyorui = allOutkensuuSyorui + 1;

                                outPage = outPage + 1;

                                syoruiimagerendousuu = syoruiimagerendousuu + 1;

                                String hyourikbn = HYOURI;

                                String rendouimagerenno = Strings.padStart(String.valueOf(syoruiimagerendousuu), 4, '0');

                                String sOutPage = Strings.padStart(String.valueOf(outPage), 2, '0');

                                String imageFileNm = Strings.padEnd((pdfFileName + sOutPage + FILEEXT_TIF), 30, ' ');

                                String hyousiKbn = HYOUSIKBN_BLNK;

                                if (outPage == 1) {

                                    if (C_UmuKbn.ARI.eq(getHyousiKbn(bzGetImagePropsBean.getSyoruiCd()))) {
                                        hyousiKbn = HYOUSIKBN_HYOUSI;
                                    }
                                }
                                SiSyrImageInfoMeisaiLayoutFile siSyrImageInfoMeisaiLayoutFile = SWAKInjector.
                                    getInstance(SiSyrImageInfoMeisaiLayoutFile.class);

                                siSyrImageInfoMeisaiLayoutFile.setIffSyono(skKihon.getSyono());

                                siSyrImageInfoMeisaiLayoutFile.setIffYuyuskankensikibetuno(skKihon.getSkno());

                                siSyrImageInfoMeisaiLayoutFile.setIffHokenkinsyuruikbn(hokenkinsyuruikbn);

                                siSyrImageInfoMeisaiLayoutFile.setIffRendouimagerenno(rendouimagerenno);

                                siSyrImageInfoMeisaiLayoutFile.setIffYobiimginfomeisai01(setSpace(65));

                                siSyrImageInfoMeisaiLayoutFile.setIffSyoruicd(bzGetImagePropsBean.getSyoruiCd()
                                    .getValue());

                                siSyrImageInfoMeisaiLayoutFile.setIffHyourikbn(hyourikbn);

                                siSyrImageInfoMeisaiLayoutFile.setIffSyoruinm(syoruiNm);

                                siSyrImageInfoMeisaiLayoutFile.setIffImagefilenm(imageFileNm);

                                siSyrImageInfoMeisaiLayoutFile.setIffImagesikibetuno(pdfFileName + sOutPage);

                                siSyrImageInfoMeisaiLayoutFile.setIffHyousikbn(hyousiKbn);

                                siSyrImageInfoMeisaiLayoutFile.setIffYobiimginfomeisai02(setSpace(284));

                                siSyrImageInfoMeisaiLayoutFileLst.add(siSyrImageInfoMeisaiLayoutFile);
                            }
                            else {
                                tiffhenkankekkakbn = TIFFHENKANKEKKAKBN_PDF;
                                break;
                            }
                        }
                        else {
                            ankenimgjygntyoukahyj = ANKENIMGJYGNTYOUKAHYJ;
                            break;
                        }
                    }
                    JT_AksrendouzumiSyoruiImg aksrendouzumiSyoruiImg = new JT_AksrendouzumiSyoruiImg();

                    aksrendouzumiSyoruiImg.setSkno(skKihon.getSkno());

                    aksrendouzumiSyoruiImg.setSyono(skKihon.getSyono());

                    aksrendouzumiSyoruiImg.setImageid(bzGetImagePropsBean.getImageId());

                    aksrendouzumiSyoruiImg.setSyoruiimagepagecnt(Integer.parseInt(bzGetImagePropsBean.getPageCount()));

                    aksrendouzumiSyoruiImg.setSyoruiCd(bzGetImagePropsBean.getSyoruiCd());

                    aksrendouzumiSyoruiImg.setAksrendoupdffilenm(pdfFileName);

                    aksrendouzumiSyoruiImg.setGyoumuKousinKinou(kinou.getKinouId());

                    aksrendouzumiSyoruiImg.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());

                    aksrendouzumiSyoruiImg.setGyoumuKousinTime(sysDate);

                    BizPropertyInitializer.initialize(aksrendouzumiSyoruiImg);

                    siharaiDomManager.insert(aksrendouzumiSyoruiImg);
                }
                KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

                KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

                keiyakuPrm.setSyono(bzGetProcessSummaryOutBean.getSyoNo());
                keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

                keiyakuInfoSyutoku.getInfos(keiyakuPrm);

                List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();

                JT_SiKykKihon siKykKihon = siKykKihonLst.get(0);

                JT_SiKykSyouhn siKykSyouhn = siKykKihon.getSiKykSyouhns().get(0);

                Integer seikyuurirekinoMax = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(skKihon.getSkno(),
                    skKihon.getSyono());

                JT_Sk sk = skKihon.getSkBySeikyuurirekino(seikyuurirekinoMax);

                JT_SkJiyuu skJiyuu = sk.getSkJiyuus().get(0);

                List<JT_SiDetail> siDetailLst = skJiyuu.getSiDetails();

                String saigaihosyouarihyj = issaigaihosyouarihyj(siDetailLst, skKihon.getShrkekkakbn());

                String siinsyuruikbn = getSiinsyuruikbn(hokenkinsyuruikbn, skJiyuu.getGeninkbn());

                Map<String, String> skByoumeiInfoMap = getSkByoumeiInfoMap(skJiyuu, sk.getSiinkbn());

                SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

                String hhknnen = "";

                if (siKykSyouhn.getKykymd() == null || skKihon.getHhknseiymd() == null) {
                    hhknnen = setSpace(2);
                }
                else {
                    hhknnen = String.valueOf(setNenrei.exec(siKykSyouhn.getKykymd(), skKihon.getHhknseiymd()));
                    hhknnen = hoseiNenrei(hhknnen);
                }

                String shrhushrkbn = "";

                String shrkekkakbn = "";

                String shrhushrsyoriymd = String.valueOf(syoriYmd);

                if (C_ShrKekkaKbn.SHR.eq(skKihon.getShrkekkakbn())
                    || C_ShrKekkaKbn.NENKINSHR.eq(skKihon.getShrkekkakbn())
                    || C_ShrKekkaKbn.ITIBU_NENKIN.eq(skKihon.getShrkekkakbn())) {

                    shrhushrkbn = SHRHUSHRKBN;

                    if (SAIGAIHOSYOUARIHYJ.equals(saigaihosyouarihyj)) {
                        shrkekkakbn = SHRKEKKAKBN_SIBOUS_NONE;
                    }
                    else {
                        shrkekkakbn = SHRKEKKAKBN;
                    }
                }
                else if (C_ShrKekkaKbn.HSHR.eq(skKihon.getShrkekkakbn())) {

                    shrhushrkbn = SHRHUSHRKBN_NONE;

                    shrkekkakbn = SHRKEKKAKBN_NONE;

                }

                String syasibouymd = "";

                if (AKS_HOKENKINSYURUIKBN.equals(hokenkinsyuruikbn)) {
                    if (skJiyuu.getSibouymd() == null) {
                        syasibouymd = space;
                    }
                    else {
                        syasibouymd = String.valueOf(skJiyuu.getSibouymd());
                    }
                }

                String kyknen = "";
                if (siKykSyouhn.getKykymd() == null || skKihon.getKykseiymd() == null) {
                    kyknen = setSpace(2);
                }
                else {
                    kyknen = String.valueOf(setNenrei.exec(siKykSyouhn.getKykymd(), skKihon.getKykseiymd()));
                    kyknen = hoseiNenrei(kyknen);
                }

                String hhknhonninsaisikbn = HHKNHONNINSAISIKBN;

                String saisateiKbn;
                if (C_SaisateiKbn.SAISATEI.eq(skKihon.getSaisateikbn())) {
                    saisateiKbn = SAISATEIKBN_SAISATEI;
                }
                else {
                    saisateiKbn = SAISATEIKBN_SAISATEIIGAI;
                }

                String byoumeicd1 = skByoumeiInfoMap.get("0");

                String byoumeicd2 = skByoumeiInfoMap.get("1");

                String byoumeicd3 = skByoumeiInfoMap.get("2");

                String byoumeicd4 = skByoumeiInfoMap.get("3");

                String byoumeicd5 = skByoumeiInfoMap.get("4");

                String byoumeicd6 = skByoumeiInfoMap.get("5");

                String byoumeicd7 = skByoumeiInfoMap.get("6");

                String byoumeicd8 = skByoumeiInfoMap.get("7");

                String byoumeicd9 = skByoumeiInfoMap.get("8");

                String byoumeicd10 = skByoumeiInfoMap.get("9");

                String syoruiimagerendousuuS = Strings.padStart(String.valueOf(syoruiimagerendousuu), 4, '0');

                String hknsyuruinm = Strings.padEnd(siKykSyouhn.getSyouhnnm(), 50, '　');

                String hknsyukigou = siKykSyouhn.getSyouhncd().substring(0, 2);

                String kykadr = siKykKihon.getTsinadr1kj() + siKykKihon.getTsinadr2kj() + siKykKihon.getTsinadr3kj();
                if (kykadr.length() > 62) {
                    kykadr = kykadr.substring(0, 62);
                }
                else {
                    kykadr = Strings.padEnd(kykadr, 62, '　');
                }

                String kyktelno = Strings.padEnd(siKykKihon.getTsintelno(), 15, ' ');

                SiSkKykInfoMeisaiLayoutFile siSkKykInfoMeisaiLayoutFile = SWAKInjector.
                    getInstance(SiSkKykInfoMeisaiLayoutFile.class);

                siSkKykInfoMeisaiLayoutFile.setIffSyono(skKihon.getSyono());

                siSkKykInfoMeisaiLayoutFile.setIffYuyuskankensikibetuno(skKihon.getSkno());

                siSkKykInfoMeisaiLayoutFile.setIffHokenkinsyuruikbn(hokenkinsyuruikbn);

                siSkKykInfoMeisaiLayoutFile.setIffYobiskkykinfomeisai01(setSpace(69));

                siSkKykInfoMeisaiLayoutFile.setIffHhknhonninsaisikbn(hhknhonninsaisikbn);

                siSkKykInfoMeisaiLayoutFile.setIffHhknnmkn(Strings.padEnd(ConvertUtil.toHanAll(skKihon.getHhknnmkn(), 0, 0), 18, ' '));

                siSkKykInfoMeisaiLayoutFile.setIffHhknnmkj(Strings.padEnd(skKihon.getHhknnmkj(), 17, '　'));

                if (skKihon.getHhknseiymd() == null) {
                    siSkKykInfoMeisaiLayoutFile.setIffHhknseiymd(space);
                }
                else {
                    siSkKykInfoMeisaiLayoutFile.setIffHhknseiymd(String.valueOf(skKihon.getHhknseiymd()));
                }

                siSkKykInfoMeisaiLayoutFile.setIffHhknnen(hhknnen);

                siSkKykInfoMeisaiLayoutFile.setIffShrhushrkbn(shrhushrkbn);

                siSkKykInfoMeisaiLayoutFile.setIffSaisateikbn(saisateiKbn);

                siSkKykInfoMeisaiLayoutFile.setIffShrkekkakbn(shrkekkakbn);

                siSkKykInfoMeisaiLayoutFile.setIffShrhushrsyoriymd(shrhushrsyoriymd);

                siSkKykInfoMeisaiLayoutFile.setIffSbymd(syasibouymd);

                siSkKykInfoMeisaiLayoutFile.setIffSiinsyuruikbn(siinsyuruikbn);

                siSkKykInfoMeisaiLayoutFile.setIffByoumeicd1(byoumeicd1);

                siSkKykInfoMeisaiLayoutFile.setIffByoumeicd2(byoumeicd2);

                siSkKykInfoMeisaiLayoutFile.setIffByoumeicd3(byoumeicd3);

                siSkKykInfoMeisaiLayoutFile.setIffByoumeicd4(byoumeicd4);

                siSkKykInfoMeisaiLayoutFile.setIffByoumeicd5(byoumeicd5);

                siSkKykInfoMeisaiLayoutFile.setIffByoumeicd6(byoumeicd6);

                siSkKykInfoMeisaiLayoutFile.setIffByoumeicd7(byoumeicd7);

                siSkKykInfoMeisaiLayoutFile.setIffByoumeicd8(byoumeicd8);

                siSkKykInfoMeisaiLayoutFile.setIffByoumeicd9(byoumeicd9);

                siSkKykInfoMeisaiLayoutFile.setIffByoumeicd10(byoumeicd10);

                siSkKykInfoMeisaiLayoutFile.setIffYobiskkykinfomeisai02(setSpace(276));

                siSkKykInfoMeisaiLayoutFile.setIffSyoruiimagerendousuu(syoruiimagerendousuuS);

                siSkKykInfoMeisaiLayoutFile.setIffAnkenimgjygntyoukahyj(ankenimgjygntyoukahyj);

                siSkKykInfoMeisaiLayoutFile.setIffTiffhenkankekkakbn(tiffhenkankekkakbn);

                siSkKykInfoMeisaiLayoutFile.setIffYobiskkykinfomeisai03(setSpace(94));

                siSkKykInfoMeisaiLayoutFile.setIffHknsyuruinm(hknsyuruinm);

                siSkKykInfoMeisaiLayoutFile.setIffHknsyuruikigou(hknsyukigou);

                siSkKykInfoMeisaiLayoutFile.setIffKyknmkn(Strings.padEnd(ConvertUtil.toHanAll(skKihon.getKyknmkn(), 0, 0), 41, ' '));

                siSkKykInfoMeisaiLayoutFile.setIffKyknmkj(Strings.padEnd(skKihon.getKyknmkj(), 37, '　'));

                if (skKihon.getKykseiymd() == null) {
                    siSkKykInfoMeisaiLayoutFile.setIffKykseiymd(space);
                }
                else {
                    siSkKykInfoMeisaiLayoutFile.setIffKykseiymd(String.valueOf(skKihon.getKykseiymd()));
                }

                siSkKykInfoMeisaiLayoutFile.setIffKyknen(kyknen);

                siSkKykInfoMeisaiLayoutFile.setIffKykadr(kykadr);

                siSkKykInfoMeisaiLayoutFile.setIffKyktelno(kyktelno);

                if (siKykSyouhn.getSknnkaisiymd() == null) {
                    siSkKykInfoMeisaiLayoutFile.setIffSknnkaisiymd(space);
                }
                else {
                    siSkKykInfoMeisaiLayoutFile.setIffSknnkaisiymd(String.valueOf(siKykSyouhn.getSknnkaisiymd()));
                }

                siSkKykInfoMeisaiLayoutFile.setIffSaigaihosyouarihyj(saigaihosyouarihyj);

                siSkKykInfoMeisaiLayoutFile.setIffYobiskkykinfomeisai04(setSpace(325));

                siSkKykInfoMeisaiLayoutFileLst.add(siSkKykInfoMeisaiLayoutFile);

                outkensuuSeikyuu = outkensuuSeikyuu + 1;

                allOutkensuuSeikyuu = allOutkensuuSeikyuu + 1;

                JT_AksrendouzumiSkKykInfo aksrendouzumiSkKykInfo = new JT_AksrendouzumiSkKykInfo();

                aksrendouzumiSkKykInfo.setSkno(skKihon.getSkno());

                aksrendouzumiSkKykInfo.setSyono(skKihon.getSyono());

                aksrendouzumiSkKykInfo.setSeikyuusyubetu(skKihon.getSeikyuusyubetu());

                aksrendouzumiSkKykInfo.setShrkekkakbn(skKihon.getShrkekkakbn());

                aksrendouzumiSkKykInfo.setSyoriYmd(syoriYmd);

                aksrendouzumiSkKykInfo.setSibouymd(skJiyuu.getSibouymd());

                aksrendouzumiSkKykInfo.setGeninkbn(skJiyuu.getGeninkbn());

                aksrendouzumiSkKykInfo.setSyoruiimagerendousuu(syoruiimagerendousuu);

                aksrendouzumiSkKykInfo.setAnkenimgjygntyoukahyj(ankenimgjygntyoukahyj);

                aksrendouzumiSkKykInfo.setTiffhenkankekkakbn(tiffhenkankekkakbn);

                aksrendouzumiSkKykInfo.setGyoumuKousinKinou(kinou.getKinouId());

                aksrendouzumiSkKykInfo.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());

                aksrendouzumiSkKykInfo.setGyoumuKousinTime(sysDate);

                BizPropertyInitializer.initialize(aksrendouzumiSkKykInfo);

                siharaiDomManager.insert(aksrendouzumiSkKykInfo);
            }
        }

        allOutkensuuSyorui = allOutkensuuSyorui + 1;

        allOutkensuuSeikyuu = allOutkensuuSeikyuu + 1;

        siSyrImageInfoTrailerLayoutFile.setIffLastrecsikibetusi(LASTRECSIKIBETUSI);

        siSyrImageInfoTrailerLayoutFile
        .setIffRecordkensuu(Strings.padStart(String.valueOf(allOutkensuuSyorui), 7, '0'));

        siSyrImageInfoTrailerLayoutFile.setIffYobiimginfotrailer01(setSpace(489));


        siSkKykInfoTrailerLayoutFile.setIffLastrecsikibetusi(LASTRECSIKIBETUSI);

        siSkKykInfoTrailerLayoutFile.setIffRecordkensuu(Strings.padStart(String.valueOf(allOutkensuuSeikyuu), 7, '0'));

        siSkKykInfoTrailerLayoutFile.setIffYobikykinfotrailer01(setSpace(1289));

        siSyrImageInfoTrailerLayoutFileLst.add(siSyrImageInfoTrailerLayoutFile);

        siSkKykInfoTrailerLayoutFileLst.add(siSkKykInfoTrailerLayoutFile);

        FileEntityManager fileEntityManager = FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(
            FileType.FIXEDLENGTH);

        String siSyrImageInfoPath = YuyuBizConfig.getInstance().getBatchFileOut() + "/" + TIFFHENKAN_JOBCD + "/"
            + siMakeAKSRendouFileBatchParam.flieNmSiSyrImageInfoMae +
            syoriYmd + siMakeAKSRendouFileBatchParam.flieNmSiSyrImageInfoGo;

        try (OutputStream siSyrImageInfoOutputStream = new FileOutputStream(siSyrImageInfoPath)) {

            fileEntityManager.write(SiSyrImageInfoHeaderLayoutFile.class, siSyrImageInfoHeaderLayoutFileLst,
                siSyrImageInfoOutputStream, false);

            fileEntityManager.write(SiSyrImageInfoMeisaiLayoutFile.class, siSyrImageInfoMeisaiLayoutFileLst,
                siSyrImageInfoOutputStream, false);

            fileEntityManager.write(SiSyrImageInfoTrailerLayoutFile.class, siSyrImageInfoTrailerLayoutFileLst,
                siSyrImageInfoOutputStream, true);

        } catch (IOException e) {
            throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0008, MessageUtil.
                getMessage(MessageId.IJW1064), siSyrImageInfoPath));
        }

        String siSkKykInfoPath = YuyuBizConfig.getInstance().getBatchFileOut() + "/" + TIFFHENKAN_JOBCD + "/"
            + siMakeAKSRendouFileBatchParam.flieNmSiSkKykInfoMae
            + syoriYmd + siMakeAKSRendouFileBatchParam.flieNmSiSkKykInfoGo;

        try (OutputStream siSkKykInfoOutputStream = new FileOutputStream(siSkKykInfoPath)) {

            fileEntityManager.write(SiSkKykInfoHeaderLayoutFile.class, siSkKykInfoHeaderLayoutFileLst,
                siSkKykInfoOutputStream, false);

            fileEntityManager.write(SiSkKykInfoMeisaiLayoutFile.class, siSkKykInfoMeisaiLayoutFileLst,
                siSkKykInfoOutputStream, false);

            fileEntityManager.write(SiSkKykInfoTrailerLayoutFile.class, siSkKykInfoTrailerLayoutFileLst,
                siSkKykInfoOutputStream, true);

        } catch (IOException e) {
            throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0008, MessageUtil.
                getMessage(MessageId.IJW1063), siSkKykInfoPath));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(outkensuuPdf),
            MessageUtil.getMessage(MessageId.IJW1062)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(outkensuuSeikyuu),
            MessageUtil.getMessage(MessageId.IJW1063)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(outkensuuSyorui),
            MessageUtil.getMessage(MessageId.IJW1064)));
    }

    private C_UmuKbn getHyousiKbn(C_SyoruiCdKbn pSyoruiCd) {

        C_UmuKbn umuKbn = C_UmuKbn.NONE;

        ZtrhyousiInfoBySyoruiCdBean ztrhyousiInfoBySyoruiCdBean = bizDomManager.getZtrhyousiInfoBySyoruiCd(pSyoruiCd);

        if (BizUtil.isBlank(ztrhyousiInfoBySyoruiCdBean.getAM_SyoruiZokusei().getTyouhyouid())) {
            umuKbn = C_UmuKbn.ARI;
        }
        return umuKbn;
    }

    private String issaigaihosyouarihyj(List<JT_SiDetail> pSiDetailLst, C_ShrKekkaKbn pShrkekkakbn) {

        String saigaihosyouarihyj = SAIGAIHOSYOUARIHYJ_NONE;

        for (JT_SiDetail siDetail : pSiDetailLst) {

            if (C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.eq(siDetail.getHokenkinsyuruikbn())) {

                if (C_ShrKekkaKbn.HSHR.eq(pShrkekkakbn)) {
                    saigaihosyouarihyj = SAIGAIHOSYOUARIHYJ;
                    break;
                }
                if (BizUtil.isZero(siDetail.getKyhkg())) {
                    saigaihosyouarihyj = SAIGAIHOSYOUARIHYJ;
                }
                else {
                    saigaihosyouarihyj = SAIGAIHOSYOUARIHYJ_NONE;
                    break;
                }
            }
        }
        return saigaihosyouarihyj;
    }

    private String getSiinsyuruikbn(String pHokenkinsyuruikbn, C_GeninKbn pGeninkbn) {

        String siinsyuruikbn = "";

        if (AKS_HOKENKINSYURUIKBN.equals(pHokenkinsyuruikbn)) {

            if (C_GeninKbn.BSSS.eq(pGeninkbn)) {

                siinsyuruikbn = SIINSYURUIKBN_BSSS;
            }
            else if (C_GeninKbn.KTJK.eq(pGeninkbn)) {

                siinsyuruikbn = SIINSYURUIKBN_KTJK;
            }
            else if (C_GeninKbn.TENTOU.eq(pGeninkbn)) {

                siinsyuruikbn = SIINSYURUIKBN_TENTOU;
            }
            else if (C_GeninKbn.DKS.eq(pGeninkbn)) {

                siinsyuruikbn = SIINSYURUIKBN_DKS;
            }
            else if (C_GeninKbn.KKOKS.eq(pGeninkbn)) {

                siinsyuruikbn = SIINSYURUIKBN_KKOKS;
            }
            else if (C_GeninKbn.TSK.eq(pGeninkbn)) {

                siinsyuruikbn = SIINSYURUIKBN_TSK;
            }
            else if (C_GeninKbn.TDK.eq(pGeninkbn)) {

                siinsyuruikbn = SIINSYURUIKBN_TDK;
            }
            else if (C_GeninKbn.SONOTAFR.eq(pGeninkbn)) {

                siinsyuruikbn = SIINSYURUIKBN_SONOTAFR;
            }
            else if (C_GeninKbn.JS.eq(pGeninkbn)) {

                siinsyuruikbn = SIINSYURUIKBN_JS;
            }
            else if (C_GeninKbn.TST.eq(pGeninkbn)) {

                siinsyuruikbn = SIINSYURUIKBN_TST;
            }
            else if (C_GeninKbn.SONOTAFS.eq(pGeninkbn)) {

                siinsyuruikbn = SIINSYURUIKBN_SONOTAFS;
            }
            else if (C_GeninKbn.FSS.eq(pGeninkbn)) {

                siinsyuruikbn = SIINSYURUIKBN_FSS;
            }
        }
        return siinsyuruikbn;
    }

    private Map<String, String> getSkByoumeiInfoMap(JT_SkJiyuu pSkJiyuu, C_SiinKbn pSiinKbn) {

        Map<String, String> skByoumeiInfoMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            skByoumeiInfoMap.put(String.valueOf(i), BYOUMEI_CD);
        }

        if (!C_SiinKbn.SG.eq(pSiinKbn)) {
            List<JT_SkByoumei> skByoumeiLst = pSkJiyuu.getSkByoumeis();

            for (int k = 0; k < skByoumeiLst.size(); k++) {

                String byoumeiCode = skByoumeiLst.get(k).getByoumei().getByoumeicd();
                byoumeiCode = Strings.padEnd(byoumeiCode, 4, ' ');
                skByoumeiInfoMap.put(String.valueOf(k), byoumeiCode);
            }
        }

        return skByoumeiInfoMap;
    }

    private String setSpace(int pCount) {

        String space = "";
        for (int i = 0; i < pCount; i++) {
            space = space + " ";
        }
        return space;
    }

    private String hoseiNenrei(String nenrei) {
        return Integer.parseInt(nenrei) >= 100 ? MAX_NENREI : Strings.padStart(nenrei, 2, '0');
    }
}