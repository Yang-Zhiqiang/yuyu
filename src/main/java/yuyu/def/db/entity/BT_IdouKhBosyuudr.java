package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_IdouKhBosyuudr;

/**
 * 異動契約保全募集代理店テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_IdouKhBosyuudr} の JavaDoc を参照してください。<br />
 * @see     GenBT_IdouKhBosyuudr<br />
 * @see     PKBT_IdouKhBosyuudr<br />
 * @see     QBT_IdouKhBosyuudr<br />
 * @see     GenQBT_IdouKhBosyuudr<br />
 */
@Entity
public class BT_IdouKhBosyuudr extends GenBT_IdouKhBosyuudr {

    private static final long serialVersionUID = 1L;

    public BT_IdouKhBosyuudr() {
    }

    public BT_IdouKhBosyuudr(String pSyono,Integer pRenno3keta) {
        super(pSyono,pRenno3keta);
    }



    private BT_TjtIdouNyKh bT_TjtIdouNyKh ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_IdouKhBosyuudr.SYONO  , referencedColumnName=BT_TjtIdouNyKh.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=BT_IdouKhBosyuudr.RENNO3KETA  , referencedColumnName=BT_TjtIdouNyKh.RENNO3KETA, insertable=false, updatable=false)
    })
    public BT_TjtIdouNyKh getTjtIdouNyKh() {
        return bT_TjtIdouNyKh;
    }

    public void setTjtIdouNyKh(BT_TjtIdouNyKh pBT_TjtIdouNyKh) {
        this.bT_TjtIdouNyKh = pBT_TjtIdouNyKh;
    }

}

