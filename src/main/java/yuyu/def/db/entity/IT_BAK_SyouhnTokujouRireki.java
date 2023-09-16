package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.mapping.GenIT_BAK_SyouhnTokujouRireki;


/**
 * 商品特条履歴バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_SyouhnTokujouRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_SyouhnTokujouRireki<br />
 * @see     PKIT_BAK_SyouhnTokujouRireki<br />
 * @see     QIT_BAK_SyouhnTokujouRireki<br />
 * @see     GenQIT_BAK_SyouhnTokujouRireki<br />
 */
@Entity
public class IT_BAK_SyouhnTokujouRireki extends GenIT_BAK_SyouhnTokujouRireki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_SyouhnTokujouRireki() {
    }

    public IT_BAK_SyouhnTokujouRireki(String pKbnkey,String pSyono,String pTrkssikibetukey,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno,pHenkousikibetukey);
    }

    public IT_BAK_SyouhnTokujouRireki(String pSyono,String pTrkssikibetukey,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno,pHenkousikibetukey);
    }


    private IT_BAK_KhTtdkRireki iT_BAKKhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_SyouhnTokujouRireki.KBNKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_SyouhnTokujouRireki.SYONO  , referencedColumnName=IT_BAK_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_SyouhnTokujouRireki.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_SyouhnTokujouRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KhTtdkRireki getBAKKhTtdkRireki() {
        return iT_BAKKhTtdkRireki;
    }

    public void setBAKKhTtdkRireki(IT_BAK_KhTtdkRireki pIT_BAK_KhTtdkRireki) {
        this.iT_BAKKhTtdkRireki = pIT_BAK_KhTtdkRireki;
    }

}

