package yuyu.app.workflow.imagekanri.qrsealsakusei;

/**
 * QRシール用紙作成 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QRSealSakuseiConstants extends GenQRSealSakuseiConstants {
    public static final String SUBSYSTEM_NM = "新契約";

    public static final String JIMUTETUZUKI_NM = "新契約（代理店）";

    public static final String SUBSYSTEM_ID = "sinkeiyaku";

    public static final String JIMUTETUZUKI_CD = "skmaindairiten";

    public static final String KINOU_ID  = "qrsealsakusei";

    public static final String KINOU_ID_TORIKOMIYOU  = "torikomiyouhyousisakusei";

    public static final String SAKUJYO_LINK = "削除";

    public static final String BLANK = "";

    public static final String KBN_BLANK = "00";

    public static final String OUTKENSUU_ZERO = "0";

    public static final String MSG_MOSNO = "申込番号";
    public static final String MSG_SYORUI = "書類名";

    public static final String QR_FILE_DIR_PATH = "WEB-INF/classes/reports/qr/";

    public enum E_OutKeisiki {
        KENSUU("1"),
        MOSNO("2"),
        MOSNOSYORUI("3");

        private final String name;
        E_OutKeisiki(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
}
