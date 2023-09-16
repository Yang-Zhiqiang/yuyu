package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.meta.QHT_Henkin;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * 返金テーブル(HT_HenkinDao) アクセス用の DAO クラスです。<br />
 */
public class HT_HenkinDao extends AbstractDao<HT_Henkin> {

    public HT_HenkinDao() {
        super(HT_Henkin.class);
    }

    @Deprecated
    public HT_Henkin getHenkin(String pMosno,
        Integer pRenno){
        HT_Henkin hT_Henkin =  new HT_Henkin();
        hT_Henkin.setMosno(pMosno);
        hT_Henkin.setRenno(pRenno);
        return this.selectOne(hT_Henkin);
    }

    @Override
    @Deprecated
    public List<HT_Henkin> selectAll() {
        return super.selectAll();
    }

    public Integer getHenkinMaxRennoByMosno(String pMosno) {


        QHT_Henkin qHT_Henkin = new QHT_Henkin();

        String querySql =$SELECT + $MAX(qHT_Henkin.renno) +
            $FROM + qHT_Henkin.HT_Henkin() +
            $WHERE + qHT_Henkin.mosno.eq(pMosno) ;

        return em.createJPQL(querySql).bind(qHT_Henkin).getSingleResult();
    }

    public List<HT_Henkin> getHenkinsByMosnoHnknsyoriymd(String pMosno, BizDate pHnknsyoriymd) {


        QHT_Henkin qHT_Henkin = new QHT_Henkin();

        String querySql = $SELECT + qHT_Henkin +
            $FROM + qHT_Henkin.HT_Henkin() +
            $WHERE + qHT_Henkin.mosno.eq(pMosno) +
            $AND + "(" + qHT_Henkin.hnknsyoriymd.isNull() +
            $OR + qHT_Henkin.hnknsyoriymd.ge(pHnknsyoriymd) + ")" +
            $AND + qHT_Henkin.pkakinsyoriymd.lt(pHnknsyoriymd) ;
        return em.createJPQL(querySql).bind(qHT_Henkin).getResultList();
    }

    public List<BizCurrency> getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn(String pMosno, BizDate pHnknsyoriymd) {


        QHT_Henkin qHT_Henkin = new QHT_Henkin();

        String maiQueryStr = $SELECT + $NEW(BizCurrencySum.class,
            qHT_Henkin.hnkngk.getTypeFieldName(),
            $SUM + $(qHT_Henkin.hnkngk.getValueFieldName())) +
            $FROM + qHT_Henkin.HT_Henkin() +
            $WHERE + qHT_Henkin.mosno.eq(pMosno) +
            $AND + qHT_Henkin.hnknsyoriymd.eq(pHnknsyoriymd) +
            $AND + qHT_Henkin.hnknhoukbn.ne(C_HnknhouKbn.KARIUKE) +
            $GROUP_BY + qHT_Henkin.hnkngk.getTypeFieldName() +
            $ORDER_BY (qHT_Henkin.hnkngk.typeAsc());


        List<BizCurrencySum> results = em.createJPQL(maiQueryStr, BizCurrencySum.class).bind(qHT_Henkin).getResultList();

        List<BizCurrency> currencies = Lists.transform(results, new Function<BizCurrencySum, BizCurrency>() {
            @Override
            public BizCurrency apply(BizCurrencySum sum) {
                return sum.toBizCurrency();
            }});

        return currencies;
    }


    public List<HT_Henkin> getHenkinSumHnkngkByMosnoHnkntuukasyu(String pMosno, C_Tuukasyu pHnkntuukasyu) {


        QHT_Henkin qHT_Henkin = new QHT_Henkin();

        String querySql = $SELECT + qHT_Henkin +
            $FROM + qHT_Henkin.HT_Henkin() +
            $WHERE + qHT_Henkin.mosno.eq(pMosno) +
            $AND + qHT_Henkin.hnkntuukasyu.eq(pHnkntuukasyu) +
            $AND + qHT_Henkin.hnknhoukbn.eq(C_HnknhouKbn.KARIUKE);

        return em.createJPQL(querySql).bind(qHT_Henkin).getResultList();
    }


    public Long getHenkinCountByMosnoHnknsyoriymd(String pMosno) {


        QHT_Henkin qHT_Henkin = new QHT_Henkin();

        String querySql = $SELECT + $COUNT(qHT_Henkin.mosno) +
            $FROM + qHT_Henkin.HT_Henkin() +
            $WHERE + qHT_Henkin.mosno.eq(pMosno) +
            $AND + qHT_Henkin.hnknsyoriymd.isNull();

        return em.createJPQL(querySql).bind(qHT_Henkin).getSingleResult();
    }

    public List<HT_Henkin> getHenkinsByMosnoHnknsyoriymdHnknhoukbnHnkntuukasyu(String pMosno, BizDate pHnknsyoriymd,
        C_Tuukasyu pHnkntuukasyu) {

        QHT_Henkin qHT_Henkin = new QHT_Henkin();

        String querySql = $SELECT + qHT_Henkin +
            $FROM + qHT_Henkin.HT_Henkin() +
            $WHERE + qHT_Henkin.mosno.eq(pMosno) +
            $AND + qHT_Henkin.hnknsyoriymd.eq(pHnknsyoriymd) +
            $AND + qHT_Henkin.hnknhoukbn.ne(C_HnknhouKbn.KARIUKE) +
            $AND + qHT_Henkin.hnkntuukasyu.eq(pHnkntuukasyu);

        return em.createJPQL(querySql).bind(qHT_Henkin).getResultList();
    }

    public List<HT_Henkin> getHenkinsByMosnoHnknsyoriymdHnknhoukbn(String pMosno, BizDate pHnknsyoriymd) {


        QHT_Henkin qHT_Henkin = new QHT_Henkin();

        String querySql = $SELECT + qHT_Henkin +
            $FROM + qHT_Henkin.HT_Henkin() +
            $WHERE + qHT_Henkin.mosno.eq(pMosno) +
            $AND + qHT_Henkin.hnknsyoriymd.eq(pHnknsyoriymd) +
            $AND + qHT_Henkin.hnknhoukbn.ne(C_HnknhouKbn.KARIUKE);

        return em.createJPQL(querySql).bind(qHT_Henkin).getResultList();
    }

    public Integer getHenkinMaxZenhnknrenno(String pMosno) {


        QHT_Henkin qHT_Henkin = new QHT_Henkin("qHT_Henkin");

        String querySql = $SELECT + $MAX(qHT_Henkin.zenhnknrenno) +
            $FROM(qHT_Henkin) +
            $WHERE + qHT_Henkin.mosno.eq(pMosno);

        return em.createJPQL(querySql).bind(qHT_Henkin).getSingleResult();
    }
}
