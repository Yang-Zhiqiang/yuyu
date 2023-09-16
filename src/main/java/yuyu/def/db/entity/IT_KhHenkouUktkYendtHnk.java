package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.id.PKIT_KhHenkouUktkYendtHnk;
import yuyu.def.db.mapping.GenIT_KhHenkouUktkYendtHnk;
import yuyu.def.db.meta.GenQIT_KhHenkouUktkYendtHnk;
import yuyu.def.db.meta.QIT_KhHenkouUktkYendtHnk;

/**
 * 契約保全変更受付内容（円建変更）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhHenkouUktkYendtHnk} の JavaDoc を参照してください。
 * @see     GenIT_KhHenkouUktkYendtHnk
 * @see     PKIT_KhHenkouUktkYendtHnk
 * @see     QIT_KhHenkouUktkYendtHnk
 * @see     GenQIT_KhHenkouUktkYendtHnk
 */
@Entity
public class IT_KhHenkouUktkYendtHnk extends GenIT_KhHenkouUktkYendtHnk {

    private static final long serialVersionUID = 1L;

    public IT_KhHenkouUktkYendtHnk() {
    }

    public IT_KhHenkouUktkYendtHnk(
        String pKbnkey,
        String pSyono,
        Integer pHozenhenkouuktkrenno
        ) {
        super(
            pKbnkey,
            pSyono,
            pHozenhenkouuktkrenno
            );
    }

    public IT_KhHenkouUktkYendtHnk(String pSyono, Integer pHozenhenkouuktkrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono), pSyono, pHozenhenkouuktkrenno);
    }

    private IT_KhHenkouUktk iT_KhHenkouUktk;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name = IT_KhHenkouUktkYendtHnk.KBNKEY, referencedColumnName = IT_KhHenkouUktk.KBNKEY, insertable = false, updatable = false),
        @JoinColumn(name = IT_KhHenkouUktkYendtHnk.SYONO, referencedColumnName = IT_KhHenkouUktk.SYONO, insertable = false, updatable = false),
        @JoinColumn(name = IT_KhHenkouUktkYendtHnk.HOZENHENKOUUKTKRENNO, referencedColumnName = IT_KhHenkouUktk.HOZENHENKOUUKTKRENNO, insertable = false, updatable = false)
    })
    public IT_KhHenkouUktk getKhHenkouUktk() {
        return iT_KhHenkouUktk;
    }

    public void setKhHenkouUktk(IT_KhHenkouUktk pIT_KhHenkouUktk) {
        this.iT_KhHenkouUktk = pIT_KhHenkouUktk;
    }

}