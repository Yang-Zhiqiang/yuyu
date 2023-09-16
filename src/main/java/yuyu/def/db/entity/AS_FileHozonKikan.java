package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.mapping.GenAS_FileHozonKikan;


/**
 * ファイル保存期間基幹テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_FileHozonKikan} の JavaDoc を参照してください。<br />
 * @see     GenAS_FileHozonKikan<br />
 * @see     PKAS_FileHozonKikan<br />
 * @see     QAS_FileHozonKikan<br />
 * @see     GenQAS_FileHozonKikan<br />
 */
@Entity
public class AS_FileHozonKikan extends GenAS_FileHozonKikan {

    private static final long serialVersionUID = 1L;

    public AS_FileHozonKikan() {
    }

    public AS_FileHozonKikan(C_FileSyuruiCdKbn pFileSyuruiCd) {
        super(pFileSyuruiCd);
    }



    private AS_FileSyurui aS_FileSyurui ;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne(cascade = { CascadeType.DETACH })
    @JoinColumn(name=AS_FileHozonKikan.FILESYURUICD  , referencedColumnName=AS_FileSyurui.FILESYURUICD, insertable=false, updatable=false)
    public  AS_FileSyurui getFileSyurui() {
        return aS_FileSyurui;
    }

    public void setFileSyurui(AS_FileSyurui pAS_FileSyurui) {
        this.aS_FileSyurui = pAS_FileSyurui;
    }

}

