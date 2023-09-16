package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKsnHurikaeRn;
import yuyu.def.db.meta.QZT_SkKsnHurikaeRn;

/**
 * 新契約決算用振替伝票テーブル（連）(ZT_SkKsnHurikaeRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKsnHurikaeRnDao extends AbstractDao<ZT_SkKsnHurikaeRn> {

    public ZT_SkKsnHurikaeRnDao() {
        super(ZT_SkKsnHurikaeRn.class);
    }

    public ZT_SkKsnHurikaeRn getSkKsnHurikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen, String pZrntorihikituki, String pZrntorihikibi) {
        ZT_SkKsnHurikaeRn zT_SkKsnHurikaeRn =  new ZT_SkKsnHurikaeRn();
        zT_SkKsnHurikaeRn.setZrntorihikinoc8(pZrntorihikinoc8);
        zT_SkKsnHurikaeRn.setZrntorihikinoedano(pZrntorihikinoedano);
        zT_SkKsnHurikaeRn.setZrntorihikiymdgengokbn(pZrntorihikiymdgengokbn);
        zT_SkKsnHurikaeRn.setZrntorihikinen(pZrntorihikinen);
        zT_SkKsnHurikaeRn.setZrntorihikituki(pZrntorihikituki);
        zT_SkKsnHurikaeRn.setZrntorihikibi(pZrntorihikibi);
        return this.selectOne(zT_SkKsnHurikaeRn);
    }

    public ExDBResults<ZT_SkKsnHurikaeRn> selectAllZT_SkKsnHurikaeRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKsnHurikaeRn qZT_SkKsnHurikaeRn =  new QZT_SkKsnHurikaeRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkKsnHurikaeRn);
        jpql.append($FROM);
        jpql.append(qZT_SkKsnHurikaeRn.ZT_SkKsnHurikaeRn());
        jpql.append($ORDER_BY(qZT_SkKsnHurikaeRn.zrntorihikinoc8.asc(), qZT_SkKsnHurikaeRn.zrntorihikinoedano.asc(), qZT_SkKsnHurikaeRn.zrntorihikiymdgengokbn.asc(), qZT_SkKsnHurikaeRn.zrntorihikinen.asc(), qZT_SkKsnHurikaeRn.zrntorihikituki.asc(), qZT_SkKsnHurikaeRn.zrntorihikibi.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKsnHurikaeRn).getResults();
    }
}
