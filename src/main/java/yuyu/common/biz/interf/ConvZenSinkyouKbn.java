package yuyu.common.biz.interf;

import jp.co.slcs.swak.core.classification.Classification;
import yuyu.def.classification.C_TratkidrtenKbn;

/**
 * 業務共通 インターフェイス 区分変換クラス（全信協用）
 */
public class ConvZenSinkyouKbn {

    public static final int CONV_FOR_PACKAGE = 0;

    public static final int CONV_TO_PACKAGE = 1;

    private static final String  SPLITTER = "\\n";

    public static String getCodeCnv( Classification<?> pClassification, int pConvKbn ) {

        String[]    cdSys;
        String[]    cdItems;
        String      retStr;
        if (pClassification == null) {
            return "";
        }

        cdSys = getCodeTbl(pClassification);

        if (cdSys == null || cdSys.length <= 0) {
            return "";
        }
        retStr = "";
        for(int cnt=0 ; cnt < cdSys.length; cnt++){
            cdItems = split( cdSys[cnt] );

            if( pClassification.getValue().equals( cdItems[pConvKbn] ) ){
                retStr = cdItems[getConvIndex(pConvKbn)];
                break;
            }
        }
        return retStr;

    }

    private static String[] getCodeTbl( Classification<?> pClassification ) {

        String[]  cdItems = null;
        int       max      = 0;

        if( pClassification == null ){
            return null;
        }
        else if(pClassification instanceof C_TratkidrtenKbn){
            max = 2;
            cdItems = new String[max];
            cdItems[0] = C_TratkidrtenKbn.SINKIN + SPLITTER + "0";
            cdItems[1] = C_TratkidrtenKbn.KOKAISYA_DRTEN + SPLITTER + "1";
        }
        else{
            return null;
        }
        if( max <= 0 ){
            return null;
        }

        return cdItems;

    }

    private static String[] split( String pPrm ) {

        String[]    retStr;
        String      tmp;
        int         count;

        count = 1;
        tmp   = pPrm;
        while( tmp.indexOf( SPLITTER ) > -1 ){
            count++;
            tmp = tmp.substring( tmp.indexOf( SPLITTER ) + SPLITTER.length() );
        }

        retStr = new String[count];
        count = 0;
        tmp   = pPrm;
        while( tmp.indexOf( SPLITTER ) > -1 ){
            retStr[count] = tmp.substring( 0, tmp.indexOf( SPLITTER ) );
            count++;
            tmp = tmp.substring( tmp.indexOf( SPLITTER ) + SPLITTER.length() );
        }
        retStr[count] = tmp;

        return retStr;
    }

    private static int getConvIndex(int pConvKbn) {
        int convIndex = 0;
        if (pConvKbn == CONV_FOR_PACKAGE) {
            convIndex = 1;
        }
        return convIndex;
    }
}

