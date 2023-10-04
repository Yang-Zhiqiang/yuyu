package yuyu.batch.sinkeiyaku.skijitoukei.skijitoukeimeisaisks;

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
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetAdrData;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.sinkeiyaku.skcommon.EditIjitoukeiS;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_IjitoukeiKaijyoKbn;
import yuyu.def.classification.C_IjitoukeiTikShrTkykKbn;
import yuyu.def.classification.C_IjitoukeiZennouKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_DakuhiKettei;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 医事統計 医事統計明細作成
 */
public class SkIjiToukeiMeisaiSksBatch implements Batch {

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

        String tysyttaisyouTableID = "HT_SyoriCTL";
        String recoveryFilterID = "Sk001";
        long syoriKensu = 0;
        BizDateYM tysytTaisyouYm = syoriYmd.getBizDateYM().addMonths(-3);
        SortHT_DakuhiKettei sortHTDakuhiKettei = SWAKInjector.getInstance(SortHT_DakuhiKettei.class);
        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);
        BzGetAdrData bzGetAdrData = SWAKInjector.getInstance(BzGetAdrData.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        EditIjitoukeiS editIjitoukeiS = SWAKInjector.getInstance(EditIjitoukeiS.class);

        try (EntityInserter<HT_IjitoukeiMeisai> isaToukeiDataTy = new EntityInserter<>();
            ExDBResults<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager
                .getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(
                    kakutyouJobCd, tysytTaisyouYm)) {
            for (HT_SyoriCTL syoriCTL : syoriCTLLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(tysyttaisyouTableID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryFilterID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoriCTL.getMosno());

                List<HT_IjitoukeiMeisai> ijitoukeiMeisaiLst = sinkeiyakuDomManager
                    .getIjitoukeiMeisaisBySyono(syoriCTL.getSyono());

                if (ijitoukeiMeisaiLst.size() > 0) {
                    batchLogger.error(MessageUtil.getMessage(MessageId.EBF0130, "証券番号：" + syoriCTL.getSyono()));
                    continue;
                }

                HT_MosKihon mosKihon = syoriCTL.getMosKihon();
                BizDate kwsratekjymd = mosKihon.getMosymd();
                List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
                List<HT_MosSyouhn> mossyouhnLst = syoriCTL.getMosSyouhns();
                HT_MosSyouhn mossyouhnSyukeiyaku = new HT_MosSyouhn();
                List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
                HT_Kokutisyo kokutisyo = syoriCTL.getKokutisyo();

                HT_DakuhiKettei dakuhiKettei = sortHTDakuhiKettei.OrderHT_DakuhiKetteiByPkDesc(
                    syoriCTL.getDakuhiKetteis()).get(0);

                for (HT_MosSyouhn mossyouhn : mossyouhnLst) {
                    if (C_SyutkKbn.SYU.eq(mossyouhn.getSyutkkbn())) {
                        mossyouhnSyukeiyaku = mossyouhn;
                        break;
                    }
                }
                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(mossyouhnSyukeiyaku.getSyouhncd(),
                    mossyouhnSyukeiyaku.getSyouhnsdno());

                BizCurrency sbus = null;
                BizCurrency sbumanen = null;
                BizCurrency seitoukihons = mossyouhnSyukeiyaku.getSeitoukihons();
                BizCurrency seitoukihonsmanen = null;
                BizCurrency syutkp = mossyouhnSyukeiyaku.getSyutkp();
                BizCurrency syutkpmanen = null;
                BizNumber yenkansantkykwsrate = null;
                C_IjitoukeiZennouKbn ijitoukeizennoukbn = C_IjitoukeiZennouKbn.BLNK;
                C_TkiktbrisyuruiKbn tkiktbsyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu());

                if (C_ErrorKbn.OK.eq(editIjitoukeiS.sinkeiyakuEdit(mosKihon, mossyouhnLst))){

                    sbus = editIjitoukeiS.getSibouS();
                    sbumanen = getKiteiCheckYenkansangk.exec(kwsratekjymd, sbus, henkanTuuka.henkanTuukaTypeToKbn(sbus.getType()));

                    sbumanen = sbumanen.round(-4, RoundingMode.HALF_UP).divide(10000);
                    sbumanen = BizCurrency.valueOf(new BigDecimal(sbumanen.toString()), BizCurrencyTypes.MANYEN);

                }
                else {
                    sbus = BizCurrency.valueOf(0, currencyType);
                    sbumanen = BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN);
                }

                if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                    seitoukihonsmanen = getKiteiCheckYenkansangk.exec(kwsratekjymd, seitoukihons,
                        mosKihon.getKyktuukasyu());
                    yenkansantkykwsrate = getKiteiCheckYenkansangk.getKijyungkHanteiyouKawaseRate();
                    syutkpmanen = getKiteiCheckYenkansangk.exec(kwsratekjymd, syutkp, mosKihon.getKyktuukasyu());
                }
                else {
                    seitoukihonsmanen = seitoukihons;
                    syutkpmanen = syutkp;
                    yenkansantkykwsrate = BizNumber.valueOf(0);
                }
                seitoukihonsmanen = seitoukihonsmanen.round(-4, RoundingMode.FLOOR).divide(10000);
                seitoukihonsmanen = BizCurrency.valueOf(new BigDecimal(seitoukihonsmanen.toString()),
                    BizCurrencyTypes.MANYEN);
                syutkpmanen = syutkpmanen.round(-4, RoundingMode.FLOOR).divide(10000);
                syutkpmanen = BizCurrency.valueOf(new BigDecimal(syutkpmanen.toString()), BizCurrencyTypes.MANYEN);

                String hhknYno = mosKihon.getTsinyno();
                if (C_TsindousiteiKbn.BLNK.eq(mosKihon.getTsindousiteikbn())) {
                    hhknYno = mosKihon.getHhknyno();
                }

                bzGetAdrData.execTodouhukenCdByPostalcd(hhknYno);
                C_TodouhukenKbn todouhukenKbn = bzGetAdrData.getTodouhukenCd();

                if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())){
                    if (C_BlnktkumuKbn.ARI.eq(mosKihon.getZenkizennouumu())){

                        ijitoukeizennoukbn = C_IjitoukeiZennouKbn.ZENKIZENNOU;

                    }
                    else{

                        ijitoukeizennoukbn = C_IjitoukeiZennouKbn.ITIBUZENNOU;

                    }
                }
                else{

                    ijitoukeizennoukbn = C_IjitoukeiZennouKbn.BLNK;

                }

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getTeikiikkatubaraiumu())){
                    if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(mosKihon.getIkkatubaraikbn())){
                        if (C_IkkatubaraiKaisuuKbn.IKKATU6.eq(mosKihon.getIkkatubaraikaisuu())){

                            tkiktbsyuruikbn = C_TkiktbrisyuruiKbn.TEIKI_6MONTHS;

                        }
                        else if (C_IkkatubaraiKaisuuKbn.IKKATU12.eq(mosKihon.getIkkatubaraikaisuu())){

                            tkiktbsyuruikbn = C_TkiktbrisyuruiKbn.TEIKI_12MONTHS;

                        }
                    }
                    else{

                        tkiktbsyuruikbn = C_TkiktbrisyuruiKbn.NONE;

                    }
                }
                else{

                    tkiktbsyuruikbn = C_TkiktbrisyuruiKbn.BLNK;

                }

                BizCurrency teikisiharaikinmanen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                if (C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn())) {
                    teikisiharaikinmanen = getKiteiCheckYenkansangk.exec(kwsratekjymd,
                        mossyouhnSyukeiyaku.getTeikisiharaikin(),
                        henkanTuuka.henkanTuukaTypeToKbn(mossyouhnSyukeiyaku.getTeikisiharaikin().getType()));
                    teikisiharaikinmanen = teikisiharaikinmanen.round(-4, RoundingMode.FLOOR).divide(10000);
                    teikisiharaikinmanen = BizCurrency.valueOf(new BigDecimal(teikisiharaikinmanen.toString()),
                        BizCurrencyTypes.MANYEN);
                }

                HT_IjitoukeiMeisai ijitoukeiMeisai = new HT_IjitoukeiMeisai();
                ijitoukeiMeisai.setSyono(syoriCTL.getSyono());
                ijitoukeiMeisai.setRenno8keta(1);
                ijitoukeiMeisai.setBosyuuym(mosKihon.getBosyuuym());
                ijitoukeiMeisai.setKykymd(mosKihon.getKykymd());
                ijitoukeiMeisai.setSknnkaisiymd(mosKihon.getSknnkaisiymd());
                ijitoukeiMeisai.setSntkhoukbn(mosKihon.getSntkhoukbn());
                ijitoukeiMeisai.setKokutikbn(syouhnZokusei.getKokutikbn());
                ijitoukeiMeisai.setSkeijimukbn(syoriCTL.getSkeijimukbn());
                ijitoukeiMeisai.setSirajikykkbn(nayoseKekkaLst.get(0).getSirajikykkbn());
                ijitoukeiMeisai.setHrkkaisuu(mosKihon.getHrkkaisuu());
                ijitoukeiMeisai.setHaitoukinuketorihoukbn(mosKihon.getHaitoukinuketorihoukbn());
                ijitoukeiMeisai.setOyadrtencd(mosDairitenLst.get(0).getOyadrtencd());
                ijitoukeiMeisai.setAatsukaishasoshikicd(mosDairitenLst.get(0).getDrtenkanrisosikicd());
                ijitoukeiMeisai.setAatukaikojincd(mosDairitenLst.get(0).getDaibosyuucd());
                ijitoukeiMeisai.setTratkiagcd(mosDairitenLst.get(0).getTratkiagcd());
                if (mosDairitenLst.size() > 1) {
                    ijitoukeiMeisai.setBosyuudairitenatkikeitaikbn(C_BosyuuDairitenAtkiKeitaiKbn.DAIRITENKYOUDOU);
                }
                else {
                    ijitoukeiMeisai.setBosyuudairitenatkikeitaikbn(C_BosyuuDairitenAtkiKeitaiKbn.TANDOKU);
                }
                ijitoukeiMeisai.setHhknnen(mosKihon.getHhknnen());
                ijitoukeiMeisai.setHhknsei(mosKihon.getHhknsei());
                ijitoukeiMeisai.setHhknyno(hhknYno);
                ijitoukeiMeisai.setHhkntodouhukencd(todouhukenKbn.getValue());
                ijitoukeiMeisai.setHhknnensyuukbn(mosKihon.getHhknnensyuukbn());
                ijitoukeiMeisai.setHhknsykgycd(mosKihon.getHhknsykgycd());
                if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn())) {
                    ijitoukeiMeisai.setSintyou(kokutisyo.getSintyou());
                    ijitoukeiMeisai.setTaijyuu(kokutisyo.getTaijyuu());
                    ijitoukeiMeisai.setKituenkbn(kokutisyo.getKituenkbn());
                    ijitoukeiMeisai.setKituenhon(kokutisyo.getKituenhon());
                }
                ijitoukeiMeisai.setKyktuukasyu(mosKihon.getKyktuukasyu());
                ijitoukeiMeisai.setHrktuukasyu(mosKihon.getHrktuukasyu());
                ijitoukeiMeisai.setSyouhncd(mossyouhnSyukeiyaku.getSyouhncd());
                ijitoukeiMeisai.setSyouhnsdno(mossyouhnSyukeiyaku.getSyouhnsdno());
                ijitoukeiMeisai.setSeitoukihons(seitoukihons);
                ijitoukeiMeisai.setSeitoukihonsmanen(seitoukihonsmanen);
                ijitoukeiMeisai.setSyutkp(syutkp);
                ijitoukeiMeisai.setSyutkpmanen(syutkpmanen);
                ijitoukeiMeisai.setImustiyusbus(sbus);
                ijitoukeiMeisai.setImustiyusbusmanen(sbumanen);
                ijitoukeiMeisai.setYenkansantkykwsrate(yenkansantkykwsrate);
                ijitoukeiMeisai.setSyoubyoucd1(dakuhiKettei.getSyoubyoucd1());
                ijitoukeiMeisai.setSyoubyoucd2(dakuhiKettei.getSyoubyoucd2());
                ijitoukeiMeisai.setDakuhiktkekkacd(dakuhiKettei.getKetkekkacd());
                ijitoukeiMeisai.setDakuhiketsyacd(dakuhiKettei.getKetsyacd());
                ijitoukeiMeisai.setPalketsyacd(dakuhiKettei.getPalketsyacd());
                ijitoukeiMeisai.setSyksbyensitihsyutkhkkbn(mosKihon.getSyksbyensitihsyutkhkkbn());
                ijitoukeiMeisai.setJyudkaigomehrtkhkkbn(mosKihon.getJyudkaigomehrtkhkkbn());
                ijitoukeiMeisai.setIjitoukeikaijyokbn(C_IjitoukeiKaijyoKbn.BLNK);
                ijitoukeiMeisai.setIjitoukeizennoukbn(ijitoukeizennoukbn);
                ijitoukeiMeisai.setHrkkeiro(mosKihon.getHrkkeiro());
                ijitoukeiMeisai.setTikiktbrisyuruikbn(tkiktbsyuruikbn);
                ijitoukeiMeisai.setDai1hknkkn(mossyouhnSyukeiyaku.getDai1hknkkn());
                if (C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn())) {
                    if (mossyouhnSyukeiyaku.getHknkkn() == 5) {
                        ijitoukeiMeisai.setIjitoukeitikshrtkykkbn(C_IjitoukeiTikShrTkykKbn.TOKUYAKUARISUEOKI5);
                    }
                    else if (mossyouhnSyukeiyaku.getHknkkn() == 10) {
                        ijitoukeiMeisai.setIjitoukeitikshrtkykkbn(C_IjitoukeiTikShrTkykKbn.TOKUYAKUARISUEOKI10);
                    }
                    else{
                        ijitoukeiMeisai.setIjitoukeitikshrtkykkbn(C_IjitoukeiTikShrTkykKbn.BLNK);
                    }
                }
                else{
                    ijitoukeiMeisai.setIjitoukeitikshrtkykkbn(C_IjitoukeiTikShrTkykKbn.BLNK);
                }
                ijitoukeiMeisai.setTeikisiharaikin(mossyouhnSyukeiyaku.getTeikisiharaikin());
                ijitoukeiMeisai.setTeikisiharaikinmanen(teikisiharaikinmanen);
                ijitoukeiMeisai.setGyoumuKousinTime(gyoumuKousinTime);
                BizPropertyInitializer.initialize(ijitoukeiMeisai);
                isaToukeiDataTy.add(ijitoukeiMeisai);

                syoriKensu = syoriKensu + 1;
            }
        }
        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensu), "医事統計明細作成"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {
        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
