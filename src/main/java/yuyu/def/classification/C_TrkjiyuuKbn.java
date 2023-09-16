
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 登録事由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TrkjiyuuKbn</td><td colspan="3">登録事由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;00&quot;</td><td>設定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SSKHNK_HJN}</td><td>&quot;01&quot;</td><td>組織変更（法人化等）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUUDOKURITU}</td><td>&quot;02&quot;</td><td>募集人独立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYZKHKNHNK}</td><td>&quot;03&quot;</td><td>所属会社変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYZKDRTENHNK}</td><td>&quot;04&quot;</td><td>所属代理店変更</td></tr>
 * </table>
 */
public class C_TrkjiyuuKbn extends Classification<C_TrkjiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TrkjiyuuKbn NONE = new C_TrkjiyuuKbn("00");

    public static final C_TrkjiyuuKbn SSKHNK_HJN = new C_TrkjiyuuKbn("01");

    public static final C_TrkjiyuuKbn BOSYUUDOKURITU = new C_TrkjiyuuKbn("02");

    public static final C_TrkjiyuuKbn SYZKHKNHNK = new C_TrkjiyuuKbn("03");

    public static final C_TrkjiyuuKbn SYZKDRTENHNK = new C_TrkjiyuuKbn("04");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, SSKHNK_HJN, "SSKHNK_HJN", false);
        addPattern(PATTERN_DEFAULT, BOSYUUDOKURITU, "BOSYUUDOKURITU", false);
        addPattern(PATTERN_DEFAULT, SYZKHKNHNK, "SYZKHKNHNK", false);
        addPattern(PATTERN_DEFAULT, SYZKDRTENHNK, "SYZKDRTENHNK", false);


        lock(C_TrkjiyuuKbn.class);
    }

    private C_TrkjiyuuKbn(String value) {
        super(value);
    }

    public static C_TrkjiyuuKbn valueOf(String value) {
        return valueOf(C_TrkjiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TrkjiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TrkjiyuuKbn.class, patternId, value);
    }
}
