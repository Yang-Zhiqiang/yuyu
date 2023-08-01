package yuyu.def;

import java.nio.charset.Charset;

public class YuyuStandardCharsets {

    private YuyuStandardCharsets() {
    }

    public static final String SHIFT_JIS_STRING = "Shift_JIS";

    public static final String WINDOWS_31J_STRING = "windows-31j";

    public static final String EUC_JP_STRING = "EUC-JP";

    public static final String ISO_2022_JP_STRING = "ISO-2022-JP";

    public static final String IBM500_STRING = "IBM500";

    public static final String X_IBM930_STRING = "x-IBM930";

    public static final String US_ASCII_STRING = "US-ASCII";

    public static final String ISO_8859_1_STRING = "ISO-8859-1";

    public static final String UTF_8_STRING = "UTF-8";

    public static final String UTF_16BE_STRING = "UTF-16BE";

    public static final String UTF_16LE_STRING = "UTF-16LE";

    public static final String UTF_16_STRING = "UTF-16";

    public static final Charset SHIFT_JIS = Charset.forName(SHIFT_JIS_STRING);

    public static final Charset WINDOWS_31J = Charset.forName(WINDOWS_31J_STRING);

    public static final Charset EUC_JP = Charset.forName(EUC_JP_STRING);

    public static final Charset ISO_2022_JP = Charset.forName(ISO_2022_JP_STRING);

    public static final Charset IBM500 = Charset.forName(IBM500_STRING);

    public static final Charset X_IBM930 = Charset.forName(X_IBM930_STRING);

    public static final Charset US_ASCII = Charset.forName(US_ASCII_STRING);

    public static final Charset ISO_8859_1 = Charset.forName(ISO_8859_1_STRING);

    public static final Charset UTF_8 = Charset.forName(UTF_8_STRING);

    public static final Charset UTF_16BE = Charset.forName(UTF_16BE_STRING);

    public static final Charset UTF_16LE = Charset.forName(UTF_16LE_STRING);

    public static final Charset UTF_16 = Charset.forName(UTF_16_STRING);

    public static boolean isCharset(String pString, Charset pCharSet){
        return pString.equals(new String(pString.getBytes(pCharSet),pCharSet));
    }

}
