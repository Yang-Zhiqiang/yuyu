package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KouzaHrkmTuuti;

/**
 * 口座振込通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KouzaHrkmTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_KouzaHrkmTuuti<br />
 * @see     PKIT_KouzaHrkmTuuti<br />
 * @see     QIT_KouzaHrkmTuuti<br />
 * @see     GenQIT_KouzaHrkmTuuti<br />
 */
@Entity
public class IT_KouzaHrkmTuuti extends GenIT_KouzaHrkmTuuti {

    private static final long serialVersionUID = 1L;

    public IT_KouzaHrkmTuuti() {
    }

    public IT_KouzaHrkmTuuti(String pKbnkey,String pSyono,Integer pKrkno) {
        super(pKbnkey,pSyono,pKrkno);
    }

    public IT_KouzaHrkmTuuti(String pSyono,Integer pKrkno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pKrkno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KouzaHrkmTuuti.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KouzaHrkmTuuti.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

