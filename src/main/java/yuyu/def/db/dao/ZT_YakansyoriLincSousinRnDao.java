package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_YakansyoriLincSousinRn;
import yuyu.def.db.meta.QZT_YakansyoriLincSousinRn;

/**
 * 夜間処理ＬＩＮＣ送信ファイルテーブル（連）(ZT_YakansyoriLincSousinRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_YakansyoriLincSousinRnDao extends AbstractDao<ZT_YakansyoriLincSousinRn> {

    public ZT_YakansyoriLincSousinRnDao() {
        super(ZT_YakansyoriLincSousinRn.class);
    }

    public ZT_YakansyoriLincSousinRn getYakansyoriLincSousinRn(String pZrnrecordsyubetukbn, String pZrnkykkanrino) {
        ZT_YakansyoriLincSousinRn zT_YakansyoriLincSousinRn =  new ZT_YakansyoriLincSousinRn();
        zT_YakansyoriLincSousinRn.setZrnrecordsyubetukbn(pZrnrecordsyubetukbn);
        zT_YakansyoriLincSousinRn.setZrnkykkanrino(pZrnkykkanrino);
        return this.selectOne(zT_YakansyoriLincSousinRn);
    }

    public ExDBResults<ZT_YakansyoriLincSousinRn> selectAllZT_YakansyoriLincSousinRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_YakansyoriLincSousinRn qZT_YakansyoriLincSousinRn =  new QZT_YakansyoriLincSousinRn();
        jpql.append($SELECT);
        jpql.append(qZT_YakansyoriLincSousinRn);
        jpql.append($FROM);
        jpql.append(qZT_YakansyoriLincSousinRn.ZT_YakansyoriLincSousinRn());
        jpql.append($ORDER_BY(qZT_YakansyoriLincSousinRn.zrnrecordsyubetukbn.asc(), qZT_YakansyoriLincSousinRn.zrnkykkanrino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_YakansyoriLincSousinRn).getResults();
    }
}
