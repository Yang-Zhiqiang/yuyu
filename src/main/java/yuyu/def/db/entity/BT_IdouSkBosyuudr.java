package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_IdouSkBosyuudr;


/**
 * 異動新契約募集代理店テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_IdouSkBosyuudr} の JavaDoc を参照してください。<br />
 * @see     GenBT_IdouSkBosyuudr<br />
 * @see     PKBT_IdouSkBosyuudr<br />
 * @see     QBT_IdouSkBosyuudr<br />
 * @see     GenQBT_IdouSkBosyuudr<br />
 */
@Entity
public class BT_IdouSkBosyuudr extends GenBT_IdouSkBosyuudr {

    private static final long serialVersionUID = 1L;

    public BT_IdouSkBosyuudr() {
    }

    public BT_IdouSkBosyuudr(String pMosno,Integer pRenno3keta) {
        super(pMosno,pRenno3keta);
    }



    private BT_TjtIdouNySk bT_TjtIdouNySk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_IdouSkBosyuudr.MOSNO  , referencedColumnName=BT_TjtIdouNySk.MOSNO, insertable=false, updatable=false),
        @JoinColumn(name=BT_IdouSkBosyuudr.RENNO3KETA  , referencedColumnName=BT_TjtIdouNySk.RENNO3KETA, insertable=false, updatable=false)
    })
    public BT_TjtIdouNySk getTjtIdouNySk() {
        return bT_TjtIdouNySk;
    }

    public void setTjtIdouNySk(BT_TjtIdouNySk pBT_TjtIdouNySk) {
        this.bT_TjtIdouNySk = pBT_TjtIdouNySk;
    }

}

