package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import yuyu.def.db.id.PKWT_TorikomiRelation;
import yuyu.def.db.mapping.GenWT_TorikomiRelation;
import yuyu.def.db.meta.GenQWT_TorikomiRelation;
import yuyu.def.db.meta.QWT_TorikomiRelation;

/**
 * 取込関連テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWT_TorikomiRelation} の JavaDoc を参照してください。
 * @see     GenWT_TorikomiRelation
 * @see     PKWT_TorikomiRelation
 * @see     QWT_TorikomiRelation
 * @see     GenQWT_TorikomiRelation
 */
@Entity
public class WT_TorikomiRelation extends GenWT_TorikomiRelation {

    private static final long serialVersionUID = 1L;

    public WT_TorikomiRelation() {
    }

    public WT_TorikomiRelation(String pGyoumuKey, String pIwfImageId) {
        super(pGyoumuKey, pIwfImageId);
    }

    private WT_KouteiSummary wT_KouteiSummary;

    @ManyToOne
    @JoinColumn(name=WT_TorikomiRelation.GYOUMUKEY, referencedColumnName=WT_KouteiSummary.GYOUMUKEY, insertable=false, updatable=false)
    public WT_KouteiSummary getKouteiSummary(){
        return wT_KouteiSummary;
    }

    public void setKouteiSummary(WT_KouteiSummary pKouteiSummary){
        wT_KouteiSummary = pKouteiSummary;
    }

    private WT_TorikomiKanri wT_TorikomiKanri;

    @ManyToOne
    @JoinColumn(name=WT_TorikomiRelation.IWFIMAGEID, referencedColumnName=WT_TorikomiKanri.IWFIMAGEID, insertable=false, updatable=false)
    public WT_TorikomiKanri getTorikomiKanri(){
        return wT_TorikomiKanri;
    }

    public void setTorikomiKanri(WT_TorikomiKanri pTorikomiKanri){
        wT_TorikomiKanri = pTorikomiKanri;
    }

}
