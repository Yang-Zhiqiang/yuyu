package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.db.entity.IM_Kykjyoutaikahi;

/**
 * 契約状態処理可否マスタ(IM_KykjyoutaikahiDao) アクセス用の DAO クラスです。<br />
 */
public class IM_KykjyoutaikahiDao extends AbstractDao<IM_Kykjyoutaikahi> {

    public IM_KykjyoutaikahiDao() {
        super(IM_Kykjyoutaikahi.class);
    }

    public IM_Kykjyoutaikahi getKykjyoutaikahi(String pKinouId,
         C_Kykjyoutai pKykjyoutai){
        IM_Kykjyoutaikahi iM_Kykjyoutaikahi =  new IM_Kykjyoutaikahi();
        iM_Kykjyoutaikahi.setKinouId(pKinouId);
        iM_Kykjyoutaikahi.setKykjyoutai(pKykjyoutai);
        return this.selectOne(iM_Kykjyoutaikahi);
    }
}
