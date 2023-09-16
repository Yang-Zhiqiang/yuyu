package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KoujyoSymKanri;


/**
 * 控除証明書管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KoujyoSymKanri} の JavaDoc を参照してください。<br />
 * @see     GenIT_KoujyoSymKanri<br />
 * @see     PKIT_KoujyoSymKanri<br />
 * @see     QIT_KoujyoSymKanri<br />
 * @see     GenQIT_KoujyoSymKanri<br />
 */
@Entity
public class IT_KoujyoSymKanri extends GenIT_KoujyoSymKanri {

    private static final long serialVersionUID = 1L;

    public IT_KoujyoSymKanri() {
    }

    public IT_KoujyoSymKanri(String pKbnkey,String pSyono,String pNendo) {
        super(pKbnkey,pSyono,pNendo);
    }

    public IT_KoujyoSymKanri(String pSyono,String pNendo) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pNendo);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KoujyoSymKanri.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KoujyoSymKanri.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

