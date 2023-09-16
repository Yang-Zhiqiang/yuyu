package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenBT_IdouSkMeigiItjhzn;


/**
 * 異動新契約名義管理一時保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_IdouSkMeigiItjhzn} の JavaDoc を参照してください。<br />
 * @see     GenBT_IdouSkMeigiItjhzn<br />
 * @see     PKBT_IdouSkMeigiItjhzn<br />
 * @see     QBT_IdouSkMeigiItjhzn<br />
 * @see     GenQBT_IdouSkMeigiItjhzn<br />
 */
@Entity
public class BT_IdouSkMeigiItjhzn extends GenBT_IdouSkMeigiItjhzn {

    private static final long serialVersionUID = 1L;

    public BT_IdouSkMeigiItjhzn() {
    }

    public BT_IdouSkMeigiItjhzn(String pMosno,Integer pRenno3keta) {
        super(pMosno,pRenno3keta);
    }



    private BT_TjtIdouNySkItjhzn bT_TjtIdouNySkItjhzn ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_IdouSkMeigiItjhzn.MOSNO  , referencedColumnName=BT_TjtIdouNySkItjhzn.MOSNO, insertable=false, updatable=false),
        @JoinColumn(name=BT_IdouSkMeigiItjhzn.RENNO3KETA  , referencedColumnName=BT_TjtIdouNySkItjhzn.RENNO3KETA, insertable=false, updatable=false)
    })
    public BT_TjtIdouNySkItjhzn getTjtIdouNySkItjhzn() {
        return bT_TjtIdouNySkItjhzn;
    }

    public void setTjtIdouNySkItjhzn(BT_TjtIdouNySkItjhzn pBT_TjtIdouNySkItjhzn) {
        this.bT_TjtIdouNySkItjhzn = pBT_TjtIdouNySkItjhzn;
    }

}

