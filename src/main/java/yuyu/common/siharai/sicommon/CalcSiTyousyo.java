package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払調書金額計算
 */
public class CalcSiTyousyo {

    @Inject
    private static Logger logger;

    private CalcSiTyousyoBean calcSiTyousyoBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    public C_ErrorKbn exec(JT_Sk pSk, String pSyouhnCd) {

        logger.debug("▽ 支払調書金額計算 開始");

        calcSiTyousyoBean = SWAKInjector.getInstance(CalcSiTyousyoBean.class);

        if (pSk == null) {
            logger.debug("△ 支払調書金額計算 終了");
            return C_ErrorKbn.ERROR;
        }

        JM_SiSyouhnZokusei siSyouhnZokusei = siharaiDomManager.getSiSyouhnZokuseisBySyouhncd(pSyouhnCd);

        BizCurrency sshkd = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (C_Tuukasyu.JPY.eq(pSk.getKyktuukasyu())) {

            sshkd = pSk.getHaitoukin();
        }
        else {

            sshkd = pSk.getYenkahaitoukin();
        }

        HasuuMsyPHensyuBean hasuuMsyPHensyuBean = SWAKInjector.getInstance(HasuuMsyPHensyuBean.class);
        HasuuMsyPHensyu hasuuMsyPHensyu = SWAKInjector.getInstance(HasuuMsyPHensyu.class);

        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuuy(pSk.getMisyuupjyuutoukaisuuy());
        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuum(pSk.getMisyuupjyuutoukaisuum());
        hasuuMsyPHensyuBean.setMisyuupjyuutouym(pSk.getMisyuupjyuutouym());
        hasuuMsyPHensyuBean.setMisyuup(pSk.getMisyuup());
        hasuuMsyPHensyuBean.setYenkamisyuup(pSk.getYenkamisyuup());
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuuy(pSk.getMikeikapjyuutoukaisuuy());
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuum(pSk.getMikeikapjyuutoukaisuum());
        hasuuMsyPHensyuBean.setMikeikapjyuutouym(pSk.getMikeikapjyuutouym());
        hasuuMsyPHensyuBean.setMikeikap(pSk.getMikeikap());
        hasuuMsyPHensyuBean.setYenkamikeikap(pSk.getYenkamikeikap());
        hasuuMsyPHensyuBean.setKyktuukasyu(pSk.getKyktuukasyu());
        hasuuMsyPHensyuBean.setKwsrate(pSk.getShrkwsrate());

        hasuuMsyPHensyu.exec(hasuuMsyPHensyuBean);

        BizCurrency misyuup = hasuuMsyPHensyu.getMisyuup();
        BizCurrency mikeikap = hasuuMsyPHensyu.getMikeikap();
        BizCurrency yenkamikeikap = hasuuMsyPHensyu.getYenkamikeikap();

        BizCurrency warimsiShrGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency ttkeKstkganRi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency shrGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency znnphr = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency sshkshrgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency mihrkmP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (C_Tuukasyu.JPY.eq(pSk.getKyktuukasyu())) {

            shrGk = pSk.getHokenkngkgoukei();

            znnphr = mikeikap.add(pSk.getZennouseisankgk()).add(pSk.getAzukarikingk());

            mihrkmP = pSk.getKrkgk().subtract(misyuup);

            sshkshrgk = shrGk.add(warimsiShrGk).add(znnphr).add(ttkeKstkganRi).add(sshkd).add(mihrkmP);
        }
        else {

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            if (C_Tuukasyu.JPY.eq(pSk.getShrtuukasyu())) {

                shrGk = pSk.getYenhkgkgoukei();

                sshkshrgk = pSk.getYenshrgk().subtract(pSk.getYenshrtienrsk());

                boolean znnphrKumuChk = false;

                if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                    C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {

                    if (yenkamikeikap.add(pSk.getYenkazennouseisankgk()).add(
                        pSk.getYenkaazukarikingk()).compareTo(
                            BizCurrency.valueOf(0, yenkamikeikap.getType())) != 0) {

                        znnphrKumuChk = true;
                    }
                }

                if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                    C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {

                    if (mikeikap.add(pSk.getZennouseisankgk()).compareTo(
                        BizCurrency.valueOf(0, mikeikap.getType())) != 0) {

                        znnphrKumuChk = true;
                    }
                }

                BizCurrency  misyuupyen = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    misyuup,
                    pSk.getShrkwsrate(),
                    C_HasuusyoriKbn.SUTE);

                if (pSk.getYenkakrkgk().subtract(misyuupyen).compareTo(
                    BizCurrency.valueOf(0, pSk.getYenkakrkgk().getType())) != 0) {

                    if (!znnphrKumuChk) {

                        mihrkmP = sshkshrgk.subtract(shrGk.add(warimsiShrGk).add(ttkeKstkganRi).add(sshkd));
                    }
                    else {

                        mihrkmP = pSk.getYenkakrkgk().subtract(misyuupyen);
                    }
                }

                if (znnphrKumuChk) {

                    znnphr = sshkshrgk.subtract(shrGk.add(warimsiShrGk).add(ttkeKstkganRi).add(sshkd).add(mihrkmP));
                }
            }
            else {

                shrGk = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    pSk.getHokenkngkgoukei(),
                    pSk.getZeimukwsrate(),
                    C_HasuusyoriKbn.SUTE);

                BizCurrency kansanKingaku = pSk.getZitkazukarikingksiteituuka();

                if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {

                    kansanKingaku = kansanKingaku.add(mikeikap);
                }

                if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {

                    kansanKingaku = kansanKingaku.add(pSk.getZennouseisankgk());
                }

                BizCurrency kansanKingakuYen  = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    kansanKingaku,
                    pSk.getZeimukwsrate(),
                    C_HasuusyoriKbn.SUTE);

