package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KihrkmpSeisanRireki;


/**
 * 既払込Ｐ精算履歴バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KihrkmpSeisanRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KihrkmpSeisanRireki<br />
 * @see     PKIT_BAK_KihrkmpSeisanRireki<br />
 * @see     QIT_BAK_KihrkmpSeisanRireki<br />
 * @see     GenQIT_BAK_KihrkmpSeisanRireki<br />
 */
@Entity
public class IT_BAK_KihrkmpSeisanRireki extends GenIT_BAK_KihrkmpSeisanRireki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KihrkmpSeisanRireki() {
    }

    public IT_BAK_KihrkmpSeisanRireki(String pKbnkey,String pSyono,String pTrkssikibetukey,Integer pRenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pRenno);
    }

    public IT_BAK_KihrkmpSeisanRireki(String pSyono,String pTrkssikibetukey,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pRenno);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KihrkmpSeisanRireki.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KihrkmpSeisanRireki.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KihrkmpSeisanRireki.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

