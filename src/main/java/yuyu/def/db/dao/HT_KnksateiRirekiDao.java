package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.meta.QHT_KnksateiRireki;

/**
 * 環境査定履歴テーブル(HT_KnksateiRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_KnksateiRirekiDao extends AbstractDao<HT_KnksateiRireki> {

    public HT_KnksateiRirekiDao() {
        super(HT_KnksateiRireki.class);
    }

    @Deprecated
    public HT_KnksateiRireki getKnksateiRireki(String pMosno,
        Integer pRenno){
        HT_KnksateiRireki hT_KnksateiRireki =  new HT_KnksateiRireki();
        hT_KnksateiRireki.setMosno(pMosno);
        hT_KnksateiRireki.setRenno(pRenno);
        return this.selectOne(hT_KnksateiRireki);
    }

    @Override
    @Deprecated
    public List<HT_KnksateiRireki> selectAll() {
        return super.selectAll();
    }

    public HT_KnksateiRireki getKnksateiRirekiByMosnoMaxRenno(String pMosno) {


        QHT_KnksateiRireki qHT_KnksateiRireki = new QHT_KnksateiRireki();

        String subQueryStr = "(" + $SELECT + $MAX(qHT_KnksateiRireki.renno) +
            $FROM + qHT_KnksateiRireki.HT_KnksateiRireki() +
            $WHERE + qHT_KnksateiRireki.mosno.eq(pMosno) + ")";

        String mainQueryStr = $SELECT + qHT_KnksateiRireki +
            $FROM + qHT_KnksateiRireki.HT_KnksateiRireki() +
            $WHERE + qHT_KnksateiRireki.mosno.eq(pMosno) +
            $AND + qHT_KnksateiRireki.renno + $EQ + subQueryStr;

        return em.createJPQL(mainQueryStr).bind(qHT_KnksateiRireki).getSingleResult();
    }

    public Long getKnksateiRirekiCountByKetsyacdTnsketsyacd(String pKetsyacd) {


        QHT_KnksateiRireki qHT_KnksateiRireki = new QHT_KnksateiRireki();

        String quertSql = $SELECT + $COUNT +"(*)"+
            $FROM + qHT_KnksateiRireki.HT_KnksateiRireki() +
            $WHERE + qHT_KnksateiRireki.ketsyacd.eq(pKetsyacd) +
            $OR + qHT_KnksateiRireki.tnsketsyacd.eq(pKetsyacd);

        return em.createJPQL(quertSql).bind(qHT_KnksateiRireki).getSingleResult();
    }
}
