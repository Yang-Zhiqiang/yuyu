package yuyu.app.workflow.processkanri.kouteitorikesi;


/**
 * 工程取消 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class KouteiTorikesiConstants extends GenKouteiTorikesiConstants {

    public static final String BLANK = "";

    public static final String SPLITTER = ".";

    public static final String KOUTEI_TORIKESI_LINK = "入力";

    public static final String GYOUMU_KEY_HOZEN = "証券番号";

    public static final String GYOUMU_KEY_SIHARAI = "証券番号";

    public static final String GYOUMU_KEY_NENKIN = "年金証書番号";

    public static final String MESSAGE_SHOUKEN = "証券番号 ";

    public static final String MESSAGE_NENKIN = "年金証書番号 ";

    public static final String KOUTEI_JYOUTAI = "処理中";

    public static final String KAISI_NENGAPPI = "未設定";

    public static final String ZERO = "0";


    public enum E_SubSystem {
        SINKEIYAKU("sinkeiyaku"),
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
