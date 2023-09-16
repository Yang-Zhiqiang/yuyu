package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.id.PKIT_AeoiInfo;
import yuyu.def.db.mapping.GenIT_AeoiInfo;
import yuyu.def.db.meta.GenQIT_AeoiInfo;
import yuyu.def.db.meta.QIT_AeoiInfo;

/**
 * ＡＥＯＩ情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_AeoiInfo} の JavaDoc を参照してください。
 * @see     GenIT_AeoiInfo
 * @see     PKIT_AeoiInfo
 * @see     QIT_AeoiInfo
 * @see     GenQIT_AeoiInfo
 */
@Entity
public class IT_AeoiInfo extends GenIT_AeoiInfo {

    private static final long serialVersionUID = 1L;

    public IT_AeoiInfo() {
    }

    public IT_AeoiInfo(
        String pKbnkey,
        String pSyono,
        Integer pRenno
        ) {
        super(
            pKbnkey,
            pSyono,
            pRenno
            );
    }

    public IT_AeoiInfo(String pSyono,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pRenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_AeoiInfo.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_AeoiInfo.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

