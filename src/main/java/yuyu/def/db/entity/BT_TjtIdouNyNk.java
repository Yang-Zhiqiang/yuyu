package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.db.mapping.GenBT_TjtIdouNyNk;

import com.google.common.collect.Lists;


/**
 * 当日異動内容年金支払テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_TjtIdouNyNk} の JavaDoc を参照してください。<br />
 * @see     GenBT_TjtIdouNyNk<br />
 * @see     PKBT_TjtIdouNyNk<br />
 * @see     QBT_TjtIdouNyNk<br />
 * @see     GenQBT_TjtIdouNyNk<br />
 */
@Entity
public class BT_TjtIdouNyNk extends GenBT_TjtIdouNyNk {

    private static final long serialVersionUID = 1L;

    public BT_TjtIdouNyNk() {
    }

    public BT_TjtIdouNyNk(String pNksysyno,Integer pRenno3keta) {
        super(pNksysyno,pRenno3keta);
    }



    private List<BT_IdouNkMeigi> bT_IdouNkMeigis = Lists.newLinkedList();
    public BT_IdouNkMeigi createIdouNkMeigi() {
        BT_IdouNkMeigi idouNkMeigi =  new BT_IdouNkMeigi();
        idouNkMeigi.setTjtIdouNyNk(this);
        idouNkMeigi.setNksysyno(this.getNksysyno());
        idouNkMeigi.setRenno3keta(this.getRenno3keta());
        setIdouNkMeigi(idouNkMeigi);
        return idouNkMeigi;
    }
    @Transient
    public  BT_IdouNkMeigi getIdouNkMeigi() {
        requiredEntities(getIdouNkMeigis(),BT_IdouNkMeigi.class);
        if(getIdouNkMeigis().size() == 0) {
            return null;
        }
        return getIdouNkMeigis().get(0);
    }
    @Transient
    public void setIdouNkMeigi(BT_IdouNkMeigi pBT_IdouNkMeigi) {
        if(this.getIdouNkMeigis().size() >0){
            this.getIdouNkMeigis().set(0, pBT_IdouNkMeigi) ;
        }else{
            this.getIdouNkMeigis().add(pBT_IdouNkMeigi) ;
        }
    }
    public void setIdouNkMeigis(List<BT_IdouNkMeigi> pBT_IdouNkMeigis) {
        this.bT_IdouNkMeigis = pBT_IdouNkMeigis;
    }
    @OneToMany (
        mappedBy = "tjtIdouNyNk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_IdouNkMeigi.NKSYSYNO+" ASC ,"+BT_IdouNkMeigi.RENNO3KETA+" ASC ")
    public  List<BT_IdouNkMeigi> getIdouNkMeigis() {
        return bT_IdouNkMeigis;
    }

    private List<BT_IdouNkBosyuudr> bT_IdouNkBosyuudrs = Lists.newLinkedList();
    public BT_IdouNkBosyuudr createIdouNkBosyuudr() {
        BT_IdouNkBosyuudr idouNkBosyuudr =  new BT_IdouNkBosyuudr();
        idouNkBosyuudr.setTjtIdouNyNk(this);
        idouNkBosyuudr.setNksysyno(this.getNksysyno());
        idouNkBosyuudr.setRenno3keta(this.getRenno3keta());
        setIdouNkBosyuudr(idouNkBosyuudr);
        return idouNkBosyuudr;
    }
    @Transient
    public  BT_IdouNkBosyuudr getIdouNkBosyuudr() {
        requiredEntities(getIdouNkBosyuudrs(),BT_IdouNkBosyuudr.class);
        if(getIdouNkBosyuudrs().size() == 0) {
            return null;
        }
        return getIdouNkBosyuudrs().get(0);
    }
    @Transient
    public void setIdouNkBosyuudr(BT_IdouNkBosyuudr pBT_IdouNkBosyuudr) {
        if(this.getIdouNkBosyuudrs().size() >0){
            this.getIdouNkBosyuudrs().set(0, pBT_IdouNkBosyuudr) ;
        }else{
            this.getIdouNkBosyuudrs().add(pBT_IdouNkBosyuudr) ;
        }
    }
    public void setIdouNkBosyuudrs(List<BT_IdouNkBosyuudr> pBT_IdouNkBosyuudrs) {
        this.bT_IdouNkBosyuudrs = pBT_IdouNkBosyuudrs;
    }
    @OneToMany (
        mappedBy = "tjtIdouNyNk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_IdouNkBosyuudr.NKSYSYNO+" ASC ,"+BT_IdouNkBosyuudr.RENNO3KETA+" ASC ")
    public  List<BT_IdouNkBosyuudr> getIdouNkBosyuudrs() {
        return bT_IdouNkBosyuudrs;
    }

}

