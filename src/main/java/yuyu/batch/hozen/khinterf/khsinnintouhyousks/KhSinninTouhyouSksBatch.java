package yuyu.batch.hozen.khinterf.khsinnintouhyousks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khsinnintouhyousks.dba.KhSinninTouhyouSksDao;
import yuyu.batch.hozen.khinterf.khsinnintouhyousks.dba.KhYuukouTaisyouKykBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.ZT_SinninTouhyouTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェース 信任投票作成
 */
public class KhSinninTouhyouSksBatch implements Batch {

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhSinninTouhyouSksDao khSinninTouhyouSksDao;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private CheckYuukouJyoutai checkYuukouJyoutai;

    @Inject
    private CheckYuukouJyoutaiParam checkYuukouJyoutaiParam;

    private SinninTouhyouLogger logger = new SinninTouhyouLogger();

    private RecoveryFilterManagement recoveryFilter = new RecoveryFilterManagement();

    @Execute
    @Transactional
    public void execute() {
        BizDate sinninTouhyouSyutujouYmd = bzBatchParam.getSyoriYmd().getBizDateYM().getPreviousMonth().getFirstDay();

        logger.init(khSinninTouhyouSksDao.getYuukouTaisyouKykCount(sinninTouhyouSyutujouYmd));
        recoveryFilter.init(bzBatchParam.getIbKakutyoujobcd());

        try (
            ExDBResults<KhYuukouTaisyouKykBean> exDBResults = khSinninTouhyouSksDao.
            getYuukouTaisyouKykBeans(bzBatchParam.getIbKakutyoujobcd(), sinninTouhyouSyutujouYmd);
            EntityInserter<ZT_SinninTouhyouTy> entityInserter = new EntityInserter<>()) {

            for (KhYuukouTaisyouKykBean khYuukouTaisyouKykBean : exDBResults) {

                logger.incrementSyorizumiKensu();

                recoveryFilter.setRecoveryData(khYuukouTaisyouKykBean.getKbnkey(), khYuukouTaisyouKykBean.getSyono());

                checkYuukouJyoutaiParam.setSyono(khYuukouTaisyouKykBean.getSyono());
                if (C_YuukoujyotaichkKbn.HUKA.eq(checkYuukouJyoutai.exec(khozenCommonParam, checkYuukouJyoutaiParam))) {
                    checkYuukouJyoutai.detachAllEntities(khYuukouTaisyouKykBean.getSyono());
                    continue;
                }

                editAndResisterSinninTouhyou(khYuukouTaisyouKykBean, entityInserter);

                logger.incrementTourokuKensu();

                logger.outputSintyokuLog();

                checkYuukouJyoutai.detachAllEntities(khYuukouTaisyouKykBean.getSyono());
            }

            recoveryFilter.clear();

            logger.outputEndLog();
        }
    }

