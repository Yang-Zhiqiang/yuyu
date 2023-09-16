package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.mapping.GenIT_BAK_HengakuUnit;


/**
 * 変額ユニットバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_HengakuUnit} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_HengakuUnit<br />
 * @see     PKIT_BAK_HengakuUnit<br />
 * @see     QIT_BAK_HengakuUnit<br />
 * @see     GenQIT_BAK_HengakuUnit<br />
 */
@Entity
public class IT_BAK_HengakuUnit extends GenIT_BAK_HengakuUnit {

    private static final long serialVersionUID = 1L;

    public IT_BAK_HengakuUnit() {
    }

    public IT_BAK_HengakuUnit(String pKbnkey,String pSyono,String pTrkssikibetukey,C_UnitFundKbn pUnitfundkbn) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pUnitfundkbn);
    }

    public IT_BAK_HengakuUnit(String pSyono,String pTrkssikibetukey,C_UnitFundKbn pUnitfundkbn) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pUnitfundkbn);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_HengakuUnit.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HengakuUnit.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HengakuUnit.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

