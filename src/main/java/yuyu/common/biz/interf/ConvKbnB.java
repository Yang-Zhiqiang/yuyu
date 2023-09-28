package yuyu.common.biz.interf;

import jp.co.slcs.swak.core.classification.Classification;
import yuyu.def.classification.C_YokinKbn;

/**
 * 業務共通 インターフェイス 区分変換クラスＢ
 */
public class ConvKbnB {

    public static final int CONV_FOR_PACKAGE = 0;

    public static final int CONV_TO_PACKAGE = 1;

    private static final String SPLITTER = "\\n";

    public ConvKbnB() {
        super();
    }

    public static String getCodeCnv(Classification<?> pClassification, int pConvKbn) {

        String[] cds;
        String[] cdItems;
        String ret;
        if (pClassification == null) {
            return "";
        }

        cds = getCodeTbl(pClassification);

        if (cds == null || cds.length <= 0) {
            return "";
        }

        ret = "";
        for (int cnt = 0; cnt < cds.length; cnt++) {
            cdItems = split(cds[cnt]);

            if (pClassification.getValue().equals(cdItems[pConvKbn])) {
                ret = cdItems[getConvIndex(pConvKbn)];
                break;
            }
        }

        return ret;

    }

    private static String[] getCodeTbl(Classification<?> pClassification) {

        String[] cdItems = null;
        int max = 0;

        if (pClassification == null) {
            return null;
        }
        else if (pClassification instanceof C_YokinKbn) {
            max = 6;
            cdItems = new String[max];
            cdItems[0] = C_YokinKbn.HUTUU.getValue() + SPLITTER + "1";
            cdItems[1] = C_YokinKbn.TOUZA.getValue() + SPLITTER + "2";
            cdItems[2] = C_YokinKbn.TYOTIKU.getValue() + SPLITTER + "4";
            cdItems[3] = C_YokinKbn.TTYOKIN.getValue() + SPLITTER + "5";
            cdItems[4] = C_YokinKbn.TEIKI.getValue() + SPLITTER + "6";
            cdItems[5] = C_YokinKbn.TUMITATE.getValue() + SPLITTER + "7";
        }
        else {
            return null;
        }
        if (max <= 0) {
            return null;
        }

        return cdItems;

    }

    private static String[] split(String pPrm) {

        String[] rets;
        String tmp;
        int count;

        count = 1;
        tmp = pPrm;
        while (tmp.indexOf(SPLITTER) > -1) {
            count++;
            tmp = tmp.substring(tmp.indexOf(SPLITTER) + SPLITTER.length());
        }

        rets = new String[count];
        count = 0;
        tmp = pPrm;
        while (tmp.indexOf(SPLITTER) > -1) {
            rets[count] = tmp.substring(0, tmp.indexOf(SPLITTER));
            count++;
            tmp = tmp.substring(tmp.indexOf(SPLITTER) + SPLITTER.length());
        }
        rets[count] = tmp;

        return rets;
    }

    private static int getConvIndex(int pConvKbn) {
        int convIndex = 0;
        if (pConvKbn == CONV_FOR_PACKAGE) {
            convIndex = 1;
        }
        return convIndex;
    }
}
