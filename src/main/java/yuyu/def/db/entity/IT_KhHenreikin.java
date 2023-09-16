package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.id.PKIT_KhHenreikin;
import yuyu.def.db.mapping.GenIT_KhHenreikin;
import yuyu.def.db.meta.GenQIT_KhHenreikin;
import yuyu.def.db.meta.QIT_KhHenreikin;

/**
 * 契約保全返戻金テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhHenreikin} の JavaDoc を参照してください。
 * @see     GenIT_KhHenreikin
 * @see     PKIT_KhHenreikin
 * @see     QIT_KhHenreikin
 * @see     GenQIT_KhHenreikin
 */
@Entity
public class IT_KhHenreikin extends GenIT_KhHenreikin {

    private static final long serialVersionUID = 1L;

    public IT_KhHenreikin() {
    }

    public IT_KhHenreikin(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey
        ) {
        super(
            pKbnkey,
            pSyono,
            pHenkousikibetukey
            );
    }

    public IT_KhHenreikin(String pSyono,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey);
    }

    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KhHenreikin.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhHenreikin.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}
