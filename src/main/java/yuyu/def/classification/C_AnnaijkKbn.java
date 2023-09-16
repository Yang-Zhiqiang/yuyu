
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 案内状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AnnaijkKbn</td><td colspan="3">案内状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAI}</td><td>&quot;1&quot;</td><td>案内中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKIN}</td><td>&quot;2&quot;</td><td>入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MINYUU}</td><td>&quot;3&quot;</td><td>未入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAKETTYAKU}</td><td>&quot;4&quot;</td><td>その他決着済</td></tr>
 * </table>
 */
public class C_AnnaijkKbn extends Classification<C_AnnaijkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AnnaijkKbn BLNK = new C_AnnaijkKbn("0");

    public static final C_AnnaijkKbn ANNAI = new C_AnnaijkKbn("1");

    public static final C_AnnaijkKbn NYUUKIN = new C_AnnaijkKbn("2");

    public static final C_AnnaijkKbn MINYUU = new C_AnnaijkKbn("3");

    public static final C_AnnaijkKbn SONOTAKETTYAKU = new C_AnnaijkKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ANNAI, "ANNAI", false);
        addPattern(PATTERN_DEFAULT, NYUUKIN, "NYUUKIN", false);
        addPattern(PATTERN_DEFAULT, MINYUU, "MINYUU", false);
        addPattern(PATTERN_DEFAULT, SONOTAKETTYAKU, "SONOTAKETTYAKU", false);


        lock(C_AnnaijkKbn.class);
    }

    private C_AnnaijkKbn(String value) {
        super(value);
    }

    public static C_AnnaijkKbn valueOf(String value) {
        return valueOf(C_AnnaijkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AnnaijkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AnnaijkKbn.class, patternId, value);
    }
}
