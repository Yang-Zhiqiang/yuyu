package yuyu.app.hozen.khansyuu.khnyuukinsyoukai.dba;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 案内収納 入金照会機能Daoクラス
 */
public class KhNyuukinSyoukaiDao {

    @Inject
    private HozenDomManager hozenDomManager;

    public IT_KykKihon getKykKihon(String pSyono) {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return kykKihon;
    }

    public List<IT_KykSyouhn> getKykSyouhn(IT_KykKihon pKykKihon, C_SyutkKbn pSyutkKbn) {
        return pKykKihon.getKykSyouhnsBySyutkkbn(pSyutkKbn);
    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyono) {
        return hozenDomManager.getAnsyuKihon(pSyono);
    }
}
