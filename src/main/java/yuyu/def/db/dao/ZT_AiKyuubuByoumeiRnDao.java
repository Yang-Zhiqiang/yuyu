package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_AiKyuubuByoumeiRn;
import yuyu.def.db.meta.QZT_AiKyuubuByoumeiRn;

/**
 * あいキューブ病名マスタ送信データテーブル（連）(ZT_AiKyuubuByoumeiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_AiKyuubuByoumeiRnDao extends AbstractDao<ZT_AiKyuubuByoumeiRn> {

    public ZT_AiKyuubuByoumeiRnDao() {
        super(ZT_AiKyuubuByoumeiRn.class);
    }

    public ZT_AiKyuubuByoumeiRn getAiKyuubuByoumeiRn(String pZrnbyoumeitourokuno) {
        ZT_AiKyuubuByoumeiRn zT_AiKyuubuByoumeiRn =  new ZT_AiKyuubuByoumeiRn();
        zT_AiKyuubuByoumeiRn.setZrnbyoumeitourokuno(pZrnbyoumeitourokuno);
        return this.selectOne(zT_AiKyuubuByoumeiRn);
    }

    public ExDBResults<ZT_AiKyuubuByoumeiRn> selectAllZT_AiKyuubuByoumeiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_AiKyuubuByoumeiRn qZT_AiKyuubuByoumeiRn =  new QZT_AiKyuubuByoumeiRn();
        jpql.append($SELECT);
        jpql.append(qZT_AiKyuubuByoumeiRn);
        jpql.append($FROM);
        jpql.append(qZT_AiKyuubuByoumeiRn.ZT_AiKyuubuByoumeiRn());
        jpql.append($ORDER_BY(qZT_AiKyuubuByoumeiRn.zrnbyoumeitourokuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_AiKyuubuByoumeiRn).getResults();
    }

    public Long getAiKyuubuByoumeiRnCount() {


        QZT_AiKyuubuByoumeiRn qZT_AiKyuubuByoumeiRn = new QZT_AiKyuubuByoumeiRn();

        String querySql = $SELECT + $COUNT + "(*)" +
            $FROM + qZT_AiKyuubuByoumeiRn.ZT_AiKyuubuByoumeiRn();

        return em.createJPQL(querySql).bind(qZT_AiKyuubuByoumeiRn).getSingleResult();
    }
}
