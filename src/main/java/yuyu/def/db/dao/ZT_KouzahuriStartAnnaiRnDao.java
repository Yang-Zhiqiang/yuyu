package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KouzahuriStartAnnaiRn;
import yuyu.def.db.meta.QZT_KouzahuriStartAnnaiRn;

/**
 * 口座振替開始案内テーブル（連）(ZT_KouzahuriStartAnnaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KouzahuriStartAnnaiRnDao extends AbstractDao<ZT_KouzahuriStartAnnaiRn> {

    public ZT_KouzahuriStartAnnaiRnDao() {
        super(ZT_KouzahuriStartAnnaiRn.class);
    }

    public ZT_KouzahuriStartAnnaiRn getKouzahuriStartAnnaiRn(String pZrntyouhyouymd, String pZrnsyono) {
        ZT_KouzahuriStartAnnaiRn zT_KouzahuriStartAnnaiRn =  new ZT_KouzahuriStartAnnaiRn();
        zT_KouzahuriStartAnnaiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_KouzahuriStartAnnaiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_KouzahuriStartAnnaiRn);
    }

    public ExDBResults<ZT_KouzahuriStartAnnaiRn> selectAllZT_KouzahuriStartAnnaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KouzahuriStartAnnaiRn qZT_KouzahuriStartAnnaiRn =  new QZT_KouzahuriStartAnnaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_KouzahuriStartAnnaiRn);
        jpql.append($FROM);
        jpql.append(qZT_KouzahuriStartAnnaiRn.ZT_KouzahuriStartAnnaiRn());
        jpql.append($ORDER_BY(qZT_KouzahuriStartAnnaiRn.zrntyouhyouymd.asc(), qZT_KouzahuriStartAnnaiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KouzahuriStartAnnaiRn).getResults();
    }
}
