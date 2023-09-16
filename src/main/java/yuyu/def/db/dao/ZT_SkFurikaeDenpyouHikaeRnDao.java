package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouHikaeRn;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouHikaeRn;

/**
 * 新契約振替伝票（控）テーブル（連）(ZT_SkFurikaeDenpyouHikaeRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkFurikaeDenpyouHikaeRnDao extends AbstractDao<ZT_SkFurikaeDenpyouHikaeRn> {

    public ZT_SkFurikaeDenpyouHikaeRnDao() {
        super(ZT_SkFurikaeDenpyouHikaeRn.class);
    }

    public ZT_SkFurikaeDenpyouHikaeRn getSkFurikaeDenpyouHikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen, String pZrntorihikituki, String pZrntorihikibi) {
        ZT_SkFurikaeDenpyouHikaeRn zT_SkFurikaeDenpyouHikaeRn =  new ZT_SkFurikaeDenpyouHikaeRn();
        zT_SkFurikaeDenpyouHikaeRn.setZrntorihikinoc8(pZrntorihikinoc8);
        zT_SkFurikaeDenpyouHikaeRn.setZrntorihikinoedano(pZrntorihikinoedano);
        zT_SkFurikaeDenpyouHikaeRn.setZrntorihikiymdgengokbn(pZrntorihikiymdgengokbn);
        zT_SkFurikaeDenpyouHikaeRn.setZrntorihikinen(pZrntorihikinen);
        zT_SkFurikaeDenpyouHikaeRn.setZrntorihikituki(pZrntorihikituki);
        zT_SkFurikaeDenpyouHikaeRn.setZrntorihikibi(pZrntorihikibi);
        return this.selectOne(zT_SkFurikaeDenpyouHikaeRn);
    }

    public ExDBResults<ZT_SkFurikaeDenpyouHikaeRn> selectAllZT_SkFurikaeDenpyouHikaeRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkFurikaeDenpyouHikaeRn qZT_SkFurikaeDenpyouHikaeRn =  new QZT_SkFurikaeDenpyouHikaeRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkFurikaeDenpyouHikaeRn);
        jpql.append($FROM);
        jpql.append(qZT_SkFurikaeDenpyouHikaeRn.ZT_SkFurikaeDenpyouHikaeRn());
        jpql.append($ORDER_BY(qZT_SkFurikaeDenpyouHikaeRn.zrntorihikinoc8.asc(), qZT_SkFurikaeDenpyouHikaeRn.zrntorihikinoedano.asc(), qZT_SkFurikaeDenpyouHikaeRn.zrntorihikiymdgengokbn.asc(), qZT_SkFurikaeDenpyouHikaeRn.zrntorihikinen.asc(), qZT_SkFurikaeDenpyouHikaeRn.zrntorihikituki.asc(), qZT_SkFurikaeDenpyouHikaeRn.zrntorihikibi.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkFurikaeDenpyouHikaeRn).getResults();
    }
}
