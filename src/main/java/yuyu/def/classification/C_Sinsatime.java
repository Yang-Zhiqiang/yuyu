
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 診査時刻 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Sinsatime</td><td colspan="3">診査時刻</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="25">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONE}</td><td>&quot;1&quot;</td><td>1</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWO}</td><td>&quot;2&quot;</td><td>2</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THREE}</td><td>&quot;3&quot;</td><td>3</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FOUR}</td><td>&quot;4&quot;</td><td>4</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FIVE}</td><td>&quot;5&quot;</td><td>5</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIX}</td><td>&quot;6&quot;</td><td>6</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEVEN}</td><td>&quot;7&quot;</td><td>7</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGHT}</td><td>&quot;8&quot;</td><td>8</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NINE}</td><td>&quot;9&quot;</td><td>9</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEN}</td><td>&quot;10&quot;</td><td>10</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ELEVEN}</td><td>&quot;11&quot;</td><td>11</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWELVE}</td><td>&quot;12&quot;</td><td>12</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THIRTEEN}</td><td>&quot;13&quot;</td><td>13</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FOURTEEN}</td><td>&quot;14&quot;</td><td>14</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FIFTEEN}</td><td>&quot;15&quot;</td><td>15</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIXTEEN}</td><td>&quot;16&quot;</td><td>16</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEVENTEEN}</td><td>&quot;17&quot;</td><td>17</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGHTEEN}</td><td>&quot;18&quot;</td><td>18</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NINETEEN}</td><td>&quot;19&quot;</td><td>19</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWENTY}</td><td>&quot;20&quot;</td><td>20</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWENTYONE}</td><td>&quot;21&quot;</td><td>21</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWENTYTWO}</td><td>&quot;22&quot;</td><td>22</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWENTYTHREE}</td><td>&quot;23&quot;</td><td>23</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWENTYFOUR}</td><td>&quot;24&quot;</td><td>24</td></tr>
 * </table>
 */
public class C_Sinsatime extends Classification<C_Sinsatime> {

    private static final long serialVersionUID = 1L;


    public static final C_Sinsatime BLNK = new C_Sinsatime("0");

    public static final C_Sinsatime ONE = new C_Sinsatime("1");

    public static final C_Sinsatime TWO = new C_Sinsatime("2");

    public static final C_Sinsatime THREE = new C_Sinsatime("3");

    public static final C_Sinsatime FOUR = new C_Sinsatime("4");

    public static final C_Sinsatime FIVE = new C_Sinsatime("5");

    public static final C_Sinsatime SIX = new C_Sinsatime("6");

    public static final C_Sinsatime SEVEN = new C_Sinsatime("7");

    public static final C_Sinsatime EIGHT = new C_Sinsatime("8");

    public static final C_Sinsatime NINE = new C_Sinsatime("9");

    public static final C_Sinsatime TEN = new C_Sinsatime("10");

    public static final C_Sinsatime ELEVEN = new C_Sinsatime("11");

    public static final C_Sinsatime TWELVE = new C_Sinsatime("12");

    public static final C_Sinsatime THIRTEEN = new C_Sinsatime("13");

    public static final C_Sinsatime FOURTEEN = new C_Sinsatime("14");

    public static final C_Sinsatime FIFTEEN = new C_Sinsatime("15");

    public static final C_Sinsatime SIXTEEN = new C_Sinsatime("16");

    public static final C_Sinsatime SEVENTEEN = new C_Sinsatime("17");

    public static final C_Sinsatime EIGHTEEN = new C_Sinsatime("18");

    public static final C_Sinsatime NINETEEN = new C_Sinsatime("19");

    public static final C_Sinsatime TWENTY = new C_Sinsatime("20");

    public static final C_Sinsatime TWENTYONE = new C_Sinsatime("21");

    public static final C_Sinsatime TWENTYTWO = new C_Sinsatime("22");

    public static final C_Sinsatime TWENTYTHREE = new C_Sinsatime("23");

    public static final C_Sinsatime TWENTYFOUR = new C_Sinsatime("24");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ONE, "ONE", false);
        addPattern(PATTERN_DEFAULT, TWO, "TWO", false);
        addPattern(PATTERN_DEFAULT, THREE, "THREE", false);
        addPattern(PATTERN_DEFAULT, FOUR, "FOUR", false);
        addPattern(PATTERN_DEFAULT, FIVE, "FIVE", false);
        addPattern(PATTERN_DEFAULT, SIX, "SIX", false);
        addPattern(PATTERN_DEFAULT, SEVEN, "SEVEN", false);
        addPattern(PATTERN_DEFAULT, EIGHT, "EIGHT", false);
        addPattern(PATTERN_DEFAULT, NINE, "NINE", false);
        addPattern(PATTERN_DEFAULT, TEN, "TEN", false);
        addPattern(PATTERN_DEFAULT, ELEVEN, "ELEVEN", false);
        addPattern(PATTERN_DEFAULT, TWELVE, "TWELVE", false);
        addPattern(PATTERN_DEFAULT, THIRTEEN, "THIRTEEN", false);
        addPattern(PATTERN_DEFAULT, FOURTEEN, "FOURTEEN", false);
        addPattern(PATTERN_DEFAULT, FIFTEEN, "FIFTEEN", false);
        addPattern(PATTERN_DEFAULT, SIXTEEN, "SIXTEEN", false);
        addPattern(PATTERN_DEFAULT, SEVENTEEN, "SEVENTEEN", false);
        addPattern(PATTERN_DEFAULT, EIGHTEEN, "EIGHTEEN", false);
        addPattern(PATTERN_DEFAULT, NINETEEN, "NINETEEN", false);
        addPattern(PATTERN_DEFAULT, TWENTY, "TWENTY", false);
        addPattern(PATTERN_DEFAULT, TWENTYONE, "TWENTYONE", false);
        addPattern(PATTERN_DEFAULT, TWENTYTWO, "TWENTYTWO", false);
        addPattern(PATTERN_DEFAULT, TWENTYTHREE, "TWENTYTHREE", false);
        addPattern(PATTERN_DEFAULT, TWENTYFOUR, "TWENTYFOUR", false);


        lock(C_Sinsatime.class);
    }

    private C_Sinsatime(String value) {
        super(value);
    }

    public static C_Sinsatime valueOf(String value) {
        return valueOf(C_Sinsatime.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Sinsatime.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Sinsatime.class, patternId, value);
    }
}
