package yuyu.batch.sinkeiyaku.skjyouhoukei.skseiritujyouhousks;

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
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_PWaribikitekiyouKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.ZT_SeirituInfoTy;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 情報系 成立情報作成のバッチクラスです。
 */
public class SkSeirituJyouhouSksBatch implements Batch {

    private static final String TABLE_ID = "HT_SyoriCTL";

    private static final String FILTER_ID = "Sk001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

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
        String kakutyouJobcd = bzBatchParam.getIbKakutyoujobcd();
        long syoriKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobcd));

        BizDateYM syoriYm = syoriYmd.getBizDateYM();
        BizDateYM bosyuuYm = syoriYm.getPreviousMonth();

        try (
            ExDBResults<HT_SyoriCTL> syoriCTLLst =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnBosyuuym(kakutyouJobcd, bosyuuYm);
            EntityInserter<ZT_SeirituInfoTy> seirituInfoTyLst = new EntityInserter<>();) {

            HT_MosKihon mosKihon = null;
            List<HT_MosSyouhn> mosSyouhnLst = null;
            List<HT_MosDairiten> mosDairitenLst = null;
            BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
            EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);
            GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean;
            GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu =
                SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

            for (HT_SyoriCTL syoriCTL : syoriCTLLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoriCTL.getMosno());

                mosKihon = syoriCTL.getMosKihon();
                mosSyouhnLst = syoriCTL.getMosSyouhns();
                mosDairitenLst = syoriCTL.getMosDairitens();

                syoriKensuu++;

                editPalRenkeiKoumoku.getSyuEntity(mosSyouhnLst);
                HT_MosSyouhn mosSyouhnSyu = editPalRenkeiKoumoku.getMosSyouhn();
                BM_SyouhnZokusei syouhnZokuseiSyu = editPalRenkeiKoumoku.getSyouhnZokusei();

                Integer hknkkn = 0;
                Integer pHrkkkn = mosSyouhnSyu.getHrkkkn();

                if (C_UmuKbn.ARI.eq(syouhnZokuseiSyu.getNkhknumu())) {

                    C_ErrorKbn nenkinSiharaiKaisiNenreiErrorKbn = editNenkinKoumokuUtil.editNenkinSiharaiKaisiNenrei(
                        mosSyouhnSyu.getHknkkn(), mosSyouhnSyu.getHknkknsmnkbn(), mosKihon.getHhknnen());

                    if (C_ErrorKbn.OK.eq(nenkinSiharaiKaisiNenreiErrorKbn)) {

                        Integer nkshrStartNenrei = editNenkinKoumokuUtil.getNenkinSiharaiKaisiNenrei();

                        if (C_HknkknsmnKbn.SAIMANKI.eq(mosSyouhnSyu.getHknkknsmnkbn()) && nkshrStartNenrei < 50) {

                            hknkkn = mosSyouhnSyu.getHknkkn() - mosKihon.getHhknnen();

                            if (C_HrkkknsmnKbn.SAIMANKI.eq(mosSyouhnSyu.getHrkkknsmnkbn())) {

                                pHrkkkn = mosSyouhnSyu.getHrkkkn() - mosKihon.getHhknnen();
                            }
                        }
                        else if (C_HknkknsmnKbn.NENMANKI.eq(mosSyouhnSyu.getHknkknsmnkbn()) && nkshrStartNenrei >= 50) {

                            hknkkn = nkshrStartNenrei;

                            if (C_HrkkknsmnKbn.NENMANKI.eq(mosSyouhnSyu.getHrkkknsmnkbn())) {

                                pHrkkkn = mosSyouhnSyu.getHrkkkn() + mosKihon.getHhknnen();
                            }

                        }
                        else {

                            hknkkn = mosSyouhnSyu.getHknkkn();

                            if (C_HknkknsmnKbn.SAIMANKI.eq(mosSyouhnSyu.getHknkknsmnkbn()) &&
                                C_HrkkknsmnKbn.NENMANKI.eq(mosSyouhnSyu.getHrkkknsmnkbn())) {

                                pHrkkkn = mosSyouhnSyu.getHrkkkn() + mosKihon.getHhknnen();
                            }
                            if (C_HknkknsmnKbn.NENMANKI.eq(mosSyouhnSyu.getHknkknsmnkbn()) &&
                                C_HrkkknsmnKbn.SAIMANKI.eq(mosSyouhnSyu.getHrkkknsmnkbn())) {

                                pHrkkkn = mosSyouhnSyu.getHrkkkn() - mosKihon.getHhknnen();
                            }
                        }
                    }
                    else {

                        pHrkkkn = 0;
                    }
                }
                else {

                    if (C_HknkknsmnKbn.SAIMANKI.eq(mosSyouhnSyu.getHknkknsmnkbn()) && mosSyouhnSyu.getHknkkn() < 50) {

                        hknkkn = mosSyouhnSyu.getHknkkn() - mosKihon.getHhknnen();

                        if (C_HrkkknsmnKbn.SAIMANKI.eq(mosSyouhnSyu.getHrkkknsmnkbn())) {

                            pHrkkkn = mosSyouhnSyu.getHrkkkn() - mosKihon.getHhknnen();
                        }
                    }
                    else {

                        hknkkn = mosSyouhnSyu.getHknkkn();

                        if (C_HknkknsmnKbn.SAIMANKI.eq(mosSyouhnSyu.getHknkknsmnkbn())
                            && mosSyouhnSyu.getHknkkn() >= 50) {

                            if (C_HrkkknsmnKbn.NENMANKI.eq(mosSyouhnSyu.getHrkkknsmnkbn())) {

                                pHrkkkn = mosSyouhnSyu.getHrkkkn() + mosKihon.getHhknnen();
                            }
                        }
                        else {

                            if (C_HrkkknsmnKbn.SAIMANKI.eq(mosSyouhnSyu.getHrkkknsmnkbn())) {

                                pHrkkkn = mosSyouhnSyu.getHrkkkn() - mosKihon.getHhknnen();
                            }
                        }
                    }
                }

                String skRyourituKbn = editPalRenkeiKoumoku.editRyourituKbn(mosKihon.getHrkkeiro(),
                    mosKihon.getDntryouritukbn());

                String aAtkioybsyDrtenCd = "";
                if (!BizUtil.isBlank(mosDairitenLst.get(0).getOyadrtencd())) {
                    aAtkioybsyDrtenCd = mosDairitenLst.get(0).getOyadrtencd();
                }

                String bAtkioybsyDrtenCd = "";
                if (mosDairitenLst.size() > 1 && !BizUtil.isBlank(mosDairitenLst.get(1).getOyadrtencd())) {
                    bAtkioybsyDrtenCd = mosDairitenLst.get(1).getOyadrtencd();
                }

                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu());

                BizCurrency kihonsKyktuuka = BizCurrency.valueOf(0, currencyType);

                for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
                    kihonsKyktuuka = kihonsKyktuuka.add(mosSyouhn.getSeitoukihons());
                }

                BizDate enknsnKijyunYmd = editPalRenkeiKoumoku.getEnknsnKijyunYmd(
                    mosKihon.getKyktuukasyu(), syoriCTL.getRyosyuymd(), mosKihon.getMosymd());

                BizNumber enknsnKawaseRate = editPalRenkeiKoumoku.getEnknsnKawaseRate(
                    mosKihon.getKyktuukasyu(), enknsnKijyunYmd, mosKihon.getHrkkaisuu(),
                    mosKihon.getZennoumousideumu(), mosKihon.getIkkatubaraikbn());

                BizCurrency kihonsYen = BizCurrency.valueOf(0);
                BizCurrency hsysYen = BizCurrency.valueOf(0);

                if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                    kihonsYen = kihonsKyktuuka;
                    for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
                        hsysYen = hsysYen.add(mosSyouhn.getSeitoukihons());
                    }
                }
                else {

                    for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {

                        BizCurrency syouhnTaniKihons = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY, mosSyouhn.getSeitoukihons(), enknsnKawaseRate, C_HasuusyoriKbn.SUTE);
                        kihonsYen = kihonsYen.add(syouhnTaniKihons);

                        BizCurrency syouhnTaniHsys = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY, mosSyouhn.getSeitoukihons(), enknsnKawaseRate, C_HasuusyoriKbn.SUTE);
                        hsysYen = hsysYen.add(syouhnTaniHsys);
                    }
                }
                kihonsYen = kihonsYen.round(-3, RoundingMode.DOWN);
                hsysYen = hsysYen.round(-3, RoundingMode.DOWN);

                BizCurrency syukykpYen = BizCurrency.valueOf(0);
                BizCurrency syukykp = mosSyouhnSyu.getSyutkp();

                if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                    syukykpYen = syukykp;
                }
                else {
                    if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
                        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokuseiSyu.getPtratkituukasiteikbn())) {

                            syukykpYen = mosSyouhnSyu.getHrktuukasyutkp();
                        }
                        else {

                            syukykpYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                syukykp, syoriCTL.getNyknkwsrate(), C_HasuusyoriKbn.SUTE);
                        }
                    }
                    else {
                        syukykpYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            syukykp, enknsnKawaseRate, C_HasuusyoriKbn.SUTE);
                    }
                }

                String hrkkaisuu = editPalRenkeiKoumoku.editHrkkaisuu(mosKihon);

                String ztyhrkkeiro = "0";

                if (C_Hrkkeiro.KOUHURI.eq(mosKihon.getHrkkeiro())) {
                    ztyhrkkeiro = "1";
                }
                else if (C_Hrkkeiro.DANTAI.eq(mosKihon.getHrkkeiro())) {
                    ztyhrkkeiro = "2";
                }
                else if (C_Hrkkeiro.HURIKAE.eq(mosKihon.getHrkkeiro())) {
                    ztyhrkkeiro = "4";
                }
                else if (C_Hrkkeiro.SYUUDAN.eq(mosKihon.getHrkkeiro())) {
                    ztyhrkkeiro = "6";
                }
                else if (C_Hrkkeiro.CREDIT.eq(mosKihon.getHrkkeiro())) {
                    ztyhrkkeiro = "Z";
                }

                int keisanHrkkaisuu = editPalRenkeiKoumoku.getKeisanHrkkaisuu(mosKihon.getHrkkaisuu());
                CurrencyType hrktuukasyuType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getHrktuukasyu());

                BizCurrency tkbriknsnhrkpYen = BizCurrency.valueOf(0);
                CurrencyType pYakujyouCurrencyType = null;
                if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokuseiSyu.getPtratkituukasiteikbn())){
                    pYakujyouCurrencyType = hrktuukasyuType;
                }
                else {
                    pYakujyouCurrencyType = currencyType;
                }
                BizCurrency tkbriknsnhrkpYakujyou = BizCurrency.valueOf(0, pYakujyouCurrencyType);
                BizCurrency hrktuukatukiknznhrkp = BizCurrency.valueOf(0, hrktuukasyuType);
                BizCurrency siteituukatukiknznhrkp = BizCurrency.valueOf(0, currencyType);
                BizCurrency tkbriknsnhrkp = BizCurrency.valueOf(0, currencyType);

                if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                    tkbriknsnhrkp = mosKihon.getSeitoufstpkei();
                    hrktuukatukiknznhrkp = mosKihon.getFstphrkgk();
                    siteituukatukiknznhrkp = mosKihon.getSeitoufstpkei();
                    if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                        tkbriknsnhrkpYen = tkbriknsnhrkp;
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
                            for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
                                tkbriknsnhrkpYen = tkbriknsnhrkpYen.add(mosSyouhn.getHrktuukasyutkp());
                            }
                        }
                        else {
                            tkbriknsnhrkpYen = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY, tkbriknsnhrkp, enknsnKawaseRate, C_HasuusyoriKbn.SUTE);
                        }
                    }
                }
                else {
                    tkbriknsnhrkpYen = BizCurrency.valueOf(0, pYakujyouCurrencyType);
                    for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
                        tkbriknsnhrkpYakujyou = tkbriknsnhrkpYakujyou.add(mosSyouhn.getHrktuukasyutkp());
                        siteituukatukiknznhrkp = siteituukatukiknznhrkp.add(mosSyouhn.getSyutkp());
                    }
                    siteituukatukiknznhrkp = siteituukatukiknznhrkp.divide(keisanHrkkaisuu, 10, RoundingMode.DOWN)
                        .toValidValue(RoundingMode.DOWN);

                    if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokuseiSyu.getPtratkituukasiteikbn())) {
                        hrktuukatukiknznhrkp = tkbriknsnhrkpYakujyou.divide(keisanHrkkaisuu, 10, RoundingMode.DOWN)
                            .toValidValue(RoundingMode.DOWN);
                        if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
                            tkbriknsnhrkpYen = tkbriknsnhrkpYakujyou.divide(keisanHrkkaisuu, 0, RoundingMode.DOWN);
                        }
                        else {
                            tkbriknsnhrkpYen = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY, tkbriknsnhrkpYakujyou, enknsnKawaseRate, C_HasuusyoriKbn.SUTE).divide(keisanHrkkaisuu, 0, RoundingMode.DOWN);
                        }
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                            tkbriknsnhrkpYen = siteituukatukiknznhrkp;
                            hrktuukatukiknznhrkp = siteituukatukiknznhrkp;
                        }
                        else {
                            if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
                                BizCurrency nnbrihrkmpYen = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY, tkbriknsnhrkpYakujyou, syoriCTL.getNyknkwsrate(), C_HasuusyoriKbn.SUTE);
                                tkbriknsnhrkpYen = nnbrihrkmpYen.divide(keisanHrkkaisuu, 0, RoundingMode.DOWN);
                                hrktuukatukiknznhrkp = nnbrihrkmpYen.divide(keisanHrkkaisuu, 0, RoundingMode.DOWN);
                            }
                            else {
                                tkbriknsnhrkp = tkbriknsnhrkpYakujyou.divide(keisanHrkkaisuu, 0, RoundingMode.DOWN);
                                tkbriknsnhrkpYen = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY, tkbriknsnhrkp, enknsnKawaseRate, C_HasuusyoriKbn.SUTE);

                                if (mosKihon.getHrktuukasyu().eq(mosKihon.getKyktuukasyu())){
                                    hrktuukatukiknznhrkp = tkbriknsnhrkp;
                                }

                            }

                        }
                    }
                }

                BizNumber sjkkkTyouseiyouRiritu = BizNumber.ZERO;

                getSjkkktyouseiyourirituBean =
                    SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
                getSjkkktyouseiyourirituBean.setSyouhncd(mosSyouhnSyu.getSyouhncd());
                getSjkkktyouseiyourirituBean.setSknnkaisiymd(mosKihon.getSknnkaisiymd());
                getSjkkktyouseiyourirituBean.setKykymd(mosKihon.getKykymd());
                getSjkkktyouseiyourirituBean.setHknkkn(mosSyouhnSyu.getHknkkn());
                getSjkkktyouseiyourirituBean.setHknkknsmnkbn(mosSyouhnSyu.getHknkknsmnkbn());
                getSjkkktyouseiyourirituBean.setHhknnen(mosKihon.getHhknnen());

                C_ErrorKbn sjkkkTyouseiyouRirituErrorKbn = getSjkkktyouseiyouriritu.execKykji(getSjkkktyouseiyourirituBean);

                if (C_ErrorKbn.OK.eq(sjkkkTyouseiyouRirituErrorKbn)) {

                    sjkkkTyouseiyouRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                }

                C_PWaribikitekiyouKbn pwaribikitekiyoukbn = mosKihon.getPwaribikitekiyoukbn();
                String pwrbkkbn = "00";
                BizCurrency ztypwaribikihanteigkYen = BizCurrency.valueOf(0);
                if (!C_PWaribikitekiyouKbn.NONE.eq(pwaribikitekiyoukbn)) {
                    pwrbkkbn = pwaribikitekiyoukbn.getValue().substring(2);
                    ztypwaribikihanteigkYen = tkbriknsnhrkpYen;
                }

                String kzktrkServiceKbn = editPalRenkeiKoumoku.getKzktrkServiceKbn(syoriCTL);

                ZT_SeirituInfoTy seirituInfoTy = new ZT_SeirituInfoTy();

                seirituInfoTy.setZtykijyunym(syoriYm.toString());
                if (mosKihon.getSeisekiym() == null) {
                    seirituInfoTy.setZtyseisekiym("000000");
                }
                else {
                    seirituInfoTy.setZtyseisekiym(mosKihon.getSeisekiym().toString());
                }

                seirituInfoTy.setZtysyono(syoriCTL.getSyono());
                seirituInfoTy.setZtyhanbainm(SyouhinUtil.getSeirituJyouhouHanbaiNm(
                    mosSyouhnSyu.getSyouhnZokusei(), mosKihon.getKyktuukasyu()));
                seirituInfoTy.setZtyatkisisya(mosDairitenLst.get(0).getDrtenkanrisosikicd().substring(0, 3));
                seirituInfoTy.setZtyhknkkn(editPalRenkeiKoumoku.editKetasuuShiteiZeroUme(hknkkn,2));
                seirituInfoTy.setZtyphrkkikn(editPalRenkeiKoumoku.editKetasuuShiteiZeroUme(pHrkkkn,2));

                KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(
                    mosKihon.getSdpdkbn().getValue(), C_Sdpd.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);
                seirituInfoTy.setZtysdpdkbn(kbnInfoBean.getKbnData());

                seirituInfoTy.setZtyhrkkaisuukbn(hrkkaisuu);

                seirituInfoTy.setZtyhrkkeirokbn(ztyhrkkeiro);

                seirituInfoTy.setZtysinkykryouritukbn(skRyourituKbn);

                kbnInfoBean = bzKbnHenkanUtil.convKbn(mosKihon.getHaitoukinuketorihoukbn().getValue(),
                    C_HaitoukinuketorihouKbn.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);
                seirituInfoTy.setZtyduketorihouhoukbn(kbnInfoBean.getKbnData());

                if (kihonsYen.compareTo(BizCurrency.valueOf(999999999)) <= 0) {
                    seirituInfoTy.setZtykihons9(Long.parseLong(kihonsYen.toString()));
                }
                else {
                    seirituInfoTy.setZtykihons9(999999999l);
                }

                if (hsysYen.compareTo(BizCurrency.valueOf(99999999999l)) <= 0) {
                    seirituInfoTy.setZtyhsys(Long.parseLong(hsysYen.toString()));
                }
                else {
                    seirituInfoTy.setZtyhsys(99999999999l);
                }

                if (tkbriknsnhrkpYen.compareTo(BizCurrency.valueOf(99999999999l)) <= 0) {
                    seirituInfoTy.setZtytkbriknsnhrkp(Long.parseLong(tkbriknsnhrkpYen.toString()));
                }
                else {
                    seirituInfoTy.setZtytkbriknsnhrkp(99999999999l);
                }

                kbnInfoBean = bzKbnHenkanUtil.convKbn(mosKihon.getHhknsei().getValue(),
                    C_Hhknsei.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);
                seirituInfoTy.setZtyhhknseikbn(kbnInfoBean.getKbnData());

                seirituInfoTy.setZtykyksyaseikbn(editPalRenkeiKoumoku.editKykSyaseiKbn(
                    mosKihon.getKykkbn(), mosKihon.getHhknsei(), mosKihon.getKyksei()));
                seirituInfoTy.setZtyhhknnen2keta(editPalRenkeiKoumoku.editHhknnen(mosKihon.getHhknnen()));
                seirituInfoTy.setZtykyksyanen(editPalRenkeiKoumoku.editKyksyanen2Keta(
                    mosKihon.getKykkbn(), mosKihon.getHhknnen(), mosKihon.getKyknen()));

                if (!BizUtil.isBlank(mosKihon.getHhknsykgycd())) {
                    seirituInfoTy.setZtysykgycd(mosKihon.getHhknsykgycd());
                }
                else {
                    seirituInfoTy.setZtysykgycd("000");
                }

                seirituInfoTy.setZtykyksyakikykarihyj("0");
                seirituInfoTy.setZtyhknsyukigou(mosSyouhnSyu.getSyouhncd().substring(0, 2));
                seirituInfoTy.setZtysyokaipnyuukinhouhoukbn(editPalRenkeiKoumoku.editFstpNyknHouhouKbn(
                    syoriCTL.getNyknnrkumu(), mosKihon.getFstphrkkeirokbn()));
                seirituInfoTy.setZtytoukeiyousinsakbn(editPalRenkeiKoumoku.editToukeiyouSinsaKbn(
                    mosKihon.getSntkhoukbn()));

                if (C_BlnktkumuKbn.ARI.eq(mosKihon.getZenkizennouumu())) {
                    seirituInfoTy.setZtyzenkizennouhyouji("1");
                }
                else {
                    seirituInfoTy.setZtyzenkizennouhyouji("0");
                }

                seirituInfoTy.setZtyhhknsynensyuukbn(mosKihon.getHhknnensyuukbn().getValue());

                if (syukykpYen.compareTo(BizCurrency.valueOf(99999999999l)) <= 0) {
                    seirituInfoTy.setZtysyukeiyakup(Long.parseLong(syukykpYen.toString()));
                }
                else {
                    seirituInfoTy.setZtysyukeiyakup(99999999999l);
                }

                seirituInfoTy.setZtybsudirtnatkikeitaikbn(editPalRenkeiKoumoku.editBosyuuDairitenAtkiKeitaiKbn(
                    mosDairitenLst));

                if (mosKihon.getKykymd() == null) {
                    seirituInfoTy.setZtykykymd("00000000");
                }
                else {
                    seirituInfoTy.setZtykykymd(mosKihon.getKykymd().toString());
                }

                seirituInfoTy.setZtystdairiseikyuutkykarihyj(editPalRenkeiKoumoku.editTkariHyouji(
                    mosKihon.getStdrsktkyhkkbn()));

                seirituInfoTy.setZtypwaribikikbn(pwrbkkbn);
                if (ztypwaribikihanteigkYen.compareTo(BizCurrency.valueOf(99999999999l)) <= 0) {
                    seirituInfoTy.setZtypwaribikihanteigk(BizNumber.valueOf(new BigDecimal(ztypwaribikihanteigkYen
                        .toString())));
                }
                else {
                    seirituInfoTy.setZtypwaribikihanteigk(BizNumber.valueOf(99999999999l));
                }

                seirituInfoTy.setZtymannenreihyj("1");
                seirituInfoTy.setZtynksyuruikbn1(editPalRenkeiKoumoku.editNenkinsyu(mosSyouhnSyu.getSknenkinsyu()));
                seirituInfoTy.setZtynstkarihyj(editPalRenkeiKoumoku.editTkariHyouji(mosKihon.getNstkhkkbn()));
                seirituInfoTy.setZtyaatkioybsydrtencd(aAtkioybsyDrtenCd);
                seirituInfoTy.setZtybatkioybsydrtencd(bAtkioybsyDrtenCd);
                seirituInfoTy.setZtysinkeiyakujiyoteiriritu(mosSyouhnSyu.getYoteiriritu());

                if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                    if (BizNumber.valueOf(new BigDecimal(kihonsKyktuuka.toString())).compareTo(BizNumber.valueOf(99999999999.99)) <= 0) {
                        seirituInfoTy.setZtysiteituukakihons(BizNumber.valueOf(new BigDecimal(kihonsKyktuuka.toString())));
                    }
                    else {
                        seirituInfoTy.setZtysiteituukakihons(BizNumber.valueOf(99999999999.99));
                    }
                }

                seirituInfoTy.setZtyhrktuukakbn(editPalRenkeiKoumoku.editTuukaKbn(mosKihon.getHrktuukasyu()));
                seirituInfoTy.setZtysiteituukakbn(editPalRenkeiKoumoku.editTuukaKbn(mosKihon.getKyktuukasyu()));

                if (BizNumber.valueOf(new BigDecimal(hrktuukatukiknznhrkp.toString())).compareTo(BizNumber.valueOf(99999999999.99)) <= 0) {
                    seirituInfoTy.setZtyhrktuukatukiknznhrkp(BizNumber.valueOf(
                        new BigDecimal(hrktuukatukiknznhrkp.toString())));
                }
                else {
                    seirituInfoTy.setZtyhrktuukatukiknznhrkp(BizNumber.valueOf(99999999999.99));
                }
                if (BizNumber.valueOf(new BigDecimal(siteituukatukiknznhrkp.toString())).compareTo(BizNumber.valueOf(99999999999.99)) <= 0) {
                    seirituInfoTy.setZtysiteituukatukiknznhrkp(BizNumber.valueOf(
                        new BigDecimal(siteituukatukiknznhrkp.toString())));
                }
                else {
                    seirituInfoTy.setZtysiteituukatukiknznhrkp(BizNumber.valueOf(99999999999.99));
                }

                if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu()) &&
                    C_Tkhukaumu.HUKA.eq(mosKihon.getYennykntkhkkbn())) {
                    seirituInfoTy.setZtyyennyknrate(syoriCTL.getNyknkwsrate());
                }

                if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu()) &&
                    C_Tkhukaumu.HUKA.eq(mosKihon.getGaikanykntkhkkbn())) {
                    seirituInfoTy.setZtygaikanyknrate(syoriCTL.getNyknkwsrate());
                }

                seirituInfoTy.setZtyjyudkaigomehrtkarihyj(editPalRenkeiKoumoku.editTkariHyouji(mosKihon
                    .getJyudkaigomehrtkhkkbn()));

                if (C_Tkhukaumu.HUKA.eq(mosKihon.getSyksbyensitihsyutkhkkbn()) &&
                    !C_Tkhukaumu.HUKA.eq(mosKihon.getYennykntkhkkbn())) {

                    seirituInfoTy.setZtysyksbyensitihsyutkykrate(editPalRenkeiKoumoku
                        .getSyksbEnknsnKawaseRate(mosKihon.getKyktuukasyu(), enknsnKijyunYmd, mosKihon.getHrkkaisuu(),
                            mosKihon.getZennoumousideumu(), mosKihon.getIkkatubaraikbn()));
                }
                else {
                    seirituInfoTy.setZtysyksbyensitihsyutkykrate(BizNumber.valueOf(0));
                }

                seirituInfoTy.setZtysjkkktyouseiriritu(sjkkkTyouseiyouRiritu);

                if (!C_TargetTkMokuhyoutiKbn.BLNK.eq(mosKihon.getTargettkmkhtkbn())
                    && !C_TargetTkMokuhyoutiKbn.NOTARGET.eq(mosKihon.getTargettkmkhtkbn())) {
                    seirituInfoTy.setZtytargettkmkht(Integer.parseInt(mosKihon.getTargettkmkhtkbn().getValue()));
                }
                else {
                    seirituInfoTy.setZtytargettkmkht(0);
                }

                if (C_TumitatekinHaibunWariKbn.BLNK.eq(mosKihon.getTeirituhaibunwarikbn())) {
                    seirituInfoTy.setZtyteirituhaibunwari("000");
                }
                else {
                    seirituInfoTy.setZtyteirituhaibunwari(mosKihon.getTeirituhaibunwarikbn().getValue());
                }

                seirituInfoTy.setZtydai1hknkkn(editPalRenkeiKoumoku.editKetasuuShiteiZeroUme(mosSyouhnSyu.getDai1hknkkn(),2));

                seirituInfoTy.setZtykykdrtkykarihyj(editPalRenkeiKoumoku.editTkariHyouji(mosKihon
                    .getKykdrtkykhukakbn()));

                seirituInfoTy.setZtykzktrkservicetrkninzuu(kzktrkServiceKbn);

                seirituInfoTy.setZtyteikisiharaiarihyj(editPalRenkeiKoumoku.editTkariHyouji(mosKihon
                    .getTeikisiharaitkykhkkbn()));

                BizPropertyInitializer.initialize(seirituInfoTy);

                seirituInfoTyLst.add(seirituInfoTy);
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), kinou.getKinouNm()));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}