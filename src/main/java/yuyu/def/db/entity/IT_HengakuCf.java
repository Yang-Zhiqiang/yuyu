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
import yuyu.def.db.mapping.GenIT_HengakuCf;


/**
 * 変額ＣＦテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HengakuCf} の JavaDoc を参照してください。<br />
 * @see     GenIT_HengakuCf<br />
 * @see     PKIT_HengakuCf<br />
 * @see     QIT_HengakuCf<br />
 * @see     GenQIT_HengakuCf<br />
 */
@Entity
public class IT_HengakuCf extends GenIT_HengakuCf {

    private static final long serialVersionUID = 1L;

    public IT_HengakuCf() {
    }

    public IT_HengakuCf(String pKbnkey,String pSyono,String pHenkousikibetukey,C_UnitFundKbn pUnitfundkbn,BizDate pSyoriYmd,Integer pRenno) {
        super(pKbnkey,pSyono,pHenkousikibetukey,pUnitfundkbn,pSyoriYmd,pRenno);
    }

    public IT_HengakuCf(String pSyono,String pHenkousikibetukey,C_UnitFundKbn pUnitfundkbn,BizDate pSyoriYmd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey,pUnitfundkbn,pSyoriYmd,pRenno);
    }


    private IT_KhTtdkRireki iT_KhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_HengakuCf.KBNKEY  , referencedColumnName=IT_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_HengakuCf.SYONO  , referencedColumnName=IT_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_HengakuCf.HENKOUSIKIBETUKEY  , referencedColumnName=IT_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_KhTtdkRireki getKhTtdkRireki() {
        return iT_KhTtdkRireki;
    }

    public void setKhTtdkRireki(IT_KhTtdkRireki pIT_KhTtdkRireki) {
        this.iT_KhTtdkRireki = pIT_KhTtdkRireki;
    }

}

