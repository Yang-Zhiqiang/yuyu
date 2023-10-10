package yuyu.app.hozen.khozen.khkaiyaku;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

/**
 * 解約 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class KhKaiyakuConstants extends GenKhKaiyakuConstants {

    public static final int KAWASERATE_SEIJYOU          = 0;

    public static final int KAWASERATE_MINASI           = 1;

    public static final BizCurrency HYAKUMANEN          = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

    public static final String MIKEISANN                = "（未計算）";

    public static final String GAMENSYORIKBN_CONFIRM    = "confirm";

    public static final String GAMENSYORIKBN_SKSCONFIRM = "sksconfirm";

    public static final String  KEISAN_HUNOU= "（計算不能）";

    public static final String  KAIYAKU= "解約";

    public static final String JPY_SIHARAI_MOUSIDE_NONE = "円貨支払申出なし";

    public static final String JPY_SIHARAI_MOUSIDE_ARI = "円貨支払申出あり";

}
