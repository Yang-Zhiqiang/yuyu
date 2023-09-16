
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 書類情報一覧表示方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoruiInfoItiranHyoujiHouhouKbn</td><td colspan="3">書類情報一覧表示方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #JIMUTETUZUKI}</td><td>&quot;1&quot;</td><td>事務手続別</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINOU}</td><td>&quot;2&quot;</td><td>機能別</td></tr>
 * </table>
 */
public class C_SyoruiInfoItiranHyoujiHouhouKbn extends Classification<C_SyoruiInfoItiranHyoujiHouhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoruiInfoItiranHyoujiHouhouKbn JIMUTETUZUKI = new C_SyoruiInfoItiranHyoujiHouhouKbn("1");

    public static final C_SyoruiInfoItiranHyoujiHouhouKbn KINOU = new C_SyoruiInfoItiranHyoujiHouhouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, JIMUTETUZUKI, "JIMUTETUZUKI", true);
        addPattern(PATTERN_DEFAULT, KINOU, "KINOU", false);


        lock(C_SyoruiInfoItiranHyoujiHouhouKbn.class);
    }

    private C_SyoruiInfoItiranHyoujiHouhouKbn(String value) {
        super(value);
    }

    public static C_SyoruiInfoItiranHyoujiHouhouKbn valueOf(String value) {
        return valueOf(C_SyoruiInfoItiranHyoujiHouhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoruiInfoItiranHyoujiHouhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoruiInfoItiranHyoujiHouhouKbn.class, patternId, value);
    }
}
