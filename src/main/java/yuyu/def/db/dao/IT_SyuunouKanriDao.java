package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.db.entity.IT_SyuunouKanri;

/**
 * 収納管理テーブル(IT_SyuunouKanriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SyuunouKanriDao extends AbstractDao<IT_SyuunouKanri> {

    public IT_SyuunouKanriDao() {
        super(IT_SyuunouKanri.class);
    }

    public IT_SyuunouKanri getSyuunouKanri(C_Syuudaikocd pSyuudaikocd,
         BizDate pHurikaeymd){
        IT_SyuunouKanri iT_SyuunouKanri =  new IT_SyuunouKanri();
        iT_SyuunouKanri.setSyuudaikocd(pSyuudaikocd);
        iT_SyuunouKanri.setHurikaeymd(pHurikaeymd);
        return this.selectOne(iT_SyuunouKanri);
    }
}
