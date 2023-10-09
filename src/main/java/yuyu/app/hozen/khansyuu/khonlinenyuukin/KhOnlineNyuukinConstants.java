package yuyu.app.hozen.khansyuu.khonlinenyuukin;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

/**
 * オンライン入金処理 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class KhOnlineNyuukinConstants extends GenKhOnlineNyuukinConstants {

    public static final String NYKNAIYOUKBN = "nyknaiyoukbn";

    public static final String RYOSYUYMD = "ryosyuymd";

    public static final String RSGAKU                  = "rsgaku";

    public static final String TYAKKINYMD = "tyakkinymd";

    public static final String HRKKAISUU = "hrkkaisuu";

    public static final String NYKINPUTDENYMD = "nykinputdenymd";

    public static final String SUITOSOSHIKICD = "suitososhikicd";

    public static final String TABAKARIKANJYONO = "tabakarikanjyono";

    public static final String NYKINPUTNYKKEIRO = "nykinputnykkeiro";

    public static final String NYKINPUTNYKNAIYOUKBN = "nykinputnyknaiyoukbn";

    public static final String NYKINPUTRYOSYUYMD = "nykinputryosyuymd";

    public static final String NYKINPUTHRKKAISUU = "nykinputhrkkaisuu";

    public static final BizCurrency MAX_KYOYOUKINGAKUYEN = BizCurrency.valueOf(10000000000L, BizCurrencyTypes.YEN);

    public static final String MAX_KYOYOUKINGAKUYEN_MSG = "領収金額がシステムで取扱可能な金額を超えています。";

    public static final String NYKINPUTDENYMD_HIEIGYOUBI_MSG = "伝票日付が非営業日";

}
