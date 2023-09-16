package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_DairitenItakuSyouhn;
import yuyu.def.db.mapping.GenBT_DairitenItakuSyouhn;
import yuyu.def.db.meta.GenQBT_DairitenItakuSyouhn;
import yuyu.def.db.meta.QBT_DairitenItakuSyouhn;
import jp.co.slcs.swak.date.BizDate;

/**
 * 代理店委託商品情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_DairitenItakuSyouhn} の JavaDoc を参照してください。
 * @see     GenBT_DairitenItakuSyouhn
 * @see     PKBT_DairitenItakuSyouhn
 * @see     QBT_DairitenItakuSyouhn
 * @see     GenQBT_DairitenItakuSyouhn
 */
@Entity
public class BT_DairitenItakuSyouhn extends GenBT_DairitenItakuSyouhn {

    private static final long serialVersionUID = 1L;

    public BT_DairitenItakuSyouhn() {
    }

    public BT_DairitenItakuSyouhn(
        String pDrtencd,
        String pDrtsyouhinsikibetukbnstr,
        String pDrthrkhouhoukbn,
        String pDrtplannmkbn,
        BizDate pItakuhknhnbkaisiymd
    ) {
        super(
            pDrtencd,
            pDrtsyouhinsikibetukbnstr,
            pDrthrkhouhoukbn,
            pDrtplannmkbn,
            pItakuhknhnbkaisiymd
        );
    }

}
