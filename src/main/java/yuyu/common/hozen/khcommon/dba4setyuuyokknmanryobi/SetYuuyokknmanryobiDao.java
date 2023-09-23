package yuyu.common.hozen.khcommon.dba4setyuuyokknmanryobi;

import javax.inject.Inject;

import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 猶予期間満了日設定Daoクラス
 */
public class SetYuuyokknmanryobiDao {

    @Inject
    private HozenDomManager hozenDomManager;

    public IT_KykKihon getKykKihon(String pSyono){
        return hozenDomManager.getKykKihon(pSyono);
    }

    //    public List<IT_KykSyouhn> getKykSyouhns(IT_KykKihon pKykKihon, C_SyutkKbn pSyutkkbn){
    //        return pKykKihon.getKykSyouhnsBySyutkkbn(pSyutkkbn);
    //    }

    public IT_Tokusin getTokusin(String pSyono){
        IT_AnsyuKihon asyuKihon = hozenDomManager.getAnsyuKihon(pSyono);
        return asyuKihon.getTokusin();
    }
}
