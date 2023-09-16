package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import yuyu.def.db.entity.ZT_GentumiSkMikomirituULFRn;
import yuyu.def.db.meta.QZT_GentumiSkMikomirituULFRn;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 限積用失効見込率算出用ＵＬＦテーブル（連）(ZT_GentumiSkMikomirituULFRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_GentumiSkMikomirituULFRnDao extends AbstractDao<ZT_GentumiSkMikomirituULFRn> {


    public ZT_GentumiSkMikomirituULFRnDao() {
        super(ZT_GentumiSkMikomirituULFRn.class);
    }

    public ZT_GentumiSkMikomirituULFRn getGentumiSkMikomirituULFRn(String pZrndatakanrino) {
        ZT_GentumiSkMikomirituULFRn zT_GentumiSkMikomirituULFRn =  new ZT_GentumiSkMikomirituULFRn();
        zT_GentumiSkMikomirituULFRn.setZrndatakanrino(pZrndatakanrino);
        return this.selectOne(zT_GentumiSkMikomirituULFRn);
    }

    public ExDBResults<ZT_GentumiSkMikomirituULFRn> selectAllZT_GentumiSkMikomirituULFRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_GentumiSkMikomirituULFRn qZT_GentumiSkMikomirituULFRn =  new QZT_GentumiSkMikomirituULFRn();
        jpql.append($SELECT);
        jpql.append(qZT_GentumiSkMikomirituULFRn);
        jpql.append($FROM);
        jpql.append(qZT_GentumiSkMikomirituULFRn.ZT_GentumiSkMikomirituULFRn());
        jpql.append($ORDER_BY(qZT_GentumiSkMikomirituULFRn.zrndatakanrino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_GentumiSkMikomirituULFRn).getResults();
    }
}
