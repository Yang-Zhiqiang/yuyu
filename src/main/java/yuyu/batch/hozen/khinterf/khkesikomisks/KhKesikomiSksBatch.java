package yuyu.batch.hozen.khinterf.khkesikomisks;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityDeleter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khkesikomisks.dba.ItKhKesikomiDataBean;
import yuyu.batch.hozen.khinterf.khkesikomisks.dba.KhKesikomiSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_CreditcardHrKskmKbn;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.db.entity.IT_KhKesikomiData;
import yuyu.def.db.entity.ZT_KesikomiSousinCreditTy;
import yuyu.def.db.entity.ZT_KesikomiSousinHurikaeTy;
import yuyu.def.db.entity.ZT_KesikomiSousinKouhuriTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 消込送信Ｆ作成のバッチクラスです。
 */
public class KhKesikomiSksBatch implements Batch {

    private static final String SUITOUKBN_KOUZAHURI = "04";

    private static final  String SUITOUKBN_HURI_BANK = "05";

    private static final  String SUITOUKBN_CREDIT = "07";

    private static final  String KARIUKE_HUHO_YOHURI = "27124";

    private static final  String KARIUKE_HUHO_HRKE = "27123";

    private static final  String KARIUKE_HUHO_SYUUNOU = "19105";

    private static final  String KARIUKE_HUHO_CREDIT = "19109";

    private static final  String KZHURISYUUDAIKOKBN_CSS = "1";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhKesikomiSksBatchParam khKesikomiSksBatchParam;

    @Inject
    private KhKesikomiSksDao khKesikomiSksDao;

