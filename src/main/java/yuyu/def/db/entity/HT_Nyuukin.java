package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_Nyuukin;


/**
 * 入金テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_Nyuukin} の JavaDoc を参照してください。<br />
 * @see     GenHT_Nyuukin<br />
 * @see     PKHT_Nyuukin<br />
 * @see     QHT_Nyuukin<br />
 * @see     GenQHT_Nyuukin<br />
 */
@Entity
public class HT_Nyuukin extends GenHT_Nyuukin {

    private static final long serialVersionUID = 1L;

    public HT_Nyuukin() {
    }

    public HT_Nyuukin(String pMosno,Integer pRenno) {
        super(pMosno,pRenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_Nyuukin.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

