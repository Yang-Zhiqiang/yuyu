package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.meta.QJT_SateiSyouninRireki;
import yuyu.def.db.meta.QJT_SkKihon;
import yuyu.def.db.meta.QJT_TtdkRireki;

/**
 * 査定承認履歴テーブル(JT_SateiSyouninRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SateiSyouninRirekiDao extends AbstractDao<JT_SateiSyouninRireki> {

    public JT_SateiSyouninRirekiDao() {
        super(JT_SateiSyouninRireki.class);
    }

    @Deprecated
    public JT_SateiSyouninRireki getSateiSyouninRireki(String pSkno,
        String pSyono,
        String pSateisyouninskbtkey){
        JT_SateiSyouninRireki jT_SateiSyouninRireki =  new JT_SateiSyouninRireki();
        jT_SateiSyouninRireki.setSkno(pSkno);
        jT_SateiSyouninRireki.setSyono(pSyono);
        jT_SateiSyouninRireki.setSateisyouninskbtkey(pSateisyouninskbtkey);
        return this.selectOne(jT_SateiSyouninRireki);
    }

    @Override
    @Deprecated
    public List<JT_SateiSyouninRireki> selectAll() {
        return super.selectAll();
    }

    public ExDBResults<JT_SateiSyouninRireki> getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds(
        C_SyorikekkaKbn pSyorikekkakbn, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String[] pKossyorisscd) {


        QJT_SateiSyouninRireki qJT_SateiSyouninRireki = new QJT_SateiSyouninRireki();


        QJT_TtdkRireki qJT_TtdkRireki = new QJT_TtdkRireki();


        String querySql = $SELECT + qJT_SateiSyouninRireki +
            $FROM + qJT_SateiSyouninRireki.JT_SateiSyouninRireki() + "," +
            qJT_TtdkRireki.JT_TtdkRireki() +
            $WHERE + qJT_TtdkRireki.skno.eq(qJT_SateiSyouninRireki.skno) +
            $AND + qJT_TtdkRireki.syono.eq(qJT_SateiSyouninRireki.syono) +
            $AND + qJT_TtdkRireki.sateisyouninskbtkey.eq(qJT_SateiSyouninRireki.sateisyouninskbtkey) +
            $AND + qJT_SateiSyouninRireki.syorikekkakbn.eq(pSyorikekkakbn) +
            $AND + qJT_TtdkRireki.kossyorisscd.in(pKossyorisscd) +
            $AND + qJT_TtdkRireki.syoriYmd.ge(pSyoriYmdFrom) +
            $AND + qJT_TtdkRireki.syoriYmd.le(pSyoriYmdTo) +
            $ORDER_BY (qJT_SateiSyouninRireki.skno.asc(),
                qJT_SateiSyouninRireki.syono.asc(),
                qJT_SateiSyouninRireki.sateisyouninskbtkey.desc());

        return em.createJPQL(querySql).bind(qJT_SateiSyouninRireki, qJT_TtdkRireki).getResults();
    }

    public String getSateiSyouninRirekiMaxSateisyouninskbtkeyBySknoSyono(String pSkno, String pSyono) {


        QJT_SateiSyouninRireki qJT_SateiSyouninRireki = new QJT_SateiSyouninRireki();


        String strSql = $SELECT + $MAX(qJT_SateiSyouninRireki.sateisyouninskbtkey) +
            $FROM + qJT_SateiSyouninRireki.JT_SateiSyouninRireki() +
            $WHERE + qJT_SateiSyouninRireki.skno.eq(pSkno) +
            $AND + qJT_SateiSyouninRireki.syono.eq(pSyono);


        return em.createJPQL(strSql).bind(qJT_SateiSyouninRireki).getSingleResult();
    }

    public ExDBResults<JT_SateiSyouninRireki> getSaishigaitoulistsBySyorikekkakbnItems(C_SyorikekkaKbn pSyorikekkakbn,
        String[] pKossyorisscd, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, C_SaigaiHigaitouKbn pSaigaihigaitoukbn) {


        QJT_SateiSyouninRireki qJT_SateiSyouninRireki = new QJT_SateiSyouninRireki();


        QJT_TtdkRireki qJT_TtdkRireki = new QJT_TtdkRireki();


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();


        String strSql = $SELECT + qJT_SateiSyouninRireki +
            $FROM(qJT_SateiSyouninRireki,
                qJT_TtdkRireki,
                qJT_SkKihon) +
            $WHERE + qJT_TtdkRireki.skno.eq(qJT_SateiSyouninRireki.skno) +
            $AND + qJT_TtdkRireki.syono.eq(qJT_SateiSyouninRireki.syono) +
            $AND + qJT_TtdkRireki.sateisyouninskbtkey.eq(qJT_SateiSyouninRireki.sateisyouninskbtkey) +
            $AND + qJT_SateiSyouninRireki.syorikekkakbn.eq(pSyorikekkakbn) +
            $AND + qJT_TtdkRireki.kossyorisscd.in(pKossyorisscd) +
            $AND + qJT_TtdkRireki.syoriYmd.ge(pSyoriYmdFrom) +
            $AND + qJT_TtdkRireki.syoriYmd.le(pSyoriYmdTo) +
            $AND + qJT_SkKihon.skno.eq(qJT_SateiSyouninRireki.skno) +
            $AND + qJT_SkKihon.syono.eq(qJT_SateiSyouninRireki.syono) +
            $AND + qJT_SkKihon.saigaihigaitoukbn.eq(pSaigaihigaitoukbn) +
            $ORDER_BY(qJT_SateiSyouninRireki.skno.asc(),
                qJT_SateiSyouninRireki.syono.asc(),
                    qJT_SateiSyouninRireki.sateisyouninskbtkey.desc());


        return em.createJPQL(strSql).bind(qJT_SateiSyouninRireki, qJT_TtdkRireki, qJT_SkKihon).getResults();
    }
}
