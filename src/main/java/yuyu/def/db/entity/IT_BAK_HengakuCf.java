package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.mapping.GenIT_BAK_HengakuCf;


/**
 * 変額ＣＦバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_HengakuCf} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_HengakuCf<br />
 * @see     PKIT_BAK_HengakuCf<br />
 * @see     QIT_BAK_HengakuCf<br />
 * @see     GenQIT_BAK_HengakuCf<br />
 */
@Entity
public class IT_BAK_HengakuCf extends GenIT_BAK_HengakuCf {

    private static final long serialVersionUID = 1L;

    public IT_BAK_HengakuCf() {
    }

    public IT_BAK_HengakuCf(String pKbnkey,String pSyono,String pTrkssikibetukey,String pHenkousikibetukey,C_UnitFundKbn pUnitfundkbn,BizDate pSyoriYmd,Integer pRenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHenkousikibetukey,pUnitfundkbn,pSyoriYmd,pRenno);
    }

    public IT_BAK_HengakuCf(String pSyono,String pTrkssikibetukey,String pHenkousikibetukey,C_UnitFundKbn pUnitfundkbn,BizDate pSyoriYmd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHenkousikibetukey,pUnitfundkbn,pSyoriYmd,pRenno);
    }


    private IT_BAK_KhTtdkRireki iT_BAKKhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_HengakuCf.KBNKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HengakuCf.SYONO  , referencedColumnName=IT_BAK_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HengakuCf.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HengakuCf.HENKOUSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KhTtdkRireki getBAKKhTtdkRireki() {
        return iT_BAKKhTtdkRireki;
    }

    public void setBAKKhTtdkRireki(IT_BAK_KhTtdkRireki pIT_BAK_KhTtdkRireki) {
        this.iT_BAKKhTtdkRireki = pIT_BAK_KhTtdkRireki;
    }

}

