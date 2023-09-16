package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_SeihowebIdouRireki;

/**
 * 生保Ｗｅｂ用異動履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_SeihowebIdouRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_SeihowebIdouRireki<br />
 * @see     PKIT_SeihowebIdouRireki<br />
 * @see     QIT_SeihowebIdouRireki<br />
 * @see     GenQIT_SeihowebIdouRireki<br />
 */
@Entity
public class IT_SeihowebIdouRireki extends GenIT_SeihowebIdouRireki {

    private static final long serialVersionUID = 1L;

    public IT_SeihowebIdouRireki() {
    }

    public IT_SeihowebIdouRireki(String pKbnkey,String pSyono,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pHenkousikibetukey);
    }

    public IT_SeihowebIdouRireki(String pSyono,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey);
    }


    private IT_KhTtdkRireki iT_KhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_SeihowebIdouRireki.KBNKEY  , referencedColumnName=IT_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_SeihowebIdouRireki.SYONO  , referencedColumnName=IT_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_SeihowebIdouRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_KhTtdkRireki getKhTtdkRireki() {
        return iT_KhTtdkRireki;
    }

    public void setKhTtdkRireki(IT_KhTtdkRireki pIT_KhTtdkRireki) {
        this.iT_KhTtdkRireki = pIT_KhTtdkRireki;
    }

}

