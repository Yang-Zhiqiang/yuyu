package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;



import yuyu.def.db.mapping.GenIT_KykSyaHenkouRireki;


/**
 * 契約者変更履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KykSyaHenkouRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_KykSyaHenkouRireki<br />
 * @see     PKIT_KykSyaHenkouRireki<br />
 * @see     QIT_KykSyaHenkouRireki<br />
 * @see     GenQIT_KykSyaHenkouRireki<br />
 */
@Entity
public class IT_KykSyaHenkouRireki extends GenIT_KykSyaHenkouRireki {

    private static final long serialVersionUID = 1L;

    public IT_KykSyaHenkouRireki() {
    }

    public IT_KykSyaHenkouRireki(String pKbnkey,String pSyono,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pHenkousikibetukey);
    }

    public IT_KykSyaHenkouRireki(String pSyono,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey);
    }


    private IT_KhTtdkRireki iT_KhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KykSyaHenkouRireki.KBNKEY  , referencedColumnName=IT_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KykSyaHenkouRireki.SYONO  , referencedColumnName=IT_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_KykSyaHenkouRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_KhTtdkRireki getKhTtdkRireki() {
        return iT_KhTtdkRireki;
    }

    public void setKhTtdkRireki(IT_KhTtdkRireki pIT_KhTtdkRireki) {
        this.iT_KhTtdkRireki = pIT_KhTtdkRireki;
    }

}

