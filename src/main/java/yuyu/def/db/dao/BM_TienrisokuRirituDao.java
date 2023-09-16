package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_TienrisokuRiritu;

/**
 * 遅延利息利率マスタ(BM_TienrisokuRirituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_TienrisokuRirituDao extends AbstractDao<BM_TienrisokuRiritu> {

    public BM_TienrisokuRirituDao() {
        super(BM_TienrisokuRiritu.class);
    }

    public BM_TienrisokuRiritu getTienrisokuRiritu(String pTekiyoukknfrom, String pTekiyoukknkto) {
        BM_TienrisokuRiritu bM_TienrisokuRiritu =  new BM_TienrisokuRiritu();
        bM_TienrisokuRiritu.setTekiyoukknfrom(pTekiyoukknfrom);
        bM_TienrisokuRiritu.setTekiyoukknkto(pTekiyoukknkto);
        return this.selectOne(bM_TienrisokuRiritu);
    }

}
