package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.BT_Nyknmeisai;
import yuyu.def.db.meta.QBT_Nyknmeisai;

/**
 * 入出金明細テーブル(BT_NyknmeisaiDao) アクセス用の DAO クラスです。<br />
 */
public class BT_NyknmeisaiDao extends AbstractDao<BT_Nyknmeisai> {

    public BT_NyknmeisaiDao() {
        super(BT_Nyknmeisai.class);
    }

    public BT_Nyknmeisai getNyknmeisai(String pHrkmsakuseiymd6keta, String pHrkmbankcd, String pHrkmshitencd, String pHrkmyokinkbn, String pHrkmkouzano, String pHrkmsyoukaino, String pHrkmrenno8) {
        BT_Nyknmeisai bT_Nyknmeisai =  new BT_Nyknmeisai();
        bT_Nyknmeisai.setHrkmsakuseiymd6keta(pHrkmsakuseiymd6keta);
        bT_Nyknmeisai.setHrkmbankcd(pHrkmbankcd);
        bT_Nyknmeisai.setHrkmshitencd(pHrkmshitencd);
        bT_Nyknmeisai.setHrkmyokinkbn(pHrkmyokinkbn);
        bT_Nyknmeisai.setHrkmkouzano(pHrkmkouzano);
        bT_Nyknmeisai.setHrkmsyoukaino(pHrkmsyoukaino);
        bT_Nyknmeisai.setHrkmrenno8(pHrkmrenno8);
        return this.selectOne(bT_Nyknmeisai);
    }

    public ExDBResults<BT_Nyknmeisai> getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(String pHrkmsakuseiymd6keta) {


        QBT_Nyknmeisai qBT_Nyknmeisai = new QBT_Nyknmeisai();


        String strSql = $SELECT + qBT_Nyknmeisai +
            $FROM + qBT_Nyknmeisai.BT_Nyknmeisai() +
            $WHERE + qBT_Nyknmeisai.hrkmsakuseiymd6keta.eq(pHrkmsakuseiymd6keta);


        return em.createJPQL(strSql).bind(qBT_Nyknmeisai).getResults();
    }
}
