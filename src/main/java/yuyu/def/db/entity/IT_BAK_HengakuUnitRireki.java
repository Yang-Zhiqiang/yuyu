package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.mapping.GenIT_BAK_HengakuUnitRireki;


/**
 * 変額ユニット履歴バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_HengakuUnitRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_HengakuUnitRireki<br />
 * @see     PKIT_BAK_HengakuUnitRireki<br />
 * @see     QIT_BAK_HengakuUnitRireki<br />
 * @see     GenQIT_BAK_HengakuUnitRireki<br />
 */
@Entity
public class IT_BAK_HengakuUnitRireki extends GenIT_BAK_HengakuUnitRireki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_HengakuUnitRireki() {
    }

    public IT_BAK_HengakuUnitRireki(String pKbnkey,String pSyono,String pTrkssikibetukey,C_UnitFundKbn pUnitfundkbn,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pUnitfundkbn,pHenkousikibetukey);
    }

    public IT_BAK_HengakuUnitRireki(String pSyono,String pTrkssikibetukey,C_UnitFundKbn pUnitfundkbn,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pUnitfundkbn,pHenkousikibetukey);
    }


    private IT_BAK_KhTtdkRireki iT_BAKKhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_HengakuUnitRireki.KBNKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HengakuUnitRireki.SYONO  , referencedColumnName=IT_BAK_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HengakuUnitRireki.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HengakuUnitRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KhTtdkRireki getBAKKhTtdkRireki() {
        return iT_BAKKhTtdkRireki;
    }

    public void setBAKKhTtdkRireki(IT_BAK_KhTtdkRireki pIT_BAK_KhTtdkRireki) {
        this.iT_BAKKhTtdkRireki = pIT_BAK_KhTtdkRireki;
    }

}

