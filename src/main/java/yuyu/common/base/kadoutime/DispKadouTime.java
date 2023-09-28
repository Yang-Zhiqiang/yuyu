package yuyu.common.base.kadoutime;

import static yuyu.common.base.kadoutime.KadouTimeConstants.*;
import yuyu.def.enumeration.E_HenkanKbn;

import com.google.common.base.Strings;

/**
 * 表示用稼働時間取得クラスです。
 */
public class DispKadouTime {

    private static final String COLON = ":";
    private static final String HALF_HYPHEN = "-";
    private static final String BLANK = " ";

    public static String getDispKadouTimesFromTo(KadouTimeTableData pKadouTimeTableData) {

        StringBuilder dispKadouTimesFromTo = new StringBuilder();

        for(int i=1; i<=MAX_KADOUTIME_COUNT; i++){
            if (!Strings.isNullOrEmpty(getKadouTimeFrom(pKadouTimeTableData, i))) {
                dispKadouTimesFromTo.append(getDispKadouTimeFromTo(getKadouTimeFrom(pKadouTimeTableData, i), getKadouTimeTo(pKadouTimeTableData, i)));
            }
        }

        return dispKadouTimesFromTo.toString();
    }

    public static void convDispInputKadouTimes(KadouTimeTableData pKadouTimeTableData, E_HenkanKbn pHenkanKbn) {

        String kadouTimeFrom;
        String kadouTimeTo;
        for(int i=1; i<=MAX_KADOUTIME_COUNT; i++){

            kadouTimeFrom = getKadouTimeFrom(pKadouTimeTableData, i);
            kadouTimeTo   = getKadouTimeTo  (pKadouTimeTableData, i);

            if (!Strings.isNullOrEmpty(kadouTimeFrom) && !Strings.isNullOrEmpty(kadouTimeTo)) {

                if(E_HenkanKbn.HYOUJI.equals(pHenkanKbn)){
                    kadouTimeFrom = getDispKadouTime(kadouTimeFrom);
                    kadouTimeTo   = getDispKadouTime(kadouTimeTo);

                }else{
                    kadouTimeFrom = getInputKadouTime(kadouTimeFrom);
                    kadouTimeTo   = getInputKadouTime(kadouTimeTo);
                }
            }

            setKadouTimeFrom(pKadouTimeTableData, i, kadouTimeFrom);
            setKadouTimeTo  (pKadouTimeTableData, i, kadouTimeTo);

        }
    }

    private static String getDispKadouTimeFromTo(String pKadouTimeFrom, String pKadouTimeTo) {

        StringBuilder kadouTime = new StringBuilder();

        kadouTime.append(getDispKadouTime(pKadouTimeFrom));

        kadouTime.append(HALF_HYPHEN);

        kadouTime.append(getDispKadouTime(pKadouTimeTo));

        kadouTime.append(BLANK);

        return kadouTime.toString();
    }

    private static String getDispKadouTime(String pKadouTime) {

        StringBuilder kadouTime = new StringBuilder();

        kadouTime.append(pKadouTime.subSequence(0, 2));
        kadouTime.append(COLON);
        kadouTime.append(pKadouTime.subSequence(2, 4));

        return kadouTime.toString();
    }

    private static String getInputKadouTime(String pKadouTime) {

        if (Strings.isNullOrEmpty(pKadouTime)) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        String[] kadouTimes = pKadouTime.split(COLON);

        for(String kadouTime : kadouTimes){
            if(!kadouTime.equals(COLON)){
                sb.append(kadouTime);
            }
        }

        return sb.toString();

    }

    private static String getKadouTimeFrom(KadouTimeTableData pKadouTimeTableData, int pIdx){
        switch(pIdx){
            case 1  : return pKadouTimeTableData.getKadouTimeFrom1();
            case 2  : return pKadouTimeTableData.getKadouTimeFrom2();
            case 3  : return pKadouTimeTableData.getKadouTimeFrom3();
            case 4  : return pKadouTimeTableData.getKadouTimeFrom4();
            case 5  : return pKadouTimeTableData.getKadouTimeFrom5();
            default : return null;
        }
    }

    private static String getKadouTimeTo(KadouTimeTableData pKadouTimeTableData, int pIdx){
        switch(pIdx){
            case 1  : return pKadouTimeTableData.getKadouTimeTo1();
            case 2  : return pKadouTimeTableData.getKadouTimeTo2();
            case 3  : return pKadouTimeTableData.getKadouTimeTo3();
            case 4  : return pKadouTimeTableData.getKadouTimeTo4();
            case 5  : return pKadouTimeTableData.getKadouTimeTo5();
            default : return null;
        }
    }

    private static void setKadouTimeFrom(KadouTimeTableData pKadouTimeTableData, int pIdx, String pKadouTimeFrom){
        switch(pIdx){
            case 1  : pKadouTimeTableData.setKadouTimeFrom1(pKadouTimeFrom); break;
            case 2  : pKadouTimeTableData.setKadouTimeFrom2(pKadouTimeFrom); break;
            case 3  : pKadouTimeTableData.setKadouTimeFrom3(pKadouTimeFrom); break;
            case 4  : pKadouTimeTableData.setKadouTimeFrom4(pKadouTimeFrom); break;
            case 5  : pKadouTimeTableData.setKadouTimeFrom5(pKadouTimeFrom); break;
            default : break;
        }
    }

    private static void setKadouTimeTo(KadouTimeTableData pKadouTimeTableData, int pIdx, String pKadouTimeTo){
        switch(pIdx){
            case 1  : pKadouTimeTableData.setKadouTimeTo1(pKadouTimeTo); break;
            case 2  : pKadouTimeTableData.setKadouTimeTo2(pKadouTimeTo); break;
            case 3  : pKadouTimeTableData.setKadouTimeTo3(pKadouTimeTo); break;
            case 4  : pKadouTimeTableData.setKadouTimeTo4(pKadouTimeTo); break;
            case 5  : pKadouTimeTableData.setKadouTimeTo5(pKadouTimeTo); break;
            default : break;
        }
    }
}
