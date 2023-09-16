package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_IdouNkMeigi;


/**
 * 異動年金支払名義管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_IdouNkMeigi} の JavaDoc を参照してください。<br />
 * @see     GenBT_IdouNkMeigi<br />
 * @see     PKBT_IdouNkMeigi<br />
 * @see     QBT_IdouNkMeigi<br />
 * @see     GenQBT_IdouNkMeigi<br />
 */
@Entity
public class BT_IdouNkMeigi extends GenBT_IdouNkMeigi {

    private static final long serialVersionUID = 1L;

    public BT_IdouNkMeigi() {
    }

    public BT_IdouNkMeigi(String pNksysyno,Integer pRenno3keta) {
        super(pNksysyno,pRenno3keta);
    }



    private BT_TjtIdouNyNk bT_TjtIdouNyNk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_IdouNkMeigi.NKSYSYNO  , referencedColumnName=BT_TjtIdouNyNk.NKSYSYNO, insertable=false, updatable=false),
        @JoinColumn(name=BT_IdouNkMeigi.RENNO3KETA  , referencedColumnName=BT_TjtIdouNyNk.RENNO3KETA, insertable=false, updatable=false)
    })
    public BT_TjtIdouNyNk getTjtIdouNyNk() {
        return bT_TjtIdouNyNk;
    }

    public void setTjtIdouNyNk(BT_TjtIdouNyNk pBT_TjtIdouNyNk) {
        this.bT_TjtIdouNyNk = pBT_TjtIdouNyNk;
    }

}

