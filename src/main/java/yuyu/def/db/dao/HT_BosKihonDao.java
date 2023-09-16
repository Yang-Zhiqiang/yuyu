package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_MosTourokuJyoukyouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.db.meta.QHT_BosKihon;
import yuyu.def.sinkeiyaku.result.bean.BosKihonInfosByKakutyoujobcdItemsBean;

/**
 * 募集基本テーブル(HT_BosKihonDao) アクセス用の DAO クラスです。<br />
 */
public class HT_BosKihonDao extends AbstractDao<HT_BosKihon> {

    public HT_BosKihonDao() {
        super(HT_BosKihon.class);
    }

    public HT_BosKihon getBosKihon(String pMosno){
        HT_BosKihon hT_BosKihon =  new HT_BosKihon();
        hT_BosKihon.setMosno(pMosno);
        return this.selectOne(hT_BosKihon);
    }

    public ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> getBosKihonInfosByKakutyoujobcdItems(C_MosUketukeKbn pMosuketukekbn, C_MosTourokuJyoukyouKbn pMostourokujyoukyoukbn, C_UmuKbn pPplessdatasousinumukbn) {
        QHT_BosKihon qHT_BosKihon =  new QHT_BosKihon();

        String str = $SELECT + $NEW(BosKihonInfosByKakutyoujobcdItemsBean.class,
            qHT_BosKihon.mosno) +
            $FROM + qHT_BosKihon.HT_BosKihon() +
            $WHERE + qHT_BosKihon.mosuketukekbn.eq(pMosuketukekbn) +
            $AND + qHT_BosKihon.mostourokujyoukyoukbn.eq(pMostourokujyoukyoukbn) +
            $AND + qHT_BosKihon.pplessdatasousinumukbn.eq(pPplessdatasousinumukbn) +
            $ORDER_BY(qHT_BosKihon.mosno.asc());

        return em.createJPQL(str, BosKihonInfosByKakutyoujobcdItemsBean.class).bind(qHT_BosKihon).getResults();
    }
}
