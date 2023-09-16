package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhShrRireki;

/**
 * 契約保全支払履歴バックアップテーブル(IT_BAK_KhShrRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhShrRirekiDao extends AbstractDao<IT_BAK_KhShrRireki> {

    public IT_BAK_KhShrRirekiDao() {
        super(IT_BAK_KhShrRireki.class);
    }

    @Deprecated
    public IT_BAK_KhShrRireki getBAKKhShrRireki(String pSyono,
         String pTrkssikibetukey,
         String pHenkousikibetukey){
        IT_BAK_KhShrRireki iT_BAK_KhShrRireki =  new IT_BAK_KhShrRireki();
        iT_BAK_KhShrRireki.setSyono(pSyono);
        iT_BAK_KhShrRireki.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KhShrRireki.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_BAK_KhShrRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KhShrRireki> selectAll() {
        return super.selectAll();
    }
}
