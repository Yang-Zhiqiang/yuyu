
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 起動画面区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KidougmKbn</td><td colspan="3">起動画面区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUTKEY}</td><td>&quot;1&quot;</td><td>キー入力画面</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WORKLIST}</td><td>&quot;2&quot;</td><td>工程ワークリスト</td></tr>
 * </table>
 */
public class C_KidougmKbn extends Classification<C_KidougmKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KidougmKbn BLNK = new C_KidougmKbn("0");

    public static final C_KidougmKbn INPUTKEY = new C_KidougmKbn("1");

    public static final C_KidougmKbn WORKLIST = new C_KidougmKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, INPUTKEY, "INPUTKEY", false);
        addPattern(PATTERN_DEFAULT, WORKLIST, "WORKLIST", false);


        lock(C_KidougmKbn.class);
    }

    private C_KidougmKbn(String value) {
        super(value);
    }

    public static C_KidougmKbn valueOf(String value) {
        return valueOf(C_KidougmKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KidougmKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KidougmKbn.class, patternId, value);
    }
}
