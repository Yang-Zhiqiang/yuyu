package yuyu.app.workflow.imagekanri.imagesakujyo;

/**
 * イメージ削除 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class ImageSakujyoConstants extends GenImageSakujyoConstants {

    public static final String BLANK = "";

    public static final String SPLITTER = ".";

    public static final String HYOUJI_LINK = "表示";

    public static final String SAKUJO_LINK = "削除";

    public static final String LBL_GYOUMUKEY_SINKEIYAKU = "申込番号";

    public static final String LBL_GYOUMUKEY_KEIYAKUHOZEN = "証券番号";

    public static final String LBL_GYOUMUKEY_HOKENKYUHUSIHARAI = "証券番号";

    public static final String LBL_GYOUMUKEY_NENKINSIHARAI = "年金証書番号";

    public static final String MESSAGE_IMAGE = "イメージ";

    public static final String MESSAGE_ID = "IWF2160";

    public static final int ZERO = 0;
    static final int SEARCH_MAX = 1000;

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
