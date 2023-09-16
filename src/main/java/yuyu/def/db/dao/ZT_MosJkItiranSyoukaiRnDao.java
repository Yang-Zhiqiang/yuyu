package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_MosJkItiranSyoukaiRn;
import yuyu.def.db.meta.QZT_MosJkItiranSyoukaiRn;

/**
 * 申込状況一覧照会用Ｆテーブル（連）(ZT_MosJkItiranSyoukaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_MosJkItiranSyoukaiRnDao extends AbstractDao<ZT_MosJkItiranSyoukaiRn> {

    public ZT_MosJkItiranSyoukaiRnDao() {
        super(ZT_MosJkItiranSyoukaiRn.class);
    }

    public ZT_MosJkItiranSyoukaiRn getMosJkItiranSyoukaiRn(String pZrnmosym, String pZrnmosno, String pZrnbsydrtencd, String pZrnatukaikojincd) {
        ZT_MosJkItiranSyoukaiRn zT_MosJkItiranSyoukaiRn =  new ZT_MosJkItiranSyoukaiRn();
        zT_MosJkItiranSyoukaiRn.setZrnmosym(pZrnmosym);
        zT_MosJkItiranSyoukaiRn.setZrnmosno(pZrnmosno);
        zT_MosJkItiranSyoukaiRn.setZrnbsydrtencd(pZrnbsydrtencd);
        zT_MosJkItiranSyoukaiRn.setZrnatukaikojincd(pZrnatukaikojincd);
        return this.selectOne(zT_MosJkItiranSyoukaiRn);
    }

    public ExDBResults<ZT_MosJkItiranSyoukaiRn> selectAllZT_MosJkItiranSyoukaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_MosJkItiranSyoukaiRn qZT_MosJkItiranSyoukaiRn =  new QZT_MosJkItiranSyoukaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_MosJkItiranSyoukaiRn);
        jpql.append($FROM);
        jpql.append(qZT_MosJkItiranSyoukaiRn.ZT_MosJkItiranSyoukaiRn());
        jpql.append($ORDER_BY(qZT_MosJkItiranSyoukaiRn.zrnmosym.asc(), qZT_MosJkItiranSyoukaiRn.zrnmosno.asc(), qZT_MosJkItiranSyoukaiRn.zrnbsydrtencd.asc(), qZT_MosJkItiranSyoukaiRn.zrnatukaikojincd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_MosJkItiranSyoukaiRn).getResults();
    }
}
