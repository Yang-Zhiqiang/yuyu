package yuyu.infr.report.swakreport.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.co.slcs.swak.core.exception.ExRuntimeException;

/**
 * CSVファイル読み込み用の抽象基本クラスです。<br />
 * このクラスの実装は {@link #readLine(int, String[])} を実装しなければならず、
 * {@link #process()} を実行すると csv １行分の処理として {@link #readLine(int, String[])} がコールバックされます。
 */
public abstract class CsvReader {

    private static final String CSV_FILE_ENCODING = "Windows-31J";

    private InputStream inStream_;

    private String      encoding_;

    private int         cols_;

    @SuppressWarnings("resource")
    public CsvReader(File pFile) throws FileNotFoundException {
        this(new FileInputStream(pFile));
    }

    @SuppressWarnings("resource")
    public CsvReader(File pFile, String pEncoding) throws FileNotFoundException {
        this(new FileInputStream(pFile), pEncoding, 0);
    }

    @SuppressWarnings("resource")
    public CsvReader(File pFile, int pCols) throws FileNotFoundException {
        this(new FileInputStream(pFile), pCols);
    }

    @SuppressWarnings("resource")
    public CsvReader(File pFile, String pEncoding, int pCols) throws FileNotFoundException {
        this(new FileInputStream(pFile), pEncoding, pCols);
    }

    public CsvReader(InputStream pInStream) {
        this(pInStream, CSV_FILE_ENCODING, 0);
    }

    public CsvReader(InputStream pInStream, String pEncoding) {
        this(pInStream, pEncoding, 0);
    }

    public CsvReader(InputStream pInStream, int pCols) {
        this(pInStream, CSV_FILE_ENCODING, pCols);
    }

    public CsvReader(InputStream pInStream, String pEncoding, int pCols) {
        inStream_ = pInStream;
        encoding_ = pEncoding;
        cols_     = pCols;
    }

    public void process() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(inStream_, encoding_));
        } catch (UnsupportedEncodingException e) {
            throw new SyoruiZokuseiConfigurationException(e, "ESRP019", e.getClass().getSimpleName());
        }

        int rowNo = 0;
        try {
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    rowNo++;
                    if (readLine(rowNo, split(line)) == false) {
                        break;
                    }
                }
            } finally {
                reader.close();
            }
        } catch (Throwable t) {
            try {
                handleException(t, rowNo);
            } catch (Throwable t2) {
                if (t2 instanceof ExRuntimeException) {
                    throw (ExRuntimeException)t2;
                }
            }
            throw new SyoruiZokuseiConfigurationException(t, "ESRP020", t.getClass().getSimpleName());
        }
    }

    protected abstract boolean readLine(int pLineNo, String[] pValues) throws Throwable;

    protected void handleException(Throwable pThrowable, int pRowNo) throws Throwable {
    }

    private static Pattern quoted__ = Pattern.compile("^\"(.+)\"$");

    private static String[] empty__ = new String[0];

    protected String[] split(String pLine) {
        String[] values = pLine.split(",");
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i].trim();
            Matcher mat = quoted__.matcher(values[i]);
            if (mat.matches()) {
                values[i] = mat.group(1);
            }
        }

        if ((values.length == 1) && (values[0].length() == 0)) {
            return empty__;
        }

        if (cols_ > values.length) {
            String[] temp = Arrays.copyOf(values, cols_);
            Arrays.fill(temp, values.length, cols_, "");
            return temp;
        }
        return values;
    }
}
