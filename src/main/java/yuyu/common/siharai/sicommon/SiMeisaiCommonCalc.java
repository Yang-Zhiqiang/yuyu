package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払明細書共通計算
 */
public class SiMeisaiCommonCalc {

    @Inject
    private static Logger logger;

    private BizCurrency shrmisisynykngk;

    private BizCurrency shrmisikztkgk;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    public C_ErrorKbn exec(SiMeisaiCommonCalcBean pSiMeisaiCommonCalcBean) {
        logger.debug("▽ 支払明細書共通計算 開始");

        if (pSiMeisaiCommonCalcBean == null) {
            logger.debug("【支払明細書共通計算】の与件が正しく設定されていません。");
            logger.debug("△ 支払明細書共通計算 終了");
            return C_ErrorKbn.ERROR;
        }

        shrmisisynykngk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        shrmisikztkgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        HasuuMsyPHensyu hasuuMsyPHensyu = SWAKInjector.getInstance(HasuuMsyPHensyu.class);

        HasuuMsyPHensyuBean hasuuMsyPHensyuBean = SWAKInjector.getInstance(HasuuMsyPHensyuBean.class);
        hasuuMsyPHensyuBean.setMisyuup(pSiMeisaiCommonCalcBean.getMisyuup());
        hasuuMsyPHensyuBean.setMikeikap(pSiMeisaiCommonCalcBean.getMikeikap());
        hasuuMsyPHensyuBean.setYenkamikeikap(pSiMeisaiCommonCalcBean.getYenkamikeikap());
        hasuuMsyPHensyuBean.setKyktuukasyu(pSiMeisaiCommonCalcBean.getKykTuukasyu());
        hasuuMsyPHensyuBean.setKwsrate(pSiMeisaiCommonCalcBean.getKawaseRate());

        hasuuMsyPHensyu.exec(hasuuMsyPHensyuBean);

        BizCurrency misyuuP = hasuuMsyPHensyu.getMisyuup();
        BizCurrency mikeikaP = hasuuMsyPHensyu.getMikeikap();
        BizCurrency yenkaMikeikaP = hasuuMsyPHensyu.getYenkamikeikap();

        if (C_Tuukasyu.JPY.eq(pSiMeisaiCommonCalcBean.getKykTuukasyu())) {

            if (C_ZeitratkiKbn.ITIJI.eq(pSiMeisaiCommonCalcBean.getZeitratkikbn())) {

                shrmisisynykngk = sumBizCurrency(pSiMeisaiCommonCalcBean.getHokenkngkgoukei(),
                    pSiMeisaiCommonCalcBean.getZennouseisankgk(),
                    mikeikaP,
                    pSiMeisaiCommonCalcBean.getHaitoukin(),
                    pSiMeisaiCommonCalcBean.getSonotahaitoukin());
            }

        } else {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pSiMeisaiCommonCalcBean.getKykTuukasyu());

            BizCurrency yenkaknsntkgk = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenkaknsnkekkakgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency gaikaknsntkgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency gaikaknsnkekkakgk = BizCurrency.valueOf(0, currencyType);
            BizCurrency gaikaSynykngk = BizCurrency.valueOf(0, currencyType);

            JM_SiSyouhnZokusei siSyouhnZokusei =
                siharaiDomManager.getSiSyouhnZokuseisBySyouhncd(pSiMeisaiCommonCalcBean.getSyouhinCd());

            if (C_Tuukasyu.JPY.eq(pSiMeisaiCommonCalcBean.getShrTuukasyu())) {

                if (C_ZeitratkiKbn.ITIJI.eq(pSiMeisaiCommonCalcBean.getZeitratkikbn())) {

                    yenkaknsntkgk = sumBizCurrency(pSiMeisaiCommonCalcBean.getHokenkngkgoukei(),
                        pSiMeisaiCommonCalcBean.getZitkazukarikingksiteituuka());

                    if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                        yenkaknsntkgk = sumBizCurrency(yenkaknsntkgk, pSiMeisaiCommonCalcBean.getZennouseisankgk());
                    }

                    if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                        yenkaknsntkgk = sumBizCurrency(yenkaknsntkgk, mikeikaP);
                    }

                    if (yenkaknsntkgk.compareTo(BizCurrency.valueOf(0, yenkaknsntkgk.getType())) > 0) {
                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                        yenkaknsnkekkakgk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, yenkaknsntkgk,
                            pSiMeisaiCommonCalcBean.getKawaseRate(), C_HasuusyoriKbn.AGE);
                    }

                    shrmisisynykngk = sumBizCurrency(yenkaknsnkekkakgk,
                        pSiMeisaiCommonCalcBean.getYenkahaitoukin(),
                        pSiMeisaiCommonCalcBean.getYenkasonotahaitoukin(),
                        pSiMeisaiCommonCalcBean.getZitkazukarikingkyen());

