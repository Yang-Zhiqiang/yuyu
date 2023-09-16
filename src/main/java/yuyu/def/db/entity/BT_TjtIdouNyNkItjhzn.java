package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.db.mapping.GenBT_TjtIdouNyNkItjhzn;

import com.google.common.collect.Lists;


/**
 * 当日異動内容年金支払一時保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_TjtIdouNyNkItjhzn} の JavaDoc を参照してください。<br />
 * @see     GenBT_TjtIdouNyNkItjhzn<br />
 * @see     PKBT_TjtIdouNyNkItjhzn<br />
 * @see     QBT_TjtIdouNyNkItjhzn<br />
 * @see     GenQBT_TjtIdouNyNkItjhzn<br />
 */
@Entity
public class BT_TjtIdouNyNkItjhzn extends GenBT_TjtIdouNyNkItjhzn {

    private static final long serialVersionUID = 1L;

    public BT_TjtIdouNyNkItjhzn() {
    }

    public BT_TjtIdouNyNkItjhzn(String pNksysyno,Integer pRenno3keta) {
        super(pNksysyno,pRenno3keta);
    }



    private List<BT_IdouNkMeigiItjhzn> bT_IdouNkMeigiItjhzns = Lists.newLinkedList();
    public BT_IdouNkMeigiItjhzn createIdouNkMeigiItjhzn() {
        BT_IdouNkMeigiItjhzn idouNkMeigiItjhzn =  new BT_IdouNkMeigiItjhzn();
        idouNkMeigiItjhzn.setTjtIdouNyNkItjhzn(this);
        idouNkMeigiItjhzn.setNksysyno(this.getNksysyno());
        idouNkMeigiItjhzn.setRenno3keta(this.getRenno3keta());
        setIdouNkMeigiItjhzn(idouNkMeigiItjhzn);
        return idouNkMeigiItjhzn;
    }
    @Transient
    public  BT_IdouNkMeigiItjhzn getIdouNkMeigiItjhzn() {
        requiredEntities(getIdouNkMeigiItjhzns(),BT_IdouNkMeigiItjhzn.class);
        if(getIdouNkMeigiItjhzns().size() == 0) {
            return null;
        }
        return getIdouNkMeigiItjhzns().get(0);
    }
    @Transient
    public void setIdouNkMeigiItjhzn(BT_IdouNkMeigiItjhzn pBT_IdouNkMeigiItjhzn) {
        if(this.getIdouNkMeigiItjhzns().size() >0){
            this.getIdouNkMeigiItjhzns().set(0, pBT_IdouNkMeigiItjhzn) ;
        }else{
            this.getIdouNkMeigiItjhzns().add(pBT_IdouNkMeigiItjhzn) ;
        }
    }
    public void setIdouNkMeigiItjhzns(List<BT_IdouNkMeigiItjhzn> pBT_IdouNkMeigiItjhzns) {
        this.bT_IdouNkMeigiItjhzns = pBT_IdouNkMeigiItjhzns;
    }
    @OneToMany (
        mappedBy = "tjtIdouNyNkItjhzn",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_IdouNkMeigiItjhzn.NKSYSYNO+" ASC ,"+BT_IdouNkMeigiItjhzn.RENNO3KETA+" ASC ")
    public  List<BT_IdouNkMeigiItjhzn> getIdouNkMeigiItjhzns() {
        return bT_IdouNkMeigiItjhzns;
    }

    private List<BT_IdouNkBosyuudrItjhzn> bT_IdouNkBosyuudrItjhzns = Lists.newLinkedList();
    public BT_IdouNkBosyuudrItjhzn createIdouNkBosyuudrItjhzn() {
        BT_IdouNkBosyuudrItjhzn idouNkBosyuudrItjhzn =  new BT_IdouNkBosyuudrItjhzn();
        idouNkBosyuudrItjhzn.setTjtIdouNyNkItjhzn(this);
        idouNkBosyuudrItjhzn.setNksysyno(this.getNksysyno());
        idouNkBosyuudrItjhzn.setRenno3keta(this.getRenno3keta());
        setIdouNkBosyuudrItjhzn(idouNkBosyuudrItjhzn);
        return idouNkBosyuudrItjhzn;
    }
    @Transient
    public  BT_IdouNkBosyuudrItjhzn getIdouNkBosyuudrItjhzn() {
        requiredEntities(getIdouNkBosyuudrItjhzns(),BT_IdouNkBosyuudrItjhzn.class);
        if(getIdouNkBosyuudrItjhzns().size() == 0) {
            return null;
        }
        return getIdouNkBosyuudrItjhzns().get(0);
    }
    @Transient
    public void setIdouNkBosyuudrItjhzn(BT_IdouNkBosyuudrItjhzn pBT_IdouNkBosyuudrItjhzn) {
        if(this.getIdouNkBosyuudrItjhzns().size() >0){
            this.getIdouNkBosyuudrItjhzns().set(0, pBT_IdouNkBosyuudrItjhzn) ;
        }else{
            this.getIdouNkBosyuudrItjhzns().add(pBT_IdouNkBosyuudrItjhzn) ;
        }
    }
    public void setIdouNkBosyuudrItjhzns(List<BT_IdouNkBosyuudrItjhzn> pBT_IdouNkBosyuudrItjhzns) {
        this.bT_IdouNkBosyuudrItjhzns = pBT_IdouNkBosyuudrItjhzns;
    }
    @OneToMany (
        mappedBy = "tjtIdouNyNkItjhzn",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_IdouNkBosyuudrItjhzn.NKSYSYNO+" ASC ,"+BT_IdouNkBosyuudrItjhzn.RENNO3KETA+" ASC ")
    public  List<BT_IdouNkBosyuudrItjhzn> getIdouNkBosyuudrItjhzns() {
        return bT_IdouNkBosyuudrItjhzns;
    }

}

