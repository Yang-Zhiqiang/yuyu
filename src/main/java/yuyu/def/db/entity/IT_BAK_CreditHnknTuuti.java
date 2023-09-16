package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_CreditHnknTuuti;


/**
 * クレカ返金通知バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_CreditHnknTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_CreditHnknTuuti<br />
 * @see     PKIT_BAK_CreditHnknTuuti<br />
 * @see     QIT_BAK_CreditHnknTuuti<br />
 * @see     GenQIT_BAK_CreditHnknTuuti<br />
 */
@Entity
public class IT_BAK_CreditHnknTuuti extends GenIT_BAK_CreditHnknTuuti {

    private static final long serialVersionUID = 1L;

    public IT_BAK_CreditHnknTuuti() {
    }

    public IT_BAK_CreditHnknTuuti(String pKbnkey,String pSyono,String pTrkssikibetukey,String pDenrenno,Integer pEdano) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pDenrenno,pEdano);
    }

    public IT_BAK_CreditHnknTuuti(String pSyono,String pTrkssikibetukey,String pDenrenno,Integer pEdano) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pDenrenno,pEdano);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_CreditHnknTuuti.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_CreditHnknTuuti.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_CreditHnknTuuti.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

