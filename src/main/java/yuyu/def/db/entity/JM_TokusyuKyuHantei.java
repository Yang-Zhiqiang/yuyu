package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJM_TokusyuKyuHantei;


/**
 * 特定給付判定マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJM_TokusyuKyuHantei} の JavaDoc を参照してください。<br />
 * @see     GenJM_TokusyuKyuHantei<br />
 * @see     PKJM_TokusyuKyuHantei<br />
 * @see     QJM_TokusyuKyuHantei<br />
 * @see     GenQJM_TokusyuKyuHantei<br />
 */
@Entity
public class JM_TokusyuKyuHantei extends GenJM_TokusyuKyuHantei {

    private static final long serialVersionUID = 1L;

    public JM_TokusyuKyuHantei() {
    }

    public JM_TokusyuKyuHantei(String pByoumeitourokuno,String pSyouhncd,Integer pSyouhnsdno,String pTekiyoukknfrom,String pTekiyoukknkto) {
        super(pByoumeitourokuno,pSyouhncd,pSyouhnsdno,pTekiyoukknfrom,pTekiyoukknkto);
    }



    private JM_Byoumei jM_Byoumei ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JM_TokusyuKyuHantei.BYOUMEITOUROKUNO  , referencedColumnName=JM_Byoumei.BYOUMEITOUROKUNO, insertable=false, updatable=false)
    })
    public  JM_Byoumei getByoumei() {
        return jM_Byoumei;
    }

    public void setByoumei(JM_Byoumei pJM_Byoumei) {
        this.jM_Byoumei = pJM_Byoumei;
    }

}

