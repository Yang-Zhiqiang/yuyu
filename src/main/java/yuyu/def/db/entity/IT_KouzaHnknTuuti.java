package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KouzaHnknTuuti;

/**
 * 口座返金通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KouzaHnknTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_KouzaHnknTuuti<br />
 * @see     PKIT_KouzaHnknTuuti<br />
 * @see     QIT_KouzaHnknTuuti<br />
 * @see     GenQIT_KouzaHnknTuuti<br />
 */
@Entity
public class IT_KouzaHnknTuuti extends GenIT_KouzaHnknTuuti {

    private static final long serialVersionUID = 1L;

    public IT_KouzaHnknTuuti() {
    }

    public IT_KouzaHnknTuuti(String pKbnkey,String pSyono,String pDenrenno,Integer pEdano) {
        super(pKbnkey,pSyono,pDenrenno,pEdano);
    }

    public IT_KouzaHnknTuuti(String pSyono,String pDenrenno,Integer pEdano) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pDenrenno,pEdano);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KouzaHnknTuuti.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KouzaHnknTuuti.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

