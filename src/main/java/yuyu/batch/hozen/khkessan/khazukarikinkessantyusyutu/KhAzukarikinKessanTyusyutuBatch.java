package yuyu.batch.hozen.khkessan.khazukarikinkessantyusyutu;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khkessan.khazukarikinkessantyusyutu.dba.KhAzukarikinKessanInfosByKakutyoujobcdKsnbiymdBean;
import yuyu.batch.hozen.khkessan.khazukarikinkessantyusyutu.dba.KhAzukarikinKessanTyusyutuDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanAzukariGanrikin;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AzukarijikiKbn;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 決算 預り金決算情報抽出</BR>
 */
public class KhAzukarikinKessanTyusyutuBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "IT_KykKihon";

    private static final String RECOVERYFILTERIDKBNID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhAzukarikinKessanTyusyutuBatchParam batchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhAzukarikinKessanTyusyutuDao khAzukarikinKessanTyusyutuDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private BizDate zenjigyounendoKsnymd4q = null;

    private BizDate ksnymd1q = null;

    private BizDate ksnymd2q = null;

    private BizDate ksnymd3q = null;

    private BizDate ksnymd4q = null;

    private BizDate zenjigyounendoKwsratekjymd = null;

    private BizDate kwsratekjymd1q = null;

    private BizNumber kawaserate1q = BizNumber.ZERO;

    private BizDate kwsratekjymd2q = null;

    private BizNumber kawaserate2q = BizNumber.ZERO;

    private BizDate kwsratekjymd3q = null;

    private BizNumber kawaserate3q = BizNumber.ZERO;

    private BizDate kwsratekjymd4q = null;

    private BizNumber kawaserate4q = BizNumber.ZERO;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = batchParam.getSyoriYmd();

        String ibKakutyoujobcd = batchParam.getIbKakutyoujobcd();

        BizDate kessanYmd = batchParam.getKessanYmd();

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        int kensuCount = 0;
        List<IT_AzukarikinKessankanri> azukarikinKessankanriList =
            khAzukarikinKessanTyusyutuDao.getKhAzukarikinKessanInfoByKessankijyunymd(kessanYmd);
        hozenDomManager.delete(azukarikinKessankanriList);
        hozenDomManager.flush();

        try (ExDBResults<KhAzukarikinKessanInfosByKakutyoujobcdKsnbiymdBean> exDBResults =
            khAzukarikinKessanTyusyutuDao.getKhAzukarikinKessanInfosByKakutyoujobcdKsnbiymd(ibKakutyoujobcd, kessanYmd);
            EntityInserter<IT_AzukarikinKessankanri> entityInserter = new EntityInserter<>()) {

            BizDateY kessanNendo = calcNendo(kessanYmd);

            BizDate zenjigyouNendo = BizDateYM.valueOf(kessanNendo, 3).getLastDay();

            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
            String kinouId = khozenCommonParam.getFunctionId();
            String userId = khozenCommonParam.getUserID();
            String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

            for (KhAzukarikinKessanInfosByKakutyoujobcdKsnbiymdBean azukarikinKessanInfosByKakutyoujobcdKsnbiymdBean : exDBResults) {

                IT_KykKihon kykKihon = azukarikinKessanInfosByKakutyoujobcdKsnbiymdBean.getKykKihon();
                IT_KykSyouhn kykSyouhn = azukarikinKessanInfosByKakutyoujobcdKsnbiymdBean.getKykSyouhn();
                IT_Azukarikin azukarikin = azukarikinKessanInfosByKakutyoujobcdKsnbiymdBean.getAzukarikin();

                String syono = kykKihon.getSyono();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykKihon.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
                SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
                    kykSyouhn.getSyouhncd(), kykSyouhn.getKyktuukasyu());
                if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {
                    throw new CommonBizAppException(
                        MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", azukarikin.getSyono()));
                }

                C_Segcd kbnkeirisegcd = syouhinbetuSegmentBean.getSegcd1();
                IT_KhBikinkanri khBikinkanri = khAzukarikinKessanTyusyutuDao.getKhBikinkanriBySyonoKsnbiymd(syono, kessanYmd);
                BizDate calckijyunymd = null;
                C_Tuukasyu shrtuukasyu = C_Tuukasyu.BLNK;
                C_BknJkuKbn bknjkukbn = C_BknJkuKbn.BLNK;
                BizDate bikinkeiymd = null;
                C_BkncdKbn bkncdkbn = C_BkncdKbn.BLNK;
                BizDate shrkwsratekjnymd = null;
                BizNumber shrkwsrate = BizNumber.ZERO;
                BizDate gaikashrkwsratekjnymd = null;
                BizNumber gaikashrkwsrate = BizNumber.ZERO;

                C_Tuukasyu azukariTuuka = azukarikin.getTuukasyu();
                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                CurrencyType azukariType = henkanTuuka.henkanTuukaKbnToType(azukariTuuka);
                BizCurrency azukariganrikin = BizCurrency.valueOf(0);
                BizCurrency tounendgankin = BizCurrency.valueOf(0);
                BizDate kwsratekjymd = null;
                BizNumber kawaserate = BizNumber.ZERO;
                BizCurrency gaikaazukariganrikin = BizCurrency.valueOf(0, azukariType);
                BizCurrency gaikatounendgankin = BizCurrency.valueOf(0, azukariType);
                BizCurrency gaikaknsnmaeazukariganrikin = BizCurrency.valueOf(0);
                BizCurrency gaikaknsnmaetounendgankin = BizCurrency.valueOf(0);

                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                if (khBikinkanri != null) {
                    calckijyunymd = khBikinkanri.getCalckijyunymd();
                    shrtuukasyu = khBikinkanri.getShrtuukasyu();
                    bknjkukbn = khBikinkanri.getBknjkukbn();
                    bikinkeiymd = khBikinkanri.getBknkktymd();
                    bkncdkbn = khBikinkanri.getBkncdkbn();
                    shrkwsratekjnymd = khBikinkanri.getShrkwsratekjnymd();
                    shrkwsrate = khBikinkanri.getShrkwsrate();
                    gaikashrkwsratekjnymd = khBikinkanri.getGaikashrkwsratekjnymd();
                    gaikashrkwsrate = khBikinkanri.getGaikashrkwsrate();
                }
                else {
                    JT_SiBikinkanri siBikinkanri =khAzukarikinKessanTyusyutuDao.getSiBikinkanriBySyonoKsnbiymd(syono, kessanYmd);

                    if (siBikinkanri != null) {
                        calckijyunymd = siBikinkanri.getCalckijyunymd();
                        shrtuukasyu = siBikinkanri.getShrtuukasyu();
                        bknjkukbn = siBikinkanri.getBknjkukbn();
                        bikinkeiymd = siBikinkanri.getBknkktymd();
                        bkncdkbn = siBikinkanri.getBkncdkbn();
                        shrkwsratekjnymd = siBikinkanri.getShrkwsratekjnymd();
                        shrkwsrate = siBikinkanri.getShrkwsrate();

                        if (C_Tuukasyu.BLNK.eq(shrtuukasyu)) {
                            shrtuukasyu = siBikinkanri.getKyktuukasyu();
                        }

                        if (!C_Tuukasyu.JPY.eq(shrtuukasyu)) {
                            getKawaseRate.exec(
                                shrkwsratekjnymd,
                                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                                shrtuukasyu,
                                C_Tuukasyu.JPY,
                                C_KawasetekiyoKbn.TTM,
                                C_KawasetsryKbn.SYUKKINRATE,
                                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                                C_YouhiKbn.HUYOU);
                            gaikashrkwsratekjnymd = getKawaseRate.getKwsrateKjYmd();
                            gaikashrkwsrate = getKawaseRate.getKawaserate();

                        }

                    }
                    else if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                        if (BizDateUtil.compareYmd(kykSyouhn.getSyoumetuymd(), zenjigyouNendo) == BizDateUtil.COMPARE_GREATER) {
                            JT_Sk skInfo = khAzukarikinKessanTyusyutuDao.getSkBySyono(syono);
                            if (skInfo != null) {
                                calckijyunymd = kykSyouhn.getSyoumetuymd();
                                shrtuukasyu = skInfo.getShrtuukasyu();
                                shrkwsratekjnymd = skInfo.getShrkwsratekjnymd();
                                shrkwsrate = skInfo.getShrkwsrate();
                                gaikashrkwsratekjnymd = skInfo.getGaikaknsnkwsratekjymd();
                                gaikashrkwsrate = skInfo.getGaikaknsnkwsrate();

                            }
                            else {
                                IT_KhShrRireki khShrRireki = khAzukarikinKessanTyusyutuDao.getKhShrRirekiBySyono(syono);

                                if (khShrRireki != null) {
                                    calckijyunymd = kykSyouhn.getSyoumetuymd();
                                    shrtuukasyu = khShrRireki.getShrtuukasyu();
                                    shrkwsratekjnymd = khShrRireki.getShrkwsratekjnymd();
                                    shrkwsrate = khShrRireki.getShrkwsrate();
                                    gaikashrkwsratekjnymd = khShrRireki.getGaikashrkwsratekjnymd();
                                    gaikashrkwsrate = khShrRireki.getGaikashrkwsrate();
                                }
                                else {
                                    continue;
                                }
                            }
                        }
                        else {
                            continue;
                        }
                    }
                    else {
                        calckijyunymd = kessanYmd;
                        shrtuukasyu = azukariTuuka;
                    }
                }

                BizDateY azukarikinhsiymdJigyouNendo = calcNendo(azukarikin.getAzukarikinhsiymd());

                C_AzukarijikiKbn azukarijikiKbn = C_AzukarijikiKbn.BLNK;

                if (kessanNendo.compareTo(azukarikinhsiymdJigyouNendo) == 0) {
                    azukarijikiKbn = C_AzukarijikiKbn.TOUNEND;
                }
                else if (kessanNendo.compareTo(azukarikinhsiymdJigyouNendo) > 0) {
                    azukarijikiKbn = C_AzukarijikiKbn.ZENJIGYOUNENDOIZEN;
                }

                BizDate kessankwsratekjnymd = null;
                BizNumber kessankwsrate = BizNumber.ZERO;

                setSihankimatuKawaserate(kessanYmd, azukariTuuka);

                KeisanAzukariGanrikin keisanAzukariGanrikin = SWAKInjector.getInstance(KeisanAzukariGanrikin.class);
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                if (C_Tuukasyu.JPY.eq(azukariTuuka)) {
                    if (C_BkncdKbn.KAIYAKU.eq(bkncdkbn) ||
                        C_BkncdKbn.SIBOUUKETUKE.eq(bkncdkbn) ||
                        C_BkncdKbn.SIBOUKARIUKETUKE.eq(bkncdkbn) ||
                        C_BkncdKbn.MENSEKI.eq(bkncdkbn) ||
                        C_BkncdKbn.SIBOUKAIJYO.eq(bkncdkbn)) {

                        if (!C_Tuukasyu.JPY.eq(shrtuukasyu)) {
                            if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_EQUAL ||
                                BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_LESSER) {
                                if (BizDateUtil.compareYmd(calckijyunymd, zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_EQUAL ||
                                    BizDateUtil.compareYmd(calckijyunymd, zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_LESSER) {
                                    C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                        azukarikin.getAzukarikinhsiymd(),
                                        calckijyunymd,
                                        azukarikin.getAzukarikingk(),
                                        azukariTuuka);

                                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                        throw new CommonBizAppException(
                                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                    }

                                    gaikaknsnmaeazukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                    gaikaknsnmaetounendgankin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                }
                                else {
                                    C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                        azukarikin.getAzukarikinhsiymd(),
                                        zenjigyounendoKsnymd4q,
                                        azukarikin.getAzukarikingk(),
                                        azukariTuuka);

                                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                        throw new CommonBizAppException(
                                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                    }

                                    gaikaknsnmaetounendgankin = keisanAzukariGanrikin.getAzukariGanrikinYen();

                                    errorKbn = keisanAzukariGanrikin.exec(
                                        azukarikin.getAzukarikinhsiymd(),
                                        calckijyunymd,
                                        azukarikin.getAzukarikingk(),
                                        azukariTuuka);

                                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                        throw new CommonBizAppException(
                                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                    }

                                    gaikaknsnmaeazukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                }
                            }
                            else {
                                C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                    azukarikin.getAzukarikinhsiymd(),
                                    calckijyunymd,
                                    azukarikin.getAzukarikingk(),
                                    azukariTuuka);

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    throw new CommonBizAppException(
                                        MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                }

                                gaikaknsnmaeazukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                gaikaknsnmaetounendgankin = azukarikin.getAzukarikingk();
                            }

                            gaikaazukariganrikin = keisanGaikakanzan.execDivide(
                                shrtuukasyu,
                                gaikaknsnmaeazukariganrikin,
                                gaikashrkwsrate,
                                C_HasuusyoriKbn.AGE);
                            gaikatounendgankin = keisanGaikakanzan.execDivide(
                                shrtuukasyu,
                                gaikaknsnmaetounendgankin,
                                gaikashrkwsrate,
                                C_HasuusyoriKbn.AGE);
                        }
                        else {
                            gaikashrkwsratekjnymd = null;
                            gaikashrkwsrate = BizNumber.ZERO;
                        }
                    }
                    else if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn()) &&
                        kykSyouhn.getSyoumetuymd() != null) {
                        if (!C_Tuukasyu.JPY.eq(shrtuukasyu)) {
                            if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_EQUAL ||
                                BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_LESSER) {
                                if (BizDateUtil.compareYmd(calckijyunymd, zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_EQUAL ||
                                    BizDateUtil.compareYmd(calckijyunymd, zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_LESSER) {
                                    C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                        azukarikin.getAzukarikinhsiymd(),
                                        calckijyunymd,
                                        azukarikin.getAzukarikingk(),
                                        azukariTuuka);

                                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                        throw new CommonBizAppException(
                                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                    }

                                    gaikaknsnmaeazukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                    gaikaknsnmaetounendgankin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                }
                                else {
                                    C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                        azukarikin.getAzukarikinhsiymd(),
                                        zenjigyounendoKsnymd4q,
                                        azukarikin.getAzukarikingk(),
                                        azukariTuuka);

                                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                        throw new CommonBizAppException(
                                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                    }

                                    gaikaknsnmaetounendgankin = keisanAzukariGanrikin.getAzukariGanrikinYen();

                                    errorKbn = keisanAzukariGanrikin.exec(
                                        azukarikin.getAzukarikinhsiymd(),
                                        calckijyunymd,
                                        azukarikin.getAzukarikingk(),
                                        azukariTuuka);

                                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                        throw new CommonBizAppException(
                                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                    }

                                    gaikaknsnmaeazukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                }
                            }
                            else {
                                C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                    azukarikin.getAzukarikinhsiymd(),
                                    calckijyunymd,
                                    azukarikin.getAzukarikingk(),
                                    azukariTuuka);

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    throw new CommonBizAppException(
                                        MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                }

                                gaikaknsnmaeazukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                gaikaknsnmaetounendgankin = azukarikin.getAzukarikingk();
                            }

                            gaikaazukariganrikin = keisanGaikakanzan.execDivide(
                                shrtuukasyu,
                                gaikaknsnmaeazukariganrikin,
                                gaikashrkwsrate,
                                C_HasuusyoriKbn.AGE);
                            gaikatounendgankin = keisanGaikakanzan.execDivide(
                                shrtuukasyu,
                                gaikaknsnmaetounendgankin,
                                gaikashrkwsrate,
                                C_HasuusyoriKbn.AGE);
                        }
                        else {
                            gaikashrkwsratekjnymd = null;
                            gaikashrkwsrate = BizNumber.ZERO;
                        }
                    }
                }
                else {
                    if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_EQUAL ||
                        BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_LESSER) {
                        if (BizDateUtil.compareYmd(calckijyunymd, zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_EQUAL ||
                            BizDateUtil.compareYmd(calckijyunymd, zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_LESSER) {
                            C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                azukarikin.getAzukarikinhsiymd(),
                                calckijyunymd,
                                azukarikin.getAzukarikingk(),
                                azukariTuuka);

                            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                throw new CommonBizAppException(
                                    MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                            }

                            gaikaazukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();
                            gaikatounendgankin = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();
                        }
                        else {
                            C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                azukarikin.getAzukarikinhsiymd(),
                                zenjigyounendoKsnymd4q,
                                azukarikin.getAzukarikingk(),
                                azukariTuuka);

                            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                throw new CommonBizAppException(
                                    MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                            }

                            gaikatounendgankin = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();

                            errorKbn = keisanAzukariGanrikin.exec(
                                azukarikin.getAzukarikinhsiymd(),
                                calckijyunymd,
                                azukarikin.getAzukarikingk(),
                                azukariTuuka);

                            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                throw new CommonBizAppException(
                                    MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                            }

                            gaikaazukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();
                        }
                    }
                    else {
                        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                            azukarikin.getAzukarikinhsiymd(),
                            calckijyunymd,
                            azukarikin.getAzukarikingk(),
                            azukariTuuka);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new CommonBizAppException(
                                MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                        }

                        gaikaazukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();
                        gaikatounendgankin = azukarikin.getAzukarikingk();
                    }

                    gaikashrkwsratekjnymd = null;
                    gaikashrkwsrate = BizNumber.ZERO;
                }

                if (!C_Tuukasyu.JPY.eq(shrtuukasyu)) {
                    getKawaseRate.exec(
                        kessanYmd,
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                        shrtuukasyu,
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.JISSEIRATE,
                        C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                        C_YouhiKbn.HUYOU);

                    kessankwsratekjnymd = getKawaseRate.getKwsrateKjYmd();
                    kessankwsrate = getKawaseRate.getKawaserate();
                }

                if (C_BkncdKbn.KAIYAKU.eq(bkncdkbn) ||
                    C_BkncdKbn.SIBOUUKETUKE.eq(bkncdkbn) ||
                    C_BkncdKbn.SIBOUKARIUKETUKE.eq(bkncdkbn) ||
                    C_BkncdKbn.MENSEKI.eq(bkncdkbn) ||
                    C_BkncdKbn.SIBOUKAIJYO.eq(bkncdkbn)) {
                    if (C_Tuukasyu.JPY.eq(azukariTuuka)) {
                        if (C_Tuukasyu.JPY.eq(shrtuukasyu)) {
                            if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_EQUAL ||
                                BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_LESSER) {
                                if (BizDateUtil.compareYmd(calckijyunymd, zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_EQUAL ||
                                    BizDateUtil.compareYmd(calckijyunymd, zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_LESSER) {
                                    C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                        azukarikin.getAzukarikinhsiymd(),
                                        calckijyunymd,
                                        azukarikin.getAzukarikingk(),
                                        azukariTuuka);

                                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                        throw new CommonBizAppException(
                                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                    }

                                    azukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                    tounendgankin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                }
                                else {
                                    C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                        azukarikin.getAzukarikinhsiymd(),
                                        zenjigyounendoKsnymd4q,
                                        azukarikin.getAzukarikingk(),
                                        azukariTuuka);

                                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                        throw new CommonBizAppException(
                                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                    }

                                    tounendgankin = keisanAzukariGanrikin.getAzukariGanrikinYen();

                                    errorKbn = keisanAzukariGanrikin.exec(
                                        azukarikin.getAzukarikinhsiymd(),
                                        calckijyunymd,
                                        azukarikin.getAzukarikingk(),
                                        azukariTuuka);

                                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                        throw new CommonBizAppException(
                                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                    }

                                    azukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                }
                            }
                            else {
                                C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                    azukarikin.getAzukarikinhsiymd(),
                                    calckijyunymd,
                                    azukarikin.getAzukarikingk(),
                                    azukariTuuka);

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    throw new CommonBizAppException(
                                        MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                }

                                azukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                tounendgankin = azukarikin.getAzukarikingk();
                            }
                        }
                        else {
                            azukariganrikin = keisanGaikakanzan.exec(
                                azukariTuuka,
                                gaikaazukariganrikin,
                                kessankwsrate,
                                C_HasuusyoriKbn.SUTE);
                            tounendgankin = keisanGaikakanzan.exec(
                                azukariTuuka,
                                gaikatounendgankin,
                                kessankwsrate,
                                C_HasuusyoriKbn.SUTE);

                            kwsratekjymd = kessankwsratekjnymd;
                            kawaserate = kessankwsrate;
                        }
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(shrtuukasyu)) {
                            azukariganrikin = keisanGaikakanzan.exec(
                                shrtuukasyu,
                                gaikaazukariganrikin,
                                shrkwsrate,
                                C_HasuusyoriKbn.AGE);
                            tounendgankin = keisanGaikakanzan.exec(
                                shrtuukasyu,
                                gaikatounendgankin,
                                shrkwsrate,
                                C_HasuusyoriKbn.AGE);

                            kwsratekjymd = shrkwsratekjnymd;
                            kawaserate = shrkwsrate;
                        }
                        else {
                            azukariganrikin = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                gaikaazukariganrikin,
                                kessankwsrate,
                                C_HasuusyoriKbn.SUTE);
                            tounendgankin = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                gaikatounendgankin,
                                kessankwsrate,
                                C_HasuusyoriKbn.SUTE);

                            kwsratekjymd = kessankwsratekjnymd;
                            kawaserate = kessankwsrate;
                        }
                    }
                }
                else if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn()) &&
                    kykSyouhn.getSyoumetuymd() != null) {
                    if (C_Tuukasyu.JPY.eq(azukariTuuka)) {
                        if (!C_Tuukasyu.JPY.eq(shrtuukasyu) && (
                            C_Syoumetujiyuu.KAIYAKU.eq(kykSyouhn.getSyoumetujiyuu()) ||
                            C_Syoumetujiyuu.SIBOUKYUUHUKINSHR.eq(kykSyouhn.getSyoumetujiyuu()) ||
                            C_Syoumetujiyuu.MENSEKI.eq(kykSyouhn.getSyoumetujiyuu()) ||
                            C_Syoumetujiyuu.SBKAIJO.eq(kykSyouhn.getSyoumetujiyuu()) ||
                            C_Syoumetujiyuu.KAIJO.eq(kykSyouhn.getSyoumetujiyuu()))) {
                            azukariganrikin = keisanGaikakanzan.exec(
                                azukariTuuka,
                                gaikaazukariganrikin,
                                kessankwsrate,
                                C_HasuusyoriKbn.SUTE);
                            tounendgankin = keisanGaikakanzan.exec(
                                azukariTuuka,
                                gaikatounendgankin,
                                kessankwsrate,
                                C_HasuusyoriKbn.SUTE);

                            kwsratekjymd = kessankwsratekjnymd;
                            kawaserate = kessankwsrate;
                        }
                        else {
                            if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_EQUAL ||
                                BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_LESSER) {
                                if (BizDateUtil.compareYmd(calckijyunymd, zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_EQUAL ||
                                    BizDateUtil.compareYmd(calckijyunymd, zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_LESSER) {
                                    C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                        azukarikin.getAzukarikinhsiymd(),
                                        calckijyunymd,
                                        azukarikin.getAzukarikingk(),
                                        azukariTuuka);

                                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                        throw new CommonBizAppException(
                                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                    }

                                    azukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                    tounendgankin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                }
                                else {
                                    C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                        azukarikin.getAzukarikinhsiymd(),
                                        zenjigyounendoKsnymd4q,
                                        azukarikin.getAzukarikingk(),
                                        azukariTuuka);

                                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                        throw new CommonBizAppException(
                                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                    }

                                    tounendgankin = keisanAzukariGanrikin.getAzukariGanrikinYen();

                                    errorKbn = keisanAzukariGanrikin.exec(
                                        azukarikin.getAzukarikinhsiymd(),
                                        calckijyunymd,
                                        azukarikin.getAzukarikingk(),
                                        azukariTuuka);

                                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                        throw new CommonBizAppException(
                                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                    }

                                    azukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                }
                            }
                            else {
                                C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                    azukarikin.getAzukarikinhsiymd(),
                                    calckijyunymd,
                                    azukarikin.getAzukarikingk(),
                                    azukariTuuka);

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    throw new CommonBizAppException(
                                        MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                }

                                azukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                tounendgankin = azukarikin.getAzukarikingk();
                            }
                        }
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(shrtuukasyu) && (
                            C_Syoumetujiyuu.KAIYAKU.eq(kykSyouhn.getSyoumetujiyuu()) ||
                            C_Syoumetujiyuu.SIBOUKYUUHUKINSHR.eq(kykSyouhn.getSyoumetujiyuu()) ||
                            C_Syoumetujiyuu.MENSEKI.eq(kykSyouhn.getSyoumetujiyuu()) ||
                            C_Syoumetujiyuu.SBKAIJO.eq(kykSyouhn.getSyoumetujiyuu()) ||
                            C_Syoumetujiyuu.KAIJO.eq(kykSyouhn.getSyoumetujiyuu()))) {
                            azukariganrikin = keisanGaikakanzan.exec(
                                shrtuukasyu,
                                gaikaazukariganrikin,
                                shrkwsrate,
                                C_HasuusyoriKbn.AGE);
                            tounendgankin = keisanGaikakanzan.exec(
                                shrtuukasyu,
                                gaikatounendgankin,
                                shrkwsrate,
                                C_HasuusyoriKbn.AGE);
                        }
                        else {
                            azukariganrikin = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                gaikaazukariganrikin,
                                kessankwsrate,
                                C_HasuusyoriKbn.SUTE);
                            tounendgankin = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                gaikatounendgankin,
                                kessankwsrate,
                                C_HasuusyoriKbn.SUTE);

                            kwsratekjymd = kessankwsratekjnymd;
                            kawaserate = kessankwsrate;
                        }
                    }
                }
                else {
                    if (C_Tuukasyu.JPY.eq(azukariTuuka)) {
                        if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_EQUAL ||
                            BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_LESSER) {
                            if (BizDateUtil.compareYmd(calckijyunymd, zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_EQUAL ||
                                BizDateUtil.compareYmd(calckijyunymd, zenjigyounendoKsnymd4q) == BizDateUtil.COMPARE_LESSER) {
                                C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                    azukarikin.getAzukarikinhsiymd(),
                                    calckijyunymd,
                                    azukarikin.getAzukarikingk(),
                                    azukariTuuka);

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    throw new CommonBizAppException(
                                        MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                }

                                azukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                                tounendgankin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                            }
                            else {
                                C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                    azukarikin.getAzukarikinhsiymd(),
                                    zenjigyounendoKsnymd4q,
                                    azukarikin.getAzukarikingk(),
                                    azukariTuuka);

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    throw new CommonBizAppException(
                                        MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                }

                                tounendgankin = keisanAzukariGanrikin.getAzukariGanrikinYen();

                                errorKbn = keisanAzukariGanrikin.exec(
                                    azukarikin.getAzukarikinhsiymd(),
                                    calckijyunymd,
                                    azukarikin.getAzukarikingk(),
                                    azukariTuuka);

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    throw new CommonBizAppException(
                                        MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                                }

                                azukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                            }
                        }
                        else {
                            C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                                azukarikin.getAzukarikinhsiymd(),
                                calckijyunymd,
                                azukarikin.getAzukarikingk(),
                                azukariTuuka);

                            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                throw new CommonBizAppException(
                                    MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                            }

                            azukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
                            tounendgankin = azukarikin.getAzukarikingk();
                        }
                    }
                    else {
                        azukariganrikin = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            gaikaazukariganrikin,
                            kessankwsrate,
                            C_HasuusyoriKbn.SUTE);
                        tounendgankin = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            gaikatounendgankin,
                            kessankwsrate,
                            C_HasuusyoriKbn.SUTE);

                        kwsratekjymd = kessankwsratekjnymd;
                        kawaserate = kessankwsrate;
                    }
                }

                BizCurrency tounendrsk = azukariganrikin.subtract(tounendgankin);
                BizCurrency gaikatounendrsk = gaikaazukariganrikin.subtract(gaikatounendgankin);
                BizCurrency gaikaknsnmaetounendrsk = gaikaknsnmaeazukariganrikin.subtract(gaikaknsnmaetounendgankin);

                BizCurrency azukarikinshrgk = BizCurrency.valueOf(0);
                BizCurrency azukarikinshrrskgk = BizCurrency.valueOf(0);

                if ((!C_BkncdKbn.KAIYAKU.eq(bkncdkbn) &&
                    !C_BkncdKbn.SIBOUUKETUKE.eq(bkncdkbn) &&
                    !C_BkncdKbn.SIBOUKARIUKETUKE.eq(bkncdkbn) &&
                    !C_BkncdKbn.MENSEKI.eq(bkncdkbn) &&
                    !C_BkncdKbn.SIBOUKAIJYO.eq(bkncdkbn)) &&
                    C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn()) &&
                    kykSyouhn.getSyoumetuymd() != null) {
                    if (C_Tuukasyu.JPY.eq(azukariTuuka)) {
                        azukarikinshrgk = tounendgankin;
                        azukarikinshrrskgk = azukariganrikin.subtract(tounendgankin);
                    }
                    else {
                        azukarikinshrgk = gaikaknsnmaetounendgankin;
                        azukarikinshrrskgk = gaikaknsnmaeazukariganrikin.subtract(gaikaknsnmaetounendgankin);
                    }
                }

                BizCurrency tounendsyoumetuukemishrgk = BizCurrency.valueOf(0);
                BizCurrency sinbikinkeirskgk = BizCurrency.valueOf(0);

                if ((C_BkncdKbn.KAIYAKU.eq(bkncdkbn) ||
                    C_BkncdKbn.SIBOUUKETUKE.eq(bkncdkbn) ||
                    C_BkncdKbn.SIBOUKARIUKETUKE.eq(bkncdkbn) ||
                    C_BkncdKbn.MENSEKI.eq(bkncdkbn) ||
                    C_BkncdKbn.SIBOUKAIJYO.eq(bkncdkbn)) &&
                    C_BknJkuKbn.SINBI.eq(bknjkukbn)) {
                    if (C_Tuukasyu.JPY.eq(azukariTuuka)) {
                        tounendsyoumetuukemishrgk = tounendgankin;
                        sinbikinkeirskgk = azukariganrikin.subtract(tounendgankin);
                    }
                    else {
                        tounendsyoumetuukemishrgk = gaikaknsnmaetounendgankin;
                        sinbikinkeirskgk = gaikaknsnmaeazukariganrikin.subtract(gaikaknsnmaetounendgankin);
                    }
                }

                BizDate wkAzukariganrikinKeisanKaisiYmd = azukarikin.getAzukarikinhsiymd();
                BizCurrency wkRskKeisanAzukarikin = azukarikin.getAzukarikingk();

                BizDate wkKwsratekjymd1q = null;
                BizNumber wkKawaserate1q = BizNumber.ZERO;
                BizDate wkKwsratekjymd2q = null;
                BizNumber wkKawaserate2q = BizNumber.ZERO;
                BizDate wkKwsratekjymd3q = null;
                BizNumber wkKawaserate3q = BizNumber.ZERO;
                BizDate wkKwsratekjymd4q = null;
                BizNumber wkKawaserate4q = BizNumber.ZERO;

                BizDate wkAzukariganrikinKeisanYmd1q = null;
                BizDate wkAzukariganrikinKeisanYmd2q = null;
                BizDate wkAzukariganrikinKeisanYmd3q = null;
                BizDate wkAzukariganrikinKeisanYmd4q = null;

                BizCurrency azukariganrikin1q = BizCurrency.valueOf(0, azukariType);
                BizCurrency azukarigankin1qKyktuuka = BizCurrency.valueOf(0, azukariType);
                BizCurrency azukarikinrsk1q = BizCurrency.valueOf(0);
                BizCurrency azukariganrikin2q = BizCurrency.valueOf(0, azukariType);
                BizCurrency azukarigankin2qKyktuuka = BizCurrency.valueOf(0, azukariType);
                BizCurrency azukarikinrsk2q = BizCurrency.valueOf(0);
                BizCurrency azukariganrikin3q = BizCurrency.valueOf(0, azukariType);
                BizCurrency azukarigankin3qKyktuuka = BizCurrency.valueOf(0, azukariType);
                BizCurrency azukarikinrsk3q = BizCurrency.valueOf(0);
                BizCurrency azukariganrikin4q = BizCurrency.valueOf(0, azukariType);
                BizCurrency azukarigankin4qKyktuuka = BizCurrency.valueOf(0, azukariType);
                BizCurrency azukarikinrsk4q = BizCurrency.valueOf(0);

                if (!C_Tuukasyu.JPY.eq(azukariTuuka) &&
                    kwsratekjymd1q != null){
                    if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), ksnymd1q) == BizDateUtil.COMPARE_LESSER) {
                        if ((C_BkncdKbn.KAIYAKU.eq(bkncdkbn) ||
                            C_BkncdKbn.SIBOUUKETUKE.eq(bkncdkbn) ||
                            C_BkncdKbn.SIBOUKARIUKETUKE.eq(bkncdkbn) ||
                            C_BkncdKbn.MENSEKI.eq(bkncdkbn) ||
                            C_BkncdKbn.SIBOUKAIJYO.eq(bkncdkbn))) {
                            if (C_BknJkuKbn.SINBI.eq(bknjkukbn) &&
                                BizDateUtil.compareYmd(zenjigyounendoKsnymd4q,calckijyunymd) == BizDateUtil.COMPARE_LESSER) {
                                if (BizDateUtil.compareYmd(ksnymd1q, calckijyunymd) == BizDateUtil.COMPARE_LESSER) {
                                    wkKwsratekjymd1q = kwsratekjymd1q;
                                    wkKawaserate1q = kawaserate1q;
                                    wkAzukariganrikinKeisanYmd1q = kwsratekjymd1q;
                                }
                                else {
                                    wkKwsratekjymd1q = kwsratekjymd1q;
                                    wkKawaserate1q = kawaserate1q;
                                    wkAzukariganrikinKeisanYmd1q = calckijyunymd;
                                }
                            }
                        }
                        else if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                            if (BizDateUtil.compareYmd(ksnymd1q, kykSyouhn.getSyoumetuymd()) == BizDateUtil.COMPARE_LESSER) {
                                wkKwsratekjymd1q = kwsratekjymd1q;
                                wkKawaserate1q = kawaserate1q;
                                wkAzukariganrikinKeisanYmd1q = kwsratekjymd1q;
                            }
                            else {
                                wkKwsratekjymd1q = kwsratekjymd1q;
                                wkKawaserate1q = kawaserate1q;
                                wkAzukariganrikinKeisanYmd1q = calckijyunymd;
                            }
                        }
                        else {
                            wkKwsratekjymd1q = kwsratekjymd1q;
                            wkKawaserate1q = kawaserate1q;
                            wkAzukariganrikinKeisanYmd1q = kwsratekjymd1q;
                        }
                    }
                }

                if (wkKwsratekjymd1q != null) {
                    C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                        azukarikin.getAzukarikinhsiymd(),
                        wkAzukariganrikinKeisanYmd1q,
                        azukarikin.getAzukarikingk(),
                        azukariTuuka);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException(
                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                    }

                    azukariganrikin1q = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();

                    BizDate wkZenjigyounendoKwsratekjymd = zenjigyounendoKwsratekjymd;

                    if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), wkZenjigyounendoKwsratekjymd) == BizDateUtil.COMPARE_LESSER) {
                        errorKbn = keisanAzukariGanrikin.exec(
                            azukarikin.getAzukarikinhsiymd(),
                            wkZenjigyounendoKwsratekjymd,
                            azukarikin.getAzukarikingk(),
                            azukariTuuka);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new CommonBizAppException(
                                MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                        }
                        azukarigankin1qKyktuuka = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();
                    }

                    else if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), ksnymd1q) == BizDateUtil.COMPARE_LESSER) {
                        azukarigankin1qKyktuuka = azukarikin.getAzukarikingk();
                    }

                    BizCurrency azukariganrikin1qYen = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        azukariganrikin1q,
                        wkKawaserate1q,
                        C_HasuusyoriKbn.SUTE);

                    BizCurrency azukarigankin1qYen = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        azukarigankin1qKyktuuka,
                        wkKawaserate1q,
                        C_HasuusyoriKbn.SUTE);

                    azukarikinrsk1q = azukariganrikin1qYen.subtract(azukarigankin1qYen);
                    wkAzukariganrikinKeisanKaisiYmd = wkAzukariganrikinKeisanYmd1q;
                    wkRskKeisanAzukarikin = azukariganrikin1q;
                }

                if (!C_Tuukasyu.JPY.eq(azukariTuuka) &&
                    kwsratekjymd2q != null){
                    if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), ksnymd2q) == BizDateUtil.COMPARE_LESSER) {
                        if ((C_BkncdKbn.KAIYAKU.eq(bkncdkbn) ||
                            C_BkncdKbn.SIBOUUKETUKE.eq(bkncdkbn) ||
                            C_BkncdKbn.SIBOUKARIUKETUKE.eq(bkncdkbn) ||
                            C_BkncdKbn.MENSEKI.eq(bkncdkbn) ||
                            C_BkncdKbn.SIBOUKAIJYO.eq(bkncdkbn))) {
                            if (C_BknJkuKbn.SINBI.eq(bknjkukbn) &&
                                BizDateUtil.compareYmd(zenjigyounendoKsnymd4q,calckijyunymd) == BizDateUtil.COMPARE_LESSER) {
                                if (BizDateUtil.compareYmd(ksnymd2q, calckijyunymd) == BizDateUtil.COMPARE_LESSER) {
                                    wkKwsratekjymd2q = kwsratekjymd2q;
                                    wkKawaserate2q = kawaserate2q;
                                    wkAzukariganrikinKeisanYmd2q = kwsratekjymd2q;
                                }
                                else {
                                    wkKwsratekjymd2q = kwsratekjymd2q;
                                    wkKawaserate2q = kawaserate2q;
                                    wkAzukariganrikinKeisanYmd2q = calckijyunymd;
                                }
                            }
                        }
                        else if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                            if (BizDateUtil.compareYmd(ksnymd2q, kykSyouhn.getSyoumetuymd()) == BizDateUtil.COMPARE_LESSER) {
                                wkKwsratekjymd2q = kwsratekjymd2q;
                                wkKawaserate2q = kawaserate2q;
                                wkAzukariganrikinKeisanYmd2q = kwsratekjymd2q;
                            }
                            else {
                                wkKwsratekjymd2q = kwsratekjymd2q;
                                wkKawaserate2q = kawaserate2q;
                                wkAzukariganrikinKeisanYmd2q = calckijyunymd;
                            }
                        }
                        else {
                            wkKwsratekjymd2q = kwsratekjymd2q;
                            wkKawaserate2q = kawaserate2q;
                            wkAzukariganrikinKeisanYmd2q = kwsratekjymd2q;
                        }
                    }
                }

                if (wkKwsratekjymd2q != null) {
                    C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                        wkAzukariganrikinKeisanKaisiYmd,
                        wkAzukariganrikinKeisanYmd2q,
                        wkRskKeisanAzukarikin,
                        azukariTuuka);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException(
                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                    }

                    azukariganrikin2q = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();

                    if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), ksnymd1q) == BizDateUtil.COMPARE_LESSER) {
                        azukarigankin2qKyktuuka =  azukariganrikin1q;
                    }
                    else if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), ksnymd2q) == BizDateUtil.COMPARE_LESSER) {
                        azukarigankin2qKyktuuka =  azukarikin.getAzukarikingk();
                    }

                    BizCurrency azukariganrikin2qYen = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        azukariganrikin2q,
                        wkKawaserate2q,
                        C_HasuusyoriKbn.SUTE);

                    BizCurrency azukarigankin2qYen = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        azukarigankin2qKyktuuka,
                        wkKawaserate2q,
                        C_HasuusyoriKbn.SUTE);

                    azukarikinrsk2q = azukariganrikin2qYen.subtract(azukarigankin2qYen);
                    wkAzukariganrikinKeisanKaisiYmd = wkAzukariganrikinKeisanYmd2q;
                    wkRskKeisanAzukarikin = azukariganrikin2q;
                }

                if (!C_Tuukasyu.JPY.eq(azukariTuuka) &&
                    kwsratekjymd3q != null){
                    if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), ksnymd3q) == BizDateUtil.COMPARE_LESSER) {
                        if ((C_BkncdKbn.KAIYAKU.eq(bkncdkbn) ||
                            C_BkncdKbn.SIBOUUKETUKE.eq(bkncdkbn) ||
                            C_BkncdKbn.SIBOUKARIUKETUKE.eq(bkncdkbn) ||
                            C_BkncdKbn.MENSEKI.eq(bkncdkbn) ||
                            C_BkncdKbn.SIBOUKAIJYO.eq(bkncdkbn))) {
                            if (C_BknJkuKbn.SINBI.eq(bknjkukbn) &&
                                BizDateUtil.compareYmd(zenjigyounendoKsnymd4q,calckijyunymd) == BizDateUtil.COMPARE_LESSER) {
                                if (BizDateUtil.compareYmd(ksnymd3q, calckijyunymd) == BizDateUtil.COMPARE_LESSER) {
                                    wkKwsratekjymd3q = kwsratekjymd3q;
                                    wkKawaserate3q = kawaserate3q;
                                    wkAzukariganrikinKeisanYmd3q = kwsratekjymd3q;
                                }
                                else {
                                    wkKwsratekjymd3q = kwsratekjymd3q;
                                    wkKawaserate3q = kawaserate3q;
                                    wkAzukariganrikinKeisanYmd3q = calckijyunymd;
                                }
                            }
                        }
                        else if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                            if (BizDateUtil.compareYmd(ksnymd3q, kykSyouhn.getSyoumetuymd()) == BizDateUtil.COMPARE_LESSER) {
                                wkKwsratekjymd3q = kwsratekjymd3q;
                                wkKawaserate3q = kawaserate3q;
                                wkAzukariganrikinKeisanYmd3q = kwsratekjymd3q;
                            }
                            else {
                                wkKwsratekjymd3q = kwsratekjymd3q;
                                wkKawaserate3q = kawaserate3q;
                                wkAzukariganrikinKeisanYmd3q = calckijyunymd;
                            }
                        }
                        else {
                            wkKwsratekjymd3q = kwsratekjymd3q;
                            wkKawaserate3q = kawaserate3q;
                            wkAzukariganrikinKeisanYmd3q = kwsratekjymd3q;
                        }
                    }
                }

                if (wkKwsratekjymd3q != null) {
                    C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                        wkAzukariganrikinKeisanKaisiYmd,
                        wkAzukariganrikinKeisanYmd3q,
                        wkRskKeisanAzukarikin,
                        azukariTuuka);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException(
                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                    }

                    azukariganrikin3q = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();

                    if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), ksnymd2q) == BizDateUtil.COMPARE_LESSER) {
                        azukarigankin3qKyktuuka =  azukariganrikin2q;
                    }
                    else if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), ksnymd3q) == BizDateUtil.COMPARE_LESSER) {
                        azukarigankin3qKyktuuka =  azukarikin.getAzukarikingk();
                    }

                    BizCurrency azukariganrikin3qYen = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        azukariganrikin3q,
                        wkKawaserate3q,
                        C_HasuusyoriKbn.SUTE);

                    BizCurrency azukarigankin3qYen = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        azukarigankin3qKyktuuka,
                        wkKawaserate3q,
                        C_HasuusyoriKbn.SUTE);

                    azukarikinrsk3q = azukariganrikin3qYen.subtract(azukarigankin3qYen);
                    wkAzukariganrikinKeisanKaisiYmd = wkAzukariganrikinKeisanYmd3q;
                    wkRskKeisanAzukarikin = azukariganrikin3q;
                }

                if (!C_Tuukasyu.JPY.eq(azukariTuuka) &&
                    kwsratekjymd4q != null){
                    if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), ksnymd4q) == BizDateUtil.COMPARE_LESSER) {
                        if ((C_BkncdKbn.KAIYAKU.eq(bkncdkbn) ||
                            C_BkncdKbn.SIBOUUKETUKE.eq(bkncdkbn) ||
                            C_BkncdKbn.SIBOUKARIUKETUKE.eq(bkncdkbn) ||
                            C_BkncdKbn.MENSEKI.eq(bkncdkbn) ||
                            C_BkncdKbn.SIBOUKAIJYO.eq(bkncdkbn))) {
                            if (C_BknJkuKbn.SINBI.eq(bknjkukbn) &&
                                BizDateUtil.compareYmd(zenjigyounendoKsnymd4q,calckijyunymd) == BizDateUtil.COMPARE_LESSER) {
                                if (BizDateUtil.compareYmd(ksnymd4q, calckijyunymd) == BizDateUtil.COMPARE_LESSER) {
                                    wkKwsratekjymd4q = kwsratekjymd4q;
                                    wkKawaserate4q = kawaserate4q;
                                    wkAzukariganrikinKeisanYmd4q = kwsratekjymd4q;
                                }
                                else {
                                    wkKwsratekjymd4q = kwsratekjymd4q;
                                    wkKawaserate4q = kawaserate4q;
                                    wkAzukariganrikinKeisanYmd4q = calckijyunymd;
                                }
                            }
                        }
                        else if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                            if (BizDateUtil.compareYmd(ksnymd4q, kykSyouhn.getSyoumetuymd()) == BizDateUtil.COMPARE_LESSER) {
                                wkKwsratekjymd4q = kwsratekjymd4q;
                                wkKawaserate4q = kawaserate4q;
                                wkAzukariganrikinKeisanYmd4q = kwsratekjymd4q;
                            }
                            else {
                                wkKwsratekjymd4q = kwsratekjymd4q;
                                wkKawaserate4q = kawaserate4q;
                                wkAzukariganrikinKeisanYmd4q = calckijyunymd;
                            }
                        }
                        else {
                            wkKwsratekjymd4q = kwsratekjymd4q;
                            wkKawaserate4q = kawaserate4q;
                            wkAzukariganrikinKeisanYmd4q = kwsratekjymd4q;
                        }
                    }
                }

                if (wkKwsratekjymd4q != null) {
                    C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                        wkAzukariganrikinKeisanKaisiYmd,
                        wkAzukariganrikinKeisanYmd4q,
                        wkRskKeisanAzukarikin,
                        azukariTuuka);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException(
                            MessageUtil.getMessage(MessageId.EIA1010, "預り金決算情報抽出", syono));
                    }

                    azukariganrikin4q = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();

                    if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), ksnymd3q) == BizDateUtil.COMPARE_LESSER) {
                        azukarigankin4qKyktuuka =  azukariganrikin3q;
                    }
                    else if (BizDateUtil.compareYmd(azukarikin.getAzukarikinhsiymd(), ksnymd4q) == BizDateUtil.COMPARE_LESSER) {
                        azukarigankin4qKyktuuka =  azukarikin.getAzukarikingk();
                    }

                    BizCurrency azukariganrikin4qYen = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        azukariganrikin4q,
                        wkKawaserate4q,
                        C_HasuusyoriKbn.SUTE);

                    BizCurrency azukarigankin4qYen = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        azukarigankin4qKyktuuka,
                        wkKawaserate4q,
                        C_HasuusyoriKbn.SUTE);

                    azukarikinrsk4q =  azukariganrikin4qYen.subtract(azukarigankin4qYen);
                }

                BizCurrency tounendrsksyukeisitu;
                BizCurrency zennendrsksyukeisitu;

                if (C_AzukarijikiKbn.TOUNEND.eq(azukarijikiKbn)) {
                    tounendrsksyukeisitu = azukarikinrsk1q.add(azukarikinrsk2q).add(azukarikinrsk3q).add(azukarikinrsk4q);
                    zennendrsksyukeisitu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                }
                else {
                    tounendrsksyukeisitu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    zennendrsksyukeisitu = azukarikinrsk1q.add(azukarikinrsk2q).add(azukarikinrsk3q).add(azukarikinrsk4q);
                }

                IT_AzukarikinKessankanri azukarikinKessankanri = new IT_AzukarikinKessankanri();

                azukarikinKessankanri.setSyono(syono);
                azukarikinKessankanri.setKessankijyunymd(kessanYmd);
                azukarikinKessankanri.setHenkousikibetukey(azukarikin.getHenkousikibetukey());
                azukarikinKessankanri.setTuukasyu(azukariTuuka);
                azukarikinKessankanri.setSyouhncd(kykSyouhn.getSyouhncd());
                azukarikinKessankanri.setKykymd(kykSyouhn.getKykymd());
                azukarikinKessankanri.setYuukousyoumetukbn(kykSyouhn.getYuukousyoumetukbn());
                azukarikinKessankanri.setSyoumetujiyuu(kykSyouhn.getSyoumetujiyuu());
                azukarikinKessankanri.setSyoumetuymd(kykSyouhn.getSyoumetuymd());
                azukarikinKessankanri.setKbnkeirisegcd(kbnkeirisegcd);
                azukarikinKessankanri.setCalckijyunymd(calckijyunymd);
                azukarikinKessankanri.setAzukarikinhsiymd(azukarikin.getAzukarikinhsiymd());
                azukarikinKessankanri.setAzukarigankin(azukarikin.getAzukarikingk());
                azukarikinKessankanri.setAzukarijikikbn(azukarijikiKbn);
                azukarikinKessankanri.setAzukariganrikin(azukariganrikin);
                azukarikinKessankanri.setTounendgankin(tounendgankin);
                azukarikinKessankanri.setTounendrsk(tounendrsk);
                azukarikinKessankanri.setKwsratekjymd(kwsratekjymd);
                azukarikinKessankanri.setKawaserate(kawaserate);
                azukarikinKessankanri.setGaikaazukariganrikin(gaikaazukariganrikin);
                azukarikinKessankanri.setGaikatounendgankin(gaikatounendgankin);
                azukarikinKessankanri.setGaikatounendrsk(gaikatounendrsk);
                azukarikinKessankanri.setGaikashrkwsratekjnymd(gaikashrkwsratekjnymd);
                azukarikinKessankanri.setGaikashrkwsrate(gaikashrkwsrate);
                azukarikinKessankanri.setGaikaknsnmaeazukariganrikin(gaikaknsnmaeazukariganrikin);
                azukarikinKessankanri.setGaikaknsnmaetounendgankin(gaikaknsnmaetounendgankin);
                azukarikinKessankanri.setGaikaknsnmaetounendrsk(gaikaknsnmaetounendrsk);
                azukarikinKessankanri.setAzukarikinshrgk(azukarikinshrgk);
                azukarikinKessankanri.setAzukarikinshrrskgk(azukarikinshrrskgk);
                azukarikinKessankanri.setTounendsyoumetuukemishrgk(tounendsyoumetuukemishrgk);
                azukarikinKessankanri.setSinbikinkeirskgk(sinbikinkeirskgk);
                azukarikinKessankanri.setBknjkukbn(bknjkukbn);
                azukarikinKessankanri.setBikinkeiymd(bikinkeiymd);
                azukarikinKessankanri.setBkncdkbn(bkncdkbn);
                azukarikinKessankanri.setTounendrsksyukeisitu(tounendrsksyukeisitu);
                azukarikinKessankanri.setZennendrsksyukeisitu(zennendrsksyukeisitu);
                azukarikinKessankanri.setKwsratekjymd1q(wkKwsratekjymd1q);
                azukarikinKessankanri.setKawaserate1q(wkKawaserate1q);
                azukarikinKessankanri.setAzukarikinrsk1q(azukarikinrsk1q);
                azukarikinKessankanri.setKwsratekjymd2q(wkKwsratekjymd2q);
                azukarikinKessankanri.setKawaserate2q(wkKawaserate2q);
                azukarikinKessankanri.setAzukarikinrsk2q(azukarikinrsk2q);
                azukarikinKessankanri.setKwsratekjymd3q(wkKwsratekjymd3q);
                azukarikinKessankanri.setKawaserate3q(wkKawaserate3q);
                azukarikinKessankanri.setAzukarikinrsk3q(azukarikinrsk3q);
                azukarikinKessankanri.setKwsratekjymd4q(wkKwsratekjymd4q);
                azukarikinKessankanri.setKawaserate4q(wkKawaserate4q);
                azukarikinKessankanri.setAzukarikinrsk4q(azukarikinrsk4q);
                azukarikinKessankanri.setGyoumuKousinKinou(kinouId);
                azukarikinKessankanri.setGyoumuKousinsyaId(userId);
                azukarikinKessankanri.setGyoumuKousinTime(sysDateTimeMilli);

                BizPropertyInitializer.initialize(azukarikinKessankanri);

                entityInserter.add(azukarikinKessankanri);

                kensuCount++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(
            MessageUtil.getMessage(
                MessageId.IBF0002,
                String.valueOf(kensuCount),
                "<<預り金決算管理テーブル>>"));
    }

    private BizDateY calcNendo(BizDate pCountedObjYmd) {

        BizDateY countedY;

        if (BizDateMD.valueOf(4, 1).compareTo(pCountedObjYmd.getBizDateMD()) > 0) {
            countedY = pCountedObjYmd.getBizDateY().addYears(-1);
        }
        else {
            countedY = pCountedObjYmd.getBizDateY();
        }

        return countedY;
    }

    private void setSihankimatuKawaserate(
        BizDate pTaisyouYmd, C_Tuukasyu pTuukasyu) {

        if (pTaisyouYmd.getMonth() == 6 ||
            pTaisyouYmd.getMonth() == 9 ||
            pTaisyouYmd.getMonth() == 12) {
            zenjigyounendoKsnymd4q = BizDateYM.valueOf(pTaisyouYmd.getBizDateY(), 3).getLastDay();
            ksnymd1q = BizDateYM.valueOf(pTaisyouYmd.getBizDateY(), 6).getLastDay();
            ksnymd2q = BizDateYM.valueOf(pTaisyouYmd.getBizDateY(), 9).getLastDay();
            ksnymd3q = BizDateYM.valueOf(pTaisyouYmd.getBizDateY(), 12).getLastDay();
            ksnymd4q = BizDateYM.valueOf(pTaisyouYmd.getBizDateY().addYears(1), 3).getLastDay();

        }
        else {
            zenjigyounendoKsnymd4q = BizDateYM.valueOf(pTaisyouYmd.getBizDateY().addYears(-1), 3).getLastDay();
            ksnymd1q = BizDateYM.valueOf(pTaisyouYmd.getBizDateY().addYears(-1), 6).getLastDay();
            ksnymd2q = BizDateYM.valueOf(pTaisyouYmd.getBizDateY().addYears(-1), 9).getLastDay();
            ksnymd3q = BizDateYM.valueOf(pTaisyouYmd.getBizDateY().addYears(-1), 12).getLastDay();
            ksnymd4q = BizDateYM.valueOf(pTaisyouYmd.getBizDateY(), 3).getLastDay();
        }

        if (!C_Tuukasyu.JPY.eq(pTuukasyu)) {

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

            getKawaseRate.exec(
                zenjigyounendoKsnymd4q,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                pTuukasyu,
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            zenjigyounendoKwsratekjymd = getKawaseRate.getKwsrateKjYmd();

            if (BizDateUtil.compareYmd(ksnymd1q, pTaisyouYmd) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(ksnymd1q, pTaisyouYmd) == BizDateUtil.COMPARE_LESSER) {
                getKawaseRate.exec(
                    ksnymd1q,
                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                    pTuukasyu,
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.JISSEIRATE,
                    C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                kwsratekjymd1q = getKawaseRate.getKwsrateKjYmd();
                kawaserate1q = getKawaseRate.getKawaserate();
            }

            if (BizDateUtil.compareYmd(ksnymd2q, pTaisyouYmd) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(ksnymd2q, pTaisyouYmd) == BizDateUtil.COMPARE_LESSER) {
                getKawaseRate.exec(
                    ksnymd2q,
                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                    pTuukasyu,
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.JISSEIRATE,
                    C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                kwsratekjymd2q = getKawaseRate.getKwsrateKjYmd();
                kawaserate2q = getKawaseRate.getKawaserate();
            }

            if (BizDateUtil.compareYmd(ksnymd3q, pTaisyouYmd) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(ksnymd3q, pTaisyouYmd) == BizDateUtil.COMPARE_LESSER) {
                getKawaseRate.exec(
                    ksnymd3q,
                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                    pTuukasyu,
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.JISSEIRATE,
                    C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                kwsratekjymd3q = getKawaseRate.getKwsrateKjYmd();
                kawaserate3q = getKawaseRate.getKawaserate();
            }

            if (BizDateUtil.compareYmd(ksnymd4q, pTaisyouYmd) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(ksnymd4q, pTaisyouYmd) == BizDateUtil.COMPARE_LESSER) {
                getKawaseRate.exec(
                    ksnymd4q,
                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                    pTuukasyu,
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.JISSEIRATE,
                    C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                kwsratekjymd4q = getKawaseRate.getKwsrateKjYmd();
                kawaserate4q = getKawaseRate.getKawaserate();
            }
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();

    }
}
