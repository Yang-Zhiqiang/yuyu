package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KariwariateHtkinMeisaiRn;
import yuyu.def.db.meta.QZT_KariwariateHtkinMeisaiRn;

/**
 * 仮割当配当金明細Ｆテーブル（連）(ZT_KariwariateHtkinMeisaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KariwariateHtkinMeisaiRnDao extends AbstractDao<ZT_KariwariateHtkinMeisaiRn> {

    public ZT_KariwariateHtkinMeisaiRnDao() {
        super(ZT_KariwariateHtkinMeisaiRn.class);
    }

    public ZT_KariwariateHtkinMeisaiRn getKariwariateHtkinMeisaiRn(Integer pZrnsequenceno) {
        ZT_KariwariateHtkinMeisaiRn zT_KariwariateHtkinMeisaiRn =  new ZT_KariwariateHtkinMeisaiRn();
        zT_KariwariateHtkinMeisaiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_KariwariateHtkinMeisaiRn);
    }

    public ExDBResults<ZT_KariwariateHtkinMeisaiRn> selectAllZT_KariwariateHtkinMeisaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KariwariateHtkinMeisaiRn qZT_KariwariateHtkinMeisaiRn =  new QZT_KariwariateHtkinMeisaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_KariwariateHtkinMeisaiRn);
        jpql.append($FROM);
        jpql.append(qZT_KariwariateHtkinMeisaiRn.ZT_KariwariateHtkinMeisaiRn());
        jpql.append($ORDER_BY(qZT_KariwariateHtkinMeisaiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KariwariateHtkinMeisaiRn).getResults();
    }
}
