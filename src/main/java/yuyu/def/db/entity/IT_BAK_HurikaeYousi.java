package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_HurikaeYousi;

/**
 * 振替用紙バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_HurikaeYousi} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_HurikaeYousi<br />
 * @see     PKIT_BAK_HurikaeYousi<br />
 * @see     QIT_BAK_HurikaeYousi<br />
 * @see     GenQIT_BAK_HurikaeYousi<br />
 */
@Entity
public class IT_BAK_HurikaeYousi extends GenIT_BAK_HurikaeYousi {

    private static final long serialVersionUID = 1L;

    public IT_BAK_HurikaeYousi() {
    }

    public IT_BAK_HurikaeYousi(String pKbnkey,String pSyono,String pHenkousikibetukey,String pTrkssikibetukey) {
        super(pKbnkey,pSyono,pHenkousikibetukey,pTrkssikibetukey);
    }

    public IT_BAK_HurikaeYousi(String pSyono,String pHenkousikibetukey,String pTrkssikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey,pTrkssikibetukey);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_HurikaeYousi.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HurikaeYousi.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HurikaeYousi.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

