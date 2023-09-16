package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_HutanpoBui;

/**
 * 不担保部位マスタ(BM_HutanpoBuiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_HutanpoBuiDao extends AbstractDao<BM_HutanpoBui> {

    public BM_HutanpoBuiDao() {
        super(BM_HutanpoBui.class);
    }

    public BM_HutanpoBui getHutanpoBui(String pHtnpbuicd){
        BM_HutanpoBui bM_HutanpoBui =  new BM_HutanpoBui();
        bM_HutanpoBui.setHtnpbuicd(pHtnpbuicd);
        return this.selectOne(bM_HutanpoBui);
    }
}
