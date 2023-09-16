package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouTy;
import yuyu.def.db.meta.QZT_TjtIdouNaiyouTy;

/**
 * 当日異動内容テーブル（中）(ZT_TjtIdouNaiyouTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TjtIdouNaiyouTyDao extends AbstractDao<ZT_TjtIdouNaiyouTy> {

    public ZT_TjtIdouNaiyouTyDao() {
        super(ZT_TjtIdouNaiyouTy.class);
    }

    public ZT_TjtIdouNaiyouTy getTjtIdouNaiyouTy(String pZtyhuho2kyknokbn, String pZtyhuho2kykno) {
        ZT_TjtIdouNaiyouTy zT_TjtIdouNaiyouTy =  new ZT_TjtIdouNaiyouTy();
        zT_TjtIdouNaiyouTy.setZtyhuho2kyknokbn(pZtyhuho2kyknokbn);
        zT_TjtIdouNaiyouTy.setZtyhuho2kykno(pZtyhuho2kykno);
        return this.selectOne(zT_TjtIdouNaiyouTy);
    }

    public ExDBResults<ZT_TjtIdouNaiyouTy> selectAllZT_TjtIdouNaiyouTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_TjtIdouNaiyouTy qZT_TjtIdouNaiyouTy =  new QZT_TjtIdouNaiyouTy();
        jpql.append($SELECT);
        jpql.append(qZT_TjtIdouNaiyouTy);
        jpql.append($FROM);
        jpql.append(qZT_TjtIdouNaiyouTy.ZT_TjtIdouNaiyouTy());
        jpql.append($ORDER_BY(qZT_TjtIdouNaiyouTy.ztyhuho2kyknokbn.asc(), qZT_TjtIdouNaiyouTy.ztyhuho2kykno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TjtIdouNaiyouTy).getResults();
    }
}
