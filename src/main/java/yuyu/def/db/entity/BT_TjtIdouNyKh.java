package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.db.mapping.GenBT_TjtIdouNyKh;

import com.google.common.collect.Lists;

/**
 * 当日異動内容契約保全テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_TjtIdouNyKh} の JavaDoc を参照してください。<br />
 * @see     GenBT_TjtIdouNyKh<br />
 * @see     PKBT_TjtIdouNyKh<br />
 * @see     QBT_TjtIdouNyKh<br />
 * @see     GenQBT_TjtIdouNyKh<br />
 */
@Entity
public class BT_TjtIdouNyKh extends GenBT_TjtIdouNyKh {

    private static final long serialVersionUID = 1L;

    public BT_TjtIdouNyKh() {
    }

    public BT_TjtIdouNyKh(String pSyono,Integer pRenno3keta) {
        super(pSyono,pRenno3keta);
    }



    private List<BT_IdouKhMeigi> bT_IdouKhMeigis = Lists.newLinkedList();
    public BT_IdouKhMeigi createIdouKhMeigi() {
        BT_IdouKhMeigi idouKhMeigi =  new BT_IdouKhMeigi();
        idouKhMeigi.setTjtIdouNyKh(this);
        idouKhMeigi.setSyono(this.getSyono());
        idouKhMeigi.setRenno3keta(this.getRenno3keta());
        setIdouKhMeigi(idouKhMeigi);
        return idouKhMeigi;
    }
    @Transient
    public  BT_IdouKhMeigi getIdouKhMeigi() {
        requiredEntities(getIdouKhMeigis(),BT_IdouKhMeigi.class);
        if(getIdouKhMeigis().size() == 0) {
            return null;
        }
        return getIdouKhMeigis().get(0);
    }
    @Transient
    public void setIdouKhMeigi(BT_IdouKhMeigi pBT_IdouKhMeigi) {
        if(this.getIdouKhMeigis().size() >0){
            this.getIdouKhMeigis().set(0, pBT_IdouKhMeigi) ;
        }else{
            this.getIdouKhMeigis().add(pBT_IdouKhMeigi) ;
        }
    }
    public void setIdouKhMeigis(List<BT_IdouKhMeigi> pBT_IdouKhMeigis) {
        this.bT_IdouKhMeigis = pBT_IdouKhMeigis;
    }
    @OneToMany (
        mappedBy = "tjtIdouNyKh",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_IdouKhMeigi.SYONO+" ASC ,"+BT_IdouKhMeigi.RENNO3KETA+" ASC ")
    public  List<BT_IdouKhMeigi> getIdouKhMeigis() {
        return bT_IdouKhMeigis;
    }

    private List<BT_IdouKhBosyuudr> bT_IdouKhBosyuudrs = Lists.newLinkedList();
    public BT_IdouKhBosyuudr createIdouKhBosyuudr() {
        BT_IdouKhBosyuudr idouKhBosyuudr =  new BT_IdouKhBosyuudr();
        idouKhBosyuudr.setTjtIdouNyKh(this);
        idouKhBosyuudr.setSyono(this.getSyono());
        idouKhBosyuudr.setRenno3keta(this.getRenno3keta());
        setIdouKhBosyuudr(idouKhBosyuudr);
        return idouKhBosyuudr;
    }
    @Transient
    public  BT_IdouKhBosyuudr getIdouKhBosyuudr() {
        requiredEntities(getIdouKhBosyuudrs(),BT_IdouKhBosyuudr.class);
        if(getIdouKhBosyuudrs().size() == 0) {
            return null;
        }
        return getIdouKhBosyuudrs().get(0);
    }
    @Transient
    public void setIdouKhBosyuudr(BT_IdouKhBosyuudr pBT_IdouKhBosyuudr) {
        if(this.getIdouKhBosyuudrs().size() >0){
            this.getIdouKhBosyuudrs().set(0, pBT_IdouKhBosyuudr) ;
        }else{
            this.getIdouKhBosyuudrs().add(pBT_IdouKhBosyuudr) ;
        }
    }
    public void setIdouKhBosyuudrs(List<BT_IdouKhBosyuudr> pBT_IdouKhBosyuudrs) {
        this.bT_IdouKhBosyuudrs = pBT_IdouKhBosyuudrs;
    }
    @OneToMany (
        mappedBy = "tjtIdouNyKh",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_IdouKhBosyuudr.SYONO+" ASC ,"+BT_IdouKhBosyuudr.RENNO3KETA+" ASC ")
    public  List<BT_IdouKhBosyuudr> getIdouKhBosyuudrs() {
        return bT_IdouKhBosyuudrs;
    }

}

