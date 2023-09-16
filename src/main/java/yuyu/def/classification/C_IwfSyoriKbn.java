
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * Iwf処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IwfSyoriKbn</td><td colspan="3">Iwf処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="17">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NEW}</td><td>&quot;00&quot;</td><td>タスク生成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #START}</td><td>&quot;01&quot;</td><td>タスク実行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UPDATE}</td><td>&quot;02&quot;</td><td>工程情報更新</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRANSIT}</td><td>&quot;03&quot;</td><td>工程遷移</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ASSIGN}</td><td>&quot;04&quot;</td><td>タスク割当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RELEASE}</td><td>&quot;05&quot;</td><td>タスク割当解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FORCETRANSIT}</td><td>&quot;06&quot;</td><td>工程遷移（強制）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PROCESSCANCEL}</td><td>&quot;07&quot;</td><td>工程中断</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PROCESSSTART}</td><td>&quot;08&quot;</td><td>工程開始</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PROCESSEND}</td><td>&quot;09&quot;</td><td>工程終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PUTIMAGE}</td><td>&quot;10&quot;</td><td>イメージ登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DROPIMAGE}</td><td>&quot;11&quot;</td><td>イメージ削除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUTOPROCESSSTART}</td><td>&quot;12&quot;</td><td>自動工程開始</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKOUPROCESSSTART}</td><td>&quot;13&quot;</td><td>移行時工程開始</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETRELATION}</td><td>&quot;14&quot;</td><td>関連設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RELEASERELATION}</td><td>&quot;15&quot;</td><td>関連解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLANK}</td><td>&quot;99&quot;</td><td>未設定</td></tr>
 * </table>
 */
public class C_IwfSyoriKbn extends Classification<C_IwfSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IwfSyoriKbn NEW = new C_IwfSyoriKbn("00");

    public static final C_IwfSyoriKbn START = new C_IwfSyoriKbn("01");

    public static final C_IwfSyoriKbn UPDATE = new C_IwfSyoriKbn("02");

    public static final C_IwfSyoriKbn TRANSIT = new C_IwfSyoriKbn("03");

    public static final C_IwfSyoriKbn ASSIGN = new C_IwfSyoriKbn("04");

    public static final C_IwfSyoriKbn RELEASE = new C_IwfSyoriKbn("05");

    public static final C_IwfSyoriKbn FORCETRANSIT = new C_IwfSyoriKbn("06");

    public static final C_IwfSyoriKbn PROCESSCANCEL = new C_IwfSyoriKbn("07");

    public static final C_IwfSyoriKbn PROCESSSTART = new C_IwfSyoriKbn("08");

    public static final C_IwfSyoriKbn PROCESSEND = new C_IwfSyoriKbn("09");

    public static final C_IwfSyoriKbn PUTIMAGE = new C_IwfSyoriKbn("10");

    public static final C_IwfSyoriKbn DROPIMAGE = new C_IwfSyoriKbn("11");

    public static final C_IwfSyoriKbn AUTOPROCESSSTART = new C_IwfSyoriKbn("12");

    public static final C_IwfSyoriKbn IKOUPROCESSSTART = new C_IwfSyoriKbn("13");

    public static final C_IwfSyoriKbn SETRELATION = new C_IwfSyoriKbn("14");

    public static final C_IwfSyoriKbn RELEASERELATION = new C_IwfSyoriKbn("15");

    public static final C_IwfSyoriKbn BLANK = new C_IwfSyoriKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NEW, "NEW", true);
        addPattern(PATTERN_DEFAULT, START, "START", false);
        addPattern(PATTERN_DEFAULT, UPDATE, "UPDATE", false);
        addPattern(PATTERN_DEFAULT, TRANSIT, "TRANSIT", false);
        addPattern(PATTERN_DEFAULT, ASSIGN, "ASSIGN", false);
        addPattern(PATTERN_DEFAULT, RELEASE, "RELEASE", false);
        addPattern(PATTERN_DEFAULT, FORCETRANSIT, "FORCETRANSIT", false);
        addPattern(PATTERN_DEFAULT, PROCESSCANCEL, "PROCESSCANCEL", false);
        addPattern(PATTERN_DEFAULT, PROCESSSTART, "PROCESSSTART", false);
        addPattern(PATTERN_DEFAULT, PROCESSEND, "PROCESSEND", false);
        addPattern(PATTERN_DEFAULT, PUTIMAGE, "PUTIMAGE", false);
        addPattern(PATTERN_DEFAULT, DROPIMAGE, "DROPIMAGE", false);
        addPattern(PATTERN_DEFAULT, AUTOPROCESSSTART, "AUTOPROCESSSTART", false);
        addPattern(PATTERN_DEFAULT, IKOUPROCESSSTART, "IKOUPROCESSSTART", false);
        addPattern(PATTERN_DEFAULT, SETRELATION, "SETRELATION", false);
        addPattern(PATTERN_DEFAULT, RELEASERELATION, "RELEASERELATION", false);
        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", false);


        lock(C_IwfSyoriKbn.class);
    }

    private C_IwfSyoriKbn(String value) {
        super(value);
    }

    public static C_IwfSyoriKbn valueOf(String value) {
        return valueOf(C_IwfSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IwfSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IwfSyoriKbn.class, patternId, value);
    }
}
