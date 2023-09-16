package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.BT_Gknyknmeisai;
import yuyu.def.db.meta.QBT_Gknyknmeisai;

/**
 * 外貨入出金明細テーブル(BT_GknyknmeisaiDao) アクセス用の DAO クラスです。<br />
 */
public class BT_GknyknmeisaiDao extends AbstractDao<BT_Gknyknmeisai> {

    public BT_GknyknmeisaiDao() {
        super(BT_Gknyknmeisai.class);
    }

    public BT_Gknyknmeisai getGknyknmeisai(String pHrkmsakuseiymd, String pHrkmrenrakuymd, String pHrkmrenrakukaisuu, String pHrkmbankcd, String pHrkmshitencd, String pHrkmyokinkbn, String pHrkmkouzano, String pHrkmzndktuukasyu, String pHrkmsyorino1) {
        BT_Gknyknmeisai bT_Gknyknmeisai =  new BT_Gknyknmeisai();
        bT_Gknyknmeisai.setHrkmsakuseiymd(pHrkmsakuseiymd);
        bT_Gknyknmeisai.setHrkmrenrakuymd(pHrkmrenrakuymd);
        bT_Gknyknmeisai.setHrkmrenrakukaisuu(pHrkmrenrakukaisuu);
        bT_Gknyknmeisai.setHrkmbankcd(pHrkmbankcd);
        bT_Gknyknmeisai.setHrkmshitencd(pHrkmshitencd);
        bT_Gknyknmeisai.setHrkmyokinkbn(pHrkmyokinkbn);
        bT_Gknyknmeisai.setHrkmkouzano(pHrkmkouzano);
        bT_Gknyknmeisai.setHrkmzndktuukasyu(pHrkmzndktuukasyu);
        bT_Gknyknmeisai.setHrkmsyorino1(pHrkmsyorino1);
        return this.selectOne(bT_Gknyknmeisai);
    }

    public ExDBResults<BT_Gknyknmeisai> getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd(String pHrkmsakuseiymd) {


        QBT_Gknyknmeisai qBT_Gknyknmeisai = new QBT_Gknyknmeisai();


        String strSql =$SELECT +qBT_Gknyknmeisai+
            $FROM+qBT_Gknyknmeisai.BT_Gknyknmeisai()+
            $WHERE+qBT_Gknyknmeisai.hrkmsakuseiymd.eq(pHrkmsakuseiymd);


        return em.createJPQL(strSql).bind(qBT_Gknyknmeisai).getResults();
    }
}
