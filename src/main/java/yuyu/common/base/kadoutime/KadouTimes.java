package yuyu.common.base.kadoutime;

import static yuyu.common.base.kadoutime.KadouTimeConstants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import yuyu.common.base.kadoutime.KadouTimeConstants.E_BlankStatus;
import yuyu.def.MessageId;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 稼働時間複数保持クラスです。
 * 稼働時間を最大５つ保持し、ソートやUiBeanのセット、稼働時間の重複チェック等を行います。
 */
public class KadouTimes{

    private KadouTimeUiBean kadouTimeUiBean;

    private List<KadouTime> kadouTimeList;

    private Map<Integer, KadouTime> kadouTimeMap;

    public KadouTimes(KadouTimeUiBean pKadouTimeUiBean){
        kadouTimeUiBean = pKadouTimeUiBean;
        init();
    }

    public void setupEntity(KadouTimeTableData pKadouTimeTableData){

        List<KadouTime> list = Lists.newArrayList(kadouTimeList);

        fillBlank(list);

        int i=0;
        for(KadouTime t :list){
            i++;
            setKadouTimes(pKadouTimeTableData, t, i);
        }
    }

    public void sort(){
        Collections.sort(kadouTimeList, new Comparator<KadouTime>() {
            @Override
            public int compare(KadouTime o1, KadouTime o2) {
                return o1.compareTo(o2);
            }
        });
    }

    int chkDuplication(){

        for(int i=1; i<kadouTimeList.size(); i++){

            if(!Strings.isNullOrEmpty(kadouTimeList.get(i).getKadouTimeFrom())){

                if(kadouTimeList.get(i).getKadouTimeFrom().compareTo(kadouTimeList.get(i-1).getKadouTimeTo()) < 0){
                    return i;
                }
            }
        }

        return MAX_KADOUTIME_COUNT+1;
    }

    boolean chkAllBlank(){

        for(KadouTime t : kadouTimeList){
            if(!t.getBlankStatus().equals(E_BlankStatus.BOTH_BLANK)){
                return false;
            }
        }
        return true;
    }

    int chkKadouTimeRange(){

        int iCount=0;
        for(KadouTime t : kadouTimeList){
            if(!t.chkContext()){
                return iCount;
            }
            iCount++;
        }
        return MAX_KADOUTIME_COUNT+1;
    }

    void chkKadouTimePartBlank(Item[] pKadouTimeFromItems, Item[] pKadouTimeToItems){
        int i=0;
        for(KadouTime t : kadouTimeList){
            E_BlankStatus s = t.getBlankStatus();
            switch(s){
                case TO_ONLY       : throw new BizLogicException(MessageId.EAC0027, pKadouTimeFromItems[i],pKadouTimeToItems[i]);
                case FROM_ONLY     : throw new BizLogicException(MessageId.EAC0027, pKadouTimeToItems[i]  ,pKadouTimeFromItems[i]);
                default :
            }
            i++;
        }
    }

    void setupUiBean(){

        List<KadouTime> list = Lists.newArrayList(kadouTimeList);

        fillBlank(list);

        int i = 0;
        for(KadouTime t : list){
            i++;
            kadouTimeUiBean.setKadouTime(t, i);
        }
    }

    void setSort() {
        int targetKadouTimeIdx = 0;
        boolean kadouTimeCheck = true;
        List<String> kadouTimeLists = new ArrayList<>();
        for ( KadouTime time :  kadouTimeList ) {
            kadouTimeLists.add(time.getKadouTimeFrom());
            kadouTimeLists.add(time.getKadouTimeTo());
        }

        for ( int idx = 0; idx < 9; idx += 2) {
            if ( kadouTimeCheck ) {
                targetKadouTimeIdx = idx;
                kadouTimeCheck = false;
            }

            if ( (targetKadouTimeIdx != idx) ) {
                if ( !Strings.isNullOrEmpty(kadouTimeLists.get(targetKadouTimeIdx)) && !Strings.isNullOrEmpty(kadouTimeLists.get(idx))) {
                    if ((kadouTimeLists.get(targetKadouTimeIdx).equals(kadouTimeLists.get(idx))) && (kadouTimeLists.get(targetKadouTimeIdx + 1).equals(kadouTimeLists.get(idx + 1))) ) {
                        kadouTimeList.set(idx / 2, new KadouTime("", ""));
                        kadouTimeLists.set(idx, "");
                        kadouTimeLists.set(idx + 1, "");
                    }
                }
            }

            if ( idx == 8 && targetKadouTimeIdx != 8 ) {
                idx = targetKadouTimeIdx;
                targetKadouTimeIdx += 2;
                kadouTimeCheck = true;
            }
        }
    }

    private static void fillBlank(List<KadouTime> pList){
        while(pList.size() < MAX_KADOUTIME_COUNT){
            pList.add(new KadouTime(null,null));
        }
    }

    private void init(){
        KadouTimeTableData ds = kadouTimeUiBean.getKadouTime();

        kadouTimeMap = Maps.newHashMap();
        kadouTimeMap.put(1, new KadouTime(ds.getKadouTimeFrom1(), ds.getKadouTimeTo1()));
        kadouTimeMap.put(2, new KadouTime(ds.getKadouTimeFrom2(), ds.getKadouTimeTo2()));
        kadouTimeMap.put(3, new KadouTime(ds.getKadouTimeFrom3(), ds.getKadouTimeTo3()));
        kadouTimeMap.put(4, new KadouTime(ds.getKadouTimeFrom4(), ds.getKadouTimeTo4()));
        kadouTimeMap.put(5, new KadouTime(ds.getKadouTimeFrom5(), ds.getKadouTimeTo5()));

        kadouTimeList = Lists.newArrayList();
        for(int idx = 1; idx <= kadouTimeMap.size(); idx++){
            kadouTimeList.add(kadouTimeMap.get(idx));
        }

        setupUiBean();
    }

    private static void setKadouTimes(KadouTimeTableData pKadouTimeTableData, KadouTime pKadouTime, int pIdx){

        switch(pIdx){
            case 1 : pKadouTimeTableData.setKadouTimeFrom1(pKadouTime.getKadouTimeFrom()); pKadouTimeTableData.setKadouTimeTo1(pKadouTime.getKadouTimeTo()); break;
            case 2 : pKadouTimeTableData.setKadouTimeFrom2(pKadouTime.getKadouTimeFrom()); pKadouTimeTableData.setKadouTimeTo2(pKadouTime.getKadouTimeTo()); break;
            case 3 : pKadouTimeTableData.setKadouTimeFrom3(pKadouTime.getKadouTimeFrom()); pKadouTimeTableData.setKadouTimeTo3(pKadouTime.getKadouTimeTo()); break;
            case 4 : pKadouTimeTableData.setKadouTimeFrom4(pKadouTime.getKadouTimeFrom()); pKadouTimeTableData.setKadouTimeTo4(pKadouTime.getKadouTimeTo()); break;
            case 5 : pKadouTimeTableData.setKadouTimeFrom5(pKadouTime.getKadouTimeFrom()); pKadouTimeTableData.setKadouTimeTo5(pKadouTime.getKadouTimeTo()); break;
            default :
        }
    }
}
