package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_ZougenKbn;
import yuyu.def.db.mapping.GenIT_BAK_HokenKykIdouRireki;


/**
 * 保険契約異動情報履歴バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_HokenKykIdouRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_HokenKykIdouRireki<br />
 * @see     PKIT_BAK_HokenKykIdouRireki<br />
 * @see     QIT_BAK_HokenKykIdouRireki<br />
 * @see     GenQIT_BAK_HokenKykIdouRireki<br />
 */
@Entity
public class IT_BAK_HokenKykIdouRireki extends GenIT_BAK_HokenKykIdouRireki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_HokenKykIdouRireki() {
    }

    public IT_BAK_HokenKykIdouRireki(String pKbnkey,String pSyono,String pTrkssikibetukey,String pHenkousikibetukey,C_ZougenKbn pZougenkbn) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHenkousikibetukey,pZougenkbn);
    }

    public IT_BAK_HokenKykIdouRireki(String pSyono,String pTrkssikibetukey,String pHenkousikibetukey,C_ZougenKbn pZougenkbn) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHenkousikibetukey,pZougenkbn);
    }


    private IT_BAK_KhTtdkRireki iT_BAKKhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_HokenKykIdouRireki.KBNKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HokenKykIdouRireki.SYONO  , referencedColumnName=IT_BAK_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HokenKykIdouRireki.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HokenKykIdouRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KhTtdkRireki getBAKKhTtdkRireki() {
        return iT_BAKKhTtdkRireki;
    }

    public void setBAKKhTtdkRireki(IT_BAK_KhTtdkRireki pIT_BAK_KhTtdkRireki) {
        this.iT_BAKKhTtdkRireki = pIT_BAK_KhTtdkRireki;
    }

}

