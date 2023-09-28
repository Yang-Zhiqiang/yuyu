package yuyu.common.base.kadoutime;

import static yuyu.common.base.kadoutime.KadouTimeConstants.*;
import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KadouTimeSiteiKbn;

/**
 * 稼働時間関連チェッククラスです。
 */
public class KadouTimeRelationCheck {

    private KadouTimes kadouTimes;

    private Item[] kadouTimeFromItems;

    private Item[] kadouTimeToItems;

    public void init(KadouTimes pKadouTimes, Item[] pkadouTimeFromItems, Item[] pkadouTimeToItems){
        kadouTimes         = pKadouTimes;
        kadouTimeFromItems = pkadouTimeFromItems;
        kadouTimeToItems   = pkadouTimeToItems;
    }

    public void relationChk(Item[] pExceptionItems){

        chkAllBlank(pExceptionItems);

        kadouTimes.chkKadouTimePartBlank(kadouTimeFromItems, kadouTimeToItems);

        chkKadouTimeRange();

        chkKadouTimeDuplicate();

    }

    private void chkAllBlank(Item[] pExceptionItems){
        if(kadouTimes.chkAllBlank()){
            throw new BizLogicException(MessageId.EAF0030,
                pExceptionItems, C_KadouTimeSiteiKbn.SITEI.getContent(),
                MessageUtil.getMessage(MessageId.IAW0040));
        }
    }

    private void chkKadouTimeRange() {
        int rangeErrIdx = kadouTimes.chkKadouTimeRange();

        if(rangeErrIdx <= MAX_KADOUTIME_COUNT){
            throw new BizLogicException(MessageId.EAC0005, kadouTimeFromItems[rangeErrIdx], kadouTimeToItems[rangeErrIdx]);
        }
    }

    private void chkKadouTimeDuplicate() {
        kadouTimes.setSort();

        kadouTimes.sort();

        kadouTimes.setupUiBean();

        int dupIdx = kadouTimes.chkDuplication();

        if(dupIdx <= MAX_KADOUTIME_COUNT){
            throw new BizLogicException(MessageId.EAF0038,
                new Item[]{ kadouTimeToItems[dupIdx - 1], kadouTimeFromItems[dupIdx]},
                MessageUtil.getMessage(MessageId.IAW0040));
        }
    }
}
