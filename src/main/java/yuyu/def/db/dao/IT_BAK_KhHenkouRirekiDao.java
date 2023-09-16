package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhHenkouRireki;

/**
 * 契約保全変更履歴バックアップテーブル(IT_BAK_KhHenkouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhHenkouRirekiDao extends AbstractDao<IT_BAK_KhHenkouRireki> {

    public IT_BAK_KhHenkouRirekiDao() {
        super(IT_BAK_KhHenkouRireki.class);
    }

    @Deprecated
    public IT_BAK_KhHenkouRireki getBAKKhHenkouRireki(String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey,
        Integer pRenno){
        IT_BAK_KhHenkouRireki iT_BAK_KhHenkouRireki =  new IT_BAK_KhHenkouRireki();
        iT_BAK_KhHenkouRireki.setSyono(pSyono);
        iT_BAK_KhHenkouRireki.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KhHenkouRireki.setHenkousikibetukey(pHenkousikibetukey);
        iT_BAK_KhHenkouRireki.setRenno3keta(pRenno);
        return this.selectOne(iT_BAK_KhHenkouRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KhHenkouRireki> selectAll() {
        return super.selectAll();
    }
}
