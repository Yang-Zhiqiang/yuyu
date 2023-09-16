package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HM_SiinBunrui;

/**
 * 死因分類マスタ(HM_SiinBunruiDao) アクセス用の DAO クラスです。<br />
 */
public class HM_SiinBunruiDao extends AbstractDao<HM_SiinBunrui> {

    public HM_SiinBunruiDao() {
        super(HM_SiinBunrui.class);
    }

    public HM_SiinBunrui getSiinBunrui(String pSiincd){
        HM_SiinBunrui hM_SiinBunrui =  new HM_SiinBunrui();
        hM_SiinBunrui.setSiincd(pSiincd);
        return this.selectOne(hM_SiinBunrui);
    }

}
