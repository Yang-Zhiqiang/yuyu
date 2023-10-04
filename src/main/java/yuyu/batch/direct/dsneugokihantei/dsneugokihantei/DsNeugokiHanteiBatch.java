package yuyu.batch.direct.dsneugokihantei.dsneugokihantei;

import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.direct.dsneugokihantei.dsneugokihantei.dba.DsKokyakuInfoBySyonoBean;
import yuyu.batch.direct.dsneugokihantei.dsneugokihantei.dba.DsNeugokiHanteiDao;
import yuyu.batch.direct.dsneugokihantei.dsneugokihantei.dba.DsNeugokiHanteiKekkaBySyonoROWNUMBean;
import yuyu.batch.direct.dsneugokihantei.dsneugokihantei.dba.DsNeugokiHanteiTaisyouKykKihonsByKakutyoujobcdSyoriYmdSyoriKykTuukasyuBean;
import yuyu.batch.direct.dsneugokihantei.dsneugokihantei.dba.ZenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUMBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.DsDataMaintenanceHantei;
import yuyu.common.direct.dscommon.DsDataMaintenanceHanteiBean;
import yuyu.common.hozen.khcommon.KeisanKijyungk;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailTourokuJyoutaiKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.MT_DsMailHaisin;
import yuyu.def.db.entity.MW_DsMailHaisinRirekiWk;
import yuyu.def.db.entity.MW_DsNeugokiHanteiKekkaWk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * ダイレクトサービス 値動き判定 値動き判定クラス
 */
public class DsNeugokiHanteiBatch implements Batch {

    private final BizNumber FIRST_NEUGOKI_WARI = BizNumber.valueOf(1.0);

    private final BizNumber FIRST_KAGEN_IKITI = BizNumber.valueOf(0.9);

    private final BizNumber FIRST_JYOUGEN_IKITI = BizNumber.valueOf(1.1);

    private final Integer DS_MAIL_HAISIN_RENBAN_INIT = 100000001;

    private final String TABLE_ID = "IT_KykKihon";

    private final String FILTER_ID = "Kh001";

    private final String ASTERISK = "＊＊＊";

    private final String KIJUNKINGAKU = "基準金額";

    private final String ENDATEKIJUNKINGAKU = "円建基準金額";

    private final String KANKYOUIZONMOZI_TAISYO1 = "Ⅱ";

    private final String KANKYOUIZONMOZI_TAISYO1_TIKANMOZI = "II";

    private int dsSousinNoRenban = 1;

    private long dsNeugokiHanteiTargetKensuu = 0;

    private long dsNeugokiTargetKensuu = 0;

    private long dsNeugokiMailSousinTargetKensuu = 0;

    private BizDate syoriYmd = null;

    private C_Tuukasyu syoriKykTuukasyu = null;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private DsNeugokiHanteiBatchParam dsNeugokiHanteiBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private DsNeugokiHanteiDao dsNeugokiHanteiDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {

        return dsNeugokiHanteiBatchParam;
    }

