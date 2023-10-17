package yuyu.app.hozen.khozen.khyendthnkhrshr;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

/**
 * 円建変更時返戻金支払 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class KhYendtHnkHrShrConstants extends GenKhYendtHnkHrShrConstants {

    public static final String MIKEISANN                = "（未計算）";

    public static final String SHSKADRINFO_SHSADRKJ     = "送付先住所（漢字）";

    public static final String KYKSYASZKINFO_KYKSYASZKADRKJ     = "契約者相続人住所（漢字）";

    public static final String GAMENSYORIKBN_CONFIRM    = "confirm";

    public static final String GAMENSYORIKBN_SKSCONFIRM = "sksconfirm";

    public static final String KOUSAJOUHOU = "口座情報";

    public static final BizCurrency HYAKUMANEN          = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);
}
