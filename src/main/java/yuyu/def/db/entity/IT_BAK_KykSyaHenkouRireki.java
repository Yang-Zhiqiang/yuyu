package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KykSyaHenkouRireki;


/**
 * 契約者変更履歴バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KykSyaHenkouRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KykSyaHenkouRireki<br />
 * @see     PKIT_BAK_KykSyaHenkouRireki<br />
 * @see     QIT_BAK_KykSyaHenkouRireki<br />
 * @see     GenQIT_BAK_KykSyaHenkouRireki<br />
 */
@Entity
public class IT_BAK_KykSyaHenkouRireki extends GenIT_BAK_KykSyaHenkouRireki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KykSyaHenkouRireki() {
    }

    public IT_BAK_KykSyaHenkouRireki(String pKbnkey,String pSyono,String pTrkssikibetukey,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHenkousikibetukey);
    }

    public IT_BAK_KykSyaHenkouRireki(String pSyono,String pTrkssikibetukey,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHenkousikibetukey);
    }


    private IT_BAK_KhTtdkRireki iT_BAKKhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KykSyaHenkouRireki.KBNKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KykSyaHenkouRireki.SYONO  , referencedColumnName=IT_BAK_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KykSyaHenkouRireki.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KykSyaHenkouRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KhTtdkRireki getBAKKhTtdkRireki() {
        return iT_BAKKhTtdkRireki;
    }

    public void setBAKKhTtdkRireki(IT_BAK_KhTtdkRireki pIT_BAK_KhTtdkRireki) {
        this.iT_BAKKhTtdkRireki = pIT_BAK_KhTtdkRireki;
    }

}