    private void editAndResisterSinninTouhyou(KhYuukouTaisyouKykBean pKhYuukouTaisyouKykBean, EntityInserter<ZT_SinninTouhyouTy> pEntityInserter) {

        ZT_SinninTouhyouTy ztSinninTouhyouTy = initZtSinninTouhyouTy(new ZT_SinninTouhyouTy());

        ztSinninTouhyouTy.setZtyhokenkbn(E_PalHokenkbn.YUYU.getValue());
        ztSinninTouhyouTy.setZtykyknaiyoukbn(E_PalKyknaiyoukbn.SNNNTUHUNOMI.getValue());
        ztSinninTouhyouTy.setZtyhokenkbnnys(E_PalHokenkbnNum.HUTUUKYK.getValue());
        ztSinninTouhyouTy.setZtysakuinmeinonys(hanteiSakuinmeino(pKhYuukouTaisyouKykBean));
        ztSinninTouhyouTy.setZtysyainnm(pKhYuukouTaisyouKykBean.getKyknmkn());
        ztSinninTouhyouTy.setZtykanjisyainnm(pKhYuukouTaisyouKykBean.getKyknmkj());
        ztSinninTouhyouTy.setZtysyainseiymd(editSyainseiymd(pKhYuukouTaisyouKykBean.getKykseiymd()));
        ztSinninTouhyouTy.setZtytsinkihontikucd(pKhYuukouTaisyouKykBean.getTsinyno());
        ztSinninTouhyouTy.setZtykanjitsinkaiadr(editKanjitsinkaiadr(pKhYuukouTaisyouKykBean));
        ztSinninTouhyouTy.setZtysyono(pKhYuukouTaisyouKykBean.getSyono());
        ztSinninTouhyouTy.setZtyannaifuyouriyuukbn(hanteiAnnaiFuyouRiyuuKbn(pKhYuukouTaisyouKykBean));
        ztSinninTouhyouTy.setZtyhrkkaisuukbn(hanteiHrkkaisuuKbn(pKhYuukouTaisyouKykBean));
        ztSinninTouhyouTy.setZtyhrkkeirokbn(hanteiHrkkeiroKbn(pKhYuukouTaisyouKykBean));
        ztSinninTouhyouTy.setZtytksyuannaikykkbn(E_PalAtksyuannaikykkbn.TSG.getValue());
        ztSinninTouhyouTy.setZtysouhuhunoukbn(hanteiSouhuhunouKbn(pKhYuukouTaisyouKykBean));
        ztSinninTouhyouTy.setZtynaimitureigaihyj(hanteiNaimitureigaihyj(ztSinninTouhyouTy));
        ztSinninTouhyouTy.setZtybsyym(pKhYuukouTaisyouKykBean.getBosyuuym().toString());
        ztSinninTouhyouTy.setZtyprivacyhogoyouhyj(hanteiPrivacyhogoyouhyj(ztSinninTouhyouTy));
        ztSinninTouhyouTy.setZtykaigaitokoukykhyj(hanteiKaigaitokoukykhyj(pKhYuukouTaisyouKykBean, ztSinninTouhyouTy));
        ztSinninTouhyouTy.setZtybsydrtenkbn(E_PalBsydrtenkbn.BSYDRTEN.getValue());

        BizPropertyInitializer.initialize(ztSinninTouhyouTy);

        pEntityInserter.add(ztSinninTouhyouTy);
    }

