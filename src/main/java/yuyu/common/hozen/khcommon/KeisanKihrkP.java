package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.dba4keisankihrkp.KeisanKihrkPDao;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SumKihrkmpSeisanRirekiBean;
import yuyu.def.hozen.result.bean.SumNyknJissekiRirekiBean;

/**
 * 契約保全 契約保全共通 既払込Ｐ計算クラス
 */
public class KeisanKihrkP {

    private BizCurrency kihrkP;

    private BizCurrency yenKihrkP;

    private BizCurrency skjHrktuukaKihrkP;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KeisanKihrkPDao keisanKihrkPDao;

    @Inject
    private static Logger logger;

    public KeisanKihrkP() {
        super();
    }

    public C_ErrorKbn exec(String pSyono, C_Tuukasyu pKykTuukasyu) {

        logger.debug("▽ 既払込Ｐ計算 開始");

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pKykTuukasyu);

        BizCurrency yenkansanNyknkingkSum = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency yenmisyuupSum = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency yenMikeikapSum = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency kyktuukaNykngkSum = BizCurrency.valueOf(0, currencyType);

        BizCurrency kyktuukaMisyuupSum = BizCurrency.valueOf(0, currencyType);

        BizCurrency kyktuukaMikeikapSum = BizCurrency.valueOf(0, currencyType);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        SumNyknJissekiRirekiBean sumNyknJissekiRirekiBean =
            kykKihon.getSumNyknJissekiRirekiBeanByNyktrksflgNe(C_Nyktrksflg.TORIKESI);

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst =
            kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);

        if (nyknJissekiRirekiLst.size() == 0) {
            throw new CommonBizAppException("入金実績履歴情報取得に失敗しました。"
                + "証券番号：" + pSyono);
        }

        List<IT_Zennou> zennouList = keisanKihrkPDao.getZennous(pSyono);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        int syouhinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

        if (syouhinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            if (!C_Tuukasyu.JPY.eq(pKykTuukasyu)) {

                if (sumNyknJissekiRirekiBean != null) {

                    kyktuukaNykngkSum = sumNyknJissekiRirekiBean.getSumHrkp().get(currencyType);
                }

                if (zennouList.size() != 0 ) {

                    kyktuukaNykngkSum = kyktuukaNykngkSum.add(zennouList.get(0).getZennounyuukinkgk());
                }
            }
        }

        if (sumNyknJissekiRirekiBean != null) {

            if (C_Tuukasyu.JPY.eq(nyknJissekiRirekiLst.get(0).getRstuukasyu())) {

                if (sumNyknJissekiRirekiBean.getSumRsgaku().size() > 0) {

                    yenkansanNyknkingkSum = sumNyknJissekiRirekiBean.getSumRsgaku().get(BizCurrencyTypes.YEN);
                }
            }
            else {

                if (sumNyknJissekiRirekiBean.getSumYenkansannyknkingk().size() > 0) {

                    yenkansanNyknkingkSum = sumNyknJissekiRirekiBean.getSumYenkansannyknkingk().get(
                        BizCurrencyTypes.YEN);
                }
            }
        }

        if (zennouList != null && zennouList.size() > 0 ) {

            yenkansanNyknkingkSum = yenkansanNyknkingkSum.add(zennouList.get(0).getYenkansannyknkingk());
        }

        List<SumKihrkmpSeisanRirekiBean> sumKihrkmpSeisanRirekiBeanList = kykKihon.getSumKihrkmpSeisanRirekiBeans();

        for (SumKihrkmpSeisanRirekiBean sumKihrkmpSeisanRirekiBean : sumKihrkmpSeisanRirekiBeanList) {

            if (C_MisyuumikeikaKbn.MISYUUP.eq(sumKihrkmpSeisanRirekiBean.getMisyuumikeikakbn())) {

                yenmisyuupSum = yenmisyuupSum.add(
                    sumKihrkmpSeisanRirekiBean.getSumYenkansansspgoukei().get(BizCurrencyTypes.YEN));

                if (sumKihrkmpSeisanRirekiBean.getSumSeisanpgoukei().containsKey(currencyType)) {

                    kyktuukaMisyuupSum = kyktuukaMisyuupSum.add(sumKihrkmpSeisanRirekiBean.getSumSeisanpgoukei().get(currencyType));
                }
            }
            else if (C_MisyuumikeikaKbn.MIKEIKAP.eq(sumKihrkmpSeisanRirekiBean.getMisyuumikeikakbn())) {

                yenMikeikapSum = yenMikeikapSum.add(
                    sumKihrkmpSeisanRirekiBean.getSumYenkansansspgoukei().get(BizCurrencyTypes.YEN));


                if (sumKihrkmpSeisanRirekiBean.getSumSeisanpgoukei().containsKey(currencyType)) {

                    kyktuukaMikeikapSum = kyktuukaMikeikapSum.add(sumKihrkmpSeisanRirekiBean.getSumSeisanpgoukei().get(currencyType));
                }
            }
        }

        this.kihrkP = kyktuukaNykngkSum.add(kyktuukaMisyuupSum).subtract(kyktuukaMikeikapSum);

        this.yenKihrkP = yenkansanNyknkingkSum.add(yenmisyuupSum).subtract(yenMikeikapSum);

        if (this.kihrkP.compareTo(BizCurrency.valueOf(0, this.kihrkP.getType())) < 0) {

            this.kihrkP = BizCurrency.valueOf(0, currencyType);
        }

        if (this.yenKihrkP.compareTo(BizCurrency.valueOf(0)) < 0) {

            this.yenKihrkP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }

        if (C_Tuukasyu.JPY.eq(nyknJissekiRirekiLst.get(0).getRstuukasyu())) {

            this.skjHrktuukaKihrkP = this.yenKihrkP;
        }
        else {
            this.skjHrktuukaKihrkP = this.kihrkP;
        }

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        logger.debug("△ 既払込Ｐ計算 終了");

        return errorKbn;
    }

    public BizCurrency getKihrkP() {
        return this.kihrkP;
    }

    public BizCurrency getYenKihrkP() {
        return this.yenKihrkP;
    }
    public BizCurrency getSkjHrktuukaKihrkP() {
        return this.skjHrktuukaKihrkP;
    }
}