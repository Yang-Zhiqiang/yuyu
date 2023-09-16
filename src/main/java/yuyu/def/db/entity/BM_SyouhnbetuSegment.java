package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_SyouhnbetuSegment;
import yuyu.def.db.mapping.GenBM_SyouhnbetuSegment;
import yuyu.def.db.meta.GenQBM_SyouhnbetuSegment;
import yuyu.def.db.meta.QBM_SyouhnbetuSegment;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_SegbunruiKbn;
import yuyu.def.classification.C_SegbunruiKbn;

/**
 * 商品別セグメントマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SyouhnbetuSegment} の JavaDoc を参照してください。
 * @see     GenBM_SyouhnbetuSegment
 * @see     PKBM_SyouhnbetuSegment
 * @see     QBM_SyouhnbetuSegment
 * @see     GenQBM_SyouhnbetuSegment
 */
@Entity
public class BM_SyouhnbetuSegment extends GenBM_SyouhnbetuSegment {

    private static final long serialVersionUID = 1L;

    public BM_SyouhnbetuSegment() {
    }

    public BM_SyouhnbetuSegment(
        String pSyouhncd,
        C_Tuukasyu pKyktuukasyu,
        C_SegbunruiKbn pSegbunrui1,
        C_SegbunruiKbn pSegbunrui2
    ) {
        super(
            pSyouhncd,
            pKyktuukasyu,
            pSegbunrui1,
            pSegbunrui2
        );
    }

}
