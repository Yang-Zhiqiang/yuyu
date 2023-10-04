package yuyu.batch.hozen.khinterf.khtesuryoinfosks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khtesuryoinfosks.dba.KhTesuryoInfoSksDao;
import yuyu.batch.hozen.khinterf.khtesuryoinfosks.dba.TesuuryouInfosByKakutyoujobcditemsExBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Tesuuryou;
import yuyu.def.db.entity.IT_TesuuryouSyouhn;
import yuyu.def.db.entity.IT_TesuuryouSyouhnRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.ZT_DrtenTsryInfoTy;
import yuyu.def.hozen.detacher.IT_AnsyuKihonDetacher;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_NyknJissekiRireki;
import yuyu.def.hozen.sorter.SortIT_Zennou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス （契約ＭＦヒストリーＦ）手数料情報作成クラス
 */
public class KhTesuryoInfoSksBatch implements Batch {

    private static final String IB_RECOVERY_FILTER_ID = "Kh001";

    private static final String TABLE_ID = "IT_KykKihon";

    private static final String SSKNMTIHRKKISUKBN_TUKI = "3";
    private static final String SSKNMTIHRKKISUKBN_NEN = "4";
    private static final String SSKNMTIHRKKISUKBN_HALFY = "5";
    private static final String SSKNMTIHRKKISUKBN_SONOTA = "0";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KhTesuryoInfoSksDao khTesuryoInfoSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDateYM boshuYm = bzBatchParam.getSyoriYmd().addMonths(-61).getRekijyou().getBizDateYM();
        long syoriKensuu = 0;

