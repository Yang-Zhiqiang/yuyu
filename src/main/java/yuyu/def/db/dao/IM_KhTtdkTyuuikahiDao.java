package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.IM_KhTtdkTyuuikahi;

/**
 * 契約保全手続注意処理可否マスタ(IM_KhTtdkTyuuikahiDao) アクセス用の DAO クラスです。<br />
 */
public class IM_KhTtdkTyuuikahiDao extends AbstractDao<IM_KhTtdkTyuuikahi> {

    public IM_KhTtdkTyuuikahiDao() {
        super(IM_KhTtdkTyuuikahi.class);
    }

    public IM_KhTtdkTyuuikahi getKhTtdkTyuuikahi(String pKinouId,
         C_TtdktyuuiKbn pTtdktyuuikbn){
        IM_KhTtdkTyuuikahi iM_KhTtdkTyuuikahi =  new IM_KhTtdkTyuuikahi();
        iM_KhTtdkTyuuikahi.setKinouId(pKinouId);
        iM_KhTtdkTyuuikahi.setTtdktyuuikbn(pTtdktyuuikbn);
        return this.selectOne(iM_KhTtdkTyuuikahi);
    }
}