    private ZT_SinninTouhyouTy initZtSinninTouhyouTy(ZT_SinninTouhyouTy pZtSinninTouhyouTy) {

        pZtSinninTouhyouTy.setZtyhokenkbn(null);
        pZtSinninTouhyouTy.setZtykyknaiyoukbn(null);
        pZtSinninTouhyouTy.setZtyhokenkbnnys(null);
        pZtSinninTouhyouTy.setZtysakuinmeinonys(null);
        pZtSinninTouhyouTy.setZtysyainnm(null);
        pZtSinninTouhyouTy.setZtykanjisyainnm(null);
        pZtSinninTouhyouTy.setZtysyainseiymd(null);
        pZtSinninTouhyouTy.setZtytsinkihontikucd(null);
        pZtSinninTouhyouTy.setZtykanjitsinkaiadr(null);
        pZtSinninTouhyouTy.setZtysyono(null);
        pZtSinninTouhyouTy.setZtyannaifuyouriyuukbn(null);
        pZtSinninTouhyouTy.setZtyhrkkaisuukbn(null);
        pZtSinninTouhyouTy.setZtyhrkkeirokbn(null);
        pZtSinninTouhyouTy.setZtytksyuannaikykkbn(null);
        pZtSinninTouhyouTy.setZtysouhuhunoukbn(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtynaimitureigaihyj(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtysyuukinsisya(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtysyuukintntusycd(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtyokyakusamano(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtynaibukojincd(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtyhokenkbnsyainno(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtysakuinmeinosyainno(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtybsyym(null);
        pZtSinninTouhyouTy.setZtyprivacyhogoyouhyj(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtykaigaitokoukykhyj(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtynaibukbn(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtykyktsnatkitkyktrkjtkbn(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtyalcardhkkbn(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtyvitkaiinno(E_TableDefault.HANKAKU_ZERO.getValue());
        pZtSinninTouhyouTy.setZtyyobiv60(E_TableDefault.BLNK.getValue());

        return pZtSinninTouhyouTy;
    }

    private String hanteiSakuinmeino(KhYuukouTaisyouKykBean pKhYuukouTaisyouKykBean) {

        if (C_Tdk.HONNIN.equals(pKhYuukouTaisyouKykBean.getKkkyktdk())) {
            return pKhYuukouTaisyouKykBean.getHhknsakuinmeino();
        }
        return pKhYuukouTaisyouKykBean.getKyksakuinmeino();
    }

    private String editSyainseiymd(BizDate pKykseiymd) {

        if(pKykseiymd != null) {
            return String.valueOf(pKykseiymd);
        }
        return E_TableDefault.BLNK.getValue();
    }

    private String editKanjitsinkaiadr(KhYuukouTaisyouKykBean pKhYuukouTaisyouKykBean) {

        String tsinadr1kj = pKhYuukouTaisyouKykBean.getTsinadr1kj() != null ? pKhYuukouTaisyouKykBean.getTsinadr1kj()
            : E_TableDefault.BLNK.getValue();
        String tsinadr2kj = pKhYuukouTaisyouKykBean.getTsinadr2kj() != null ? pKhYuukouTaisyouKykBean.getTsinadr2kj()
            : E_TableDefault.BLNK.getValue();
        String tsinadr3kj = pKhYuukouTaisyouKykBean.getTsinadr3kj() != null ? pKhYuukouTaisyouKykBean.getTsinadr3kj()
            : E_TableDefault.BLNK.getValue();

        return tsinadr1kj.concat(tsinadr2kj).concat(tsinadr3kj);
    }

    private String hanteiSouhuhunouKbn(KhYuukouTaisyouKykBean pKhYuukouTaisyouKykBean) {

        if (C_TtdktyuuiKbn.ADRHUMEI.eq(pKhYuukouTaisyouKykBean.getTtdktyuuikbn1())
            || C_TtdktyuuiKbn.ADRHUMEI.eq(pKhYuukouTaisyouKykBean.getTtdktyuuikbn2())
            || C_TtdktyuuiKbn.ADRHUMEI.eq(pKhYuukouTaisyouKykBean.getTtdktyuuikbn3())
            || C_TtdktyuuiKbn.ADRHUMEI.eq(pKhYuukouTaisyouKykBean.getTtdktyuuikbn4())
            || C_TtdktyuuiKbn.ADRHUMEI.eq(pKhYuukouTaisyouKykBean.getTtdktyuuikbn5())) {

            return E_PalSuhhnukbn.JUUSYOHUMEI.getValue();

        }
        else if (BizUtil.isBlank(pKhYuukouTaisyouKykBean.getTsinadr1kj())) {
            return E_PalSuhhnukbn.JUUSYOHUBI.getValue();
        }
        else if (C_KktyuitaKbn.DNGNMEMOARI.equals(pKhYuukouTaisyouKykBean.getKktyuitakbn())) {
            return E_PalSuhhnukbn.ANNAIREIGAI.getValue();
        }
        else if (BizUtil.isBlank(pKhYuukouTaisyouKykBean.getKyknmkj())) {
            return E_PalSuhhnukbn.SYAINNMHUMEI.getValue();
        }
        return E_TableDefault.HANKAKU_ZERO.getValue();
    }

    private String hanteiNaimitureigaihyj(ZT_SinninTouhyouTy pZtSinninTouhyouTy) {

        if (E_PalSuhhnukbn.JUUSYOHUBI.getValue().equals(pZtSinninTouhyouTy.getZtysouhuhunoukbn())
            || E_PalSuhhnukbn.ANNAIREIGAI.getValue().equals(pZtSinninTouhyouTy.getZtysouhuhunoukbn())
            || E_PalSuhhnukbn.SYAINNMHUMEI.getValue().equals(pZtSinninTouhyouTy.getZtysouhuhunoukbn())) {
            return E_PalNaimitureigaihyj.HYJ.getValue();
        }
        return E_TableDefault.HANKAKU_ZERO.getValue();
    }

    private String hanteiPrivacyhogoyouhyj(ZT_SinninTouhyouTy pZtSinninTouhyouTy) {

        if (!E_TableDefault.HANKAKU_ZERO.getValue().equals(pZtSinninTouhyouTy.getZtysouhuhunoukbn())) {
            return E_PalPrivacyhogoyouhyj.HYJ.getValue();
        }
        return E_TableDefault.HANKAKU_ZERO.getValue();
    }

    private String hanteiKaigaitokoukykhyj(KhYuukouTaisyouKykBean pKhYuukouTaisyouKykBean, ZT_SinninTouhyouTy pZtSinninTouhyouTy) {

        if (C_TtdktyuuiKbn.KAIGAITOKOU.eq(pKhYuukouTaisyouKykBean.getTtdktyuuikbn1())
            || C_TtdktyuuiKbn.KAIGAITOKOU.eq(pKhYuukouTaisyouKykBean.getTtdktyuuikbn2())
            || C_TtdktyuuiKbn.KAIGAITOKOU.eq(pKhYuukouTaisyouKykBean.getTtdktyuuikbn3())
            || C_TtdktyuuiKbn.KAIGAITOKOU.eq(pKhYuukouTaisyouKykBean.getTtdktyuuikbn4())
            || C_TtdktyuuiKbn.KAIGAITOKOU.eq(pKhYuukouTaisyouKykBean.getTtdktyuuikbn5())
            ||!E_TableDefault.HANKAKU_ZERO.getValue().equals(pZtSinninTouhyouTy.getZtysouhuhunoukbn())) {
            return E_PalKaigaitokoukykhyj.HYJ.getValue();
        }
        return E_TableDefault.HANKAKU_ZERO.getValue();
    }

    private String hanteiHrkkaisuuKbn(KhYuukouTaisyouKykBean pKhYuukouTaisyouKykBean) {

        String hrkkaisuuKbn = "";
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(pKhYuukouTaisyouKykBean.getHrkkaisuu().getValue(),
            C_Hrkkaisuu.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        if (kbnInfoBean.isHenkanFlg()) {
            hrkkaisuuKbn = kbnInfoBean.getKbnData();
        }
        else {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1046,
                IT_KykKihon.HRKKAISUU,
                pKhYuukouTaisyouKykBean.getHrkkaisuu().getValue()));
        }

        return hrkkaisuuKbn;
    }

    private String hanteiHrkkeiroKbn(KhYuukouTaisyouKykBean pKhYuukouTaisyouKykBean) {

        String hrkkeiroKbn = "";
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(pKhYuukouTaisyouKykBean.getHrkkeiro().getValue(),
            C_Hrkkeiro.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        if (kbnInfoBean.isHenkanFlg()) {
            hrkkeiroKbn = kbnInfoBean.getKbnData();
        }
        else {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1046,
                IT_KykKihon.HRKKEIRO,
                pKhYuukouTaisyouKykBean.getHrkkeiro().getValue()));
        }

        return hrkkeiroKbn;
    }

    private String hanteiAnnaiFuyouRiyuuKbn(KhYuukouTaisyouKykBean pKhYuukouTaisyouKykBean) {

        String annaiFuyouRiyuuKbn = "";
        String kykjyoutai = "";
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        if (C_Kykjyoutai.HRKMTYUU.eq(pKhYuukouTaisyouKykBean.getKykjyoutai()) &&
            (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKhYuukouTaisyouKykBean.getTikiktbrisyuruikbn()) ||
                C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKhYuukouTaisyouKykBean.getTikiktbrisyuruikbn()))) {
            kykjyoutai = C_Kykjyoutai.IKKATUNK.getValue();
        }
        else {
            kykjyoutai = pKhYuukouTaisyouKykBean.getKykjyoutai().getValue();
        }

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(kykjyoutai,
            C_Kykjyoutai.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        if (kbnInfoBean.isHenkanFlg()) {
            annaiFuyouRiyuuKbn = kbnInfoBean.getKbnData();
        }
        else {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1046,
                IT_KykSyouhn.KYKJYOUTAI,
                kykjyoutai));
        }

        return annaiFuyouRiyuuKbn;
    }

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    private class SinninTouhyouLogger{

        private BatchLogger batchLogger = SWAKInjector.getInstance(BatchLogger.class);

        private static final long SYUTURYOKUTANNI = 10000;

        private static final String TOUROKUTBLNM = "信任投票データテーブル（中）";

        private long syorizumiKensu;

        private long sintyokuSyorizumiKensu;

        private long tourokuKensu;

        private long syoriTaisyouKensu;

        SinninTouhyouLogger() {
        }

        void init(long pSyoriTaisyouKensu) {
            syorizumiKensu = 0;
            sintyokuSyorizumiKensu = 0;
            tourokuKensu = 0;
            syoriTaisyouKensu = pSyoriTaisyouKensu;
        }

        void incrementSyorizumiKensu() {
            syorizumiKensu++;
        }

        void incrementTourokuKensu() {
            tourokuKensu++;
        }

        void outputSintyokuLog(){
            sintyokuSyorizumiKensu++;
            if(sintyokuSyorizumiKensu == SYUTURYOKUTANNI){
                batchLogger.info(MessageUtil.getMessage(MessageId.IIA1001, String.valueOf(syorizumiKensu),
                    String.valueOf((syoriTaisyouKensu))));
                sintyokuSyorizumiKensu = 0;
            }
        }

        void outputEndLog(){
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(tourokuKensu), TOUROKUTBLNM));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate()  {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    private class RecoveryFilterManagement{

        private static final String TYSYTTAISYOUTABLEID = "IT_KykKihon";

        private static final String RECOVERYFILTERID = "Kh001";

        private String ibKakutyoujobCd;

        private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean = SWAKInjector
            .getInstance(BzRecoveryDatasikibetuBean.class);

        RecoveryFilterManagement() {
        }

        void init(String pIbKakutyoujobCd){
            ibKakutyoujobCd = pIbKakutyoujobCd;
        }

        void setRecoveryData(String kbnKey, String syono){

            bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
            bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
            bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kbnKey);
            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);
        }

        void clear(){
            bzRecoveryDatasikibetuBean.initializeBlank();
        }
    }

    private enum E_TableDefault {
        HANKAKU_ZERO ("0"),
        BLNK("");

        private String value;
        E_TableDefault(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    private enum E_PalHokenkbn {
        YUYU ("I");

        private String value;
        E_PalHokenkbn(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    private enum E_PalHokenkbnNum {
        HUTUUKYK ("1");

        private String value;
        E_PalHokenkbnNum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    private enum E_PalKyknaiyoukbn {
        SNNNTUHUNOMI ("3");

        private String value;
        E_PalKyknaiyoukbn(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    private enum E_PalAtksyuannaikykkbn {
        TSG ("0");

        private String value;
        E_PalAtksyuannaikykkbn(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    private enum E_PalSuhhnukbn {
        JUUSYOHUMEI ("1"),
        JUUSYOHUBI("2"),
        ANNAIREIGAI("4"),
        SYAINNMHUMEI("5");

        private String value;
        E_PalSuhhnukbn(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    private enum E_PalNaimitureigaihyj {
        HYJ ("1");

        private String value;
        E_PalNaimitureigaihyj(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    private enum E_PalPrivacyhogoyouhyj {
        HYJ ("1");

        private String value;
        E_PalPrivacyhogoyouhyj(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    private enum E_PalKaigaitokoukykhyj {
        HYJ ("1");

        private String value;
        E_PalKaigaitokoukykhyj(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    private enum E_PalBsydrtenkbn {
        BSYDRTEN ("1");

        private String value;
        E_PalBsydrtenkbn(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
}
