package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_YuukouKakKekkaFTr;
import yuyu.def.db.meta.QZT_YuukouKakKekkaFTr;

/**
 * 有効性確認結果Ｆテーブル（取）(ZT_YuukouKakKekkaFTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_YuukouKakKekkaFTrDao extends AbstractDao<ZT_YuukouKakKekkaFTr> {

    public ZT_YuukouKakKekkaFTrDao() {
        super(ZT_YuukouKakKekkaFTr.class);
    }

    public ZT_YuukouKakKekkaFTr getYuukouKakKekkaFTr(String pZtrcreditkessaiyouno) {
        ZT_YuukouKakKekkaFTr zT_YuukouKakKekkaFTr =  new ZT_YuukouKakKekkaFTr();
        zT_YuukouKakKekkaFTr.setZtrcreditkessaiyouno(pZtrcreditkessaiyouno);
        return this.selectOne(zT_YuukouKakKekkaFTr);
    }

    public ExDBResults<ZT_YuukouKakKekkaFTr> selectAllZT_YuukouKakKekkaFTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_YuukouKakKekkaFTr qZT_YuukouKakKekkaFTr =  new QZT_YuukouKakKekkaFTr();
        jpql.append($SELECT);
        jpql.append(qZT_YuukouKakKekkaFTr);
        jpql.append($FROM);
        jpql.append(qZT_YuukouKakKekkaFTr.ZT_YuukouKakKekkaFTr());
        jpql.append($ORDER_BY(qZT_YuukouKakKekkaFTr.ztrcreditkessaiyouno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_YuukouKakKekkaFTr).getResults();
    }
}
