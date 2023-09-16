
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 切断理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SetudanRiyuuKbn</td><td colspan="3">切断理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASSINNOERROR}</td><td>&quot;01&quot;</td><td>発信番号エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZIKANGAIERROR}</td><td>&quot;02&quot;</td><td>時間外エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUTERROR}</td><td>&quot;03&quot;</td><td>入力エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NINSYOUERROR}</td><td>&quot;04&quot;</td><td>認証エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #APIZIKKOUERROR}</td><td>&quot;05&quot;</td><td>ＡＰＩ実行エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIKANRYOU}</td><td>&quot;06&quot;</td><td>処理完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETUDEN}</td><td>&quot;07&quot;</td><td>切電</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IVRSYSTEMERROR}</td><td>&quot;99&quot;</td><td>ＩＶＲシステムエラー</td></tr>
 * </table>
 */
public class C_SetudanRiyuuKbn extends Classification<C_SetudanRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SetudanRiyuuKbn BLNK = new C_SetudanRiyuuKbn("0");

    public static final C_SetudanRiyuuKbn HASSINNOERROR = new C_SetudanRiyuuKbn("01");

    public static final C_SetudanRiyuuKbn ZIKANGAIERROR = new C_SetudanRiyuuKbn("02");

    public static final C_SetudanRiyuuKbn INPUTERROR = new C_SetudanRiyuuKbn("03");

    public static final C_SetudanRiyuuKbn NINSYOUERROR = new C_SetudanRiyuuKbn("04");

    public static final C_SetudanRiyuuKbn APIZIKKOUERROR = new C_SetudanRiyuuKbn("05");

    public static final C_SetudanRiyuuKbn SYORIKANRYOU = new C_SetudanRiyuuKbn("06");

    public static final C_SetudanRiyuuKbn SETUDEN = new C_SetudanRiyuuKbn("07");

    public static final C_SetudanRiyuuKbn IVRSYSTEMERROR = new C_SetudanRiyuuKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HASSINNOERROR, "HASSINNOERROR", false);
        addPattern(PATTERN_DEFAULT, ZIKANGAIERROR, "ZIKANGAIERROR", false);
        addPattern(PATTERN_DEFAULT, INPUTERROR, "INPUTERROR", false);
        addPattern(PATTERN_DEFAULT, NINSYOUERROR, "NINSYOUERROR", false);
        addPattern(PATTERN_DEFAULT, APIZIKKOUERROR, "APIZIKKOUERROR", false);
        addPattern(PATTERN_DEFAULT, SYORIKANRYOU, "SYORIKANRYOU", false);
        addPattern(PATTERN_DEFAULT, SETUDEN, "SETUDEN", false);
        addPattern(PATTERN_DEFAULT, IVRSYSTEMERROR, "IVRSYSTEMERROR", false);


        lock(C_SetudanRiyuuKbn.class);
    }

    private C_SetudanRiyuuKbn(String value) {
        super(value);
    }

    public static C_SetudanRiyuuKbn valueOf(String value) {
        return valueOf(C_SetudanRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SetudanRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SetudanRiyuuKbn.class, patternId, value);
    }
}
