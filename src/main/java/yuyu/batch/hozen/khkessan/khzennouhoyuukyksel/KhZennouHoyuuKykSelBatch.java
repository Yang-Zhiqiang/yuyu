package yuyu.batch.hozen.khkessan.khzennouhoyuukyksel;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khkessan.khzennouhoyuukyksel.dba.KhZennouHoyuuKykSelDao;
import yuyu.batch.hozen.khkessan.khzennouhoyuukyksel.dba.ZennouHyuKykInfoBean;
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
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.khcommon.GetTkJitenZennouInfo;
import yuyu.common.hozen.khcommon.HanteiZennouKessanHoyuuKyk;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouKessanHoyuuHanteiKekkaKbn;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.classification.C_ZennoubikinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_ZennouRiritu2;
import yuyu.def.db.entity.BM_ZennouTumitateRitu2;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.IT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.hozen.detacher.IT_KhBikinkanriDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.detacher.JT_SiBikinkanriDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 決算 前納保有契約データ抽出
 */
public class KhZennouHoyuuKykSelBatch implements Batch {

    private static final String KAKUTYOUJOBCD_KESSANKIHONBAN = "RDPSX000";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhZennouHoyuuKykSelBatchParam khZennouHoyuuKykSelBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KhZennouHoyuuKykSelDao khZennouHoyuuKykSelDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private BizDate syoriYmd;

    private String kakutyoujobCd;

