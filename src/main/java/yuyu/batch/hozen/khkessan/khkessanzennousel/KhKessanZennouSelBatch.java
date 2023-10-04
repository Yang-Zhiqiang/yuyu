package yuyu.batch.hozen.khkessan.khkessanzennousel;

import java.util.ArrayList;
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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khkessan.khkessanzennousel.dba.KhKessanZennouSelDao;
import yuyu.batch.hozen.khkessan.khkessanzennousel.dba.ZennouInfoBean;
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
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.SrHoyuuKeiyakuCheck;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HoyuuCheckKekkaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SyouhinJyouhouGetKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.entity.BM_ZennouRiritu2;
import yuyu.def.db.entity.BM_ZennouTumitateRitu2;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.IT_ZennouKessan;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 決算 決算用前納データ抽出
 */
public class KhKessanZennouSelBatch implements Batch {

    private static final String RDPMX000 = "RDPMX000";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhKessanZennouSelBatchParam batchParam;

    @Inject
    private KhKessanZennouSelDao khKessanZennouSelDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Override
    public BatchParam getParam() {

        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = batchParam.getSyoriYmd();

        BizDate kessanYmd = batchParam.getKessanYmd();

        String kakutyoujobCd = batchParam.getIbKakutyoujobcd();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        long syoriKns = 0;

        long errorKns = 0;

        BizNumber zennouriritu = BizNumber.valueOf(0);

        BizNumber ksnkisikawaserate = BizNumber.valueOf(0);

        BizNumber ksnkisikawaseratengt = BizNumber.valueOf(0);

        BizNumber tndmatuzndkksnjkwsrate = BizNumber.valueOf(0);

        BizNumber tndmatuzndkksnjkwsratengt = BizNumber.valueOf(0);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1020),
            String.valueOf(kessanYmd)));

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

        BizDate kessanStartymd = setKessanNensibi.exec(kessanYmd);

        BizDateY syoriNendo = null;

        if (syoriYmd.getMonth() >= 4) {

            syoriNendo = syoriYmd.getBizDateY();
        }
        else {

            syoriNendo = syoriYmd.getBizDateY().addYears(-1);
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        BizDate zennendoMatuymd = kessanStartymd.addBusinessDays(-1);

        C_ErrorKbn errorKbn1 = getKawaseRate.exec(zennendoMatuymd, C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
            C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.BLNK, C_YouhiKbn.HUYOU);

        if (C_ErrorKbn.OK.eq(errorKbn1)) {
            ksnkisikawaserate = getKawaseRate.getKawaserate();
        }

        C_ErrorKbn errorKbn2 = getKawaseRate.exec(kessanYmd, C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
            C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.ZENEIGYOUBI, C_YouhiKbn.HUYOU);

        if (C_ErrorKbn.OK.eq(errorKbn2)) {
            tndmatuzndkksnjkwsrate = getKawaseRate.getKawaserate();
        }

        try (ExDBResults<ZennouInfoBean> zennouInfoBeanLst = khKessanZennouSelDao.getZennouInfos(kessanYmd);
            EntityInserter<IT_ZennouKessan> zennouKessanInserter = new EntityInserter<>();) {

            for (ZennouInfoBean zennouInfoBean : zennouInfoBeanLst) {

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(zennouInfoBean.getSyono());

                List<SV_KiykSyuhnData> kiykSyuhnDataLst1 = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(
                    zennouInfoBean.getSyono(), C_SyutkKbn.SYU);

                List<SV_KiykSyuhnData> kiykSyuhnDataLst2 = SV_KiykSyuhnDataDetacher
                    .detachKiykSyuhnDatatouched(kiykSyuhnDataLst1);

                SortSV_KiykSyuhnData sortSVkiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

                List<SV_KiykSyuhnData> kiykSyuhnDataLst = sortSVkiykSyuhnData
                    .OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(kiykSyuhnDataLst2);

                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector
                    .getInstance(SrGetTokutejitenSyohnInfo.class);

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO, zennouInfoBean.getSyono(), kessanYmd, "",
                    kiykSyuhnDataLst);

                if (C_SyouhinJyouhouGetKbn.SYOUHININFONASI.eq(tkJitenKeiyakuSyouhinBean.getSyouhinJyouhouGetKbnAto())) {
                    kykKihon.detach();

                    continue;
                }

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean
                    .getTkJitenKeiyakuSyouhinKijyunBeanAto();

                IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU,
                    tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), tkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno(),
                    tkJitenKeiyakuSyouhinKijyunBean.getKyksyouhnrenno());

                List<IT_KhBikinkanri> khBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(zennouInfoBean
                    .getSyono());

                List<JT_SiBikinkanri> siBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(zennouInfoBean
                    .getSyono());

                IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey(kykSyouhn
                    .getHenkousikibetukey());

                SrHoyuuKeiyakuCheck srHoyuuKeiyakuCheck = SWAKInjector.getInstance(SrHoyuuKeiyakuCheck.class);

                C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(
                    kessanYmd,
                    zennouInfoBean.getSyono(),
                    kykKihon.getSkeikeijyouym(),
                    kykSyouhn,
                    khTtdkRireki,
                    khBikinkanriLst,
                    siBikinkanriLst);

                if (!C_HoyuuCheckKekkaKbn.HOYUUTAISYOU.eq(hoyuuCheckKekkaKbn)) {

                    for (IT_KhBikinkanri khBikinkanri : khBikinkanriLst) {

                        khBikinkanri.detach();
                    }

                    for (JT_SiBikinkanri siBikinkanri : siBikinkanriLst) {

                        siBikinkanri.detach();
                    }

                    kykKihon.detach();

                    continue;
                }

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(zennouInfoBean.getSyono());

                IT_Zennou zennou = khKessanZennouSelDao.getZennou(ansyuKihon, zennouInfoBean.getZennoukaisiymd(),
                    zennouInfoBean.getRenno());

                GetTkJitenZennouInfo getTkJitenZennouInfo = SWAKInjector.getInstance(GetTkJitenZennouInfo.class);

                IT_Zennou tokuteijitenZennou = getTkJitenZennouInfo.exec(C_ZennouSeisanKbn.MISEISAN, kessanYmd, zennou);

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                C_Tuukasyu calctuukaSyu = henkanTuuka.henkanTuukaTypeToKbn(zennou.getZennoujihrkp().getType());
                if (C_Tuukasyu.USD.eq(calctuukaSyu)) {
                    if (C_ErrorKbn.ERROR.eq(errorKbn1)) {
                        String msg = MessageUtil.getMessage(MessageId.EBF1021, zennendoMatuymd.toString(),
                            C_Tuukasyu.USD.toString(), C_Tuukasyu.JPY.toString());
                        handleError(msg, kykKihon, ansyuKihon, khBikinkanriLst, siBikinkanriLst);
                        errorKns = errorKns + 1;
                        continue;
                    }
                    ksnkisikawaseratengt = ksnkisikawaserate;
                }
                else {
                    ksnkisikawaseratengt =  BizNumber.valueOf(0);
                }

                if (C_Tuukasyu.USD.eq(calctuukaSyu)) {
                    if (C_ErrorKbn.ERROR.eq(errorKbn2)) {
                        String msg = MessageUtil.getMessage(MessageId.EBF1021, kessanYmd.toString(),
                            C_Tuukasyu.USD.toString(), C_Tuukasyu.JPY.toString());
                        handleError(msg, kykKihon, ansyuKihon, khBikinkanriLst, siBikinkanriLst);
                        errorKns = errorKns + 1;
                        continue;
                    }
                    tndmatuzndkksnjkwsratengt = tndmatuzndkksnjkwsrate;
                }
                else {
                    tndmatuzndkksnjkwsratengt = BizNumber.valueOf(0);
                }

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                BizDate ryosyutykzenoutouymd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, kykSyouhn.getKykymd(),
                    C_Hrkkaisuu.NEN, tokuteijitenZennou.getRyosyuymd());

                List<BM_ZennouRiritu2> zennouRirituLst2 = khKessanZennouSelDao.getZennouRiritu2(calctuukaSyu,
                    ryosyutykzenoutouymd);

                if (zennouRirituLst2.size() == 0) {

                    handleError("前納利率マスタ取得エラー", kykKihon, ansyuKihon, khBikinkanriLst, siBikinkanriLst);
                    errorKns = errorKns + 1;
                    continue;
                }
                zennouriritu = zennouRirituLst2.get(0).getZennouriritu();

                KeisanZennouSeisanGk2 keisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);

                C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(kessanYmd, kykSyouhn.getKykymd(),
                    tokuteijitenZennou.getZennoujihrkp(), tokuteijitenZennou.getZennoukaisiymd(),
                    tokuteijitenZennou.getRyosyuymd(), tokuteijitenZennou.getZennounyuukinkgk());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    handleError("前納精算額計算エラー", kykKihon, ansyuKihon, khBikinkanriLst, siBikinkanriLst);
                    errorKns = errorKns + 1;
                    continue;
                }

                BizCurrency tndmatuzndk = keisanZennouSeisanGk2.getZennouSeisanGk();

                if (BizUtil.isZero(tndmatuzndk)) {

                    for (IT_KhBikinkanri khBikinkanri : khBikinkanriLst) {

                        khBikinkanri.detach();
                    }

                    for (JT_SiBikinkanri siBikinkanri : siBikinkanriLst) {

                        siBikinkanri.detach();
                    }

                    kykKihon.detach();

                    ansyuKihon.detach();

                    continue;
                }

                List<BizDate> zennoutumitaterituhenkoymdLst = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();

                String tndzndkhikakukbn = keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn();

                BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
                SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(kykSyouhn.getSyouhncd(),
                    kykSyouhn.getKyktuukasyu());

                if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {
                    handleError(
                        "セグメントコード取得エラー　商品コード：" + kykSyouhn.getSyouhncd() + "　通貨種類："
                            + kykSyouhn.getKyktuukasyu().toString(),
                            kykKihon, ansyuKihon, khBikinkanriLst, siBikinkanriLst);
                    errorKns = errorKns + 1;
                    continue;
                }
                C_ZennouToukeiListKbn zennouToukeiListKbn = C_ZennouToukeiListKbn.ZENNOU_MKKP;

                BizDateY zennoumanryouNendo = setKessanNensibi
                    .exec(tokuteijitenZennou.getAnnaisaikaiym().getFirstDay()).getBizDateY();

                if (zennoumanryouNendo.compareTo(syoriNendo) == 0) {

                    zennouToukeiListKbn = C_ZennouToukeiListKbn.MANRYOUBUN_MKKP;
                }

                errorKbn = keisanZennouSeisanGk2.exec(tokuteijitenZennou.getZennoukaisiymd(), kykSyouhn.getKykymd(),
                    tokuteijitenZennou.getZennoujihrkp(), tokuteijitenZennou.getZennoukaisiymd(),
                    tokuteijitenZennou.getRyosyuymd(), tokuteijitenZennou.getZennounyuukinkgk());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    handleError("前納精算額計算エラー", kykKihon, ansyuKihon, khBikinkanriLst, siBikinkanriLst);
                    errorKns = errorKns + 1;
                    continue;
                }

                BizCurrency zennoukaisijizndk = keisanZennouSeisanGk2.getZennouSeisanGk();

                BizDate rthndStartymd = null;
                List<BizCurrency> rthndzndkLst = new ArrayList<>();
                List<BizNumber> tkyrtLst = new ArrayList<>();
                List<BizDate> rthndymdLst = new ArrayList<>();
                BizNumber tndmatutkyrt = BizNumber.ZERO;

                if (BizDateUtil.compareYmd(kessanStartymd, zennouInfoBean.getRyosyuymd()) == BizDateUtil.COMPARE_GREATER
                    || BizDateUtil.compareYmd(kessanStartymd, zennouInfoBean.getRyosyuymd()) == BizDateUtil.COMPARE_EQUAL) {

                    rthndStartymd = kessanStartymd;
                }
                else {

                    rthndStartymd = zennouInfoBean.getRyosyuymd();
                }

                for (int k = 0; k < 4; k++) {
                    rthndzndkLst.add(BizCurrency.valueOf(0, zennou.getZennoujihrkp().getType()));
                    tkyrtLst.add(BizNumber.valueOf(0));
                    rthndymdLst.add(null);
                }
                int rthndkaisu = 0;

                for (int m = 0; m < zennoutumitaterituhenkoymdLst.size(); m++) {

                    if (BizDateUtil.compareYmd(zennoutumitaterituhenkoymdLst.get(m), rthndStartymd) == BizDateUtil.COMPARE_GREATER
                        || BizDateUtil.compareYmd(zennoutumitaterituhenkoymdLst.get(m), rthndStartymd) == BizDateUtil.COMPARE_EQUAL) {

                        keisanZennouSeisanGk2.exec(zennoutumitaterituhenkoymdLst.get(m), kykSyouhn.getKykymd(),
                            tokuteijitenZennou.getZennoujihrkp(), tokuteijitenZennou.getZennoukaisiymd(),
                            tokuteijitenZennou.getRyosyuymd(), tokuteijitenZennou.getZennounyuukinkgk());

                        rthndzndkLst.set(rthndkaisu, keisanZennouSeisanGk2.getZennouSeisanGk());


                        String tkyTmttZndkHikakuKbn = keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn();

                        rthndymdLst.set(rthndkaisu, zennoutumitaterituhenkoymdLst.get(m));

                        if (KeisanZennouSeisanGk2.TKYTMMTTZNDKHIKAKBN_ZNNRIRITUZNDK.equals(tkyTmttZndkHikakuKbn)
                            || KeisanZennouSeisanGk2.TKYTMMTTZNDKHIKAKBN_DOUGAKU.equals(tkyTmttZndkHikakuKbn)) {

                            tkyrtLst.set(rthndkaisu, zennouriritu);
                        }
                        else {
                            BizDate zennoutmttrtgetkijunymd = null;
                            if (rthndkaisu == 0) {
                                zennoutmttrtgetkijunymd = rthndStartymd;
                            }
                            else {
                                zennoutmttrtgetkijunymd = zennoutumitaterituhenkoymdLst.get(m - 1);
                            }
                            List<BM_ZennouTumitateRitu2> zennouTumitateRituLst2 = khKessanZennouSelDao
                                .getTumitateRiritu2(calctuukaSyu, zennoutmttrtgetkijunymd);
                            tkyrtLst.set(rthndkaisu, zennouTumitateRituLst2.get(0).getZennoutumitateritu());
                        }

                        tndmatutkyrt = tkyrtLst.get(rthndkaisu);
                        rthndkaisu = rthndkaisu + 1;

                        if (rthndkaisu >= 4) {
                            break;
                        }
                    }
                }

                if (KeisanZennouSeisanGk2.TKYTMMTTZNDKHIKAKBN_ZNNRIRITUZNDK.equals(tndzndkhikakukbn)
                    || KeisanZennouSeisanGk2.TKYTMMTTZNDKHIKAKBN_DOUGAKU.equals(tndzndkhikakukbn)) {

                    tndmatutkyrt = zennouriritu;
                }
                else {
                    BizDate tndmatutkyrtkijunymd = null;
                    if (rthndkaisu == 0) {
                        tndmatutkyrtkijunymd = rthndStartymd;
                    }
                    else {
                        tndmatutkyrtkijunymd = rthndymdLst.get(rthndkaisu - 1);
                    }
                    List<BM_ZennouTumitateRitu2> zennouTumitateRituLst2 = khKessanZennouSelDao
                        .getTumitateRiritu2(calctuukaSyu,tndmatutkyrtkijunymd);
                    tndmatutkyrt = zennouTumitateRituLst2.get(0).getZennoutumitateritu();
                }

                String bosyuukeitaikbn = "";

                IT_KykDairiten kykDairiten = kykKihon.getKykDairitenByDrtenrenno(1);

                SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

                SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.BOSYU_KEITAI,
                    kykDairiten.getDrtencd());

                if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                    String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                        kykSyouhn.getSyono(), kykDairiten.getDrtencd());
                    handleError(msg, kykKihon, ansyuKihon, khBikinkanriLst, siBikinkanriLst);
                    errorKns = errorKns + 1;
                    continue;
                }

                bosyuukeitaikbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();

                String gkdtznnhyj = "0";
                String znngaikakbn = "0";
                String yenkanyknhyj = "0";
                BizNumber znnnyknjikawaserate = BizNumber.valueOf(0);
                BizDate znnnyknjikawaseratetkyuymd = null;
                BizCurrency zennounyuukinkgkgaika = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
                BizCurrency zennounyuukinkgktkmatu = BizCurrency.valueOf(0);
                BizCurrency zennoukaisijizndktkmatu = BizCurrency.valueOf(0);
                BizCurrency tndmatuzndktkmatu = BizCurrency.valueOf(0);
                List<BizCurrency> rthndzndktkmatuLst = new ArrayList<>();
                for (int k = 0; k < 4; k++) {
                    rthndzndktkmatuLst.add(BizCurrency.valueOf(0));
                }

                SrSuuriKbnHenkanBean SrSuuriKbnHenkanBean2 = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
                    calctuukaSyu.getValue());

                if (C_ErrorKbn.ERROR.eq(SrSuuriKbnHenkanBean2.getKekkaKbn())) {

                    handleError("前納外貨区分変換エラー　通貨種類：" + calctuukaSyu, kykKihon, ansyuKihon, khBikinkanriLst, siBikinkanriLst);
                    errorKns = errorKns + 1;
                    continue;
                }
                znngaikakbn = SrSuuriKbnHenkanBean2.getHenkanAtoKbn();

                ChkZennouKeisanTuuka chkZennouKeisanTuuka = SWAKInjector.getInstance(ChkZennouKeisanTuuka.class);
                if (C_ErrorKbn.ERROR.eq(chkZennouKeisanTuuka.exec(zennouInfoBean.getSyono(), znngaikakbn))) {
                    handleError("前納外貨区分不正", kykKihon, ansyuKihon, khBikinkanriLst, siBikinkanriLst);
                    errorKns = errorKns + 1;
                    continue;
                }

                if (!C_Tuukasyu.JPY.eq(calctuukaSyu)) {
                    gkdtznnhyj = "1";
                    zennounyuukinkgkgaika = tokuteijitenZennou.getZennounyuukinkgk();

                    if (C_Tuukasyu.JPY.eq(tokuteijitenZennou.getRstuukasyu())) {
                        yenkanyknhyj = "1";
                        znnnyknjikawaseratetkyuymd = tokuteijitenZennou.getRyosyukwsratekjymd();
                        znnnyknjikawaserate = tokuteijitenZennou.getRyosyukwsrate();
                    } 
                    else {
                        if (tokuteijitenZennou.getTyakkinymd().isHoliday()) {
                            znnnyknjikawaseratetkyuymd = tokuteijitenZennou.getTyakkinymd().getBusinessDay(
                                CHolidayAdjustingMode.NEXT);
                        }
                        else {
                            znnnyknjikawaseratetkyuymd = tokuteijitenZennou.getTyakkinymd();
                        }

                        getKawaseRate.exec(znnnyknjikawaseratetkyuymd, C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                            C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE,
                            C_EigyoubiHoseiKbn.BLNK, C_YouhiKbn.HUYOU);

                        znnnyknjikawaserate =getKawaseRate.getKawaserate();
                    }

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    zennounyuukinkgktkmatu = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                        tokuteijitenZennou.getZennounyuukinkgk(), tndmatuzndkksnjkwsrate, C_HasuusyoriKbn.SSYGNY);

                    zennoukaisijizndktkmatu = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                        zennoukaisijizndk, tndmatuzndkksnjkwsrate, C_HasuusyoriKbn.SSYGNY);

                    for (int k = 0; k < 4; k++) {
                        rthndzndktkmatuLst.set(k, keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            rthndzndkLst.get(k), tndmatuzndkksnjkwsrate, C_HasuusyoriKbn.SSYGNY));
                    }

                    tndmatuzndktkmatu = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                        tndmatuzndk, tndmatuzndkksnjkwsrate, C_HasuusyoriKbn.SSYGNY);
                }
                IT_ZennouKessan zennouKessan = new IT_ZennouKessan(kykKihon.getSyono(),
                    syoriYmd, syouhinbetuSegmentBean.getSegcd1(), C_ZennouKbn.IPPAN_ZENNOU,
                    zennouToukeiListKbn, tokuteijitenZennou.getZennoukaisiymd().getBizDateYM());

                zennouKessan.setZennoukaisiymd(tokuteijitenZennou.getZennoukaisiymd());
                zennouKessan.setZennoukaisijizndk(zennoukaisijizndk);
                zennouKessan.setKeiyakuymd(kykSyouhn.getKykymd());
                zennouKessan.setZennouwrbkrt(zennouriritu);
                zennouKessan.setRthndzndk1(rthndzndkLst.get(0));
                zennouKessan.setTkyrt1(tkyrtLst.get(0));
                zennouKessan.setRthndymd1(rthndymdLst.get(0));
                zennouKessan.setRthndzndk2(rthndzndkLst.get(1));
                zennouKessan.setTkyrt2(tkyrtLst.get(1));
                zennouKessan.setRthndymd2(rthndymdLst.get(1));
                zennouKessan.setRthndzndk3(rthndzndkLst.get(2));
                zennouKessan.setTkyrt3(tkyrtLst.get(2));
                zennouKessan.setRthndymd3(rthndymdLst.get(2));
                zennouKessan.setRthndzndk4(rthndzndkLst.get(3));
                zennouKessan.setTkyrt4(tkyrtLst.get(3));
                zennouKessan.setRthndymd4(rthndymdLst.get(3));
                zennouKessan.setTndmatuzndk(tndmatuzndk);
                zennouKessan.setTndmatutkyrt(tndmatutkyrt);
                zennouKessan.setZennounyuukinymd(tokuteijitenZennou.getRyosyuymd());
                zennouKessan.setTndzndkhikakukbn(tndzndkhikakukbn);
                zennouKessan.setZennoukikan(tokuteijitenZennou.getZennoukikan());
                zennouKessan.setBosyuukeitaikbn(bosyuukeitaikbn);
                zennouKessan.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                zennouKessan.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                zennouKessan.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                zennouKessan.setGkdtznnhyj(gkdtznnhyj);
                zennouKessan.setZnngaikakbn(znngaikakbn);
                zennouKessan.setYenkanyknhyj(yenkanyknhyj);
                zennouKessan.setZnnnyknjikawaserate(znnnyknjikawaserate);
                zennouKessan.setZnnnyknjikawaseratetkyuymd(znnnyknjikawaseratetkyuymd);
                zennouKessan.setKsnkisikawaserate(ksnkisikawaseratengt);
                zennouKessan.setTndmatuzndkksnjkwsrate(tndmatuzndkksnjkwsratengt);
                zennouKessan.setZennounyuukinkgkgaika(zennounyuukinkgkgaika);
                zennouKessan.setZennounyuukinkgktkmatu(zennounyuukinkgktkmatu);
                zennouKessan.setZennoukaisijizndktkmatu(zennoukaisijizndktkmatu);
                zennouKessan.setRthndzndk1tkmatu(rthndzndktkmatuLst.get(0));
                zennouKessan.setRthndzndk2tkmatu(rthndzndktkmatuLst.get(1));
                zennouKessan.setRthndzndk3tkmatu(rthndzndktkmatuLst.get(2));
                zennouKessan.setRthndzndk4tkmatu(rthndzndktkmatuLst.get(3));
                zennouKessan.setTndmatuzndktkmatu(tndmatuzndktkmatu);

                BizPropertyInitializer.initialize(zennouKessan);

                zennouKessanInserter.add(zennouKessan);

                syoriKns = syoriKns + 1;

                for (IT_KhBikinkanri khBikinkanri : khBikinkanriLst) {

                    khBikinkanri.detach();
                }

                for (JT_SiBikinkanri siBikinkanri : siBikinkanriLst) {

                    siBikinkanri.detach();
                }

                kykKihon.detach();

                ansyuKihon.detach();
            }
        }

        if (errorKns != 0 && RDPMX000.equals(kakutyoujobCd)) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(errorKns), "エラー件数"));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKns), "正常登録件数"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(errorKns), "エラー件数"));
    }

    private void handleError(String pErroMsg, IT_KykKihon pKykKihon, IT_AnsyuKihon pAnsyuKihon,
        List<IT_KhBikinkanri> pKhBikinkanriLst, List<JT_SiBikinkanri> pSiBikinkanriLst) {
        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

        suuriyouErrJyouhou.setSyoriYmd(batchParam.getSyoriYmd());
        suuriyouErrJyouhou.setKakutyoujobcd(batchParam.getIbKakutyoujobcd());
        suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(pErroMsg);

        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

        pKykKihon.detach();

        if (pAnsyuKihon != null) {
            pAnsyuKihon.detach();
        }

        if (pKhBikinkanriLst != null) {
            for (IT_KhBikinkanri khBikinkanri : pKhBikinkanriLst) {
                khBikinkanri.detach();
            }
        }

        if (pSiBikinkanriLst != null) {
            for (JT_SiBikinkanri siBikinkanri : pSiBikinkanriLst) {

                siBikinkanri.detach();
            }
        }
    }
}
