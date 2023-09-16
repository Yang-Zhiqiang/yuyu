package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.meta.QHT_DakuhiKettei;

/**
 * 諾否決定テーブル(HT_DakuhiKetteiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_DakuhiKetteiDao extends AbstractDao<HT_DakuhiKettei> {

    public HT_DakuhiKetteiDao() {
        super(HT_DakuhiKettei.class);
    }

    @Deprecated
    public HT_DakuhiKettei getDakuhiKettei(String pMosno,
        Integer pDakuhiktrenno){
        HT_DakuhiKettei hT_DakuhiKettei =  new HT_DakuhiKettei();
        hT_DakuhiKettei.setMosno(pMosno);
        hT_DakuhiKettei.setDakuhiktrenno(pDakuhiktrenno);
        return this.selectOne(hT_DakuhiKettei);
    }

    @Override
    @Deprecated
    public List<HT_DakuhiKettei> selectAll() {
        return super.selectAll();
    }

    public Integer getDakuhiKetteiMaxDakuhiktrennoByMosno(String pMosno) {


        QHT_DakuhiKettei qHT_DakuhiKettei = new QHT_DakuhiKettei();


        String subQuerry = $SELECT + $MAX(qHT_DakuhiKettei.dakuhiktrenno) +
            $FROM + qHT_DakuhiKettei.HT_DakuhiKettei() +
            $WHERE + qHT_DakuhiKettei.mosno.eq(pMosno);

        return em.createJPQL(subQuerry).bind(qHT_DakuhiKettei).getSingleResult();
    }

    public List<HT_DakuhiKettei> getDakuhiKetteisByKetsyacd(String pKetsyacd) {
        HT_DakuhiKettei hT_DakuhiKettei =  new HT_DakuhiKettei();
        hT_DakuhiKettei.setKetsyacd(pKetsyacd);
        return this.select(hT_DakuhiKettei);
    }

    public HT_DakuhiKettei getDakuhiKetteiByMosnoMaxDakuhiktrenno(String pMosno) {

        QHT_DakuhiKettei qHT_DakuhiKettei1 = new QHT_DakuhiKettei("q1");


        QHT_DakuhiKettei qHT_DakuhiKettei2 = new QHT_DakuhiKettei("q2");


        String strSql1 = $SELECT + $MAX(qHT_DakuhiKettei2.dakuhiktrenno) +
            $FROM + qHT_DakuhiKettei2.HT_DakuhiKettei() +
            $WHERE + qHT_DakuhiKettei2.mosno.eq(pMosno);


        String strSql = $SELECT + qHT_DakuhiKettei1 +
            $FROM + qHT_DakuhiKettei1.HT_DakuhiKettei() +
            $WHERE + qHT_DakuhiKettei1.mosno.eq(pMosno) +
            $AND + qHT_DakuhiKettei1.dakuhiktrenno+ $EQ + $(strSql1);

        return em.createJPQL(strSql).bind(qHT_DakuhiKettei1, qHT_DakuhiKettei2).getSingleResult();
    }

    public HT_DakuhiKettei getDakuhiKetteiByMosnoDakuhiktbunruikbnMaxDakuhiktrenno(String pMosno, C_DakuhiktbunruiKbn pDakuhiktbunruikbn) {


        QHT_DakuhiKettei qHT_DakuhiKettei1 = new QHT_DakuhiKettei("qHT_DakuhiKettei1");
        QHT_DakuhiKettei qHT_DakuhiKettei2 = new QHT_DakuhiKettei("qHT_DakuhiKettei2");


        String strSubSql = $SELECT + $MAX(qHT_DakuhiKettei2.dakuhiktrenno) +
            $FROM + qHT_DakuhiKettei2.HT_DakuhiKettei() +
            $WHERE + qHT_DakuhiKettei2.mosno.eq(pMosno) +
            $AND + qHT_DakuhiKettei2.dakuhiktbunruikbn.eq(pDakuhiktbunruikbn);


        String strMainSql = $SELECT + qHT_DakuhiKettei1 +
            $FROM + qHT_DakuhiKettei1.HT_DakuhiKettei() +
            $WHERE + qHT_DakuhiKettei1.mosno.eq(pMosno) +
            $AND + qHT_DakuhiKettei1.dakuhiktrenno+ $EQ + $(strSubSql);


        return em.createJPQL(strMainSql).bind(qHT_DakuhiKettei1, qHT_DakuhiKettei2).getSingleResult();
    }
}
