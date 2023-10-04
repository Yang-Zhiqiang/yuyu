package yuyu.batch.hozen.khkessan.khzennouidoukyksel;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khkessan.khzennouidoukyksel.dba.KhZennouIdouKykSelDao;
import yuyu.batch.hozen.khkessan.khzennouidoukyksel.dba.ZennouIdouKykInfoBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.ascommon.ChkZennouKeisanTuuka;
import yuyu.common.hozen.khcommon.GetTkJitenZennouInfo;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.IT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 決算 前納異動契約データ抽出
 */
public class KhZennouIdouKykSelBatch implements Batch{

    private static final String RDPTX000= "RDPTX000";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KhZennouIdouKykSelBatchParam khZennouIdouKykSelBatchParam;

    @Inject
    private KhZennouIdouKykSelDao khZennouIdouKykSelDao;

    private BizDate syoriYmd;

    private String kakutyoujobCd;

    @Override
    public BatchParam getParam() {

        return khZennouIdouKykSelBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = khZennouIdouKykSelBatchParam.getSyoriYmd();
        kakutyoujobCd = khZennouIdouKykSelBatchParam.getIbKakutyoujobcd();
        BizDate kessanYmd = khZennouIdouKykSelBatchParam.getKessanYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyoujobCd));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1020),  String.valueOf(kessanYmd)));

        long syoriCount = 0;
        long errorCount = 0;
        String maeRcdSyono = "";
        BizDate maeRcdSyoriYmd = null;
        int douituSyonoRenno = 1;
        boolean maeRcdSyonoErrorFlag = false;
        BizNumber kessankiSiDollarRate = BizNumber.ZERO;
        String kessankiSiDollarRateErrMsg = "";
        BizNumber kessankiMaDollarRate = BizNumber.ZERO;
        String kessankiMaDollarRateErrMsg = "";

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        BizDate kessanKaisiYmd = setKessanNensibi.exec(kessanYmd);
        BizDate zenNendoMatujituYmd = kessanKaisiYmd.addBusinessDays(-1);

        try (
            ExDBResults<ZennouIdouKykInfoBean> zennouIdouKykInfoBeanList =
            khZennouIdouKykSelDao.getZennouIdouKykInfoBeans(kessanKaisiYmd, kessanYmd);
            EntityInserter<IT_ZennouHoyuuIdouKykDtl> zennouHoyuuIdouKykDtlInserter = new EntityInserter<IT_ZennouHoyuuIdouKykDtl>();) {

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            C_ErrorKbn errorKbnKawaseRate = getKawaseRate.exec(zenNendoMatujituYmd,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                C_Tuukasyu.USD,
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.BLNK,
                C_YouhiKbn.HUYOU);
            if (C_ErrorKbn.ERROR.eq(errorKbnKawaseRate)) {
                kessankiSiDollarRateErrMsg = MessageUtil.getMessage(MessageId.EBF1021,
                    zenNendoMatujituYmd.toString(),
                    C_Tuukasyu.USD.getValue(),
                    C_Tuukasyu.JPY.getValue());
            }
            else {
                kessankiSiDollarRate = getKawaseRate.getKawaserate();
            }

            BizDate getKawaseRateyoukessanYmd = kessanYmd;
            if (kessanYmd.isHoliday()) {
                getKawaseRateyoukessanYmd = kessanYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
            }
            errorKbnKawaseRate = getKawaseRate.exec(getKawaseRateyoukessanYmd,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                C_Tuukasyu.USD,
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.BLNK,
                C_YouhiKbn.HUYOU);
            if (C_ErrorKbn.ERROR.eq(errorKbnKawaseRate)) {
                kessankiMaDollarRateErrMsg = MessageUtil.getMessage(MessageId.EBF1021,
                    String.valueOf(getKawaseRateyoukessanYmd),
                    C_Tuukasyu.USD.getValue(),
                    C_Tuukasyu.JPY.getValue());
            }
            else {
                kessankiMaDollarRate = getKawaseRate.getKawaserate();
            }

            for(ZennouIdouKykInfoBean zennouIdouKykInfoBean : zennouIdouKykInfoBeanList) {

                if (maeRcdSyono.equals(zennouIdouKykInfoBean.getSyono()) && maeRcdSyonoErrorFlag) {
                    continue;
                }

                if (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(zennouIdouKykInfoBean.getGyoumuKousinKinou())) {
                    IT_KhTtdkRireki khTtdkRireki =
                        khZennouIdouKykSelDao.getKhTtdkRirekisBySyonoGyoumuKousinKinou(
                            zennouIdouKykInfoBean.getSyono(),
                            zennouIdouKykInfoBean.getGyoumuKousinKinou()).get(0);

                    if (!C_SyoriKbn.CLGOFF.eq(khTtdkRireki.getSyorikbn()) &&
                        !C_SyoriKbn.KYKTORIKESI.eq(khTtdkRireki.getSyorikbn()) &&
                        !C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(khTtdkRireki.getSyorikbn())) {
                        continue;
                    }
                }
                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(zennouIdouKykInfoBean.getSyono());
                List<IT_KykSyouhn> kykKihonList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
                IT_KykSyouhn kykSyouhn = kykKihonList.get(0);

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(zennouIdouKykInfoBean.getSyono());
                IT_Zennou zennou= khZennouIdouKykSelDao.getZennou(ansyuKihon,
                    zennouIdouKykInfoBean.getZennoukaisiymd(),
                    zennouIdouKykInfoBean.getRenno());

                GetTkJitenZennouInfo getTkJitenZennouInfo = SWAKInjector.getInstance(GetTkJitenZennouInfo.class);
                IT_Zennou  idouZennouInfo = getTkJitenZennouInfo.exec(C_ZennouSeisanKbn.SEISANZUMI, kessanYmd, zennou);
                BizDate syoriNendoTaniKykOtouYmd;
                if (kykSyouhn.getKykymd().getMonth() >= 4) {
                    syoriNendoTaniKykOtouYmd =
                        BizDate.valueOf(kessanKaisiYmd.getYear(), kykSyouhn.getKykymd().getBizDateMD()).getRekijyou();
                }
                else {
                    syoriNendoTaniKykOtouYmd = BizDate.valueOf(kessanKaisiYmd.getBizDateY().getNextYear(),
                        kykSyouhn.getKykymd().getBizDateMD()).getRekijyou();
                }

                BizDate konkiNenTaniKykOtouYmd = syoriNendoTaniKykOtouYmd;

                BizCurrency toukiZennounyuukinkgk;
                BizDate yokuKessanKaisiYmd = kessanKaisiYmd.addYears(1);

                if ((BizDateUtil.compareYmd(idouZennouInfo.getRyosyuymd(), kessanKaisiYmd) == BizDateUtil.COMPARE_GREATER
                    || BizDateUtil.compareYmd(idouZennouInfo.getRyosyuymd(), kessanKaisiYmd) == BizDateUtil.COMPARE_EQUAL)
                    && (BizDateUtil.compareYmd(idouZennouInfo.getRyosyuymd(), yokuKessanKaisiYmd) == BizDateUtil.COMPARE_LESSER)) {
                    toukiZennounyuukinkgk = idouZennouInfo.getZennounyuukinkgk();
                }
                else {
                    toukiZennounyuukinkgk = BizCurrency.valueOf(0);
                }

                BizCurrency toukiJyuuToup;
                if (BizDateUtil.compareYmd(konkiNenTaniKykOtouYmd, idouZennouInfo.getZennouseisankijyunymd()) != BizDateUtil.COMPARE_GREATER &&
                    BizDateUtil.compareYmd(idouZennouInfo.getZennoukaisiymd(), konkiNenTaniKykOtouYmd) != BizDateUtil.COMPARE_GREATER &&
                    BizDateUtil.compareYm(konkiNenTaniKykOtouYmd.getBizDateYM(),
                        idouZennouInfo.getAnnaisaikaiym()) == BizDateUtil.COMPARE_LESSER) {
                    toukiJyuuToup = idouZennouInfo.getZennoujihrkp();
                }
                else {
                    toukiJyuuToup = BizCurrency.valueOf(0);
                }

                AS_Kinou kinouEntity = baseDomManager.getKinou(zennouIdouKykInfoBean.getGyoumuKousinKinou());
                String syoricd =  kinouEntity.getSyoricd();

                BizDate denYmd;
                if (idouZennouInfo.getZennouseisandenymd() != null) {
                    denYmd = idouZennouInfo.getZennouseisandenymd();
                }
                else {
                    denYmd = idouZennouInfo.getZennouseisansyoriymd();
                }


                if (maeRcdSyono.equals(idouZennouInfo.getSyono()) &&
                    BizDateUtil.compareYmd(maeRcdSyoriYmd,
                        idouZennouInfo.getZennouseisansyoriymd()) == BizDateUtil.COMPARE_EQUAL) {
                    douituSyonoRenno++;
                }
                else {
                    douituSyonoRenno = 1;
                }
                String kykMfksnctr =  idouZennouInfo.getZennouseisansyoriymd().toString().
                    substring(idouZennouInfo.getZennouseisansyoriymd().toString().length() - 6)
                    + String.valueOf(douituSyonoRenno);
                SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
                SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(C_SrKbnHenkanKbn.SYOKEIYAKU
                    , kykSyouhn.getSyouhncd(),kykSyouhn.getKyktuukasyu().getValue());
                String syuKykSyuruicd;
                if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {
                    String errorMst = "主契約種類コード区分変換エラー　商品コード：" + kykSyouhn.getSyouhncd();
                    addSuuriyouErrJyouhou(zennouIdouKykInfoBean.getSyono(), errorMst, ansyuKihon, kykKihon);
                    errorCount++;
                    maeRcdSyonoErrorFlag = true;
                    maeRcdSyono = idouZennouInfo.getSyono();
                    maeRcdSyoriYmd = idouZennouInfo.getZennouseisansyoriymd();
                    continue;
                }

                syuKykSyuruicd= srSuuriKbnHenkanBean.getHenkanAtoKbn();

                BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
                SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(kykSyouhn.getSyouhncd()
                    , kykSyouhn.getKyktuukasyu());
                if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {
                    String errorMst = "セグメントコード取得エラー　商品コード：" + kykSyouhn.getSyouhncd() + "　通貨種類：" +
                        kykSyouhn.getKyktuukasyu();
                    addSuuriyouErrJyouhou(zennouIdouKykInfoBean.getSyono(), errorMst, ansyuKihon, kykKihon);
                    errorCount = errorCount + 1;
                    maeRcdSyonoErrorFlag = true;
                    maeRcdSyono = idouZennouInfo.getSyono();
                    maeRcdSyoriYmd = idouZennouInfo.getZennouseisansyoriymd();
                    continue;
                }

                C_Segcd kbnkeiriSeg1cd = syouhinbetuSegmentBean.getSegcd1();

                String gkdtznnhyj = "0";
                String znngaikakbn = "0";
                String yenkanyknhyj = "0";
                BizNumber znnnyknjikawaserate = BizNumber.ZERO;
                BizDate znnnyknjikawaseratetkyuymd = null;
                BizNumber ksnkisikawaserate = BizNumber.ZERO;
                BizNumber znncalckjynymdkwsrate = BizNumber.ZERO;
                BizNumber ksnkimatukawaserate = BizNumber.ZERO;
                BizCurrency zennounyuukinkgktkmatu = BizCurrency.valueOf(0);

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                C_Tuukasyu tkJitenZennouType = henkanTuuka.henkanTuukaTypeToKbn(zennouIdouKykInfoBean.getZennoujihrkp().
                    getType());

                if (!C_Tuukasyu.JPY.eq(tkJitenZennouType)) {
                    gkdtznnhyj = "1";
                }

                srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
                    tkJitenZennouType.getValue());
                if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {
                    String errnaiyou = "前納外貨区分変換エラー　通貨種類：" + tkJitenZennouType.getValue();
                    addSuuriyouErrJyouhou(zennouIdouKykInfoBean.getSyono(), errnaiyou, ansyuKihon, kykKihon);
                    errorCount = errorCount + 1;
                    maeRcdSyonoErrorFlag = true;
                    maeRcdSyono = idouZennouInfo.getSyono();
                    maeRcdSyoriYmd = idouZennouInfo.getZennouseisansyoriymd();
                    continue;
                }
                znngaikakbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();

                ChkZennouKeisanTuuka chkZennouKeisanTuuka = SWAKInjector.getInstance(ChkZennouKeisanTuuka.class);
                C_ErrorKbn errorKbn = chkZennouKeisanTuuka.exec(zennouIdouKykInfoBean.getSyono(), znngaikakbn);
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    String errnaiyou = "前納外貨区分不正";
                    addSuuriyouErrJyouhou(idouZennouInfo.getSyono(), errnaiyou, ansyuKihon, kykKihon);
                    errorCount = errorCount + 1;
                    maeRcdSyonoErrorFlag = true;
                    maeRcdSyono = idouZennouInfo.getSyono();
                    maeRcdSyoriYmd = idouZennouInfo.getZennouseisansyoriymd();
                    continue;
                }

                if (!"0".equals(gkdtznnhyj)) {
                    if (C_Tuukasyu.USD.eq(tkJitenZennouType)) {
                        if (!BizUtil.isBlank(kessankiSiDollarRateErrMsg)) {
                            addSuuriyouErrJyouhou(zennouIdouKykInfoBean.getSyono(), kessankiSiDollarRateErrMsg,
                                ansyuKihon,kykKihon);
                            errorCount = errorCount + 1;
                            maeRcdSyonoErrorFlag = true;
                            maeRcdSyono = idouZennouInfo.getSyono();
                            maeRcdSyoriYmd = idouZennouInfo.getZennouseisansyoriymd();
                            continue;
                        }
                        ksnkisikawaserate = kessankiSiDollarRate;

                        if (!BizUtil.isBlank(kessankiMaDollarRateErrMsg)) {
                            addSuuriyouErrJyouhou(zennouIdouKykInfoBean.getSyono(), kessankiMaDollarRateErrMsg,
                                ansyuKihon, kykKihon);
                            errorCount = errorCount + 1;
                            maeRcdSyonoErrorFlag = true;
                            maeRcdSyono = idouZennouInfo.getSyono();
                            maeRcdSyoriYmd = idouZennouInfo.getZennouseisansyoriymd();
                            continue;
                        }
                        ksnkimatukawaserate = kessankiMaDollarRate;
                    }

                    if (C_Tuukasyu.JPY.eq(zennouIdouKykInfoBean.getRstuukasyu())) {
                        yenkanyknhyj = "1";
                        znnnyknjikawaserate = zennouIdouKykInfoBean.getRyosyukwsrate();
                        znnnyknjikawaseratetkyuymd = zennouIdouKykInfoBean.getRyosyukwsratekjymd();
                    }
                    else {
                        znnnyknjikawaseratetkyuymd = zennouIdouKykInfoBean.getTyakkinymd();
                        if (zennouIdouKykInfoBean.getTyakkinymd().isHoliday()) {
                            znnnyknjikawaseratetkyuymd = zennouIdouKykInfoBean.getTyakkinymd().
                                getBusinessDay(CHolidayAdjustingMode.NEXT);
                        }
                        errorKbnKawaseRate = getKawaseRate.exec(znnnyknjikawaseratetkyuymd,
                            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                            tkJitenZennouType,
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.NYUKINRATE,
                            C_EigyoubiHoseiKbn.BLNK,
                            C_YouhiKbn.HUYOU);
                        if (C_ErrorKbn.ERROR.eq(errorKbnKawaseRate)) {
                            String getKawaseRateErrMsg = MessageUtil.getMessage(MessageId.EBF1021,
                                znnnyknjikawaseratetkyuymd.toString(),
                                tkJitenZennouType.getValue(),
                                C_Tuukasyu.JPY.getValue());
                            addSuuriyouErrJyouhou(zennouIdouKykInfoBean.getSyono(), getKawaseRateErrMsg, ansyuKihon,
                                kykKihon);
                            errorCount = errorCount + 1;
                            maeRcdSyonoErrorFlag = true;
                            maeRcdSyono = idouZennouInfo.getSyono();
                            maeRcdSyoriYmd = idouZennouInfo.getZennouseisansyoriymd();
                            continue;
                        }
                        znnnyknjikawaserate = getKawaseRate.getKawaserate();
                    }

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    zennounyuukinkgktkmatu = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                        zennouIdouKykInfoBean.getZennounyuukinkgk(),
                        ksnkimatukawaserate,
                        C_HasuusyoriKbn.SSYGNY);

                    BizDate znncalckjynymd = idouZennouInfo.getZennouseisankijyunymd();

                    if (znncalckjynymd.isHoliday()) {
                        znncalckjynymd = znncalckjynymd.getBusinessDay(CHolidayAdjustingMode.NEXT);
                    }

                    errorKbnKawaseRate = getKawaseRate.exec(znncalckjynymd,
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        tkJitenZennouType,
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.SYUKKINRATE,
                        C_EigyoubiHoseiKbn.BLNK,
                        C_YouhiKbn.HUYOU);

                    if (C_ErrorKbn.ERROR.eq(errorKbnKawaseRate)) {
                        String getKawaseRateErrMsg = MessageUtil.getMessage(MessageId.EBF1021,
                            String.valueOf(znncalckjynymd),
                            tkJitenZennouType.getValue(),
                            C_Tuukasyu.JPY.getValue());
                        addSuuriyouErrJyouhou(zennouIdouKykInfoBean.getSyono(), getKawaseRateErrMsg, ansyuKihon,
                            kykKihon);

                        errorCount = errorCount + 1;
                        maeRcdSyonoErrorFlag = true;
                        maeRcdSyono = idouZennouInfo.getSyono();
                        maeRcdSyoriYmd = idouZennouInfo.getZennouseisansyoriymd();
                        continue;
                    }
                    znncalckjynymdkwsrate = getKawaseRate.getKawaserate();

                }
                IT_ZennouHoyuuIdouKykDtl zennouHoyuuIdouKykDtl = new IT_ZennouHoyuuIdouKykDtl(kykSyouhn.getSyono(),
                    syoriYmd, syoricd, Integer.parseInt(kykMfksnctr));

                zennouHoyuuIdouKykDtl.setHenkousyoriymd(idouZennouInfo.getZennouseisansyoriymd());
                zennouHoyuuIdouKykDtl.setZennoukessanrecordkbn("3");
                zennouHoyuuIdouKykDtl.setKeijyouym(denYmd.getBizDateYM());
                zennouHoyuuIdouKykDtl.setDenymd(denYmd);
                zennouHoyuuIdouKykDtl.setZennoucalckijyunymd(idouZennouInfo.getZennouseisankijyunymd());
                zennouHoyuuIdouKykDtl.setSyukeiyakusyuruicd(syuKykSyuruicd);
                zennouHoyuuIdouKykDtl.setKbnkeirisegcd(kbnkeiriSeg1cd);
                zennouHoyuuIdouKykDtl.setKeiyakuymd(kykSyouhn.getKykymd());
                zennouHoyuuIdouKykDtl.setZennoukaisiymd(idouZennouInfo.getZennoukaisiymd());
                zennouHoyuuIdouKykDtl.setZennoukbn(C_ZennouKbn.IPPAN_ZENNOU);
                zennouHoyuuIdouKykDtl.setZennoukikan(idouZennouInfo.getZennoukikan());
                zennouHoyuuIdouKykDtl.setZennounyuukinymd(idouZennouInfo.getRyosyuymd());
                zennouHoyuuIdouKykDtl.setZennounyuukinkgk(zennouIdouKykInfoBean.getZennounyuukinkgk());
                zennouHoyuuIdouKykDtl.setToukijyuutoup(toukiJyuuToup);
                zennouHoyuuIdouKykDtl.setToukizennouseisangk(idouZennouInfo.getZennouseisankgk());
                zennouHoyuuIdouKykDtl.setToukizennounyuukinkgk(toukiZennounyuukinkgk);
                zennouHoyuuIdouKykDtl.setGyoumuKousinKinou(kinou.getKinouId());
                zennouHoyuuIdouKykDtl.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                zennouHoyuuIdouKykDtl.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                zennouHoyuuIdouKykDtl.setGkdtznnhyj(gkdtznnhyj);
                zennouHoyuuIdouKykDtl.setZnngaikakbn(znngaikakbn);
                zennouHoyuuIdouKykDtl.setYenkanyknhyj(yenkanyknhyj);
                zennouHoyuuIdouKykDtl.setZnnnyknjikawaserate(znnnyknjikawaserate);
                zennouHoyuuIdouKykDtl.setZnnnyknjikawaseratetkyuymd(znnnyknjikawaseratetkyuymd);
                zennouHoyuuIdouKykDtl.setKsnkisikawaserate(ksnkisikawaserate);
                zennouHoyuuIdouKykDtl.setZnncalckjynymdkwsrate(znncalckjynymdkwsrate);
                zennouHoyuuIdouKykDtl.setKsnkimatukawaserate(ksnkimatukawaserate);
                zennouHoyuuIdouKykDtl.setZennounyuukinkgktkmatu(zennounyuukinkgktkmatu);
                BizPropertyInitializer.initialize(zennouHoyuuIdouKykDtl);
                zennouHoyuuIdouKykDtlInserter.add(zennouHoyuuIdouKykDtl);
                syoriCount++;
                maeRcdSyono = idouZennouInfo.getSyono();
                maeRcdSyoriYmd = idouZennouInfo.getZennouseisansyoriymd();
                maeRcdSyonoErrorFlag = false;
                ansyuKihon.detach();
                kykKihon.detach();
            }
        }

        if ((errorCount != 0) && (RDPTX000.equals(kakutyoujobCd))) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(errorCount), "エラー件数"));
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCount), "正常登録件数"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(errorCount), "エラー件数"));

    }

    private void addSuuriyouErrJyouhou(String pSyoNo, String pSuuritoukeiyouerrnaiyou, IT_AnsyuKihon pAnsyuKihon,
        IT_KykKihon pKykKihon) {
        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
        suuriyouErrJyouhou.setSyoriYmd(syoriYmd);
        suuriyouErrJyouhou.setKakutyoujobcd(kakutyoujobCd);
        suuriyouErrJyouhou.setSyono(pSyoNo);
        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(ConvertUtil.toZenAll(pSuuritoukeiyouerrnaiyou, 0, 1));
        BizPropertyInitializer.initialize(suuriyouErrJyouhou);
        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);
        pAnsyuKihon.detach();
        pKykKihon.detach();
    }
}
