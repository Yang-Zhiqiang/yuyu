package yuyu.app.hozen.khansyuu.khkzseibi.dba;

import javax.inject.Inject;

import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 *
 * 口座整備処理 口座整備処理機能DAOのクラスです。<br />
 *
 */
public class KhKzSeibiDao {

    @Inject
    private HozenDomManager hozenDomManager;

    public KhKzSeibiDao () {

    }

    public IT_KykKihon getKykKihon(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return kykKihon;
    }

    public IT_Kouza getKouza (IT_KykKihon pKykKihon) {

        IT_Kouza kouza = pKykKihon.getKouza();

        return kouza;
    }


    public void update (IT_KykKihon pKykKihon) {

        hozenDomManager.update(pKykKihon);
    }

    public IT_KhTtdkRireki createKhTtdkRireki(IT_KykKihon pKykKihon) {

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.createKhTtdkRireki();

        return khTtdkRireki;
    }
}
