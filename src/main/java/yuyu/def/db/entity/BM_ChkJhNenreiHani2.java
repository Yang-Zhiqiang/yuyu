package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkJhNenreiHani2;
import yuyu.def.db.mapping.GenBM_ChkJhNenreiHani2;
import yuyu.def.db.meta.GenQBM_ChkJhNenreiHani2;
import yuyu.def.db.meta.QBM_ChkJhNenreiHani2;
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
 * 年齢範囲事方書チェックマスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkJhNenreiHani2} の JavaDoc を参照してください。
 * @see     GenBM_ChkJhNenreiHani2
 * @see     PKBM_ChkJhNenreiHani2
 * @see     QBM_ChkJhNenreiHani2
 * @see     GenQBM_ChkJhNenreiHani2
 */
@Entity
public class BM_ChkJhNenreiHani2 extends GenBM_ChkJhNenreiHani2 {

    private static final long serialVersionUID = 1L;

    public BM_ChkJhNenreiHani2() {
    }

    public BM_ChkJhNenreiHani2(
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
