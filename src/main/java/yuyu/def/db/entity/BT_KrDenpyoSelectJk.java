package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_KrDenpyoSelectJk;
import yuyu.def.db.mapping.GenBT_KrDenpyoSelectJk;
import yuyu.def.db.meta.GenQBT_KrDenpyoSelectJk;
import yuyu.def.db.meta.QBT_KrDenpyoSelectJk;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 経理伝票データ抽出条件テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_KrDenpyoSelectJk} の JavaDoc を参照してください。
 * @see     GenBT_KrDenpyoSelectJk
 * @see     PKBT_KrDenpyoSelectJk
 * @see     QBT_KrDenpyoSelectJk
 * @see     GenQBT_KrDenpyoSelectJk
 */
@Entity
public class BT_KrDenpyoSelectJk extends GenBT_KrDenpyoSelectJk {

    private static final long serialVersionUID = 1L;

    public BT_KrDenpyoSelectJk() {
    }

    public BT_KrDenpyoSelectJk(BizDate pSyoriYmd, BizNumber pSyoriymdrenno) {
        super(pSyoriYmd, pSyoriymdrenno);
    }

}
