package yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku;


/**
 * 事務用コード入力 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class JimuyouCodeNyuuryokuConstants extends GenJimuyouCodeNyuuryokuConstants {

    public static final String GYOUMU_KEY_SINKEIYAKU = "申込番号";

    public static final String GYOUMU_KEY_HOZEN = "証券番号";

    public static final String GYOUMU_KEY_SIHARAI = "証券番号";

    public static final String GYOUMU_KEY_NENKIN = "年金証書番号";

    public static final String KOUTEIJYOUKYOU = "処理中";

    public static final String MESSAGE_MOSNO = "申込番号";
    public static final String MESSAGE_SHOUKEN = "証券番号";
    public static final String MESSAGE_NENKIN = "年金証書番号";
    public static final String MESSAGE_JIMUYOUCD = "事務用コード ";

    public static final String BLANK = "";

    public static final String SPLITTER = ".";

    public enum E_SubSystem {
        SINKEIYAKU ("sinkeiyaku"),
        KEIYAKUHOZEN("hozen"),
        HOKENKYUHUSIHARAI("siharai"),
        NENKINSIHARAI("nenkin");

        private String name;
        E_SubSystem(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
}
