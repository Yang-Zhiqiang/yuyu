package yuyu.app.hozen.khansyuu.khonlinenyuukin.dba;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.hozen.manager.HozenDomManager;

import com.google.common.collect.Collections2;

/**
 * オンライン入金処理 オンライン入金処理DAOのクラスです。<br />
 */
public class KhOnlineNyuukinDao {

    @Inject
    private HozenDomManager hozenDomManager;

    public KhOnlineNyuukinDao () {

    }
    public IT_KykKihon getKykKihon(String pSyono) {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return kykKihon;
    }

    public void update (IT_KykKihon pKykKihon) {
        hozenDomManager.update(pKykKihon);
    }

    public void update (IT_AnsyuKihon pAnsyuKihon) {
        hozenDomManager.update(pAnsyuKihon);
    }

    public void insert (IT_KhDenpyoData pKhDenpyoData) {
        hozenDomManager.insert(pKhDenpyoData);
    }

    public void insert (IT_KhFBSoukinData pKhFBSoukinData) {
        hozenDomManager.insert(pKhFBSoukinData);
    }

    public IT_KhTtdkRireki createKhTtdkRireki (IT_KykKihon pKykKihon) {
        IT_KhTtdkRireki khTtdkRireki =  pKykKihon.createKhTtdkRireki();

        return khTtdkRireki;
    }

    public void insert(IT_NyuukinKakusyouData pNyuukinKakusyouData) {
        hozenDomManager.insert(pNyuukinKakusyouData);
    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyono) {
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);

        return ansyuKihon;
    }

    //    public List<IT_HrkeIraiInfo> getHrkeIraiInfos(IT_AnsyuKihon pAnsyuKihon) {
    //        List<IT_HrkeIraiInfo> hrkeIraiInfoList = new ArrayList<IT_HrkeIraiInfo>(Collections2.
    //            filter(pAnsyuKihon.getHrkeIraiInfos(), new FilterHrkeIraiInfo1(C_HrkeAnnaiJkKbn.ANNAITYUU)));
    //
    //        SortKhOnlineNyuukin sortKhOnlineNyuukin = new SortKhOnlineNyuukin();
    //
    //        hrkeIraiInfoList = sortKhOnlineNyuukin.OrderIT_HrkeIraiInfoByHrkkigenAsc(hrkeIraiInfoList);
    //
    //        return hrkeIraiInfoList;
    //    }

    public IT_Kariukekin getKariukekin(IT_KykKihon pKykKihon, Integer pKariukeNo) {

        List<IT_Kariukekin> kariukekinList = new ArrayList<IT_Kariukekin>(Collections2.
            filter(pKykKihon.getKariukekins(), new FilterKariukekins1(pKariukeNo, C_Krkseisanzumiflg.BLNK)));

        if (kariukekinList.size() == 0) {
            return null;
        }

        return kariukekinList.get(0);

    }

    public IT_Kariukekin getKariukekin2(IT_KykKihon pKykKihon, Integer pKariukeNo) {

        List<IT_Kariukekin> kariukekinList = new ArrayList<IT_Kariukekin>(Collections2.
            filter(pKykKihon.getKariukekins(), new FilterKariukekins2(pKariukeNo)));

        if (kariukekinList.size() == 0) {
            return null;
        }

        return kariukekinList.get(0);

    }

    //    public IT_HrkeIraiInfo getHrkeIraiInfo(IT_AnsyuKihon pAnsyuKihon, String pHenkouSikibetuKey) {
    //        List<IT_HrkeIraiInfo> hrkeIraiInfoList = new ArrayList<IT_HrkeIraiInfo>(Collections2.
    //            filter(pAnsyuKihon.getHrkeIraiInfos(), new FilterHrkeIraiInfo2(pHenkouSikibetuKey)));
    //
    //        if (hrkeIraiInfoList.size() == 0) {
    //            return null;
    //        }
    //
    //        return hrkeIraiInfoList.get(0);
    //    }

    public BM_SyouhnZokusei getSyouhnZokusei(IT_KykKihon pKykKihon) {

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        return syouhnZokusei;
    }
}
