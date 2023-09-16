package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.id.PKAT_TyouhyouKensaku;
import yuyu.def.db.mapping.GenAT_TyouhyouKensaku;
import yuyu.def.db.meta.GenQAT_TyouhyouKensaku;
import yuyu.def.db.meta.QAT_TyouhyouKensaku;

/**
 * 帳票検索テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_TyouhyouKensaku} の JavaDoc を参照してください。
 * @see     GenAT_TyouhyouKensaku
 * @see     PKAT_TyouhyouKensaku
 * @see     QAT_TyouhyouKensaku
 * @see     GenQAT_TyouhyouKensaku
 */
@Entity
public class AT_TyouhyouKensaku extends GenAT_TyouhyouKensaku {

    private static final long serialVersionUID = 1L;

    public AT_TyouhyouKensaku() {
    }

    public AT_TyouhyouKensaku(String pUniqueId) {
        super(pUniqueId);
    }

    @Transient
    public AT_TyouhyouHozon getTyouhyouHozon() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        return baseDomManager.getTyouhyouHozon(this.getReportKey());
    }

    private AM_SyoruiZokusei aM_SyoruiZokusei;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name = AT_TyouhyouKensaku.SYORUICD, referencedColumnName = AM_SyoruiZokusei.SYORUICD, insertable=false, updatable=false)
    public AM_SyoruiZokusei getSyoruiZokusei(){
        return aM_SyoruiZokusei;
    }

    public void setSyoruiZokusei(AM_SyoruiZokusei pSyoruiZokusei){
        aM_SyoruiZokusei = pSyoruiZokusei;
    }
}
