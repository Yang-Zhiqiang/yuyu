package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.BM_SibouRitu;

/**
 * 死亡率マスタ(BM_SibouRituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SibouRituDao extends AbstractDao<BM_SibouRitu> {

    public BM_SibouRituDao() {
        super(BM_SibouRitu.class);
    }

    public BM_SibouRitu getSibouRitu(String pRyouritusdno, C_Seibetu pSeibetu, Integer pNenrei) {
        BM_SibouRitu bM_SibouRitu =  new BM_SibouRitu();
        bM_SibouRitu.setRyouritusdno(pRyouritusdno);
        bM_SibouRitu.setSeibetu(pSeibetu);
        bM_SibouRitu.setNenrei(pNenrei);
        return this.selectOne(bM_SibouRitu);
    }
}
