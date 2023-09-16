package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.id.PKAS_TyouhyouSakujyotaisyo;
import yuyu.def.db.mapping.GenAS_TyouhyouSakujyotaisyo;
import yuyu.def.db.meta.GenQAS_TyouhyouSakujyotaisyo;
import yuyu.def.db.meta.QAS_TyouhyouSakujyotaisyo;

/**
 * 帳票削除対象基幹テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_TyouhyouSakujyotaisyo} の JavaDoc を参照してください。
 * @see     GenAS_TyouhyouSakujyotaisyo
 * @see     PKAS_TyouhyouSakujyotaisyo
 * @see     QAS_TyouhyouSakujyotaisyo
 * @see     GenQAS_TyouhyouSakujyotaisyo
 */
@Entity
public class AS_TyouhyouSakujyotaisyo extends GenAS_TyouhyouSakujyotaisyo {

    private static final long serialVersionUID = 1L;

    public AS_TyouhyouSakujyotaisyo() {
    }

    public AS_TyouhyouSakujyotaisyo(C_SyoruiCdKbn pSyoruiCd) {
        super(pSyoruiCd);
    }



    private AM_SyoruiZokusei aM_SyoruiZokusei ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=AS_TyouhyouSakujyotaisyo.SYORUICD  , referencedColumnName=AM_SyoruiZokusei.SYORUICD, insertable=false, updatable=false)
    })
    public  AM_SyoruiZokusei getSyoruiZokusei() {
        return aM_SyoruiZokusei;
    }

    public void setSyoruiZokusei(AM_SyoruiZokusei pAM_SyoruiZokusei) {
        this.aM_SyoruiZokusei = pAM_SyoruiZokusei;
    }

}

