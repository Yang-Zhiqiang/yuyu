package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_Tuusan;


/**
 * 通算テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_Tuusan} の JavaDoc を参照してください。<br />
 * @see     GenHT_Tuusan<br />
 * @see     PKHT_Tuusan<br />
 * @see     QHT_Tuusan<br />
 * @see     GenQHT_Tuusan<br />
 */
@Entity
public class HT_Tuusan extends GenHT_Tuusan {

    private static final long serialVersionUID = 1L;

    public HT_Tuusan() {
    }

    public HT_Tuusan(String pMosno) {
        super(pMosno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_Tuusan.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

