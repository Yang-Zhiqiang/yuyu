package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_YuukouKakKekkaFRn;
import yuyu.def.db.meta.QZT_YuukouKakKekkaFRn;

/**
 * 有効性確認結果Ｆテーブル（連）(ZT_YuukouKakKekkaFRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_YuukouKakKekkaFRnDao extends AbstractDao<ZT_YuukouKakKekkaFRn> {

    public ZT_YuukouKakKekkaFRnDao() {
        super(ZT_YuukouKakKekkaFRn.class);
    }

    public ZT_YuukouKakKekkaFRn getYuukouKakKekkaFRn(String pZrncreditkessaiyouno) {
        ZT_YuukouKakKekkaFRn zT_YuukouKakKekkaFRn =  new ZT_YuukouKakKekkaFRn();
        zT_YuukouKakKekkaFRn.setZrncreditkessaiyouno(pZrncreditkessaiyouno);
        return this.selectOne(zT_YuukouKakKekkaFRn);
    }

    public ExDBResults<ZT_YuukouKakKekkaFRn> selectAllZT_YuukouKakKekkaFRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_YuukouKakKekkaFRn qZT_YuukouKakKekkaFRn =  new QZT_YuukouKakKekkaFRn();
        jpql.append($SELECT);
        jpql.append(qZT_YuukouKakKekkaFRn);
        jpql.append($FROM);
        jpql.append(qZT_YuukouKakKekkaFRn.ZT_YuukouKakKekkaFRn());
        jpql.append($ORDER_BY(qZT_YuukouKakKekkaFRn.zrncreditkessaiyouno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_YuukouKakKekkaFRn).getResults();
    }
}
