package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkNenreiHani2;
import yuyu.def.db.mapping.GenBM_ChkNenreiHani2;
import yuyu.def.db.meta.GenQBM_ChkNenreiHani2;
import yuyu.def.db.meta.QBM_ChkNenreiHani2;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HknkknsmnKbn;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HrkkknsmnKbn;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 年齢範囲チェックマスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkNenreiHani2} の JavaDoc を参照してください。
 * @see     GenBM_ChkNenreiHani2
 * @see     PKBM_ChkNenreiHani2
 * @see     QBM_ChkNenreiHani2
 * @see     GenQBM_ChkNenreiHani2
 */
@Entity
public class BM_ChkNenreiHani2 extends GenBM_ChkNenreiHani2 {

    private static final long serialVersionUID = 1L;

    public BM_ChkNenreiHani2() {
    }

    public BM_ChkNenreiHani2(
        C_Channelcd pChannelcd,
        String pSyusyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        Integer pHhknseifrom,
        Integer pHhknseito,
        C_KataKbn pSyukatakbn,
        Integer pSyuhknkkn,
        Integer pSyuhknkknto,
        C_HknkknsmnKbn pSyuhknkknsmnkbn,
        Integer pSyuhrkkkn,
        Integer pSyuhrkkknto,
        C_HrkkknsmnKbn pSyuhrkkknsmnkbn,
        BizNumber pSyufromnen,
        BizNumber pSyutonen,
        BizNumber pSyuyoteiriritufrom,
        BizNumber pSyuyoteirirituto,
        Integer pSyudai1hknkkn,
        BizNumber pTokusyuchkno,
        String pTksyouhncd,
        BizNumber pTkhknkkn,
        Integer pTkhknkknto,
        C_HknkknsmnKbn pTkhknkknsmnkbn,
        BizNumber pTkhrkkkn,
        Integer pTkhrkkknto,
        C_HrkkknsmnKbn pTkhrkkknsmnkbn,
        BizNumber pTkfromnen,
        BizNumber pTktonen
    ) {
        super(
            pChannelcd,
            pSyusyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pHhknseifrom,
            pHhknseito,
            pSyukatakbn,
            pSyuhknkkn,
            pSyuhknkknto,
            pSyuhknkknsmnkbn,
            pSyuhrkkkn,
            pSyuhrkkknto,
            pSyuhrkkknsmnkbn,
            pSyufromnen,
            pSyutonen,
            pSyuyoteiriritufrom,
            pSyuyoteirirituto,
            pSyudai1hknkkn,
            pTokusyuchkno,
            pTksyouhncd,
            pTkhknkkn,
            pTkhknkknto,
            pTkhknkknsmnkbn,
            pTkhrkkkn,
            pTkhrkkknto,
            pTkhrkkknsmnkbn,
            pTkfromnen,
            pTktonen
        );
    }

}
