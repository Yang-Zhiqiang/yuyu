package yuyu.app.hozen.khozen.khmeigihenkou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KhTtdkRireki;

import com.google.common.collect.Collections2;

/**
 * 名義変更（KhMeigiHenkou）の機能DAOクラスです。
 */
public class KhMeigiHenkouDao {

    @Inject
    private HozenDomManager hozenDomManager;

    public IT_KhTtdkRireki getKhTtdkRirekisMkhgktttYendthnktorikesiBySyono(String syoNo){

        IT_KykKihon wk_IT_KykKihon = hozenDomManager.getKykKihon(syoNo);

        List<IT_KhTtdkRireki> khTtdkRirekiList = wk_IT_KykKihon.getKhTtdkRirekis();

        List<IT_KhTtdkRireki> khTtdkRirekiList2 = new ArrayList<IT_KhTtdkRireki>(Collections2.filter(khTtdkRirekiList, new FilterKhTtdkRireki1(C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI)));

        if(khTtdkRirekiList2.size() == 0){

            return null;
        }

        SortIT_KhTtdkRireki sortIT_KhTtdkRireki = new SortIT_KhTtdkRireki();

        List<IT_KhTtdkRireki> khTtdkRirekiList3 = sortIT_KhTtdkRireki.OrderIT_KhTtdkRirekiBySyoriYmdDesc(khTtdkRirekiList2);

        return khTtdkRirekiList3.get(0);
    }
}
