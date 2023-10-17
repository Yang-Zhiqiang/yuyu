package yuyu.app.hozen.khansyuu.khkariuketeisei.dba;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;
import yuyu.def.hozen.manager.HozenDomManager;

import com.google.common.collect.Iterables;

/**
 *
 * 仮受訂正 仮受訂正機能DAOのクラスです。<br />
 *
 */
public class KhKariukeTeiseiDao {

    @Inject
    private HozenDomManager hozenDomManager;

    public KhKariukeTeiseiDao () {

    }

    public IT_KykKihon getKykKihon(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return kykKihon;
    }

    public IT_Kariukekin getKariukekin (IT_KykKihon pKykKihon, Integer pKrkNo) {

        List<IT_Kariukekin> kariukekinLst = pKykKihon.getKariukekins();

        return Iterables.getFirst(Iterables.filter(kariukekinLst,new FilterKariukekin1(pKrkNo)), null);
    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyono) {

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);

        return ansyuKihon;
    }

    public IT_SyuunouHenknRireki createSyuunouHenknRireki (IT_AnsyuKihon pAnsyuKihon) {

        IT_SyuunouHenknRireki syuunouHenknRireki = pAnsyuKihon.createSyuunouHenknRireki();

        return syuunouHenknRireki;
    }

    public void update (IT_AnsyuKihon pAnsyuKihon) {
        hozenDomManager.update(pAnsyuKihon);
    }

    public void update (IT_KykKihon pKykKihon) {
        hozenDomManager.update(pKykKihon);
    }

    public void insert (IT_KhDenpyoData pKhDenpyoData) {
        hozenDomManager.insert(pKhDenpyoData);
    }

    public void insert (IT_KhFBSoukinData pKhFBSoukinData) {
        hozenDomManager.insert(pKhFBSoukinData);
    }

    public IT_KhTtdkRireki createKhTtdkRireki(IT_KykKihon pKykKihon) {

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.createKhTtdkRireki();

        return khTtdkRireki;
    }

    public IT_Kouza getKouza(IT_KykKihon pKykKihon) {

        IT_Kouza kouza = pKykKihon.getKouza();

        return kouza;
    }

    public IT_KykSyouhn getKykSyouhn(IT_KykKihon pKykKihon) {

        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        return kykSyouhnList.get(0);
    }
}
