package yuyu.def.db.entity;

import java.util.ArrayList;
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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.mapping.GenIT_KhTtdkRireki;
import yuyu.def.hozen.predicate.FilterKhShrRirekiByShrsyoriymdDenrenno;
import yuyu.def.hozen.predicate.FilterKykSyouhnRirekiByKouryokuhasseiymdGt;
import yuyu.def.hozen.predicate.FilterKykSyouhnRirekiBySyouhncdSyouhnsdno;
import yuyu.def.hozen.predicate.FilterKykSyouhnRirekiBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno;
import yuyu.def.hozen.predicate.FilterKykSyouhnRirekiByYuukousyoumetukbnSyutkkbn;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * 契約保全手続履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhTtdkRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhTtdkRireki<br />
 * @see     PKIT_KhTtdkRireki<br />
 * @see     QIT_KhTtdkRireki<br />
 * @see     GenQIT_KhTtdkRireki<br />
 */
@Entity
public class IT_KhTtdkRireki extends GenIT_KhTtdkRireki {

    private static final long serialVersionUID = 1L;

    public IT_KhTtdkRireki() {
    }

    public IT_KhTtdkRireki(String pKbnkey,String pSyono,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pHenkousikibetukey);
    }

    public IT_KhTtdkRireki(String pSyono,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KhTtdkRireki.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhTtdkRireki.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

    private List<IT_KhShrRireki> iT_KhShrRirekis = Lists.newLinkedList();
    public IT_KhShrRireki createKhShrRireki() {
        IT_KhShrRireki khShrRireki =  new IT_KhShrRireki();
        khShrRireki.setKhTtdkRireki(this);
        khShrRireki.setKbnkey(this.getKbnkey());
        khShrRireki.setSyono(this.getSyono());
        khShrRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        setKhShrRireki(khShrRireki);
        return khShrRireki;
    }
    @Transient
    public  IT_KhShrRireki getKhShrRireki() {
        if(getKhShrRirekis().size() == 0) {
            return null;
        }
        return getKhShrRirekis().get(0);
    }
    @Transient
    public void setKhShrRireki(IT_KhShrRireki pIT_KhShrRireki) {
        if(this.getKhShrRirekis().size() >0){
            this.getKhShrRirekis().set(0, pIT_KhShrRireki) ;
        }else{
            this.getKhShrRirekis().add(pIT_KhShrRireki) ;
        }
    }
    public void setKhShrRirekis(List<IT_KhShrRireki> pIT_KhShrRirekis) {
        this.iT_KhShrRirekis = pIT_KhShrRirekis;
    }
    @OneToMany (
        mappedBy = "khTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhShrRireki.SYONO+" ASC ,"+IT_KhShrRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_KhShrRireki> getKhShrRirekis() {
        return iT_KhShrRirekis;
    }

    private List<IT_KhHenkouRireki> iT_KhHenkouRirekis = Lists.newLinkedList();
    public IT_KhHenkouRireki createKhHenkouRireki() {
        IT_KhHenkouRireki khHenkouRireki =  new IT_KhHenkouRireki();
        khHenkouRireki.setKhTtdkRireki(this);
        khHenkouRireki.setKbnkey(this.getKbnkey());
        khHenkouRireki.setSyono(this.getSyono());
        khHenkouRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getKhHenkouRirekis().add(khHenkouRireki);
        return khHenkouRireki;
    }
    public void setKhHenkouRirekis(List<IT_KhHenkouRireki> pIT_KhHenkouRirekis) {
        this.iT_KhHenkouRirekis = pIT_KhHenkouRirekis;
    }
    @OneToMany (
        mappedBy = "khTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhHenkouRireki.SYONO+" ASC ,"+IT_KhHenkouRireki.HENKOUSIKIBETUKEY+" ASC ,"+IT_KhHenkouRireki.RENNO3KETA+" ASC ")
    public  List<IT_KhHenkouRireki> getKhHenkouRirekis() {
        return iT_KhHenkouRirekis;
    }

    private List<IT_KykSyouhnRireki> iT_KykSyouhnRirekis = Lists.newLinkedList();
    public IT_KykSyouhnRireki createKykSyouhnRireki() {
        IT_KykSyouhnRireki kykSyouhnRireki =  new IT_KykSyouhnRireki();
        kykSyouhnRireki.setKhTtdkRireki(this);
        kykSyouhnRireki.setKbnkey(this.getKbnkey());
        kykSyouhnRireki.setSyono(this.getSyono());
        kykSyouhnRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getKykSyouhnRirekis().add(kykSyouhnRireki);
        return kykSyouhnRireki;
    }
    public void setKykSyouhnRirekis(List<IT_KykSyouhnRireki> pIT_KykSyouhnRirekis) {
        this.iT_KykSyouhnRirekis = pIT_KykSyouhnRirekis;
    }
    @OneToMany (
        mappedBy = "khTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KykSyouhnRireki.SYONO+" ASC ,"+IT_KykSyouhnRireki.SYUTKKBN+" ASC ,"+IT_KykSyouhnRireki.SYOUHNCD+" ASC ,"+IT_KykSyouhnRireki.SYOUHNSDNO+" ASC ,"+IT_KykSyouhnRireki.KYKSYOUHNRENNO+" ASC ,"+IT_KykSyouhnRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_KykSyouhnRireki> getKykSyouhnRirekis() {
        return iT_KykSyouhnRirekis;
    }

    private List<IT_SyouhnTokujouRireki> iT_SyouhnTokujouRirekis = Lists.newLinkedList();
    public IT_SyouhnTokujouRireki createSyouhnTokujouRireki() {
        IT_SyouhnTokujouRireki syouhnTokujouRireki =  new IT_SyouhnTokujouRireki();
        syouhnTokujouRireki.setKhTtdkRireki(this);
        syouhnTokujouRireki.setKbnkey(this.getKbnkey());
        syouhnTokujouRireki.setSyono(this.getSyono());
        syouhnTokujouRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getSyouhnTokujouRirekis().add(syouhnTokujouRireki);
        return syouhnTokujouRireki;
    }
    public void setSyouhnTokujouRirekis(List<IT_SyouhnTokujouRireki> pIT_SyouhnTokujouRirekis) {
        this.iT_SyouhnTokujouRirekis = pIT_SyouhnTokujouRirekis;
    }
    @OneToMany (
        mappedBy = "khTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_SyouhnTokujouRireki.SYONO+" ASC ,"+IT_SyouhnTokujouRireki.SYUTKKBN+" ASC ,"+IT_SyouhnTokujouRireki.SYOUHNCD+" ASC ,"+IT_SyouhnTokujouRireki.SYOUHNSDNO+" ASC ,"+IT_SyouhnTokujouRireki.KYKSYOUHNRENNO+" ASC ,"+IT_SyouhnTokujouRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_SyouhnTokujouRireki> getSyouhnTokujouRirekis() {
        return iT_SyouhnTokujouRirekis;
    }

    private List<IT_HengakuUnitRireki> iT_HengakuUnitRirekis = Lists.newLinkedList();
    public IT_HengakuUnitRireki createHengakuUnitRireki() {
        IT_HengakuUnitRireki hengakuUnitRireki =  new IT_HengakuUnitRireki();
        hengakuUnitRireki.setKhTtdkRireki(this);
        hengakuUnitRireki.setKbnkey(this.getKbnkey());
        hengakuUnitRireki.setSyono(this.getSyono());
        hengakuUnitRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getHengakuUnitRirekis().add(hengakuUnitRireki);
        return hengakuUnitRireki;
    }
    public void setHengakuUnitRirekis(List<IT_HengakuUnitRireki> pIT_HengakuUnitRirekis) {
        this.iT_HengakuUnitRirekis = pIT_HengakuUnitRirekis;
    }
    @OneToMany (
        mappedBy = "khTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_HengakuUnitRireki.SYONO+" ASC ,"+IT_HengakuUnitRireki.UNITFUNDKBN+" ASC ,"+IT_HengakuUnitRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_HengakuUnitRireki> getHengakuUnitRirekis() {
        return iT_HengakuUnitRirekis;
    }

    private AS_Kinou aS_Kinou ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=IT_KhTtdkRireki.GYOUMUKOUSINKINOU  , referencedColumnName=AS_Kinou.KINOUID, insertable=false, updatable=false)
    })
    public  AS_Kinou getKinou() {
        return aS_Kinou;
    }

    public void setKinou(AS_Kinou pAS_Kinou) {
        this.aS_Kinou = pAS_Kinou;
    }

    private AM_User aM_User ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=IT_KhTtdkRireki.GYOUMUKOUSINSYAID  , referencedColumnName=AM_User.USERID, insertable=false, updatable=false)
    })
    public  AM_User getUser() {
        return aM_User;
    }

    public void setUser(AM_User pAM_User) {
        this.aM_User = pAM_User;
    }

    private List<IT_HengakuCf> iT_HengakuCfs = Lists.newLinkedList();
    public IT_HengakuCf createHengakuCf() {
        IT_HengakuCf hengakuCf =  new IT_HengakuCf();
        hengakuCf.setKhTtdkRireki(this);
        hengakuCf.setKbnkey(this.getKbnkey());
        hengakuCf.setSyono(this.getSyono());
        hengakuCf.setHenkousikibetukey(this.getHenkousikibetukey());
        getHengakuCfs().add(hengakuCf);
        return hengakuCf;
    }
    public void setHengakuCfs(List<IT_HengakuCf> pIT_HengakuCfs) {
        this.iT_HengakuCfs = pIT_HengakuCfs;
    }
    @OneToMany (
        mappedBy = "khTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_HengakuCf.SYONO+" ASC ,"+IT_HengakuCf.HENKOUSIKIBETUKEY+" ASC ,"+IT_HengakuCf.UNITFUNDKBN+" ASC ,"+IT_HengakuCf.SYORIYMD+" ASC ,"+IT_HengakuCf.RENNO+" ASC ")
    public  List<IT_HengakuCf> getHengakuCfs() {
        return iT_HengakuCfs;
    }

    private List<IT_KykSyaHenkouRireki> iT_KykSyaHenkouRirekis = Lists.newLinkedList();
    public IT_KykSyaHenkouRireki createKykSyaHenkouRireki() {
        IT_KykSyaHenkouRireki kykSyaHenkouRireki =  new IT_KykSyaHenkouRireki();
        kykSyaHenkouRireki.setKhTtdkRireki(this);
        kykSyaHenkouRireki.setKbnkey(this.getKbnkey());
        kykSyaHenkouRireki.setSyono(this.getSyono());
        kykSyaHenkouRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getKykSyaHenkouRirekis().add(kykSyaHenkouRireki);
        return kykSyaHenkouRireki;
    }
    public void setKykSyaHenkouRirekis(List<IT_KykSyaHenkouRireki> pIT_KykSyaHenkouRirekis) {
        this.iT_KykSyaHenkouRirekis = pIT_KykSyaHenkouRirekis;
    }
    @OneToMany (
        mappedBy = "khTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KykSyaHenkouRireki.SYONO+" ASC ,"+IT_KykSyaHenkouRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_KykSyaHenkouRireki> getKykSyaHenkouRirekis() {
        return iT_KykSyaHenkouRirekis;
    }

    private List<IT_KhHasseijiKazeiRireki> iT_KhHasseijiKazeiRirekiss = Lists.newLinkedList();
    public IT_KhHasseijiKazeiRireki createKhHasseijiKazeiRireki() {
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki =  new IT_KhHasseijiKazeiRireki();
        khHasseijiKazeiRireki.setKhTtdkRireki(this);
        khHasseijiKazeiRireki.setKbnkey(this.getKbnkey());
        khHasseijiKazeiRireki.setSyono(this.getSyono());
        khHasseijiKazeiRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        setKhHasseijiKazeiRireki(khHasseijiKazeiRireki);
        return khHasseijiKazeiRireki;
    }
    @Transient
    public  IT_KhHasseijiKazeiRireki getKhHasseijiKazeiRireki() {
        if(getKhHasseijiKazeiRirekis().size() == 0) {
            return null;
        }
        return getKhHasseijiKazeiRirekis().get(0);
    }
    @Transient
    public void setKhHasseijiKazeiRireki(IT_KhHasseijiKazeiRireki pIT_KhHasseijiKazeiRireki) {
        if(this.getKhHasseijiKazeiRirekis().size() >0){
            this.getKhHasseijiKazeiRirekis().set(0, pIT_KhHasseijiKazeiRireki) ;
        }else{
            this.getKhHasseijiKazeiRirekis().add(pIT_KhHasseijiKazeiRireki) ;
        }
    }
    public void setKhHasseijiKazeiRirekis(List<IT_KhHasseijiKazeiRireki> pIT_KhHasseijiKazeiRirekis) {
        this.iT_KhHasseijiKazeiRirekiss = pIT_KhHasseijiKazeiRirekis;
    }
    @OneToMany (
        mappedBy = "khTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhHasseijiKazeiRireki.SYONO+" ASC ,"+IT_KhHasseijiKazeiRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_KhHasseijiKazeiRireki> getKhHasseijiKazeiRirekis() {
        return iT_KhHasseijiKazeiRirekiss;
    }

    private List<IT_SeihowebIdouRireki> iT_SeihowebIdouRirekiss = Lists.newLinkedList();
    public IT_SeihowebIdouRireki createSeihowebIdouRireki() {
        IT_SeihowebIdouRireki seihowebIdouRireki =  new IT_SeihowebIdouRireki();
        seihowebIdouRireki.setKhTtdkRireki(this);
        seihowebIdouRireki.setKbnkey(this.getKbnkey());
        seihowebIdouRireki.setSyono(this.getSyono());
        seihowebIdouRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        setSeihowebIdouRireki(seihowebIdouRireki);
        return seihowebIdouRireki;
    }
    @Transient
    public  IT_SeihowebIdouRireki getSeihowebIdouRireki() {
        if(getSeihowebIdouRirekis().size() == 0) {
            return null;
        }
        return getSeihowebIdouRirekis().get(0);
    }
    @Transient
    public void setSeihowebIdouRireki(IT_SeihowebIdouRireki pIT_SeihowebIdouRireki) {
        if(this.getSeihowebIdouRirekis().size() >0){
            this.getSeihowebIdouRirekis().set(0, pIT_SeihowebIdouRireki) ;
        }else{
            this.getSeihowebIdouRirekis().add(pIT_SeihowebIdouRireki) ;
        }
    }
    public void setSeihowebIdouRirekis(List<IT_SeihowebIdouRireki> pIT_SeihowebIdouRirekis) {
        this.iT_SeihowebIdouRirekiss = pIT_SeihowebIdouRirekis;
    }
    @OneToMany (
        mappedBy = "khTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_SeihowebIdouRireki.SYONO+" ASC ,"+IT_SeihowebIdouRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_SeihowebIdouRireki> getSeihowebIdouRirekis() {
        return iT_SeihowebIdouRirekiss;
    }

    private List<IT_HokenKykIdouRireki> iT_HokenKykIdouRirekis = Lists.newLinkedList();
    public IT_HokenKykIdouRireki createHokenKykIdouRireki() {
        IT_HokenKykIdouRireki hokenKykIdouRireki =  new IT_HokenKykIdouRireki();
        hokenKykIdouRireki.setKhTtdkRireki(this);
        hokenKykIdouRireki.setKbnkey(this.getKbnkey());
        hokenKykIdouRireki.setSyono(this.getSyono());
        hokenKykIdouRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getHokenKykIdouRirekis().add(hokenKykIdouRireki);
        return hokenKykIdouRireki;
    }
    public void setHokenKykIdouRirekis(List<IT_HokenKykIdouRireki> pIT_HokenKykIdouRirekis) {
        this.iT_HokenKykIdouRirekis = pIT_HokenKykIdouRirekis;
    }
    @OneToMany (
        mappedBy = "khTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_HokenKykIdouRireki.SYONO+" ASC ,"+IT_HokenKykIdouRireki.HENKOUSIKIBETUKEY+" ASC ,"+IT_HokenKykIdouRireki.ZOUGENKBN+" ASC ")
    public  List<IT_HokenKykIdouRireki> getHokenKykIdouRirekis() {
        return iT_HokenKykIdouRirekis;
    }

    @Transient
    public  IT_KhShrRireki getKhShrRirekiByShrsyoriymdDenrenno(BizDate pShrsyoriymd,String pDenrenno) {
        return Iterables.getFirst(Iterables.filter(getKhShrRirekis(),
            new FilterKhShrRirekiByShrsyoriymdDenrenno(pShrsyoriymd, pDenrenno)),null);
    }
    @Transient
    public  List<IT_KykSyouhnRireki> getKykSyouhnRirekisByYuukousyoumetukbnSyutkkbn(C_YuukousyoumetuKbn pYuukousyoumetukbn,C_SyutkKbn pSyutkkbn) {
        return new ArrayList<IT_KykSyouhnRireki>(Collections2.filter(getKykSyouhnRirekis(),
            new FilterKykSyouhnRirekiByYuukousyoumetukbnSyutkkbn(pYuukousyoumetukbn, pSyutkkbn)));
    }
    @Transient
    public  List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyouhncdSyouhnsdno(String pSyouhncd,Integer pSyouhnsdno) {
        return new ArrayList<IT_KykSyouhnRireki>(Collections2.filter(getKykSyouhnRirekis(),
            new FilterKykSyouhnRirekiBySyouhncdSyouhnsdno(pSyouhncd, pSyouhnsdno)));
    }
    @Transient
    public  List<IT_KykSyouhnRireki> getKykSyouhnRirekisByKouryokuhasseiymdGt(BizDate pKouryokuhasseiymd) {
        return new ArrayList<IT_KykSyouhnRireki>(Collections2.filter(getKykSyouhnRirekis(),
            new FilterKykSyouhnRirekiByKouryokuhasseiymdGt(pKouryokuhasseiymd)));
    }
    @Transient
    public  IT_KykSyouhnRireki getKykSyouhnRirekiBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        return Iterables.getFirst(Iterables.filter(getKykSyouhnRirekis(),
            new FilterKykSyouhnRirekiBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(pSyutkkbn, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno)), null);
    }
}