                znnphr = pSk.getZitkazukarikingkyen().add(kansanKingakuYen);

                if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {

                    znnphr = znnphr.add(yenkamikeikap);
                }

                if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {

                    znnphr = znnphr.add(pSk.getYenkazennouseisankgk());
                }

                BizCurrency misyuupyen = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    misyuup,
                    pSk.getZeimukwsrate(),
                    C_HasuusyoriKbn.SUTE);

                mihrkmP = pSk.getYenkakrkgk().subtract(misyuupyen);

                sshkshrgk = shrGk.add(warimsiShrGk).add(znnphr).add(ttkeKstkganRi).add(sshkd).add(mihrkmP);
            }
        }

        CalcSiTyousyoBean tempCalcSiTyousyoBean = SWAKInjector.getInstance(CalcSiTyousyoBean.class);

        if (shrGk.compareTo(YuyuBizConfig.getInstance().getShrtysyTsytHuyou()) <= 0) {

            tempCalcSiTyousyoBean.setOutUm(C_UmuKbn.NONE);

        } else {

            tempCalcSiTyousyoBean.setOutUm(C_UmuKbn.ARI);
            tempCalcSiTyousyoBean.setHokenkingaku(shrGk);
            tempCalcSiTyousyoBean.setWarimasihokenkingaku(warimsiShrGk);
            tempCalcSiTyousyoBean.setMiharaihaitou(sshkd);
            tempCalcSiTyousyoBean.setKasitukikingaku(ttkeKstkganRi);
            tempCalcSiTyousyoBean.setMiharaikomip(mihrkmP);
            tempCalcSiTyousyoBean.setZennouptou(znnphr);
            tempCalcSiTyousyoBean.setSasihikis(sshkshrgk);
            tempCalcSiTyousyoBean.setKibaraikomip(pSk.getGoukeihituyoukeihi());
        }

        calcSiTyousyoBean = tempCalcSiTyousyoBean;
        logger.debug("△ 支払調書金額計算 終了");
        return C_ErrorKbn.OK;
    }

    public CalcSiTyousyoBean getCalcSiTyousyoBean() {
        return calcSiTyousyoBean;
    }

}