    @Inject
    private  HozenDomManager  hozenDomManager;
    @Override
    public BatchParam getParam() {
        return khKesikomiSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = khKesikomiSksBatchParam.getSyoriYmd();
        String ibKakutyouJobcd = khKesikomiSksBatchParam.getIbKakutyoujobcd();
        C_Nykkeiro nykkeiro = khKesikomiSksBatchParam.getNykkeiro();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyouJobcd));

        if (null == nykkeiro) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
                MessageId.IIW3012), null));
        }
        else {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
                MessageId.IIW3012), nykkeiro.getContent()));
        }

        if (null == nykkeiro || C_Nykkeiro.BLNK.eq(nykkeiro) || C_Nykkeiro.KZHRK.eq(nykkeiro) ||
            C_Nykkeiro.CREDIT.eq(nykkeiro) || C_Nykkeiro.BANK.eq(nykkeiro) ) {
        }
        else {
            throw new BizAppException(MessageId.EBF0010, MessageUtil.getMessage(MessageId.IIW3012));
        }

        long syoriCnt = 0;
        long syoriCntKouhuri = 0;
        long syoriCntCredit = 0;
        long syoriCntHurikae = 0;
        UniqueKeyGenerator uniqueKeyGenerator = SWAKInjector.getInstance(UniqueKeyGenerator.class);
        Map<String, KouhuriMergeBean> kouhuriSisMergeMap = new HashMap<String, KouhuriMergeBean>();
        Map<String, KouhuriMergeBean> kouhuriCssMergeMap = new HashMap<String, KouhuriMergeBean>();
        Map<String, CreditcardHrMergeBean> creditcardHrMergeMap = new HashMap<String, CreditcardHrMergeBean>();

        try (ExDBResults<ItKhKesikomiDataBean> itKhKesikomiDataBeanList = khKesikomiSksDao.getKesikomiData(
            nykkeiro);

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();

            EntityDeleter<IT_KhKesikomiData> khKesikomiDataDeleter = new EntityDeleter<>()) {

            BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

            for (ItKhKesikomiDataBean itKhKesikomiDataBean : itKhKesikomiDataBeanList) {

                ZT_KesikomiSousinHurikaeTy kesikomiSousinHurikaeTy = null;

                String taisyakuKbn = itKhKesikomiDataBean.getTaisyakukbn().getValue();

                if (C_Nykkeiro.KZHRK.eq(itKhKesikomiDataBean.getNykkeiro())) {
                    if (C_Syuudaikocd.SIS.eq(itKhKesikomiDataBean.getSyuudaikocd())) {

                        String kouhuriSisMergeKey = "";
                        kouhuriSisMergeKey = taisyakuKbn + "_" +
                            KARIUKE_HUHO_SYUUNOU  + "_" +
                            SUITOUKBN_KOUZAHURI  + "_" +
                            itKhKesikomiDataBean.getKzhurikaebankcd()  + "_" +
                            itKhKesikomiDataBean.getRyosyuymd().toString();

                        if (kouhuriSisMergeMap.containsKey(kouhuriSisMergeKey)) {

                            KouhuriMergeBean kouhuriMergeBean = kouhuriSisMergeMap.get(kouhuriSisMergeKey);

                            kouhuriMergeBean.setDengk(kouhuriMergeBean.getDengk().add(itKhKesikomiDataBean.getRsgaku()));
                        }
                        else {

                            KouhuriMergeBean kouhuriMergeBean = SWAKInjector.getInstance(KouhuriMergeBean.class);

                            kouhuriMergeBean.setSuitouKbn(SUITOUKBN_KOUZAHURI);
                            kouhuriMergeBean.setKzhurikaeBankCd(itKhKesikomiDataBean.getKzhurikaebankcd());
                            kouhuriMergeBean.setHurikaeYmd(itKhKesikomiDataBean.getRyosyuymd());
                            kouhuriMergeBean.setDenYmd(itKhKesikomiDataBean.getNykdenymd());
                            kouhuriMergeBean.setTaisyakuKbn(taisyakuKbn);
                            kouhuriMergeBean.setHutuuhokenKamokuCd(KARIUKE_HUHO_SYUUNOU);
                            kouhuriMergeBean.setDengk(itKhKesikomiDataBean.getRsgaku());
                            kouhuriMergeBean.setNkkakusyouNyuuryokuYmd(itKhKesikomiDataBean.getNyuukinkakusyounrkymd());

                            kouhuriSisMergeMap.put(kouhuriSisMergeKey, kouhuriMergeBean);
                        }
                    }
                    else if (C_Syuudaikocd.CSS.eq(itKhKesikomiDataBean.getSyuudaikocd())) {

                        String kouhuriCssMergeKey = "";
                        kouhuriCssMergeKey = taisyakuKbn + "_" +
                            KARIUKE_HUHO_SYUUNOU  + "_" +
                            SUITOUKBN_KOUZAHURI  + "_" +
                            itKhKesikomiDataBean.getRyosyuymd().toString()  + "_" +
                            KZHURISYUUDAIKOKBN_CSS;

                        if (kouhuriCssMergeMap.containsKey(kouhuriCssMergeKey)) {

                            KouhuriMergeBean kouhuriMergeBean = kouhuriCssMergeMap.get(kouhuriCssMergeKey);

                            kouhuriMergeBean.setDengk(kouhuriMergeBean.getDengk().add(itKhKesikomiDataBean.getRsgaku()));
                        }
                        else {

                            KouhuriMergeBean kouhuriMergeBean = SWAKInjector.getInstance(KouhuriMergeBean.class);

                            kouhuriMergeBean.setSuitouKbn(SUITOUKBN_KOUZAHURI);
                            kouhuriMergeBean.setHurikaeYmd(itKhKesikomiDataBean.getRyosyuymd());
                            kouhuriMergeBean.setDenYmd(itKhKesikomiDataBean.getNykdenymd());
                            kouhuriMergeBean.setTaisyakuKbn(taisyakuKbn);
                            kouhuriMergeBean.setHutuuhokenKamokuCd(KARIUKE_HUHO_SYUUNOU);
                            kouhuriMergeBean.setDengk(itKhKesikomiDataBean.getRsgaku());
                            kouhuriMergeBean.setNkkakusyouNyuuryokuYmd(itKhKesikomiDataBean.getNyuukinkakusyounrkymd());
                            kouhuriMergeBean.setKinyuukikanKbn(KZHURISYUUDAIKOKBN_CSS);

                            kouhuriCssMergeMap.put(kouhuriCssMergeKey, kouhuriMergeBean);
                        }
                    }

                    syoriCntKouhuri = syoriCntKouhuri + 1;
                }

                else if (C_Nykkeiro.CREDIT.eq(itKhKesikomiDataBean.getNykkeiro())) {

                    String creditMergeKey = "";
                    creditMergeKey = taisyakuKbn + "_" +
                        KARIUKE_HUHO_CREDIT  + "_" +
                        SUITOUKBN_CREDIT  + "_" +
                        itKhKesikomiDataBean.getCreditcardhrkskmKbn();

                    if (creditcardHrMergeMap.containsKey(creditMergeKey)){

                        CreditcardHrMergeBean creditcardHrMergeBean = creditcardHrMergeMap.get(creditMergeKey);

                        creditcardHrMergeBean.setDengk(creditcardHrMergeBean.getDengk().add(itKhKesikomiDataBean.getRsgaku()));
                    }
                    else{

                        CreditcardHrMergeBean creditcardHrMergeBean = new CreditcardHrMergeBean();

                        creditcardHrMergeBean.setSuitouKbn(SUITOUKBN_CREDIT);
                        creditcardHrMergeBean.setDenYmd(itKhKesikomiDataBean.getNykdenymd());
                        creditcardHrMergeBean.setTaisyakuKbn(taisyakuKbn);
                        creditcardHrMergeBean.setHutuuhokenKamokuCd(KARIUKE_HUHO_CREDIT);
                        creditcardHrMergeBean.setDengk(itKhKesikomiDataBean.getRsgaku());
                        creditcardHrMergeBean.setRyousyuuymd(itKhKesikomiDataBean.getRyosyuymd());
                        creditcardHrMergeBean.setNkkakusyouNyuuryokuYmd(itKhKesikomiDataBean.getNyuukinkakusyounrkymd());
                        creditcardHrMergeBean.setCreditcardhrkskmkbn(itKhKesikomiDataBean.getCreditcardhrkskmKbn());

                        creditcardHrMergeMap.put(creditMergeKey, creditcardHrMergeBean);
                    }

                    syoriCntCredit = syoriCntCredit + 1;
                }
                else if (C_Nykkeiro.BANK.eq(itKhKesikomiDataBean.getNykkeiro())) {

                    String hutuuhokenKamokuCd = KARIUKE_HUHO_HRKE;

                    KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(String.valueOf(itKhKesikomiDataBean.getNyknaiyoukbn()),
                        C_NyknaiyouKbn .class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER );

                    String nyknaiyouKbn = kbnInfoBean.getKbnData();

                    kesikomiSousinHurikaeTy = new ZT_KesikomiSousinHurikaeTy();
                    kesikomiSousinHurikaeTy.setZtykskmsousinrenno(uniqueKeyGenerator.generateUniqueKey());
                    kesikomiSousinHurikaeTy.setZtykskmkamokucd("27123");
                    kesikomiSousinHurikaeTy.setZtysuitoukbn(SUITOUKBN_HURI_BANK);
                    kesikomiSousinHurikaeTy.setZtysuitousosikicd(
                        itKhKesikomiDataBean.getSuitoubumoncd() + "0000");
                    kesikomiSousinHurikaeTy.setZtyhasseidenymd(
                        String.valueOf(itKhKesikomiDataBean.getRyosyuymd()));
                    kesikomiSousinHurikaeTy.setZtykarikanjyono(
                        itKhKesikomiDataBean.getKarikanjyono());
                    kesikomiSousinHurikaeTy.setZtykinyuukikankbn("0");
                    kesikomiSousinHurikaeTy.setZtykskmfsyoriymd(String.valueOf(syoriYmd));
                    kesikomiSousinHurikaeTy.setZtykskmfdenymd(
                        String.valueOf(itKhKesikomiDataBean.getNykdenymd()));
                    kesikomiSousinHurikaeTy.setZtydenatesakicd(String.valueOf(C_Tantositucd.SYUUNOUSV));
                    kesikomiSousinHurikaeTy.setZtykskmftaisyakukbn(
                        taisyakuKbn);
                    kesikomiSousinHurikaeTy.setZtyhutuuhokenkamokucd(hutuuhokenKamokuCd);
                    kesikomiSousinHurikaeTy.setZtydengk(Long.valueOf(
                        itKhKesikomiDataBean.getRsgaku().toString()));
                    kesikomiSousinHurikaeTy.setZtytabakariknjykskmdatakbn("22");
                    kesikomiSousinHurikaeTy.setZtykskmfryousyuuymd(
                        String.valueOf(itKhKesikomiDataBean.getRyosyuymd()));
                    kesikomiSousinHurikaeTy.setZtynkkakusyounyuuryokuymd2(
                        String.valueOf(itKhKesikomiDataBean.getNyuukinkakusyounrkymd()));
                    kesikomiSousinHurikaeTy.setZtykskmfsyono(
                        itKhKesikomiDataBean.getSyono());
                    if(itKhKesikomiDataBean.getJyuutouym() != null){
                        kesikomiSousinHurikaeTy.setZtykskmfjyuutouym(
                            String.valueOf(itKhKesikomiDataBean.getJyuutouym()));
                    }
                    kesikomiSousinHurikaeTy.setZtynyuuryokuhouhoukbn(
                        String.valueOf(itKhKesikomiDataBean.getNyuuryokukbn()));
                    kesikomiSousinHurikaeTy.setZtykskmfnyknaiyoukbn(nyknaiyouKbn);
                    kesikomiSousinHurikaeTy.setZtyhurikomiyousinyuukinkbn(
                        C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI.getValue());

                    BizPropertyInitializer.initialize(kesikomiSousinHurikaeTy);

                    syoriCntHurikae = syoriCntHurikae + 1;
                }

                if (null != kesikomiSousinHurikaeTy) {

                    khKesikomiSksDao.addMultipleInserterEntity(multipleEntityInserter, kesikomiSousinHurikaeTy);
                }

                IT_KhKesikomiData khKesikomiData =  hozenDomManager.getKhKesikomiData(
                    itKhKesikomiDataBean.getNyuukinkakusyouno(), itKhKesikomiDataBean.getSyono());

                khKesikomiSksDao.deleteKesikomiData(khKesikomiDataDeleter, khKesikomiData);

                syoriCnt = syoriCnt + 1;

            }

            for (Map.Entry<String, KouhuriMergeBean> tempMap : kouhuriSisMergeMap.entrySet()) {

                KouhuriMergeBean kouhuriMergeBean = tempMap.getValue();

                ZT_KesikomiSousinKouhuriTy kesikomiSousinKouhuriTy = new ZT_KesikomiSousinKouhuriTy();

                kesikomiSousinKouhuriTy.setZtykskmsousinrenno(uniqueKeyGenerator.generateUniqueKey());
                kesikomiSousinKouhuriTy.setZtykskmkamokucd(KARIUKE_HUHO_YOHURI);
                kesikomiSousinKouhuriTy.setZtysuitoukbn(kouhuriMergeBean.getSuitouKbn());
                kesikomiSousinKouhuriTy.setZtykskmfkzhurikaebankcd(kouhuriMergeBean.getKzhurikaeBankCd());
                kesikomiSousinKouhuriTy.setZtykskmfhurikaeymd(String.valueOf(kouhuriMergeBean.getHurikaeYmd()));
                kesikomiSousinKouhuriTy.setZtykinyuukikankbn("0");
                kesikomiSousinKouhuriTy.setZtykskmfsyoriymd(String.valueOf(syoriYmd));
                kesikomiSousinKouhuriTy.setZtykskmfdenymd(String.valueOf(kouhuriMergeBean.getDenYmd()));
                kesikomiSousinKouhuriTy.setZtydenatesakicd(String.valueOf(C_Tantositucd.SYUUNOUSV));
                kesikomiSousinKouhuriTy.setZtykskmftaisyakukbn(kouhuriMergeBean.getTaisyakuKbn());
                kesikomiSousinKouhuriTy.setZtyhutuuhokenkamokucd(kouhuriMergeBean.getHutuuhokenKamokuCd());
                kesikomiSousinKouhuriTy.setZtydengk(Long.valueOf(kouhuriMergeBean.getDengk().toString()));
                kesikomiSousinKouhuriTy.setZtytabakariknjykskmdatakbn("22");
                kesikomiSousinKouhuriTy.setZtynkkakusyounyuuryokuymd2(String.valueOf(kouhuriMergeBean.getNkkakusyouNyuuryokuYmd()));
                kesikomiSousinKouhuriTy.setZtyhasseisosikicd(String.valueOf(C_Tantositucd.SYUUNOUSV) + "0000");

                BizPropertyInitializer.initialize(kesikomiSousinKouhuriTy);

                khKesikomiSksDao.addMultipleInserterEntity(multipleEntityInserter, kesikomiSousinKouhuriTy);
            }

            for (Map.Entry<String, KouhuriMergeBean> tempMap : kouhuriCssMergeMap.entrySet()) {

                KouhuriMergeBean kouhuriMergeBean = tempMap.getValue();

                ZT_KesikomiSousinKouhuriTy kesikomiSousinKouhuriTy = new ZT_KesikomiSousinKouhuriTy();

                kesikomiSousinKouhuriTy.setZtykskmsousinrenno(uniqueKeyGenerator.generateUniqueKey());
                kesikomiSousinKouhuriTy.setZtykskmkamokucd(KARIUKE_HUHO_YOHURI);
                kesikomiSousinKouhuriTy.setZtysuitoukbn(kouhuriMergeBean.getSuitouKbn());
                kesikomiSousinKouhuriTy.setZtykskmfhurikaeymd(String.valueOf(kouhuriMergeBean.getHurikaeYmd()));
                kesikomiSousinKouhuriTy.setZtykinyuukikankbn(kouhuriMergeBean.getKinyuukikanKbn());
                kesikomiSousinKouhuriTy.setZtykskmfsyoriymd(String.valueOf(syoriYmd));
                kesikomiSousinKouhuriTy.setZtykskmfdenymd(String.valueOf(kouhuriMergeBean.getDenYmd()));
                kesikomiSousinKouhuriTy.setZtydenatesakicd(String.valueOf(C_Tantositucd.SYUUNOUSV));
                kesikomiSousinKouhuriTy.setZtykskmftaisyakukbn(kouhuriMergeBean.getTaisyakuKbn());
                kesikomiSousinKouhuriTy.setZtyhutuuhokenkamokucd(kouhuriMergeBean.getHutuuhokenKamokuCd());
                kesikomiSousinKouhuriTy.setZtydengk(Long.valueOf(kouhuriMergeBean.getDengk().toString()));
                kesikomiSousinKouhuriTy.setZtytabakariknjykskmdatakbn("22");
                kesikomiSousinKouhuriTy.setZtynkkakusyounyuuryokuymd2(String.valueOf(kouhuriMergeBean.getNkkakusyouNyuuryokuYmd()));
                kesikomiSousinKouhuriTy.setZtyhasseisosikicd(String.valueOf(C_Tantositucd.SYUUNOUSV) + "0000");

                BizPropertyInitializer.initialize(kesikomiSousinKouhuriTy);

                khKesikomiSksDao.addMultipleInserterEntity(multipleEntityInserter, kesikomiSousinKouhuriTy);
            }

            for (Map.Entry<String,CreditcardHrMergeBean> tempMap : creditcardHrMergeMap.entrySet()) {

                CreditcardHrMergeBean creditcardHrMergeBean = tempMap.getValue();

                ZT_KesikomiSousinCreditTy kesikomiSousinCreditTy = new ZT_KesikomiSousinCreditTy();

                kesikomiSousinCreditTy.setZtykskmsousinrenno(uniqueKeyGenerator.generateUniqueKey());
                kesikomiSousinCreditTy.setZtykskmkamokucd(KARIUKE_HUHO_CREDIT);
                kesikomiSousinCreditTy.setZtysuitoukbn(creditcardHrMergeBean.getSuitouKbn());
                kesikomiSousinCreditTy.setZtykinyuukikankbn("0");
                kesikomiSousinCreditTy.setZtykskmfsyoriymd(String.valueOf(syoriYmd));
                kesikomiSousinCreditTy.setZtykskmfdenymd(String.valueOf(creditcardHrMergeBean.getDenYmd()));
                kesikomiSousinCreditTy.setZtydenatesakicd(C_Tantositucd.SYUUNOUSV.getValue());
                kesikomiSousinCreditTy.setZtykskmftaisyakukbn(creditcardHrMergeBean.getTaisyakuKbn());
                kesikomiSousinCreditTy.setZtyhutuuhokenkamokucd(creditcardHrMergeBean.getHutuuhokenKamokuCd());
                kesikomiSousinCreditTy.setZtydengk(Long.valueOf((creditcardHrMergeBean.getDengk().toString())));
                kesikomiSousinCreditTy.setZtytabakariknjykskmdatakbn("22");
                kesikomiSousinCreditTy.setZtykskmfryousyuuymd(String.valueOf(creditcardHrMergeBean.getRyousyuuymd()));
                kesikomiSousinCreditTy.setZtynkkakusyounyuuryokuymd2(String.valueOf(creditcardHrMergeBean.getNkkakusyouNyuuryokuYmd()));
                kesikomiSousinCreditTy.setZtycreditcardhrkskmkbn(creditcardHrMergeBean.getCreditcardhrkskmkbn().getValue());

                BizPropertyInitializer.initialize(kesikomiSousinCreditTy);

                khKesikomiSksDao.addMultipleInserterEntity(multipleEntityInserter, kesikomiSousinCreditTy);
            }
        }

        if (null == nykkeiro || C_Nykkeiro.BLNK.eq(nykkeiro) || C_Nykkeiro.KZHRK.eq(nykkeiro)){

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCntKouhuri), "口振"));
        }
        if (null == nykkeiro || C_Nykkeiro.BLNK.eq(nykkeiro) || C_Nykkeiro.CREDIT.eq(nykkeiro)){

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCntCredit), "クレ払"));
        }
        if (null == nykkeiro || C_Nykkeiro.BLNK.eq(nykkeiro) || C_Nykkeiro.BANK.eq(nykkeiro)){

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCntHurikae), "振替"));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCnt), "合計"));
    }

    public class CreditcardHrMergeBean{

        private String suitouKbn;

        private BizDate  denYmd;

        private String taisyakuKbn;

        private String hutuuhokenKamokuCd;

        private BizCurrency dengk;

        private BizDate ryousyuuymd;

        private BizDate nkkakusyouNyuuryokuYmd;

        private C_CreditcardHrKskmKbn creditcardhrkskmkbn;

        protected CreditcardHrMergeBean() {
        }

        public String getSuitouKbn() {
            return suitouKbn;
        }

        protected void setSuitouKbn(String pSuitouKbn) {
            suitouKbn = pSuitouKbn;
        }

        public BizDate getDenYmd() {
            return denYmd;
        }

        protected void setDenYmd(BizDate pDenYmd) {
            denYmd = pDenYmd;
        }

        public String getTaisyakuKbn() {
            return taisyakuKbn;
        }

        protected void setTaisyakuKbn(String pTaisyakuKbn) {
            taisyakuKbn = pTaisyakuKbn;
        }

        public String getHutuuhokenKamokuCd() {
            return hutuuhokenKamokuCd;
        }

        protected void setHutuuhokenKamokuCd(String pHutuuhokenKamokuCd) {
            hutuuhokenKamokuCd = pHutuuhokenKamokuCd;
        }

        public BizCurrency getDengk() {
            return dengk;
        }

        protected void setDengk(BizCurrency pDengk) {
            dengk = pDengk;
        }

        public BizDate getRyousyuuymd() {
            return ryousyuuymd;
        }

        protected void setRyousyuuymd(BizDate pRyousyuuymd) {
            ryousyuuymd = pRyousyuuymd;
        }

        public BizDate getNkkakusyouNyuuryokuYmd() {
            return nkkakusyouNyuuryokuYmd;
        }

        protected void setNkkakusyouNyuuryokuYmd(BizDate pNkkakusyouNyuuryokuYmd) {
            nkkakusyouNyuuryokuYmd = pNkkakusyouNyuuryokuYmd;
        }

        public C_CreditcardHrKskmKbn getCreditcardhrkskmkbn() {
            return creditcardhrkskmkbn;
        }

        protected void setCreditcardhrkskmkbn(C_CreditcardHrKskmKbn pCreditcardhrkskmkbn) {
            creditcardhrkskmkbn = pCreditcardhrkskmkbn;
        }

    }
}
