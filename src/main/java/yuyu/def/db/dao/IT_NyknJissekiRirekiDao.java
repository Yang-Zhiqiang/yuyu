package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.hozen.result.bean.NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean;

/**
 * 入金実績履歴テーブル(IT_NyknJissekiRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_NyknJissekiRirekiDao extends AbstractDao<IT_NyknJissekiRireki> {

    public IT_NyknJissekiRirekiDao() {
        super(IT_NyknJissekiRireki.class);
    }

    @Deprecated
    public IT_NyknJissekiRireki getNyknJissekiRireki(String pSyono,
        BizDateYM pJyutoustartym,
        Integer pRenno){
        IT_NyknJissekiRireki iT_NyknJissekiRireki =  new IT_NyknJissekiRireki();
        iT_NyknJissekiRireki.setSyono(pSyono);
        iT_NyknJissekiRireki.setJyutoustartym(pJyutoustartym);
        iT_NyknJissekiRireki.setRenno(pRenno);
        return this.selectOne(iT_NyknJissekiRireki);
    }

    @Override
    @Deprecated
    public List<IT_NyknJissekiRireki> selectAll() {
        return super.selectAll();
    }

    public Long getNyknJissekiRirekiCountBySyono(String pSyono) {


        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki();

        String queryStr = $SELECT + $COUNT +"(*)"+
            $FROM + qIT_NyknJissekiRireki.IT_NyknJissekiRireki() +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + qIT_NyknJissekiRireki.nyktrksflg.ne(C_Nyktrksflg.TORIKESI) +
            $AND + qIT_NyknJissekiRireki.iktnyuukinnumu.eq(C_UmuKbn.ARI);


        return em.createJPQL(queryStr).bind(qIT_NyknJissekiRireki).getSingleResult();
    }

    public Long getNyknJissekiRirekiCountBySyonoJyutouendymIktnyuukinnumuNyktrksflg(String pSyono,
        BizDateYM pJyutouendym, C_UmuKbn pIktnyuukinnumu, C_Nyktrksflg pNyktrksflg) {


        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki();

        String queryStr = $SELECT + $COUNT +"(*)"+
            $FROM + qIT_NyknJissekiRireki.IT_NyknJissekiRireki() +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + qIT_NyknJissekiRireki.jyutouendym.ge(pJyutouendym) +
            $AND + qIT_NyknJissekiRireki.iktnyuukinnumu.eq(pIktnyuukinnumu) +
            $AND + qIT_NyknJissekiRireki.nyktrksflg.ne(pNyktrksflg);

        return em.createJPQL(queryStr).bind(qIT_NyknJissekiRireki).getSingleResult();
    }

    public List<IT_NyknJissekiRireki> getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(String pSyono,
        C_Nyktrksflg pNyktrksflg) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki();

        String strSql1 = $SELECT + $MAX(qIT_NyknJissekiRireki.jyutoustartym) +
            $FROM + qIT_NyknJissekiRireki.IT_NyknJissekiRireki() +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + qIT_NyknJissekiRireki.nyktrksflg.eq(pNyktrksflg);

        String strSql = $SELECT + qIT_NyknJissekiRireki +
            $FROM + qIT_NyknJissekiRireki.IT_NyknJissekiRireki() +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + qIT_NyknJissekiRireki.nyktrksflg.eq(pNyktrksflg) +
            $AND + qIT_NyknJissekiRireki.jyutoustartym + $EQ + $(strSql1) +
            $ORDER_BY(qIT_NyknJissekiRireki.renno.desc());

        return em.createJPQL(strSql).bind(qIT_NyknJissekiRireki).getResultList();
    }

    public NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean getNyknJissekiRirekiRstuukasyuRyosyuymdByPK(String pSyono,
        BizDateYM pJyutoustartym, Integer pRenno) {


        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String strSql = $SELECT + $NEW(NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.class,
            qIT_NyknJissekiRireki.rstuukasyu,
            qIT_NyknJissekiRireki.ryosyuymd )+
            $FROM(qIT_NyknJissekiRireki)+
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + qIT_NyknJissekiRireki.jyutoustartym.eq(pJyutoustartym) +
            $AND + qIT_NyknJissekiRireki.renno.eq(pRenno) ;

        return em.createJPQL(strSql,NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.class).bind(qIT_NyknJissekiRireki).getSingleResult();
    }
}
