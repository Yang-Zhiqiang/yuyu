package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KhTtdkTyuui;

/**
 * 契約保全手続注意テーブル(IT_KhTtdkTyuuiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhTtdkTyuuiDao extends AbstractDao<IT_KhTtdkTyuui> {

    public IT_KhTtdkTyuuiDao() {
        super(IT_KhTtdkTyuui.class);
    }

    @Deprecated
    public IT_KhTtdkTyuui getKhTtdkTyuui(String pSyono){
        IT_KhTtdkTyuui iT_KhTtdkTyuui =  new IT_KhTtdkTyuui();
        iT_KhTtdkTyuui.setSyono(pSyono);
        return this.selectOne(iT_KhTtdkTyuui);
    }

    @Override
    @Deprecated
    public List<IT_KhTtdkTyuui> selectAll() {
        return super.selectAll();
    }
}
