package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenMT_DsMailAddressSpiralYyk;

/**
 * ＤＳメールアドレスＳＰＩＲＡＬ反映予約テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsMailAddressSpiralYyk} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsMailAddressSpiralYyk<br />
 * @see     PKMT_DsMailAddressSpiralYyk<br />
 * @see     QMT_DsMailAddressSpiralYyk<br />
 * @see     GenQMT_DsMailAddressSpiralYyk<br />
 */
@Entity
public class MT_DsMailAddressSpiralYyk extends GenMT_DsMailAddressSpiralYyk {

    private static final long serialVersionUID = 1L;

    public MT_DsMailAddressSpiralYyk() {
    }

    public MT_DsMailAddressSpiralYyk(BizDate pDsdatasakuseiymd,String pDskokno,Integer pDsmailaddressrenban) {
        super(pDsdatasakuseiymd,pDskokno,pDsmailaddressrenban);
    }



    private MT_DsKokyakuKanri mT_DsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsMailAddressSpiralYyk.DSKOKNO  , referencedColumnName=MT_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false)
    })
    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return mT_DsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pMT_DsKokyakuKanri) {
        this.mT_DsKokyakuKanri = pMT_DsKokyakuKanri;
    }

}

