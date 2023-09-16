package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.mapping.GenIT_HengakuUnitRireki;


/**
 * 変額ユニット履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HengakuUnitRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_HengakuUnitRireki<br />
 * @see     PKIT_HengakuUnitRireki<br />
 * @see     QIT_HengakuUnitRireki<br />
 * @see     GenQIT_HengakuUnitRireki<br />
 */
@Entity
public class IT_HengakuUnitRireki extends GenIT_HengakuUnitRireki {

    private static final long serialVersionUID = 1L;

    public IT_HengakuUnitRireki() {
    }

    public IT_HengakuUnitRireki(String pKbnkey,String pSyono,C_UnitFundKbn pUnitfundkbn,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pUnitfundkbn,pHenkousikibetukey);
    }

    public IT_HengakuUnitRireki(String pSyono,C_UnitFundKbn pUnitfundkbn,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pUnitfundkbn,pHenkousikibetukey);
    }


    private IT_KhTtdkRireki iT_KhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_HengakuUnitRireki.KBNKEY  , referencedColumnName=IT_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_HengakuUnitRireki.SYONO  , referencedColumnName=IT_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_HengakuUnitRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_KhTtdkRireki getKhTtdkRireki() {
        return iT_KhTtdkRireki;
    }

    public void setKhTtdkRireki(IT_KhTtdkRireki pIT_KhTtdkRireki) {
        this.iT_KhTtdkRireki = pIT_KhTtdkRireki;
    }

}

