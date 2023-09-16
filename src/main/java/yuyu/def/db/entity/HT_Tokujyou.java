package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_Tokujyou;


/**
 * 特条テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_Tokujyou} の JavaDoc を参照してください。<br />
 * @see     GenHT_Tokujyou<br />
 * @see     PKHT_Tokujyou<br />
 * @see     QHT_Tokujyou<br />
 * @see     GenQHT_Tokujyou<br />
 */
@Entity
public class HT_Tokujyou extends GenHT_Tokujyou {

    private static final long serialVersionUID = 1L;

    public HT_Tokujyou() {
    }

    public HT_Tokujyou(String pMosno) {
        super(pMosno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_Tokujyou.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

    private BM_HutanpoBui bM_HutanpoBui1 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_Tokujyou.HTNPBUICD1  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
    })
    public  BM_HutanpoBui getHutanpoBui1() {
        return bM_HutanpoBui1;
    }

    public void setHutanpoBui1(BM_HutanpoBui pBM_HutanpoBui) {
        this.bM_HutanpoBui1 = pBM_HutanpoBui;
    }

    private BM_HutanpoBui bM_HutanpoBui2 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_Tokujyou.HTNPBUICD2  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
    })
    public  BM_HutanpoBui getHutanpoBui2() {
        return bM_HutanpoBui2;
    }

    public void setHutanpoBui2(BM_HutanpoBui pBM_HutanpoBui) {
        this.bM_HutanpoBui2 = pBM_HutanpoBui;
    }

    private BM_HutanpoBui bM_HutanpoBui3 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_Tokujyou.HTNPBUICD3  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
    })
    public  BM_HutanpoBui getHutanpoBui3() {
        return bM_HutanpoBui3;
    }

    public void setHutanpoBui3(BM_HutanpoBui pBM_HutanpoBui) {
        this.bM_HutanpoBui3 = pBM_HutanpoBui;
    }

    private BM_HutanpoBui bM_HutanpoBui4 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_Tokujyou.HTNPBUICD4  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
    })
    public  BM_HutanpoBui getHutanpoBui4() {
        return bM_HutanpoBui4;
    }

    public void setHutanpoBui4(BM_HutanpoBui pBM_HutanpoBui) {
        this.bM_HutanpoBui4 = pBM_HutanpoBui;
    }

}

