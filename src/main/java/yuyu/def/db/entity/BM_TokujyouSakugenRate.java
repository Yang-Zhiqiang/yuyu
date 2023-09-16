package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.db.mapping.GenBM_TokujyouSakugenRate;


/**
 * 特条削減率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_TokujyouSakugenRate} の JavaDoc を参照してください。<br />
 * @see     GenBM_TokujyouSakugenRate<br />
 * @see     PKBM_TokujyouSakugenRate<br />
 * @see     QBM_TokujyouSakugenRate<br />
 * @see     GenQBM_TokujyouSakugenRate<br />
 */
@Entity
public class BM_TokujyouSakugenRate extends GenBM_TokujyouSakugenRate {

    private static final long serialVersionUID = 1L;

    public BM_TokujyouSakugenRate() {
    }

    public BM_TokujyouSakugenRate(String pSyouhncd,Integer pSyouhnsdno,C_Tkjyskgnkkn pTkjyskgnkkn) {
        super(pSyouhncd,pSyouhnsdno,pTkjyskgnkkn);
    }



    private BM_SyouhnZokusei bM_SyouhnZokusei ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BM_TokujyouSakugenRate.SYOUHNCD  , referencedColumnName=BM_SyouhnZokusei.SYOUHNCD, insertable=false, updatable=false),
        @JoinColumn(name=BM_TokujyouSakugenRate.SYOUHNSDNO  , referencedColumnName=BM_SyouhnZokusei.SYOUHNSDNO, insertable=false, updatable=false)
    })
    public BM_SyouhnZokusei getSyouhnZokusei() {
        return bM_SyouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pBM_SyouhnZokusei) {
        this.bM_SyouhnZokusei = pBM_SyouhnZokusei;
    }

}

