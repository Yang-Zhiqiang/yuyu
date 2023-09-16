package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.mapping.GenIT_BAK_KykSyouhnRireki;


/**
 * 契約商品履歴バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KykSyouhnRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KykSyouhnRireki<br />
 * @see     PKIT_BAK_KykSyouhnRireki<br />
 * @see     QIT_BAK_KykSyouhnRireki<br />
 * @see     GenQIT_BAK_KykSyouhnRireki<br />
 */
@Entity
public class IT_BAK_KykSyouhnRireki extends GenIT_BAK_KykSyouhnRireki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KykSyouhnRireki() {
    }

    public IT_BAK_KykSyouhnRireki(String pKbnkey,String pSyono,String pTrkssikibetukey,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno,pHenkousikibetukey);
    }

    public IT_BAK_KykSyouhnRireki(String pSyono,String pTrkssikibetukey,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno,pHenkousikibetukey);
    }


    private IT_BAK_KhTtdkRireki iT_BAKKhTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KykSyouhnRireki.KBNKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KykSyouhnRireki.SYONO  , referencedColumnName=IT_BAK_KhTtdkRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KykSyouhnRireki.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KykSyouhnRireki.HENKOUSIKIBETUKEY  , referencedColumnName=IT_BAK_KhTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KhTtdkRireki getBAKKhTtdkRireki() {
        return iT_BAKKhTtdkRireki;
    }

    public void setBAKKhTtdkRireki(IT_BAK_KhTtdkRireki pIT_BAK_KhTtdkRireki) {
        this.iT_BAKKhTtdkRireki = pIT_BAK_KhTtdkRireki;
    }

}

