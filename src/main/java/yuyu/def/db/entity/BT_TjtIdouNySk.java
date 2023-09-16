package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.db.mapping.GenBT_TjtIdouNySk;

import com.google.common.collect.Lists;


/**
 * 当日異動内容新契約テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_TjtIdouNySk} の JavaDoc を参照してください。<br />
 * @see     GenBT_TjtIdouNySk<br />
 * @see     PKBT_TjtIdouNySk<br />
 * @see     QBT_TjtIdouNySk<br />
 * @see     GenQBT_TjtIdouNySk<br />
 */
@Entity
public class BT_TjtIdouNySk extends GenBT_TjtIdouNySk {

    private static final long serialVersionUID = 1L;

    public BT_TjtIdouNySk() {
    }

    public BT_TjtIdouNySk(String pMosno,Integer pRenno3keta) {
        super(pMosno,pRenno3keta);
    }



    private List<BT_IdouSkMeigi> bT_IdouSkMeigis = Lists.newLinkedList();
    public BT_IdouSkMeigi createIdouSkMeigi() {
        BT_IdouSkMeigi idouSkMeigi =  new BT_IdouSkMeigi();
        idouSkMeigi.setTjtIdouNySk(this);
        idouSkMeigi.setMosno(this.getMosno());
        idouSkMeigi.setRenno3keta(this.getRenno3keta());
        setIdouSkMeigi(idouSkMeigi);
        return idouSkMeigi;
    }
    @Transient
    public  BT_IdouSkMeigi getIdouSkMeigi() {
        requiredEntities(getIdouSkMeigis(),BT_IdouSkMeigi.class);
        if(getIdouSkMeigis().size() == 0) {
            return null;
        }
        return getIdouSkMeigis().get(0);
    }
    @Transient
    public void setIdouSkMeigi(BT_IdouSkMeigi pBT_IdouSkMeigi) {
        if(this.getIdouSkMeigis().size() >0){
            this.getIdouSkMeigis().set(0, pBT_IdouSkMeigi) ;
        }else{
            this.getIdouSkMeigis().add(pBT_IdouSkMeigi) ;
        }
    }
    public void setIdouSkMeigis(List<BT_IdouSkMeigi> pBT_IdouSkMeigis) {
        this.bT_IdouSkMeigis = pBT_IdouSkMeigis;
    }
    @OneToMany (
        mappedBy = "tjtIdouNySk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_IdouSkMeigi.MOSNO+" ASC ,"+BT_IdouSkMeigi.RENNO3KETA+" ASC ")
    public  List<BT_IdouSkMeigi> getIdouSkMeigis() {
        return bT_IdouSkMeigis;
    }

    private List<BT_IdouSkBosyuudr> bT_IdouSkBosyuudrs = Lists.newLinkedList();
    public BT_IdouSkBosyuudr createIdouSkBosyuudr() {
        BT_IdouSkBosyuudr idouSkBosyuudr =  new BT_IdouSkBosyuudr();
        idouSkBosyuudr.setTjtIdouNySk(this);
        idouSkBosyuudr.setMosno(this.getMosno());
        idouSkBosyuudr.setRenno3keta(this.getRenno3keta());
        setIdouSkBosyuudr(idouSkBosyuudr);
        return idouSkBosyuudr;
    }
    @Transient
    public  BT_IdouSkBosyuudr getIdouSkBosyuudr() {
        requiredEntities(getIdouSkBosyuudrs(),BT_IdouSkBosyuudr.class);
        if(getIdouSkBosyuudrs().size() == 0) {
            return null;
        }
        return getIdouSkBosyuudrs().get(0);
    }
    @Transient
    public void setIdouSkBosyuudr(BT_IdouSkBosyuudr pBT_IdouSkBosyuudr) {
        if(this.getIdouSkBosyuudrs().size() >0){
            this.getIdouSkBosyuudrs().set(0, pBT_IdouSkBosyuudr) ;
        }else{
            this.getIdouSkBosyuudrs().add(pBT_IdouSkBosyuudr) ;
        }
    }
    public void setIdouSkBosyuudrs(List<BT_IdouSkBosyuudr> pBT_IdouSkBosyuudrs) {
        this.bT_IdouSkBosyuudrs = pBT_IdouSkBosyuudrs;
    }
    @OneToMany (
        mappedBy = "tjtIdouNySk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_IdouSkBosyuudr.MOSNO+" ASC ,"+BT_IdouSkBosyuudr.RENNO3KETA+" ASC ")
    public  List<BT_IdouSkBosyuudr> getIdouSkBosyuudrs() {
        return bT_IdouSkBosyuudrs;
    }

}

