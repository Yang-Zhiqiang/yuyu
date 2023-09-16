package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_IdouSkBosyuudrItjhzn;


/**
 * 異動新契約募集代理店一時保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_IdouSkBosyuudrItjhzn} の JavaDoc を参照してください。<br />
 * @see     GenBT_IdouSkBosyuudrItjhzn<br />
 * @see     PKBT_IdouSkBosyuudrItjhzn<br />
 * @see     QBT_IdouSkBosyuudrItjhzn<br />
 * @see     GenQBT_IdouSkBosyuudrItjhzn<br />
 */
@Entity
public class BT_IdouSkBosyuudrItjhzn extends GenBT_IdouSkBosyuudrItjhzn {

    private static final long serialVersionUID = 1L;

    public BT_IdouSkBosyuudrItjhzn() {
    }

    public BT_IdouSkBosyuudrItjhzn(String pMosno,Integer pRenno3keta) {
        super(pMosno,pRenno3keta);
    }



    private BT_TjtIdouNySkItjhzn bT_TjtIdouNySkItjhzn ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_IdouSkBosyuudrItjhzn.MOSNO  , referencedColumnName=BT_TjtIdouNySkItjhzn.MOSNO, insertable=false, updatable=false),
        @JoinColumn(name=BT_IdouSkBosyuudrItjhzn.RENNO3KETA  , referencedColumnName=BT_TjtIdouNySkItjhzn.RENNO3KETA, insertable=false, updatable=false)
    })
    public BT_TjtIdouNySkItjhzn getTjtIdouNySkItjhzn() {
        return bT_TjtIdouNySkItjhzn;
    }

    public void setTjtIdouNySkItjhzn(BT_TjtIdouNySkItjhzn pBT_TjtIdouNySkItjhzn) {
        this.bT_TjtIdouNySkItjhzn = pBT_TjtIdouNySkItjhzn;
    }

}

