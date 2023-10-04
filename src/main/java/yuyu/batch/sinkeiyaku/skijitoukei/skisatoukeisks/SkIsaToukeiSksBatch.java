package yuyu.batch.sinkeiyaku.skijitoukei.skisatoukeisks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KokutiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.ZT_IsaToukeiDataTy;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_DakuhiKettei;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 新契約 医事統計 医査統計作成
 */
public class SkIsaToukeiSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCd));

        String tysyttaisyouTableId = "HT_SyoriCTL";
        String recoveryFilterId = "Sk001";
        long syoriKensuu = 0;
        BizDateYM tysyttaisyouMosYm = syoriYmd.getBizDateYM().addMonths(-2);
        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);
        SortHT_DakuhiKettei sortHT_DakuhiKettei = SWAKInjector.getInstance(SortHT_DakuhiKettei.class);
        int syouhinhanteikbn = 0;

        try (
            EntityInserter<ZT_IsaToukeiDataTy> isaToukeiDataTyLst = new EntityInserter<>();
            ExDBResults<HT_SyoriCTL> syoriCTLLst =
                sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(kakutyouJobCd, tysyttaisyouMosYm)) {

            for (HT_SyoriCTL syoriCTL : syoriCTLLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(tysyttaisyouTableId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryFilterId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoriCTL.getMosno());

                HT_MosKihon mosKihon = syoriCTL.getMosKihon();
                BizDate kwsrateKijyunYmd = mosKihon.getMosymd();
                List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
                List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
                HT_DakuhiKettei dakuhiKettei = sortHT_DakuhiKettei.OrderHT_DakuhiKetteiByPkDesc(syoriCTL.getDakuhiKetteis()).get(0);

                HT_Kokutisyo kokutisyo = null;
                HT_MosSyouhn mosSyouhnSyu = null;

                if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn())) {
                    kokutisyo = syoriCTL.getKokutisyo();
                }


                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                BizCurrency sbSs = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu()));
                BizCurrency sbSt = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu()));
                BizCurrency syukeiyakuP = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu()));
                BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();

                for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {

                    syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(),mosSyouhn.getSyouhnsdno());
                    syouhinhanteikbn = SyouhinUtil.hantei(mosSyouhn.getSyouhncd());


                    if (C_UmuKbn.ARI.eq(syouhnZokusei.getHutuusbhsyumu())) {
                        if (C_SyutkKbn.SYU.eq(mosSyouhn.getSyutkkbn())) {

                            sbSs = sbSs.add(mosSyouhn.getSeitoukihons());
                            syukeiyakuP = syukeiyakuP.add(mosSyouhn.getSyutkp());

                        }
                        else if (C_SyutkKbn.TK.eq(mosSyouhn.getSyutkkbn())) {

                            sbSt = sbSt.add(mosSyouhn.getSeitoukihons());

                        }
                    }

                    if (syouhinhanteikbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syouhinhanteikbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ) {
                        if (C_SyutkKbn.SYU.eq(mosSyouhn.getSyutkkbn())) {

                            sbSs = sbSs.add(mosSyouhn.getSyutkp());
                            syukeiyakuP = syukeiyakuP.add(mosSyouhn.getSyutkp());

                        }
                    }
                    else if (syouhinhanteikbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        if (C_SyutkKbn.SYU.eq(mosSyouhn.getSyutkkbn())) {

                            sbSs = mosKihon.getPharaikomisougaku();

                        }
                    }

                    if (C_SyutkKbn.SYU.eq(mosSyouhn.getSyutkkbn())) {

                        mosSyouhnSyu = mosSyouhn;
                    }
                }


                BizCurrency sbSspt = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
                BizCurrency keisanSbS = sbSs;

                if (!henkanTuuka.henkanTuukaTypeToKbn(sbSs.getType()).eq(henkanTuuka.henkanTuukaTypeToKbn(sbSt.getType()))) {
                    if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(sbSs.getType()))) {
                        sbSs = getKiteiCheckYenkansangk.exec(kwsrateKijyunYmd, sbSs, henkanTuuka.henkanTuukaTypeToKbn(sbSs.getType()));

                    }
                    if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(sbSt.getType()))) {
                        sbSt = getKiteiCheckYenkansangk.exec(kwsrateKijyunYmd, sbSt, henkanTuuka.henkanTuukaTypeToKbn(sbSt.getType()));
                    }

                    sbSspt = sbSs.add(sbSt);
                }
                else {
                    sbSspt = sbSs.add(sbSt);
                    if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(sbSspt.getType()))) {
                        sbSspt = getKiteiCheckYenkansangk.exec(kwsrateKijyunYmd, sbSspt, henkanTuuka.henkanTuukaTypeToKbn(sbSspt.getType()));

                    }
                }

                sbSspt = sbSspt.round(-4, RoundingMode.FLOOR).divide(10000);


                BizCurrency jissituHosyouS = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));

                if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {

                    jissituHosyouS = keisanSbS.subtract(syukeiyakuP);

                }
                else {

                    jissituHosyouS = keisanSbS;

                }

                if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(jissituHosyouS.getType()))) {

                    jissituHosyouS = getKiteiCheckYenkansangk.exec(kwsrateKijyunYmd, jissituHosyouS, henkanTuuka.henkanTuukaTypeToKbn(jissituHosyouS.getType()));

                }

                jissituHosyouS = jissituHosyouS.round(-4, RoundingMode.FLOOR).divide(10000);

                int bmi = 0;

                if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn())) {

                    if (kokutisyo.getSintyou().compareTo(0) != 0 && kokutisyo.getTaijyuu().compareTo(0) != 0) {

                        BizNumber sintyou = BizNumber.valueOf(kokutisyo.getSintyou());
                        BizNumber sintyoukeisuu = BizNumber.valueOf(100);
                        BizNumber taiju = BizNumber.valueOf(kokutisyo.getTaijyuu());

                        sintyou = sintyou.divide(sintyoukeisuu, 2, RoundingMode.HALF_UP);
                        BizNumber sintyou2 = sintyou.multiply(sintyou);
                        BizNumber bmiti = taiju.divide(sintyou2, 1, RoundingMode.HALF_UP);

                        BizNumber bmihoseikeisuu = BizNumber.valueOf(10);
                        BizNumber hoseibmiti = bmiti.multiply(bmihoseikeisuu);
                        String bmistr = hoseibmiti.toString();
                        bmi = Integer.parseInt(bmistr);
                    }
                }

                BizCurrency teikisiharaikinManen = BizCurrency.valueOf(0,  BizCurrencyTypes.YEN);

                if ( mosSyouhnSyu != null && C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn())) {

                    teikisiharaikinManen = getKiteiCheckYenkansangk.exec(kwsrateKijyunYmd , mosSyouhnSyu.getTeikisiharaikin(),
                        henkanTuuka.henkanTuukaTypeToKbn(mosSyouhnSyu.getTeikisiharaikin().getType()));

                    teikisiharaikinManen = teikisiharaikinManen.round(-4, RoundingMode.FLOOR).divide(10000);
                }

                ZT_IsaToukeiDataTy isaToukeiDataTy = new ZT_IsaToukeiDataTy();

                isaToukeiDataTy.setZtymosno(editStringZero(syoriCTL.getMosno(),9));

                isaToukeiDataTy.setZtysyono(editStringZero(syoriCTL.getSyono(),11));

                if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn()) ||
                    C_SntkhouKbn.SYOKUGYOU.eq(mosKihon.getSntkhoukbn()) ||
                    C_SntkhouKbn.NONE.eq(mosKihon.getSntkhoukbn())) {

                    isaToukeiDataTy.setZtyhjykktkbn("2");
                }
                else {
                    isaToukeiDataTy.setZtyhjykktkbn("0");
                }

                isaToukeiDataTy.setZtyhknsyuruicd(editStringZero(syouhnZokusei.getIsatoukeihokensyuruicd().getValue(),2));

                if (C_Hrkkaisuu.BLNK.eq(mosKihon.getHrkkaisuu())) {
                    isaToukeiDataTy.setZtyhrkhuhukbn("0");
                }
                else if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                    isaToukeiDataTy.setZtyhrkhuhukbn("4");
                }
                else {
                    if (C_Hrkkeiro.CREDIT.eq(mosKihon.getHrkkeiro())){
                        isaToukeiDataTy.setZtyhrkhuhukbn("6");
                    }
                    else {
                        isaToukeiDataTy.setZtyhrkhuhukbn("2");
                    }
                }

                if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {

                    if (C_Ketkekkacd.ENKI_SIJINASI.eq(dakuhiKettei.getKetkekkacd()) ||
                        C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(dakuhiKettei.getKetkekkacd())) {

                        isaToukeiDataTy.setZtymossyoumetukbn("3");
                    }
                    else if (C_Ketkekkacd.MIAWASE.eq(dakuhiKettei.getKetkekkacd())) {

                        isaToukeiDataTy.setZtymossyoumetukbn("2");
                    }
                    else {

                        isaToukeiDataTy.setZtymossyoumetukbn("0");
                    }
                }
                else if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {

                    isaToukeiDataTy.setZtymossyoumetukbn("1");
                }
                else {

                    isaToukeiDataTy.setZtymossyoumetukbn("0");
                }

                isaToukeiDataTy.setZtymusymd(editStringZero(mosKihon.getMosymd(), 8));

                isaToukeiDataTy.setZtymosym(editStringZero(mosKihon.getMosym(),6));

                isaToukeiDataTy.setZtybsyym(editStringZero(mosKihon.getBosyuuym(),6));

                isaToukeiDataTy.setZtyaatukaisosikicd(editStringZero(mosDairitenLst.get(0).getDrtenkanrisosikicd(),7));

                isaToukeiDataTy.setZtyaatukaikojincd(editStringZero(mosDairitenLst.get(0).getDaibosyuucd(),6));

                isaToukeiDataTy.setZtyhhknnen3(editStringZero(mosKihon.getHhknnen(), 3));

                if (C_Hhknsei.MALE.eq(mosKihon.getHhknsei())) {

                    isaToukeiDataTy.setZtyhhknseikbn("1");
                }
                else if (C_Hhknsei.FEMALE.eq(mosKihon.getHhknsei())) {

                    isaToukeiDataTy.setZtyhhknseikbn("2");
                }
                else{
                    isaToukeiDataTy.setZtyhhknseikbn("0");
                }

                if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

                    isaToukeiDataTy.setZtykyktuuka("1");
                }
                else if (C_Tuukasyu.USD.eq(mosKihon.getKyktuukasyu())) {

                    isaToukeiDataTy.setZtykyktuuka("2");
                }
                else if (C_Tuukasyu.EUR.eq(mosKihon.getKyktuukasyu())) {

                    isaToukeiDataTy.setZtykyktuuka("3");
                }
                else if (C_Tuukasyu.AUD.eq(mosKihon.getKyktuukasyu())) {

                    isaToukeiDataTy.setZtykyktuuka("4");
                }
                else{
                    isaToukeiDataTy.setZtykyktuuka("0");

                }
                isaToukeiDataTy.setZtysibous7(new BigDecimal(sbSspt.toString()).intValue());

                isaToukeiDataTy.setZtydakuhikettisyacd(editStringZero(dakuhiKettei.getPalketsyacd(),2));

                isaToukeiDataTy.setZtydkhktiymd(editStringZero(dakuhiKettei.getKetymd(),8));

                if (C_Ketkekkacd.MUJYOUKEN.eq(dakuhiKettei.getKetkekkacd())) {

                    isaToukeiDataTy.setZtydakuhikettikekkacd("10");

                    isaToukeiDataTy.setZtysyukykktkekkacd("10");

                    isaToukeiDataTy.setZtysyokaiktidkhktikekkacd("10");

                    isaToukeiDataTy.setZtysyokaiktsyukykktkekkacd("10");
                }
                else if (C_Ketkekkacd.GENKAITAI_SYOUDAKU.eq(dakuhiKettei.getKetkekkacd())) {

                    isaToukeiDataTy.setZtydakuhikettikekkacd("13");

                    isaToukeiDataTy.setZtysyukykktkekkacd("13");

                    isaToukeiDataTy.setZtysyokaiktidkhktikekkacd("13");

                    isaToukeiDataTy.setZtysyokaiktsyukykktkekkacd("13");
                }
                else if (C_Ketkekkacd.ENKI_SIJINASI.eq(dakuhiKettei.getKetkekkacd())) {

                    isaToukeiDataTy.setZtydakuhikettikekkacd("70");

                    isaToukeiDataTy.setZtysyukykktkekkacd("70");

                    isaToukeiDataTy.setZtysyokaiktidkhktikekkacd("70");

                    isaToukeiDataTy.setZtysyokaiktsyukykktkekkacd("70");
                }
                else if (C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(dakuhiKettei.getKetkekkacd())) {

                    isaToukeiDataTy.setZtydakuhikettikekkacd("75");

                    isaToukeiDataTy.setZtysyukykktkekkacd("75");

                    isaToukeiDataTy.setZtysyokaiktidkhktikekkacd("75");

                    isaToukeiDataTy.setZtysyokaiktsyukykktkekkacd("75");
                }
                else if (C_Ketkekkacd.MIAWASE.eq(dakuhiKettei.getKetkekkacd())) {

                    isaToukeiDataTy.setZtydakuhikettikekkacd("80");

                    isaToukeiDataTy.setZtysyukykktkekkacd("80");

                    isaToukeiDataTy.setZtysyokaiktidkhktikekkacd("80");

                    isaToukeiDataTy.setZtysyokaiktsyukykktkekkacd("80");
                }
                else {

                    isaToukeiDataTy.setZtydakuhikettikekkacd("00");

                    isaToukeiDataTy.setZtysyukykktkekkacd("00");

                    isaToukeiDataTy.setZtysyokaiktidkhktikekkacd("00");

                    isaToukeiDataTy.setZtysyokaiktsyukykktkekkacd("00");
                }
                isaToukeiDataTy.setZtydakuhiketteiriyuucdx1(editStringZero(dakuhiKettei.getKetriyuucd1().getValue(),2));

                isaToukeiDataTy.setZtydakuhiketteiriyuucdx2(editStringZero(dakuhiKettei.getKetriyuucd2().getValue(),2));

                isaToukeiDataTy.setZtydakuhiketteiriyuucdx3(editStringZero(dakuhiKettei.getKetriyuucd3().getValue(),2));

                isaToukeiDataTy.setZtydakuhiketteiriyuucdx4(editStringZero(dakuhiKettei.getKetriyuucd4().getValue(),2));

                if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn())) {

                    isaToukeiDataTy.setZtysntyo3(editStringZero(kokutisyo.getSintyou(),3));

                    isaToukeiDataTy.setZtytijyuu3(editStringZero(kokutisyo.getTaijyuu(),3));
                }
                else {
                    isaToukeiDataTy.setZtysntyo3("000");

                    isaToukeiDataTy.setZtytijyuu3("000");
                }

                isaToukeiDataTy.setZtybmi(bmi);

                if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn())) {

                    if (C_KokutiKbn.KANIKOKUTI.eq(syouhnZokusei.getKokutikbn())) {

                        isaToukeiDataTy.setZtysinsahouhou("14");

                        isaToukeiDataTy.setZtysyokaiktisinsahouhou("14");
                    }
                    else {

                        isaToukeiDataTy.setZtysinsahouhou("08");

                        isaToukeiDataTy.setZtysyokaiktisinsahouhou("08");
                    }
                }
                else if (C_SntkhouKbn.SYOKUGYOU.eq(mosKihon.getSntkhoukbn())) {

                    isaToukeiDataTy.setZtysinsahouhou("17");

                    isaToukeiDataTy.setZtysyokaiktisinsahouhou("17");
                }
                else {

                    isaToukeiDataTy.setZtysinsahouhou("21");

                    isaToukeiDataTy.setZtysyokaiktisinsahouhou("21");
                }

                isaToukeiDataTy.setZtysyoubyoucd1(editStringZero(dakuhiKettei.getSyoubyoucd1(),6));

                if (dakuhiKettei.getKantiym1() != null && dakuhiKettei.getKetymd() != null && BizDateUtil.compareYm(
                    dakuhiKettei.getKetymd().getBizDateYM(), dakuhiKettei.getKantiym1()) == BizDateUtil.COMPARE_GREATER) {

                    isaToukeiDataTy.setZtykeikanensuux1(editStringZero(dakuhiKettei.getKetymd().getYear() -
                        dakuhiKettei.getKantiym1().getYear(),2));
                }
                else {

                    isaToukeiDataTy.setZtykeikanensuux1("00");
                }

                isaToukeiDataTy.setZtysyoubyoucd2(editStringZero(dakuhiKettei.getSyoubyoucd2(),6));

                if (dakuhiKettei.getKantiym2() != null && dakuhiKettei.getKetymd() != null && BizDateUtil.compareYm(
                    dakuhiKettei.getKetymd().getBizDateYM(), dakuhiKettei.getKantiym2()) == BizDateUtil.COMPARE_GREATER) {

                    isaToukeiDataTy.setZtykeikanensuux2(editStringZero(dakuhiKettei.getKetymd().getYear() -
                        dakuhiKettei.getKantiym2().getYear(),2));
                }
                else {

                    isaToukeiDataTy.setZtykeikanensuux2("00");
                }

                if (C_SkeijimuKbn.TIGINSINKIN.eq(syoriCTL.getSkeijimukbn()) ||
                    C_SkeijimuKbn.SMBC.eq(syoriCTL.getSkeijimukbn()) ||
                    C_SkeijimuKbn.SMTB.eq(syoriCTL.getSkeijimukbn()) ||
                    C_SkeijimuKbn.MIZUHO.eq(syoriCTL.getSkeijimukbn())) {

                    isaToukeiDataTy.setZtyhanbaikeirokbn("3");
                }
                else if (C_SkeijimuKbn.SHOP.eq(syoriCTL.getSkeijimukbn())) {

                    isaToukeiDataTy.setZtyhanbaikeirokbn("5");
                }
                else {

                    isaToukeiDataTy.setZtyhanbaikeirokbn("0");
                }

                isaToukeiDataTy.setZtyjissituhosyous(new BigDecimal(jissituHosyouS.toString()).intValue());

                isaToukeiDataTy.setZtyoyadairitencd(editStringZero(mosDairitenLst.get(0).getOyadrtencd(),7));

                isaToukeiDataTy.setZtynensyuukbn(editStringZero(mosKihon.getHhknnensyuukbn().getValue(),1));

                isaToukeiDataTy.setZtysykgycd(editStringZero(mosKihon.getHhknsykgycd(),3));

                if (C_Tkhukaumu.HUKA.eq(mosKihon.getSyksbyensitihsyutkhkkbn())) {
                    isaToukeiDataTy.setZtysyksbyensitihsyutyhkumu("1");
                }
                else {
                    isaToukeiDataTy.setZtysyksbyensitihsyutyhkumu("0");
                }

                if (C_Tkhukaumu.HUKA.eq(mosKihon.getJyudkaigomehrtkhkkbn())) {
                    isaToukeiDataTy.setZtyjyudkaigomehrtkhkumu("1");
                }
                else {
                    isaToukeiDataTy.setZtyjyudkaigomehrtkhkumu("0");
                }

                isaToukeiDataTy.setZtykykymd(editStringZero(mosKihon.getKykymd(), 8));

                if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {
                    if (C_BlnktkumuKbn.ARI.eq(mosKihon.getZenkizennouumu())) {
                        isaToukeiDataTy.setZtyijitoukeizennoukbn("1");
                    }
                    else if (C_BlnktkumuKbn.NONE.eq(mosKihon.getZenkizennouumu())) {
                        isaToukeiDataTy.setZtyijitoukeizennoukbn("2");
                    }
                    else {
                        isaToukeiDataTy.setZtyijitoukeizennoukbn("0");
                    }
                }
                else {
                    isaToukeiDataTy.setZtyijitoukeizennoukbn("0");
                }

                if (mosSyouhnSyu != null) {

                    isaToukeiDataTy.setZtydai1hknkkn(editStringZero(mosSyouhnSyu.getDai1hknkkn(), 2));
                }
                else {

                    isaToukeiDataTy.setZtydai1hknkkn(editStringZero(null, 2));
                }

                if (mosSyouhnSyu != null && C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn())) {
                    if (mosSyouhnSyu.getHknkkn() == 5) {
                        isaToukeiDataTy.setZtyijitoukeitikshrtkykkbn("1");
                    }
                    else if (mosSyouhnSyu.getHknkkn() == 10) {
                        isaToukeiDataTy.setZtyijitoukeitikshrtkykkbn("2");
                    }
                    else {
                        isaToukeiDataTy.setZtyijitoukeitikshrtkykkbn("0");
                    }
                }
                else {
                    isaToukeiDataTy.setZtyijitoukeitikshrtkykkbn("0");
                }

                isaToukeiDataTy.setZtyteikisiharaikinmanen(new BigDecimal(teikisiharaikinManen.toString()).intValue());

                BizPropertyInitializer.initialize(isaToukeiDataTy);

                isaToukeiDataTyLst.add(isaToukeiDataTy);

                syoriKensuu++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "医査統計作成"));

    }

    private String editStringZero(Object pObject, int pMaxKeta) {

        if (pObject != null && pObject.toString().length() == pMaxKeta) {
            return pObject.toString();
        }
        else if (pObject == null || pObject.toString().length() == 0) {
            return Strings.padStart("", pMaxKeta, '0');
        }
        else {
            return Strings.padStart(pObject.toString(), pMaxKeta, '0');

        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}