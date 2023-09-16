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
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KhTtdkRireki;

import com.google.common.collect.Lists;


/**
 * 契約保全手続履歴バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhTtdkRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhTtdkRireki<br />
 * @see     PKIT_BAK_KhTtdkRireki<br />
 * @see     QIT_BAK_KhTtdkRireki<br />
 * @see     GenQIT_BAK_KhTtdkRireki<br />
 */
@Entity
public class IT_BAK_KhTtdkRireki extends GenIT_BAK_KhTtdkRireki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhTtdkRireki() {
    }

    public IT_BAK_KhTtdkRireki(String pKbnkey,String pSyono,String pTrkssikibetukey,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHenkousikibetukey);
    }

    public IT_BAK_KhTtdkRireki(String pSyono,String pTrkssikibetukey,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHenkousikibetukey);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KhTtdkRireki.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhTtdkRireki.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhTtdkRireki.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

    private List<IT_BAK_KhShrRireki> iT_BAKKhShrRirekis = Lists.newLinkedList();
    public IT_BAK_KhShrRireki createBAKKhShrRireki() {
        IT_BAK_KhShrRireki bAKKhShrRireki =  new IT_BAK_KhShrRireki();
        bAKKhShrRireki.setBAKKhTtdkRireki(this);
        bAKKhShrRireki.setKbnkey(this.getKbnkey());
        bAKKhShrRireki.setSyono(this.getSyono());
        bAKKhShrRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKKhShrRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        setBAKKhShrRireki(bAKKhShrRireki);
        return bAKKhShrRireki;
    }
    @Transient
    public  IT_BAK_KhShrRireki getBAKKhShrRireki() {
        if(getBAKKhShrRirekis().size() == 0) {
            return null;
        }
        return getBAKKhShrRirekis().get(0);
    }
    @Transient
    public void setBAKKhShrRireki(IT_BAK_KhShrRireki pIT_BAK_KhShrRireki) {
        if(this.getBAKKhShrRirekis().size() >0){
            this.getBAKKhShrRirekis().set(0, pIT_BAK_KhShrRireki) ;
        }else{
            this.getBAKKhShrRirekis().add(pIT_BAK_KhShrRireki) ;
        }
    }
    public void setBAKKhShrRirekis(List<IT_BAK_KhShrRireki> pIT_BAK_KhShrRirekis) {
        this.iT_BAKKhShrRirekis = pIT_BAK_KhShrRirekis;
    }
    @OneToMany (
        mappedBy = "BAKKhTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhShrRireki.SYONO+" ASC ,"+IT_BAK_KhShrRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KhShrRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_KhShrRireki> getBAKKhShrRirekis() {
        return iT_BAKKhShrRirekis;
    }

    private List<IT_BAK_KhHenkouRireki> iT_BAKKhHenkouRirekis = Lists.newLinkedList();
    public IT_BAK_KhHenkouRireki createBAKKhHenkouRireki() {
        IT_BAK_KhHenkouRireki bAKKhHenkouRireki =  new IT_BAK_KhHenkouRireki();
        bAKKhHenkouRireki.setBAKKhTtdkRireki(this);
        bAKKhHenkouRireki.setKbnkey(this.getKbnkey());
        bAKKhHenkouRireki.setSyono(this.getSyono());
        bAKKhHenkouRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKKhHenkouRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getBAKKhHenkouRirekis().add(bAKKhHenkouRireki);
        return bAKKhHenkouRireki;
    }
    public void setBAKKhHenkouRirekis(List<IT_BAK_KhHenkouRireki> pIT_BAK_KhHenkouRirekis) {
        this.iT_BAKKhHenkouRirekis = pIT_BAK_KhHenkouRirekis;
    }
    @OneToMany (
        mappedBy = "BAKKhTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhHenkouRireki.SYONO+" ASC ,"+IT_BAK_KhHenkouRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KhHenkouRireki.HENKOUSIKIBETUKEY+" ASC ,"+IT_BAK_KhHenkouRireki.RENNO3KETA+" ASC ")
    public  List<IT_BAK_KhHenkouRireki> getBAKKhHenkouRirekis() {
        return iT_BAKKhHenkouRirekis;
    }

    private List<IT_BAK_KykSyouhnRireki> iT_BAKKykSyouhnRirekis = Lists.newLinkedList();
    public IT_BAK_KykSyouhnRireki createBAKKykSyouhnRireki() {
        IT_BAK_KykSyouhnRireki bAKKykSyouhnRireki =  new IT_BAK_KykSyouhnRireki();
        bAKKykSyouhnRireki.setBAKKhTtdkRireki(this);
        bAKKykSyouhnRireki.setKbnkey(this.getKbnkey());
        bAKKykSyouhnRireki.setSyono(this.getSyono());
        bAKKykSyouhnRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKKykSyouhnRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getBAKKykSyouhnRirekis().add(bAKKykSyouhnRireki);
        return bAKKykSyouhnRireki;
    }
    public void setBAKKykSyouhnRirekis(List<IT_BAK_KykSyouhnRireki> pIT_BAK_KykSyouhnRirekis) {
        this.iT_BAKKykSyouhnRirekis = pIT_BAK_KykSyouhnRirekis;
    }
    @OneToMany (
        mappedBy = "BAKKhTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KykSyouhnRireki.SYONO+" ASC ,"+IT_BAK_KykSyouhnRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KykSyouhnRireki.SYUTKKBN+" ASC ,"+IT_BAK_KykSyouhnRireki.SYOUHNCD+" ASC ,"+IT_BAK_KykSyouhnRireki.SYOUHNSDNO+" ASC ,"+IT_BAK_KykSyouhnRireki.KYKSYOUHNRENNO+" ASC ,"+IT_BAK_KykSyouhnRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_KykSyouhnRireki> getBAKKykSyouhnRirekis() {
        return iT_BAKKykSyouhnRirekis;
    }

    private List<IT_BAK_SyouhnTokujouRireki> iT_BAKSyouhnTokujouRirekis = Lists.newLinkedList();
    public IT_BAK_SyouhnTokujouRireki createBAKSyouhnTokujouRireki() {
        IT_BAK_SyouhnTokujouRireki bAKSyouhnTokujouRireki =  new IT_BAK_SyouhnTokujouRireki();
        bAKSyouhnTokujouRireki.setBAKKhTtdkRireki(this);
        bAKSyouhnTokujouRireki.setKbnkey(this.getKbnkey());
        bAKSyouhnTokujouRireki.setSyono(this.getSyono());
        bAKSyouhnTokujouRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKSyouhnTokujouRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getBAKSyouhnTokujouRirekis().add(bAKSyouhnTokujouRireki);
        return bAKSyouhnTokujouRireki;
    }
    public void setBAKSyouhnTokujouRirekis(List<IT_BAK_SyouhnTokujouRireki> pIT_BAK_SyouhnTokujouRirekis) {
        this.iT_BAKSyouhnTokujouRirekis = pIT_BAK_SyouhnTokujouRirekis;
    }
    @OneToMany (
        mappedBy = "BAKKhTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_SyouhnTokujouRireki.SYONO+" ASC ,"+IT_BAK_SyouhnTokujouRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_SyouhnTokujouRireki.SYUTKKBN+" ASC ,"+IT_BAK_SyouhnTokujouRireki.SYOUHNCD+" ASC ,"+IT_BAK_SyouhnTokujouRireki.SYOUHNSDNO+" ASC ,"+IT_BAK_SyouhnTokujouRireki.KYKSYOUHNRENNO+" ASC ,"+IT_BAK_SyouhnTokujouRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_SyouhnTokujouRireki> getBAKSyouhnTokujouRirekis() {
        return iT_BAKSyouhnTokujouRirekis;
    }

    private List<IT_BAK_HengakuUnitRireki> iT_BAKHengakuUnitRirekis = Lists.newLinkedList();
    public IT_BAK_HengakuUnitRireki createBAKHengakuUnitRireki() {
        IT_BAK_HengakuUnitRireki bAKHengakuUnitRireki =  new IT_BAK_HengakuUnitRireki();
        bAKHengakuUnitRireki.setBAKKhTtdkRireki(this);
        bAKHengakuUnitRireki.setKbnkey(this.getKbnkey());
        bAKHengakuUnitRireki.setSyono(this.getSyono());
        bAKHengakuUnitRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKHengakuUnitRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getBAKHengakuUnitRirekis().add(bAKHengakuUnitRireki);
        return bAKHengakuUnitRireki;
    }
    public void setBAKHengakuUnitRirekis(List<IT_BAK_HengakuUnitRireki> pIT_BAK_HengakuUnitRirekis) {
        this.iT_BAKHengakuUnitRirekis = pIT_BAK_HengakuUnitRirekis;
    }
    @OneToMany (
        mappedBy = "BAKKhTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_HengakuUnitRireki.SYONO+" ASC ,"+IT_BAK_HengakuUnitRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_HengakuUnitRireki.UNITFUNDKBN+" ASC ,"+IT_BAK_HengakuUnitRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_HengakuUnitRireki> getBAKHengakuUnitRirekis() {
        return iT_BAKHengakuUnitRirekis;
    }

    private List<IT_BAK_HengakuCf> iT_BAKHengakuCfs = Lists.newLinkedList();
    public IT_BAK_HengakuCf createBAKHengakuCf() {
        IT_BAK_HengakuCf bAKHengakuCf =  new IT_BAK_HengakuCf();
        bAKHengakuCf.setBAKKhTtdkRireki(this);
        bAKHengakuCf.setKbnkey(this.getKbnkey());
        bAKHengakuCf.setSyono(this.getSyono());
        bAKHengakuCf.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKHengakuCf.setHenkousikibetukey(this.getHenkousikibetukey());
        getBAKHengakuCfs().add(bAKHengakuCf);
        return bAKHengakuCf;
    }
    public void setBAKHengakuCfs(List<IT_BAK_HengakuCf> pIT_BAK_HengakuCfs) {
        this.iT_BAKHengakuCfs = pIT_BAK_HengakuCfs;
    }
    @OneToMany (
        mappedBy = "BAKKhTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_HengakuCf.SYONO+" ASC ,"+IT_BAK_HengakuCf.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_HengakuCf.HENKOUSIKIBETUKEY+" ASC ,"+IT_BAK_HengakuCf.UNITFUNDKBN+" ASC ,"+IT_BAK_HengakuCf.SYORIYMD+" ASC ,"+IT_BAK_HengakuCf.RENNO+" ASC ")
    public  List<IT_BAK_HengakuCf> getBAKHengakuCfs() {
        return iT_BAKHengakuCfs;
    }

    private List<IT_BAK_KykSyaHenkouRireki> iT_BAKKykSyaHenkouRirekis = Lists.newLinkedList();
    public IT_BAK_KykSyaHenkouRireki createBAKKykSyaHenkouRireki() {
        IT_BAK_KykSyaHenkouRireki bAKKykSyaHenkouRireki =  new IT_BAK_KykSyaHenkouRireki();
        bAKKykSyaHenkouRireki.setBAKKhTtdkRireki(this);
        bAKKykSyaHenkouRireki.setKbnkey(this.getKbnkey());
        bAKKykSyaHenkouRireki.setSyono(this.getSyono());
        bAKKykSyaHenkouRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKKykSyaHenkouRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getBAKKykSyaHenkouRirekis().add(bAKKykSyaHenkouRireki);
        return bAKKykSyaHenkouRireki;
    }
    public void setBAKKykSyaHenkouRirekis(List<IT_BAK_KykSyaHenkouRireki> pIT_BAK_KykSyaHenkouRirekis) {
        this.iT_BAKKykSyaHenkouRirekis = pIT_BAK_KykSyaHenkouRirekis;
    }
    @OneToMany (
        mappedBy = "BAKKhTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KykSyaHenkouRireki.SYONO+" ASC ,"+IT_BAK_KykSyaHenkouRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KykSyaHenkouRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_KykSyaHenkouRireki> getBAKKykSyaHenkouRirekis() {
        return iT_BAKKykSyaHenkouRirekis;
    }

    private List<IT_BAK_KhHasseijiKazeiRireki> iT_BAKKhHasseijiKazeiRirekis = Lists.newLinkedList();
    public IT_BAK_KhHasseijiKazeiRireki createBAKKhHasseijiKazeiRireki() {
        IT_BAK_KhHasseijiKazeiRireki bAKKhHasseijiKazeiRireki =  new IT_BAK_KhHasseijiKazeiRireki();
        bAKKhHasseijiKazeiRireki.setBAKKhTtdkRireki(this);
        bAKKhHasseijiKazeiRireki.setKbnkey(this.getKbnkey());
        bAKKhHasseijiKazeiRireki.setSyono(this.getSyono());
        bAKKhHasseijiKazeiRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKKhHasseijiKazeiRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        setBAKKhHasseijiKazeiRireki(bAKKhHasseijiKazeiRireki);
        return bAKKhHasseijiKazeiRireki;
    }
    @Transient
    public  IT_BAK_KhHasseijiKazeiRireki getBAKKhHasseijiKazeiRireki() {
        if(getBAKKhHasseijiKazeiRirekis().size() == 0) {
            return null;
        }
        return getBAKKhHasseijiKazeiRirekis().get(0);
    }
    @Transient
    public void setBAKKhHasseijiKazeiRireki(IT_BAK_KhHasseijiKazeiRireki pIT_BAK_KhHasseijiKazeiRireki) {
        if(this.getBAKKhHasseijiKazeiRirekis().size() >0){
            this.getBAKKhHasseijiKazeiRirekis().set(0, pIT_BAK_KhHasseijiKazeiRireki) ;
        }else{
            this.getBAKKhHasseijiKazeiRirekis().add(pIT_BAK_KhHasseijiKazeiRireki) ;
        }
    }
    public void setBAKKhHasseijiKazeiRirekis(List<IT_BAK_KhHasseijiKazeiRireki> pIT_BAK_KhHasseijiKazeiRirekis) {
        this.iT_BAKKhHasseijiKazeiRirekis = pIT_BAK_KhHasseijiKazeiRirekis;
    }
    @OneToMany (
        mappedBy = "BAKKhTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhHasseijiKazeiRireki.SYONO+" ASC ,"+IT_BAK_KhHasseijiKazeiRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KhHasseijiKazeiRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_KhHasseijiKazeiRireki> getBAKKhHasseijiKazeiRirekis() {
        return iT_BAKKhHasseijiKazeiRirekis;
    }

    private List<IT_BAK_SeihowebIdouRireki> iT_BAKSeihowebIdouRirekiss = Lists.newLinkedList();
    public IT_BAK_SeihowebIdouRireki createBAKSeihowebIdouRireki() {
        IT_BAK_SeihowebIdouRireki bAKSeihowebIdouRireki =  new IT_BAK_SeihowebIdouRireki();
        bAKSeihowebIdouRireki.setBAKKhTtdkRireki(this);
        bAKSeihowebIdouRireki.setKbnkey(this.getKbnkey());
        bAKSeihowebIdouRireki.setSyono(this.getSyono());
        bAKSeihowebIdouRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKSeihowebIdouRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        setBAKSeihowebIdouRireki(bAKSeihowebIdouRireki);
        return bAKSeihowebIdouRireki;
    }
    @Transient
    public  IT_BAK_SeihowebIdouRireki getBAKSeihowebIdouRireki() {
        if(getBAKSeihowebIdouRirekis().size() == 0) {
            return null;
        }
        return getBAKSeihowebIdouRirekis().get(0);
    }
    @Transient
    public void setBAKSeihowebIdouRireki(IT_BAK_SeihowebIdouRireki pIT_BAK_SeihowebIdouRireki) {
        if(this.getBAKSeihowebIdouRirekis().size() >0){
            this.getBAKSeihowebIdouRirekis().set(0, pIT_BAK_SeihowebIdouRireki) ;
        }else{
            this.getBAKSeihowebIdouRirekis().add(pIT_BAK_SeihowebIdouRireki) ;
        }
    }
    public void setBAKSeihowebIdouRirekis(List<IT_BAK_SeihowebIdouRireki> pIT_BAK_SeihowebIdouRirekis) {
        this.iT_BAKSeihowebIdouRirekiss = pIT_BAK_SeihowebIdouRirekis;
    }
    @OneToMany (
        mappedBy = "BAKKhTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_SeihowebIdouRireki.SYONO+" ASC ,"+IT_BAK_SeihowebIdouRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_SeihowebIdouRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_SeihowebIdouRireki> getBAKSeihowebIdouRirekis() {
        return iT_BAKSeihowebIdouRirekiss;
    }

    private List<IT_BAK_HokenKykIdouRireki> iT_BAKHokenKykIdouRirekis = Lists.newLinkedList();
    public IT_BAK_HokenKykIdouRireki createBAKHokenKykIdouRireki() {
        IT_BAK_HokenKykIdouRireki bAKHokenKykIdouRireki =  new IT_BAK_HokenKykIdouRireki();
        bAKHokenKykIdouRireki.setBAKKhTtdkRireki(this);
        bAKHokenKykIdouRireki.setKbnkey(this.getKbnkey());
        bAKHokenKykIdouRireki.setSyono(this.getSyono());
        bAKHokenKykIdouRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKHokenKykIdouRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getBAKHokenKykIdouRirekis().add(bAKHokenKykIdouRireki);
        return bAKHokenKykIdouRireki;
    }
    public void setBAKHokenKykIdouRirekis(List<IT_BAK_HokenKykIdouRireki> pIT_BAK_HokenKykIdouRirekis) {
        this.iT_BAKHokenKykIdouRirekis = pIT_BAK_HokenKykIdouRirekis;
    }
    @OneToMany (
        mappedBy = "BAKKhTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_HokenKykIdouRireki.SYONO+" ASC ,"+IT_BAK_HokenKykIdouRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_HokenKykIdouRireki.HENKOUSIKIBETUKEY+" ASC ,"+IT_BAK_HokenKykIdouRireki.ZOUGENKBN+" ASC ")
    public  List<IT_BAK_HokenKykIdouRireki> getBAKHokenKykIdouRirekis() {
        return iT_BAKHokenKykIdouRirekis;
    }

}

