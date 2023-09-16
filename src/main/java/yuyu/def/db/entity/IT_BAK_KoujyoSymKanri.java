package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KoujyoSymKanri;


/**
 * 控除証明書管理バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KoujyoSymKanri} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KoujyoSymKanri<br />
 * @see     PKIT_BAK_KoujyoSymKanri<br />
 * @see     QIT_BAK_KoujyoSymKanri<br />
 * @see     GenQIT_BAK_KoujyoSymKanri<br />
 */
@Entity
public class IT_BAK_KoujyoSymKanri extends GenIT_BAK_KoujyoSymKanri {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KoujyoSymKanri() {
    }

    public IT_BAK_KoujyoSymKanri(String pKbnkey,String pSyono,String pTrkssikibetukey,String pNendo) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pNendo);
    }

    public IT_BAK_KoujyoSymKanri(String pSyono,String pTrkssikibetukey,String pNendo) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pNendo);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KoujyoSymKanri.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KoujyoSymKanri.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KoujyoSymKanri.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

