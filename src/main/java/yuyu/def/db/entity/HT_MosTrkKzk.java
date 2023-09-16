package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.db.mapping.GenHT_MosTrkKzk;

/**
 * 申込登録家族テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_MosTrkKzk} の JavaDoc を参照してください。<br />
 * @see     GenHT_MosTrkKzk<br />
 * @see     PKHT_MosTrkKzk<br />
 * @see     QHT_MosTrkKzk<br />
 * @see     GenQHT_MosTrkKzk<br />
 */
@Entity
public class HT_MosTrkKzk extends GenHT_MosTrkKzk {

    private static final long serialVersionUID = 1L;

    public HT_MosTrkKzk() {
    }

    public HT_MosTrkKzk(String pMosno,C_TrkKzkKbn pTrkkzkkbn) {
        super(pMosno,pTrkkzkkbn);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_MosTrkKzk.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

