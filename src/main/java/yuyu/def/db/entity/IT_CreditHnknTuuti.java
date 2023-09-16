package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;



import yuyu.def.db.mapping.GenIT_CreditHnknTuuti;


/**
 * クレカ返金通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_CreditHnknTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_CreditHnknTuuti<br />
 * @see     PKIT_CreditHnknTuuti<br />
 * @see     QIT_CreditHnknTuuti<br />
 * @see     GenQIT_CreditHnknTuuti<br />
 */
@Entity
public class IT_CreditHnknTuuti extends GenIT_CreditHnknTuuti {

    private static final long serialVersionUID = 1L;

    public IT_CreditHnknTuuti() {
    }

    public IT_CreditHnknTuuti(String pKbnkey,String pSyono,String pDenrenno,Integer pEdano) {
        super(pKbnkey,pSyono,pDenrenno,pEdano);
    }

    public IT_CreditHnknTuuti(String pSyono,String pDenrenno,Integer pEdano) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pDenrenno,pEdano);
    }

    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_CreditHnknTuuti.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_CreditHnknTuuti.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }
}

