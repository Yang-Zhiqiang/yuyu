package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.mapping.GenBM_ChkNenreiHani;


/**
 * 年齢範囲チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkNenreiHani} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkNenreiHani<br />
 * @see     PKBM_ChkNenreiHani<br />
 * @see     QBM_ChkNenreiHani<br />
 * @see     GenQBM_ChkNenreiHani<br />
 */
@Entity
public class BM_ChkNenreiHani extends GenBM_ChkNenreiHani {

    private static final long serialVersionUID = 1L;

    public BM_ChkNenreiHani() {
    }

    public BM_ChkNenreiHani(
        C_Channelcd pChannelcd,
        String pSyusyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
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
