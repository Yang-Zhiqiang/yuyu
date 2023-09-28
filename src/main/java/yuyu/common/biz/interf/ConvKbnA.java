package yuyu.common.biz.interf;

import jp.co.slcs.swak.core.classification.Classification;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 業務共通 インターフェイス 区分変換クラスＡ
 */
public class ConvKbnA {

    public static final int CONV_FOR_PACKAGE = 0;

    public static final int CONV_TO_PACKAGE = 1;

    private static final String  SPLITTER = "\\n";

    public static String getCodeCnv(Classification<?> pClassification , int pConvKbn) {

        String[] codes;
        String[] codeItems;
        String ret;

        if (pClassification == null) {
            return "";
        }

        codes = getCodeTbl(pClassification);
        if (codes == null || codes.length <= 0) {
            return "";
        }

        ret = "";
        for (int cnt=0 ; cnt < codes.length; cnt++) {
            codeItems = split(codes[cnt]);

            if (pClassification.getValue().equals(codeItems[pConvKbn])) {
                ret = codeItems[getConvIndex(pConvKbn)];
                break;
            }
        }

        return ret;
    }

    private static String[] getCodeTbl(Classification<?> pClassification) {

        String[] codeItems = null;
        int max = 0;

        if (pClassification == null) {
            return null;
        }
        else if (pClassification instanceof C_YokinKbn) {
            max = 2;
            codeItems = new String[max];
            codeItems[0]   =     C_YokinKbn.HUTUU.getValue() + SPLITTER + "1";
            codeItems[1]   =     C_YokinKbn.TOUZA.getValue() + SPLITTER + "2";

        }
        else if (pClassification instanceof C_SinkeizkKbn) {
            max = 3;
            codeItems = new String[max];
            codeItems[0]   =     C_SinkeizkKbn.SHINKI.getValue() + SPLITTER + "1";
            codeItems[1]   =     C_SinkeizkKbn.HENKOU.getValue() + SPLITTER + "2";
            codeItems[2]   =     C_SinkeizkKbn.KEIZOKU.getValue() + SPLITTER + "0";
        }
        else if (pClassification instanceof C_HurihunoKbn) {
            max = 7;
            codeItems = new String[max];
            codeItems[0]   =     C_HurihunoKbn.BLNK.getValue() + SPLITTER + "0";
            codeItems[1]   =     C_HurihunoKbn.SIKINHUSOKU.getValue() + SPLITTER + "1";
            codeItems[2]   =     C_HurihunoKbn.NOKOZA.getValue() + SPLITTER + "2";
            codeItems[3]   =     C_HurihunoKbn.YKNSYATUGOU.getValue() + SPLITTER + "3";
            codeItems[4]   =     C_HurihunoKbn.NOKOUHURIIRAI.getValue() + SPLITTER + "4";
            codeItems[5]   =     C_HurihunoKbn.ITKTUGOU.getValue() + SPLITTER + "8";
            codeItems[6]   =     C_HurihunoKbn.OTHER.getValue() + SPLITTER + "9";
        }
        else{
            return null;
        }
        if(max <= 0){
            return null;
        }

        return codeItems;
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
