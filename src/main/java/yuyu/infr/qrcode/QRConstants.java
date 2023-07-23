package yuyu.infr.qrcode;

/**
 * QRコード生成用定数を定義します。
 */
public interface QRConstants {

    public static String OPTIONS_KEY_CONTENTS = "Contents";

    public static String OPTIONS_KEY_IMAGEFILE_NAME = "ImgFileName";

    public static String OPTIONS_KEY_FILE_TYPE = "FileType";

    public static String OPTIONS_KEY_ERROR_CORRECTION_LEVEL = "ErrorCorrectionLevel";

    public static String OPTIONS_KEY_RETURN_TYPE = "ReturnType";

    public static String OPTIONS_KEY_ENCODE_TYPE = "EncodeType";

    public static String OPTIONS_KEY_WIDTH = "Width";

    public static String OPTIONS_KEY_HEIGHT = "Height";

    public static String CHARSET_TYPE_SHIFT_JIS = "shift_jis";

    public static String CHARSET_TYPE_UTF_8 = "UTF-8";

    public static String DEFAULT_QRCODE_FILE_NAME = "barcode";

    public static String DEFAULT_QRCODE_FILE_TYPE = "gif";

    public static String DEFAULT_IMAGE_WIDTH = "117";

    public static String DEFAULT_IMAGE_HEIGHT = "117";

    public static String[] QRCODE_FILE_TYPE = { "png", "gif", "jpeg" };

    public static String[] QRCODE_CORRECTION_LEVEL = { "M", "H", "Q", "L" };

    public static String ERR_OPTIONS_NOT_SET = "QRコードの生成条件は未指定です。";

    public static String ERR_CREATE_QRCODE_FAILURE = "QRコードの生成に失敗しました。";

    public static String ERR_CONTENTS_NOT_SET = "作成する文字列が指定されていません。";

    public static String ERR_CORRECTION_LEVEL_NOT_SET = "誤り訂正レベルが指定されていません。";

    public static String ERR_IMAGE_WIDTH_NOT_SET = "QRコード画像の幅が未指定または空です。";

    public static String ERR_IMAGE_HEIGHT_NOT_SET = "QRコード画像の高さが未指定または空です。";

    public static String ERR_IMAGE_WIDTH_IS_NOT_NUMBER = "指定したQRコード画像の幅が無効な数値です。";

    public static String ERR_IMAGE_HEIGHT_IS_NOT_NUMBER = "指定したQRコード画像の高さが無効な数値です。";

    public static String ERR_CONTENTS_MAX_SIZE = "150文字程度まで指定可能です。";

    public static String ERR_IMAGE_BYTES_IS_EMPTY = "指定したイメージのバイナリ情報が空です。";

    public static String ERR_CREATE_QRCODE_EXCEPTION = "QRコード生成中に予期しないエラーが発生しました。再度、生成をやり直してください。";

    public static String ERR_FILE_TYPE_NOT_CORRECT = "指定するファイル形式が不正です。";

    public static String ERR_CORRECTION_LEVEL_NOT_CORRECT = "指定した誤り訂正レベルが不正です。";

    public static String ERR_IMAGE_WRITE_EXCEPTION = "イメージをファイルに書き込み時に異常が発生しました。";

    public static String ERR_IMAGE_IO_EXCEPTION = "イメージを読み込み中に異常が発生しました。";

    public static String ERR_RASTERFORMAT_EXCEPTION = "レイアウト情報が無効です。";

}