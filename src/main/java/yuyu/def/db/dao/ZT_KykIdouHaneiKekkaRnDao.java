package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaRn;
import yuyu.def.db.meta.QZT_KykIdouHaneiKekkaRn;

/**
 * 普保Ⅱ契約異動反映結果テーブル（連）(ZT_KykIdouHaneiKekkaRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KykIdouHaneiKekkaRnDao extends AbstractDao<ZT_KykIdouHaneiKekkaRn> {

    public ZT_KykIdouHaneiKekkaRnDao() {
        super(ZT_KykIdouHaneiKekkaRn.class);
    }

    public ZT_KykIdouHaneiKekkaRn getKykIdouHaneiKekkaRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno) {
        ZT_KykIdouHaneiKekkaRn zT_KykIdouHaneiKekkaRn =  new ZT_KykIdouHaneiKekkaRn();
        zT_KykIdouHaneiKekkaRn.setZrnhuho2kyknokbn(pZrnhuho2kyknokbn);
        zT_KykIdouHaneiKekkaRn.setZrnhuho2kykno(pZrnhuho2kykno);
        return this.selectOne(zT_KykIdouHaneiKekkaRn);
    }

    public ExDBResults<ZT_KykIdouHaneiKekkaRn> selectAllZT_KykIdouHaneiKekkaRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KykIdouHaneiKekkaRn qZT_KykIdouHaneiKekkaRn =  new QZT_KykIdouHaneiKekkaRn();
        jpql.append($SELECT);
        jpql.append(qZT_KykIdouHaneiKekkaRn);
        jpql.append($FROM);
        jpql.append(qZT_KykIdouHaneiKekkaRn.ZT_KykIdouHaneiKekkaRn());
        jpql.append($ORDER_BY(qZT_KykIdouHaneiKekkaRn.zrnhuho2kyknokbn.asc(), qZT_KykIdouHaneiKekkaRn.zrnhuho2kykno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KykIdouHaneiKekkaRn).getResults();
    }
}
