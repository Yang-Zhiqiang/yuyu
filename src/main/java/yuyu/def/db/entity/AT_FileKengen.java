package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.mapping.GenAT_FileKengen;


/**
 * ファイル権限テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_FileKengen} の JavaDoc を参照してください。<br />
 * @see     GenAT_FileKengen<br />
 * @see     PKAT_FileKengen<br />
 * @see     QAT_FileKengen<br />
 * @see     GenQAT_FileKengen<br />
 */
@Entity
public class AT_FileKengen extends GenAT_FileKengen {

    private static final long serialVersionUID = 1L;

    public AT_FileKengen() {
    }

    public AT_FileKengen(String pRoleCd,C_FileSyuruiCdKbn pFileSyuruiCd) {
        super(pRoleCd,pFileSyuruiCd);
    }



    private AS_FileSyurui aS_FileSyurui ;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne(cascade = { CascadeType.DETACH })
    @JoinColumn(name=AT_FileKengen.FILESYURUICD  , referencedColumnName=AS_FileSyurui.FILESYURUICD, insertable=false, updatable=false)
    public  AS_FileSyurui getFileSyurui() {
        return aS_FileSyurui;
    }

    public void setFileSyurui(AS_FileSyurui pAS_FileSyurui) {
        this.aS_FileSyurui = pAS_FileSyurui;
    }

    private AM_Role aM_Role ;

    @ManyToOne (fetch = FetchType.LAZY,
        cascade = { CascadeType.DETACH }
        )
    @JoinColumn(name=AT_FileKengen.ROLECD  , referencedColumnName=AM_Role.ROLECD, insertable=false, updatable=false)
    public  AM_Role getRole() {
        return aM_Role;
    }

    public void setRole(AM_Role pAM_Role) {
        this.aM_Role = pAM_Role;
    }

}

