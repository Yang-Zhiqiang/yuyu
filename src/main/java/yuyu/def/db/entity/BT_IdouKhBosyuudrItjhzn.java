package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_IdouKhBosyuudrItjhzn;

/**
 * 異動契約保全募集代理店一時保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_IdouKhBosyuudrItjhzn} の JavaDoc を参照してください。<br />
 * @see     GenBT_IdouKhBosyuudrItjhzn<br />
 * @see     PKBT_IdouKhBosyuudrItjhzn<br />
 * @see     QBT_IdouKhBosyuudrItjhzn<br />
 * @see     GenQBT_IdouKhBosyuudrItjhzn<br />
 */
@Entity
public class BT_IdouKhBosyuudrItjhzn extends GenBT_IdouKhBosyuudrItjhzn {

    private static final long serialVersionUID = 1L;

    public BT_IdouKhBosyuudrItjhzn() {
    }

    public BT_IdouKhBosyuudrItjhzn(String pSyono,Integer pRenno3keta) {
        super(pSyono,pRenno3keta);
    }



    private BT_TjtIdouNyKhItjhzn bT_TjtIdouNyKhItjhzn ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_IdouKhBosyuudrItjhzn.SYONO  , referencedColumnName=BT_TjtIdouNyKhItjhzn.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=BT_IdouKhBosyuudrItjhzn.RENNO3KETA  , referencedColumnName=BT_TjtIdouNyKhItjhzn.RENNO3KETA, insertable=false, updatable=false)
    })
    public BT_TjtIdouNyKhItjhzn getTjtIdouNyKhItjhzn() {
        return bT_TjtIdouNyKhItjhzn;
    }

    public void setTjtIdouNyKhItjhzn(BT_TjtIdouNyKhItjhzn pBT_TjtIdouNyKhItjhzn) {
        this.bT_TjtIdouNyKhItjhzn = pBT_TjtIdouNyKhItjhzn;
    }

}

