package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KoujyoSym;


/**
 * 控除証明書バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KoujyoSym} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KoujyoSym<br />
 * @see     PKIT_BAK_KoujyoSym<br />
 * @see     QIT_BAK_KoujyoSym<br />
 * @see     GenQIT_BAK_KoujyoSym<br />
 */
@Entity
public class IT_BAK_KoujyoSym extends GenIT_BAK_KoujyoSym {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KoujyoSym() {
    }

    public IT_BAK_KoujyoSym(String pKbnkey,String pSyono,String pTrkssikibetukey,String pNendo,BizDate pTyouhyouymd,Integer pRenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pNendo,pTyouhyouymd,pRenno);
    }

    public IT_BAK_KoujyoSym(String pSyono,String pTrkssikibetukey,String pNendo,BizDate pTyouhyouymd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pNendo,pTyouhyouymd,pRenno);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KoujyoSym.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KoujyoSym.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KoujyoSym.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

