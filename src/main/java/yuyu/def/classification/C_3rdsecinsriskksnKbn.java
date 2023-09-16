
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 第三分野保険リスク計算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_3rdsecinsriskksnKbn</td><td colspan="3">第三分野保険リスク計算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KEISAN_NASI}</td><td>&quot;0&quot;</td><td>計算しない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THIRDSECS_YOTEIHKKYHNS}</td><td>&quot;1&quot;</td><td>第三分野Ｓ×予定平均給付日数</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THIRDSECS}</td><td>&quot;2&quot;</td><td>第三分野Ｓ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENSUU}</td><td>&quot;3&quot;</td><td>件数</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THIRDSECS_KHNKYHKGBAIRITU}</td><td>&quot;4&quot;</td><td>第三分野Ｓ×基本給付金額倍率</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THIRDRDSECS_YOTEISGHKKYHNS}</td><td>&quot;5&quot;</td><td>第三分野Ｓ×予定災害平均給付日数</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THIRDRDSECS_YOTEISIPHKKYHNS}</td><td>&quot;6&quot;</td><td>第三分野Ｓ×予定疾病平均給付日数</td></tr>
 * </table>
 */
public class C_3rdsecinsriskksnKbn extends Classification<C_3rdsecinsriskksnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_3rdsecinsriskksnKbn KEISAN_NASI = new C_3rdsecinsriskksnKbn("0");

    public static final C_3rdsecinsriskksnKbn THIRDSECS_YOTEIHKKYHNS = new C_3rdsecinsriskksnKbn("1");

    public static final C_3rdsecinsriskksnKbn THIRDSECS = new C_3rdsecinsriskksnKbn("2");

    public static final C_3rdsecinsriskksnKbn KENSUU = new C_3rdsecinsriskksnKbn("3");

    public static final C_3rdsecinsriskksnKbn THIRDSECS_KHNKYHKGBAIRITU = new C_3rdsecinsriskksnKbn("4");

    public static final C_3rdsecinsriskksnKbn THIRDRDSECS_YOTEISGHKKYHNS = new C_3rdsecinsriskksnKbn("5");

    public static final C_3rdsecinsriskksnKbn THIRDRDSECS_YOTEISIPHKKYHNS = new C_3rdsecinsriskksnKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KEISAN_NASI, "KEISAN_NASI", true);
        addPattern(PATTERN_DEFAULT, THIRDSECS_YOTEIHKKYHNS, "THIRDSECS_YOTEIHKKYHNS", false);
        addPattern(PATTERN_DEFAULT, THIRDSECS, "THIRDSECS", false);
        addPattern(PATTERN_DEFAULT, KENSUU, "KENSUU", false);
        addPattern(PATTERN_DEFAULT, THIRDSECS_KHNKYHKGBAIRITU, "THIRDSECS_KHNKYHKGBAIRITU", false);
        addPattern(PATTERN_DEFAULT, THIRDRDSECS_YOTEISGHKKYHNS, "THIRDRDSECS_YOTEISGHKKYHNS", false);
        addPattern(PATTERN_DEFAULT, THIRDRDSECS_YOTEISIPHKKYHNS, "THIRDRDSECS_YOTEISIPHKKYHNS", false);


        lock(C_3rdsecinsriskksnKbn.class);
    }

    private C_3rdsecinsriskksnKbn(String value) {
        super(value);
    }

    public static C_3rdsecinsriskksnKbn valueOf(String value) {
        return valueOf(C_3rdsecinsriskksnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_3rdsecinsriskksnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_3rdsecinsriskksnKbn.class, patternId, value);
    }
}
