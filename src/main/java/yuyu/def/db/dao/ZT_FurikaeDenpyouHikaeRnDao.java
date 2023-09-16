package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_FurikaeDenpyouHikaeRn;
import yuyu.def.db.meta.QZT_FurikaeDenpyouHikaeRn;

/**
 * 振替伝票（控）テーブル（連）(ZT_FurikaeDenpyouHikaeRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_FurikaeDenpyouHikaeRnDao extends AbstractDao<ZT_FurikaeDenpyouHikaeRn> {

    public ZT_FurikaeDenpyouHikaeRnDao() {
        super(ZT_FurikaeDenpyouHikaeRn.class);
    }

    public ZT_FurikaeDenpyouHikaeRn getFurikaeDenpyouHikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen, String pZrntorihikituki, String pZrntorihikibi) {
        ZT_FurikaeDenpyouHikaeRn zT_FurikaeDenpyouHikaeRn =  new ZT_FurikaeDenpyouHikaeRn();
        zT_FurikaeDenpyouHikaeRn.setZrntorihikinoc8(pZrntorihikinoc8);
        zT_FurikaeDenpyouHikaeRn.setZrntorihikinoedano(pZrntorihikinoedano);
        zT_FurikaeDenpyouHikaeRn.setZrntorihikiymdgengokbn(pZrntorihikiymdgengokbn);
        zT_FurikaeDenpyouHikaeRn.setZrntorihikinen(pZrntorihikinen);
        zT_FurikaeDenpyouHikaeRn.setZrntorihikituki(pZrntorihikituki);
        zT_FurikaeDenpyouHikaeRn.setZrntorihikibi(pZrntorihikibi);
        return this.selectOne(zT_FurikaeDenpyouHikaeRn);
    }

    public ExDBResults<ZT_FurikaeDenpyouHikaeRn> selectAllZT_FurikaeDenpyouHikaeRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_FurikaeDenpyouHikaeRn qZT_FurikaeDenpyouHikaeRn =  new QZT_FurikaeDenpyouHikaeRn();
        jpql.append($SELECT);
        jpql.append(qZT_FurikaeDenpyouHikaeRn);
        jpql.append($FROM);
        jpql.append(qZT_FurikaeDenpyouHikaeRn.ZT_FurikaeDenpyouHikaeRn());
        jpql.append($ORDER_BY(qZT_FurikaeDenpyouHikaeRn.zrntorihikinoc8.asc(), qZT_FurikaeDenpyouHikaeRn.zrntorihikinoedano.asc(), qZT_FurikaeDenpyouHikaeRn.zrntorihikiymdgengokbn.asc(), qZT_FurikaeDenpyouHikaeRn.zrntorihikinen.asc(), qZT_FurikaeDenpyouHikaeRn.zrntorihikituki.asc(), qZT_FurikaeDenpyouHikaeRn.zrntorihikibi.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_FurikaeDenpyouHikaeRn).getResults();
    }
}
