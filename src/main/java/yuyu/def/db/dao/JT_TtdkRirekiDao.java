package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.db.meta.QJT_SateiSyouninRireki;
import yuyu.def.db.meta.QJT_TtdkRireki;

/**
 * 手続履歴テーブル(JT_TtdkRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class JT_TtdkRirekiDao extends AbstractDao<JT_TtdkRireki> {

    public JT_TtdkRirekiDao() {
        super(JT_TtdkRireki.class);
    }

    @Deprecated
    public JT_TtdkRireki getTtdkRireki(String pSkno,
        String pSyono,
        String pTtdkrrkskbtkey){
        JT_TtdkRireki jT_TtdkRireki =  new JT_TtdkRireki();
        jT_TtdkRireki.setSkno(pSkno);
        jT_TtdkRireki.setSyono(pSyono);
        jT_TtdkRireki.setTtdkrrkskbtkey(pTtdkrrkskbtkey);
        return this.selectOne(jT_TtdkRireki);
    }

    @Override
    @Deprecated
    public List<JT_TtdkRireki> selectAll() {
        return super.selectAll();
    }

    public String getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(String pSkno, String pSyono) {


        QJT_TtdkRireki qJT_TtdkRireki = new QJT_TtdkRireki();


        String strSql = $SELECT + $MAX(qJT_TtdkRireki.ttdkrrkskbtkey) +
            $FROM + qJT_TtdkRireki.JT_TtdkRireki() +
            $WHERE + qJT_TtdkRireki.skno.eq(pSkno) +
            $AND + qJT_TtdkRireki.syono.eq(pSyono);


        return em.createJPQL(strSql).bind(qJT_TtdkRireki).getSingleResult();
    }

    public ExDBResults<JT_TtdkRireki> getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey(BizDate pSyoriYmd, String pKossyorisscd) {


        QJT_TtdkRireki qJT_TtdkRireki1 = new QJT_TtdkRireki("qJT_TtdkRireki1");
        QJT_TtdkRireki qJT_TtdkRireki2 = new QJT_TtdkRireki("qJT_TtdkRireki2");
        QJT_SateiSyouninRireki qJT_SateiSyouninRireki = new QJT_SateiSyouninRireki("qJT_SateiSyouninRireki");


        String strSubSql1 = $SELECT + qJT_TtdkRireki2.skno +
            $FROM + qJT_TtdkRireki2.JT_TtdkRireki() +
            $WHERE + qJT_TtdkRireki2.skno.eq(qJT_TtdkRireki1.skno) +
            $AND + qJT_TtdkRireki2.syono.eq(qJT_TtdkRireki1.syono) +
            $GROUP_BY + qJT_TtdkRireki2.skno + ","+ qJT_TtdkRireki2.syono +
            $HAVING + $MAX(qJT_TtdkRireki2.ttdkrrkskbtkey) + $EQ + qJT_TtdkRireki1.ttdkrrkskbtkey;


        String strSubSql2 = $SELECT + qJT_SateiSyouninRireki.skno +
            $FROM + qJT_SateiSyouninRireki.JT_SateiSyouninRireki() +
            $WHERE + qJT_SateiSyouninRireki.skno.eq(qJT_TtdkRireki1.skno) +
            $AND + qJT_SateiSyouninRireki.syono.eq(qJT_TtdkRireki1.syono) +
            $AND + qJT_SateiSyouninRireki.sateisyouninskbtkey.eq(qJT_TtdkRireki1.sateisyouninskbtkey) +
            $AND + qJT_SateiSyouninRireki.syorikekkakbn.in(C_SyorikekkaKbn.KAKUNIN, C_SyorikekkaKbn.TUIKAKAKUNIN, C_SyorikekkaKbn.TYUUKANKAKUNIN);


        String strSql = $SELECT + qJT_TtdkRireki1 +
            $FROM + qJT_TtdkRireki1.JT_TtdkRireki() +
            $WHERE + qJT_TtdkRireki1.syoriYmd.eq(pSyoriYmd) +
            $AND + $EXISTS(strSubSql1) +
            $AND + qJT_TtdkRireki1.kossyorisscd.eq(pKossyorisscd) +
            $AND + $EXISTS(strSubSql2) +
            $ORDER_BY(qJT_TtdkRireki1.skno.asc(), qJT_TtdkRireki1.syono.asc());


        return em.createJPQL(strSql).bind(qJT_TtdkRireki1, qJT_TtdkRireki2, qJT_SateiSyouninRireki).getResults();
    }

    public JT_TtdkRireki getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds(String pSkno, String pSyono,
        C_SyorikekkaKbn pSyorikekkakbn, String[] pKossyorisscd) {


        QJT_TtdkRireki qJT_TtdkRireki = new QJT_TtdkRireki("qJT_TtdkRireki");

        QJT_TtdkRireki qJT_TtdkRireki2 = new QJT_TtdkRireki("qJT_TtdkRireki2");

        QJT_SateiSyouninRireki qJT_SateiSyouninRireki = new QJT_SateiSyouninRireki("qJT_SateiSyouninRireki");


        String subQuerry = $SELECT + $MAX(qJT_TtdkRireki2.ttdkrrkskbtkey) +
            $FROM + qJT_TtdkRireki2.JT_TtdkRireki() + "," +
            qJT_SateiSyouninRireki.JT_SateiSyouninRireki() +
            $WHERE + qJT_TtdkRireki2.skno.eq(qJT_SateiSyouninRireki.skno) +
            $AND + qJT_TtdkRireki2.syono.eq(qJT_SateiSyouninRireki.syono) +
            $AND + qJT_TtdkRireki2.sateisyouninskbtkey.eq(qJT_SateiSyouninRireki.sateisyouninskbtkey) +
            $AND + qJT_TtdkRireki2.skno.eq(pSkno) +
            $AND + qJT_TtdkRireki2.syono.eq(pSyono) +
            $AND + qJT_SateiSyouninRireki.syorikekkakbn.eq(pSyorikekkakbn) +
            $AND + qJT_SateiSyouninRireki.kossyorisscd.in(pKossyorisscd) +
            $GROUP_BY + qJT_TtdkRireki2.skno+ "," +
            qJT_TtdkRireki2.syono +
            $HAVING + $MAX(qJT_TtdkRireki2.ttdkrrkskbtkey) + $EQ + qJT_TtdkRireki.ttdkrrkskbtkey;


        String strSql = $SELECT + qJT_TtdkRireki +
            $FROM + qJT_TtdkRireki.JT_TtdkRireki() +
            $WHERE + $EXISTS(subQuerry);


        return em.createJPQL(strSql).bind(qJT_TtdkRireki, qJT_TtdkRireki2, qJT_SateiSyouninRireki).getSingleResult();
    }

    public JT_TtdkRireki getTtdkRirekisBySknoSyonoSyorikekkakbnsKossyorisscds(
        String pSkno, String pSyono, String[] pKossyorisscd,
        C_SyorikekkaKbn... pSyorikekkakbn) {

        QJT_TtdkRireki qJT_TtdkRireki = new QJT_TtdkRireki("qJT_TtdkRireki");

        QJT_TtdkRireki qJT_TtdkRireki2 = new QJT_TtdkRireki("qJT_TtdkRireki2");

        QJT_SateiSyouninRireki qJT_SateiSyouninRireki = new QJT_SateiSyouninRireki("qJT_SateiSyouninRireki");


        String subQuerry = $SELECT + $MAX(qJT_TtdkRireki2.ttdkrrkskbtkey) +
            $FROM + qJT_TtdkRireki2.JT_TtdkRireki() + "," +
            qJT_SateiSyouninRireki.JT_SateiSyouninRireki() +
            $WHERE + qJT_TtdkRireki2.syono.eq(qJT_TtdkRireki.syono) +
            $AND + qJT_TtdkRireki2.skno.eq(qJT_TtdkRireki.skno) +
            $AND + qJT_TtdkRireki2.skno.eq(qJT_SateiSyouninRireki.skno) +
            $AND + qJT_TtdkRireki2.syono.eq(qJT_SateiSyouninRireki.syono) +
            $AND + qJT_TtdkRireki2.sateisyouninskbtkey.eq(qJT_SateiSyouninRireki.sateisyouninskbtkey) +
            $AND + qJT_SateiSyouninRireki.syorikekkakbn.in(pSyorikekkakbn) +
            $AND + qJT_TtdkRireki2.kossyorisscd.in(pKossyorisscd) +
            $GROUP_BY + qJT_TtdkRireki2.skno+ "," +
            qJT_TtdkRireki2.syono +
            $HAVING + $MAX(qJT_TtdkRireki2.ttdkrrkskbtkey) + $EQ + qJT_TtdkRireki.ttdkrrkskbtkey;



        String strSql = $SELECT + qJT_TtdkRireki +
            $FROM + qJT_TtdkRireki.JT_TtdkRireki() +
            $WHERE + qJT_TtdkRireki.skno.eq(pSkno) +
            $AND + qJT_TtdkRireki.syono.eq(pSyono) +
            $AND + $EXISTS(subQuerry) ;


        return em.createJPQL(strSql).bind(qJT_TtdkRireki, qJT_TtdkRireki2, qJT_SateiSyouninRireki).getSingleResult();
    }
}
