package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_Nyknmeisai;
import yuyu.def.db.mapping.GenBT_Nyknmeisai;
import yuyu.def.db.meta.GenQBT_Nyknmeisai;
import yuyu.def.db.meta.QBT_Nyknmeisai;

/**
 * 入出金明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_Nyknmeisai} の JavaDoc を参照してください。
 * @see     GenBT_Nyknmeisai
 * @see     PKBT_Nyknmeisai
 * @see     QBT_Nyknmeisai
 * @see     GenQBT_Nyknmeisai
 */
@Entity
public class BT_Nyknmeisai extends GenBT_Nyknmeisai {

    private static final long serialVersionUID = 1L;

    public BT_Nyknmeisai() {
    }

    public BT_Nyknmeisai(
        String pHrkmsakuseiymd6keta,
        String pHrkmbankcd,
        String pHrkmshitencd,
        String pHrkmyokinkbn,
        String pHrkmkouzano,
        String pHrkmsyoukaino,
        String pHrkmrenno8
    ) {
        super(
            pHrkmsakuseiymd6keta,
            pHrkmbankcd,
            pHrkmshitencd,
            pHrkmyokinkbn,
            pHrkmkouzano,
            pHrkmsyoukaino,
            pHrkmrenno8
        );
    }

}
