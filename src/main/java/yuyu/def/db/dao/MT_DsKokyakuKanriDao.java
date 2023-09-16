package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.classification.C_DsKanyuuKeiroKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SeisaHuyouHyj;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QMT_DsHonninKakuninCd;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsLoginKanri;
import yuyu.def.direct.result.bean.DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean;

/**
 * ＤＳ顧客管理テーブル(MT_DsKokyakuKanriDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsKokyakuKanriDao extends AbstractDao<MT_DsKokyakuKanri> {

    public MT_DsKokyakuKanriDao() {
        super(MT_DsKokyakuKanri.class);
    }

    public MT_DsKokyakuKanri getDsKokyakuKanri(String pDskokno) {
        MT_DsKokyakuKanri mT_DsKokyakuKanri =  new MT_DsKokyakuKanri();
        mT_DsKokyakuKanri.setDskokno(pDskokno);
        return this.selectOne(mT_DsKokyakuKanri);
    }

    public ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj() {

        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri();
        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku();


        String strSubSql = $SELECT + qMT_DsKokyakuKeiyaku.dskokno +
            $FROM + qMT_DsKokyakuKeiyaku.MT_DsKokyakuKeiyaku() +
            $WHERE + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq( C_MukouHyj.BLANK) +
            $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsKokyakuKanri.dskokno);


        String strSql = $SELECT + qMT_DsKokyakuKanri +
            $FROM + qMT_DsKokyakuKanri.MT_DsKokyakuKanri() +
            $WHERE + qMT_DsKokyakuKanri.dskokyakujtkbn.ne(C_DsKokyakuJtKbn.KAIYAKU) +
            $AND + qMT_DsKokyakuKanri.dskokyakujtkbn.ne(C_DsKokyakuJtKbn.SEISA_SYOUMETU) +
            $AND + qMT_DsKokyakuKanri.seisahuyouhyj.eq(C_SeisaHuyouHyj.BLANK) +
            $AND + $NOT_EXISTS(strSubSql);


        return em.createJPQL(strSql).bind(qMT_DsKokyakuKanri, qMT_DsKokyakuKeiyaku).getUpdatableResults();
    }

    public ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByKakutyoujobcd() {

        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri();

        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku();

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn();


        String  strSubSq2 = $SELECT + qIT_KykSyouhn.syono +
            $FROM + qIT_KykSyouhn.IT_KykSyouhn() +
            $WHERE + qIT_KykSyouhn.syono.eq(qMT_DsKokyakuKeiyaku.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.SYOUMETU);


        String strSubSq1 = $SELECT + qMT_DsKokyakuKeiyaku.dskokno +
            $FROM + qMT_DsKokyakuKeiyaku.MT_DsKokyakuKeiyaku() +
            $WHERE + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsKokyakuKanri.dskokno) +
            $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK) +
            $AND + $EXISTS(strSubSq2);


        String strSql = $SELECT + qMT_DsKokyakuKanri +
            $FROM + qMT_DsKokyakuKanri.MT_DsKokyakuKanri() +
            $WHERE + $EXISTS(strSubSq1) +
            $ORDER_BY(qMT_DsKokyakuKanri.dskokno.asc());

        return em.createJPQL(strSql).bind(qIT_KykSyouhn, qMT_DsKokyakuKeiyaku, qMT_DsKokyakuKanri).getUpdatableResults();
    }

    public List<MT_DsKokyakuKanri> getDsKokyakuKanrisBySyonoDskykmukouhyj(String pSyono) {


        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri();


        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku();

        String strSql = $SELECT + qMT_DsKokyakuKanri +
            $FROM + qMT_DsKokyakuKanri.MT_DsKokyakuKanri() + "," +
            qMT_DsKokyakuKeiyaku.MT_DsKokyakuKeiyaku() +
            $WHERE + qMT_DsKokyakuKeiyaku.syono.eq(pSyono) +
            $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK) +
            $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsKokyakuKanri.dskokno) +
            $ORDER_BY (qMT_DsKokyakuKeiyaku.dskokno.asc(),
                qMT_DsKokyakuKeiyaku.syono.asc());

        return em.createJPQL(strSql).bind(qMT_DsKokyakuKanri, qMT_DsKokyakuKeiyaku).getResultList();
    }

    public List<MT_DsKokyakuKanri> getDsKokyakuKanrisBySyono(String pSyono) {


        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri();


        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku();

        String strSql = $SELECT + qMT_DsKokyakuKanri +
            $FROM + qMT_DsKokyakuKanri.MT_DsKokyakuKanri() + "," +
            qMT_DsKokyakuKeiyaku.MT_DsKokyakuKeiyaku() +
            $WHERE + qMT_DsKokyakuKeiyaku.syono.eq(pSyono) +
            $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsKokyakuKanri.dskokno);

        return em.createJPQL(strSql).bind(qMT_DsKokyakuKanri, qMT_DsKokyakuKeiyaku).getResultList();
    }

    public DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM(String pSyono) {


        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri();


        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku();


        String queryStr = $SELECT + $NEW(DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean.class,
            qMT_DsKokyakuKanri.dskokno,
            qMT_DsKokyakuKanri.dskokyakunmkn,
            qMT_DsKokyakuKanri.dskokyakunmkj,
            qMT_DsKokyakuKanri.dskokyakuseiymd,
            qMT_DsKokyakuKanri.dskokyakuyno,
            qMT_DsKokyakuKanri.dskokyakujtkbn,
            qMT_DsKokyakuKanri.dsteisiriyuukbn) +
            $FROM + qMT_DsKokyakuKanri.MT_DsKokyakuKanri() + ","  +
            qMT_DsKokyakuKeiyaku.MT_DsKokyakuKeiyaku() +
            $WHERE + qMT_DsKokyakuKeiyaku.syono.eq(pSyono)  +
            $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK) +
            $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsKokyakuKanri.dskokno) +
            $ORDER_BY (qMT_DsKokyakuKanri.dskokno.desc());

        return em.createJPQL(queryStr, DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean.class).setFirstResult(0).setMaxResults(1).bind(qMT_DsKokyakuKanri, qMT_DsKokyakuKeiyaku).getSingleResult();
    }

    public List<Object[]> getDsKokyakuKanrisByItems(String pDskokyakunmkn, String pDskokyakunmkj,
        BizDate pDskokyakuseiymd, String pDskokyakuyno) {


        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri("qMT_DsKokyakuKanri");


        QMT_DsHonninKakuninCd qMT_DsHonninKakuninCd = new QMT_DsHonninKakuninCd("qMT_DsHonninKakuninCd");


        QMT_DsLoginKanri qMT_DsLoginKanri = new QMT_DsLoginKanri("qMT_DsLoginKanri");


        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");


        String subQuerStr = "";

        if (!StringUtil.isNullOrBlank(pDskokyakunmkn)) {

            subQuerStr = $AND + qMT_DsKokyakuKanri.dskokyakunmkn.like("%" + pDskokyakunmkn + "%");
        }

        if (!StringUtil.isNullOrBlank(pDskokyakunmkj)) {

            subQuerStr = subQuerStr + $AND +  qMT_DsKokyakuKanri.dskokyakunmkj.like("%" + pDskokyakunmkj + "%");
        }

        if (pDskokyakuseiymd != null) {

            subQuerStr = subQuerStr + $AND + qMT_DsKokyakuKanri.dskokyakuseiymd.eq(pDskokyakuseiymd);
        }

        if (!StringUtil.isNullOrBlank(pDskokyakuyno)) {

            subQuerStr = subQuerStr + $AND + qMT_DsKokyakuKanri.dskokyakuyno.eq(pDskokyakuyno);
        }

        String sql = $SELECT +
            qMT_DsKokyakuKanri + "," +
            qMT_DsHonninKakuninCd + "," +
            qMT_DsLoginKanri + "," +
            qMT_DsKokyakuKeiyaku +
            $FROM (qMT_DsKokyakuKanri,
                qMT_DsHonninKakuninCd,
                qMT_DsLoginKanri,
                qMT_DsKokyakuKeiyaku) +
                $WHERE + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsHonninKakuninCd.dskokno) +
                $AND + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsLoginKanri.dskokno) +
                $AND + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsKokyakuKeiyaku.dskokno) +
                subQuerStr +
                $ORDER_BY (qMT_DsKokyakuKeiyaku.dskokno.asc(),
                    qMT_DsKokyakuKeiyaku.syono.asc());

        return em.createJPQL(sql).bind(qMT_DsKokyakuKanri, qMT_DsHonninKakuninCd, qMT_DsLoginKanri, qMT_DsKokyakuKeiyaku)
            .getResultList();
    }

    public List<MT_DsKokyakuKanri> getDsKokyakuKanrisByDskokyakujtkbnNe(String pDskokyakunmkn, String pDskokyakunmkj,
        BizDate pDskokyakuseiymd, String pDskokyakuyno) {


        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri();


        String queryStr = $SELECT + qMT_DsKokyakuKanri +
            $FROM + qMT_DsKokyakuKanri.MT_DsKokyakuKanri() +
            $WHERE + qMT_DsKokyakuKanri.dskokyakunmkn.eq(pDskokyakunmkn) +
            $AND + qMT_DsKokyakuKanri.dskokyakunmkj.eq(pDskokyakunmkj) +
            $AND + qMT_DsKokyakuKanri.dskokyakuseiymd.eq(pDskokyakuseiymd) +
            $AND + qMT_DsKokyakuKanri.dskokyakuyno.eq(pDskokyakuyno) +
            $AND + qMT_DsKokyakuKanri.dskokyakujtkbn.ne(C_DsKokyakuJtKbn.KAIYAKU) +
            $AND + qMT_DsKokyakuKanri.dskokyakujtkbn.ne(C_DsKokyakuJtKbn.SEISA_SYOUMETU);

        return em.createJPQL(queryStr).bind(qMT_DsKokyakuKanri).getResultList();
    }

    public ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(
        C_DsKrHnnKakCdTtYhKbn pDskrhnnkakcdttyhkbn,
        BizDate pDskrhnnkakcdttshjyhsymd) {


        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri();


        QMT_DsHonninKakuninCd qMT_DsHonninKakuninCd = new QMT_DsHonninKakuninCd();


        String queryStr = $SELECT + qMT_DsKokyakuKanri +
            $FROM + qMT_DsKokyakuKanri.MT_DsKokyakuKanri() + "," +
            qMT_DsHonninKakuninCd.MT_DsHonninKakuninCd() +
            $WHERE + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsHonninKakuninCd.dskokno) +
            $AND + qMT_DsHonninKakuninCd.dskrhnnkakcdttyhkbn.eq(pDskrhnnkakcdttyhkbn) +
            $AND + $($(qMT_DsKokyakuKanri.dskanyuukeirokbn.eq(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI) +
                $AND + qMT_DsHonninKakuninCd.dskrhnnkakcdsetkbn.eq(C_DsKrHnnKakCdSetKbn.SINKI) +
                $AND + qMT_DsHonninKakuninCd.dskrhnnkakcdttshjyhsymd.le(pDskrhnnkakcdttshjyhsymd)) +
                $OR  + $(qMT_DsKokyakuKanri.dskanyuukeirokbn.eq(C_DsKanyuuKeiroKbn.TYUUTOKANYUU) +
                    $AND + qMT_DsHonninKakuninCd.dskrhnnkakcdsetkbn.eq(C_DsKrHnnKakCdSetKbn.SINKI)) +
                    $OR  + qMT_DsHonninKakuninCd.dskrhnnkakcdsetkbn.eq(C_DsKrHnnKakCdSetKbn.SAIHAKKOU));

        return em.createJPQL(queryStr).bind(qMT_DsKokyakuKanri, qMT_DsHonninKakuninCd).getUpdatableResults();
    }
}
