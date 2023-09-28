package yuyu.common.base.kadoutime;

import jp.co.slcs.swak.util.string.StringUtil;
import lombok.Data;
import yuyu.common.base.kadoutime.KadouTimeConstants.E_BlankStatus;

import com.google.common.base.Strings;

/**
 * 稼働時間保持クラスです。
 * 稼働時間（自）と稼働時間（至）を保持します。<br />
 */
@Data
public class KadouTime {

    private static final String SEPARATOR = "@SEP@";
    private static final String MAX_TIME  = "9999";

    private String kadouTimeFrom = null;
    private String kadouTimeTo   = null;

    public KadouTime(String pKadouTimeFrom, String pKadouTimeTo){

        kadouTimeFrom = StringUtil.isNullOrBlank(pKadouTimeFrom) ? null : pKadouTimeFrom;
        kadouTimeTo   = StringUtil.isNullOrBlank(pKadouTimeTo)   ? null : pKadouTimeTo;
    }

    public E_BlankStatus getBlankStatus(){
        if(!Strings.isNullOrEmpty(kadouTimeFrom) &&
            Strings.isNullOrEmpty(kadouTimeTo)){
            return E_BlankStatus.TO_ONLY;
        }
        else if(Strings.isNullOrEmpty(kadouTimeFrom) &&
            !Strings.isNullOrEmpty(kadouTimeTo)){
            return E_BlankStatus.FROM_ONLY;
        }
        else if(Strings.isNullOrEmpty(kadouTimeFrom) &&
            Strings.isNullOrEmpty(kadouTimeTo)){
            return E_BlankStatus.BOTH_BLANK;
        }
        else{
            return E_BlankStatus.NOT_BLANK;
        }

    }

    @Override
    public boolean equals(Object t){

        if(t instanceof KadouTime){
            return this.getCompString().equals(((KadouTime)t).getCompString());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getCompString().hashCode();
    }

    int compareTo(KadouTime pKadouTime){

        if(compareToTime(kadouTimeFrom, pKadouTime.kadouTimeFrom) == 0){
            return compareToTime(kadouTimeTo, pKadouTime.kadouTimeTo);
        }
        return compareToTime(kadouTimeFrom, pKadouTime.kadouTimeFrom);
    }

    boolean chkContext(){
        if (!Strings.isNullOrEmpty(kadouTimeFrom) && !Strings.isNullOrEmpty(kadouTimeTo)) {

            if (kadouTimeFrom.compareTo(kadouTimeTo) > 0) {
                return false;
            }
        }
        return true;
    }

    private String getCompString(){
        return kadouTimeFrom + SEPARATOR + kadouTimeTo;
    }

    private static int compareToTime(String pTime1, String pTime2){
        return (Strings.isNullOrEmpty(pTime1) ? MAX_TIME : pTime1).compareTo((Strings.isNullOrEmpty(pTime2) ? MAX_TIME : pTime2));
    }

}
