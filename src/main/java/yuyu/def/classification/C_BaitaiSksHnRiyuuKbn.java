
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 媒体作成不能理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BaitaiSksHnRiyuuKbn</td><td colspan="3">媒体作成不能理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BAITAISAKUSEIHUKA}</td><td>&quot;90&quot;</td><td>ゆうゆうシステムで媒体作成不可</td></tr>
 * </table>
 */
public class C_BaitaiSksHnRiyuuKbn extends Classification<C_BaitaiSksHnRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BaitaiSksHnRiyuuKbn BLNK = new C_BaitaiSksHnRiyuuKbn("00");

    public static final C_BaitaiSksHnRiyuuKbn BAITAISAKUSEIHUKA = new C_BaitaiSksHnRiyuuKbn("90");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BAITAISAKUSEIHUKA, "BAITAISAKUSEIHUKA", false);


        lock(C_BaitaiSksHnRiyuuKbn.class);
    }

    private C_BaitaiSksHnRiyuuKbn(String value) {
        super(value);
    }

    public static C_BaitaiSksHnRiyuuKbn valueOf(String value) {
        return valueOf(C_BaitaiSksHnRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BaitaiSksHnRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BaitaiSksHnRiyuuKbn.class, patternId, value);
    }
}
