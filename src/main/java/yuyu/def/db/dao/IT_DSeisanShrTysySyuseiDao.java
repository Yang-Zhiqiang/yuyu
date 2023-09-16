package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_DSeisanShrTysySyusei;

/**
 * Ｄ精算支払調書修正テーブル(IT_DSeisanShrTysySyuseiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_DSeisanShrTysySyuseiDao extends AbstractDao<IT_DSeisanShrTysySyusei> {

    public IT_DSeisanShrTysySyuseiDao() {
        super(IT_DSeisanShrTysySyusei.class);
    }

    public IT_DSeisanShrTysySyusei getDSeisanShrTysySyusei(String pSyono, BizDate pSyoriYmd) {
        IT_DSeisanShrTysySyusei iT_DSeisanShrTysySyusei =  new IT_DSeisanShrTysySyusei( pSyono,  pSyoriYmd);
        return this.selectOne(iT_DSeisanShrTysySyusei);
    }
}
