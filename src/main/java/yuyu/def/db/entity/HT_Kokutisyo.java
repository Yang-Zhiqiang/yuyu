package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_Kokutisyo;


/**
 * 告知書テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_Kokutisyo} の JavaDoc を参照してください。<br />
 * @see     GenHT_Kokutisyo<br />
 * @see     PKHT_Kokutisyo<br />
 * @see     QHT_Kokutisyo<br />
 * @see     GenQHT_Kokutisyo<br />
 */
@Entity
public class HT_Kokutisyo extends GenHT_Kokutisyo {

    private static final long serialVersionUID = 1L;

    public HT_Kokutisyo() {
    }

    public HT_Kokutisyo(String pMosno) {
        super(pMosno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_Kokutisyo.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

