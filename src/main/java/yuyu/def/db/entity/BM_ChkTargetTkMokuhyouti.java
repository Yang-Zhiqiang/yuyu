package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkTargetTkMokuhyouti;
import yuyu.def.db.mapping.GenBM_ChkTargetTkMokuhyouti;
import yuyu.def.db.meta.GenQBM_ChkTargetTkMokuhyouti;
import yuyu.def.db.meta.QBM_ChkTargetTkMokuhyouti;
import yuyu.def.classification.C_Channelcd;

/**
 * ターゲット特約目標値チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkTargetTkMokuhyouti} の JavaDoc を参照してください。
 * @see     GenBM_ChkTargetTkMokuhyouti
 * @see     PKBM_ChkTargetTkMokuhyouti
 * @see     QBM_ChkTargetTkMokuhyouti
 * @see     GenQBM_ChkTargetTkMokuhyouti
 */
@Entity
public class BM_ChkTargetTkMokuhyouti extends GenBM_ChkTargetTkMokuhyouti {

    private static final long serialVersionUID = 1L;

    public BM_ChkTargetTkMokuhyouti() {
    }

    public BM_ChkTargetTkMokuhyouti(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd,
        Integer pTargettkmokuhyouti
    ) {
        super(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pChannelcd,
            pTargettkmokuhyouti
        );
    }

}
