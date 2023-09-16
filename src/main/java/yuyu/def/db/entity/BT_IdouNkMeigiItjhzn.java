package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_IdouNkMeigiItjhzn;


/**
 * 異動年金支払名義管理一時保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_IdouNkMeigiItjhzn} の JavaDoc を参照してください。<br />
 * @see     GenBT_IdouNkMeigiItjhzn<br />
 * @see     PKBT_IdouNkMeigiItjhzn<br />
 * @see     QBT_IdouNkMeigiItjhzn<br />
 * @see     GenQBT_IdouNkMeigiItjhzn<br />
 */
@Entity
public class BT_IdouNkMeigiItjhzn extends GenBT_IdouNkMeigiItjhzn {

    private static final long serialVersionUID = 1L;

    public BT_IdouNkMeigiItjhzn() {
    }

    public BT_IdouNkMeigiItjhzn(String pNksysyno,Integer pRenno3keta) {
        super(pNksysyno,pRenno3keta);
    }



    private BT_TjtIdouNyNkItjhzn bT_TjtIdouNyNkItjhzn ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_IdouNkMeigiItjhzn.NKSYSYNO  , referencedColumnName=BT_TjtIdouNyNkItjhzn.NKSYSYNO, insertable=false, updatable=false),
        @JoinColumn(name=BT_IdouNkMeigiItjhzn.RENNO3KETA  , referencedColumnName=BT_TjtIdouNyNkItjhzn.RENNO3KETA, insertable=false, updatable=false)
    })
    public BT_TjtIdouNyNkItjhzn getTjtIdouNyNkItjhzn() {
        return bT_TjtIdouNyNkItjhzn;
    }

    public void setTjtIdouNyNkItjhzn(BT_TjtIdouNyNkItjhzn pBT_TjtIdouNyNkItjhzn) {
        this.bT_TjtIdouNyNkItjhzn = pBT_TjtIdouNyNkItjhzn;
    }

}

