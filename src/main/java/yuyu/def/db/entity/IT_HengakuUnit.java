package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.mapping.GenIT_HengakuUnit;


/**
 * 変額ユニットテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HengakuUnit} の JavaDoc を参照してください。<br />
 * @see     GenIT_HengakuUnit<br />
 * @see     PKIT_HengakuUnit<br />
 * @see     QIT_HengakuUnit<br />
 * @see     GenQIT_HengakuUnit<br />
 */
@Entity
public class IT_HengakuUnit extends GenIT_HengakuUnit {

    private static final long serialVersionUID = 1L;

    public IT_HengakuUnit() {
    }

    public IT_HengakuUnit(String pKbnkey,String pSyono,C_UnitFundKbn pUnitfundkbn) {
        super(pKbnkey,pSyono,pUnitfundkbn);
    }

    public IT_HengakuUnit(String pSyono,C_UnitFundKbn pUnitfundkbn) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pUnitfundkbn);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_HengakuUnit.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_HengakuUnit.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