        try (ExDBResults<TesuuryouInfosByKakutyoujobcditemsExBean> tsryInfoBeanList =
            khTesuryoInfoSksDao.getTesuuryouInfosByKakutyoujobcditems(
                bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd(), boshuYm, C_SyutkKbn.SYU);
            EntityInserter<ZT_DrtenTsryInfoTy> drtenTsryInfoTyInserter = new EntityInserter<>()) {
            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

            for (TesuuryouInfosByKakutyoujobcditemsExBean tsryInfoBean : tsryInfoBeanList) {

                IT_Tesuuryou tesuuryou = tsryInfoBean.getIT_Tesuuryou();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(IB_RECOVERY_FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(tesuuryou.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(tesuuryou.getSyono());

                IT_TesuuryouSyouhn tesuuryouSyouhn = tsryInfoBean.getIT_TesuuryouSyouhn();

                if (C_TsrysyoriKbn.SIKKOU.eq(tesuuryou.getTsrysyorikbn())) {

                    if (!C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM.eq(tesuuryouSyouhn.getSyoumetujiyuu())
                        && !C_Syoumetujiyuu.PMNYSYMET_MSSN.eq(tesuuryouSyouhn.getSyoumetujiyuu())) {

                        continue;
                    }
                }

                BM_SyouhnZokusei syouhnZokusei =
                    bizDomManager.getSyouhnZokusei(tesuuryouSyouhn.getSyouhncd(), tesuuryouSyouhn.getSyouhnsdno());
                if (syouhnZokusei == null) {
                    throw new BizAppException(MessageId.EBS0005, BM_SyouhnZokusei.TABLE_NAME,
                        BM_SyouhnZokusei.SYOUHNCD, tesuuryouSyouhn.getSyouhncd(), BM_SyouhnZokusei.SYOUHNSDNO,
                        String.valueOf(tesuuryouSyouhn.getSyouhnsdno()));
                }

                IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki = null;

                IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon(tesuuryouSyouhn.getSyono());
                kykKihon2 = IT_KykKihonDetacher.detachTesuuryouSyouhnRirekitouched(kykKihon2);

                List<IT_Tesuuryou> tesuuryouList = kykKihon2.getTesuuryousByTsrysyorikbnRenno(
                    tesuuryouSyouhn.getTsrysyorikbn(),
                    tesuuryouSyouhn.getRenno());

                if (tesuuryouList.size() > 0) {
                    List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiList = tesuuryouList.get(0)
                        .getTesuuryouSyouhnRirekisBySyutkkbn(C_SyutkKbn.SYU);

                    if (tesuuryouSyouhnRirekiList.size() > 0) {
                        tesuuryouSyouhnRireki = tesuuryouSyouhnRirekiList.get(0);
                    }
                }

                IT_KykKihon kykKihonforNkjisseki = hozenDomManager.getKykKihon(tesuuryou.getSyono());
                kykKihonforNkjisseki = IT_KykKihonDetacher.detachNyknJissekiRirekitouched(kykKihonforNkjisseki);

                List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihonforNkjisseki.getNyknJissekiRirekis();

                SortIT_NyknJissekiRireki sortIT_NyknJissekiRireki = SWAKInjector.getInstance(SortIT_NyknJissekiRireki.class);
                nyknJissekiRirekiLst = sortIT_NyknJissekiRireki.OrderIT_NyknJissekiRirekiByPkDesc(nyknJissekiRirekiLst);
                IT_NyknJissekiRireki nyknJissekiRireki = nyknJissekiRirekiLst.get(0);

                IT_Zennou itzennou = null;
                if (C_Kykjyoutai.ZENNOU.eq(tesuuryouSyouhn.getKykjyoutai())) {

                    IT_AnsyuKihon itansyuKihon = hozenDomManager.getAnsyuKihon(tesuuryouSyouhn.getSyono());
                    itansyuKihon = IT_AnsyuKihonDetacher.detachZennoustouched(itansyuKihon);

                    List<IT_Zennou> itzennouLst = itansyuKihon.getZennous();

                    if (itzennouLst.size() == 0) {
                        throw new CommonBizAppException(
                            MessageUtil.getMessage(MessageId.EIA1048,
                                IT_Zennou.TABLE_NAME,
                                tesuuryouSyouhn.getSyono()));
                    }

                    SortIT_Zennou sortIT_Zennou = SWAKInjector.getInstance(SortIT_Zennou.class);
                    itzennouLst = sortIT_Zennou.OrderIT_ZennouByPkDesc(itzennouLst);
                    itzennou = itzennouLst.get(0);
                }

                IT_KykDairiten kykDairiten = tsryInfoBean.getIT_KykDairiten();
                String kydatkiBosyuuCd = "000000";
                String drtenAtkikeitaiKbn = "1";
                BizNumber atkiwari = BizNumber.valueOf(1.00);
                long drtenAtkininsuu = 1;
                double drtenTsratkiwari = 0;
                IT_KykDairiten kykDairitenKb = null;

                if (C_UmuKbn.ARI.eq(kykDairiten.getDrtenbunumu())) {

                    IT_KykKihon kykKihon = hozenDomManager.getKykKihon(tesuuryou.getSyono());

                    kykKihon = IT_KykKihonDetacher.detachKykDairitentouched(kykKihon);

                    kykDairitenKb = kykKihon.getKykDairitenByDrtenrenno(2);

                    if (kykDairitenKb == null) {
                        throw new BizAppException(MessageId.EIA1048, IT_KykDairiten.TABLE_NAME, tesuuryou.getSyono()
                            + "　代理店連番：2");
                    }

                    kydatkiBosyuuCd = kykDairitenKb.getBosyuucd();
                    drtenAtkikeitaiKbn = "3";
                    drtenTsratkiwari = new BigDecimal(kykDairiten.getBunwari().toString()).doubleValue();

                    if (kykDairiten.getDrtencd().equals(kykDairitenKb.getDrtencd())) {
                        atkiwari = BizNumber.valueOf(1.00);
                        drtenAtkininsuu = 2;
                    }
                    else {
                        atkiwari = BizNumber.valueOf(0.50);
                        drtenAtkininsuu = 1;
                    }
                }

                int syohinHanteiKeika = SyouhinUtil.hantei(tesuuryouSyouhn.getSyouhncd());

                String hrkkaisuuKbn = "";

                if (C_TsrysyoriKbn.HRIKAIHEN.eq(tesuuryou.getTsrysyorikbn())) {
                    List<IT_KhHenkouRireki> khHenkouRirekiLst =
                        khTesuryoInfoSksDao.getKhHenkouRirekisBySyonoHenkousikibetukeyGyoumuKousinKinouTableidHenkoukoumokuid(
                            tesuuryouSyouhn.getSyono(),
                            tesuuryouSyouhn.getHenkousikibetukey(),
                            IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU,
                            IT_KykKihon.TABLE_NAME,
                            IT_KykKihon.HRKKAISUU);

                    if (khHenkouRirekiLst.size() > 0) {
                        hrkkaisuuKbn = khHenkouRirekiLst.get(0).getBfrnaiyouoriginal();
                    }
                    else {
                        hrkkaisuuKbn = tesuuryou.getHrkkaisuu().getValue();
                    }
                }
                else {
                    hrkkaisuuKbn = tesuuryou.getHrkkaisuu().getValue();
                }

                KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(hrkkaisuuKbn,
                    C_Hrkkaisuu.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                if (kbnInfoBean.isHenkanFlg()) {
                    hrkkaisuuKbn = kbnInfoBean.getKbnData();
                }
                else {
                    throw new BizAppException(MessageId.EIA1046, IT_Tesuuryou.HRKKAISUU, hrkkaisuuKbn);
                }

                IT_KykKihon kykKihon = tsryInfoBean.getIT_KykKihon();
                String skeihyj = "0";
                String seirituYmd = "00000000";
                String sekininkaisiYmd = "00000000";
                String uktkId = "";
                String shzirtstkjynYmd = "00000000";
                String tyouseiJiyuu = "";
                BizNumber syouhizeiritu = BizNumber.ZERO;
                String tuukaCd = "";
                BizNumber tousyoKykjiKawaserate = BizNumber.ZERO;
                long hokenRyou = 0;
                String bankBoskykKbn = "0";
                String nyuukinTukisuu = "000";

                if (C_TsrysyoriKbn.SINKEIYAKUSEIRITU.eq(tesuuryou.getTsrysyorikbn())) {
                    skeihyj = "1";

                    if (kykKihon.getSeirituymd() != null) {
                        seirituYmd = kykKihon.getSeirituymd().toString();
                    }
                    if (tesuuryouSyouhn.getSknnkaisiymd() != null) {
                        sekininkaisiYmd = tesuuryouSyouhn.getSknnkaisiymd().toString();
                    }
                    uktkId = kykKihon.getSmbckanriid();
                    tyouseiJiyuu = "000";
                    bankBoskykKbn = "1";

                    if (C_Kykjyoutai.ITIJIBARAI.eq(tesuuryouSyouhn.getKykjyoutai())) {
                        if (!C_Tuukasyu.JPY.eq(tesuuryouSyouhn.getKyktuukasyu())) {
                            C_ErrorKbn tskjkRateErrorKbn = getKawaseRate.exec(
                                kykKihon.getFstpnyknymd(),
                                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                                tesuuryouSyouhn.getKyktuukasyu(),
                                C_Tuukasyu.JPY,
                                C_KawasetekiyoKbn.TTB,
                                C_KawasetsryKbn.JISSEIRATE,
                                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                                C_YouhiKbn.HUYOU);
                            if (C_ErrorKbn.OK.eq(tskjkRateErrorKbn)) {
                                tousyoKykjiKawaserate = getKawaseRate.getKawaserate().divide(1, 2, RoundingMode.DOWN);
                            }
                            else {
                                throw new BizAppException(MessageId.EIA1047,
                                    String.valueOf(kykKihon.getFstpnyknymd()),
                                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                                    tesuuryouSyouhn.getKyktuukasyu().getValue(), C_Tuukasyu.JPY.getValue(),
                                    C_KawasetekiyoKbn.TTB.getValue(), C_KawasetsryKbn.JISSEIRATE.getValue(),
                                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(), C_YouhiKbn.HUYOU.getValue());
                            }
                        }
                    }
                }

                BizDate denYmd;
                if (C_TsrysyoriKbn.KEIZOKUPNYUUKIN.eq(tesuuryou.getTsrysyorikbn())
                    || C_TsrysyoriKbn.IKKATUNYUUKIN.eq(tesuuryou.getTsrysyorikbn())
                    || C_TsrysyoriKbn.SYOUMETUGOKZPNYUUKIN.eq(tesuuryou.getTsrysyorikbn())
                    || C_TsrysyoriKbn.HRIKAIHEN.eq(tesuuryou.getTsrysyorikbn())) {
                    denYmd = tesuuryou.getNyknymd();
                }
                else {
                    denYmd = bzBatchParam.getSyoriYmd();
                }

                if (C_TsrysyoriKbn.SEINENGAPPISEI.eq(tesuuryou.getTsrysyorikbn())) {
                    tyouseiJiyuu = "110";
                }
                else if (C_TsrysyoriKbn.GENGAKU.eq(tesuuryou.getTsrysyorikbn())) {
                    tyouseiJiyuu = "200";
                }
                else if (C_TsrysyoriKbn.KEIYAKUTORIKESI.eq(tesuuryou.getTsrysyorikbn()) ||
                    C_TsrysyoriKbn.CLGOFF.eq(tesuuryou.getTsrysyorikbn()) ||
                    C_TsrysyoriKbn.KAIJO.eq(tesuuryou.getTsrysyorikbn()) ||
                    C_TsrysyoriKbn.MUKOU.eq(tesuuryou.getTsrysyorikbn())) {
                    tyouseiJiyuu = "401";
                }
                else if (C_TsrysyoriKbn.KAIYAKU.eq(tesuuryou.getTsrysyorikbn())) {
                    tyouseiJiyuu = "481";
                }
                else if (C_TsrysyoriKbn.KEIZOKUPNYUUKIN.eq(tesuuryou.getTsrysyorikbn()) ||
                    C_TsrysyoriKbn.IKKATUNYUUKIN.eq(tesuuryou.getTsrysyorikbn()) ||
                    C_TsrysyoriKbn.SYOUMETUGOKZPNYUUKIN.eq(tesuuryou.getTsrysyorikbn()) ||
                    C_TsrysyoriKbn.HRIKAIHEN.eq(tesuuryou.getTsrysyorikbn())) {
                    tyouseiJiyuu = "000";
                }
                else if (C_TsrysyoriKbn.NYUUKINTORIKESI.eq(tesuuryou.getTsrysyorikbn())) {
                    tyouseiJiyuu = "001";
                }
                else if (C_TsrysyoriKbn.SIBOU.eq(tesuuryou.getTsrysyorikbn())) {
                    tyouseiJiyuu = "700";
                }

                C_UmuKbn mikeikapHenkanUmu = C_UmuKbn.NONE;

                if (C_TsrysyoriKbn.KAIYAKU.eq(tesuuryou.getTsrysyorikbn()) ||
                    C_TsrysyoriKbn.GENGAKU.eq(tesuuryou.getTsrysyorikbn())) {
                    if (C_UmuKbn.ARI.eq(tesuuryou.getMikeikapariflg())) {
                        tyouseiJiyuu = "700";
                        mikeikapHenkanUmu = C_UmuKbn.ARI;
                    }
                }

                if (C_TsrysyoriKbn.SIKKOU.eq(tesuuryou.getTsrysyorikbn())) {
                    tyouseiJiyuu = "471";
                }

                if (C_TsrysyoriKbn.SINKEIYAKUSEIRITU.eq(tesuuryou.getTsrysyorikbn())) {
                    if (tesuuryouSyouhn.getSknnkaisiymd() != null) {
                        shzirtstkjynYmd = tesuuryouSyouhn.getSknnkaisiymd().toString();
                    }

                    if (BizDateUtil.compareYmd(tesuuryouSyouhn.getSknnkaisiymd(),
                        YuyuBizConfig.getInstance().getTekiyouKaisiYmd()) < 0) {
                        syouhizeiritu = YuyuBizConfig.getInstance().getSyouhizeiritu();
                    }
                    else {
                        syouhizeiritu = YuyuBizConfig.getInstance().getSinsyouhizeiritu();
                    }
                }
                else {
                    if ("000".equals(tyouseiJiyuu)) {
                        if (tesuuryou.getNyknymd() != null) {
                            shzirtstkjynYmd = tesuuryou.getNyknymd().toString();

                            if (BizDateUtil.compareYmd(tesuuryou.getNyknymd(),
                                YuyuBizConfig.getInstance().getTekiyouKaisiYmd()) < 0) {
                                syouhizeiritu = YuyuBizConfig.getInstance().getSyouhizeiritu();
                            }
                            else {
                                syouhizeiritu = YuyuBizConfig.getInstance().getSinsyouhizeiritu();
                            }
                        }
                        else {
                            shzirtstkjynYmd = "00000000";
                            syouhizeiritu = BizNumber.ZERO;
                        }

                    }
                    else {
                        shzirtstkjynYmd = "00000000";
                        syouhizeiritu = BizNumber.ZERO;
                    }
                }

                if (C_Kykjyoutai.ITIJIBARAI.eq(tesuuryouSyouhn.getKykjyoutai())) {
                    if ("000".equals(tyouseiJiyuu)) {
                        nyuukinTukisuu = "012";
                    }
                    else {
                        nyuukinTukisuu = "000";
                    }
                }
                else {
                    if ("000".equals(tyouseiJiyuu)  || "001".equals(tyouseiJiyuu) || "700".equals(tyouseiJiyuu)) {
                        nyuukinTukisuu = BizUtil.num(String.valueOf((tesuuryou.getNyknkaisuuy() * 12) + tesuuryou.getNyknkaisuum()), BizUtil.ZERO_FILL, 3);
                    }
                    else {
                        nyuukinTukisuu = "000";
                    }
                }

                String sikibetujyunjyo = "1";

                BizCurrency tsrkeisansyukykhsyos = BizCurrency.valueOf(0);
                if (C_TsrysyoriKbn.GENGAKU.eq(tesuuryou.getTsrysyorikbn())) {
                    if (C_UmuKbn.ARI.eq(tesuuryou.getMikeikapariflg())) {
                        tsrkeisansyukykhsyos = tesuuryouSyouhnRireki.getKihons();
                    }
                    else {
                        tsrkeisansyukykhsyos = tesuuryouSyouhn.getKihons();
                    }
                }
                else {
                    tsrkeisansyukykhsyos = tesuuryouSyouhn.getKihons();
                }

                String annaiFuyouRiyuuKbn = "";

                if (C_Kykjyoutai.ITIJIBARAI.eq(tesuuryouSyouhn.getKykjyoutai())) {
                    annaiFuyouRiyuuKbn = "01";
                }
                else if (C_Kykjyoutai.ZENNOU.eq(tesuuryouSyouhn.getKykjyoutai())) {
                    annaiFuyouRiyuuKbn = "07";
                }
                else {
                    annaiFuyouRiyuuKbn = "00";
                }

                String hknkikan = "";

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getSyuusinhknumu())) {
                    hknkikan = "99";
                }
                else if (C_HknkknsmnKbn.NENMANKI.eq(tesuuryouSyouhn.getHknkknsmnkbn())) {
                    hknkikan = String.valueOf(tesuuryouSyouhn.getHknkkn());
                }
                else if (C_HknkknsmnKbn.SAIMANKI.eq(tesuuryouSyouhn.getHknkknsmnkbn())) {
                    hknkikan = String.valueOf(tesuuryouSyouhn.getHknkkn() - tesuuryouSyouhn.getHhknnen());
                }

                String coolingofhyj = "";
                if (C_TsrysyoriKbn.CLGOFF.eq(tesuuryou.getTsrysyorikbn())) {
                    coolingofhyj = "1";
                }
                else {
                    coolingofhyj = "0";
                }

                String saimnkkykhyj = "";
                if (C_HknkknsmnKbn.SAIMANKI.eq(tesuuryouSyouhn.getHknkknsmnkbn())) {
                    saimnkkykhyj = "1";
                }
                else {
                    saimnkkykhyj = "0";
                }

                if (C_Tuukasyu.USD.eq(tesuuryouSyouhn.getKyktuukasyu())) {
                    tuukaCd = "001";
                }
                else if (C_Tuukasyu.AUD.eq(tesuuryouSyouhn.getKyktuukasyu())) {
                    tuukaCd = "002";
                }

                String phrkkikn = BizUtil.num(String.valueOf(tesuuryouSyouhn.getHrkkkn()), BizUtil.ZERO_FILL, 2);

                if (C_Kykjyoutai.ITIJIBARAI.eq(tesuuryouSyouhn.getKykjyoutai())) {
                    if (C_TsrysyoriKbn.SINKEIYAKUSEIRITU.eq(tesuuryou.getTsrysyorikbn())) {
                        hokenRyou = Long.parseLong(nyknJissekiRireki.getRsgaku().toAdsoluteString());
                    }
                    else {
                        hokenRyou = 0;
                    }
                }
                else {
                    if (syohinHanteiKeika == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
                        (syohinHanteiKeika == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
                        C_Tuukasyu.JPY.eq(tesuuryouSyouhn.getKyktuukasyu()))) {
                        hokenRyou = Long.parseLong(tesuuryouSyouhn.getHokenryou().toAdsoluteString());

                        if (C_TsrysyoriKbn.HRIKAIHEN.eq(tesuuryou.getTsrysyorikbn())) {
                            hokenRyou = Long.parseLong(tesuuryouSyouhnRireki.getHokenryou().toAdsoluteString());
                        }

                        if ("700".equals(tyouseiJiyuu)) {
                            if ("3".equals(hrkkaisuuKbn)) {
                                if (C_TsrysyoriKbn.GENGAKU.eq(tesuuryou.getTsrysyorikbn())) {
                                    hokenRyou = Long.parseLong(tesuuryouSyouhnRireki.getHokenryou().subtract(
                                        tesuuryouSyouhn.getHokenryou()).toAdsoluteString());
                                }
                            }

                            if ("1".equals(hrkkaisuuKbn) || "2".equals(hrkkaisuuKbn)) {
                                hokenRyou = Long.parseLong(tesuuryou.getMikeikap().toAdsoluteString());
                            }
                        }
                    }
                }

                long bfrsyup = 0;
                if (C_Kykjyoutai.ITIJIBARAI.eq(tesuuryouSyouhn.getKykjyoutai())) {
                    bfrsyup = 0;
                }
                else {
                    if (syohinHanteiKeika == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
                        (syohinHanteiKeika == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
                        C_Tuukasyu.JPY.eq(tesuuryouSyouhn.getKyktuukasyu()))) {
                        if ("200".equals(tyouseiJiyuu) ||"110".equals(tyouseiJiyuu)) {
                            bfrsyup = Long.parseLong(tesuuryouSyouhnRireki.getHokenryou().toAdsoluteString());
                        }

                        else if ("700".equals(tyouseiJiyuu)) {
                            if ("1".equals(hrkkaisuuKbn) || "2".equals(hrkkaisuuKbn)) {
                                if (C_TsrysyoriKbn.GENGAKU.eq(tesuuryou.getTsrysyorikbn())) {
                                    bfrsyup = Long.parseLong(tesuuryouSyouhnRireki.getHokenryou().subtract(
                                        tesuuryouSyouhn.getHokenryou()).toAdsoluteString());
                                }
                                else {
                                    bfrsyup = Long.parseLong(tesuuryouSyouhn.getHokenryou().toAdsoluteString());
                                }
                            }
                            else {
                                bfrsyup = 0;
                            }
                        }
                        else {
                            bfrsyup = 0;
                        }
                    }
                }

                String pjytoYm = "";
                if (C_Kykjyoutai.ITIJIBARAI.eq(tesuuryouSyouhn.getKykjyoutai())) {
                    if (C_TsrysyoriKbn.SINKEIYAKUSEIRITU.eq(tesuuryou.getTsrysyorikbn())) {
                        if (tesuuryouSyouhn.getKykymd() != null) {
                            pjytoYm = String.valueOf(tesuuryouSyouhn.getKykymd().getBizDateYM());
                        }
                    }
                    else {
                        pjytoYm = "000000";
                    }
                }
                else {
                    if ("000".equals(tyouseiJiyuu)) {
                        pjytoYm = String.valueOf(tesuuryou.getKouryokuhasseiym());
                    }
                    else {
                        pjytoYm = "000000";
                    }
                }

                String sskhntihrkkisukbn = "";
                if ("0".equals(hrkkaisuuKbn)) {
                    sskhntihrkkisukbn = SSKNMTIHRKKISUKBN_SONOTA;
                }
                else if ("1".equals(hrkkaisuuKbn)) {
                    sskhntihrkkisukbn = SSKNMTIHRKKISUKBN_NEN;
                }
                else if ("2".equals(hrkkaisuuKbn)) {
                    sskhntihrkkisukbn = SSKNMTIHRKKISUKBN_HALFY;
                }
                else {
                    sskhntihrkkisukbn = SSKNMTIHRKKISUKBN_TUKI;
                }

                String phenkanarihyj = "0";

                String ktbriKbn = "";

                if (C_TsrysyoriKbn.HRIKAIHEN.eq(tesuuryou.getTsrysyorikbn())) {
                    ktbriKbn = "0";
                }
                else {
                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tesuuryou.getTikiktbrisyuruikbn()) ||
                        C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tesuuryou.getTikiktbrisyuruikbn())) {
                        ktbriKbn = "2";
                    }
                    else {
                        ktbriKbn = "0";
                    }
                }

