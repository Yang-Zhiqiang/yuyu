package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_Kouza;


/**
 * 口座テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_Kouza} の JavaDoc を参照してください。<br />
 * @see     GenIT_Kouza<br />
 * @see     PKIT_Kouza<br />
 * @see     QIT_Kouza<br />
 * @see     GenQIT_Kouza<br />
 */
@Entity
public class IT_Kouza extends GenIT_Kouza {

    private static final long serialVersionUID = 1L;

    public IT_Kouza() {
    }

    public IT_Kouza(String pKbnkey,String pSyono) {
        super(pKbnkey,pSyono);
    }

    public IT_Kouza(String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_Kouza.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_Kouza.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

    private BM_Ginkou bM_Ginkou ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=IT_Kouza.BANKCD  , referencedColumnName=BM_Ginkou.BANKCD, insertable=false, updatable=false),
        @JoinColumn(name=IT_Kouza.SITENCD  , referencedColumnName=BM_Ginkou.SITENCD, insertable=false, updatable=false)
    })
    public  BM_Ginkou getGinkou() {
        return bM_Ginkou;
    }

    public void setGinkou(BM_Ginkou pBM_Ginkou) {
        this.bM_Ginkou = pBM_Ginkou;
    }

}

