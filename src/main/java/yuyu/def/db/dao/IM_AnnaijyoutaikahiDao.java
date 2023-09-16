package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_AnnaijyoutaiKbn;
import yuyu.def.db.entity.IM_Annaijyoutaikahi;

/**
 * 案内状態処理可否マスタ(IM_AnnaijyoutaikahiDao) アクセス用の DAO クラスです。<br />
 */
public class IM_AnnaijyoutaikahiDao extends AbstractDao<IM_Annaijyoutaikahi> {

    public IM_AnnaijyoutaikahiDao() {
        super(IM_Annaijyoutaikahi.class);
    }

    public IM_Annaijyoutaikahi getAnnaijyoutaikahi(String pKinouId,
         C_AnnaijyoutaiKbn pAnnaijyoutaikbn){
        IM_Annaijyoutaikahi iM_Annaijyoutaikahi =  new IM_Annaijyoutaikahi();
        iM_Annaijyoutaikahi.setKinouId(pKinouId);
        iM_Annaijyoutaikahi.setAnnaijyoutaikbn(pAnnaijyoutaikbn);
        return this.selectOne(iM_Annaijyoutaikahi);
    }
}
