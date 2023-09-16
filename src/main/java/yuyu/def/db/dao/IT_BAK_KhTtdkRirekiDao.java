package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhTtdkRireki;

/**
 * 契約保全手続履歴バックアップテーブル(IT_BAK_KhTtdkRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhTtdkRirekiDao extends AbstractDao<IT_BAK_KhTtdkRireki> {

    public IT_BAK_KhTtdkRirekiDao() {
        super(IT_BAK_KhTtdkRireki.class);
    }

    @Deprecated
    public IT_BAK_KhTtdkRireki getBAKKhTtdkRireki(String pSyono,
         String pTrkssikibetukey,
         String pHenkousikibetukey){
        IT_BAK_KhTtdkRireki iT_BAK_KhTtdkRireki =  new IT_BAK_KhTtdkRireki();
        iT_BAK_KhTtdkRireki.setSyono(pSyono);
        iT_BAK_KhTtdkRireki.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KhTtdkRireki.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_BAK_KhTtdkRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KhTtdkRireki> selectAll() {
        return super.selectAll();
    }
}
