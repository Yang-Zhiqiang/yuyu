package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_IdouNkBosyuudrItjhzn;


/**
 * 異動年金支払募集代理店一時保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_IdouNkBosyuudrItjhzn} の JavaDoc を参照してください。<br />
 * @see     GenBT_IdouNkBosyuudrItjhzn<br />
 * @see     PKBT_IdouNkBosyuudrItjhzn<br />
 * @see     QBT_IdouNkBosyuudrItjhzn<br />
 * @see     GenQBT_IdouNkBosyuudrItjhzn<br />
 */
@Entity
public class BT_IdouNkBosyuudrItjhzn extends GenBT_IdouNkBosyuudrItjhzn {

    private static final long serialVersionUID = 1L;

    public BT_IdouNkBosyuudrItjhzn() {
    }

    public BT_IdouNkBosyuudrItjhzn(String pNksysyno,Integer pRenno3keta) {
        super(pNksysyno,pRenno3keta);
    }



    private BT_TjtIdouNyNkItjhzn bT_TjtIdouNyNkItjhzn ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_IdouNkBosyuudrItjhzn.NKSYSYNO  , referencedColumnName=BT_TjtIdouNyNkItjhzn.NKSYSYNO, insertable=false, updatable=false),
        @JoinColumn(name=BT_IdouNkBosyuudrItjhzn.RENNO3KETA  , referencedColumnName=BT_TjtIdouNyNkItjhzn.RENNO3KETA, insertable=false, updatable=false)
    })
    public BT_TjtIdouNyNkItjhzn getTjtIdouNyNkItjhzn() {
        return bT_TjtIdouNyNkItjhzn;
    }

    public void setTjtIdouNyNkItjhzn(BT_TjtIdouNyNkItjhzn pBT_TjtIdouNyNkItjhzn) {
        this.bT_TjtIdouNyNkItjhzn = pBT_TjtIdouNyNkItjhzn;
    }

}

