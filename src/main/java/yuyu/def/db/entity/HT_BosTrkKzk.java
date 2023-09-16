package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.db.mapping.GenHT_BosTrkKzk;

/**
 * 募集登録家族テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_BosTrkKzk} の JavaDoc を参照してください。<br />
 * @see     GenHT_BosTrkKzk<br />
 * @see     PKHT_BosTrkKzk<br />
 * @see     QHT_BosTrkKzk<br />
 * @see     GenQHT_BosTrkKzk<br />
 */
@Entity
public class HT_BosTrkKzk extends GenHT_BosTrkKzk {

    private static final long serialVersionUID = 1L;

    public HT_BosTrkKzk() {
    }

    public HT_BosTrkKzk(String pMosno,C_TrkKzkKbn pTrkkzkkbn) {
        super(pMosno,pTrkkzkkbn);
    }



    private HT_BosKihon hT_BosKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_BosTrkKzk.MOSNO  , referencedColumnName=HT_BosKihon.MOSNO, insertable=false, updatable=false)
    })
    public HT_BosKihon getBosKihon() {
        return hT_BosKihon;
    }

    public void setBosKihon(HT_BosKihon pHT_BosKihon) {
        this.hT_BosKihon = pHT_BosKihon;
    }

}

