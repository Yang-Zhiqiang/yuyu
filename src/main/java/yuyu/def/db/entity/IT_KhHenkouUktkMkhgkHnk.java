package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhHenkouUktkMkhgkHnk;


/**
 * 契約保全変更受付内容（目標額変更）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhHenkouUktkMkhgkHnk} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhHenkouUktkMkhgkHnk<br />
 * @see     PKIT_KhHenkouUktkMkhgkHnk<br />
 * @see     QIT_KhHenkouUktkMkhgkHnk<br />
 * @see     GenQIT_KhHenkouUktkMkhgkHnk<br />
 */
@Entity
public class IT_KhHenkouUktkMkhgkHnk extends GenIT_KhHenkouUktkMkhgkHnk {

    private static final long serialVersionUID = 1L;

    public IT_KhHenkouUktkMkhgkHnk() {
    }

    public IT_KhHenkouUktkMkhgkHnk(String pKbnkey,String pSyono,Integer pHozenhenkouuktkrenno) {
        super(pKbnkey,pSyono,pHozenhenkouuktkrenno);
    }

    public IT_KhHenkouUktkMkhgkHnk(String pSyono,Integer pHozenhenkouuktkrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHozenhenkouuktkrenno);
    }


    private IT_KhHenkouUktk iT_KhHenkouUktk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KhHenkouUktkMkhgkHnk.KBNKEY  , referencedColumnName=IT_KhHenkouUktk.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhHenkouUktkMkhgkHnk.SYONO  , referencedColumnName=IT_KhHenkouUktk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhHenkouUktkMkhgkHnk.HOZENHENKOUUKTKRENNO  , referencedColumnName=IT_KhHenkouUktk.HOZENHENKOUUKTKRENNO, insertable=false, updatable=false)
    })
    public IT_KhHenkouUktk getKhHenkouUktk() {
        return iT_KhHenkouUktk;
    }

    public void setKhHenkouUktk(IT_KhHenkouUktk pIT_KhHenkouUktk) {
        this.iT_KhHenkouUktk = pIT_KhHenkouUktk;
    }

}

