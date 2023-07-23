package yuyu.infr.util;

import com.google.common.base.Strings;

public class Modulus10w21Util {

    public static int getCheckDigitModulus10w21(String pValue){

        if(pValue == null){
            return 0;
        }

        if(pValue.length() == 0){
            return 0;
        }

        long digitValue;

        try{
            digitValue = Long.valueOf(pValue);
        }catch (NumberFormatException e){
            throw new RuntimeException(e);
        }

        int weight = 2;
        int chkDigit = 0;

        while(digitValue > 0){
            int add = (int)(digitValue % 10) * weight;

            if(add >= 10){
                chkDigit += add % 10;

                add /= 10;

                chkDigit += add % 10;

            }else{
                chkDigit += add;
            }

            weight = (weight == 2) ? 1 : 2;

            digitValue /= 10;
        }

        if(chkDigit % 10 == 0){
            return 0;
        }

        return 10 - (chkDigit % 10);

    }

    public static String getStringCheckDigitModulus10w21(String pValue){

        if(pValue == null){
            return null;
        }

        return String.valueOf(getCheckDigitModulus10w21(pValue));
    }

    public static boolean chkModulus10w21(String pValue){

        if(Strings.isNullOrEmpty(pValue)){
            return true;
        }

        if(pValue.matches("[0]+")){
            return false;
        }

        if(!pValue.matches("[0-9]+")){
            return false;
        }

        if(pValue.length() == 1){
            return true;
        }

        String pCheckValue = pValue.substring(0,pValue.length()-1);

        String chkDigit;
        try{
            chkDigit = getStringCheckDigitModulus10w21(pCheckValue);
        }catch(RuntimeException e){
            return false;
        }

        if(chkDigit.equals(pValue.substring(pValue.length()-1))){
            return true;
        }

        return false;
    }
}
