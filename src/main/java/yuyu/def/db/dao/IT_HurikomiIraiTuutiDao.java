package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_HurikomiIraiTuuti;

/**
 * 振込依頼通知テーブル(IT_HurikomiIraiTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HurikomiIraiTuutiDao extends AbstractDao<IT_HurikomiIraiTuuti> {

    public IT_HurikomiIraiTuutiDao() {
        super(IT_HurikomiIraiTuuti.class);
    }

    public IT_HurikomiIraiTuuti getHurikomiIraiTuuti(String pSyono, BizDate pTyouhyouymd) {
        IT_HurikomiIraiTuuti iT_HurikomiIraiTuuti =  new IT_HurikomiIraiTuuti( pSyono,  pTyouhyouymd);
        return this.selectOne(iT_HurikomiIraiTuuti);
    }
}
