package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouRn;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouRn;

/**
 * 新契約振替伝票テーブル（連）(ZT_SkFurikaeDenpyouRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkFurikaeDenpyouRnDao extends AbstractDao<ZT_SkFurikaeDenpyouRn> {

    public ZT_SkFurikaeDenpyouRnDao() {
        super(ZT_SkFurikaeDenpyouRn.class);
    }

    public ZT_SkFurikaeDenpyouRn getSkFurikaeDenpyouRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen, String pZrntorihikituki, String pZrntorihikibi) {
        ZT_SkFurikaeDenpyouRn zT_SkFurikaeDenpyouRn =  new ZT_SkFurikaeDenpyouRn();
        zT_SkFurikaeDenpyouRn.setZrntorihikinoc8(pZrntorihikinoc8);
        zT_SkFurikaeDenpyouRn.setZrntorihikinoedano(pZrntorihikinoedano);
        zT_SkFurikaeDenpyouRn.setZrntorihikiymdgengokbn(pZrntorihikiymdgengokbn);
        zT_SkFurikaeDenpyouRn.setZrntorihikinen(pZrntorihikinen);
        zT_SkFurikaeDenpyouRn.setZrntorihikituki(pZrntorihikituki);
        zT_SkFurikaeDenpyouRn.setZrntorihikibi(pZrntorihikibi);
        return this.selectOne(zT_SkFurikaeDenpyouRn);
    }

    public ExDBResults<ZT_SkFurikaeDenpyouRn> selectAllZT_SkFurikaeDenpyouRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkFurikaeDenpyouRn qZT_SkFurikaeDenpyouRn =  new QZT_SkFurikaeDenpyouRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkFurikaeDenpyouRn);
        jpql.append($FROM);
        jpql.append(qZT_SkFurikaeDenpyouRn.ZT_SkFurikaeDenpyouRn());
        jpql.append($ORDER_BY(qZT_SkFurikaeDenpyouRn.zrntorihikinoc8.asc(), qZT_SkFurikaeDenpyouRn.zrntorihikinoedano.asc(), qZT_SkFurikaeDenpyouRn.zrntorihikiymdgengokbn.asc(), qZT_SkFurikaeDenpyouRn.zrntorihikituki.asc(), qZT_SkFurikaeDenpyouRn.zrntorihikituki.asc(), qZT_SkFurikaeDenpyouRn.zrntorihikibi.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkFurikaeDenpyouRn).getResults();
    }
}
