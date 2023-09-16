package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenMT_DsMailAddress;

/**
 * ＤＳメールアドレステーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsMailAddress} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsMailAddress<br />
 * @see     PKMT_DsMailAddress<br />
 * @see     QMT_DsMailAddress<br />
 * @see     GenQMT_DsMailAddress<br />
 */
@Entity
public class MT_DsMailAddress extends GenMT_DsMailAddress {

    private static final long serialVersionUID = 1L;

    public MT_DsMailAddress() {
    }

    public MT_DsMailAddress(String pDskokno,Integer pDsmailaddressrenban) {
        super(pDskokno,pDsmailaddressrenban);
    }



    private MT_DsKokyakuKanri mT_DsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsMailAddress.DSKOKNO  , referencedColumnName=MT_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false)
    })
    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return mT_DsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pMT_DsKokyakuKanri) {
        this.mT_DsKokyakuKanri = pMT_DsKokyakuKanri;
    }

}

