package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.db.mapping.GenHT_MosTrkKzkVrf;

/**
 * 申込登録家族ベリファイテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_MosTrkKzkVrf} の JavaDoc を参照してください。<br />
 * @see     GenHT_MosTrkKzkVrf<br />
 * @see     PKHT_MosTrkKzkVrf<br />
 * @see     QHT_MosTrkKzkVrf<br />
 * @see     GenQHT_MosTrkKzkVrf<br />
 */
@Entity
public class HT_MosTrkKzkVrf extends GenHT_MosTrkKzkVrf {

    private static final long serialVersionUID = 1L;

    public HT_MosTrkKzkVrf() {
    }

    public HT_MosTrkKzkVrf(String pMosno,C_TrkKzkKbn pTrkkzkkbn) {
        super(pMosno,pTrkkzkkbn);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_MosTrkKzkVrf.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

