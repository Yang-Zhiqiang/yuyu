package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_OnlineGknyknmeisai;
import yuyu.def.db.mapping.GenBT_OnlineGknyknmeisai;
import yuyu.def.db.meta.GenQBT_OnlineGknyknmeisai;
import yuyu.def.db.meta.QBT_OnlineGknyknmeisai;

/**
 * オンライン外貨入出金明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_OnlineGknyknmeisai} の JavaDoc を参照してください。
 * @see     GenBT_OnlineGknyknmeisai
 * @see     PKBT_OnlineGknyknmeisai
 * @see     QBT_OnlineGknyknmeisai
 * @see     GenQBT_OnlineGknyknmeisai
 */
@Entity
public class BT_OnlineGknyknmeisai extends GenBT_OnlineGknyknmeisai {

    private static final long serialVersionUID = 1L;

    public BT_OnlineGknyknmeisai() {
    }

    public BT_OnlineGknyknmeisai(
        String pHrkmsakuseiymd,
        String pHrkmrenrakuymd,
        String pHrkmrenrakukaisuu,
        String pHrkmbankcd,
        String pHrkmshitencd,
        String pHrkmyokinkbn,
        String pHrkmkouzano,
        String pHrkmzndktuukasyu,
        String pHrkmsyorino1
    ) {
        super(
            pHrkmsakuseiymd,
            pHrkmrenrakuymd,
            pHrkmrenrakukaisuu,
            pHrkmbankcd,
            pHrkmshitencd,
            pHrkmyokinkbn,
            pHrkmkouzano,
            pHrkmzndktuukasyu,
            pHrkmsyorino1
        );
    }

}