    @Override
    public BatchParam getParam() {

        return khZennouHoyuuKykSelBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        syoriYmd = khZennouHoyuuKykSelBatchParam.getSyoriYmd();
        kakutyoujobCd = khZennouHoyuuKykSelBatchParam.getIbKakutyoujobcd();
        BizDate kessanYmd = khZennouHoyuuKykSelBatchParam.getKessanYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyoujobCd));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1020), String.valueOf(kessanYmd)));

        long syoriCount = 0;
        long errorCount = 0;
        BizNumber kessankiSiDollarRate = BizNumber.ZERO;
        String kessankiSiDollarRateErrMsg = "";
        BizNumber kessankiMaDollarRate = BizNumber.ZERO;
        String kessankiMaDollarRateErrMsg = "";

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        BizDate kessanKaisibi = setKessanNensibi.exec(kessanYmd);
        BizDateY syoriNendo = kessanKaisibi.getBizDateY();
        BizDate zenNendoMatujitu = kessanKaisibi.addBusinessDays(-1);
        try (
            ExDBResults<ZennouHyuKykInfoBean> zennouHyuKykInfoBeanLst =
            khZennouHoyuuKykSelDao.getZennouHyuKykInfoBeans(kessanYmd);
            EntityInserter<IT_ZennouHoyuuIdouKykDtl> zennouHoyuuIdouKykDtlInserter = new EntityInserter<IT_ZennouHoyuuIdouKykDtl>();) {
            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            C_ErrorKbn errorKbnKawaseRate = getKawaseRate.exec(zenNendoMatujitu,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                C_Tuukasyu.USD,
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.BLNK,
                C_YouhiKbn.HUYOU);
            if (C_ErrorKbn.ERROR.eq(errorKbnKawaseRate)) {
                kessankiSiDollarRateErrMsg = MessageUtil.getMessage(MessageId.EBF1021,
                    zenNendoMatujitu.toString(),
                    C_Tuukasyu.USD.getValue(),
                    C_Tuukasyu.JPY.getValue());
            }
            else {
                kessankiSiDollarRate = getKawaseRate.getKawaserate();
            }

            BizDate getKawaseRateYoukessanYmd = kessanYmd;
            if (kessanYmd.isHoliday()) {
                getKawaseRateYoukessanYmd = kessanYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
            }
            errorKbnKawaseRate = getKawaseRate.exec(getKawaseRateYoukessanYmd,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                C_Tuukasyu.USD,
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.BLNK,
                C_YouhiKbn.HUYOU);
            if (C_ErrorKbn.ERROR.eq(errorKbnKawaseRate)) {
                kessankiMaDollarRateErrMsg = MessageUtil.getMessage(MessageId.EBF1021,
                    getKawaseRateYoukessanYmd.toString(),
                    C_Tuukasyu.USD.getValue(),
                    C_Tuukasyu.JPY.getValue());
            }
            else {
                kessankiMaDollarRate = getKawaseRate.getKawaserate();
            }

            for (ZennouHyuKykInfoBean zennouHyuKykInfoBean : zennouHyuKykInfoBeanLst) {
                String syoNo = zennouHyuKykInfoBean.getSyono();
                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
                IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

                List<IT_KhBikinkanri> khBikinkanriLst =
                    hozenDomManager.getKhBikinkanrisBySyono(syoNo);
                khBikinkanriLst = IT_KhBikinkanriDetacher.detachKhBikinkanritouched(khBikinkanriLst);

                List<JT_SiBikinkanri> siBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(syoNo);
                siBikinkanriLst = JT_SiBikinkanriDetacher.detachSiBikinkanritouched(siBikinkanriLst);

                IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey(kykSyouhn.getHenkousikibetukey());

                HanteiZennouKessanHoyuuKyk hanteiZennouKessanHoyuuKyk = SWAKInjector.getInstance(HanteiZennouKessanHoyuuKyk.class);
                C_ZennouKessanHoyuuHanteiKekkaKbn hyuHanteikekkaKbn = hanteiZennouKessanHoyuuKyk.exec(
                    kessanYmd,
                    syoNo,
                    kykKihon.getSkeikeijyouym(),
                    kykSyouhn,
                    khTtdkRireki,
                    khBikinkanriLst,
                    siBikinkanriLst);
                BizDate calckijyunYmd = hanteiZennouKessanHoyuuKyk.getCalckijyunymd();
                C_ZennoubikinKbn bikinKbn;
                if (C_ZennouKessanHoyuuHanteiKekkaKbn.HOYUUTAISYOU.eq(hyuHanteikekkaKbn)) {
                    bikinKbn = C_ZennoubikinKbn.YUUKOU;
                }
                else if (C_ZennouKessanHoyuuHanteiKekkaKbn.BIKINTAISYOU.eq(hyuHanteikekkaKbn)) {
                    bikinKbn = C_ZennoubikinKbn.BIKIN;
                }
                else {
                    continue;
                }

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);

                IT_Zennou zennou = khZennouHoyuuKykSelDao.getZennou(ansyuKihon,
                    zennouHyuKykInfoBean.getZennoukaisiymd(), zennouHyuKykInfoBean.getRenno());

                IT_Zennou tkJitenZennou;

                if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(zennouHyuKykInfoBean.getGyoumuKousinKinou())) {

                    GetTkJitenZennouInfo getTkJitenZennouInfo = SWAKInjector.getInstance(GetTkJitenZennouInfo.class);
                    tkJitenZennou = getTkJitenZennouInfo.exec(C_ZennouSeisanKbn.MISEISAN, kessanYmd, zennou);
                }
                else {

                    tkJitenZennou = zennou;
                }

                ansyuKihon.detach();

                KeisanZennouSeisanGk2 keisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);
                C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(calckijyunYmd,
                    kykSyouhn.getKykymd(),
                    tkJitenZennou.getZennoujihrkp(),
                    tkJitenZennou.getZennoukaisiymd(),
                    tkJitenZennou.getRyosyuymd(),
                    tkJitenZennou.getZennounyuukinkgk());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    errorCount = errorCount + 1;
                    String errnaiyou = "前納精算額計算エラー";
                    addSuuriyouErrJyouhou(tkJitenZennou.getSyono(), errnaiyou, kykKihon);
                    continue;
                }

                BizCurrency tndmatuzndk =  keisanZennouSeisanGk2.getZennouSeisanGk();
                String tkyTmttZndkHikakuKbn = keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn();

                BizDate kykOutouYmd;
                if (kykSyouhn.getKykymd().getMonth() >= 4) {
                    kykOutouYmd = BizDate.valueOf(syoriNendo, kykSyouhn.getKykymd().getBizDateMD()).getRekijyou();
                }
                else {
                    kykOutouYmd = BizDate.valueOf(syoriNendo.getNextYear(), kykSyouhn.getKykymd().getBizDateMD()).getRekijyou();
                }

                C_UmuKbn konkiKykuoutoubiUmuKbn;
                BizDate konkiKykuoutoubi;
                BizDate jikaiKykuoutoubi;
                if ((BizDateUtil.compareYmd(kykOutouYmd, kessanKaisibi) == BizDateUtil.COMPARE_GREATER
                    || BizDateUtil.compareYmd(kykOutouYmd, kessanKaisibi) == BizDateUtil.COMPARE_EQUAL) &&
                    (BizDateUtil.compareYmd(kykOutouYmd, kessanYmd) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYmd(kykOutouYmd, kessanYmd) == BizDateUtil.COMPARE_EQUAL)) {
                    konkiKykuoutoubiUmuKbn = C_UmuKbn.ARI;
                    konkiKykuoutoubi = kykOutouYmd;
                    jikaiKykuoutoubi = kykOutouYmd.addYears(1).getRekijyou();
                }
                else {
                    konkiKykuoutoubiUmuKbn = C_UmuKbn.NONE;
                    konkiKykuoutoubi = null;
                    jikaiKykuoutoubi = kykOutouYmd;
                }

                BizCurrency toukiZennouNyuukinkgk = BizCurrency.valueOf(0);
                if ((BizDateUtil.compareYmd(tkJitenZennou.getRyosyuymd(), kessanKaisibi) == BizDateUtil.COMPARE_GREATER
                    || BizDateUtil.compareYmd(tkJitenZennou.getRyosyuymd(), kessanKaisibi) == BizDateUtil.COMPARE_EQUAL)&&
                    (BizDateUtil.compareYmd(tkJitenZennou.getRyosyuymd(), kessanYmd) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYmd(tkJitenZennou.getRyosyuymd(), kessanYmd) == BizDateUtil.COMPARE_EQUAL)) {
                    toukiZennouNyuukinkgk = tkJitenZennou.getZennounyuukinkgk();
                }

                BizCurrency toukijyuutoup = BizCurrency.valueOf(0);
                if (C_UmuKbn.ARI.eq(konkiKykuoutoubiUmuKbn) &&
                    BizDateUtil.compareYm(tkJitenZennou.getZennoukaisiymd().getBizDateYM(),
                        konkiKykuoutoubi.getBizDateYM()) != BizDateUtil.COMPARE_GREATER
                        && BizDateUtil.compareYmd(konkiKykuoutoubi, calckijyunYmd) != BizDateUtil.COMPARE_GREATER
                        && BizDateUtil.compareYm(konkiKykuoutoubi.getBizDateYM(),
                            tkJitenZennou.getAnnaisaikaiym()) == BizDateUtil.COMPARE_LESSER) {

                    toukijyuutoup = tkJitenZennou.getZennoujihrkp();
                }

                BizCurrency yokukiNenbaraip = BizCurrency.valueOf(0);
                if ((BizDateUtil.compareYm(tkJitenZennou.getZennoukaisiymd().getBizDateYM(),
                    jikaiKykuoutoubi.getBizDateYM()) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYm(tkJitenZennou.getZennoukaisiymd().getBizDateYM(),
                        jikaiKykuoutoubi.getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) &&
                        BizDateUtil.compareYm(jikaiKykuoutoubi.getBizDateYM(),
                            tkJitenZennou.getAnnaisaikaiym()) == BizDateUtil.COMPARE_LESSER) {
                    yokukiNenbaraip = tkJitenZennou.getZennoujihrkp();
                }
                String kykMfksnctr = kessanYmd.toString().substring(kessanYmd.toString().length() - 6) + "1";

                SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
                SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(C_SrKbnHenkanKbn.SYOKEIYAKU,
                    kykSyouhn.getSyouhncd(),kykSyouhn.getKyktuukasyu().getValue());

                if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {
                    errorCount = errorCount + 1;
                    String errnaiyou = "主契約種類コード区分変換エラー　商品コード：" + kykSyouhn.getSyouhncd();
                    addSuuriyouErrJyouhou(tkJitenZennou.getSyono(), errnaiyou, kykKihon);
                    continue;
                }

                String syokeiyaku = srSuuriKbnHenkanBean.getHenkanAtoKbn();
                BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
                SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(kykSyouhn.getSyouhncd(),
                    kykSyouhn.getKyktuukasyu());
                if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {
                    String errnaiyou = "セグメントコード取得エラー　商品コード：" + kykSyouhn.getSyouhncd() + "　通貨種類：" +
                        kykSyouhn.getKyktuukasyu().getValue();
                    addSuuriyouErrJyouhou(tkJitenZennou.getSyono(), errnaiyou, kykKihon);
                    errorCount = errorCount + 1;
                    continue;
                }
                C_Segcd seg1cd = syouhinbetuSegmentBean.getSegcd1();

                C_ZennouToukeiListKbn zennouToukeiListKbn;
                BizDateY zennouManryouNendo;
                BizDateY hanteiNendo;

                if (C_ZennoubikinKbn.BIKIN.eq(bikinKbn)) {
                    zennouToukeiListKbn = C_ZennouToukeiListKbn.OTHER;
                }
                else {
                    if (tkJitenZennou.getAnnaisaikaiym().getMonth() >= 4) {
                        zennouManryouNendo = tkJitenZennou.getAnnaisaikaiym().getBizDateY();
                    }
                    else {
                        zennouManryouNendo = tkJitenZennou.getAnnaisaikaiym().getBizDateY().addYears(-1);
                    }

                    if (syoriYmd.getMonth() >= 4) {
                        hanteiNendo = syoriYmd.getBizDateY();
                    }
                    else {
                        hanteiNendo = syoriYmd.getBizDateY().addYears(-1);
                    }

                    if (zennouManryouNendo.compareTo(hanteiNendo) == 0) {
                        zennouToukeiListKbn = C_ZennouToukeiListKbn.MANRYOUBUN_MKKP;
                    }
                    else {
                        zennouToukeiListKbn = C_ZennouToukeiListKbn.ZENNOU_MKKP;
                    }
                }

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
                BizDate ryosyuTykzenoutouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN,
                    kykSyouhn.getKykymd(),
                    C_Hrkkaisuu.NEN,
                    tkJitenZennou.getRyosyuymd());

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                C_Tuukasyu tkJitenZennouType = henkanTuuka.henkanTuukaTypeToKbn(tkJitenZennou.getZennoujihrkp().
                    getType());

                BM_ZennouRiritu2 zennouRiritu2 = khZennouHoyuuKykSelDao.getZennouRiritu2(tkJitenZennouType,
                    ryosyuTykzenoutouYmd);
                if (zennouRiritu2 == null) {
                    errorCount = errorCount + 1;
                    String errnaiyou = "前納利率マスタ２取得エラー　通貨種類：" + tkJitenZennouType.getContent() +
                        "領収日直前応当日：" + ryosyuTykzenoutouYmd;
                    addSuuriyouErrJyouhou(tkJitenZennou.getSyono(), errnaiyou, kykKihon);
                    continue;
                }

                BizNumber znRiritu = zennouRiritu2.getZennouriritu();
                BizNumber tndmatutkyrt = znRiritu;
                BizDate rthndStartymd;
                if (KeisanZennouSeisanGk2.TKYTMMTTZNDKHIKAKBN_ZNNTMIRIRITUZNDK.equals(tkyTmttZndkHikakuKbn)) {
                    if (BizDateUtil.compareYmd(kessanKaisibi, tkJitenZennou.getRyosyuymd()) == BizDateUtil.COMPARE_GREATER
                        || BizDateUtil.compareYmd(kessanKaisibi, tkJitenZennou.getRyosyuymd()) == BizDateUtil.COMPARE_EQUAL) {
                        rthndStartymd = kessanKaisibi;
                    }
                    else {
                        rthndStartymd = tkJitenZennou.getRyosyuymd();
                    }

                    int index = 0;
                    List<BM_ZennouTumitateRitu2> zennouTumitateRituLst = khZennouHoyuuKykSelDao.getTumitateRitu2(
                        tkJitenZennouType, rthndStartymd, calckijyunYmd);

                    if (zennouTumitateRituLst.size() > 4) {
                        index = 3;
                    }
                    else {
                        index = zennouTumitateRituLst.size() - 1;
                    }

                    for (int m = 0; m <= index; m++) {
                        if (znRiritu.compareTo(zennouTumitateRituLst.get(m).getZennoutumitateritu()) >= 0) {
                            tndmatutkyrt = znRiritu;
                        }
                        else {
                            tndmatutkyrt = zennouTumitateRituLst.get(m).getZennoutumitateritu();
                        }
                    }
                }

                String gkdtznnhyj = "0";
                String znngaikakbn = "0";
                String yenkanyknhyj = "0";
                BizNumber znnnyknjikawaserate = BizNumber.ZERO;
                BizDate znnnyknjikawaseratetkyuymd = null;
                BizNumber ksnkisikawaserate = BizNumber.ZERO;
                BizNumber ksnkimatukawaserate = BizNumber.ZERO;
                BizCurrency zennounyuukinkgktkmatu = BizCurrency.valueOf(0);
                BizCurrency tkmatuznnzndktkmatu = BizCurrency.valueOf(0);
                BizNumber znncalckjynymdkwsrate = BizNumber.ZERO;

                if (!C_Tuukasyu.JPY.eq(tkJitenZennouType)) {
                    gkdtznnhyj = "1";
                }

                srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
                    tkJitenZennouType.getValue());
                if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {
                    String errnaiyou = "前納外貨区分変換エラー　通貨種類：" + tkJitenZennouType.getValue();
                    addSuuriyouErrJyouhou(tkJitenZennou.getSyono(), errnaiyou, kykKihon);
                    errorCount = errorCount + 1;
                    continue;
                }
                znngaikakbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();

                ChkZennouKeisanTuuka chkZennouKeisanTuuka = SWAKInjector.getInstance(ChkZennouKeisanTuuka.class);
                errorKbn = chkZennouKeisanTuuka.exec(tkJitenZennou.getSyono(), znngaikakbn);
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    String errnaiyou = "前納外貨区分不正";
                    addSuuriyouErrJyouhou(tkJitenZennou.getSyono(), errnaiyou, kykKihon);
                    errorCount = errorCount + 1;
                    continue;
                }

                if (!"0".equals(gkdtznnhyj)) {
                    if (C_Tuukasyu.USD.eq(tkJitenZennouType)) {
                        if (!BizUtil.isBlank(kessankiSiDollarRateErrMsg)) {
                            addSuuriyouErrJyouhou(tkJitenZennou.getSyono(), kessankiSiDollarRateErrMsg, kykKihon);
                            errorCount = errorCount + 1;
                            continue;
                        }
                        ksnkisikawaserate = kessankiSiDollarRate;

                        if (!BizUtil.isBlank(kessankiMaDollarRateErrMsg)) {
                            addSuuriyouErrJyouhou(tkJitenZennou.getSyono(), kessankiMaDollarRateErrMsg, kykKihon);
                            errorCount = errorCount + 1;
                            continue;
                        }
                        ksnkimatukawaserate = kessankiMaDollarRate;
                    }

                    if (C_Tuukasyu.JPY.eq(tkJitenZennou.getRstuukasyu())) {
                        yenkanyknhyj = "1";
                        znnnyknjikawaserate = tkJitenZennou.getRyosyukwsrate();
                        znnnyknjikawaseratetkyuymd = tkJitenZennou.getRyosyukwsratekjymd();
                    }
                    else {
                        znnnyknjikawaseratetkyuymd = tkJitenZennou.getTyakkinymd();
                        if (tkJitenZennou.getTyakkinymd().isHoliday()) {
                            znnnyknjikawaseratetkyuymd = tkJitenZennou.getTyakkinymd().getBusinessDay(CHolidayAdjustingMode.NEXT);
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
                            addSuuriyouErrJyouhou(tkJitenZennou.getSyono(), getKawaseRateErrMsg, kykKihon);
                            errorCount = errorCount + 1;
                            continue;
                        }

                        znnnyknjikawaserate = getKawaseRate.getKawaserate();
                    }

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                    zennounyuukinkgktkmatu = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                        tkJitenZennou.getZennounyuukinkgk(),
                        ksnkimatukawaserate,
                        C_HasuusyoriKbn.SSYGNY);

                    tkmatuznnzndktkmatu = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                        tndmatuzndk,
                        ksnkimatukawaserate,
                        C_HasuusyoriKbn.SSYGNY);

                    znncalckjynymdkwsrate = ksnkimatukawaserate;
                    if (C_ZennoubikinKbn.BIKIN.eq(bikinKbn)) {
                        errorKbnKawaseRate = getKawaseRate.exec(calckijyunYmd,
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                            tkJitenZennouType,
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.JISSEIRATE,
                            C_EigyoubiHoseiKbn.BLNK,
                            C_YouhiKbn.HUYOU);
                        if (C_ErrorKbn.ERROR.eq(errorKbnKawaseRate)) {
                            String getKawaseRateErrMsg = MessageUtil.getMessage(MessageId.EBF1021,
                                calckijyunYmd.toString(),
                                tkJitenZennouType.getValue(),
                                C_Tuukasyu.JPY.getValue());
                            addSuuriyouErrJyouhou(tkJitenZennou.getSyono(), getKawaseRateErrMsg, kykKihon);
                            errorCount = errorCount + 1;
                            continue;
                        }
                        znncalckjynymdkwsrate = getKawaseRate.getKawaserate();
                    }
                }

                IT_ZennouHoyuuIdouKykDtl zennouHoyuuIdouKykDtl = new IT_ZennouHoyuuIdouKykDtl(tkJitenZennou.getSyono(),
                    syoriYmd, kinou.getSyoricd(), Integer.parseInt(kykMfksnctr));
                zennouHoyuuIdouKykDtl.setHenkousyoriymd(syoriYmd);
                zennouHoyuuIdouKykDtl.setZennoukessanrecordkbn("1");
                zennouHoyuuIdouKykDtl.setKeijyouym(calckijyunYmd.getBizDateYM());
                zennouHoyuuIdouKykDtl.setDenymd(kessanYmd);
                zennouHoyuuIdouKykDtl.setZennoucalckijyunymd(calckijyunYmd);
                zennouHoyuuIdouKykDtl.setZennoubikinkbn(bikinKbn);
                zennouHoyuuIdouKykDtl.setSyukeiyakusyuruicd(syokeiyaku);
                zennouHoyuuIdouKykDtl.setKbnkeirisegcd(seg1cd);
                zennouHoyuuIdouKykDtl.setZennoutoukeilistkbn(zennouToukeiListKbn);
                zennouHoyuuIdouKykDtl.setKeiyakuymd(kykSyouhn.getKykymd());
                zennouHoyuuIdouKykDtl.setZennouwrbkrt(znRiritu);
                zennouHoyuuIdouKykDtl.setTndmatutkyrt(tndmatutkyrt);
                zennouHoyuuIdouKykDtl.setTndzndkhikakukbn(tkyTmttZndkHikakuKbn);
                zennouHoyuuIdouKykDtl.setZennoukaisiymd(tkJitenZennou.getZennoukaisiymd());
                zennouHoyuuIdouKykDtl.setZennoukbn(C_ZennouKbn.IPPAN_ZENNOU);
                zennouHoyuuIdouKykDtl.setZennoukikan(tkJitenZennou.getZennoukikan());
                zennouHoyuuIdouKykDtl.setZennounyuukinymd(tkJitenZennou.getRyosyuymd());
                zennouHoyuuIdouKykDtl.setZennounyuukinkgk(tkJitenZennou.getZennounyuukinkgk());
                zennouHoyuuIdouKykDtl.setToukimatuzennouzndk(tndmatuzndk);
                zennouHoyuuIdouKykDtl.setToukijyuutoup(toukijyuutoup);
                zennouHoyuuIdouKykDtl.setToukizennounyuukinkgk(toukiZennouNyuukinkgk);
                zennouHoyuuIdouKykDtl.setYokukinenbaraip(yokukiNenbaraip);
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
                zennouHoyuuIdouKykDtl.setTkmatuznnzndktkmatu(tkmatuznnzndktkmatu);

                BizPropertyInitializer.initialize(zennouHoyuuIdouKykDtl);
                zennouHoyuuIdouKykDtlInserter.add(zennouHoyuuIdouKykDtl);
                syoriCount = syoriCount + 1;
            }
        }

        if (errorCount != 0 && KAKUTYOUJOBCD_KESSANKIHONBAN.equals(kakutyoujobCd)) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(errorCount), "エラー件数"));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCount), "正常登録件数"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(errorCount), "エラー件数"));
    }

    private void addSuuriyouErrJyouhou (String pSyoNo, String pSuuritoukeiyouerrnaiyou, IT_KykKihon pKykKihon) {
        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
        suuriyouErrJyouhou.setSyoriYmd(syoriYmd);
        suuriyouErrJyouhou.setKakutyoujobcd(kakutyoujobCd);
        suuriyouErrJyouhou.setSyono(pSyoNo);
        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(ConvertUtil.toZenAll(pSuuritoukeiyouerrnaiyou, 0, 1));
        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        BizPropertyInitializer.initialize(suuriyouErrJyouhou);
        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);
        pKykKihon.detach();
    }
}
