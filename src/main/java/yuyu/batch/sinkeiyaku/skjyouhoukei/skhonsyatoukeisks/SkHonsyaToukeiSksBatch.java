package yuyu.batch.sinkeiyaku.skjyouhoukei.skhonsyatoukeisks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_FatcakakkekkaKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_ImusateikaniyhKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_Knkysatei1jiyhKbn;
import yuyu.def.classification.C_Knkysatei2jiyhKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykkakkekKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_KzmeigitknKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SentakuJyouhou;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.db.entity.ZT_HonsyaToukeiTy;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_MosSyouhn;
import yuyu.def.sinkeiyaku.sorter.SortHT_Uketorinin;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 新契約 情報系 本社統計情報作成
 */
public class SkHonsyaToukeiSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzKbnHenkanUtil bzKbnHenkanUtil;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyouJobCode = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCode));

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        long syoriKensuu = 0;

        String tableId = "HT_SyoriCTL";

        String recoveryFilterId = "Sk001";

        SortHT_MosSyouhn sortHT_MosSyouhn = SWAKInjector.getInstance(SortHT_MosSyouhn.class);

        SortHT_Uketorinin sortHT_Uketorinin = SWAKInjector.getInstance(SortHT_Uketorinin.class);

        try (EntityInserter<ZT_HonsyaToukeiTy> hnsyaToukeiTyLst = new EntityInserter<>()) {

            GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            try (ExDBResults<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosym(
                kakutyouJobCode, syoriYmd.getBizDateYM().addMonths(-2), syoriYmd.getBizDateYM())) {
                Iterator<HT_SyoriCTL> syoriCTLTemp = syoriCTLLst.iterator();

                if (syoriCTLTemp.hasNext()) {
                    while (syoriCTLTemp.hasNext()) {

                        HT_SyoriCTL syoriCTL = syoriCTLTemp.next();

                        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCode);

                        bzRecoveryDatasikibetuBean.setIbTableid(tableId);

                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryFilterId);

                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoriCTL.getMosno());

                        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();

                        mosSyouhnLst = sortHT_MosSyouhn.OrderHT_MosSyouhnByBM_SyouhnZokuseiSyutkkbnSyohnsortnoAsc(
                            mosSyouhnLst);

                        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();

                        List<HT_Uketorinin> uketorininSbuktLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.SBUKT);

                        uketorininSbuktLst = sortHT_Uketorinin.OrderHT_UketorininByUktbnwariDescUktsyurennoAsc(
                            uketorininSbuktLst);

                        List<HT_Uketorinin> uketorininStdrskLst = syoriCTL.getUketorininsByUktsyukbn(
                            C_UktsyuKbn.STDRSK);

                        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteisByKetkekkacds();

                        Integer maxNo = sinkeiyakuDomManager.getHenteiRirekiMaxRennoByMosno(syoriCTL.getMosno());

                        if (maxNo == null) {
                            maxNo = 0;
                        }

                        Long count = sinkeiyakuDomManager.getKmTsRirekiDistinctSyoriTimeCountByMosno(
                            syoriCTL.getMosno());

                        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTL.getKnksateiRirekisByKnksateikekkakbn();

                        List<HT_ImusateiRireki> imusateiRirekiLst =
                            syoriCTL.getImusateiRirekisByImusateikekkakbn(C_SyorikekkaKbn.KANRYOU);

                        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();

                        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkasBySignalsetteiumukbn();

                        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();

                        BizDate minNyuukinYmd =
                            sinkeiyakuDomManager.getNyuukinMinNyksyoriymdByMosnoZenhnknkbn(syoriCTL.getMosno());

                        HT_KykKak kykKak = sinkeiyakuDomManager.getKykKakByMosnoMaxRenno(syoriCTL.getMosno());

                        List<HT_HubiMsg> hubiMsgKzhuriLst = syoriCTL
                            .getHubiMsgsByHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.KOUHURIKZMEIGIKYKBETUHUBI);

                        List<HT_HubiMsg> hubiMsgDebitnykLst = syoriCTL
                            .getHubiMsgsByHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.DEBITNYKKZMEIGIKYKBETUHUBI);

                        HT_Tokunin tokunin = syoriCTL.getTokunin();

                        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();

                        List<HT_Uketorinin> uketorininKykLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.KYKDRN);

                        List<HT_MosTrkKzk> mosTrkKzkLst = syoriCTL.getMosTrkKzks();

                        syoriKensuu = syoriKensuu + 1;

                        editPalRenkeiKoumoku.getSyuEntity(mosSyouhnLst);

                        HT_MosSyouhn mosSyouhnPsyu = editPalRenkeiKoumoku.getMosSyouhn();

                        BM_SyouhnZokusei syouhnZokuseiPsyu = editPalRenkeiKoumoku.getSyouhnZokusei();

                        if (mosSyouhnPsyu == null) {
                            mosSyouhnPsyu = new HT_MosSyouhn();
                        }

                        if (syouhnZokuseiPsyu == null) {
                            syouhnZokuseiPsyu = new BM_SyouhnZokusei();
                        }

                        editPalRenkeiKoumoku.editDakuhiKetteiKanrenKoumoku(dakuhiKetteiLst);

                        C_Ketkekkacd saisinKetkekkaCd = editPalRenkeiKoumoku.getSaisinKetkekkaCd();

                        C_TorikesisyousairiyuuCd saisinTorikeSisyousaiRiyuuCd =
                            editPalRenkeiKoumoku.getSaisinTorikesiSyousaiRiyuuCd();

                        String saisinPlaKetsyaCd = editPalRenkeiKoumoku.getSaisinPalKetsyaCd();

                        C_Ketkekkacd dakuhiKetSaisinKetKekkaCd = editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd();

                        BizDate dakuhiKetSaisinKetteiYmd = editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiYmd();

                        C_Ketriyuucd dakuhiKetSaisinKetKekkaCd1 = editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd1();

                        C_Ketriyuucd dakuhiKetSaisinKetKekkaCd2 = editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd2();

                        C_Ketriyuucd dakuhiKetSaisinKetKekkaCd3 = editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd3();

                        C_Ketriyuucd dakuhiKetSaisinKetKekkaCd4 = editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd4();

                        List<C_Ketkekkacd> dakuhiKetSaisinKetKekkaCdLst =
                            editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst();

                        List<String> dakuhiKetSaisinKetteiMdLst = editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst();

                        BizDate yenKijyunymd = editPalRenkeiKoumoku.getEnknsnKijyunYmd(mosKihon.getKyktuukasyu(),
                            syoriCTL.getRyosyuymd(), mosKihon.getMosymd());

                        BizNumber yenKansantkykwsrate = editPalRenkeiKoumoku.getEnknsnKawaseRate(
                            mosKihon.getKyktuukasyu(), yenKijyunymd, mosKihon.getHrkkaisuu(),
                            mosKihon.getZennoumousideumu(), mosKihon.getIkkatubaraikbn());

                        BizCurrency yenHaraikomip = BizCurrency.valueOf(0);
                        CurrencyType kykCurrencyType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu());
                        BizCurrency siteituukaHaraikomip = BizCurrency.valueOf(0, kykCurrencyType);

                        if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

                            yenHaraikomip = mosKihon.getFstphrkgk();
                        }

                        else {
                            if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                                if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokuseiPsyu.getPtratkituukasiteikbn())) {

                                    yenHaraikomip = mosKihon.getMosfstpkei();
                                }
                                else {
                                    yenHaraikomip = mosKihon.getHrktuukafstphrkgk();
                                }
                            }
                            else {
                                if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokuseiPsyu.getPtratkituukasiteikbn())
                                    && !mosKihon.getHrktuukasyu().eq(mosKihon.getKyktuukasyu())){
                                    siteituukaHaraikomip = mosKihon.getSeitoufstpkei();
                                }
                                else {
                                    siteituukaHaraikomip = mosKihon.getFstphrkgk();
                                }
                                yenHaraikomip = keisanGaikakanzan.exec(C_Tuukasyu.JPY, siteituukaHaraikomip,
                                    yenKansantkykwsrate, C_HasuusyoriKbn.SUTE);
                            }
                        }

                        BizCurrency seitoukihonsPsyu = BizCurrency.valueOf(0);

                        BizCurrency seitoukihonsPgk = BizCurrency.valueOf(0);

                        for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
                            if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                                BizCurrency kansan = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                    mosSyouhn.getSeitoukihons(), yenKansantkykwsrate, C_HasuusyoriKbn.SUTE);
                                seitoukihonsPgk = seitoukihonsPgk.add(kansan);

                                if (C_SyutkKbn.SYU.eq(mosSyouhn.getSyutkkbn())) {
                                    seitoukihonsPsyu = kansan;
                                }
                            }

                            else {
                                seitoukihonsPgk = seitoukihonsPgk.add(mosSyouhn.getSeitoukihons());
                                if (C_SyutkKbn.SYU.eq(mosSyouhn.getSyutkkbn())) {
                                    seitoukihonsPsyu = mosSyouhn.getSeitoukihons();
                                }
                            }
                        }

                        seitoukihonsPsyu = seitoukihonsPsyu.round(-3, RoundingMode.FLOOR);
                        seitoukihonsPgk = seitoukihonsPgk.round(-3, RoundingMode.FLOOR);

                        BizDate knsyoriYmd = minNyuukinYmd;

                        Map<C_Tuukasyu, BizCurrency> sumRsgaku = new HashMap<>();

                        BizCurrency yenFsthrkpkei = BizCurrency.valueOf(0);

                        if (C_UmuKbn.ARI.eq(syoriCTL.getNyknnrkumu())) {
                            if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {
                                for (HT_Nyuukin nyuukin : nyuukinLst) {

                                    if (!C_ZenhnknKbn.SUMI.eq(nyuukin.getZenhnknkbn())) {
                                        if (sumRsgaku.containsKey(nyuukin.getRstuukasyu())) {
                                            sumRsgaku.put(nyuukin.getRstuukasyu(), sumRsgaku.get(nyuukin.getRstuukasyu())
                                                .add(nyuukin.getRsgaku()));
                                        }
                                        else {
                                            sumRsgaku.put(nyuukin.getRstuukasyu(), nyuukin.getRsgaku());
                                        }
                                    }
                                }
                            }

                            else {
                                getRsgakukei.getHenkinsumiRsgaku(syoriCTL);
                                sumRsgaku.put(getRsgakukei.getTuukasyu(), getRsgakukei.getRsgakukei());
                            }

                            for (C_Tuukasyu tukasyu : sumRsgaku.keySet()) {
                                if (C_Tuukasyu.JPY.eq(tukasyu)) {
                                    yenFsthrkpkei = sumRsgaku.get(tukasyu);
                                }

                                else {
                                    BizNumber kawaseRate =
                                        editPalRenkeiKoumoku.getEnknsnKawaseRate(tukasyu, syoriCTL.getRyosyuymd(),
                                            mosKihon.getHrkkaisuu(),mosKihon.getZennoumousideumu(),mosKihon.getIkkatubaraikbn());

                                    yenFsthrkpkei = keisanGaikakanzan.exec(C_Tuukasyu.JPY, sumRsgaku.get(tukasyu),
                                        kawaseRate, C_HasuusyoriKbn.SUTE);
                                }
                                break;
                            }
                        }


                        String sbuktkbn = "";

                        if (mosKihon.getSbuktnin() > 1) {
                            sbuktkbn = "4";
                        }
                        else if (mosKihon.getSbuktnin() == 1 && uketorininSbuktLst.size() == 1) {
                            if (C_UktKbn.KYK.eq(uketorininSbuktLst.get(0).getUktkbn())) {
                                sbuktkbn = "2";
                            }
                            else if (C_UktKbn.TOKUTEIMEIGI.eq(uketorininSbuktLst.get(0).getUktkbn())) {
                                sbuktkbn = "5";
                            }
                            else {
                                sbuktkbn = "0";
                            }
                        }
                        else {
                            sbuktkbn = "0";
                        }
                        String ukttdk = "";

                        if (mosKihon.getSbuktnin() > 1
                            && C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())
                            && uketorininSbuktLst.size() >= 1
                            && C_UktKbn.KYK.eq(uketorininSbuktLst.get(0).getUktkbn())) {
                            ukttdk = "0";
                        }
                        else {
                            if (uketorininSbuktLst.size() >= 1) {

                                if (C_Tdk.HGU.eq(uketorininSbuktLst.get(0).getUkttdk())) {
                                    ukttdk = "1";
                                }
                                else if (C_Tdk.KO.eq(uketorininSbuktLst.get(0).getUkttdk())){
                                    ukttdk = "2";
                                }
                                else if (C_Tdk.OYA.eq(uketorininSbuktLst.get(0).getUkttdk())){
                                    ukttdk = "3";
                                }
                                else if (C_Tdk.MAGO.eq(uketorininSbuktLst.get(0).getUkttdk())){
                                    ukttdk = "4";
                                }
                                else if (C_Tdk.SHB.eq(uketorininSbuktLst.get(0).getUkttdk())){
                                    ukttdk = "5";
                                }
                                else if (C_Tdk.KYDSM.eq(uketorininSbuktLst.get(0).getUkttdk())){
                                    ukttdk = "6";
                                }
                                else if (C_Tdk.SONOTA.eq(uketorininSbuktLst.get(0).getUkttdk())){
                                    ukttdk = "9";
                                }
                                else {
                                    ukttdk = "0";
                                }
                            }
                            else {
                                ukttdk = "0";
                            }
                        }

                        String uktnmkj = "";

                        String uktnmkn = "";

                        BizDate uktseiymd = BizDate.valueOf("00000000");

                        if (uketorininSbuktLst.size() >= 1) {
                            uktnmkj = uketorininSbuktLst.get(0).getUktnmkj();

                            uktnmkn = uketorininSbuktLst.get(0).getUktnmkn();

                            uktseiymd = uketorininSbuktLst.get(0).getUktseiymd();
                        }

                        String siteidairininkbn = "";

                        if (uketorininStdrskLst.size() == 0) {
                            siteidairininkbn = "00";
                        }

                        else if (C_UktKbn.SBUK.eq(uketorininStdrskLst.get(0).getUktkbn())) {
                            siteidairininkbn = "07";
                        }

                        else if (C_UktKbn.TOUROKUKAZOKU1.eq(uketorininStdrskLst.get(0).getUktkbn())) {
                            siteidairininkbn = "11";
                        }

                        else if (C_UktKbn.TOUROKUKAZOKU2.eq(uketorininStdrskLst.get(0).getUktkbn())) {
                            siteidairininkbn = "12";
                        }

                        else if (C_UktKbn.KYK.eq(uketorininStdrskLst.get(0).getUktkbn())) {
                            siteidairininkbn = "13";
                        }

                        else if (C_UktKbn.TOKUTEIMEIGI.eq(uketorininStdrskLst.get(0).getUktkbn())) {

                            if (C_Tdk.BLNK.eq(uketorininStdrskLst.get(0).getUkttdk())) {
                                siteidairininkbn = "00";
                            }

                            else if (C_Tdk.HGU.eq(uketorininStdrskLst.get(0).getUkttdk())) {
                                siteidairininkbn = "01";
                            }

                            else if (C_Tdk.OYA.eq(uketorininStdrskLst.get(0).getUkttdk())) {
                                siteidairininkbn = "03";
                            }

                            else if (C_Tdk.KO.eq(uketorininStdrskLst.get(0).getUkttdk())) {
                                siteidairininkbn = "02";
                            }

                            else if (C_Tdk.SHB.eq(uketorininStdrskLst.get(0).getUkttdk())) {
                                siteidairininkbn = "05";
                            }

                            else if (C_Tdk.KYDSM.eq(uketorininStdrskLst.get(0).getUkttdk())) {
                                siteidairininkbn = "06";
                            }

                            else if (C_Tdk.MAGO.eq(uketorininStdrskLst.get(0).getUkttdk())) {
                                siteidairininkbn = "04";
                            }

                            else if (C_Tdk.SINTOU3.eq(uketorininStdrskLst.get(0).getUkttdk())) {
                                siteidairininkbn = "08";
                            }

                            else if (C_Tdk.SONOTA.eq(uketorininStdrskLst.get(0).getUkttdk())) {
                                siteidairininkbn = "10";
                            }
                        }

                        else {
                            siteidairininkbn = "00";
                        }

                        String kjsiteidairininnm = "";

                        String teidairininnm = "";

                        if (uketorininStdrskLst.size() > 0) {
                            if (C_UktKbn.TOKUTEIMEIGI.eq(uketorininStdrskLst.get(0).getUktkbn())) {
                                kjsiteidairininnm = uketorininStdrskLst.get(0).getUktnmkj();

                                teidairininnm = uketorininStdrskLst.get(0).getUktnmkn();
                            }
                        }

                        String inputmissteiseikaisuu = "0";

                        if (count >= 100) {
                            inputmissteiseikaisuu = "99";
                        } else {
                            inputmissteiseikaisuu = Strings.padStart(String.valueOf(count), 2, '0') ;
                        }

                        String sisyaketnyuuryokuymd = editPalRenkeiKoumoku.editSisyaketteiYmd(syoriCTL);

                        String sentakuinfoumuhyj = "";

                        if (sentakuJyouhouLst.size() == 0) {
                            sentakuinfoumuhyj = "0";
                        }

                        else {
                            sentakuinfoumuhyj = "1";
                        }

                        String dainisentakuInfokakjkKbn = "";

                        if (nayoseKekkaLst.size() > 0) {

                            if (tokunin != null && C_SignalkaihiKbn.ARI.eq(tokunin.getSignalkaihikbn())) {
                                dainisentakuInfokakjkKbn = "2";
                            }
                            else {
                                dainisentakuInfokakjkKbn = "1";
                            }
                        }

                        else {
                            dainisentakuInfokakjkKbn = "0";
                        }

                        String hknkkn = "00";
                        String saimankikeiyakuhyouji = "0";
                        String pHrkkkn = "00";

                        if (mosSyouhnPsyu.getHknkkn() != null &&
                            mosSyouhnPsyu.getHknkknsmnkbn() != null) {
                            editPalRenkeiKoumoku.editHknkkn(mosKihon, mosSyouhnPsyu, syouhnZokuseiPsyu);
                            hknkkn = editPalRenkeiKoumoku.getHknKkn();
                            saimankikeiyakuhyouji = editPalRenkeiKoumoku.getSaiMnkKykHyj();
                            pHrkkkn = editPalRenkeiKoumoku.getHrkkkn();

                        }

                        String kzmeigikakuninzumikbn = "0";

                        if (tokunin != null && C_KzmeigitknKbn.ARI.eq(tokunin.getKzmeigitknkbn())) {
                            if (hubiMsgKzhuriLst.size() > 0 && hubiMsgDebitnykLst.size() > 0) {
                                kzmeigikakuninzumikbn = "3";
                            }
                            else if (hubiMsgDebitnykLst.size() > 0) {
                                kzmeigikakuninzumikbn = "2";
                            }
                            else if (hubiMsgKzhuriLst.size() > 0) {
                                kzmeigikakuninzumikbn = "1";
                            }
                        }

                        String hrkkaisuu = editPalRenkeiKoumoku.editHrkkaisuu(mosKihon);

                        String kykdrkbn = "0";
                        String kjkykdairinm = "";
                        String kykdairinm = "";

                        if (C_Tkhukaumu.HUKA.eq(mosKihon.getKykdrtkykhukakbn())) {

                            if (uketorininKykLst.size() > 0) {

                                if (C_UktKbn.TOUROKUKAZOKU1.eq(uketorininKykLst.get(0).getUktkbn())) {

                                    kykdrkbn = "1";
                                }
                                if (C_UktKbn.TOUROKUKAZOKU2.eq(uketorininKykLst.get(0).getUktkbn())) {

                                    kykdrkbn = "2";
                                }
                            }
                        }

                        String trkkzktdk1 = "0";
                        String kjkzktourokunm1 = "";
                        String kzktourokunm1 = "";
                        String trkkzktdk2 = "0";
                        String kjkzktourokunm2 = "";
                        String kzktourokunm2 = "";

                        if (C_KzktourokuserviceTourokuKbn.ARI.eq(mosKihon.getKzktourokuservicetourokukbn())) {
                            if (mosTrkKzkLst.size() > 0) {

                                for (HT_MosTrkKzk mosTrKzk : mosTrkKzkLst) {

                                    if (C_TrkKzkKbn.TRKKZK1.eq(mosTrKzk.getTrkkzkkbn())) {

                                        if (C_Tdk.HGU.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk1 = "1";
                                        }
                                        else if (C_Tdk.KO.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk1 = "2";
                                        }
                                        else if (C_Tdk.MAGO.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk1 = "3";
                                        }
                                        else if (C_Tdk.KYDSM.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk1 = "4";
                                        }
                                        else if (C_Tdk.SINTOU3.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk1 = "5";
                                        }
                                        else if (C_Tdk.SONOTA.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk1 = "7";
                                        }
                                        else if (C_Tdk.OYA.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk1 = "8";
                                        }
                                        else if (C_Tdk.SHB.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk1 = "9";
                                        }

                                        kjkzktourokunm1 = mosTrKzk.getTrkkzknmkj();
                                        kzktourokunm1 = mosTrKzk.getTrkkzknmkn();
                                    }

                                    if (C_TrkKzkKbn.TRKKZK2.eq(mosTrKzk.getTrkkzkkbn())) {
                                        if (C_Tdk.HGU.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk2 = "1";
                                        }
                                        else if (C_Tdk.KO.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk2 = "2";
                                        }
                                        else if (C_Tdk.MAGO.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk2 = "3";
                                        }
                                        else if (C_Tdk.KYDSM.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk2 = "4";
                                        }
                                        else if (C_Tdk.SINTOU3.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk2 = "5";
                                        }
                                        else if (C_Tdk.SONOTA.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk2 = "7";
                                        }
                                        else if (C_Tdk.OYA.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk2 = "8";
                                        }
                                        else if (C_Tdk.SHB.eq(mosTrKzk.getTrkkzktdk())) {

                                            trkkzktdk2 = "9";
                                        }

                                        kjkzktourokunm2 = mosTrKzk.getTrkkzknmkj();
                                        kzktourokunm2 = mosTrKzk.getTrkkzknmkn();

                                    }

                                }

                            }

                        }

                        ZT_HonsyaToukeiTy honsyaToukeiTy = SWAKInjector.getInstance(ZT_HonsyaToukeiTy.class);

                        String ztyMossyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(syoriCTL.getSeiritukbn(),
                            saisinKetkekkaCd);

                        String ztydakuhikettikekkacd =
                            editPalRenkeiKoumoku.editDakuhiKtkekkaCd(dakuhiKetSaisinKetKekkaCd);

                        String ztyketkbn = "";


                        if (C_UmuKbn.ARI.eq(syoriCTL.getKnkysateirrkumu()) ||
                            C_Knkysatei1jiyhKbn.YOU.eq(syoriCTL.getKnkysatei1jiyhkbn()) ||
                            C_Knkysatei2jiyhKbn.YOU_A.eq(syoriCTL.getKnkysatei2jiyhkbn()) ||
                            C_Knkysatei2jiyhKbn.YOU_B.eq(syoriCTL.getKnkysatei2jiyhkbn()) ||
                            C_UmuKbn.ARI.eq(syoriCTL.getImusateirrkumu()) ||
                            C_ImusateikaniyhKbn.YOU_KANI_UW.eq(syoriCTL.getImusateikaniyhkbn()) ||
                            C_ImusateikaniyhKbn.YOU_KANI_MD.eq(syoriCTL.getImusateikaniyhkbn())) {

                            ztyketkbn = "2";
                        }

                        else if (C_Knkysatei1jiyhKbn.HUYOU.eq(syoriCTL.getKnkysatei1jiyhkbn()) &&
                            C_Knkysatei2jiyhKbn.HUYOU.eq(syoriCTL.getKnkysatei2jiyhkbn()) &&
                            C_ImusateikaniyhKbn.HUYOU.eq(syoriCTL.getImusateikaniyhkbn())) {
                            ztyketkbn = "1";
                        }

                        else {
                            ztyketkbn = "0";
                        }

                        String ztytoukeihknsyruikbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(syouhnZokuseiPsyu,
                            mosKihon);

                        String hhknnen = editPalRenkeiKoumoku.editHhknnen(mosKihon.getHhknnen());

                        String ztyhjykktkbn = editPalRenkeiKoumoku.editHjykktKbn(mosKihon.getSntkhoukbn());

                        String kkeirokbn = editPalRenkeiKoumoku.editHrkKeiroKbn(mosKihon.getHrkkeiro(),
                            mosKihon.getHrkkaisuu());

                        String ztyryouritukbn = editPalRenkeiKoumoku.editRyourituKbn(mosKihon.getHrkkeiro(),
                            mosKihon.getDntryouritukbn());

                        String ztykykkakjkkbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(syoriCTL.getKykkakjkkbn(),
                            syoriCTL.getSeiritukbn(), mosKihon.getKakukisyouryakukbumukbn());

                        BizDate ztykykkakkanryouymd = null;

                        BizDate ztykykkakketymd = null;

                        if (kykKak != null
                            && (C_Kykkaksyrui.KETMAE.eq(kykKak.getKykkaksyrui()) ||
                                C_Kykkaksyrui.KETHORYU.eq(kykKak.getKykkaksyrui()))) {

                            if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {
                                ztykykkakkanryouymd = syoriCTL.getSrsyoriymd();
                            }
                            else {
                                ztykykkakkanryouymd = kykKak.getKykkakkanymd();
                            }
                            ztykykkakketymd = kykKak.getKykkakkanymd();
                        }

                        else {
                            ztykykkakkanryouymd = BizDate.valueOf("00000000");
                            ztykykkakketymd = BizDate.valueOf("00000000");
                        }

                        String ztykykkakketkekkakbn = "";

                        if (kykKak == null) {
                            ztykykkakketkekkakbn = "0";
                        }

                        else {
                            if (C_KykkakkekKbn.BLNK.eq(kykKak.getKykkakkekkbn())) {
                                ztykykkakketkekkakbn = "0";
                            }
                            else if (C_KykkakkekKbn.HOUKOKUJIKOU_NONE.eq(kykKak.getKykkakkekkbn())) {
                                ztykykkakketkekkakbn = "1";
                            }

                            else if (C_KykkakkekKbn.HOUKOKUJIKOU_ARI.eq(kykKak.getKykkakkekkbn())) {
                                ztykykkakketkekkakbn = "5";
                            }

                            else if (C_KykkakkekKbn.KAK_TYUUSI.eq(kykKak.getKykkakkekkbn())) {
                                ztykykkakketkekkakbn = "6";
                            }
                        }

                        String ztykykkaktantoukojincd = "";
                        if (kykKak != null) {

                            ztykykkaktantoukojincd = kykKak.getKykkaktantcd();

                            if (ztykykkaktantoukojincd.length() > 6) {
                                ztykykkaktantoukojincd = "";
                            }
                        }
                        else {
                            ztykykkaktantoukojincd = "";
                        }

                        String ztysyosakuseiymd = editPalRenkeiKoumoku.editSyokenSakuseiYmd(syoriCTL.getSeiritukbn(),
                            syoriCTL.getSrsyoriymd());

                        String syokaipnyuukinhouhoukbn = editPalRenkeiKoumoku.editFstpNyknHouhouKbn(
                            syoriCTL.getNyknnrkumu(), mosKihon.getFstphrkkeirokbn());

                        String ztyhaitousiharaikbn = "";

                        if (C_HaitouKbn.YUUHAI.eq(mosKihon.getHaitoukbn())) {
                            ztyhaitousiharaikbn = "0";
                        }

                        else if (C_HaitouKbn.RISAHAI.eq(mosKihon.getHaitoukbn())) {
                            ztyhaitousiharaikbn = "1";
                        }

                        else if (C_HaitouKbn.NONE.eq(mosKihon.getHaitoukbn())) {
                            ztyhaitousiharaikbn = "2";
                        }
                        else {
                            ztyhaitousiharaikbn = "0";
                        }

                        String ztytoukeiyousinsakbn =
                            editPalRenkeiKoumoku.editToukeiyouSinsaKbn(mosKihon.getSntkhoukbn());

                        String ztybsudirtnatkikeitaikbn =
                            editPalRenkeiKoumoku.editBosyuuDairitenAtkiKeitaiKbn(mosDairitenLst);

                        String ztykjkyknm = editPalRenkeiKoumoku.editKyknmkj(mosKihon.getKykkbn(),
                            mosKihon.getHhknnmkj(), mosKihon.getKyknmkj(), 15);

                        String ztynyknzumihyouji = editPalRenkeiKoumoku.editNyknzumiHyouji(syoriCTL.getMosnrkumu(),
                            syoriCTL.getNyknnrkumu());

                        String ztynyknjkkbn = editPalRenkeiKoumoku.editNyknJkKbn(syoriCTL.getNyknnrkumu(),
                            syoriCTL.getRyosyuymd(), mosKihon.getMosym());

                        String ztybatukaisyakojincd = "";

                        if (mosDairitenLst.size() == 2) {
                            ztybatukaisyakojincd = mosDairitenLst.get(1).getDaibosyuucd();
                        }
                        else {
                            ztybatukaisyakojincd = "000000";
                        }

                        String ztysinfstpnyknhouhoukbn =
                            editPalRenkeiKoumoku.editSinfstpNyknHouhouKbn(syoriCTL.getNyknnrkumu());

                        String ztymostorikesikbn = "";

                        String ztymostrkssyousairiyuukbn = "";

                        if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {

                            if (C_Ketkekkacd.MOS_TORIKESI.eq(saisinKetkekkaCd)) {
                                ztymostorikesikbn = "1";
                                ztymostrkssyousairiyuukbn = saisinTorikeSisyousaiRiyuuCd.getValue();
                            }

                            else if (C_Ketkekkacd.COOLINGOFF.eq(saisinKetkekkaCd)) {
                                ztymostorikesikbn = "2";
                                ztymostrkssyousairiyuukbn = saisinTorikeSisyousaiRiyuuCd.getValue();
                            }
                            else {
                                ztymostorikesikbn = "0";
                                ztymostrkssyousairiyuukbn = "00";
                            }
                        }
                        else {
                            ztymostorikesikbn = "0";
                            ztymostrkssyousairiyuukbn = "00";
                        }

                        String kyknmkn = editPalRenkeiKoumoku.editKyknmkn(mosKihon.getKykkbn(), mosKihon.getHhknnmkn(),
                            mosKihon.getKyknmkn(), 18);

                        String kyktdkkbn = "";

                        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                            kyktdkkbn = "0";
                        }
                        else {
                            if (C_Tdk.HGU.eq(mosKihon.getKyktdk())) {
                                kyktdkkbn = "1";
                            }
                            else if (C_Tdk.KO.eq(mosKihon.getKyktdk())){
                                kyktdkkbn = "2";
                            }
                            else if (C_Tdk.OYA.eq(mosKihon.getKyktdk())){
                                kyktdkkbn = "3";
                            }
                            else if (C_Tdk.MAGO.eq(mosKihon.getKyktdk())){
                                kyktdkkbn = "4";
                            }
                            else if (C_Tdk.SHB.eq(mosKihon.getKyktdk())){
                                kyktdkkbn = "5";
                            }
                            else if (C_Tdk.KYDSM.eq(mosKihon.getKyktdk())){
                                kyktdkkbn = "6";
                            }
                            else if (C_Tdk.SONOTA.eq(mosKihon.getKyktdk())){
                                kyktdkkbn = "9";
                            }
                            else {
                                kyktdkkbn = "0";
                            }
                        }

                        String ztykyksyanen = editPalRenkeiKoumoku.editKyksyanen2Keta(mosKihon.getKykkbn(),
                            mosKihon.getHhknnen(), mosKihon.getKyknen());

                        String ztykyksyaseikbn = editPalRenkeiKoumoku.editKykSyaseiKbn(mosKihon.getKykkbn(),
                            mosKihon.getHhknsei(), mosKihon.getKyksei());

                        String ztymosjihonninkknnkbn = "00";

                        if (C_HonninkakuninSyoruiKbn.BLNK.eq(mosKihon.getKykhonninkakninsyoruikbn())) {
                            ztymosjihonninkknnkbn = "00";
                        }
                        else if (C_HonninkakuninSyoruiKbn.UNTEN.eq(mosKihon.getKykhonninkakninsyoruikbn())) {
                            ztymosjihonninkknnkbn = "01";
                        }
                        else if (C_HonninkakuninSyoruiKbn.PASSPORT.eq(mosKihon.getKykhonninkakninsyoruikbn())) {
                            ztymosjihonninkknnkbn = "02";
                        }
                        else if (C_HonninkakuninSyoruiKbn.ZAIRYUUCARD.eq(mosKihon.getKykhonninkakninsyoruikbn())) {
                            ztymosjihonninkknnkbn = "11";
                        }
                        else if (C_HonninkakuninSyoruiKbn.KOKUMINKENKOUHOKEN.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.KENKOUHOKEN.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.SENINHOKEN.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.KAIGOHOKEN.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.KOUKIKOUREISYAIRYOU.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.KENKOUHOKENHIYATOI.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.KOKKAKOUMUINKYOUSAI.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.TIHOUKOUMUINKYOUSAI.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.SIRITUGAKKOUKYOUINKYOUSAI.eq(
                                mosKihon.getKykhonninkakninsyoruikbn())) {
                            ztymosjihonninkknnkbn = "05";
                        }
                        else if (C_HonninkakuninSyoruiKbn.KOKUMINNENKIN.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.JIDOUHUYOUTEATE.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.TOKUBETUJIDOUHUYOUTEATE.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.BOSIKENKOU.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.SINTAISYOUGAISYA.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.SEISINSYOUGAISYA.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.RYOUIKU.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.SENSYOUBYOUSYA.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            ||
                            C_HonninkakuninSyoruiKbn.GAIKOKUSEIHUKOKUSAIKIKAN.eq(
                                mosKihon.getKykhonninkakninsyoruikbn())
                                || C_HonninkakuninSyoruiKbn.KANKOUTYOUHAKKOU.eq(mosKihon.getKykhonninkakninsyoruikbn())) {
                            ztymosjihonninkknnkbn = "07";
                        }

                        else if (C_HonninkakuninSyoruiKbn.JYUUMINKIHONDAITYOU.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            || C_HonninkakuninSyoruiKbn.KOJINNOCARD.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            || C_HonninkakuninSyoruiKbn.KOJINKOUTEKISYOUMEIYUUSOU.eq(mosKihon.getKykhonninkakninsyoruikbn())
                            || C_HonninkakuninSyoruiKbn.SONOTA.eq(mosKihon.getKykhonninkakninsyoruikbn())) {
                            ztymosjihonninkknnkbn = "10";
                        }

                        String ztyfatcamosjikakkokusekikbn = "";

                        if (C_FatcakakkekkaKbn.BLNK.eq(syoriCTL.getFatcakakkekkakbn())) {
                            ztyfatcamosjikakkokusekikbn = "0";
                        }

                        else {
                            if (C_BikkjnssinfoKbn.ARI.eq(mosKihon.getBikkjnssinfokbn())) {
                                ztyfatcamosjikakkokusekikbn = "1";
                            }
                            else {
                                ztyfatcamosjikakkokusekikbn = "2";
                            }
                        }

                        BizDate kykKakIraiYmd = null;

                        String keiyakuKakuninSyuruiKbn = "";

                        if (kykKak != null) {

                            kykKakIraiYmd = kykKak.getKykkakiraiymd();

                            keiyakuKakuninSyuruiKbn = kykKak.getKykkaksyrui().getValue();

                        }
                        else {
                            kykKakIraiYmd = BizDate.valueOf("00000000");

                            keiyakuKakuninSyuruiKbn = "00";
                        }

                        String ztykzkakiraikbn = "0";
                        String ztykzkakiraiymd = "00000000";
                        String ztybankyohurikzhyouji = "0";

                        if (kouzaJyouhou != null) {

                            if (C_YouhiblnkKbn.YOU.eq(kouzaJyouhou.getKouzakakuniniraikbn())) {
                                ztykzkakiraikbn = "1";
                            }
                            if (kouzaJyouhou.getKouzakakuniniraiymd() != null) {
                                ztykzkakiraiymd = kouzaJyouhou.getKouzakakuniniraiymd().toString();

                            }
                            if (!IGkCommonKoumoku.BANKCD_YTGINKOU.equals(kouzaJyouhou.getBankcd())) {
                                ztybankyohurikzhyouji = "1";
                            }

                        }

                        honsyaToukeiTy.setZtykijyunym(String.valueOf(syoriYmd.getBizDateYM()));

                        honsyaToukeiTy.setZtymosym(String.valueOf(mosKihon.getMosym()));

                        honsyaToukeiTy.setZtymosno(syoriCTL.getMosno());

                        honsyaToukeiTy.setZtysosikicd(YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());

                        honsyaToukeiTy.setZtymossyoumetukbn(ztyMossyoumetuKbn);

                        if (syoriCTL.getSrsyoriymd() == null) {
                            honsyaToukeiTy.setZtymossyumtkktymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtymossyumtkktymd(String.valueOf(syoriCTL.getSrsyoriymd()));
                        }

                        honsyaToukeiTy.setZtyrenseihhknkbn("0");

                        honsyaToukeiTy.setZtydakuhikettikekkacd(ztydakuhikettikekkacd);

                        if (dakuhiKetSaisinKetteiYmd == null) {
                            honsyaToukeiTy.setZtydkhktiymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtydkhktiymd(String.valueOf(dakuhiKetSaisinKetteiYmd));
                        }

                        honsyaToukeiTy.setZtyketkbn(ztyketkbn);

                        honsyaToukeiTy.setZtytoukeihknsyruikbn(ztytoukeihknsyruikbn);

                        honsyaToukeiTy.setZtyhhknnen2keta(hhknnen);

                        honsyaToukeiTy.setZtyhhknseikbn(mosKihon.getHhknsei().getValue());

                        honsyaToukeiTy.setZtyhjykktkbn(ztyhjykktkbn);

                        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

                        honsyaToukeiTy.setZtyhrkkaisuukbn(hrkkaisuu);

                        honsyaToukeiTy.setZtyhrkkeirokbn(kkeirokbn);

                        honsyaToukeiTy.setZtyryouritukbn(ztyryouritukbn);

                        if (seitoukihonsPgk.toString().length() > 11) {
                            honsyaToukeiTy.setZtydakuhikts(99999999999L);
                        }
                        else {
                            honsyaToukeiTy.setZtydakuhikts(new BigDecimal(seitoukihonsPgk.toString()).longValue());
                        }

                        if (seitoukihonsPgk.toString().length() > 11) {
                            honsyaToukeiTy.setZtykihons(99999999999L);
                        }
                        else {
                            honsyaToukeiTy.setZtykihons(new BigDecimal(seitoukihonsPgk.toString()).longValue());
                        }

                        honsyaToukeiTy.setZtyhhkndaisansyakykkbn("0");

                        honsyaToukeiTy.setZtydainisentakuinfokakjkkbn(dainisentakuInfokakjkKbn);

                        if (mosKihon.getMosymd() == null) {
                            honsyaToukeiTy.setZtymusymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtymusymd(String.valueOf(mosKihon.getMosymd()));
                        }

                        if (syoriCTL.getRyosyuymd() == null) {
                            honsyaToukeiTy.setZtyryousyuuymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtyryousyuuymd(String.valueOf(syoriCTL.getRyosyuymd()));
                        }

                        if (C_SntkhouKbn.NONE.eq(mosKihon.getSntkhoukbn())) {

                            if (mosKihon.getMosymd() == null) {

                                honsyaToukeiTy.setZtykokutiymd("00000000");

                            }
                            else {
                                honsyaToukeiTy.setZtykokutiymd(mosKihon.getMosymd().toString());
                            }
                        }
                        else {
                            if (syoriCTL.getKktymd() == null) {
                                honsyaToukeiTy.setZtykokutiymd("00000000");
                            }
                            else {
                                honsyaToukeiTy.setZtykokutiymd(String.valueOf(syoriCTL.getKktymd()));
                            }
                        }

                        if (mosKihon.getKykymd() == null) {
                            honsyaToukeiTy.setZtykykymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtykykymd(String.valueOf(mosKihon.getKykymd()));
                        }

                        if (syoriCTL.getMosnrkymd() == null) {
                            honsyaToukeiTy.setZtyseikeirenrakuymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtyseikeirenrakuymd(String.valueOf(syoriCTL.getMosnrkymd()));
                        }

                        if (knsyoriYmd == null) {
                            honsyaToukeiTy.setZtynyknnyuuryokuymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtynyknnyuuryokuymd(String.valueOf(knsyoriYmd));
                        }

                        if (sisyaketnyuuryokuymd == null) {
                            honsyaToukeiTy.setZtysisyaketnyuuryokuymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtysisyaketnyuuryokuymd(String.valueOf(sisyaketnyuuryokuymd));
                        }

                        if (kykKakIraiYmd == null) {
                            honsyaToukeiTy.setZtykykkakiraiymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtykykkakiraiymd(kykKakIraiYmd.toString());
                        }

                        Class<?> clazz_C_Kykkaksyrui = C_Kykkaksyrui.class;


                        if (!"00".equals(keiyakuKakuninSyuruiKbn)) {
                            honsyaToukeiTy.setZtykeiyakukakuninsyuruikbn(bzKbnHenkanUtil.convKbn(
                                keiyakuKakuninSyuruiKbn,
                                clazz_C_Kykkaksyrui, direction).getKbnData());
                        }
                        else {
                            honsyaToukeiTy.setZtykeiyakukakuninsyuruikbn("00");
                        }
                        honsyaToukeiTy.setZtysiteidairikbn2(siteidairininkbn);

                        honsyaToukeiTy.setZtykykkakjkkbn1(ztykykkakjkkbn1);

                        if (ztykykkakkanryouymd == null) {
                            honsyaToukeiTy.setZtykykkakkanryouymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtykykkakkanryouymd(ztykykkakkanryouymd.toString());
                        }

                        if (ztykykkakketymd == null) {
                            honsyaToukeiTy.setZtykykkakketymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtykykkakketymd(ztykykkakketymd.toString());
                        }

                        honsyaToukeiTy.setZtykykkakketkekkakbn(ztykykkakketkekkakbn);

                        honsyaToukeiTy.setZtykykkaktantoukojincd(Strings.padStart(ztykykkaktantoukojincd, 6, '0'));

                        honsyaToukeiTy.setZtyketsyacd(Strings.padStart(saisinPlaKetsyaCd, 2, '0'));

                        if (ztysyosakuseiymd == null) {
                            honsyaToukeiTy.setZtysyosakuseiymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtysyosakuseiymd(ztysyosakuseiymd);
                        }

                        if (mosKihon.getSeisekiym() == null) {
                            honsyaToukeiTy.setZtyseisekiym("000000");
                        }
                        else {
                            honsyaToukeiTy.setZtyseisekiym(String.valueOf(mosKihon.getSeisekiym()));
                        }

                        if (mosKihon.getBosyuuym() == null) {
                            honsyaToukeiTy.setZtybsyym("000000");
                        }
                        else {
                            honsyaToukeiTy.setZtybsyym(String.valueOf(mosKihon.getBosyuuym()));
                        }

                        if (yenFsthrkpkei.toString().length() > 11) {
                            honsyaToukeiTy.setZtysyokaiharaikomip(99999999999L);
                        }
                        else {
                            honsyaToukeiTy.setZtysyokaiharaikomip(new BigDecimal(yenFsthrkpkei.toString()).longValue());
                        }

                        if (mosKihon.getMossakuseiymd() == null) {
                            honsyaToukeiTy.setZtymossyosakuseiymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtymossyosakuseiymd(String.valueOf(mosKihon.getMossakuseiymd()));
                        }

                        honsyaToukeiTy.setZtysyono(Strings.padStart(syoriCTL.getSyono(), 11, '0'));

                        honsyaToukeiTy.setZtydakuhiketteiriyuucdx1(Strings.padStart(
                            dakuhiKetSaisinKetKekkaCd1.getValue(), 2, '0'));

                        honsyaToukeiTy.setZtydakuhiketteiriyuucdx2(Strings.padStart(
                            dakuhiKetSaisinKetKekkaCd2.getValue(), 2, '0'));

                        honsyaToukeiTy.setZtydakuhiketteiriyuucdx3(Strings.padStart(
                            dakuhiKetSaisinKetKekkaCd3.getValue(), 2, '0'));

                        honsyaToukeiTy.setZtydakuhiketteiriyuucdx4(Strings.padStart(
                            dakuhiKetSaisinKetKekkaCd4.getValue(), 2, '0'));

                        honsyaToukeiTy.setZtyhenkouteiseisyorikaisuu(Strings.padStart(
                            String.valueOf(maxNo), 2, '0'));

                        honsyaToukeiTy.setZtysyosisyatodokekibouhyj(mosKihon.getSyosisyatodokeumukbn().getValue());

                        honsyaToukeiTy.setZtyhndketkaisuu(String.valueOf(knksateiRirekiLst.size()
                            + imusateiRirekiLst.size()));

                        honsyaToukeiTy.setZtydakuhiketkeiikekkacd1(editPalRenkeiKoumoku
                            .editDakuhiKtkekkaCd(dakuhiKetSaisinKetKekkaCdLst.get(0)));

                        honsyaToukeiTy.setZtydakuhiketkeiiketmd1(dakuhiKetSaisinKetteiMdLst.get(0));

                        honsyaToukeiTy.setZtydakuhiketkeiikekkacd2(editPalRenkeiKoumoku
                            .editDakuhiKtkekkaCd(dakuhiKetSaisinKetKekkaCdLst.get(1)));

                        honsyaToukeiTy.setZtydakuhiketkeiiketmd2(dakuhiKetSaisinKetteiMdLst.get(1));

                        honsyaToukeiTy.setZtydakuhiketkeiikekkacd3(editPalRenkeiKoumoku
                            .editDakuhiKtkekkaCd(dakuhiKetSaisinKetKekkaCdLst.get(2)));

                        honsyaToukeiTy.setZtydakuhiketkeiiketmd3(dakuhiKetSaisinKetteiMdLst.get(2));

                        honsyaToukeiTy.setZtydakuhiketkeiikekkacd4(editPalRenkeiKoumoku
                            .editDakuhiKtkekkaCd(dakuhiKetSaisinKetKekkaCdLst.get(3)));

                        honsyaToukeiTy.setZtydakuhiketkeiiketmd4(dakuhiKetSaisinKetteiMdLst.get(3));

                        honsyaToukeiTy.setZtydakuhiketkeiikekkacd5(editPalRenkeiKoumoku
                            .editDakuhiKtkekkaCd(dakuhiKetSaisinKetKekkaCdLst.get(4)));

                        honsyaToukeiTy.setZtydakuhiketkeiiketmd5(dakuhiKetSaisinKetteiMdLst.get(4));

                        honsyaToukeiTy.setZtydakuhiketkeiikekkacd6(editPalRenkeiKoumoku
                            .editDakuhiKtkekkaCd(dakuhiKetSaisinKetKekkaCdLst.get(5)));

                        honsyaToukeiTy.setZtydakuhiketkeiiketmd6(dakuhiKetSaisinKetteiMdLst.get(5));

                        honsyaToukeiTy.setZtykojincd(Strings.padStart(mosDairitenLst.get(0).getDaibosyuucd(), 6, '0'));

                        honsyaToukeiTy.setZtysyokaipnyuukinhouhoukbn(syokaipnyuukinhouhoukbn);

                        honsyaToukeiTy.setZtysentakuinfoumuhyj(sentakuinfoumuhyj);

                        honsyaToukeiTy.setZtyhaitousiharaikbn(ztyhaitousiharaikbn);

                        if (seitoukihonsPgk.toString().length() > 11) {
                            honsyaToukeiTy.setZtyhonsyatkkohojyunhsys(99999999999L);
                        }
                        else {
                            honsyaToukeiTy.setZtyhonsyatkkohojyunhsys(
                                new BigDecimal(seitoukihonsPgk.toString()).longValue());
                        }

                        honsyaToukeiTy.setZtytoukeiyousinsakbn(ztytoukeiyousinsakbn);

                        if (mosKihon.getSknnkaisiymd() == null) {
                            honsyaToukeiTy.setZtysknnkaisiymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtysknnkaisiymd(String.valueOf(mosKihon.getSknnkaisiymd()));
                        }

                        honsyaToukeiTy.setZtybsudirtnatkikeitaikbn(ztybsudirtnatkikeitaikbn);

                        honsyaToukeiTy.setZtyhhknsynensyuukbn(mosKihon.getHhknnensyuukbn().getValue());

                        honsyaToukeiTy.setZtytokusyujimutoriatukaikbn("1");

                        honsyaToukeiTy.setZtyinputmissteiseikaisuu(inputmissteiseikaisuu);

                        honsyaToukeiTy.setZtykjkyknm(ztykjkyknm);

                        honsyaToukeiTy.setZtyknjhhknmei(mosKihon.getHhknnmkj());

                        honsyaToukeiTy.setZtyhonninkknnkbn("00");

                        honsyaToukeiTy.setZtynyknzumihyouji(ztynyknzumihyouji);

                        honsyaToukeiTy.setZtyhhknsykgycd(Strings.padStart(mosKihon.getHhknsykgycd(), 3, '0'));

                        honsyaToukeiTy.setZtynyknjkkbn(ztynyknjkkbn);

                        honsyaToukeiTy.setZtybatukaisyakojincd(Strings.padStart(ztybatukaisyakojincd, 6, '0'));

                        honsyaToukeiTy.setZtysinfstpnyknhouhoukbn(ztysinfstpnyknhouhoukbn);

                        honsyaToukeiTy.setZtymostorikesikbn(ztymostorikesikbn);

                        honsyaToukeiTy.setZtymostrkssyousairiyuukbn(ztymostrkssyousairiyuukbn);

                        honsyaToukeiTy.setZtymossakuseino("000000000");

                        if (seitoukihonsPsyu.toString().length() > 11) {
                            honsyaToukeiTy.setZtysibous(99999999999L);
                        }
                        else {
                            honsyaToukeiTy.setZtysibous(new BigDecimal(seitoukihonsPsyu.toString()).longValue());
                        }

                        if (yenHaraikomip.toString().length() > 11) {
                            honsyaToukeiTy.setZtyharaikomip(99999999999L);
                        }
                        else {
                            honsyaToukeiTy.setZtyharaikomip(new BigDecimal(yenHaraikomip.toString()).longValue());
                        }

                        honsyaToukeiTy.setZtyhknkkn(hknkkn);

                        honsyaToukeiTy.setZtyphrkkikn(pHrkkkn);

                        honsyaToukeiTy.setZtysaimnkkykhyj(saimankikeiyakuhyouji);

                        honsyaToukeiTy.setZtykyknm(kyknmkn);

                        honsyaToukeiTy.setZtykyktdkkbn(kyktdkkbn);

                        honsyaToukeiTy.setZtykyksyanen(ztykyksyanen);

                        honsyaToukeiTy.setZtykyksyaseikbn(ztykyksyaseikbn);

                        honsyaToukeiTy.setZtymosjihonninkknnkbn(ztymosjihonninkknnkbn);

                        honsyaToukeiTy.setZtyhhknmei(mosKihon.getHhknnmkn());

                        honsyaToukeiTy.setZtysbuktkbn(sbuktkbn);

                        honsyaToukeiTy.setZtykjsbuktnm(uktnmkj);

                        honsyaToukeiTy.setZtysbuktnm(uktnmkn);

                        if (uktseiymd == null) {
                            honsyaToukeiTy.setZtysbuktseiymd("00000000");
                        }
                        else {
                            honsyaToukeiTy.setZtysbuktseiymd(String.valueOf(uktseiymd));
                        }

                        honsyaToukeiTy.setZtysbukttdkkbn(ukttdk);

                        honsyaToukeiTy.setZtykjsiteidairininnm(kjsiteidairininnm);

                        honsyaToukeiTy.setZtysiteidairininnm(teidairininnm);

                        String beforeFatcakakkekkakbn = syoriCTL.getFatcakakkekkakbn().getValue();

                        Class<?> clazz_C_FatcakakkekkaKbn = C_FatcakakkekkaKbn.class;

                        honsyaToukeiTy.setZtyfatcakakkekkakbn(bzKbnHenkanUtil.convKbn(beforeFatcakakkekkakbn,
                            clazz_C_FatcakakkekkaKbn, direction).getKbnData());

                        honsyaToukeiTy.setZtyfatcamosjikakkokusekikbn(ztyfatcamosjikakkokusekikbn);

                        honsyaToukeiTy.setZtyfatcatorjikakkokusekikbn("0");

                        honsyaToukeiTy.setZtykzkakiraikbn(ztykzkakiraikbn);

                        honsyaToukeiTy.setZtykzkakiraiymd(ztykzkakiraiymd);

                        honsyaToukeiTy.setZtybankyohurikzhyouji(ztybankyohurikzhyouji);

                        honsyaToukeiTy.setZtykzmeigikakuninzumikbn(kzmeigikakuninzumikbn);

                        if (mosKihon.getZnnkai() > 99) {
                            honsyaToukeiTy.setZtyznnkai("99");
                        }
                        else {
                            honsyaToukeiTy.setZtyznnkai(mosKihon.getZnnkai().toString());
                        }
                        honsyaToukeiTy.setZtykzktrkservicekbn(editPalRenkeiKoumoku.getKzktrkServiceKbn(syoriCTL));
                        honsyaToukeiTy.setZtykykdrkbn(kykdrkbn);
                        honsyaToukeiTy.setZtykjkykdairinm(kjkykdairinm);
                        honsyaToukeiTy.setZtykykdairinm(kykdairinm);
                        honsyaToukeiTy.setZtytrkkzktdk1keta1(trkkzktdk1);
                        honsyaToukeiTy.setZtykjkzktourokunm1(kjkzktourokunm1);
                        honsyaToukeiTy.setZtykzktourokunm1(kzktourokunm1);
                        honsyaToukeiTy.setZtytrkkzktdk2keta1(trkkzktdk2);
                        honsyaToukeiTy.setZtykjkzktourokunm2(kjkzktourokunm2);
                        honsyaToukeiTy.setZtykzktourokunm2(kzktourokunm2);
                        honsyaToukeiTy.setZtyyakkanjyuryouhoukbn(mosKihon.getYakkanjyuryouhoukbn().getValue());
                        honsyaToukeiTy.setZtyyakkanbunsyono(mosKihon.getYakkanbunsyono());
                        honsyaToukeiTy.setZtykzktuutityokusoukbn(editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL));

                        BizPropertyInitializer.initialize(honsyaToukeiTy);

                        hnsyaToukeiTyLst.add(honsyaToukeiTy);
                    }
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info
            (MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), kinou.getKinouNm()));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
