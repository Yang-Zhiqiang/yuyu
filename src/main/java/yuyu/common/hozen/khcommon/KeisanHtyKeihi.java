package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.dba4keisanhtykeihi.KeisanHtyKeihiDao;
import yuyu.common.hozen.khcommon.dba4keisanhtykeihi.KihrkmpSeisanRirekiBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SumKihrkmpSeisanRirekiBean;
import yuyu.def.hozen.sorter.SortIT_KykSyaHenkouRireki;

/**
 * 契約保全 契約保全共通 必要経費計算クラス
 */
public class KeisanHtyKeihi {

    private BizCurrency htyKeihi;

    private BizCurrency yenHtyKeihi;

    private BizCurrency yenGenKykSyaHtyKeihi;

    private int kykSyaHenkouKaisuu;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KeisanHtyKeihiDao keisanHtyKeihiDao;

    @Inject
    private static Logger logger;

    public KeisanHtyKeihi() {
        super();
    }

    public C_ErrorKbn exec(String pSyono, C_Tuukasyu pKykTuukasyu) {

        logger.debug("▽ 必要経費計算 開始");

        KeisanKihrkP keisanKihrkP = SWAKInjector.getInstance(KeisanKihrkP.class);

        keisanKihrkP.exec(pSyono, pKykTuukasyu);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pKykTuukasyu);

        BizCurrency yenKihrkmP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        yenKihrkmP = keisanKihrkP.getYenKihrkP();


        BizCurrency yenHituyouKeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency yenkansanHenkankinSum = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency yenkansantuityoukinSum = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        SumKihrkmpSeisanRirekiBean sumKihrkmpSeisanRirekiBean = kykKihon.getSumKihrkmpSeisanRirekiBean();

        if (sumKihrkmpSeisanRirekiBean != null) {

            if (sumKihrkmpSeisanRirekiBean.getSumYenkansanhenkankin().size() > 0) {

                yenkansanHenkankinSum =
                    sumKihrkmpSeisanRirekiBean.getSumYenkansanhenkankin().get(BizCurrencyTypes.YEN);
            }

            if (sumKihrkmpSeisanRirekiBean.getSumYenkansantuityoukin().size() > 0) {

                yenkansantuityoukinSum =
                    sumKihrkmpSeisanRirekiBean.getSumYenkansantuityoukin().get(BizCurrencyTypes.YEN);
            }
        }

        BizCurrency yenKykEditKihrkmpsgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        List<IT_KykSyaHenkouRireki> KykSyaHenkouRirekiLst = hozenDomManager.getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(
            pSyono, C_Meigihnkjiyuu.KYK);

        if (KykSyaHenkouRirekiLst.size() != 0) {

            SortIT_KykSyaHenkouRireki kykSyaHenkouRirekiSort = SWAKInjector
                .getInstance(SortIT_KykSyaHenkouRireki.class);

            yenKykEditKihrkmpsgk = kykSyaHenkouRirekiSort
                .OrderIT_KykSyaHenkouRirekiByHenkouSikibetuKeyDesc(KykSyaHenkouRirekiLst).get(0).getKihrkmpsgk();
        }


        BizCurrency hituyoukeihiitijisytktysgkSum = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (KykSyaHenkouRirekiLst.size() != 0) {

            KihrkmpSeisanRirekiBean kihrkmpSeisanRirekiBean = keisanHtyKeihiDao
                .getKihrkmpSeisanRirekiBean(pSyono, KykSyaHenkouRirekiLst.get(0).getGyoumuKousinTime());

            if (kihrkmpSeisanRirekiBean != null) {

                hituyoukeihiitijisytktysgkSum = kihrkmpSeisanRirekiBean.getHituyoukeihiitijisytktysgk();
            }
        }


        yenHituyouKeihi = yenKihrkmP.add(yenkansantuityoukinSum).subtract(yenkansanHenkankinSum);

        if (yenHituyouKeihi.compareTo(BizCurrency.valueOf(0)) < 0) {

            yenHituyouKeihi = BizCurrency.valueOf(0);
        }

        BizCurrency yenGenKeiyakusyaHtyKeihi =
            yenHituyouKeihi.add(hituyoukeihiitijisytktysgkSum).subtract(yenKykEditKihrkmpsgk);

        if (yenGenKeiyakusyaHtyKeihi.compareTo(BizCurrency.valueOf(0)) < 0) {

            yenGenKeiyakusyaHtyKeihi = BizCurrency.valueOf(0);
        }

        this.htyKeihi = BizCurrency.valueOf(0, currencyType);

        this.yenHtyKeihi = yenHituyouKeihi;

        this.yenGenKykSyaHtyKeihi = yenGenKeiyakusyaHtyKeihi;

        this.kykSyaHenkouKaisuu = KykSyaHenkouRirekiLst.size();

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        logger.debug("△ 必要経費計算 終了");

        return errorKbn;
    }

    public BizCurrency getHtyKeihi() {
        return this.htyKeihi;
    }

    public BizCurrency getYenHtyKeihi() {
        return this.yenHtyKeihi;
    }

    public BizCurrency getYenGenKykSyaHtyKeihi() {
        return this.yenGenKykSyaHtyKeihi;
    }

    public int getKykSyaHenkouKaisuu() {
        return this.kykSyaHenkouKaisuu;
    }
}