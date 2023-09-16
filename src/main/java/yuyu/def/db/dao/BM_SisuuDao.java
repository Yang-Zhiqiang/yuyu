package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.db.entity.BM_Sisuu;
import yuyu.def.db.meta.QBM_Sisuu;

/**
 * 指数マスタ(BM_SisuuDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SisuuDao extends AbstractDao<BM_Sisuu> {

    public BM_SisuuDao() {
        super(BM_Sisuu.class);
    }

    @Deprecated
    public BM_Sisuu getSisuu(C_Sisuukbn pSisuukbn, BizDate pSisuukouhyouymd) {
        BM_Sisuu bM_Sisuu =  new BM_Sisuu();
        bM_Sisuu.setSisuukbn(pSisuukbn);
        bM_Sisuu.setSisuukouhyouymd(pSisuukouhyouymd);
        return this.selectOne(bM_Sisuu);
    }

    @Override
    @Deprecated
    public List<BM_Sisuu> selectAll() {
        return super.selectAll();
    }

    public List<BM_Sisuu> getSisuusBySisuukouhyouymdMax() {


        QBM_Sisuu qBM_Sisuu = new QBM_Sisuu("qBM_Sisuu");


        String strSubSql = $SELECT + $MAX(qBM_Sisuu.sisuukouhyouymd) +
            $FROM(qBM_Sisuu);


        String strSql = $SELECT + qBM_Sisuu +
            $FROM(qBM_Sisuu)  +
            $WHERE + qBM_Sisuu.sisuukouhyouymd + $EQ + $(strSubSql) +
            $ORDER_BY(qBM_Sisuu.sisuukbn.asc());


        return em.createJPQL(strSql).bind(qBM_Sisuu).getResultList();
    }
}
