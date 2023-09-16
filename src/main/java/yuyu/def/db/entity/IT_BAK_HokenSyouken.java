package yuyu.def.db.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_HokenSyouken;

import com.google.common.collect.Lists;


/**
 * 保険証券バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_HokenSyouken} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_HokenSyouken<br />
 * @see     PKIT_BAK_HokenSyouken<br />
 * @see     QIT_BAK_HokenSyouken<br />
 * @see     GenQIT_BAK_HokenSyouken<br />
 */
@Entity
public class IT_BAK_HokenSyouken extends GenIT_BAK_HokenSyouken {

    private static final long serialVersionUID = 1L;

    public IT_BAK_HokenSyouken() {
    }

    public IT_BAK_HokenSyouken(String pKbnkey,String pSyono,String pTrkssikibetukey,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pTyouhyouymd);
    }

    public IT_BAK_HokenSyouken(String pSyono,String pTrkssikibetukey,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pTyouhyouymd);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_HokenSyouken.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HokenSyouken.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HokenSyouken.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

    private List<IT_BAK_HokenSyoukenHukaInfo> iT_BAKHokenSyoukenHukaInfos = Lists.newLinkedList();
    public IT_BAK_HokenSyoukenHukaInfo createBAKHokenSyoukenHukaInfo() {
        IT_BAK_HokenSyoukenHukaInfo bAKHokenSyoukenHukaInfo =  new IT_BAK_HokenSyoukenHukaInfo();
        bAKHokenSyoukenHukaInfo.setBAKHokenSyouken(this);
        bAKHokenSyoukenHukaInfo.setKbnkey(this.getKbnkey());
        bAKHokenSyoukenHukaInfo.setSyono(this.getSyono());
        bAKHokenSyoukenHukaInfo.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKHokenSyoukenHukaInfo.setTyouhyouymd(this.getTyouhyouymd());
        setBAKHokenSyoukenHukaInfo(bAKHokenSyoukenHukaInfo);
        return bAKHokenSyoukenHukaInfo;
    }
    @Transient
    public  IT_BAK_HokenSyoukenHukaInfo getBAKHokenSyoukenHukaInfo() {
        if(getBAKHokenSyoukenHukaInfos().size() == 0) {
            return null;
        }
        return getBAKHokenSyoukenHukaInfos().get(0);
    }
    @Transient
    public void setBAKHokenSyoukenHukaInfo(IT_BAK_HokenSyoukenHukaInfo pIT_BAK_HokenSyoukenHukaInfo) {
        if(this.getBAKHokenSyoukenHukaInfos().size() >0){
            this.getBAKHokenSyoukenHukaInfos().set(0, pIT_BAK_HokenSyoukenHukaInfo) ;
        }else{
            this.getBAKHokenSyoukenHukaInfos().add(pIT_BAK_HokenSyoukenHukaInfo) ;
        }
    }
    public void setBAKHokenSyoukenHukaInfos(List<IT_BAK_HokenSyoukenHukaInfo> pIT_BAK_HokenSyoukenHukaInfos) {
        this.iT_BAKHokenSyoukenHukaInfos = pIT_BAK_HokenSyoukenHukaInfos;
    }
    @OneToMany (
        mappedBy = "BAKHokenSyouken",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_HokenSyoukenHukaInfo.SYONO+" ASC ,"+IT_BAK_HokenSyoukenHukaInfo.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_HokenSyoukenHukaInfo.TYOUHYOUYMD+" ASC ")
    public  List<IT_BAK_HokenSyoukenHukaInfo> getBAKHokenSyoukenHukaInfos() {
        return iT_BAKHokenSyoukenHukaInfos;
    }

}

