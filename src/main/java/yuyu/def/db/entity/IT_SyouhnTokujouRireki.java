package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.mapping.GenIT_SyouhnTokujouRireki;


/**
 * 商品特条履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_SyouhnTokujouRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_SyouhnTokujouRireki<br />
 * @see     PKIT_SyouhnTokujouRireki<br />
 * @see     QIT_SyouhnTokujouRireki<br />
 * @see     GenQIT_SyouhnTokujouRireki<br />
 */
@Entity
public class IT_SyouhnTokujouRireki extends GenIT_SyouhnTokujouRireki {

    private static final long serialVersionUID = 1L;

    public IT_SyouhnTokujouRireki() {
    }

    public IT_SyouhnTokujouRireki(String pKbnkey,String pSyono,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno,pHenkousikibetukey);
    }

    public IT_SyouhnTokujouRireki(String pSyono,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno,pHenkousikibetukey);
    }


    private IT_KhTtdkRireki iT_KhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_SyouhnTokujouRireki.KBNKEY  , referencedColumnName=IT_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_SyouhnTokujouRireki.SYONO  , referencedColumnName=IT_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_SyouhnTokujouRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_KhTtdkRireki getKhTtdkRireki() {
        return iT_KhTtdkRireki;
    }

    public void setKhTtdkRireki(IT_KhTtdkRireki pIT_KhTtdkRireki) {
        this.iT_KhTtdkRireki = pIT_KhTtdkRireki;
    }

}

