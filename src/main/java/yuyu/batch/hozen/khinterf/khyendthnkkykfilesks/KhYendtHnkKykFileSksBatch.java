package yuyu.batch.hozen.khinterf.khyendthnkkykfilesks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khyendthnkkykfilesks.dba.KhYendtHnkKykBean;
import yuyu.batch.hozen.khinterf.khyendthnkkykfilesks.dba.KhYendtHnkKykFileSksDao;
import yuyu.batch.hozen.khinterf.khyendthnkkykfilesks.dba.KykSyouhnHnkmaeBean;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.file.csv.KhYendtHnkKykCsvFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 円建変更契約ファイル作成
 */
public class KhYendtHnkKykFileSksBatch implements Batch {

    private final String SYUHKNKKN_SYUUSIN = "00";

    private final String KYKJYOUTAIKBN_YUUKOUTYUU = "1";

    private final String KYKJYOUTAIKBN_KAIYAKU = "3";

    private final String KYKJYOUTAIKBN_SONOTASYMT = "4";

    private final String MKHSETTI_NINI = "000";

    private final String TUUKACD_JPY = "000";

    private final String TUUKACD_USD = "001";

    private final String TUUKACD_AUD = "002";

    private final int FILE_SAVE_MAX_LIST_COUNT = 2000;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhYendtHnkKykFileSksDao khYendtHnkKykFileSksDao;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        long khYendtHnkKykFileSksCsvFileKensuu = 0;
        List<KhYendtHnkKykCsvFile> khYendtHnkKykCsvFileLst = new ArrayList<>();
        String syoNo = "";

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        List<KhYendtHnkKykBean> khYendtHnkKykBeanList = khYendtHnkKykFileSksDao.getKhYendtHnkKykBeans(syoriYmd);
        for (KhYendtHnkKykBean khYendtHnkKykBean : khYendtHnkKykBeanList) {

            IT_KykKihon kykKihon = khYendtHnkKykBean.getKykKihon();

            if (!syoNo.equals(kykKihon.getSyono())) {

                syoNo = kykKihon.getSyono();
            }
            else {

                continue;
            }

            KykSyouhnHnkmaeBean kykSyouhnHnkmaeBean =
                khYendtHnkKykFileSksDao.getKykSyouhnHnkmaeBeanMaxRennoSyonoSyutkkbn(syoNo, C_SyutkKbn.SYU);

            if (kykSyouhnHnkmaeBean == null) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                    ResourceUtil.getApplicationResources().getString(IT_KykSyouhnHnkmae.TABLE_NAME), syoNo));
            }

            List<IT_NyknJissekiRireki> nyknJissekiRirekiList =
                kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);

            if (nyknJissekiRirekiList.size() == 0) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                    ResourceUtil.getApplicationResources().getString(IT_NyknJissekiRireki.TABLE_NAME), syoNo));
            }

            BizCurrency rsgaku = nyknJissekiRirekiList.get(0).getRsgaku();
            C_Tuukasyu rsTuukaSyu = nyknJissekiRirekiList.get(0).getRstuukasyu();

            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(khYendtHnkKykBean.getSyouhncd(),
                khYendtHnkKykBean.getSyouhnsdno());
            String syouhnNm = syouhnZokusei.getSyouhnnm();
            C_UmuKbn syuusinhknUmu = syouhnZokusei.getSyuusinhknumu();

            String oyadrtenCd = "";
            String drtenCd = "";
            String kydatkioyadrtenCd = "";
            String kydatkidrtenCd = "";

            IT_KykDairiten kykDairiten = kykKihon.getKykDairitenByDrtenrenno(1);

            String drtenCd1 = kykDairiten.getDrtencd();
            C_UmuKbn drtenbunUmu = kykDairiten.getDrtenbunumu();

            List<BzGetAgInfoBean> bzGetAgInfoBeanList1 = bzGetAgInfo.exec(drtenCd1);

            for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanList1) {

                if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                    oyadrtenCd = bzGetAgInfoBean.getDrtenCd();

                }
                else if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                    drtenCd = bzGetAgInfoBean.getDrtenCd();
                }
            }

            if (C_UmuKbn.ARI.eq(drtenbunUmu)) {

                kykDairiten = kykKihon.getKykDairitenByDrtenrenno(2);

                if (kykDairiten != null) {

                    String drtencd2 = kykDairiten.getDrtencd();

                    List<BzGetAgInfoBean> bzGetAgInfoBeanList2 = bzGetAgInfo.exec(drtencd2);

                    for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanList2) {

                        if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                            kydatkioyadrtenCd = bzGetAgInfoBean.getDrtenCd();

                        }

                        else if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                            kydatkidrtenCd = bzGetAgInfoBean.getDrtenCd();
                        }
                    }
                }
            }

            BizNumber tousyoKykjiKawaserate = BizNumber.valueOf(0);
            BizCurrency kihrkmP = BizCurrency.valueOf(0);

            tousyoKykjiKawaserate = getKawaserate(
                kykKihon.getFstpnyknymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                kykSyouhnHnkmaeBean.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.NYUKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            kihrkmP = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                kykSyouhnHnkmaeBean.getHokenryou(),
                tousyoKykjiKawaserate,
                C_HasuusyoriKbn.SUTE);

            String syuhknkkn;

            if (C_UmuKbn.ARI.eq(syuusinhknUmu)) {
                syuhknkkn = SYUHKNKKN_SYUUSIN;
            }
            else {
                syuhknkkn = Strings.padStart(khYendtHnkKykBean.getHknkkn().toString(), 2, '0');
            }

            String kykjyoutaikbn = "";

            if (C_YuukousyoumetuKbn.YUUKOU.eq(khYendtHnkKykBean.getYuukousyoumetukbn())) {
                kykjyoutaikbn = KYKJYOUTAIKBN_YUUKOUTYUU;
            }
            else if (C_YuukousyoumetuKbn.SYOUMETU.eq(khYendtHnkKykBean.getYuukousyoumetukbn())) {
                if (C_Syoumetujiyuu.KAIYAKU.eq(khYendtHnkKykBean.getSyoumetujiyuu())) {
                    kykjyoutaikbn = KYKJYOUTAIKBN_KAIYAKU;
                }
                else {
                    kykjyoutaikbn = KYKJYOUTAIKBN_SONOTASYMT;
                }
            }

            String mokuhyouSetTi;

            if (C_UktkSyoriKbn.MKHGKTTTYENDTHNK.eq(khYendtHnkKykBean.getUktksyorikbn())) {
                mokuhyouSetTi = kykSyouhnHnkmaeBean.getTargettkmokuhyouti().toString();
            }
            else {
                mokuhyouSetTi = MKHSETTI_NINI;
            }

            String siteiTuukaCd = "";

            if (C_Tuukasyu.USD.eq(kykSyouhnHnkmaeBean.getKyktuukasyu())) {
                siteiTuukaCd = TUUKACD_USD;
            }
            else if (C_Tuukasyu.AUD.eq(kykSyouhnHnkmaeBean.getKyktuukasyu())) {
                siteiTuukaCd = TUUKACD_AUD;
            }

            String hrkTuukaCd = "";

            if (C_Tuukasyu.JPY.eq(rsTuukaSyu)) {
                hrkTuukaCd = TUUKACD_JPY;
            }
            else if (C_Tuukasyu.USD.eq(rsTuukaSyu)) {
                hrkTuukaCd = TUUKACD_USD;
            }
            else if (C_Tuukasyu.AUD.eq(rsTuukaSyu)) {
                hrkTuukaCd = TUUKACD_AUD;
            }

            KhYendtHnkKykCsvFile khYendtHnkKykCsvFile = SWAKInjector.getInstance(KhYendtHnkKykCsvFile.class);
            khYendtHnkKykCsvFile.setIfcSyono(syoNo);
            khYendtHnkKykCsvFile.setIfcYendthnkymd(khYendtHnkKykBean.getYendthnkymd().toString());
            khYendtHnkKykCsvFile.setIfcUktksyorikbn(khYendtHnkKykBean.getUktksyorikbn().getContent());
            khYendtHnkKykCsvFile.setIfcToutatukngk(khYendtHnkKykBean.getYendthnkkaiyakuhryen().toAdsoluteString());
            khYendtHnkKykCsvFile.setIfcYendthnkhr(khYendtHnkKykBean.getYendthnkhr().toAdsoluteString());
            khYendtHnkKykCsvFile.setIfcYendtkijyunkngk(kykSyouhnHnkmaeBean.getTargettkykkijyungk().toAdsoluteString());
            khYendtHnkKykCsvFile.setIfcYendthnkkihons(khYendtHnkKykBean.getYendthnkkihons().toAdsoluteString());
            khYendtHnkKykCsvFile.setIfcSyouhnnm(syouhnNm);
            khYendtHnkKykCsvFile.setIfcOyadrtencd(oyadrtenCd);
            khYendtHnkKykCsvFile.setIfcDrtencd(drtenCd);
            khYendtHnkKykCsvFile.setIfcKydatkioyadrtencd(kydatkioyadrtenCd);
            khYendtHnkKykCsvFile.setIfcKydatkidrtencd(kydatkidrtenCd);
            khYendtHnkKykCsvFile.setIfcMusymd(khYendtHnkKykBean.getKykymd().toString());
            khYendtHnkKykCsvFile.setIfcKihrkmpmf(kihrkmP.toAdsoluteString());
            khYendtHnkKykCsvFile.setIfcSiteituukaitijibrp(kykSyouhnHnkmaeBean.getHokenryou().toAdsoluteString());
            khYendtHnkKykCsvFile.setIfcHrktuukaitijibrp(rsgaku.toAdsoluteString());
            khYendtHnkKykCsvFile.setIfcSyuhknkkn(syuhknkkn);
            khYendtHnkKykCsvFile.setIfcKnjkyksyamei(khYendtHnkKykBean.getKyknmkj());
            khYendtHnkKykCsvFile.setIfcKykjyutikbnyendthnkkykf(kykjyoutaikbn);
            khYendtHnkKykCsvFile.setIfcCifcd(kykKihon.getCifcd());
            khYendtHnkKykCsvFile.setIfcTargettkmkhtstr(mokuhyouSetTi);
            khYendtHnkKykCsvFile.setIfcSiteituukacd(siteiTuukaCd);
            khYendtHnkKykCsvFile.setIfcHrktuukacd(hrkTuukaCd);


            khYendtHnkKykCsvFileLst.add(khYendtHnkKykCsvFile);

            khYendtHnkKykFileSksCsvFileKensuu = khYendtHnkKykFileSksCsvFileKensuu + 1;
        }


        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        if (khYendtHnkKykCsvFileLst.size() > 0) {

            int renno = 1;

            List<List<KhYendtHnkKykCsvFile>> bunkatuList =
                Lists.partition(khYendtHnkKykCsvFileLst, FILE_SAVE_MAX_LIST_COUNT);

            for (List<KhYendtHnkKykCsvFile> csvFileLst : bunkatuList) {

                C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                    C_FileSyuruiCdKbn.KH_YENDTHNKKYKCSVF,
                    csvFileLst,
                    true,
                    Strings.padStart(String.valueOf(renno), 2, '0'));

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
                }

                renno = renno + 1;
            }
        }

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0001, String.valueOf(khYendtHnkKykFileSksCsvFileKensuu)));
    }

    private BizNumber getKawaserate(BizDate pKwsrateKjYmd, C_KawaserateSyuruiKbn pKawaserateSyuruiKbn,
        C_Tuukasyu pMototuuka, C_Tuukasyu pKanzantuuka, C_KawasetekiyoKbn pKawaseteKiyoKbn,
        C_KawasetsryKbn pKawasetsryKbn, C_EigyoubiHoseiKbn pEigyoubiHoseiKbn, C_YouhiKbn pZenEigyoubiKsSyutokuYouhi) {

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        C_ErrorKbn errorKbn = getKawaseRate.exec(
            pKwsrateKjYmd,
            pKawaserateSyuruiKbn,
            pMototuuka,
            pKanzantuuka,
            pKawaseteKiyoKbn,
            pKawasetsryKbn,
            pEigyoubiHoseiKbn,
            pZenEigyoubiKsSyutokuYouhi);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1047, pKwsrateKjYmd.toString(),
                pKawaserateSyuruiKbn.getValue(), pMototuuka.getValue(), pKanzantuuka.getValue(),
                pKawaseteKiyoKbn.getValue(), pKawasetsryKbn.getValue(), pEigyoubiHoseiKbn.getValue(),
                pZenEigyoubiKsSyutokuYouhi.getValue()));
        }
        return getKawaseRate.getKawaserate();
    }

}
