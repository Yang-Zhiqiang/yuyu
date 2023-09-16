
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ後続事務確認発生事由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsKzkJmKknHsJyKbn</td><td colspan="3">ＤＳ後続事務確認発生事由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINE}</td><td>&quot;01&quot;</td><td>オンライン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAYOSESAKIHUMEI}</td><td>&quot;02&quot;</td><td>名寄先不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAYOSESAKIKEIYAKUIDOUTYUU}</td><td>&quot;03&quot;</td><td>名寄せ先契約異動中</td></tr>
 * </table>
 */
public class C_DsKzkJmKknHsJyKbn extends Classification<C_DsKzkJmKknHsJyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsKzkJmKknHsJyKbn BLNK = new C_DsKzkJmKknHsJyKbn("0");

    public static final C_DsKzkJmKknHsJyKbn ONLINE = new C_DsKzkJmKknHsJyKbn("01");

    public static final C_DsKzkJmKknHsJyKbn NAYOSESAKIHUMEI = new C_DsKzkJmKknHsJyKbn("02");

    public static final C_DsKzkJmKknHsJyKbn NAYOSESAKIKEIYAKUIDOUTYUU = new C_DsKzkJmKknHsJyKbn("03");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ONLINE, "ONLINE", false);
        addPattern(PATTERN_DEFAULT, NAYOSESAKIHUMEI, "NAYOSESAKIHUMEI", false);
        addPattern(PATTERN_DEFAULT, NAYOSESAKIKEIYAKUIDOUTYUU, "NAYOSESAKIKEIYAKUIDOUTYUU", false);


        lock(C_DsKzkJmKknHsJyKbn.class);
    }

    private C_DsKzkJmKknHsJyKbn(String value) {
        super(value);
    }

    public static C_DsKzkJmKknHsJyKbn valueOf(String value) {
        return valueOf(C_DsKzkJmKknHsJyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsKzkJmKknHsJyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsKzkJmKknHsJyKbn.class, patternId, value);
    }
}
