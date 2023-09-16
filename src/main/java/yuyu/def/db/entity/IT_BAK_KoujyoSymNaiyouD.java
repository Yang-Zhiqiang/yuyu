package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KoujyoSymNaiyouD;

/**
 * 控除証明内容Ｄバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KoujyoSymNaiyouD} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KoujyoSymNaiyouD<br />
 * @see     PKIT_BAK_KoujyoSymNaiyouD<br />
 * @see     QIT_BAK_KoujyoSymNaiyouD<br />
 * @see     GenQIT_BAK_KoujyoSymNaiyouD<br />
 */
@Entity
public class IT_BAK_KoujyoSymNaiyouD extends GenIT_BAK_KoujyoSymNaiyouD {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KoujyoSymNaiyouD() {
    }

    public IT_BAK_KoujyoSymNaiyouD(String pKbnkey,String pSyono,String pTrkssikibetukey,String pSyouhncd,Integer pRenno3keta) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pSyouhncd,pRenno3keta);
    }

    public IT_BAK_KoujyoSymNaiyouD(String pSyono,String pTrkssikibetukey,String pSyouhncd,Integer pRenno3keta) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pSyouhncd,pRenno3keta);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KoujyoSymNaiyouD.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KoujyoSymNaiyouD.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KoujyoSymNaiyouD.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

