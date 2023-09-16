package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.id.PKMT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.mapping.GenMT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.meta.GenQMT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.meta.QMT_DsHanyouKokyakuateTuuti;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;

/**
 * ＤＳ汎用顧客宛通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsHanyouKokyakuateTuuti} の JavaDoc を参照してください。
 * @see     GenMT_DsHanyouKokyakuateTuuti
 * @see     PKMT_DsHanyouKokyakuateTuuti
 * @see     QMT_DsHanyouKokyakuateTuuti
 * @see     GenQMT_DsHanyouKokyakuateTuuti
 */
@Entity
public class MT_DsHanyouKokyakuateTuuti extends GenMT_DsHanyouKokyakuateTuuti {

    private static final long serialVersionUID = 1L;

    public MT_DsHanyouKokyakuateTuuti() {
    }

    public MT_DsHanyouKokyakuateTuuti(
        BizDate pDsdatasakuseiymd,
        String pDskokno,
        C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn
        ) {
        super(
            pDsdatasakuseiymd,
            pDskokno,
            pDshanyoukokyakuatetuutikbn
            );
    }



    private MT_DsKokyakuKanri mT_DsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsHanyouKokyakuateTuuti.DSKOKNO  , referencedColumnName=MT_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false)
    })
    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return mT_DsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pMT_DsKokyakuKanri) {
        this.mT_DsKokyakuKanri = pMT_DsKokyakuKanri;
    }

}

