package yuyu.common.hozen.haitou;

import java.math.RoundingMode;
import java.util.ArrayList;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.haitou.SetDNnd.HaitouKaisuuBean;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 契約保全 配当 配当金計算（経過月数考慮）
 */
public class KeisanDKeikatukisuukouryo extends KeisanDJitugaku {

    public KeisanDKeikatukisuukouryo() {
    }

    @Override
    public C_ErrorKbn exec(KeisanDBean pKeisanDBean) {

        clear();

        haitoukin = ZEROYEN;

        keisanDInfoBeanList = new ArrayList<>();

        for (HaitouKaisuuBean haitouKaisuuBean : pKeisanDBean.getHaitouKaisuuBeanList()) {

            KeisanDInfoBean keisanDInfoBean = new KeisanDInfoBean();

            BizCurrency keisanKekka = ZEROYEN.multiply(haitouKaisuuBean.getKeikamon()).divide(BizNumber.valueOf(12),
                RoundingMode.DOWN);

            if (logger.isDebugEnabled()) {
                logger.debug("｜ ▽ 配当金計算情報");
                logger.debug("｜ ｜ 経過月数                  ＝ " + haitouKaisuuBean.getKeikamon());
                logger.debug("｜ ｜ 配当金                    ＝ " + keisanKekka);
                logger.debug("｜ △");
            }

            haitoukin = haitoukin.add(keisanKekka);
            keisanDInfoBean.setHaitoukinYen(keisanKekka);
            keisanDInfoBean.setKeikaTukisuu(haitouKaisuuBean.getKeikamon());
            keisanDInfoBeanList.add(keisanDInfoBean);
        }

        setRateDForKsn(pKeisanDBean.getKsnSiyouUmu());
        return C_ErrorKbn.OK;
    }
}
