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
import yuyu.def.db.mapping.GenIT_HokenSyouken;

import com.google.common.collect.Lists;


/**
 * 保険証券テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HokenSyouken} の JavaDoc を参照してください。<br />
 * @see     GenIT_HokenSyouken<br />
 * @see     PKIT_HokenSyouken<br />
 * @see     QIT_HokenSyouken<br />
 * @see     GenQIT_HokenSyouken<br />
 */
@Entity
public class IT_HokenSyouken extends GenIT_HokenSyouken {

    private static final long serialVersionUID = 1L;

    public IT_HokenSyouken() {
    }

    public IT_HokenSyouken(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_HokenSyouken(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_HokenSyouken.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_HokenSyouken.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

    private List<IT_HokenSyoukenHukaInfo> iT_HokenSyoukenHukaInfos = Lists.newLinkedList();
    public IT_HokenSyoukenHukaInfo createHokenSyoukenHukaInfo() {
        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo =  new IT_HokenSyoukenHukaInfo();
        hokenSyoukenHukaInfo.setHokenSyouken(this);
        hokenSyoukenHukaInfo.setKbnkey(this.getKbnkey());
        hokenSyoukenHukaInfo.setSyono(this.getSyono());
        hokenSyoukenHukaInfo.setTyouhyouymd(this.getTyouhyouymd());
        setHokenSyoukenHukaInfo(hokenSyoukenHukaInfo);
        return hokenSyoukenHukaInfo;
    }
    @Transient
    public  IT_HokenSyoukenHukaInfo getHokenSyoukenHukaInfo() {
        if(getHokenSyoukenHukaInfos().size() == 0) {
            return null;
        }
        return getHokenSyoukenHukaInfos().get(0);
    }
    @Transient
    public void setHokenSyoukenHukaInfo(IT_HokenSyoukenHukaInfo pIT_HokenSyoukenHukaInfo) {
        if(this.getHokenSyoukenHukaInfos().size() >0){
            this.getHokenSyoukenHukaInfos().set(0, pIT_HokenSyoukenHukaInfo) ;
        }else{
            this.getHokenSyoukenHukaInfos().add(pIT_HokenSyoukenHukaInfo) ;
        }
    }
    public void setHokenSyoukenHukaInfos(List<IT_HokenSyoukenHukaInfo> pIT_HokenSyoukenHukaInfos) {
        this.iT_HokenSyoukenHukaInfos = pIT_HokenSyoukenHukaInfos;
    }
    @OneToMany (
        mappedBy = "hokenSyouken",
        cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REMOVE },
        orphanRemoval = true
        )
    @OrderBy(IT_HokenSyoukenHukaInfo.SYONO+" ASC ,"+IT_HokenSyoukenHukaInfo.TYOUHYOUYMD+" ASC ")
    public  List<IT_HokenSyoukenHukaInfo> getHokenSyoukenHukaInfos() {
        return iT_HokenSyoukenHukaInfos;
    }

}

