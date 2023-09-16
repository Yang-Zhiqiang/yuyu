package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.meta.QJT_Sk;
import yuyu.def.db.meta.QJT_SkKihon;

/**
 * 請求テーブル(JT_SkDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SkDao extends AbstractDao<JT_Sk> {

    public JT_SkDao() {
        super(JT_Sk.class);
    }

    @Deprecated
    public JT_Sk getSk(String pSkno,
        String pSyono,
        Integer pSeikyuurirekino){
        JT_Sk jT_Sk =  new JT_Sk();
        jT_Sk.setSkno(pSkno);
        jT_Sk.setSyono(pSyono);
        jT_Sk.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_Sk);
    }

    @Override
    @Deprecated
    public List<JT_Sk> selectAll() {
        return super.selectAll();
    }

    public JT_Sk getSkBySknoSyonoMaxSeikyuurirekino(String pSkno, String pSyono) {


        QJT_Sk qJT_Sk = new QJT_Sk();

        String subQueryStr = "(" + $SELECT + $MAX(qJT_Sk.seikyuurirekino) +
            $FROM + qJT_Sk.JT_Sk() +
            $WHERE + qJT_Sk.skno.eq(pSkno) +
            $AND + qJT_Sk.syono.eq(pSyono) + ")";

        String mainQueryStr = $SELECT + qJT_Sk +
            $FROM + qJT_Sk.JT_Sk() +
            $WHERE + qJT_Sk.skno.eq(pSkno) +
            $AND + qJT_Sk.syono.eq(pSyono) +
            $AND + qJT_Sk.seikyuurirekino + $EQ + subQueryStr;

        return em.createJPQL(mainQueryStr).bind(qJT_Sk).getSingleResult();
    }

    public Integer getSkMaxSeikyuurirekinoBySknoSyono(String pSkno, String pSyono) {


        QJT_Sk qJT_Sk = new QJT_Sk();

        String querySql =$SELECT + $MAX(qJT_Sk.seikyuurirekino) +
            $FROM + qJT_Sk.JT_Sk() +
            $WHERE + qJT_Sk.skno.eq(pSkno) +
            $AND + qJT_Sk.syono.eq(pSyono);

        return em.createJPQL(querySql).bind(qJT_Sk).getSingleResult();
    }

    public List<JT_Sk> getSksBySyonoItemsSeikyuurirekinoMax(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu,
        C_SaisateiKbn pSaisateikbn, C_SyoriJyoutaiKbn pSyorijyoutaikbn) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon("q1");

        QJT_Sk qJT_Sk = new QJT_Sk("q2");

        QJT_Sk qJT_Sk2 = new QJT_Sk("q3");


        String subquery = $SELECT + $MAX(qJT_Sk2.seikyuurirekino) +
            $FROM + qJT_Sk2.JT_Sk() + "," +
            qJT_SkKihon.JT_SkKihon() +
            $WHERE + qJT_SkKihon.syono.eq(pSyono) +
            $AND + qJT_SkKihon.seikyuusyubetu.eq(pSeikyuusyubetu) +
            $AND + qJT_SkKihon.saisateikbn.eq(pSaisateikbn) +
            $AND + qJT_SkKihon.syorijyoutaikbn.eq(pSyorijyoutaikbn) +
            $AND + qJT_Sk2.skno.eq(qJT_SkKihon.skno) +
            $AND + qJT_Sk2.syono.eq(qJT_SkKihon.syono) +
            $GROUP_BY + qJT_Sk2.skno+ "," +
            qJT_Sk2.syono +
            $HAVING + $MAX(qJT_Sk2.seikyuurirekino) +
            $EQ + qJT_Sk.seikyuurirekino +
            $AND + qJT_Sk2.skno.eq(qJT_Sk.skno) +
            $AND + qJT_Sk2.syono.eq(qJT_Sk.syono);


        String mainQuery = $SELECT + qJT_Sk +
            $FROM + qJT_Sk.JT_Sk() +
            $WHERE + $EXISTS(subquery);

        return em.createJPQL(mainQuery).bind(qJT_SkKihon, qJT_Sk, qJT_Sk2).getResultList();
    }
}
