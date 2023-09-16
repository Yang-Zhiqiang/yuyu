package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_IdouSkMeigi;


/**
 * 異動新契約名義管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_IdouSkMeigi} の JavaDoc を参照してください。<br />
 * @see     GenBT_IdouSkMeigi<br />
 * @see     PKBT_IdouSkMeigi<br />
 * @see     QBT_IdouSkMeigi<br />
 * @see     GenQBT_IdouSkMeigi<br />
 */
@Entity
public class BT_IdouSkMeigi extends GenBT_IdouSkMeigi {

    private static final long serialVersionUID = 1L;

    public BT_IdouSkMeigi() {
    }

    public BT_IdouSkMeigi(String pMosno,Integer pRenno3keta) {
        super(pMosno,pRenno3keta);
    }



    private BT_TjtIdouNySk bT_TjtIdouNySk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_IdouSkMeigi.MOSNO  , referencedColumnName=BT_TjtIdouNySk.MOSNO, insertable=false, updatable=false),
        @JoinColumn(name=BT_IdouSkMeigi.RENNO3KETA  , referencedColumnName=BT_TjtIdouNySk.RENNO3KETA, insertable=false, updatable=false)
    })
    public BT_TjtIdouNySk getTjtIdouNySk() {
        return bT_TjtIdouNySk;
    }

    public void setTjtIdouNySk(BT_TjtIdouNySk pBT_TjtIdouNySk) {
        this.bT_TjtIdouNySk = pBT_TjtIdouNySk;
    }

}

