package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkSueokiKikan;
import yuyu.def.db.mapping.GenBM_ChkSueokiKikan;
import yuyu.def.db.meta.GenQBM_ChkSueokiKikan;
import yuyu.def.db.meta.QBM_ChkSueokiKikan;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_SueokikknsmnKbn;

/**
 * 据置期間チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkSueokiKikan} の JavaDoc を参照してください。
 * @see     GenBM_ChkSueokiKikan
 * @see     PKBM_ChkSueokiKikan
 * @see     QBM_ChkSueokiKikan
 * @see     GenQBM_ChkSueokiKikan
 */
@Entity
public class BM_ChkSueokiKikan extends GenBM_ChkSueokiKikan {

    private static final long serialVersionUID = 1L;

    public BM_ChkSueokiKikan() {
    }

    public BM_ChkSueokiKikan(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd,
        Integer pSueokikkn,
        C_SueokikknsmnKbn pSueokikknsmnkbn
    ) {
        super(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pChannelcd,
            pSueokikkn,
            pSueokikknsmnkbn
        );
    }

}
