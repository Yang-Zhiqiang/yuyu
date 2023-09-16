package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_IdouNkBosyuudr;


/**
 * 異動年金支払募集代理店テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_IdouNkBosyuudr} の JavaDoc を参照してください。<br />
 * @see     GenBT_IdouNkBosyuudr<br />
 * @see     PKBT_IdouNkBosyuudr<br />
 * @see     QBT_IdouNkBosyuudr<br />
 * @see     GenQBT_IdouNkBosyuudr<br />
 */
@Entity
public class BT_IdouNkBosyuudr extends GenBT_IdouNkBosyuudr {

    private static final long serialVersionUID = 1L;

    public BT_IdouNkBosyuudr() {
    }

    public BT_IdouNkBosyuudr(String pNksysyno,Integer pRenno3keta) {
        super(pNksysyno,pRenno3keta);
    }



    private BT_TjtIdouNyNk bT_TjtIdouNyNk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_IdouNkBosyuudr.NKSYSYNO  , referencedColumnName=BT_TjtIdouNyNk.NKSYSYNO, insertable=false, updatable=false),
        @JoinColumn(name=BT_IdouNkBosyuudr.RENNO3KETA  , referencedColumnName=BT_TjtIdouNyNk.RENNO3KETA, insertable=false, updatable=false)
    })
    public BT_TjtIdouNyNk getTjtIdouNyNk() {
        return bT_TjtIdouNyNk;
    }

    public void setTjtIdouNyNk(BT_TjtIdouNyNk pBT_TjtIdouNyNk) {
        this.bT_TjtIdouNyNk = pBT_TjtIdouNyNk;
    }

}

