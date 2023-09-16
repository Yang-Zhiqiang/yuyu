package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.meta.QJT_SiRireki;
import yuyu.def.db.meta.QJT_Sk;
import yuyu.def.db.meta.QJT_SkKihon;

/**
 * 支払履歴テーブル(JT_SiRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiRirekiDao extends AbstractDao<JT_SiRireki> {

    public JT_SiRirekiDao() {
        super(JT_SiRireki.class);
    }

    @Deprecated
    public JT_SiRireki getSiRireki(String pSkno,
        String pSyono,
        String pShrsikibetukey){
        JT_SiRireki jT_SiRireki =  new JT_SiRireki();
        jT_SiRireki.setSkno(pSkno);
        jT_SiRireki.setSyono(pSyono);
        jT_SiRireki.setShrsikibetukey(pShrsikibetukey);
        return this.selectOne(jT_SiRireki);
    }

    @Override
    @Deprecated
    public List<JT_SiRireki> selectAll() {
        return super.selectAll();
    }

    public List<JT_SiRireki> getSiRirekisBySyonoShrkekkakbnTorikesiflg(String pSyono, C_ShrKekkaKbn pShrkekkakbn,
        C_UmuKbn pTorikesiflg) {
        JT_SiRireki jT_SiRireki =  new JT_SiRireki();
        jT_SiRireki.setSyono(pSyono);
        jT_SiRireki.setShrkekkakbn(pShrkekkakbn);
        jT_SiRireki.setTorikesiflg(pTorikesiflg);
        return this.select(jT_SiRireki);
    }

    public List<JT_SiRireki> getSiRirekisBySyonoGyoumuKousinTime(String pSyono, String pGyoumuKousinTime) {


        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki();


        String queryStr = $SELECT + qJT_SiRireki +
            $FROM + qJT_SiRireki.JT_SiRireki() +
            $WHERE + qJT_SiRireki.syono.eq(pSyono) +
            $AND + qJT_SiRireki.gyoumuKousinTime.ge(pGyoumuKousinTime);

        return em.createJPQL(queryStr).bind(qJT_SiRireki).getResultList();
    }

    public List<Object[]> getSiRirekiSkKihonSksBySyonoTorikesiflg(String pSyono, C_UmuKbn pTorikesiflg) {

        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki("qJT_SiRireki");

        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon("qJT_SkKihon");

        QJT_Sk qJT_Sk= new QJT_Sk("qJT_Sk");

        String quertSql = $SELECT + qJT_SiRireki + ","
            + qJT_SkKihon + ","
            + qJT_Sk +
            $FROM + qJT_SiRireki.JT_SiRireki() + ","
            + qJT_SkKihon.JT_SkKihon() + ","
            + qJT_Sk.JT_Sk() +
            $WHERE + qJT_SiRireki.skno.eq(qJT_SkKihon.skno) +
            $AND + qJT_SiRireki.syono.eq(qJT_SkKihon.syono) +
            $AND + qJT_SiRireki.skno.eq(qJT_Sk.skno) +
            $AND + qJT_SiRireki.syono.eq(qJT_Sk.syono) +
            $AND + qJT_SiRireki.seikyuurirekino.eq(qJT_Sk.seikyuurirekino) +
            $AND + qJT_SiRireki.torikesiflg.eq(pTorikesiflg) +
            $AND + qJT_SiRireki.syono.eq(pSyono) +
            $ORDER_BY(qJT_SiRireki.shrsyoriymd.asc());
        return em.createJPQL(quertSql).bind(qJT_SiRireki, qJT_SkKihon, qJT_Sk).getResultList();
    }

    public ExDBResults<JT_SiRireki> getSiRirekisBySeikyuusyubetuShrsyoriymdShrkekkakbn(BizDate pShrsyoriymdFrom, BizDate pShrsyoriymdTo) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();
        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki();


        String strSql = $SELECT + qJT_SiRireki +
            $FROM(qJT_SkKihon, qJT_SiRireki) +
            $WHERE + qJT_SiRireki.skno.eq(qJT_SkKihon.skno) +
            $AND + qJT_SiRireki.syono.eq(qJT_SkKihon.syono) +
            $AND + qJT_SkKihon.seikyuusyubetu.ne(C_SeikyuuSyubetu.SDSSHR) +
            $AND + qJT_SiRireki.shrsyoriymd.ge(pShrsyoriymdFrom) +
            $AND + qJT_SiRireki.shrsyoriymd.le(pShrsyoriymdTo) +
            $AND + qJT_SiRireki.shrkekkakbn.in(C_ShrKekkaKbn.SHR, C_ShrKekkaKbn.ITIBU_SHR) +
            $ORDER_BY(qJT_SiRireki.syono.asc(),
                qJT_SiRireki.skno.asc());


        return em.createJPQL(strSql).bind(qJT_SkKihon, qJT_SiRireki).getResults();
    }

    public String getSiRirekiMaxShrsikibetukeyBySknoSyono(String pSkno, String pSyono) {


        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki();


        String strSql = $SELECT + $MAX(qJT_SiRireki.shrsikibetukey) +
            $FROM + qJT_SiRireki.JT_SiRireki() +
            $WHERE + qJT_SiRireki.skno.eq(pSkno) +
            $AND + qJT_SiRireki.syono.eq(pSyono);


        return em.createJPQL(strSql).bind(qJT_SiRireki).getSingleResult();
    }

    public ExDBResults<JT_SiRireki> getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo(
        C_ShrKekkaKbn pShrkekkakbn, BizDate pShrsyoriymdFrom,
        BizDate pShrsyoriymdTo) {


        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki();


        String strSql = $SELECT + qJT_SiRireki +
            $FROM + qJT_SiRireki.JT_SiRireki() +
            $WHERE + qJT_SiRireki.shrkekkakbn.eq(pShrkekkakbn) +
            $AND + qJT_SiRireki.shrsyoriymd.ge(pShrsyoriymdFrom) +
            $AND + qJT_SiRireki.shrsyoriymd.le(pShrsyoriymdTo);


        return em.createJPQL(strSql).bind(qJT_SiRireki).getResults();
    }

    public ExDBResults<JT_SiRireki> getSiRirekisByShrkekkakbnTyakkinymdFromTyakkinymdTo(
        C_ShrKekkaKbn pShrkekkakbn, BizDate pTyakkinymdFrom,
        BizDate pTyakkinymdTo) {


        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki();


        String strSql = $SELECT + qJT_SiRireki +
            $FROM + qJT_SiRireki.JT_SiRireki() +
            $WHERE + qJT_SiRireki.shrkekkakbn.eq(pShrkekkakbn) +
            $AND + qJT_SiRireki.tyakkinymd.ge(pTyakkinymdFrom) +
            $AND + qJT_SiRireki.tyakkinymd.le(pTyakkinymdTo);


        return em.createJPQL(strSql).bind(qJT_SiRireki).getResults();
    }

}
