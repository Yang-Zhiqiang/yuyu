package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_ZougenKbn;
import yuyu.def.db.mapping.GenIT_HokenKykIdouRireki;


/**
 * 保険契約異動情報履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HokenKykIdouRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_HokenKykIdouRireki<br />
 * @see     PKIT_HokenKykIdouRireki<br />
 * @see     QIT_HokenKykIdouRireki<br />
 * @see     GenQIT_HokenKykIdouRireki<br />
 */
@Entity
public class IT_HokenKykIdouRireki extends GenIT_HokenKykIdouRireki {

    private static final long serialVersionUID = 1L;

    public IT_HokenKykIdouRireki() {
    }

    public IT_HokenKykIdouRireki(String pKbnkey,String pSyono,String pHenkousikibetukey,C_ZougenKbn pZougenkbn) {
        super(pKbnkey,pSyono,pHenkousikibetukey,pZougenkbn);
    }

    public IT_HokenKykIdouRireki(String pSyono,String pHenkousikibetukey,C_ZougenKbn pZougenkbn) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey,pZougenkbn);
    }


    private IT_KhTtdkRireki iT_KhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_HokenKykIdouRireki.KBNKEY  , referencedColumnName=IT_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_HokenKykIdouRireki.SYONO  , referencedColumnName=IT_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_HokenKykIdouRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_KhTtdkRireki getKhTtdkRireki() {
        return iT_KhTtdkRireki;
    }

    public void setKhTtdkRireki(IT_KhTtdkRireki pIT_KhTtdkRireki) {
        this.iT_KhTtdkRireki = pIT_KhTtdkRireki;
    }

}

