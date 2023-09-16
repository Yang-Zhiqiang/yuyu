
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * マルチ照会動作区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MultidousaKbn</td><td colspan="3">マルチ照会動作区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKUSUUKENSAKUSOUSAKENGEN}</td><td>&quot;1&quot;</td><td>複数検索（操作権限制御）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKUSUUKENSAKUSYOUKAILEVEL}</td><td>&quot;2&quot;</td><td>複数検索（照会レベル制御）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEYINFOKENSAKU}</td><td>&quot;3&quot;</td><td>キー情報検索</td></tr>
 * </table>
 */
public class C_MultidousaKbn extends Classification<C_MultidousaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MultidousaKbn BLNK = new C_MultidousaKbn("0");

    public static final C_MultidousaKbn HUKUSUUKENSAKUSOUSAKENGEN = new C_MultidousaKbn("1");

    public static final C_MultidousaKbn HUKUSUUKENSAKUSYOUKAILEVEL = new C_MultidousaKbn("2");

    public static final C_MultidousaKbn KEYINFOKENSAKU = new C_MultidousaKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HUKUSUUKENSAKUSOUSAKENGEN, "HUKUSUUKENSAKUSOUSAKENGEN", false);
        addPattern(PATTERN_DEFAULT, HUKUSUUKENSAKUSYOUKAILEVEL, "HUKUSUUKENSAKUSYOUKAILEVEL", false);
        addPattern(PATTERN_DEFAULT, KEYINFOKENSAKU, "KEYINFOKENSAKU", false);


        lock(C_MultidousaKbn.class);
    }

    private C_MultidousaKbn(String value) {
        super(value);
    }

    public static C_MultidousaKbn valueOf(String value) {
        return valueOf(C_MultidousaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MultidousaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MultidousaKbn.class, patternId, value);
    }
}
