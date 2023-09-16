package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.BM_SikinIdouGroup;

/**
 * 資金移動グループマスタ(BM_SikinIdouGroupDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SikinIdouGroupDao extends AbstractDao<BM_SikinIdouGroup> {

    public BM_SikinIdouGroupDao() {
        super(BM_SikinIdouGroup.class);
    }

    public BM_SikinIdouGroup getSikinIdouGroup(C_Segcd pSegcd) {
        BM_SikinIdouGroup bM_SikinIdouGroup =  new BM_SikinIdouGroup();
        bM_SikinIdouGroup.setSegcd(pSegcd);
        return this.selectOne(bM_SikinIdouGroup);
    }

}