    @Execute
    public void execute() {

        BizDate hoseiBeforSyoriYmd = dsNeugokiHanteiBatchParam.getSyoriYmd();

        syoriYmd = hoseiBeforSyoriYmd.addBusinessDays(dsNeugokiHanteiBatchParam.getSyoriymdhoseinissuu());
        syoriKykTuukasyu = dsNeugokiHanteiBatchParam.getSyorikyktuukasyu();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(hoseiBeforSyoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IMW1003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IMW1004),
            syoriKykTuukasyu.getValue()));

        if (!(C_Tuukasyu.USD.eq(syoriKykTuukasyu) || C_Tuukasyu.AUD.eq(syoriKykTuukasyu) ||
            C_Tuukasyu.BLNK.eq(syoriKykTuukasyu))) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0010,
                MessageUtil.getMessage(MessageId.IMW1004)));
        }

        dsNeugokiHanteiKakoInfoDel();

        dsNeugokiHantei();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(dsNeugokiHanteiTargetKensuu),
            "値動き判定対象件数"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(dsNeugokiTargetKensuu),
            "値動き対象件数"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(dsNeugokiMailSousinTargetKensuu),
            "値動きメール送信対象件数"));

    }

    @Transactional
    void dsNeugokiHanteiKakoInfoDel() {
        dsNeugokiHanteiDao.deleteDsNeugokiHanteiKekkaWkByDsdatasakuseiymd(syoriYmd);

        dsNeugokiHanteiDao.deleteDsMailHaisinBySousinymd(syoriYmd);

        dsNeugokiHanteiDao.deleteDsMailHaisinRirekiWkByDsdatasakuseiymd(syoriYmd);
    }

    @Transactional
    void dsNeugokiHantei() {

        String gyoumuKousinKinou = kinou.getKinouId();
        String gyoumuKousinsyaId = baseUserInfo.getUserId();
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        DsDataMaintenanceHantei dsDataMaintenanceHantei = SWAKInjector.getInstance(DsDataMaintenanceHantei.class);
        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = SWAKInjector.getInstance(DsDataMaintenanceHanteiBean.class);

        BizNumber kawaseRateUsd = BizNumber.ZERO;
        BizNumber kawaseRateAud = BizNumber.ZERO;

        if (C_Tuukasyu.USD.eq(syoriKykTuukasyu) || C_Tuukasyu.BLNK.eq(syoriKykTuukasyu)) {
            C_ErrorKbn errorKbn = getKawaseRate.exec(syoriYmd,
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                C_Tuukasyu.USD,
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.SYUKKINRATE,
                C_EigyoubiHoseiKbn.BLNK,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.OK.eq(errorKbn)) {
                kawaseRateUsd = getKawaseRate.getKawaserate();

            }
            else {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                    "為替レート（処理日）（米ドル）取得"));
            }
        }

        if (C_Tuukasyu.AUD.eq(syoriKykTuukasyu) || C_Tuukasyu.BLNK.eq(syoriKykTuukasyu)) {
            C_ErrorKbn errorKbn = getKawaseRate.exec(syoriYmd,
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                C_Tuukasyu.AUD,
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.SYUKKINRATE,
                C_EigyoubiHoseiKbn.BLNK,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.OK.eq(errorKbn)) {
                kawaseRateAud = getKawaseRate.getKawaserate();

            }
            else {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                    "為替レート（処理日）（豪ドル）取得"));
            }
        }

        try (ExDBResults<DsNeugokiHanteiTaisyouKykKihonsByKakutyoujobcdSyoriYmdSyoriKykTuukasyuBean>
        dsNeugokiHanteiTaisyouKykKihonBeanLst =
        dsNeugokiHanteiDao.getDsNeugokiHanteiTaisyouKykKihonsByKakutyoujobcdSyoriYmdSyorikyktuukasyu(
            dsNeugokiHanteiBatchParam.getIbKakutyoujobcd(), syoriYmd.addMonths(-6).getRekijyou(), syoriKykTuukasyu);

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {

            Integer dsMailHaisinRenban = 0;

            dsMailHaisinRenban = dsNeugokiHanteiDao.getDsMailHaisinRirekiWkMaxDsmailhaisinrenno();

            if (dsMailHaisinRenban != null) {
                dsMailHaisinRenban = dsMailHaisinRenban + 1;
            }
            else {
                dsMailHaisinRenban = DS_MAIL_HAISIN_RENBAN_INIT;
            }

            for (DsNeugokiHanteiTaisyouKykKihonsByKakutyoujobcdSyoriYmdSyoriKykTuukasyuBean
                dsNeugokiHanteiTaisyouKykKihonBean : dsNeugokiHanteiTaisyouKykKihonBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(dsNeugokiHanteiBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(dsNeugokiHanteiTaisyouKykKihonBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(dsNeugokiHanteiTaisyouKykKihonBean.getSyono());

                int syohinHanteiKbn =  SyouhinUtil.hantei(dsNeugokiHanteiTaisyouKykKihonBean.getSyouhncd());

                dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec(dsNeugokiHanteiTaisyouKykKihonBean.getSyono());

                C_UmuKbn dsDataMaintenanceUmuKbn = dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn();

                if(!C_UmuKbn.ARI.eq(dsDataMaintenanceUmuKbn)){

                    BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(dsNeugokiHanteiTaisyouKykKihonBean.getKykymd(),
                        syoriYmd,null,null,dsNeugokiHanteiTaisyouKykKihonBean.getKykjyoutai(),
                        dsNeugokiHanteiTaisyouKykKihonBean.getSyouhncd(),null);

                    CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(
                        dsNeugokiHanteiTaisyouKykKihonBean.getKyktuukasyu());
                    BizCurrency kaiyakuhrKyktuuka = BizCurrency.valueOf(0, currencyType);
                    KeisanWExtBean keisanWExtBean = null;

                    C_ErrorKbn errorKbn = keisanWExt.exec(dsNeugokiHanteiTaisyouKykKihonBean.getSyono(), syoriYmd);

                    if (C_ErrorKbn.OK.eq(errorKbn)) {
                        keisanWExtBean = keisanWExt.getKeisanWExtBean();
                    }
                    else {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                            "解約返戻金計算拡張情報作成（証券番号：" + dsNeugokiHanteiTaisyouKykKihonBean.getSyono() + "）"));
                    }

                    errorKbn = keisanW.exec(syoriYmd, kaiyakuhrKisnKijyunYM, keisanWExtBean);

                    if (C_ErrorKbn.OK.eq(errorKbn)) {
                        kaiyakuhrKyktuuka = keisanW.getW();
                    }
                    else {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                            "解約返戻金計算（証券番号：" + dsNeugokiHanteiTaisyouKykKihonBean.getSyono() + "）"));
                    }

                    BizNumber kawaseRateSyoriymdKyktuuka = BizNumber.ZERO;
                    BizCurrency kaiyakuhrYen = BizCurrency.valueOf(0);

                    if (C_Tuukasyu.USD.eq(dsNeugokiHanteiTaisyouKykKihonBean.getKyktuukasyu())) {
                        kawaseRateSyoriymdKyktuuka = kawaseRateUsd;

                    }
                    else if (C_Tuukasyu.AUD.eq(dsNeugokiHanteiTaisyouKykKihonBean.getKyktuukasyu())) {
                        kawaseRateSyoriymdKyktuuka = kawaseRateAud;
                    }

                    kaiyakuhrYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                        kaiyakuhrKyktuuka,
                        kawaseRateSyoriymdKyktuuka,
                        C_HasuusyoriKbn.AGE);

                    BizCurrency neugokiHanteiKjnknGk = BizCurrency.valueOf(0);
                    C_Tkhukaumu yennykntkhkUmu = C_Tkhukaumu.BLNK;

                    if (BizUtil.isZero(dsNeugokiHanteiTaisyouKykKihonBean.getGengakugoyenitijibrpstgk())) {
                        if (C_UmuKbn.ARI.eq(dsNeugokiHanteiTaisyouKykKihonBean.getYennykntkhkumu())) {
                            yennykntkhkUmu = C_Tkhukaumu.HUKA;

                        }
                        else {
                            yennykntkhkUmu = C_Tkhukaumu.NONE;

                        }

                        KeisanKijyungk keisankijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);

                        errorKbn = keisankijyungk.exec(dsNeugokiHanteiTaisyouKykKihonBean.getRyosyuymd(),
                            dsNeugokiHanteiTaisyouKykKihonBean.getRsgaku(),
                            dsNeugokiHanteiTaisyouKykKihonBean.getHrkp(),
                            dsNeugokiHanteiTaisyouKykKihonBean.getKyktuukasyu(),
                            yennykntkhkUmu);

                        if (C_ErrorKbn.OK.eq(errorKbn)) {
                            neugokiHanteiKjnknGk = keisankijyungk.getKijyungk();

                        }
                        else {
                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                                "基準金額計算（証券番号：" + dsNeugokiHanteiTaisyouKykKihonBean.getSyono() + "）"));
                        }
                    }
                    else {
                        neugokiHanteiKjnknGk = dsNeugokiHanteiTaisyouKykKihonBean.getGengakugoyenitijibrpstgk();
                    }

                    if (BizUtil.isZero(kaiyakuhrYen) || BizUtil.isZero(neugokiHanteiKjnknGk)) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                            "値動き割合算出（証券番号：" + dsNeugokiHanteiTaisyouKykKihonBean.getSyono() + "）"));
                    }

                    BizNumber neugokiwari = kaiyakuhrYen.divideBizCurrency(neugokiHanteiKjnknGk, 14, RoundingMode.DOWN);

                    DsNeugokiHanteiKekkaBySyonoROWNUMBean dsNeugokiHanteiKekkaBySyonoROWNUMBean =
                        dsNeugokiHanteiDao.getDsNeugokiHanteiKekkaBySyonoROWNUM(
                            dsNeugokiHanteiTaisyouKykKihonBean.getSyono());

                    BizNumber kagenIkiti = BizNumber.ZERO;
                    BizNumber jyougenIkiti = BizNumber.ZERO;
                    BizNumber zenkaiNeugokiWari = BizNumber.ZERO;

                    if (dsNeugokiHanteiKekkaBySyonoROWNUMBean != null) {
                        kagenIkiti = dsNeugokiHanteiKekkaBySyonoROWNUMBean.getNeugokitoutatulinefile().subtract(
                            BizNumber.valueOf(0.1));
                        jyougenIkiti = dsNeugokiHanteiKekkaBySyonoROWNUMBean.getNeugokitoutatulinefile().add(
                            BizNumber.valueOf(0.1));
                        zenkaiNeugokiWari = dsNeugokiHanteiKekkaBySyonoROWNUMBean.getNeugokiwari();
                    }
                    else {
                        kagenIkiti = FIRST_KAGEN_IKITI;
                        jyougenIkiti = FIRST_JYOUGEN_IKITI;
                        zenkaiNeugokiWari = FIRST_NEUGOKI_WARI;
                    }

                    ZenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUMBean
                    zenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUMBean =
                    dsNeugokiHanteiDao.getZenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUM(
                        dsNeugokiHanteiTaisyouKykKihonBean.getSyono());

                    BizNumber mailHaisinyouKagenIkiti = BizNumber.ZERO;
                    BizNumber mailHaisinyouJyougenIkiti = BizNumber.ZERO;
                    BizNumber zenkaiMailHaisinjiNeugokiWari = BizNumber.ZERO;

                    if (zenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUMBean != null) {
                        mailHaisinyouKagenIkiti =
                            zenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUMBean.getNeugokitoutatulinemail().subtract(
                                BizNumber.valueOf(0.1));
                        mailHaisinyouJyougenIkiti =
                            zenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUMBean.getNeugokitoutatulinemail().add(
                                BizNumber.valueOf(0.1));
                        zenkaiMailHaisinjiNeugokiWari =
                            zenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUMBean.getNeugokiwari();

                    }
                    else {
                        mailHaisinyouKagenIkiti = FIRST_KAGEN_IKITI;
                        mailHaisinyouJyougenIkiti = FIRST_JYOUGEN_IKITI;
                        zenkaiMailHaisinjiNeugokiWari = FIRST_NEUGOKI_WARI;
                    }

                    DsKokyakuInfoBySyonoBean dsKokyakuInfoBySyonoBean = null;
                    List<DsKokyakuInfoBySyonoBean> dsKokyakuInfoBySyonoBeanLst =
                        dsNeugokiHanteiDao.getDsKokyakuInfoBySyono(dsNeugokiHanteiTaisyouKykKihonBean.getSyono());

                    if (dsKokyakuInfoBySyonoBeanLst != null && dsKokyakuInfoBySyonoBeanLst.size() != 0) {
                        dsKokyakuInfoBySyonoBean = dsKokyakuInfoBySyonoBeanLst.get(0);
                    }

                    C_YouhiKbn mailSousinYhKbn = C_YouhiKbn.HUYOU;

                    if (dsKokyakuInfoBySyonoBean != null &&
                        ((C_DsKokyakuJtKbn.YUUKOU.eq(dsKokyakuInfoBySyonoBean.getDskokyakujtkbn()) ||
                            C_DsTeisiRiyuuKbn.LOCK_OUT.eq(dsKokyakuInfoBySyonoBean.getDsteisiriyuukbn()) ||
                            C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU.eq(
                                dsKokyakuInfoBySyonoBean.getDsteisiriyuukbn())) &&
                                C_DsMailTourokuJyoutaiKbn.TOUROKU.eq(
                                    dsKokyakuInfoBySyonoBean.getDsmailtourokujyoutaikbn()) &&
                                    C_DsMailSousinJyoutaiKbn.YUUKOU.eq(
                                        dsKokyakuInfoBySyonoBean.getDsmailsousinjyoutaikbn())) &&
                                        (neugokiwari.compareTo(mailHaisinyouKagenIkiti) <= 0 ||
                                        neugokiwari.compareTo(mailHaisinyouJyougenIkiti) >= 0)) {
                        mailSousinYhKbn = C_YouhiKbn.YOU;
                    }

                    if (neugokiwari.compareTo(kagenIkiti) <= 0 || neugokiwari.compareTo(jyougenIkiti) >= 0 ||
                        C_YouhiKbn.YOU.eq(mailSousinYhKbn)) {

                        BizNumber neugokiToutatulineFile = BizNumber.ZERO;
                        BizNumber neugokiToutatulineMail = BizNumber.ZERO;

                        if (neugokiwari.compareTo(kagenIkiti) <= 0 || neugokiwari.compareTo(jyougenIkiti) >= 0) {
                            if (zenkaiNeugokiWari.compareTo(neugokiwari) < 0) {
                                neugokiToutatulineFile = neugokiwari.round(1, RoundingMode.DOWN);
                            }
                            else {
                                neugokiToutatulineFile = neugokiwari.round(1, RoundingMode.UP);
                            }
                        }

                        if (C_YouhiKbn.YOU.eq(mailSousinYhKbn)) {
                            if (zenkaiMailHaisinjiNeugokiWari.compareTo(neugokiwari) < 0) {
                                neugokiToutatulineMail = neugokiwari.round(1, RoundingMode.DOWN);
                            }
                            else {
                                neugokiToutatulineMail = neugokiwari.round(1, RoundingMode.UP);
                            }
                        }

                        MW_DsNeugokiHanteiKekkaWk dsNeugokiHanteiKekkaWk = new MW_DsNeugokiHanteiKekkaWk();
                        String dsSousinNo = gyoumuKousinTime.substring(2, 8) + "T" + gyoumuKousinTime.substring(8, 12) +
                            "NA" + Strings.padStart(String.valueOf(dsSousinNoRenban), 8, '0');

                        dsNeugokiHanteiKekkaWk.setDsdatasakuseiymd(syoriYmd);
                        dsNeugokiHanteiKekkaWk.setSyono(dsNeugokiHanteiTaisyouKykKihonBean.getSyono());

                        if (dsKokyakuInfoBySyonoBean != null) {
                            dsNeugokiHanteiKekkaWk.setDskokno(dsKokyakuInfoBySyonoBean.getDskokno());
                        }

                        if (dsKokyakuInfoBySyonoBean != null) {
                            dsNeugokiHanteiKekkaWk.setDsmailaddressrenban(
                                dsKokyakuInfoBySyonoBean.getDsmailaddressrenban());
                        }

                        dsNeugokiHanteiKekkaWk.setKyknmkn(dsNeugokiHanteiTaisyouKykKihonBean.getKyknmkn());
                        dsNeugokiHanteiKekkaWk.setKykymd(dsNeugokiHanteiTaisyouKykKihonBean.getKykymd());

                        if (!BizUtil.isBlank(dsNeugokiHanteiTaisyouKykKihonBean.getBosyuujiaatukaidrtencd())) {
                            dsNeugokiHanteiKekkaWk.setBosyuujiaatukaidrtencd(
                                dsNeugokiHanteiTaisyouKykKihonBean.getBosyuujiaatukaidrtencd());
                        }

                        if (!BizUtil.isBlank(dsNeugokiHanteiTaisyouKykKihonBean.getBosyuujibatukaidrtencd())) {
                            dsNeugokiHanteiKekkaWk.setBosyuujibatukaidrtencd(
                                dsNeugokiHanteiTaisyouKykKihonBean.getBosyuujibatukaidrtencd());
                        }

                        dsNeugokiHanteiKekkaWk.setAisyoumeikbn(dsNeugokiHanteiTaisyouKykKihonBean.getAisyoumeikbn());
                        dsNeugokiHanteiKekkaWk.setKyktuukasyu(dsNeugokiHanteiTaisyouKykKihonBean.getKyktuukasyu());
                        dsNeugokiHanteiKekkaWk.setKaiyakuhryen(kaiyakuhrYen);
                        dsNeugokiHanteiKekkaWk.setItijibrp(dsNeugokiHanteiTaisyouKykKihonBean.getHrkp());
                        dsNeugokiHanteiKekkaWk.setNeugokihanteikjnkngk(neugokiHanteiKjnknGk);
                        dsNeugokiHanteiKekkaWk.setNeugokiwari(neugokiwari.round(2, RoundingMode.DOWN));
                        dsNeugokiHanteiKekkaWk.setNeugokitoutatulinefile(neugokiToutatulineFile);
                        dsNeugokiHanteiKekkaWk.setNeugokitoutatulinemail(neugokiToutatulineMail);

                        if (neugokiwari.compareTo(kagenIkiti) <= 0 || neugokiwari.compareTo(jyougenIkiti) >= 0) {
                            dsNeugokiHanteiKekkaWk.setNeugokihanteiumukbn(C_UmuKbn.ARI);
                        }
                        else {
                            dsNeugokiHanteiKekkaWk.setNeugokihanteiumukbn(C_UmuKbn.NONE);
                        }

                        dsNeugokiHanteiKekkaWk.setMailsousinyhkbn(mailSousinYhKbn);

                        if (dsKokyakuInfoBySyonoBean != null && C_DsMailTourokuJyoutaiKbn.TOUROKU.eq(
                            dsKokyakuInfoBySyonoBean.getDsmailtourokujyoutaikbn())) {
                            dsNeugokiHanteiKekkaWk.setMailaddresstourokuumukbn(C_UmuKbn.ARI);
                        }
                        else {
                            dsNeugokiHanteiKekkaWk.setMailaddresstourokuumukbn(C_UmuKbn.NONE);
                        }

                        if (C_YouhiKbn.YOU.eq(mailSousinYhKbn)) {
                            dsNeugokiHanteiKekkaWk.setDssousinno(dsSousinNo);
                        }

                        dsNeugokiHanteiKekkaWk.setGyoumuKousinKinou(gyoumuKousinKinou);
                        dsNeugokiHanteiKekkaWk.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                        dsNeugokiHanteiKekkaWk.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(dsNeugokiHanteiKekkaWk);

                        dsNeugokiHanteiDao.addMultipleInsertEntity(multipleEntityInserter, dsNeugokiHanteiKekkaWk);

                        dsNeugokiTargetKensuu++;

                        if (C_YouhiKbn.YOU.eq(mailSousinYhKbn)) {
                            String kanjiHoujinSyougou = "";
                            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

                            List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(
                                dsNeugokiHanteiTaisyouKykKihonBean.getBosyuujiaatukaidrtencd());

                            if (bzGetAgInfoBeanList != null && bzGetAgInfoBeanList.size() != 0 &&
                                !BizUtil.isBlank(bzGetAgInfoBeanList.get(0).getKanjiHoujinSyougou())) {

                                kanjiHoujinSyougou = bzGetAgInfoBeanList.get(0).getKanjiHoujinSyougou();

                            }
                            else {

                                kanjiHoujinSyougou = ASTERISK;
                            }

                            String aisyouMei = dsNeugokiHanteiTaisyouKykKihonBean.getAisyoumeikbn().getContent().
                                replace(KANKYOUIZONMOZI_TAISYO1,KANKYOUIZONMOZI_TAISYO1_TIKANMOZI);

                            String kijunKingakuMei = "";
                            if(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn ||
                                SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {

                                kijunKingakuMei = KIJUNKINGAKU;

                            }
                            else {

                                kijunKingakuMei = ENDATEKIJUNKINGAKU;

                            }

                            String sasikomikoumokudai01 = new BizDateFormat("yyyy年MM月dd日", FillStyle.None).format(dsNeugokiHanteiTaisyouKykKihonBean.getKykymd()) +
                                "に" + kanjiHoujinSyougou + "様にてご加入いただきました、以下の保険商品の資産状況をお知らせいたします。\\n\\n";
                            String sasikomikoumokudai02 = "【商品名】" + aisyouMei + "\\n" +
                                "【" + kijunKingakuMei + "に対する解約返戻金の割合】" + String.valueOf(neugokiwari.round(2, RoundingMode.DOWN).multiply(100)) + "％\\n\\n";
                            String sasikomikoumokudai03 = "本お知らせメールは、" + kijunKingakuMei + "に対し、解約返戻金額が一定の割合に増加・減少した場合にお知らせしております。\\n";
                            String sasikomikoumokudai04 = "※一定の割合＝10％刻みの増減割合、・・・70％、80％、90％、100％、110％、120％、130％・・・でお知らせ\\n\\n";
                            String sasikomikoumokudai05 = "解約返戻金などのご契約内容の詳細につきましては、スミセイダイレクトサービスにログインしてご確認ください。\\n";
                            String sasikomikoumokudai06 = "また、お知らせメールの停止につきましてもスミセイダイレクトサービスからお手続きください。\\n";

                            MT_DsMailHaisin dsMailHaisin = new MT_DsMailHaisin();

                            dsMailHaisin.setSousinymd(syoriYmd);
                            dsMailHaisin.setDskokmailaddressskbtkey(dsKokyakuInfoBySyonoBean.getDskokno() +
                                Strings.padStart(String.valueOf(dsKokyakuInfoBySyonoBean.getDsmailaddressrenban()),9, '0'));
                            dsMailHaisin.setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn.NEUGOKIMAIL);
                            dsMailHaisin.setDssousinno(dsSousinNo);
                            dsMailHaisin.setSyono(dsNeugokiHanteiTaisyouKykKihonBean.getSyono());
                            dsMailHaisin.setDsmailaddress(dsKokyakuInfoBySyonoBean.getDsmailaddress());
                            dsMailHaisin.setSasikomikoumokusyou01(String.valueOf(
                                dsNeugokiHanteiTaisyouKykKihonBean.getKykymd().getYear()));
                            dsMailHaisin.setSasikomikoumokusyou02(String.valueOf(
                                dsNeugokiHanteiTaisyouKykKihonBean.getKykymd().getMonth()));
                            dsMailHaisin.setSasikomikoumokusyou03(String.valueOf(
                                dsNeugokiHanteiTaisyouKykKihonBean.getKykymd().getDay()));
                            dsMailHaisin.setSasikomikoumokusyou04(String.valueOf(neugokiwari.round(2, RoundingMode.DOWN).multiply(100)));
                            dsMailHaisin.setSasikomikoumokutyuu01(kanjiHoujinSyougou);
                            dsMailHaisin.setSasikomikoumokutyuu02(aisyouMei);
                            dsMailHaisin.setSasikomikoumokutyuu03("（送信番号" + gyoumuKousinTime.substring(2, 8) + "T" + gyoumuKousinTime.substring(8, 12) +
                                "NA" + Strings.padStart(String.valueOf(dsSousinNoRenban), 8, '0') + "）");
                            dsMailHaisin.setSasikomikoumokudai01(sasikomikoumokudai01);
                            dsMailHaisin.setSasikomikoumokudai02(sasikomikoumokudai02);
                            dsMailHaisin.setSasikomikoumokudai03(sasikomikoumokudai03);
                            dsMailHaisin.setSasikomikoumokudai04(sasikomikoumokudai04);
                            dsMailHaisin.setSasikomikoumokudai05(sasikomikoumokudai05);
                            dsMailHaisin.setSasikomikoumokudai06(sasikomikoumokudai06);

                            BizPropertyInitializer.initialize(dsMailHaisin);

                            dsNeugokiHanteiDao.addMultipleInsertEntity(multipleEntityInserter, dsMailHaisin);

                            MW_DsMailHaisinRirekiWk dsMailHaisinRirekiWk = new MW_DsMailHaisinRirekiWk();

                            dsMailHaisinRirekiWk.setDsdatasakuseiymd(syoriYmd);
                            dsMailHaisinRirekiWk.setDskokno(dsKokyakuInfoBySyonoBean.getDskokno());
                            dsMailHaisinRirekiWk.setDsmailhaisinrenban(dsMailHaisinRenban);
                            dsMailHaisinRirekiWk.setHaisinjidsmailaddress(dsKokyakuInfoBySyonoBean.getDsmailaddress());
                            dsMailHaisinRirekiWk.setDssousinno(dsSousinNo);
                            dsMailHaisinRirekiWk.setGyoumuKousinKinou(gyoumuKousinKinou);
                            dsMailHaisinRirekiWk.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                            dsMailHaisinRirekiWk.setGyoumuKousinTime(gyoumuKousinTime);
                            dsMailHaisinRirekiWk.setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn.NEUGOKIMAIL);
                            dsMailHaisinRirekiWk.setSyono(dsNeugokiHanteiTaisyouKykKihonBean.getSyono());

                            BizPropertyInitializer.initialize(dsMailHaisinRirekiWk);

                            dsNeugokiHanteiDao.addMultipleInsertEntity(multipleEntityInserter, dsMailHaisinRirekiWk);

                            dsMailHaisinRenban++;
                            dsSousinNoRenban++;
                            dsNeugokiMailSousinTargetKensuu++;

                        }
                    }

                    dsNeugokiHanteiTargetKensuu++;
                }

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(dsNeugokiHanteiTaisyouKykKihonBean.getSyono());
                if (kykKihon != null) {
                    kykKihon.noCheckDetach();
                }

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(dsNeugokiHanteiTaisyouKykKihonBean.getSyono());
                if (ansyuKihon != null) {
                    ansyuKihon.noCheckDetach();
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}