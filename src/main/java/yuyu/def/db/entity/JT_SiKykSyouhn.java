package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.mapping.GenJT_SiKykSyouhn;


/**
 * 支払契約商品テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiKykSyouhn} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiKykSyouhn<br />
 * @see     PKJT_SiKykSyouhn<br />
 * @see     QJT_SiKykSyouhn<br />
 * @see     GenQJT_SiKykSyouhn<br />
 */
@Entity
public class JT_SiKykSyouhn extends GenJT_SiKykSyouhn {

    private static final long serialVersionUID = 1L;

    public JT_SiKykSyouhn() {
    }

    public JT_SiKykSyouhn(String pSyono,C_SyutkKbn pSyutkkbn,String pSyouhncd,C_KyhgndkataKbn pKyhgndkatakbn,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(pSyono,pSyutkkbn,pSyouhncd,pKyhgndkatakbn,pSyouhnsdno,pKyksyouhnrenno);
    }



    private JT_SiKykKihon jT_SiKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SiKykSyouhn.SYONO  , referencedColumnName=JT_SiKykKihon.SYONO, insertable=false, updatable=false)
    })
    public JT_SiKykKihon getSiKykKihon() {
        return jT_SiKykKihon;
    }

    public void setSiKykKihon(JT_SiKykKihon pJT_SiKykKihon) {
        this.jT_SiKykKihon = pJT_SiKykKihon;
    }

    private BM_HutanpoBui bM_HutanpoBui1 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=JT_SiKykSyouhn.HTNPBUICD1  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
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
        @JoinColumn(name=JT_SiKykSyouhn.HTNPBUICD2  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
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
        @JoinColumn(name=JT_SiKykSyouhn.HTNPBUICD3  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
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
        @JoinColumn(name=JT_SiKykSyouhn.HTNPBUICD4  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
    })
    public  BM_HutanpoBui getHutanpoBui4() {
        return bM_HutanpoBui4;
    }

    public void setHutanpoBui4(BM_HutanpoBui pBM_HutanpoBui) {
        this.bM_HutanpoBui4 = pBM_HutanpoBui;
    }

}

