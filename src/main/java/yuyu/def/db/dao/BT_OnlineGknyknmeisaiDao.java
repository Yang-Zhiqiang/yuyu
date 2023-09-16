package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_OnlineGknyknmeisai;

/**
 * オンライン外貨入出金明細テーブル
 */
public class BT_OnlineGknyknmeisaiDao extends AbstractDao<BT_OnlineGknyknmeisai> {

    public BT_OnlineGknyknmeisaiDao() {
        super(BT_OnlineGknyknmeisai.class);
    }

    public BT_OnlineGknyknmeisai getOnlineGknyknmeisai(String pHrkmsakuseiymd, String pHrkmrenrakuymd, String pHrkmrenrakukaisuu, String pHrkmbankcd, String pHrkmshitencd, String pHrkmyokinkbn, String pHrkmkouzano, String pHrkmzndktuukasyu, String pHrkmsyorino1) {
        BT_OnlineGknyknmeisai bT_OnlineGknyknmeisai =  new BT_OnlineGknyknmeisai();
        bT_OnlineGknyknmeisai.setHrkmsakuseiymd(pHrkmsakuseiymd);
        bT_OnlineGknyknmeisai.setHrkmrenrakuymd(pHrkmrenrakuymd);
        bT_OnlineGknyknmeisai.setHrkmrenrakukaisuu(pHrkmrenrakukaisuu);
        bT_OnlineGknyknmeisai.setHrkmbankcd(pHrkmbankcd);
        bT_OnlineGknyknmeisai.setHrkmshitencd(pHrkmshitencd);
        bT_OnlineGknyknmeisai.setHrkmyokinkbn(pHrkmyokinkbn);
        bT_OnlineGknyknmeisai.setHrkmkouzano(pHrkmkouzano);
        bT_OnlineGknyknmeisai.setHrkmzndktuukasyu(pHrkmzndktuukasyu);
        bT_OnlineGknyknmeisai.setHrkmsyorino1(pHrkmsyorino1);
        return this.selectOne(bT_OnlineGknyknmeisai);
    }
}
