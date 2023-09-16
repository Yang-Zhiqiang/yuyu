package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhHenkouRireki;


/**
 * 契約保全変更履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhHenkouRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhHenkouRireki<br />
 * @see     PKIT_KhHenkouRireki<br />
 * @see     QIT_KhHenkouRireki<br />
 * @see     GenQIT_KhHenkouRireki<br />
 */
@Entity
public class IT_KhHenkouRireki extends GenIT_KhHenkouRireki {

    private static final long serialVersionUID = 1L;

    public IT_KhHenkouRireki() {
    }

    public IT_KhHenkouRireki(String pKbnkey,String pSyono,String pHenkousikibetukey,Integer pRenno3keta) {
        super(pKbnkey,pSyono,pHenkousikibetukey,pRenno3keta);
    }

    public IT_KhHenkouRireki(String pSyono,String pHenkousikibetukey,Integer pRenno3keta) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey,pRenno3keta);
    }


    private IT_KhTtdkRireki iT_KhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KhHenkouRireki.KBNKEY  , referencedColumnName=IT_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhHenkouRireki.SYONO  , referencedColumnName=IT_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhHenkouRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_KhTtdkRireki getKhTtdkRireki() {
        return iT_KhTtdkRireki;
    }

    public void setKhTtdkRireki(IT_KhTtdkRireki pIT_KhTtdkRireki) {
        this.iT_KhTtdkRireki = pIT_KhTtdkRireki;
    }

}

