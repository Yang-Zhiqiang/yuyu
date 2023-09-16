package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_HjybruikeigakuTeisei;

/**
 * 補助簿累計額訂正テーブル(BT_HjybruikeigakuTeiseiDao) アクセス用の DAO クラスです。<br />
 */
public class BT_HjybruikeigakuTeiseiDao extends AbstractDao<BT_HjybruikeigakuTeisei> {

    public BT_HjybruikeigakuTeiseiDao() {
        super(BT_HjybruikeigakuTeisei.class);
    }

    public BT_HjybruikeigakuTeisei getHjybruikeigakuTeisei(String pHjybruigkteiseitantositucd, C_Kanjyoukmkcd pKanjyoukmkcd) {
        BT_HjybruikeigakuTeisei bT_HjybruikeigakuTeisei =  new BT_HjybruikeigakuTeisei();
        bT_HjybruikeigakuTeisei.setHjybruigkteiseitantositucd(pHjybruigkteiseitantositucd);
        bT_HjybruikeigakuTeisei.setKanjyoukmkcd(pKanjyoukmkcd);
        return this.selectOne(bT_HjybruikeigakuTeisei);
    }

}
