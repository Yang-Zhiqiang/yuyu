package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.meta.QJT_SiRireki;
import yuyu.def.db.meta.QJT_SibouKariuketsuke;
import yuyu.def.db.meta.QJT_Sk;
import yuyu.def.db.meta.QJT_SkKihon;
import yuyu.def.db.meta.QJT_TtdkRireki;
import yuyu.def.siharai.result.bean.DoujiSeikyuuInfosBySknoSyonoNeBean;
import yuyu.def.siharai.result.bean.SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean;

/**
 * 請求基本テーブル(JT_SkKihonDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SkKihonDao extends AbstractDao<JT_SkKihon> {

    public JT_SkKihonDao() {
        super(JT_SkKihon.class);
    }

    public JT_SkKihon getSkKihon(String pSkno,
        String pSyono){
        JT_SkKihon jT_SkKihon =  new JT_SkKihon();
        jT_SkKihon.setSkno(pSkno);
        jT_SkKihon.setSyono(pSyono);
        return this.selectOne(jT_SkKihon);
    }

    public List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu, C_UmuKbn pTorikesiflg){


        QJT_SkKihon qJT_SkKihon =  new QJT_SkKihon();


        QJT_SibouKariuketsuke qJT_SibouKariuketsuke = new QJT_SibouKariuketsuke();

        String queryStr = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() + "," +
            qJT_SibouKariuketsuke.JT_SibouKariuketsuke() +
            $WHERE + qJT_SkKihon.skno.eq(qJT_SibouKariuketsuke.skno) +
            $AND + qJT_SkKihon.syono.eq(qJT_SibouKariuketsuke.syono) +
            $AND + qJT_SkKihon.syono.eq(pSyono) +
            $AND + qJT_SkKihon.seikyuusyubetu.eq(pSeikyuusyubetu) +
            $AND + qJT_SibouKariuketsuke.torikesiflg.eq(pTorikesiflg);

        return em.createJPQL(queryStr).bind(qJT_SkKihon, qJT_SibouKariuketsuke).getResultList();
    }

    public List<JT_SkKihon> getSkKihonsBySyonoSibouKariuketsuke(String pSyono) {


        QJT_SkKihon qJT_SkKihon =  new QJT_SkKihon();


        QJT_SibouKariuketsuke qJT_SibouKariuketsuke = new QJT_SibouKariuketsuke();

        String queryStr = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() + "," +
            qJT_SibouKariuketsuke.JT_SibouKariuketsuke() +
            $WHERE + qJT_SkKihon.skno.eq(qJT_SibouKariuketsuke.skno) +
            $AND + qJT_SkKihon.syono.eq(qJT_SibouKariuketsuke.syono) +
            $AND + qJT_SkKihon.syono.eq(pSyono) +
            $AND + qJT_SkKihon.seikyuusyubetu.eq(C_SeikyuuSyubetu.SBKRUKTK) +
            $AND + qJT_SibouKariuketsuke.torikesiflg.eq(C_UmuKbn.NONE);

        return em.createJPQL(queryStr).bind(qJT_SkKihon, qJT_SibouKariuketsuke).getResultList();

    }

    public List<DoujiSeikyuuInfosBySknoSyonoNeBean> getDoujiSeikyuuInfosBySknoSyonoNe(String pSkno, String pSyono) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon("qJT_SkKihon");


        QJT_TtdkRireki qJT_TtdkRireki = new QJT_TtdkRireki("qJT_TtdkRireki");

        String queryStr = $SELECT + $NEW(DoujiSeikyuuInfosBySknoSyonoNeBean.class,
            qJT_SkKihon.skno,
            qJT_SkKihon.syono,
            qJT_SkKihon.seikyuusyubetu,
            qJT_SkKihon.syorijyoutaikbn,
            qJT_SkKihon.hubijyoukyoukbn,
            qJT_SkKihon.tyousajyoukyoukbn,
            $($MAX(qJT_TtdkRireki.syoriYmd)) )+
            $FROM + qJT_SkKihon.JT_SkKihon() +
            $LEFT_OUTER_JOIN + qJT_SkKihon.JT_TtdkRireki() +
            $AS + qJT_TtdkRireki +
            $WHERE + qJT_SkKihon.skno.eq(pSkno) +
            $AND + qJT_SkKihon.syono.ne(pSyono) +
            $GROUP_BY + qJT_SkKihon.syono + "," +
            qJT_SkKihon.skno + "," +
            qJT_SkKihon.seikyuusyubetu + "," +
            qJT_SkKihon.syorijyoutaikbn + "," +
            qJT_SkKihon.hubijyoukyoukbn + "," +
            qJT_SkKihon.tyousajyoukyoukbn +
            $ORDER_BY (qJT_SkKihon.syono.asc());

        return em.createJPQL(queryStr).bind(qJT_SkKihon, qJT_TtdkRireki).getResultList();
    }

    public List<Object[]> getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
        String pSyono, String pHhknnmkn, C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSyoruiukeymdFrom,
        BizDate pSyoruiukeymdTo) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon("qJT_SkKihon");

        QJT_SkKihon qJT_SkKihon1 = new QJT_SkKihon("qJT_SkKihon1");

        QJT_Sk qJT_Sk = new QJT_Sk("qJT_Sk");

        QJT_Sk qJT_Sk1 = new QJT_Sk("qJT_Sk1");


        String subquery1 = "";


        if (!StringUtil.isNullOrBlank(pSyono)) {

            subquery1 = subquery1 + $AND + qJT_SkKihon.syono.eq(pSyono);
        }


        if (!StringUtil.isNullOrBlank(pHhknnmkn)) {

            subquery1 = subquery1 + $AND + qJT_SkKihon.hhknnmkn.like("%" + pHhknnmkn + "%");
        }


        if (pSeikyuusyubetu != null && !C_SeikyuuSyubetu.BLNK.eq(pSeikyuusyubetu)) {

            subquery1 = subquery1 + $AND + qJT_SkKihon.seikyuusyubetu.eq(pSeikyuusyubetu);
        }


        if ((pSyoruiukeymdFrom != null)) {

            subquery1 = subquery1 + $AND + qJT_Sk.syoruiukeymd.ge(pSyoruiukeymdFrom);
        }


        if ((pSyoruiukeymdTo != null)) {

            subquery1 = subquery1 + $AND + qJT_Sk.syoruiukeymd.le(pSyoruiukeymdTo);
        }


        String subQuery = $SELECT + qJT_Sk1.syono +  "," +
            qJT_Sk1.skno + "," +
            $MAX(qJT_Sk1.seikyuurirekino) +
            $FROM + qJT_SkKihon1.JT_SkKihon() +
            $LEFT_OUTER_JOIN + qJT_SkKihon1.JT_Sk() +
            $AS + qJT_Sk1 +
            $GROUP_BY + qJT_Sk1.syono + "," +
            qJT_Sk1.skno +
            $HAVING + $MAX(qJT_Sk1.seikyuurirekino) + $EQ + qJT_Sk.seikyuurirekino +
            $AND  + qJT_Sk1.syono.eq(qJT_Sk.syono)+
            $AND  + qJT_Sk1.skno.eq(qJT_Sk.skno);


        String mainQuery = $SELECT +
            qJT_SkKihon + "," +
            qJT_Sk +
            $FROM + qJT_SkKihon.JT_SkKihon() +
            $LEFT_OUTER_JOIN + qJT_SkKihon.JT_Sk() +
            $AS + qJT_Sk +
            $WHERE + $($EXISTS(subQuery)  +
                $OR + qJT_Sk.skno.isNull()) +
                subquery1 +
                $ORDER_BY(qJT_SkKihon.syono.asc()+
                    ","+qJT_SkKihon.skno.asc());

        return em.createJPQL(mainQuery).bind(qJT_SkKihon,qJT_Sk).getResultList();
    }

    public List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetu(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon("qJT_SkKihon");
        String jpql = $SELECT + qJT_SkKihon + $FROM(qJT_SkKihon) +
            $WHERE + qJT_SkKihon.syono.eq(pSyono) +
            $AND + qJT_SkKihon.seikyuusyubetu.eq(pSeikyuusyubetu) +
            $ORDER_BY(qJT_SkKihon.skno.desc()) ;


        return em.createJPQL(jpql).bind(qJT_SkKihon).getResultList();
    }

    public List<JT_SkKihon> getSkKihonsBySyono(String pSyono) {


        JT_SkKihon jt_SkKihon = new JT_SkKihon();
        jt_SkKihon.setSyono(pSyono);


        return select(jt_SkKihon);

    }

    public List<JT_SkKihon> getSkKihonsBySyorijyoutaikbnLikeHhknnmkn(C_SyoriJyoutaiKbn pSyorijyoutaikbn, String pHhknnmkn) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();

        String queryStr = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() +
            $WHERE + qJT_SkKihon.syorijyoutaikbn.eq(pSyorijyoutaikbn) +
            $AND + qJT_SkKihon.hhknnmkn.like("%" + pHhknnmkn + "%") +
            $ORDER_BY(qJT_SkKihon.hhknnmkn.asc());

        return em.createJPQL(queryStr).bind(qJT_SkKihon).getResultList();
    }

    public ExDBResults<SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean> getSibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflg(
        BizDate pTaisyoukknfrom, BizDate pTaisyoukknto) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon("qJT_SkKihon");
        QJT_SibouKariuketsuke qJT_SibouKariuketsuke = new QJT_SibouKariuketsuke("qJT_SibouKariuketsuke");


        String strSql = $SELECT + qJT_SkKihon + "," + qJT_SibouKariuketsuke +
            $FROM(qJT_SkKihon, qJT_SibouKariuketsuke) +
            $WHERE + qJT_SkKihon.seikyuusyubetu.eq(C_SeikyuuSyubetu.SBKRUKTK) +
            $AND + qJT_SkKihon.skno.eq(qJT_SibouKariuketsuke.skno) +
            $AND + qJT_SkKihon.syono.eq(qJT_SibouKariuketsuke.syono) +
            $AND + qJT_SkKihon.siboukaritrkymd.ge(pTaisyoukknfrom) +
            $AND + qJT_SkKihon.siboukaritrkymd.le(pTaisyoukknto) +
            $AND + qJT_SibouKariuketsuke.torikesiflg.eq(C_UmuKbn.NONE) +
            $ORDER_BY(qJT_SkKihon.syono.asc());


        return em.createJPQL(strSql).bind(qJT_SkKihon, qJT_SibouKariuketsuke)
            .getResults(SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean.class);
    }

    public ExDBUpdatableResults<JT_SkKihon> getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe (
        C_SyoriJyoutaiKbn pSyorijyoutaikbn, C_ShrKekkaKbn pShrkekkakbn) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();


        String strSqlWhere = "";

        if (C_SyoriJyoutaiKbn.SYORITYUU.eq(pSyorijyoutaikbn)) {

            strSqlWhere += $WHERE;
            strSqlWhere += qJT_SkKihon.syorijyoutaikbn.eq(pSyorijyoutaikbn);
        }

        if (C_ShrKekkaKbn.BLNK.eq(pShrkekkakbn)) {

            if (C_SyoriJyoutaiKbn.SYORITYUU.eq(pSyorijyoutaikbn)) {

                strSqlWhere += $AND;
            } else {

                strSqlWhere += $WHERE;
            }

            strSqlWhere += qJT_SkKihon.shrkekkakbn.ne(pShrkekkakbn);
        }


        String strSql = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() +
            strSqlWhere +
            $ORDER_BY(qJT_SkKihon.syono.asc(),
                qJT_SkKihon.skno.asc());


        return em.createJPQL(strSql).bind(qJT_SkKihon).getUpdatableResults();
    }

    public ExDBResults<JT_SkKihon>  getSkKihonsBySeikyuusyubetuSiboukaritrkymdShrkekkakbns(C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSiboukaritrkymd, C_ShrKekkaKbn... pShrkekkakbn) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();


        String strSql = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() +
            $WHERE + qJT_SkKihon.seikyuusyubetu.eq(pSeikyuusyubetu) +
            $AND + qJT_SkKihon.siboukaritrkymd.ge(pSiboukaritrkymd) +
            $AND + qJT_SkKihon.shrkekkakbn.in(pShrkekkakbn);


        return em.createJPQL(strSql).bind(qJT_SkKihon).getResults();
    }


    public ExDBResults<JT_SkKihon> getSkKihonsBySeikyuusyubetuNeShrsyoriymdShrkekkakbn(BizDate pShrsyoriymdFrom,
        BizDate pShrsyoriymdTo) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();
        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki();


        String strSql = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() + "," +
            qJT_SiRireki.JT_SiRireki() +
            $WHERE + qJT_SkKihon.skno.eq(qJT_SiRireki.skno) +
            $AND + qJT_SkKihon.syono.eq(qJT_SiRireki.syono) +
            $AND + qJT_SkKihon.seikyuusyubetu.ne(C_SeikyuuSyubetu.SDSSHR) +
            $AND + qJT_SiRireki.shrsyoriymd.ge(pShrsyoriymdFrom) +
            $AND + qJT_SiRireki.shrsyoriymd.le(pShrsyoriymdTo) +
            $AND + "(" + qJT_SiRireki.shrkekkakbn.eq(C_ShrKekkaKbn.SHR) +
            $OR + qJT_SiRireki.shrkekkakbn.eq(C_ShrKekkaKbn.ITIBU_SHR) + ")" +
            $ORDER_BY(qJT_SkKihon.syono.asc(),
                qJT_SkKihon.skno.asc());


        return em.createJPQL(strSql).bind(qJT_SkKihon,qJT_SiRireki).getResults();
    }

    public ExDBResults<JT_SkKihon> getSkKihonsByKakutyoujobcdSeikyuusyubetuItems(C_SeikyuuSyubetu pSeikyuusyubetu,
        BizDate pSiboukaritrkymd, BizDate pTyakkinymd, BizDate pShrsyoriymd) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();
        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki();


        String strSubSql = $SELECT + qJT_SiRireki.skno +
            $FROM + qJT_SiRireki.JT_SiRireki() +
            $WHERE + qJT_SkKihon.skno.eq(qJT_SiRireki.skno) +
            $AND + qJT_SkKihon.syono.eq(qJT_SiRireki.syono) +
            $AND + "((" + qJT_SiRireki.shrkekkakbn.eq(C_ShrKekkaKbn.SHR) +
            $AND + qJT_SiRireki.tyakkinymd.le(pTyakkinymd) +
            ")" +$OR + "(" +
            qJT_SiRireki.shrkekkakbn.eq(C_ShrKekkaKbn.HSHR) +
            $AND + qJT_SiRireki.shrsyoriymd.le(pShrsyoriymd) + "))";


        String mainSql = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() +
            $WHERE + qJT_SkKihon.seikyuusyubetu.eq(pSeikyuusyubetu) +
            $AND + qJT_SkKihon.siboukaritrkymd.le(pSiboukaritrkymd) +
            $AND + $NOT_EXISTS(strSubSql);


        return em.createJPQL(mainSql).bind(qJT_SkKihon, qJT_SiRireki).getResults();
    }

    public ExDBResults<JT_SkKihon> getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(C_SeikyuuSyubetu pSeikyuusyubetu1,
        C_SeikyuuSyubetu pSeikyuusyubetu2, BizDate pSiboukaritrkymd) {


        QJT_SkKihon qJT_SkKihon1 = new QJT_SkKihon("qJT_SkKihon1");
        QJT_SkKihon qJT_SkKihon2 = new QJT_SkKihon("qJT_SkKihon2");


        String strSubSql = $SELECT + qJT_SkKihon2.syono +
            $FROM + qJT_SkKihon2.JT_SkKihon() +
            $WHERE + qJT_SkKihon2.seikyuusyubetu.eq(pSeikyuusyubetu2) +
            $AND + qJT_SkKihon2.syono.eq(qJT_SkKihon1.syono);


        String strMainSql = $SELECT + qJT_SkKihon1 +
            $FROM + qJT_SkKihon1.JT_SkKihon() +
            $WHERE + qJT_SkKihon1.seikyuusyubetu.eq(pSeikyuusyubetu1) +
            $AND + qJT_SkKihon1.siboukaritrkymd.le(pSiboukaritrkymd) +
            $AND + $NOT_EXISTS(strSubSql);


        return em.createJPQL(strMainSql).bind(qJT_SkKihon1, qJT_SkKihon2).getResults();
    }

    public List<JT_SkKihon> getSkKihonsBySyonoTorikesiflg(String pSyono, C_UmuKbn pTorikesiflg) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();
        QJT_SibouKariuketsuke qJT_SibouKariuketsuke = new QJT_SibouKariuketsuke();


        String strSubSql = $SELECT + qJT_SibouKariuketsuke.syono +
            $FROM + qJT_SibouKariuketsuke.JT_SibouKariuketsuke() +
            $WHERE + qJT_SibouKariuketsuke.syono.eq(qJT_SkKihon.syono) +
            $AND + qJT_SibouKariuketsuke.torikesiflg.eq(pTorikesiflg);


        String strMainSql = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() +
            $WHERE + qJT_SkKihon.syono.eq(pSyono) +
            $AND + $EXISTS(strSubSql);


        return em.createJPQL(strMainSql).bind(qJT_SkKihon, qJT_SibouKariuketsuke).getResultList();
    }

    public ExDBResults<JT_SkKihon> getSkKihonsByKakutyoujobcdGaibuinsatuoutymd(BizDate pGaibuinsatuoutymd) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();


        String strSql = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() +
            $WHERE + qJT_SkKihon.gaibuinsatuoutymd.eq(pGaibuinsatuoutymd) +
            $ORDER_BY(qJT_SkKihon.syono.asc(),
                qJT_SkKihon.skno.asc());


        return em.createJPQL(strSql).bind(qJT_SkKihon).getResults();
    }

    public ExDBResults<JT_SkKihon> getSkKihonsByShrsyoriymdShrkekkakbnSeikyuusyubetu(BizDate pShrsyoriymd,
        C_ShrKekkaKbn pShrkekkakbn, C_SeikyuuSyubetu pSeikyuusyubetu) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();
        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki();


        String strSql = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() + "," +
            qJT_SiRireki.JT_SiRireki() +
            $WHERE + qJT_SiRireki.shrsyoriymd.eq(pShrsyoriymd) +
            $AND + qJT_SiRireki.shrkekkakbn.eq(pShrkekkakbn) +
            $AND + "(" + qJT_SkKihon.skno.eq(qJT_SiRireki.skno) +
            $AND + qJT_SkKihon.syono.eq(qJT_SiRireki.syono)  +
            $AND + qJT_SkKihon.seikyuusyubetu.ne(pSeikyuusyubetu) + ")" +
            $ORDER_BY(qJT_SkKihon.syono.asc(),
                qJT_SkKihon.skno.asc());


        return em.createJPQL(strSql).bind(qJT_SkKihon, qJT_SiRireki).getResults();
    }

    public ExDBResults<JT_SkKihon> getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(BizDate pShrsyoriymd,
        C_ShrKekkaKbn pShrkekkakbn, C_SeikyuuSyubetu pSeikyuusyubetu) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();
        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki();


        String strSql = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() + "," +
            qJT_SiRireki.JT_SiRireki() +
            $WHERE + qJT_SiRireki.shrsyoriymd.eq(pShrsyoriymd) +
            $AND + qJT_SiRireki.shrkekkakbn.eq(pShrkekkakbn) +
            $AND + "(" + qJT_SkKihon.skno.eq(qJT_SiRireki.skno) +
            $AND + qJT_SkKihon.syono.eq(qJT_SiRireki.syono)  +
            $AND + qJT_SkKihon.seikyuusyubetu.ne(pSeikyuusyubetu) + ")" +
            $ORDER_BY(qJT_SkKihon.syono.asc(),
                qJT_SkKihon.skno.asc());


        return em.createJPQL(strSql).bind(qJT_SkKihon, qJT_SiRireki).getResults();
    }

    public ExDBResults<JT_SkKihon> getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(
        C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSiboukaritrkymd, C_SaisateiKbn pSaisateikbn,
        BizDate pTyakkinymd, BizDate pShrsyoriymd) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();
        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki();


        String strSubSql = $SELECT + qJT_SiRireki.skno +
            $FROM + qJT_SiRireki.JT_SiRireki() +
            $WHERE + qJT_SkKihon.skno.eq(qJT_SiRireki.skno) +
            $AND + qJT_SkKihon.syono.eq(qJT_SiRireki.syono) +
            $AND + "((" + qJT_SiRireki.shrkekkakbn.eq(C_ShrKekkaKbn.SHR) +
            $AND + qJT_SiRireki.tyakkinymd.le(pTyakkinymd) +
            ")" +$OR + "(" +
            qJT_SiRireki.shrkekkakbn.eq(C_ShrKekkaKbn.HSHR) +
            $AND + qJT_SiRireki.shrsyoriymd.le(pShrsyoriymd) + "))";


        String mainSql = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() +
            $WHERE + qJT_SkKihon.seikyuusyubetu.eq(pSeikyuusyubetu) +
            $AND + qJT_SkKihon.siboukaritrkymd.le(pSiboukaritrkymd) +
            $AND + qJT_SkKihon.saisateikbn.eq(pSaisateikbn) +
            $AND + $NOT_EXISTS(strSubSql);


        return em.createJPQL(mainSql).bind(qJT_SkKihon, qJT_SiRireki).getResults();
    }

    public List<JT_SkKihon> getSkKihonsByHhknnmknTorikesiflg(String pHhknnmkn) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();


        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki();


        QJT_Sk qJT_Sk = new QJT_Sk();


        String subquery1 = "";


        if (!StringUtil.isNullOrBlank(pHhknnmkn)) {


            subquery1 = subquery1 + $AND + qJT_SkKihon.hhknnmkn.like("%" + pHhknnmkn + "%");
        }


        String mainSql = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() + "," +
            qJT_SiRireki.JT_SiRireki() + "," +
            qJT_Sk.JT_Sk() +
            $WHERE + qJT_SiRireki.torikesiflg.eq(C_UmuKbn.NONE) +
            $AND + qJT_SiRireki.syono.eq(qJT_SkKihon.syono) +
            $AND + qJT_SiRireki.skno.eq(qJT_SkKihon.skno) +
            $AND + qJT_SiRireki.skno.eq(qJT_Sk.skno) +
            $AND + qJT_SiRireki.syono.eq(qJT_Sk.syono) +
            $AND + qJT_SiRireki.seikyuurirekino.eq(qJT_Sk.seikyuurirekino) +
            subquery1 +
            $ORDER_BY(qJT_SkKihon.hhknnmkn.asc());

        return em.createJPQL(mainSql).bind(qJT_SkKihon, qJT_SiRireki, qJT_Sk).getResultList();
    }

    public ExDBResults<JT_SkKihon> getSkKihonsBySeikyuusyubetuSaisateikbnSiboukaritrkymdShrkekkakbns(
        C_SeikyuuSyubetu pSeikyuusyubetu, C_SaisateiKbn pSaisateikbn, BizDate pSiboukaritrkymd, BizDate pZennendoKsnbiymd,
        C_ShrKekkaKbn... pShrkekkakbn) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();


        String strSql = $SELECT + qJT_SkKihon +
            $FROM + qJT_SkKihon.JT_SkKihon() +
            $WHERE + qJT_SkKihon.seikyuusyubetu.eq(pSeikyuusyubetu) +
            $AND + qJT_SkKihon.saisateikbn.eq(pSaisateikbn) +
            $AND + qJT_SkKihon.siboukaritrkymd.ge(pSiboukaritrkymd) +
            $AND + qJT_SkKihon.siboukaritrkymd.le(pZennendoKsnbiymd) +
            $AND + qJT_SkKihon.shrkekkakbn.in(pShrkekkakbn);


        return em.createJPQL(strSql).bind(qJT_SkKihon).getResults();
    }

    public List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetuSaisateikbn(String pSyono,
        C_SeikyuuSyubetu pSeikyuusyubetu, C_SaisateiKbn pSaisateikbn) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon();


        String strSql = $SELECT + qJT_SkKihon +
            $FROM (qJT_SkKihon) +
            $WHERE + qJT_SkKihon.syono.eq(pSyono) +
            $AND + qJT_SkKihon.seikyuusyubetu.eq(pSeikyuusyubetu) +
            $AND + qJT_SkKihon.saisateikbn.eq(pSaisateikbn);


        return em.createJPQL(strSql).bind(qJT_SkKihon).getResultList();
    }
}