                    if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                        shrmisisynykngk = sumBizCurrency(shrmisisynykngk, pSiMeisaiCommonCalcBean.getYenkazennouseisankgk());
                    }

                    if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                        shrmisisynykngk = sumBizCurrency(shrmisisynykngk, yenkaMikeikaP);
                    }
                }

            } else {
                if (C_ZeitratkiKbn.ITIJI.eq(pSiMeisaiCommonCalcBean.getZeitratkikbn())) {

                    gaikaknsntkgk = sumBizCurrency(pSiMeisaiCommonCalcBean.getYenkahaitoukin(),
                        pSiMeisaiCommonCalcBean.getYenkasonotahaitoukin(),
                        pSiMeisaiCommonCalcBean.getZitkazukarikingkyen());

                    if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                        gaikaknsntkgk = sumBizCurrency(gaikaknsntkgk, pSiMeisaiCommonCalcBean.getYenkazennouseisankgk());
                    }

                    if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                        gaikaknsntkgk = sumBizCurrency(gaikaknsntkgk, yenkaMikeikaP);
                    }

                    if (gaikaknsntkgk.compareTo(BizCurrency.valueOf(0, gaikaknsntkgk.getType())) > 0) {
                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                        gaikaknsnkekkakgk = keisanGaikakanzan.execDivide(pSiMeisaiCommonCalcBean.getKykTuukasyu(),
                            gaikaknsntkgk, pSiMeisaiCommonCalcBean.getGaikaknsnkwsrate(), C_HasuusyoriKbn.AGE);
                    }

                    gaikaSynykngk = sumBizCurrency(pSiMeisaiCommonCalcBean.getHokenkngkgoukei(),
                        pSiMeisaiCommonCalcBean.getZitkazukarikingksiteituuka(), gaikaknsnkekkakgk);

                    if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                        gaikaSynykngk = sumBizCurrency(gaikaSynykngk, pSiMeisaiCommonCalcBean.getZennouseisankgk());
                    }

                    if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                        gaikaSynykngk = sumBizCurrency(gaikaSynykngk, mikeikaP);
                    }

                    if (gaikaSynykngk.compareTo(BizCurrency.valueOf(0, gaikaSynykngk.getType())) > 0) {
                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                        shrmisisynykngk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, gaikaSynykngk,
                            pSiMeisaiCommonCalcBean.getZeimukwsrate(), C_HasuusyoriKbn.SUTE);
                    }

                } else {

                    yenkaknsntkgk = sumBizCurrency(pSiMeisaiCommonCalcBean.getHokenkngkgoukei(),
                        pSiMeisaiCommonCalcBean.getZitkazukarikingksiteituuka()).subtract(misyuuP);

                    if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                        yenkaknsntkgk = sumBizCurrency(yenkaknsntkgk, pSiMeisaiCommonCalcBean.getZennouseisankgk());
                    }

                    if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                        yenkaknsntkgk = sumBizCurrency(yenkaknsntkgk, mikeikaP);
                    }

                    if (yenkaknsntkgk.compareTo(BizCurrency.valueOf(0, yenkaknsntkgk.getType())) > 0) {
                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                        yenkaknsnkekkakgk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, yenkaknsntkgk,
                            pSiMeisaiCommonCalcBean.getZeimukwsrate(), C_HasuusyoriKbn.SUTE);
                    }

                    shrmisikztkgk = sumBizCurrency(yenkaknsnkekkakgk,
                        pSiMeisaiCommonCalcBean.getYenkahaitoukin(),
                        pSiMeisaiCommonCalcBean.getYenkasonotahaitoukin(),
                        pSiMeisaiCommonCalcBean.getZitkazukarikingkyen(),
                        pSiMeisaiCommonCalcBean.getYenkakrkgk());

                    if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                        shrmisikztkgk = sumBizCurrency(shrmisikztkgk, pSiMeisaiCommonCalcBean.getYenkazennouseisankgk());
                    }

                    if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                        shrmisikztkgk = sumBizCurrency(shrmisikztkgk, yenkaMikeikaP);
                    }
                }
            }
        }

        logger.debug("△ 支払明細書共通計算 終了");
        return C_ErrorKbn.OK;
    }

    public BizCurrency getShrmisisynykngk() {
        return shrmisisynykngk;
    }

    public BizCurrency getShrmisikztkgk() {
        return shrmisikztkgk;
    }

    private BizCurrency sumBizCurrency(BizCurrency... bizCurrencies) {
        BizCurrency addResult = BizCurrency.valueOf(0, bizCurrencies[0].getType());

        for (int i = 0; i < bizCurrencies.length; i++) {
            addResult = addResult.add(bizCurrencies[i]);
        }

        return addResult;
    }
}