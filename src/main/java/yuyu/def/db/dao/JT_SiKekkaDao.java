package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.db.meta.QJT_SiKekka;

/**
 * 支払処理結果テーブル(JT_SiKekkaDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiKekkaDao extends AbstractDao<JT_SiKekka> {

    public JT_SiKekkaDao() {
        super(JT_SiKekka.class);
    }

    public JT_SiKekka getSiKekka(C_ShiharaikekkadataKbn pShiharaikekkadatakbn,
        String pSyono,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno,
        C_SyutkKbn pSyutkkbn){
        JT_SiKekka jT_SiKekka =  new JT_SiKekka();
        jT_SiKekka.setShiharaikekkadatakbn(pShiharaikekkadatakbn);
        jT_SiKekka.setSyono(pSyono);
        jT_SiKekka.setSyouhncd(pSyouhncd);
        jT_SiKekka.setSyouhnsdno(pSyouhnsdno);
        jT_SiKekka.setKyksyouhnrenno(pKyksyouhnrenno);
        jT_SiKekka.setSyutkkbn(pSyutkkbn);
        return this.selectOne(jT_SiKekka);
    }

    public ExDBResults<JT_SiKekka> getSiKekkasByKakutyoujobcd() {


        QJT_SiKekka qJT_SiKekka = new QJT_SiKekka();


        String queryStr = $SELECT + qJT_SiKekka +
            $FROM + qJT_SiKekka.JT_SiKekka() +
            $ORDER_BY(qJT_SiKekka.syono.asc(),
                qJT_SiKekka.syutkkbn.desc(),
                qJT_SiKekka.shiharaikekkadatakbn.desc());

        return em.createJPQL(queryStr).bind(qJT_SiKekka).getResults();
    }

    public ExDBResults<JT_SiKekka> getSiKekkasByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QJT_SiKekka qJT_SiKekka = new QJT_SiKekka();


        String queryStr = $SELECT + qJT_SiKekka +
            $FROM + qJT_SiKekka.JT_SiKekka() +
            $WHERE + qJT_SiKekka.syoriYmd.eq(pSyoriYmd) +
            $ORDER_BY(qJT_SiKekka.syono.asc(),
                qJT_SiKekka.syutkkbn.desc(),
                qJT_SiKekka.shiharaikekkadatakbn.desc());

        return em.createJPQL(queryStr).bind(qJT_SiKekka).getResults();
    }

    public List<JT_SiKekka> getSiKekkasBySyono(String pSyono) {


        QJT_SiKekka qJT_SiKekka = new QJT_SiKekka();


        String queryStr = $SELECT + qJT_SiKekka +
            $FROM (qJT_SiKekka) +
            $WHERE + qJT_SiKekka.syono.eq(pSyono) ;


        return em.createJPQL(queryStr).bind(qJT_SiKekka).getResultList();

    }

    public List<JT_SiKekka> getSiKekkasBySyonoSyoumetujiyuuNe(String pSyono, C_Syoumetujiyuu  pSyoumetujiyuu) {


        QJT_SiKekka qJT_SiKekka = new QJT_SiKekka();


        String queryStr = $SELECT + qJT_SiKekka +
            $FROM (qJT_SiKekka) +
            $WHERE + qJT_SiKekka.syono.eq(pSyono) +
            $AND + qJT_SiKekka.syoumetujiyuu.ne(pSyoumetujiyuu);


        return em.createJPQL(queryStr).bind(qJT_SiKekka).getResultList();
    }
}
