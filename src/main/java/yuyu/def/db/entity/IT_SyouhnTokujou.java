package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.mapping.GenIT_SyouhnTokujou;


/**
 * 商品特条テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_SyouhnTokujou} の JavaDoc を参照してください。<br />
 * @see     GenIT_SyouhnTokujou<br />
 * @see     PKIT_SyouhnTokujou<br />
 * @see     QIT_SyouhnTokujou<br />
 * @see     GenQIT_SyouhnTokujou<br />
 */
@Entity
public class IT_SyouhnTokujou extends GenIT_SyouhnTokujou {

    private static final long serialVersionUID = 1L;

    public IT_SyouhnTokujou() {
    }

    public IT_SyouhnTokujou(String pKbnkey,String pSyono,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(pKbnkey,pSyono,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }

    public IT_SyouhnTokujou(String pSyono,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_SyouhnTokujou.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_SyouhnTokujou.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

    private BM_HutanpoBui bM_HutanpoBui1 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=IT_SyouhnTokujou.HTNPBUICD1  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
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
        @JoinColumn(name=IT_SyouhnTokujou.HTNPBUICD2  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
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
        @JoinColumn(name=IT_SyouhnTokujou.HTNPBUICD3  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
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
        @JoinColumn(name=IT_SyouhnTokujou.HTNPBUICD4  , referencedColumnName=BM_HutanpoBui.HTNPBUICD, insertable=false, updatable=false)
    })
    public  BM_HutanpoBui getHutanpoBui4() {
        return bM_HutanpoBui4;
    }

    public void setHutanpoBui4(BM_HutanpoBui pBM_HutanpoBui) {
        this.bM_HutanpoBui4 = pBM_HutanpoBui;
    }

}

