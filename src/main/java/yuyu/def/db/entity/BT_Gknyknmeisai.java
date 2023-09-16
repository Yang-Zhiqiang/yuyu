package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBT_Gknyknmeisai;


/**
 * 外貨入出金明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_Gknyknmeisai} の JavaDoc を参照してください。<br />
 * @see     GenBT_Gknyknmeisai<br />
 * @see     PKBT_Gknyknmeisai<br />
 * @see     QBT_Gknyknmeisai<br />
 * @see     GenQBT_Gknyknmeisai<br />
 */
@Entity
public class BT_Gknyknmeisai extends GenBT_Gknyknmeisai {

    private static final long serialVersionUID = 1L;

    public BT_Gknyknmeisai() {
    }

    public BT_Gknyknmeisai(String pHrkmsakuseiymd,String pHrkmrenrakuymd,String pHrkmrenrakukaisuu,String pHrkmbankcd,String pHrkmshitencd,String pHrkmyokinkbn,String pHrkmkouzano,String pHrkmzndktuukasyu,String pHrkmsyorino1) {
        super(pHrkmsakuseiymd,pHrkmrenrakuymd,pHrkmrenrakukaisuu,pHrkmbankcd,pHrkmshitencd,pHrkmyokinkbn,pHrkmkouzano,pHrkmzndktuukasyu,pHrkmsyorino1);
    }



}

