package yuyu.def.db.dao;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.meta.QJT_SiBikinkanri;
import yuyu.def.siharai.result.bean.SiBikinkanriItemsBySyonoBean;

/**
 * 保険金給付金備金管理テーブル(JT_SiBikinkanriDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiBikinkanriDao extends AbstractDao<JT_SiBikinkanri> {

    public JT_SiBikinkanriDao() {
        super(JT_SiBikinkanri.class);
    }

    public JT_SiBikinkanri getSiBikinkanri(String pSkno, String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd, String pKyuuhucd) {
        JT_SiBikinkanri jT_SiBikinkanri =  new JT_SiBikinkanri();
        jT_SiBikinkanri.setSkno(pSkno);
        jT_SiBikinkanri.setSyono(pSyono);
        jT_SiBikinkanri.setKessankijyunymd(pKessankijyunymd);
        jT_SiBikinkanri.setBkncdkbn(pBkncdkbn);
        jT_SiBikinkanri.setBknkktymd(pBknkktymd);
        jT_SiBikinkanri.setKyuuhucd(pKyuuhucd);
        return this.selectOne(jT_SiBikinkanri);
    }

    public List<JT_SiBikinkanri> getSiBikinkanrisBySyono(String pSyono) {


        JT_SiBikinkanri jT_SiBikinkanri = new JT_SiBikinkanri();


        jT_SiBikinkanri.setSyono(pSyono);


        return select(jT_SiBikinkanri);
    }


    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByBknkktymdCalckijyunymdKessankijyunymd(BizDate pBknkktymd, BizDate pCalckijyunymd, BizDate pKessankijyunymd) {


        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri();


        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM + qJT_SiBikinkanri.JT_SiBikinkanri() +
            $WHERE + qJT_SiBikinkanri.bknkktymd.ge(pBknkktymd) +
            $AND + qJT_SiBikinkanri.calckijyunymd.ge(pCalckijyunymd) +
            $AND + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunymd);


        return em.createJPQL(strSql).bind(qJT_SiBikinkanri).getResults();
    }

    public List<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbn(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {


        JT_SiBikinkanri jT_SiBikinkanri = new JT_SiBikinkanri();


        jT_SiBikinkanri.setKessankijyunymd(pKessankijyunymd);
        jT_SiBikinkanri.setBknrigikbn(pBknrigikbn);


        return select(jT_SiBikinkanri);
    }

    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {


        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri();


        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM + qJT_SiBikinkanri.JT_SiBikinkanri() +
            $WHERE + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qJT_SiBikinkanri.bknrigikbn.eq(pBknrigikbn) +
            $ORDER_BY(qJT_SiBikinkanri.hokenkinsyuruikbn.asc(),
                qJT_SiBikinkanri.syuukeiyoubkncdkbn.asc(),
                qJT_SiBikinkanri.syouhnsyuruikbn.asc(),
                qJT_SiBikinkanri.kbnkeirisegcd.asc());


        return em.createJPQL(strSql).bind(qJT_SiBikinkanri).getResults();
    }

    public List<JT_SiBikinkanri> getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn(
        String pSkno, String pSyono, BizDate pKessankijyunymd,
        C_BkncdKbn pBkncdkbn) {


        JT_SiBikinkanri jT_SiBikinkanri = new JT_SiBikinkanri();


        jT_SiBikinkanri.setSkno(pSkno);
        jT_SiBikinkanri.setSyono(pSyono);
        jT_SiBikinkanri.setKessankijyunymd(pKessankijyunymd);
        jT_SiBikinkanri.setBkncdkbn(pBkncdkbn);

        return select(jT_SiBikinkanri);
    }

    public List<JT_SiBikinkanri> getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns(String pSyono,
        BizDate pKessankijyunymd, C_BkncdKbn... pBkncdkbn) {


        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri();


        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM + qJT_SiBikinkanri.JT_SiBikinkanri() +
            $WHERE + qJT_SiBikinkanri.syono.eq(pSyono) +
            $AND + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qJT_SiBikinkanri.bkncdkbn.in(pBkncdkbn);


        return em.createJPQL(strSql).bind(qJT_SiBikinkanri).getResultList();
    }

    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbnEx(
        BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {

        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri();


        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM + qJT_SiBikinkanri.JT_SiBikinkanri() +
            $WHERE + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qJT_SiBikinkanri.bknrigikbn.eq(pBknrigikbn) +
            $ORDER_BY(qJT_SiBikinkanri.syono.asc(),
                qJT_SiBikinkanri.skno.asc(),
                qJT_SiBikinkanri.bkncdkbn.asc(),
                qJT_SiBikinkanri.bknkktymd.asc(),
                qJT_SiBikinkanri.kyuuhucd.asc());

        return em.createJPQL(strSql).bind(qJT_SiBikinkanri).getResults();
    }

    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByBknkktymdItems(BizDate pBknkktymd, BizDate pCalckijyunymd,
        BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {

        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri();


        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM + qJT_SiBikinkanri.JT_SiBikinkanri() +
            $WHERE + qJT_SiBikinkanri.bknkktymd.ge(pBknkktymd) +
            $AND + qJT_SiBikinkanri.calckijyunymd.ge(pCalckijyunymd) +
            $AND + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qJT_SiBikinkanri.bknrigikbn.eq(pBknrigikbn);


        return em.createJPQL(strSql).bind(qJT_SiBikinkanri).getResults();
    }

    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKakutyoujobcdItems(BizDate pKessankijyunymd,
        C_BknrigiKbn pBknrigikbn) {


        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri();


        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM + qJT_SiBikinkanri.JT_SiBikinkanri() +
            $WHERE + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qJT_SiBikinkanri.bknrigikbn.ne(pBknrigikbn) +
            $ORDER_BY(qJT_SiBikinkanri.syuukeiyoubkncdkbn.asc(),
                qJT_SiBikinkanri.hokenkinsyuruikbn.asc(),
                qJT_SiBikinkanri.kbnkeirisegcd.asc(),
                qJT_SiBikinkanri.bknkktinnd.asc(),
                qJT_SiBikinkanri.bknkktiym.asc(),
                qJT_SiBikinkanri.syono.asc(),
                qJT_SiBikinkanri.syutkkbn.asc());

        return em.createJPQL(strSql).bind(qJT_SiBikinkanri).getResults();
    }

    public List<SiBikinkanriItemsBySyonoBean> getSiBikinkanriItemsBySyono(String pSyono) {


        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri();


        String strSql = $SELECT + $NEW(SiBikinkanriItemsBySyonoBean.class,
            qJT_SiBikinkanri.kessankijyunymd,
            qJT_SiBikinkanri.bknrigikbn,
            qJT_SiBikinkanri.bkncdkbn) +
            $FROM (qJT_SiBikinkanri) +
            $WHERE + qJT_SiBikinkanri.syono.eq(pSyono);


        return em.createJPQL(strSql, SiBikinkanriItemsBySyonoBean.class).bind(qJT_SiBikinkanri).getResultList();
    }

    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbnOrderByBkntyousafsyorikbnSyono(
        BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {

        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri();


        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM + qJT_SiBikinkanri.JT_SiBikinkanri() +
            $WHERE + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qJT_SiBikinkanri.bknrigikbn.eq(pBknrigikbn) +
            $ORDER_BY(qJT_SiBikinkanri.bkntyousafsyorikbn.asc(),
                qJT_SiBikinkanri.syono.asc());


        return em.createJPQL(strSql).bind(qJT_SiBikinkanri).getResults();
    }

    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByZennouseisankin(BizDate pKessankijyunymd,
        C_UmuKbn pZennouseisankinumukbn, C_ShrKekkaKbn pShrkekkakbn, C_BknrigiKbn pBknrigikbn) {



        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri("qJT_SiBikinkanri");


        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM(qJT_SiBikinkanri) +
            $WHERE + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qJT_SiBikinkanri.zennouseisankinumukbn.eq(pZennouseisankinumukbn) +
            $AND + qJT_SiBikinkanri.shrkekkakbn.ne(pShrkekkakbn) +
            $AND + qJT_SiBikinkanri.bknrigikbn.ne(pBknrigikbn) +
            $ORDER_BY(qJT_SiBikinkanri.syuukeiyoubkncdkbn.asc(),
                qJT_SiBikinkanri.kbnkeirisegcd.asc(),
                qJT_SiBikinkanri.bknkktymd.asc(),
                qJT_SiBikinkanri.syono.asc());


        return em.createJPQL(strSql).bind(qJT_SiBikinkanri).getResults();
    }

    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByMikeikap(BizDate pKessankijyunymd, C_UmuKbn pMikeikapumukbn,
        C_ShrKekkaKbn pShrkekkakbn, C_BknrigiKbn pBknrigikbn) {



        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri("qJT_SiBikinkanri");


        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM(qJT_SiBikinkanri) +
            $WHERE + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qJT_SiBikinkanri.mikeikapumukbn.eq(pMikeikapumukbn) +
            $AND + qJT_SiBikinkanri.shrkekkakbn.ne(pShrkekkakbn) +
            $AND + qJT_SiBikinkanri.bknrigikbn.ne(pBknrigikbn) +
            $ORDER_BY(qJT_SiBikinkanri.syuukeiyoubkncdkbn.asc(),
                qJT_SiBikinkanri.kbnkeirisegcd.asc(),
                qJT_SiBikinkanri.bknkktymd.asc(),
                qJT_SiBikinkanri.syono.asc());


        return em.createJPQL(strSql).bind(qJT_SiBikinkanri).getResults();
    }

    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByMisyup(BizDate pKessankijyunymd, C_UmuKbn pMisyuupumukbn,
        C_ShrKekkaKbn pShrkekkakbn, C_BknrigiKbn pBknrigikbn) {



        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri("qJT_SiBikinkanri");


        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM(qJT_SiBikinkanri) +
            $WHERE + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qJT_SiBikinkanri.misyuupumukbn.eq(pMisyuupumukbn) +
            $AND + qJT_SiBikinkanri.shrkekkakbn.ne(pShrkekkakbn) +
            $AND + qJT_SiBikinkanri.bknrigikbn.ne(pBknrigikbn) +
            $ORDER_BY(qJT_SiBikinkanri.syuukeiyoubkncdkbn.asc(),
                qJT_SiBikinkanri.syono.asc());


        return em.createJPQL(strSql).bind(qJT_SiBikinkanri).getResults();
    }

    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(BizDate pKessankijyunymd,
        C_BknJkuKbn pBknJkuKbn,C_BknrigiKbn pBknrigiKbn) {



        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri("qJT_SiBikinkanri");


        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM(qJT_SiBikinkanri) +
            $WHERE + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qJT_SiBikinkanri.bknjkukbn.eq(pBknJkuKbn) +
            $AND + qJT_SiBikinkanri.bknrigikbn.ne(pBknrigiKbn) +
            $ORDER_BY(qJT_SiBikinkanri.kbnkeirisegcd.asc(),
                qJT_SiBikinkanri.syuukeiyoubkncdkbn.asc(),
                qJT_SiBikinkanri.bkncdkbn.asc(),
                qJT_SiBikinkanri.syono.asc());


        return em.createJPQL(strSql).bind(qJT_SiBikinkanri).getResults();
    }


    public List<JT_SiBikinkanri> getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe(String pSyono, BizDate pKessankijyunymd,
        C_BknJkuKbn pBknJkuKbn,C_BknrigiKbn pBknrigiKbn) {



        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri("qJT_SiBikinkanri");


        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM(qJT_SiBikinkanri) +
            $WHERE + qJT_SiBikinkanri.syono.eq(pSyono) +
            $AND + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qJT_SiBikinkanri.bknjkukbn.eq(pBknJkuKbn) +
            $AND + qJT_SiBikinkanri.bknrigikbn.ne(pBknrigiKbn);


        return em.createJPQL(strSql).bind(qJT_SiBikinkanri).getResultList();

    }
}
