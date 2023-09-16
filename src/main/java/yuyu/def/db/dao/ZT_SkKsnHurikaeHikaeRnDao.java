package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKsnHurikaeHikaeRn;
import yuyu.def.db.meta.QZT_SkKsnHurikaeHikaeRn;

/**
 * 新契約決算用振替伝票（控）テーブル（連）(ZT_SkKsnHurikaeHikaeRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKsnHurikaeHikaeRnDao extends AbstractDao<ZT_SkKsnHurikaeHikaeRn> {

    public ZT_SkKsnHurikaeHikaeRnDao() {
        super(ZT_SkKsnHurikaeHikaeRn.class);
    }

    public ZT_SkKsnHurikaeHikaeRn getSkKsnHurikaeHikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen, String pZrntorihikituki, String pZrntorihikibi) {
        ZT_SkKsnHurikaeHikaeRn zT_SkKsnHurikaeHikaeRn =  new ZT_SkKsnHurikaeHikaeRn();
        zT_SkKsnHurikaeHikaeRn.setZrntorihikinoc8(pZrntorihikinoc8);
        zT_SkKsnHurikaeHikaeRn.setZrntorihikinoedano(pZrntorihikinoedano);
        zT_SkKsnHurikaeHikaeRn.setZrntorihikiymdgengokbn(pZrntorihikiymdgengokbn);
        zT_SkKsnHurikaeHikaeRn.setZrntorihikinen(pZrntorihikinen);
        zT_SkKsnHurikaeHikaeRn.setZrntorihikituki(pZrntorihikituki);
        zT_SkKsnHurikaeHikaeRn.setZrntorihikibi(pZrntorihikibi);
        return this.selectOne(zT_SkKsnHurikaeHikaeRn);
    }

    public ExDBResults<ZT_SkKsnHurikaeHikaeRn> selectAllZT_SkKsnHurikaeHikaeRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKsnHurikaeHikaeRn qZT_SkKsnHurikaeHikaeRn =  new QZT_SkKsnHurikaeHikaeRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkKsnHurikaeHikaeRn);
        jpql.append($FROM);
        jpql.append(qZT_SkKsnHurikaeHikaeRn.ZT_SkKsnHurikaeHikaeRn());
        jpql.append($ORDER_BY(qZT_SkKsnHurikaeHikaeRn.zrntorihikinoc8.asc(), qZT_SkKsnHurikaeHikaeRn.zrntorihikinoedano.asc(), qZT_SkKsnHurikaeHikaeRn.zrntorihikiymdgengokbn.asc(), qZT_SkKsnHurikaeHikaeRn.zrntorihikinen.asc(), qZT_SkKsnHurikaeHikaeRn.zrntorihikituki.asc(), qZT_SkKsnHurikaeHikaeRn.zrntorihikibi.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKsnHurikaeHikaeRn).getResults();
    }
}
