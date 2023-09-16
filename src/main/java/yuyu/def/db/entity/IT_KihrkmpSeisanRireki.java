package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KihrkmpSeisanRireki;


/**
 * 既払込Ｐ精算履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KihrkmpSeisanRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_KihrkmpSeisanRireki<br />
 * @see     PKIT_KihrkmpSeisanRireki<br />
 * @see     QIT_KihrkmpSeisanRireki<br />
 * @see     GenQIT_KihrkmpSeisanRireki<br />
 */
@Entity
public class IT_KihrkmpSeisanRireki extends GenIT_KihrkmpSeisanRireki {

    private static final long serialVersionUID = 1L;

    public IT_KihrkmpSeisanRireki() {
    }

    public IT_KihrkmpSeisanRireki(String pKbnkey,String pSyono,Integer pRenno) {
        super(pKbnkey,pSyono,pRenno);
    }

    public IT_KihrkmpSeisanRireki(String pSyono,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pRenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KihrkmpSeisanRireki.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KihrkmpSeisanRireki.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

