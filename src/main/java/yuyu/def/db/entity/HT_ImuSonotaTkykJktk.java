package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.mapping.GenHT_ImuSonotaTkykJktk;


/**
 * 医務査定その他特約条件付テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_ImuSonotaTkykJktk} の JavaDoc を参照してください。<br />
 * @see     GenHT_ImuSonotaTkykJktk<br />
 * @see     PKHT_ImuSonotaTkykJktk<br />
 * @see     QHT_ImuSonotaTkykJktk<br />
 * @see     GenQHT_ImuSonotaTkykJktk<br />
 */
@Entity
public class HT_ImuSonotaTkykJktk extends GenHT_ImuSonotaTkykJktk {

    private static final long serialVersionUID = 1L;

    public HT_ImuSonotaTkykJktk() {
    }

    public HT_ImuSonotaTkykJktk(String pMosno,Integer pRenno,C_PmnjtkKbn pPmnjtkkbn) {
        super(pMosno,pRenno,pPmnjtkkbn);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_ImuSonotaTkykJktk.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

