package yuyu.common.hozen.khcommon.dba4gettkjitenzennouinfo;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Zennou;

import com.google.common.collect.Collections2;

/**
 * 契約保全 契約保全共通 特定時点前納情報取得Daoクラス
 */
public class GetTkJitenZennouInfoDao {

    public IT_Zennou getZennou(IT_AnsyuKihon pAnsyuKihon, BizDate pZennoukaisiYmd,
        Integer pRenno) {

        List<IT_Zennou> zennouList = pAnsyuKihon.getZennous();

        List<IT_Zennou> zennouFilterList = new ArrayList<IT_Zennou>(Collections2.filter(zennouList,
            new FilterZennou1(pZennoukaisiYmd, pRenno)));

        if (zennouFilterList.size() > 0) {
            return zennouFilterList.get(0);
        }
        return null;
    }

}
