package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhTtdkTyuui;

/**
 * 契約保全手続注意バックアップテーブル(IT_BAK_KhTtdkTyuuiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhTtdkTyuuiDao extends AbstractDao<IT_BAK_KhTtdkTyuui> {

    public IT_BAK_KhTtdkTyuuiDao() {
        super(IT_BAK_KhTtdkTyuui.class);
    }

    @Deprecated
    public IT_BAK_KhTtdkTyuui getBAKKhTtdkTyuui(String pSyono,
         String pTrkssikibetukey){
        IT_BAK_KhTtdkTyuui iT_BAK_KhTtdkTyuui =  new IT_BAK_KhTtdkTyuui();
        iT_BAK_KhTtdkTyuui.setSyono(pSyono);
        iT_BAK_KhTtdkTyuui.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_KhTtdkTyuui);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KhTtdkTyuui> selectAll() {
        return super.selectAll();
    }
}
