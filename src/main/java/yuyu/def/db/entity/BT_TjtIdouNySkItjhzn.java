package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.db.mapping.GenBT_TjtIdouNySkItjhzn;

import com.google.common.collect.Lists;


/**
 * 当日異動内容新契約一時保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_TjtIdouNySkItjhzn} の JavaDoc を参照してください。<br />
 * @see     GenBT_TjtIdouNySkItjhzn<br />
 * @see     PKBT_TjtIdouNySkItjhzn<br />
 * @see     QBT_TjtIdouNySkItjhzn<br />
 * @see     GenQBT_TjtIdouNySkItjhzn<br />
 */
@Entity
public class BT_TjtIdouNySkItjhzn extends GenBT_TjtIdouNySkItjhzn {

    private static final long serialVersionUID = 1L;

    public BT_TjtIdouNySkItjhzn() {
    }

    public BT_TjtIdouNySkItjhzn(String pMosno,Integer pRenno3keta) {
        super(pMosno,pRenno3keta);
    }



    private List<BT_IdouSkMeigiItjhzn> bT_IdouSkMeigiItjhzns = Lists.newLinkedList();
    public BT_IdouSkMeigiItjhzn createIdouSkMeigiItjhzn() {
        BT_IdouSkMeigiItjhzn idouSkMeigiItjhzn =  new BT_IdouSkMeigiItjhzn();
        idouSkMeigiItjhzn.setTjtIdouNySkItjhzn(this);
        idouSkMeigiItjhzn.setMosno(this.getMosno());
        idouSkMeigiItjhzn.setRenno3keta(this.getRenno3keta());
        setIdouSkMeigiItjhzn(idouSkMeigiItjhzn);
        return idouSkMeigiItjhzn;
    }
    @Transient
    public  BT_IdouSkMeigiItjhzn getIdouSkMeigiItjhzn() {
        requiredEntities(getIdouSkMeigiItjhzns(),BT_IdouSkMeigiItjhzn.class);
        if(getIdouSkMeigiItjhzns().size() == 0) {
            return null;
        }
        return getIdouSkMeigiItjhzns().get(0);
    }
    @Transient
    public void setIdouSkMeigiItjhzn(BT_IdouSkMeigiItjhzn pBT_IdouSkMeigiItjhzn) {
        if(this.getIdouSkMeigiItjhzns().size() >0){
            this.getIdouSkMeigiItjhzns().set(0, pBT_IdouSkMeigiItjhzn) ;
        }else{
            this.getIdouSkMeigiItjhzns().add(pBT_IdouSkMeigiItjhzn) ;
        }
    }
    public void setIdouSkMeigiItjhzns(List<BT_IdouSkMeigiItjhzn> pBT_IdouSkMeigiItjhzns) {
        this.bT_IdouSkMeigiItjhzns = pBT_IdouSkMeigiItjhzns;
    }
    @OneToMany (
        mappedBy = "tjtIdouNySkItjhzn",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_IdouSkMeigiItjhzn.MOSNO+" ASC ,"+BT_IdouSkMeigiItjhzn.RENNO3KETA+" ASC ")
    public  List<BT_IdouSkMeigiItjhzn> getIdouSkMeigiItjhzns() {
        return bT_IdouSkMeigiItjhzns;
    }

    private List<BT_IdouSkBosyuudrItjhzn> bT_IdouSkBosyuudrItjhzns = Lists.newLinkedList();
    public BT_IdouSkBosyuudrItjhzn createIdouSkBosyuudrItjhzn() {
        BT_IdouSkBosyuudrItjhzn idouSkBosyuudrItjhzn =  new BT_IdouSkBosyuudrItjhzn();
        idouSkBosyuudrItjhzn.setTjtIdouNySkItjhzn(this);
        idouSkBosyuudrItjhzn.setMosno(this.getMosno());
        idouSkBosyuudrItjhzn.setRenno3keta(this.getRenno3keta());
        setIdouSkBosyuudrItjhzn(idouSkBosyuudrItjhzn);
        return idouSkBosyuudrItjhzn;
    }
    @Transient
    public  BT_IdouSkBosyuudrItjhzn getIdouSkBosyuudrItjhzn() {
        requiredEntities(getIdouSkBosyuudrItjhzns(),BT_IdouSkBosyuudrItjhzn.class);
        if(getIdouSkBosyuudrItjhzns().size() == 0) {
            return null;
        }
        return getIdouSkBosyuudrItjhzns().get(0);
    }
    @Transient
    public void setIdouSkBosyuudrItjhzn(BT_IdouSkBosyuudrItjhzn pBT_IdouSkBosyuudrItjhzn) {
        if(this.getIdouSkBosyuudrItjhzns().size() >0){
            this.getIdouSkBosyuudrItjhzns().set(0, pBT_IdouSkBosyuudrItjhzn) ;
        }else{
            this.getIdouSkBosyuudrItjhzns().add(pBT_IdouSkBosyuudrItjhzn) ;
        }
    }
    public void setIdouSkBosyuudrItjhzns(List<BT_IdouSkBosyuudrItjhzn> pBT_IdouSkBosyuudrItjhzns) {
        this.bT_IdouSkBosyuudrItjhzns = pBT_IdouSkBosyuudrItjhzns;
    }
    @OneToMany (
        mappedBy = "tjtIdouNySkItjhzn",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_IdouSkBosyuudrItjhzn.MOSNO+" ASC ,"+BT_IdouSkBosyuudrItjhzn.RENNO3KETA+" ASC ")
    public  List<BT_IdouSkBosyuudrItjhzn> getIdouSkBosyuudrItjhzns() {
        return bT_IdouSkBosyuudrItjhzns;
    }

}

