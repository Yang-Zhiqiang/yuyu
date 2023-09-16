package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.mapping.GenHT_SonotaTkykJktk;


/**
 * その他特約条件付テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SonotaTkykJktk} の JavaDoc を参照してください。<br />
 * @see     GenHT_SonotaTkykJktk<br />
 * @see     PKHT_SonotaTkykJktk<br />
 * @see     QHT_SonotaTkykJktk<br />
 * @see     GenQHT_SonotaTkykJktk<br />
 */
@Entity
public class HT_SonotaTkykJktk extends GenHT_SonotaTkykJktk {

    private static final long serialVersionUID = 1L;

    public HT_SonotaTkykJktk() {
    }

    public HT_SonotaTkykJktk(String pMosno,C_PmnjtkKbn pPmnjtkkbn) {
        super(pMosno,pPmnjtkkbn);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_SonotaTkykJktk.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