                String ktbriKaisuu = "";

                if (C_TsrysyoriKbn.HRIKAIHEN.eq(tesuuryou.getTsrysyorikbn())) {
                    ktbriKaisuu = "00";
                }
                else {
                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tesuuryou.getTikiktbrisyuruikbn())) {
                        ktbriKaisuu = "06";
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tesuuryou.getTikiktbrisyuruikbn())) {
                        ktbriKaisuu = "12";
                    }
                    else {
                        ktbriKaisuu = "00";
                    }
                }

                long phenkanbfrsyup = 0;

                if ("700".equals(tyouseiJiyuu)) {
                    if (tesuuryouSyouhnRireki != null) {
                        phenkanbfrsyup = Long.parseLong(tesuuryouSyouhnRireki.getHokenryou().toAdsoluteString());
                    }
                    else {
                        phenkanbfrsyup = Long.parseLong(tesuuryouSyouhn.getHokenryou().toAdsoluteString());
                    }
                }

                BizNumber tkykwsrate = BizNumber.valueOf(0);
                BizNumber tkykwsratesyorijiten = BizNumber.valueOf(0);
                IT_KykSonotaTkyk kykSonotaTkyk = tsryInfoBean.getKykSonotaTkyk();

                if (C_Kykjyoutai.ITIJIBARAI.eq(tesuuryouSyouhn.getKykjyoutai())) {
                    if (!C_Tuukasyu.JPY.eq(tesuuryouSyouhn.getKyktuukasyu())) {
                        boolean getRateFlg = true;
                        C_Tuukasyu mototuuka = null;
                        C_EigyoubiHoseiKbn eigyobihoseiyouhi = null;

                        if (C_TsrysyoriKbn.SINKEIYAKUSEIRITU.eq(tesuuryou.getTsrysyorikbn())) {
                            if (!C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {
                                mototuuka = nyknJissekiRireki.getRstuukasyu();
                                eigyobihoseiyouhi = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                            }
                            else {
                                getRateFlg = false;
                            }
                        }
                        else {
                            mototuuka = tesuuryouSyouhn.getKyktuukasyu();
                            eigyobihoseiyouhi = C_EigyoubiHoseiKbn.BLNK;
                        }

                        if (getRateFlg) {
                            C_ErrorKbn errorKbn = getKawaseRate.exec(
                                tesuuryou.getYenkansantkykwsrateymd(),
                                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                                mototuuka,
                                C_Tuukasyu.JPY,
                                C_KawasetekiyoKbn.TTB,
                                C_KawasetsryKbn.JISSEIRATE,
                                eigyobihoseiyouhi,
                                C_YouhiKbn.HUYOU);

                            if (C_ErrorKbn.OK.eq(errorKbn)) {
                                tkykwsrate = getKawaseRate.getKawaserate().divide(1, 2, RoundingMode.DOWN);
                            }
                            else {
                                throw new BizAppException(MessageId.EIA1047,
                                    String.valueOf(tesuuryou.getYenkansantkykwsrateymd()),
                                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(), mototuuka.getValue(),
                                    C_Tuukasyu.JPY.getValue(),
                                    C_KawasetekiyoKbn.TTB.getValue(), C_KawasetsryKbn.JISSEIRATE.getValue(),
                                    eigyobihoseiyouhi.getValue(), C_YouhiKbn.HUYOU.getValue());
                            }
                        }
                    }
                }
                else {
                    if (syohinHanteiKeika == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        if ("000".equals(tyouseiJiyuu)) {
                            C_Tuukasyu mototuuka = tesuuryouSyouhn.getKyktuukasyu();
                            C_EigyoubiHoseiKbn eigyobihoseiyouhi = null;
                            BizDate kwsrateKjYmd = null;

                            if (C_TsrysyoriKbn.SINKEIYAKUSEIRITU.eq(tesuuryou.getTsrysyorikbn())) {
                                kwsrateKjYmd = nyknJissekiRireki.getRyosyuymd().getPreviousDay();
                                eigyobihoseiyouhi = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
                            }
                            else {
                                if (BizDateUtil.compareYmd(tesuuryou.getKouryokuhasseiym().getPreviousMonth().getLastDay(),
                                    bzBatchParam.getSyoriYmd()) == BizDateUtil.COMPARE_GREATER) {
                                    kwsrateKjYmd = bzBatchParam.getSyoriYmd();
                                }
                                else {
                                    kwsrateKjYmd = tesuuryou.getKouryokuhasseiym().getPreviousMonth().getLastDay();
                                }
                                eigyobihoseiyouhi = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
                            }

                            C_ErrorKbn errorKbn = getKawaseRate.exec(
                                kwsrateKjYmd,
                                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                                mototuuka,
                                C_Tuukasyu.JPY,
                                C_KawasetekiyoKbn.TTM,
                                C_KawasetsryKbn.NYUKINRATE,
                                eigyobihoseiyouhi,
                                C_YouhiKbn.HUYOU);

                            if (C_ErrorKbn.OK.eq(errorKbn)) {
                                tkykwsrate = getKawaseRate.getKawaserate().divide(1, 2, RoundingMode.DOWN);
                            }
                            else {
                                throw new BizAppException(MessageId.EIA1047,
                                    String.valueOf(kwsrateKjYmd),
                                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE.getValue(), mototuuka.getValue(),
                                    C_Tuukasyu.JPY.getValue(),
                                    C_KawasetekiyoKbn.TTM.getValue(), C_KawasetsryKbn.NYUKINRATE.getValue(),
                                    eigyobihoseiyouhi.getValue(), C_YouhiKbn.HUYOU.getValue());
                            }
                        }
                    }

                    if (syohinHanteiKeika == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                        if (C_Tuukasyu.JPY.eq(tesuuryouSyouhn.getKyktuukasyu())) {
                            tkykwsrate = BizNumber.valueOf(0);
                        }
                        else {
                            if ("001".equals(tyouseiJiyuu)) {
                                tkykwsrate = BizNumber.valueOf(0);
                            }
                            else {
                                C_Tuukasyu mototuuka = tesuuryouSyouhn.getKyktuukasyu();
                                C_KawaserateSyuruiKbn kawaseratesyuruikbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
                                BizDate kwsrateKjYmd = null;
                                C_EigyoubiHoseiKbn eigyobihoseiyouhi = null;

                                if ("000".equals(tyouseiJiyuu)) {
                                    if (C_TsrysyoriKbn.SINKEIYAKUSEIRITU.eq(tesuuryou.getTsrysyorikbn())) {
                                        if (itzennou != null) {
                                            kwsrateKjYmd = tesuuryou.getNyknymd();
                                            eigyobihoseiyouhi = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                                        }
                                        else {
                                            kwsrateKjYmd = tesuuryou.getNyknymd().getPreviousDay();
                                            eigyobihoseiyouhi = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
                                        }
                                    }
                                    else {
                                        if (BizDateUtil.compareYmd(tesuuryou.getNyknymd().getBizDateYM().getPreviousMonth().getLastDay(),
                                            bzBatchParam.getSyoriYmd()) == BizDateUtil.COMPARE_GREATER) {
                                            kwsrateKjYmd = bzBatchParam.getSyoriYmd();
                                        }
                                        else {
                                            kwsrateKjYmd = tesuuryou.getNyknymd().getBizDateYM().getPreviousMonth().getLastDay();
                                        }

                                        eigyobihoseiyouhi = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
                                    }
                                }
                                else {
                                    kawaseratesyuruikbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
                                    kwsrateKjYmd = bzBatchParam.getSyoriYmd();
                                    eigyobihoseiyouhi = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
                                }

                                C_ErrorKbn errorKbn = getKawaseRate.exec(
                                    kwsrateKjYmd,
                                    kawaseratesyuruikbn,
                                    mototuuka,
                                    C_Tuukasyu.JPY,
                                    C_KawasetekiyoKbn.TTB,
                                    C_KawasetsryKbn.JISSEIRATE,
                                    eigyobihoseiyouhi,
                                    C_YouhiKbn.HUYOU);

                                if (C_ErrorKbn.OK.eq(errorKbn)) {
                                    tkykwsrate = getKawaseRate.getKawaserate().divide(1, 2, RoundingMode.DOWN);

                                    if ("700".equals(tyouseiJiyuu)) {
                                        if (C_TsrysyoriKbn.KAIYAKU.eq(tesuuryou.getTsrysyorikbn()) ||
                                            C_TsrysyoriKbn.GENGAKU.eq(tesuuryou.getTsrysyorikbn())) {
                                            tkykwsratesyorijiten = tkykwsrate;
                                        }
                                        tkykwsrate = BizNumber.valueOf(0);
                                    }
                                }
                                else {
                                    throw new BizAppException(MessageId.EIA1047,
                                        String.valueOf(kwsrateKjYmd),
                                        kawaseratesyuruikbn.getValue(), mototuuka.getValue(),
                                        C_Tuukasyu.JPY.getValue(),
                                        C_KawasetekiyoKbn.TTB.getValue(), C_KawasetsryKbn.JISSEIRATE.getValue(),
                                        eigyobihoseiyouhi.getValue(), C_YouhiKbn.HUYOU.getValue());
                                }
                            }
                        }
                    }
                }

                long syukeiyakupkyktuuka = 0;
                if (C_Kykjyoutai.ITIJIBARAI.eq(tesuuryouSyouhn.getKykjyoutai())) {
                    syukeiyakupkyktuuka = Long.parseLong(tesuuryouSyouhn.getHokenryou().toAdsoluteString());
                }
                else {
                    if (syohinHanteiKeika == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        if ("000".equals(tyouseiJiyuu)) {
                            syukeiyakupkyktuuka = Long.parseLong(keisanGaikakanzan.execDivide(
                                tesuuryouSyouhn.getKyktuukasyu(), tesuuryouSyouhn.getHokenryou(),
                                tkykwsrate, C_HasuusyoriKbn.AGE).toAdsoluteString());
                        }
                        else {
                            syukeiyakupkyktuuka = 0;
                        }
                    }

                    if (syohinHanteiKeika == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                        if (C_Tuukasyu.JPY.eq(tesuuryouSyouhn.getKyktuukasyu())) {
                            syukeiyakupkyktuuka = 0;
                        }
                        else {
                            syukeiyakupkyktuuka = Long.parseLong(tesuuryouSyouhn.getHokenryou().toAdsoluteString());

                            if (C_TsrysyoriKbn.HRIKAIHEN.eq(tesuuryou.getTsrysyorikbn())) {
                                syukeiyakupkyktuuka = Long.parseLong(tesuuryouSyouhnRireki.getHokenryou().toAdsoluteString());
                            }

                            if ("700".equals(tyouseiJiyuu)) {
                                if ("3".equals(hrkkaisuuKbn)) {
                                    if (C_TsrysyoriKbn.GENGAKU.eq(tesuuryou.getTsrysyorikbn())) {
                                        syukeiyakupkyktuuka = Long.parseLong(tesuuryouSyouhnRireki.getHokenryou().subtract(
                                            tesuuryouSyouhn.getHokenryou()).toAdsoluteString());
                                    }
                                }

                                if ("1".equals(hrkkaisuuKbn) || "2".equals(hrkkaisuuKbn)) {
                                    syukeiyakupkyktuuka = Long.parseLong(tesuuryou.getMikeikap().toAdsoluteString());
                                }
                            }
                        }
                    }
                }

                BizCurrency bfrsyupKytk = BizCurrency.valueOf(0);
                if (C_Kykjyoutai.ITIJIBARAI.eq(tesuuryouSyouhn.getKykjyoutai())) {
                    if (C_TsrysyoriKbn.SEINENGAPPISEI.eq(tesuuryou.getTsrysyorikbn()) ||
                        C_TsrysyoriKbn.GENGAKU.eq(tesuuryou.getTsrysyorikbn())) {
                        if (tesuuryouSyouhnRireki != null) {
                            if (!tesuuryouSyouhn.getHokenryou().equals(tesuuryouSyouhnRireki.getHokenryou())) {
                                bfrsyupKytk = tesuuryouSyouhnRireki.getHokenryou();
                            }
                            else {
                                bfrsyupKytk = BizCurrency.valueOf(0);
                            }
                        }
                        else {
                            throw new BizAppException(MessageId.EIA1048, IT_TesuuryouSyouhnRireki.TABLE_NAME,
                                tesuuryou.getSyono());
                        }
                    }
                    else {
                        bfrsyupKytk = BizCurrency.valueOf(0);
                    }
                }
                else {
                    if (syohinHanteiKeika == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        bfrsyupKytk = BizCurrency.valueOf(0);
                    }

                    if (syohinHanteiKeika == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ) {
                        if (C_Tuukasyu.JPY.eq(tesuuryouSyouhn.getKyktuukasyu())) {
                            bfrsyupKytk = BizCurrency.valueOf(0);
                        }
                        else {
                            if ("200".equals(tyouseiJiyuu) ||"110".equals(tyouseiJiyuu)) {
                                bfrsyupKytk = tesuuryouSyouhnRireki.getHokenryou();
                            }

                            else if ("700".equals(tyouseiJiyuu)) {
                                if ("3".equals(hrkkaisuuKbn)) {
                                    bfrsyupKytk = BizCurrency.valueOf(0);
                                }
                                if ("1".equals(hrkkaisuuKbn) || "2".equals(hrkkaisuuKbn)) {
                                    if (C_TsrysyoriKbn.GENGAKU.eq(tesuuryou.getTsrysyorikbn())) {
                                        bfrsyupKytk = tesuuryouSyouhnRireki.getHokenryou().subtract(tesuuryouSyouhn.getHokenryou());
                                    }
                                    else {
                                        bfrsyupKytk = tesuuryouSyouhn.getHokenryou();
                                    }
                                }
                                else {
                                    bfrsyupKytk = BizCurrency.valueOf(0);
                                }
                            }
                            else {
                                bfrsyupKytk = BizCurrency.valueOf(0);
                            }
                        }
                    }
                }

                IT_KykSya kykSya = tsryInfoBean.getIT_KykSya();
                IT_HhknSya hhknSya = tsryInfoBean.getIT_HhknSya();

                ZT_DrtenTsryInfoTy drtenTsryInfoTy = new ZT_DrtenTsryInfoTy();

                drtenTsryInfoTy.setZtydairitencd(kykDairiten.getDrtencd());
                drtenTsryInfoTy.setZtybosyuunincd(kykDairiten.getBosyuucd());
                drtenTsryInfoTy.setZtysyono(tesuuryou.getSyono());
                drtenTsryInfoTy.setZtykeiyakukbn("1");
                drtenTsryInfoTy.setZtytokuyakuno("00");
                if (tesuuryou.getBosyuuym() != null) {
                    drtenTsryInfoTy.setZtybsyym(tesuuryou.getBosyuuym().toString());
                }
                if (tesuuryouSyouhn.getKykymd() != null) {
                    drtenTsryInfoTy.setZtykykymd(tesuuryouSyouhn.getKykymd().toString());
                }
                drtenTsryInfoTy.setZtykydatkibosyuucd(kydatkiBosyuuCd);
                drtenTsryInfoTy.setZtykydeigyouakojincd("000000");
                drtenTsryInfoTy.setZtykydeigyoubkojincd("000000");
                drtenTsryInfoTy.setZtyskeihyj(skeihyj);
                if (denYmd != null) {
                    drtenTsryInfoTy.setZtydenymd(denYmd.toString());
                }
                else {
                    drtenTsryInfoTy.setZtydenymd("00000000");
                }
                drtenTsryInfoTy.setZtykikaisyoriymd(bzBatchParam.getSyoriYmd().toString());
                drtenTsryInfoTy.setZtytyouseijiyuu(tyouseiJiyuu);
                drtenTsryInfoTy.setZtynyknmonth(nyuukinTukisuu);
                drtenTsryInfoTy.setZtysikibetujyunjyo(sikibetujyunjyo);
                drtenTsryInfoTy.setZtytnsmacezugkukbn("0");
                drtenTsryInfoTy.setZtyacezugkkrykkaisiymd("00000000");
                drtenTsryInfoTy.setZtykykmfksnctrlkh(Long.valueOf(
                    tesuuryouSyouhn.getHenkousikibetukey().substring(10, 17)));
                drtenTsryInfoTy.setZtydairitenatkikeitaikbn(drtenAtkikeitaiKbn);
                drtenTsryInfoTy.setZtyatkiwari(atkiwari);
                drtenTsryInfoTy.setZtydairitenatkinin(drtenAtkininsuu);
                drtenTsryInfoTy.setZtytsrkeisansyukykhsyos(new BigDecimal(tsrkeisansyukykhsyos.toAdsoluteString()).longValue());
                drtenTsryInfoTy.setZtyhknsyukigou(tesuuryouSyouhn.getSyouhncd().substring(0, 2));
                drtenTsryInfoTy.setZtyhknsyuruikigousedaikbn(tesuuryouSyouhn.getRyouritusdno().substring(0, 1));
                drtenTsryInfoTy.setZtyhrkkaisuukbn(hrkkaisuuKbn);
                drtenTsryInfoTy.setZtyannaifuyouriyuukbn(annaiFuyouRiyuuKbn);
                drtenTsryInfoTy.setZtyhhknnen2keta(String.valueOf(tesuuryouSyouhn.getHhknnen()));
                drtenTsryInfoTy.setZtyhknkkn(hknkikan);
                drtenTsryInfoTy.setZtyfstkeijyouhtkm("000000");
                drtenTsryInfoTy.setZtytsrytsryhushrkbn(kykKihon.getTsryhshrkykumukbn().getValue());
                drtenTsryInfoTy.setZtymrtihukakbn("0");
                drtenTsryInfoTy.setZtysznmrtihukakbn("0");
                drtenTsryInfoTy.setZtyteigenmrtihukakbn("0");
                drtenTsryInfoTy.setZtysyunyumrtihukakbn("0");
                drtenTsryInfoTy.setZtykzkmrtihukakbn("0");
                drtenTsryInfoTy.setZtytoksipmrtihukakbn("0");
                drtenTsryInfoTy.setZtytoksipmrsyhukakbn("0");
                drtenTsryInfoTy.setZtymanskknmrtihukakbn("0");
                drtenTsryInfoTy.setZtykigsyunyumrtihukakbn("0");
                drtenTsryInfoTy.setZtykigteigenmrtihukakbn("0");
                drtenTsryInfoTy.setZtykignktkhukakbn("0");
                drtenTsryInfoTy.setZtykigmrtihukakbn("0");
                drtenTsryInfoTy.setZtymrtisyukguyobiv1("0");
                drtenTsryInfoTy.setZtymrtisyukguyobiv1x2("0");
                drtenTsryInfoTy.setZtymrtisyukguyobiv1x3("0");
                drtenTsryInfoTy.setZtymrtisyukguyobiv1x4("0");
                drtenTsryInfoTy.setZtymrtisyukguyobiv1x5("0");
                drtenTsryInfoTy.setZtykyknm(kykSya.getKyknmkn());
                drtenTsryInfoTy.setZtykjkyknm(kykSya.getKyknmkj());
                drtenTsryInfoTy.setZtyhhknmei(hhknSya.getHhknnmkn());
                drtenTsryInfoTy.setZtyknjhhknmei(hhknSya.getHhknnmkj());
                drtenTsryInfoTy.setZtyanniskcd("00000000");
                drtenTsryInfoTy.setZtykarikeijyoukbn("0");
                drtenTsryInfoTy.setZtytuikakeijyouhyj("0");
                drtenTsryInfoTy.setZtyksnhyj("0");
                drtenTsryInfoTy.setZtyphrkkikn(phrkkikn);
                drtenTsryInfoTy.setZtysyukeiyakup(hokenRyou);
                drtenTsryInfoTy.setZtybfrsyup(bfrsyup);
                drtenTsryInfoTy.setZtydairitentsratkiwari(BizNumber.valueOf(drtenTsratkiwari / 100));
                drtenTsryInfoTy.setZtyseirituymd(seirituYmd);
                drtenTsryInfoTy.setZtysekininkaisiymd(sekininkaisiYmd);
                drtenTsryInfoTy.setZtycifcd(tesuuryou.getCifcd());
                drtenTsryInfoTy.setZtybankboskykkbn(bankBoskykKbn);
                drtenTsryInfoTy.setZtykykjiqpackhyj("0");
                drtenTsryInfoTy.setZtyyoteiriritun5(tesuuryouSyouhn.getYoteiriritu());
                drtenTsryInfoTy.setZtykyksyaskinmeino(kykSya.getKyksakuinmeino());
                drtenTsryInfoTy.setZtyhhknsakuinmeino(hhknSya.getHhknsakuinmeino());
                drtenTsryInfoTy.setZtysyouhizeiritu(syouhizeiritu);
                drtenTsryInfoTy.setZtymdhnaisyoumeicd(kykKihon.getAisyoumeikbn().getValue());
                drtenTsryInfoTy.setZtycoolingofhyj(coolingofhyj);
                drtenTsryInfoTy.setZtysaimnkkykhyj(saimnkkykhyj);
                drtenTsryInfoTy.setZtypjytoym(pjytoYm);
                drtenTsryInfoTy.setZtysskhntihrkkisukbn(sskhntihrkkisukbn);
                drtenTsryInfoTy.setZtyphenkanarihyj(phenkanarihyj);
                drtenTsryInfoTy.setZtyhjnkykhyj("0");
                drtenTsryInfoTy.setZtybktgomeisaicalcjyun("00");
                drtenTsryInfoTy.setZtyphenkanbfrsyup(phenkanbfrsyup);
                drtenTsryInfoTy.setZtyikkatubaraikbn(ktbriKbn);
                drtenTsryInfoTy.setZtyikkatubaraikaisuu(ktbriKaisuu);
                drtenTsryInfoTy.setZtyuktkid(uktkId);
                drtenTsryInfoTy.setZtytousyokykjikawaserate(tousyoKykjiKawaserate);
                drtenTsryInfoTy.setZtykigmrsytkphrkkkn("00");
                drtenTsryInfoTy.setZtyshzirtstkjynymd(shzirtstkjynYmd);
                if (kykSya.getKykseiymd() != null) {
                    drtenTsryInfoTy.setZtykyksyaseiymd(kykSya.getKykseiymd().toString());
                }
                drtenTsryInfoTy.setZtytuukacd(tuukaCd);
                drtenTsryInfoTy.setZtysyukeiyakupkyktuuka(syukeiyakupkyktuuka);
                drtenTsryInfoTy.setZtybfrsyupkyktuuka(new BigDecimal(bfrsyupKytk.toAdsoluteString()).longValue());
                drtenTsryInfoTy.setZtytekiyoukawaserate7keta(tkykwsrate);
                drtenTsryInfoTy.setZtyyobiv22("0000000000000000000000");

                BizPropertyInitializer.initialize(drtenTsryInfoTy);
                drtenTsryInfoTyInserter.add(drtenTsryInfoTy);
                syoriKensuu++;

                String mkkpHkNyuukinTukisuu = "";
                String mkkpHkSikibetujyunjyo = "";
                String mkkpHkPhenkanarihyj = "";
                String mkkpHkTyouseiJiyuu = "";
                long mkkpHkHokenRyou = 0;
                long mkkpHkBfrsyup = 0;
                long mkkphenkanbfrsyup = 0;
                BizCurrency mkkptsrkeisansyukykhsyos = BizCurrency.valueOf(0);
                long mkkpsyukeiyakupkyktuuka = 0;
                BizCurrency mkkpbfrsyupKytk = BizCurrency.valueOf(0);
                BizNumber mkkptkykwsrate = BizNumber.valueOf(0);

                if (C_UmuKbn.ARI.eq(mikeikapHenkanUmu)) {

                    nyuukinTukisuu = "000";
                    sikibetujyunjyo = "2";
                    phenkanarihyj = "1";
                    phenkanbfrsyup = 0;

                    if (C_TsrysyoriKbn.KAIYAKU.eq(tesuuryou.getTsrysyorikbn())) {
                        tyouseiJiyuu = "481";
                        if (syohinHanteiKeika == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ) {
                            if (C_Tuukasyu.JPY.eq(tesuuryouSyouhn.getKyktuukasyu())) {
                                hokenRyou = Long.parseLong(tesuuryouSyouhn.getHokenryou().toAdsoluteString());
                                bfrsyup = 0L;
                            }
                            else {
                                syukeiyakupkyktuuka = Long.parseLong(tesuuryouSyouhn.getHokenryou().toAdsoluteString());
                                bfrsyupKytk = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
                                tkykwsrate = tkykwsratesyorijiten;
                            }
                        }
                    }
                    else if (C_TsrysyoriKbn.GENGAKU.eq(tesuuryou.getTsrysyorikbn())) {
                        tyouseiJiyuu = "200";
                        tsrkeisansyukykhsyos = tesuuryouSyouhn.getKihons();

                        if (syohinHanteiKeika == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
                            (syohinHanteiKeika == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
                            C_Tuukasyu.JPY.eq(tesuuryouSyouhn.getKyktuukasyu()))) {
                            hokenRyou = Long.parseLong(tesuuryouSyouhn.getHokenryou().toAdsoluteString());
                            bfrsyup = Long.parseLong(tesuuryouSyouhnRireki.getHokenryou().toAdsoluteString());
                        }
                        if ((syohinHanteiKeika == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
                            !C_Tuukasyu.JPY.eq(tesuuryouSyouhn.getKyktuukasyu()))) {
                            syukeiyakupkyktuuka = Long.parseLong(tesuuryouSyouhn.getHokenryou().toAdsoluteString());
                            bfrsyupKytk = tesuuryouSyouhnRireki.getHokenryou();
                            tkykwsrate = tkykwsratesyorijiten;
                        }
                    }

                    if (C_UmuKbn.ARI.eq(kykDairiten.getDrtenbunumu())) {
                        mkkpHkNyuukinTukisuu = nyuukinTukisuu;
                        mkkpHkSikibetujyunjyo = sikibetujyunjyo;
                        mkkpHkPhenkanarihyj = phenkanarihyj;
                        mkkpHkTyouseiJiyuu = tyouseiJiyuu;
                        mkkpHkHokenRyou = hokenRyou;
                        mkkpHkBfrsyup = bfrsyup;
                        mkkphenkanbfrsyup = phenkanbfrsyup;
                        mkkptsrkeisansyukykhsyos = tsrkeisansyukykhsyos;
                        mkkpsyukeiyakupkyktuuka = syukeiyakupkyktuuka;
                        mkkpbfrsyupKytk = bfrsyupKytk;
                        mkkptkykwsrate = tkykwsrate;
                    }

                    ZT_DrtenTsryInfoTy drtenTsryInfoTyMkkpHk = new ZT_DrtenTsryInfoTy();
                    BeanUtil.copyProperties(drtenTsryInfoTyMkkpHk, drtenTsryInfoTy);
                    drtenTsryInfoTyMkkpHk.setZtynyknmonth(nyuukinTukisuu);
                    drtenTsryInfoTyMkkpHk.setZtysikibetujyunjyo(sikibetujyunjyo);
                    drtenTsryInfoTyMkkpHk.setZtyphenkanarihyj(phenkanarihyj);
                    drtenTsryInfoTyMkkpHk.setZtytyouseijiyuu(tyouseiJiyuu);
                    drtenTsryInfoTyMkkpHk.setZtysyukeiyakup(hokenRyou);
                    drtenTsryInfoTyMkkpHk.setZtybfrsyup(bfrsyup);
                    drtenTsryInfoTyMkkpHk.setZtyphenkanbfrsyup(phenkanbfrsyup);
                    drtenTsryInfoTyMkkpHk.setZtytsrkeisansyukykhsyos(new BigDecimal(tsrkeisansyukykhsyos.toAdsoluteString()).longValue());
                    drtenTsryInfoTyMkkpHk.setZtysyukeiyakupkyktuuka(syukeiyakupkyktuuka);
                    drtenTsryInfoTyMkkpHk.setZtybfrsyupkyktuuka(new BigDecimal(bfrsyupKytk.toAdsoluteString()).longValue());
                    drtenTsryInfoTyMkkpHk.setZtytekiyoukawaserate7keta(tkykwsrate);

                    drtenTsryInfoTyInserter.add(drtenTsryInfoTyMkkpHk);
                    syoriKensuu++;
                }

                if (C_UmuKbn.ARI.eq(kykDairiten.getDrtenbunumu())) {

                    ZT_DrtenTsryInfoTy drtenTsryInfoTyKb = new ZT_DrtenTsryInfoTy();
                    BeanUtil.copyProperties(drtenTsryInfoTyKb, drtenTsryInfoTy);
                    drtenTsryInfoTyKb.setZtydairitencd(kykDairitenKb.getDrtencd());
                    drtenTsryInfoTyKb.setZtybosyuunincd(kykDairitenKb.getBosyuucd());
                    drtenTsryInfoTyKb.setZtykydatkibosyuucd(kykDairiten.getBosyuucd());
                    drtenTsryInfoTyKb.setZtydairitentsratkiwari(
                        BizNumber.valueOf(new BigDecimal(kykDairitenKb.getBunwari().toString()).doubleValue() / 100));
                    if (C_TsrysyoriKbn.SINKEIYAKUSEIRITU.eq(tesuuryou.getTsrysyorikbn())) {
                        drtenTsryInfoTyKb.setZtybankboskykkbn("2");
                    }
                    drtenTsryInfoTyInserter.add(drtenTsryInfoTyKb);
                    syoriKensuu++;

                    if (C_UmuKbn.ARI.eq(mikeikapHenkanUmu)) {
                        nyuukinTukisuu = mkkpHkNyuukinTukisuu;
                        sikibetujyunjyo = mkkpHkSikibetujyunjyo;
                        phenkanarihyj = mkkpHkPhenkanarihyj;
                        tyouseiJiyuu = mkkpHkTyouseiJiyuu;
                        hokenRyou = mkkpHkHokenRyou;
                        bfrsyup = mkkpHkBfrsyup;
                        phenkanbfrsyup = mkkphenkanbfrsyup;
                        tsrkeisansyukykhsyos = mkkptsrkeisansyukykhsyos;
                        syukeiyakupkyktuuka = mkkpsyukeiyakupkyktuuka;
                        bfrsyupKytk = mkkpbfrsyupKytk;
                        tkykwsrate = mkkptkykwsrate;

                        ZT_DrtenTsryInfoTy drtenTsryInfoTyMkkpHk = new ZT_DrtenTsryInfoTy();
                        BeanUtil.copyProperties(drtenTsryInfoTyMkkpHk, drtenTsryInfoTyKb);
                        drtenTsryInfoTyMkkpHk.setZtynyknmonth(nyuukinTukisuu);
                        drtenTsryInfoTyMkkpHk.setZtysikibetujyunjyo(sikibetujyunjyo);
                        drtenTsryInfoTyMkkpHk.setZtyphenkanarihyj(phenkanarihyj);
                        drtenTsryInfoTyMkkpHk.setZtytyouseijiyuu(tyouseiJiyuu);
                        drtenTsryInfoTyMkkpHk.setZtysyukeiyakup(hokenRyou);
                        drtenTsryInfoTyMkkpHk.setZtybfrsyup(bfrsyup);
                        drtenTsryInfoTyMkkpHk.setZtyphenkanbfrsyup(phenkanbfrsyup);
                        drtenTsryInfoTyMkkpHk.setZtytsrkeisansyukykhsyos(new BigDecimal(tsrkeisansyukykhsyos.toAdsoluteString()).longValue());
                        drtenTsryInfoTyMkkpHk.setZtysyukeiyakupkyktuuka(syukeiyakupkyktuuka);
                        drtenTsryInfoTyMkkpHk.setZtybfrsyupkyktuuka(new BigDecimal(bfrsyupKytk.toAdsoluteString()).longValue());
                        drtenTsryInfoTyMkkpHk.setZtytekiyoukawaserate7keta(tkykwsrate);
                        drtenTsryInfoTyInserter.add(drtenTsryInfoTyMkkpHk);
                        syoriKensuu++;
                    }
                }
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
