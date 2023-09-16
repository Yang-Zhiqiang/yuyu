package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.db.mapping.GenBT_TjtIdouNyKhItjhzn;

import com.google.common.collect.Lists;

/**
 * 当日異動内容契約保全一時保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_TjtIdouNyKhItjhzn} の JavaDoc を参照してください。<br />
 * @see     GenBT_TjtIdouNyKhItjhzn<br />
 * @see     PKBT_TjtIdouNyKhItjhzn<br />
 * @see     QBT_TjtIdouNyKhItjhzn<br />
 * @see     GenQBT_TjtIdouNyKhItjhzn<br />
 */
@Entity
public class BT_TjtIdouNyKhItjhzn extends GenBT_TjtIdouNyKhItjhzn {

    private static final long serialVersionUID = 1L;

    public BT_TjtIdouNyKhItjhzn() {
    }

    public BT_TjtIdouNyKhItjhzn(String pSyono,Integer pRenno3keta) {
        super(pSyono,pRenno3keta);
    }



    private List<BT_IdouKhMeigiItjhzn> bT_IdouKhMeigiItjhzns = Lists.newLinkedList();
    public BT_IdouKhMeigiItjhzn createIdouKhMeigiItjhzn() {
        BT_IdouKhMeigiItjhzn idouKhMeigiItjhzn =  new BT_IdouKhMeigiItjhzn();
        idouKhMeigiItjhzn.setTjtIdouNyKhItjhzn(this);
        idouKhMeigiItjhzn.setSyono(this.getSyono());
        idouKhMeigiItjhzn.setRenno3keta(this.getRenno3keta());
        setIdouKhMeigiItjhzn(idouKhMeigiItjhzn);
        return idouKhMeigiItjhzn;
    }
    @Transient
    public  BT_IdouKhMeigiItjhzn getIdouKhMeigiItjhzn() {
        requiredEntities(getIdouKhMeigiItjhzns(),BT_IdouKhMeigiItjhzn.class);
        if(getIdouKhMeigiItjhzns().size() == 0) {
            return null;
        }
        return getIdouKhMeigiItjhzns().get(0);
    }
    @Transient
    public void setIdouKhMeigiItjhzn(BT_IdouKhMeigiItjhzn pBT_IdouKhMeigiItjhzn) {
        if(this.getIdouKhMeigiItjhzns().size() >0){
            this.getIdouKhMeigiItjhzns().set(0, pBT_IdouKhMeigiItjhzn) ;
        }else{
            this.getIdouKhMeigiItjhzns().add(pBT_IdouKhMeigiItjhzn) ;
        }
    }
    public void setIdouKhMeigiItjhzns(List<BT_IdouKhMeigiItjhzn> pBT_IdouKhMeigiItjhzns) {
        this.bT_IdouKhMeigiItjhzns = pBT_IdouKhMeigiItjhzns;
    }
    @OneToMany (
        mappedBy = "tjtIdouNyKhItjhzn",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_IdouKhMeigiItjhzn.SYONO+" ASC ,"+BT_IdouKhMeigiItjhzn.RENNO3KETA+" ASC ")
    public  List<BT_IdouKhMeigiItjhzn> getIdouKhMeigiItjhzns() {
        return bT_IdouKhMeigiItjhzns;
    }

    private List<BT_IdouKhBosyuudrItjhzn> bT_IdouKhBosyuudrItjhzns = Lists.newLinkedList();
    public BT_IdouKhBosyuudrItjhzn createIdouKhBosyuudrItjhzn() {
        BT_IdouKhBosyuudrItjhzn idouKhBosyuudrItjhzn =  new BT_IdouKhBosyuudrItjhzn();
        idouKhBosyuudrItjhzn.setTjtIdouNyKhItjhzn(this);
        idouKhBosyuudrItjhzn.setSyono(this.getSyono());
        idouKhBosyuudrItjhzn.setRenno3keta(this.getRenno3keta());
        setIdouKhBosyuudrItjhzn(idouKhBosyuudrItjhzn);
        return idouKhBosyuudrItjhzn;
    }
    @Transient
    public  BT_IdouKhBosyuudrItjhzn getIdouKhBosyuudrItjhzn() {
        requiredEntities(getIdouKhBosyuudrItjhzns(),BT_IdouKhBosyuudrItjhzn.class);
        if(getIdouKhBosyuudrItjhzns().size() == 0) {
            return null;
        }
        return getIdouKhBosyuudrItjhzns().get(0);
    }
    @Transient
    public void setIdouKhBosyuudrItjhzn(BT_IdouKhBosyuudrItjhzn pBT_IdouKhBosyuudrItjhzn) {
        if(this.getIdouKhBosyuudrItjhzns().size() >0){
            this.getIdouKhBosyuudrItjhzns().set(0, pBT_IdouKhBosyuudrItjhzn) ;
        }else{
            this.getIdouKhBosyuudrItjhzns().add(pBT_IdouKhBosyuudrItjhzn) ;
        }
    }
    public void setIdouKhBosyuudrItjhzns(List<BT_IdouKhBosyuudrItjhzn> pBT_IdouKhBosyuudrItjhzns) {
        this.bT_IdouKhBosyuudrItjhzns = pBT_IdouKhBosyuudrItjhzns;
    }
    @OneToMany (
        mappedBy = "tjtIdouNyKhItjhzn",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_IdouKhBosyuudrItjhzn.SYONO+" ASC ,"+BT_IdouKhBosyuudrItjhzn.RENNO3KETA+" ASC ")
    public  List<BT_IdouKhBosyuudrItjhzn> getIdouKhBosyuudrItjhzns() {
        return bT_IdouKhBosyuudrItjhzns;
    }

}

