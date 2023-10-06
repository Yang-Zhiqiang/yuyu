package yuyu.batch.biz.boss.bzkeizokuriturenrakuulfsks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.boss.bzkeizokuriturenrakuulfsks.dba.BzKeizokurituRenrakuUlfSksDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknYendtHnk;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KeizokuriturenrakudateUlfsByBosyuuymBean;
import yuyu.def.hozen.sorter.SortIT_NyknJissekiRireki;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 普保Ⅱ継続率連絡データＵＬＦ作成
 */
public class BzKeizokurituRenrakuUlfSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzKeizokurituRenrakuUlfSksDao bzKeizokurituRenrakuUlfSksDao;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            batchParam.getSyoriYmd().toString()));

        int syoriKensuu = 0;
        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        SortIT_NyknJissekiRireki nyknJissekiRireki = SWAKInjector.getInstance(SortIT_NyknJissekiRireki.class);
        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        try (
            EntityInserter<ZT_KeizokurituRenrakuULFTy> keizokurituRenrakuULFTyInserter = new EntityInserter<>();
            ExDBResults<KeizokuriturenrakudateUlfsByBosyuuymBean> keizokuriturenrakudateUlfBeanLst =
                hozenDomManager.getKeizokuriturenrakudateUlfsByBosyuuym(
                    batchParam.getSyoriYmd().getBizDateYM().addMonths(-77),
                    batchParam.getSyoriYmd().getBizDateYM().addMonths(-4));) {

            for (KeizokuriturenrakudateUlfsByBosyuuymBean keizokuriturenrakudateUlfBean : keizokuriturenrakudateUlfBeanLst) {
                ZT_KeizokurituRenrakuULFTy keizokurituRenrakuULFTy = new ZT_KeizokurituRenrakuULFTy();
                IT_KykKihon kykKihon = keizokuriturenrakudateUlfBean.getIT_KykKihon();
                IT_KykSyouhn kykSyouhn = keizokuriturenrakudateUlfBean.getIT_KykSyouhn();
                IT_KykSya kykSya = keizokuriturenrakudateUlfBean.getIT_KykSya();
                IT_HhknSya hhknSya = keizokuriturenrakudateUlfBean.getIT_HhknSya();
                IT_KykDairiten kykDairiten = keizokuriturenrakudateUlfBean.getIT_KykDairiten();
                IT_AnsyuKihon ansyuuKihon = keizokuriturenrakudateUlfBean.getIT_AnsyuKihon();
                BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();
                IT_KykSonotaTkyk kykSonotaTkyk = keizokuriturenrakudateUlfBean.getIT_KykSonotaTkyk();


                int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());
                Integer ztyhknkkn = 0;
                if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())
                    && C_HknkknsmnKbn.NENMANKI.eq(kykSyouhn.getHknkknsmnkbn())) {

                    ztyhknkkn = setNenrei.getNkshrStartNenrei(kykSyouhn.getHhknnen(), kykSyouhn.getHknkkn());
                }
                else {

                    ztyhknkkn = kykSyouhn.getHknkkn();
                }
                String ztyKhyuukousyoumetukbn = "0";
                String ztyKeikatukisuu = "00";

                if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                    if (C_Syoumetujiyuu.KAIYAKU.eq(kykSyouhn.getSyoumetujiyuu())) {

                        ztyKhyuukousyoumetukbn = "4";
                    }
                    else if (C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM.eq(kykSyouhn.getSyoumetujiyuu()) ||
                        C_Syoumetujiyuu.PMNYSYMET_MSSN.eq(kykSyouhn.getSyoumetujiyuu()) ||
                        C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(kykSyouhn.getSyoumetujiyuu()) ||
                        C_Syoumetujiyuu.JIKOU.eq(kykSyouhn.getSyoumetujiyuu())) {

                        ztyKhyuukousyoumetukbn = "5";
                    }
                }

                BizDateYM taisyoYM = null;

                if ("4".equals(ztyKhyuukousyoumetukbn)) {

                    if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                        taisyoYM = kykSyouhn.getSyoumetuymd().getNextDay().getBizDateYM();
                    }
                    else {
                        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                        taisyoYM = keisanWKijunYM.exec

                            (kykSyouhn.getKykymd(),
                                kykSyouhn.getSyoumetuymd(),
                                ansyuuKihon.getJkipjytym(),
                                kykKihon.getHrkkaisuu(),
                                kykSyouhn.getKykjyoutai(),
                                kykSyouhn.getSyouhncd(),
                                kykSyouhn.getYendthnkymd());

                    }
                }

                else if ("5".equals(ztyKhyuukousyoumetukbn)) {
                    if(C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())){
                        ztyKeikatukisuu = "01";
                    }else{
                        taisyoYM = ansyuuKihon.getJkipjytym();
                    }
                }

                if (taisyoYM != null) {
                    ztyKeikatukisuu = String.valueOf(BizDateUtil.calcDifferenceMonths

                        (taisyoYM,

                            kykSyouhn.getKykymd().getBizDateYM()));

                    if (Integer.valueOf(ztyKeikatukisuu) >= 100) {
                        ztyKeikatukisuu = "99";
                    }
                    else if (Integer.valueOf(ztyKeikatukisuu) < 10) {
                        ztyKeikatukisuu = "0" + ztyKeikatukisuu;
                    }
                }

                double ztyKeiyakukensuu = 0;
                if (C_UmuKbn.ARI.eq(kykDairiten.getDrtenbunumu())) {

                    ztyKeiyakukensuu = 0.5;
                }
                else {

                    ztyKeiyakukensuu = 1;
                }

                String ztyAtukaisosikicd = "0000000";
                if (!BizUtil.isBlank(kykDairiten.getDrtenkanrisosikicd())) {
                    ztyAtukaisosikicd = kykDairiten.getDrtenkanrisosikicd();
                }
                else {

                    List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(kykDairiten.getDrtencd());

                    if (bzGetAgInfoBeanLst.size() != 0) {

                        ztyAtukaisosikicd = bzGetAgInfoBeanLst.get(0).getDrtKanrisosikiCd1();
                    }
                }

                BizCurrency ztyKihons = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizNumber kawaseRate = null;

                List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = null;

                if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ) {
                    ztyKihons = kykSyouhn.getPharaikomisougaku();

                }
                else {
                    nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);
                    nyknJissekiRirekiLst = nyknJissekiRireki.OrderIT_NyknJissekiRirekiByPkAsc(nyknJissekiRirekiLst);

                    if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                        ztyKihons = kykSyouhn.getKihons();
                    }
                    else {
                        BizDate kawaseRateKjYmd = null;
                        if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ) {

                            kawaseRateKjYmd = batchParam.getSyoriYmd();
                        }

                        else {
                            if (nyknJissekiRirekiLst.size() > 0) {
                                kawaseRateKjYmd = nyknJissekiRirekiLst.get(0).getRyosyuymd();

                            }
                        }

                        kawaseRate = getKawaserate(
                            kawaseRateKjYmd,
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                            kykSyouhn.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.JISSEIRATE,
                            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        ztyKihons = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            kykSyouhn.getKihons(),
                            kawaseRate,
                            C_HasuusyoriKbn.SUTE);
                    }
                }
                if (C_UmuKbn.ARI.eq(kykDairiten.getDrtenbunumu())) {
                    if (kykDairiten.getDrtenrenno() == 1) {
                        ztyKihons = ztyKihons.divide(2, 0, RoundingMode.UP);
                    }
                    else {
                        ztyKihons = ztyKihons.divide(2, 0, RoundingMode.DOWN);
                    }
                }

                BizCurrency ztyhsys = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
                    syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
                    syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                    ztyhsys = ztyKihons;
                }
                else {

                    BizDate wkCalckijyunYmd = kykSyouhn.getKykymd();

                    if (kykSyouhn.getYendthnkymd() != null) {
                        if (BizDateUtil.compareYmd(batchParam.getSyoriYmd(),kykSyouhn.getYendthnkymd()) == BizDateUtil.COMPARE_LESSER) {
                            wkCalckijyunYmd = kykSyouhn.getYendthnkymd();
                        }
                        else {
                            wkCalckijyunYmd = batchParam.getSyoriYmd();
                        }
                    }

                    C_ErrorKbn calcHkErrorKbn = calcHkShrKngk.execByKeisanWExt(
                        kykKihon.getSyono(),
                        wkCalckijyunYmd,
                        C_SiinKbn.SP,
                        C_HokenkinsyuruiKbn.SBHOKENKIN,
                        kykKihon.getSdpdkbn(),
                        kykKihon.getHrkkeiro()
                        );

                    if (!C_ErrorKbn.OK.eq(calcHkErrorKbn)) {

                        throw new CommonBizAppException((MessageUtil.getMessage(MessageId.EIA1048,
                            ResourceUtil.getApplicationResources().getString("hoknkngk"),
                            kykKihon.getSyono()
                            )));
                    }

                    if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                        ztyhsys = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk(),
                            kawaseRate,
                            C_HasuusyoriKbn.SUTE);
                    }
                    else {

                        ztyhsys = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();
                    }

                    if (C_UmuKbn.ARI.eq(kykDairiten.getDrtenbunumu())) {

                        if (kykDairiten.getDrtenrenno() == 1) {

                            ztyhsys = ztyhsys.divide(2, 0, RoundingMode.UP);
                        }
                        else {

                            ztyhsys = ztyhsys.divide(2, 0, RoundingMode.DOWN);
                        }
                    }
                }

                String ztyHhknnen2keta = String.valueOf(kykSyouhn.getHhknnen());
                if (kykSyouhn.getHhknnen() >= 100) {
                    ztyHhknnen2keta = "99";
                }
                else if (kykSyouhn.getHhknnen() < 10) {
                    ztyHhknnen2keta = "0" + ztyHhknnen2keta;
                }

                String ztyKydatkihyj = "";
                if (C_UmuKbn.ARI.eq(kykDairiten.getDrtenbunumu())) {
                    ztyKydatkihyj = "1";
                }
                else {
                    ztyKydatkihyj = "0";
                }

                BizNumber ztyitijibaraipkyktuuka = null;

                IT_KykSyouhnHnkmae kykSyouhnHnkmae = bzKeizokurituRenrakuUlfSksDao
                    .getKykSyouhnHnkmaeBySyono(kykKihon.getSyono());

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {
                    if (kykSyouhn.getYendthnkymd() != null) {

                        ztyitijibaraipkyktuuka = BizNumber.valueOf(new BigDecimal(kykSyouhnHnkmae.getHokenryou()
                            .toString()));
                    }
                    else {
                        ztyitijibaraipkyktuuka = BizNumber.valueOf(new BigDecimal(kykSyouhn.getHokenryou().toString()));
                    }
                }

                else {
                    ztyitijibaraipkyktuuka = BizNumber.valueOf(0);
                }

                BizNumber ztykawaseraten5 = null;
                C_Tuukasyu rstuukasyu = C_Tuukasyu.BLNK;
                C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.BLNK;
                C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.BLNK;
                BizDate kawaseRateKjYmd = null;

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    if (kykSyouhn.getYendthnkymd() != null) {

                        if (C_Tuukasyu.JPY.eq(kykSyouhnHnkmae.getKyktuukasyu())) {

                            ztykawaseraten5 = BizNumber.valueOf(0);
                        }
                        else {
                            kawaseRateKjYmd = nyknJissekiRirekiLst.get(0).getRyosyuymd();
                            rstuukasyu = nyknJissekiRirekiLst.get(0).getRstuukasyu();

                            if (C_Tuukasyu.JPY.eq(rstuukasyu)) {

                                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
                                kawasetsryKbn = C_KawasetsryKbn.NYUKINRATE;
                            }
                            else {
                                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
                                kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
                            }

                            ztykawaseraten5 = getKawaserate(
                                kawaseRateKjYmd,
                                kawaserateSyuruiKbn,
                                kykSyouhnHnkmae.getKyktuukasyu(),
                                C_Tuukasyu.JPY,
                                C_KawasetekiyoKbn.TTM,
                                kawasetsryKbn,
                                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                                C_YouhiKbn.HUYOU);
                        }
                    }
                    else {

                        if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                            ztykawaseraten5 = BizNumber.valueOf(0);
                        }
                        else {

                            kawaseRateKjYmd = nyknJissekiRirekiLst.get(0).getRyosyuymd();
                            rstuukasyu = nyknJissekiRirekiLst.get(0).getRstuukasyu();

                            if (C_Tuukasyu.JPY.eq(rstuukasyu)) {

                                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
                                kawasetsryKbn = C_KawasetsryKbn.NYUKINRATE;
                            }
                            else {
                                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
                                kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
                            }

                            ztykawaseraten5 = getKawaserate(
                                kawaseRateKjYmd,
                                kawaserateSyuruiKbn,
                                kykSyouhn.getKyktuukasyu(),
                                C_Tuukasyu.JPY,
                                C_KawasetekiyoKbn.TTM,
                                kawasetsryKbn,
                                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                                C_YouhiKbn.HUYOU);
                        }
                    }

                }
                else {
                    if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                        if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                            ztykawaseraten5 = BizNumber.valueOf(0);
                        }
                        else {
                            if ((C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai()))) {

                                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {
                                    ztykawaseraten5 = nyknJissekiRirekiLst.get(0).getRyosyukwsrate();
                                }
                                else {
                                    ztykawaseraten5 = getKawaserate(
                                        nyknJissekiRirekiLst.get(0).getYenkansantkykwsrateymd(),
                                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                                        kykSyouhn.getKyktuukasyu(),
                                        C_Tuukasyu.JPY,
                                        C_KawasetekiyoKbn.TTM,
                                        C_KawasetsryKbn.JISSEIRATE,
                                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                                        C_YouhiKbn.HUYOU);
                                }


                            }
                            else {
                                ztykawaseraten5 = nyknJissekiRirekiLst.get(0).getRyosyukwsrate();
                            }
                        }
                    }
                    else {
                        ztykawaseraten5 = BizNumber.valueOf(0);
                    }
                }

                String ztyhrkkaisuukbn = "0";

                if ((C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai()))) {

                } else if ((C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai()))) {

                    ztyhrkkaisuukbn = "1";

                } else {

                    if ((C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) ||
                        (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) ) {

                        ztyhrkkaisuukbn = "2";

                    } else if ((C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()))||
                        (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu()))) {

                        ztyhrkkaisuukbn = "1";

                    } else {

                        ztyhrkkaisuukbn = "3";
                    }
                }

                String ztyhrkkeirokbn = "0";

                KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(
                    kykKihon.getHrkkeiro().getValue(),
                    C_Hrkkeiro.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                if (kbnInfoBean.isHenkanFlg()) {

                    ztyhrkkeirokbn = kbnInfoBean.getKbnData();

                } else {
                    throw new CommonBizAppException((MessageUtil.getMessage(MessageId.EIA1046,

                        ResourceUtil.getApplicationResources().getString("hrkkeiro"),
                        kykKihon.getHrkkeiro().getValue())));
                }


                String ztyannaifuyouriyuukbn = "";
                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {
                    ztyannaifuyouriyuukbn = "01";

                } else if (C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {
                    ztyannaifuyouriyuukbn = "07";

                } else {
                    ztyannaifuyouriyuukbn = "00";
                }


                String ztyjikaipjyuutouym = String.valueOf(ansyuuKihon.getJkipjytym());

                BizCurrency ztynnknsnpssysyup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                if (!C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    ztynnknsnpssysyup = kykKihon.getHrkp();
                }

                String ztynenkansanpsansyutuhrkkaisuukbn = "";

                if (!C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {

                        ztynenkansanpsansyutuhrkkaisuukbn = "3";


                    }
                    else if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())){

                        ztynenkansanpsansyutuhrkkaisuukbn = "2";
                    }
                    else if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())){

                        ztynenkansanpsansyutuhrkkaisuukbn = "1";
                    }
                    else {

                        ztynenkansanpsansyutuhrkkaisuukbn = "0";
                    }
                }

                BizNumber ztynnknsnpyennkgotmttrrt = BizNumber.valueOf(0);
                BizCurrency ztynnknsnpyennkgonksjtmttkn = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                if (kykSyouhn.getYendthnkymd() != null) {

                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                        ztynnknsnpyennkgotmttrrt = kykSyouhn.getTumitateriritu();
                    }

                    if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn) {
                        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
                        KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk = SWAKInjector
                            .getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

                        BizDateYM yendthnkYM = keisanWKijunYM.exec

                            (kykSyouhn.getKykymd(),
                                kykSyouhn.getYendthnkymd(),
                                null,
                                null,
                                kykSyouhn.getKykjyoutai(),
                                kykSyouhn.getSyouhncd(),
                                null);

                        C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknYendtHnk.exec

                            (kykSyouhn.getHknkknmanryouymd(),
                                kykSyouhn.getHknkknmanryouymd().getBizDateYM(),
                                kykSyouhn.getYendthnkymd(),
                                yendthnkYM,
                                kykSyouhn.getKykymd(),
                                kykSyouhn.getHknkkn(),
                                kykSyouhn.getKihons(),
                                kykSyouhn.getTumitateriritu());

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {

                            throw new CommonBizAppException((MessageUtil.getMessage(MessageId.EIA1010,
                                "円建変更後積立金計算",
                                kykKihon.getSyono())));
                        }

                        ztynnknsnpyennkgonksjtmttkn = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
                    }
                }
                String ztykzktourokuservicearihyj = "0";
                List<IT_TrkKzk> itTrkKzkList = kykKihon.getTrkKzks();
                if (itTrkKzkList.size() > 0){
                    ztykzktourokuservicearihyj = "1";
                }

                String ztyyendthnkymd8keta = "";
                if (kykSyouhn.getYendthnkymd() != null){
                    ztyyendthnkymd8keta = String.valueOf(kykSyouhn.getYendthnkymd());
                }

                String ztykykymd = "00000000";
                if (kykSyouhn.getKykymd() != null){
                    ztykykymd = String.valueOf(kykSyouhn.getKykymd());
                }

                String siteituukakbn = "0";
                if (kykSyouhn.getYendthnkymd() != null) {
                    if (C_Tuukasyu.USD.eq(kykSyouhnHnkmae.getKyktuukasyu())) {
                        siteituukakbn = "1";
                    }
                    else if (C_Tuukasyu.AUD.eq(kykSyouhnHnkmae.getKyktuukasyu())) {
                        siteituukakbn = "2";
                    }
                }
                else {
                    if (C_Tuukasyu.USD.eq(kykSyouhn.getKyktuukasyu())) {
                        siteituukakbn = "1";
                    }
                    else if (C_Tuukasyu.AUD.eq(kykSyouhn.getKyktuukasyu())) {
                        siteituukakbn = "2";
                    }
                }

                keizokurituRenrakuULFTy.setZtysequenceno(syoriKensuu + 1);
                keizokurituRenrakuULFTy.setZtysyono(kykKihon.getSyono());
                keizokurituRenrakuULFTy.setZtyatukaikojincd(kykDairiten.getDaibosyuucd());
                keizokurituRenrakuULFTy.setZtybsyym(String.valueOf(kykKihon.getBosyuuym()));
                keizokurituRenrakuULFTy.setZtysyukgu(kykSyouhn.getSyouhncd().substring(0, 2));
                keizokurituRenrakuULFTy.setZtyhknkkn(Strings.padStart(ztyhknkkn.toString(), 2, '0'));
                keizokurituRenrakuULFTy.setZtyphrkkikn(Strings.padStart(kykSyouhn.getHrkkkn().toString(), 2, '0'));

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                    keizokurituRenrakuULFTy.setZtysaimnkkykhyj("1");
                }
                else {
                    if (C_HknkknsmnKbn.SAIMANKI.eq(kykSyouhn.getHknkknsmnkbn())) {
                        keizokurituRenrakuULFTy.setZtysaimnkkykhyj("1");
                    }
                    else {
                        keizokurituRenrakuULFTy.setZtysaimnkkykhyj("0");
                    }
                }

                keizokurituRenrakuULFTy.setZtyhrkkaisuukbn(ztyhrkkaisuukbn);
                keizokurituRenrakuULFTy.setZtyhrkkeirokbn(ztyhrkkeirokbn);
                keizokurituRenrakuULFTy.setZtytksyuannaikykkbn("0");
                keizokurituRenrakuULFTy.setZtysyukinkbn("0");
                keizokurituRenrakuULFTy.setZtyannaifuyouriyuukbn(ztyannaifuyouriyuukbn);
                keizokurituRenrakuULFTy.setZtyanniskcd("00000000");
                keizokurituRenrakuULFTy.setZtysyuukintantousosikicd("0000000");
                keizokurituRenrakuULFTy.setZtydnthrkkeirokbn("0");
                keizokurituRenrakuULFTy.setZtykhyuukousyoumetukbn(ztyKhyuukousyoumetukbn);
                keizokurituRenrakuULFTy.setZtykeikatukisuu(ztyKeikatukisuu);
                keizokurituRenrakuULFTy.setZtykeiyakukensuu(BizNumber.valueOf(ztyKeiyakukensuu));
                keizokurituRenrakuULFTy.setZtykihons(Long.valueOf(ztyKihons.toString()));
                keizokurituRenrakuULFTy.setZtysyuuseis9keta(0L);
                keizokurituRenrakuULFTy.setZtyhsys(Long.valueOf(ztyhsys.toString()));
                keizokurituRenrakuULFTy.setZtyatukaisosikicd(ztyAtukaisosikicd);
                keizokurituRenrakuULFTy.setZtykyknm(kykSya.getKyknmkn());
                keizokurituRenrakuULFTy.setZtykjkyknm(kykSya.getKyknmkj());
                keizokurituRenrakuULFTy.setZtyhhknseikbn(String.valueOf(hhknSya.getHhknsei()));
                keizokurituRenrakuULFTy.setZtyhhknnen2keta(ztyHhknnen2keta);
                keizokurituRenrakuULFTy.setZtymarutokuhyj("0");
                keizokurituRenrakuULFTy.setZtytyohktyouseihyj("0");
                keizokurituRenrakuULFTy.setZtygyoumujyouhyouji("0");
                keizokurituRenrakuULFTy.setZtykydatkihyj(ztyKydatkihyj);
                keizokurituRenrakuULFTy.setZtytenkankaisuu("0");
                keizokurituRenrakuULFTy.setZtykzktatkibanhktgksnkbn("0");
                keizokurituRenrakuULFTy.setZtyjidoukousinhyouji("0");
                keizokurituRenrakuULFTy.setZtyskeijimrtiarihyj("0");
                keizokurituRenrakuULFTy.setZtyskeijikzkmrtiarihyj("0");
                keizokurituRenrakuULFTy.setZtyhukkatukeiiarihyj("0");
                keizokurituRenrakuULFTy.setZtytyouhukutyouseiskeihyj("0");
                keizokurituRenrakuULFTy.setZtyhknsyukigou(kykSyouhn.getSyouhncd().substring(0, 2));
                keizokurituRenrakuULFTy.setZtyphkbnmnoshyouji("0");
                keizokurituRenrakuULFTy.setZtykaigomarusyuuarihyj("0");
                keizokurituRenrakuULFTy.setZtyheiyoubaraikeiyakukbn("0");
                keizokurituRenrakuULFTy.setZtyhngkjidouentyoukbn("0");
                keizokurituRenrakuULFTy.setZtyhngkjidouentyoukikan("000");
                keizokurituRenrakuULFTy.setZtydoujihuhomrtisyukigou("");
                keizokurituRenrakuULFTy.setZtyyobiv1("0");
                keizokurituRenrakuULFTy.setZtyseizonmrtiarihyj("0");
                keizokurituRenrakuULFTy.setZtyteigenmrtiarihyj("0");
                keizokurituRenrakuULFTy.setZtyjyunkensuu(BizNumber.valueOf(0));
                keizokurituRenrakuULFTy.setZtyaltourokukeiyakuhyj("0");
                keizokurituRenrakuULFTy.setZtyjikokykhyj("0");
                keizokurituRenrakuULFTy.setZtysynymrtiarihyj("0");
                keizokurituRenrakuULFTy.setZtykykniyutksytioukbn("0");
                keizokurituRenrakuULFTy.setZtyreguardmrtiarihyj("0");
                keizokurituRenrakuULFTy.setZtyreguardmrsyuarihyj("0");
                keizokurituRenrakuULFTy.setZtyvguardmrtiarihyj("0");
                keizokurituRenrakuULFTy.setZtykousintkykhyj("0");
                keizokurituRenrakuULFTy.setZtykousinkakuninnasihyj("0");
                keizokurituRenrakuULFTy.setZtyfollowhunouhyj("0");
                keizokurituRenrakuULFTy.setZtykaigosynymrtiarihyj("0");
                keizokurituRenrakuULFTy.setZtykaigoteigenmrtiarihyj("0");
                keizokurituRenrakuULFTy.setZtysuperknkuseikatupackhyj("0");
                keizokurituRenrakuULFTy.setZtykaigonktkykarihyj("0");
                keizokurituRenrakuULFTy.setZtykaigomrtiarihyj("0");
                keizokurituRenrakuULFTy.setZtykeiyakukbn("1");
                keizokurituRenrakuULFTy.setZtykeizokutyuuihyouji("0");
                keizokurituRenrakuULFTy.setZtykikeiyakutyuuihyouji("0");
                keizokurituRenrakuULFTy.setZtybosyuunincd(kykDairiten.getBosyuucd());
                keizokurituRenrakuULFTy.setZtyhsyuikktminaosikaisu("00");
                keizokurituRenrakuULFTy.setZtykykjiqpackhyj("0");
                keizokurituRenrakuULFTy.setZtybnkttnknkbn("0");
                keizokurituRenrakuULFTy.setZtymrtikousinkbn("");
                keizokurituRenrakuULFTy.setZtypmenkbnv1("9");
                keizokurituRenrakuULFTy.setZtyyouikunktkykarihyj("0");
                keizokurituRenrakuULFTy.setZtysyoumetucd("0000");
                keizokurituRenrakuULFTy.setZtyseikatusyuunyuumrtis(0L);
                keizokurituRenrakuULFTy.setZtyhitenkansyono1("00000000000");
                keizokurituRenrakuULFTy.setZtyhitenkansyono2("00000000000");
                keizokurituRenrakuULFTy.setZtyhitenkansyono3("00000000000");
                keizokurituRenrakuULFTy.setZtyhitenkansyono4("00000000000");
                keizokurituRenrakuULFTy.setZtyhitenkansyono5("00000000000");
                keizokurituRenrakuULFTy.setZtyhitenkansyono6("00000000000");
                keizokurituRenrakuULFTy.setZtynenkansanp(0L);
                keizokurituRenrakuULFTy.setZtydai3bunyanenkansanp(0L);
                keizokurituRenrakuULFTy.setZtykykym(String.valueOf(kykSyouhn.getKykymd().getBizDateYM()));
                keizokurituRenrakuULFTy.setZtysytikbn("0");
                keizokurituRenrakuULFTy.setZtyfundbubunnenkansanp(0L);
                keizokurituRenrakuULFTy.setZtyjikaipjyuutouym(ztyjikaipjyuutouym);
                keizokurituRenrakuULFTy.setZtykzktatsyuuseis(0L);
                keizokurituRenrakuULFTy.setZtysiktsynymrtiarihyj("0");
                keizokurituRenrakuULFTy.setZtylivguardarihyj("0");
                keizokurituRenrakuULFTy.setZtylivguards(0L);
                keizokurituRenrakuULFTy.setZtyknkuzusnzyrttekitkarihyj("0");
                keizokurituRenrakuULFTy.setZtybluekzjtkaisiymd("00000000");
                keizokurituRenrakuULFTy.setZtyknkuzusnzyrtstkbn("");
                keizokurituRenrakuULFTy.setZtytokuyakuno("00");
                keizokurituRenrakuULFTy.setZtyvityugusttkyuhyj("0");
                keizokurituRenrakuULFTy.setZtykykdrtkykarihyj(kykSonotaTkyk.getKykdrtkykhukaumu().getValue());
                keizokurituRenrakuULFTy.setZtystdairiseikyuutkykarihyj(kykSonotaTkyk.getStdrsktkyhkumu().getValue());
                keizokurituRenrakuULFTy.setZtykzktourokuservicearihyj(ztykzktourokuservicearihyj);
                keizokurituRenrakuULFTy.setZtyyendthnkymd8keta(ztyyendthnkymd8keta);
                keizokurituRenrakuULFTy.setZtykykymd(ztykykymd);
                keizokurituRenrakuULFTy.setZtykhsyoumetujiyuu(Strings.padStart(
                    kykSyouhn.getSyoumetujiyuu().getValue(), 2, '0'));
                keizokurituRenrakuULFTy.setZtyitijibaraipkyktuuka(ztyitijibaraipkyktuuka);
                keizokurituRenrakuULFTy.setZtykawaseraten5(ztykawaseraten5);
                keizokurituRenrakuULFTy.setZtynnknsnpssysyup(new BigDecimal(ztynnknsnpssysyup.toAdsoluteString()).longValue());
                keizokurituRenrakuULFTy.setZtynknsnpssyhrkkskbn(ztynenkansanpsansyutuhrkkaisuukbn);
                keizokurituRenrakuULFTy.setZtynnknsnpyennkgotmttrrt(ztynnknsnpyennkgotmttrrt);
                keizokurituRenrakuULFTy.setZtynnknsnpyennkgonksjtmttkn(Long.valueOf(String
                    .valueOf(ztynnknsnpyennkgonksjtmttkn)));
                keizokurituRenrakuULFTy.setZtysiteituukakbn(siteituukakbn);

                BizPropertyInitializer.initialize(keizokurituRenrakuULFTy);

                BzKeizokurituRenrakuUlfSksConverter.convertPadding(keizokurituRenrakuULFTy);

                keizokurituRenrakuULFTyInserter.add(keizokurituRenrakuULFTy);

                syoriKensuu++;
            }
        }

        batchLogger
        .info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), kinou.getKinouNm()));
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

