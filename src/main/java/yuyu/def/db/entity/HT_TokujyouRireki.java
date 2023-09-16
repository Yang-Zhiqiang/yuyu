package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_TokujyouRireki;


/**
 * 特条履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_TokujyouRireki} の JavaDoc を参照してください。<br />
 * @see     GenHT_TokujyouRireki<br />
 * @see     PKHT_TokujyouRireki<br />
 * @see     QHT_TokujyouRireki<br />
 * @see     GenQHT_TokujyouRireki<br />
 */
@Entity
public class HT_TokujyouRireki extends GenHT_TokujyouRireki {

    private static final long serialVersionUID = 1L;

    public HT_TokujyouRireki() {
    }

    public HT_TokujyouRireki(String pMosno,Integer pDakuhiktrenno) {
        super(pMosno,pDakuhiktrenno);
    }



    private HT_DakuhiKettei hT_DakuhiKettei ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_TokujyouRireki.MOSNO  , referencedColumnName=HT_DakuhiKettei.MOSNO, insertable=false, updatable=false),
        @JoinColumn(name=HT_TokujyouRireki.DAKUHIKTRENNO  , referencedColumnName=HT_DakuhiKettei.DAKUHIKTRENNO, insertable=false, updatable=false)
    })
    public HT_DakuhiKettei getDakuhiKettei() {
        return hT_DakuhiKettei;
    }

    public void setDakuhiKettei(HT_DakuhiKettei pHT_DakuhiKettei) {
        this.hT_DakuhiKettei = pHT_DakuhiKettei;
    }

    private BM_HutanpoBui bM_HutanpoBui1 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_TokujyouRireki.HTNPBUICD1  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_TokujyouRireki.HTNPBUICD2  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_TokujyouRireki.HTNPBUICD3  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_TokujyouRireki.HTNPBUICD4  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
    })
    public  BM_HutanpoBui getHutanpoBui4() {
        return bM_HutanpoBui4;
    }

    public void setHutanpoBui4(BM_HutanpoBui pBM_HutanpoBui) {
        this.bM_HutanpoBui4 = pBM_HutanpoBui;
    }

}

