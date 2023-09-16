package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.id.PKAT_FileHozonInfo;
import yuyu.def.db.mapping.GenAT_FileHozonInfo;
import yuyu.def.db.meta.GenQAT_FileHozonInfo;
import yuyu.def.db.meta.QAT_FileHozonInfo;

/**
 * ファイル保存情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_FileHozonInfo} の JavaDoc を参照してください。
 * @see     GenAT_FileHozonInfo
 * @see     PKAT_FileHozonInfo
 * @see     QAT_FileHozonInfo
 * @see     GenQAT_FileHozonInfo
 */
@Entity
public class AT_FileHozonInfo extends GenAT_FileHozonInfo {

    private static final long serialVersionUID = 1L;

    public AT_FileHozonInfo() {
    }

    public AT_FileHozonInfo(String pUniqueId) {
        super(pUniqueId);
    }

    private AS_FileSyurui aS_FileSyurui;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AT_FileHozonInfo.FILESYURUICD, referencedColumnName=AS_FileSyurui.FILESYURUICD, insertable=false, updatable=false)
    public AS_FileSyurui getFileSyurui(){
        return aS_FileSyurui;
    }

    public void setFileSyurui(AS_FileSyurui pFileSyurui){
        aS_FileSyurui = pFileSyurui;
    }

    @Transient
    public AT_FileHozon getFileHozon() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        return baseDomManager.getFileHozon(this.getUniqueId());
    }

  
    private AT_FileSansyoKaisu aT_FileSansyoKaisu ;

    @LazyToOne(LazyToOneOption.FALSE)
    @OneToOne (
            mappedBy = "fileHozonInfo",
            cascade = { CascadeType.ALL },
            orphanRemoval = true
            )

    public  AT_FileSansyoKaisu getFileSansyoKaisu() {
        return aT_FileSansyoKaisu;
    }

    public void setFileSansyoKaisu(AT_FileSansyoKaisu pAT_FileSansyoKaisu) {
        this.aT_FileSansyoKaisu = pAT_FileSansyoKaisu;
    }
    public AT_FileSansyoKaisu createFileSansyoKaisu() {
        AT_FileSansyoKaisu fileSansyoKaisu =  new AT_FileSansyoKaisu();
        fileSansyoKaisu.setFileHozonInfo(this);
        fileSansyoKaisu.setUniqueId(this.getUniqueId());
        setFileSansyoKaisu(fileSansyoKaisu);
        return fileSansyoKaisu;
    }


}
