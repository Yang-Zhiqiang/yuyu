package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.mapping.GenBM_KyhNitigakuBairitu;


/**
 * 給付日額倍率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_KyhNitigakuBairitu} の JavaDoc を参照してください。<br />
 * @see     GenBM_KyhNitigakuBairitu<br />
 * @see     PKBM_KyhNitigakuBairitu<br />
 * @see     QBM_KyhNitigakuBairitu<br />
 * @see     GenQBM_KyhNitigakuBairitu<br />
 */
@Entity
public class BM_KyhNitigakuBairitu extends GenBM_KyhNitigakuBairitu {

    private static final long serialVersionUID = 1L;

    public BM_KyhNitigakuBairitu() {
    }

    public BM_KyhNitigakuBairitu(String pSyouhncd,Integer pSyouhnsdno,C_KataKbn pKatakbn) {
        super(pSyouhncd,pSyouhnsdno,pKatakbn);
    }



    private BM_SyouhnZokusei bM_SyouhnZokusei ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BM_KyhNitigakuBairitu.SYOUHNCD  , referencedColumnName=BM_SyouhnZokusei.SYOUHNCD, insertable=false, updatable=false),
        @JoinColumn(name=BM_KyhNitigakuBairitu.SYOUHNSDNO  , referencedColumnName=BM_SyouhnZokusei.SYOUHNSDNO, insertable=false, updatable=false)
    })
    public BM_SyouhnZokusei getSyouhnZokusei() {
        return bM_SyouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pBM_SyouhnZokusei) {
        this.bM_SyouhnZokusei = pBM_SyouhnZokusei;
    }

}

