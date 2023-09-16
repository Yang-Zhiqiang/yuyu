package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;

/**
 * ＤＳ登録受付管理テーブル(MT_DsTourokuUkKanriDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsTourokuUkKanriDao extends AbstractDao<MT_DsTourokuUkKanri> {

    public MT_DsTourokuUkKanriDao() {
        super(MT_DsTourokuUkKanri.class);
    }

    public MT_DsTourokuUkKanri getDsTourokuUkKanri(String pSyono, C_DsTtdksyubetuKbn pDsttdksyubetukbn, Integer pDatarenno) {
        MT_DsTourokuUkKanri mT_DsTourokuUkKanri =  new MT_DsTourokuUkKanri();
        mT_DsTourokuUkKanri.setSyono(pSyono);
        mT_DsTourokuUkKanri.setDsttdksyubetukbn(pDsttdksyubetukbn);
        mT_DsTourokuUkKanri.setDatarenno(pDatarenno);
        return this.selectOne(mT_DsTourokuUkKanri);
    }

}
