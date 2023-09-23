package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

/**
 * 契約保全 契約保全共通 決算年始日設定
 */
public class SetKessanNensibi {

    public SetKessanNensibi() {
        super();
    }

    public BizDate exec(BizDate pHanteibi) {

        BizDateMD kessanKijunbiMD = BizDateMD.valueOf(YuyuHozenConfig.getInstance().getKessanKijunbi());

        BizDate hanteibi = pHanteibi;

        int hanteibiY = hanteibi.getYear();


        BizDateMD hanteibiMD = hanteibi.getBizDateMD();

        BizDate kessanNensibi = null;


        if (hanteibiMD.compareTo(kessanKijunbiMD) >= 0) {

            kessanNensibi = BizDate.valueOf(hanteibiY, kessanKijunbiMD);
        }

        else {

            kessanNensibi = BizDate.valueOf(hanteibiY - 1, kessanKijunbiMD);
        }

        return kessanNensibi;
    }
}