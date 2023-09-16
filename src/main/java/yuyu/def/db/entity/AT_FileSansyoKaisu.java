package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.mapping.GenAT_FileSansyoKaisu;


/**
 * ファイル参照回数テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_FileSansyoKaisu} の JavaDoc を参照してください。<br />
 * @see     GenAT_FileSansyoKaisu<br />
 * @see     PKAT_FileSansyoKaisu<br />
 * @see     QAT_FileSansyoKaisu<br />
 * @see     GenQAT_FileSansyoKaisu<br />
 */
@Entity
public class AT_FileSansyoKaisu extends GenAT_FileSansyoKaisu {

    private static final long serialVersionUID = 1L;

    public AT_FileSansyoKaisu() {
    }

    public AT_FileSansyoKaisu(String pUniqueId) {
        super(pUniqueId);
    }


  
    private AT_FileHozonInfo aT_FileHozonInfo ;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne(cascade = { CascadeType.DETACH })
        @JoinColumn(name=AT_FileSansyoKaisu.UNIQUEID  , referencedColumnName=AT_FileHozonInfo.UNIQUEID, insertable=false, updatable=false)
    public  AT_FileHozonInfo getFileHozonInfo() {
        return aT_FileHozonInfo;
    }

    public void setFileHozonInfo(AT_FileHozonInfo pAT_FileHozonInfo) {
        this.aT_FileHozonInfo = pAT_FileHozonInfo;
    }

}

