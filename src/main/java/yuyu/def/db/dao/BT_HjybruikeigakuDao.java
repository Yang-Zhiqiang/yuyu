package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_Hjybruikeigaku;
import yuyu.def.db.meta.QBT_Hjybruikeigaku;

/**
 * 補助簿累計額テーブル(BT_HjybruikeigakuDao) アクセス用の DAO クラスです。<br />
 */
public class BT_HjybruikeigakuDao extends AbstractDao<BT_Hjybruikeigaku> {

    public BT_HjybruikeigakuDao() {
        super(BT_Hjybruikeigaku.class);
    }

    public BT_Hjybruikeigaku getHjybruikeigaku(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd, BizDateYM pDenym) {
        BT_Hjybruikeigaku bT_Hjybruikeigaku =  new BT_Hjybruikeigaku();
        bT_Hjybruikeigaku.setHjybtantositucd(pHjybtantositucd);
        bT_Hjybruikeigaku.setKanjyoukmkcd(pKanjyoukmkcd);
        bT_Hjybruikeigaku.setDenym(pDenym);
        return this.selectOne(bT_Hjybruikeigaku);
    }



    public List<BT_Hjybruikeigaku> getHjybruikeigakusByPK(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd,
        BizDateYM pDenym) {


        QBT_Hjybruikeigaku qBT_Hjybruikeigaku = new QBT_Hjybruikeigaku("qBT_Hjybruikeigaku");


        String strSql = $SELECT + qBT_Hjybruikeigaku +
            $FROM(qBT_Hjybruikeigaku) +
            $WHERE + qBT_Hjybruikeigaku.hjybtantositucd.eq(pHjybtantositucd) +
            $AND + qBT_Hjybruikeigaku.kanjyoukmkcd.eq(pKanjyoukmkcd) +
            $AND + qBT_Hjybruikeigaku.denym.le(pDenym) +
            $ORDER_BY(qBT_Hjybruikeigaku.denym.desc());

        return em.createJPQL(strSql).bind(qBT_Hjybruikeigaku).getResultList();
    }

}
