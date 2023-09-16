package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;

/**
 * ＤＳ顧客管理バックアップテーブル(MT_BAK_DsKokyakuKanriDao) アクセス用の DAO クラスです。<br />
 */
public class MT_BAK_DsKokyakuKanriDao extends AbstractDao<MT_BAK_DsKokyakuKanri> {

    public MT_BAK_DsKokyakuKanriDao() {
        super(MT_BAK_DsKokyakuKanri.class);
    }

    public MT_BAK_DsKokyakuKanri getBAKDsKokyakuKanri(String pDskokno, String pTrkssikibetukey) {
        MT_BAK_DsKokyakuKanri mT_BAK_DsKokyakuKanri =  new MT_BAK_DsKokyakuKanri();
        mT_BAK_DsKokyakuKanri.setDskokno(pDskokno);
        mT_BAK_DsKokyakuKanri.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(mT_BAK_DsKokyakuKanri);
    }

}
