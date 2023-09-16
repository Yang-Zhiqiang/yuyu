package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.id.PKIT_BAK_AeoiInfo;
import yuyu.def.db.mapping.GenIT_BAK_AeoiInfo;
import yuyu.def.db.meta.GenQIT_BAK_AeoiInfo;
import yuyu.def.db.meta.QIT_BAK_AeoiInfo;

/**
 * ＡＥＯＩ情報バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_AeoiInfo} の JavaDoc を参照してください。
 * @see     GenIT_BAK_AeoiInfo
 * @see     PKIT_BAK_AeoiInfo
 * @see     QIT_BAK_AeoiInfo
 * @see     GenQIT_BAK_AeoiInfo
 */
@Entity
public class IT_BAK_AeoiInfo extends GenIT_BAK_AeoiInfo {

    private static final long serialVersionUID = 1L;

    public IT_BAK_AeoiInfo() {
    }

    public IT_BAK_AeoiInfo(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        Integer pRenno
        ) {
        super(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pRenno
            );
    }

    public IT_BAK_AeoiInfo(String pSyono,String pTrkssikibetukey,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pRenno);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_AeoiInfo.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_AeoiInfo.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_AeoiInfo.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

