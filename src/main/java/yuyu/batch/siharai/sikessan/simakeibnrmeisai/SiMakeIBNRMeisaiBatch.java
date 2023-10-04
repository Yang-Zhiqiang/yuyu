package yuyu.batch.siharai.sikessan.simakeibnrmeisai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
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
import yuyu.def.siharai.file.csv.SiIBNRMeisaiFLayoutFile;
import yuyu.def.siharai.file.csv.SiIBNRMeisaiLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SiRireki;
import yuyu.def.siharai.sorter.SortJT_Sk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 保険金給付金支払 決算 IBNR備金明細表作成
 */
public class SiMakeIBNRMeisaiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private final int FILE_SAVE_MAX_LIST_COUNT = 5000;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        BizDate uketukeymd = BizDate.valueOf(String.valueOf(syoriYmd.getYear() - 5) + "0401");

        BizDate hasseiymd = BizDate.valueOf(String.valueOf(syoriYmd.getYear() - 6) + "0401");

        BizDate zennendoKsnbiymd = BizDate.valueOf(syoriYmd.getYear() + "0331");

        List<BikinOutputBean> meisaiLst = new ArrayList<>();

        List<SiIBNRMeisaiLayoutFile> dataLayoutBeanLst = new ArrayList<>();

        List<SiIBNRMeisaiFLayoutFile> ibnrMeisaiFLayoutBeanLst = new ArrayList<>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

        BizDate denSimebiDate = setDenSimebi.exec(syoriYmd);

        if (BizDateUtil.compareYmd(syoriYmd, denSimebiDate) == BizDateUtil.COMPARE_LESSER) {
            meisaiLst.addAll(bikinMeisaiOutputBySiharai(uketukeymd, hasseiymd, zennendoKsnbiymd));
        }

        if (BizDateUtil.compareYmd(syoriYmd, denSimebiDate) == BizDateUtil.COMPARE_EQUAL) {
            meisaiLst.addAll(bikinMeisaiOutputBySiharai(uketukeymd, hasseiymd, zennendoKsnbiymd));
            meisaiLst.addAll(bikinMeisaiOutputByBikin(uketukeymd, hasseiymd, zennendoKsnbiymd));
        }

        if (meisaiLst.size() > 0) {

            dataLayoutBeanLst.addAll(setDataLayoutBean(meisaiLst));

        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_IBNRMEISAI, dataLayoutBeanLst, true);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        if (meisaiLst.size() > 0) {
            ibnrMeisaiFLayoutBeanLst = setIBNRMeisaiFDataLayoutBean(meisaiLst);

            int fileRenno = 1;

            List<List<SiIBNRMeisaiFLayoutFile>> bunkatuLst = Lists.partition(ibnrMeisaiFLayoutBeanLst,
                FILE_SAVE_MAX_LIST_COUNT);

            for (List<SiIBNRMeisaiFLayoutFile> list : bunkatuLst) {
                errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_IBNRMEISAIF, list, true,
                    String.valueOf(fileRenno));
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
                }
                fileRenno = fileRenno + 1;
            }

        } else {
            errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_IBNRMEISAIF, ibnrMeisaiFLayoutBeanLst, true, "1");
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }
        }

        batchLogger
        .info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(meisaiLst.size()), kinou.getKinouNm()));
    }

    private List<BikinOutputBean> bikinMeisaiOutputBySiharai(BizDate pUketukeymd, BizDate pHasseiymd,
        BizDate pZennendoKsnbiymd) {

        List<BikinOutputBean> bikinOutputBeanLst = new ArrayList<>();

        try (
            ExDBResults<JT_SkKihon> skKihonLst =
            siharaiDomManager.getSkKihonsBySeikyuusyubetuSaisateikbnSiboukaritrkymdShrkekkakbns(
                C_SeikyuuSyubetu.SB, C_SaisateiKbn.BLNK, pUketukeymd, pZennendoKsnbiymd, C_ShrKekkaKbn.SHR, C_ShrKekkaKbn.ITIBU_NENKIN);) {

            bikinOutputBeanLst.addAll(setBikinMeisaiInformationBySiharai(skKihonLst, pHasseiymd, pZennendoKsnbiymd));

            return bikinOutputBeanLst;
        }
    }

    private List<BikinOutputBean> bikinMeisaiOutputByBikin(BizDate pUketukeymd, BizDate pHasseiymd,
        BizDate pZennendoKsnbiymd) {

        List<BikinOutputBean> bikinOutputBeanLst = new ArrayList<>();

        try (

            ExDBResults<JT_SiBikinkanri> siBikinkanriLst = siharaiDomManager
            .getSiBikinkanrisByBknkktymdItems(pUketukeymd, pHasseiymd,
                pZennendoKsnbiymd, C_BknrigiKbn.BLNK);) {

            bikinOutputBeanLst.addAll(setBikinMeisaiInformationByBikin(siBikinkanriLst));

            return bikinOutputBeanLst;
        }
    }

    private List<BikinOutputBean> setBikinMeisaiInformationBySiharai(
        ExDBResults<JT_SkKihon> pEntityLst, BizDate pHasseiymd, BizDate pZennendoKsnbiymd) {
        List<BikinOutputBean> bikinOutputBeanLst = new ArrayList<>();

        String syutokumotoShr = MessageUtil.getMessage(MessageId.IJW1105);

        for (JT_SkKihon skKihon : pEntityLst) {
            List<JT_Sk> skLst = skKihon.getSks();
            SortJT_Sk sortSk = SWAKInjector.getInstance(SortJT_Sk.class);
            JT_Sk sk = sortSk.OrderJT_SkByPkDesc(skLst).get(0);

            List<JT_SiRireki> siRirekiLst = skKihon.getSiRirekis();
            SortJT_SiRireki sortSiRireki = SWAKInjector.getInstance(SortJT_SiRireki.class);
            JT_SiRireki siRireki = sortSiRireki.OrderJT_SiRirekiByPkDesc(siRirekiLst).get(0);

            if (pZennendoKsnbiymd.compareTo(siRireki.getTyakkinymd()) >= 0) {

                List<JT_SkJiyuu> skJiyuuLst = sk.getSkJiyuusBySibouymd(pHasseiymd);

                for (JT_SkJiyuu skJiyuu : skJiyuuLst) {
                    List<JT_SiDetail> siDetailLst = skJiyuu.getSiDetails();

                    for (JT_SiDetail siDetail : siDetailLst) {
                        BizCurrency kingk = BizCurrency.optional();
                        BizCurrency kingkgk = BizCurrency.optional();

                        if (C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {
                            kingk = siDetail.getKyhkg();
                            kingkgk = BizCurrency.valueOf(0);
                        }
                        else {
                            kingk = siDetail.getYenkyhgk();
                            kingkgk = siDetail.getKyhkg();
                        }

                        if (kingk.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) > 0) {
                            BikinOutputBean bikinOutputBean = SWAKInjector.getInstance(BikinOutputBean.class);

                            String hasseiNendo = nendoProcess(skJiyuu.getSibouymd());
                            String uketukeNendo = uketukenendoProcess(skKihon.getSiboukaritrkymd());
                            String kyktuukaSort = kyktuukaSort(sk.getKyktuukasyu());
                            bikinOutputBean.setHasseinendo(hasseiNendo);
                            bikinOutputBean.setKyktuuka(sk.getKyktuukasyu());
                            bikinOutputBean.setKyktuukasort(kyktuukaSort);
                            bikinOutputBean.setKingk(kingk);
                            bikinOutputBean.setKingkgk(kingkgk);
                            bikinOutputBean.setHokenkinsyuruikbn(siDetail.getHokenkinsyuruikbn());
                            bikinOutputBean.setUketukenendo(uketukeNendo);
                            bikinOutputBean.setSyono(sk.getSyono());
                            bikinOutputBean.setSyouhncd(siDetail.getSyouhncd());
                            bikinOutputBean.setShrkekkakbn(skKihon.getShrkekkakbn());
                            if (C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {
                                bikinOutputBean.setYenknsnrate(BizNumber.ZERO);
                            } else {
                                bikinOutputBean.setYenknsnrate(sk.getShrkwsrate());
                            }
                            bikinOutputBean.setSibouymd(skJiyuu.getSibouymd());
                            bikinOutputBean.setSiboukariymd(skKihon.getSiboukaritrkymd());
                            bikinOutputBean.setShrsyoriymd(siRireki.getShrsyoriymd());
                            bikinOutputBean.setTyakkinymd(siRireki.getTyakkinymd());
                            bikinOutputBean.setSyoruiukeymd(sk.getSyoruiukeymd());
                            bikinOutputBean.setHubikanryouymd(sk.getHubikanryouymd());
                            bikinOutputBean.setSyutokumoto(syutokumotoShr);

                            bikinOutputBeanLst.add(bikinOutputBean);
                        }
                    }
                }
            }
        }
        return bikinOutputBeanLst;
    }

    private List<BikinOutputBean> setBikinMeisaiInformationByBikin(ExDBResults<JT_SiBikinkanri> pExDBResults) {
        List<BikinOutputBean> bikinOutputBeanLst = new ArrayList<>();

        String syutokumotoBikin = MessageUtil.getMessage(MessageId.IJW1106);

        for (JT_SiBikinkanri biBikinkanri : pExDBResults) {
            BikinOutputBean bikinOutputBean = SWAKInjector.getInstance(BikinOutputBean.class);

            BizCurrency kingk = BizCurrency.optional();
            BizCurrency kingkgk = BizCurrency.optional();

            if (C_Tuukasyu.JPY.eq(biBikinkanri.getKyktuukasyu())) {
                kingk = biBikinkanri.getBkngk();
                kingkgk = BizCurrency.valueOf(0);
            }
            else {
                kingk = biBikinkanri.getBkngk();
                kingkgk = biBikinkanri.getShrgk();
            }

            if (biBikinkanri.getBkngk().compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) > 0) {
                String hasseiNendo = nendoProcess(biBikinkanri.getCalckijyunymd());
                String uketukeNendo = uketukenendoProcess(biBikinkanri.getBknkktymd());
                String kyktuukaSort = kyktuukaSort(biBikinkanri.getKyktuukasyu());
                bikinOutputBean.setHasseinendo(hasseiNendo);
                bikinOutputBean.setKyktuuka(biBikinkanri.getKyktuukasyu());
                bikinOutputBean.setKyktuukasort(kyktuukaSort);
                bikinOutputBean.setKingk(kingk);
                bikinOutputBean.setKingkgk(kingkgk);
                bikinOutputBean.setHokenkinsyuruikbn(biBikinkanri.getHokenkinsyuruikbn());
                bikinOutputBean.setUketukenendo(uketukeNendo);
                bikinOutputBean.setSyono(biBikinkanri.getSyono());
                bikinOutputBean.setSyouhncd(biBikinkanri.getSyouhncd());
                bikinOutputBean.setShrkekkakbn(biBikinkanri.getShrkekkakbn());
                if (C_Tuukasyu.JPY.eq(biBikinkanri.getKyktuukasyu())) {
                    bikinOutputBean.setYenknsnrate(BizNumber.ZERO);
                } else {
                    bikinOutputBean.setYenknsnrate(biBikinkanri.getShrkwsrate());
                }
                bikinOutputBean.setSibouymd(biBikinkanri.getCalckijyunymd());
                bikinOutputBean.setSiboukariymd(biBikinkanri.getBknkktymd());
                bikinOutputBean.setShrsyoriymd(biBikinkanri.getShrsyoriymd());
                bikinOutputBean.setTyakkinymd(biBikinkanri.getTyakkinymd());
                bikinOutputBean.setSyoruiukeymd(biBikinkanri.getSyoruiukeymd());
                bikinOutputBean.setHubikanryouymd(biBikinkanri.getHubikanryouymd());
                bikinOutputBean.setSyutokumoto(syutokumotoBikin);

                bikinOutputBeanLst.add(bikinOutputBean);
            }
        }
        return bikinOutputBeanLst;
    }

    private List<SiIBNRMeisaiLayoutFile> setDataLayoutBean(List<BikinOutputBean> pBikinOutputBeanLst) {

        List<SiIBNRMeisaiLayoutFile> siIBNRMeisaiLayoutFileLst = new ArrayList<>();
        String syuruiName = "";
        String key = "";
        C_HokenkinsyuruiKbn hokenkinsyuruiKbn = C_HokenkinsyuruiKbn.BLNK;
        C_Tuukasyu kyktuuka = C_Tuukasyu.BLNK;
        String kyktuukaSort = "";
        String hasseiNendo = "";
        String uketukeNendo = "";
        BizCurrency kingk = BizCurrency.optional();
        BizCurrency kingkgk = BizCurrency.optional();
        String siharaiSyuruiName = "";
        String kyktuukaOut = "";
        String kyktuukaSortTemp = "";
        String hasseiNendoOut = "";
        String hasseiNendoTemp = "";
        C_HokenkinsyuruiKbn hokenkinsyuruiKbnTemp = C_HokenkinsyuruiKbn.BLNK;

        Ordering<BikinOutputBean> ordering = Ordering.from(new Comparator<BikinOutputBean>() {
            @Override
            public int compare(BikinOutputBean o1, BikinOutputBean o2) {

                C_HokenkinsyuruiKbn hokenkinsyuruikbn1 = o1.getHokenkinsyuruikbn();
                C_HokenkinsyuruiKbn hokenkinsyuruikbn2 = o2.getHokenkinsyuruikbn();
                String kyktuukasort1 = o1.getKyktuukasort();
                String kyktuukasort2 = o2.getKyktuukasort();
                String hasseinendo1 = o1.getHasseinendo();
                String hasseinendo2 = o2.getHasseinendo();
                String uketukenendo1 = o1.getUketukenendo();
                String uketukenendo2 = o2.getUketukenendo();

                int result = hokenkinsyuruikbn1.compareTo(hokenkinsyuruikbn2);
                if (result != 0) {
                    return result;
                }

                result = kyktuukasort1.compareTo(kyktuukasort2);
                if (result != 0) {
                    return result;
                }

                result = hasseinendo1.compareTo(hasseinendo2);
                if (result != 0) {
                    return result;
                }

                result = uketukenendo1.compareTo(uketukenendo2);

                return result;
            }
        });

        List<BikinOutputBean> bikinOutputBeanLst = ordering.sortedCopy(pBikinOutputBeanLst);

        for (int i = 0; i < bikinOutputBeanLst.size(); i++) {

            if (i == 0) {
                syuruiName = "保険金";
                key = bikinOutputBeanLst.get(i).getHokenkinsyuruikbn().getValue()
                    + bikinOutputBeanLst.get(i).getKyktuukasort() + bikinOutputBeanLst.get(i).getHasseinendo()
                    + bikinOutputBeanLst.get(i).getUketukenendo();
                hokenkinsyuruiKbn = bikinOutputBeanLst.get(i).getHokenkinsyuruikbn();
                kyktuuka = bikinOutputBeanLst.get(i).getKyktuuka();
                kyktuukaSort = bikinOutputBeanLst.get(i).getKyktuukasort();
                hasseiNendo = bikinOutputBeanLst.get(i).getHasseinendo();
                uketukeNendo = bikinOutputBeanLst.get(i).getUketukenendo();
                kingk = bikinOutputBeanLst.get(i).getKingk();
                kingkgk = bikinOutputBeanLst.get(i).getKingkgk();
            }

            else {
                if (key.equals(bikinOutputBeanLst.get(i).getHokenkinsyuruikbn().getValue()
                    + bikinOutputBeanLst.get(i).getKyktuukasort() + bikinOutputBeanLst.get(i).getHasseinendo()
                    + bikinOutputBeanLst.get(i).getUketukenendo())) {
                    kingk = kingk.add(bikinOutputBeanLst.get(i).getKingk());
                    kingkgk = kingkgk.add(bikinOutputBeanLst.get(i).getKingkgk());
                }

                else {
                    if (siIBNRMeisaiLayoutFileLst.size() > 0) {
                        siharaiSyuruiName = hokenkinsyuruiKbn.getContent();
                        kyktuukaOut = kyktuuka.getContent();
                        hasseiNendoOut = hasseiNendo;
                        if (hokenkinsyuruiKbnTemp.eq(hokenkinsyuruiKbn)) {
                            siharaiSyuruiName = "";
                            if (kyktuukaSortTemp.equals(kyktuukaSort)) {
                                kyktuukaOut = "";
                                if (hasseiNendoTemp.equals(hasseiNendoOut)) {
                                    hasseiNendoOut = "";
                                }
                            }
                        }
                        hokenkinsyuruiKbnTemp = hokenkinsyuruiKbn;
                        kyktuukaSortTemp = kyktuukaSort;
                        hasseiNendoTemp = hasseiNendo;

                    }
                    else {
                        siharaiSyuruiName = hokenkinsyuruiKbn.getContent();
                        kyktuukaOut = kyktuuka.getContent();
                        hasseiNendoOut = hasseiNendo;
                        hokenkinsyuruiKbnTemp = hokenkinsyuruiKbn;
                        kyktuukaSortTemp = kyktuukaSort;
                        hasseiNendoTemp = hasseiNendo;

                    }

                    SiIBNRMeisaiLayoutFile siIBNRMeisaiLayoutFile = SWAKInjector
                        .getInstance(SiIBNRMeisaiLayoutFile.class);
                    siIBNRMeisaiLayoutFile.setIfcSyuruimei(syuruiName);
                    siIBNRMeisaiLayoutFile.setIfcShrsyuruimei(siharaiSyuruiName);
                    siIBNRMeisaiLayoutFile.setIfcKyktuuka(kyktuukaOut);
                    siIBNRMeisaiLayoutFile.setIfcHasseinendo(hasseiNendoOut);
                    siIBNRMeisaiLayoutFile.setIfcUketukenendo(uketukeNendo);
                    siIBNRMeisaiLayoutFile.setIfcShrgk(kingk.toString());
                    if (C_Tuukasyu.JPY.eq(kyktuuka)){
                        siIBNRMeisaiLayoutFile.setIfcGaikashrgk("");
                    }
                    else {
                        siIBNRMeisaiLayoutFile.setIfcGaikashrgk(kingkgk.toString());
                    }

                    siIBNRMeisaiLayoutFileLst.add(siIBNRMeisaiLayoutFile);

                    syuruiName = "";
                    key = bikinOutputBeanLst.get(i).getHokenkinsyuruikbn().getValue()
                        + bikinOutputBeanLst.get(i).getKyktuukasort() + bikinOutputBeanLst.get(i).getHasseinendo()
                        + bikinOutputBeanLst.get(i).getUketukenendo();
                    hokenkinsyuruiKbn = bikinOutputBeanLst.get(i).getHokenkinsyuruikbn();
                    kyktuuka = bikinOutputBeanLst.get(i).getKyktuuka();
                    kyktuukaSort = bikinOutputBeanLst.get(i).getKyktuukasort();
                    hasseiNendo = bikinOutputBeanLst.get(i).getHasseinendo();
                    uketukeNendo = bikinOutputBeanLst.get(i).getUketukenendo();
                    kingk = bikinOutputBeanLst.get(i).getKingk();
                    kingkgk = bikinOutputBeanLst.get(i).getKingkgk();
                }
            }
        }
        if (siIBNRMeisaiLayoutFileLst.size() > 0) {

            siharaiSyuruiName = hokenkinsyuruiKbn.getContent();
            kyktuukaOut = kyktuuka.getContent();
            hasseiNendoOut = hasseiNendo;

            if (hokenkinsyuruiKbnTemp.eq(hokenkinsyuruiKbn)) {
                siharaiSyuruiName = "";
                if (kyktuukaSortTemp.equals(kyktuukaSort)) {
                    kyktuukaOut = "";
                    if (hasseiNendoTemp.equals(hasseiNendoOut)) {
                        hasseiNendoOut = "";
                    }
                }
            }

            SiIBNRMeisaiLayoutFile siIBNRMeisaiLayoutFile = SWAKInjector.getInstance(SiIBNRMeisaiLayoutFile.class);
            siIBNRMeisaiLayoutFile.setIfcSyuruimei(syuruiName);
            siIBNRMeisaiLayoutFile.setIfcShrsyuruimei(siharaiSyuruiName);
            siIBNRMeisaiLayoutFile.setIfcKyktuuka(kyktuukaOut);
            siIBNRMeisaiLayoutFile.setIfcHasseinendo(hasseiNendoOut);
            siIBNRMeisaiLayoutFile.setIfcUketukenendo(uketukeNendo);
            siIBNRMeisaiLayoutFile.setIfcShrgk(kingk.toString());
            if (C_Tuukasyu.JPY.eq(kyktuuka)){
                siIBNRMeisaiLayoutFile.setIfcGaikashrgk("");
            }
            else {
                siIBNRMeisaiLayoutFile.setIfcGaikashrgk(kingkgk.toString());
            }
            siIBNRMeisaiLayoutFileLst.add(siIBNRMeisaiLayoutFile);
        }
        else {
            siharaiSyuruiName = hokenkinsyuruiKbn.getContent();
            kyktuukaOut = kyktuuka.getContent();
            hasseiNendoOut = hasseiNendo;
            SiIBNRMeisaiLayoutFile siIBNRMeisaiLayoutFile = SWAKInjector.getInstance(SiIBNRMeisaiLayoutFile.class);
            siIBNRMeisaiLayoutFile.setIfcSyuruimei(syuruiName);
            siIBNRMeisaiLayoutFile.setIfcShrsyuruimei(siharaiSyuruiName);
            siIBNRMeisaiLayoutFile.setIfcKyktuuka(kyktuukaOut);
            siIBNRMeisaiLayoutFile.setIfcHasseinendo(hasseiNendoOut);
            siIBNRMeisaiLayoutFile.setIfcUketukenendo(uketukeNendo);
            siIBNRMeisaiLayoutFile.setIfcShrgk(kingk.toString());
            if (C_Tuukasyu.JPY.eq(kyktuuka)){
                siIBNRMeisaiLayoutFile.setIfcGaikashrgk("");
            }
            else {
                siIBNRMeisaiLayoutFile.setIfcGaikashrgk(kingkgk.toString());
            }
            siIBNRMeisaiLayoutFileLst.add(siIBNRMeisaiLayoutFile);
        }

        return siIBNRMeisaiLayoutFileLst;
    }

    private String nendoProcess(BizDate pCountedObjYmd) {

        String countedyear = "";

        if (BizDateMD.valueOf(4, 1).compareTo(pCountedObjYmd.getBizDateMD()) > 0) {
            countedyear = pCountedObjYmd.getBizDateY().addYears(-1).toString();
        }

        else {
            countedyear = pCountedObjYmd.getBizDateY().toString();
        }

        return countedyear;
    }

    private String uketukenendoProcess(BizDate pCountedObjYmd) {

        BizDateY uketukeNendo = BizDateY.valueOf(nendoProcess(pCountedObjYmd));

        return uketukeNendo.toString();
    }

    private String kyktuukaSort(C_Tuukasyu pKyktuukasyu) {

        String kyktuukaSort = "0";

        if (C_Tuukasyu.USD.eq(pKyktuukasyu)) {
            kyktuukaSort = "1";
        }
        else if (C_Tuukasyu.AUD.eq(pKyktuukasyu)){
            kyktuukaSort = "2";
        }
        else if (C_Tuukasyu.JPY.eq(pKyktuukasyu)){
            kyktuukaSort = "9";
        }

        return kyktuukaSort;
    }

    private List<SiIBNRMeisaiFLayoutFile> setIBNRMeisaiFDataLayoutBean(List<BikinOutputBean> pBikinOutputBeanLst) {
        List<SiIBNRMeisaiFLayoutFile> list = new ArrayList<>();

        Ordering<BikinOutputBean> ordering = Ordering.from(new Comparator<BikinOutputBean>() {
            @Override
            public int compare(BikinOutputBean o1, BikinOutputBean o2) {

                String syono1 = o1.getSyono();
                String syono2 = o2.getSyono();

                return syono1.compareTo(syono2);
            }
        });
        List<BikinOutputBean> bikinOutputBeanLst = ordering.sortedCopy(pBikinOutputBeanLst);

        for (BikinOutputBean bean : bikinOutputBeanLst) {
            SiIBNRMeisaiFLayoutFile layoutFile = SWAKInjector.getInstance(SiIBNRMeisaiFLayoutFile.class);

            layoutFile.setIfcSyono(bean.getSyono());
            layoutFile.setIfcSyouhncd(bean.getSyouhncd());
            layoutFile.setIfcHknknsyruikbn(bean.getHokenkinsyuruikbn().getValue());
            layoutFile.setIfcShrkekkakbn(bean.getShrkekkakbn());
            layoutFile.setIfcKyktuukasyu(bean.getKyktuuka().getValue());
            if (C_Tuukasyu.JPY.eq(bean.getKyktuuka())) {
                layoutFile.setIfcShrgk(bean.getKingk().toString());
            } else {
                layoutFile.setIfcShrgk(bean.getKingkgk().toString());
            }
            if (C_Tuukasyu.JPY.eq(bean.getKyktuuka())) {
                layoutFile.setIfcBkngk("0");
            } else {
                layoutFile.setIfcBkngk(bean.getKingk().toString());
            }
            layoutFile.setIfcShrkwsrate(bean.getYenknsnrate());
            layoutFile.setIfcSibouymd(bean.getSibouymd());
            layoutFile.setIfcSiboukariymd(bean.getSiboukariymd());
            layoutFile.setIfcShrsyoriymd(bean.getShrsyoriymd());
            layoutFile.setIfcTyakkinymd(bean.getTyakkinymd());
            layoutFile.setIfcSyoruiukeymd(bean.getSyoruiukeymd());
            layoutFile.setIfcHubikanryouymd(bean.getHubikanryouymd());
            layoutFile.setIfcBikou1(bean.getSyutokumoto());

            list.add(layoutFile);
        }
        return list;
    }
}
