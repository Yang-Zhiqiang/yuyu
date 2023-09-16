package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiRn;
import yuyu.def.db.meta.QZT_DsKariPasswordTuutiRn;

/**
 * 仮パスワード通知テーブル（連）(ZT_DsKariPasswordTuutiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DsKariPasswordTuutiRnDao extends AbstractDao<ZT_DsKariPasswordTuutiRn> {

    public ZT_DsKariPasswordTuutiRnDao() {
        super(ZT_DsKariPasswordTuutiRn.class);
    }

    public ZT_DsKariPasswordTuutiRn getDsKariPasswordTuutiRn(String pZrnkrpasswordtuutikey) {
        ZT_DsKariPasswordTuutiRn zT_DsKariPasswordTuutiRn =  new ZT_DsKariPasswordTuutiRn();
        zT_DsKariPasswordTuutiRn.setZrnkrpasswordtuutikey(pZrnkrpasswordtuutikey);
        return this.selectOne(zT_DsKariPasswordTuutiRn);
    }

    public ExDBResults<ZT_DsKariPasswordTuutiRn> selectAllZT_DsKariPasswordTuutiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DsKariPasswordTuutiRn qZT_DsKariPasswordTuutiRn =  new QZT_DsKariPasswordTuutiRn();
        jpql.append($SELECT);
        jpql.append(qZT_DsKariPasswordTuutiRn);
        jpql.append($FROM);
        jpql.append(qZT_DsKariPasswordTuutiRn.ZT_DsKariPasswordTuutiRn());
        jpql.append($ORDER_BY(qZT_DsKariPasswordTuutiRn.zrnkrpasswordtuutikey.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DsKariPasswordTuutiRn).getResults();
    }
}
