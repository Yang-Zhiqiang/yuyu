
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 帳票作成対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tyhysksitisy</td><td colspan="3">帳票作成対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRMS}</td><td>&quot;1&quot;</td><td>支払明細書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHRTT}</td><td>&quot;2&quot;</td><td>不支払通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSNYI}</td><td>&quot;3&quot;</td><td>保障内容一覧</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHAN}</td><td>&quot;4&quot;</td><td>送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKS}</td><td>&quot;5&quot;</td><td>請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHKSDS}</td><td>&quot;6&quot;</td><td>給付金診断書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HBKSSJS}</td><td>&quot;7&quot;</td><td>不備解消指示書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HBTTS}</td><td>&quot;8&quot;</td><td>不備通知書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HBHORYUUL}</td><td>&quot;9&quot;</td><td>不備保留中リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYSIRAIS}</td><td>&quot;10&quot;</td><td>調査依頼書</td></tr>
 * </table>
 */
public class C_Tyhysksitisy extends Classification<C_Tyhysksitisy> {

    private static final long serialVersionUID = 1L;


    public static final C_Tyhysksitisy BLNK = new C_Tyhysksitisy("0");

    public static final C_Tyhysksitisy SHRMS = new C_Tyhysksitisy("1");

    public static final C_Tyhysksitisy HSHRTT = new C_Tyhysksitisy("2");

    public static final C_Tyhysksitisy HSNYI = new C_Tyhysksitisy("3");

    public static final C_Tyhysksitisy SHAN = new C_Tyhysksitisy("4");

    public static final C_Tyhysksitisy SKS = new C_Tyhysksitisy("5");

    public static final C_Tyhysksitisy KHKSDS = new C_Tyhysksitisy("6");

    public static final C_Tyhysksitisy HBKSSJS = new C_Tyhysksitisy("7");

    public static final C_Tyhysksitisy HBTTS = new C_Tyhysksitisy("8");

    public static final C_Tyhysksitisy HBHORYUUL = new C_Tyhysksitisy("9");

    public static final C_Tyhysksitisy TYSIRAIS = new C_Tyhysksitisy("10");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SHRMS, "SHRMS", false);
        addPattern(PATTERN_DEFAULT, HSHRTT, "HSHRTT", false);
        addPattern(PATTERN_DEFAULT, HSNYI, "HSNYI", false);
        addPattern(PATTERN_DEFAULT, SHAN, "SHAN", false);
        addPattern(PATTERN_DEFAULT, SKS, "SKS", false);
        addPattern(PATTERN_DEFAULT, KHKSDS, "KHKSDS", false);
        addPattern(PATTERN_DEFAULT, HBKSSJS, "HBKSSJS", false);
        addPattern(PATTERN_DEFAULT, HBTTS, "HBTTS", false);
        addPattern(PATTERN_DEFAULT, HBHORYUUL, "HBHORYUUL", false);
        addPattern(PATTERN_DEFAULT, TYSIRAIS, "TYSIRAIS", false);


        lock(C_Tyhysksitisy.class);
    }

    private C_Tyhysksitisy(String value) {
        super(value);
    }

    public static C_Tyhysksitisy valueOf(String value) {
        return valueOf(C_Tyhysksitisy.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tyhysksitisy.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tyhysksitisy.class, patternId, value);
    }
}
