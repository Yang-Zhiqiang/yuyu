
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約管理注意取扱区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KktyuitaKbn</td><td colspan="3">契約管理注意取扱区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DNGNMEMONASI}</td><td>&quot;1&quot;</td><td>伝言メモ（本社回送なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DNGNMEMOARI}</td><td>&quot;2&quot;</td><td>伝言メモ(本社回送あり)</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(画面表示用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DNGNMEMONASI}</td><td>&quot;1&quot;</td><td>伝言メモ(本社回送なし)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DNGNMEMOARI}</td><td>&quot;2&quot;</td><td>伝言メモ(本社回送あり)</td></tr>
 * </table>
 */
public class C_KktyuitaKbn extends Classification<C_KktyuitaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KktyuitaKbn BLNK = new C_KktyuitaKbn("0");

    public static final C_KktyuitaKbn DNGNMEMONASI = new C_KktyuitaKbn("1");

    public static final C_KktyuitaKbn DNGNMEMOARI = new C_KktyuitaKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DNGNMEMONASI, "DNGNMEMONASI", false);
        addPattern(PATTERN_DEFAULT, DNGNMEMOARI, "DNGNMEMOARI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", false);
        addPattern(PATTERN_SELECT, DNGNMEMONASI, "DNGNMEMONASI", false);
        addPattern(PATTERN_SELECT, DNGNMEMOARI, "DNGNMEMOARI", false);


        lock(C_KktyuitaKbn.class);
    }

    private C_KktyuitaKbn(String value) {
        super(value);
    }

    public static C_KktyuitaKbn valueOf(String value) {
        return valueOf(C_KktyuitaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KktyuitaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KktyuitaKbn.class, patternId, value);
    }
}
