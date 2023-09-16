
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 機能選択区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KinousentakuKbn</td><td colspan="3">機能選択区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ITIRAN}</td><td>&quot;1&quot;</td><td>一覧</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DATAHANEI}</td><td>&quot;2&quot;</td><td>データ反映</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DATASYUTOKU}</td><td>&quot;3&quot;</td><td>データ取得</td></tr>
 * </table>
 */
public class C_KinousentakuKbn extends Classification<C_KinousentakuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KinousentakuKbn ITIRAN = new C_KinousentakuKbn("1");

    public static final C_KinousentakuKbn DATAHANEI = new C_KinousentakuKbn("2");

    public static final C_KinousentakuKbn DATASYUTOKU = new C_KinousentakuKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ITIRAN, "ITIRAN", true);
        addPattern(PATTERN_DEFAULT, DATAHANEI, "DATAHANEI", false);
        addPattern(PATTERN_DEFAULT, DATASYUTOKU, "DATASYUTOKU", false);


        lock(C_KinousentakuKbn.class);
    }

    private C_KinousentakuKbn(String value) {
        super(value);
    }

    public static C_KinousentakuKbn valueOf(String value) {
        return valueOf(C_KinousentakuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KinousentakuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KinousentakuKbn.class, patternId, value);
    }
}
