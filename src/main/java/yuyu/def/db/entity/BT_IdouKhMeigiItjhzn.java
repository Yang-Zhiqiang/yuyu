package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_IdouKhMeigiItjhzn;

/**
 * 異動契約保全名義管理一時保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_IdouKhMeigiItjhzn} の JavaDoc を参照してください。<br />
 * @see     GenBT_IdouKhMeigiItjhzn<br />
 * @see     PKBT_IdouKhMeigiItjhzn<br />
 * @see     QBT_IdouKhMeigiItjhzn<br />
 * @see     GenQBT_IdouKhMeigiItjhzn<br />
 */
@Entity
public class BT_IdouKhMeigiItjhzn extends GenBT_IdouKhMeigiItjhzn {

    private static final long serialVersionUID = 1L;

    public BT_IdouKhMeigiItjhzn() {
    }

    public BT_IdouKhMeigiItjhzn(String pSyono,Integer pRenno3keta) {
        super(pSyono,pRenno3keta);
    }



    private BT_TjtIdouNyKhItjhzn bT_TjtIdouNyKhItjhzn ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_IdouKhMeigiItjhzn.SYONO  , referencedColumnName=BT_TjtIdouNyKhItjhzn.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=BT_IdouKhMeigiItjhzn.RENNO3KETA  , referencedColumnName=BT_TjtIdouNyKhItjhzn.RENNO3KETA, insertable=false, updatable=false)
    })
    public BT_TjtIdouNyKhItjhzn getTjtIdouNyKhItjhzn() {
        return bT_TjtIdouNyKhItjhzn;
    }

    public void setTjtIdouNyKhItjhzn(BT_TjtIdouNyKhItjhzn pBT_TjtIdouNyKhItjhzn) {
        this.bT_TjtIdouNyKhItjhzn = pBT_TjtIdouNyKhItjhzn;
    }

}

