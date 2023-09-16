package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_YykIdouUktk;


/**
 * 予約異動受付テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_YykIdouUktk} の JavaDoc を参照してください。<br />
 * @see     GenIT_YykIdouUktk<br />
 * @see     PKIT_YykIdouUktk<br />
 * @see     QIT_YykIdouUktk<br />
 * @see     GenQIT_YykIdouUktk<br />
 */
@Entity
public class IT_YykIdouUktk extends GenIT_YykIdouUktk {

    private static final long serialVersionUID = 1L;

    public IT_YykIdouUktk() {
    }

    public IT_YykIdouUktk(String pKbnkey,String pSyono,String pHenkousikibetukey,String pKinouId) {
        super(pKbnkey,pSyono,pHenkousikibetukey,pKinouId);
    }

    public IT_YykIdouUktk(String pSyono,String pHenkousikibetukey,String pKinouId) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey,pKinouId);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_YykIdouUktk.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_YykIdouUktk.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

