package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_LastSyoriymdKanriKbn;
import yuyu.def.db.entity.BT_LastSyoriYMDKanri;

/**
 * 最終処理日管理テーブル(BT_LastSyoriYMDKanriDao) アクセス用の DAO クラスです。<br />
 */
public class BT_LastSyoriYMDKanriDao extends AbstractDao<BT_LastSyoriYMDKanri> {

    public BT_LastSyoriYMDKanriDao() {
        super(BT_LastSyoriYMDKanri.class);
    }

    public BT_LastSyoriYMDKanri getLastSyoriYMDKanri(C_LastSyoriymdKanriKbn pLastsyoriymdkanrikbn){
        BT_LastSyoriYMDKanri bT_LastSyoriYMDKanri =  new BT_LastSyoriYMDKanri();
        bT_LastSyoriYMDKanri.setLastsyoriymdkanrikbn(pLastsyoriymdkanrikbn);
        return this.selectOne(bT_LastSyoriYMDKanri);
    }
}
