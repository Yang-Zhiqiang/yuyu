package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KhHenkouRireki;


/**
 * 契約保全変更履歴バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhHenkouRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhHenkouRireki<br />
 * @see     PKIT_BAK_KhHenkouRireki<br />
 * @see     QIT_BAK_KhHenkouRireki<br />
 * @see     GenQIT_BAK_KhHenkouRireki<br />
 */
@Entity
public class IT_BAK_KhHenkouRireki extends GenIT_BAK_KhHenkouRireki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhHenkouRireki() {
    }

    public IT_BAK_KhHenkouRireki(String pKbnkey,String pSyono,String pTrkssikibetukey,String pHenkousikibetukey,Integer pRenno3keta) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHenkousikibetukey,pRenno3keta);
    }

    public IT_BAK_KhHenkouRireki(String pSyono,String pTrkssikibetukey,String pHenkousikibetukey,Integer pRenno3keta) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHenkousikibetukey,pRenno3keta);
    }


    private IT_BAK_KhTtdkRireki iT_BAKKhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KhHenkouRireki.KBNKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhHenkouRireki.SYONO  , referencedColumnName=IT_BAK_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhHenkouRireki.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhHenkouRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KhTtdkRireki getBAKKhTtdkRireki() {
        return iT_BAKKhTtdkRireki;
    }

    public void setBAKKhTtdkRireki(IT_BAK_KhTtdkRireki pIT_BAK_KhTtdkRireki) {
        this.iT_BAKKhTtdkRireki = pIT_BAK_KhTtdkRireki;
    }

}

