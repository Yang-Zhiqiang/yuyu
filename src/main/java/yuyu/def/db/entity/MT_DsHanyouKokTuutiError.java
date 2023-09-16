package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;



import yuyu.def.db.mapping.GenMT_DsHanyouKokTuutiError;


/**
 * ＤＳ汎用顧客宛通知エラーテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsHanyouKokTuutiError} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsHanyouKokTuutiError<br />
 * @see     PKMT_DsHanyouKokTuutiError<br />
 * @see     QMT_DsHanyouKokTuutiError<br />
 * @see     GenQMT_DsHanyouKokTuutiError<br />
 */
@Entity
public class MT_DsHanyouKokTuutiError extends GenMT_DsHanyouKokTuutiError {

    private static final long serialVersionUID = 1L;

    public MT_DsHanyouKokTuutiError() {
    }

    public MT_DsHanyouKokTuutiError(BizDate pDsdatasakuseiymd,String pDskoktuutirenno,String pDskokno,C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn) {
        super(pDsdatasakuseiymd,pDskoktuutirenno,pDskokno,pDshanyoukokyakuatetuutikbn);
    }



    private MT_DsHanyouKokyakuateTuuti2 mT_DsHanyouKokyakuateTuuti2 ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsHanyouKokTuutiError.DSDATASAKUSEIYMD  , referencedColumnName=MT_DsHanyouKokyakuateTuuti2.DSDATASAKUSEIYMD, insertable=false, updatable=false),
        @JoinColumn(name=MT_DsHanyouKokTuutiError.DSKOKTUUTIRENNO  , referencedColumnName=MT_DsHanyouKokyakuateTuuti2.DSKOKTUUTIRENNO, insertable=false, updatable=false),
        @JoinColumn(name=MT_DsHanyouKokTuutiError.DSKOKNO  , referencedColumnName=MT_DsHanyouKokyakuateTuuti2.DSKOKNO, insertable=false, updatable=false),
        @JoinColumn(name=MT_DsHanyouKokTuutiError.DSHANYOUKOKYAKUATETUUTIKBN  , referencedColumnName=MT_DsHanyouKokyakuateTuuti2.DSHANYOUKOKYAKUATETUUTIKBN, insertable=false, updatable=false)
    })
    public MT_DsHanyouKokyakuateTuuti2 getDsHanyouKokyakuateTuuti2() {
        return mT_DsHanyouKokyakuateTuuti2;
    }

    public void setDsHanyouKokyakuateTuuti2(MT_DsHanyouKokyakuateTuuti2 pMT_DsHanyouKokyakuateTuuti2) {
        this.mT_DsHanyouKokyakuateTuuti2 = pMT_DsHanyouKokyakuateTuuti2;
    }

}

