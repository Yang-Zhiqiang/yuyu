package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import yuyu.def.db.entity.ZT_GentumiSkMikomirituULFTy;
import yuyu.def.db.meta.QZT_GentumiSkMikomirituULFTy;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 限積用失効見込率算出用ＵＬＦテーブル（中）(ZT_GentumiSkMikomirituULFTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_GentumiSkMikomirituULFTyDao extends AbstractDao<ZT_GentumiSkMikomirituULFTy> {


    public ZT_GentumiSkMikomirituULFTyDao() {
        super(ZT_GentumiSkMikomirituULFTy.class);
    }

    public ZT_GentumiSkMikomirituULFTy getGentumiSkMikomirituULFTy(String pZtydatakanrino) {
        ZT_GentumiSkMikomirituULFTy zT_GentumiSkMikomirituULFTy =  new ZT_GentumiSkMikomirituULFTy();
        zT_GentumiSkMikomirituULFTy.setZtydatakanrino(pZtydatakanrino);
        return this.selectOne(zT_GentumiSkMikomirituULFTy);
    }

    public ExDBResults<ZT_GentumiSkMikomirituULFTy> selectAllZT_GentumiSkMikomirituULFTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_GentumiSkMikomirituULFTy qZT_GentumiSkMikomirituULFTy =  new QZT_GentumiSkMikomirituULFTy();
        jpql.append($SELECT);
        jpql.append(qZT_GentumiSkMikomirituULFTy);
        jpql.append($FROM);
        jpql.append(qZT_GentumiSkMikomirituULFTy.ZT_GentumiSkMikomirituULFTy());
        jpql.append($ORDER_BY(qZT_GentumiSkMikomirituULFTy.ztydatakanrino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_GentumiSkMikomirituULFTy).getResults();
    }
}
