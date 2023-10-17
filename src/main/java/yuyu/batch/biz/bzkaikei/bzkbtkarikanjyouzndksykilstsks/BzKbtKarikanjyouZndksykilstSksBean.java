package yuyu.batch.biz.bzkaikei.bzkbtkarikanjyouzndksykilstsks;

import java.io.Serializable;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Kanjyoukmkcd;

/**
 * 業務共通 経理・会計 個別仮勘定残高集計リスト作成用Beanクラス
 */
public class BzKbtKarikanjyouZndksykilstSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String huridenatesakicd;

    @Getter
    @Setter
    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Getter
    @Setter
    private String kanjyoukmknm;

    @Getter
    @Setter
    private BizDate denymd;

    @Getter
    @Setter
    private BizCurrency karikatamsgk;

    @Getter
    @Setter
    private long karikatamsks;

    @Getter
    @Setter
    private BizCurrency kasikatamsgk;

    @Getter
    @Setter
    private long kasikatamsks;
}
