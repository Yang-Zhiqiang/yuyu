package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_HurikaeYousi;

/**
 * 振替用紙テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HurikaeYousi} の JavaDoc を参照してください。<br />
 * @see     GenIT_HurikaeYousi<br />
 * @see     PKIT_HurikaeYousi<br />
 * @see     QIT_HurikaeYousi<br />
 * @see     GenQIT_HurikaeYousi<br />
 */
@Entity
public class IT_HurikaeYousi extends GenIT_HurikaeYousi {

    private static final long serialVersionUID = 1L;

    public IT_HurikaeYousi() {
    }

    public IT_HurikaeYousi(String pKbnkey,String pSyono,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pHenkousikibetukey);
    }

    public IT_HurikaeYousi(String pSyono,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_HurikaeYousi.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_HurikaeYousi.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

