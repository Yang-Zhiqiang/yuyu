package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_IdouKhMeigi;

/**
 * 異動契約保全名義管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_IdouKhMeigi} の JavaDoc を参照してください。<br />
 * @see     GenBT_IdouKhMeigi<br />
 * @see     PKBT_IdouKhMeigi<br />
 * @see     QBT_IdouKhMeigi<br />
 * @see     GenQBT_IdouKhMeigi<br />
 */
@Entity
public class BT_IdouKhMeigi extends GenBT_IdouKhMeigi {

    private static final long serialVersionUID = 1L;

    public BT_IdouKhMeigi() {
    }

    public BT_IdouKhMeigi(String pSyono,Integer pRenno3keta) {
        super(pSyono,pRenno3keta);
    }



    private BT_TjtIdouNyKh bT_TjtIdouNyKh ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_IdouKhMeigi.SYONO  , referencedColumnName=BT_TjtIdouNyKh.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=BT_IdouKhMeigi.RENNO3KETA  , referencedColumnName=BT_TjtIdouNyKh.RENNO3KETA, insertable=false, updatable=false)
    })
    public BT_TjtIdouNyKh getTjtIdouNyKh() {
        return bT_TjtIdouNyKh;
    }

    public void setTjtIdouNyKh(BT_TjtIdouNyKh pBT_TjtIdouNyKh) {
        this.bT_TjtIdouNyKh = pBT_TjtIdouNyKh;
    }

}

