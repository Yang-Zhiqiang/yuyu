package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_OnlineLincSousinRn;
import yuyu.def.db.meta.QZT_OnlineLincSousinRn;

/**
 * オンラインＬＩＮＣ送信ファイルテーブル（連）(ZT_OnlineLincSousinRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_OnlineLincSousinRnDao extends AbstractDao<ZT_OnlineLincSousinRn> {

    public ZT_OnlineLincSousinRnDao() {
        super(ZT_OnlineLincSousinRn.class);
    }

    public ZT_OnlineLincSousinRn getOnlineLincSousinRn(String pZrnrecordsyubetukbn, String pZrnkykkanrino) {
        ZT_OnlineLincSousinRn zT_OnlineLincSousinRn =  new ZT_OnlineLincSousinRn();
        zT_OnlineLincSousinRn.setZrnrecordsyubetukbn(pZrnrecordsyubetukbn);
        zT_OnlineLincSousinRn.setZrnkykkanrino(pZrnkykkanrino);
        return this.selectOne(zT_OnlineLincSousinRn);
    }

    public ExDBResults<ZT_OnlineLincSousinRn> selectAllZT_OnlineLincSousinRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_OnlineLincSousinRn qZT_OnlineLincSousinRn =  new QZT_OnlineLincSousinRn();
        jpql.append($SELECT);
        jpql.append(qZT_OnlineLincSousinRn);
        jpql.append($FROM);
        jpql.append(qZT_OnlineLincSousinRn.ZT_OnlineLincSousinRn());
        jpql.append($ORDER_BY(qZT_OnlineLincSousinRn.zrnrecordsyubetukbn.asc(), qZT_OnlineLincSousinRn.zrnkykkanrino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_OnlineLincSousinRn).getResults();
    }
}
