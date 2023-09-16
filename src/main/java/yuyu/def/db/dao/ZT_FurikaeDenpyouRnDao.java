package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_FurikaeDenpyouRn;
import yuyu.def.db.meta.QZT_FurikaeDenpyouRn;

/**
 * 振替伝票テーブル（連）(ZT_FurikaeDenpyouRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_FurikaeDenpyouRnDao extends AbstractDao<ZT_FurikaeDenpyouRn> {

    public ZT_FurikaeDenpyouRnDao() {
        super(ZT_FurikaeDenpyouRn.class);
    }

    public ZT_FurikaeDenpyouRn getFurikaeDenpyouRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen, String pZrntorihikituki, String pZrntorihikibi) {
        ZT_FurikaeDenpyouRn zT_FurikaeDenpyouRn =  new ZT_FurikaeDenpyouRn();
        zT_FurikaeDenpyouRn.setZrntorihikinoc8(pZrntorihikinoc8);
        zT_FurikaeDenpyouRn.setZrntorihikinoedano(pZrntorihikinoedano);
        zT_FurikaeDenpyouRn.setZrntorihikiymdgengokbn(pZrntorihikiymdgengokbn);
        zT_FurikaeDenpyouRn.setZrntorihikinen(pZrntorihikinen);
        zT_FurikaeDenpyouRn.setZrntorihikituki(pZrntorihikituki);
        zT_FurikaeDenpyouRn.setZrntorihikibi(pZrntorihikibi);
        return this.selectOne(zT_FurikaeDenpyouRn);
    }

    public ExDBResults<ZT_FurikaeDenpyouRn> selectAllZT_FurikaeDenpyouRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_FurikaeDenpyouRn qZT_FurikaeDenpyouRn =  new QZT_FurikaeDenpyouRn();
        jpql.append($SELECT);
        jpql.append(qZT_FurikaeDenpyouRn);
        jpql.append($FROM);
        jpql.append(qZT_FurikaeDenpyouRn.ZT_FurikaeDenpyouRn());
        jpql.append($ORDER_BY(qZT_FurikaeDenpyouRn.zrntorihikinoc8.asc(), qZT_FurikaeDenpyouRn.zrntorihikinoedano.asc(), qZT_FurikaeDenpyouRn.zrntorihikiymdgengokbn.asc(), qZT_FurikaeDenpyouRn.zrntorihikinen.asc(), qZT_FurikaeDenpyouRn.zrntorihikituki.asc(), qZT_FurikaeDenpyouRn.zrntorihikibi.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_FurikaeDenpyouRn).getResults();
    }
}
