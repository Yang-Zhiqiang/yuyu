package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import yuyu.def.db.id.PKWT_TorikomiKanri;
import yuyu.def.db.mapping.GenWT_TorikomiKanri;
import yuyu.def.db.meta.GenQWT_TorikomiKanri;
import yuyu.def.db.meta.QWT_TorikomiKanri;

/**
 * 取込管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWT_TorikomiKanri} の JavaDoc を参照してください。
 * @see     GenWT_TorikomiKanri
 * @see     PKWT_TorikomiKanri
 * @see     QWT_TorikomiKanri
 * @see     GenQWT_TorikomiKanri
 */
@Entity
public class WT_TorikomiKanri extends GenWT_TorikomiKanri {

    private static final long serialVersionUID = 1L;

    public WT_TorikomiKanri() {
    }

    public WT_TorikomiKanri(String pIwfImageId) {
        super(pIwfImageId);
    }

    //    private List<WT_Page> wT_Pages = Lists.newLinkedList();
    //
    //    @OneToMany(
    //        fetch         = FetchType.EAGER
    //        )
    //    @JoinColumn(name=WT_TorikomiKanri.IWFIMAGEID, referencedColumnName=WT_Page.IWFIMAGEID, insertable=false, updatable=false)
    //    public List<WT_Page> getPages(){
    //        return wT_Pages;
    //    }
    //
    //    public void setPages(List<WT_Page> pPages){
    //        wT_Pages = pPages;
    //    }

    private List<WT_TorikomiRelation> wT_TorikomiRelation;

    @OneToMany(
        fetch         = FetchType.EAGER
        )
    @JoinColumn(name=WT_TorikomiKanri.IWFIMAGEID, referencedColumnName=WT_TorikomiRelation.IWFIMAGEID, insertable=false, updatable=false)
    public List<WT_TorikomiRelation> getTorikomiRelation(){
        return wT_TorikomiRelation;
    }

    public void setTorikomiRelation(List<WT_TorikomiRelation> pTorikomiRelation){
        wT_TorikomiRelation = pTorikomiRelation;
    }

}
