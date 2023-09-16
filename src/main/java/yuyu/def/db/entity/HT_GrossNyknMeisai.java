package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenHT_GrossNyknMeisai;

/**
 * グロス入金明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_GrossNyknMeisai} の JavaDoc を参照してください。<br />
 * @see     GenHT_GrossNyknMeisai<br />
 * @see     PKHT_GrossNyknMeisai<br />
 * @see     QHT_GrossNyknMeisai<br />
 * @see     GenQHT_GrossNyknMeisai<br />
 */
@Entity
public class HT_GrossNyknMeisai extends GenHT_GrossNyknMeisai {

    private static final long serialVersionUID = 1L;

    public HT_GrossNyknMeisai() {
    }

    public HT_GrossNyknMeisai(BizDate pRyosyuymd, String pOyadrtencd, Integer pRenno, Integer pMeisairenno) {
        super(pRyosyuymd, pOyadrtencd, pRenno, pMeisairenno);
    }

    private HT_GrossNykn hT_GrossNykn;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name = HT_GrossNyknMeisai.RYOSYUYMD, referencedColumnName = HT_GrossNykn.RYOSYUYMD, insertable = false, updatable = false),
        @JoinColumn(name = HT_GrossNyknMeisai.OYADRTENCD, referencedColumnName = HT_GrossNykn.OYADRTENCD, insertable = false, updatable = false),
        @JoinColumn(name = HT_GrossNyknMeisai.RENNO, referencedColumnName = HT_GrossNykn.RENNO, insertable = false, updatable = false)
    })
    public HT_GrossNykn getGrossNykn() {
        return hT_GrossNykn;
    }

    public void setGrossNykn(HT_GrossNykn pHT_GrossNykn) {
        this.hT_GrossNykn = pHT_GrossNykn;
    }

}
