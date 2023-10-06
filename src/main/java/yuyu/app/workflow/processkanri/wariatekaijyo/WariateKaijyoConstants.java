package yuyu.app.workflow.processkanri.wariatekaijyo;

/**
 * 担当者割当解除 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WariateKaijyoConstants extends GenWariateKaijyoConstants {

    public static final String BLANK = "";

    public static final String SPLITTER = ".";

    public static final String WARIATE_KAIJYO_LINK = "割当解除";

    public static final String GYOUMU_KEY_SINKEIYAKU= "申込番号";

    public static final String GYOUMU_KEY_KEIYAKUHOZEN = "証券番号";

    public static final String GYOUMU_KEY_HOKENKYUHUSIHARAI = "証券番号";

    public static final String GYOUMU_KEY_NENKINSIHARAI= "年金証書番号";

    public static final int ZERO = 0;

    public static final int THOUSAND = 1000;

    public static final String IWF2160 = "IWF2160";

    public static final String AJAX_POST_PARAM_JIMUTETUZUKICD = "jimutetuzukicd";

    public static final String AJAX_POST_EVENTHANDLER ="_eventHandler=callAjaxCreateTantoSelect";

    public static final String MESSAGE_ANKEN = "案件";

    public enum E_SubSystem {
        SINKEIYAKU ("sinkeiyaku",1),
        KEIYAKUHOZEN("hozen",2),
        HOKENKYUHUSIHARAI("siharai",3),
        NENKINSIHARAI("nenkin",4);

        private String name;

        private int sortId;

        E_SubSystem(String name,int sortId) {
            this.name = name;
            this.sortId = sortId;
        }

        public String getName() {
            return name;
        }

        public int getSortId() {
            return sortId;
        }

    }



}
