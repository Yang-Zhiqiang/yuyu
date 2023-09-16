package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IM_KhTyuuiKahi;

/**
 * 契約保全注意取扱処理可否マスタ(IM_KhTyuuiKahiDao) アクセス用の DAO クラスです。<br />
 */
public class IM_KhTyuuiKahiDao extends AbstractDao<IM_KhTyuuiKahi> {

    public IM_KhTyuuiKahiDao() {
        super(IM_KhTyuuiKahi.class);
    }

    public IM_KhTyuuiKahi getKhTyuuiKahi(String pKinouId){
        IM_KhTyuuiKahi iM_KhTyuuiKahi =  new IM_KhTyuuiKahi();
        iM_KhTyuuiKahi.setKinouId(pKinouId);
        return this.selectOne(iM_KhTyuuiKahi);
    }
}
