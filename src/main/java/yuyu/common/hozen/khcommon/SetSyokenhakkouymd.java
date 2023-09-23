package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全 契約保全共通 証券発行日設定
 */
public class SetSyokenhakkouymd {

    public SetSyokenhakkouymd() {
        super();
    }

    public BizDate exec(BizDate pHanteibi) {

        BizDate syoHakkoubi = null;

        int syohakkoubiAddDays = 2;

        syoHakkoubi = pHanteibi.addBusinessDays(syohakkoubiAddDays);

        return syoHakkoubi;
    }
}