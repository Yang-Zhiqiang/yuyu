package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.db.id.PKMT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.mapping.GenMT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.meta.GenQMT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.meta.QMT_DsHanyouKokyakuateTuuti2;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;

import com.google.common.collect.Lists;

/**
 * ＤＳ汎用顧客宛通知２テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsHanyouKokyakuateTuuti2} の JavaDoc を参照してください。
 * @see     GenMT_DsHanyouKokyakuateTuuti2
 * @see     PKMT_DsHanyouKokyakuateTuuti2
 * @see     QMT_DsHanyouKokyakuateTuuti2
 * @see     GenQMT_DsHanyouKokyakuateTuuti2
 */
@Entity
public class MT_DsHanyouKokyakuateTuuti2 extends GenMT_DsHanyouKokyakuateTuuti2 {

    private static final long serialVersionUID = 1L;

    public MT_DsHanyouKokyakuateTuuti2() {
    }

    public MT_DsHanyouKokyakuateTuuti2(
        BizDate pDsdatasakuseiymd,
        String pDskoktuutirenno,
        String pDskokno,
        C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn
        ) {
        super(
            pDsdatasakuseiymd,
            pDskoktuutirenno,
            pDskokno,
            pDshanyoukokyakuatetuutikbn
            );
    }

    private MT_DsKokyakuKanri mT_DsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsHanyouKokyakuateTuuti2.DSKOKNO  , referencedColumnName=MT_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false)
    })
    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return mT_DsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pMT_DsKokyakuKanri) {
        this.mT_DsKokyakuKanri = pMT_DsKokyakuKanri;
    }

    private List<MT_DsHanyouKokTuutiError> mT_DsHanyouKokTuutiErrors = Lists.newLinkedList();
    public MT_DsHanyouKokTuutiError createDsHanyouKokTuutiError() {
        MT_DsHanyouKokTuutiError dsHanyouKokTuutiError =  new MT_DsHanyouKokTuutiError();
        dsHanyouKokTuutiError.setDsHanyouKokyakuateTuuti2(this);
        dsHanyouKokTuutiError.setDsdatasakuseiymd(this.getDsdatasakuseiymd());
        dsHanyouKokTuutiError.setDskoktuutirenno(this.getDskoktuutirenno());
        dsHanyouKokTuutiError.setDskokno(this.getDskokno());
        dsHanyouKokTuutiError.setDshanyoukokyakuatetuutikbn(this.getDshanyoukokyakuatetuutikbn());
        setDsHanyouKokTuutiError(dsHanyouKokTuutiError);
        return dsHanyouKokTuutiError;
    }
    @Transient
    public  MT_DsHanyouKokTuutiError getDsHanyouKokTuutiError() {
        if(getDsHanyouKokTuutiErrors().size() == 0) {
            return null;
        }
        return getDsHanyouKokTuutiErrors().get(0);
    }
    @Transient
    public void setDsHanyouKokTuutiError(MT_DsHanyouKokTuutiError pMT_DsHanyouKokTuutiError) {
        if(this.getDsHanyouKokTuutiErrors().size() >0){
            this.getDsHanyouKokTuutiErrors().set(0, pMT_DsHanyouKokTuutiError) ;
        }else{
            this.getDsHanyouKokTuutiErrors().add(pMT_DsHanyouKokTuutiError) ;
        }
    }
    public void setDsHanyouKokTuutiErrors(List<MT_DsHanyouKokTuutiError> pMT_DsHanyouKokTuutiErrors) {
        this.mT_DsHanyouKokTuutiErrors = pMT_DsHanyouKokTuutiErrors;
    }
    @OneToMany (
        mappedBy = "dsHanyouKokyakuateTuuti2",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_DsHanyouKokTuutiError.DSDATASAKUSEIYMD+" ASC ,"+MT_DsHanyouKokTuutiError.DSKOKTUUTIRENNO+" ASC ,"+MT_DsHanyouKokTuutiError.DSKOKNO+" ASC ,"+MT_DsHanyouKokTuutiError.DSHANYOUKOKYAKUATETUUTIKBN+" ASC ")
    public  List<MT_DsHanyouKokTuutiError> getDsHanyouKokTuutiErrors() {
        return mT_DsHanyouKokTuutiErrors;
    }
}
