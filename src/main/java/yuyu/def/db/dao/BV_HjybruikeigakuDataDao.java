package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BV_HjybruikeigakuData;

/**
 * 補助簿累計額情報ビュー(BV_HjybruikeigakuDataDao) アクセス用の DAO クラスです。<br />
 */
public class BV_HjybruikeigakuDataDao extends AbstractDao<BV_HjybruikeigakuData> {

    public BV_HjybruikeigakuDataDao() {
        super(BV_HjybruikeigakuData.class);
    }

    public BV_HjybruikeigakuData getHjybruikeigakuData(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd) {
        BV_HjybruikeigakuData bV_HjybruikeigakuData =  new BV_HjybruikeigakuData();
        bV_HjybruikeigakuData.setHjybtantositucd(pHjybtantositucd);
        bV_HjybruikeigakuData.setKanjyoukmkcd(pKanjyoukmkcd);
        return this.selectOne(bV_HjybruikeigakuData);
    }

}
