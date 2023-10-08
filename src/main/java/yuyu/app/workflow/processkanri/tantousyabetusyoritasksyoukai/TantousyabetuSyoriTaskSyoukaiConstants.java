package yuyu.app.workflow.processkanri.tantousyabetusyoritasksyoukai;

/**
 * 担当者別処理タスク照会 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class TantousyabetuSyoriTaskSyoukaiConstants extends GenTantousyabetuSyoriTaskSyoukaiConstants {

    public static final String LBL_GYOUMUKEY_SINKEIYAKU = "申込番号";

    public static final String LBL_GYOUMUKEY_KEIYAKUHOZEN = "証券番号";

    public static final String LBL_GYOUMUKEY_HOKENKYUHUSIHARAI = "証券番号";

    public static final String LBL_GYOUMUKEY_NENKINSIHARAI = "年金証書番号";

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
