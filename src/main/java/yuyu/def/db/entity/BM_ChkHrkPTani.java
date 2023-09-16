package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkHrkPTani;
import yuyu.def.db.mapping.GenBM_ChkHrkPTani;
import yuyu.def.db.meta.GenQBM_ChkHrkPTani;
import yuyu.def.db.meta.QBM_ChkHrkPTani;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 払込Ｐ単位チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkHrkPTani} の JavaDoc を参照してください。
 * @see     GenBM_ChkHrkPTani
 * @see     PKBM_ChkHrkPTani
 * @see     QBM_ChkHrkPTani
 * @see     GenQBM_ChkHrkPTani
 */
@Entity
public class BM_ChkHrkPTani extends GenBM_ChkHrkPTani {

    private static final long serialVersionUID = 1L;

    public BM_ChkHrkPTani() {
    }

    public BM_ChkHrkPTani(
        String pSyouhncd,
        C_Hrkkaisuu pHrkkaisuu,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd,
        C_Tuukasyu pHrktuukasyu
    ) {
        super(
            pSyouhncd,
            pHrkkaisuu,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pChannelcd,
            pHrktuukasyu
        );
    }

}
