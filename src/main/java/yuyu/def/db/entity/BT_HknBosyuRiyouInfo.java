package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBT_HknBosyuRiyouInfo;


/**
 * 保険募集システム利用情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_HknBosyuRiyouInfo} の JavaDoc を参照してください。<br />
 * @see     GenBT_HknBosyuRiyouInfo<br />
 * @see     PKBT_HknBosyuRiyouInfo<br />
 * @see     QBT_HknBosyuRiyouInfo<br />
 * @see     GenQBT_HknBosyuRiyouInfo<br />
 */
@Entity
public class BT_HknBosyuRiyouInfo extends GenBT_HknBosyuRiyouInfo {

    private static final long serialVersionUID = 1L;

    public BT_HknBosyuRiyouInfo() {
    }

    public BT_HknBosyuRiyouInfo(String pDrtencd) {
        super(pDrtencd);
    }



}

