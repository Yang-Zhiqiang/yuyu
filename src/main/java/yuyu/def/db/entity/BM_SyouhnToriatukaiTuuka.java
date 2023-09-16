package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_SyouhnToriatukaiTuuka;
import yuyu.def.db.mapping.GenBM_SyouhnToriatukaiTuuka;
import yuyu.def.db.meta.GenQBM_SyouhnToriatukaiTuuka;
import yuyu.def.db.meta.QBM_SyouhnToriatukaiTuuka;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 商品取扱通貨マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SyouhnToriatukaiTuuka} の JavaDoc を参照してください。
 * @see     GenBM_SyouhnToriatukaiTuuka
 * @see     PKBM_SyouhnToriatukaiTuuka
 * @see     QBM_SyouhnToriatukaiTuuka
 * @see     GenQBM_SyouhnToriatukaiTuuka
 */
@Entity
public class BM_SyouhnToriatukaiTuuka extends GenBM_SyouhnToriatukaiTuuka {

    private static final long serialVersionUID = 1L;

    public BM_SyouhnToriatukaiTuuka() {
    }

    public BM_SyouhnToriatukaiTuuka(
        String pSyouhncd,
        BizDate pTkyfromymd,
        BizDate pTkytoymd,
        C_BlnktkumuKbn pZenkizennouumu,
        C_Tuukasyu pKyktuukasyu,
        C_Tuukasyu pHrktuukasyu
    ) {
        super(
            pSyouhncd,
            pTkyfromymd,
            pTkytoymd,
            pZenkizennouumu,
            pKyktuukasyu,
            pHrktuukasyu
        );
    }

}
