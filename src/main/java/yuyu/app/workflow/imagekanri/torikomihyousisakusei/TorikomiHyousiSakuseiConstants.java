package yuyu.app.workflow.imagekanri.torikomihyousisakusei;

/**
 * 取込用表紙作成 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class TorikomiHyousiSakuseiConstants extends GenTorikomiHyousiSakuseiConstants {

    public static final String SPLITTER = ".";

    public static final String ZERO = "0";

    public static final String BLANK = "";

    public static final String SYORITYUU = "処理中";

    public static final String SAKUSEI_LINK = "作成";

    public static final String KINOU_ID = "torikomiyouhyousisakusei";

    public static final String NENKINSIHARAI = "年金支払";

    public static final String HOZEN = "契約保全";

    public static final String SIHARAI = "保険金給付金支払";

    public static final String GYOUMU_KEY_SINKEIYAKU = "申込番号";

    public static final String GYOUMU_KEY_HOZEN = "証券番号";

    public static final String GYOUMU_KEY_SIHARAI = "証券番号";

    public static final String GYOUMU_KEY_NENKIN = "年金証書番号";

    public static final String MESSAGE_MOSNO = "申込番号 ";
    public static final String MESSAGE_SHOUKEN = "証券番号 ";
    public static final String MESSAGE_NENKIN = "年金証書番号 ";
    public static final String MESSAGE_ANKEN = "案件";

    public enum E_SubSystem {
        SINKEIYAKU ("sinkeiyaku"),
        KEIYAKUHOZEN("hozen"),
        HOKENKYUHUSIHARAI("siharai"),
        NENKINSIHARAI("nenkin");

        private final String name;
        E_SubSystem(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
}
