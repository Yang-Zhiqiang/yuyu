package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.google.common.collect.Lists;

import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.id.PKAS_FileSyurui;
import yuyu.def.db.mapping.GenAS_FileSyurui;
import yuyu.def.db.meta.GenQAS_FileSyurui;
import yuyu.def.db.meta.QAS_FileSyurui;

/**
 * ファイル種類基幹テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_FileSyurui} の JavaDoc を参照してください。
 * @see     GenAS_FileSyurui
 * @see     PKAS_FileSyurui
 * @see     QAS_FileSyurui
 * @see     GenQAS_FileSyurui
 */
@Entity
public class AS_FileSyurui extends GenAS_FileSyurui {

    private static final long serialVersionUID = 1L;

    public AS_FileSyurui() {
    }

    public AS_FileSyurui(C_FileSyuruiCdKbn pFileSyuruiCd) {
        super(pFileSyuruiCd);
    }



    private AS_FileHozonKikan aS_FileHozonKikan ;

    @LazyToOne(LazyToOneOption.FALSE)
    @OneToOne (
        mappedBy = "fileSyurui",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )

    public  AS_FileHozonKikan getFileHozonKikan() {
        return aS_FileHozonKikan;
    }

    public void setFileHozonKikan(AS_FileHozonKikan pAS_FileHozonKikan) {
        this.aS_FileHozonKikan = pAS_FileHozonKikan;
    }
    public AS_FileHozonKikan createFileHozonKikan() {
        AS_FileHozonKikan fileHozonKikan =  new AS_FileHozonKikan();
        fileHozonKikan.setFileSyurui(this);
        fileHozonKikan.setFileSyuruiCd(this.getFileSyuruiCd());
        setFileHozonKikan(fileHozonKikan);
        return fileHozonKikan;
    }


    private List<AT_FileKengen> aT_FileKengens = Lists.newLinkedList();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany (
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @JoinColumn(name=AT_FileKengen.FILESYURUICD  , referencedColumnName=AS_FileSyurui.FILESYURUICD, insertable=false, updatable=false)
    @OrderBy(AT_FileKengen.ROLECD+" ASC ,"+AT_FileKengen.FILESYURUICD+" ASC ")
    public  List<AT_FileKengen> getFileKengens() {
        return aT_FileKengens;
    }

    public void setFileKengens(List<AT_FileKengen> pAT_FileKengens) {
        this.aT_FileKengens = pAT_FileKengens;
    }
    public AT_FileKengen createFileKengen() {
        AT_FileKengen fileKengen =  new AT_FileKengen();
        fileKengen.setFileSyurui(this);
        fileKengen.setFileSyuruiCd(this.getFileSyuruiCd());
        getFileKengens().add(fileKengen);
        return fileKengen;
    }
}