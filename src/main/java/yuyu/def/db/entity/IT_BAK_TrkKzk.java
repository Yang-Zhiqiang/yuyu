package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.db.mapping.GenIT_BAK_TrkKzk;


/**
 * 登録家族バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_TrkKzk} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_TrkKzk<br />
 * @see     PKIT_BAK_TrkKzk<br />
 * @see     QIT_BAK_TrkKzk<br />
 * @see     GenQIT_BAK_TrkKzk<br />
 */
@Entity
public class IT_BAK_TrkKzk extends GenIT_BAK_TrkKzk {

    private static final long serialVersionUID = 1L;

    public IT_BAK_TrkKzk() {
    }

    public IT_BAK_TrkKzk(String pKbnkey,String pSyono,String pTrkssikibetukey,C_TrkKzkKbn pTrkkzkkbn) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pTrkkzkkbn);
    }

    public IT_BAK_TrkKzk(String pSyono,String pTrkssikibetukey,C_TrkKzkKbn pTrkkzkkbn) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pTrkkzkkbn);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_TrkKzk.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_TrkKzk.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_TrkKzk.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

