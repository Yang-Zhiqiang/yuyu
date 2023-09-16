package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QMT_DsHonninKakuninCd;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsLoginKanri;

/**
 * ＤＳ顧客契約テーブル(MT_DsKokyakuKeiyakuDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsKokyakuKeiyakuDao extends AbstractDao<MT_DsKokyakuKeiyaku> {

    public MT_DsKokyakuKeiyakuDao() {
        super(MT_DsKokyakuKeiyaku.class);
    }

    @Deprecated
    public MT_DsKokyakuKeiyaku getDsKokyakuKeiyaku(String pDskokno, String pSyono) {
        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku =  new MT_DsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku.setDskokno(pDskokno);
        mT_DsKokyakuKeiyaku.setSyono(pSyono);
        return this.selectOne(mT_DsKokyakuKeiyaku);
    }

    @Override
    @Deprecated
    public List<MT_DsKokyakuKeiyaku> selectAll() {
        return super.selectAll();
    }

    public List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusByDskoknoDskykmukouhyjSyutkkbnYuukousyoumetukbn(String pDskokno) {


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn();
        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku();


        String strsql1 = $SELECT + qIT_KykSyouhn.syono +
            $FROM + qIT_KykSyouhn.IT_KykSyouhn() +
            $WHERE + qIT_KykSyouhn.syono.eq(qMT_DsKokyakuKeiyaku.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.SYOUMETU);


        String strsql2 = $SELECT + qMT_DsKokyakuKeiyaku +
            $FROM + qMT_DsKokyakuKeiyaku.MT_DsKokyakuKeiyaku() +
            $WHERE + qMT_DsKokyakuKeiyaku.dskokno.eq(pDskokno) +
            $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK) +
            $AND + $EXISTS(strsql1);


        return em.createJPQL(strsql2).bind(qIT_KykSyouhn, qMT_DsKokyakuKeiyaku).getResultList();
    }


    public ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByDskokyakujtkbnDsteisiriyuukbnDskrhnnkakcdsetymd() {


        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri();


        QMT_DsHonninKakuninCd qMT_DsHonninKakuninCd = new QMT_DsHonninKakuninCd();

        String strsql = $SELECT + qMT_DsKokyakuKanri +
            $FROM + qMT_DsKokyakuKanri.MT_DsKokyakuKanri() +  "," +
            qMT_DsHonninKakuninCd.MT_DsHonninKakuninCd() +
            $WHERE + qMT_DsKokyakuKanri.dskokyakujtkbn.eq(C_DsKokyakuJtKbn.ITIJI_TEISI) +
            $AND + qMT_DsKokyakuKanri.dsteisiriyuukbn.eq(C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU) +
            $AND + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsHonninKakuninCd.dskokno) +
            $AND + qMT_DsHonninKakuninCd.dskrhnnkakcdsetymd.isNull();


        return em.createJPQL(strsql).bind(qMT_DsKokyakuKanri,qMT_DsHonninKakuninCd).getUpdatableResults();
    }

    public List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank(String pSyono) {


        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku();
        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri();
        QMT_DsHonninKakuninCd qMT_DsHonninKakuninCd = new QMT_DsHonninKakuninCd();
        QMT_DsLoginKanri qMT_DsLoginKanri = new QMT_DsLoginKanri();


        String strSql = $SELECT + qMT_DsKokyakuKeiyaku +
            $FROM(qMT_DsKokyakuKeiyaku, qMT_DsKokyakuKanri ,
                qMT_DsHonninKakuninCd, qMT_DsLoginKanri) +
                $WHERE + qMT_DsKokyakuKeiyaku.syono.eq(pSyono) +
                $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsKokyakuKanri.dskokno) +
                $AND + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsHonninKakuninCd.dskokno) +
                $AND + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsLoginKanri.dskokno) +
                $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK);


        return em.createJPQL(strSql).bind(qMT_DsKokyakuKeiyaku, qMT_DsKokyakuKanri, qMT_DsHonninKakuninCd, qMT_DsLoginKanri).getResultList();

    }

    public List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusBySyono(String pSyono) {

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku = new MT_DsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku.setSyono(pSyono);
        return this.select(mT_DsKokyakuKeiyaku);
    }
}
