package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.id.PKAS_Category;
import yuyu.def.db.mapping.GenAS_Category;
import yuyu.def.db.meta.GenQAS_Category;
import yuyu.def.db.meta.QAS_Category;

/**
 * カテゴリ基幹テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_Category} の JavaDoc を参照してください。
 * @see     GenAS_Category
 * @see     PKAS_Category
 * @see     QAS_Category
 * @see     GenQAS_Category
 */
@Entity
public class AS_Category extends GenAS_Category {

    private static final long serialVersionUID = 2L;

    public AS_Category() {
    }

    public AS_Category(String pCategoryId) {
        super(pCategoryId);
    }

    private AS_SubSystem aS_SubSystem;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AS_Category.SUBSYSTEMID, referencedColumnName=AS_SubSystem.SUBSYSTEMID, insertable=false, updatable=false)
    public AS_SubSystem getSubSystem() {
        return aS_SubSystem;
    }

    void setSubSystem(AS_SubSystem pSubSystem) {
        aS_SubSystem = pSubSystem;
    }

}
